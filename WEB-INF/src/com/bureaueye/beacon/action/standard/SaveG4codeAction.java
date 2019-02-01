package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;

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
import com.bureaueye.beacon.form.standard.G4codeForm;


import com.bureaueye.beacon.model.standard.G4code;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.G4codeBD;



/**
 * Amendments
 * ----------
 * 												
 */
public final class SaveG4codeAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		G4codeForm saveForm = (G4codeForm) form;
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
		G4codeBD bd = new G4codeBD(this.getSessionFactoryClusterMap());
		
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getG4codeId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		G4code dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new G4code();
		}

		
		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			G4code duplicate = null;
			try{duplicate=bd.findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(saveForm.getG1codekey(), saveForm.getG2codekey(), saveForm.getG3codekey(), saveForm.getG4codekey());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.g3code.unique"));				
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
			bd.delete(dao, user);		
		} else {
	

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	

			
			// special code for Create
			if (action.equals("Create")) {
			}
			

			
						
			
			bd.createOrUpdate(dao, user);

			
			
			
			// Find form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());
			
			// Reset the parameters as if it was the first time in
			//listform.setStartPage();

		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);


	}

	

	
	
}
