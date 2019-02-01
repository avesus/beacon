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
import com.bureaueye.beacon.form.standard.AddressForm;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;


public final class EditAddressAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		HttpSession session = request.getSession(false);
		AddressForm editForm = (AddressForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		String action = editForm.getAction();
		
		
		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction:  Processing " + action + " action");
		
		
		Address address = null;
		
		if (!(action == null || action.equals("Create"))) {
			
			address = new AddressBD(
					this.getSessionFactoryClusterMap()
			).read(editForm.getAddrkey());
			
			if (address == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for id "
						+ request.getParameter("id"));
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getAddrkey()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			
			try {	
				// check user has access to this address if user typekeylist is not blank
				if (!user.getTypekeylist().equals("")) {
					// change required to use Typekey List
					boolean _typekeyfound=false;
					StringTokenizer _atlSt = new StringTokenizer(address.getTypekeylist(), "|");			
					search:
						while (_atlSt.hasMoreTokens()) {
							String _at=_atlSt.nextToken();
							StringTokenizer _utlSt = new StringTokenizer(user.getTypekeylist(), "|");				
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
								" does not have access to address: "+ 
								editForm.getAddrkey()
						);
						ActionMessages errors = new ActionMessages();
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
								"error.address.nouseraccess", editForm.getAddrkey()));
						saveMessages(request, errors);
						return findFailure(mapping);
					}
				}//check user typekeylist is not blank
			} catch (Exception e) {
			}
			
		}
		
		
		
		if (!(action == null || action.equals("Create"))) {
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + address);
			
			BeanUtils.copyProperties(editForm, address);
			
			if (action.equals("Copy")) {
				editForm.setAddrkey("");
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
