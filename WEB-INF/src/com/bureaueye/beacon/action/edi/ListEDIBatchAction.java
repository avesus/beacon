package com.bureaueye.beacon.action.edi;


import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.edi.bd.EDIBatchBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


public final class ListEDIBatchAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("EDIBATCH_ID");
			}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("EDIBATCH_ID")) listForm.setOrderByDesc("desc");
		
		// set default field values
		
		int dateRangeDays = 7;
		try{
			dateRangeDays = 
				new Integer(
						new SystemcodeBD(
								this.getSessionFactoryClusterMap()
						)
						.read(new SystemcodePK("DATERANGEDAYS","LISTEDIBATCH")).getDescr()).intValue();
		}catch(Exception e){}	
		
		Calendar c = Calendar.getInstance();
		// create date 'from'
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
		//total = new EDIBatchBD(this.getSessionFactoryClusterMap()).findEDIBatchsTotalResults(listForm);	
		//listForm.setTotalResults(total);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		listForm.setLineItems(		
				new EDIBatchBD(this.getSessionFactoryClusterMap())
					.findEDIBatchsBySearch(listForm)
					);		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());
		return null;
	}
}
