package com.bureaueye.beacon.action.account;


import java.util.Calendar;

import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.account.bd.AioutBD;



/**
 *
 * Amendments
 * ----------
 *									
 */
public final class ListAIOutAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("AIOUT_ID");
		}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Createdate")) listForm.setOrderByDesc("desc");
		if (listForm.getOrderBy().equals("Sentdate")) listForm.setOrderByDesc("desc");

		// set default field values
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		// type
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1("%");
		}		
		// status
		if (listForm.getSearchString9() == null || listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("%");
		}


		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-30);			
			// default 'from' date to today minus 30
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 30 
			c.add(Calendar.DATE,30);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}

		Calendar c2 = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate3() == null) {
			c2.add(Calendar.DATE,-30);			
			// default 'from' date to today minus 30
			try {
				listForm.setSearchDate3(c2.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate4() == null) {			
			// default 'to' date plus 30 
			c2.add(Calendar.DATE,30);
			try {
				listForm.setSearchDate4(c2.getTime());
			} catch (Exception e) {
			}								
		}

	}

	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {	

		AioutBD bd = new  AioutBD(this.getSessionFactoryClusterMap());
		listForm.setLineItems(		
				bd.findAIOutsBySearch(listForm)
		);		
		bd = null; 

		return null;
	}


}
