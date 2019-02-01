package com.bureaueye.beacon.model.quotation.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the quocost table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="quocost"
 */

public abstract class BaseQuocost  implements Serializable {

	public static String REF = "Quocost";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_VENDOR_FAX = "VendorFax";
	public static String PROP_XRATE = "Xrate";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_VENDOR_CONTACT = "VendorContact";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_CSTAMT = "Cstamt";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_VENDOR_NAME = "VendorName";
	public static String PROP_VENDOR_EMAIL = "VendorEmail";
	public static String PROP_UNITS = "Units";
	public static String PROP_UNITNAME = "Unitname";
	public static String PROP_QUOCOST_ID = "QuocostId";
	public static String PROP_QUOMOV_ID = "QuomovId";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_RATE = "Rate";
	public static String PROP_COSTTYPE = "Costtype";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_QUOTNO = "Quotno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_VENDTARFHDR_ID = "VendtarfhdrId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_VENDOR_PHONE = "VendorPhone";
	public static String PROP_TXT = "Txt";
	public static String PROP_VENDOR_ADDR1 = "VendorAddr1";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_VENDOR_ADDR2 = "VendorAddr2";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseQuocost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQuocost (java.lang.Integer quocostId) {
		this.setQuocostId(quocostId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer quocostId;

	// fields
	private java.lang.String vendorFax;
	private java.lang.Integer quohdrId;
	private java.lang.String systemlogprogram;
	private java.math.BigDecimal cstamt;
	private java.lang.String vendorName;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String vendtarfhdrId;
	private java.lang.String vendorContact;
	private java.lang.String vendorAddr1;
	private java.lang.Integer quomovId;
	private boolean xinactive;
	private java.lang.String quotno;
	private java.lang.String costtype;
	private java.lang.String vendorEmail;
	private java.lang.String systemloglock;
	private java.lang.String systemlogtime;
	private java.lang.String unitname;
	private boolean deleted;
	private java.lang.String vendorAddr2;
	private java.lang.String createuserid;
	private java.lang.String txt;
	private java.math.BigDecimal xrate;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.lang.String vendorPhone;
	private java.lang.String xlock;
	private java.math.BigDecimal rate;
	private java.lang.String vendoraddrkey;
	private java.lang.String costkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOCOST_ID"
     */
	public java.lang.Integer getQuocostId () {
		return quocostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quocostId the new ID
	 */
	public void setQuocostId (java.lang.Integer quocostId) {
		this.quocostId = quocostId;
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
	 * Return the value associated with the column: CSTAMT
	 */
	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}

	/**
	 * Set the value related to the column: CSTAMT
	 * @param cstamt the CSTAMT value
	 */
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
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
	 * Return the value associated with the column: VENDTARFHDR_ID
	 */
	public java.lang.String getVendtarfhdrId () {
		return vendtarfhdrId;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrId (java.lang.String vendtarfhdrId) {
		this.vendtarfhdrId = vendtarfhdrId;
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
	 * Return the value associated with the column: QUOMOV_ID
	 */
	public java.lang.Integer getQuomovId () {
		return quomovId;
	}

	/**
	 * Set the value related to the column: QUOMOV_ID
	 * @param quomovId the QUOMOV_ID value
	 */
	public void setQuomovId (java.lang.Integer quomovId) {
		this.quomovId = quomovId;
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
	 * Return the value associated with the column: quotno
	 */
	public java.lang.String getQuotno () {
		return quotno;
	}

	/**
	 * Set the value related to the column: quotno
	 * @param quotno the quotno value
	 */
	public void setQuotno (java.lang.String quotno) {
		this.quotno = quotno;
	}



	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param costtype the costtype value
	 */
	public void setCosttype (java.lang.String costtype) {
		this.costtype = costtype;
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
	 * Return the value associated with the column: systemloglock
	 */
	public java.lang.String getSystemloglock () {
		return systemloglock;
	}

	/**
	 * Set the value related to the column: systemloglock
	 * @param systemloglock the systemloglock value
	 */
	public void setSystemloglock (java.lang.String systemloglock) {
		this.systemloglock = systemloglock;
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
	 * Return the value associated with the column: unitname
	 */
	public java.lang.String getUnitname () {
		return unitname;
	}

	/**
	 * Set the value related to the column: unitname
	 * @param unitname the unitname value
	 */
	public void setUnitname (java.lang.String unitname) {
		this.unitname = unitname;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
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
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: TXT
	 * @param txt the TXT value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}



	/**
	 * Return the value associated with the column: XRATE
	 */
	public java.math.BigDecimal getXrate () {
		return xrate;
	}

	/**
	 * Set the value related to the column: XRATE
	 * @param xrate the XRATE value
	 */
	public void setXrate (java.math.BigDecimal xrate) {
		this.xrate = xrate;
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
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
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
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.quotation.Quocost)) return false;
		else {
			com.bureaueye.beacon.model.quotation.Quocost quocost = (com.bureaueye.beacon.model.quotation.Quocost) obj;
			if (null == this.getQuocostId() || null == quocost.getQuocostId()) return false;
			else return (this.getQuocostId().equals(quocost.getQuocostId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getQuocostId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getQuocostId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}