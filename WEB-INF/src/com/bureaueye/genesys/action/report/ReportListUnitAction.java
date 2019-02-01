package com.bureaueye.genesys.action.report;


import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.UnitfitBD;



public final class ReportListUnitAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Unitkey");
		}
		
		
		// order by
		listForm.setOrderByDesc("");
		
		
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
		}				
		if (listForm.getSearchString3() == null || listForm.getSearchString3().equals("")) {
			listForm.setSearchString3("%");
		}	
		if (listForm.getSearchString4() == null || listForm.getSearchString4().equals("")) {
			listForm.setSearchString4("%");
		}	
		if (listForm.getSearchString5() == null || listForm.getSearchString5().equals("")) {
			listForm.setSearchString5("%");
		}				
		if (listForm.getSearchString6() == null || listForm.getSearchString6().equals("")) {
			listForm.setSearchString6("%");
		}	
		if (listForm.getSearchString7() == null || listForm.getSearchString7().equals("")) {
			listForm.setSearchString7("%");
		}
		if (listForm.getSearchString8() == null || listForm.getSearchString8().equals("")) {
			listForm.setSearchString8("%");
		}

		
		
		int total = Constants.MAX_TOTAL_RESULTS;
		
		listForm.setTotalResults(total);
		
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {
		
		listForm.setLineItems(null);
		
		if (listForm.getAction() != null) {
			if (listForm.getAction().equals("CurrentFleetforLessee")) {
				listForm.setLineItems(
						new UnitBD(this.getSessionFactoryClusterMap()).findUnitsByKey2(listForm)
				);

				// clear other search fields
					listForm.setSearchString3("%");
					listForm.setSearchString4("%");
					listForm.setSearchString5("%");
					listForm.setSearchString6("%");					
					listForm.setSearchString7("%");
					listForm.setSearchString8("%");
					listForm.setSearchString9("");			
			}
			
			if (listForm.getAction().equals("UnitsAvailableforLeasebyEquipment")) {
				listForm.setLineItems(
						new UnitBD(this.getSessionFactoryClusterMap()).findUnitsByKey3(listForm)
				);
				
//				 clear other search fields
				listForm.setSearchString2("%");
				listForm.setSearchString6("%");				
				listForm.setSearchString7("%");
				listForm.setSearchString8("%");
				listForm.setSearchString9("");					
			}
			
			if (listForm.getAction().equals("UnitsAvailableforLeasebyFittings")) {
				listForm.setLineItems(
						new UnitfitBD(this.getSessionFactoryClusterMap()).findUnitfitsByKey1(listForm)
				);

//				 clear other search fields
				listForm.setSearchString2("%");
				listForm.setSearchString3("%");
				listForm.setSearchString4("%");
				listForm.setSearchString5("%");			
			}			
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
	
	
}
