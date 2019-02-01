package com.bureaueye.beacon.form.purchaseinvoice;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class PidtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _button;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _pidtlId;
	private java.lang.String _pihdrId;
	
	
	// fields
	
	private java.lang.String _invoiceamt = "0.0";
	private java.lang.String _cstamt = "0.0";
	
	private java.lang.String _txt1;
	private java.lang.String _txt2;
	private java.lang.String _invoicestatus;

	private java.lang.String _disputemessage;
/*	private java.lang.String _costkey;
	private java.lang.String _unitId;
	private java.lang.String _unitkey;*/
	
	private java.lang.String _jobno;
	private java.lang.String _jobhdrId;

	

	// collections
	private java.util.List _vendorjobs;
	private java.util.List _pidtlcosts;	
	

	/**
	 * Return the value associated with the column: Vendorjobs
	 */
	public java.util.List getVendorjobs () {
		return this._vendorjobs;
	}
	/**
	 * Set the value related to the column: Vendorjobs
	 */
	public void setVendorjobs (java.util.List _vendorjobs) {
		this._vendorjobs = _vendorjobs;
	}	
	public void addToVendorjobs (Object obj) {
		if (null == this._vendorjobs) this._vendorjobs = new java.util.LinkedList();
		this._vendorjobs.add(obj);
	}

	
	

	public java.util.List getPidtlcosts () {
		return this._pidtlcosts;
	}
	public void setPidtlcosts (java.util.List _pidtlcosts) {
		this._pidtlcosts = _pidtlcosts;
	}	
	public void addToPidtlcosts (Object obj) {
		if (null == this._pidtlcosts) this._pidtlcosts = new java.util.LinkedList();
		this._pidtlcosts.add(obj);
	}
	
	
	
	public void setButton(String _button) {	this._button = _button;	}
	public String getButton() {return _button;}	
	
	
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
	 */
	public java.lang.String getInvoicestatus () {
		return _invoicestatus;
	}
	/**
	 */
	public void setInvoicestatus (java.lang.String _invoicestatus) {
		this._invoicestatus = _invoicestatus;
	}
	

/*	*//**
	 *//*
	public java.lang.String getUnitkey () {
		return _unitkey;
	}
	*//**
	 *//*
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}
	*//**
	 *//*
	public java.lang.String getUnitId () {
		return _unitId;
	}
	*//**
	 *//*
	public void setUnitId (java.lang.String _unitId) {
		this._unitId = _unitId;
	}*/
	

	/**
     */
	public java.lang.String getPidtlId () {
		return _pidtlId;
	}

	/**
	 */
	public void setPidtlId (java.lang.String _pidtlId) {
		this._pidtlId = _pidtlId;
	}


	/**
	 */
	public java.lang.String getPihdrId () {
		return _pihdrId;
	}

	/**
	 */
	public void setPihdrId (java.lang.String _pihdrId) {
		this._pihdrId = _pihdrId;
	}
	
	
	
	
	/**
     */
	public java.lang.String getJobhdrId() {
		return _jobhdrId;
	}

	/**
	 */
	public void setJobhdrId(java.lang.String _jobhdrId) {
		this._jobhdrId = _jobhdrId;
	}
	

	/**
     */
	public java.lang.String getJobno() {
		return _jobno;
	}

	/**
	 */
	public void setJobno(java.lang.String _jobno) {
		this._jobno = _jobno;
	}
	
	


	/**
	 */
	public java.lang.String getInvoiceamt () {
		return _invoiceamt;
	}

	/**
	 */
	public void setInvoiceamt (java.lang.String _invoiceamt) {
		this._invoiceamt = _invoiceamt;
	}


	/**
	 */
	public java.lang.String getCstamt () {
		return _cstamt;
	}

	/**
	 */
	public void setCstamt (java.lang.String _cstamt) {
		this._cstamt = _cstamt;
	}
	

/*	*//**
	 *//*
	public java.lang.String getCostkey() {
		return _costkey;
	}

	*//**
	 *//*
	public void setCostkey(java.lang.String _costkey) {
		this._costkey = _costkey;
	}*/
	


	/**
	 */
	public java.lang.String getDisputemessage() {
		return _disputemessage;
	}

	/**
	 */
	public void setDisputemessage(java.lang.String _disputemessage) {
		this._disputemessage = _disputemessage;
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
		 
		addErrorIfBlank(errors, "jobno", _jobno, "error.jobno.required");    
		
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
