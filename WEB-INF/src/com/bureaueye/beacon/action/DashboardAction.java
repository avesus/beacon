package com.bureaueye.beacon.action;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;



public final class DashboardAction extends Action {

	// ----------------------------------------------------- Instance Variables

	static String ACTION = "action";

	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory.getLog(Constants.PACKAGE);


	protected static Map<String, SessionFactory> _sessionFactoryClusterMap;
	/**
	 * Set the session factory cluster to Map
	 */
	public void setSessionFactoryCluster (String configFileName, SessionFactory sf) {
		if (null == configFileName) configFileName = "";
		if (null == _sessionFactoryClusterMap) _sessionFactoryClusterMap = new HashMap<String, SessionFactory>();
		_sessionFactoryClusterMap.put(
				configFileName,
				sf);
	}
	/**
	 * get the session factory cluster Map
	 */
	public Map<String, SessionFactory> getSessionFactoryClusterMap () {
		return _sessionFactoryClusterMap;
	}



	private SessionFactory _sessionFactoryCluster1;

	public SessionFactory getSessionFactoryCluster1 () {
		return _sessionFactoryCluster1;
	}
	public void setSessionFactoryCluster1 (SessionFactory _factory) {
		this._sessionFactoryCluster1 = _factory;
	}


	private SessionFactory _sessionFactoryCluster2;

	public SessionFactory getSessionFactoryCluster2 () {
		return _sessionFactoryCluster2;
	}
	public void setSessionFactoryCluster2 (SessionFactory _factory) {
		this._sessionFactoryCluster2 = _factory;
	}


	private SessionFactory _sessionFactoryCluster3;

	public SessionFactory getSessionFactoryCluster3 () {
		return _sessionFactoryCluster3;
	}
	public void setSessionFactoryCluster3 (SessionFactory _factory) {
		this._sessionFactoryCluster3 = _factory;
	}



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
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" User '" + user.getUserid()
						+ "' logged off in session " + session.getId());
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" User logged off in session "
						+ session.getId());
			}
		}


		// set hibernate session factories
		this.setSessionFactoryCluster1(
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster1Plugin.SESSION_FACTORY_KEY)
		);
		this.setSessionFactoryCluster(
				HibernateCluster1Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster1Plugin.SESSION_FACTORY_KEY)
		);		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster1: "+this.getSessionFactoryClusterMap().toString());

		this.setSessionFactoryCluster2(
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster2Plugin.SESSION_FACTORY_KEY)
		);
		this.setSessionFactoryCluster(
				HibernateCluster2Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster2Plugin.SESSION_FACTORY_KEY)
		);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster2: "+this.getSessionFactoryClusterMap().toString());		

		this.setSessionFactoryCluster3(
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster3Plugin.SESSION_FACTORY_KEY)
		);
		this.setSessionFactoryCluster(
				HibernateCluster3Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(HibernateCluster3Plugin.SESSION_FACTORY_KEY)
		);		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster3: "+this.getSessionFactoryCluster3().toString());



		// Local parameters
		String action = "";
		try{action=request.getParameter(ACTION);}catch(Exception e){}


		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" action: "+action
		);


		// check dashboard pool already exists
		DashboardPool pool = DashboardPool.getPool(session);
		if (pool==null) {

			// Instantiate the Pool
			pool = new DashboardPool(this.getSessionFactoryClusterMap());
			//init pool objects
			pool.setUser(user);

			
			//WORKFLOW_PENDING_APPROVAL
			try {
				pool.setWORKFLOW_PENDING_APPROVAL();				
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"WORKFLOW_PENDING_APPROVAL - Exception: "+e.getMessage());					
			}			

			//QUOTATIONS_EXPIRING
			try {
				pool.setQUOTATIONS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"QUOTATIONS_EXPIRING - Exception: "+e.getMessage());					
			}				

			//SALES_INVOICES_TO_BUILD
			try {
				pool.setSALES_INVOICES_TO_BUILD();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"SALES_INVOICES_TO_BUILD - Exception: "+e.getMessage());					
			}		

			//SALES_INVOICES_TO_PRINT
			try {
				pool.setSALES_INVOICES_TO_PRINT();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"SALES_INVOICES_TO_PRINT - Exception: "+e.getMessage());					
			}	

			//JOB_MOVEMENTS_TO_ACTUALISE
			try {
				pool.setJOB_MOVEMENTS_TO_ACTUALISE();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"JOB_MOVEMENTS_TO_ACTUALISE - Exception: "+e.getMessage());					
			}	
			
			//VENDOR_TARIFFS_EXPIRING
			try {
				pool.setVENDOR_TARIFFS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"VENDOR_TARIFFS_EXPIRING - Exception: "+e.getMessage());					
			}	

			//VENDOR_TARIFFS_EXPIRING
			try {
				pool.setVENDOR_TARIFFS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"VENDOR_TARIFFS_EXPIRING - Exception: "+e.getMessage());					
			}	
			
			//CUSTOMER_TARIFFS_EXPIRING
			try {
				pool.setCUSTOMER_TARIFFS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"CUSTOMER_TARIFFS_EXPIRING - Exception: "+e.getMessage());					
			}	
			
			
			//
			try {
				List queryResult = new LinkedList();																	
				pool.setDashboardlist8(queryResult);
				pool.setDaterangedays8("");
				pool.setDashboardtype8("");				
				pool.setDashboardlist9(queryResult);
				pool.setDaterangedays9("");
				pool.setDashboardtype9("");				
				pool.setDashboardlist10(queryResult);
				pool.setDaterangedays10("");
				pool.setDashboardtype10("");				
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						" - Exception: "+e.getMessage());					
			}

			//store dashboard pool in user's session
			DashboardPool.setPool(session, pool);

		}//if (pool==null) {


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
