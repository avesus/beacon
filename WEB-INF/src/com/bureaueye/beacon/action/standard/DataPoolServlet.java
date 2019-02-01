package com.bureaueye.beacon.action.standard;


import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



/**
 * 
 * Amendments
 * ----------
 * 												
 * NT	2012-07-26		ITT-201207-0001		Add Contract Type 
 *   
 */
public class DataPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 
	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory
			.getLog(com.bureaueye.beacon.bean.Constants.PACKAGE);

	
	
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
	
	
	// ------------------------------------------------------ Protected Methods

	//Initialize global variables
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

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
				" setSessionFactoryCluster3: "+this.getSessionFactoryClusterMap().toString());
		
		

		
		// Instantiate the DataPool
		DataPool dataPool = new DataPool(this.getSessionFactoryClusterMap());
		 
		
		try {			
			dataPool.setADDRESSS();
			
			dataPool.setLESSEES();
			dataPool.setLESSORS();
			dataPool.setAGENTS();
			dataPool.setOWNERS();
			
			dataPool.setCONSIGNEES();
			dataPool.setCUSTOMERS();
			dataPool.setSHIPPERS();
			dataPool.setBROKERS();
			dataPool.setFWDAGENTS();
			dataPool.setVENDORS();
			
			dataPool.setCUSTOMERLESSEES();

			
			dataPool.setLocations();
			
			dataPool.setDEPOTS();
			dataPool.setPORTS();
			dataPool.setPLANTS();			
			dataPool.setPIERS();			


			dataPool.setDeliverylocations1();
			dataPool.setPickuplocations1();
			dataPool.setDeliverylocations2();
			dataPool.setPickuplocations2();

			
			dataPool.setAddrtypes();
			dataPool.setLocationtypes();
			

			dataPool.setStatuscodes(); 
			
			dataPool.setCcys();
			dataPool.setRejectreasons();
			dataPool.setDispositions();
			dataPool.setUsers();
			dataPool.setUsergroups();
			dataPool.setCharges();
			dataPool.setCosts();
			dataPool.setSections();			


			dataPool.setVessels();
			
			dataPool.setMonths();
			dataPool.setDays();
			dataPool.setYears();
			dataPool.setHours();
			dataPool.setMinutes();
			
			dataPool.setActivitys();
			dataPool.setDepartments();
			dataPool.setCompanys();
			dataPool.setShipmethods();
			dataPool.setCitys();
			dataPool.setCountrys();
			dataPool.setTransportmodes();
			dataPool.setTesttypes();

			dataPool.setLeasetypes();
			
			// tempunits list
			dataPool.setTempunits(); 
			
			// wghtunits list
			dataPool.setWghtunits(); 
	
			// volunits list
			dataPool.setVolunits();
				
			// priority list
			dataPool.setPrioritys();				

			// note category list
			dataPool.setNotecatgs();

			// invoice status list
			dataPool.setInvoicestatuss();
			
			// tax code list
			dataPool.setTaxcodes();

			// company header list
			dataPool.setCompanyheaders();

			// page results list
			dataPool.setPageresults();
			
			
			// equipment param 1 list
			dataPool.setEqpkeyp1s();
			// equipment param 2 list
			dataPool.setEqpkeyp2s();
			// equipment param 3 list
			dataPool.setEqpkeyp3s();
			// equipment param 4 list
			dataPool.setEqpkeyp4s();
			// equipment param 5 list
			dataPool.setEqpkeyp5s();

			
			
			// movement status list
			dataPool.setMovestatuss();

			dataPool.setProducts();			

			dataPool.setFitgrps();	
			dataPool.setFittyps();	

			dataPool.setIncoterms();	
			
			dataPool.setDamagecodes();
			dataPool.setRepaircodes();
			dataPool.setMaterialtypecodes();
			dataPool.setRepairstatuss();
			dataPool.setLocationcode1s();
			dataPool.setLocationcode2s();
			dataPool.setComponentcodes();
			dataPool.setResponsibilitycodes();
			dataPool.setUnitmeasurecodes();			

			dataPool.setMandrcancelreasons();	
			dataPool.setMandrcosts();

			dataPool.setProductcolors();
			dataPool.setProductfleetgroups();
			dataPool.setProductcategorys();

			dataPool.setImdgs();

			
			dataPool.setG1codes();
			dataPool.setG2codes();
			dataPool.setG3codes();
			dataPool.setG4codes();

			dataPool.setDoctypes();	
			dataPool.setCategorys();
			dataPool.setSubcategorys();

			
			
			dataPool.setContracttypes();//ITT-201207-0001
			
			
		} catch (ApplicationException e) {		
			throw new ServletException(e);
		}

	
	
		// ... MORE DATA FOR THE POOL ADD HERE

		// Once the pool is Initailized, add it to the
		// Global ServletContext.  This makes it available
		// To other servlets using the same ServletContext.
		context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,
				dataPool);
		// 
		log.debug(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY
				+ " added to ServletContext");

	}

	//Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set the response content-type
		response.setContentType("text/html");
		// get the Writer object
		PrintWriter out = response.getWriter();
		out.println("This Servlet does not service requests!");
		out.close();
	}

	public void destroy() {

		// Remove the Attribute from the ServletContext
		getServletContext().removeAttribute(
				com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
		log.debug(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY
				+ " destroyed");
	}

	//Get Servlet information
	public String getServletInfo() {
		return "DataPoolServlet Information";
	}

	public HashMap setAddresss(String type, String orderBy) throws Exception {
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		List list = null;
		try {
			list = new AddressBD(this.getSessionFactoryClusterMap()).findAddressesByType(type, orderBy);
		} catch (Exception e) {
			throw new Exception("setAddresss.Exception", e);
		}
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Address object = (Address) iter.next();
			hm.put(object, object.getAddrkey());
		}

		return hm;
	}

	public HashMap setLocations(String type, String orderBy) throws Exception {
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		List list = null;
		try {
			list = new LocationBD(this.getSessionFactoryClusterMap()).findLocationsByType(type, orderBy);
		} catch (Exception e) {
			throw new Exception("setLocations.Exception", e);
		}
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Location object = (Location) iter.next();
			hm.put(object, object.getLocationkey());
		}

		return hm;
	}

}
