package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tarinvoicedetl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tarinvoicedetl"
 */

public abstract class BaseTarinvoicedetl  implements Serializable {

	public static String REF = "Tarinvoicedetl";
	public static String PROP_INVC_KEY = "InvcKey";
	public static String PROP_ITEM_ALIAS_KEY = "ItemAliasKey";
	public static String PROP_COMM_CLASS_KEY = "CommClassKey";
	public static String PROP_SHIP_LINE_KEY = "ShipLineKey";
	public static String PROP_COMM_BASE = "CommBase";
	public static String PROP_COMM_PLAN_KEY = "CommPlanKey";
	public static String PROP_EXT_CMNT = "ExtCmnt";
	public static String PROP_PROJ_I_D = "ProjID";
	public static String PROP_TRADE_DISC_AMT = "TradeDiscAmt";
	public static String PROP_RTRN_TYPE = "RtrnType";
	public static String PROP_EXT_AMT = "ExtAmt";
	public static String PROP_INVOICE_LINE_KEY = "InvoiceLineKey";
	public static String PROP_KIT_INVOICE_LINE_KEY = "KitInvoiceLineKey";
	public static String PROP_UNIT_PRICE_OVRD = "UnitPriceOvrd";
	public static String PROP_UNIT_MEAS_KEY = "UnitMeasKey";
	public static String PROP_CMNT_ONLY = "CmntOnly";
	public static String PROP_CALC_COMM_AMT = "CalcCommAmt";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ITEM_KEY = "ItemKey";
	public static String PROP_UNIT_PRICE = "UnitPrice";
	public static String PROP_S_O_LINE_KEY = "SOLineKey";
	public static String PROP_ACT_COMM_AMT = "ActCommAmt";
	public static String PROP_SEQ_NO = "SeqNo";
	public static String PROP_PROJ_CLIENT_I_D = "ProjClientID";
	public static String PROP_S_TAX_CLASS_KEY = "STaxClassKey";
	public static String PROP_UNIT_COST = "UnitCost";


	// constructors
	public BaseTarinvoicedetl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTarinvoicedetl (java.lang.Integer invoiceLineKey) {
		this.setInvoiceLineKey(invoiceLineKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer invoiceLineKey;

	// fields
	private java.lang.Integer invcKey;
	private java.lang.Integer itemAliasKey;
	private java.lang.Integer commClassKey;
	private java.lang.Integer shipLineKey;
	private java.lang.Short commBase;
	private java.lang.Integer commPlanKey;
	private java.lang.String extCmnt;
	private java.lang.String projID;
	private java.math.BigDecimal tradeDiscAmt;
	private java.math.BigDecimal extAmt;
	private java.lang.Short rtrnType;
	private java.lang.Short unitPriceOvrd;
	private java.lang.Integer kitInvoiceLineKey;
	private java.lang.Integer unitMeasKey;
	private java.lang.Short cmntOnly;
	private java.math.BigDecimal calcCommAmt;
	private java.lang.String description;
	private java.lang.Integer itemKey;
	private java.math.BigDecimal unitPrice;
	private java.lang.Integer sOLineKey;
	private java.math.BigDecimal actCommAmt;
	private java.lang.Integer seqNo;
	private java.lang.String projClientID;
	private java.lang.Integer sTaxClassKey;
	private java.math.BigDecimal unitCost;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="InvoiceLineKey"
     */
	public java.lang.Integer getInvoiceLineKey () {
		return invoiceLineKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param invoiceLineKey the new ID
	 */
	public void setInvoiceLineKey (java.lang.Integer invoiceLineKey) {
		this.invoiceLineKey = invoiceLineKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: InvcKey
	 */
	public java.lang.Integer getInvcKey () {
		return invcKey;
	}

	/**
	 * Set the value related to the column: InvcKey
	 * @param invcKey the InvcKey value
	 */
	public void setInvcKey (java.lang.Integer invcKey) {
		this.invcKey = invcKey;
	}



	/**
	 * Return the value associated with the column: ItemAliasKey
	 */
	public java.lang.Integer getItemAliasKey () {
		return itemAliasKey;
	}

	/**
	 * Set the value related to the column: ItemAliasKey
	 * @param itemAliasKey the ItemAliasKey value
	 */
	public void setItemAliasKey (java.lang.Integer itemAliasKey) {
		this.itemAliasKey = itemAliasKey;
	}



	/**
	 * Return the value associated with the column: CommClassKey
	 */
	public java.lang.Integer getCommClassKey () {
		return commClassKey;
	}

	/**
	 * Set the value related to the column: CommClassKey
	 * @param commClassKey the CommClassKey value
	 */
	public void setCommClassKey (java.lang.Integer commClassKey) {
		this.commClassKey = commClassKey;
	}



	/**
	 * Return the value associated with the column: ShipLineKey
	 */
	public java.lang.Integer getShipLineKey () {
		return shipLineKey;
	}

	/**
	 * Set the value related to the column: ShipLineKey
	 * @param shipLineKey the ShipLineKey value
	 */
	public void setShipLineKey (java.lang.Integer shipLineKey) {
		this.shipLineKey = shipLineKey;
	}



	/**
	 * Return the value associated with the column: CommBase
	 */
	public java.lang.Short getCommBase () {
		return commBase;
	}

	/**
	 * Set the value related to the column: CommBase
	 * @param commBase the CommBase value
	 */
	public void setCommBase (java.lang.Short commBase) {
		this.commBase = commBase;
	}



	/**
	 * Return the value associated with the column: CommPlanKey
	 */
	public java.lang.Integer getCommPlanKey () {
		return commPlanKey;
	}

	/**
	 * Set the value related to the column: CommPlanKey
	 * @param commPlanKey the CommPlanKey value
	 */
	public void setCommPlanKey (java.lang.Integer commPlanKey) {
		this.commPlanKey = commPlanKey;
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
	 * Return the value associated with the column: ProjID
	 */
	public java.lang.String getProjID () {
		return projID;
	}

	/**
	 * Set the value related to the column: ProjID
	 * @param projID the ProjID value
	 */
	public void setProjID (java.lang.String projID) {
		this.projID = projID;
	}



	/**
	 * Return the value associated with the column: TradeDiscAmt
	 */
	public java.math.BigDecimal getTradeDiscAmt () {
		return tradeDiscAmt;
	}

	/**
	 * Set the value related to the column: TradeDiscAmt
	 * @param tradeDiscAmt the TradeDiscAmt value
	 */
	public void setTradeDiscAmt (java.math.BigDecimal tradeDiscAmt) {
		this.tradeDiscAmt = tradeDiscAmt;
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
	 * Return the value associated with the column: RtrnType
	 */
	public java.lang.Short getRtrnType () {
		return rtrnType;
	}

	/**
	 * Set the value related to the column: RtrnType
	 * @param rtrnType the RtrnType value
	 */
	public void setRtrnType (java.lang.Short rtrnType) {
		this.rtrnType = rtrnType;
	}



	/**
	 * Return the value associated with the column: UnitPriceOvrd
	 */
	public java.lang.Short getUnitPriceOvrd () {
		return unitPriceOvrd;
	}

	/**
	 * Set the value related to the column: UnitPriceOvrd
	 * @param unitPriceOvrd the UnitPriceOvrd value
	 */
	public void setUnitPriceOvrd (java.lang.Short unitPriceOvrd) {
		this.unitPriceOvrd = unitPriceOvrd;
	}



	/**
	 * Return the value associated with the column: KitInvoiceLineKey
	 */
	public java.lang.Integer getKitInvoiceLineKey () {
		return kitInvoiceLineKey;
	}

	/**
	 * Set the value related to the column: KitInvoiceLineKey
	 * @param kitInvoiceLineKey the KitInvoiceLineKey value
	 */
	public void setKitInvoiceLineKey (java.lang.Integer kitInvoiceLineKey) {
		this.kitInvoiceLineKey = kitInvoiceLineKey;
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
	 * Return the value associated with the column: CalcCommAmt
	 */
	public java.math.BigDecimal getCalcCommAmt () {
		return calcCommAmt;
	}

	/**
	 * Set the value related to the column: CalcCommAmt
	 * @param calcCommAmt the CalcCommAmt value
	 */
	public void setCalcCommAmt (java.math.BigDecimal calcCommAmt) {
		this.calcCommAmt = calcCommAmt;
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
	 * Return the value associated with the column: UnitPrice
	 */
	public java.math.BigDecimal getUnitPrice () {
		return unitPrice;
	}

	/**
	 * Set the value related to the column: UnitPrice
	 * @param unitPrice the UnitPrice value
	 */
	public void setUnitPrice (java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}



	/**
	 * Return the value associated with the column: SOLineKey
	 */
	public java.lang.Integer getSOLineKey () {
		return sOLineKey;
	}

	/**
	 * Set the value related to the column: SOLineKey
	 * @param sOLineKey the SOLineKey value
	 */
	public void setSOLineKey (java.lang.Integer sOLineKey) {
		this.sOLineKey = sOLineKey;
	}



	/**
	 * Return the value associated with the column: ActCommAmt
	 */
	public java.math.BigDecimal getActCommAmt () {
		return actCommAmt;
	}

	/**
	 * Set the value related to the column: ActCommAmt
	 * @param actCommAmt the ActCommAmt value
	 */
	public void setActCommAmt (java.math.BigDecimal actCommAmt) {
		this.actCommAmt = actCommAmt;
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
	 * Return the value associated with the column: ProjClientID
	 */
	public java.lang.String getProjClientID () {
		return projClientID;
	}

	/**
	 * Set the value related to the column: ProjClientID
	 * @param projClientID the ProjClientID value
	 */
	public void setProjClientID (java.lang.String projClientID) {
		this.projClientID = projClientID;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tarinvoicedetl)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tarinvoicedetl tarinvoicedetl = (com.bureaueye.beacon.model.mas500.Tarinvoicedetl) obj;
			if (null == this.getInvoiceLineKey() || null == tarinvoicedetl.getInvoiceLineKey()) return false;
			else return (this.getInvoiceLineKey().equals(tarinvoicedetl.getInvoiceLineKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getInvoiceLineKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getInvoiceLineKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}