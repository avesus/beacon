package com.bureaueye.beacon.form.salesinvoice;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



public final class SidtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	
	
	// primary key
	private java.lang.String _sidtlId;

	// fields
	private java.lang.String _baseccykey;
	private java.lang.String _chgamt = "0.0";
	private boolean _mainchargeflag;
	private java.lang.String _units = "0";
	private java.lang.String _sihdrId;
	private java.lang.String _chargetype = "UNIT";
	private java.lang.String _systemlogtime;
	private java.lang.String _demurragedays;
	private java.lang.String _unitkey;
	private java.lang.String _rate = "0.0";
	private java.lang.String _invoicegroupref;
	private java.lang.String _xrateinv = "1.0";
	private java.lang.String _invoiceref;
	private boolean _printedflag;
	private java.lang.String _sapbookperiod;
	private java.lang.String _txt1;
	private java.lang.String _xratebase = "1.0";
	private java.lang.String _uname;
	private java.lang.String _txt2;
	private java.lang.String _printtime;
	private java.lang.String _ccykey;
	private java.lang.String _orderno;
	private java.lang.String _invoiceccykey;
	private java.lang.String _invoiceamt = "0.0";
	private java.lang.String _taxcode;
	
	
	private java.lang.String adddata1;
	private java.lang.String adddata2;
	private java.lang.String adddata3;
	private java.lang.String adddata4;
	private java.lang.String adddata5;
	private java.lang.String adddata6;
	private java.lang.String adddata7;
	private java.lang.String adddata8;
	private java.lang.String adddata9;
	private java.lang.String adddata10;
	
	
	// many to one
	private String _chargekey;
	
	
	// collections

	
	
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
     *  column="SIDTL_ID"
     */
	public java.lang.String getSidtlId () {
		return _sidtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _sidtlId the new ID
	 */
	public void setSidtlId (java.lang.String _sidtlId) {
		this._sidtlId = _sidtlId;
	}




	/**
	 * Return the value associated with the column: chgamt
	 */
	public String getChgamt () {
		return _chgamt;
	}

	/**
	 * Set the value related to the column: chgamt
	 * @param _chgamt the chgamt value
	 */
	public void setChgamt (String _chgamt) {
		this._chgamt = _chgamt;
	}




	/**
	 * Return the value associated with the column: mainchargeflag
	 */
	public boolean isMainchargeflag () {
		return _mainchargeflag;
	}

	/**
	 * Set the value related to the column: mainchargeflag
	 * @param _mainchargeflag the mainchargeflag value
	 */
	public void setMainchargeflag (boolean _mainchargeflag) {
		this._mainchargeflag = _mainchargeflag;
	}


	/**
	 * Return the value associated with the column: units
	 */
	public String getUnits () {
		return _units;
	}

	/**
	 * Set the value related to the column: units
	 * @param _units the units value
	 */
	public void setUnits (String _units) {
		this._units = _units;
	}




	/**
	 * Return the value associated with the column: SIHDR_ID
	 */
	public String getSihdrId () {
		return _sihdrId;
	}

	/**
	 * Set the value related to the column: SIHDR_ID
	 * @param _sihdrId the SIHDR_ID value
	 */
	public void setSihdrId (String _sihdrId) {
		this._sihdrId = _sihdrId;
	}




	/**
	 * Return the value associated with the column: Chargeype
	 */
	public java.lang.String getChargetype () {
		return _chargetype;
	}

	/**
	 * Set the value related to the column: Chargeype
	 * @param _chargetype the _chargetype value
	 */
	public void setChargetype(java.lang.String _chargetype) {
		this._chargetype = _chargetype;
	}



	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return _systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param _systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String _systemlogtime) {
		this._systemlogtime = _systemlogtime;
	}


	/**
	 * Return the value associated with the column: demurragedays
	 */
	public String getDemurragedays () {
		return _demurragedays;
	}

	/**
	 * Set the value related to the column: demurragedays
	 * @param _demurragedays the demurragedays value
	 */
	public void setDemurragedays (String _demurragedays) {
		this._demurragedays = _demurragedays;
	}


	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param _unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}


	/**
	 * Return the value associated with the column: rate
	 */
	public String getRate () {
		return _rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param _rate the rate value
	 */
	public void setRate (String _rate) {
		this._rate = _rate;
	}


	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref () {
		return _invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * @param _invoicegroupref the invoicegroupref value
	 */
	public void setInvoicegroupref (java.lang.String _invoicegroupref) {
		this._invoicegroupref = _invoicegroupref;
	}


	/**
	 * Return the value associated with the column: xrateinv
	 */
	public String getXrateinv () {
		return _xrateinv;
	}

	/**
	 * Set the value related to the column: xrateinv
	 * @param _xrateinv the xrateinv value
	 */
	public void setXrateinv (String _xrateinv) {
		this._xrateinv = _xrateinv;
	}


	/**
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref () {
		return _invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * @param _invoiceref the invoiceref value
	 */
	public void setInvoiceref (java.lang.String _invoiceref) {
		this._invoiceref = _invoiceref;
	}



	/**
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag () {
		return _printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * @param _printedflag the printedflag value
	 */
	public void setPrintedflag (boolean _printedflag) {
		this._printedflag = _printedflag;
	}


	/**
	 * Return the value associated with the column: sapbookperiod
	 */
	public java.lang.String getSapbookperiod () {
		return _sapbookperiod;
	}

	/**
	 * Set the value related to the column: sapbookperiod
	 * @param _sapbookperiod the sapbookperiod value
	 */
	public void setSapbookperiod (java.lang.String _sapbookperiod) {
		this._sapbookperiod = _sapbookperiod;
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
	 * Return the value associated with the column: xratebase
	 */
	public String getXratebase () {
		return _xratebase;
	}

	/**
	 * Set the value related to the column: xratebase
	 * @param _xratebase the xratebase value
	 */
	public void setXratebase (String _xratebase) {
		this._xratebase = _xratebase;
	}



	/**
	 * Return the value associated with the column: uname
	 */
	public java.lang.String getUname () {
		return _uname;
	}

	/**
	 * Set the value related to the column: uname
	 * @param _uname the uname value
	 */
	public void setUname (java.lang.String _uname) {
		this._uname = _uname;
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
	 * Return the value associated with the column: printtime
	 */
	public java.lang.String getPrinttime () {
		return _printtime;
	}

	/**
	 * Set the value related to the column: printtime
	 * @param _printtime the printtime value
	 */
	public void setPrinttime (java.lang.String _printtime) {
		this._printtime = _printtime;
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
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * @param _orderno the orderno value
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
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
	 * Return the value associated with the column: invoiceamt
	 */
	public String getInvoiceamt () {
		return _invoiceamt;
	}

	/**
	 * Set the value related to the column: invoiceamt
	 * @param _invoiceamt the invoiceamt value
	 */
	public void setInvoiceamt (String _invoiceamt) {
		this._invoiceamt = _invoiceamt;
	}


	/**
     * @hibernate.property
     *  column=chargekey
	 */
	public String getChargekey () {
		return this._chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param _chargekey the chargekey value
	 */
	public void setChargekey (String _chargekey) {
		this._chargekey = _chargekey;
	}
	
	
	/**
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode () {
		return _taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * @param _taxcode the taxcode value
	 */
	public void setTaxcode (java.lang.String _taxcode) {
		this._taxcode = _taxcode;
	}
	
	

	
	/**
	 * Return the value associated with the column: adddata1
	 */
	public java.lang.String getAdddata1 () {
		return adddata1;
	}

	/**
	 * Set the value related to the column: adddata1
	 * @param adddata1 the adddata1 value
	 */
	public void setAdddata1 (java.lang.String adddata1) {
		this.adddata1 = adddata1;
	}



	/**
	 * Return the value associated with the column: adddata2
	 */
	public java.lang.String getAdddata2 () {
		return adddata2;
	}

	/**
	 * Set the value related to the column: adddata2
	 * @param adddata2 the adddata2 value
	 */
	public void setAdddata2 (java.lang.String adddata2) {
		this.adddata2 = adddata2;
	}



	/**
	 * Return the value associated with the column: adddata3
	 */
	public java.lang.String getAdddata3 () {
		return adddata3;
	}

	/**
	 * Set the value related to the column: adddata3
	 * @param adddata3 the adddata3 value
	 */
	public void setAdddata3 (java.lang.String adddata3) {
		this.adddata3 = adddata3;
	}



	/**
	 * Return the value associated with the column: adddata4
	 */
	public java.lang.String getAdddata4 () {
		return adddata4;
	}

	/**
	 * Set the value related to the column: adddata4
	 * @param adddata4 the adddata4 value
	 */
	public void setAdddata4 (java.lang.String adddata4) {
		this.adddata4 = adddata4;
	}



	/**
	 * Return the value associated with the column: adddata5
	 */
	public java.lang.String getAdddata5 () {
		return adddata5;
	}

	/**
	 * Set the value related to the column: adddata5
	 * @param adddata5 the adddata5 value
	 */
	public void setAdddata5 (java.lang.String adddata5) {
		this.adddata5 = adddata5;
	}



	/**
	 * Return the value associated with the column: adddata6
	 */
	public java.lang.String getAdddata6 () {
		return adddata6;
	}

	/**
	 * Set the value related to the column: adddata6
	 * @param adddata6 the adddata6 value
	 */
	public void setAdddata6 (java.lang.String adddata6) {
		this.adddata6 = adddata6;
	}



	/**
	 * Return the value associated with the column: adddata7
	 */
	public java.lang.String getAdddata7 () {
		return adddata7;
	}

	/**
	 * Set the value related to the column: adddata7
	 * @param adddata7 the adddata7 value
	 */
	public void setAdddata7 (java.lang.String adddata7) {
		this.adddata7 = adddata7;
	}



	/**
	 * Return the value associated with the column: adddata8
	 */
	public java.lang.String getAdddata8 () {
		return adddata8;
	}

	/**
	 * Set the value related to the column: adddata8
	 * @param adddata8 the adddata8 value
	 */
	public void setAdddata8 (java.lang.String adddata8) {
		this.adddata8 = adddata8;
	}



	/**
	 * Return the value associated with the column: adddata9
	 */
	public java.lang.String getAdddata9 () {
		return adddata9;
	}

	/**
	 * Set the value related to the column: adddata9
	 * @param adddata9 the adddata9 value
	 */
	public void setAdddata9 (java.lang.String adddata9) {
		this.adddata9 = adddata9;
	}



	/**
	 * Return the value associated with the column: adddata10
	 */
	public java.lang.String getAdddata10 () {
		return adddata10;
	}

	/**
	 * Set the value related to the column: adddata10
	 * @param adddata10 the adddata10 value
	 */
	public void setAdddata10 (java.lang.String adddata10) {
		this.adddata10 = adddata10;
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
		
		return keysToSkip;
	}
	
	
}
