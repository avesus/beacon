package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vendortariffdtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vendortariffdtl"
 */

public abstract class BaseVendortariffdtl  implements Serializable {

	public static String REF = "Vendortariffdtl";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_VENDTARFHDR_ID = "VendtarfhdrId";
	public static String PROP_FROMVALUE = "Fromvalue";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_UNITRATE = "Unitrate";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_LUMPSUM = "Lumpsum";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_VENDTARFDTL_ID = "VendtarfdtlId";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_TOVALUE = "Tovalue";


	// constructors
	public BaseVendortariffdtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVendortariffdtl (java.lang.Integer vendtarfdtlId) {
		this.setVendtarfdtlId(vendtarfdtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer vendtarfdtlId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.Integer tovalue;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String vendtarfhdrId;
	private java.math.BigDecimal lumpsum;
	private java.lang.String createuserid;
	private java.lang.String xinactive;
	private java.lang.Integer rowid;
	private java.lang.Integer fromvalue;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.math.BigDecimal unitrate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VENDTARFDTL_ID"
     */
	public java.lang.Integer getVendtarfdtlId () {
		return vendtarfdtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param vendtarfdtlId the new ID
	 */
	public void setVendtarfdtlId (java.lang.Integer vendtarfdtlId) {
		this.vendtarfdtlId = vendtarfdtlId;
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
	 * Return the value associated with the column: tovalue
	 */
	public java.lang.Integer getTovalue () {
		return tovalue;
	}

	/**
	 * Set the value related to the column: tovalue
	 * @param tovalue the tovalue value
	 */
	public void setTovalue (java.lang.Integer tovalue) {
		this.tovalue = tovalue;
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
	 * Return the value associated with the column: fromvalue
	 */
	public java.lang.Integer getFromvalue () {
		return fromvalue;
	}

	/**
	 * Set the value related to the column: fromvalue
	 * @param fromvalue the fromvalue value
	 */
	public void setFromvalue (java.lang.Integer fromvalue) {
		this.fromvalue = fromvalue;
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
	 * Return the value associated with the column: unitrate
	 */
	public java.math.BigDecimal getUnitrate () {
		return unitrate;
	}

	/**
	 * Set the value related to the column: unitrate
	 * @param unitrate the unitrate value
	 */
	public void setUnitrate (java.math.BigDecimal unitrate) {
		this.unitrate = unitrate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Vendortariffdtl)) return false;
		else {
			com.bureaueye.beacon.model.standard.Vendortariffdtl vendortariffdtl = (com.bureaueye.beacon.model.standard.Vendortariffdtl) obj;
			if (null == this.getVendtarfdtlId() || null == vendortariffdtl.getVendtarfdtlId()) return false;
			else return (this.getVendtarfdtlId().equals(vendortariffdtl.getVendtarfdtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getVendtarfdtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getVendtarfdtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}