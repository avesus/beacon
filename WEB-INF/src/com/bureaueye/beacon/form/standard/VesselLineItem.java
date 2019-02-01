/*
 * $Id: VesselLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.form.standard;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 */

public final class VesselLineItem extends ActionForm {


    // --------------------------------------------------- Instance Variables


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The vessel.
     */
    private String vesselkey = null;

    private String vesselname = null;
    

    private boolean checked = false;
    
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    




    /**
     * Return the vessel.
     */
    public String getVesselkey() {

	return (this.vesselkey);

    }


    /**
     * Set the vessel name.
     *
     * @param vessel The vessel
     */
    public void setVesselkey(String vesselkey) {

        this.vesselkey = vesselkey;

    }

    /**
     * Return the description.
     */
    public String getVesselname() {
    	return (this.vesselname);
    }
    /**
     * Set the  name.
     *
     * @param description
     */
    public void setVesselname(String vesselname) {
        this.vesselname = vesselname;
    }
    

    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        this.vesselname = null; 
        this.vesselkey = null;    	
        this.checked = false;
        
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
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

	return (errors);

    }


}

