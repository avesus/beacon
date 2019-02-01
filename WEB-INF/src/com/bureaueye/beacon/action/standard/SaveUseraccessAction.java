package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;

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
import com.bureaueye.beacon.form.standard.UseraccessForm;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module 
 *
 */
public final class SaveUseraccessAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		UseraccessForm saveForm = (UseraccessForm) form;
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
		UseraccessBD bd = new UseraccessBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getUseraccessId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Useraccess dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Useraccess();
		}
		
		if (action.equals("Create")) {
			// check for duplicate
			Useraccess duplicate = null;
			try{duplicate=bd.findUseraccessByKey1(saveForm.getUserid(),saveForm.getAccessid());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("accessid", new ActionMessage("error.useraccess.unique"));
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
		
		
		try {	
			// populate data-transfer-object from form
			// init FORM with DTO values
			BeanUtils.copyProperties(dao, saveForm);
		} catch (IllegalAccessException ite) {
		} catch (InvocationTargetException ite) {
		}  catch (Exception e) {
		}			
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Useraccess(pk),user);		
		} else {
			
			bd.createOrUpdate(dao,user);
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
		}
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
	
}
