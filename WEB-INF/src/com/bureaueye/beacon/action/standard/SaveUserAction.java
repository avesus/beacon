package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.UserForm;


import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.Userdashboard;
import com.bureaueye.beacon.model.standard.Usermenu;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;
import com.bureaueye.beacon.model.standard.bd.UserdashboardBD;
import com.bureaueye.beacon.model.standard.bd.UsermenuBD;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 */
public final class SaveUserAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		UserForm saveForm = (UserForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();

		
		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");
		
		// Generate Business Delegate
		UserBD bd = new UserBD(this.getSessionFactoryClusterMap());
		
		
		// set primary key
		String pk = null;		
		try {
			pk = saveForm.getUserid();			
		} catch (Exception e) {}
		// find data-access-object using primary key
		User dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new User();
		}

		
		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			User duplicate = null;
			try{duplicate=bd.findUserByUserid(saveForm.getUserid());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.userid.unique"));				
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
						
		
		
		if (action.equals("Delete")) {		
			bd.deleteAll(pk, user);		
		} else {
	

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(dto, saveForm);
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	

			
			// special code for Create
			if (action.equals("Create")) {
			}
			

			
						
			
			bd.createOrUpdate(dto, user);

			
			// copy all order details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing copyUser from id: "+saveForm.getCopyId());
				String userId = null;
				try{userId = saveForm.getCopyId();}catch(Exception e){}
				if (userId != null) {
					copyUserToUser(userId, dto, user);
				}
			}
			
			
			// Find the quohdr form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());
			
			// Reset the parameters as if it was the first time in
			//listform.setStartPage();
			// Set the search parameters
			//listform.setSearchString1(dto.getUserid());
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);


	}

	
	public void copyUserToUser(
			String userId, 
			User dto,
			User user
	) throws Exception {

		UserBD userbd = new UserBD(this.getSessionFactoryClusterMap());	
		UsermenuBD usermenubd = new UsermenuBD(this.getSessionFactoryClusterMap());	
		UseraccessBD useraccessbd = new UseraccessBD(this.getSessionFactoryClusterMap());	
		UserdashboardBD userdashboardbd = new UserdashboardBD(this.getSessionFactoryClusterMap());
		
		// copy menu
		for (Iterator it = userbd.getUsermenus(userId).iterator(); it.hasNext();) {			
			Usermenu usermenu = new Usermenu();
			BeanUtils.copyProperties(usermenu, it.next());
			usermenu.setUserid(dto.getUserid());
			usermenu.setUsermenuId(null);	
			usermenubd.createOrUpdate(usermenu, user);
		}

		// copy access
		for (Iterator it = userbd.getUseraccesss(userId).iterator(); it.hasNext();) {			
			Useraccess useraccess = new Useraccess();
			BeanUtils.copyProperties(useraccess, it.next());
			useraccess.setUserid(dto.getUserid());
			useraccess.setUseraccessId(null);	
			useraccessbd.createOrUpdate(useraccess, user);
		}

		// copy dashboard
		for (Iterator it = userbd.getUserdashboard(userId).iterator(); it.hasNext();) {			
			Userdashboard userdashboard = new Userdashboard();
			BeanUtils.copyProperties(userdashboard, it.next());
			userdashboard.setUserid(dto.getUserid());
			userdashboard.setUserdashboardId(null);	
			userdashboardbd.createOrUpdate(userdashboard, user);
		}
		
		
	}
	

	
	
}
