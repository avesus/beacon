package com.bureaueye.beacon.action.order;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdernotecustBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;


/**
 * 
 * Amendments
 * ----------
 * 												
 */
public final class ListOrdernotecustAction extends ListAction {
	
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
		Orderhdr hdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getOrderno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(hdr.getOrderdate())
		);
		listForm.setHeaderInfo3(
				hdr.getCustomerref()
		);
		listForm.setHeaderInfo4(
				new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getCustomeraddrkey()).getName()
		);
		listForm.setHeaderInfo5(hdr.getOrderbyuserid());
		
		
		
		// set line items
		listForm.setLineItems(new OrdernotecustBD(this.getSessionFactoryClusterMap())
				.findOrdernotecustsById(
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
