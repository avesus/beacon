package com.bureaueye.beacon.action.dsactivity;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.dsactivity.bd.DsingateBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;



public final class ListDsingateAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Indate");
		}

		if (listForm.getOrderBy().equals("Indate")) listForm.setOrderByDesc("Desc");


		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}


		// eirin
		if (listForm.getSearchString1() == null) listForm.setSearchString1("");


		// customer
		if (listForm.getSearchString3() == null || listForm.getSearchString3().equals("")) {
			listForm.setSearchString3("%");
		}

		// depot
		if (listForm.getSearchString4() == null || listForm.getSearchString4().equals("")) {
			listForm.setSearchString4("%");
		}
		
		

		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTDSINGATE")).getDescr()).intValue();
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


		boolean processedflag = false;
		listForm.setLineItems(null);
		if (!listForm.getSearchString1().equals("")) {
			listForm.setLineItems(new DsingateBD(this.getSessionFactoryClusterMap()).findDsingatesForSearchByEirin(listForm));
			processedflag = true;
		}
		if (!processedflag) {
			listForm.setLineItems(new DsingateBD(this.getSessionFactoryClusterMap()).findDsingatesForSearch(listForm));
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}

}
