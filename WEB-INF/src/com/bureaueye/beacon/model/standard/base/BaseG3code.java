package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the g3code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="g3code"
 */

public abstract class BaseG3code  implements Serializable {

	public static String REF = "G3code";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_G1CODEKEY = "G1codekey";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_LDESC = "Ldesc";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_G3CODE_ID = "G3codeId";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_GROUPG3CODEKEY = "Groupg3codekey";
	public static String PROP_SDESC = "Sdesc";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_LOCATIONCODE = "Locationcode";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_G2CODEKEY = "G2codekey";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_G3CODEKEY = "G3codekey";


	// constructors
	public BaseG3code () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseG3code (java.lang.Integer g3codeId) {
		this.setG3codeId(g3codeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer g3codeId;

	// fields
	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String ldesc;
	private java.lang.String sdesc;
	private java.lang.String locationcode;
	private java.lang.String groupg3codekey;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private boolean deleteflag;
	private java.util.Date deletedate;
	private java.lang.String deletetime;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogaction;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogtime;
	private java.lang.String systemloguserid;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.lang.Integer rowid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="G3CODE_ID"
     */
	public java.lang.Integer getG3codeId () {
		return g3codeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param g3codeId the new ID
	 */
	public void setG3codeId (java.lang.Integer g3codeId) {
		this.g3codeId = g3codeId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: g1codekey
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}

	/**
	 * Set the value related to the column: g1codekey
	 * @param g1codekey the g1codekey value
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}



	/**
	 * Return the value associated with the column: g2codekey
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 * Set the value related to the column: g2codekey
	 * @param g2codekey the g2codekey value
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}



	/**
	 * Return the value associated with the column: g3codekey
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}

	/**
	 * Set the value related to the column: g3codekey
	 * @param g3codekey the g3codekey value
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}



	/**
	 * Return the value associated with the column: ldesc
	 */
	public java.lang.String getLdesc () {
		return ldesc;
	}

	/**
	 * Set the value related to the column: ldesc
	 * @param ldesc the ldesc value
	 */
	public void setLdesc (java.lang.String ldesc) {
		this.ldesc = ldesc;
	}



	/**
	 * Return the value associated with the column: sdesc
	 */
	public java.lang.String getSdesc () {
		return sdesc;
	}

	/**
	 * Set the value related to the column: sdesc
	 * @param sdesc the sdesc value
	 */
	public void setSdesc (java.lang.String sdesc) {
		this.sdesc = sdesc;
	}



	/**
	 * Return the value associated with the column: locationcode
	 */
	public java.lang.String getLocationcode () {
		return locationcode;
	}

	/**
	 * Set the value related to the column: locationcode
	 * @param locationcode the locationcode value
	 */
	public void setLocationcode (java.lang.String locationcode) {
		this.locationcode = locationcode;
	}



	/**
	 * Return the value associated with the column: groupg3codekey
	 */
	public java.lang.String getGroupg3codekey () {
		return groupg3codekey;
	}

	/**
	 * Set the value related to the column: groupg3codekey
	 * @param groupg3codekey the groupg3codekey value
	 */
	public void setGroupg3codekey (java.lang.String groupg3codekey) {
		this.groupg3codekey = groupg3codekey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.G3code)) return false;
		else {
			com.bureaueye.beacon.model.standard.G3code g3code = (com.bureaueye.beacon.model.standard.G3code) obj;
			if (null == this.getG3codeId() || null == g3code.getG3codeId()) return false;
			else return (this.getG3codeId().equals(g3code.getG3codeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getG3codeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getG3codeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}