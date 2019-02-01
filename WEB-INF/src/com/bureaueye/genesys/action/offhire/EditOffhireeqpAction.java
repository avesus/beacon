package com.bureaueye.genesys.action.offhire;

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
import com.bureaueye.genesys.form.offhire.OffhireeqpForm;
import com.bureaueye.genesys.model.offhire.Offhireeqp;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpBD;






public final class EditOffhireeqpAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		OffhireeqpForm editForm = (OffhireeqpForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Offhireeqp dto = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dto = new OffhireeqpBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getOffhireeqpId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getOffhireId() + ", "
						+ "dtlid: " + editForm.getOffhireeqpId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getOffhireId()
								+ " - " + editForm.getOffhireeqpId()));
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
				editForm.setCopyId(editForm.getOffhireeqpId());
				editForm.setOffhireeqpId("");							
				editForm.setAction("Create");
				action="Create";
			}
		}


		// set defaults for Create process
		if (action.equals("Create")) {

		}				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
