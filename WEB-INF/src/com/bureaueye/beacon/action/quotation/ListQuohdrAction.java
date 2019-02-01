package com.bureaueye.beacon.action.quotation;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


/**
 *
 * Amendments
 * ----------
 *
 * 	 											
 *
 */
public final class ListQuohdrAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Quotedate");
		}
	
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Quotedate")) listForm.setOrderByDesc("desc");
		

		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}
		
		
		// set default field values
		// customer
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
		}
		
		// status
		if (listForm.getSearchString9() == null || listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("%");
		}
		
		// location
		if (listForm.getSearchString10() == null || listForm.getSearchString10().equals("")) {
			listForm.setSearchString10("%");
		}	
		// location
		if (listForm.getSearchString11() == null || listForm.getSearchString11().equals("")) {
			listForm.setSearchString11("%");
		}
		// location
		if (listForm.getSearchString12() == null || listForm.getSearchString12().equals("")) {
			listForm.setSearchString12("%");
		}
		// location
		if (listForm.getSearchString13() == null || listForm.getSearchString13().equals("")) {
			listForm.setSearchString13("%");
		}
		
		// active/expired 
		if (listForm.getSearchString15() == null || listForm.getSearchString15().equals("")) {
			listForm.setSearchString15("ALL");
		}

		
		
		
		//loading gcodes
		if (listForm.getSearchString20() == null || listForm.getSearchString20().equals("")) {
			listForm.setSearchString20("");
		}	
		if (listForm.getSearchString21() == null || listForm.getSearchString21().equals("")) {
			listForm.setSearchString21("");
		}
		if (listForm.getSearchString22() == null || listForm.getSearchString22().equals("")) {
			listForm.setSearchString22("");
		}
		if (listForm.getSearchString23() == null || listForm.getSearchString23().equals("")) {
			listForm.setSearchString23("");
		}
		//discharge gcodes
		if (listForm.getSearchString24() == null || listForm.getSearchString24().equals("")) {
			listForm.setSearchString24("");
		}	
		if (listForm.getSearchString25() == null || listForm.getSearchString25().equals("")) {
			listForm.setSearchString25("");
		}
		if (listForm.getSearchString26() == null || listForm.getSearchString26().equals("")) {
			listForm.setSearchString26("");
		}
		if (listForm.getSearchString27() == null || listForm.getSearchString27().equals("")) {
			listForm.setSearchString27("");
		}
		
		
		
		
		// expiry/active date check
		listForm.setSearchDate3(new Date());
		
		
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(
					new SystemcodeBD(
							this.getSessionFactoryClusterMap()
					).read(new SystemcodePK("DATERANGEDAYS","LISTQUOHDR")).getDescr()).intValue();
		}catch(Exception e){}
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// quote date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}
		
		int total = 0;	
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
		
		//default company
		if (listForm.getSearchString19() == null || listForm.getSearchString19().equals("")) {
			listForm.setSearchString19("");
			try {
				List usercompanykeylist=(List)session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USERCOMPANYKEYLIST);
				Company companydao = (Company)usercompanykeylist.iterator().next();
				listForm.setSearchString19(companydao.getCompid());
			} catch (Exception e) {
			}
		}
		
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		if (listForm.getSearchString1() == null || 
				listForm.getSearchString1().equals("")) {
			if (listForm.getSearchString15().equals("ACTIVE")) {			
				listForm.setLineItems(		
						new QuohdrBD(
								this.getSessionFactoryClusterMap()
						)
						.findQuohdrsBySearchActive(listForm)
				);		
			} 
			if (listForm.getSearchString15().equals("EXPIRED")) {			
				listForm.setLineItems(		
						new QuohdrBD(
								this.getSessionFactoryClusterMap()
						)
						.findQuohdrsBySearchExpired(listForm)
				);					
			}
			if (listForm.getSearchString15().equals("ALL")) {			
				listForm.setLineItems(		
						new QuohdrBD(
								this.getSessionFactoryClusterMap()
						)
						.findQuohdrsBySearch(listForm)
				);					
			}			
		}
		else { 
			listForm.setLineItems(		
					new QuohdrBD(
							this.getSessionFactoryClusterMap()
					)
					.findQuohdrsBySearchByQuotno(listForm)
			);		
		}
		
		return null;
	}
}
