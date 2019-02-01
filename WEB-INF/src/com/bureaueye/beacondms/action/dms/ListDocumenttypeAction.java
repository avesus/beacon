package com.bureaueye.beacondms.action.dms;


import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;



public final class ListDocumenttypeAction extends ListAction {

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

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		listForm.setLineItems(		
				new DocumenttypeBD(this.getSessionFactoryClusterMap())
					.findDocumenttypesBySearch(listForm)
					);		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());
		return null;
	}
}
