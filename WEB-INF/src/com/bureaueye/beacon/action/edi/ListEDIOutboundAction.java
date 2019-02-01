package com.bureaueye.beacon.action.edi;


import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.edi.bd.EDIOutboundBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


public final class ListEDIOutboundAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("EDIOUTBOUND_ID");
			}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("EDIOUTBOUND_ID")) listForm.setOrderByDesc("desc");
		if (listForm.getOrderBy().equals("Createdate")) listForm.setOrderByDesc("desc");
		if (listForm.getOrderBy().equals("Sentdate")) listForm.setOrderByDesc("desc");
		
		// set default field values
		// type
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1("%");
		}		
		// partner
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
		}
		// status
		if (listForm.getSearchString9() == null || listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("ERROR");
		}
		// id
		//if (listForm.getSearchString3() == null || listForm.getSearchString3().equals("")) {
		//	listForm.setSearchString3("%");
		//}		

		int dateRangeDays = 7;
		try{
			dateRangeDays = 
				new Integer(
						new SystemcodeBD(
								this.getSessionFactoryClusterMap()
						)
						.read(new SystemcodePK("DATERANGEDAYS","LISTEDIOUTBOUND")).getDescr()).intValue();
		}catch(Exception e){}	
		
		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);		
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}

		Calendar c2 = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate3() == null) {
			c2.add(Calendar.DATE,-1*dateRangeDays);		
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate3(c2.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate4() == null) {			
			// default 'to' date plus 7 
			c2.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate4(c2.getTime());
			} catch (Exception e) {
			}								
		}
		
		int total = 0;
		//total = new EDIOutboundBD(this.getSessionFactoryClusterMap()).findEDIOutboundsTotalResults(listForm);	
		listForm.setTotalResults(total);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		listForm.setLineItems(		
				new EDIOutboundBD(this.getSessionFactoryClusterMap())
					.findEDIOutboundsBySearch(listForm)
					);		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());
		return null;
	}
}
