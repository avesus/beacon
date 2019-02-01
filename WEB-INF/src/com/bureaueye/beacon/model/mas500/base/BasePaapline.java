package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the paapline table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="paapline"
 */

public abstract class BasePaapline  implements Serializable {

	public static String REF = "Paapline";
	public static String PROP_VOUCHER_LINE_KEY = "VoucherLineKey";
	public static String PROP_TI_IS_VARIATION = "TiIsVariation";
	public static String PROP_INT_JOB_LINE_KEY = "IntJobLineKey";
	public static String PROP_INT_JOB_KEY = "IntJobKey";
	public static String PROP_INT_PHASE_KEY = "IntPhaseKey";
	public static String PROP_TIME_AND_MATERIAL_BILL_METH = "TimeAndMaterialBillMeth";
	public static String PROP_SI_CST_CLSIFICATN_D_D_L = "SiCstClsificatnDDL";
	public static String PROP_INT_TASK_KEY = "IntTaskKey";
	public static String PROP_INT_E_C_LINE_KEY = "IntECLineKey";
	public static String PROP_TI_CREATE_BY = "TiCreateBy";


	// constructors
	public BasePaapline () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaapline (java.lang.Integer voucherLineKey) {
		this.setVoucherLineKey(voucherLineKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer voucherLineKey;

	// fields
	private java.lang.Integer intECLineKey;
	private java.lang.Integer intTaskKey;
	private java.lang.Short tiCreateBy;
	private java.lang.Short siCstClsificatnDDL;
	private java.lang.Integer intJobLineKey;
	private java.lang.Short timeAndMaterialBillMeth;
	private java.lang.Integer intPhaseKey;
	private java.lang.Short tiIsVariation;
	private java.lang.Integer intJobKey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VoucherLineKey"
     */
	public java.lang.Integer getVoucherLineKey () {
		return voucherLineKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param voucherLineKey the new ID
	 */
	public void setVoucherLineKey (java.lang.Integer voucherLineKey) {
		this.voucherLineKey = voucherLineKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: intECLineKey
	 */
	public java.lang.Integer getIntECLineKey () {
		return intECLineKey;
	}

	/**
	 * Set the value related to the column: intECLineKey
	 * @param intECLineKey the intECLineKey value
	 */
	public void setIntECLineKey (java.lang.Integer intECLineKey) {
		this.intECLineKey = intECLineKey;
	}



	/**
	 * Return the value associated with the column: intTaskKey
	 */
	public java.lang.Integer getIntTaskKey () {
		return intTaskKey;
	}

	/**
	 * Set the value related to the column: intTaskKey
	 * @param intTaskKey the intTaskKey value
	 */
	public void setIntTaskKey (java.lang.Integer intTaskKey) {
		this.intTaskKey = intTaskKey;
	}



	/**
	 * Return the value associated with the column: tiCreateBy
	 */
	public java.lang.Short getTiCreateBy () {
		return tiCreateBy;
	}

	/**
	 * Set the value related to the column: tiCreateBy
	 * @param tiCreateBy the tiCreateBy value
	 */
	public void setTiCreateBy (java.lang.Short tiCreateBy) {
		this.tiCreateBy = tiCreateBy;
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
	 * Return the value associated with the column: intJobLineKey
	 */
	public java.lang.Integer getIntJobLineKey () {
		return intJobLineKey;
	}

	/**
	 * Set the value related to the column: intJobLineKey
	 * @param intJobLineKey the intJobLineKey value
	 */
	public void setIntJobLineKey (java.lang.Integer intJobLineKey) {
		this.intJobLineKey = intJobLineKey;
	}



	/**
	 * Return the value associated with the column: TimeAndMaterialBillMeth
	 */
	public java.lang.Short getTimeAndMaterialBillMeth () {
		return timeAndMaterialBillMeth;
	}

	/**
	 * Set the value related to the column: TimeAndMaterialBillMeth
	 * @param timeAndMaterialBillMeth the TimeAndMaterialBillMeth value
	 */
	public void setTimeAndMaterialBillMeth (java.lang.Short timeAndMaterialBillMeth) {
		this.timeAndMaterialBillMeth = timeAndMaterialBillMeth;
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
	 * Return the value associated with the column: tiIsVariation
	 */
	public java.lang.Short getTiIsVariation () {
		return tiIsVariation;
	}

	/**
	 * Set the value related to the column: tiIsVariation
	 * @param tiIsVariation the tiIsVariation value
	 */
	public void setTiIsVariation (java.lang.Short tiIsVariation) {
		this.tiIsVariation = tiIsVariation;
	}



	/**
	 * Return the value associated with the column: intJobKey
	 */
	public java.lang.Integer getIntJobKey () {
		return intJobKey;
	}

	/**
	 * Set the value related to the column: intJobKey
	 * @param intJobKey the intJobKey value
	 */
	public void setIntJobKey (java.lang.Integer intJobKey) {
		this.intJobKey = intJobKey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Paapline)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Paapline paapline = (com.bureaueye.beacon.model.mas500.Paapline) obj;
			if (null == this.getVoucherLineKey() || null == paapline.getVoucherLineKey()) return false;
			else return (this.getVoucherLineKey().equals(paapline.getVoucherLineKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getVoucherLineKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getVoucherLineKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}