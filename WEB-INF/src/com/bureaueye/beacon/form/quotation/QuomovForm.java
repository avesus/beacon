package com.bureaueye.beacon.form.quotation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class QuomovForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	// primary key
	private java.lang.String _quomovId;

	// fields
	private java.lang.String _vendorFax;
	private java.lang.String _seqno;	
	private java.lang.String _vendorName;
	private boolean _initfromday;
	private java.lang.String _tog2key;
	private java.lang.String _vendorContact;
	private java.lang.String _vendorAddr1;
	private java.lang.String _departmentkey;
	private boolean _inittoday;
	private java.lang.String _fromlocationkey;
	private java.lang.String _tolocationkey;
	private java.lang.String _vendorEmail;
	private java.lang.String _tog3key;
	private java.lang.String _companykey;
	private java.lang.String _movcost;
	private java.lang.String _vendoraddrkey;
	private java.lang.String _tog4key;
	private java.lang.String _tog1key;
	private java.lang.String _sectionkey;
	private java.lang.String _vendorAddr2;
	private java.lang.String _fromdayno = "0";
	private java.lang.String _fromg3key;
	private java.lang.String _todayno = "0";
	private boolean _stdCostsGenerated;
	private java.lang.String _fromg2key;
	private java.lang.String _quotno;
	private java.lang.String _quohdrId;
	private java.lang.String _fromg1key;
	private java.lang.String _activitykey;
	private java.lang.String _fromg4key;
	private java.lang.String _vendorPhone;

	private java.lang.String _section;

	private java.lang.String _numberofcosts;

	
	public java.lang.String getSection() {
		return _section;
	}
	public void setSection(java.lang.String _section) {
		this._section = _section;
	}
	

	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}


	// derived field methods
	public String getNumberofcosts() { return _numberofcosts;	}
	public void setNumberofcosts(String _numberofcosts) { this._numberofcosts = _numberofcosts;	}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOMOV_ID"
     */
	public java.lang.String getQuomovId () {
		return _quomovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _quomovId the new ID
	 */
	public void setQuomovId (java.lang.String _quomovId) {
		this._quomovId = _quomovId;
	}


	public void setSeqno (java.lang.String _seqno) {
		this._seqno = _seqno;
	}
	public java.lang.String getSeqno () {
		return _seqno;
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
	 * Return the value associated with the column: initfromday
	 */
	public boolean getInitfromday () {
		return _initfromday;
	}

	/**
	 * Set the value related to the column: initfromday
	 * @param _initfromday the initfromday value
	 */
	public void setInitfromday (boolean _initfromday) {
		this._initfromday = _initfromday;
	}





	/**
	 * Return the value associated with the column: tog2key
	 */
	public java.lang.String getTog2key () {
		return _tog2key;
	}

	/**
	 * Set the value related to the column: tog2key
	 * @param _tog2key the tog2key value
	 */
	public void setTog2key (java.lang.String _tog2key) {
		this._tog2key = _tog2key;
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
	 * Return the value associated with the column: inittoday
	 */
	public boolean getInittoday () {
		return _inittoday;
	}

	/**
	 * Set the value related to the column: inittoday
	 * @param _inittoday the inittoday value
	 */
	public void setInittoday (boolean _inittoday) {
		this._inittoday = _inittoday;
	}



	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public java.lang.String getFromlocationkey () {
		return _fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param _fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (java.lang.String _fromlocationkey) {
		this._fromlocationkey = _fromlocationkey;
	}


	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public java.lang.String getTolocationkey () {
		return _tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param _tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (java.lang.String _tolocationkey) {
		this._tolocationkey = _tolocationkey;
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
	 * Return the value associated with the column: tog3key
	 */
	public java.lang.String getTog3key () {
		return _tog3key;
	}

	/**
	 * Set the value related to the column: tog3key
	 * @param _tog3key the tog3key value
	 */
	public void setTog3key (java.lang.String _tog3key) {
		this._tog3key = _tog3key;
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
	 * Return the value associated with the column: MOVCOST
	 */
	public java.lang.String getMovcost () {
		return _movcost;
	}

	/**
	 * Set the value related to the column: MOVCOST
	 * @param _movcost the MOVCOST value
	 */
	public void setMovcost (java.lang.String _movcost) {
		this._movcost = _movcost;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param _vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}


	/**
	 * Return the value associated with the column: tog4key
	 */
	public java.lang.String getTog4key () {
		return _tog4key;
	}

	/**
	 * Set the value related to the column: tog4key
	 * @param _tog4key the tog4key value
	 */
	public void setTog4key (java.lang.String _tog4key) {
		this._tog4key = _tog4key;
	}


	/**
	 * Return the value associated with the column: tog1key
	 */
	public java.lang.String getTog1key () {
		return _tog1key;
	}

	/**
	 * Set the value related to the column: tog1key
	 * @param _tog1key the tog1key value
	 */
	public void setTog1key (java.lang.String _tog1key) {
		this._tog1key = _tog1key;
	}


	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey () {
		return _sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param _sectionkey the sectionkey value
	 */
	public void setSectionkey (java.lang.String _sectionkey) {
		this._sectionkey = _sectionkey;
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
	 * Return the value associated with the column: fromdayno
	 */
	public java.lang.String getFromdayno () {
		return _fromdayno;
	}

	/**
	 * Set the value related to the column: fromdayno
	 * @param _fromdayno the fromdayno value
	 */
	public void setFromdayno (java.lang.String _fromdayno) {
		this._fromdayno = _fromdayno;
	}


	/**
	 * Return the value associated with the column: fromg3key
	 */
	public java.lang.String getFromg3key () {
		return _fromg3key;
	}

	/**
	 * Set the value related to the column: fromg3key
	 * @param _fromg3key the fromg3key value
	 */
	public void setFromg3key (java.lang.String _fromg3key) {
		this._fromg3key = _fromg3key;
	}


	/**
	 * Return the value associated with the column: todayno
	 */
	public java.lang.String getTodayno () {
		return _todayno;
	}

	/**
	 * Set the value related to the column: todayno
	 * @param _todayno the todayno value
	 */
	public void setTodayno (java.lang.String _todayno) {
		this._todayno = _todayno;
	}


	/**
	 * Return the value associated with the column: STD_COSTS_GENERATED
	 */
	public boolean isStdCostsGenerated () {
		return _stdCostsGenerated;
	}

	/**
	 * Set the value related to the column: STD_COSTS_GENERATED
	 * @param _stdCostsGenerated the STD_COSTS_GENERATED value
	 */
	public void setStdCostsGenerated (boolean _stdCostsGenerated) {
		this._stdCostsGenerated = _stdCostsGenerated;
	}


	/**
	 * Return the value associated with the column: fromg2key
	 */
	public java.lang.String getFromg2key () {
		return _fromg2key;
	}

	/**
	 * Set the value related to the column: fromg2key
	 * @param _fromg2key the fromg2key value
	 */
	public void setFromg2key (java.lang.String _fromg2key) {
		this._fromg2key = _fromg2key;
	}


	/**
	 * Return the value associated with the column: QUOTNO
	 */
	public java.lang.String getQuotno () {
		return _quotno;
	}

	/**
	 * Set the value related to the column: QUOTNO
	 * @param _quotno the QUOTNO value
	 */
	public void setQuotno (java.lang.String _quotno) {
		this._quotno = _quotno;
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
	 * Return the value associated with the column: fromg1key
	 */
	public java.lang.String getFromg1key () {
		return _fromg1key;
	}

	/**
	 * Set the value related to the column: fromg1key
	 * @param _fromg1key the fromg1key value
	 */
	public void setFromg1key (java.lang.String _fromg1key) {
		this._fromg1key = _fromg1key;
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
	 * Return the value associated with the column: fromg4key
	 */
	public java.lang.String getFromg4key () {
		return _fromg4key;
	}

	/**
	 * Set the value related to the column: fromg4key
	 * @param _fromg4key the fromg4key value
	 */
	public void setFromg4key (java.lang.String _fromg4key) {
		this._fromg4key = _fromg4key;
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


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		_initfromday = false;
		_inittoday = false;
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
		addErrorIfBlank(errors, "sectionkey", _sectionkey, "error.section.required");
		addErrorIfBlank(errors, "fromlocationkey", _fromlocationkey, "error.fromlocation.required");
		addErrorIfBlank(errors, "tolocationkey", _tolocationkey, "error.tolocation.required");
		addErrorIfBlank(errors, "vendoraddrkey", _vendoraddrkey, "error.vendoraddrkey.required");
		
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

		keysToSkip.add("vendorFax");
		keysToSkip.add("vendorName");
		keysToSkip.add("initfromday");
		keysToSkip.add("tog2key");
		keysToSkip.add("vendorContact");
		keysToSkip.add("vendorAddr1");
		keysToSkip.add("departmentkey");
		keysToSkip.add("inittoday");
		keysToSkip.add("vendorEmail");
		keysToSkip.add("tog3key");
		keysToSkip.add("companykey");
		keysToSkip.add("tog4key");
		keysToSkip.add("tog1key");
		keysToSkip.add("vendorAddr2");
		keysToSkip.add("fromg3key");
		keysToSkip.add("stdCostsGenerated");
		keysToSkip.add("fromg2key");
		keysToSkip.add("quotno");
		keysToSkip.add("fromg1key");
		keysToSkip.add("activitykey");
		keysToSkip.add("fromg4key");
		keysToSkip.add("vendorPhone");
		
		keysToSkip.add("numberofcosts");
		
		keysToSkip.add("section");	
		
		keysToSkip.add("createuserid");	
		keysToSkip.add("createdate");
		keysToSkip.add("createtime");		

		keysToSkip.add("quocosts");
		
		return keysToSkip;
	}
	
	
}
