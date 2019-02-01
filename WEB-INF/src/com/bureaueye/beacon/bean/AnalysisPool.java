package com.bureaueye.beacon.bean;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.model.standard.User;




public class AnalysisPool {

    /**
     * The <code>Log</code> instance for this application.
     */
    public static Log log = LogFactory.getLog(com.bureaueye.beacon.bean.Constants.PACKAGE); 

     
    
	
	// constructors
	public AnalysisPool() {
	}
	public AnalysisPool(SessionFactory _factory) {
		setSessionFactory1(_factory);		
	}
	public AnalysisPool(SessionFactory _factory1, SessionFactory _factory2) {
		setSessionFactory1(_factory1);
		setSessionFactory2(_factory2);
	}	
	
	
	
	public AnalysisPool(Map<String, SessionFactory> sfcm) {
		setSessionFactoryClusterMap(sfcm);		
	}
	
	protected static Map<String, SessionFactory> _sessionFactoryClusterMap;
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
					" getSessionFactoryCluster:  Found Session Factory for Config Filename '" + 
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
					" getSessionFactoryClusterByClass:  Found Session Factory for Class Name '" + 
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
	
	
	
	//  model objects
	private List analysislist1;
	private List analysislist2;
	private List analysislist3;
	private List analysislist4;
	private List analysislist5;
	private List analysislist6;
	private List analysislist7;
	private List analysislist8;
	private List analysislist9;	
	private List analysislist10;
	
	
	private String dashboardtype1;
	private String dashboardtype2;
	private String dashboardtype3;
	private String dashboardtype4;
	private String dashboardtype5;
	private String dashboardtype6;
	private String dashboardtype7;
	private String dashboardtype8;
	private String dashboardtype9;	
	private String dashboardtype10;	

	private String daterangedays1;
	private String daterangedays2;
	private String daterangedays3;
	private String daterangedays4;
	private String daterangedays5;
	private String daterangedays6;
	private String daterangedays7;
	private String daterangedays8;
	private String daterangedays9;	
	private String daterangedays10;
	
	
	private User user;
	
	
	/**
	 */
	public java.util.List getAnalysislist1 () {
		return this.analysislist1;
	}
	/**
	 */
	public void setAnalysislist1 (java.util.List analysislist1) {
		this.analysislist1 = analysislist1;
	}	
	public void addToAnalysislist1 (Object obj) {
		if (null == this.analysislist1) this.analysislist1 = new java.util.LinkedList();
		this.analysislist1.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist2 () {
		return this.analysislist2;
	}
	/**
	 */
	public void setAnalysislist2 (java.util.List analysislist2) {
		this.analysislist2 = analysislist2;
	}	
	public void addToAnalysislist2 (Object obj) {
		if (null == this.analysislist2) this.analysislist2 = new java.util.LinkedList();
		this.analysislist2.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist3 () {
		return this.analysislist3;
	}
	/**
	 */
	public void setAnalysislist3 (java.util.List analysislist3) {
		this.analysislist3 = analysislist3;
	}	
	public void addToAnalysislist3 (Object obj) {
		if (null == this.analysislist3) this.analysislist3 = new java.util.LinkedList();
		this.analysislist3.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist4 () {
		return this.analysislist4;
	}
	/**
	 */
	public void setAnalysislist4 (java.util.List analysislist4) {
		this.analysislist4 = analysislist4;
	}	
	public void addToAnalysislist4 (Object obj) {
		if (null == this.analysislist4) this.analysislist4 = new java.util.LinkedList();
		this.analysislist4.add(obj);
	}	

	
	/**
	 */
	public java.util.List getAnalysislist5 () {
		return this.analysislist5;
	}
	/**
	 */
	public void setAnalysislist5 (java.util.List analysislist5) {
		this.analysislist5 = analysislist5;
	}	
	public void addToAnalysislist5 (Object obj) {
		if (null == this.analysislist5) this.analysislist5 = new java.util.LinkedList();
		this.analysislist5.add(obj);
	}
	

	/**
	 */
	public java.util.List getAnalysislist6 () {
		return this.analysislist6;
	}
	/**
	 */
	public void setAnalysislist6 (java.util.List analysislist6) {
		this.analysislist6 = analysislist6;
	}	
	public void addToAnalysislist6 (Object obj) {
		if (null == this.analysislist6) this.analysislist6 = new java.util.LinkedList();
		this.analysislist6.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist7 () {
		return this.analysislist7;
	}
	/**
	 */
	public void setAnalysislist7 (java.util.List analysislist7) {
		this.analysislist7 = analysislist7;
	}	
	public void addToAnalysislist7 (Object obj) {
		if (null == this.analysislist7) this.analysislist7 = new java.util.LinkedList();
		this.analysislist7.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist8 () {
		return this.analysislist8;
	}
	/**
	 */
	public void setAnalysislist8 (java.util.List analysislist8) {
		this.analysislist8 = analysislist8;
	}	
	public void addToAnalysislist8 (Object obj) {
		if (null == this.analysislist8) this.analysislist8 = new java.util.LinkedList();
		this.analysislist8.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist9 () {
		return this.analysislist9;
	}
	/**
	 */
	public void setAnalysislist9 (java.util.List analysislist9) {
		this.analysislist9 = analysislist9;
	}	
	public void addToAnalysislist9 (Object obj) {
		if (null == this.analysislist9) this.analysislist9 = new java.util.LinkedList();
		this.analysislist9.add(obj);
	}
	
	
	/**
	 */
	public java.util.List getAnalysislist10 () {
		return this.analysislist10;
	}
	/**
	 */
	public void setAnalysislist10 (java.util.List analysislist10) {
		this.analysislist10 = analysislist10;
	}	
	public void addToAnalysislist10 (Object obj) {
		if (null == this.analysislist10) this.analysislist10 = new java.util.LinkedList();
		this.analysislist10.add(obj);
	}
	
	public String getDashboardtype1 () {		return this.dashboardtype1;	}
	public void setDashboardtype1 (String dashboardtype1) {	this.dashboardtype1 = dashboardtype1;	}

	public String getDashboardtype2 () {		return this.dashboardtype2;	}
	public void setDashboardtype2 (String dashboardtype2) {	this.dashboardtype2 = dashboardtype2;	}

	public String getDashboardtype3 () {		return this.dashboardtype3;	}
	public void setDashboardtype3 (String dashboardtype3) {	this.dashboardtype3 = dashboardtype3;	}

	public String getDashboardtype4 () {		return this.dashboardtype4;	}
	public void setDashboardtype4 (String dashboardtype4) {	this.dashboardtype4 = dashboardtype4;	}

	public String getDashboardtype5 () {		return this.dashboardtype5;	}
	public void setDashboardtype5 (String dashboardtype5) {	this.dashboardtype5 = dashboardtype5;	}

	public String getDashboardtype6 () {		return this.dashboardtype6;	}
	public void setDashboardtype6 (String dashboardtype6) {	this.dashboardtype6 = dashboardtype6;	}

	public String getDashboardtype7 () {		return this.dashboardtype7;	}
	public void setDashboardtype7 (String dashboardtype7) {	this.dashboardtype7 = dashboardtype7;	}

	public String getDashboardtype8 () {		return this.dashboardtype8;	}
	public void setDashboardtype8 (String dashboardtype8) {	this.dashboardtype8 = dashboardtype8;	}

	public String getDashboardtype9 () {		return this.dashboardtype9;	}
	public void setDashboardtype9 (String dashboardtype9) {	this.dashboardtype9 = dashboardtype9;	}

	public String getDashboardtype10 () {		return this.dashboardtype10;	}
	public void setDashboardtype10 (String dashboardtype10) {	this.dashboardtype10 = dashboardtype10;	}



	public String getDaterangedays1 () {		return this.daterangedays1;	}
	public void setDaterangedays1 (String daterangedays1) {	this.daterangedays1 = daterangedays1;	}

	public String getDaterangedays2 () {		return this.daterangedays2;	}
	public void setDaterangedays2 (String daterangedays2) {	this.daterangedays2 = daterangedays2;	}

	public String getDaterangedays3 () {		return this.daterangedays3;	}
	public void setDaterangedays3 (String daterangedays3) {	this.daterangedays3 = daterangedays3;	}

	public String getDaterangedays4 () {		return this.daterangedays4;	}
	public void setDaterangedays4 (String daterangedays4) {	this.daterangedays4 = daterangedays4;	}

	public String getDaterangedays5 () {		return this.daterangedays5;	}
	public void setDaterangedays5 (String daterangedays5) {	this.daterangedays5 = daterangedays5;	}

	public String getDaterangedays6 () {		return this.daterangedays6;	}
	public void setDaterangedays6 (String daterangedays6) {	this.daterangedays6 = daterangedays6;	}

	public String getDaterangedays7 () {		return this.daterangedays7;	}
	public void setDaterangedays7 (String daterangedays7) {	this.daterangedays7 = daterangedays7;	}

	public String getDaterangedays8 () {		return this.daterangedays8;	}
	public void setDaterangedays8 (String daterangedays8) {	this.daterangedays8 = daterangedays8;	}

	public String getDaterangedays9 () {		return this.daterangedays9;	}
	public void setDaterangedays9 (String daterangedays9) {	this.daterangedays9 = daterangedays9;	}

	public String getDaterangedays10 () {		return this.daterangedays10;	}
	public void setDaterangedays10 (String daterangedays10) {	this.daterangedays10 = daterangedays10;	}

	
	
	public User getUser () {		return this.user;	}
	public void setUser(User user) {	this.user = user;	}
	
	
	
}
