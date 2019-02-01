package com.bureaueye.beacon.action.quotation;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuofileBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;

public final class ListQuofileAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Createdate");
			}

		if (listForm.getOrderBy2() == null) {
				listForm.setOrderBy2("Createtime");			
		}	
		
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
		
		int total = 0;
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Quohdr quohdr = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(quohdr.getQuotno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(quohdr.getQuotedate())
				);
		listForm.setHeaderInfo3(
				quohdr.getCustomerref()
				);
		listForm.setHeaderInfo4(
				new AddressBD(this.getSessionFactoryClusterMap()).read(quohdr.getCustomeraddrkey()).getName()
				);
		listForm.setHeaderInfo5(quohdr.getQuotebyuserid());
		listForm.setHeaderInfo6("");
		try {
			listForm.setHeaderInfo6(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getLdglocationkey2()).getLocationName());
		} catch (Exception e) {}
		listForm.setHeaderInfo7("");
		try {
			listForm.setHeaderInfo7(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getDchlocationkey2()).getLocationName());
		} catch (Exception e) {}		
		listForm.setHeaderInfo8(quohdr.getCcykey());


		
		// set line items
		listForm.setLineItems(new QuofileBD(this.getSessionFactoryClusterMap())
							.findQuofilesById(
									listForm.getId(), 
									listForm.getGotoPage(), 
									listForm.getMaxResults(), 
									listForm.getOrderBy(),
									listForm.getOrderBy2()									
									)
								);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		
		return null;
	}
}
