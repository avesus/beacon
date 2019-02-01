package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tapvoucher table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tapvoucher"
 */

public abstract class BaseTapvoucher  implements Serializable {

	public static String REF = "Tapvoucher";
	public static String PROP_TRAN_DATE = "TranDate";
	public static String PROP_CLOSING_POST_DATE = "ClosingPostDate";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_V1099_BOX_TEXT = "V1099BoxText";
	public static String PROP_FREIGHT_AMT = "FreightAmt";
	public static String PROP_RETNT_AMT = "RetntAmt";
	public static String PROP_APPLY_SEQ_NO = "ApplySeqNo";
	public static String PROP_INVC_RCPT_DATE = "InvcRcptDate";
	public static String PROP_BALANCE_H_C = "BalanceHC";
	public static String PROP_BATCH_KEY = "BatchKey";
	public static String PROP_F_O_B_KEY = "FOBKey";
	public static String PROP_S_TAX_AMT = "STaxAmt";
	public static String PROP_TRAN_CMNT = "TranCmnt";
	public static String PROP_REMIT_TO_ADDR_KEY = "RemitToAddrKey";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_DISC_DATE = "DiscDate";
	public static String PROP_CASH_ACCT_KEY = "CashAcctKey";
	public static String PROP_REASON_CODE_KEY = "ReasonCodeKey";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_CURR_EXCH_RATE = "CurrExchRate";
	public static String PROP_DISC_AMT = "DiscAmt";
	public static String PROP_REMIT_TO_VEND_ADDR_KEY = "RemitToVendAddrKey";
	public static String PROP_TRAN_I_D = "TranID";
	public static String PROP_SEPARATE_CHK = "SeparateChk";
	public static String PROP_CURR_EXCH_SCHD_KEY = "CurrExchSchdKey";
	public static String PROP_UPDATE_USER_I_D = "UpdateUserID";
	public static String PROP_VEND_KEY = "VendKey";
	public static String PROP_TRAN_TYPE = "TranType";
	public static String PROP_TRAN_NO = "TranNo";
	public static String PROP_CLOSING_TRAN_DATE = "ClosingTranDate";
	public static String PROP_CREATE_TYPE = "CreateType";
	public static String PROP_V1099_BOX = "V1099Box";
	public static String PROP_POST_DATE = "PostDate";
	public static String PROP_TRAN_AMT = "TranAmt";
	public static String PROP_VOUCHER_KEY = "VoucherKey";
	public static String PROP_PURCH_VEND_ADDR_KEY = "PurchVendAddrKey";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_HOLD_PMT = "HoldPmt";
	public static String PROP_IMPORT_LOG_KEY = "ImportLogKey";
	public static String PROP_PURCH_ADDR_KEY = "PurchAddrKey";
	public static String PROP_CURR_I_D = "CurrID";
	public static String PROP_PMT_TERMS_KEY = "PmtTermsKey";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_CREATE_USER_I_D = "CreateUserID";
	public static String PROP_TRAN_AMT_H_C = "TranAmtHC";
	public static String PROP_VOUCH_NO = "VouchNo";
	public static String PROP_RECUR_VOUCH_KEY = "RecurVouchKey";
	public static String PROP_SHIP_ZONE_KEY = "ShipZoneKey";
	public static String PROP_NEXT_APPL_ENTRY_NO = "NextApplEntryNo";
	public static String PROP_CNTCT_KEY = "CntctKey";
	public static String PROP_V1099_FORM = "V1099Form";
	public static String PROP_STATUS = "Status";
	public static String PROP_DISC_TAKEN_AMT = "DiscTakenAmt";
	public static String PROP_SHIP_METH_KEY = "ShipMethKey";
	public static String PROP_VEND_CLASS_KEY = "VendClassKey";
	public static String PROP_UPDATE_DATE = "UpdateDate";
	public static String PROP_PURCH_AMT = "PurchAmt";
	public static String PROP_S_TAX_TRAN_KEY = "STaxTranKey";


	// constructors
	public BaseTapvoucher () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTapvoucher (java.lang.Integer voucherKey) {
		this.setVoucherKey(voucherKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer voucherKey;

	// fields
	private java.util.Date tranDate;
	private java.util.Date closingPostDate;
	private java.util.Date createDate;
	private java.lang.String v1099BoxText;
	private java.math.BigDecimal freightAmt;
	private java.math.BigDecimal retntAmt;
	private java.lang.Integer applySeqNo;
	private java.util.Date invcRcptDate;
	private java.math.BigDecimal balanceHC;
	private java.lang.Integer batchKey;
	private java.lang.Integer fOBKey;
	private java.math.BigDecimal sTaxAmt;
	private java.lang.Integer remitToAddrKey;
	private java.lang.String tranCmnt;
	private java.util.Date discDate;
	private java.math.BigDecimal balance;
	private java.lang.Integer cashAcctKey;
	private java.util.Date dueDate;
	private java.lang.Integer reasonCodeKey;
	private java.lang.Float currExchRate;
	private java.math.BigDecimal discAmt;
	private java.lang.Integer remitToVendAddrKey;
	private java.lang.String tranID;
	private java.lang.Short separateChk;
	private java.lang.Integer currExchSchdKey;
	private java.lang.String updateUserID;
	private java.lang.Integer vendKey;
	private java.lang.Integer tranType;
	private java.lang.String tranNo;
	private java.util.Date closingTranDate;
	private java.lang.Short createType;
	private java.lang.String v1099Box;
	private java.util.Date postDate;
	private java.math.BigDecimal tranAmt;
	private java.lang.Integer purchVendAddrKey;
	private java.lang.Integer updateCounter;
	private java.lang.Short holdPmt;
	private java.lang.Integer importLogKey;
	private java.lang.Integer purchAddrKey;
	private java.lang.String currID;
	private java.lang.Integer pmtTermsKey;
	private java.lang.String companyID;
	private java.lang.String createUserID;
	private java.math.BigDecimal tranAmtHC;
	private java.lang.String vouchNo;
	private java.lang.Integer recurVouchKey;
	private java.lang.Integer shipZoneKey;
	private java.lang.Integer nextApplEntryNo;
	private java.lang.Integer cntctKey;
	private java.lang.Short v1099Form;
	private java.lang.Short status;
	private java.math.BigDecimal discTakenAmt;
	private java.lang.Integer shipMethKey;
	private java.lang.Integer vendClassKey;
	private java.util.Date updateDate;
	private java.math.BigDecimal purchAmt;
	private java.lang.Integer sTaxTranKey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VoucherKey"
     */
	public java.lang.Integer getVoucherKey () {
		return voucherKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param voucherKey the new ID
	 */
	public void setVoucherKey (java.lang.Integer voucherKey) {
		this.voucherKey = voucherKey;
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
	 * Return the value associated with the column: V1099BoxText
	 */
	public java.lang.String getV1099BoxText () {
		return v1099BoxText;
	}

	/**
	 * Set the value related to the column: V1099BoxText
	 * @param v1099BoxText the V1099BoxText value
	 */
	public void setV1099BoxText (java.lang.String v1099BoxText) {
		this.v1099BoxText = v1099BoxText;
	}



	/**
	 * Return the value associated with the column: FreightAmt
	 */
	public java.math.BigDecimal getFreightAmt () {
		return freightAmt;
	}

	/**
	 * Set the value related to the column: FreightAmt
	 * @param freightAmt the FreightAmt value
	 */
	public void setFreightAmt (java.math.BigDecimal freightAmt) {
		this.freightAmt = freightAmt;
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
	 * Return the value associated with the column: ApplySeqNo
	 */
	public java.lang.Integer getApplySeqNo () {
		return applySeqNo;
	}

	/**
	 * Set the value related to the column: ApplySeqNo
	 * @param applySeqNo the ApplySeqNo value
	 */
	public void setApplySeqNo (java.lang.Integer applySeqNo) {
		this.applySeqNo = applySeqNo;
	}



	/**
	 * Return the value associated with the column: InvcRcptDate
	 */
	public java.util.Date getInvcRcptDate () {
		return invcRcptDate;
	}

	/**
	 * Set the value related to the column: InvcRcptDate
	 * @param invcRcptDate the InvcRcptDate value
	 */
	public void setInvcRcptDate (java.util.Date invcRcptDate) {
		this.invcRcptDate = invcRcptDate;
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
	 * Return the value associated with the column: RemitToAddrKey
	 */
	public java.lang.Integer getRemitToAddrKey () {
		return remitToAddrKey;
	}

	/**
	 * Set the value related to the column: RemitToAddrKey
	 * @param remitToAddrKey the RemitToAddrKey value
	 */
	public void setRemitToAddrKey (java.lang.Integer remitToAddrKey) {
		this.remitToAddrKey = remitToAddrKey;
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
	 * Return the value associated with the column: CashAcctKey
	 */
	public java.lang.Integer getCashAcctKey () {
		return cashAcctKey;
	}

	/**
	 * Set the value related to the column: CashAcctKey
	 * @param cashAcctKey the CashAcctKey value
	 */
	public void setCashAcctKey (java.lang.Integer cashAcctKey) {
		this.cashAcctKey = cashAcctKey;
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
	 * Return the value associated with the column: RemitToVendAddrKey
	 */
	public java.lang.Integer getRemitToVendAddrKey () {
		return remitToVendAddrKey;
	}

	/**
	 * Set the value related to the column: RemitToVendAddrKey
	 * @param remitToVendAddrKey the RemitToVendAddrKey value
	 */
	public void setRemitToVendAddrKey (java.lang.Integer remitToVendAddrKey) {
		this.remitToVendAddrKey = remitToVendAddrKey;
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
	 * Return the value associated with the column: SeparateChk
	 */
	public java.lang.Short getSeparateChk () {
		return separateChk;
	}

	/**
	 * Set the value related to the column: SeparateChk
	 * @param separateChk the SeparateChk value
	 */
	public void setSeparateChk (java.lang.Short separateChk) {
		this.separateChk = separateChk;
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
	 * Return the value associated with the column: VendKey
	 */
	public java.lang.Integer getVendKey () {
		return vendKey;
	}

	/**
	 * Set the value related to the column: VendKey
	 * @param vendKey the VendKey value
	 */
	public void setVendKey (java.lang.Integer vendKey) {
		this.vendKey = vendKey;
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
	 * Return the value associated with the column: V1099Box
	 */
	public java.lang.String getV1099Box () {
		return v1099Box;
	}

	/**
	 * Set the value related to the column: V1099Box
	 * @param v1099Box the V1099Box value
	 */
	public void setV1099Box (java.lang.String v1099Box) {
		this.v1099Box = v1099Box;
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
	 * Return the value associated with the column: PurchVendAddrKey
	 */
	public java.lang.Integer getPurchVendAddrKey () {
		return purchVendAddrKey;
	}

	/**
	 * Set the value related to the column: PurchVendAddrKey
	 * @param purchVendAddrKey the PurchVendAddrKey value
	 */
	public void setPurchVendAddrKey (java.lang.Integer purchVendAddrKey) {
		this.purchVendAddrKey = purchVendAddrKey;
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
	 * Return the value associated with the column: HoldPmt
	 */
	public java.lang.Short getHoldPmt () {
		return holdPmt;
	}

	/**
	 * Set the value related to the column: HoldPmt
	 * @param holdPmt the HoldPmt value
	 */
	public void setHoldPmt (java.lang.Short holdPmt) {
		this.holdPmt = holdPmt;
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
	 * Return the value associated with the column: PurchAddrKey
	 */
	public java.lang.Integer getPurchAddrKey () {
		return purchAddrKey;
	}

	/**
	 * Set the value related to the column: PurchAddrKey
	 * @param purchAddrKey the PurchAddrKey value
	 */
	public void setPurchAddrKey (java.lang.Integer purchAddrKey) {
		this.purchAddrKey = purchAddrKey;
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
	 * Return the value associated with the column: VouchNo
	 */
	public java.lang.String getVouchNo () {
		return vouchNo;
	}

	/**
	 * Set the value related to the column: VouchNo
	 * @param vouchNo the VouchNo value
	 */
	public void setVouchNo (java.lang.String vouchNo) {
		this.vouchNo = vouchNo;
	}



	/**
	 * Return the value associated with the column: RecurVouchKey
	 */
	public java.lang.Integer getRecurVouchKey () {
		return recurVouchKey;
	}

	/**
	 * Set the value related to the column: RecurVouchKey
	 * @param recurVouchKey the RecurVouchKey value
	 */
	public void setRecurVouchKey (java.lang.Integer recurVouchKey) {
		this.recurVouchKey = recurVouchKey;
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
	 * Return the value associated with the column: CntctKey
	 */
	public java.lang.Integer getCntctKey () {
		return cntctKey;
	}

	/**
	 * Set the value related to the column: CntctKey
	 * @param cntctKey the CntctKey value
	 */
	public void setCntctKey (java.lang.Integer cntctKey) {
		this.cntctKey = cntctKey;
	}



	/**
	 * Return the value associated with the column: V1099Form
	 */
	public java.lang.Short getV1099Form () {
		return v1099Form;
	}

	/**
	 * Set the value related to the column: V1099Form
	 * @param v1099Form the V1099Form value
	 */
	public void setV1099Form (java.lang.Short v1099Form) {
		this.v1099Form = v1099Form;
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
	 * Return the value associated with the column: VendClassKey
	 */
	public java.lang.Integer getVendClassKey () {
		return vendClassKey;
	}

	/**
	 * Set the value related to the column: VendClassKey
	 * @param vendClassKey the VendClassKey value
	 */
	public void setVendClassKey (java.lang.Integer vendClassKey) {
		this.vendClassKey = vendClassKey;
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
	 * Return the value associated with the column: PurchAmt
	 */
	public java.math.BigDecimal getPurchAmt () {
		return purchAmt;
	}

	/**
	 * Set the value related to the column: PurchAmt
	 * @param purchAmt the PurchAmt value
	 */
	public void setPurchAmt (java.math.BigDecimal purchAmt) {
		this.purchAmt = purchAmt;
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
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tapvoucher)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tapvoucher tapvoucher = (com.bureaueye.beacon.model.mas500.Tapvoucher) obj;
			if (null == this.getVoucherKey() || null == tapvoucher.getVoucherKey()) return false;
			else return (this.getVoucherKey().equals(tapvoucher.getVoucherKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getVoucherKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getVoucherKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}