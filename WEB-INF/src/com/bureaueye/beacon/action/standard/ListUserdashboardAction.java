package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.model.standard.bd.UserdashboardBD;


/**
 * Amendments
 * ----------
 * 												
 */
public final class ListUserdashboardAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Dashboardid");
		}
		
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		User header = new UserBD(this.getSessionFactoryClusterMap()).read(listForm.getId());		
		listForm.setHeaderInfo1(header.getUserid());
		
		// set line items
		listForm.setLineItems(new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardsBySearch(listForm));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
