package com.bureaueye.beacon.action.standard;


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
import com.bureaueye.beacon.form.standard.LocationForm;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.LocationBD;



/**
 *
 * Amendments
 * ----------
 *
 * NT	2010-04-02		201000017		Location Maintenance - Sychronize update of Locationcode and portunicon fields
 * 												
 */
public final class SaveLocationAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		LocationForm locationForm = (LocationForm) form;
		String action = locationForm.getAction();
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Processing " + action	+ " action");

		// Generate Business Delegate
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());


		// find record
		Location location = locationbd.read(locationForm.getLocationkey());

		// validation - check unique key
		if (location != null && action.equals(Constants.CREATE_ACTION)) {			
			errors.add("locationkey", 
					new ActionMessage("error.record.unique"));			
		}

		// delete validation - check location is not used on order		
		if (action.equals(Constants.DELETE_ACTION)) {
			int countOrders=0;
			countOrders = orderhdrbd.countOrdersByLdglocationkey2(locationForm.getLocationkey());
			if (countOrders > 0) {
				errors.add("locationkey",  new ActionMessage("error.cannotdelete")); 								
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
			locationbd.delete(new Location(
					locationForm.getLocationkey()), user);
		} else {

			if (location == null) {
				location = new Location();
			}		
			BeanUtils.copyProperties(location, locationForm);


			// temp code - these fields should be removed
			location.setDescription1(location.getCountry());
			location.setDescription2(location.getCity());
			location.setDescription3("");

			//sychronize update
			location.setPortUnicon(location.getLocationcode());//201000017

			locationbd.createOrUpdate(location, user);

			// Find the ListLocationForm and reset to first page
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveLocationAction: createOrUpdate " + "List"
					+ mapping.getName());
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			if (action.equals(Constants.CREATE_ACTION)) {
				// Reset the parameters as if it was the first time in
				//listform.setStartPage();
				listform.setSearchString1(location.getLocationName());
				listform.setSearchString2("");
			}			

		}


		//REMOVE THIS FOR THE TIME BEING - go-live for Beacon Laker NT 08feb2013		
		//if (action.equals("Create") || action.equals("Delete")) {
		// refresh datapool
		ServletContext context = session.getServletContext();			
		DataPool datapool = null;
		datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
		if (datapool != null) {

			/* TODO: Remove for the time being.  The DataPool results need to be assigned to datapool context obj
			 * 				try {
				 String _methodName = "set"+locationForm.getLocationType()+"S";
				 Object _object = new DataPool();

				 // now calling method using reflection
				  DataPool.class.getMethod(_methodName, null).invoke(_object, null );

				  log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				  " Refresh DataPool: Run Method: " + _methodName+" in Class: "+_object.getClass().getName());

				  } catch (Exception e) {
				  }*/

			datapool.setLocations();

			datapool.setPORTS();
			datapool.setPLANTS();			
			datapool.setPIERS();			
			datapool.setDEPOTS();	

			datapool.setDeliverylocations1();
			datapool.setPickuplocations1();
			datapool.setDeliverylocations2();
			datapool.setPickuplocations2();

			context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,	datapool);
			// 
			log.info(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY+" refreshed on ServletContext");				
		}
		//}

		
		//clear objects
		locationbd = null;
		orderhdrbd = null;


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
