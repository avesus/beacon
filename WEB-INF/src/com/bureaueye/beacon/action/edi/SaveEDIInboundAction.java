package com.bureaueye.beacon.action.edi;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.edi.EDIInboundForm;
import com.bureaueye.beacon.model.edi.Ediinbound;
import com.bureaueye.beacon.model.edi.bd.EDIInboundBD;
import com.bureaueye.beacon.model.standard.User;




public final class SaveEDIInboundAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		EDIInboundForm saveForm = (EDIInboundForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		
		// If the session has timed-out then take the user back to the login
		// page
		//if (action == null || session == null || user == null) {
		//	log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
		//	return mapping.findForward("welcome");
		//}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log
				.debug("SaveEDIInboundAction:  Processing " + action
						+ " action");

		// Generate Business Delegate
		EDIInboundBD bd = new EDIInboundBD(this.getSessionFactoryClusterMap());

		
		
		
		if (action.equals("Delete")) {
			//bd.delete(new EDIInbound(new Integer(saveForm.getEDIInboundId())), user);
		} else {
			Ediinbound dto = bd.read(new Integer(saveForm.getEdiinboundId()));

			if (dto == null) {
				dto = new Ediinbound();
			}

			BeanUtils.copyProperties(dto, saveForm);

			bd.createOrUpdate(dto, user);

			// Find the form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			//listform.setSearchString1(dto.get?());

		}

		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
