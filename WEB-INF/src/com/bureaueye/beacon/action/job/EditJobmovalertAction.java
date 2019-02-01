package com.bureaueye.beacon.action.job;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
import com.bureaueye.beacon.form.alert.AlertForm;
import com.bureaueye.beacon.model.alert.Alert;
import com.bureaueye.beacon.model.alert.bd.AlertBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;






public final class EditJobmovalertAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		AlertForm editForm = (AlertForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Alert dao = null; 

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			dao = new AlertBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getAlertId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for Id: "
						+ editForm.getAlertId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getAlertId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		


			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setAlertId(null);
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}

		}

		
		//init fields for create action
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {	
			editForm.setRuleparam5("0");
		}		
		
		
		//**IMPORTANT** FOR THE A SCREEN LIST TO WORK THE SCREEN *MUST* BE A SESSION SCOPE
		//populate job movement list
		try {
			// for multiple Movement Update process
			List<JobmovDTO> jobmovs = null;
			jobmovs=new JobmovBD(
					this.getSessionFactoryClusterMap()
			)
			.findJobmovsById(
					editForm.getRecord1Id().toString(), 
					0, 
					com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT, 
					"Totimeinmillis", 
					"Fromtimeinmillis"
			);		
			editForm.setJobmovs(jobmovs);
		} catch (Exception e) {
		}


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
