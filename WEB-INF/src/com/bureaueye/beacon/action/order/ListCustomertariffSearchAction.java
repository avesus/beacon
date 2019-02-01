package com.bureaueye.beacon.action.order;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.PopupListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;

public final class ListCustomertariffSearchAction extends PopupListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("CusttarfhdrId");
		}

		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
		
	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {
		
		listForm.setLineItems(
				new CustomertariffhdrBD(this.getSessionFactoryClusterMap()).customertariffSearch(
						listForm.getSearchString1(),
						listForm.getSearchString2(), 
						listForm.getSearchString3(), 
						listForm.getSearchString4(), 
						listForm.getSearchString5(), 
						listForm.getSearchString6(), 
						listForm.getSearchString7(),
						listForm.getSearchString8(),						
						//listForm.getSearchString9(), // stores orderhdrId 
						listForm.getSearchString10(),
						listForm.getSearchString11(),
						listForm.getGotoPage(),
						listForm.getMaxResults(), 
						listForm.getOrderBy()						
						)
					);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
				);
		
		return null;
	}
}
