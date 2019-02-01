package com.bureaueye.beacon.action.salesinvoice;


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
import com.bureaueye.beacon.form.salesinvoice.SidocnoForm;
import com.bureaueye.beacon.model.salesinvoice.Sidocno;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;




public final class EditSidocnoAction extends BaseAction {

	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		SidocnoForm editForm = (SidocnoForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  Processing: " + action + " action");

		Sidocno dao = null;
		
		if (!(action == null || action.equals("Create"))) {

			Integer key = new Integer(editForm.getSidocnoId());
			
			dao = new SidocnoBD().read(key);
			if (dao == null) {
				log.error("No record found for key "
						+editForm.getSidocnoId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getSidocnoId()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Populating Form from " + dao);

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
