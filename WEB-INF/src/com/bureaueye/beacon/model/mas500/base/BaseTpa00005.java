package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tpa00005 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tpa00005"
 */

public abstract class BaseTpa00005  implements Serializable {

	public static String REF = "Tpa00005";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_CHR_TASK_NUMBER = "ChrTaskNumber";
	public static String PROP_INT_PHASE_KEY = "IntPhaseKey";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_COSTS_ACCT_KEY = "CostsAcctKey";
	public static String PROP_SI_TASK_TYPE = "SiTaskType";
	public static String PROP_CHR_TASK_NAME = "ChrTaskName";
	public static String PROP_INT_TASK_KEY = "IntTaskKey";
	public static String PROP_SALES_ACCT_KEY = "SalesAcctKey";


	// constructors
	public BaseTpa00005 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTpa00005 (java.lang.Integer intTaskKey) {
		this.setIntTaskKey(intTaskKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer intTaskKey;

	// fields
	private java.lang.String chrTaskNumber;
	private java.lang.String companyID;
	private java.lang.Integer updateCounter;
	private java.lang.Integer costsAcctKey;
	private java.lang.Integer intPhaseKey;
	private java.lang.String chrTaskName;
	private java.lang.Integer salesAcctKey;
	private java.lang.Short siTaskType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="intTaskKey"
     */
	public java.lang.Integer getIntTaskKey () {
		return intTaskKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param intTaskKey the new ID
	 */
	public void setIntTaskKey (java.lang.Integer intTaskKey) {
		this.intTaskKey = intTaskKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: chrTaskNumber
	 */
	public java.lang.String getChrTaskNumber () {
		return chrTaskNumber;
	}

	/**
	 * Set the value related to the column: chrTaskNumber
	 * @param chrTaskNumber the chrTaskNumber value
	 */
	public void setChrTaskNumber (java.lang.String chrTaskNumber) {
		this.chrTaskNumber = chrTaskNumber;
	}



	/**
	 * Return the value associated with the column: CompanyID
	 */
	public java.lang.String getCompanyID () {
		return companyID;
	}

	/**
	 * Set the value related to the column: CompanyID
	 * @param companyID the CompanyID value
	 */
	public void setCompanyID (java.lang.String companyID) {
		this.companyID = companyID;
	}



	/**
	 * Return the value associated with the column: UpdateCounter
	 */
	public java.lang.Integer getUpdateCounter () {
		return updateCounter;
	}

	/**
	 * Set the value related to the column: UpdateCounter
	 * @param updateCounter the UpdateCounter value
	 */
	public void setUpdateCounter (java.lang.Integer updateCounter) {
		this.updateCounter = updateCounter;
	}



	/**
	 * Return the value associated with the column: CostsAcctKey
	 */
	public java.lang.Integer getCostsAcctKey () {
		return costsAcctKey;
	}

	/**
	 * Set the value related to the column: CostsAcctKey
	 * @param costsAcctKey the CostsAcctKey value
	 */
	public void setCostsAcctKey (java.lang.Integer costsAcctKey) {
		this.costsAcctKey = costsAcctKey;
	}



	/**
	 * Return the value associated with the column: intPhaseKey
	 */
	public java.lang.Integer getIntPhaseKey () {
		return intPhaseKey;
	}

	/**
	 * Set the value related to the column: intPhaseKey
	 * @param intPhaseKey the intPhaseKey value
	 */
	public void setIntPhaseKey (java.lang.Integer intPhaseKey) {
		this.intPhaseKey = intPhaseKey;
	}



	/**
	 * Return the value associated with the column: chrTaskName
	 */
	public java.lang.String getChrTaskName () {
		return chrTaskName;
	}

	/**
	 * Set the value related to the column: chrTaskName
	 * @param chrTaskName the chrTaskName value
	 */
	public void setChrTaskName (java.lang.String chrTaskName) {
		this.chrTaskName = chrTaskName;
	}



	/**
	 * Return the value associated with the column: SalesAcctKey
	 */
	public java.lang.Integer getSalesAcctKey () {
		return salesAcctKey;
	}

	/**
	 * Set the value related to the column: SalesAcctKey
	 * @param salesAcctKey the SalesAcctKey value
	 */
	public void setSalesAcctKey (java.lang.Integer salesAcctKey) {
		this.salesAcctKey = salesAcctKey;
	}



	/**
	 * Return the value associated with the column: siTaskType
	 */
	public java.lang.Short getSiTaskType () {
		return siTaskType;
	}

	/**
	 * Set the value related to the column: siTaskType
	 * @param siTaskType the siTaskType value
	 */
	public void setSiTaskType (java.lang.Short siTaskType) {
		this.siTaskType = siTaskType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tpa00005)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tpa00005 tpa00005 = (com.bureaueye.beacon.model.mas500.Tpa00005) obj;
			if (null == this.getIntTaskKey() || null == tpa00005.getIntTaskKey()) return false;
			else return (this.getIntTaskKey().equals(tpa00005.getIntTaskKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIntTaskKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIntTaskKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}