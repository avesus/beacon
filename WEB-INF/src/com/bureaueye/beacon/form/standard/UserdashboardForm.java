package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;


/**
 * Amendments
 * ----------
 * 												
 */
public final class UserdashboardForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String copyId = "";
    

	// primary key
	private java.lang.String userdashboardId;

	// fields
	private java.lang.String userid;
	private java.lang.String dashboardid;
	private java.lang.String dashboardtype;
	private java.lang.String daterangedays;
	private java.lang.String txt;


	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}


    /**
     */
    public String getCopyId() {return (this.copyId);}
    public void setCopyId(String copyId) {this.copyId = copyId;}
    

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERDASHBOARD_ID"
     */
	public java.lang.String getUserdashboardId () {
		return userdashboardId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param userdashboardId the new ID
	 */
	public void setUserdashboardId (java.lang.String userdashboardId) {
		this.userdashboardId = userdashboardId;
	}




	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: dashboardid
	 */
	public java.lang.String getDashboardid () {
		return dashboardid;
	}

	/**
	 * Set the value related to the column: dashboardid
	 * @param dashboardid the dashboardid value
	 */
	public void setDashboardid (java.lang.String dashboardid) {
		this.dashboardid = dashboardid;
	}



	/**
	 * Return the value associated with the column: dashboardtype
	 */
	public java.lang.String getDashboardtype () {
		return dashboardtype;
	}

	/**
	 * Set the value related to the column: dashboardtype
	 * @param dashboardtype the dashboardtype value
	 */
	public void setDashboardtype (java.lang.String dashboardtype) {
		this.dashboardtype = dashboardtype;
	}



	/**
	 * Return the value associated with the column: daterangedays
	 */
	public java.lang.String getDaterangedays () {
		return daterangedays;
	}

	/**
	 * Set the value related to the column: daterangedays
	 * @param daterangedays the daterangedays value
	 */
	public void setDaterangedays (java.lang.String daterangedays) {
		this.daterangedays = daterangedays;
	}



	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}

	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
		addErrorIfBlank(errors, "dashboardid", dashboardid, "error.dashboardid.required");        	
		addErrorIfBlank(errors, "dashboardtype", dashboardtype, "error.dashboardtype.required"); 
		
/*		if (_action.equals("Create")) {
			if (Util.invalidChars(this.dashboardid)) errors.add("dashboardid", new ActionMessage("error.dashboardid.invalidchars"));
		}*/
   
     
      
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
