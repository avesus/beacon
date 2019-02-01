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
import com.bureaueye.beacon.form.purchaseinvoice.PihdrForm;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.standard.User;





public final class EditPihdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);	
		PihdrForm editForm = (PihdrForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Pihdr dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new PihdrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		
			

			PidtlBD pidtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
			PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());			
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
			
			
			//clear objects
			pidtlbd=null;
			pidtlcostbd=null;			
			
			if (action.equals("Copy")) {
				editForm.setCopyId(editForm.getId());											
				editForm.setAction("Create");
				action="Create";
			}
			
		}



		// create only
		if (action.equals("Create")) {
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
			
		}
				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
