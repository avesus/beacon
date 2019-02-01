package com.bureaueye.beacon.action.standard;

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
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.standard.UnitForm;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.UnitBD;


public final class EditUnitAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UnitForm unitForm = (UnitForm) form;

		String action = unitForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" UnitForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		if (!(action == null || action.equals("Create"))) {

			Unit dto = new UnitBD(this.getSessionFactoryClusterMap()).read(new Integer(unitForm.getUnitId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for unit: " + unitForm.getUnitId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", unitForm.getUnitId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't delete: forwarding to: "
						+ findFailure(mapping).getPath());
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);
			

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(unitForm, dto);
				
				// list certificates
				SystemX systemX = (SystemX)request.getSession().getAttribute(com.bureaueye.beacon.bean.standard.Constants.SYSTEM_KEY);
				unitForm.setCertificatedirectory(systemX.getCertifdir());
				unitForm.setCertificatepath(systemX.getCertifpath());
				unitForm.setCertificates();
				
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
			}	
		
			
			if (action.equals("Copy")) {
				unitForm.setUnitId(null);
				unitForm.setUnitkey("");
				unitForm.setAction("Create");
				action="Create";
			}
			
		}

		if (action.equals("Create")) {
			unitForm.setMovests("AVAILABLE");
			unitForm.setInvsts("AVAILABLE");
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
