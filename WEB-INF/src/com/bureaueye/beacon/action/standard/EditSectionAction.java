package com.bureaueye.beacon.action.standard;

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
import com.bureaueye.beacon.form.standard.SectionForm;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.bd.SectionBD;

public final class EditSectionAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SectionForm sectionForm = (SectionForm) form;

		String action = sectionForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" SectionForm not supplied for EditSectionAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditSectionAction:  Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {

			Section section = new SectionBD(this.getSessionFactoryClusterMap()).read(sectionForm.getSectionkey());

			if (section == null) {
				log
						.error("No record found for sectionkey "
								+ sectionForm.getSectionkey());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", sectionForm.getSectionkey()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating SectionForm from " + section);

			BeanUtils.copyProperties(sectionForm, section);

			if (action.equals("Copy")) {
				sectionForm.setSectionkey("");
				sectionForm.setAction("Create");
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
