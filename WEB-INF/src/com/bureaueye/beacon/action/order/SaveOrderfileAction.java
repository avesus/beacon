package com.bureaueye.beacon.action.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Hibernate;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.order.OrderfileForm;
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.bd.OrderfileBD;
import com.bureaueye.beacon.model.standard.User;



public final class SaveOrderfileAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrderfileForm saveForm = (OrderfileForm) form;
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		// Generate Business Delegate
		OrderfileBD bd = new OrderfileBD(this.getSessionFactoryClusterMap());

		Integer pk = null;	
		try {
			pk = new Integer(saveForm.getOrderfileId());			
		} catch (Exception e) {}
		Orderfile dto = bd.read(pk);
		if (dto == null) {
			dto = new Orderfile();
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
		//BeanUtils.copyProperties(dto, saveForm);

		
		if (action.equals("Delete")) {		
			bd.delete(new Orderfile(pk), user);		
		} else {
		
			
			if (action.equals("Create")) {				
				//upload file information
				dto.setFilebin( Hibernate.createBlob (saveForm.getInfile().getInputStream()) );
				//store file information
				dto.setFilename(saveForm.getInfile().getFileName());
				dto.setFilesize(saveForm.getInfile().getFileSize());
				dto.setContenttype(saveForm.getInfile().getContentType());
				//store desctiption
				dto.setDescription(saveForm.getDescription());
				
				//store header id
				dto.setOrderhdrId(saveForm.getOrderhdrId());
			}
			
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
