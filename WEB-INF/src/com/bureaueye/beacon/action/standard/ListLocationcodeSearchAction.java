package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.PopupListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.LocationcodeBD;

public final class ListLocationcodeSearchAction extends PopupListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Locationcode");
		}
		
/*		listForm
				.setTotalResults(new LocationcodeBD(this.getSessionFactoryClusterMap())
						.findLocationcodesTotalResults(listForm
								.getSearchString1(), listForm
								.getSearchString2(), listForm
								.getSearchString3(), listForm
								.getSearchString4(), listForm
								.getSearchString5(), listForm
								.getSearchString6(), listForm
								.getSearchString7(), listForm
								.getSearchString8(), listForm
								.getSearchString9(), listForm
								.getSearchString10(), listForm
								.getSearchString11(), listForm
								.getSearchString12(), listForm
								.getSearchString13(), listForm
								.getSearchString14(), listForm.getHeaderInfo1()));*/
	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		
		
	}
	
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {
		
		listForm.setLineItems(new LocationcodeBD(this.getSessionFactoryClusterMap()).findLocationcodesSearch(
				listForm.getSearchString1(), listForm.getSearchString2(),
				listForm.getSearchString3(), listForm.getSearchString4(),
				listForm.getSearchString5(), listForm.getSearchString6(),
				listForm.getSearchString7(), listForm.getSearchString8(),
				listForm.getSearchString9(), listForm.getSearchString10(),
				listForm.getSearchString11(), listForm.getSearchString12(),
				listForm.getSearchString13(), listForm.getSearchString14(),
				listForm.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy(), listForm.getHeaderInfo1()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
				);
		
		return null;
	}
}