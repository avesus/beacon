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
import com.bureaueye.beacon.form.quotation.QuonotecustForm;
import com.bureaueye.beacon.formatter.FormattingException;
import com.bureaueye.beacon.model.quotation.Quonotecust;
import com.bureaueye.beacon.model.quotation.bd.QuonotecustBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;


/**
 * 
 * Amendments
 * ----------
 * 												
 * NT	2011-03-01		ITT-201103-0001		Quotation Customer Notes 
 *
 */
public final class EditQuonotecustAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);	
		QuonotecustForm editForm = (QuonotecustForm) form;
		
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
		
		
		if (!(action == null || action.equals("Create"))) {
			
			Quonotecust dto = new QuonotecustBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getQuonotecustId()));
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quonotecust found for hdrId: "
						+ editForm.getQuohdrId() + ", "
						+ "notecustid: " + editForm.getQuonotecustId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getQuohdrId()
						+ " - " + editForm.getQuonotecustId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);
			
			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);
			
			try {
				editForm.setCreatetime(dto.getCreatetime());
				editForm.setCreatedate(dto.getCreatedate());
			}
			catch (FormattingException fe) {}
			
			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setQuonotecustId("");				
				editForm.setCreatetime("");
				editForm.setCreateuserid("");
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}
			
		}
		
		

		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
		
	}
	
}
