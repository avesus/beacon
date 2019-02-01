package com.bureaueye.beacon.action.report;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.report.bd.ReportBD;

public final class ListFasttrackAction extends ListAction {

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}

	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Unitkey");		
		}
		listForm.setOrderByDesc("desc");

		// unitkey
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1("%");
		}
		// inactive 
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("N");
		}
		
		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,7);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}
		
	}

	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {

		listForm.setLineItems(null);
		listForm.setLineItems(
				new ReportBD(this.getSessionFactoryClusterMap()).fasttrack(
						listForm						
						)
					);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
