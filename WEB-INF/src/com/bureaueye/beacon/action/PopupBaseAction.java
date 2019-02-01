/*
 * $Id: BaseAction.java 
 *
 */

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
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.hibernate.plugin.HibernateCluster1Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster2Plugin;
import com.bureaueye.hibernate.plugin.HibernateCluster3Plugin;


/**
 * Base Action for Beacon application.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */
public abstract class PopupBaseAction extends Action {

    // ----------------------------------------------------- Instance Variables

    /**
     * The <code>Log</code> instance for this application.
     */
    public static Log log = LogFactory.getLog(Constants.PACKAGE);
    
    // ------------------------------------------------------ Protected Methods

 
    
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

	
	public ActionForward execute( ActionMapping mapping, 
			                        ActionForm form,
			                        HttpServletRequest request, 
									HttpServletResponse response
									) throws Exception {
		
        // if session time-out then go back to popup window instead of logoff
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);      
        //if (user == null) return (mapping.findForward("logoff"));
        if (user == null) return findSuccess(mapping);

        
        
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
		
		

		
		executeBefore();

		// call the abstract method
		ActionForward forward = executeAction( mapping, form, request, response );

		executeAfter();

		return forward;
  }		

	protected abstract ActionForward executeAction( 
									ActionMapping mapping, 
                                    ActionForm form,
                                    HttpServletRequest request, 
			                        HttpServletResponse response) throws Exception;
	
	private void executeBefore() {
	}

	private void executeAfter() {
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
