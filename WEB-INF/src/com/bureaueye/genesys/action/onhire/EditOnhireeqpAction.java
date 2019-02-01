package com.bureaueye.genesys.action.onhire;

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
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.genesys.form.onhire.OnhireeqpForm;
import com.bureaueye.genesys.model.onhire.Onhireeqp;
import com.bureaueye.genesys.model.onhire.bd.OnhireeqpBD;






public final class EditOnhireeqpAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		OnhireeqpForm editForm = (OnhireeqpForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Onhireeqp dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new OnhireeqpBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getOnhireeqpId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getOnhireId() + ", "
						+ "dtlid: " + editForm.getOnhireeqpId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getOnhireId()
								+ " - " + editForm.getOnhireeqpId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		
			
			
			if (action.equals("Copy")) {
				editForm.setCopyId(editForm.getOnhireeqpId());
				editForm.setOnhireeqpId("");							
				editForm.setAction("Create");
				action="Create";
			}
		}


		// set defaults for Create process
		if (action.equals("Create")) {

		}				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
