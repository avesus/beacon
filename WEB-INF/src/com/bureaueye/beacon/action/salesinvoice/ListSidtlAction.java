package com.bureaueye.beacon.action.salesinvoice;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;


public final class ListSidtlAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Chargekey");
		}	
		
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
		
		int total = 0;
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Sihdr sihdr = new SihdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(sihdr.getOrderno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(sihdr.getCreatedate())
		);
		listForm.setHeaderInfo3(sihdr.getCustomerref());
		listForm.setHeaderInfo4(
				new AddressBD(this.getSessionFactoryClusterMap()).read(sihdr.getCustomeraddrkey()).getName()
		);
		listForm.setHeaderInfo5(new Boolean(sihdr.isManualflag()).toString());
		listForm.setHeaderInfo6(
				Util.dateTextFormat2(sihdr.getPrintdate())
		);
		listForm.setHeaderInfo7(new Boolean(sihdr.isPrintedflag()).toString());	
		listForm.setHeaderInfo8(sihdr.getInvoiceccykey());
		listForm.setHeaderInfo9(sihdr.getInvoiceno());
		listForm.setHeaderInfo10(sihdr.getSihdrId().toString());
		listForm.setHeaderInfo11(sihdr.getInvoiceamt().toString());
		
		
		// set line items
		listForm.setLineItems(new SidtlBD(this.getSessionFactoryClusterMap())
				.findSidtlsById(
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
