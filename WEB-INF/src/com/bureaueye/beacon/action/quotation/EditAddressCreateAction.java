package com.bureaueye.beacon.action.quotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.quotation.QuotationAddressForm;

import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;



public final class EditAddressCreateAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		QuotationAddressForm editForm = (QuotationAddressForm) form;
		
		Quohdr dto = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getId()));
		
		if (dto == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quohdr found for Id: "
					+ editForm.getId());
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.record.deleted", editForm.getId()));
			saveMessages(request, errors);
			return findFailure(mapping);
		}
		
		editForm.setAddrkey("");
		editForm.setAction("Create");
		editForm.setTypekey(Constants.CUSTOMER);
		editForm.setName(dto.getCustomername());
		editForm.setShortname(dto.getCustomername());
		editForm.setAddr1(dto.getCustomeraddr1());
		editForm.setAddr2(dto.getCustomeraddr2());
		editForm.setAddr3(dto.getCustomeraddr3());		
		editForm.setAddr4(dto.getCustomeraddr4());
		editForm.setEmailno(dto.getCustomeremail());
		editForm.setTelno1(dto.getCustomertelno());
		editForm.setFaxno1(dto.getCustomerfaxno());
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction:  Processing " 
				+ editForm.getAction() + " action");
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
	}
}
