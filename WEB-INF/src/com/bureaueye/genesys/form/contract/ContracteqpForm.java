package com.bureaueye.genesys.form.contract;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class ContracteqpForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _contracteqpId;
	private java.lang.String _contractId;
	
	
	// fields
	private java.lang.String _eqpkeyp5;
	private java.lang.String _erowithin = "0";
	private java.lang.String _eqpkeyp2;
	
	private java.util.Date _erodate;
	private java.lang.String _erorate = "0.0";
	private java.lang.String _eroincrease = "0.0";
	private java.lang.String _eroadd = "0";	
	private java.lang.String _erodays = "0";
	private java.lang.String _eroperiod;
	
	private java.lang.String _eqpkey;
	private java.lang.String _eqpkeyp6;	
	private java.lang.String _eqpkeyp7;
	private java.lang.String _eqpkeyp3;
	private java.lang.String _eqpkeyp4;
	private java.lang.String _eqpkeyp9;
	private java.lang.String _eqpkeyp8;
	private java.lang.String _eqpkeyp10;
	private java.lang.String _eqpkeyp1;
	
	private java.lang.String _freedays = "0";
	private java.lang.String _mindays = "0";
	
	private java.lang.String _fixdlyrat = "0.0";	
	private java.lang.String _rate1 = "0.0";
	private java.lang.String _fromday1 = "0";
	private java.lang.String _today1 = "0";
	private java.lang.String _rate2 = "0.0";
	private java.lang.String _fromday2 = "0";
	private java.lang.String _today2 = "0";
	private java.lang.String _rate3 = "0.0";
	private java.lang.String _fromday3 = "0";
	private java.lang.String _today3 = "0";
	private java.lang.String _rate4 = "0.0";
	private java.lang.String _fromday4 = "0";
	private java.lang.String _today4 = "0";
	private java.lang.String _rate5 = "0.0";
	private java.lang.String _fromday5 = "0";
	private java.lang.String _today5 = "0";

	
	
	// collections

	
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
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTEQP_ID"
     */
	public java.lang.String getContracteqpId () {
		return _contracteqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _contracteqpId the new ID
	 */
	public void setContracteqpId (java.lang.String _contracteqpId) {
		this._contracteqpId = _contracteqpId;
	}


	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.String getContractId () {
		return _contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param _contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.String _contractId) {
		this._contractId = _contractId;
	}
	
	
	
	

	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return _eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param _eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String _eqpkeyp5) {
		this._eqpkeyp5 = _eqpkeyp5;
	}



	/**
	 * Return the value associated with the column: erowithin
	 */
	public java.lang.String getErowithin () {
		return _erowithin;
	}

	/**
	 * Set the value related to the column: erowithin
	 * @param _erowithin the erowithin value
	 */
	public void setErowithin (java.lang.String _erowithin) {
		this._erowithin = _erowithin;
	}



	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return _eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param _eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String _eqpkeyp2) {
		this._eqpkeyp2 = _eqpkeyp2;
	}


	/**
	 * Return the value associated with the column: erodate
	 */
	public java.util.Date getErodate () {
		return _erodate;
	}

	/**
	 * Set the value related to the column: erodate
	 * @param _erodate the erodate value
	 */
	public void setErodate (java.util.Date _erodate) {
		this._erodate = _erodate;
	}


	/**
	 * Return the value associated with the column: erodays
	 */
	public java.lang.String getErodays () {
		return _erodays;
	}

	/**
	 * Set the value related to the column: erodays
	 * @param _erodays the erodays value
	 */
	public void setErodays (java.lang.String _erodays) {
		this._erodays = _erodays;
	}


	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return _eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param _eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String _eqpkey) {
		this._eqpkey = _eqpkey;
	}


	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return _eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param _eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String _eqpkeyp7) {
		this._eqpkeyp7 = _eqpkeyp7;
	}



	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return _eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param _eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String _eqpkeyp3) {
		this._eqpkeyp3 = _eqpkeyp3;
	}




	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return _eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param _eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String _eqpkeyp4) {
		this._eqpkeyp4 = _eqpkeyp4;
	}



	/**
	 * Return the value associated with the column: eroadd
	 */
	public java.lang.String getEroadd () {
		return _eroadd;
	}

	/**
	 * Set the value related to the column: eroadd
	 * @param _eroadd the eroadd value
	 */
	public void setEroadd (java.lang.String _eroadd) {
		this._eroadd = _eroadd;
	}


	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return _eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param _eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String _eqpkeyp9) {
		this._eqpkeyp9 = _eqpkeyp9;
	}


	/**
	 * Return the value associated with the column: fixdlyrat
	 */
	public java.lang.String getFixdlyrat () {
		return _fixdlyrat;
	}

	/**
	 * Set the value related to the column: fixdlyrat
	 * @param _fixdlyrat the fixdlyrat value
	 */
	public void setFixdlyrat (java.lang.String _fixdlyrat) {
		this._fixdlyrat = _fixdlyrat;
	}


	/**
	 * Return the value associated with the column: erorate
	 */
	public java.lang.String getErorate () {
		return _erorate;
	}

	/**
	 * Set the value related to the column: erorate
	 * @param _erorate the erorate value
	 */
	public void setErorate (java.lang.String _erorate) {
		this._erorate = _erorate;
	}


	/**
	 * Return the value associated with the column: eroincrease
	 */
	public java.lang.String getEroincrease () {
		return _eroincrease;
	}

	/**
	 * Set the value related to the column: eroincrease
	 * @param _eroincrease the eroincrease value
	 */
	public void setEroincrease (java.lang.String _eroincrease) {
		this._eroincrease = _eroincrease;
	}


	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return _eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param _eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String _eqpkeyp8) {
		this._eqpkeyp8 = _eqpkeyp8;
	}


	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return _eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param _eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String _eqpkeyp10) {
		this._eqpkeyp10 = _eqpkeyp10;
	}


	/**
	 * Return the value associated with the column: eroperiod
	 */
	public java.lang.String getEroperiod () {
		return _eroperiod;
	}

	/**
	 * Set the value related to the column: eroperiod
	 * @param _eroperiod the eroperiod value
	 */
	public void setEroperiod (java.lang.String _eroperiod) {
		this._eroperiod = _eroperiod;
	}


	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return _eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String _eqpkeyp1) {
		this._eqpkeyp1 = _eqpkeyp1;
	}



	/**
	 * Return the value associated with the column: freedays
	 */
	public java.lang.String getFreedays () {
		return _freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param _freedays the freedays value
	 */
	public void setFreedays (java.lang.String _freedays) {
		this._freedays = _freedays;
	}


	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return _eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param _eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String _eqpkeyp6) {
		this._eqpkeyp6 = _eqpkeyp6;
	}






	/**
	 * Return the value associated with the column: mindays
	 */
	public java.lang.String getMindays () {
		return _mindays;
	}

	/**
	 * Set the value related to the column: mindays
	 * @param _mindays the mindays value
	 */
	public void setMindays (java.lang.String _mindays) {
		this._mindays = _mindays;
	}




	/**
	 * Return the value associated with the column: rate1
	 */
	public java.lang.String getRate1 () {
		return _rate1;
	}

	/**
	 * Set the value related to the column: rate1
	 * @param _rate1 the rate1 value
	 */
	public void setRate1 (java.lang.String _rate1) {
		this._rate1 = _rate1;
	}


	/**
	 * Return the value associated with the column: fromday1
	 */
	public java.lang.String getFromday1 () {
		return _fromday1;
	}

	/**
	 * Set the value related to the column: fromday1
	 * @param _fromday1 the fromday1 value
	 */
	public void setFromday1 (java.lang.String _fromday1) {
		this._fromday1 = _fromday1;
	}


	/**
	 * Return the value associated with the column: today1
	 */
	public java.lang.String getToday1 () {
		return _today1;
	}

	/**
	 * Set the value related to the column: today1
	 * @param _today1 the today1 value
	 */
	public void setToday1 (java.lang.String _today1) {
		this._today1 = _today1;
	}


	/**
	 * Return the value associated with the column: rate2
	 */
	public java.lang.String getRate2 () {
		return _rate2;
	}

	/**
	 * Set the value related to the column: rate2
	 * @param _rate2 the rate2 value
	 */
	public void setRate2 (java.lang.String _rate2) {
		this._rate2 = _rate2;
	}


	/**
	 * Return the value associated with the column: fromday2
	 */
	public java.lang.String getFromday2 () {
		return _fromday2;
	}

	/**
	 * Set the value related to the column: fromday2
	 * @param _fromday2 the fromday2 value
	 */
	public void setFromday2 (java.lang.String _fromday2) {
		this._fromday2 = _fromday2;
	}


	/**
	 * Return the value associated with the column: today2
	 */
	public java.lang.String getToday2 () {
		return _today2;
	}

	/**
	 * Set the value related to the column: today2
	 * @param _today2 the today2 value
	 */
	public void setToday2 (java.lang.String _today2) {
		this._today2 = _today2;
	}


	/**
	 * Return the value associated with the column: rate3
	 */
	public java.lang.String getRate3 () {
		return _rate3;
	}

	/**
	 * Set the value related to the column: rate3
	 * @param _rate3 the rate3 value
	 */
	public void setRate3 (java.lang.String _rate3) {
		this._rate3 = _rate3;
	}


	/**
	 * Return the value associated with the column: fromday3
	 */
	public java.lang.String getFromday3 () {
		return _fromday3;
	}

	/**
	 * Set the value related to the column: fromday3
	 * @param _fromday3 the fromday3 value
	 */
	public void setFromday3 (java.lang.String _fromday3) {
		this._fromday3 = _fromday3;
	}


	/**
	 * Return the value associated with the column: today3
	 */
	public java.lang.String getToday3 () {
		return _today3;
	}

	/**
	 * Set the value related to the column: today3
	 * @param _today3 the today3 value
	 */
	public void setToday3 (java.lang.String _today3) {
		this._today3 = _today3;
	}


	/**
	 * Return the value associated with the column: rate4
	 */
	public java.lang.String getRate4 () {
		return _rate4;
	}

	/**
	 * Set the value related to the column: rate4
	 * @param _rate4 the rate4 value
	 */
	public void setRate4 (java.lang.String _rate4) {
		this._rate4 = _rate4;
	}


	/**
	 * Return the value associated with the column: fromday4
	 */
	public java.lang.String getFromday4 () {
		return _fromday4;
	}

	/**
	 * Set the value related to the column: fromday4
	 * @param _fromday4 the fromday4 value
	 */
	public void setFromday4 (java.lang.String _fromday4) {
		this._fromday4 = _fromday4;
	}


	/**
	 * Return the value associated with the column: today4
	 */
	public java.lang.String getToday4 () {
		return _today4;
	}

	/**
	 * Set the value related to the column: today4
	 * @param _today4 the today4 value
	 */
	public void setToday4 (java.lang.String _today4) {
		this._today4 = _today4;
	}


	/**
	 * Return the value associated with the column: rate5
	 */
	public java.lang.String getRate5 () {
		return _rate5;
	}

	/**
	 * Set the value related to the column: rate5
	 * @param _rate5 the rate5 value
	 */
	public void setRate5 (java.lang.String _rate5) {
		this._rate5 = _rate5;
	}


	/**
	 * Return the value associated with the column: fromday5
	 */
	public java.lang.String getFromday5 () {
		return _fromday5;
	}

	/**
	 * Set the value related to the column: fromday5
	 * @param _fromday5 the fromday5 value
	 */
	public void setFromday5 (java.lang.String _fromday5) {
		this._fromday5 = _fromday5;
	}


	/**
	 * Return the value associated with the column: today5
	 */
	public java.lang.String getToday5 () {
		return _today5;
	}

	/**
	 * Set the value related to the column: today5
	 * @param _today5 the today5 value
	 */
	public void setToday5 (java.lang.String _today5) {
		this._today5 = _today5;
	}

	
	
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
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
		
		addErrorIfBlank(errors, "eqpkeyp1", _eqpkeyp1, "error.eqpkeyp1.required");      
		//addErrorIfBlank(errors, "eqpkeyp2", _eqpkeyp2, "error.eqpkeyp2.required"); 
		
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
