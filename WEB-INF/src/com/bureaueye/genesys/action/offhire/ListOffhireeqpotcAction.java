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
import com.bureaueye.genesys.model.offhire.Offhireeqp;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpBD;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpotcBD;

public final class ListOffhireeqpotcAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Unitkey");
			}

		
		int total = new OffhireeqpotcBD(this.getSessionFactoryClusterMap()).findOffhireeqpotcsTotalResults((listForm.getId()));
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Offhireeqp dtl = new OffhireeqpBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));		
		Offhire hdr = new OffhireBD(this.getSessionFactoryClusterMap()).read(dtl.getOffhireId());
		
		listForm.setHeaderInfo1(hdr.getOffhireno());
		//listForm.setHeaderInfo2(hdr.getContractno());
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
		
		listForm.setHeaderInfo7(dtl.getUnitkey());
		// set flags
		listForm.setHeaderInfo8("false");
		listForm.setHeaderInfo9("false");
		if(dtl.isBillfinish())listForm.setHeaderInfo8("true");
		if(dtl.isActualflag())listForm.setHeaderInfo9("true");
		
		
		// set line items
		listForm.setLineItems(new OffhireeqpotcBD(this.getSessionFactoryClusterMap())
				.findOffhireeqpotcsById(listForm.getId(), listForm
						.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;		
	}
}
