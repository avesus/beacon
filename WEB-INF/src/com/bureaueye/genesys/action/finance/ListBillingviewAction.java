package com.bureaueye.genesys.action.finance;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;




public final class ListBillingviewAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		

		listForm.setOrderBy("FinancehdrId");
		listForm.setOrderByDesc("Asc");


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = 
				new Integer(
						new SystemcodeBD(
								this.getSessionFactoryClusterMap()
						)
						.read(new SystemcodePK("DATERANGEDAYS","LISTFINANCEHDR")).getDescr()).intValue();
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
		
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);


	}


	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {


		FinancehdrBD bd = new FinancehdrBD(this.getSessionFactoryClusterMap());
		
		// get previous billing runs
		listForm.setLineItems(null);
		listForm.setLineItems(bd.findFinancehdrsByDocdateNotManual(listForm));		

		bd=null;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}


}
