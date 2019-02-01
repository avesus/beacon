package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;

public final class EditRegistrationAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Extract attributes we will need
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		if (user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  User is not logged on in session " + session.getId());
			return mapping.findForward("welcome");
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form from " + user);

		session.setAttribute(Constants.USER_KEY, new UserBD(this.getSessionFactoryClusterMap()).read(user.getUserid()));

		BeanUtils.copyProperties(form, user);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
