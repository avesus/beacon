package com.bureaueye.hibernate.plugin;


import java.net.URL;
import javax.servlet.ServletException;


import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.bureaueye.beacon.bean.Constants;


public class HibernateCluster1Plugin implements PlugIn {
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);	
	
	private Configuration config;
	private SessionFactory factory;
	private String path = com.bureaueye.hibernate.plugin.Constants.HIBERNATE_CONFIG_FILE;
	private static Class clazz = HibernateCluster1Plugin.class;
	
	
	public static final String SESSION_FACTORY_KEY = clazz.getName();
	
	
	
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public void init(ActionServlet servlet, ModuleConfig modConfig)
	throws ServletException {
		
		
		try {
			URL url = HibernateCluster1Plugin.class.getResource(path);
			config = new Configuration().configure(url);
			factory = config.buildSessionFactory();
			servlet.getServletContext().setAttribute(SESSION_FACTORY_KEY, factory);
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" setAttribute: "+SESSION_FACTORY_KEY);
			
		} catch (MappingException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" MappingException: "+e.getMessage());
			throw new ServletException();
			
			
		} catch (HibernateException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" HibernateException: "+e.getMessage());    	  
			throw new ServletException();
		}
		
		
	}
	
	
	public void destroy() {
		try {
			factory.close();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Close factory: "+SESSION_FACTORY_KEY);			
		} catch (HibernateException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" unable to close factory HibernateException: "+e.getMessage());    	           
		}
	}
}