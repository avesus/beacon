package com.bureaueye.beacon.action.quotation;


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
import com.bureaueye.beacon.form.quotation.QuomovForm;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 */
public final class EditQuomovAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);		
		QuomovForm editForm = (QuomovForm) form;
		
		// Extract attributes we will need
		String action = editForm.getAction();
		
		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		
		// user access check ---------------------------------------------------->
		ActionMessages appInformationMessages = new ActionMessages();
		// check access for userid and type
		Useraccess useraccessdao = new UseraccessBD(this.getSessionFactoryClusterMap())
		.findUseraccessByKey1(user.getUserid(), mapping.getParameter());				
		if (useraccessdao!= null) {			
			// check action in grant action list
			if (!useraccessdao.getGrantactionlist().contains(action)) {
				// downgrade access to view only if view access in grant action list
				if (
						action.equals(com.bureaueye.beacon.bean.Constants.EDIT_ACTION) &&
						useraccessdao.getGrantactionlist().contains(com.bureaueye.beacon.bean.Constants.VIEW_ACTION)
				) {
					editForm.setAction(com.bureaueye.beacon.bean.Constants.VIEW_ACTION);
					action=com.bureaueye.beacon.bean.Constants.VIEW_ACTION;					
				} else {
					// if user does not have correct access - create information message
					appInformationMessages.add(
							"errors.useraccess",
							new ActionMessage(
									"information.useraccess", 
									user.getUserid(),
									action,
									mapping.getParameter()
							)
					);	
					saveAppInformationMessages(request, appInformationMessages);
					// if user does not have correct access - return to failure mapping
					return findFailure(mapping);
				}
			}	
		}
		// user access check ---------------------------------------------------->
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		
		if (!(action == null || action.equals("Create"))) {
			
			Quomov dto = new QuomovBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getQuomovId()));
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quomov found for quohdrId: "
						+ editForm.getQuohdrId() + ", "
						+ "quomovid: " + editForm.getQuomovId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getQuohdrId()
						+ " - " + editForm.getQuomovId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating editForm from " + dto);
			
			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);
			
//			// init FORM with DTO values
//			//BeanUtils.copyProperties(editForm, dto);
//			try {
//			editForm.populate(dto,BaseForm.TO_STRING);
//			editForm.setInitfromday(dto.isInitfromday());
//			editForm.setInittoday(dto.isInittoday());	
//			editForm.setSection(editForm.getSectionkey());
//			}
//			catch (FormattingException fe) {
//			fe.printStackTrace();
//			}
			
			/*			try {
			 // set derived fields
			  editForm.setNumberofcosts(
			  new Integer(dto.getQuocosts().size()).toString()
			  );			
			  }
			  catch (Exception e) {
			  e.printStackTrace();
			  }*/			
			
			if (action.equals("Copy")) {
				editForm.setQuomovId("");							
				editForm.setAction("Create");
				action="Create";
			}
		}
		
		// set defaults for Create process
		if (action.equals("Create")) {
			// default user information
			// init next sequence no
			int seqno = 10;
			Quomov findQuomov = new QuomovBD(this.getSessionFactoryClusterMap()).findLastQuomovByQuohdrId(editForm.getQuohdrId());
			if (findQuomov != null) seqno = findQuomov.getSeqno().intValue()+10;				
			editForm.setSeqno(""+seqno);
			
			editForm.setInitfromday(false);
			editForm.setInittoday(false);
			editForm.setNumberofcosts("0");				
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
		
	}
	
}
