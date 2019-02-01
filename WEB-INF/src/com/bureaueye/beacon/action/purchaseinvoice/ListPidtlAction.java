package com.bureaueye.beacon.action.purchaseinvoice;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;



public final class ListPidtlAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("JobhdrId");
		}

		//set default max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
		
		// invoice status search
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1("%");
		}
		
		int total = 0;
		listForm.setTotalResults(total);
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		//init business delegates
		PihdrBD hdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
		PidtlBD dtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		
		// set header information
		Pihdr hdr = hdrbd.read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getPino());
		listForm.setHeaderInfo2(hdr.getVendorref());		
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getInvoicedate())
				);
		listForm.setHeaderInfo4(hdr.getCcykey());
		listForm.setHeaderInfo5(
				addressbd.read(hdr.getVendoraddrkey()).getName()		
				);
		try {
			listForm.setHeaderInfo6(hdr.getGrossamt().toString());
		} catch (Exception e) {
			listForm.setHeaderInfo6("0.00");
		}
		
		try {
			listForm.setHeaderInfo7(
					dtlbd.pidtlsInvoiceamtTotal(listForm.getId()).toString()
					);
		} catch (Exception e) {
			listForm.setHeaderInfo7("0.00");
		}
		listForm.setHeaderInfo8(new Boolean(hdr.isPostedflag()).toString());
		
		
		// set line items
		listForm.setLineItems(dtlbd.findPidtlsById(
						listForm.getId(),
						listForm.getSearchString1(),
						listForm.getGotoPage(), 
						listForm.getMaxResults(), 
						listForm.getOrderBy())
						);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		//clear objects
		hdr=null;
		hdrbd=null;
		dtlbd=null;
		addressbd=null;
		
		
		return null;
	}
}
