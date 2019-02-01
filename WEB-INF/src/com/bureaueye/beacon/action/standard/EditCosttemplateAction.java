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
import com.bureaueye.beacon.form.standard.CosttemplateForm;
import com.bureaueye.beacon.model.standard.Costtemplate;
import com.bureaueye.beacon.model.standard.bd.CosttemplateBD;



public final class EditCosttemplateAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CosttemplateForm editForm = (CosttemplateForm) form;

		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction:  Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {
			
			Integer pk = new Integer(editForm.getCosttemplateId());
			Costtemplate dao = new CosttemplateBD(this.getSessionFactoryClusterMap()).read(pk);

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for key "
						+ editForm.getCosttemplateId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getCosttemplateId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);

			BeanUtils.copyProperties(editForm, dao);

			if (action.equals("Copy")) {
				editForm.setCosttemplateId("");
				editForm.setAction("Create");
			}
		}

		// set defaults for Create process
		if (action.equals("Create")) {
			//set system base ccy
			//SystemXBD systemxbd = new SystemXBD(this.getSessionFactoryClusterMap());
			//SystemX system = systemxbd.findSystem();
			//if (system != null) editForm.setCcykey(system.getCcykey());
			editForm.setCcykey("");
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
