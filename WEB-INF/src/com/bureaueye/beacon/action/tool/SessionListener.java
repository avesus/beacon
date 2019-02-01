package com.bureaueye.beacon.action.tool;

import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bureaueye.beacon.bean.Constants;



public class SessionListener implements HttpSessionListener {

	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);
	
	
	public SessionListener() {
	}
	
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// Get the session that was created
		HttpSession session = sessionEvent.getSession();
		// Store session, and log a message
		try {
			log.info(
					"["+this.getClass().getName()+"] "+new java.util.Date()+ 
					" sessionCreated: "+
					" Id["+session.getId()+"]"
					//" Id["+session.getAttribute()+"]"+
			);	

		} catch (Exception e) {
			log.error(
					"["+this.getClass().getName()+"] "+new java.util.Date()+ 
					"Error in setting session attribute: " + 
					e.getMessage());
		}
	}
	
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// Get the session that was invalidated
		HttpSession session = sessionEvent.getSession();
		// Log a message
		log.info(
				"["+this.getClass().getName()+"] "+new java.util.Date()+ 
				" sessionDestroyed: "+
				" Id["+session.getId()+"]"
		);	
	}
	
}