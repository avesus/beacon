package com.bureaueye.beacon.form.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class OrdermovcostForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	// primary key
	private java.lang.String _ordercostId;
	private java.lang.String _orderhdrId;
	
	// fields
	private java.lang.String _baseccykey;
	private java.lang.String _vendorFax;
	private java.lang.String _cstamt = "0.0";
	private java.lang.String _vendorName;
	private java.lang.String _vendtarfhdrId;
	private java.lang.String _vendorContact;
	private java.lang.String _vendorAddr1;
	private java.lang.String _ordermovId;
	private String _costkey;
	private java.lang.String _orderno;
	private java.lang.String _costtype = "UNIT";
	private java.lang.String _vendorEmail;
	private String _vendoraddrkey;
	private java.lang.String _unitname;
	private boolean _deleted;
	private java.lang.String _vendorAddr2;
	private java.lang.String _txt;
	private java.lang.String _xrate = "1.0";
	private java.lang.String _units = "0";
	private java.lang.String _ccykey;
	private java.lang.String _vendorPhone;
	private java.lang.String _rate = "0.0";



	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	/**
	 * Return the unique identifier of this class
     */
	public java.lang.String getOrdercostId () {
		return _ordercostId;
	}

	/**
	 */
	public void setOrdercostId (java.lang.String _ordercostId) {
		this._ordercostId = _ordercostId;
	}

	
	/**
     */
	public java.lang.String getOrderhdrId () {
		return _orderhdrId;
	}
	/**
	 */
	public void setOrderhdrId (java.lang.String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}
	
	

	/**
	 * Return the value associated with the column: VENDOR_FAX
	 */
	public java.lang.String getVendorFax () {
		return _vendorFax;
	}

	/**
	 * Set the value related to the column: VENDOR_FAX
	 * @param _vendorFax the VENDOR_FAX value
	 */
	public void setVendorFax (java.lang.String _vendorFax) {
		this._vendorFax = _vendorFax;
	}



	/**
	 * Return the value associated with the column: CSTAMT
	 */
	public java.lang.String getCstamt () {
		return _cstamt;
	}

	/**
	 * Set the value related to the column: CSTAMT
	 * @param _cstamt the CSTAMT value
	 */
	public void setCstamt (java.lang.String _cstamt) {
		this._cstamt = _cstamt;
	}


	/**
	 * Return the value associated with the column: VENDOR_NAME
	 */
	public java.lang.String getVendorName () {
		return _vendorName;
	}

	/**
	 * Set the value related to the column: VENDOR_NAME
	 * @param _vendorName the VENDOR_NAME value
	 */
	public void setVendorName (java.lang.String _vendorName) {
		this._vendorName = _vendorName;
	}



	/**
	 * Return the value associated with the column: VENDTARFHDR_ID
	 */
	public java.lang.String getVendtarfhdrId () {
		return _vendtarfhdrId;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param _vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrId (java.lang.String _vendtarfhdrId) {
		this._vendtarfhdrId = _vendtarfhdrId;
	}


	/**
	 * Return the value associated with the column: VENDOR_CONTACT
	 */
	public java.lang.String getVendorContact () {
		return _vendorContact;
	}

	/**
	 * Set the value related to the column: VENDOR_CONTACT
	 * @param _vendorContact the VENDOR_CONTACT value
	 */
	public void setVendorContact (java.lang.String _vendorContact) {
		this._vendorContact = _vendorContact;
	}


	/**
	 * Return the value associated with the column: VENDOR_ADDR1
	 */
	public java.lang.String getVendorAddr1 () {
		return _vendorAddr1;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR1
	 * @param _vendorAddr1 the VENDOR_ADDR1 value
	 */
	public void setVendorAddr1 (java.lang.String _vendorAddr1) {
		this._vendorAddr1 = _vendorAddr1;
	}


	/**
	 */
	public java.lang.String getOrdermovId () {
		return _ordermovId;
	}

	/**
	 */
	public void setOrdermovId (java.lang.String _ordermovId) {
		this._ordermovId = _ordermovId;
	}



	/**
	 * Return the value associated with the column: costkey
	 */
	public String getCostkey () {
		return _costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param _costkey the costkey value
	 */
	public void setCostkey (String _costkey) {
		this._costkey = _costkey;
	}


	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

	/**
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}


	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return _costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param _costtype the costtype value
	 */
	public void setCosttype (java.lang.String _costtype) {
		this._costtype = _costtype;
	}


	/**
	 * Return the value associated with the column: VENDOR_EMAIL
	 */
	public java.lang.String getVendorEmail () {
		return _vendorEmail;
	}

	/**
	 * Set the value related to the column: VENDOR_EMAIL
	 * @param _vendorEmail the VENDOR_EMAIL value
	 */
	public void setVendorEmail (java.lang.String _vendorEmail) {
		this._vendorEmail = _vendorEmail;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param _vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}


	/**
	 * Return the value associated with the column: unitname
	 */
	public java.lang.String getUnitname () {
		return _unitname;
	}

	/**
	 * Set the value related to the column: unitname
	 * @param _unitname the unitname value
	 */
	public void setUnitname (java.lang.String _unitname) {
		this._unitname = _unitname;
	}


	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return _deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param _deleted the deleted value
	 */
	public void setDeleted (boolean _deleted) {
		this._deleted = _deleted;
	}


	/**
	 * Return the value associated with the column: VENDOR_ADDR2
	 */
	public java.lang.String getVendorAddr2 () {
		return _vendorAddr2;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR2
	 * @param _vendorAddr2 the VENDOR_ADDR2 value
	 */
	public void setVendorAddr2 (java.lang.String _vendorAddr2) {
		this._vendorAddr2 = _vendorAddr2;
	}



	/**
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return _txt;
	}

	/**
	 * Set the value related to the column: TXT
	 * @param _txt the TXT value
	 */
	public void setTxt (java.lang.String _txt) {
		this._txt = _txt;
	}


	/**
	 * Return the value associated with the column: XRATE
	 */
	public java.lang.String getXrate () {
		return _xrate;
	}

	/**
	 * Set the value related to the column: XRATE
	 * @param _xrate the XRATE value
	 */
	public void setXrate (java.lang.String _xrate) {
		this._xrate = _xrate;
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
	 * Return the value associated with the column: VENDOR_PHONE
	 */
	public java.lang.String getVendorPhone () {
		return _vendorPhone;
	}

	/**
	 * Set the value related to the column: VENDOR_PHONE
	 * @param _vendorPhone the VENDOR_PHONE value
	 */
	public void setVendorPhone (java.lang.String _vendorPhone) {
		this._vendorPhone = _vendorPhone;
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
		
		addErrorIfBlank(errors, "vendoraddrkey.addrkey", _vendoraddrkey, "error.vendor.required");
		addErrorIfBlank(errors, "costkey.costkey", _costkey, "error.cost.required");

		if (_costtype.equals("UNIT") || _costtype.equals("DISTANCE")) 
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
