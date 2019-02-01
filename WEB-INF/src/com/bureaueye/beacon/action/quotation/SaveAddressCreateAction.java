package com.bureaueye.beacon.action.quotation;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.form.quotation.QuotationAddressForm;

import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;




public final class SaveAddressCreateAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		QuotationAddressForm saveForm = (QuotationAddressForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionErrors errors = new ActionErrors();
		
		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		// Generate Business Delegate
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		
		
		Address address = new Address();

		BeanUtils.copyProperties(address, saveForm);
		address.setTypekeylist(address.getTypekey());
		

		// Perform validator framework validations		
		this.addErrorIfBlank(errors, "addrkey", saveForm.getAddrkey(), "error.code.required");
		this.addErrorIfBlank(errors, "name", saveForm.getName(), "error.name.required");
		this.addErrorIfBlank(errors, "typekey", saveForm.getTypekey(), "error.type.required");
		this.addErrorIfBlank(errors, "shortname", saveForm.getShortname(), "error.shortname.required");
		
		if (action.equals("Create")) {
			if (Util.invalidChars(saveForm.getAddrkey())) errors.add("addrkey", new ActionMessage("error.code.invalidchars"));
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Validation Errors: "+!errors.isEmpty());
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			//log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to page: "+findFailure(mapping));			
			return (findFailure(mapping));
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			//log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to page: "+findFailure(mapping));
			return (findFailure(mapping));
		}	
	
		addressbd.createOrUpdate(address, user);

		
		// update quotation with new address	
		Quohdr quohdr = quohdrbd.read(new Integer(saveForm.getId()));		
		if (quohdr  != null) {
			quohdr.setCustomeraddrkey(address.getAddrkey());
			quohdr.setCustomername(address.getName());
			quohdr.setCustomeraddr1(address.getAddr1());
			quohdr.setCustomeraddr2(address.getAddr2());
			quohdr.setCustomeraddr3(address.getAddr3());
			quohdr.setCustomeraddr4(address.getAddr4());
			quohdr.setCustomeraddr5(address.getAddr5());
			quohdr.setCustomertelno(address.getTelno1());
			quohdr.setCustomerfaxno(address.getFaxno1());
			quohdr.setCustomeremail(address.getEmailno());			
			quohdrbd.createOrUpdate(quohdr, user);
		}
		
		
		// refresh datapool
		ServletContext context = session.getServletContext();
		
		DataPool datapool = null;
		datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
		if (datapool != null) {

			datapool.setADDRESSS();
			
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.CONSIGNEE)) datapool.setCONSIGNEES();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.CUSTOMER)) datapool.setCUSTOMERS();			
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.VENDOR)) datapool.setVENDORS();			
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.BROKER)) datapool.setBROKERS();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.SHIPPER)) datapool.setSHIPPERS();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.FWDAGENT)) datapool.setFWDAGENTS();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.AGENT)) datapool.setAGENTS();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.LESSEE)) datapool.setLESSEES();
			if (saveForm.getTypekey().equals(com.bureaueye.beacon.bean.Constants.LESSOR)) datapool.setLESSORS();

			
			context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,
					datapool);
			// 
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY
					+ " refreshed on ServletContext");				
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}

	
	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}
	
}
