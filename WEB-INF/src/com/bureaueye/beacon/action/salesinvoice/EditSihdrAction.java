package com.bureaueye.beacon.action.salesinvoice;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.salesinvoice.SihdrForm;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.User;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function to Sales Invoice module
 * 
 */
public final class EditSihdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);
		SihdrForm editForm = (SihdrForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		Sihdr dto = null;

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			dto = new SihdrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getId()));

			if (dto == null) {
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " No Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}

			/*
			 * // view only if (!dto.isManualflag() || dto.isPrintedflag()) {
			 * editForm.setAction("View"); editForm.setReadonly("TRUE"); }
			 */

			//WSI-201311-0002
			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setCopyId(editForm.getId());
				editForm.setId("");
				editForm.setInvoiceno("");
				editForm.setPrintedflag(false);				
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action = com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}
			
		}

		// create only
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			editForm.setManualflag(true);
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());
		}

		// Forward control to the edit page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
