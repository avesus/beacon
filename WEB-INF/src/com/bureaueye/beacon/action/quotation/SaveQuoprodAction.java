package com.bureaueye.beacon.action.quotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.quotation.QuoprodForm;
import com.bureaueye.beacon.model.quotation.Quoprod;
import com.bureaueye.beacon.model.quotation.bd.QuoprodBD;
import com.bureaueye.beacon.model.standard.User;
 

public final class SaveQuoprodAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		QuoprodForm quoprodForm = (QuoprodForm) form;
		String action = quoprodForm.getAction();
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Processing " + action	+ " action");
		
		// Generate Business Delegate
		QuoprodBD bd = new QuoprodBD(this.getSessionFactoryClusterMap());

		Integer pk = null;
		//Integer ky = null;		
		try {
			pk = new Integer(quoprodForm.getQuoprodId());
			//ky = new Integer(quoprodForm.getQuohdrId());			
		} catch (Exception e) {}
		Quoprod dto = bd.read(pk);
		if (dto == null) {
			dto = new Quoprod();
		}		
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, messages);
			return (mapping.getInputForward());
		}		
	
		
		// populate data-transfer-object from form
		// init FORM with DTO values
		BeanUtils.copyProperties(dto, quoprodForm);

		
		if (action.equals("Delete")) {		
			bd.delete(new Quoprod(pk), user);		
		} else {
		
			bd.createOrUpdate(dto, user);

			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName()))
					.setStartPage();
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}
}
