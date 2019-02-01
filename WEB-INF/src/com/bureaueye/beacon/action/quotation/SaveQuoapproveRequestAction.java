package com.bureaueye.beacon.action.quotation;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;



import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.quotation.ListQuoapproveRequestForm;
import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.model.standard.bd.UsergroupBD;




/**
 * Amendments
 * ----------
 *
 * NT	2010-02-23		201000012		Add check to not allow creation of duplicate userid/usergroupid approval requests
 * 
 */
public final class SaveQuoapproveRequestAction extends BaseAction {
	
	// ----------------------------------------------------- Instance Variables
	
	
	// --------------------------------------------------------- Public Methods
	
	// See superclass for Javadoc
	public ActionForward executeAction(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ListQuoapproveRequestForm listForm = (ListQuoapproveRequestForm) form;
		String action = "SubmitApproveRequest";
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		
		String email = null;
		try {
			email = request.getParameter("email");
		} catch (NullPointerException npe) {} 
		
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
		
		
		
		// Validate the request parameters specified by the user
		if (log.isTraceEnabled()) {
			log.trace(" Performing extra validations");		
		}
		
		// Performing extra validations here ------------>
		
		
		
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
		
		
		// generate Business Delegate
		QuoapproveBD bd = new QuoapproveBD(this.getSessionFactoryClusterMap());
		QuohdrBD _quohdrBD = new QuohdrBD(this.getSessionFactoryClusterMap());
		Quohdr _quohdrDTO = _quohdrBD.read(new Integer(listForm.getId()));
		
		// get http parameters
		for (int i = 0; i < 5; i++) {
			// generate view fields
			String quoapproveid = null;				
			String userid = null;
			String usergroupid = null;
			String priority = null;
			String delete = null;			
			
			try {
				quoapproveid = request.getParameter("quoapproveid"+i);				
				userid = request.getParameter("userid"+i);
				usergroupid = request.getParameter("usergroupid"+i);
				priority = request.getParameter("priority"+i);
				delete = request.getParameter("delete"+i);	
				
				
				Quoapprove dto = null;				
				// process if id exists
				if (!quoapproveid.equals("")) { 
					// 	retreive object			
					dto = bd.read(new Integer(quoapproveid)); 
				}
				
				// create transaction
				if (
						delete == null && 
						quoapproveid.equals("") &&
						(!userid.equals("") || !usergroupid.equals(""))
				) {
					
					// Add check to not allow creation of duplicate userid/usergroupid approval requests
					// - check approval request record exists for userid/usergroupid key			
					dto = bd.findQuoapproveByUseridUsergroupid(listForm.getId(),userid,usergroupid);//201000012 					
					if (dto==null) {//201000012
						dto = new Quoapprove();
						bd.createOrUpdate(dto, user);
						quoapproveid = dto.getQuoapproveId().toString();
						dto.setQuohdrId(new Integer(listForm.getId()));
						dto.setNotes("");
						dto.setRejectreason("");
						dto.setApproveflag("");
					}//201000012
				}
				
				// delete transaction
				if (delete != null && !quoapproveid.equals("")) {
					bd.delete(dto, user);
				}
				
				// update transaction 
				if (delete == null && !quoapproveid.equals("")) {
					try {
						dto.setUserid(userid);
						dto.setUsergroupid(usergroupid);
						dto.setPriority(priority);
						bd.createOrUpdate(dto, user);
					} catch (Exception e) {
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Database update", e);
					}
				}
				
				// Performing email notification here ------------>
				if (email != null && !quoapproveid.equals("")) {				
					toEmail(
							_quohdrDTO,
							dto,
							user
					);
				}
				
			}
			catch (NullPointerException npe) {} 
			
		}	// end FOR statement to get web parameters
		
		
		// Remove the obsolete form bean	
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope()))
				request.removeAttribute(mapping.getAttribute());
			else
				session.removeAttribute(mapping.getAttribute());
		}
		
		
		
		// Forward control to the specified success URI
		if (log.isTraceEnabled()) {
			log.trace(" Forwarding to success page");
		}
		
		return (mapping.findForward("success"));
		
	}
	
	
	
	public void toEmail(
			Quohdr _quohdrDTO,
			Quoapprove dto,
			User user
	)
	throws Exception {
		
		
		// set email properties
		Properties props = new Properties();
		props.put("mail.host", user.getMailhost());			
		javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
		javax.mail.Message body = new MimeMessage(mailSession);
		javax.mail.Address _From = null;
		try {
			// FROM - default to user logon		
			_From = new InternetAddress(user.getEmail().trim());
			body.setFrom(_From);
		}	
		catch (AddressException ae) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: AddressException: "+ae.getMessage());			
		}
		
		
		String userOrGroupId = "";
		String userOrGroup = "";
		javax.mail.Address _Recipient = null;		
		if (!dto.getUserid().equals("")) {
			userOrGroupId = dto.getUserid();
			userOrGroup = "user";
			try {				
				_Recipient = new InternetAddress(new UserBD(this.getSessionFactoryClusterMap()).read(dto.getUserid()).getEmail().trim());		
				body.addRecipient(Message.RecipientType.TO, _Recipient);
			}
			catch (NullPointerException npe) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: NullPointerException: "+npe.getMessage());			
			}			
			catch (AddressException ae) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: AddressException: "+ae.getMessage());			
			}		
		}
		else {  			
			if (!dto.getUsergroupid().equals("")) {
				userOrGroupId = dto.getUsergroupid();
				userOrGroup = "group";
				try {  						
					_Recipient = new InternetAddress(new UsergroupBD(this.getSessionFactoryClusterMap()).read(dto.getUsergroupid()).getEmail().trim());
					body.addRecipient(Message.RecipientType.TO, _Recipient);
				}
				catch (NullPointerException npe) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: NullPointerException: "+npe.getMessage());			
				}				
				catch (AddressException ae) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: AddressException: "+ae.getMessage());			
				}
			}
		}
		
		
		body.setSubject(userOrGroupId+" approval Quotation - "+_quohdrDTO.getQuotno());
		
		
		try {
			String content= "";
			content = 
				"<table style='border-right: 2px #FFFFFF solid' cellpadding='2' cellspacing='0' border='0' width='100%'>";
			
			
			content=content+
			"<tr><td>"+
			"Approval by - "+userOrGroup+": "+userOrGroupId+" is required."+
			"</td></tr>"+
			"<tr><td>"+
			"Quotation "+_quohdrDTO.getQuotno()+" has been created, the status is Submitted"+
			"</td></tr>"+
			"<tr><td>"+
			""+
			"</td></tr>"+
			"<tr><td>"+		
			"Quotation #: "+_quohdrDTO.getQuotno()+
			"</td></tr>"+
			"<tr><td>"+				
			"Assigned Group: "+dto.getUsergroupid()+
			"</td></tr>"+
			"<tr><td>"+				
			"Assigned User: "+dto.getUserid()+
			"</td></tr>"+
			"<tr><td>"+				
			"Priority: "+dto.getPriority()+
			"</td></tr>"+
			"<tr><td>"+				
			"Requester: "+user.getName()+
			"</td></tr>"+
			"<tr><td>"+				
			"Company: "+_quohdrDTO.getCompanykey()+
			"</td></tr>"+
			"<tr><td>"+				
			"Department: "+_quohdrDTO.getDepartmentkey()+
			"</td></tr>"+
			"<tr><td>"+				
			"Activity: "+_quohdrDTO.getActivitykey()+
			"</td></tr>";
			
			
			
			
			
			content=content+    
			"</table>";
			
			body.setContent(content, "text/html");
			
			Transport.send(body);
			
		}
		catch (Exception e) {						
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" toEmail: Exception: "+e.getMessage());			
		}
		
		
	}
	
}
