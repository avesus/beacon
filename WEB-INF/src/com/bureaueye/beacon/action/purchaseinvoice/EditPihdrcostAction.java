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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.purchaseinvoice.PidtlcostForm;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;




public final class EditPihdrcostAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		PidtlcostForm editForm = (PidtlcostForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());
		Pidtlcost dao = null; 

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			dao = pidtlcostbd.read(new Integer(editForm.getPidtlcostId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for Id: "
						+ editForm.getPidtlId() + ", "
						+ "dtlid: " + editForm.getPidtlcostId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getPidtlId()
						+ " - " + editForm.getPidtlcostId()));
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



		// set defaults for Create process
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {

			PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
			PidtlBD pidtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
			JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

			Pidtl dtldao = pidtlbd.read(new Integer(editForm.getPidtlId()));
			Pihdr hdrdao = pihdrbd.read(dtldao.getPihdrId());


			// set collections
			try {
				//check if miscellaneous invoice
				if (!hdrdao.isMiscflag()) {
					// set purchase invoice vendor job cost list					
					ListForm listForm = new ListForm();					
					listForm.setSearchString1(dtldao.getJobno());				
					listForm.setSearchString2(hdrdao.getVendoraddrkey());
					listForm.setSearchString3(hdrdao.getCcykey());				
					listForm.setOrderBy("Costkey");

					editForm.setVendorjobcosts(
						jobcostbd.findJobcostsByJobhdrIdVendoraddrkeyCcykey(listForm)
					);
				}
				
				editForm.setPidtlcosts(
						pidtlcostbd.findPidtlcostsById(
								editForm.getPidtlId(),
								0,
								com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
								"Costkey"
						)
				);


			} catch (Exception e) {}


			editForm.setVendoraddrkey(hdrdao.getVendoraddrkey());
			editForm.setCcykey(hdrdao.getCcykey());
			editForm.setMiscflag(hdrdao.isMiscflag());
			

			//clear
			pihdrbd=null;
			pidtlbd=null;
			jobcostbd=null;

		}				

		//clear
		pidtlcostbd=null;

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
