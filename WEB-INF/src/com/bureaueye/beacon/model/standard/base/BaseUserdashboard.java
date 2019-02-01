package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the userdashboard table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="userdashboard"
 */

public abstract class BaseUserdashboard  implements Serializable {

	public static String REF = "Userdashboard";
	public static String PROP_DASHBOARDID = "Dashboardid";
	public static String PROP_USERID = "Userid";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_DATERANGEDAYS = "Daterangedays";
	public static String PROP_USERDASHBOARD_ID = "UserdashboardId";
	public static String PROP_TXT = "Txt";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_DASHBOARDTYPE = "Dashboardtype";


	// constructors
	public BaseUserdashboard () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserdashboard (java.lang.Integer userdashboardId) {
		this.setUserdashboardId(userdashboardId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer userdashboardId;

	// fields
	private java.lang.String userid;
	private java.lang.String dashboardid;
	private java.lang.String dashboardtype;
	private java.lang.String daterangedays;
	private java.lang.String txt;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERDASHBOARD_ID"
     */
	public java.lang.Integer getUserdashboardId () {
		return userdashboardId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param userdashboardId the new ID
	 */
	public void setUserdashboardId (java.lang.Integer userdashboardId) {
		this.userdashboardId = userdashboardId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: dashboardid
	 */
	public java.lang.String getDashboardid () {
		return dashboardid;
	}

	/**
	 * Set the value related to the column: dashboardid
	 * @param dashboardid the dashboardid value
	 */
	public void setDashboardid (java.lang.String dashboardid) {
		this.dashboardid = dashboardid;
	}



	/**
	 * Return the value associated with the column: dashboardtype
	 */
	public java.lang.String getDashboardtype () {
		return dashboardtype;
	}

	/**
	 * Set the value related to the column: dashboardtype
	 * @param dashboardtype the dashboardtype value
	 */
	public void setDashboardtype (java.lang.String dashboardtype) {
		this.dashboardtype = dashboardtype;
	}



	/**
	 * Return the value associated with the column: daterangedays
	 */
	public java.lang.String getDaterangedays () {
		return daterangedays;
	}

	/**
	 * Set the value related to the column: daterangedays
	 * @param daterangedays the daterangedays value
	 */
	public void setDaterangedays (java.lang.String daterangedays) {
		this.daterangedays = daterangedays;
	}



	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Userdashboard)) return false;
		else {
			com.bureaueye.beacon.model.standard.Userdashboard userdashboard = (com.bureaueye.beacon.model.standard.Userdashboard) obj;
			if (null == this.getUserdashboardId() || null == userdashboard.getUserdashboardId()) return false;
			else return (this.getUserdashboardId().equals(userdashboard.getUserdashboardId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUserdashboardId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUserdashboardId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}