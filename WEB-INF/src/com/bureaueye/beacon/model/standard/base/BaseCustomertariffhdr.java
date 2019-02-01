package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertariffhdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertariffhdr"
 */

public abstract class BaseCustomertariffhdr  implements Serializable {

	public static String REF = "Customertariffhdr";
	public static String PROP_TOLOCATIONKEY2 = "Tolocationkey2";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_P2KEY = "P2key";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_TOG4KEY = "Tog4key";
	public static String PROP_TOG2KEY = "Tog2key";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_P3KEY = "P3key";
	public static String PROP_TOLOCATIONKEY = "Tolocationkey";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_FROMG2KEY = "Fromg2key";
	public static String PROP_FROMLOCATIONKEY2 = "Fromlocationkey2";
	public static String PROP_FROMLOCATIONKEY = "Fromlocationkey";
	public static String PROP_FROMG4KEY = "Fromg4key";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_FROMG3KEY = "Fromg3key";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_FROMG1KEY = "Fromg1key";
	public static String PROP_UNITTYPE = "Unittype";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CUSTTARFHDR_ID = "CusttarfhdrId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_P1KEY = "P1key";
	public static String PROP_CHARGEKEY = "Chargekey";
	public static String PROP_VALIDFROM = "Validfrom";
	public static String PROP_VALIDTO = "Validto";
	public static String PROP_LUMPSUM = "Lumpsum";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TOG1KEY = "Tog1key";
	public static String PROP_TOG3KEY = "Tog3key";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseCustomertariffhdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertariffhdr (java.lang.String custtarfhdrId) {
		this.setCusttarfhdrId(custtarfhdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String custtarfhdrId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date validfrom;
	private java.util.Date systemlogdate;
	private java.lang.String tog2key;
	private java.util.Date validto;
	private java.lang.String xinactive;
	private java.lang.String tog3key;
	private java.lang.String p3key;
	private java.lang.String systemlogtime;
	private java.lang.String tog4key;
	private java.util.Date createdate;
	private java.lang.String tog1key;
	private java.lang.String productkey;
	private java.lang.String p2key;
	private java.lang.String fromg3key;
	private java.lang.String createuserid;
	private java.lang.String fromg2key;
	private java.lang.String unittype;
	private java.lang.String fromg1key;
	private java.lang.Integer rowid;
	private java.lang.String p1key;
	private java.lang.String fromg4key;
	private java.lang.String ccykey;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.math.BigDecimal lumpsum;
	private java.lang.String customeraddrkey;
	private java.lang.String chargekey;
	private java.lang.String fromlocationkey;
	private java.lang.String tolocationkey;
	private java.lang.String fromlocationkey2;
	private java.lang.String tolocationkey2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="CUSTTARFHDR_ID"
     */
	public java.lang.String getCusttarfhdrId () {
		return custtarfhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param custtarfhdrId the new ID
	 */
	public void setCusttarfhdrId (java.lang.String custtarfhdrId) {
		this.custtarfhdrId = custtarfhdrId;
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
	 * Return the value associated with the column: validfrom
	 */
	public java.util.Date getValidfrom () {
		return validfrom;
	}

	/**
	 * Set the value related to the column: validfrom
	 * @param validfrom the validfrom value
	 */
	public void setValidfrom (java.util.Date validfrom) {
		this.validfrom = validfrom;
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
	 * Return the value associated with the column: validto
	 */
	public java.util.Date getValidto () {
		return validto;
	}

	/**
	 * Set the value related to the column: validto
	 * @param validto the validto value
	 */
	public void setValidto (java.util.Date validto) {
		this.validto = validto;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
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
	 * Return the value associated with the column: p3key
	 */
	public java.lang.String getP3key () {
		return p3key;
	}

	/**
	 * Set the value related to the column: p3key
	 * @param p3key the p3key value
	 */
	public void setP3key (java.lang.String p3key) {
		this.p3key = p3key;
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
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
	}



	/**
	 * Return the value associated with the column: p2key
	 */
	public java.lang.String getP2key () {
		return p2key;
	}

	/**
	 * Set the value related to the column: p2key
	 * @param p2key the p2key value
	 */
	public void setP2key (java.lang.String p2key) {
		this.p2key = p2key;
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
	 * Return the value associated with the column: unittype
	 */
	public java.lang.String getUnittype () {
		return unittype;
	}

	/**
	 * Set the value related to the column: unittype
	 * @param unittype the unittype value
	 */
	public void setUnittype (java.lang.String unittype) {
		this.unittype = unittype;
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
	 * Return the value associated with the column: p1key
	 */
	public java.lang.String getP1key () {
		return p1key;
	}

	/**
	 * Set the value related to the column: p1key
	 * @param p1key the p1key value
	 */
	public void setP1key (java.lang.String p1key) {
		this.p1key = p1key;
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
	 * Return the value associated with the column: lumpsum
	 */
	public java.math.BigDecimal getLumpsum () {
		return lumpsum;
	}

	/**
	 * Set the value related to the column: lumpsum
	 * @param lumpsum the lumpsum value
	 */
	public void setLumpsum (java.math.BigDecimal lumpsum) {
		this.lumpsum = lumpsum;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}



	/**
	 * Return the value associated with the column: chargekey
	 */
	public java.lang.String getChargekey () {
		return chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param chargekey the chargekey value
	 */
	public void setChargekey (java.lang.String chargekey) {
		this.chargekey = chargekey;
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
	 * Return the value associated with the column: fromlocationkey2
	 */
	public java.lang.String getFromlocationkey2 () {
		return fromlocationkey2;
	}

	/**
	 * Set the value related to the column: fromlocationkey2
	 * @param fromlocationkey2 the fromlocationkey2 value
	 */
	public void setFromlocationkey2 (java.lang.String fromlocationkey2) {
		this.fromlocationkey2 = fromlocationkey2;
	}



	/**
	 * Return the value associated with the column: tolocationkey2
	 */
	public java.lang.String getTolocationkey2 () {
		return tolocationkey2;
	}

	/**
	 * Set the value related to the column: tolocationkey2
	 * @param tolocationkey2 the tolocationkey2 value
	 */
	public void setTolocationkey2 (java.lang.String tolocationkey2) {
		this.tolocationkey2 = tolocationkey2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertariffhdr)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertariffhdr customertariffhdr = (com.bureaueye.beacon.model.standard.Customertariffhdr) obj;
			if (null == this.getCusttarfhdrId() || null == customertariffhdr.getCusttarfhdrId()) return false;
			else return (this.getCusttarfhdrId().equals(customertariffhdr.getCusttarfhdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCusttarfhdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCusttarfhdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}