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
import com.bureaueye.beacon.form.standard.CustomertariffhdrForm;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;

public final class EditCustomertariffhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CustomertariffhdrForm customertariffhdrForm = (CustomertariffhdrForm) form;

		String action = customertariffhdrForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log
					.error("CustomertariffhdrForm not supplied for EditCustomertariffhdrAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditCustomertariffhdrAction:  Processing " + action
				+ " action");

		if (!(action == null || action.equals("Create"))) {

			Customertariffhdr customertariffhdr = new CustomertariffhdrBD(this.getSessionFactoryClusterMap())
					.read(customertariffhdrForm.getCusttarfhdrId());

			if (customertariffhdr == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Customertariffhdr found for customertariffhdr: "
						+ customertariffhdrForm.getCusttarfhdrId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", customertariffhdrForm
								.getCusttarfhdrId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating CustomertariffhdrForm from "
					+ customertariffhdr);
			BeanUtils.copyProperties(customertariffhdrForm, customertariffhdr);

			if (action.equals("Copy")) {
				customertariffhdrForm.setCusttarfhdrId(null);
				customertariffhdrForm.setAction("Create");
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
