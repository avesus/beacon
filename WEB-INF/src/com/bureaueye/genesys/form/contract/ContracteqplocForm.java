package com.bureaueye.genesys.form.contract;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class ContracteqplocForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary key
	private java.lang.String _contracteqplocId;
	private java.lang.String _contracteqpId;
	
	private java.lang.String _handchg = "0.0";
	private java.lang.String _minreturns = "0";
	private java.lang.String _monthreturns = "0";
	private java.lang.String _pudoflag;
	private java.lang.String _locationreturns = "0";


	// many to one
	private String _locationkey;



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
	public java.lang.String getContracteqplocId () {
		return _contracteqplocId;
	}

	/**
	 */
	public void setContracteqplocId (java.lang.String _contracteqplocId) {
		this._contracteqplocId = _contracteqplocId;
	}


	/**
	 */
	public java.lang.String getContracteqpId () {
		return _contracteqpId;
	}

	/**
	 */
	public void setContracteqpId (java.lang.String _contracteqpId) {
		this._contracteqpId = _contracteqpId;
	}
	
	
	
	





	/**
	 * Return the value associated with the column: handchg
	 */
	public java.lang.String getHandchg () {
		return _handchg;
	}

	/**
	 * Set the value related to the column: handchg
	 * @param _handchg the handchg value
	 */
	public void setHandchg (java.lang.String _handchg) {
		this._handchg = _handchg;
	}





	/**
	 * Return the value associated with the column: minreturns
	 */
	public java.lang.String getMinreturns () {
		return _minreturns;
	}

	/**
	 * Set the value related to the column: minreturns
	 * @param _minreturns the minreturns value
	 */
	public void setMinreturns (java.lang.String _minreturns) {
		this._minreturns = _minreturns;
	}





	/**
	 * Return the value associated with the column: monthreturns
	 */
	public java.lang.String getMonthreturns () {
		return _monthreturns;
	}

	/**
	 * Set the value related to the column: monthreturns
	 * @param _monthreturns the monthreturns value
	 */
	public void setMonthreturns (java.lang.String _monthreturns) {
		this._monthreturns = _monthreturns;
	}





	/**
	 * Return the value associated with the column: pudoflag
	 */
	public java.lang.String getPudoflag () {
		return _pudoflag;
	}

	/**
	 * Set the value related to the column: pudoflag
	 * @param _pudoflag the pudoflag value
	 */
	public void setPudoflag (java.lang.String _pudoflag) {
		this._pudoflag = _pudoflag;
	}


	/**
	 * Return the value associated with the column: locationreturns
	 */
	public java.lang.String getLocationreturns () {
		return _locationreturns;
	}

	/**
	 * Set the value related to the column: locationreturns
	 * @param _locationreturns the locationreturns value
	 */
	public void setLocationreturns (java.lang.String _locationreturns) {
		this._locationreturns = _locationreturns;
	}


	
	
	/**
     * @hibernate.property
     *  column=_locationkey
	 */
	public String getLocationkey() {
		return this._locationkey;
	}

	/**
	 * Set the value related to the column: _locationkey
	 * @param __locationkey the _locationkey value
	 */
	public void setLocationkey (String _locationkey) {
		this._locationkey = _locationkey;
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
		
		addErrorIfBlank(errors, "locationkey.locationkey", _locationkey, "error.location.required");
		addErrorIfBlank(errors, "pudoflag", _pudoflag, "error.pudoflag.required");



		
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
