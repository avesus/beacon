/*
 * $Id: CheckLogonTag.java 54929 2004-10-16 16:38:42Z ntankard $ 
 *
 */
package com.bureaueye.beacon.taglib;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.config.ModuleConfig;

import com.bureaueye.beacon.bean.standard.Constants;


/**
 * Check for a valid User logged on in the current session.  If there is no
 * such user, forward control to the logon page.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */
public final class CheckLogonTag extends TagSupport {


    // --------------------------------------------------- Instance Variables


    /**
     * The key of the session-scope bean we look for.
     */
    private String name = Constants.USER_KEY;

    /**
     * Path to use if a login is needed.
     */
    private static String LOGIN_PATH = "/Logon.do";

    /**
     * Path to use if a logout is needed.
     */
    private static String LOGOFF_PATH = "/Logoff.do";

    /**
     * The action to which we should forward for the user to log off.
     */
    private String page = LOGOFF_PATH;


    // ------------------------------------------------------- Public Methods


    /**
     * Defer our checking until the end of this tag is encountered.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {

	   return (SKIP_BODY);

    }


    /**
     * Perform our logged-in user check by looking for the existence of
     * a session scope bean under the specified name.  If this bean is not
     * present, control is forwarded to the specified logon page.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {
    
    	// Is there a valid user logged on?
    	boolean valid = false;
    	HttpSession session = pageContext.getSession();
    	if ((session != null) && (session.getAttribute(name) != null)) {
    	    valid = true;
        }
    
        // Forward control based on the results
        if (valid) {
            return (EVAL_PAGE);
        } else {
            ModuleConfig config =
                (ModuleConfig) pageContext.getServletContext().getAttribute(
                    org.apache.struts.Globals.MODULE_KEY);
            
                try {
                    pageContext.forward(config.getPrefix() + page);
                } catch (ServletException e) {
                    throw new JspException(e.toString());
                } catch (IOException e) {
                    throw new JspException(e.toString());
                }
             
            return (SKIP_PAGE);
        }
    
    }


    /**
     * Release any acquired resources.
     */
    public void release() {

        super.release();
        this.name = Constants.USER_KEY;
        this.page = LOGOFF_PATH;

    }

}
