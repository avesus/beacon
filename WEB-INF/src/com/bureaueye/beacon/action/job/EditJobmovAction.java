package com.bureaueye.beacon.action.job;

import java.lang.reflect.InvocationTargetException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.job.JobmovForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;





public final class EditJobmovAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		JobmovForm editForm = (JobmovForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Jobmov dao = null; 

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			dao = new JobmovBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getJobmovId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getJobhdrId() + ", "
						+ "movid: " + editForm.getJobmovId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getJobhdrId()
						+ " - " + editForm.getJobmovId()));
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
				editForm.setJobmovId("");

				/*				editForm.setActfromdate(null);
				editForm.setActfromdatedd("00");
				editForm.setActfromdatemm("00");
				editForm.setActfromdateyyyy("0000");
				editForm.setActfromtime("00:00");
				editForm.setActfromtimehh("00");
				editForm.setActfromtimemm("00");
				editForm.setActfromtimeinmillis("0");
				editForm.setActtodate(null);
				editForm.setActtodatedd("00");
				editForm.setActtodatemm("00");
				editForm.setActtodateyyyy("0000");
				editForm.setActtotime("00:00");
				editForm.setActtotimehh("00");
				editForm.setActtotimemm("00");
				editForm.setActtotimeinmillis("0");*/

				editForm.setActfromdate(null);
				editForm.setActfromdatedd(null);
				editForm.setActfromdatemm(null);
				editForm.setActfromdateyyyy(null);
				editForm.setActfromtime(null);
				editForm.setActfromtimehh(null);
				editForm.setActfromtimemm(null);
				editForm.setActfromtimeinmillis(null);
				editForm.setActtodate(null);
				editForm.setActtodatedd(null);
				editForm.setActtodatemm(null);
				editForm.setActtodateyyyy(null);
				editForm.setActtotime(null);
				editForm.setActtotimehh(null);
				editForm.setActtotimemm(null);
				editForm.setActtotimeinmillis(null);

				editForm.setMmulink("");
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}

		}


		JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
		Jobhdr hdr = jobhdrbd.read(new Integer(editForm.getJobhdrId()));
		// init Unit id 
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {	
			if (hdr != null) {				
				editForm.setUnitId(hdr.getUnitId().toString());				
			}
		}
		jobhdrbd=null;


		//check multiple update function required
		PropertyResourceBundle props = 
			(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
		if (props.getString("multipleupdate").equals("yes")) {
			//set multiple update parameters
			if (hdr != null) {

				OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
				editForm.setOrderjobsfound("false");
				try {
					if (orderhdrbd.getOrderjobscount(hdr.getOrderhdrId().toString()) > 1) {
						editForm.setOrderjobsfound("true");
					}
				} catch (ApplicationException ae) {}

				editForm.setOrderconsignmentsfound("false");
				try {
					Orderhdr orderhdr = orderhdrbd.read(hdr.getOrderhdrId());
					if (
							!orderhdr.getConsignmentno().equals("") && 
							orderhdrbd.getOrderconsignmentscount(orderhdr.getConsignmentno()) > 1
					) {
						editForm.setOrderconsignmentsfound("true");
					}
				} catch (ApplicationException ae) {}
				orderhdrbd=null;

			}
		}//check multiple update function required

		/***
		// set collections
		if (hdr != null && action.equals(com.bureaueye.beacon.bean.Constants.EDIT_ACTION)) {				
			// for multiple Movement Update process
			List jobmovs = null;
			jobmovs = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovsByKey5(
					editForm.getJobmovId(),
					hdr.getOrderhdrId().toString(),
					editForm.getMmulink(),
					0,
					999,
					"jobhdr.Unitkey"
					);
			//convert list to arraylist??? - to capture the checkbox selection
			List<JobhdrmovDTO> jobmovDTOs = new ArrayList<JobhdrmovDTO>();
			//int row = 0;
			for (Iterator it = jobmovs.iterator(); it.hasNext();) {
					jobmovDTOs.add((JobhdrmovDTO)it.next());
			}

			editForm.setMmuList(jobmovDTOs);
			// Reset the delete boxes
			editForm.setSelectedObjects(null);		
		}
		 ***/




		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
