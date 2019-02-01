package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.VesselForm;

import com.bureaueye.beacon.model.standard.Vessel;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.VesselBD;

public final class SaveVesselAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		VesselForm vesselForm = (VesselForm) form;
		String action = vesselForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Processing " + action	+ " action");
		
		// Generate Business Delegate
		VesselBD vesselbd = new VesselBD(this.getSessionFactoryClusterMap());

		if (action.equals("Delete")) {
			vesselbd.delete(new Vessel(vesselForm.getVesselkey()), user);
		} else {
			Vessel vessel = vesselbd.read(vesselForm.getVesselkey());

			if (vessel == null) {
				vessel = new Vessel();
			}
			BeanUtils.copyProperties(vessel, vesselForm);

			vesselbd.createOrUpdate(vessel, user);

			// Find the vessel form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			//listform.setStartPage();
			//listform.setSearchString1(vessel.getVesselkey());
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
