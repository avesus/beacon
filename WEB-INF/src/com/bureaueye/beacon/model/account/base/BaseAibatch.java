package com.bureaueye.beacon.model.account.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the aibatch table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="aibatch"
 */

public abstract class BaseAibatch  implements Serializable {

	public static String REF = "Aibatch";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_RELOADALL = "Reloadall";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_UPDATEMODE = "Updatemode";
	public static String PROP_AIBATCH_ID = "AibatchId";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_PROCESSSTATUS = "Processstatus";
	public static String PROP_ERRORCOUNT = "Errorcount";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_RETURNVALUE = "Returnvalue";
	public static String PROP_SENTTIME = "Senttime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_BATCHCOUNT = "Batchcount";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_COMPANYID = "Companyid";
	public static String PROP_SENTDATE = "Sentdate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_PROCESSCOUNT = "Processcount";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseAibatch () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAibatch (java.lang.Integer aibatchId) {
		this.setAibatchId(aibatchId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer aibatchId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String activitykey;
	private java.util.Date deletedate;
	private java.lang.Integer batchcount;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.String companykey;
	private java.lang.String systemlogaction;
	private java.lang.String deletetime;
	private java.lang.String createtime;
	private java.lang.String systemlogprogram;
	private java.lang.String senttime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.util.Date sentdate;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.Integer rowid;
	private boolean deleteflag;
	private java.lang.Integer errorcount;
	private java.lang.Integer processcount;
	private java.lang.String companyid;
	private java.lang.String returnvalue;
	private java.lang.String processstatus;
	private java.lang.String updatemode;
	private java.lang.String reloadall;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="AIBATCH_ID"
     */
	public java.lang.Integer getAibatchId () {
		return aibatchId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param aibatchId the new ID
	 */
	public void setAibatchId (java.lang.Integer aibatchId) {
		this.aibatchId = aibatchId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: errorcount
	 */
	public java.lang.Integer getErrorcount () {
		return errorcount;
	}

	/**
	 * Set the value related to the column: errorcount
	 * @param errorcount the errorcount value
	 */
	public void setErrorcount (java.lang.Integer errorcount) {
		this.errorcount = errorcount;
	}



	/**
	 * Return the value associated with the column: processcount
	 */
	public java.lang.Integer getProcesscount () {
		return processcount;
	}

	/**
	 * Set the value related to the column: processcount
	 * @param processcount the processcount value
	 */
	public void setProcesscount (java.lang.Integer processcount) {
		this.processcount = processcount;
	}



	/**
	 * Return the value associated with the column: companyid
	 */
	public java.lang.String getCompanyid () {
		return companyid;
	}

	/**
	 * Set the value related to the column: companyid
	 * @param companyid the companyid value
	 */
	public void setCompanyid (java.lang.String companyid) {
		this.companyid = companyid;
	}



	/**
	 * Return the value associated with the column: returnvalue
	 */
	public java.lang.String getReturnvalue () {
		return returnvalue;
	}

	/**
	 * Set the value related to the column: returnvalue
	 * @param returnvalue the returnvalue value
	 */
	public void setReturnvalue (java.lang.String returnvalue) {
		this.returnvalue = returnvalue;
	}



	/**
	 * Return the value associated with the column: processstatus
	 */
	public java.lang.String getProcessstatus () {
		return processstatus;
	}

	/**
	 * Set the value related to the column: processstatus
	 * @param processstatus the processstatus value
	 */
	public void setProcessstatus (java.lang.String processstatus) {
		this.processstatus = processstatus;
	}



	/**
	 * Return the value associated with the column: updatemode
	 */
	public java.lang.String getUpdatemode () {
		return updatemode;
	}

	/**
	 * Set the value related to the column: updatemode
	 * @param updatemode the updatemode value
	 */
	public void setUpdatemode (java.lang.String updatemode) {
		this.updatemode = updatemode;
	}



	/**
	 * Return the value associated with the column: reloadall
	 */
	public java.lang.String getReloadall () {
		return reloadall;
	}

	/**
	 * Set the value related to the column: reloadall
	 * @param reloadall the reloadall value
	 */
	public void setReloadall (java.lang.String reloadall) {
		this.reloadall = reloadall;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.account.Aibatch)) return false;
		else {
			com.bureaueye.beacon.model.account.Aibatch aibatch = (com.bureaueye.beacon.model.account.Aibatch) obj;
			if (null == this.getAibatchId() || null == aibatch.getAibatchId()) return false;
			else return (this.getAibatchId().equals(aibatch.getAibatchId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAibatchId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAibatchId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}