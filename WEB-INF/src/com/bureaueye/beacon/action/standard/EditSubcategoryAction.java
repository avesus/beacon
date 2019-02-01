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
import com.bureaueye.beacon.form.standard.SubcategoryForm;
import com.bureaueye.beacon.model.standard.Subcategory;
import com.bureaueye.beacon.model.standard.bd.SubcategoryBD;






public final class EditSubcategoryAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		SubcategoryForm editForm = (SubcategoryForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" SubcategoryForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  Processing: " + action + " action");

		Subcategory dao = null;
		
		if (!(action == null || action.equals("Create"))) {

			dao = new SubcategoryBD().read(new Integer(editForm.getSubcategoryId()));
			if (dao == null) {
				log.error("No record found for key "
						+ editForm.getSubcategoryId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getSubcategoryId()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Populating SubcategoryForm from " + dao);

			BeanUtils.copyProperties(editForm, dao);

			if (action.equals("Copy")) {
				editForm.setSubcategoryId("");
				editForm.setAction("Create");
			}
		}

	
		
		// Forward control to the edit page
		log.debug(" Forwarding to 'success' page");
		return findSuccess(mapping);
	}
}
