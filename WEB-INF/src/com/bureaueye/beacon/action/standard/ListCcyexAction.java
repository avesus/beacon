package com.bureaueye.beacon.action.standard;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;

public final class ListCcyexAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Fromccykey");
		}
		
		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.MONTH,-1);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.MONTH,1);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}
				
		int total = 0;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);		
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {
		
		CcyexBD bd = new CcyexBD(this.getSessionFactoryClusterMap());
		listForm.setLineItems(bd.findCcyexsBySearch(listForm));
		bd=null;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
				);
		
		return null;
	}
}
