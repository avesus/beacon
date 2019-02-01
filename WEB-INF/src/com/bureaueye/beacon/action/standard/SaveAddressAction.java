package com.bureaueye.beacon.action.standard;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.AddressForm;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;



public final class SaveAddressAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		AddressForm saveForm = (AddressForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();

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
		VendortariffhdrBD vendortariffhdrbd = new VendortariffhdrBD(this.getSessionFactoryClusterMap());
		CustomertariffhdrBD customertariffhdrbd = new CustomertariffhdrBD(this.getSessionFactoryClusterMap());	
		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		PihdrBD pihdrbd = new PihdrBD(this.getSessionFactoryClusterMap());

		
		Address address = addressbd.read(saveForm.getAddrkey());

		// validation - check unique key
		if (address != null && action.equals(Constants.CREATE_ACTION)) {			
			errors.add("addrkey", 
					new ActionMessage("error.record.unique"));			
		}
		
		// delete validation
		// check CUSTOMER not used on Tariff
		if (saveForm.getTypekey().equals(Constants.CUSTOMER) && action.equals(Constants.DELETE_ACTION)) {
			List customertariffhdrs = null;
			customertariffhdrs = customertariffhdrbd.findCustomertariffhdrsByAddrkey(saveForm.getAddrkey());
			if (customertariffhdrs != null && customertariffhdrs.size() > 0) {
				errors.add("addrkey",  new ActionMessage("error.cannotdelete")); 								
			}
		}

		// check VENDOR not used on Tariff
		if (saveForm.getTypekey().equals(Constants.VENDOR) && action.equals(Constants.DELETE_ACTION)) {
			List vendortariffhdrs = null;
			vendortariffhdrs = vendortariffhdrbd.findVendortariffhdrsByAddrkey(saveForm.getAddrkey());
			if (vendortariffhdrs != null && vendortariffhdrs.size() > 0) {
				errors.add("addrkey",  new ActionMessage("error.cannotdelete")); 								
			}
		}

		// delete validation 	
		if (action.equals(Constants.DELETE_ACTION)) {
			//check address is not used on order
			int countRecords=0;
			countRecords = orderhdrbd.countOrdersByCustomeraddrkey(saveForm.getAddrkey());			
			if (countRecords > 0) {
				errors.add("addrkey",  new ActionMessage("error.cannotdelete")); 								
			}
			//check address is not used on purchase invoice			
			countRecords=0;
			countRecords = pihdrbd.countPihdrsByVendoraddrkey(saveForm.getAddrkey());			
			if (countRecords > 0) {
				errors.add("addrkey",  new ActionMessage("error.cannotdelete")); 								
			}			
		}



		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}	



		if (action.equals(Constants.DELETE_ACTION)) {
			// delete parent/children
			addressbd.deleteAll(saveForm.getAddrkey(), user);			
		} else {

			if (address == null) {
				address = new Address();
			}
			BeanUtils.copyProperties(address, saveForm);

			addressbd.createOrUpdate(address, user);

			// Find the address form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			if (action.equals(Constants.CREATE_ACTION)) {
				// Reset the parameters as if it was the first time in
				//listform.setStartPage();
				listform.setSearchString1(address.getName());
				listform.setSearchString2("");
			}

		}


		//REMOVE THIS FOR THE TIME BEING - go-live for Beacon Laker NT 08feb2013
		//		if (action.equals("Create") || action.equals("Delete")) {
		// refresh datapool
		ServletContext context = session.getServletContext();


		DataPool datapool = null;
		datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
		if (datapool != null) {

			/* TODO: Remove for the time being.  The DataPool results need to be assigned to datapool context obj
			 * 				try {
				 String _methodName = "set"+saveForm.getTypekey()+"S";
				 Object _object = new DataPool();

				 // now calling method using reflection
				  DataPool.class.getMethod(_methodName, null).invoke(_object, null );

				  log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				  " Refresh DataPool: Run Method: " + _methodName+" in Class: "+_object.getClass().getName());

				  } catch (Exception e) {
				  }*/


			try {
				datapool.setADDRESSS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setADDRESSS - Exception: "+e.getMessage());					
			}



			try {
				datapool.setCONSIGNEES();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setCONSIGNEES - Exception: "+e.getMessage());					
			}
			try {
				datapool.setCUSTOMERS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setCUSTOMERS - Exception: "+e.getMessage());					
			}
			try {
				datapool.setVENDORS();	
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setVENDORS - Exception: "+e.getMessage());					
			}
			try {		
				datapool.setBROKERS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setBROKERS - Exception: "+e.getMessage());					
			}

			try {
				datapool.setSHIPPERS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setSHIPPERS - Exception: "+e.getMessage());					
			}
			try {
				datapool.setFWDAGENTS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setFWDAGENTS - Exception: "+e.getMessage());					
			}
			try {
				datapool.setAGENTS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setAGENTS - Exception: "+e.getMessage());					
			}
			try {
				datapool.setLESSEES();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setLESSEES - Exception: "+e.getMessage());					
			}
			try {
				datapool.setLESSORS();
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Datapool.setLESSORS - Exception: "+e.getMessage());					
			}


			context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,
					datapool);
			// 
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY
					+ " refreshed on ServletContext");				
		}
		//		}



		//clear objects
		addressbd = null;
		vendortariffhdrbd = null;
		customertariffhdrbd = null;
		orderhdrbd = null;
		pihdrbd = null;
		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}
}
