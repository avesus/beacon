package com.bureaueye.beacon.action.order;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.PopupListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;

public final class ListVendortariffSearchAction extends PopupListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("VendtarfhdrId");
		}

		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
		
	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {
		
		listForm.setLineItems(
				new VendortariffhdrBD(this.getSessionFactoryClusterMap()).vendortariffSearch(
						listForm.getSearchString1(),//vendor
						listForm.getSearchString2(),//cost
						listForm.getSearchString3(),//fromlocation
						listForm.getSearchString4(),//tolocation
						listForm.getSearchString5(),//tslocation 
						listForm.getSearchString6(),//product
						listForm.getSearchString7(),//ccy
						//listForm.getSearchString8(), stores ordermovId 						
						listForm.getSearchString9(),//unittype
						listForm.getSearchString10(),//units
						listForm.getSearchString12(),//producthazardous							
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
