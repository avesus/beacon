package com.bureaueye.beacon.action.system;


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
import com.bureaueye.beacon.form.system.SystemcodeForm;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;




public final class EditSystemcodeAction extends BaseAction {

	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		SystemcodeForm editForm = (SystemcodeForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" SystemcodeForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  Processing: " + action + " action");

		Systemcode dao = null;
		
		if (!(action == null || action.equals("Create"))) {

			SystemcodePK pkey = new SystemcodePK(editForm.getTypekey(),editForm.getCodekey());
			
			dao = new SystemcodeBD().read(pkey);
			if (dao == null) {
				log.error("No record found for key "
						+editForm.getCodekey()+"/"+editForm.getTypekey());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getCodekey()+"/"+editForm.getTypekey()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Populating SystemcodeForm from " + dao);

			BeanUtils.copyProperties(editForm, dao);

			if (action.equals("Copy")) {
				editForm.setAction("Create");
			}
		}

	
		
		// Forward control to the edit page
		log.debug(" Forwarding to 'success' page");
		return findSuccess(mapping);
	}
}
