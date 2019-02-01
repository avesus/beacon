package com.bureaueye.genesys.action.onhire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;



public final class EditUnitSearchAction extends PopupBaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		ListForm searchForm = (ListForm) form;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" EditSearchAction: " + searchForm.getId());
		
		Unit dto = new UnitBD(this.getSessionFactoryClusterMap()).findUnitByUnitkey(searchForm.getId());
		searchForm.setStartPage();
		if (dto == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" No Unit found for key "+ searchForm.getId());
			
			try {
				// default order location information
				Onhire onhire = 
					new OnhireBD(this.getSessionFactoryClusterMap()).read(new Integer(searchForm.getHeaderInfo6()));
				Location location = 
					new LocationBD(this.getSessionFactoryClusterMap()).read(onhire.getLocationkey());
				
				// Blank out any previously saved parameters
				searchForm.setSearchString1(null);
				searchForm.setSearchString2(null);
				
				if (location != null) {
					searchForm.setSearchString3(location.getLocationkey());
					//searchForm.setSearchString4(location.getCountry());
					//searchForm.setSearchString5(location.getLocationcode());
				}	
				searchForm.setSearchString6("Y");						//foodgrade
				searchForm.setSearchString7(onhire.getEqpkeyp1());		//Eqpkeyp1
				searchForm.setSearchString8(onhire.getEqpkeyp2());		//Eqpkeyp2
				searchForm.setSearchString9(null);						//Eqpkeyp3
				searchForm.setSearchString10(null);						//Eqpkeyp4
				searchForm.setSearchString11(null);						//Eqpkeyp5
			} catch (Exception e) {}
			
			//searchForm.setSearchString7(null);		//Eqpkeyp1
			//searchForm.setSearchString8(null);		//Eqpkeyp2
			//searchForm.setSearchString9(null);		//Eqpkeyp3
			//searchForm.setSearchString10(null);		//Eqpkeyp4
			//searchForm.setSearchString11(null);		//Eqpkeyp5
			searchForm.setSearchString12(null);
			searchForm.setSearchString13(null);
			searchForm.setSearchString14(null);
			
		} else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating SearchForm from " + dto);
			searchForm.setSearchString1(dto.getUnitkey());
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());
		
		return findSuccess(mapping);
	}
}
