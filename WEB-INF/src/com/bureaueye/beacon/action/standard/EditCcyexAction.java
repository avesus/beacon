package com.bureaueye.beacon.action.standard;

import java.util.Calendar;

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
import com.bureaueye.beacon.form.standard.CcyexForm;
import com.bureaueye.beacon.model.standard.Ccyex;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;

public final class EditCcyexAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CcyexForm editForm = (CcyexForm) form;

		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" CcyexForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditCcyAction:  Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {

			Ccyex dto = new CcyexBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getCcyexId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Currency found for Id " + editForm.getCcyexId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getCcyexId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating CcyexForm from " + dto);

			BeanUtils.copyProperties(editForm, dto);

			if (action.equals("Copy")) {
				editForm.setCcyexId("");
				editForm.setAction("Create");
			}
			
		}
		
		// TODO: create default exchange date to today
		if (action.equals("Create")) {
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setExdate(c.getTime());
			} catch (Exception e) {}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
