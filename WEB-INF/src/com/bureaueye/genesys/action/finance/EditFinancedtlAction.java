package com.bureaueye.genesys.action.finance;

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
import com.bureaueye.genesys.form.finance.FinancedtlForm;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancedtlBD;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;






public final class EditFinancedtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FinancedtlForm editForm = (FinancedtlForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Financedtl dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new FinancedtlBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getFinancedtlId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getFinancehdrId() + ", "
						+ "dtlid: " + editForm.getFinancedtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getFinancehdrId()
								+ " - " + editForm.getFinancedtlId()));
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
				editForm.setFinancedtlId("");
				editForm.setDockey("");
				editForm.setAction("Create");
				action="Create";
			}
			
		}


		// set defaults for Create process
		if (action.equals("Create")) {
			Financehdr hdr = new FinancehdrBD(this.getSessionFactoryClusterMap())
								.read(new Integer(editForm.getFinancehdrId()));
			// default information
			editForm.setCcykey(hdr.getCcykey());
			editForm.setDoctypekey(hdr.getDoctypekey());
		}				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
