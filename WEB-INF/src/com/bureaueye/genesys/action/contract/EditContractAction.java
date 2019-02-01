package com.bureaueye.genesys.action.contract;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.genesys.form.contract.ContractForm;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.bd.ContractBD;






public final class EditContractAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);	
		ContractForm editForm = (ContractForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Contract dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new ContractBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
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
			
/*			// view only
			if (!dto.isManualflag() || dto.isPrintedflag()) {
				editForm.setAction("View");
				editForm.setReadonly("TRUE");
			}*/
			
			
			if (action.equals("Copy")) {
				editForm.setCopyId(editForm.getId());				
				editForm.setId("");				
				editForm.setContractno("");				
				editForm.setAction("Create");
				action="Create";
			}
			
		}



		// create only
		if (action.equals("Create")) {
			// default user information
			editForm.setCreateuserid(user.getUserid());		
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());

			editForm.setBillfreqnum("1");
			editForm.setBillfreqtype("MONTH");
			
			// default quote date to today
			Calendar c = Calendar.getInstance();		
			try {editForm.setContractdate(c.getTime());} catch (Exception e) {}
			try {editForm.setCreatedate(c.getTime());} catch (Exception e) {}			
			
		}
				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
