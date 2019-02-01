package com.bureaueye.beacon.action.quotation;


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
import com.bureaueye.beacon.form.quotation.QuomovcostForm;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 * NT	2011-08-10		201100019			Change Copy process to not default header currency to cost currency
 *
 */
public final class EditQuomovcostAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);	
		QuomovcostForm editForm = (QuomovcostForm) form;
		
		// Extract attributes we will need
		String action = editForm.getAction();
		
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
		
		
		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {
			
			Quocost dto = new QuocostBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getQuocostId()));
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quocost found for quomovId: "
						+ editForm.getQuomovId() + ", "
						+ "quocostid: " + editForm.getQuocostId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getQuomovId()
						+ " - " + editForm.getQuocostId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating QuomovcostForm from " + dto);
			
			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);
			
			//check user action is copy
			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setQuocostId("");				
				editForm.setCostkey("");
				//change form action from copy to create
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				//action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;//201100019
			}
		}
		
		
		// set header information
		Quomov quomov = new QuomovBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getQuomovId()));
		Quohdr quohdr = null;
		if (quomov != null) {
			quohdr = new QuohdrBD(this.getSessionFactoryClusterMap()).read(quomov.getQuohdrId());
			if (quohdr != null)	{
				editForm.setBaseccykey(quohdr.getCcykey());
			}
		}
		
		
		// set defaults for Create process
		if (
				//action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)//201100019
				//check form action is create
				editForm.getAction().equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)//201100019
			) {
			
			// default user information
			if (
					editForm.getCosttype() == null || 
					editForm.getCosttype().equals("")
			) {
				editForm.setCosttype("UNIT");
			}
			
			if (quohdr != null)	{
				editForm.setQuohdrId(quohdr.getId().toString());	
				//201100019
				if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) { 
					editForm.setCcykey(quohdr.getCcykey());
				}
			}
			
			if (quomov != null)	{
				//only init if orginal action not COPY 
				if (!action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) { 
					editForm.setVendoraddrkey(quomov.getVendoraddrkey());
				}
			}
			
		}
		quohdr=null;
		quomov=null;
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
		
	}
	
}
