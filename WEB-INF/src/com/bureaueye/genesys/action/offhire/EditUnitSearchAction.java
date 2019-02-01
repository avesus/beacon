package com.bureaueye.genesys.action.offhire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.genesys.model.offhire.Offhire;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;



public final class EditUnitSearchAction extends PopupBaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		ListForm searchForm = (ListForm) form;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" EditSearchAction=" + searchForm.getId());
		
		Unit dto = new UnitBD(this.getSessionFactoryClusterMap()).findUnitByUnitkey(searchForm.getId());
		searchForm.setStartPage();
		if (dto == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" No Unit found for key="+ searchForm.getId());
			
			try {
				// default lessee information
				Offhire offhire = new OffhireBD(this.getSessionFactoryClusterMap()).read(new Integer(searchForm.getHeaderInfo6()));
				Address lessee = new AddressBD(this.getSessionFactoryClusterMap()).read(offhire.getLesseeaddrkey());
				
				// Blank out any previously saved parameters
				searchForm.setSearchString1(null);
				searchForm.setSearchString2(null);
				
				if (lessee != null) {
					searchForm.setSearchString3(lessee.getAddrkey());
				}
				
				searchForm.setSearchString6("Y");						//foodgrade
				searchForm.setSearchString7(offhire.getEqpkeyp1());		//Eqpkeyp1
				searchForm.setSearchString8(offhire.getEqpkeyp2());		//Eqpkeyp2
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
