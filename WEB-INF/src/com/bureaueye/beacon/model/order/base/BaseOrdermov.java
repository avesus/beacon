package com.bureaueye.beacon.model.order.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ordermov table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ordermov"
 */

public abstract class BaseOrdermov  implements Serializable {

	public static String REF = "Ordermov";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_VENDOR_FAX = "VendorFax";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_TOG4KEY = "Tog4key";
	public static String PROP_TOG2KEY = "Tog2key";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_VENDOR_CONTACT = "VendorContact";
	public static String PROP_ACTTOTIMEINMILLIS = "Acttotimeinmillis";
	public static String PROP_VENDOR_EMAIL = "VendorEmail";
	public static String PROP_FROMG2KEY = "Fromg2key";
	public static String PROP_ACTFROMTIME = "Actfromtime";
	public static String PROP_FROMLOCATIONKEY = "Fromlocationkey";
	public static String PROP_ESTTODATE = "Esttodate";
	public static String PROP_FROMG4KEY = "Fromg4key";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_FROMG3KEY = "Fromg3key";
	public static String PROP_SECTIONKEY = "Sectionkey";
	public static String PROP_ACTTODATE = "Acttodate";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_ACTTOTIME = "Acttotime";
	public static String PROP_ESTTOTIME = "Esttotime";
	public static String PROP_VENDOR_PHONE = "VendorPhone";
	public static String PROP_STD_COSTS_GENERATED = "StdCostsGenerated";
	public static String PROP_VENDOR_ADDR1 = "VendorAddr1";
	public static String PROP_VENDOR_ADDR2 = "VendorAddr2";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_ESTTOTIMEINMILLIS = "Esttotimeinmillis";
	public static String PROP_TOG1KEY = "Tog1key";
	public static String PROP_TOG3KEY = "Tog3key";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_ESTFROMTIME = "Estfromtime";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TOLOCATIONKEY = "Tolocationkey";
	public static String PROP_VENDOR_NAME = "VendorName";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_ESTFROMTIMEINMILLIS = "Estfromtimeinmillis";
	public static String PROP_ACTFROMTIMEINMILLIS = "Actfromtimeinmillis";
	public static String PROP_ACTFROMDATE = "Actfromdate";
	public static String PROP_FROMG1KEY = "Fromg1key";
	public static String PROP_ORDERMOV_ID = "OrdermovId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ESTFROMDATE = "Estfromdate";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseOrdermov () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrdermov (java.lang.Integer ordermovId) {
		this.setOrdermovId(ordermovId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer ordermovId;

	// fields
	private java.lang.String vendorFax;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private boolean deleted;
	private java.util.Date systemlogdate;
	private java.lang.String vendorAddr1;
	private java.lang.String departmentkey;
	private java.lang.Long acttotimeinmillis;
	private java.lang.String tog3key;
	private java.lang.String tog4key;
	private java.lang.Long estfromtimeinmillis;
	private java.lang.String systemlogtime;
	private java.lang.String tog1key;
	private java.lang.Long actfromtimeinmillis;
	private java.lang.String vendorAddr2;
	private java.lang.Long esttotimeinmillis;
	private boolean stdCostsGenerated;
	private java.lang.String fromg2key;
	private java.util.Date acttodate;
	private java.lang.String fromg1key;
	private java.lang.String createtime;
	private java.lang.String fromg4key;
	private java.lang.String vendorPhone;
	private java.lang.String xlock;
	private java.lang.String vendorName;
	private java.util.Date estfromdate;
	private java.lang.String systemloguserid;
	private java.util.Date esttodate;
	private java.lang.String tog2key;
	private java.lang.String vendorContact;
	private java.lang.String actfromtime;
	private boolean xinactive;
	private java.lang.String estfromtime;
	private java.lang.String vendorEmail;
	private java.lang.String companykey;
	private java.lang.String acttotime;
	private java.lang.String esttotime;
	private java.lang.String fromg3key;
	private java.lang.String createuserid;
	private java.lang.Integer orderhdrId;
	private java.util.Date actfromdate;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String activitykey;
	private java.lang.String orderno;
	private java.lang.String vendoraddrkey;
	private java.lang.String fromlocationkey;
	private java.lang.String tolocationkey;
	private java.lang.String sectionkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERMOV_ID"
     */
	public java.lang.Integer getOrdermovId () {
		return ordermovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ordermovId the new ID
	 */
	public void setOrdermovId (java.lang.Integer ordermovId) {
		this.ordermovId = ordermovId;
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
	 * Return the value associated with the column: acttotimeinmillis
	 */
	public java.lang.Long getActtotimeinmillis () {
		return acttotimeinmillis;
	}

	/**
	 * Set the value related to the column: acttotimeinmillis
	 * @param acttotimeinmillis the acttotimeinmillis value
	 */
	public void setActtotimeinmillis (java.lang.Long acttotimeinmillis) {
		this.acttotimeinmillis = acttotimeinmillis;
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
	 * Return the value associated with the column: estfromtimeinmillis
	 */
	public java.lang.Long getEstfromtimeinmillis () {
		return estfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: estfromtimeinmillis
	 * @param estfromtimeinmillis the estfromtimeinmillis value
	 */
	public void setEstfromtimeinmillis (java.lang.Long estfromtimeinmillis) {
		this.estfromtimeinmillis = estfromtimeinmillis;
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
	 * Return the value associated with the column: actfromtimeinmillis
	 */
	public java.lang.Long getActfromtimeinmillis () {
		return actfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: actfromtimeinmillis
	 * @param actfromtimeinmillis the actfromtimeinmillis value
	 */
	public void setActfromtimeinmillis (java.lang.Long actfromtimeinmillis) {
		this.actfromtimeinmillis = actfromtimeinmillis;
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
	 * Return the value associated with the column: esttotimeinmillis
	 */
	public java.lang.Long getEsttotimeinmillis () {
		return esttotimeinmillis;
	}

	/**
	 * Set the value related to the column: esttotimeinmillis
	 * @param esttotimeinmillis the esttotimeinmillis value
	 */
	public void setEsttotimeinmillis (java.lang.Long esttotimeinmillis) {
		this.esttotimeinmillis = esttotimeinmillis;
	}



	/**
	 * Return the value associated with the column: STD_COSTS_GENERATED
	 */
	public boolean isStdCostsGenerated () {
		return stdCostsGenerated;
	}

	/**
	 * Set the value related to the column: STD_COSTS_GENERATED
	 * @param stdCostsGenerated the STD_COSTS_GENERATED value
	 */
	public void setStdCostsGenerated (boolean stdCostsGenerated) {
		this.stdCostsGenerated = stdCostsGenerated;
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
	 * Return the value associated with the column: acttodate
	 */
	public java.util.Date getActtodate () {
		return acttodate;
	}

	/**
	 * Set the value related to the column: acttodate
	 * @param acttodate the acttodate value
	 */
	public void setActtodate (java.util.Date acttodate) {
		this.acttodate = acttodate;
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
	 * Return the value associated with the column: estfromdate
	 */
	public java.util.Date getEstfromdate () {
		return estfromdate;
	}

	/**
	 * Set the value related to the column: estfromdate
	 * @param estfromdate the estfromdate value
	 */
	public void setEstfromdate (java.util.Date estfromdate) {
		this.estfromdate = estfromdate;
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
	 * Return the value associated with the column: esttodate
	 */
	public java.util.Date getEsttodate () {
		return esttodate;
	}

	/**
	 * Set the value related to the column: esttodate
	 * @param esttodate the esttodate value
	 */
	public void setEsttodate (java.util.Date esttodate) {
		this.esttodate = esttodate;
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
	 * Return the value associated with the column: actfromtime
	 */
	public java.lang.String getActfromtime () {
		return actfromtime;
	}

	/**
	 * Set the value related to the column: actfromtime
	 * @param actfromtime the actfromtime value
	 */
	public void setActfromtime (java.lang.String actfromtime) {
		this.actfromtime = actfromtime;
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
	 * Return the value associated with the column: estfromtime
	 */
	public java.lang.String getEstfromtime () {
		return estfromtime;
	}

	/**
	 * Set the value related to the column: estfromtime
	 * @param estfromtime the estfromtime value
	 */
	public void setEstfromtime (java.lang.String estfromtime) {
		this.estfromtime = estfromtime;
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
	 * Return the value associated with the column: acttotime
	 */
	public java.lang.String getActtotime () {
		return acttotime;
	}

	/**
	 * Set the value related to the column: acttotime
	 * @param acttotime the acttotime value
	 */
	public void setActtotime (java.lang.String acttotime) {
		this.acttotime = acttotime;
	}



	/**
	 * Return the value associated with the column: esttotime
	 */
	public java.lang.String getEsttotime () {
		return esttotime;
	}

	/**
	 * Set the value related to the column: esttotime
	 * @param esttotime the esttotime value
	 */
	public void setEsttotime (java.lang.String esttotime) {
		this.esttotime = esttotime;
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
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}



	/**
	 * Return the value associated with the column: actfromdate
	 */
	public java.util.Date getActfromdate () {
		return actfromdate;
	}

	/**
	 * Set the value related to the column: actfromdate
	 * @param actfromdate the actfromdate value
	 */
	public void setActfromdate (java.util.Date actfromdate) {
		this.actfromdate = actfromdate;
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
	 * Return the value associated with the column: ORDERNO
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: ORDERNO
	 * @param orderno the ORDERNO value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
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
		if (!(obj instanceof com.bureaueye.beacon.model.order.Ordermov)) return false;
		else {
			com.bureaueye.beacon.model.order.Ordermov ordermov = (com.bureaueye.beacon.model.order.Ordermov) obj;
			if (null == this.getOrdermovId() || null == ordermov.getOrdermovId()) return false;
			else return (this.getOrdermovId().equals(ordermov.getOrdermovId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOrdermovId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOrdermovId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}