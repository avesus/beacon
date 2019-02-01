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
import com.bureaueye.beacon.form.standard.VendortariffdtlForm;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.VendortariffdtlBD;


public final class SaveVendortariffdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		VendortariffdtlForm vendortariffdtlform = (VendortariffdtlForm) form;
		String action = vendortariffdtlform.getAction();
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
		VendortariffdtlBD vendortariffdtlbd = new VendortariffdtlBD(this.getSessionFactoryClusterMap());

		if (action.equals("Delete")) {
			vendortariffdtlbd.delete(new Vendortariffdtl(vendortariffdtlform
					.getVendtarfdtlId()), user);
		} else {
			Vendortariffdtl vendortariffdtl = vendortariffdtlbd
					.read(vendortariffdtlform.getVendtarfdtlId());

			if (vendortariffdtl == null) {
				vendortariffdtl = new Vendortariffdtl();
			}

			BeanUtils.copyProperties(vendortariffdtl, vendortariffdtlform);

			vendortariffdtlbd.createOrUpdate(vendortariffdtl, user);

			// Find the ListVendortariffdtlForm and reset to first page
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveVendortariffdtlAction: createOrUpdate " + "List"
					+ mapping.getName());
			((ListForm) session.getAttribute("List" + mapping.getName()))
					.setStartPage();
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
