package com.bureaueye.beacon.action.order;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;


public final class EditCustomertariffSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm tariffsearchForm = (ListForm) form;

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditCustomertariffSearchAction: " + tariffsearchForm.getId());

		Customertariffhdr hdr = new CustomertariffhdrBD(this.getSessionFactoryClusterMap()).read(tariffsearchForm.getId());

		if (hdr == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" No Customer Tariff Header found for ID "
					+ tariffsearchForm.getId());
			// initialise parameters
			Orderhdr orderhdr = new OrderhdrBD(
									this.getSessionFactoryClusterMap()
									).read(new Integer(tariffsearchForm.getSearchString9()));
	
			//tariffsearchForm.setSearchString7(orderhdr.getProductkey());		
			tariffsearchForm.setSearchDate1(new Date());			
			
		} else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + hdr);
			tariffsearchForm.setStartPage();
			tariffsearchForm.setSearchString1(hdr.getCustomeraddrkey());
			tariffsearchForm.setSearchString2(hdr.getChargekey());
			//tariffsearchForm.setSearchString3(hdr.getFromlocationkey().getLocationkey());
			//tariffsearchForm.setSearchString4(hdr.getFromlocationkey2().getLocationkey());
			//tariffsearchForm.setSearchString5(hdr.getTolocationkey2().getLocationkey());
			//tariffsearchForm.setSearchString6(hdr.getTolocationkey().getLocationkey());			
			//tariffsearchForm.setSearchString7(hdr.getProductkey());
			tariffsearchForm.setSearchString8(hdr.getCcykey());			
			tariffsearchForm.setSearchDate1(hdr.getValidto());			
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
