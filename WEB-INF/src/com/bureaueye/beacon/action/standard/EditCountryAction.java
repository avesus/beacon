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
import com.bureaueye.beacon.form.standard.CountryForm;
import com.bureaueye.beacon.model.standard.Country;
import com.bureaueye.beacon.model.standard.bd.CountryBD;

public final class EditCountryAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CountryForm countryForm = (CountryForm) form;

		String action = countryForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" CountryForm not supplied for EditCountryAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditCountryAction:  Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {

			Country country = new CountryBD(this.getSessionFactoryClusterMap()).read(countryForm.getCountrykey());

			if (country == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Country found for country "
						+ countryForm.getCountrykey());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", countryForm.getCountrykey()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating CountryForm from " + country);

			BeanUtils.copyProperties(countryForm, country);

			if (action.equals("Copy")) {
				countryForm.setCountrykey("");
				countryForm.setAction("Create");
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
