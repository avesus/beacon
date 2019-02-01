package com.bureaueye.beacon.action.job;

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
import com.bureaueye.beacon.form.job.JobhdrForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;




public final class EditJobhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		JobhdrForm editForm = (JobhdrForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			Jobhdr dto = new JobhdrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getJobhdrId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for orderhdrId: "
						+ editForm.getOrderhdrId() + ", "
						+ "jobhdrid: " + editForm.getJobhdrId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getOrderhdrId()
								+ " - " + editForm.getJobhdrId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
				}		
			
			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {				
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}
		}

		
		// set collections
		try {
			//editForm.setOrderprods(new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOrderhdrId())).getOrderprods());
			editForm.setOrderprods(
					new OrderprodBD(
							this.getSessionFactoryClusterMap()
							)
					.findOrderprodsById(
							editForm.getOrderhdrId(),
							com.bureaueye.beacon.bean.Constants.MIN_TOTAL_RESULTS,
							com.bureaueye.beacon.bean.Constants.MAX_TOTAL_RESULTS,
							"Productkey"
							)
						);
		} catch (Exception e) {}
		
		// set defaults for Create process
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			editForm.setJobhdrId("");
			editForm.setJobno("");
			// default user information			
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
