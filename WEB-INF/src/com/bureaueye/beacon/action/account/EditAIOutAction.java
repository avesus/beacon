package com.bureaueye.beacon.action.account;



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
import com.bureaueye.beacon.form.account.AIOutForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;




/**
 *
 * Amendments
 * ----------
 *										
 */
public final class EditAIOutAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		AIOutForm editForm = (AIOutForm) form;
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" editForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		Aiout dao = null;

		if (!(action == null || action.equals("Create"))) {

			dao = new AioutBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getAioutId()));//201100016
			if (dao == null) {
				log.error("No record found for key "
						+ editForm.getAioutId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getAioutId()));
				saveMessages(request, errors);
				log.debug("Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"Populating EditForm from " + dao);

			BeanUtils.copyProperties(editForm, dao);

			if (action.equals("Copy")) {
				editForm.setAioutId(null);
				editForm.setAction("Create");
				action="Create";
			}

		}

		// init default fields
		if (action.equals("Create")) {
			editForm.setSentdate(null);
			editForm.setSenttime(null);
			editForm.setAistatus("PENDING");
			editForm.setAibatchId(null);
			editForm.setErrors("");
			editForm.setDocument("");			
		}


		// Forward control to the edit page
		log.debug(" Forwarding to 'success' page");
		return findSuccess(mapping);
	}
}
