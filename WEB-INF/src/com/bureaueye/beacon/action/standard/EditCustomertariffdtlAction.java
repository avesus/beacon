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
import com.bureaueye.beacon.form.standard.CustomertariffdtlForm;
import com.bureaueye.beacon.model.standard.Customertariffdtl;
import com.bureaueye.beacon.model.standard.bd.CustomertariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;

public final class EditCustomertariffdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CustomertariffdtlForm customertariffdtlform = (CustomertariffdtlForm) form;

		// Extract attributes we will need
		String action = customertariffdtlform.getAction();

		// If action isn't supplied then invalidate the session
		if (customertariffdtlform.getAction() == null) {
			log
					.error("CustomertariffdtlForm not supplied for EditCustomertariffdtlAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditCustomertariffdtlAction:  Processing " + action
				+ " action");

		if (!(action == null || action.equals("Create"))) {

			Customertariffdtl customertariffdtl = new CustomertariffdtlBD(this.getSessionFactoryClusterMap())
					.read(customertariffdtlform.getCusttarfdtlId());

			if (customertariffdtl == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Customertariffdtl found for id: "
						+ customertariffdtlform.getCusttarfdtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", customertariffdtlform
								.getCusttarfdtlId()));
				saveMessages(request, errors);
				// If the parent record has been deleted then return to the
				// parent ListAction
				return new CustomertariffhdrBD(this.getSessionFactoryClusterMap()).read(customertariffdtlform
						.getCusttarfhdrId()) == null ? mapping
						.findForward("parent") : findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating CustomertariffdtlForm from "
					+ customertariffdtlform);

			BeanUtils.copyProperties(customertariffdtlform, customertariffdtl);

			if (action.equals("Copy")) {
				customertariffdtlform.setCusttarfdtlId(null);
				customertariffdtlform.setAction("Create");
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}
}
