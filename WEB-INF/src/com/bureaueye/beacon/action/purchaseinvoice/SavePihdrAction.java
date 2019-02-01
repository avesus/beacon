package com.bureaueye.beacon.action.purchaseinvoice;



import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Iterator;

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
import com.bureaueye.beacon.form.purchaseinvoice.PihdrForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;




public final class SavePihdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PihdrForm saveForm = (PihdrForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();


		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");

		// Generate Business Delegate
		PihdrBD bd = new PihdrBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Pihdr dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Pihdr();
		}



		// error validation 

		// business validation
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			// check for duplicate number
			Pihdr duplicate = null;
			try{duplicate=bd.findPihdrByPino(saveForm.getPino());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.purchaseinvoice.unique"));				
			}
		}


		if (!action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {	
			//if purchase invoice has been approved		
			if (saveForm.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS)) {

				//check all detail input amounts equal header net amount
				BigDecimal hdrNetamount = new BigDecimal(saveForm.getNetamt());				
				try {
					BigDecimal dtlInvoiceamtTotal = new BigDecimal(saveForm.getInputtotal());			
					if (dtlInvoiceamtTotal.floatValue()!=hdrNetamount.floatValue()) {
						errors.add(
								"informationMessage",
								new ActionMessage(
										"error.approve.netamount1",
										saveForm.getNetamt(),
										saveForm.getInputtotal()
								)
						);				
					}				
				} catch (Exception e) {
				}

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
			bd.deleteAll(dao.getPihdrId(), user);		
		} else {


			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dao, saveForm);				
			} catch (java.lang.NumberFormatException nfe) {
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {				
			}	

			TaxcodeBD taxcodebd = new TaxcodeBD(this.getSessionFactoryClusterMap());
			try{
				// calculate Tax amount
				BigDecimal taxamt = new BigDecimal(0.0);		
				BigDecimal rate = new BigDecimal(0.0);
				rate=taxcodebd.findTaxcodeByTaxcodekey(dao.getTaxcode()).getRate();
				taxamt=rate.multiply(dao.getNetamt()).divide(new BigDecimal(100.0));	
				dao.setTaxamt(taxamt);	

				// calculate Gross amount
				dao.setGrossamt(dao.getTaxamt().add(dao.getNetamt()));

				taxcodebd = null;
			} catch (Exception e){}


			AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
			//generate posting record===============================================>
			//if purchase invoice has been approved		
			if (dao.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS)) {
				Aiout aioutdao = null;
				//retrieve aiout record 
				if (dao.getAioutId()!=null) {
					try {
						aioutdao = aioutbd.read(dao.getAioutId()); 
					} catch (Exception e) {}
				}
				if (aioutdao==null) aioutdao = new Aiout();

				try {
					//check not already sent
					if (aioutdao.getSentdate()==null) {
						aioutdao.setDockey(dao.getPino());
						aioutdao.setAiid(dao.getPino());						
						aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
						aioutdao.setDoctype(com.bureaueye.beacon.bean.Constants.AP_ACTUAL);
						aioutdao.setCompanykey(dao.getCompanykey());
						aioutdao.setDepartmentkey(dao.getDepartmentkey());
						aioutdao.setActivitykey(dao.getActivitykey());
						aioutdao.setWarnings("");
						aioutdao.setErrors("");
						aioutdao.setDocument("");
						aioutdao.setCompanyid("");						
						aioutdao.setActioncode("");	
						aioutdao.setProcessstatus("");	
						aioutdao.setFilename("");
						aioutdao.setControlid("");
						
						// create/update aiout recod
						aioutbd.createOrUpdate(aioutdao, user);

						dao.setAioutId(aioutdao.getAioutId());
					}
				} catch (Exception e) {
				}
			}
			//generate posting record===============================================<


			//remove aiout record===============================================>
			//if purchase invoice has been disputed		
			if (dao.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.DISPUTED_STATUS)) {
				Aiout aioutdao = null;
				//retrieve aiout record 
				if (dao.getAioutId()!=null) {
					try {
						aioutdao = aioutbd.read(dao.getAioutId()); 
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
				dao.setAioutId(null);
			}

			aioutbd = null;


			bd.createOrUpdate(dao, user);


			// copy all details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Processing copyPihdr from id: "+saveForm.getCopyId());
				Integer copyId = null;
				try{copyId = new Integer(saveForm.getCopyId());}catch(Exception e){}
				if (copyId != null) {
					copyPihdrToNew(copyId, dao, user);
				}
			}








			// Find the list form and reset the parameters as if it
			// was the first time in
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			// Set the search parameters
			//listform.setSearchString1(dao.getPino());
		}




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}




	public void copyPihdrToNew(
			Integer pihdrId, 
			Pihdr dao,
			User user
	) throws Exception {

		//init bd
		PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());	
		PidtlBD pidtlbd = new PidtlBD(this.getSessionFactoryClusterMap());		

		// copy and store equipment
		for (Iterator it = pihdrbd.getPidtls(pihdrId).iterator(); it.hasNext();) {			
			Pidtl pidtl = new Pidtl();
			Pidtl copyPidtl = (Pidtl)it.next();			
			BeanUtils.copyProperties(pidtl, copyPidtl);
			pidtl.setPihdrId(dao.getPihdrId());
			pidtl.setPidtlId(null);			
			pidtlbd.createOrUpdate(pidtl, user);

			/*			// copy and store equipment locations
			for (Iterator it2 = pidtlrcvdbd.findPidtlrcvdsByPidtlId(copyPidtl.getPidtlId()).iterator(); it2.hasNext();) {
				Pidtlrcvd pidtlrcvd = new Pidtlrcvd();
				BeanUtils.copyProperties(pidtlrcvd, it2.next());						
				pidtlrcvd.setPidtlId(pidtl.getPidtlId());
				pidtlrcvd.setPidtlrcvdId(null);				
				pidtlrcvdbd.createOrUpdate(pidtlrcvd, user);	
			}	*/			
		}

		//clear bd
		pihdrbd = null;	
		pidtlbd = null;		

	}



}
