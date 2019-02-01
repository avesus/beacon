package com.bureaueye.beacon.form.quotation;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.Quohdr;
 
/**
 * 
 * Amendments ----------
 * 
 * NT 2014-04-01 BESL-201404-0001 RAVENMAX & WEBSERVICE
 * 
 */
public final class WorkflowWebserviceLineItem extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public WorkflowWebserviceLineItem(Quoapprove quoapprove, Quohdr quohdr) {
		this._id = quohdr.getId().toString();
		this._quoapproveId = quoapprove.getQuoapproveId();
		this._quohdrId = quohdr.getId();

		this._quotno = quohdr.getQuotno();

		this._quotestatus = quohdr.getQuotestatus();
		this._quotebyuserid = quohdr.getQuotebyuserid();

		this._expirydate = quohdr.getExpirydate();
		this._quotedate = quohdr.getQuotedate();

		this._shipmethod = quohdr.getShipmethod();

		this._companykey = quohdr.getCompanykey();
		this._departmentkey = quohdr.getDepartmentkey();
		this._activitykey = quohdr.getActivitykey();

		this._customername = quohdr.getCustomername();

		this._createdate = quoapprove.getCreatedate();
		this._createtime = quoapprove.getCreatetime();
		this._createtimestamp = quoapprove.getCreatetimestamp().toString();

		this._notes = quoapprove.getNotes();
		this._priority = quoapprove.getPriority();
		this._userid = quoapprove.getUserid();
		this._approvetype = quoapprove.getApprovetype();
		this._usergroupid = quoapprove.getUsergroupid();
		this._rejectreason = quoapprove.getRejectreason();
		this._approveflag = quoapprove.getApproveflag();
		this._approvedate = quoapprove.getApprovedate();
		this._approvetime = quoapprove.getApprovetime();
	}

	// --------------------------------------------------- Instance Variables

	/**
	 * The unique id.
	 */
	private String _id;

	/**
     */
	private java.lang.Integer _quohdrId;
	private java.lang.Integer _quoapproveId;
	private String _quotno;

	private java.util.Date _approvedate;
	private String _approvetime;

	public String _notes;
	public String _priority;
	public String _userid;
	public String _approvetype;
	public String _usergroupid;
	public String _rejectreason;
	public String _approveflag;

	private java.util.Date _expirydate;
	private java.util.Date _quotedate;
	private java.util.Date _createdate;
	private String _createtimestamp;
	private String _createtime;
	private String _customername;
	private String _quotebyuserid;
	private String _quotestatus;
	private String _companykey;
	private String _departmentkey;
	private String _activitykey;

	private String _shipmethod;
	private String _ldglocationname;
	private String _dchlocationname;
	private String _productname;

	private boolean _checked;

	// ----------------------------------------------------------- Properties

	public boolean isChecked() {
		return (this._checked);
	}

	public void setChecked(boolean b) {
		this._checked = b;
	}

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="QUOAPPROVE_ID"
	 */
	public java.lang.Integer getQuoapproveId() {
		return _quoapproveId;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param _quoapproveId
	 *            the new ID
	 */
	public void setQuoapproveId(java.lang.Integer _quoapproveId) {
		this._quoapproveId = _quoapproveId;
	}

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="QUOHDR_ID"
	 */
	public java.lang.Integer getQuohdrId() {
		return _quohdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param _quohdrId
	 *            the new ID
	 */
	public void setQuohdrId(java.lang.Integer _quohdrId) {
		this._quohdrId = _quohdrId;
	}

	/**
     */
	public String getId() {
		return (this._id);
	}

	/**
     */
	public void setId(String _id) {
		this._id = _id;
	}

	/**
     */
	public String getApproveflag() {
		return (this._approveflag);
	}

	/**
     */
	public void setApproveflag(String _approveflag) {
		this._approveflag = _approveflag;
	}

	/**
     */
	public String getQuotno() {
		return (this._quotno);
	}

	/**
     */
	public void setQuotno(String _quotno) {
		this._quotno = _quotno;
	}

	/**
     */
	public String getCreatetimestamp() {
		return (this._createtimestamp);
	}

	/**
     */
	public void setCreatetimestamp(String _createtimestamp) {
		this._createtimestamp = _createtimestamp;
	}

	/**
     */
	public String getCustomername() {
		return (this._customername);
	}

	/**
     */
	public void setCustomername(String _customername) {
		this._customername = _customername;
	}

	/**
	 * Return the value associated with the column: expirydate
	 */
	public java.util.Date getExpirydate() {
		return _expirydate;
	}

	/**
	 * Set the value related to the column: expirydate
	 * 
	 * @param _expirydate
	 *            the expirydate value
	 */
	public void setExpirydate(java.util.Date _expirydate) {
		this._expirydate = _expirydate;
	}

	/**
     */
	public String getQuotebyuserid() {
		return (this._quotebyuserid);
	}

	/**
     */
	public void setQuotebyuserid(String _quotebyuserid) {
		this._quotebyuserid = _quotebyuserid;
	}

	/**
     */
	public String getQuotestatus() {
		return (this._quotestatus);
	}

	/**
     */
	public void setQuotestatus(String _quotestatus) {
		this._quotestatus = _quotestatus;
	}

	/**
     */
	public java.util.Date getQuotedate() {
		return (this._quotedate);
	}

	public void setQuotedate(java.util.Date _quotedate) {
		this._quotedate = _quotedate;
	}

	/**
     */
	public String getCompanykey() {
		return (this._companykey);
	}

	public void setCompanykey(String _companykey) {
		this._companykey = _companykey;
	}

	/**
     */
	public String getDepartmentkey() {
		return (this._departmentkey);
	}

	public void setDepartmentkey(String _departmentkey) {
		this._departmentkey = _departmentkey;
	}

	/**
     */
	public String getActivitykey() {
		return (this._activitykey);
	}

	public void setActivitykey(String _activitykey) {
		this._activitykey = _activitykey;
	}

	/**
     */
	public String getProductname() {
		return (this._productname);
	}

	public void setProductname(String _productname) {
		this._productname = _productname;
	}

	/**
     */
	public String getLdglocationname() {
		return (this._ldglocationname);
	}

	public void setLdglocationname(String _ldglocationname) {
		this._ldglocationname = _ldglocationname;
	}

	/**
     */
	public String getDchlocationname() {
		return (this._dchlocationname);
	}

	public void setDchlocationname(String _dchlocationname) {
		this._dchlocationname = _dchlocationname;
	}

	/**
     */
	public String getShipmethod() {
		return (this._shipmethod);
	}

	public void setShipmethod(String _shipmethod) {
		this._shipmethod = _shipmethod;
	}

	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes() {
		return _notes;
	}

	/**
	 * Set the value related to the column: notes
	 * 
	 * @param _notes
	 *            the notes value
	 */
	public void setNotes(java.lang.String _notes) {
		this._notes = _notes;
	}

	/**
	 * Return the value associated with the column: approvetype
	 */
	public java.lang.String getApprovetype() {
		return _approvetype;
	}

	/**
	 * Set the value related to the column: approvetype
	 * 
	 * @param _approvetype
	 *            the approvetype value
	 */
	public void setApprovetype(java.lang.String _approvetype) {
		this._approvetype = _approvetype;
	}

	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid() {
		return _usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * 
	 * @param _usergroupid
	 *            the usergroupid value
	 */
	public void setUsergroupid(java.lang.String _usergroupid) {
		this._usergroupid = _usergroupid;
	}

	/**
	 * Return the value associated with the column: approvedate
	 */
	public java.util.Date getApprovedate() {
		return _approvedate;
	}

	/**
	 * Set the value related to the column: approvedate
	 * 
	 * @param _approvedate
	 *            the approvedate value
	 */
	public void setApprovedate(java.util.Date _approvedate) {
		this._approvedate = _approvedate;
	}

	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid() {
		return _userid;
	}

	/**
	 * Set the value related to the column: userid
	 * 
	 * @param _userid
	 *            the userid value
	 */
	public void setUserid(java.lang.String _userid) {
		this._userid = _userid;
	}

	/**
	 * Return the value associated with the column: approvetime
	 */
	public java.lang.String getApprovetime() {
		return _approvetime;
	}

	/**
	 * Set the value related to the column: approvetime
	 * 
	 * @param _approvetime
	 *            the approvetime value
	 */
	public void setApprovetime(java.lang.String _approvetime) {
		this._approvetime = _approvetime;
	}

	/**
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason() {
		return _rejectreason;
	}

	/**
	 * Set the value related to the column: rejectreason
	 * 
	 * @param _rejectreason
	 *            the rejectreason value
	 */
	public void setRejectreason(java.lang.String _rejectreason) {
		this._rejectreason = _rejectreason;
	}

	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority() {
		return _priority;
	}

	/**
	 * Set the value related to the column: priority
	 * 
	 * @param _priority
	 *            the priority value
	 */
	public void setPriority(java.lang.String _priority) {
		this._priority = _priority;
	}

	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate() {
		return _createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * 
	 * @param createdate
	 *            the createdate value
	 */
	public void setCreatedate(java.util.Date createdate) {
		this._createdate = createdate;
	}

	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime() {
		return _createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * 
	 * @param createtime
	 *            the createtime value
	 */
	public void setCreatetime(java.lang.String createtime) {
		this._createtime = createtime;
	}

	// --------------------------------------------------------- Public Methods

	/**
	 * Reset all properties to their default values.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this._checked = false;
	}

	/**
	 * Validate the properties that have been set from this HTTP request, and
	 * return an <code>ActionErrors</code> object that encapsulates any
	 * validation errors that have been found. If no errors are found, return
	 * <code>null</code> or an <code>ActionErrors</code> object with no recorded
	 * error messages.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		return (errors);

	}

}
