package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

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
import com.bureaueye.beacon.form.standard.UnitmandrForm;
import com.bureaueye.beacon.model.standard.Unitmandr;
import com.bureaueye.beacon.model.standard.bd.UnitmandrBD;





public final class EditUnitmandrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UnitmandrForm editForm = (UnitmandrForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals("Create"))) {

			Unitmandr dto = new UnitmandrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getUnitmandrId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for Main Id: "
						+ editForm.getUnitId() + ", "
						+ "Record Id: " + editForm.getUnitmandrId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getUnitId()
								+ " - " + editForm.getUnitmandrId()));
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
			
			
			// reset fields copy
			if (action.equals("Copy")) {
				editForm.setUnitmandrId("");
				editForm.setAction("Create");
			}			
			
		}

		
		// set collections

		
		// set defaults for Create process
		if (action.equals("Create")) {
			// default user information		
			
			// default dates to today
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setMandrdate(c.getTime());
			} catch (Exception e) {}
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
