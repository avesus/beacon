package com.bureaueye.beacon.action.job;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

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
import com.bureaueye.beacon.form.job.JobcostForm;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;




/**
 * Amendments
 * ----------
 * 												
 * NT	2012-09-28		201100019			Change Copy process to not default header currency to cost currency
 *
 */
public final class EditJobcostAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		JobcostForm editForm = (JobcostForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" ["+this.getClass().getName()+"] "+new Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			Jobcost dto = new JobcostBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getJobcostId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getJobmovId() + ", "
						+ "movid: " + editForm.getJobcostId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getJobmovId()
						+ " - " + editForm.getJobcostId()));
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
				editForm.setJobcostId("");
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
			}
		}


		// set header information
		Jobmov mov = new JobmovBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getJobmovId()));
		Jobhdr hdr = null;
		Orderhdr orderhdr = null;
		if (mov != null) {
			hdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(mov.getJobhdrId());
			if (hdr != null)	{
				orderhdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(hdr.getOrderhdrId());				
				if (orderhdr != null) editForm.setBaseccykey(orderhdr.getCcykey());
			}
		}		

		// set defaults for Create process
		if (editForm.getAction().equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {

			editForm.setPoststatus("");

			if (orderhdr != null)	{
				if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) { 
					editForm.setCcykey(orderhdr.getCcykey());
				}
			}
			
			if (mov != null)	{
				//only init if orginal action not COPY 
				if (!action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) { 
					editForm.setVendoraddrkey(mov.getVendoraddrkey());
				}
			}
			
		}
		hdr = null;
		mov = null;
		orderhdr = null;


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
