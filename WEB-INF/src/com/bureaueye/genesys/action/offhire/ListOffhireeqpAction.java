package com.bureaueye.genesys.action.offhire;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.model.offhire.Offhire;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpBD;



public final class ListOffhireeqpAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Unitkey");
			}

		int total = new OffhireeqpBD(this.getSessionFactoryClusterMap()).findOffhireeqpsTotalResults((listForm.getId()));
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Offhire hdr = new OffhireBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getOffhireno());
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getSubmitteddate())
				);
		listForm.setHeaderInfo4(new LocationBD(this.getSessionFactoryClusterMap()).read(hdr.getLocationkey()).getLocationName());
		listForm.setHeaderInfo5(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getLesseeaddrkey()).getName());		
		
		// set line items
		listForm.setLineItems(new OffhireeqpBD(this.getSessionFactoryClusterMap())
				.findOffhireeqpsById(
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
