package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tarinvoice table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tarinvoice"
 */

public abstract class BaseTarinvoice  implements Serializable {

	public static String REF = "Tarinvoice";
	public static String PROP_INVC_KEY = "InvcKey";
	public static String PROP_TRAN_DATE = "TranDate";
	public static String PROP_CLOSING_POST_DATE = "ClosingPostDate";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_INVC_FORM_KEY = "InvcFormKey";
	public static String PROP_RETNT_AMT = "RetntAmt";
	public static String PROP_SOURCE_MODULE = "SourceModule";
	public static String PROP_COMM_PLAN_KEY = "CommPlanKey";
	public static String PROP_BALANCE_H_C = "BalanceHC";
	public static String PROP_BATCH_KEY = "BatchKey";
	public static String PROP_F_O_B_KEY = "FOBKey";
	public static String PROP_S_TAX_AMT = "STaxAmt";
	public static String PROP_TRAN_CMNT = "TranCmnt";
	public static String PROP_IN_DISPUTE = "InDispute";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_DISC_DATE = "DiscDate";
	public static String PROP_REASON_CODE_KEY = "ReasonCodeKey";
	public static String PROP_BILL_TO_CUST_ADDR_KEY = "BillToCustAddrKey";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_RECUR_INVOICE_KEY = "RecurInvoiceKey";
	public static String PROP_CURR_EXCH_RATE = "CurrExchRate";
	public static String PROP_CUST_P_O_NO = "CustPONo";
	public static String PROP_RETNT_PCT = "RetntPct";
	public static String PROP_DISC_AMT = "DiscAmt";
	public static String PROP_TRAN_I_D = "TranID";
	public static String PROP_CONFIRM_TO_CNTCT_KEY = "ConfirmToCntctKey";
	public static String PROP_CURR_EXCH_SCHD_KEY = "CurrExchSchdKey";
	public static String PROP_UPDATE_USER_I_D = "UpdateUserID";
	public static String PROP_BILL_TO_ADDR_KEY = "BillToAddrKey";
	public static String PROP_SALES_AMT = "SalesAmt";
	public static String PROP_TRAN_TYPE = "TranType";
	public static String PROP_CUST_CLASS_KEY = "CustClassKey";
	public static String PROP_TRAN_NO = "TranNo";
	public static String PROP_PRIMARY_SPER_KEY = "PrimarySperKey";
	public static String PROP_CLOSING_TRAN_DATE = "ClosingTranDate";
	public static String PROP_CREATE_TYPE = "CreateType";
	public static String PROP_TRAN_AMT = "TranAmt";
	public static String PROP_POST_DATE = "PostDate";
	public static String PROP_VOUCHER_KEY = "VoucherKey";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_HANDL_AMT = "HandlAmt";
	public static String PROP_SHIP_TO_ADDR_KEY = "ShipToAddrKey";
	public static String PROP_TRADE_DISC_AMT = "TradeDiscAmt";
	public static String PROP_IMPORT_LOG_KEY = "ImportLogKey";
	public static String PROP_CURR_I_D = "CurrID";
	public static String PROP_S_TAX_CALC = "STaxCalc";
	public static String PROP_CUST_KEY = "CustKey";
	public static String PROP_PMT_TERMS_KEY = "PmtTermsKey";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_COST_OF_SALES = "CostOfSales";
	public static String PROP_SHIP_TO_CUST_ADDR_KEY = "ShipToCustAddrKey";
	public static String PROP_CREATE_USER_I_D = "CreateUserID";
	public static String PROP_TRAN_AMT_H_C = "TranAmtHC";
	public static String PROP_SHIP_AMT = "ShipAmt";
	public static String PROP_SHIP_ZONE_KEY = "ShipZoneKey";
	public static String PROP_NEXT_APPL_ENTRY_NO = "NextApplEntryNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_DISC_TAKEN_AMT = "DiscTakenAmt";
	public static String PROP_AUTH_OVRD_AMT = "AuthOvrdAmt";
	public static String PROP_SHIP_METH_KEY = "ShipMethKey";
	public static String PROP_UPDATE_DATE = "UpdateDate";
	public static String PROP_S_TAX_TRAN_KEY = "STaxTranKey";


	// constructors
	public BaseTarinvoice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTarinvoice (java.lang.Integer invcKey) {
		this.setInvcKey(invcKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer invcKey;

	// fields
	private java.util.Date tranDate;
	private java.util.Date closingPostDate;
	private java.util.Date createDate;
	private java.lang.Integer invcFormKey;
	private java.math.BigDecimal retntAmt;
	private java.lang.Short sourceModule;
	private java.lang.Integer commPlanKey;
	private java.math.BigDecimal balanceHC;
	private java.lang.Integer batchKey;
	private java.lang.Integer fOBKey;
	private java.math.BigDecimal sTaxAmt;
	private java.lang.String tranCmnt;
	private java.lang.Short inDispute;
	private java.util.Date discDate;
	private java.math.BigDecimal balance;
	private java.util.Date dueDate;
	private java.lang.Integer billToCustAddrKey;
	private java.lang.Integer reasonCodeKey;
	private java.lang.Integer recurInvoiceKey;
	private java.lang.String custPONo;
	private java.lang.Float currExchRate;
	private java.math.BigDecimal retntPct;
	private java.math.BigDecimal discAmt;
	private java.lang.String tranID;
	private java.lang.Integer confirmToCntctKey;
	private java.lang.Integer currExchSchdKey;
	private java.lang.String updateUserID;
	private java.lang.Integer billToAddrKey;
	private java.math.BigDecimal salesAmt;
	private java.lang.Integer tranType;
	private java.lang.Integer custClassKey;
	private java.lang.String tranNo;
	private java.lang.Integer primarySperKey;
	private java.util.Date closingTranDate;
	private java.lang.Short createType;
	private java.math.BigDecimal tranAmt;
	private java.util.Date postDate;
	private java.lang.Integer voucherKey;
	private java.lang.Integer updateCounter;
	private java.math.BigDecimal handlAmt;
	private java.lang.Integer shipToAddrKey;
	private java.math.BigDecimal tradeDiscAmt;
	private java.lang.Integer importLogKey;
	private java.lang.String currID;
	private java.lang.Short sTaxCalc;
	private java.lang.Integer custKey;
	private java.lang.Integer pmtTermsKey;
	private java.lang.String companyID;
	private java.math.BigDecimal costOfSales;
	private java.lang.Integer shipToCustAddrKey;
	private java.math.BigDecimal tranAmtHC;
	private java.lang.String createUserID;
	private java.math.BigDecimal shipAmt;
	private java.lang.Integer shipZoneKey;
	private java.lang.Integer nextApplEntryNo;
	private java.lang.Short status;
	private java.math.BigDecimal discTakenAmt;
	private java.math.BigDecimal authOvrdAmt;
	private java.lang.Integer shipMethKey;
	private java.util.Date updateDate;
	private java.lang.Integer sTaxTranKey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="InvcKey"
     */
	public java.lang.Integer getInvcKey () {
		return invcKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param invcKey the new ID
	 */
	public void setInvcKey (java.lang.Integer invcKey) {
		this.invcKey = invcKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TranDate
	 */
	public java.util.Date getTranDate () {
		return tranDate;
	}

	/**
	 * Set the value related to the column: TranDate
	 * @param tranDate the TranDate value
	 */
	public void setTranDate (java.util.Date tranDate) {
		this.tranDate = tranDate;
	}



	/**
	 * Return the value associated with the column: ClosingPostDate
	 */
	public java.util.Date getClosingPostDate () {
		return closingPostDate;
	}

	/**
	 * Set the value related to the column: ClosingPostDate
	 * @param closingPostDate the ClosingPostDate value
	 */
	public void setClosingPostDate (java.util.Date closingPostDate) {
		this.closingPostDate = closingPostDate;
	}



	/**
	 * Return the value associated with the column: CreateDate
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CreateDate
	 * @param createDate the CreateDate value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: InvcFormKey
	 */
	public java.lang.Integer getInvcFormKey () {
		return invcFormKey;
	}

	/**
	 * Set the value related to the column: InvcFormKey
	 * @param invcFormKey the InvcFormKey value
	 */
	public void setInvcFormKey (java.lang.Integer invcFormKey) {
		this.invcFormKey = invcFormKey;
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
	 * Return the value associated with the column: SourceModule
	 */
	public java.lang.Short getSourceModule () {
		return sourceModule;
	}

	/**
	 * Set the value related to the column: SourceModule
	 * @param sourceModule the SourceModule value
	 */
	public void setSourceModule (java.lang.Short sourceModule) {
		this.sourceModule = sourceModule;
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
	 * Return the value associated with the column: BalanceHC
	 */
	public java.math.BigDecimal getBalanceHC () {
		return balanceHC;
	}

	/**
	 * Set the value related to the column: BalanceHC
	 * @param balanceHC the BalanceHC value
	 */
	public void setBalanceHC (java.math.BigDecimal balanceHC) {
		this.balanceHC = balanceHC;
	}



	/**
	 * Return the value associated with the column: BatchKey
	 */
	public java.lang.Integer getBatchKey () {
		return batchKey;
	}

	/**
	 * Set the value related to the column: BatchKey
	 * @param batchKey the BatchKey value
	 */
	public void setBatchKey (java.lang.Integer batchKey) {
		this.batchKey = batchKey;
	}



	/**
	 * Return the value associated with the column: FOBKey
	 */
	public java.lang.Integer getFOBKey () {
		return fOBKey;
	}

	/**
	 * Set the value related to the column: FOBKey
	 * @param fOBKey the FOBKey value
	 */
	public void setFOBKey (java.lang.Integer fOBKey) {
		this.fOBKey = fOBKey;
	}



	/**
	 * Return the value associated with the column: STaxAmt
	 */
	public java.math.BigDecimal getSTaxAmt () {
		return sTaxAmt;
	}

	/**
	 * Set the value related to the column: STaxAmt
	 * @param sTaxAmt the STaxAmt value
	 */
	public void setSTaxAmt (java.math.BigDecimal sTaxAmt) {
		this.sTaxAmt = sTaxAmt;
	}



	/**
	 * Return the value associated with the column: TranCmnt
	 */
	public java.lang.String getTranCmnt () {
		return tranCmnt;
	}

	/**
	 * Set the value related to the column: TranCmnt
	 * @param tranCmnt the TranCmnt value
	 */
	public void setTranCmnt (java.lang.String tranCmnt) {
		this.tranCmnt = tranCmnt;
	}



	/**
	 * Return the value associated with the column: InDispute
	 */
	public java.lang.Short getInDispute () {
		return inDispute;
	}

	/**
	 * Set the value related to the column: InDispute
	 * @param inDispute the InDispute value
	 */
	public void setInDispute (java.lang.Short inDispute) {
		this.inDispute = inDispute;
	}



	/**
	 * Return the value associated with the column: DiscDate
	 */
	public java.util.Date getDiscDate () {
		return discDate;
	}

	/**
	 * Set the value related to the column: DiscDate
	 * @param discDate the DiscDate value
	 */
	public void setDiscDate (java.util.Date discDate) {
		this.discDate = discDate;
	}



	/**
	 * Return the value associated with the column: Balance
	 */
	public java.math.BigDecimal getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: Balance
	 * @param balance the Balance value
	 */
	public void setBalance (java.math.BigDecimal balance) {
		this.balance = balance;
	}



	/**
	 * Return the value associated with the column: DueDate
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: DueDate
	 * @param dueDate the DueDate value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: BillToCustAddrKey
	 */
	public java.lang.Integer getBillToCustAddrKey () {
		return billToCustAddrKey;
	}

	/**
	 * Set the value related to the column: BillToCustAddrKey
	 * @param billToCustAddrKey the BillToCustAddrKey value
	 */
	public void setBillToCustAddrKey (java.lang.Integer billToCustAddrKey) {
		this.billToCustAddrKey = billToCustAddrKey;
	}



	/**
	 * Return the value associated with the column: ReasonCodeKey
	 */
	public java.lang.Integer getReasonCodeKey () {
		return reasonCodeKey;
	}

	/**
	 * Set the value related to the column: ReasonCodeKey
	 * @param reasonCodeKey the ReasonCodeKey value
	 */
	public void setReasonCodeKey (java.lang.Integer reasonCodeKey) {
		this.reasonCodeKey = reasonCodeKey;
	}



	/**
	 * Return the value associated with the column: RecurInvoiceKey
	 */
	public java.lang.Integer getRecurInvoiceKey () {
		return recurInvoiceKey;
	}

	/**
	 * Set the value related to the column: RecurInvoiceKey
	 * @param recurInvoiceKey the RecurInvoiceKey value
	 */
	public void setRecurInvoiceKey (java.lang.Integer recurInvoiceKey) {
		this.recurInvoiceKey = recurInvoiceKey;
	}



	/**
	 * Return the value associated with the column: CustPONo
	 */
	public java.lang.String getCustPONo () {
		return custPONo;
	}

	/**
	 * Set the value related to the column: CustPONo
	 * @param custPONo the CustPONo value
	 */
	public void setCustPONo (java.lang.String custPONo) {
		this.custPONo = custPONo;
	}



	/**
	 * Return the value associated with the column: CurrExchRate
	 */
	public java.lang.Float getCurrExchRate () {
		return currExchRate;
	}

	/**
	 * Set the value related to the column: CurrExchRate
	 * @param currExchRate the CurrExchRate value
	 */
	public void setCurrExchRate (java.lang.Float currExchRate) {
		this.currExchRate = currExchRate;
	}



	/**
	 * Return the value associated with the column: RetntPct
	 */
	public java.math.BigDecimal getRetntPct () {
		return retntPct;
	}

	/**
	 * Set the value related to the column: RetntPct
	 * @param retntPct the RetntPct value
	 */
	public void setRetntPct (java.math.BigDecimal retntPct) {
		this.retntPct = retntPct;
	}



	/**
	 * Return the value associated with the column: DiscAmt
	 */
	public java.math.BigDecimal getDiscAmt () {
		return discAmt;
	}

	/**
	 * Set the value related to the column: DiscAmt
	 * @param discAmt the DiscAmt value
	 */
	public void setDiscAmt (java.math.BigDecimal discAmt) {
		this.discAmt = discAmt;
	}



	/**
	 * Return the value associated with the column: TranID
	 */
	public java.lang.String getTranID () {
		return tranID;
	}

	/**
	 * Set the value related to the column: TranID
	 * @param tranID the TranID value
	 */
	public void setTranID (java.lang.String tranID) {
		this.tranID = tranID;
	}



	/**
	 * Return the value associated with the column: ConfirmToCntctKey
	 */
	public java.lang.Integer getConfirmToCntctKey () {
		return confirmToCntctKey;
	}

	/**
	 * Set the value related to the column: ConfirmToCntctKey
	 * @param confirmToCntctKey the ConfirmToCntctKey value
	 */
	public void setConfirmToCntctKey (java.lang.Integer confirmToCntctKey) {
		this.confirmToCntctKey = confirmToCntctKey;
	}



	/**
	 * Return the value associated with the column: CurrExchSchdKey
	 */
	public java.lang.Integer getCurrExchSchdKey () {
		return currExchSchdKey;
	}

	/**
	 * Set the value related to the column: CurrExchSchdKey
	 * @param currExchSchdKey the CurrExchSchdKey value
	 */
	public void setCurrExchSchdKey (java.lang.Integer currExchSchdKey) {
		this.currExchSchdKey = currExchSchdKey;
	}



	/**
	 * Return the value associated with the column: UpdateUserID
	 */
	public java.lang.String getUpdateUserID () {
		return updateUserID;
	}

	/**
	 * Set the value related to the column: UpdateUserID
	 * @param updateUserID the UpdateUserID value
	 */
	public void setUpdateUserID (java.lang.String updateUserID) {
		this.updateUserID = updateUserID;
	}



	/**
	 * Return the value associated with the column: BillToAddrKey
	 */
	public java.lang.Integer getBillToAddrKey () {
		return billToAddrKey;
	}

	/**
	 * Set the value related to the column: BillToAddrKey
	 * @param billToAddrKey the BillToAddrKey value
	 */
	public void setBillToAddrKey (java.lang.Integer billToAddrKey) {
		this.billToAddrKey = billToAddrKey;
	}



	/**
	 * Return the value associated with the column: SalesAmt
	 */
	public java.math.BigDecimal getSalesAmt () {
		return salesAmt;
	}

	/**
	 * Set the value related to the column: SalesAmt
	 * @param salesAmt the SalesAmt value
	 */
	public void setSalesAmt (java.math.BigDecimal salesAmt) {
		this.salesAmt = salesAmt;
	}



	/**
	 * Return the value associated with the column: TranType
	 */
	public java.lang.Integer getTranType () {
		return tranType;
	}

	/**
	 * Set the value related to the column: TranType
	 * @param tranType the TranType value
	 */
	public void setTranType (java.lang.Integer tranType) {
		this.tranType = tranType;
	}



	/**
	 * Return the value associated with the column: CustClassKey
	 */
	public java.lang.Integer getCustClassKey () {
		return custClassKey;
	}

	/**
	 * Set the value related to the column: CustClassKey
	 * @param custClassKey the CustClassKey value
	 */
	public void setCustClassKey (java.lang.Integer custClassKey) {
		this.custClassKey = custClassKey;
	}



	/**
	 * Return the value associated with the column: TranNo
	 */
	public java.lang.String getTranNo () {
		return tranNo;
	}

	/**
	 * Set the value related to the column: TranNo
	 * @param tranNo the TranNo value
	 */
	public void setTranNo (java.lang.String tranNo) {
		this.tranNo = tranNo;
	}



	/**
	 * Return the value associated with the column: PrimarySperKey
	 */
	public java.lang.Integer getPrimarySperKey () {
		return primarySperKey;
	}

	/**
	 * Set the value related to the column: PrimarySperKey
	 * @param primarySperKey the PrimarySperKey value
	 */
	public void setPrimarySperKey (java.lang.Integer primarySperKey) {
		this.primarySperKey = primarySperKey;
	}



	/**
	 * Return the value associated with the column: ClosingTranDate
	 */
	public java.util.Date getClosingTranDate () {
		return closingTranDate;
	}

	/**
	 * Set the value related to the column: ClosingTranDate
	 * @param closingTranDate the ClosingTranDate value
	 */
	public void setClosingTranDate (java.util.Date closingTranDate) {
		this.closingTranDate = closingTranDate;
	}



	/**
	 * Return the value associated with the column: CreateType
	 */
	public java.lang.Short getCreateType () {
		return createType;
	}

	/**
	 * Set the value related to the column: CreateType
	 * @param createType the CreateType value
	 */
	public void setCreateType (java.lang.Short createType) {
		this.createType = createType;
	}



	/**
	 * Return the value associated with the column: TranAmt
	 */
	public java.math.BigDecimal getTranAmt () {
		return tranAmt;
	}

	/**
	 * Set the value related to the column: TranAmt
	 * @param tranAmt the TranAmt value
	 */
	public void setTranAmt (java.math.BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}



	/**
	 * Return the value associated with the column: PostDate
	 */
	public java.util.Date getPostDate () {
		return postDate;
	}

	/**
	 * Set the value related to the column: PostDate
	 * @param postDate the PostDate value
	 */
	public void setPostDate (java.util.Date postDate) {
		this.postDate = postDate;
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
	 * Return the value associated with the column: HandlAmt
	 */
	public java.math.BigDecimal getHandlAmt () {
		return handlAmt;
	}

	/**
	 * Set the value related to the column: HandlAmt
	 * @param handlAmt the HandlAmt value
	 */
	public void setHandlAmt (java.math.BigDecimal handlAmt) {
		this.handlAmt = handlAmt;
	}



	/**
	 * Return the value associated with the column: ShipToAddrKey
	 */
	public java.lang.Integer getShipToAddrKey () {
		return shipToAddrKey;
	}

	/**
	 * Set the value related to the column: ShipToAddrKey
	 * @param shipToAddrKey the ShipToAddrKey value
	 */
	public void setShipToAddrKey (java.lang.Integer shipToAddrKey) {
		this.shipToAddrKey = shipToAddrKey;
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
	 * Return the value associated with the column: ImportLogKey
	 */
	public java.lang.Integer getImportLogKey () {
		return importLogKey;
	}

	/**
	 * Set the value related to the column: ImportLogKey
	 * @param importLogKey the ImportLogKey value
	 */
	public void setImportLogKey (java.lang.Integer importLogKey) {
		this.importLogKey = importLogKey;
	}



	/**
	 * Return the value associated with the column: CurrID
	 */
	public java.lang.String getCurrID () {
		return currID;
	}

	/**
	 * Set the value related to the column: CurrID
	 * @param currID the CurrID value
	 */
	public void setCurrID (java.lang.String currID) {
		this.currID = currID;
	}



	/**
	 * Return the value associated with the column: STaxCalc
	 */
	public java.lang.Short getSTaxCalc () {
		return sTaxCalc;
	}

	/**
	 * Set the value related to the column: STaxCalc
	 * @param sTaxCalc the STaxCalc value
	 */
	public void setSTaxCalc (java.lang.Short sTaxCalc) {
		this.sTaxCalc = sTaxCalc;
	}



	/**
	 * Return the value associated with the column: CustKey
	 */
	public java.lang.Integer getCustKey () {
		return custKey;
	}

	/**
	 * Set the value related to the column: CustKey
	 * @param custKey the CustKey value
	 */
	public void setCustKey (java.lang.Integer custKey) {
		this.custKey = custKey;
	}



	/**
	 * Return the value associated with the column: PmtTermsKey
	 */
	public java.lang.Integer getPmtTermsKey () {
		return pmtTermsKey;
	}

	/**
	 * Set the value related to the column: PmtTermsKey
	 * @param pmtTermsKey the PmtTermsKey value
	 */
	public void setPmtTermsKey (java.lang.Integer pmtTermsKey) {
		this.pmtTermsKey = pmtTermsKey;
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
	 * Return the value associated with the column: CostOfSales
	 */
	public java.math.BigDecimal getCostOfSales () {
		return costOfSales;
	}

	/**
	 * Set the value related to the column: CostOfSales
	 * @param costOfSales the CostOfSales value
	 */
	public void setCostOfSales (java.math.BigDecimal costOfSales) {
		this.costOfSales = costOfSales;
	}



	/**
	 * Return the value associated with the column: ShipToCustAddrKey
	 */
	public java.lang.Integer getShipToCustAddrKey () {
		return shipToCustAddrKey;
	}

	/**
	 * Set the value related to the column: ShipToCustAddrKey
	 * @param shipToCustAddrKey the ShipToCustAddrKey value
	 */
	public void setShipToCustAddrKey (java.lang.Integer shipToCustAddrKey) {
		this.shipToCustAddrKey = shipToCustAddrKey;
	}



	/**
	 * Return the value associated with the column: TranAmtHC
	 */
	public java.math.BigDecimal getTranAmtHC () {
		return tranAmtHC;
	}

	/**
	 * Set the value related to the column: TranAmtHC
	 * @param tranAmtHC the TranAmtHC value
	 */
	public void setTranAmtHC (java.math.BigDecimal tranAmtHC) {
		this.tranAmtHC = tranAmtHC;
	}



	/**
	 * Return the value associated with the column: CreateUserID
	 */
	public java.lang.String getCreateUserID () {
		return createUserID;
	}

	/**
	 * Set the value related to the column: CreateUserID
	 * @param createUserID the CreateUserID value
	 */
	public void setCreateUserID (java.lang.String createUserID) {
		this.createUserID = createUserID;
	}



	/**
	 * Return the value associated with the column: ShipAmt
	 */
	public java.math.BigDecimal getShipAmt () {
		return shipAmt;
	}

	/**
	 * Set the value related to the column: ShipAmt
	 * @param shipAmt the ShipAmt value
	 */
	public void setShipAmt (java.math.BigDecimal shipAmt) {
		this.shipAmt = shipAmt;
	}



	/**
	 * Return the value associated with the column: ShipZoneKey
	 */
	public java.lang.Integer getShipZoneKey () {
		return shipZoneKey;
	}

	/**
	 * Set the value related to the column: ShipZoneKey
	 * @param shipZoneKey the ShipZoneKey value
	 */
	public void setShipZoneKey (java.lang.Integer shipZoneKey) {
		this.shipZoneKey = shipZoneKey;
	}



	/**
	 * Return the value associated with the column: NextApplEntryNo
	 */
	public java.lang.Integer getNextApplEntryNo () {
		return nextApplEntryNo;
	}

	/**
	 * Set the value related to the column: NextApplEntryNo
	 * @param nextApplEntryNo the NextApplEntryNo value
	 */
	public void setNextApplEntryNo (java.lang.Integer nextApplEntryNo) {
		this.nextApplEntryNo = nextApplEntryNo;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.Short getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.Short status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: DiscTakenAmt
	 */
	public java.math.BigDecimal getDiscTakenAmt () {
		return discTakenAmt;
	}

	/**
	 * Set the value related to the column: DiscTakenAmt
	 * @param discTakenAmt the DiscTakenAmt value
	 */
	public void setDiscTakenAmt (java.math.BigDecimal discTakenAmt) {
		this.discTakenAmt = discTakenAmt;
	}



	/**
	 * Return the value associated with the column: AuthOvrdAmt
	 */
	public java.math.BigDecimal getAuthOvrdAmt () {
		return authOvrdAmt;
	}

	/**
	 * Set the value related to the column: AuthOvrdAmt
	 * @param authOvrdAmt the AuthOvrdAmt value
	 */
	public void setAuthOvrdAmt (java.math.BigDecimal authOvrdAmt) {
		this.authOvrdAmt = authOvrdAmt;
	}



	/**
	 * Return the value associated with the column: ShipMethKey
	 */
	public java.lang.Integer getShipMethKey () {
		return shipMethKey;
	}

	/**
	 * Set the value related to the column: ShipMethKey
	 * @param shipMethKey the ShipMethKey value
	 */
	public void setShipMethKey (java.lang.Integer shipMethKey) {
		this.shipMethKey = shipMethKey;
	}



	/**
	 * Return the value associated with the column: UpdateDate
	 */
	public java.util.Date getUpdateDate () {
		return updateDate;
	}

	/**
	 * Set the value related to the column: UpdateDate
	 * @param updateDate the UpdateDate value
	 */
	public void setUpdateDate (java.util.Date updateDate) {
		this.updateDate = updateDate;
	}



	/**
	 * Return the value associated with the column: STaxTranKey
	 */
	public java.lang.Integer getSTaxTranKey () {
		return sTaxTranKey;
	}

	/**
	 * Set the value related to the column: STaxTranKey
	 * @param sTaxTranKey the STaxTranKey value
	 */
	public void setSTaxTranKey (java.lang.Integer sTaxTranKey) {
		this.sTaxTranKey = sTaxTranKey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tarinvoice)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tarinvoice tarinvoice = (com.bureaueye.beacon.model.mas500.Tarinvoice) obj;
			if (null == this.getInvcKey() || null == tarinvoice.getInvcKey()) return false;
			else return (this.getInvcKey().equals(tarinvoice.getInvcKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getInvcKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getInvcKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}