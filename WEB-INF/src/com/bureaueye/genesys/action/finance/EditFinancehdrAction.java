package com.bureaueye.genesys.action.finance;

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
import com.bureaueye.genesys.form.finance.FinancehdrForm;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;






public final class EditFinancehdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);	
		FinancehdrForm editForm = (FinancehdrForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Financehdr dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new FinancehdrBD(this.getSessionFactoryClusterMap())
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
			
		}



		// create only
		if (action.equals("Create")) {
			editForm.setManualflag(true);
			editForm.setDockey("");
			editForm.setId("");
			
			// default user information
			editForm.setCreateuserid(user.getUserid());		
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());
			
			// default dates to today
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setBilldate(c.getTime());
				editForm.setDocdate(c.getTime());
			} catch (Exception e) {}			
		}
				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
