

package com.bureaueye.beacon.action.quotation;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.form.quotation.ListQuoapproveForm;
import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.standard.User;



/**
 * Implementation of <strong>Action</strong> that validates and creates or
 * updates the Quoapprove information submited by the user.  
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */

public final class SaveQuoapproveAction extends BaseAction {
	
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
		ListQuoapproveForm listForm = (ListQuoapproveForm) form;
		String action = "SubmitApprove";
		User user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		
		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Cancel transaction"+
					" findSuccess(mapping): "+findSuccess(mapping)					
					);
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
		
		
		// generate Business Delegates
		QuoapproveBD bd = new QuoapproveBD(this.getSessionFactoryClusterMap());
		QuohdrBD _quohdrBD = new QuohdrBD(this.getSessionFactoryClusterMap());
		
		// init approval header fields
		String quohdrQuotestatus = "";
		String quohdrRejectreason = "";
		String quohdrNotes = "";
		int actionCount=0; 
		int approvedCount=0;
		int rejectedCount=0;
		
		// get http parameters
		for (int i = 0; i < 5; i++) {
			// generate view fields
			String quoapproveid = null;				
			String approveflag = null;
			String rejectreason = null;
			String notes = null;
			
			
			// get parameter values 	
			try {quoapproveid = request.getParameter("quoapproveid"+i);} catch (NullPointerException npe) {} 
			try {approveflag = request.getParameter("approveflag"+i);} catch (NullPointerException npe) {}
			try {rejectreason = request.getParameter("rejectreason"+i);} catch (NullPointerException npe) {}
			try {notes = request.getParameter("notes"+i);} catch (NullPointerException npe) {}
			
			
			// process if id exists
			if (quoapproveid != null) { 
				
				log.info(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"quohdrId["+listForm.getId()+"]: "+
						"quoapproveid["+quoapproveid+"] "
				);
				
				
				actionCount++;
				// 	retreive object
				Quoapprove dto = null;				
				dto = bd.read(new Integer(quoapproveid)); 
				
				//// delete transaction
				//if (action.equals("Delete")) {
				//	try {
				//		try {
				//			bd.deleteQuoapprove(dto, user);
				//		}
				//		catch (HibernateException he) {}
				//	} catch (Exception e) {
				//		log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Database delete", e);
				//	}
				//}
				//
				
				// process if change
				if (!dto.getApproveflag().equals(approveflag)) {
					// update transaction
					try {
						dto.setRejectreason(rejectreason);
						dto.setNotes(notes);
					} catch (NullPointerException npe) {}
					dto.setApproveflag(approveflag);
					if (approveflag.equals("")) {
						dto.setApprovedate(null);
						dto.setApprovetime("");
					}
					else {
						Calendar c = Calendar.getInstance();
						dto.setApprovedate(c.getTime());
						dto.setApprovetime(com.bureaueye.beacon.util.Util.toTime(c));
						//+ ((c.getTimeInMillis() % (com.bureaueye.beacon.bean.Constants.MILLISECONDS_PER_DAY)) / 1000));
					}
					bd.createOrUpdate(dto, user);
				}
				
				
				// increment APPROVED count
				if (approveflag.equals(Constants.APPROVED_STATUS)) approvedCount++;
				// increment REJECTED count
				if (approveflag.equals(Constants.REJECTED_STATUS)) rejectedCount++;
				
				
				// store approve status on header
				// - REJECTED STATUS always overrides others
				if (quohdrQuotestatus.equals("") || approveflag.equals(Constants.REJECTED_STATUS)) {					
					quohdrRejectreason = rejectreason;
					quohdrNotes = notes;
					quohdrQuotestatus = approveflag;
				}
				
				
			} // check id not null
			
			
		}	// end FOR statement to get web parameters
		
		log.info(
				"["+this.getClass().getName()+"] "+
				new java.util.Date()+" "+
				"quohdrId["+listForm.getId()+"]: "+
				"actionCount["+actionCount+"]: "+
				"approvedCount["+approvedCount+"]: "+
				"rejectedCount["+rejectedCount+"]: "+
				"quohdrRejectreason["+quohdrRejectreason+"]: "+
				"quohdrNotes["+quohdrNotes+"]: "+
				"quohdrQuotestatus["+quohdrQuotestatus+"]"
		);
		
		
		// if not all actioned set to PENDING STATUS
		// OR 
		// header status is blank set to PENDING STATUS
		if (actionCount != (approvedCount+rejectedCount) ||	quohdrQuotestatus.equals("")) {
			quohdrQuotestatus=Constants.PENDING_STATUS;
			quohdrNotes="";
			quohdrRejectreason="";
		}
		
		
		// update header if all records actioned
		// 	retreive object
		Quohdr _quohdrDTO = null;				
		_quohdrDTO = _quohdrBD.read(new Integer(listForm.getId()));
		// set approval fields
		_quohdrDTO.setRejectreason(quohdrRejectreason);
		_quohdrDTO.setNotes(quohdrNotes);
		_quohdrDTO.setQuotestatus(quohdrQuotestatus);
		Calendar c = Calendar.getInstance();
		_quohdrDTO.setApprovaldate(c.getTime());				
		_quohdrBD.createOrUpdate(_quohdrDTO, user);	
		
	
		
		
		//UPDATE DASHBOARD POOL========================================================>		
		// check dashboard pool already exists
		DashboardPool pool = DashboardPool.getPool(session);
		if (pool!=null) {
		
			//WORKFLOW_PENDING_APPROVAL
			try {
				pool.setWORKFLOW_PENDING_APPROVAL();				
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"WORKFLOW_PENDING_APPROVAL - Exception: "+e.getMessage());					
			}				

			//store dashboard pool in user's session
			DashboardPool.setPool(session, pool);

		}//if (pool==null) {
		//UPDATE DASHBOARD POOL========================================================<		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
}
