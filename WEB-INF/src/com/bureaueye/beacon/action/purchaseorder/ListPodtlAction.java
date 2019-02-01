package com.bureaueye.beacon.action.purchaseorder;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;



public final class ListPodtlAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Eqpkeyp1");
		}

		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);

		int total = 0;
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}

	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Pohdr hdr = new PohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));

		listForm.setHeaderInfo1(hdr.getPono());
		listForm.setHeaderInfo2(hdr.getDepartmentkey());
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getDeliverydate())
		);
		listForm.setHeaderInfo4(hdr.getCcykey());
		listForm.setHeaderInfo5(
				new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getVendoraddrkey()).getName()		
		);
		try {
			listForm.setHeaderInfo6(
					new LocationBD(this.getSessionFactoryClusterMap()).read(hdr.getShiptolocationkey()).getLocationName()
			);
		} catch (Exception e) {}		


		// set line items
		listForm.setLineItems(new PodtlBD(this.getSessionFactoryClusterMap())
		.findPodtlsById(
				listForm.getId(), 
				listForm.getGotoPage(), 
				listForm.getMaxResults(), 
				listForm.getOrderBy())
		);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}
}
