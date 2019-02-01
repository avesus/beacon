package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;


public final class ListG3codeAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
	
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("G3codekey");
			listForm.setOrderByDesc("");
		}
		
		listForm.setTotalResults(0);
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);			
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {
	
		listForm.setLineItems(new G3codeBD(this.getSessionFactoryClusterMap()).findG3codesBySearch(listForm));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
