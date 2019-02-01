/*
 * $Id: QuoapproveLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.form.quotation;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 */

public final class QuoapproveLineItem extends ActionForm {


    // --------------------------------------------------- Instance Variables

 
	public String Notes = null;
	public String Priority = null;
	public String QuohdrId = null;
	public String Userid = null;
	public String Approvetime = null;
	public String Approvetype = null;
	public String Approvedate = null;
	public String Usergroupid = null;
	public String Id = null;
	public String Rejectreason = null;
	public String Approveflag = null;

    private boolean checked = false;
    private boolean email = false;    
    private boolean delete = false;
   
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    public boolean isEmail() { return (this.email); }
    public void setEmail(boolean b) {
        this.email = b;
    }
    public boolean isDelete() { return (this.delete); }
    public void setDelete(boolean b) {
        this.delete = b;
    }    

     
    
    
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="QUOAPPROVE_ID"
     */
	public String getId_ () {
		return Id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId_ (String _id) {
		this.Id = _id;
	}





	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return Notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param _notes the notes value
	 */
	public void setNotes (java.lang.String _notes) {
		this.Notes = _notes;
	}



	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public String getQuohdrId_ () {
		return QuohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param _quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId_ (String _quohdrId) {
		this.QuohdrId = _quohdrId;
	}




	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return Usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param _usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String _usergroupid) {
		this.Usergroupid = _usergroupid;
	}


	/**
	 * Return the value associated with the column: approvetype
	 */
	public java.lang.String getApprovetype () {
		return Approvetype;
	}

	/**
	 * Set the value related to the column: approvetype
	 * @param _approvetype the approvetype value
	 */
	public void setApprovetype (java.lang.String _approvetype) {
		this.Approvetype = _approvetype;
	}


	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return Userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param _userid the userid value
	 */
	public void setUserid (java.lang.String _userid) {
		this.Userid = _userid;
	}


	/**
	 * Return the value associated with the column: approvedate
	 */
	public String getApprovedate () {
		return Approvedate;
	}

	/**
	 * Set the value related to the column: approvedate
	 * @param _approvedate the approvedate value
	 */
	public void setApprovedate_ (String _approvedate) {
		this.Approvedate = _approvedate;
	}


	/**
	 * Return the value associated with the column: approveflag
	 */
	public java.lang.String getApproveflag () {
		return Approveflag;
	}

	/**
	 * Set the value related to the column: approveflag
	 * @param _approveflag the approveflag value
	 */
	public void setApproveflag (java.lang.String _approveflag) {
		this.Approveflag = _approveflag;
	}




	/**
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason () {
		return Rejectreason;
	}

	/**
	 * Set the value related to the column: rejectreason
	 * @param _rejectreason the rejectreason value
	 */
	public void setRejectreason (java.lang.String _rejectreason) {
		this.Rejectreason = _rejectreason;
	}


	/**
	 * Return the value associated with the column: approvetime
	 */
	public String getApprovetime () {
		return Approvetime;
	}

	/**
	 * Set the value related to the column: approvetime
	 * @param _approvetime the approvetime value
	 */
	public void setApprovetime (String _approvetime) {
		this.Approvetime = _approvetime;
	}




	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return Priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param _priority the priority value
	 */
	public void setPriority (java.lang.String _priority) {
		this.Priority = _priority;
	}




	
    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

    	this.Notes = null;
    	this.Priority = null;
    	this.QuohdrId = null;
    	this.Userid = null;
    	this.Approvetime = null;
    	this.Approvetype = null;
    	this.Approvedate = null;
    	this.Usergroupid = null;
    	this.Id = null;
    	this.Rejectreason = null;
    	this.Approveflag = null;      
        this.checked = false;
        this.email = false;
        this.delete = false;        
        
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

