package com.bureaueye.beacon.form.salesinvoice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function
 * to Sales Invoice module (changes not commented)
 * 
 */
public final class SihdrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	private java.lang.String _copyid = "";

	// primary key
	private java.lang.String _sihdrId;

	// fields
	private java.lang.String _reasonkey;
	private boolean _mainchargeflag;
	private java.lang.String _departmentkey;
	private boolean _manualflag;
	private java.lang.String _batchId;
	private java.lang.String _languagekey;
	private java.lang.String _companykey;
	private java.lang.String _invoiceno;
	private boolean _confirmedflag;
	private java.lang.String _unitkey;
	private java.lang.String _invoicegroupref;
	private java.lang.String _invoiceref;
	private boolean _printedflag;
	private boolean _deleteflag;
	private java.lang.String _txt1;
	private java.lang.String _paymentterm;
	private java.lang.String _invoiceamt = "0.0";
	private java.lang.String _txt2;
	private java.lang.String _customerref;
	private java.lang.String _taxcode;
	private boolean _postedflag;
	private java.lang.String _activitykey;
	private java.lang.String _invoiceccykey;
	private java.lang.String _periodposted;
	private boolean _rechargeflag;
	private java.lang.String _rectype;
	private java.lang.String _orderno;

	private java.util.Date _posteddate;
	private java.lang.String _postedtime;

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
	private String _customeraddrkey;

	// collections

	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	public String getReadonly() {
		return _readonly;
	}

	public void setReadonly(String _readonly) {
		this._readonly = _readonly;
	}

	/**
	 */
	public String getCopyId() {
		return _copyid;
	}

	/**
	 */
	public void setCopyId(String _copyid) {
		this._copyid = _copyid;
	}

	/**
	 * @hibernate.property column=customeraddrkey
	 */
	public String getCustomeraddrkey() {
		return this._customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * 
	 * @param _customeraddrkey
	 *            the customeraddrkey value
	 */
	public void setCustomeraddrkey(String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}

	/**
	 */
	public java.lang.String getId() {
		return _sihdrId;
	}

	/**
	 */
	public void setId(java.lang.String _sihdrId) {
		this._sihdrId = _sihdrId;
	}

	/**
	 * Return the value associated with the column: reasonkey
	 */
	public java.lang.String getReasonkey() {
		return _reasonkey;
	}

	/**
	 * Set the value related to the column: reasonkey
	 * 
	 * @param _reasonkey
	 *            the reasonkey value
	 */
	public void setReasonkey(java.lang.String _reasonkey) {
		this._reasonkey = _reasonkey;
	}

	/**
	 * Return the value associated with the column: mainchargeflag
	 */
	public boolean isMainchargeflag() {
		return _mainchargeflag;
	}

	/**
	 * Set the value related to the column: mainchargeflag
	 * 
	 * @param _mainchargeflag
	 *            the mainchargeflag value
	 */
	public void setMainchargeflag(boolean _mainchargeflag) {
		this._mainchargeflag = _mainchargeflag;
	}

	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey() {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * 
	 * @param _departmentkey
	 *            the departmentkey value
	 */
	public void setDepartmentkey(java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}

	/**
	 * Return the value associated with the column: manualflag
	 */
	public boolean getManualflag() {
		return _manualflag;
	}

	/**
	 * Set the value related to the column: manualflag
	 * 
	 * @param _manualflag
	 *            the manualflag value
	 */
	public void setManualflag(boolean _manualflag) {
		this._manualflag = _manualflag;
	}

	/**
	 * Return the value associated with the column: BATCH_ID
	 */
	public java.lang.String getBatchId() {
		return _batchId;
	}

	/**
	 * Set the value related to the column: BATCH_ID
	 * 
	 * @param _batchId
	 *            the BATCH_ID value
	 */
	public void setBatchId(java.lang.String _batchId) {
		this._batchId = _batchId;
	}

	/**
	 * Return the value associated with the column: languagekey
	 */
	public java.lang.String getLanguagekey() {
		return _languagekey;
	}

	/**
	 * Set the value related to the column: languagekey
	 * 
	 * @param _languagekey
	 *            the languagekey value
	 */
	public void setLanguagekey(java.lang.String _languagekey) {
		this._languagekey = _languagekey;
	}

	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey() {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * 
	 * @param _companykey
	 *            the companykey value
	 */
	public void setCompanykey(java.lang.String _companykey) {
		this._companykey = _companykey;
	}

	/**
	 * Return the value associated with the column: invoiceno
	 */
	public java.lang.String getInvoiceno() {
		return _invoiceno;
	}

	/**
	 * Set the value related to the column: invoiceno
	 * 
	 * @param _invoiceno
	 *            the invoiceno value
	 */
	public void setInvoiceno(java.lang.String _invoiceno) {
		this._invoiceno = _invoiceno;
	}

	/**
	 * Return the value associated with the column: confirmedflag
	 */
	public boolean isConfirmedflag() {
		return _confirmedflag;
	}

	/**
	 * Set the value related to the column: confirmedflag
	 * 
	 * @param _confirmedflag
	 *            the confirmedflag value
	 */
	public void setConfirmedflag(boolean _confirmedflag) {
		this._confirmedflag = _confirmedflag;
	}

	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey() {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * 
	 * @param _unitkey
	 *            the unitkey value
	 */
	public void setUnitkey(java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}

	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref() {
		return _invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * 
	 * @param _invoicegroupref
	 *            the invoicegroupref value
	 */
	public void setInvoicegroupref(java.lang.String _invoicegroupref) {
		this._invoicegroupref = _invoicegroupref;
	}

	/**
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref() {
		return _invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * 
	 * @param _invoiceref
	 *            the invoiceref value
	 */
	public void setInvoiceref(java.lang.String _invoiceref) {
		this._invoiceref = _invoiceref;
	}

	/**
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag() {
		return _printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * 
	 * @param _printedflag
	 *            the printedflag value
	 */
	public void setPrintedflag(boolean _printedflag) {
		this._printedflag = _printedflag;
	}

	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag() {
		return _deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * 
	 * @param _deleteflag
	 *            the deleteflag value
	 */
	public void setDeleteflag(boolean _deleteflag) {
		this._deleteflag = _deleteflag;
	}

	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1() {
		return _txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * 
	 * @param _txt1
	 *            the txt1 value
	 */
	public void setTxt1(java.lang.String _txt1) {
		this._txt1 = _txt1;
	}

	/**
	 * Return the value associated with the column: paymentterm
	 */
	public java.lang.String getPaymentterm() {
		return _paymentterm;
	}

	/**
	 * Set the value related to the column: paymentterm
	 * 
	 * @param _paymentterm
	 *            the paymentterm value
	 */
	public void setPaymentterm(java.lang.String _paymentterm) {
		this._paymentterm = _paymentterm;
	}

	/**
	 * Return the value associated with the column: invoiceamt
	 */
	public String getInvoiceamt() {
		return _invoiceamt;
	}

	/**
	 * Set the value related to the column: invoiceamt
	 * 
	 * @param _invoiceamt
	 *            the invoiceamt value
	 */
	public void setInvoiceamt(String _invoiceamt) {
		this._invoiceamt = _invoiceamt;
	}

	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2() {
		return _txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * 
	 * @param _txt2
	 *            the txt2 value
	 */
	public void setTxt2(java.lang.String _txt2) {
		this._txt2 = _txt2;
	}

	/**
	 * Return the value associated with the column: customerref
	 */
	public java.lang.String getCustomerref() {
		return _customerref;
	}

	/**
	 * Set the value related to the column: customerref
	 * 
	 * @param _customerref
	 *            the customerref value
	 */
	public void setCustomerref(java.lang.String _customerref) {
		this._customerref = _customerref;
	}

	/**
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode() {
		return _taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * 
	 * @param _taxcode
	 *            the taxcode value
	 */
	public void setTaxcode(java.lang.String _taxcode) {
		this._taxcode = _taxcode;
	}

	/**
	 * Return the value associated with the column: postedflag
	 */
	public boolean isPostedflag() {
		return _postedflag;
	}

	/**
	 * Set the value related to the column: postedflag
	 * 
	 * @param _postedflag
	 *            the postedflag value
	 */
	public void setPostedflag(boolean _postedflag) {
		this._postedflag = _postedflag;
	}

	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey() {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * 
	 * @param _activitykey
	 *            the activitykey value
	 */
	public void setActivitykey(java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}

	/**
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey() {
		return _invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * 
	 * @param _invoiceccykey
	 *            the invoiceccykey value
	 */
	public void setInvoiceccykey(java.lang.String _invoiceccykey) {
		this._invoiceccykey = _invoiceccykey;
	}

	/**
	 * Return the value associated with the column: periodposted
	 */
	public java.lang.String getPeriodposted() {
		return _periodposted;
	}

	/**
	 * Set the value related to the column: periodposted
	 * 
	 * @param _periodposted
	 *            the periodposted value
	 */
	public void setPeriodposted(java.lang.String _periodposted) {
		this._periodposted = _periodposted;
	}

	/**
	 * Return the value associated with the column: rechargeflag
	 */
	public boolean isRechargeflag() {
		return _rechargeflag;
	}

	/**
	 * Set the value related to the column: rechargeflag
	 * 
	 * @param _rechargeflag
	 *            the rechargeflag value
	 */
	public void setRechargeflag(boolean _rechargeflag) {
		this._rechargeflag = _rechargeflag;
	}

	/**
	 * Return the value associated with the column: rectype
	 */
	public java.lang.String getRectype() {
		return _rectype;
	}

	/**
	 * Set the value related to the column: rectype
	 * 
	 * @param _rectype
	 *            the rectype value
	 */
	public void setRectype(java.lang.String _rectype) {
		this._rectype = _rectype;
	}

	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno() {
		return _orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * 
	 * @param _orderno
	 *            the orderno value
	 */
	public void setOrderno(java.lang.String _orderno) {
		this._orderno = _orderno;
	}

	public java.util.Date getPosteddate_() {
		return _posteddate;
	}

	public void setPosteddate(java.util.Date _posteddate) {
		this._posteddate = _posteddate;
	}

	public java.lang.String getPostedtime_() {
		return _postedtime;
	}

	public void setPostedtime(java.lang.String _postedtime) {
		this._postedtime = _postedtime;
	}

	/**
	 * Return the value associated with the column: adddata1
	 */
	public java.lang.String getAdddata1() {
		return adddata1;
	}

	/**
	 * Set the value related to the column: adddata1
	 * 
	 * @param adddata1
	 *            the adddata1 value
	 */
	public void setAdddata1(java.lang.String adddata1) {
		this.adddata1 = adddata1;
	}

	/**
	 * Return the value associated with the column: adddata2
	 */
	public java.lang.String getAdddata2() {
		return adddata2;
	}

	/**
	 * Set the value related to the column: adddata2
	 * 
	 * @param adddata2
	 *            the adddata2 value
	 */
	public void setAdddata2(java.lang.String adddata2) {
		this.adddata2 = adddata2;
	}

	/**
	 * Return the value associated with the column: adddata3
	 */
	public java.lang.String getAdddata3() {
		return adddata3;
	}

	/**
	 * Set the value related to the column: adddata3
	 * 
	 * @param adddata3
	 *            the adddata3 value
	 */
	public void setAdddata3(java.lang.String adddata3) {
		this.adddata3 = adddata3;
	}

	/**
	 * Return the value associated with the column: adddata4
	 */
	public java.lang.String getAdddata4() {
		return adddata4;
	}

	/**
	 * Set the value related to the column: adddata4
	 * 
	 * @param adddata4
	 *            the adddata4 value
	 */
	public void setAdddata4(java.lang.String adddata4) {
		this.adddata4 = adddata4;
	}

	/**
	 * Return the value associated with the column: adddata5
	 */
	public java.lang.String getAdddata5() {
		return adddata5;
	}

	/**
	 * Set the value related to the column: adddata5
	 * 
	 * @param adddata5
	 *            the adddata5 value
	 */
	public void setAdddata5(java.lang.String adddata5) {
		this.adddata5 = adddata5;
	}

	/**
	 * Return the value associated with the column: adddata6
	 */
	public java.lang.String getAdddata6() {
		return adddata6;
	}

	/**
	 * Set the value related to the column: adddata6
	 * 
	 * @param adddata6
	 *            the adddata6 value
	 */
	public void setAdddata6(java.lang.String adddata6) {
		this.adddata6 = adddata6;
	}

	/**
	 * Return the value associated with the column: adddata7
	 */
	public java.lang.String getAdddata7() {
		return adddata7;
	}

	/**
	 * Set the value related to the column: adddata7
	 * 
	 * @param adddata7
	 *            the adddata7 value
	 */
	public void setAdddata7(java.lang.String adddata7) {
		this.adddata7 = adddata7;
	}

	/**
	 * Return the value associated with the column: adddata8
	 */
	public java.lang.String getAdddata8() {
		return adddata8;
	}

	/**
	 * Set the value related to the column: adddata8
	 * 
	 * @param adddata8
	 *            the adddata8 value
	 */
	public void setAdddata8(java.lang.String adddata8) {
		this.adddata8 = adddata8;
	}

	/**
	 * Return the value associated with the column: adddata9
	 */
	public java.lang.String getAdddata9() {
		return adddata9;
	}

	/**
	 * Set the value related to the column: adddata9
	 * 
	 * @param adddata9
	 *            the adddata9 value
	 */
	public void setAdddata9(java.lang.String adddata9) {
		this.adddata9 = adddata9;
	}

	/**
	 * Return the value associated with the column: adddata10
	 */
	public java.lang.String getAdddata10() {
		return adddata10;
	}

	/**
	 * Set the value related to the column: adddata10
	 * 
	 * @param adddata10
	 *            the adddata10 value
	 */
	public void setAdddata10(java.lang.String adddata10) {
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
		ActionErrors errors = super.validate(mapping, request);
		if (errors == null)
			errors = new ActionErrors();

		addErrorIfBlank(errors, "customeraddrkey.addrkey", _customeraddrkey,
				"error.customer.required");
		addErrorIfBlank(errors, "invoiceccykey", _invoiceccykey,
				"error.ccykey.required");
		addErrorIfBlank(errors, "companykey", _companykey,
				"error.company.required");

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
	 * populated for the current form instance. Subclasses that override this
	 * method to provide additional keys to be skipped should be sure to call
	 * <code>super</code>
	 * 
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();

		return keysToSkip;
	}

}
