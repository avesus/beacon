package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;



public final class G1codeForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";



	// primary key
	private java.lang.String g1codeId;
	
	// fields
	private java.lang.String g1codekey;
	private java.lang.String ldesc;
	private java.lang.String sdesc;
	private java.lang.String locationcode;
	private java.lang.String groupg1codekey;

	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}


	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="G1CODE_ID"
     */
	public java.lang.String getG1codeId () {
		return g1codeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param g1codeId the new ID
	 */
	public void setG1codeId (java.lang.String g1codeId) {
		this.g1codeId = g1codeId;
	}




	/**
	 * Return the value associated with the column: g1codekey
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}

	/**
	 * Set the value related to the column: g1codekey
	 * @param g1codekey the g1codekey value
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}



	/**
	 * Return the value associated with the column: ldesc
	 */
	public java.lang.String getLdesc () {
		return ldesc;
	}

	/**
	 * Set the value related to the column: ldesc
	 * @param ldesc the ldesc value
	 */
	public void setLdesc (java.lang.String ldesc) {
		this.ldesc = ldesc;
	}



	/**
	 * Return the value associated with the column: sdesc
	 */
	public java.lang.String getSdesc () {
		return sdesc;
	}

	/**
	 * Set the value related to the column: sdesc
	 * @param sdesc the sdesc value
	 */
	public void setSdesc (java.lang.String sdesc) {
		this.sdesc = sdesc;
	}



	/**
	 * Return the value associated with the column: locationcode
	 */
	public java.lang.String getLocationcode () {
		return locationcode;
	}

	/**
	 * Set the value related to the column: locationcode
	 * @param locationcode the locationcode value
	 */
	public void setLocationcode (java.lang.String locationcode) {
		this.locationcode = locationcode;
	}



	/**
	 * Return the value associated with the column: groupg1codekey
	 */
	public java.lang.String getGroupg1codekey () {
		return groupg1codekey;
	}

	/**
	 * Set the value related to the column: groupg1codekey
	 * @param groupg1codekey the groupg1codekey value
	 */
	public void setGroupg1codekey (java.lang.String groupg1codekey) {
		this.groupg1codekey = groupg1codekey;
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
		
        if ((g1codekey == null) || (g1codekey.length() < 1))
            errors.add("g1codekey",
                    new ActionMessage("error.g1code.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this.g1codekey)) errors.add("g1code", new ActionMessage("error.g1code.invalidchars"));
		}

		addErrorIfBlank(errors, "ldesc", ldesc, "error.desc.required");      
		addErrorIfBlank(errors, "sdesc", sdesc, "error.sdesc.required");    
		
      
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
