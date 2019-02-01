package com.bureaueye.beacon.action;

import java.util.HashMap;
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
import com.bureaueye.beacon.form.SwitchtocompanyForm;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-25 201400004 Add 'Switch To' Company Function (DO NOT RELEASE TO BASE AT THE MOMENT - IT DOES WORK!!!)
 * 
 */
public final class SwitchtocompanyAction extends Action {

	/**
	 */
	static String COMPANYKEY = "companykey";

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	protected static Map<String, SessionFactory> _sessionFactoryClusterMap;

	/**
	 * Set the session factory cluster to Map
	 */
	public void setSessionFactoryCluster(String configFileName,
			SessionFactory sf) {
		if (null == configFileName)
			configFileName = "";
		if (null == _sessionFactoryClusterMap)
			_sessionFactoryClusterMap = new HashMap<String, SessionFactory>();
		_sessionFactoryClusterMap.put(configFileName, sf);
	}

	/**
	 * get the session factory cluster Map
	 */
	public Map<String, SessionFactory> getSessionFactoryClusterMap() {
		return _sessionFactoryClusterMap;
	}

	private SessionFactory _sessionFactoryCluster1;

	public SessionFactory getSessionFactoryCluster1() {
		return _sessionFactoryCluster1;
	}

	public void setSessionFactoryCluster1(SessionFactory _factory) {
		this._sessionFactoryCluster1 = _factory;
	}

	private SessionFactory _sessionFactoryCluster2;

	public SessionFactory getSessionFactoryCluster2() {
		return _sessionFactoryCluster2;
	}

	public void setSessionFactoryCluster2(SessionFactory _factory) {
		this._sessionFactoryCluster2 = _factory;
	}

	private SessionFactory _sessionFactoryCluster3;

	public SessionFactory getSessionFactoryCluster3() {
		return _sessionFactoryCluster3;
	}

	public void setSessionFactoryCluster3(SessionFactory _factory) {
		this._sessionFactoryCluster3 = _factory;
	}

	// ------------------------------------------------------ Protected Methods

	void SaveUser(HttpServletRequest request, User user) {

		HttpSession session = request.getSession();
		session.setAttribute(
				com.bureaueye.beacon.bean.standard.Constants.USER_KEY, user);

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " LogonAction: User '" + user.getUserid()
				+ "' logged on in session " + session.getId());

	}

	// --------------------------------------------------------- Public Methods

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// set hibernate session factories
		this.setSessionFactoryCluster1((SessionFactory) servlet
				.getServletContext().getAttribute(
						HibernateCluster1Plugin.SESSION_FACTORY_KEY));
		this.setSessionFactoryCluster(
				HibernateCluster1Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(
						HibernateCluster1Plugin.SESSION_FACTORY_KEY));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " setSessionFactoryCluster1: "
				+ this.getSessionFactoryClusterMap().toString());

		this.setSessionFactoryCluster2((SessionFactory) servlet
				.getServletContext().getAttribute(
						HibernateCluster2Plugin.SESSION_FACTORY_KEY));
		this.setSessionFactoryCluster(
				HibernateCluster2Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(
						HibernateCluster2Plugin.SESSION_FACTORY_KEY));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " setSessionFactoryCluster2: "
				+ this.getSessionFactoryClusterMap().toString());

		this.setSessionFactoryCluster3((SessionFactory) servlet
				.getServletContext().getAttribute(
						HibernateCluster3Plugin.SESSION_FACTORY_KEY));
		this.setSessionFactoryCluster(
				HibernateCluster3Plugin.SESSION_FACTORY_KEY,
				(SessionFactory) servlet.getServletContext().getAttribute(
						HibernateCluster3Plugin.SESSION_FACTORY_KEY));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " setSessionFactoryCluster3: "
				+ this.getSessionFactoryCluster3().toString());

		SwitchtocompanyForm inputForm = (SwitchtocompanyForm) form;

		HttpSession session = request.getSession();
		User user = (User) session
				.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
		user.setCompanykey(inputForm.getCompanykey());

		// Save user object
		SaveUser(request, user);

		// Otherwise, return "success"
		return findSuccess(mapping);

	}

	/**
	 * Return the local or global forward named "failure" or null if there is no
	 * such forward.
	 * 
	 * @param mapping
	 *            Our ActionMapping
	 * @return Return the mapping named "failure" or null if there is no such
	 *         mapping.
	 */
	protected ActionForward findFailure(ActionMapping mapping) {
		return mapping.findForward(Constants.FAILURE);
	}

	/**
	 * Return the mapping labeled "success" or null if there is no such mapping.
	 * 
	 * @param mapping
	 *            Our ActionMapping
	 * @return Return the mapping named "success" or null if there is no such
	 *         mapping.
	 */
	protected ActionForward findSuccess(ActionMapping mapping) {
		return mapping.findForward(Constants.SUCCESS);
	}

}
