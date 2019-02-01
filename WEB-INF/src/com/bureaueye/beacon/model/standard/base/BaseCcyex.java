package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ccyex table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ccyex"
 */

public abstract class BaseCcyex  implements Serializable {

	public static String REF = "Ccyex";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TOCCYKEY = "Toccykey";
	public static String PROP_CCYEX_ID = "CcyexId";
	public static String PROP_EXRATE = "Exrate";
	public static String PROP_EXDATE = "Exdate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_FROMCCYKEY = "Fromccykey";


	// constructors
	public BaseCcyex () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCcyex (java.lang.Integer ccyexId) {
		this.setCcyexId(ccyexId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer ccyexId;

	// fields
	private java.lang.String fromccykey;
	private java.lang.String toccykey;
	private java.util.Date exdate;
	private java.math.BigDecimal exrate;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CCYEX_ID"
     */
	public java.lang.Integer getCcyexId () {
		return ccyexId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ccyexId the new ID
	 */
	public void setCcyexId (java.lang.Integer ccyexId) {
		this.ccyexId = ccyexId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: fromccykey
	 */
	public java.lang.String getFromccykey () {
		return fromccykey;
	}

	/**
	 * Set the value related to the column: fromccykey
	 * @param fromccykey the fromccykey value
	 */
	public void setFromccykey (java.lang.String fromccykey) {
		this.fromccykey = fromccykey;
	}



	/**
	 * Return the value associated with the column: toccykey
	 */
	public java.lang.String getToccykey () {
		return toccykey;
	}

	/**
	 * Set the value related to the column: toccykey
	 * @param toccykey the toccykey value
	 */
	public void setToccykey (java.lang.String toccykey) {
		this.toccykey = toccykey;
	}



	/**
	 * Return the value associated with the column: exdate
	 */
	public java.util.Date getExdate () {
		return exdate;
	}

	/**
	 * Set the value related to the column: exdate
	 * @param exdate the exdate value
	 */
	public void setExdate (java.util.Date exdate) {
		this.exdate = exdate;
	}



	/**
	 * Return the value associated with the column: exrate
	 */
	public java.math.BigDecimal getExrate () {
		return exrate;
	}

	/**
	 * Set the value related to the column: exrate
	 * @param exrate the exrate value
	 */
	public void setExrate (java.math.BigDecimal exrate) {
		this.exrate = exrate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Ccyex)) return false;
		else {
			com.bureaueye.beacon.model.standard.Ccyex ccyex = (com.bureaueye.beacon.model.standard.Ccyex) obj;
			if (null == this.getCcyexId() || null == ccyex.getCcyexId()) return false;
			else return (this.getCcyexId().equals(ccyex.getCcyexId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCcyexId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCcyexId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}