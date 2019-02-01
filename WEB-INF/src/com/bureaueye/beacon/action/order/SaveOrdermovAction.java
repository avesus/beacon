package com.bureaueye.beacon.action.order;

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
import com.bureaueye.beacon.bean.standard.Gcode;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.order.OrdermovForm;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.bd.OrdermovBD;
import com.bureaueye.beacon.model.standard.User;


public final class SaveOrdermovAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrdermovForm ordermovForm = (OrdermovForm) form;
		String action = ordermovForm.getAction();
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
		OrdermovBD bd = new OrdermovBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(ordermovForm.getOrdermovId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Ordermov dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Ordermov();
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
		BeanUtils.copyProperties(dao, ordermovForm);
					
		
		
		if (action.equals("Delete")) {		
			bd.deleteAll(pk, user);			
		} else {
	
			
			
			//if (action.equals("Create")) {	
				//init FROM g codes
				try {
					Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
					gcode.initGcodesByLocation(dao.getFromlocationkey());
					dao.setFromg1key(gcode.getG1codekey());
					dao.setFromg2key(gcode.getG2codekey());
					dao.setFromg3key(gcode.getG3codekey());
					dao.setFromg4key(gcode.getG4codekey());
				} catch (Exception e){			
				}
				//init TO g codes
				try {
					Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
					gcode.initGcodesByLocation(dao.getTolocationkey());
					dao.setTog1key(gcode.getG1codekey());
					dao.setTog2key(gcode.getG2codekey());
					dao.setTog3key(gcode.getG3codekey());
					dao.setTog4key(gcode.getG4codekey());
				} catch (Exception e){			
				}
			//}
			
			
			bd.createOrUpdate(dao, user);

			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName()))
					.setStartPage();
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}
}
