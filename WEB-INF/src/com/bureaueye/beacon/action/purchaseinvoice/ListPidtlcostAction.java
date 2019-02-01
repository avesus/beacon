package com.bureaueye.beacon.action.purchaseinvoice;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;



public final class ListPidtlcostAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Costkey");
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
		PidtlcostBD dtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());		
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		
		// set header information
		Pidtl dtl = dtlbd.read(new Integer(listForm.getId()));
		Pihdr hdr = hdrbd.read(dtl.getPihdrId());
		
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
			listForm.setHeaderInfo6(hdr.getNetamt().toString());
		} catch (Exception e) {
			listForm.setHeaderInfo6("0.00");
		}
		
		try {
			listForm.setHeaderInfo7(
					dtlbd.read(dtl.getPidtlId()).getInvoiceamt().toString()
					//new PidtlBD(this.getSessionFactoryClusterMap())
					//	.pidtlsInvoiceamtTotal(dtl.getPihdrId().toString()).toString()
					);
		} catch (Exception e) {
			listForm.setHeaderInfo7("0.00");
		}

		listForm.setHeaderInfo8(dtl.getJobno());
		listForm.setHeaderInfo9(dtl.getOrderno());
		listForm.setHeaderInfo10(new Boolean(hdr.isPostedflag()).toString());
		
			
		// set line items
		listForm.setLineItems(
				dtlcostbd.findPidtlcostsById(
										listForm.getId(),
										0,
										listForm.getMaxResults(),
										listForm.getOrderBy()
										)
									);
	
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		
		//clear objects
		dtl=null;		
		hdr=null;
		hdrbd=null;
		dtlbd=null;
		dtlcostbd=null;
		addressbd=null;
		
		
		return null;
	}
}
