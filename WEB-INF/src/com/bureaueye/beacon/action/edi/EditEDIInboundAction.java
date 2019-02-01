package com.bureaueye.beacon.action.edi;


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
import com.bureaueye.beacon.form.edi.EDIInboundForm;
import com.bureaueye.beacon.model.edi.Ediinbound;
import com.bureaueye.beacon.model.edi.bd.EDIInboundBD;



public final class EditEDIInboundAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//HttpSession session = request.getSession(false);
		EDIInboundForm editForm = (EDIInboundForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("EDIInboundForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("EditEDIOutboundAction:  Processing " + action + " action");

		Ediinbound dto = null;
		
		if (!(action == null || action.equals("Create"))) {

			dto = new EDIInboundBD().read(new Integer(editForm.getEdiinboundId()));
			if (dto == null) {
				log.error("No record found for key "
						+ editForm.getEdiinboundId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getEdiinboundId()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("Populating EDIInboundForm from " + dto);

			BeanUtils.copyProperties(editForm, dto);

			if (action.equals("Copy")) {
				editForm.setEdiinboundId("");
				editForm.setAction("Create");
			}
		}

	
		
		// Forward control to the edit page
		log.debug(" Forwarding to 'success' page");
		return findSuccess(mapping);
	}
}
