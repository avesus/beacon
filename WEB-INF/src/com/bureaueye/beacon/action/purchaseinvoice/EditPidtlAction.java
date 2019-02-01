package com.bureaueye.beacon.action.purchaseinvoice;

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
import com.bureaueye.beacon.form.purchaseinvoice.PidtlForm;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;




public final class EditPidtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		PidtlForm editForm = (PidtlForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Pidtl dao = null; 

		if (!(action == null || action.equals("Create"))) {

			dao = new PidtlBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getPidtlId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getPihdrId() + ", "
						+ "dtlid: " + editForm.getPidtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getPihdrId()
						+ " - " + editForm.getPidtlId()));
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


		}


		// set collections
		try {
			// set purchase invoice vendor job list
			Pihdr hdr = new PihdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getPihdrId()));
			String vendoraddrkey = hdr.getVendoraddrkey();
			String ccykey = hdr.getCcykey();
			JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

			editForm.setVendorjobs(
					jobcostbd.findJobcostsByVendoraddrkeyCcykey(
							vendoraddrkey,
							ccykey,
							0,
							com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
							"jobcost.JobhdrId"
					)
			);

		} catch (Exception e) {}


		try {	
			PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());
			// set line items
			editForm.setPidtlcosts(
					pidtlcostbd.findPidtlcostsById(
							editForm.getPidtlId(),
							0,
							com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
							"Costkey"
					)
			);
		} catch (Exception e) {}		


		// set defaults for Create process
		if (action.equals("Create")) {

		}				


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
