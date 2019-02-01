package com.bureaueye.genesys.action.finance;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancedtlBD;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;



public final class ListFinancedtlAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Doclineno");
		}
		
		int total = new FinancedtlBD(this.getSessionFactoryClusterMap())
						.findFinancedtlsTotalResults((listForm.getId()));
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Financehdr hdr = new FinancehdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getContractno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(hdr.getCreatedate())
		);
		listForm.setHeaderInfo3(hdr.getInvoiceref());
		listForm.setHeaderInfo4(
				new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getLesseeaddrkey()).getName()
		);
		listForm.setHeaderInfo5(new Boolean(hdr.isManualflag()).toString());
		listForm.setHeaderInfo6(hdr.getDoctypekey());
		listForm.setHeaderInfo7(new Boolean(hdr.isPrintedflag()).toString());	
		listForm.setHeaderInfo8(hdr.getCcykey());
		listForm.setHeaderInfo9(hdr.getDockey());
		listForm.setHeaderInfo10(hdr.getFinancehdrId().toString());
		listForm.setHeaderInfo11(hdr.getNetamount().toString());

		
		
		// set line items
		listForm.setLineItems(new FinancedtlBD(this.getSessionFactoryClusterMap())
				.findFinancedtlsById(
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
