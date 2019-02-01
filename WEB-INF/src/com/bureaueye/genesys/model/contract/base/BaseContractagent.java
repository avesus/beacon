package com.bureaueye.genesys.model.contract.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the contractagent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contractagent"
 */

public abstract class BaseContractagent  implements Serializable {

	public static String REF = "Contractagent";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_LUMPSUMAMT = "Lumpsumamt";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_AGENTADDRKEY = "Agentaddrkey";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_PERCENTAMT = "Percentamt";
	public static String PROP_CONTRACTAGENT_ID = "ContractagentId";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseContractagent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContractagent (java.lang.Integer contractagentId) {
		this.setContractagentId(contractagentId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer contractagentId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String scheme;
	private java.math.BigDecimal percentamt;
	private boolean xinactive;
	private java.math.BigDecimal lumpsumamt;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String systemloglock;
	private java.lang.String createtime;
	private java.lang.String systemlogtime;
	private java.lang.Integer contractId;
	private java.lang.String xlock;
	private java.lang.String agentaddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTAGENT_ID"
     */
	public java.lang.Integer getContractagentId () {
		return contractagentId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contractagentId the new ID
	 */
	public void setContractagentId (java.lang.Integer contractagentId) {
		this.contractagentId = contractagentId;
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
	 * Return the value associated with the column: scheme
	 */
	public java.lang.String getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme
	 * @param scheme the scheme value
	 */
	public void setScheme (java.lang.String scheme) {
		this.scheme = scheme;
	}



	/**
	 * Return the value associated with the column: percentamt
	 */
	public java.math.BigDecimal getPercentamt () {
		return percentamt;
	}

	/**
	 * Set the value related to the column: percentamt
	 * @param percentamt the percentamt value
	 */
	public void setPercentamt (java.math.BigDecimal percentamt) {
		this.percentamt = percentamt;
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
	 * Return the value associated with the column: lumpsumamt
	 */
	public java.math.BigDecimal getLumpsumamt () {
		return lumpsumamt;
	}

	/**
	 * Set the value related to the column: lumpsumamt
	 * @param lumpsumamt the lumpsumamt value
	 */
	public void setLumpsumamt (java.math.BigDecimal lumpsumamt) {
		this.lumpsumamt = lumpsumamt;
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



	/**
	 * Return the value associated with the column: agentaddrkey
	 */
	public java.lang.String getAgentaddrkey () {
		return agentaddrkey;
	}

	/**
	 * Set the value related to the column: agentaddrkey
	 * @param agentaddrkey the agentaddrkey value
	 */
	public void setAgentaddrkey (java.lang.String agentaddrkey) {
		this.agentaddrkey = agentaddrkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.contract.Contractagent)) return false;
		else {
			com.bureaueye.genesys.model.contract.Contractagent contractagent = (com.bureaueye.genesys.model.contract.Contractagent) obj;
			if (null == this.getContractagentId() || null == contractagent.getContractagentId()) return false;
			else return (this.getContractagentId().equals(contractagent.getContractagentId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getContractagentId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getContractagentId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}