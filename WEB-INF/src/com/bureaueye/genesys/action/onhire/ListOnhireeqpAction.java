package com.bureaueye.genesys.action.onhire;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;
import com.bureaueye.genesys.model.onhire.bd.OnhireeqpBD;



public final class ListOnhireeqpAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Unitkey");
			}

		int total = new OnhireeqpBD(this.getSessionFactoryClusterMap()).findOnhireeqpsTotalResults((listForm.getId()));
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Onhire hdr = new OnhireBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getOnhireno());
		listForm.setHeaderInfo2(hdr.getContractno());
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getSubmitteddate())
				);
		
		listForm.setHeaderInfo4("");
		try {
			listForm.setHeaderInfo4(new LocationBD(this.getSessionFactoryClusterMap()).read(hdr.getLocationkey()).getLocationName());
		} catch (Exception e) {}
		
		listForm.setHeaderInfo5("");
		try {
			listForm.setHeaderInfo5(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getLesseeaddrkey()).getName());
		} catch (Exception e) {}		
				
		listForm.setHeaderInfo6(hdr.getEqpkeyp1()+"/"+hdr.getEqpkeyp2());		
		
		// set line items
		listForm.setLineItems(new OnhireeqpBD(this.getSessionFactoryClusterMap())
				.findOnhireeqpsById(
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
