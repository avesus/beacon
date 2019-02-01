package com.bureaueye.beacon.action.quotation;


import java.lang.reflect.InvocationTargetException;
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
import com.bureaueye.beacon.form.quotation.QuohdrForm;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.DocnoBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;


/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-03-23		ITT-200904-0001		Add Quotno Auto Generation
 * 											
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 */
public final class EditQuohdrAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);		
		QuohdrForm editForm = (QuohdrForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		String action = editForm.getAction();
		
		// If the session has timed-out then take the user back to the login page
		if (session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		
		// user access check ---------------------------------------------------->
		ActionMessages appInformationMessages = new ActionMessages();
		// check access for userid and type
		Useraccess useraccessdao = new UseraccessBD(this.getSessionFactoryClusterMap())
		.findUseraccessByKey1(user.getUserid(), mapping.getParameter());				
		if (useraccessdao!= null) {			
			// check action in grant action list
			if (!useraccessdao.getGrantactionlist().contains(action)) {
				// downgrade access to view only if view access in grant action list
				if (
						action.equals(com.bureaueye.beacon.bean.Constants.EDIT_ACTION) &&
						useraccessdao.getGrantactionlist().contains(com.bureaueye.beacon.bean.Constants.VIEW_ACTION)
				) {
					editForm.setAction(com.bureaueye.beacon.bean.Constants.VIEW_ACTION);
					action=com.bureaueye.beacon.bean.Constants.VIEW_ACTION;					
				} else {
					// if user does not have correct access - create information message
					appInformationMessages.add(
							"errors.useraccess",
							new ActionMessage(
									"information.useraccess", 
									user.getUserid(),
									action,
									mapping.getParameter()
							)
					);	
					saveAppInformationMessages(request, appInformationMessages);
					// if user does not have correct access - return to failure mapping
					return findFailure(mapping);
				}
			}	
		}
		// user access check ---------------------------------------------------->
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		if (!(action == null || action.equals("Create"))) {
			
			//String id = request.getParameter("id");
			Quohdr dto = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getId()));
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quohdr found for id "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating editForm from " + dto);
			
			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
			}	
			
//			// init FORM with DTO values
//			//PropertyUtils.copyProperties(editForm, dto);			
//			try {
//			editForm.populate(dto,BaseForm.TO_STRING);
//			//BeanUtils.copyProperties(editForm,dto);				
//			}
//			catch (FormattingException fe) {
//			fe.printStackTrace();
//			}
			
			// set non-primitive fields 			
			
			
			
			
			if (action.equals("Copy")) {
				editForm.setCopyId(editForm.getId());
				editForm.setId("");
				editForm.setQuotno("");				
				editForm.setAction("Create");
				action="Create";
			}
		}
		
		
		
		// set defaults for Create process
		if (action.equals("Create") || action.equals("Copy")) {
			
			
			//sITT-200904-0001
			try {
				PropertyResourceBundle props = 
					(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
				if (props.getString("quotno.auto.generate").equals("yes")) {
					// auto generate quotation number
					int nextdocno = 0;
					Calendar c = Calendar.getInstance();
					nextdocno = new DocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
							"QUOTATION",
							user.getCompanykey(),
							c.get(Calendar.YEAR),
							user
					);
					DecimalFormat df = new DecimalFormat(props.getString ("quotno.format"));				
					editForm.setQuotno(
							props.getString("quotno.prefix")+
							df.format(nextdocno)+
							props.getString("quotno.suffix")							
							);
					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"nextdocno["+nextdocno+"]: "+
							"quotno["+editForm.getQuotno()+"]: "+
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
			//eITT-200904-0001
			
			
			// default user information
			//editForm.setCreateuserid(user.getUserid());
			editForm.setQuotebyuserid(user.getUserid());			
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());
			
			// default status information
			editForm.setQuotestatus("PENDING");
			editForm.setRejectreason("");
			
			// default quote date to today
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setQuotedate(c.getTime());
				editForm.setExchgdate(c.getTime());
				editForm.setEffectivedate(c.getTime());	
			} catch (Exception e) {}	
			
			// default expiry date to today plus 
			// system default expiry days
			int expiryDays = 0;
			try {
				expiryDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("SYSDEFAULT", "EXPIRYDAYS")).getDescr()).intValue();
			} catch (Exception nfe) {}
			c.add(Calendar.DATE,expiryDays);
			try {
				editForm.setExpirydate(c.getTime());
			} catch (Exception e) {}
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
	}
}
