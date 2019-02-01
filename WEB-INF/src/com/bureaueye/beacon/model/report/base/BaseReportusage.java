package com.bureaueye.beacon.model.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the reportusage table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="reportusage"
 */

public abstract class BaseReportusage  implements Serializable {

	public static String REF = "Reportusage";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_USERID = "Userid";
	public static String PROP_REPORTQUERY = "Reportquery";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_PRICEID = "Priceid";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_REPORTUSAGE_ID = "ReportusageId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_REPORTID = "Reportid";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_SESSIONID = "Sessionid";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseReportusage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportusage (java.lang.Integer reportusageId) {
		this.setReportusageId(reportusageId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer reportusageId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String activitykey;
	private java.lang.String reportid;
	private java.lang.String userid;
	private java.util.Date createdate;
	private java.lang.String companykey;
	private java.lang.String sessionid;
	private java.lang.String systemlogaction;
	private java.lang.String createtime;
	private java.lang.String systemlogprogram;
	private java.lang.String priceid;
	private java.lang.String systemlogtime;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.String reportquery;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="REPORTUSAGE_ID"
     */
	public java.lang.Integer getReportusageId () {
		return reportusageId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param reportusageId the new ID
	 */
	public void setReportusageId (java.lang.Integer reportusageId) {
		this.reportusageId = reportusageId;
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
	 * Return the value associated with the column: reportid
	 */
	public java.lang.String getReportid () {
		return reportid;
	}

	/**
	 * Set the value related to the column: reportid
	 * @param reportid the reportid value
	 */
	public void setReportid (java.lang.String reportid) {
		this.reportid = reportid;
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
	 * Return the value associated with the column: sessionid
	 */
	public java.lang.String getSessionid () {
		return sessionid;
	}

	/**
	 * Set the value related to the column: sessionid
	 * @param sessionid the sessionid value
	 */
	public void setSessionid (java.lang.String sessionid) {
		this.sessionid = sessionid;
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
	 * Return the value associated with the column: priceid
	 */
	public java.lang.String getPriceid () {
		return priceid;
	}

	/**
	 * Set the value related to the column: priceid
	 * @param priceid the priceid value
	 */
	public void setPriceid (java.lang.String priceid) {
		this.priceid = priceid;
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
	 * Return the value associated with the column: reportquery
	 */
	public java.lang.String getReportquery () {
		return reportquery;
	}

	/**
	 * Set the value related to the column: reportquery
	 * @param reportquery the reportquery value
	 */
	public void setReportquery (java.lang.String reportquery) {
		this.reportquery = reportquery;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.report.Reportusage)) return false;
		else {
			com.bureaueye.beacon.model.report.Reportusage reportusage = (com.bureaueye.beacon.model.report.Reportusage) obj;
			if (null == this.getReportusageId() || null == reportusage.getReportusageId()) return false;
			else return (this.getReportusageId().equals(reportusage.getReportusageId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getReportusageId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getReportusageId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}