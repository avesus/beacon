package com.bureaueye.beacon.action.mandr;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;



public final class ListMandrhdrAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Mandrno");
		}
		
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
		
		listForm.setGotoPage(0);
		
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Createdate")) listForm.setOrderByDesc("desc");
		
		// set default field values	
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("CURRENT");
		}
		
		
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTSIHDR")).getDescr()).intValue();
		}catch(Exception e){}			
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
		

		
		int total = 0;
		listForm.setTotalResults(total);
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {
		
		listForm.setLineItems(null);
		listForm.setLineItems(new MandrhdrBD(this.getSessionFactoryClusterMap()).findMandrhdrsForSearch(listForm));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()
				+ " setLineItems = "+listForm.toString()
		);
		return null;
		
	}
	
}
