package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Usergroup;
import com.bureaueye.beacon.model.standard.bd.UsergroupBD;
import com.bureaueye.beacon.model.standard.bd.UsergroupmenuBD;




public final class ListUsergroupmenuAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Menuid");
		}
		
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
		int total = 0;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Usergroup header = new UsergroupBD(this.getSessionFactoryClusterMap()).read(listForm.getId());		
		listForm.setHeaderInfo1(header.getUsergroupid());
		
		// set line items
		listForm.setLineItems(new UsergroupmenuBD(this.getSessionFactoryClusterMap()).findUsergroupmenusBySearch(listForm));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
