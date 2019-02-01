package com.bureaueye.beacon.model.salesinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sidocno table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sidocno"
 */

public abstract class BaseSidocno  implements Serializable {

	public static String REF = "Sidocno";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_DOCNOPREFIX = "Docnoprefix";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_DOCNOSUFFIX = "Docnosuffix";
	public static String PROP_BUSINESSYEAR = "Businessyear";
	public static String PROP_DOCNOTO = "Docnoto";
	public static String PROP_DOCTYPE = "Doctype";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_DOCNOFROM = "Docnofrom";
	public static String PROP_SIDOCNO_ID = "SidocnoId";
	public static String PROP_DOCNOFORMAT = "Docnoformat";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_DOCNOCOUNT = "Docnocount";


	// constructors
	public BaseSidocno () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSidocno (java.lang.Integer sidocnoId) {
		this.setSidocnoId(sidocnoId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer sidocnoId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.Integer docnocount;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.Integer docnofrom;
	private java.lang.String createuserid;
	private boolean deleteflag;
	private java.lang.String departmentkey;
	private boolean xinactive;
	private java.lang.String doctype;
	private java.lang.String companykey;
	private java.lang.Integer docnoto;
	private java.util.Date createdate;
	private java.lang.Integer businessyear;
	private java.lang.String activitykey;
	private java.lang.String systemlogtime;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String docnoprefix;
	private java.lang.String docnosuffix;
	private java.lang.String docnoformat;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SIDOCNO_ID"
     */
	public java.lang.Integer getSidocnoId () {
		return sidocnoId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sidocnoId the new ID
	 */
	public void setSidocnoId (java.lang.Integer sidocnoId) {
		this.sidocnoId = sidocnoId;
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
	 * Return the value associated with the column: docnocount
	 */
	public java.lang.Integer getDocnocount () {
		return docnocount;
	}

	/**
	 * Set the value related to the column: docnocount
	 * @param docnocount the docnocount value
	 */
	public void setDocnocount (java.lang.Integer docnocount) {
		this.docnocount = docnocount;
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
	 * Return the value associated with the column: docnofrom
	 */
	public java.lang.Integer getDocnofrom () {
		return docnofrom;
	}

	/**
	 * Set the value related to the column: docnofrom
	 * @param docnofrom the docnofrom value
	 */
	public void setDocnofrom (java.lang.Integer docnofrom) {
		this.docnofrom = docnofrom;
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
	 * Return the value associated with the column: doctype
	 */
	public java.lang.String getDoctype () {
		return doctype;
	}

	/**
	 * Set the value related to the column: doctype
	 * @param doctype the doctype value
	 */
	public void setDoctype (java.lang.String doctype) {
		this.doctype = doctype;
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
	 * Return the value associated with the column: docnoto
	 */
	public java.lang.Integer getDocnoto () {
		return docnoto;
	}

	/**
	 * Set the value related to the column: docnoto
	 * @param docnoto the docnoto value
	 */
	public void setDocnoto (java.lang.Integer docnoto) {
		this.docnoto = docnoto;
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
	 * Return the value associated with the column: businessyear
	 */
	public java.lang.Integer getBusinessyear () {
		return businessyear;
	}

	/**
	 * Set the value related to the column: businessyear
	 * @param businessyear the businessyear value
	 */
	public void setBusinessyear (java.lang.Integer businessyear) {
		this.businessyear = businessyear;
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



	/**
	 * Return the value associated with the column: docnoprefix
	 */
	public java.lang.String getDocnoprefix () {
		return docnoprefix;
	}

	/**
	 * Set the value related to the column: docnoprefix
	 * @param docnoprefix the docnoprefix value
	 */
	public void setDocnoprefix (java.lang.String docnoprefix) {
		this.docnoprefix = docnoprefix;
	}



	/**
	 * Return the value associated with the column: docnosuffix
	 */
	public java.lang.String getDocnosuffix () {
		return docnosuffix;
	}

	/**
	 * Set the value related to the column: docnosuffix
	 * @param docnosuffix the docnosuffix value
	 */
	public void setDocnosuffix (java.lang.String docnosuffix) {
		this.docnosuffix = docnosuffix;
	}



	/**
	 * Return the value associated with the column: docnoformat
	 */
	public java.lang.String getDocnoformat () {
		return docnoformat;
	}

	/**
	 * Set the value related to the column: docnoformat
	 * @param docnoformat the docnoformat value
	 */
	public void setDocnoformat (java.lang.String docnoformat) {
		this.docnoformat = docnoformat;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.salesinvoice.Sidocno)) return false;
		else {
			com.bureaueye.beacon.model.salesinvoice.Sidocno sidocno = (com.bureaueye.beacon.model.salesinvoice.Sidocno) obj;
			if (null == this.getSidocnoId() || null == sidocno.getSidocnoId()) return false;
			else return (this.getSidocnoId().equals(sidocno.getSidocnoId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSidocnoId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSidocnoId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}