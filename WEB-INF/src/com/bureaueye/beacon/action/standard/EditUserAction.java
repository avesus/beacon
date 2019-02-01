package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.standard.UserForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;


public final class EditUserAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserForm editForm = (UserForm) form;

		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
	

		UserBD userbd=new UserBD(this.getSessionFactoryClusterMap());
		
		if (!(action == null || action.equals(Constants.CREATE_ACTION))) {

			User dto = userbd.read(editForm.getUserid());

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for id: " + editForm.getUserid());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getUserid()));
				saveErrors(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't delete: forwarding to: "
						+ findFailure(mapping).getPath());
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);
			

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);				
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
			}	
		
			
			if (action.equals(Constants.COPY_ACTION)) {
				editForm.setCopyId(editForm.getUserid());
				editForm.setUserid("");
				editForm.setAction(Constants.CREATE_ACTION);
			}
			
		}

		
		
		if (editForm.getAction().equals(Constants.CREATE_ACTION)) {
			
			// init user limit
			try {		
				int userLimit=0;
				int countUsers=0;				
				PropertyResourceBundle props = (PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.LicenseResources");
				try{userLimit=new Integer(props.getString ("authorized.user.limit"));} catch (Exception e) {}
				if (userLimit>0) {
					countUsers=userbd.countUsers();
					if (countUsers>=userLimit) {
						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
								"Authorized User Limit check: "+
								"authorizeduserlimit["+userLimit+"]: "+
								"countUsers["+countUsers+"]"
						);						
					ActionMessages errors = new ActionMessages();
					errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
							"error.authorizeduserlimit",userLimit));
					saveErrors(request, errors);
					return findFailure(mapping);
					}
				}
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Authorized User Limit check - Exception: "+e.getMessage());			
			}
			
		}//create 
		
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
