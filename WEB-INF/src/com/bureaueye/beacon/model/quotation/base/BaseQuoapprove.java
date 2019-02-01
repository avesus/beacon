package com.bureaueye.beacon.model.quotation.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the quoapprove table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="quoapprove"
 */

public abstract class BaseQuoapprove  implements Serializable {

	public static String REF = "Quoapprove";
	public static String PROP_APPROVEDATE = "Approvedate";
	public static String PROP_USERID = "Userid";
	public static String PROP_CREATETIMESTAMP = "Createtimestamp";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_APPROVETIME = "Approvetime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_USERGROUPID = "Usergroupid";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_REJECTREASON = "Rejectreason";
	public static String PROP_NOTES = "Notes";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_QUOAPPROVE_ID = "QuoapproveId";
	public static String PROP_APPROVEFLAG = "Approveflag";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_APPROVETYPE = "Approvetype";


	// constructors
	public BaseQuoapprove () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQuoapprove (java.lang.Integer quoapproveId) {
		this.setQuoapproveId(quoapproveId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer quoapproveId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String notes;
	private java.lang.String createuserid;
	private boolean xinactive;
	private java.lang.Integer quohdrId;
	private java.lang.String approvetype;
	private java.lang.String usergroupid;
	private java.util.Date approvedate;
	private java.lang.String userid;
	private java.lang.Integer rowid;
	private java.lang.String approveflag;
	private java.lang.String approvetime;
	private java.lang.String rejectreason;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String priority;
	private java.lang.String xlock;
	private java.util.Date createtimestamp;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOAPPROVE_ID"
     */
	public java.lang.Integer getQuoapproveId () {
		return quoapproveId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quoapproveId the new ID
	 */
	public void setQuoapproveId (java.lang.Integer quoapproveId) {
		this.quoapproveId = quoapproveId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
	}



	/**
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
	}



	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (boolean xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer quohdrId) {
		this.quohdrId = quohdrId;
	}



	/**
	 * Return the value associated with the column: approvetype
	 */
	public java.lang.String getApprovetype () {
		return approvetype;
	}

	/**
	 * Set the value related to the column: approvetype
	 * @param approvetype the approvetype value
	 */
	public void setApprovetype (java.lang.String approvetype) {
		this.approvetype = approvetype;
	}



	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String usergroupid) {
		this.usergroupid = usergroupid;
	}



	/**
	 * Return the value associated with the column: approvedate
	 */
	public java.util.Date getApprovedate () {
		return approvedate;
	}

	/**
	 * Set the value related to the column: approvedate
	 * @param approvedate the approvedate value
	 */
	public void setApprovedate (java.util.Date approvedate) {
		this.approvedate = approvedate;
	}



	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
	}



	/**
	 * Return the value associated with the column: approveflag
	 */
	public java.lang.String getApproveflag () {
		return approveflag;
	}

	/**
	 * Set the value related to the column: approveflag
	 * @param approveflag the approveflag value
	 */
	public void setApproveflag (java.lang.String approveflag) {
		this.approveflag = approveflag;
	}



	/**
	 * Return the value associated with the column: approvetime
	 */
	public java.lang.String getApprovetime () {
		return approvetime;
	}

	/**
	 * Set the value related to the column: approvetime
	 * @param approvetime the approvetime value
	 */
	public void setApprovetime (java.lang.String approvetime) {
		this.approvetime = approvetime;
	}



	/**
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason () {
		return rejectreason;
	}

	/**
	 * Set the value related to the column: rejectreason
	 * @param rejectreason the rejectreason value
	 */
	public void setRejectreason (java.lang.String rejectreason) {
		this.rejectreason = rejectreason;
	}



	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
	}



	/**
	 * Return the value associated with the column: createtimestamp
	 */
	public java.util.Date getCreatetimestamp () {
		return createtimestamp;
	}

	/**
	 * Set the value related to the column: createtimestamp
	 * @param createtimestamp the createtimestamp value
	 */
	public void setCreatetimestamp (java.util.Date createtimestamp) {
		this.createtimestamp = createtimestamp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.quotation.Quoapprove)) return false;
		else {
			com.bureaueye.beacon.model.quotation.Quoapprove quoapprove = (com.bureaueye.beacon.model.quotation.Quoapprove) obj;
			if (null == this.getQuoapproveId() || null == quoapprove.getQuoapproveId()) return false;
			else return (this.getQuoapproveId().equals(quoapprove.getQuoapproveId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getQuoapproveId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getQuoapproveId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}