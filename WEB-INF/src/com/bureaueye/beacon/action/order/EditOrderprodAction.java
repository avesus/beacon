package com.bureaueye.beacon.action.order;

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
import com.bureaueye.beacon.form.order.OrderprodForm;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;

public final class EditOrderprodAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);		
		OrderprodForm editForm = (OrderprodForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);

		String action = editForm.getAction();

		// If the session has timed-out then take the user back to the login page
		if (session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
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
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			Orderprod dto = new OrderprodBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOrderprodId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No value found for hdrId: "
						+ editForm.getOrderhdrId() + ", "
						+ "id: " + editForm.getOrderprodId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getOrderhdrId()
								+ " - " + editForm.getOrderprodId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			
			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);

			
			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setOrderprodId("");				
				editForm.setProductname("");
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
