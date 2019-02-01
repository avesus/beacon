/*
 * $Id: LogoffAction.java 54929 2005-09-30 16:38:42Z ntankard $ 
 *
 */

package com.bureaueye.beacon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.standard.User;

/**
 * Implementation of <strong>Action</strong> that processes a
 * user logoff.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */
public final class LogoffAction extends Action {
	
	// ----------------------------------------------------- Instance Variables
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory.getLog(Constants.PACKAGE);
	
	// --------------------------------------------------------- Public Methods
	
	// See superclass for Javadoc
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// Extract attributes we will need
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
		
		// Process this user logoff
		if (user != null) {
			if (log.isDebugEnabled()) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" LogoffAction: User '" + user.getUserid()
						+ "' logged off in session " + session.getId());
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" LogoffActon: User logged off in session "
						+ session.getId());
			}
		}
		//session.removeAttribute(Constants.USERMENU_KEY);
		session.removeAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
		
		// remove breadcrumb object
		session.removeAttribute(com.bureaueye.beacon.bean.Constants.BREADCRUMB_KEY);
		
		// remove breadcrumb object
		session.removeAttribute(com.bureaueye.beacon.bean.Constants.ANALYSIS_POOL_KEY);
		
		// remove static data store from session
//		session.removeAttribute(Constants.ADDRTYPES_KEY);
//		session.removeAttribute(Constants.COUNTRYS_KEY);
//		session.removeAttribute(Constants.CCYS_KEY);
//		session.removeAttribute(Constants.CITYS_KEY);
//		session.removeAttribute(Constants.USERMENUS_KEY);
//		session.removeAttribute(Constants.TRANSPORTTYPES_KEY);
//		session.removeAttribute(Constants.INVENTORYSTATUSES_KEY);
		
		session = request.getSession(false);
//		Invalidate the existing session.
		if(session!=null) {						
			session.invalidate();					
		} 	
		
		
		// Forward control to the specified success URI
		return findSuccess(mapping);
		
	}
	
	/**
	 * Return the local or global forward named "failure"
	 * or null if there is no such forward.
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "failure" or null if there is no such mapping.
	 */
	protected ActionForward findFailure(ActionMapping mapping) {
		return mapping.findForward(Constants.FAILURE);
	}
	
	
	/**
	 * Return the mapping labeled "success"
	 * or null if there is no such mapping.
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "success" or null if there is no such mapping.
	 */
	protected ActionForward findSuccess(ActionMapping mapping) {
		return mapping.findForward(Constants.SUCCESS);
	}
	
}
