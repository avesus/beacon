package com.bureaueye.beacon.form.quotation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class QuochargeForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	// primary key
	private java.lang.String _quochargeId;

	// fields
	private java.lang.String _xrateinv = "1.0";
	private java.lang.String _invoicepref;
	private java.lang.String _tariffkey;
	private java.lang.String _departmentkey;
	private java.lang.String _chargetype = "UNIT";
	private java.lang.String _quotno;
	private java.lang.String _uname;
	private java.lang.String _custtarfhdrId;
	private boolean _dmrgflag;
	private java.lang.String _baseccykey;
	private java.lang.String _invoiceccykey;
	private java.lang.String _companykey;
	private java.lang.String _xratebase = "1.0";
	private java.lang.String _txt1;
	private java.lang.String _customeraddrkey;
	private boolean _maincharge;
	private java.lang.String _quohdrId;
	private java.lang.String _txt2;
	private java.lang.String _chgamt = "0.0";
	private java.lang.String _chargekey;
	private java.lang.String _invoicegroupref;
	private java.lang.String _activitykey;
	private java.lang.String _units = "0";
	private java.lang.String _ccykey;
	private java.lang.String _taxcode;
	private java.lang.String _rate = "0.0";



	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="QUOCHARGE_ID"
     */
	public java.lang.String getQuochargeId () {
		return _quochargeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _quochargeId the new ID
	 */
	public void setQuochargeId (java.lang.String _quochargeId) {
		this._quochargeId = _quochargeId;
	}




	/**
	 * Return the value associated with the column: XRATEINV
	 */
	public java.lang.String getXrateinv () {
		return _xrateinv;
	}

	/**
	 * Set the value related to the column: XRATEINV
	 * @param _xrateinv the XRATEINV value
	 */
	public void setXrateinv (java.lang.String _xrateinv) {
		this._xrateinv = _xrateinv;
	}



	/**
	 * Return the value associated with the column: invoicepref
	 */
	public java.lang.String getInvoicepref () {
		return _invoicepref;
	}

	/**
	 * Set the value related to the column: invoicepref
	 * @param _invoicepref the invoicepref value
	 */
	public void setInvoicepref (java.lang.String _invoicepref) {
		this._invoicepref = _invoicepref;
	}


	/**
	 * Return the value associated with the column: TARIFFKEY
	 */
	public java.lang.String getTariffkey () {
		return _tariffkey;
	}

	/**
	 * Set the value related to the column: TARIFFKEY
	 * @param _tariffkey the TARIFFKEY value
	 */
	public void setTariffkey (java.lang.String _tariffkey) {
		this._tariffkey = _tariffkey;
	}


	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param _departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}



	/**
	 * Set the value related to the column: chargetype
	 * @param _chargetype the chargetype value
	 */
	public void setChargetype (String _chargetype) {
		this._chargetype = _chargetype;
	}
	public String getChargetype () {
		return _chargetype;
	}
	



	/**
	 * Return the value associated with the column: quotno
	 */
	public java.lang.String getQuotno () {
		return _quotno;
	}

	/**
	 * Set the value related to the column: quotno
	 * @param _quotno the quotno value
	 */
	public void setQuotno (java.lang.String _quotno) {
		this._quotno = _quotno;
	}


	/**
	 * Return the value associated with the column: UNAME
	 */
	public java.lang.String getUname () {
		return _uname;
	}

	/**
	 * Set the value related to the column: UNAME
	 * @param _uname the UNAME value
	 */
	public void setUname (java.lang.String _uname) {
		this._uname = _uname;
	}


	/**
	 * Return the value associated with the column: CUSTTARFHDR_ID
	 */
	public java.lang.String getCusttarfhdrId () {
		return _custtarfhdrId;
	}

	/**
	 * Set the value related to the column: CUSTTARFHDR_ID
	 * @param _custtarfhdrId the CUSTTARFHDR_ID value
	 */
	public void setCusttarfhdrId (java.lang.String _custtarfhdrId) {
		this._custtarfhdrId = _custtarfhdrId;
	}


	/**
	 * Return the value associated with the column: DMRGFLAG
	 */
	public boolean isDmrgflag () {
		return _dmrgflag;
	}

	/**
	 * Set the value related to the column: DMRGFLAG
	 * @param _dmrgflag the DMRGFLAG value
	 */
	public void setDmrgflag (boolean _dmrgflag) {
		this._dmrgflag = _dmrgflag;
	}


	/**
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey () {
		return _invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * @param _invoiceccykey the invoiceccykey value
	 */
	public void setInvoiceccykey (java.lang.String _invoiceccykey) {
		this._invoiceccykey = _invoiceccykey;
	}

	/**
	 * Return the value associated with the column: baseccykey
	 */
	public java.lang.String getBaseccykey () {
		return _baseccykey;
	}

	/**
	 * Set the value related to the column: baseccykey
	 * @param __baseccykey the baseccykey value
	 */
	public void setBaseccykey (java.lang.String _baseccykey) {
		this._baseccykey = _baseccykey;
	}
	
	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param _companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}




	/**
	 * Return the value associated with the column: XRATEBASE
	 */
	public java.lang.String getXratebase () {
		return _xratebase;
	}

	/**
	 * Set the value related to the column: XRATEBASE
	 * @param _xratebase the XRATEBASE value
	 */
	public void setXratebase (java.lang.String _xratebase) {
		this._xratebase = _xratebase;
	}


	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return _txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param _txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String _txt1) {
		this._txt1 = _txt1;
	}


	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param _customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}


	/**
	 * Return the value associated with the column: MAINCHARGE
	 */
	public boolean isMaincharge () {
		return _maincharge;
	}

	/**
	 * Set the value related to the column: MAINCHARGE
	 * @param _maincharge the MAINCHARGE value
	 */
	public void setMaincharge (boolean _maincharge) {
		this._maincharge = _maincharge;
	}



	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.String getQuohdrId () {
		return _quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param _quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.String _quohdrId) {
		this._quohdrId = _quohdrId;
	}


	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return _txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param _txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String _txt2) {
		this._txt2 = _txt2;
	}




	/**
	 * Return the value associated with the column: CHGAMT
	 */
	public java.lang.String getChgamt () {
		return _chgamt;
	}

	/**
	 * Set the value related to the column: CHGAMT
	 * @param _chgamt the CHGAMT value
	 */
	public void setChgamt (java.lang.String _chgamt) {
		this._chgamt = _chgamt;
	}





	/**
	 * Return the value associated with the column: chargekey
	 */
	public java.lang.String getChargekey () {
		return _chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param _chargekey the chargekey value
	 */
	public void setChargekey (java.lang.String _chargekey) {
		this._chargekey = _chargekey;
	}


	/**
	 * Return the value associated with the column: INVOICEGROUPREF
	 */
	public java.lang.String getInvoicegroupref () {
		return _invoicegroupref;
	}

	/**
	 * Set the value related to the column: INVOICEGROUPREF
	 * @param _invoicegroupref the INVOICEGROUPREF value
	 */
	public void setInvoicegroupref (java.lang.String _invoicegroupref) {
		this._invoicegroupref = _invoicegroupref;
	}


	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param _activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}


	/**
	 * Return the value associated with the column: UNITS
	 */
	public java.lang.String getUnits () {
		return _units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param _units the UNITS value
	 */
	public void setUnits (java.lang.String _units) {
		this._units = _units;
	}


	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return _ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param _ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}


	/**
	 * Return the value associated with the column: TAXCODE
	 */
	public java.lang.String getTaxcode () {
		return _taxcode;
	}

	/**
	 * Set the value related to the column: TAXCODE
	 * @param _taxcode the TAXCODE value
	 */
	public void setTaxcode (java.lang.String _taxcode) {
		this._taxcode = _taxcode;
	}



	/**
	 * Return the value associated with the column: RATE
	 */
	public java.lang.String getRate () {
		return _rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param _rate the RATE value
	 */
	public void setRate (java.lang.String _rate) {
		this._rate = _rate;
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
		
		// removed to allow proposal customers to enter charges
		// when the quote is copied to the order the header customer
		// will be used
		//addErrorIfBlank(errors, "customeraddrkey.addrkey", _customeraddrkey, "error.customer.required");
		
		addErrorIfBlank(errors, "chargekey.chargekey", _chargekey, "error.charge.required");

		if (_chargetype.equals("UNIT") || _chargetype.equals("DISTANCE")) 
			addErrorIfBlank(errors, "units", _units, "error.units.required");

		
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
		keysToSkip.add("id");
		keysToSkip.add("action");		
		keysToSkip.add("invoicepref");
		keysToSkip.add("tariffkey");
		keysToSkip.add("departmentkey");
		keysToSkip.add("quotno");
		keysToSkip.add("custtarfhdrId");
		keysToSkip.add("dmrgflag");
		keysToSkip.add("companykey");
		keysToSkip.add("maincharge");
		keysToSkip.add("txt2");
		keysToSkip.add("invoicegroupref");
		keysToSkip.add("activitykey");
		
		keysToSkip.add("createuserid");	
		keysToSkip.add("createdate");
		keysToSkip.add("createtime");
		
		return keysToSkip;
	}
	
	
}
