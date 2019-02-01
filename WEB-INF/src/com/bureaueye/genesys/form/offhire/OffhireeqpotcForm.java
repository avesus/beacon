package com.bureaueye.genesys.form.offhire;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class OffhireeqpotcForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary keys
	private java.lang.String _offhireeqpotcId;
	private java.lang.String _offhireeqpId;
	
	
	// fields
	private String _chargeamt = "0.0";
	
	

	// many to one
	private String _chargekey;



    /**
     */
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    

	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	/**
	 * Return the unique identifier of this class
     */
	public java.lang.String getOffhireeqpotcId () {
		return _offhireeqpotcId;
	}

	/**
	 */
	public void setOffhireeqpotcId (java.lang.String _offhireeqpotcId) {
		this._offhireeqpotcId = _offhireeqpotcId;
	}


	/**
	 */
	public java.lang.String getOffhireeqpId () {
		return _offhireeqpId;
	}

	/**
	 */
	public void setOffhireeqpId (java.lang.String _offhireeqpId) {
		this._offhireeqpId = _offhireeqpId;
	}
	
	
	
	/**
	 * Return the value associated with the column: chargeamt
	 */
	public String getChargeamt () {
		return _chargeamt;
	}

	/**
	 * Set the value related to the column: chargeamt
	 * @param _chargeamt the chargeamt value
	 */
	public void setChargeamt (String _chargeamt) {
		this._chargeamt = _chargeamt;
	}



	/**
	 * Return the value associated with the column: chargekey
	 */
	public String getChargekey () {
		return _chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param _chargekey the chargekey value
	 */
	public void setChargekey (String _chargekey) {
		this._chargekey = _chargekey;
	}



	


	



	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	
		
		addErrorIfBlank(errors, "chargekey", _chargekey, "error.chargekey.required");

		
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
