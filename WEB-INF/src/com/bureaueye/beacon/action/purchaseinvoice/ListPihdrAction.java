package com.bureaueye.beacon.action.purchaseinvoice;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;



public final class ListPihdrAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Pino");
		}


		// order by
		// Set the default ordering
		if (listForm.getOrderByDesc() == null) {
			listForm.setOrderBy("");
		}		


		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}


		// pino
		if (listForm.getSearchString1() == null) listForm.setSearchString1("");


		// vendor
		if (listForm.getSearchString3() == null || listForm.getSearchString3().equals("")) {
			listForm.setSearchString3("%");
		}
		// invoice status
		if (listForm.getSearchString4() == null || listForm.getSearchString4().equals("")) {
			listForm.setSearchString4("%");
		}		


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTPOHDR")).getDescr()).intValue();
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


	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {


		boolean processedflag = false;
		listForm.setLineItems(null);
		PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
		
		if (!listForm.getSearchString1().equals("")) {
			listForm.setLineItems(pihdrbd.findPihdrsForSearchByPino(listForm));
			processedflag = true;
		}
		if (!processedflag) {
			listForm.setLineItems(pihdrbd.findPihdrsForSearch(listForm));
		}

		pihdrbd=null;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}

}
