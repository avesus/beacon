package com.bureaueye.beacon.action.salesinvoice;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


public final class ListDemurrageinvoicebuildAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Jobno");
		}
		
		// order by
		listForm.setOrderByDesc("");
		
		
		
		// customer
		if (listForm.getSearchString6() == null || listForm.getSearchString6().equals("")) {
			listForm.setSearchString6("%");
		}

		// demurrage start section
		if (listForm.getSearchString10() == null || listForm.getSearchString10().equals("")) {
			String demurrageStartSectionCode = "";
			try{
				demurrageStartSectionCode = 
					new SystemcodeBD(this.getSessionFactoryClusterMap()).read(
							new SystemcodePK("DEMURRAGE","STARTSECTIONKEY")
							).getDescr();
			}catch(Exception e){}	
			listForm.setSearchString10(demurrageStartSectionCode);
		}
		
		// demurrage end section
		if (listForm.getSearchString11() == null || listForm.getSearchString11().equals("")) {
			String demurrageEndSectionCode = "";
			try{
				demurrageEndSectionCode = 
					new SystemcodeBD(this.getSessionFactoryClusterMap()).read(
							new SystemcodePK("DEMURRAGE","ENDSECTIONKEY")
							).getDescr();
			}catch(Exception e){}	
			listForm.setSearchString11(demurrageEndSectionCode);
		}
		
		// set query demurrage finish flag
		listForm.setSearchString12("N");
		
		// set demurrage invoice upto date
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 0;		
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}
		
		
		// set list values
		// max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		// goto page
		listForm.setGotoPage(0);
		
		// Reset the update boxes
		listForm.setSelectedObjects(null);	
		
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set line items
		listForm.setLineItems(
				new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovsForDemurrage(listForm)
		);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setLineItems = " + listForm.toString());
		
		
		return null;
	}
}
