package com.bureaueye.beacon.form.account;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



/**
 *
 * Amendments
 * ----------
 *	
 *	NT	2009-11-25		ITT-200911-0003		Account Interface	 
 *
 *  NT	2010-04-18		ITT-201004-0001		AI Modifications 
 *											- AI detail maintenance (changes not commented)					 
 *								
 */
public final class AIOutForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String _action;
	
	// primary key
	private java.lang.String _aioutId;
	
	// fields
	private java.lang.String _aibatchId;
	private java.lang.String _aiid;
	private java.lang.String _fatime;
	private java.lang.String _departmentkey;
	private java.lang.String _dockey;
	private java.lang.String _deletetime;
	private java.lang.String _doctype;
	private java.lang.String _faid;
	private java.lang.String _companykey;
	private java.lang.String _document;
	private java.util.Date _createdate;
	private java.lang.String _controlid;
	private java.util.Date _sentdate;
	private boolean _testflag;
	private java.lang.String _createuserid;
	private java.lang.String _aistatus;
	private java.lang.String _senttime;
	private boolean _deleteflag;
	private java.util.Date _deletedate;
	private java.lang.String _errors;
	private java.lang.String _warnings;	
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
	 */
	public java.lang.String getAioutId () {
		return _aioutId;
	}
	
	/**
	 * Set the unique identifier of this class
	 * @param _aioutId the new ID
	 */
	public void setAioutId (java.lang.String _aioutId) {
		this._aioutId = _aioutId;
	}
	
	
	/**
	 * Return the value associated with the column: AIBATCH_ID
	 */
	public java.lang.String getAibatchId () {
		return _aibatchId;
	}
	
	/**
	 * Set the value related to the column: AIBATCH_ID
	 * @param _aibatchId the AIBATCH_ID value
	 */
	public void setAibatchId (java.lang.String _aibatchId) {
		this._aibatchId = _aibatchId;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: aiid
	 */
	public java.lang.String getAiid () {
		return _aiid;
	}
	
	/**
	 * Set the value related to the column: aiid
	 * @param _aiid the aiid value
	 */
	public void setAiid (java.lang.String _aiid) {
		this._aiid = _aiid;
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
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate_ () {
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
	public java.util.Date getSentdate_ () {
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
	 * Return the value associated with the column: aistatus
	 */
	public java.lang.String getAistatus () {
		return _aistatus;
	}
	
	/**
	 * Set the value related to the column: aistatus
	 * @param _aistatus the aistatus value
	 */
	public void setAistatus (java.lang.String _aistatus) {
		this._aistatus = _aistatus;
	}
	
	
	/**
	 * Return the value associated with the column: senttime
	 */
	public java.lang.String getSenttime_ () {
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
	 */
	public java.lang.String getWarnings () {
		return _warnings;
	}	
	/**
	 */
	public void setWarnings (java.lang.String _warnings) {
		this._warnings = _warnings;
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
	public java.lang.String getCreatetime_ () {
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
		if (_action == null || _action.equals("Delete") || _action.equals("ReSend"))
			return null;
		
	
		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	
		       	
 
		if (_action.equals("Create")) {			
		}
		
		
		addErrorIfBlank(errors, "doctype", _doctype, "error.doctype.required");
		addErrorIfBlank(errors, "companykey", _companykey, "error.company.required");		
		addErrorIfBlank(errors, "dockey", _dockey, "error.jobshipmentid.required");		
        
        
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
