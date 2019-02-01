package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Locationcode;
import com.bureaueye.beacon.model.standard.bd.LocationcodeBD;


public final class EditLocationcodeSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm searchForm = (ListForm) form;

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditLocationcodesearchAction: " + searchForm.getId());

		Locationcode dto = new LocationcodeBD(this.getSessionFactoryClusterMap()).read(searchForm.getId());
		searchForm.setStartPage();
		if (dto == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" No Location code found for id"
					+ searchForm.getId());
			// Blank out any previously saved parameters
			//searchForm.setSearchString1(null);
			searchForm.setSearchString2(null);
			searchForm.setSearchString3(null);
		} else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating LocationsearchForm from " + dto);
			searchForm.setSearchString1(dto.getCountrykey());
			searchForm.setSearchString2(dto.getLdesc());
			searchForm.setSearchString3(dto.getLocationcode());
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
