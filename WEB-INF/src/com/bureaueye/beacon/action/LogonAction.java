package com.bureaueye.beacon.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.AnalysisPool;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.LabelValue;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Userdashboard;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.model.standard.bd.UserdashboardBD;
import com.bureaueye.beacon.model.standard.bd.UsergroupmenuBD;
import com.bureaueye.beacon.model.standard.bd.UsermenuBD;
import com.bureaueye.beacon.model.task.Task;
import com.bureaueye.beacon.model.task.bd.TaskBD;
import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;


/**
 * 
 * Amendments ----------
 * 
 * NT	2009-03-23	ITT-200904-0001	Add Concurrent User Check
 * 
 * NT	2013-12-01	WSI-201312-0004	BEACON LAKER (WSI LINER) 
 * 
 */
public final class LogonAction extends Action {

	/**
	 * Name of userid field ["userid"].
	 */
	static String USERID = "userid";

	/**
	 * Name of userid field ["usergroupid"].
	 */
	static String USERGROUPID = "usergroupid";

	/**
	 * Name of password field ["password"].
	 */
	static String PASSWORD = "password";

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


	// ------------------------------------------------------ Protected Methods

	/**
	 * <p>
	 * Confirm user credentials. Post any errors and return User object (or
	 * null).
	 * </p>
	 * 
	 * @param database
	 *            Database in which to look up the user
	 * @param username
	 *            Username specified on the logon form
	 * @param password
	 *            Password specified on the logon form
	 * @param errors
	 *            ActionMessages queue to passback errors
	 * 
	 * @return Validated User object or null
	 * @throws ExpiredPasswordException
	 *             to be handled by Struts exception processor via the
	 *             action-mapping
	 */

	/**
	 * <p>
	 * Store User object in client session. If user object is null, any existing
	 * user object is removed.
	 * </p>
	 * 
	 * @param request
	 *            The request we are processing
	 * @param user
	 *            The user object returned from the database
	 */
	void SaveUser(HttpServletRequest request, User user) {

		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY, user);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" LogonAction: User '" + user.getUserid()
				+ "' logged on in session " + session.getId());

	}

	void SaveSystem(HttpServletRequest request, SystemX system) {

		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.SYSTEM_KEY, system);

	}


	void saveBreadcrumb(HttpServletRequest request, Map breadcrumbMap) {

		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.Constants.BREADCRUMB_KEY, breadcrumbMap);

	}



	void SaveLocale(HttpServletRequest request, User user) {
		String language = user.getLanguage();
		String country = user.getCountry();

		Locale locale = getLocale(request);

		if (!language.equals("") && !country.equals("")) {
			locale = new Locale(language, country);
		} else if (!language.equals("")) {
			locale = new Locale(language, "");
		}
		HttpSession session = request.getSession();
		session.setAttribute(Globals.LOCALE_KEY, locale);
	}



	void SaveUsermenus(HttpServletRequest request, List usermenus) {
		//if (usermenus != null) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USERMENUS_KEY, usermenus);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		" Add USERMENUS to session");

		//}
	}

	void SaveUsergroupmenus(HttpServletRequest request, List usergroupmenus) {
		//if (usermenus != null) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USERMENUS_KEY, usergroupmenus);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		" Add USERGROUPMENUS to session");

		//}
	}




	void SaveUsercompanykeylist(HttpServletRequest request, List list) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USERCOMPANYKEYLIST, list);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		" Add USERCOMPANYKEYLIST to session");
	}
	void SaveUserdepartmentkeylist(HttpServletRequest request, List list) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USERDEPARTMENTKEYLIST, list);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		" Add USERDEPARTMENTKEYLIST to session");
	}	
	void SaveUseractivitykeylist(HttpServletRequest request, List list) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.standard.Constants.USERACTIVITYKEYLIST, list);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		" Add USERACTIVITYKEYLIST to session");
	}	








	// --------------------------------------------------------- Public Methods

	/**
	 * Use "username" and "password" fields from ActionForm to retrieve a User
	 * object from the database. If credentials are not valid, or database has
	 * disappeared, post error messages and forward to input.
	 * 
	 * @param mapping
	 *            The ActionMapping used to select this instance
	 * @param form
	 *            The optional ActionForm bean for this request (if any)
	 * @param request
	 *            The HTTP request we are processing
	 * @param response
	 *            The HTTP response we are creating
	 * 
	 * @exception Exception
	 *                if the application business logic throws an exception
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {


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



		// Local variables
		String userid = (String) PropertyUtils.getSimpleProperty(form, USERID);
		String password = (String) PropertyUtils.getSimpleProperty(form, PASSWORD);
		ActionMessages errors = new ActionMessages();

		// Retrieve user from Business Delegate

		User user = null;
		try {
			user = new UserBD(this.getSessionFactoryClusterMap()).read(userid);
		} catch (ApplicationException he) {			
		}

		if ((user != null) && !user.getPassword().equals(password)) {
			user = null;
		}		
		if (user == null) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"error.password.mismatch"));
		}


		// check concurrent user limit
		try {		
			PropertyResourceBundle props = (PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.LicenseResources");
			Integer concurrentuserlimit=0;
			try{concurrentuserlimit=new Integer(props.getString ("concurrent.user.limit"));} catch (Exception e) {}
			if (concurrentuserlimit!=null && concurrentuserlimit>0) {
				Integer numusers=(Integer)servlet.getServletContext().getAttribute("numUsers");
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"Concurrent User Limit check: "+
						"numusers["+numusers+"]: "+
						"concurrentuserlimit["+concurrentuserlimit+"]: "+
						"numusers.compareTo(concurrentuserlimit)["+concurrentuserlimit.compareTo(numusers)+"]"
				);
				if (concurrentuserlimit.compareTo(numusers) <= 0) {
					errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
							"error.concurrentuserlimit.exceeded",concurrentuserlimit));
				}
			}
		} catch (NullPointerException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					"Concurrent User Limit check - NullPointerException: "+e.getMessage());			  
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					"Concurrent User Limit check - Exception: "+e.getMessage());			
		}     

		// check licence expiry
		try {
			PropertyResourceBundle props = (PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.LicenseResources");		 
			Calendar cal = Calendar.getInstance();
			cal.set(new Integer(props.getString ("expirydateyyyy")).intValue(),
					new Integer(props.getString ("expirydatemm")).intValue()-1,
					new Integer(props.getString ("expirydatedd")).intValue(),0,0);
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" License Expiry check - Expiry Date ["+cal.getTime()+"]");	
			if (new Date().after(cal.getTime())) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"error.licence.expired"));
			}
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Licence Expiry check - Exception: "+e.getMessage());			
		}

		//error.licence.expired
		// Report back any errors, and exit if any
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

		// Retrieve user from Business Delegate
		SystemX systemX = null;
		try {systemX = new SystemXBD(this.getSessionFactoryClusterMap()).findSystem();} catch (ApplicationException he) {}
		SaveSystem(request, systemX);


		// Save breadcrumb object
		Map breadcrumbMap = new HashMap();
		saveBreadcrumb(request, breadcrumbMap);


		// Save user object
		SaveUser(request, user);
		SaveLocale(request, user);
		List usermenus = null;	
		usermenus = new UsermenuBD(this.getSessionFactoryClusterMap()).findUsermenusById(user.getUserid());

		// check user menus found
		if (usermenus != null && !usermenus.isEmpty()) {
			SaveUsermenus(request, usermenus);		
			// if user menus are empty then try to find menus for user group
		} else {
			// find user group menus
			usermenus = new UsergroupmenuBD(this.getSessionFactoryClusterMap()).findUsergroupmenusById(user.getUsergroupid());
			SaveUsergroupmenus(request, usermenus);
		}



		try {
			List usercompanykeylist = new LinkedList();	
			List companys = new CompanyBD(this.getSessionFactoryClusterMap()).findCompanys();
			//build company map
			StringTokenizer stringTokenizer = null;
			stringTokenizer = new StringTokenizer(user.getCompanykeylist(), "|");
			Map<String,String> keyMap = new HashMap<String,String>();
			while ( stringTokenizer.hasMoreTokens() ) { 			
				String key =stringTokenizer.nextToken();
				keyMap.put(key, key);  
			}  			
			// iterate results to initialise DAO list				
			for (Iterator it = companys.iterator(); it.hasNext();) {
				Company dao=(Company)it.next();			
				if (keyMap.get(dao.getCompid())!=null) usercompanykeylist.add(dao);			
			}		
			SaveUsercompanykeylist(request, usercompanykeylist);		
		} catch (Exception e) {
		}

		try{
			List userdepartmentkeylist = new LinkedList();	
			List departments = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("DEPARTMENT");
			//build department map
			StringTokenizer stringTokenizer = null;
			stringTokenizer = new StringTokenizer(user.getDepartmentkeylist(), "|");
			Map<String,String> keyMap = new HashMap<String,String>();
			while ( stringTokenizer.hasMoreTokens() ) { 			
				String key =stringTokenizer.nextToken();
				keyMap.put(key, key);  
			} 			
			// iterate results to initialise DAO list 	
			for (Iterator it = departments.iterator(); it.hasNext();) {
				Systemcode dao=(Systemcode)it.next();
				if (keyMap.get(dao.getId().getCodekey())!=null) userdepartmentkeylist.add(dao);			
			}		
			SaveUserdepartmentkeylist(request, userdepartmentkeylist);	
		} catch (Exception e) {
		}

		try {
			List useractivitykeylist = new LinkedList();	
			List activitys = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("ACTIVITY");
			//build activity map
			StringTokenizer stringTokenizer = null;
			stringTokenizer = new StringTokenizer(user.getActivitykeylist(), "|");
			Map<String,String> keyMap = new HashMap<String,String>();
			while ( stringTokenizer.hasMoreTokens() ) { 			
				String key =stringTokenizer.nextToken();
				keyMap.put(key, key);  
			} 			
			// iterate results to initialise DAO list 	
			for (Iterator it = activitys.iterator(); it.hasNext();) {
				Systemcode dao=(Systemcode)it.next();				
				if (keyMap.get(dao.getId().getCodekey())!=null) useractivitykeylist.add(dao);			
			}		
			SaveUseractivitykeylist(request, useractivitykeylist);	
		} catch (Exception e) {
		}





		setAnalysisPool(request, user);




		// Otherwise, return "success"
		return findSuccess(mapping);

	}



	void SaveAnalysisPool(HttpServletRequest request, AnalysisPool pool) {
		//if (usermenus != null) {
		HttpSession session = request.getSession();
		session.setAttribute(com.bureaueye.beacon.bean.Constants.ANALYSIS_POOL_KEY, pool);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Add "+com.bureaueye.beacon.bean.Constants.ANALYSIS_POOL_KEY+" to session");

		//}
	}


	void setAnalysisPool(HttpServletRequest request, User user) {

		// Instantiate the Analysis Pool
		AnalysisPool analysisPool = new AnalysisPool(this.getSessionFactoryClusterMap());


		try {	
			ListForm listForm1 = new ListForm();
			ListForm listForm2 = new ListForm();
			String wildCard = "%";

			Calendar currentMonth = Calendar.getInstance();
			Calendar currentYear = Calendar.getInstance();
			//  set 'TO' date 
			listForm1.setSearchDate2(currentMonth.getTime());
			listForm2.setSearchDate2(currentYear.getTime());

			currentMonth.set(Calendar.DAY_OF_MONTH, 1);
			listForm1.setSearchDate1(currentMonth.getTime());		
			currentYear.set(Calendar.DAY_OF_YEAR, 1);
			listForm2.setSearchDate1(currentYear.getTime());

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" setAnalysisPool ListForm1 Parameters: "+listForm1.toString()
			);

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" setAnalysisPool ListForm2 Parameters: "+listForm2.toString()
			);


			List dashboardlist=new LinkedList();
			String daterangedays="";
			String dashboardtype="";
			int count =0; 
			LabelValue labelValue = null;


			labelValue = new LabelValue();
			labelValue.setValue("");
			analysisPool.addToAnalysislist1(labelValue);			
			analysisPool.setDashboardtype1(dashboardtype);
			analysisPool.setDaterangedays1(daterangedays);
			analysisPool.addToAnalysislist2(labelValue);			
			analysisPool.setDashboardtype2(dashboardtype);
			analysisPool.setDaterangedays2(daterangedays);
			analysisPool.addToAnalysislist3(labelValue);			
			analysisPool.setDashboardtype3(dashboardtype);
			analysisPool.setDaterangedays3(daterangedays);
			analysisPool.addToAnalysislist4(labelValue);			
			analysisPool.setDashboardtype4(dashboardtype);
			analysisPool.setDaterangedays4(daterangedays);
			analysisPool.addToAnalysislist5(labelValue);			
			analysisPool.setDashboardtype5(dashboardtype);
			analysisPool.setDaterangedays5(daterangedays);
			analysisPool.addToAnalysislist6(labelValue);			
			analysisPool.setDashboardtype6(dashboardtype);
			analysisPool.setDaterangedays6(daterangedays);
			analysisPool.addToAnalysislist7(labelValue);			
			analysisPool.setDashboardtype7(dashboardtype);
			analysisPool.setDaterangedays7(daterangedays);
			analysisPool.addToAnalysislist8(labelValue);			
			analysisPool.setDashboardtype8(dashboardtype);
			analysisPool.setDaterangedays8(daterangedays);
			analysisPool.addToAnalysislist9(labelValue);			
			analysisPool.setDashboardtype9(dashboardtype);
			analysisPool.setDaterangedays9(daterangedays);
			analysisPool.addToAnalysislist10(labelValue);			
			analysisPool.setDashboardtype10(dashboardtype);
			analysisPool.setDaterangedays10(daterangedays);



			//-----------------------------------------------------------------------
			// Quotation analysis
			//-----------------------------------------------------------------------
			// check access for userid and type
			Userdashboard dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "QUOTATION_ANALYSIS");				
			if (dao!= null) {	
				daterangedays=dao.getDaterangedays();
				dashboardtype="ALL";
				analysisPool.setAnalysislist1(null);	
				analysisPool.setAnalysislist2(null);
				analysisPool.setAnalysislist3(null);

				// count quohdrs for month by current month / approved status / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist1(labelValue);		

				// count quohdrs for month by current year / approved status / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist1(labelValue);	

				// count quohdrs for month by current month / approved status / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist1(labelValue);		

				// count quohdrs for month by current year / approved status / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist1(labelValue);	




				// count quohdrs for month by current month / rejected status / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.REJECTED_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist2(labelValue);

				// count quohdrs for month by current year / rejected status / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.REJECTED_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist2(labelValue);

				// count quohdrs for month by current month / rejected status / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.REJECTED_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist2(labelValue);

				// count quohdrs for month by current year / rejected status / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.REJECTED_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist2(labelValue);




				// count quohdrs for month by current month / pending status / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist3(labelValue);

				// count quohdrs for month by current year / pending status / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist3(labelValue);

				// count quohdrs for month by current month / pending status / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist3(labelValue);

				// count quohdrs for month by current year / pending status / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new QuohdrBD(this.getSessionFactoryClusterMap())
				.quohdrsCountByQuotestatusQuotedateQuotebyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist3(labelValue);

				analysisPool.setDashboardtype1(dashboardtype);
				analysisPool.setDaterangedays1(daterangedays);
				analysisPool.setDashboardtype2(dashboardtype);
				analysisPool.setDaterangedays2(daterangedays);
				analysisPool.setDashboardtype3(dashboardtype);
				analysisPool.setDaterangedays3(daterangedays);

			}//if (dao!= null) {




			//-----------------------------------------------------------------------
			// Order analysis
			//-----------------------------------------------------------------------
			// check access for userid and type
			dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "ORDER_ANALYSIS");				
			if (dao!= null) {	
				daterangedays=dao.getDaterangedays();
				dashboardtype="ALL";
				analysisPool.setAnalysislist4(null);	
				analysisPool.setAnalysislist5(null);
				analysisPool.setAnalysislist6(null);

				// count orderhdrs for month by current month / FULLY_INVOICED_STATUS / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.FULLY_INVOICED_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist4(labelValue);		

				// count orderhdrs for month by current year / FULLY_INVOICED_STATUS / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.FULLY_INVOICED_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist4(labelValue);	

				// count orderhdrs for month by current month / FULLY_INVOICED_STATUS / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.FULLY_INVOICED_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist4(labelValue);		

				// count orderhdrs for month by current year / FULLY_INVOICED_STATUS / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.FULLY_INVOICED_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist4(labelValue);	



				// count orderhdrs for month by current month / PART_INVOICED_STATUS / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.PART_INVOICED_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist5(labelValue);

				// count orderhdrs for month by current year / PART_INVOICED_STATUS / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.PART_INVOICED_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist5(labelValue);

				// count orderhdrs for month by current month / PART_INVOICED_STATUS / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.PART_INVOICED_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist5(labelValue);

				// count orderhdrs for month by current year / PART_INVOICED_STATUS / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.PART_INVOICED_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist5(labelValue);




				// count orderhdrs for month by current month / NOT_INVOICED_STATUS / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.NOT_INVOICED_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist6(labelValue);

				// count orderhdrs for month by current year / NOT_INVOICED_STATUS / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.NOT_INVOICED_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist6(labelValue);

				// count orderhdrs for month by current month / NOT_INVOICED_STATUS / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.NOT_INVOICED_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist6(labelValue);

				// count orderhdrs for month by current year / NOT_INVOICED_STATUS / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.NOT_INVOICED_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new OrderhdrBD(this.getSessionFactoryClusterMap())
				.orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist6(labelValue);

				analysisPool.setDashboardtype4(dashboardtype);
				analysisPool.setDaterangedays4(daterangedays);
				analysisPool.setDashboardtype5(dashboardtype);
				analysisPool.setDaterangedays5(daterangedays);
				analysisPool.setDashboardtype6(dashboardtype);
				analysisPool.setDaterangedays6(daterangedays);				

			}//if (dao!= null) {




			//-----------------------------------------------------------------------
			// Sales Invoice analysis
			//-----------------------------------------------------------------------
			// check access for userid and type
			dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "SALES_INVOICE_PRINT_ANALYSIS");				
			if (dao!= null) {	
				daterangedays=dao.getDaterangedays();
				dashboardtype="ALL";
				analysisPool.setAnalysislist7(null);	
				analysisPool.setAnalysislist8(null);

				String trueString = "true";
				String falseString = "false";
				// count sihdrs for month by current month / PRINTED / all users
				listForm1.setSearchString1(trueString);
				listForm1.setSearchString2(wildCard);
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist7(labelValue);		

				// count sihdrs for month by current year / PRINTED / all users
				listForm2.setSearchString1(trueString);
				listForm2.setSearchString2(wildCard);
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist7(labelValue);	

				// count sihdrs for month by current month / PRINTED / logon user
				listForm1.setSearchString1(trueString);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist7(labelValue);		

				// count sihdrs for month by current year / PRINTED / logon user
				listForm2.setSearchString1(trueString);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist7(labelValue);	



				// count sihdrs for month by current month / NOT PRINTED / all users
				listForm1.setSearchString1(falseString);
				listForm1.setSearchString2(wildCard);
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist8(labelValue);

				// count sihdrs for month by current year / NOT PRINTED / all users
				listForm2.setSearchString1(falseString);
				listForm2.setSearchString2(wildCard);
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist8(labelValue);

				// count sihdrs for month by current month / NOT PRINTED / logon user
				listForm1.setSearchString1(falseString);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist8(labelValue);

				// count sihdrs for month by current year / NOT PRINTED / logon user
				listForm2.setSearchString1(falseString);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new SihdrBD(this.getSessionFactoryClusterMap())
				.sihdrsCountByPrintedflagCreatedateCreateuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist8(labelValue);

				analysisPool.setDashboardtype7(dashboardtype);
				analysisPool.setDaterangedays7(daterangedays);
				analysisPool.setDashboardtype8(dashboardtype);
				analysisPool.setDaterangedays8(daterangedays);

			}//if (dao!= null) {



			//-----------------------------------------------------------------------
			// sales invoice build analysis
			//-----------------------------------------------------------------------
			dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "SALES_INVOICE_BUILD_ANALYSIS");				
			if (dao!= null) {	
				daterangedays=dao.getDaterangedays();
				dashboardtype="ALL";
				analysisPool.setAnalysislist9(null);	

				// count ordercharges for month by current month / READY_STATUS / all users
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.READY_STATUS);
				listForm1.setSearchString2(wildCard);
				count = 
					new OrderchargeBD(this.getSessionFactoryClusterMap())
				.orderchargesCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist9(labelValue);		

				// count ordercharges for month by current year / READY_STATUS / all users
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.READY_STATUS);
				listForm2.setSearchString2(wildCard);
				count = 
					new OrderchargeBD(this.getSessionFactoryClusterMap())
				.orderchargesCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist9(labelValue);	

				// count ordercharges for month by current month / READY_STATUS / logon user
				listForm1.setSearchString1(com.bureaueye.beacon.bean.Constants.READY_STATUS);
				listForm1.setSearchString2(user.getUserid());
				count = 
					new OrderchargeBD(this.getSessionFactoryClusterMap())
				.orderchargesCountByInvoicestatusOrderdateOrderbyuserid(listForm1);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist9(labelValue);		

				// count ordercharges for month by current year / READY_STATUS / logon user
				listForm2.setSearchString1(com.bureaueye.beacon.bean.Constants.READY_STATUS);
				listForm2.setSearchString2(user.getUserid());
				count = 
					new OrderchargeBD(this.getSessionFactoryClusterMap())
				.orderchargesCountByInvoicestatusOrderdateOrderbyuserid(listForm2);
				labelValue = new LabelValue();
				labelValue.setValue(count+"");							
				analysisPool.addToAnalysislist9(labelValue);	

				analysisPool.setDashboardtype9(dashboardtype);
				analysisPool.setDaterangedays9(daterangedays);

			}//if (dao!= null) {



			//-----------------------------------------------------------------------
			// task build analysis
			//-----------------------------------------------------------------------
			dao = null;
			dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).findUserdashboardByKey1(user.getUserid(), "TASK_ANALYSIS");				
			if (dao!= null) {	
				daterangedays=dao.getDaterangedays();
				dashboardtype="ALL";
				analysisPool.setAnalysislist10(null);	

				listForm1.setSearchString1(user.getUserid());
				listForm1.setSearchDate1(new Date());
				listForm1.setOrderBy("Startdate");
				listForm1.setOrderBy2("Taskpriority");
				List<Task> tasks = 
					new TaskBD(this.getSessionFactoryClusterMap())
				.findTasksByUserid(listForm1);						
				analysisPool.setAnalysislist10(tasks);	

				analysisPool.setDashboardtype10(dashboardtype);
				analysisPool.setDaterangedays10(daterangedays);

			}//if (dao!= null) {




			SaveAnalysisPool(request, analysisPool);

		} catch (ApplicationException e) {
		}

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
