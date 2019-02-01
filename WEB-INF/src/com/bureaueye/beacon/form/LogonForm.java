/*
 */


package com.bureaueye.beacon.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean for the user registration page.  This form has the following
 * fields, with default values in square brackets:
 * <ul>
 * <li><b>action</b> - The maintenance action we are performing (Create,
 *     Delete, or Edit).
 * <li><b>fromAddress</b> - The EMAIL address of the sender, to be included
 *     on sent messages.  [REQUIRED]
 * <li><b>fullName</b> - The full name of the sender, to be included on
 *     sent messages.  [REQUIRED]
 * <li><b>password</b> - The password used by this user to log on.
 * <li><b>password2</b> - The confirmation password, which must match
 *     the password when changing or setting.
 * <li><b>replyToAddress</b> - The "Reply-To" address to be included on
 *     sent messages.  [Same as from address]
 * <li><b>username</b> - The registered username, which must be unique.
 *     [REQUIRED]
 * </ul>
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */

public final class LogonForm extends ValidatorForm  {


    // ----------------------------------------------------- Instance Variables



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * The password.
     */
    private String password = null;


    /**
     * The userid.
     */
    private String userid = null;
    

    // ----------------------------------------------------------- Properties




    /**
     * Return the password.
     */
    public String getPassword() {

	return (this.password);

    }


    /**
     * Set the password.
     *
     * @param password The new password
     */
    public void setPassword(String password) {

        this.password = password;

    }





    /**
     * Return the userid.
     */
    public String getUserid() {

	return (this.userid);

    }


    /**
     * Set the username.
     *
     * @param username The new username
     */
    public void setUserid(String userid) {

        this.userid = userid;

    }


    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.password = null;
        this.userid = null;
    }


    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if ((userid == null) || (userid.length() < 1))
            errors.add("userid",
                    new ActionMessage("error.userid.required"));        	
        if ((password == null) || (password.length() < 1))
        	errors.add("password",
        			new ActionMessage("error.password.required"));         

        return errors;

    }


}
