package com.bureaueye.beacondms.action.dms;


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
import com.bureaueye.beacondms.form.dms.TrackForm;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentversionBD;



public final class EditTrackAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		TrackForm editForm = (TrackForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		
		if (!(action == null || action.equals("Create"))) {

			Xdocument dao = new XdocumentBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getXdocumentId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Xdocument found for Id: "
						+ editForm.getXdocumentId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getDocid()
								+ " - " + editForm.getXdocumentId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);

			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dao);
			
			
		}
		
		
		// set collections
		try {	
			XdocumentversionBD xdcoumentversionbd = new XdocumentversionBD(this.getSessionFactoryClusterMap());
			// set line items
			editForm.setXdocumentversions(
					xdcoumentversionbd.findXdocumentversionsByDockey(editForm.getDockey())
					);
		} catch (Exception e) {}	
		
		

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
