package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class UsergroupmenuForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _usergroupmenuId;
	private java.lang.String _usergroupid;
	private java.lang.String _menuid;

	
	// fields
	private java.lang.String _programtype;
	private java.lang.String _programid;
	private java.lang.String _sequence;
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	/**
	 * Return the value associated with the column: programtype
	 */
	public java.lang.String getProgramtype () {
		return _programtype;
	}

	/**
	 * Set the value related to the column: programtype
	 * @param _programtype the programtype value
	 */
	public void setProgramtype (java.lang.String _programtype) {
		this._programtype = _programtype;
	}


	/**
	 * Return the value associated with the column: programid
	 */
	public java.lang.String getProgramid () {
		return _programid;
	}

	/**
	 * Set the value related to the column: programid
	 * @param _programid the programid value
	 */
	public void setProgramid (java.lang.String _programid) {
		this._programid = _programid;
	}


	/**
	 * Return the value associated with the column: sequence
	 */
	public java.lang.String  getSequence () {
		return _sequence;
	}

	/**
	 * Set the value related to the column: sequence
	 * @param _sequence the sequence value
	 */
	public void setSequence (java.lang.String _sequence) {
		this._sequence = _sequence;
	}

	
	/**
	 */
	public java.lang.String getUsergroupmenuId () {return _usergroupmenuId;}
	/**
	 */
	public void setUsergroupmenuId (java.lang.String _usergroupmenuId) {this._usergroupmenuId = _usergroupmenuId;}

	

	public java.lang.String getUsergroupid () {
		return _usergroupid;
	}

	public void setUsergroupid (java.lang.String _usergroupid) {
		this._usergroupid = _usergroupid;
	}

	public java.lang.String getMenuid () {
		return _menuid;
	}

	public void setMenuid (java.lang.String _menuid) {
		this._menuid = _menuid;
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
		
        if ((_menuid == null) || (_menuid.length() < 1))
            errors.add("menuid",
                    new ActionMessage("error.menuid.required"));        	

		//if (_action.equals("Create")) {
		//	if (Util.invalidChars(this._menuid)) errors.add("menuid", new ActionMessage("error.menuid.invalidchars"));
		//}

		addErrorIfBlank(errors, "programid", _programid, "error.programid.required");      
		addErrorIfBlank(errors, "programtype", _programtype, "error.programtype.required"); 
		
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
