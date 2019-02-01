package com.bureaueye.beacon.action.purchaseinvoice;



import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.purchaseinvoice.PihdrdtlForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;



/**
 * 
 * Amendments
 * ----------
 * 
 * NT 2015-04-02 201500012 Beacon enhancements 
 * 	- On Add of PI record display new record in PI List screen
 * 
 */
public final class SavePihdrdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PihdrdtlForm saveForm = (PihdrdtlForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();


		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");


		// Generate Business Delegate	
		PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
		PidtlBD pidtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
		//PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());


		// set primary key
		Integer pk = null;		
		try {pk = new Integer(saveForm.getId());} catch (Exception e) {}



		// find header data-access-object using primary key
		Pihdr pihdrdao = pihdrbd.read(pk);	
		// not found create empty object
		if (pihdrdao == null) {
			pihdrdao = new Pihdr();		
		} 
		Pidtl pidtldao = new Pidtl();		
		if (pk != null) {
			// find detail data-access-object using primary key
			pidtldao = pidtlbd.findPidtlByPihdrId(pk.toString());
		}



		// error validation==========================================================
		// business validation
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			// check for duplicate number
			Pihdr duplicate = null;
			try{duplicate=pihdrbd.findPihdrByPino(saveForm.getPino());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.purchaseinvoice.unique"));				
			}
		}


		if (!action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {	
			//if purchase invoice has been approved		
			if (saveForm.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS)) {

				BigDecimal hdrNetamount = new BigDecimal(saveForm.getNetamt());				
				//check all cost allocated amounts equal header net amount	
				try {
					BigDecimal dtlcstAmtallocTotal = new BigDecimal(saveForm.getAlloctotal());
					if (dtlcstAmtallocTotal.floatValue()!=hdrNetamount.floatValue()) {
						errors.add(
								"informationMessage",
								new ActionMessage(
										"error.approve.netamount2",
										saveForm.getNetamt(),
										saveForm.getAlloctotal()
										)
								);				
					}				
				} catch (Exception e) {
				}			

			}
		}


		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}				




		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {		
			pihdrbd.deleteAll(pihdrdao.getPihdrId(), user);		
		} else {


			// populate data-transfer-object from form
			// init header database fields from form
			try {
				BeanUtils.copyProperties(pihdrdao, saveForm);				
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}	

			// init detail database fields from form
			try {
				BeanUtils.copyProperties(pidtldao, saveForm);	
				pidtldao.setInvoiceamt(pihdrdao.getNetamt());
				pidtldao.setApprovedflag(pihdrdao.isApprovedflag());
				pidtldao.setTxt1(pihdrdao.getTxt1());
				pidtldao.setTxt2(pihdrdao.getTxt2());				
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}	


			try{
				//init gross amount
				pihdrdao.setGrossamt(pihdrdao.getNetamt());

				TaxcodeBD taxcodebd = new TaxcodeBD(this.getSessionFactoryClusterMap());				
				// calculate Tax amount
				BigDecimal taxamt = new BigDecimal(0.0);		
				BigDecimal rate = new BigDecimal(0.0);
				rate=taxcodebd.findTaxcodeByTaxcodekey(pihdrdao.getTaxcode()).getRate();
				taxamt=rate.multiply(pihdrdao.getNetamt()).divide(new BigDecimal(100.0));	
				pihdrdao.setTaxamt(taxamt);	

				// calculate Gross amount
				pihdrdao.setGrossamt(pihdrdao.getTaxamt().add(pihdrdao.getNetamt()));

				//clear objects
				taxcodebd = null;
			} catch (Exception e){}


			if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
				//check is NOT miscellaneos
				if (!saveForm.isMiscflag()) {
					//init jobhdrid 
					JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
					Jobhdr jobhdrdao = null;			
					try {				
						jobhdrdao=jobhdrbd.findJobhdrByJobno(saveForm.getJobno());
						pidtldao.setJobhdrId(jobhdrdao.getJobhdrId());
						pidtldao.setJobno(saveForm.getJobno());						
						//init order no				
						OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
						Orderhdr orderhdrdao = null;
						try {					
							orderhdrdao=orderhdrbd.read(jobhdrdao.getOrderhdrId());				
							pidtldao.setOrderno(orderhdrdao.getOrderno());
							pihdrdao.setOrderno(orderhdrdao.getOrderno());								
						} catch (Exception e) {}
						orderhdrbd = null;
						orderhdrdao = null;					
					} catch (Exception e) {}

					//clear objects
					jobhdrbd = null;
					jobhdrdao = null;

					log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Orderno " + pidtldao.getOrderno()+
							" JobhdrId " + pidtldao.getJobhdrId()						
							);
				}//is NOT miscellaneous invoice
			}//create action



			AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
			//generate posting record===============================================>
			//if purchase invoice has been approved		
			if (pihdrdao.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS)) {
				Aiout aioutdao = null;
				//retrieve aiout record 
				if (pihdrdao.getAioutId()!=null) {
					try {
						aioutdao = aioutbd.read(pihdrdao.getAioutId()); 
					} catch (Exception e) {}
				}
				if (aioutdao==null) aioutdao = new Aiout();

				try {
					//check not already sent
					if (aioutdao.getSentdate()==null) {
						aioutdao.setDockey(pihdrdao.getPino());
						aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
						aioutdao.setDoctype(com.bureaueye.beacon.bean.Constants.AP_ACTUAL);
						aioutdao.setCompanykey(pihdrdao.getCompanykey());
						aioutdao.setDepartmentkey(pihdrdao.getDepartmentkey());
						aioutdao.setActivitykey(pihdrdao.getActivitykey());
						aioutdao.setErrors("");
						aioutdao.setDocument("");

						// create/update aiout recod
						aioutbd.createOrUpdate(aioutdao, user);

						pihdrdao.setAioutId(aioutdao.getAioutId());
					}
				} catch (Exception e) {
				}
			}
			//generate posting record===============================================<


			//remove aiout record===============================================>
			//if purchase invoice has been disputed		
			if (pihdrdao.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.DISPUTED_STATUS)) {
				Aiout aioutdao = null;
				//retrieve aiout record 
				if (pihdrdao.getAioutId()!=null) {
					try {
						aioutdao = aioutbd.read(pihdrdao.getAioutId()); 
					} catch (Exception e) {}
				}
				try {
					//check not already sent
					if (aioutdao.getSentdate()==null) {
						// create/update aiout recod
						aioutbd.delete(aioutdao, user);
					}
				} catch (Exception e) {
				}
				pihdrdao.setAioutId(null);
			}
			aioutbd = null;

			//store header
			pihdrbd.createOrUpdate(pihdrdao, user);
			pidtldao.setPihdrId(pihdrdao.getPihdrId());
			//store detail
			pidtlbd.createOrUpdate(pidtldao, user);


			// Find the list form and reset the parameters as if it
			// was the first time in
			ListForm listform = (ListForm) session.getAttribute("List"	+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			
			
			//201500011
			if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
				// Set the search parameters
				listform.setSearchString1(pihdrdao.getPino());
			}


		}


		//clear objects
		pihdrbd=null;
		pidtlbd=null;



		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}




}
