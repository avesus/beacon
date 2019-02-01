package com.bureaueye.beacon.action.quotation;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;

public final class ListQuomovcostAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Costkey");
		}
		
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
		
		int total =0;
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Quomov quomov = new QuomovBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		Quohdr quohdr = new QuohdrBD(this.getSessionFactoryClusterMap()).read(quomov.getQuohdrId());
		
		listForm.setHeaderInfo1(quohdr.getQuotno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(quohdr.getQuotedate())
		);
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(quohdr.getExpirydate())
		);
		listForm.setHeaderInfo4(quohdr.getCustomername());
		listForm.setHeaderInfo5(quohdr.getQuotebyuserid());
		listForm.setHeaderInfo6("");
		try {
			listForm.setHeaderInfo6(new LocationBD(this.getSessionFactoryClusterMap()).read(quomov.getFromlocationkey()).getLocationName());
		} catch (Exception e) {}
		listForm.setHeaderInfo7("");
		try {
			listForm.setHeaderInfo7(new LocationBD(this.getSessionFactoryClusterMap()).read(quomov.getTolocationkey()).getLocationName());
		} catch (Exception e) {}			
		listForm.setHeaderInfo8(quohdr.getCcykey());
		
		
		
		// set line items
		listForm.setLineItems(new QuocostBD(this.getSessionFactoryClusterMap())
				.findQuomovcostsById(listForm.getId(), listForm
						.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;		
	}
}
