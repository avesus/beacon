package com.bureaueye.beacon.action.standard;

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
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.form.standard.CustomertariffhdrForm;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;

public final class SaveCustomertariffhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		CustomertariffhdrForm customertariffhdrform = (CustomertariffhdrForm) form;
		String action = customertariffhdrform.getAction();
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
		CustomertariffhdrBD customertariffhdrbd = new CustomertariffhdrBD(this.getSessionFactoryClusterMap());

		// find record
		Customertariffhdr customertariffhdr = customertariffhdrbd
				.read(customertariffhdrform.getCusttarfhdrId());
		// validation 
		if (customertariffhdr != null && action.equals("Create")) {			
			errors.add("custtarfhdrId", 
					new ActionMessage("error.record.unique"));			
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
		
		
		if (action.equals("Delete")) {
			customertariffhdrbd.delete(new Customertariffhdr(
					customertariffhdrform.getCusttarfhdrId()), user);
		} else {
			
			if (customertariffhdr == null) {
				customertariffhdr = new Customertariffhdr();
			}		
			BeanUtils.copyProperties(customertariffhdr, customertariffhdrform);

			customertariffhdrbd.createOrUpdate(customertariffhdr, user);

			// Find the ListCustomertariffhdrForm and reset to first page
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveCustomertariffhdrAction: createOrUpdate " + "List"
					+ mapping.getName());		
		}

		
		//UPDATE DASHBOARD POOL========================================================>		
		// check dashboard pool already exists
		DashboardPool pool = DashboardPool.getPool(session);
		if (pool!=null) {
		
			//CUSTOMER_TARIFFS_EXPIRING
			try {
				pool.setCUSTOMER_TARIFFS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"CUSTOMER_TARIFFS_EXPIRING - Exception: "+e.getMessage());					
			}				

			//store dashboard pool in user's session
			DashboardPool.setPool(session, pool);

		}//if (pool==null) {
		//UPDATE DASHBOARD POOL========================================================<
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
