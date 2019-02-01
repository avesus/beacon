package com.bureaueye.beacon.action.mandr;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrdtlBD;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;
import com.bureaueye.beacon.util.Util;


public final class ListMandrdtlAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Itemno");
		}

		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
		
		listForm.setGotoPage(0);
		
		
		int total = 0; 
		listForm.setTotalResults(total);
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Mandrhdr mandrhdrdao = new MandrhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(mandrhdrdao.getMandrno());
		listForm.setHeaderInfo2(mandrhdrdao.getVersionno().toString());
		listForm.setHeaderInfo3(mandrhdrdao.getEstimateref());
		listForm.setHeaderInfo4(mandrhdrdao.getCreateuserid());
		listForm.setHeaderInfo5(mandrhdrdao.getMoveref());
		listForm.setHeaderInfo6(Util.dateTextFormat2(mandrhdrdao.getEstimatedate()));
		listForm.setHeaderInfo8(mandrhdrdao.getCcykey());
		listForm.setHeaderInfo9(mandrhdrdao.getMandrstatus());
		listForm.setHeaderInfo10(mandrhdrdao.getMandrhdrId().toString());
		listForm.setHeaderInfo11(mandrhdrdao.getUnitkey());
		listForm.setHeaderInfo12(mandrhdrdao.getTotalamt().toString());
		listForm.setHeaderInfo13(mandrhdrdao.getLaboramt().toString());
		listForm.setHeaderInfo14(mandrhdrdao.getMaterialamt().toString());
		listForm.setHeaderInfo15(mandrhdrdao.isLastversionflag()+"");
		
		// set line items
		listForm.setLineItems(new MandrdtlBD(this.getSessionFactoryClusterMap())
				.findMandrdtlsById(
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
