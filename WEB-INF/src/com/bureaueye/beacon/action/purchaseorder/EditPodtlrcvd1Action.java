package com.bureaueye.beacon.action.purchaseorder;


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
import com.bureaueye.beacon.form.purchaseorder.Podtlrcvd1Form;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlrcvdBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;



public final class EditPodtlrcvd1Action extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Podtlrcvd1Form editForm = (Podtlrcvd1Form) form;

		// Extract attributes we will need
		String action = editForm.getActionX();

		// If action isn't supplied then invalidate the session
		if (editForm.getActionX() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals("Create"))) {

			Podtlrcvd dto = new PodtlrcvdBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getPodtlrcvdId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" No record found for podtlId: "
						+ editForm.getPodtlId() + ", "
						+ "podtlrcvdId: " + editForm.getPodtlrcvdId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getPodtlId()
								+ " - " + editForm.getPodtlrcvdId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);

			// set header information


			// set extra information
			try {
				editForm.setQtygenerated(
						new UnitBD(this.getSessionFactoryClusterMap()).countUnitsByPodtlrcvdId(dto.getPodtlrcvdId().toString())
						);
			} catch (Exception ae) {}
			
		}

		
		// set defaults for Create process
		if (action.equals("Create")) {
			// default information

		}
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
