package com.bureaueye.beacon.action.purchaseorder;

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
import com.bureaueye.beacon.form.purchaseorder.Podtlrcvd1Form;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlrcvdBD;
import com.bureaueye.beacon.model.standard.User;




public final class SavePodtlrcvd1Action extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		Podtlrcvd1Form saveForm = (Podtlrcvd1Form) form;
		String action = saveForm.getActionX();
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
		PodtlrcvdBD bd = new PodtlrcvdBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getPodtlrcvdId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Podtlrcvd dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Podtlrcvd();
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
		BeanUtils.copyProperties(dto, saveForm);
					
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Podtlrcvd(pk), user);		
		} else {
			
			bd.createOrUpdate(dto, user);

			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("ListPodtlrcvdForm"))
					.setStartPage();
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  Forwarding to success page");
		return findSuccess(mapping);


	}
}
