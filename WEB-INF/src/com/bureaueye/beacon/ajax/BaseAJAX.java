/*
 * $Id: BaseAJAX.java 
 *
 */

package com.bureaueye.beacon.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;




/**
 */
public abstract class BaseAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);
	
	
	
	
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
	
	
	
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		// set hibernate session factory
		ServletContext context = getServletContext();
		
		
		// set hibernate session factories
		this.setSessionFactoryCluster1(
				(SessionFactory) context.getAttribute(HibernateCluster1Plugin.SESSION_FACTORY_KEY)
				);
		this.setSessionFactoryCluster(
				HibernateCluster1Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) context.getAttribute(HibernateCluster1Plugin.SESSION_FACTORY_KEY)
				);		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster1: "+this.getSessionFactoryClusterMap().toString());
		
		this.setSessionFactoryCluster2(
				(SessionFactory) context.getAttribute(HibernateCluster2Plugin.SESSION_FACTORY_KEY)
				);
		this.setSessionFactoryCluster(
				HibernateCluster2Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) context.getAttribute(HibernateCluster2Plugin.SESSION_FACTORY_KEY)
				);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster2: "+this.getSessionFactoryClusterMap().toString());		
		
		this.setSessionFactoryCluster3(
				(SessionFactory) context.getAttribute(HibernateCluster3Plugin.SESSION_FACTORY_KEY)
				);
		this.setSessionFactoryCluster(
				HibernateCluster3Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) context.getAttribute(HibernateCluster3Plugin.SESSION_FACTORY_KEY)
				);		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" setSessionFactoryCluster3: "+this.getSessionFactoryCluster3().toString());
		
		
//		call the abstract method
		execute(request, response);
		
	}
	
	
	protected abstract void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
