package com.bureaueye.beacon.action.salesinvoice;



import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;





public final class ListSidocnoAction extends ListAction {

	@Override
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering

			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Doctype");
			}

		// order by
		listForm.setOrderByDesc("");
		
		// set default field values
	
	
		int total = 0;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
	}

	@Override
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	@Override
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		listForm.setLineItems(		
				new SidocnoBD(this.getSessionFactoryClusterMap())
					.findSidocnosBySearch(listForm)
					);		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());
		return null;
	}
}
