package com.bureaueye.beacon.form.edi;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.form.BaseForm;

public final class EDIInboundForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	// primary key
	private java.lang.String _ediinboundId;

	// fields
	private java.lang.String _edibatchId;
	private java.lang.String _ediid;
	private java.lang.String _fatime;
	private java.lang.String _departmentkey;
	private java.lang.String _dockey;
	private java.lang.String _deletetime;
	private java.lang.String _doctype;
	private java.lang.String _faid;
	private java.lang.String _companykey;
	private java.lang.String _document;
	private java.lang.String _xmldocument;
	private java.util.Date _createdate;
	private java.lang.String _controlid;
	private java.util.Date _sentdate;
	private boolean _testflag;
	private java.lang.String _createuserid;
	private java.lang.String _edistatus;
	private java.lang.String _senttime;
	private boolean _deleteflag;
	private java.util.Date _deletedate;
	private java.lang.String _errors;
	private boolean _ackreqflag;
	private java.util.Date _fadate;
	private java.lang.String _createtime;
	private java.lang.String _filename;



	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="EDIINBOUND_ID"
     */
	public java.lang.String getEdiinboundId () {
		return _ediinboundId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _ediinboundId the new ID
	 */
	public void setEdiinboundId (java.lang.String _ediinboundId) {
		this._ediinboundId = _ediinboundId;
	}


	/**
	 * Return the value associated with the column: EDIBATCH_ID
	 */
	public java.lang.String getEdibatchId () {
		return _edibatchId;
	}

	/**
	 * Set the value related to the column: EDIBATCH_ID
	 * @param _edibatchId the EDIBATCH_ID value
	 */
	public void setEdibatchId (java.lang.String _edibatchId) {
		this._edibatchId = _edibatchId;
	}




	/**
	 * Return the value associated with the column: ediid
	 */
	public java.lang.String getEdiid () {
		return _ediid;
	}

	/**
	 * Set the value related to the column: ediid
	 * @param _ediid the ediid value
	 */
	public void setEdiid (java.lang.String _ediid) {
		this._ediid = _ediid;
	}


	/**
	 * Return the value associated with the column: fatime
	 */
	public java.lang.String getFatime () {
		return _fatime;
	}

	/**
	 * Set the value related to the column: fatime
	 * @param _fatime the fatime value
	 */
	public void setFatime (java.lang.String _fatime) {
		this._fatime = _fatime;
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
	 * Return the value associated with the column: dockey
	 */
	public java.lang.String getDockey () {
		return _dockey;
	}

	/**
	 * Set the value related to the column: dockey
	 * @param _dockey the dockey value
	 */
	public void setDockey (java.lang.String _dockey) {
		this._dockey = _dockey;
	}



	/**
	 * Return the value associated with the column: deletetime
	 */
	public java.lang.String getDeletetime () {
		return _deletetime;
	}

	/**
	 * Set the value related to the column: deletetime
	 * @param _deletetime the deletetime value
	 */
	public void setDeletetime (java.lang.String _deletetime) {
		this._deletetime = _deletetime;
	}


	/**
	 * Return the value associated with the column: doctype
	 */
	public java.lang.String getDoctype () {
		return _doctype;
	}

	/**
	 * Set the value related to the column: doctype
	 * @param _doctype the doctype value
	 */
	public void setDoctype (java.lang.String _doctype) {
		this._doctype = _doctype;
	}


	/**
	 * Return the value associated with the column: faid
	 */
	public java.lang.String getFaid () {
		return _faid;
	}

	/**
	 * Set the value related to the column: faid
	 * @param _faid the faid value
	 */
	public void setFaid (java.lang.String _faid) {
		this._faid = _faid;
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
	 * Return the value associated with the column: document
	 */
	public java.lang.String getDocument () {
		return _document;
	}

	/**
	 * Set the value related to the column: document
	 * @param _document the document value
	 */
	public void setDocument (java.lang.String _document) {
		this._document = _document;
	}

	/**
	 * Return the value associated with the column: xmldocument
	 */
	public java.lang.String getXmldocument () {
		return _xmldocument;
	}

	/**
	 * Set the value related to the column: xmldocument
	 * @param __xmldocument the xmldocument value
	 */
	public void setXmldocument (java.lang.String _xmldocument) {
		this._xmldocument = _xmldocument;
	}
	

	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param _createdate the createdate value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}


	/**
	 * Return the value associated with the column: controlid
	 */
	public java.lang.String getControlid () {
		return _controlid;
	}

	/**
	 * Set the value related to the column: controlid
	 * @param _controlid the controlid value
	 */
	public void setControlid (java.lang.String _controlid) {
		this._controlid = _controlid;
	}


	/**
	 * Return the value associated with the column: sentdate
	 */
	public java.util.Date getSentdate () {
		return _sentdate;
	}

	/**
	 * Set the value related to the column: sentdate
	 * @param _sentdate the sentdate value
	 */
	public void setSentdate (java.util.Date _sentdate) {
		this._sentdate = _sentdate;
	}


	/**
	 * Return the value associated with the column: testflag
	 */
	public boolean isTestflag () {
		return _testflag;
	}

	/**
	 * Set the value related to the column: testflag
	 * @param _testflag the testflag value
	 */
	public void setTestflag (boolean _testflag) {
		this._testflag = _testflag;
	}


	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param _createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}


	/**
	 * Return the value associated with the column: edistatus
	 */
	public java.lang.String getEdistatus () {
		return _edistatus;
	}

	/**
	 * Set the value related to the column: edistatus
	 * @param _edistatus the edistatus value
	 */
	public void setEdistatus (java.lang.String _edistatus) {
		this._edistatus = _edistatus;
	}


	/**
	 * Return the value associated with the column: senttime
	 */
	public java.lang.String getSenttime () {
		return _senttime;
	}

	/**
	 * Set the value related to the column: senttime
	 * @param _senttime the senttime value
	 */
	public void setSenttime (java.lang.String _senttime) {
		this._senttime = _senttime;
	}


	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag () {
		return _deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param _deleteflag the deleteflag value
	 */
	public void setDeleteflag (boolean _deleteflag) {
		this._deleteflag = _deleteflag;
	}


	/**
	 * Return the value associated with the column: deletedate
	 */
	public java.util.Date getDeletedate () {
		return _deletedate;
	}

	/**
	 * Set the value related to the column: deletedate
	 * @param _deletedate the deletedate value
	 */
	public void setDeletedate (java.util.Date _deletedate) {
		this._deletedate = _deletedate;
	}


	/**
	 * Return the value associated with the column: errors
	 */
	public java.lang.String getErrors () {
		return _errors;
	}

	/**
	 * Set the value related to the column: errors
	 * @param _errors the errors value
	 */
	public void setErrors (java.lang.String _errors) {
		this._errors = _errors;
	}


	/**
	 * Return the value associated with the column: ackreqflag
	 */
	public boolean isAckreqflag () {
		return _ackreqflag;
	}

	/**
	 * Set the value related to the column: ackreqflag
	 * @param _ackreqflag the ackreqflag value
	 */
	public void setAckreqflag (boolean _ackreqflag) {
		this._ackreqflag = _ackreqflag;
	}



	/**
	 * Return the value associated with the column: fadate
	 */
	public java.util.Date getFadate () {
		return _fadate;
	}

	/**
	 * Set the value related to the column: fadate
	 * @param _fadate the fadate value
	 */
	public void setFadate (java.util.Date _fadate) {
		this._fadate = _fadate;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return _createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param _createtime the createtime value
	 */
	public void setCreatetime (java.lang.String _createtime) {
		this._createtime = _createtime;
	}



	/**
	 * Return the value associated with the column: filename
	 */
	public java.lang.String getFilename () {
		return _filename;
	}

	/**
	 * Set the value related to the column: filename
	 * @param _filename the filename value
	 */
	public void setFilename (java.lang.String _filename) {
		this._filename = _filename;
	}

	
	

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();


		return errors;

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
