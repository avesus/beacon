package com.bureaueye.beacon.action.agent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.agent.AgentjobForm;
import com.bureaueye.beacon.model.standard.User;



public final class EditAgentjob1Action extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);		
		AgentjobForm editForm = (AgentjobForm) form;
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"Processing " + action + " action");

		
		// reset session form details
		editForm.clear(mapping, request);
		
		// initailise user details
		editForm.setCreateuserid(user.getUserid());
		editForm.setCompanykey(user.getCompanykey());
		editForm.setDepartmentkey(user.getDepartmentkey());
		editForm.setActivitykey(user.getActivitykey());
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
