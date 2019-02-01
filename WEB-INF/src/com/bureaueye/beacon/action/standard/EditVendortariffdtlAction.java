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
import com.bureaueye.beacon.form.standard.VendortariffdtlForm;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.bd.VendortariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;

public final class EditVendortariffdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		VendortariffdtlForm vendortariffdtlForm = (VendortariffdtlForm) form;

		String action = vendortariffdtlForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log
					.error("VendortariffdtlForm not supplied for EditVendortariffdtlAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditVendortariffdtlAction:  Processing " + action
				+ " action");

		if (!(action == null || action.equals("Create"))) {

			Vendortariffdtl vendortariffdtl = new VendortariffdtlBD(this.getSessionFactoryClusterMap())
					.read(vendortariffdtlForm.getVendtarfdtlId());

			if (vendortariffdtl == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Vendortariffdtl found for vendortariffdtl: "
						+ vendortariffdtlForm.getVendtarfdtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", vendortariffdtlForm
								.getVendtarfdtlId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				// If the parent record has been deleted then return to the
				// parent ListAction
				return new VendortariffhdrBD(this.getSessionFactoryClusterMap()).read(vendortariffdtlForm
						.getVendtarfhdrId()) == null ? mapping
						.findForward("parent") : findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating VendortariffdtlForm from " + vendortariffdtl);
			BeanUtils.copyProperties(vendortariffdtlForm, vendortariffdtl);

			if (action.equals("Copy")) {
				vendortariffdtlForm.setVendtarfdtlId(null);
				vendortariffdtlForm.setAction("Create");
			}
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
