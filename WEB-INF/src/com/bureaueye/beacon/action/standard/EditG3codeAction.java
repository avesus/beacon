package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;

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
import com.bureaueye.beacon.form.standard.G3codeForm;
import com.bureaueye.beacon.model.standard.G3code;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;



public final class EditG3codeAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		G3codeForm editForm = (G3codeForm) form;

		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {

			G3code dao = new G3codeBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getG3codeId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for id: " + editForm.getG3codeId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getG3codeId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't delete: forwarding to: "
						+ findFailure(mapping).getPath());
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);
			

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dao);				
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
			}	
		
			
			if (action.equals("Copy")) {
				editForm.setG3codekey("");
				editForm.setG3codeId("");
				editForm.setAction("Create");
			}
			
		}

		if (action.equals("Create")) {

		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
