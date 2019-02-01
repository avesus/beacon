package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;


public final class EditUnitSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm searchForm = (ListForm) form;

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditSearchAction: " + searchForm.getId());

		Unit dto = new UnitBD(this.getSessionFactoryClusterMap()).findUnitByUnitkey(searchForm.getId());
		searchForm.setStartPage();
		if (dto == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" No Unit found for key "
					+ searchForm.getId());
			
			try{
			// default order location information
			Orderhdr orderhdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(searchForm.getHeaderInfo6()));
			Location location = new LocationBD(this.getSessionFactoryClusterMap()).read(orderhdr.getLdglocationkey1());
			
			// Blank out any previously saved parameters
			searchForm.setSearchString1(null);
			searchForm.setSearchString2(null);
			
			if (location != null) {
				searchForm.setSearchString3(location.getLocationkey());
				searchForm.setSearchString4(location.getCountry());
				searchForm.setSearchString5(location.getLocationcode());
			}
			} catch (Exception e) {}
			
			searchForm.setSearchString6("Y");
			searchForm.setSearchString7(null);
			searchForm.setSearchString8(null);
			searchForm.setSearchString9(null);
			searchForm.setSearchString10(null);
			searchForm.setSearchString11(null);
			searchForm.setSearchString12(null);
			searchForm.setSearchString13(null);
			searchForm.setSearchString14(null);

		} else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating SearchForm from " + dto);
			searchForm.setSearchString1(dto.getUnitkey());
			//searchForm.setSearchString2(dao.getShortname());
			//searchForm.setSearchString3(dto.getAddress1());
			//searchForm.setSearchString4(dto.getAddress2());
			//searchForm.setSearchString5(dto.getAddress3());
			//searchForm.setSearchString6(dao.getAddr4());
			//searchForm.setSearchString7(dto.getPostalCode());
			//searchForm.setSearchString8(dto.getCity());
			//searchForm.setSearchString9(dto.getState());
			//searchForm.setSearchString10(dto.getCountry());
			//searchForm.setSearchString11(dto.getPhone());
			//searchForm.setSearchString12(dto.getFax());
			//searchForm.setSearchString13(dao.getEmailno());
			//searchForm.setSearchString14(dao.getCcykey());
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
