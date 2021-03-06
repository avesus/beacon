package com.bureaueye.beacon.action.job;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;

public final class ListJobhdrAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Unitkey");
		}
		
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		int total = 0;
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Orderhdr orderhdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(orderhdr.getOrderno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(orderhdr.getOrderdate())
		);
		listForm.setHeaderInfo3(
				orderhdr.getCustomerref()
		);
		listForm.setHeaderInfo4(
				new AddressBD(this.getSessionFactoryClusterMap()).read(orderhdr.getCustomeraddrkey()).getName()
		);
		listForm.setHeaderInfo5(orderhdr.getOrderbyuserid());
		listForm.setHeaderInfo6("");
		try {
			listForm.setHeaderInfo6(new LocationBD(this.getSessionFactoryClusterMap()).read(orderhdr.getLdglocationkey2()).getLocationName());
		} catch (Exception e) {}
		listForm.setHeaderInfo7("");
		try {
			listForm.setHeaderInfo7(new LocationBD(this.getSessionFactoryClusterMap()).read(orderhdr.getDchlocationkey2()).getLocationName());
		} catch (Exception e) {}		
		listForm.setHeaderInfo8(orderhdr.getCcykey());
		
		
		// set line items
		listForm.setLineItems(
				new JobhdrBD(
						this.getSessionFactoryClusterMap()
				)
				.findJobhdrsById(listForm.getId(), listForm
						.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
