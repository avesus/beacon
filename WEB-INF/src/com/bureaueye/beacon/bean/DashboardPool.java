package com.bureaueye.beacon.bean;


import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Userdashboard;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;
import com.bureaueye.beacon.model.standard.bd.UserdashboardBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;




public class DashboardPool {

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(com.bureaueye.beacon.bean.Constants.PACKAGE); 




	// constructors
	public DashboardPool() {
	}
	public DashboardPool(SessionFactory _factory) {
		setSessionFactory1(_factory);		
	}
	public DashboardPool(SessionFactory _factory1, SessionFactory _factory2) {
		setSessionFactory1(_factory1);
		setSessionFactory2(_factory2);
	}	



	public DashboardPool(Map<String, SessionFactory> sfcm) {
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
	private List dashboardlist1;
	private List dashboardlist2;
	private List dashboardlist3;
	private List dashboardlist4;
	private List dashboardlist5;
	private List dashboardlist6;
	private List dashboardlist7;
	private List dashboardlist8;
	private List dashboardlist9;	
	private List dashboardlist10;

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



	/**
	 */
	public java.util.List getDashboardlist1 () {
		return this.dashboardlist1;
	}
	/**
	 */
	public void setDashboardlist1 (java.util.List dashboardlist1) {
		this.dashboardlist1 = dashboardlist1;
	}	
	public void addToDashboardlist1 (Object obj) {
		if (null == this.dashboardlist1) this.dashboardlist1 = new java.util.LinkedList();
		this.dashboardlist1.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist2 () {
		return this.dashboardlist2;
	}
	/**
	 */
	public void setDashboardlist2 (java.util.List dashboardlist2) {
		this.dashboardlist2 = dashboardlist2;
	}	
	public void addToDashboardlist2 (Object obj) {
		if (null == this.dashboardlist2) this.dashboardlist2 = new java.util.LinkedList();
		this.dashboardlist2.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist3 () {
		return this.dashboardlist3;
	}
	/**
	 */
	public void setDashboardlist3 (java.util.List dashboardlist3) {
		this.dashboardlist3 = dashboardlist3;
	}	
	public void addToDashboardlist3 (Object obj) {
		if (null == this.dashboardlist3) this.dashboardlist3 = new java.util.LinkedList();
		this.dashboardlist3.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist4 () {
		return this.dashboardlist4;
	}
	/**
	 */
	public void setDashboardlist4 (java.util.List dashboardlist4) {
		this.dashboardlist4 = dashboardlist4;
	}	
	public void addToDashboardlist4 (Object obj) {
		if (null == this.dashboardlist4) this.dashboardlist4 = new java.util.LinkedList();
		this.dashboardlist4.add(obj);
	}	


	/**
	 */
	public java.util.List getDashboardlist5 () {
		return this.dashboardlist5;
	}
	/**
	 */
	public void setDashboardlist5 (java.util.List dashboardlist5) {
		this.dashboardlist5 = dashboardlist5;
	}	
	public void addToDashboardlist5 (Object obj) {
		if (null == this.dashboardlist5) this.dashboardlist5 = new java.util.LinkedList();
		this.dashboardlist5.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist6 () {
		return this.dashboardlist6;
	}
	/**
	 */
	public void setDashboardlist6 (java.util.List dashboardlist6) {
		this.dashboardlist6 = dashboardlist6;
	}	
	public void addToDashboardlist6 (Object obj) {
		if (null == this.dashboardlist6) this.dashboardlist6 = new java.util.LinkedList();
		this.dashboardlist6.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist7 () {
		return this.dashboardlist7;
	}
	/**
	 */
	public void setDashboardlist7 (java.util.List dashboardlist7) {
		this.dashboardlist7 = dashboardlist7;
	}	
	public void addToDashboardlist7 (Object obj) {
		if (null == this.dashboardlist7) this.dashboardlist7 = new java.util.LinkedList();
		this.dashboardlist7.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist8 () {
		return this.dashboardlist8;
	}
	/**
	 */
	public void setDashboardlist8 (java.util.List dashboardlist8) {
		this.dashboardlist8 = dashboardlist8;
	}	
	public void addToDashboardlist8 (Object obj) {
		if (null == this.dashboardlist8) this.dashboardlist8 = new java.util.LinkedList();
		this.dashboardlist8.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist9 () {
		return this.dashboardlist9;
	}
	/**
	 */
	public void setDashboardlist9 (java.util.List dashboardlist9) {
		this.dashboardlist9 = dashboardlist9;
	}	
	public void addToDashboardlist9 (Object obj) {
		if (null == this.dashboardlist9) this.dashboardlist9 = new java.util.LinkedList();
		this.dashboardlist9.add(obj);
	}


	/**
	 */
	public java.util.List getDashboardlist10 () {
		return this.dashboardlist10;
	}
	/**
	 */
	public void setDashboardlist10 (java.util.List dashboardlist10) {
		this.dashboardlist10 = dashboardlist10;
	}	
	public void addToDashboardlist10 (Object obj) {
		if (null == this.dashboardlist10) this.dashboardlist10 = new java.util.LinkedList();
		this.dashboardlist10.add(obj);
	}




	public void setWORKFLOW_PENDING_APPROVAL() throws Exception {	
		//WORKFLOW_PENDING_APPROVAL
		try {
			dashboardlist1=new LinkedList();
			daterangedays1="";
			dashboardtype1="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "WORKFLOW_PENDING_APPROVAL");				
			if (dao!= null) {	

				daterangedays1=dao.getDaterangedays();
				dashboardtype1=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Quotedate");
				listForm.setOrderByDesc("");				
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");				
				listForm.setSearchString2("");

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool1 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist1=new QuoapproveBD(this.getSessionFactoryClusterMap()).findQuoapprovesForDashboard(listForm);	

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool1 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist1.size: "+dashboardlist1.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("WORKFLOW_PENDING_APPROVAL - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("WORKFLOW_PENDING_APPROVAL - Exception: "+e.getMessage());				 
		}
	}	


	public void setQUOTATIONS_EXPIRING() throws Exception {	
		//QUOTATIONS_EXPIRING
		try {
			dashboardlist2=new LinkedList();
			daterangedays2="";
			dashboardtype2="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "QUOTATIONS_EXPIRING");				
			if (dao!= null) {	

				daterangedays2=dao.getDaterangedays();
				dashboardtype2=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Expirydate");
				listForm.setOrderByDesc("");				
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");

				Calendar c = Calendar.getInstance();
				int dateRangeDays = 7;
				try{dateRangeDays = new Integer(dao.getDaterangedays()).intValue();}catch(Exception e){}
				// date 'from'			
				// default 'from' date to today
				try {listForm.setSearchDate1(c.getTime());} catch (Exception e) {}					
				// date 'to'				
				// default 'to' date plus date range days 
				c.add(Calendar.DATE,dateRangeDays);
				try {listForm.setSearchDate2(c.getTime());} catch (Exception e) {}								

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool2 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist2=new QuohdrBD(this.getSessionFactoryClusterMap()).findQuohdrsForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool2 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist2.size: "+dashboardlist2.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("QUOTATIONS_EXPIRING - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("QUOTATIONS_EXPIRING - Exception: "+e.getMessage());				 
		}
	}	


	public void setSALES_INVOICES_TO_BUILD() throws Exception {	
		//SALES_INVOICES_TO_BUILD
		try {
			dashboardlist3=new LinkedList();
			daterangedays3="";
			dashboardtype3="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "SALES_INVOICES_TO_BUILD");				
			if (dao!= null) {	

				daterangedays3=dao.getDaterangedays();
				dashboardtype3=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Orderdate");
				listForm.setOrderByDesc("");				
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");						
				listForm.setSearchString2(com.bureaueye.beacon.bean.Constants.READY_STATUS);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool3 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist3=new OrderchargeBD(this.getSessionFactoryClusterMap()).findOrderchargesForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool3 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist3.size: "+dashboardlist3.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("SALES_INVOICES_TO_BUILD - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("SALES_INVOICES_TO_BUILD - Exception: "+e.getMessage());				 
		}
	}	


	public void setSALES_INVOICES_TO_PRINT() throws Exception {	
		//SALES_INVOICES_TO_PRINT
		try {
			dashboardlist4=new LinkedList();
			daterangedays4="";
			dashboardtype4="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "SALES_INVOICES_TO_PRINT");				
			if (dao!= null) {	

				daterangedays4=dao.getDaterangedays();
				dashboardtype4=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("SIHDR_ID");
				listForm.setOrderByDesc("");				
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");						
				listForm.setSearchString2("N");

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool4 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist4=new SihdrBD(this.getSessionFactoryClusterMap()).findSihdrsForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool4 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist4.size: "+dashboardlist4.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("SALES_INVOICES_TO_PRINT - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("SALES_INVOICES_TO_PRINT - Exception: "+e.getMessage());				 
		}
	}	


	public void setJOB_MOVEMENTS_TO_ACTUALISE() throws Exception {	
		//JOB_MOVEMENTS_TO_ACTUALISE
		try {
			dashboardlist5=new LinkedList();
			daterangedays5="";
			dashboardtype5="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "JOB_MOVEMENTS_TO_ACTUALISE");				
			if (dao!= null) {	

				daterangedays5=dao.getDaterangedays();
				dashboardtype5=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Totimeinmillis");
				listForm.setOrderByDesc("asc");	
				listForm.setOrderBy2("Fromtimeinmillis");
				listForm.setOrderBy2Desc("asc");
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");						

				Calendar c = Calendar.getInstance();
				int dateRangeDays = 7;
				try{dateRangeDays = new Integer(dao.getDaterangedays()).intValue();}catch(Exception e){}
				// date 'from'			
				// default 'from' date to today
				try {listForm.setSearchDate1(c.getTime());} catch (Exception e) {}					
				// date 'to'				
				// default 'to' date plus date range days 
				c.add(Calendar.DATE,dateRangeDays);
				try {listForm.setSearchDate2(c.getTime());} catch (Exception e) {}						

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool5 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist5=new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovsForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool5 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist5.size: "+dashboardlist5.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("JOB_MOVEMENTS_TO_ACTUALISE - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("JOB_MOVEMENTS_TO_ACTUALISE - Exception: "+e.getMessage());				 
		}
	}	


	public void setVENDOR_TARIFFS_EXPIRING() throws Exception {	
		//	VENDOR_TARIFFS_EXPIRING
		try {
			dashboardlist6=new LinkedList();
			daterangedays6="";
			dashboardtype6="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "VENDOR_TARIFFS_EXPIRING");				
			if (dao!= null) {	

				daterangedays6=dao.getDaterangedays();
				dashboardtype6=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Validto");
				listForm.setOrderByDesc("desc");	
				listForm.setOrderBy2("");
				listForm.setOrderBy2Desc("");
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");						

				Calendar c = Calendar.getInstance();
				int dateRangeDays = 7;
				try{dateRangeDays = new Integer(dao.getDaterangedays()).intValue();}catch(Exception e){}
				// date 'from'			
				// default 'from' date to today
				try {listForm.setSearchDate1(c.getTime());} catch (Exception e) {}					
				// date 'to'				
				// default 'to' date plus date range days 
				c.add(Calendar.DATE,dateRangeDays);
				try {listForm.setSearchDate2(c.getTime());} catch (Exception e) {}						

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool6 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist6=new VendortariffhdrBD(this.getSessionFactoryClusterMap()).findVendortariffhdrsForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool6 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist6.size: "+dashboardlist6.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("VENDOR_TARIFFS_EXPIRING - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("VENDOR_TARIFFS_EXPIRING - Exception: "+e.getMessage());				 
		}
	}	
	

	public void setCUSTOMER_TARIFFS_EXPIRING() throws Exception {	
		//	CUSTOMER_TARIFFS_EXPIRING
		try {
			dashboardlist7=new LinkedList();
			daterangedays7="";
			dashboardtype7="";

			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "CUSTOMER_TARIFFS_EXPIRING");				
			if (dao!= null) {	

				daterangedays7=dao.getDaterangedays();
				dashboardtype7=dao.getDashboardtype();

				ListForm listForm = new ListForm();
				listForm.setOrderBy("Validto");
				listForm.setOrderByDesc("desc");	
				listForm.setOrderBy2("");
				listForm.setOrderBy2Desc("");
				listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
				listForm.setSearchString1(user.getUserid());
				if (dao.getDashboardtype().equals("ALL")) listForm.setSearchString1("%");						

				Calendar c = Calendar.getInstance();
				int dateRangeDays = 7;
				try{dateRangeDays = new Integer(dao.getDaterangedays()).intValue();}catch(Exception e){}
				// date 'from'			
				// default 'from' date to today
				try {listForm.setSearchDate1(c.getTime());} catch (Exception e) {}					
				// date 'to'				
				// default 'to' date plus date range days 
				c.add(Calendar.DATE,dateRangeDays);
				try {listForm.setSearchDate2(c.getTime());} catch (Exception e) {}						

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool7 Parameters: "+
						" listForm parameters: "+listForm.toString()
				);

				dashboardlist7=new CustomertariffhdrBD(this.getSessionFactoryClusterMap()).findCustomertariffhdrsForDashboard(listForm);

				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" setDashboardPool7 Parameters: "+
						" dashboardid: "+dao.getDashboardid()+						
						" dashboardtype: "+dao.getDashboardtype()+
						" daterangedays: "+dao.getDaterangedays()+
						" dashboardlist7.size: "+dashboardlist7.size()
				);

			}//if (dao!= null)

		} catch (ApplicationException ae) {	
			throw new Exception("CUSTOMER_TARIFFS_EXPIRING - ApplicationException: "+ae.getMessage());					
		} catch (Exception e) {	
			throw new Exception("CUSTOMER_TARIFFS_EXPIRING - Exception: "+e.getMessage());				 
		}
	}	
	

	public static void setPool(HttpSession session, DashboardPool pool) {
		session.setAttribute(com.bureaueye.beacon.bean.Constants.DASHBOARD_POOL_KEY, pool);
	}

	public static DashboardPool getPool(HttpSession session) {
		DashboardPool pool=(DashboardPool)session.getAttribute(com.bureaueye.beacon.bean.Constants.DASHBOARD_POOL_KEY);
		return pool;
	}



}
