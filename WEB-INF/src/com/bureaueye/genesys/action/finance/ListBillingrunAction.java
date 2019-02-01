package com.bureaueye.genesys.action.finance;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;




public final class ListBillingrunAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
		listForm.setOrderBy("FinancehdrId");
		listForm.setOrderByDesc("Asc");
		
		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' 
			
			Financehdr financehdr = null;
			Calendar c = Calendar.getInstance();
			try {
				financehdr = 
					new FinancehdrBD(this.getSessionFactoryClusterMap())
					.findLastFinancehdrByDocdate();
			} catch (ApplicationException ae) {}
			
			if (financehdr != null) {
				// set to last billing date plus 1 month
				try {
					c.setTime(financehdr.getDocdate());
					c.add(Calendar.MONTH, 1);
				} catch (Exception e) {
				}				
			} 
			
			try {
					listForm.setSearchDate1(c.getTime());
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
		listForm.setLineItems(bd.findFinancehdrsByDocdateNotManual(listForm)
		);		
		
		bd=null;
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
	
	
}
