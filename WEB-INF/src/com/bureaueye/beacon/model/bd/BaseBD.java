package com.bureaueye.beacon.model.bd;


import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.standard.User;







/**
*
* Amendments
* ----------
*
*
*
*/
public abstract class BaseBD
{


	
    /**
     * The <code>Log</code> instance for this application.
     */
    public static Log log = LogFactory.getLog(com.bureaueye.beacon.bean.Constants.PACKAGE); 

  
	
	// constructors
	public BaseBD() {
	}
	public BaseBD(SessionFactory _factory) {
		setSessionFactory1(_factory);		
	}
	public BaseBD(SessionFactory _factory1, SessionFactory _factory2) {
		setSessionFactory1(_factory1);
		setSessionFactory2(_factory2);
	}	
	public BaseBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		setSessionFactory1(_factory1);
		setSessionFactory2(_factory2);
		setSessionFactory3(_factory3);
	}
	
	
	

	public BaseBD(Map<String, SessionFactory> sfcm) {
		setSessionFactoryClusterMap(sfcm);		
	}
	
	private static Map<String, SessionFactory> _sessionFactoryClusterMap;
	/**
	 * Set the session factory cluster to Map
	 */
	public void setSessionFactoryClusterMap (Map<String, SessionFactory> sfcm) {
		_sessionFactoryClusterMap = sfcm;
	}	
	/**
	 * get the session factory cluster Map
	 */
	public Map<String, SessionFactory> getSessionFactoryClusterMap () {
		return _sessionFactoryClusterMap;
	}	
	/**
	 * Get the session factory cluster from Map
	 */
	public SessionFactory getSessionFactoryCluster(String configFileName) {
		if (null == configFileName) configFileName = "";
		SessionFactory sf = (SessionFactory) this.getSessionFactoryClusterMap().get(configFileName);
		if (null == sf)
			throw new RuntimeException(
					"The session factory for Config Filename '" + 
					configFileName + 
					"' has not been found"
					);
		else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" getSessionFactoryCluster:  Found Session Factory Cluster '"+
					sf.toString()+
					"' for Config Filename '" + 
					configFileName + 
					"'"
					);
			return sf;
		}
	}
	/**
	 * Get the session factory cluster from Map by class
	 */
	public SessionFactory getSessionFactoryClusterByClass(String className) {
		if (null == className) className = "";
		SessionFactory sf = null;
		for (Iterator it = this.getSessionFactoryClusterMap().values().iterator(); it.hasNext();) {
			sf = (SessionFactory)it.next();
			if (!(sf.getAllClassMetadata().containsKey(className))) sf = null;
			// break loop if session factory cluster found
			if (null != sf) break;
		}
		if (null == sf)
			throw new RuntimeException(
					"The session factory for Class Name '" + 
					className + 
					"' has not been found"
					);
		else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" getSessionFactoryCluster:  Found Session Factory Cluster '"+
					sf.toString()+
					"' for Class Name '" + 
					className + 
					"'"
					);		
			return sf;
		}
	}
	
	

    private SessionFactory _sessionFactory1;

	public SessionFactory getSessionFactory1 () {
		return _sessionFactory1;
	}
	public void setSessionFactory1 (SessionFactory _factory) {
		this._sessionFactory1 = _factory;
	}
	
    private SessionFactory _sessionFactory2;
    
	public SessionFactory getSessionFactory2 () {
		return _sessionFactory2;
	}
	public void setSessionFactory2 (SessionFactory _factory) {
		this._sessionFactory2 = _factory;
	}
	
    private SessionFactory _sessionFactory3;
    
	public SessionFactory getSessionFactory3 () {
		return _sessionFactory3;
	}
	public void setSessionFactory3 (SessionFactory _factory) {
		this._sessionFactory3 = _factory;
	}
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public abstract Object read(Object key) throws ApplicationException;
	
	
	public abstract void createOrUpdate(Object dto, User user) throws ApplicationException;
		
	
	public abstract void delete(Object dto, User user) throws ApplicationException;

	
	

	
}