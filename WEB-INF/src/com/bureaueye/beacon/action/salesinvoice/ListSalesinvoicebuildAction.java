package com.bureaueye.beacon.action.salesinvoice;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


public final class ListSalesinvoicebuildAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Orderdate");
		}
		
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Orderdate")) listForm.setOrderByDesc("desc");
		
		// set default field values
		// invoice status - set to READY FOR INVOICING
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1(com.bureaueye.beacon.bean.Constants.READY_STATUS);
		}
		
		
		// customer
		if (listForm.getSearchString6() == null || listForm.getSearchString6().equals("")) {
			listForm.setSearchString6("%");
		}
		
		
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTSIBUILD")).getDescr()).intValue();
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
		
		
		// set list values
		// max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		// goto page
		listForm.setGotoPage(0);
		
		// Reset the update boxes
		listForm.setSelectedObjects(null);	
		
	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
		
		//default company
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("");
			try {
				List usercompanykeylist=(List)session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USERCOMPANYKEYLIST);
				Company companydao = (Company)usercompanykeylist.iterator().next();
				listForm.setSearchString2(companydao.getCompid());
			} catch (Exception e) {
			}
		}
		
	}

	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set line items
		listForm.setLineItems(
				new OrderchargeBD(this.getSessionFactoryClusterMap()).findOrderchargesByInvoicestatus(listForm)
		);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setLineItems = " + listForm.toString());
		
		
		return null;
	}
	
}
