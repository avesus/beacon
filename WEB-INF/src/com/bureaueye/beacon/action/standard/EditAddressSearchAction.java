package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;

public final class EditAddressSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm addresssearchForm = (ListForm) form;

		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+" EditAddresssearchAction: " + 
				addresssearchForm.getId());

		Address address = new AddressBD(this.getSessionFactoryClusterMap()).read(addresssearchForm.getId());
		addresssearchForm.setStartPage();
		if (address == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" No Address found for addrkey "
					+ addresssearchForm.getId());
			// Blank out any previously saved parameters
			addresssearchForm.setSearchString1(null);
			addresssearchForm.setSearchString2(null);
			addresssearchForm.setSearchString3(null);
			addresssearchForm.setSearchString4(null);
			addresssearchForm.setSearchString5(null);
			addresssearchForm.setSearchString6(null);
			addresssearchForm.setSearchString7(null);
			addresssearchForm.setSearchString8(null);
			addresssearchForm.setSearchString9(null);
			addresssearchForm.setSearchString10(null);
			addresssearchForm.setSearchString11(null);
			addresssearchForm.setSearchString12(null);
			addresssearchForm.setSearchString13(null);
			addresssearchForm.setSearchString14(null);

		} else {
			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+
					" Populating AddresssearchForm from " + address
					);
			addresssearchForm.setSearchString1(address.getName());
			addresssearchForm.setSearchString2(address.getShortname());
			addresssearchForm.setSearchString3(address.getAddr1());
			addresssearchForm.setSearchString4(address.getAddr2());
			addresssearchForm.setSearchString5(address.getAddr3());
			addresssearchForm.setSearchString6(address.getAddr4());
			addresssearchForm.setSearchString7(address.getPostalcode());
			addresssearchForm.setSearchString8(address.getCity());
			addresssearchForm.setSearchString9(address.getState());
			addresssearchForm.setSearchString10(address.getCountry());
			addresssearchForm.setSearchString11(address.getTelno1());
			addresssearchForm.setSearchString12(address.getFaxno1());
			addresssearchForm.setSearchString13(address.getEmailno());
			addresssearchForm.setSearchString14(address.getCcykey());
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
