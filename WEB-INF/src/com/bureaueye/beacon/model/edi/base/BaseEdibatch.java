package com.bureaueye.beacon.model.edi.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the edibatch table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="edibatch"
 */

public abstract class BaseEdibatch  implements Serializable {

	public static String REF = "Edibatch";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SENTTIME = "Senttime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_BATCHCOUNT = "Batchcount";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SENTDATE = "Sentdate";
	public static String PROP_EDIBATCH_ID = "EdibatchId";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseEdibatch () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEdibatch (java.lang.Integer edibatchId) {
		this.setEdibatchId(edibatchId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer edibatchId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date sentdate;
	private java.util.Date systemlogdate;
	private java.lang.String createuserid;
	private java.lang.String senttime;
	private boolean deleteflag;
	private java.lang.Integer batchcount;
	private java.lang.String departmentkey;
	private java.util.Date deletedate;
	private boolean xinactive;
	private java.lang.String deletetime;
	private java.lang.String companykey;
	private java.lang.Integer rowid;
	private java.lang.String systemlogtime;
	private java.lang.String activitykey;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="EDIBATCH_ID"
     */
	public java.lang.Integer getEdibatchId () {
		return edibatchId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param edibatchId the new ID
	 */
	public void setEdibatchId (java.lang.Integer edibatchId) {
		this.edibatchId = edibatchId;
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
	 * Return the value associated with the column: sentdate
	 */
	public java.util.Date getSentdate () {
		return sentdate;
	}

	/**
	 * Set the value related to the column: sentdate
	 * @param sentdate the sentdate value
	 */
	public void setSentdate (java.util.Date sentdate) {
		this.sentdate = sentdate;
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
	 * Return the value associated with the column: senttime
	 */
	public java.lang.String getSenttime () {
		return senttime;
	}

	/**
	 * Set the value related to the column: senttime
	 * @param senttime the senttime value
	 */
	public void setSenttime (java.lang.String senttime) {
		this.senttime = senttime;
	}



	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag () {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param deleteflag the deleteflag value
	 */
	public void setDeleteflag (boolean deleteflag) {
		this.deleteflag = deleteflag;
	}



	/**
	 * Return the value associated with the column: batchcount
	 */
	public java.lang.Integer getBatchcount () {
		return batchcount;
	}

	/**
	 * Set the value related to the column: batchcount
	 * @param batchcount the batchcount value
	 */
	public void setBatchcount (java.lang.Integer batchcount) {
		this.batchcount = batchcount;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: deletedate
	 */
	public java.util.Date getDeletedate () {
		return deletedate;
	}

	/**
	 * Set the value related to the column: deletedate
	 * @param deletedate the deletedate value
	 */
	public void setDeletedate (java.util.Date deletedate) {
		this.deletedate = deletedate;
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
	 * Return the value associated with the column: deletetime
	 */
	public java.lang.String getDeletetime () {
		return deletetime;
	}

	/**
	 * Set the value related to the column: deletetime
	 * @param deletetime the deletetime value
	 */
	public void setDeletetime (java.lang.String deletetime) {
		this.deletetime = deletetime;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
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
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.edi.Edibatch)) return false;
		else {
			com.bureaueye.beacon.model.edi.Edibatch edibatch = (com.bureaueye.beacon.model.edi.Edibatch) obj;
			if (null == this.getEdibatchId() || null == edibatch.getEdibatchId()) return false;
			else return (this.getEdibatchId().equals(edibatch.getEdibatchId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getEdibatchId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getEdibatchId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}