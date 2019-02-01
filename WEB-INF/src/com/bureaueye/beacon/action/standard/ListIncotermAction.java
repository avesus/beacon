package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.IncotermBD;

public final class ListIncotermAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Description");
		}
		
		int total = new IncotermBD(this.getSessionFactoryClusterMap()).findIncotermsTotalResults(listForm
				.getSearchString1());
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {
		
		listForm.setLineItems(new IncotermBD(this.getSessionFactoryClusterMap()).findIncotermsByIncotermkey(listForm
				.getSearchString1(), listForm.getGotoPage(), listForm
				.getMaxResults(), listForm.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
