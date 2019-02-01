package com.bureaueye.genesys.model.contract.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the contracteqploc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contracteqploc"
 */

public abstract class BaseContracteqploc  implements Serializable {

	public static String REF = "Contracteqploc";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LOCATIONKEY = "Locationkey";
	public static String PROP_LOCATIONRETURNS = "Locationreturns";
	public static String PROP_HANDCHG = "Handchg";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_MINRETURNS = "Minreturns";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_CONTRACTEQP_ID = "ContracteqpId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_EQPKEY = "Eqpkey";
	public static String PROP_MONTHRETURNS = "Monthreturns";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_CONTRACTEQPLOC_ID = "ContracteqplocId";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_PUDOFLAG = "Pudoflag";


	// constructors
	public BaseContracteqploc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContracteqploc (java.lang.Integer contracteqplocId) {
		this.setContracteqplocId(contracteqplocId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer contracteqplocId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String eqpkeyp5;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkey;
	private java.lang.String eqpkeyp7;
	private boolean xinactive;
	private java.math.BigDecimal handchg;
	private java.lang.String eqpkeyp3;
	private java.lang.String systemloglock;
	private java.lang.String eqpkeyp4;
	private java.lang.String systemlogtime;
	private java.lang.Integer minreturns;
	private java.lang.String eqpkeyp9;
	private java.lang.String eqpkeyp8;
	private java.lang.String eqpkeyp10;
	private java.lang.String eqpkeyp1;
	private java.lang.String createuserid;
	private java.lang.Integer monthreturns;
	private java.lang.String eqpkeyp6;
	private java.util.Date createdate;
	private java.lang.Integer contracteqpId;
	private java.lang.String createtime;
	private java.lang.Integer contractId;
	private java.lang.String pudoflag;
	private java.lang.Integer locationreturns;
	private java.lang.String xlock;
	private java.lang.String locationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTEQPLOC_ID"
     */
	public java.lang.Integer getContracteqplocId () {
		return contracteqplocId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contracteqplocId the new ID
	 */
	public void setContracteqplocId (java.lang.Integer contracteqplocId) {
		this.contracteqplocId = contracteqplocId;
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
	 * Return the value associated with the column: handchg
	 */
	public java.math.BigDecimal getHandchg () {
		return handchg;
	}

	/**
	 * Set the value related to the column: handchg
	 * @param handchg the handchg value
	 */
	public void setHandchg (java.math.BigDecimal handchg) {
		this.handchg = handchg;
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
	 * Return the value associated with the column: minreturns
	 */
	public java.lang.Integer getMinreturns () {
		return minreturns;
	}

	/**
	 * Set the value related to the column: minreturns
	 * @param minreturns the minreturns value
	 */
	public void setMinreturns (java.lang.Integer minreturns) {
		this.minreturns = minreturns;
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
	 * Return the value associated with the column: monthreturns
	 */
	public java.lang.Integer getMonthreturns () {
		return monthreturns;
	}

	/**
	 * Set the value related to the column: monthreturns
	 * @param monthreturns the monthreturns value
	 */
	public void setMonthreturns (java.lang.Integer monthreturns) {
		this.monthreturns = monthreturns;
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
	 * Return the value associated with the column: pudoflag
	 */
	public java.lang.String getPudoflag () {
		return pudoflag;
	}

	/**
	 * Set the value related to the column: pudoflag
	 * @param pudoflag the pudoflag value
	 */
	public void setPudoflag (java.lang.String pudoflag) {
		this.pudoflag = pudoflag;
	}



	/**
	 * Return the value associated with the column: locationreturns
	 */
	public java.lang.Integer getLocationreturns () {
		return locationreturns;
	}

	/**
	 * Set the value related to the column: locationreturns
	 * @param locationreturns the locationreturns value
	 */
	public void setLocationreturns (java.lang.Integer locationreturns) {
		this.locationreturns = locationreturns;
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
	 * Return the value associated with the column: locationkey
	 */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.contract.Contracteqploc)) return false;
		else {
			com.bureaueye.genesys.model.contract.Contracteqploc contracteqploc = (com.bureaueye.genesys.model.contract.Contracteqploc) obj;
			if (null == this.getContracteqplocId() || null == contracteqploc.getContracteqplocId()) return false;
			else return (this.getContracteqplocId().equals(contracteqploc.getContracteqplocId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getContracteqplocId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getContracteqplocId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}