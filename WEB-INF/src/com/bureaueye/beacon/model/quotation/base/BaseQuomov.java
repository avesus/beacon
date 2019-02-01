package com.bureaueye.beacon.model.quotation.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the quomov table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="quomov"
 */

public abstract class BaseQuomov  implements Serializable {

	public static String REF = "Quomov";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_VENDOR_FAX = "VendorFax";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_TOG4KEY = "Tog4key";
	public static String PROP_TOG2KEY = "Tog2key";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_VENDOR_CONTACT = "VendorContact";
	public static String PROP_TOLOCATIONKEY = "Tolocationkey";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_VENDOR_NAME = "VendorName";
	public static String PROP_VENDOR_EMAIL = "VendorEmail";
	public static String PROP_FROMG2KEY = "Fromg2key";
	public static String PROP_QUOMOV_ID = "QuomovId";
	public static String PROP_FROMDAYNO = "Fromdayno";
	public static String PROP_FROMLOCATIONKEY = "Fromlocationkey";
	public static String PROP_FROMG4KEY = "Fromg4key";
	public static String PROP_TODAYNO = "Todayno";
	public static String PROP_SEQNO = "Seqno";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_SECTIONKEY = "Sectionkey";
	public static String PROP_FROMG3KEY = "Fromg3key";
	public static String PROP_FROMG1KEY = "Fromg1key";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_QUOTNO = "Quotno";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_INITFROMDAY = "Initfromday";
	public static String PROP_VENDOR_PHONE = "VendorPhone";
	public static String PROP_INITTODAY = "Inittoday";
	public static String PROP_VENDOR_ADDR1 = "VendorAddr1";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_VENDOR_ADDR2 = "VendorAddr2";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TOG1KEY = "Tog1key";
	public static String PROP_TOG3KEY = "Tog3key";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseQuomov () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQuomov (java.lang.Integer quomovId) {
		this.setQuomovId(quomovId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer quomovId;

	// fields
	private java.lang.String vendorFax;
	private java.lang.String systemlogprogram;
	private java.lang.String vendorName;
	private boolean initfromday;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private boolean deleted;
	private java.lang.String tog2key;
	private java.lang.String vendorContact;
	private java.lang.String vendorAddr1;
	private java.lang.String departmentkey;
	private boolean inittoday;
	private boolean xinactive;
	private java.lang.String vendorEmail;
	private java.lang.String tog3key;
	private java.lang.String companykey;
	private java.lang.String systemlogtime;
	private java.lang.String tog4key;
	private java.lang.String tog1key;
	private java.lang.String vendorAddr2;
	private java.lang.Integer fromdayno;
	private java.lang.String fromg3key;
	private java.lang.Integer todayno;
	private java.lang.String fromg2key;
	private java.lang.String quotno;
	private java.lang.String createuserid;
	private java.lang.Integer quohdrId;
	private java.lang.Integer seqno;
	private java.util.Date createdate;
	private java.lang.String fromg1key;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String activitykey;
	private java.lang.String fromg4key;
	private java.lang.String vendorPhone;
	private java.lang.String xlock;
	private java.lang.String vendoraddrkey;
	private java.lang.String fromlocationkey;
	private java.lang.String tolocationkey;
	private java.lang.String sectionkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOMOV_ID"
     */
	public java.lang.Integer getQuomovId () {
		return quomovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quomovId the new ID
	 */
	public void setQuomovId (java.lang.Integer quomovId) {
		this.quomovId = quomovId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: VENDOR_FAX
	 */
	public java.lang.String getVendorFax () {
		return vendorFax;
	}

	/**
	 * Set the value related to the column: VENDOR_FAX
	 * @param vendorFax the VENDOR_FAX value
	 */
	public void setVendorFax (java.lang.String vendorFax) {
		this.vendorFax = vendorFax;
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
	 * Return the value associated with the column: VENDOR_NAME
	 */
	public java.lang.String getVendorName () {
		return vendorName;
	}

	/**
	 * Set the value related to the column: VENDOR_NAME
	 * @param vendorName the VENDOR_NAME value
	 */
	public void setVendorName (java.lang.String vendorName) {
		this.vendorName = vendorName;
	}



	/**
	 * Return the value associated with the column: initfromday
	 */
	public boolean isInitfromday () {
		return initfromday;
	}

	/**
	 * Set the value related to the column: initfromday
	 * @param initfromday the initfromday value
	 */
	public void setInitfromday (boolean initfromday) {
		this.initfromday = initfromday;
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
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: tog2key
	 */
	public java.lang.String getTog2key () {
		return tog2key;
	}

	/**
	 * Set the value related to the column: tog2key
	 * @param tog2key the tog2key value
	 */
	public void setTog2key (java.lang.String tog2key) {
		this.tog2key = tog2key;
	}



	/**
	 * Return the value associated with the column: VENDOR_CONTACT
	 */
	public java.lang.String getVendorContact () {
		return vendorContact;
	}

	/**
	 * Set the value related to the column: VENDOR_CONTACT
	 * @param vendorContact the VENDOR_CONTACT value
	 */
	public void setVendorContact (java.lang.String vendorContact) {
		this.vendorContact = vendorContact;
	}



	/**
	 * Return the value associated with the column: VENDOR_ADDR1
	 */
	public java.lang.String getVendorAddr1 () {
		return vendorAddr1;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR1
	 * @param vendorAddr1 the VENDOR_ADDR1 value
	 */
	public void setVendorAddr1 (java.lang.String vendorAddr1) {
		this.vendorAddr1 = vendorAddr1;
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
	 * Return the value associated with the column: inittoday
	 */
	public boolean isInittoday () {
		return inittoday;
	}

	/**
	 * Set the value related to the column: inittoday
	 * @param inittoday the inittoday value
	 */
	public void setInittoday (boolean inittoday) {
		this.inittoday = inittoday;
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
	 * Return the value associated with the column: VENDOR_EMAIL
	 */
	public java.lang.String getVendorEmail () {
		return vendorEmail;
	}

	/**
	 * Set the value related to the column: VENDOR_EMAIL
	 * @param vendorEmail the VENDOR_EMAIL value
	 */
	public void setVendorEmail (java.lang.String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}



	/**
	 * Return the value associated with the column: tog3key
	 */
	public java.lang.String getTog3key () {
		return tog3key;
	}

	/**
	 * Set the value related to the column: tog3key
	 * @param tog3key the tog3key value
	 */
	public void setTog3key (java.lang.String tog3key) {
		this.tog3key = tog3key;
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
	 * Return the value associated with the column: tog4key
	 */
	public java.lang.String getTog4key () {
		return tog4key;
	}

	/**
	 * Set the value related to the column: tog4key
	 * @param tog4key the tog4key value
	 */
	public void setTog4key (java.lang.String tog4key) {
		this.tog4key = tog4key;
	}



	/**
	 * Return the value associated with the column: tog1key
	 */
	public java.lang.String getTog1key () {
		return tog1key;
	}

	/**
	 * Set the value related to the column: tog1key
	 * @param tog1key the tog1key value
	 */
	public void setTog1key (java.lang.String tog1key) {
		this.tog1key = tog1key;
	}



	/**
	 * Return the value associated with the column: VENDOR_ADDR2
	 */
	public java.lang.String getVendorAddr2 () {
		return vendorAddr2;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR2
	 * @param vendorAddr2 the VENDOR_ADDR2 value
	 */
	public void setVendorAddr2 (java.lang.String vendorAddr2) {
		this.vendorAddr2 = vendorAddr2;
	}



	/**
	 * Return the value associated with the column: fromdayno
	 */
	public java.lang.Integer getFromdayno () {
		return fromdayno;
	}

	/**
	 * Set the value related to the column: fromdayno
	 * @param fromdayno the fromdayno value
	 */
	public void setFromdayno (java.lang.Integer fromdayno) {
		this.fromdayno = fromdayno;
	}



	/**
	 * Return the value associated with the column: fromg3key
	 */
	public java.lang.String getFromg3key () {
		return fromg3key;
	}

	/**
	 * Set the value related to the column: fromg3key
	 * @param fromg3key the fromg3key value
	 */
	public void setFromg3key (java.lang.String fromg3key) {
		this.fromg3key = fromg3key;
	}



	/**
	 * Return the value associated with the column: todayno
	 */
	public java.lang.Integer getTodayno () {
		return todayno;
	}

	/**
	 * Set the value related to the column: todayno
	 * @param todayno the todayno value
	 */
	public void setTodayno (java.lang.Integer todayno) {
		this.todayno = todayno;
	}



	/**
	 * Return the value associated with the column: fromg2key
	 */
	public java.lang.String getFromg2key () {
		return fromg2key;
	}

	/**
	 * Set the value related to the column: fromg2key
	 * @param fromg2key the fromg2key value
	 */
	public void setFromg2key (java.lang.String fromg2key) {
		this.fromg2key = fromg2key;
	}



	/**
	 * Return the value associated with the column: QUOTNO
	 */
	public java.lang.String getQuotno () {
		return quotno;
	}

	/**
	 * Set the value related to the column: QUOTNO
	 * @param quotno the QUOTNO value
	 */
	public void setQuotno (java.lang.String quotno) {
		this.quotno = quotno;
	}



	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
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
	 * Return the value associated with the column: seqno
	 */
	public java.lang.Integer getSeqno () {
		return seqno;
	}

	/**
	 * Set the value related to the column: seqno
	 * @param seqno the seqno value
	 */
	public void setSeqno (java.lang.Integer seqno) {
		this.seqno = seqno;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: fromg1key
	 */
	public java.lang.String getFromg1key () {
		return fromg1key;
	}

	/**
	 * Set the value related to the column: fromg1key
	 * @param fromg1key the fromg1key value
	 */
	public void setFromg1key (java.lang.String fromg1key) {
		this.fromg1key = fromg1key;
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
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
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
	 * Return the value associated with the column: fromg4key
	 */
	public java.lang.String getFromg4key () {
		return fromg4key;
	}

	/**
	 * Set the value related to the column: fromg4key
	 * @param fromg4key the fromg4key value
	 */
	public void setFromg4key (java.lang.String fromg4key) {
		this.fromg4key = fromg4key;
	}



	/**
	 * Return the value associated with the column: VENDOR_PHONE
	 */
	public java.lang.String getVendorPhone () {
		return vendorPhone;
	}

	/**
	 * Set the value related to the column: VENDOR_PHONE
	 * @param vendorPhone the VENDOR_PHONE value
	 */
	public void setVendorPhone (java.lang.String vendorPhone) {
		this.vendorPhone = vendorPhone;
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
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public java.lang.String getFromlocationkey () {
		return fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (java.lang.String fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}



	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public java.lang.String getTolocationkey () {
		return tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (java.lang.String tolocationkey) {
		this.tolocationkey = tolocationkey;
	}



	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.quotation.Quomov)) return false;
		else {
			com.bureaueye.beacon.model.quotation.Quomov quomov = (com.bureaueye.beacon.model.quotation.Quomov) obj;
			if (null == this.getQuomovId() || null == quomov.getQuomovId()) return false;
			else return (this.getQuomovId().equals(quomov.getQuomovId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getQuomovId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getQuomovId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}