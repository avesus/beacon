package com.bureaueye.beacon.action.standard;

import java.util.StringTokenizer;

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
import com.bureaueye.beacon.form.standard.LocationForm;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.LocationBD;

public final class EditLocationAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HttpSession session = request.getSession(false);
		LocationForm editForm = (LocationForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		String action = editForm.getAction();
		
		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction:  Processing " + action + " action");
		
		
		Location dto = null; 
		
		if (!(action == null || action.equals("Create"))) {
			
			dto = new LocationBD(this.getSessionFactoryClusterMap()).read(editForm.getLocationkey());
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Location found for id "
						+ request.getParameter("id"));
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getLocationkey()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			
			try {
				// check user has access to this location if user locationtypelist is not blank
				if (!user.getLocationtypelist().equals("")) {
					// change required to use locationtype List
					boolean _typekeyfound=false;
					StringTokenizer _atlSt = new StringTokenizer(dto.getLocationtypelist(), "|");			
					search:
						while (_atlSt.hasMoreTokens()) {
							String _at=_atlSt.nextToken();
							StringTokenizer _utlSt = new StringTokenizer(user.getLocationtypelist(), "|");				
							// many types selection with type list
							while (_utlSt.hasMoreTokens()) {
								String _ut = _utlSt.nextToken();					
								if (_at.equals(_ut)) {						
									_typekeyfound=true;
									break search;//break from this loop and main loop
								}
							}
						}
					if (!_typekeyfound) {
						log.debug(
								"["+this.getClass().getName()+"] "+new java.util.Date()+
								" User:"+
								user.getUserid()+
								" does not have access to location: "+ 
								editForm.getLocationkey()
						);
						ActionMessages errors = new ActionMessages();
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
								"error.location.nouseraccess", editForm.getLocationkey()));
						saveMessages(request, errors);
						return findFailure(mapping);
					}
				}//check user locationtypelist is not blank
			} catch (Exception e) {
			}
			
		}
		
		
		
		if (!(action == null || action.equals("Create"))) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);
			
			BeanUtils.copyProperties(editForm, dto);
			
			if (action.equals("Copy")) {
				editForm.setLocationkey("");
				editForm.setAction("Create");
				
				//do not copy g-codes as it creates a problem 
				//with the initialisation
				editForm.setG1codekey("");
				editForm.setG2codekey("");	
				editForm.setG3codekey("");	
				editForm.setG4codekey("");
			}
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
	}
}
