package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.LocationBD;


public final class EditLocationSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm searchForm = (ListForm) form;

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditLocationsearchAction: " + searchForm.getId());

		Location dao = new LocationBD(this.getSessionFactoryClusterMap()).read(searchForm.getId());
		searchForm.setStartPage();
		if (dao == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" No Location found for id "
					+ searchForm.getId());
			// Blank out any previously saved parameters
			searchForm.setSearchString1(null);
			searchForm.setSearchString2(null);
			searchForm.setSearchString3(null);
			searchForm.setSearchString4(null);
			searchForm.setSearchString5(null);
			searchForm.setSearchString6(null);
			searchForm.setSearchString7(null);
			searchForm.setSearchString8(null);
			searchForm.setSearchString9(null);
			searchForm.setSearchString10(null);
			searchForm.setSearchString11(null);
			searchForm.setSearchString12(null);
			searchForm.setSearchString13(null);
			searchForm.setSearchString14(null);

		} else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating LocationsearchForm from " + dao);
			searchForm.setSearchString1(dao.getLocationName());
			//searchForm.setSearchString2(dao.getShortname());
			searchForm.setSearchString3(dao.getAddress1());
			searchForm.setSearchString4(dao.getAddress2());
			searchForm.setSearchString5(dao.getAddress3());
			//searchForm.setSearchString6(dao.getAddr4());
			searchForm.setSearchString7(dao.getPostalCode());
			searchForm.setSearchString8(dao.getCity());
			searchForm.setSearchString9(dao.getState());
			searchForm.setSearchString10(dao.getCountry());
			searchForm.setSearchString11(dao.getPhone());
			searchForm.setSearchString12(dao.getFax());
			//searchForm.setSearchString13(dao.getEmailno());
			//searchForm.setSearchString14(dao.getCcykey());
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
