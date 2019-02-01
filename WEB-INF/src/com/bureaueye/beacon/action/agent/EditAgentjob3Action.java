package com.bureaueye.beacon.action.agent;


import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.agent.AgentjobForm;
import com.bureaueye.beacon.formatter.DateFormatter;

import com.bureaueye.beacon.model.standard.User;





public final class EditAgentjob3Action extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession();
		AgentjobForm editForm = (AgentjobForm) form;
		String action = editForm.getAction();
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
			return mapping.findForward("beaconmenu");
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		
		
		// init dao

		
		
		// business validation

		

		// field validation
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    				editForm.getLdgfromdateyyyy()+"-"+
    				editForm.getLdgfromdatemm()+"-"+ 
    				editForm.getLdgfromdatedd()
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("ldgfromdatedd", new ActionMessage("error.ldgdate.required")); 
        
        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    				editForm.getDchfromdateyyyy()+"-"+
    				editForm.getDchfromdatemm()+"-"+ 
    				editForm.getDchfromdatedd()
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("dchfromdatedd", new ActionMessage("error.dchdate.required")); 
        
        try {
    		Calendar calendarLdgfromDate = Calendar.getInstance();
    		calendarLdgfromDate.set(
    				Integer.parseInt(editForm.getLdgfromdateyyyy()), 
    				Integer.parseInt(editForm.getLdgfromdatemm()) - 1, 
    				Integer.parseInt(editForm.getLdgfromdatedd()),
    				Integer.parseInt(editForm.getLdgfromtimehh()),
    				Integer.parseInt(editForm.getLdgfromtimemm()),
    				0
    				);		
    		Calendar calendarDchfromDate = Calendar.getInstance();
    		calendarDchfromDate.set(
    				Integer.parseInt(editForm.getDchfromdateyyyy()), 
    				Integer.parseInt(editForm.getDchfromdatemm()) - 1, 
    				Integer.parseInt(editForm.getDchfromdatedd()),
    				Integer.parseInt(editForm.getDchfromtimehh()),
    				Integer.parseInt(editForm.getDchfromtimemm()),
    				0
    				);	
            if (calendarDchfromDate.before(calendarLdgfromDate))
                errors.add("dchfromdatedd",
                        new ActionMessage("error.dchdate.afterldgdate"));             
        } catch (Exception e) {} 
        
		addErrorIfBlank(errors, "unitkey", editForm.getUnitkey(), "error.unitkey.required");
		addErrorIfBlank(errors, "incotermkey", editForm.getIncotermkey(), "error.incoterm.required");
		
        
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return findFailure(mapping);
		}
		
		
		
		// intialise form
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	private void addErrorIfBlank(ActionMessages errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}
	
	
}
