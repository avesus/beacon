package com.bureaueye.beacon.action.dsactivity;



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
import com.bureaueye.beacon.bean.standard.Constants;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.dsactivity.DsingateForm;
import com.bureaueye.beacon.model.dsactivity.Dsingate;
import com.bureaueye.beacon.model.dsactivity.bd.DsingateBD;
import com.bureaueye.beacon.model.standard.User;





public final class SaveDsingateAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		DsingateForm saveForm = (DsingateForm) form;
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
		DsingateBD bd = new DsingateBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getDsingateId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Dsingate dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Dsingate();
		}



		// error validation 

		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			Dsingate duplicate = null;
			try{duplicate=bd.findDsingateByEirinEirinver(saveForm.getEirin(),new Integer(saveForm.getEirinver()));}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.ingate.unique"));				
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


			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dao, saveForm);				
			} catch (java.lang.NumberFormatException nfe) {
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {				
			}	



			bd.createOrUpdate(dao, user);


			// copy all details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Processing copyDsingate from id: "+saveForm.getCopyId());
				Integer copyId = null;
				try{copyId = new Integer(saveForm.getCopyId());}catch(Exception e){}
				if (copyId != null) {
				}
			}


			// Find the list form and reset the parameters as if it
			// was the first time in
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
		}




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}






}
