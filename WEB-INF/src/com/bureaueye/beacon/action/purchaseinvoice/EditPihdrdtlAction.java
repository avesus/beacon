package com.bureaueye.beacon.action.purchaseinvoice;


import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

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
import com.bureaueye.beacon.form.purchaseinvoice.PihdrdtlForm;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.standard.User;




public final class EditPihdrdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		HttpSession session = request.getSession(false);	
		PihdrdtlForm editForm = (PihdrdtlForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");


		// Generate Business Delegate	
		PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
		PidtlBD pidtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
		PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());


		Pihdr pihdrdao = null; 
		Pidtl pidtldao = null; 

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			pihdrdao = pihdrbd.read(new Integer(editForm.getId()));
			if (pihdrdao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Header Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}
			pidtldao = pidtlbd.findPidtlByPihdrId(editForm.getId());
			if (pidtldao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Detail Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}


			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + pihdrdao);

			//init header form fields
			try {
				// init FORM with DAO values
				BeanUtils.copyProperties(editForm, pihdrdao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		
			//init detail form fields
			try {
				// init FORM with DAO values
				BeanUtils.copyProperties(editForm, pidtldao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}	


			try {
				editForm.setLinesentered(
						new Integer(pidtlbd.pidtlsCount(editForm.getId())).toString()
				);
			} catch (ApplicationException ae) {}
			try {
				editForm.setDisputes(
						new Integer(pidtlbd.pidtlsInvoicestatusCount(editForm.getId(), "DISPUTED")).toString()
				);
			} catch (ApplicationException ae) {}
			try {
				BigDecimal invoiceamt = pidtlbd.pidtlsInvoiceamtTotal(editForm.getId());
				if (invoiceamt != null) editForm.setInputtotal(invoiceamt.toString());
			} catch (ApplicationException ae) {}
			try {
				BigDecimal allocamt = pidtlcostbd.pidtlcostsCstamtallocSumByPihdrid(editForm.getId());
				if (allocamt != null) editForm.setAlloctotal(allocamt.toString());
			} catch (ApplicationException ae) {}								

		}


		// set collections
		try {	
			// set line items
			editForm.setPidtlcosts(
					pidtlcostbd.findPidtlcostsById(
							editForm.getPidtlId(),
							0,
							com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
							"Costkey"
					)
			);
		} catch (Exception e) {}



		// create only
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {			
			// default user information
			editForm.setCreateuserid(user.getUserid());
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());

			// default create date to today
			Calendar c = Calendar.getInstance();		
			try {editForm.setCreatedate(c.getTime());} catch (Exception e) {}

			editForm.setId("");
			editForm.setPino("");
			editForm.setVendoraddrkey("");
			editForm.setCcykey(com.bureaueye.beacon.bean.Constants.BASE_CURRENCY);

			editForm.setLinesentered("0");
			editForm.setInvoicestatus("DISPUTED");
			editForm.setDisputes("0");
			editForm.setInputtotal("0.0");	

			try {
				PropertyResourceBundle props = 
					(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
				if (props.getString("pino.auto.generate").equals("yes")) {
					// auto generate invoice no
					int nextdocno = 0;
					try {
						SidocnoBD sidocnobd = new SidocnoBD(this.getSessionFactoryClusterMap());
						nextdocno = sidocnobd.getNextDocno(
								"PINV",
								user.getCompanykey(),
								c.get(Calendar.YEAR),
								user
						);
						sidocnobd=null;					
					} catch (Exception e) {}
					DecimalFormat df = new DecimalFormat(props.getString ("pino.format"));
					editForm.setPino(
							props.getString("pino.prefix")+
							df.format(nextdocno)+
							props.getString("pino.suffix")
					);
					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"nextdocno["+nextdocno+"]: "+
							"pino["+editForm.getPino()+"]: "+
							"company["+user.getCompanykey()+"]: "+
							"userid["+user.getUserid()+"]"
					);					
				}
			} catch (Exception e) {
				log.error(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"Exception["+e.getMessage()+"]"
				);				
			}

		}//create only


		//clear objects
		pihdrbd=null;
		pidtlbd=null;
		pidtlcostbd=null;	


		// Forward control to the edit page
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
