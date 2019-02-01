package com.bureaueye.beacon.action.job;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.util.Util;


public final class ListJobmovAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			//listForm.setOrderBy("Estfromdate");
			listForm.setOrderBy("Totimeinmillis");
			listForm.setOrderByDesc("asc");				
		}
		if (listForm.getOrderBy2() == null) {
			//listForm.setOrderBy("Esttodate");
			listForm.setOrderBy2("Fromtimeinmillis");
			listForm.setOrderBy2Desc("asc");
		}

		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		int total=0;
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}

	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Jobhdr jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		Orderhdr orderhdr = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(jobhdr.getOrderhdrId());

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
		listForm.setHeaderInfo6(jobhdr.getUnitkey());
		listForm.setHeaderInfo7(jobhdr.getMovref());
		listForm.setHeaderInfo8(
				new ProductBD(this.getSessionFactoryClusterMap()).read(jobhdr.getProductkey()).getTradname()
		);
		listForm.setHeaderInfo9(jobhdr.getJobno());
		listForm.setHeaderInfo10(jobhdr.getOrderhdrId().toString());
		
		// set line items
		listForm.setLineItems(
				new JobmovBD(
						this.getSessionFactoryClusterMap()
				)
				.findJobmovsById(
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
