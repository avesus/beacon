package com.bureaueye.beacondms.action.dms;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;




import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacondms.form.dms.ListTrackForm;
import com.bureaueye.beacon.model.standard.User;





/**
 */
public class EditTrackMailAction extends BaseAction {





	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		HttpSession session = request.getSession(false);
		ListTrackForm editForm = (ListTrackForm) form;
		String action = editForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();




		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" EditForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		log.info(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				" Form parameters: "+editForm.toString()
		);	







		// validation		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			saveAppInformationMessages(request, messages);
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			saveAppErrorMessages(request, errors);
			return findFailure(mapping);
		}	







		//set default screen fields
		editForm.setMailfrom(user.getEmail());
		editForm.setMailto("");
		editForm.setMailcc("");
		editForm.setMailbcc("");
		editForm.setMailsubject("");
		editForm.setMailtext("");

		



		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
		
	}



}
