package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the systemmappingcode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="systemmappingcode"
 */

public abstract class BaseSystemmappingcode  implements Serializable {

	public static String REF = "Systemmappingcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_CODETYPE = "Codetype";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_COMPANYCODE = "Companycode";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SYSTEMMAPPINGCODE_ID = "SystemmappingcodeId";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_BEACONCODE = "Beaconcode";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseSystemmappingcode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemmappingcode (java.lang.Integer systemmappingcodeId) {
		this.setSystemmappingcodeId(systemmappingcodeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer systemmappingcodeId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String beaconcode;
	private java.lang.String createuserid;
	private boolean deleteflag;
	private java.lang.String departmentkey;
	private java.lang.String codetype;
	private java.util.Date deletedate;
	private boolean xinactive;
	private java.lang.String deletetime;
	private java.lang.String companykey;
	private java.lang.String systemlogtime;
	private java.lang.String activitykey;
	private java.util.Date createdate;
	private java.lang.String companycode;
	private java.lang.String createtime;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SYSTEMMAPPINGCODE_ID"
     */
	public java.lang.Integer getSystemmappingcodeId () {
		return systemmappingcodeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemmappingcodeId the new ID
	 */
	public void setSystemmappingcodeId (java.lang.Integer systemmappingcodeId) {
		this.systemmappingcodeId = systemmappingcodeId;
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
	 * Return the value associated with the column: beaconcode
	 */
	public java.lang.String getBeaconcode () {
		return beaconcode;
	}

	/**
	 * Set the value related to the column: beaconcode
	 * @param beaconcode the beaconcode value
	 */
	public void setBeaconcode (java.lang.String beaconcode) {
		this.beaconcode = beaconcode;
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
	 * Return the value associated with the column: codetype
	 */
	public java.lang.String getCodetype () {
		return codetype;
	}

	/**
	 * Set the value related to the column: codetype
	 * @param codetype the codetype value
	 */
	public void setCodetype (java.lang.String codetype) {
		this.codetype = codetype;
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
	 * Return the value associated with the column: companycode
	 */
	public java.lang.String getCompanycode () {
		return companycode;
	}

	/**
	 * Set the value related to the column: companycode
	 * @param companycode the companycode value
	 */
	public void setCompanycode (java.lang.String companycode) {
		this.companycode = companycode;
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
		if (!(obj instanceof com.bureaueye.beacon.model.system.Systemmappingcode)) return false;
		else {
			com.bureaueye.beacon.model.system.Systemmappingcode systemmappingcode = (com.bureaueye.beacon.model.system.Systemmappingcode) obj;
			if (null == this.getSystemmappingcodeId() || null == systemmappingcode.getSystemmappingcodeId()) return false;
			else return (this.getSystemmappingcodeId().equals(systemmappingcode.getSystemmappingcodeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSystemmappingcodeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSystemmappingcodeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}