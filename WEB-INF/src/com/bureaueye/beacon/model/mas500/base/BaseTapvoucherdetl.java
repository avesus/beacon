package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tapvoucherdetl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tapvoucherdetl"
 */

public abstract class BaseTapvoucherdetl  implements Serializable {

	public static String REF = "Tapvoucherdetl";
	public static String PROP_VOUCHER_LINE_KEY = "VoucherLineKey";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_RETNT_RATE = "RetntRate";
	public static String PROP_RETURN_TYPE = "ReturnType";
	public static String PROP_ITEM_KEY = "ItemKey";
	public static String PROP_SEQ_NO = "SeqNo";
	public static String PROP_P_O_LINE_KEY = "POLineKey";
	public static String PROP_RETNT_AMT = "RetntAmt";
	public static String PROP_S_TAX_CLASS_KEY = "STaxClassKey";
	public static String PROP_EXT_CMNT = "ExtCmnt";
	public static String PROP_VOUCHER_KEY = "VoucherKey";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_EXT_AMT = "ExtAmt";
	public static String PROP_MATCH_STATUS = "MatchStatus";
	public static String PROP_UNIT_COST = "UnitCost";
	public static String PROP_UNIT_MEAS_KEY = "UnitMeasKey";
	public static String PROP_TARGET_COMPANY_I_D = "TargetCompanyID";
	public static String PROP_CMNT_ONLY = "CmntOnly";


	// constructors
	public BaseTapvoucherdetl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTapvoucherdetl (java.lang.Integer voucherLineKey) {
		this.setVoucherLineKey(voucherLineKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer voucherLineKey;

	// fields
	private java.lang.String description;
	private java.math.BigDecimal retntRate;
	private java.lang.Short returnType;
	private java.lang.Integer itemKey;
	private java.lang.Integer seqNo;
	private java.lang.Integer pOLineKey;
	private java.math.BigDecimal retntAmt;
	private java.lang.Integer sTaxClassKey;
	private java.lang.String extCmnt;
	private java.lang.Integer voucherKey;
	private java.lang.Integer updateCounter;
	private java.math.BigDecimal extAmt;
	private java.lang.Short matchStatus;
	private java.lang.Integer unitMeasKey;
	private java.math.BigDecimal unitCost;
	private java.lang.Short cmntOnly;
	private java.lang.String targetCompanyID;



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
	 * Return the value associated with the column: Description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: Description
	 * @param description the Description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: RetntRate
	 */
	public java.math.BigDecimal getRetntRate () {
		return retntRate;
	}

	/**
	 * Set the value related to the column: RetntRate
	 * @param retntRate the RetntRate value
	 */
	public void setRetntRate (java.math.BigDecimal retntRate) {
		this.retntRate = retntRate;
	}



	/**
	 * Return the value associated with the column: ReturnType
	 */
	public java.lang.Short getReturnType () {
		return returnType;
	}

	/**
	 * Set the value related to the column: ReturnType
	 * @param returnType the ReturnType value
	 */
	public void setReturnType (java.lang.Short returnType) {
		this.returnType = returnType;
	}



	/**
	 * Return the value associated with the column: ItemKey
	 */
	public java.lang.Integer getItemKey () {
		return itemKey;
	}

	/**
	 * Set the value related to the column: ItemKey
	 * @param itemKey the ItemKey value
	 */
	public void setItemKey (java.lang.Integer itemKey) {
		this.itemKey = itemKey;
	}



	/**
	 * Return the value associated with the column: SeqNo
	 */
	public java.lang.Integer getSeqNo () {
		return seqNo;
	}

	/**
	 * Set the value related to the column: SeqNo
	 * @param seqNo the SeqNo value
	 */
	public void setSeqNo (java.lang.Integer seqNo) {
		this.seqNo = seqNo;
	}



	/**
	 * Return the value associated with the column: POLineKey
	 */
	public java.lang.Integer getPOLineKey () {
		return pOLineKey;
	}

	/**
	 * Set the value related to the column: POLineKey
	 * @param pOLineKey the POLineKey value
	 */
	public void setPOLineKey (java.lang.Integer pOLineKey) {
		this.pOLineKey = pOLineKey;
	}



	/**
	 * Return the value associated with the column: RetntAmt
	 */
	public java.math.BigDecimal getRetntAmt () {
		return retntAmt;
	}

	/**
	 * Set the value related to the column: RetntAmt
	 * @param retntAmt the RetntAmt value
	 */
	public void setRetntAmt (java.math.BigDecimal retntAmt) {
		this.retntAmt = retntAmt;
	}



	/**
	 * Return the value associated with the column: STaxClassKey
	 */
	public java.lang.Integer getSTaxClassKey () {
		return sTaxClassKey;
	}

	/**
	 * Set the value related to the column: STaxClassKey
	 * @param sTaxClassKey the STaxClassKey value
	 */
	public void setSTaxClassKey (java.lang.Integer sTaxClassKey) {
		this.sTaxClassKey = sTaxClassKey;
	}



	/**
	 * Return the value associated with the column: ExtCmnt
	 */
	public java.lang.String getExtCmnt () {
		return extCmnt;
	}

	/**
	 * Set the value related to the column: ExtCmnt
	 * @param extCmnt the ExtCmnt value
	 */
	public void setExtCmnt (java.lang.String extCmnt) {
		this.extCmnt = extCmnt;
	}



	/**
	 * Return the value associated with the column: VoucherKey
	 */
	public java.lang.Integer getVoucherKey () {
		return voucherKey;
	}

	/**
	 * Set the value related to the column: VoucherKey
	 * @param voucherKey the VoucherKey value
	 */
	public void setVoucherKey (java.lang.Integer voucherKey) {
		this.voucherKey = voucherKey;
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
	 * Return the value associated with the column: ExtAmt
	 */
	public java.math.BigDecimal getExtAmt () {
		return extAmt;
	}

	/**
	 * Set the value related to the column: ExtAmt
	 * @param extAmt the ExtAmt value
	 */
	public void setExtAmt (java.math.BigDecimal extAmt) {
		this.extAmt = extAmt;
	}



	/**
	 * Return the value associated with the column: MatchStatus
	 */
	public java.lang.Short getMatchStatus () {
		return matchStatus;
	}

	/**
	 * Set the value related to the column: MatchStatus
	 * @param matchStatus the MatchStatus value
	 */
	public void setMatchStatus (java.lang.Short matchStatus) {
		this.matchStatus = matchStatus;
	}



	/**
	 * Return the value associated with the column: UnitMeasKey
	 */
	public java.lang.Integer getUnitMeasKey () {
		return unitMeasKey;
	}

	/**
	 * Set the value related to the column: UnitMeasKey
	 * @param unitMeasKey the UnitMeasKey value
	 */
	public void setUnitMeasKey (java.lang.Integer unitMeasKey) {
		this.unitMeasKey = unitMeasKey;
	}



	/**
	 * Return the value associated with the column: UnitCost
	 */
	public java.math.BigDecimal getUnitCost () {
		return unitCost;
	}

	/**
	 * Set the value related to the column: UnitCost
	 * @param unitCost the UnitCost value
	 */
	public void setUnitCost (java.math.BigDecimal unitCost) {
		this.unitCost = unitCost;
	}



	/**
	 * Return the value associated with the column: CmntOnly
	 */
	public java.lang.Short getCmntOnly () {
		return cmntOnly;
	}

	/**
	 * Set the value related to the column: CmntOnly
	 * @param cmntOnly the CmntOnly value
	 */
	public void setCmntOnly (java.lang.Short cmntOnly) {
		this.cmntOnly = cmntOnly;
	}



	/**
	 * Return the value associated with the column: TargetCompanyID
	 */
	public java.lang.String getTargetCompanyID () {
		return targetCompanyID;
	}

	/**
	 * Set the value related to the column: TargetCompanyID
	 * @param targetCompanyID the TargetCompanyID value
	 */
	public void setTargetCompanyID (java.lang.String targetCompanyID) {
		this.targetCompanyID = targetCompanyID;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tapvoucherdetl)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tapvoucherdetl tapvoucherdetl = (com.bureaueye.beacon.model.mas500.Tapvoucherdetl) obj;
			if (null == this.getVoucherLineKey() || null == tapvoucherdetl.getVoucherLineKey()) return false;
			else return (this.getVoucherLineKey().equals(tapvoucherdetl.getVoucherLineKey()));
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