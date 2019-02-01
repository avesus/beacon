package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tpa00002 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tpa00002"
 */

public abstract class BaseTpa00002  implements Serializable {

	public static String REF = "Tpa00002";
	public static String PROP_CHR_PHASE_NAME = "ChrPhaseName";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_INT_PHASE_KEY = "IntPhaseKey";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_SI_CST_CLSIFICATN_D_D_L = "SiCstClsificatnDDL";
	public static String PROP_CHR_PHASE_NUMBER = "ChrPhaseNumber";


	// constructors
	public BaseTpa00002 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTpa00002 (java.lang.Integer intPhaseKey) {
		this.setIntPhaseKey(intPhaseKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer intPhaseKey;

	// fields
	private java.lang.String chrPhaseName;
	private java.lang.String companyID;
	private java.lang.Short siCstClsificatnDDL;
	private java.lang.Integer updateCounter;
	private java.lang.String chrPhaseNumber;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="intPhaseKey"
     */
	public java.lang.Integer getIntPhaseKey () {
		return intPhaseKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param intPhaseKey the new ID
	 */
	public void setIntPhaseKey (java.lang.Integer intPhaseKey) {
		this.intPhaseKey = intPhaseKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: chrPhaseName
	 */
	public java.lang.String getChrPhaseName () {
		return chrPhaseName;
	}

	/**
	 * Set the value related to the column: chrPhaseName
	 * @param chrPhaseName the chrPhaseName value
	 */
	public void setChrPhaseName (java.lang.String chrPhaseName) {
		this.chrPhaseName = chrPhaseName;
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
	 * Return the value associated with the column: siCstClsificatnDDL
	 */
	public java.lang.Short getSiCstClsificatnDDL () {
		return siCstClsificatnDDL;
	}

	/**
	 * Set the value related to the column: siCstClsificatnDDL
	 * @param siCstClsificatnDDL the siCstClsificatnDDL value
	 */
	public void setSiCstClsificatnDDL (java.lang.Short siCstClsificatnDDL) {
		this.siCstClsificatnDDL = siCstClsificatnDDL;
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
	 * Return the value associated with the column: chrPhaseNumber
	 */
	public java.lang.String getChrPhaseNumber () {
		return chrPhaseNumber;
	}

	/**
	 * Set the value related to the column: chrPhaseNumber
	 * @param chrPhaseNumber the chrPhaseNumber value
	 */
	public void setChrPhaseNumber (java.lang.String chrPhaseNumber) {
		this.chrPhaseNumber = chrPhaseNumber;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tpa00002)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tpa00002 tpa00002 = (com.bureaueye.beacon.model.mas500.Tpa00002) obj;
			if (null == this.getIntPhaseKey() || null == tpa00002.getIntPhaseKey()) return false;
			else return (this.getIntPhaseKey().equals(tpa00002.getIntPhaseKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIntPhaseKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIntPhaseKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}