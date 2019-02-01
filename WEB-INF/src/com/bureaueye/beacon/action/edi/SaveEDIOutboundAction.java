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
import com.bureaueye.beacon.form.edi.EDIOutboundForm;
import com.bureaueye.beacon.model.edi.Edioutbound;
import com.bureaueye.beacon.model.edi.bd.EDIOutboundBD;
import com.bureaueye.beacon.model.standard.User;




public final class SaveEDIOutboundAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		EDIOutboundForm saveForm = (EDIOutboundForm) form;
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
				.debug("SaveEDIOutboundAction:  Processing " + action
						+ " action");

		// Generate Business Delegate
		EDIOutboundBD bd = new EDIOutboundBD(this.getSessionFactoryClusterMap());

		
		
		
		if (action.equals("Delete")) {
			//bd.delete(new Edioutbound(new Integer(saveForm.getEdioutboundId())), user);
		} else {
			Edioutbound dto = bd.read(new Integer(saveForm.getEdioutboundId()));

			if (dto == null) {
				dto = new Edioutbound();
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
