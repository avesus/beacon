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
import com.bureaueye.beacon.form.edi.EDIOutboundForm;
import com.bureaueye.beacon.model.edi.Edioutbound;
import com.bureaueye.beacon.model.edi.bd.EDIOutboundBD;



public final class EditEDIOutboundAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//HttpSession session = request.getSession(false);
		EDIOutboundForm editForm = (EDIOutboundForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("EDIOutboundForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("EditEDIOutboundAction:  Processing " + action + " action");

		Edioutbound dto = null;
		
		if (!(action == null || action.equals("Create"))) {

			dto = new EDIOutboundBD().read(new Integer(editForm.getEdioutboundId()));
			if (dto == null) {
				log.error("No record found for key "
						+ editForm.getEdioutboundId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getEdioutboundId()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("Populating EDIOutboundForm from " + dto);

			BeanUtils.copyProperties(editForm, dto);

			if (action.equals("Copy")) {
				editForm.setEdioutboundId("");
				editForm.setAction("Create");
			}
		}

	
		
		// Forward control to the edit page
		log.debug(" Forwarding to 'success' page");
		return findSuccess(mapping);
	}
}
