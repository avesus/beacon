package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the taxcode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="taxcode"
 */

public abstract class BaseTaxcode  implements Serializable {

	public static String REF = "Taxcode";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_TAXCODE_ID = "TaxcodeId";
	public static String PROP_TAXCODEKEY = "Taxcodekey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_DESCR = "Descr";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_RATE = "Rate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseTaxcode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTaxcode (java.lang.Integer taxcodeId) {
		this.setTaxcodeId(taxcodeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer taxcodeId;

	// fields
	private java.lang.String createtime;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogprogram;
	private java.math.BigDecimal rate;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.String taxcodekey;
	private java.lang.String descr;
	private java.lang.String systemlogaction;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="TAXCODE_ID"
     */
	public java.lang.Integer getTaxcodeId () {
		return taxcodeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param taxcodeId the new ID
	 */
	public void setTaxcodeId (java.lang.Integer taxcodeId) {
		this.taxcodeId = taxcodeId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: taxcodekey
	 */
	public java.lang.String getTaxcodekey () {
		return taxcodekey;
	}

	/**
	 * Set the value related to the column: taxcodekey
	 * @param taxcodekey the taxcodekey value
	 */
	public void setTaxcodekey (java.lang.String taxcodekey) {
		this.taxcodekey = taxcodekey;
	}



	/**
	 * Return the value associated with the column: descr
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: descr
	 * @param descr the descr value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Taxcode)) return false;
		else {
			com.bureaueye.beacon.model.standard.Taxcode taxcode = (com.bureaueye.beacon.model.standard.Taxcode) obj;
			if (null == this.getTaxcodeId() || null == taxcode.getTaxcodeId()) return false;
			else return (this.getTaxcodeId().equals(taxcode.getTaxcodeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTaxcodeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTaxcodeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}