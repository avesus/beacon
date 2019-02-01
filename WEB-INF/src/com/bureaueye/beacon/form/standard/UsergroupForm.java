package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;



public final class UsergroupForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _usergroupid;

	
	// fields
	private java.lang.String _email;
	private java.lang.String _name;


	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	

	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return _email;
	}

	/**
	 * Set the value related to the column: email
	 * @param _email the email value
	 */
	public void setEmail (java.lang.String _email) {
		this._email = _email;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return _name;
	}

	/**
	 * Set the value related to the column: name
	 * @param _name the name value
	 */
	public void setName (java.lang.String _name) {
		this._name = _name;
	}



	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return _usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param _usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String _usergroupid) {
		this._usergroupid = _usergroupid;
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
		
        if ((_usergroupid == null) || (_usergroupid.length() < 1))
            errors.add("usergroupid",
                    new ActionMessage("error.usergroupid.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this._usergroupid)) errors.add("usergroupid", new ActionMessage("error.usergroupid.invalidchars"));
		}

        
      
		return errors;

	}

/*	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}*/

	
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
