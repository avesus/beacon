package com.bureaueye.genesys.model.contract.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the contracteqprat table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contracteqprat"
 */

public abstract class BaseContracteqprat  implements Serializable {

	public static String REF = "Contracteqprat";
	public static String PROP_RATE1 = "Rate1";
	public static String PROP_RATE2 = "Rate2";
	public static String PROP_RATE3 = "Rate3";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_RATE4 = "Rate4";
	public static String PROP_RATE5 = "Rate5";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_FROMDAY1 = "Fromday1";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_TODAY2 = "Today2";
	public static String PROP_TODAY1 = "Today1";
	public static String PROP_TODAY4 = "Today4";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_TODAY3 = "Today3";
	public static String PROP_TODAY5 = "Today5";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_CONTRACTEQP_ID = "ContracteqpId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_FROMDAY3 = "Fromday3";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_FROMDAY2 = "Fromday2";
	public static String PROP_FROMDAY5 = "Fromday5";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_FROMDAY4 = "Fromday4";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_EQPKEY = "Eqpkey";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CONTRACTEQPRAT_ID = "ContracteqpratId";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseContracteqprat () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContracteqprat (java.lang.Integer contracteqpratId) {
		this.setContracteqpratId(contracteqpratId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer contracteqpratId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String eqpkeyp5;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.math.BigDecimal rate1;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkey;
	private java.lang.String eqpkeyp7;
	private boolean xinactive;
	private java.lang.Integer fromday5;
	private java.lang.Integer today4;
	private java.lang.String eqpkeyp3;
	private java.math.BigDecimal rate3;
	private java.lang.Integer fromday2;
	private java.lang.Integer today3;
	private java.lang.String systemloglock;
	private java.lang.String eqpkeyp4;
	private java.lang.String systemlogtime;
	private java.lang.Integer today2;
	private java.lang.Integer fromday1;
	private java.math.BigDecimal rate4;
	private java.lang.String eqpkeyp9;
	private java.math.BigDecimal rate5;
	private java.lang.String eqpkeyp8;
	private java.lang.Integer today5;
	private java.lang.String eqpkeyp10;
	private java.lang.Integer fromday4;
	private java.lang.String eqpkeyp1;
	private java.math.BigDecimal rate2;
	private java.lang.String createuserid;
	private java.lang.Integer fromday3;
	private java.util.Date createdate;
	private java.lang.String eqpkeyp6;
	private java.lang.Integer today1;
	private java.lang.String createtime;
	private java.lang.Integer contracteqpId;
	private java.lang.Integer contractId;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTEQPRAT_ID"
     */
	public java.lang.Integer getContracteqpratId () {
		return contracteqpratId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contracteqpratId the new ID
	 */
	public void setContracteqpratId (java.lang.Integer contracteqpratId) {
		this.contracteqpratId = contracteqpratId;
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
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String eqpkeyp5) {
		this.eqpkeyp5 = eqpkeyp5;
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
	 * Return the value associated with the column: rate1
	 */
	public java.math.BigDecimal getRate1 () {
		return rate1;
	}

	/**
	 * Set the value related to the column: rate1
	 * @param rate1 the rate1 value
	 */
	public void setRate1 (java.math.BigDecimal rate1) {
		this.rate1 = rate1;
	}



	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
	}



	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String eqpkey) {
		this.eqpkey = eqpkey;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String eqpkeyp7) {
		this.eqpkeyp7 = eqpkeyp7;
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
	 * Return the value associated with the column: fromday5
	 */
	public java.lang.Integer getFromday5 () {
		return fromday5;
	}

	/**
	 * Set the value related to the column: fromday5
	 * @param fromday5 the fromday5 value
	 */
	public void setFromday5 (java.lang.Integer fromday5) {
		this.fromday5 = fromday5;
	}



	/**
	 * Return the value associated with the column: today4
	 */
	public java.lang.Integer getToday4 () {
		return today4;
	}

	/**
	 * Set the value related to the column: today4
	 * @param today4 the today4 value
	 */
	public void setToday4 (java.lang.Integer today4) {
		this.today4 = today4;
	}



	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String eqpkeyp3) {
		this.eqpkeyp3 = eqpkeyp3;
	}



	/**
	 * Return the value associated with the column: rate3
	 */
	public java.math.BigDecimal getRate3 () {
		return rate3;
	}

	/**
	 * Set the value related to the column: rate3
	 * @param rate3 the rate3 value
	 */
	public void setRate3 (java.math.BigDecimal rate3) {
		this.rate3 = rate3;
	}



	/**
	 * Return the value associated with the column: fromday2
	 */
	public java.lang.Integer getFromday2 () {
		return fromday2;
	}

	/**
	 * Set the value related to the column: fromday2
	 * @param fromday2 the fromday2 value
	 */
	public void setFromday2 (java.lang.Integer fromday2) {
		this.fromday2 = fromday2;
	}



	/**
	 * Return the value associated with the column: today3
	 */
	public java.lang.Integer getToday3 () {
		return today3;
	}

	/**
	 * Set the value related to the column: today3
	 * @param today3 the today3 value
	 */
	public void setToday3 (java.lang.Integer today3) {
		this.today3 = today3;
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
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String eqpkeyp4) {
		this.eqpkeyp4 = eqpkeyp4;
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
	 * Return the value associated with the column: today2
	 */
	public java.lang.Integer getToday2 () {
		return today2;
	}

	/**
	 * Set the value related to the column: today2
	 * @param today2 the today2 value
	 */
	public void setToday2 (java.lang.Integer today2) {
		this.today2 = today2;
	}



	/**
	 * Return the value associated with the column: fromday1
	 */
	public java.lang.Integer getFromday1 () {
		return fromday1;
	}

	/**
	 * Set the value related to the column: fromday1
	 * @param fromday1 the fromday1 value
	 */
	public void setFromday1 (java.lang.Integer fromday1) {
		this.fromday1 = fromday1;
	}



	/**
	 * Return the value associated with the column: rate4
	 */
	public java.math.BigDecimal getRate4 () {
		return rate4;
	}

	/**
	 * Set the value related to the column: rate4
	 * @param rate4 the rate4 value
	 */
	public void setRate4 (java.math.BigDecimal rate4) {
		this.rate4 = rate4;
	}



	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String eqpkeyp9) {
		this.eqpkeyp9 = eqpkeyp9;
	}



	/**
	 * Return the value associated with the column: rate5
	 */
	public java.math.BigDecimal getRate5 () {
		return rate5;
	}

	/**
	 * Set the value related to the column: rate5
	 * @param rate5 the rate5 value
	 */
	public void setRate5 (java.math.BigDecimal rate5) {
		this.rate5 = rate5;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String eqpkeyp8) {
		this.eqpkeyp8 = eqpkeyp8;
	}



	/**
	 * Return the value associated with the column: today5
	 */
	public java.lang.Integer getToday5 () {
		return today5;
	}

	/**
	 * Set the value related to the column: today5
	 * @param today5 the today5 value
	 */
	public void setToday5 (java.lang.Integer today5) {
		this.today5 = today5;
	}



	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String eqpkeyp10) {
		this.eqpkeyp10 = eqpkeyp10;
	}



	/**
	 * Return the value associated with the column: fromday4
	 */
	public java.lang.Integer getFromday4 () {
		return fromday4;
	}

	/**
	 * Set the value related to the column: fromday4
	 * @param fromday4 the fromday4 value
	 */
	public void setFromday4 (java.lang.Integer fromday4) {
		this.fromday4 = fromday4;
	}



	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
	}



	/**
	 * Return the value associated with the column: rate2
	 */
	public java.math.BigDecimal getRate2 () {
		return rate2;
	}

	/**
	 * Set the value related to the column: rate2
	 * @param rate2 the rate2 value
	 */
	public void setRate2 (java.math.BigDecimal rate2) {
		this.rate2 = rate2;
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
	 * Return the value associated with the column: fromday3
	 */
	public java.lang.Integer getFromday3 () {
		return fromday3;
	}

	/**
	 * Set the value related to the column: fromday3
	 * @param fromday3 the fromday3 value
	 */
	public void setFromday3 (java.lang.Integer fromday3) {
		this.fromday3 = fromday3;
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
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String eqpkeyp6) {
		this.eqpkeyp6 = eqpkeyp6;
	}



	/**
	 * Return the value associated with the column: today1
	 */
	public java.lang.Integer getToday1 () {
		return today1;
	}

	/**
	 * Set the value related to the column: today1
	 * @param today1 the today1 value
	 */
	public void setToday1 (java.lang.Integer today1) {
		this.today1 = today1;
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
	 * Return the value associated with the column: CONTRACTEQP_ID
	 */
	public java.lang.Integer getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQP_ID
	 * @param contracteqpId the CONTRACTEQP_ID value
	 */
	public void setContracteqpId (java.lang.Integer contracteqpId) {
		this.contracteqpId = contracteqpId;
	}



	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.contract.Contracteqprat)) return false;
		else {
			com.bureaueye.genesys.model.contract.Contracteqprat contracteqprat = (com.bureaueye.genesys.model.contract.Contracteqprat) obj;
			if (null == this.getContracteqpratId() || null == contracteqprat.getContracteqpratId()) return false;
			else return (this.getContracteqpratId().equals(contracteqprat.getContracteqpratId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getContracteqpratId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getContracteqpratId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}