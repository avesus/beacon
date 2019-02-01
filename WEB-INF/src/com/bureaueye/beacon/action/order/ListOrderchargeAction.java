package com.bureaueye.beacon.action.order;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;

public final class ListOrderchargeAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Chargekey");
		}
		
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);	
		
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
		
		listForm.setHeaderInfo9(orderhdr.isCompleteflag()+"");
		
		// set line items
		listForm.setLineItems(
				new OrderchargeBD(
						this.getSessionFactoryClusterMap()
				)
				.findOrderchargesById(listForm.getId(), listForm
						.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}
