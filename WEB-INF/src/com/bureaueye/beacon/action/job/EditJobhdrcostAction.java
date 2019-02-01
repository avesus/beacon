package com.bureaueye.beacon.action.job;


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
import com.bureaueye.beacon.form.job.JobhdrcostForm;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;


/**
 * Amendments
 * ----------
 * 												
 * NT	2012-09-28		201100019			Change Copy process to not default header currency to cost currency
 *
 */
public final class EditJobhdrcostAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		JobhdrcostForm editForm = (JobhdrcostForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("EditAction:  Processing " + action+ " action");

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			Jobcost dto = new JobcostBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getJobcostId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for orderhdrId: "
						+ editForm.getJobhdrId() + ", "
						+ "ordercostid: " + editForm.getJobcostId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getJobhdrId()
						+ " - " + editForm.getJobcostId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);


			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setJobcostId("");			
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
			}
		}


		// set header information
		Orderhdr orderhdr = null;
		Jobhdr jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getJobhdrId()));
		if (jobhdr != null) {
			orderhdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(jobhdr.getOrderhdrId());				
			if (orderhdr != null) editForm.setBaseccykey(orderhdr.getCcykey());				
		}

		// set defaults for Create process
		if (editForm.getAction().equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {

			// default user information
			if (
					editForm.getCosttype() == null || 
					editForm.getCosttype().equals("")
			) {
				editForm.setCosttype("UNIT");
			}
			editForm.setPoststatus("");		

			// set header information
			if (orderhdr != null) {
				if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) { 
					editForm.setCcykey(orderhdr.getCcykey());
				}
			}			

		}
		jobhdr = null;	
		orderhdr=null;


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
