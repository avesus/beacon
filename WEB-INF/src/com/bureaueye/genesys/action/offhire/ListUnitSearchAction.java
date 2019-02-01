package com.bureaueye.genesys.action.offhire;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.PopupListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;


public final class ListUnitSearchAction extends PopupListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {

		}
	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {
		
		listForm.setLineItems(
				new OffhireBD(this.getSessionFactoryClusterMap()).unitOffhireSearch(
						listForm.getSearchString1(), 
						listForm.getSearchString2(),
						listForm.getSearchString3(), 
						listForm.getSearchString4(),
						listForm.getSearchString5(), 
						listForm.getSearchString6(),
						listForm.getSearchString7(), 
						listForm.getSearchString8(),
						listForm.getSearchString9(), 
						listForm.getSearchString10(),
						listForm.getSearchString11(), 
						listForm.getSearchString12(),
						listForm.getSearchString13(), 
						listForm.getSearchString14(),
						listForm.getGotoPage(), 
						listForm.getMaxResults(), 
						listForm.getOrderBy(), 
						listForm.getHeaderInfo1(),
						listForm.getHeaderInfo3(),
						listForm.getHeaderInfo4(),
						listForm.getHeaderInfo5()
						)
					);
	
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
				);
		
		return null;
	}
}
