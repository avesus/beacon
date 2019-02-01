package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tpa00125 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tpa00125"
 */

public abstract class BaseTpa00125  implements Serializable {

	public static String REF = "Tpa00125";
	public static String PROP_NUM_CHARGE_OUT_RATE = "NumChargeOutRate";
	public static String PROP_NUM_JOB_T_R_X_N_EST_SALE = "NumJobTRXNEstSale";
	public static String PROP_INT_PHASE_KEY = "IntPhaseKey";
	public static String PROP_NUM_RETAIN_PERCENT = "NumRetainPercent";
	public static String PROP_NUM_REVISED_EST_Q_T_Y = "NumRevisedEstQTY";
	public static String PROP_NUM_RECOVERABLES_AMT = "NumRecoverablesAmt";
	public static String PROP_INT_JOB_LINE_KEY = "IntJobLineKey";
	public static String PROP_NUM_JOB_T_R_X_N_W_O_SALE = "NumJobTRXNWOSale";
	public static String PROP_NUM_JOB_T_R_X_N_RV_EST_CST = "NumJobTRXNRvEstCst";
	public static String PROP_UNIT_MEAS_KEY = "UnitMeasKey";
	public static String PROP_NUM_JOB_T_R_X_N_ACTL_COST = "NumJobTRXNActlCost";
	public static String PROP_NUM_ESTIMATED_Q_T_Y = "NumEstimatedQTY";
	public static String PROP_NUM_PERCENT_COMPLETE = "NumPercentComplete";
	public static String PROP_NUM_MARKUP = "NumMarkup";
	public static String PROP_NUM_RETAIN_AMOUNT = "NumRetainAmount";
	public static String PROP_DTE_ACT_COMPLETE_DATE = "DteActCompleteDate";
	public static String PROP_TI_WRITE_OFF = "TiWriteOff";
	public static String PROP_DTE_SCHED_START_DATE = "DteSchedStartDate";
	public static String PROP_NUM_Q_T_Y_INVOICED = "NumQTYInvoiced";
	public static String PROP_INT_INV_DESCR_KEY = "IntInvDescrKey";
	public static String PROP_SI_CST_CLSIFICATN_D_D_L = "SiCstClsificatnDDL";
	public static String PROP_DTE_ACTUAL_START_DATE = "DteActualStartDate";
	public static String PROP_NUM_COSTS_RECOGNIZED = "NumCostsRecognized";
	public static String PROP_VEND_KEY = "VendKey";
	public static String PROP_DTE_SCHED_COMPLETE = "DteSchedComplete";
	public static String PROP_TI_CREATE_P_O = "TiCreatePO";
	public static String PROP_DTE_PROMISED_DATE = "DtePromisedDate";
	public static String PROP_NUM_REVISED_CHG_OUT_RT = "NumRevisedChgOutRt";
	public static String PROP_NUM_JOB_T_R_X_N_ACTL_SALE = "NumJobTRXNActlSale";
	public static String PROP_NUM_REVISED_EMP_CST_RT = "NumRevisedEmpCstRt";
	public static String PROP_NUM_HOURS_BILLED = "NumHoursBilled";
	public static String PROP_NUM_JOB_T_R_X_N_EST_COST = "NumJobTRXNEstCost";
	public static String PROP_NUM_NEW_FORCAST_SALES = "NumNewForcastSales";
	public static String PROP_NUM_LAST_FORCAST_COST = "NumLastForcastCost";
	public static String PROP_TI_POSTED = "TiPosted";
	public static String PROP_SI_PROFIT_REC_METHOD = "SiProfitRecMethod";
	public static String PROP_UPDATE_COUNTER = "UpdateCounter";
	public static String PROP_NUM_RECOVERABLES = "NumRecoverables";
	public static String PROP_NUM_ACTUAL_QUANTITY = "NumActualQuantity";
	public static String PROP_NUM_JOB_T_R_X_N_RV_EST_SAL = "NumJobTRXNRvEstSal";
	public static String PROP_NUM_MARKUP_PERCENT = "NumMarkupPercent";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_NUM_LINE_SEQ_NUMBER = "NumLineSeqNumber";
	public static String PROP_NUM_EMPLOYEE_CST_RATE = "NumEmployeeCstRate";
	public static String PROP_INT_EMPLOYEE_KEY = "IntEmployeeKey";
	public static String PROP_NUM_SALES_RECOGNIZED = "NumSalesRecognized";
	public static String PROP_INT_TASK_KEY = "IntTaskKey";
	public static String PROP_ITEM_KEY = "ItemKey";
	public static String PROP_NUM_NEW_FORCAST_COSTS = "NumNewForcastCosts";
	public static String PROP_NUM_JOB_T_R_X_N_W_O_COST = "NumJobTRXNWOCost";
	public static String PROP_TI_IS_VARIATION = "TiIsVariation";
	public static String PROP_NUM_QUANTITY_TO_INV = "NumQuantityToInv";
	public static String PROP_INT_JOB_KEY = "IntJobKey";
	public static String PROP_NUM_J_T_D_COMMITED_CSTS = "NumJTDCommitedCsts";
	public static String PROP_CHR_DESCRIPTION = "ChrDescription";
	public static String PROP_NUM_LAST_FORCAST_SALE = "NumLastForcastSale";


	// constructors
	public BaseTpa00125 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTpa00125 (java.lang.Integer intJobLineKey) {
		this.setIntJobLineKey(intJobLineKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer intJobLineKey;

	// fields
	private java.math.BigDecimal numRecoverables;
	private java.math.BigDecimal numRevisedChgOutRt;
	private java.math.BigDecimal numLastForcastSale;
	private java.util.Date dteActCompleteDate;
	private java.util.Date dteSchedStartDate;
	private java.math.BigDecimal numQTYInvoiced;
	private java.lang.Short siProfitRecMethod;
	private java.math.BigDecimal numQuantityToInv;
	private java.math.BigDecimal numEstimatedQTY;
	private java.math.BigDecimal numRetainPercent;
	private java.lang.Integer unitMeasKey;
	private java.util.Date dteActualStartDate;
	private java.math.BigDecimal numSalesRecognized;
	private java.lang.Byte tiCreatePO;
	private java.math.BigDecimal numRevisedEmpCstRt;
	private java.math.BigDecimal numActualQuantity;
	private java.lang.Short siCstClsificatnDDL;
	private java.lang.String chrDescription;
	private java.math.BigDecimal numJobTRXNEstCost;
	private java.math.BigDecimal numHoursBilled;
	private java.math.BigDecimal numJobTRXNActlCost;
	private java.lang.Integer intPhaseKey;
	private java.lang.Short tiIsVariation;
	private java.math.BigDecimal numNewForcastCosts;
	private java.math.BigDecimal numRetainAmount;
	private java.math.BigDecimal numJobTRXNRvEstSal;
	private java.math.BigDecimal numChargeOutRate;
	private java.math.BigDecimal numEmployeeCstRate;
	private java.math.BigDecimal numLineSeqNumber;
	private java.math.BigDecimal numMarkupPercent;
	private java.lang.Integer vendKey;
	private java.math.BigDecimal numRecoverablesAmt;
	private java.lang.Integer intEmployeeKey;
	private java.util.Date dtePromisedDate;
	private java.lang.Short tiPosted;
	private java.math.BigDecimal numLastForcastCost;
	private java.math.BigDecimal numPercentComplete;
	private java.util.Date dteSchedComplete;
	private java.lang.Integer updateCounter;
	private java.math.BigDecimal numJobTRXNWOCost;
	private java.math.BigDecimal numRevisedEstQTY;
	private java.math.BigDecimal numJTDCommitedCsts;
	private java.lang.Integer intTaskKey;
	private java.lang.String companyID;
	private java.math.BigDecimal numNewForcastSales;
	private java.lang.Integer intInvDescrKey;
	private java.math.BigDecimal numJobTRXNRvEstCst;
	private java.math.BigDecimal numJobTRXNActlSale;
	private java.lang.Integer itemKey;
	private java.lang.Integer intJobKey;
	private java.math.BigDecimal numCostsRecognized;
	private java.math.BigDecimal numJobTRXNEstSale;
	private java.math.BigDecimal numMarkup;
	private java.lang.Short tiWriteOff;
	private java.math.BigDecimal numJobTRXNWOSale;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="intJobLineKey"
     */
	public java.lang.Integer getIntJobLineKey () {
		return intJobLineKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param intJobLineKey the new ID
	 */
	public void setIntJobLineKey (java.lang.Integer intJobLineKey) {
		this.intJobLineKey = intJobLineKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: numRecoverables
	 */
	public java.math.BigDecimal getNumRecoverables () {
		return numRecoverables;
	}

	/**
	 * Set the value related to the column: numRecoverables
	 * @param numRecoverables the numRecoverables value
	 */
	public void setNumRecoverables (java.math.BigDecimal numRecoverables) {
		this.numRecoverables = numRecoverables;
	}



	/**
	 * Return the value associated with the column: numRevisedChgOutRt
	 */
	public java.math.BigDecimal getNumRevisedChgOutRt () {
		return numRevisedChgOutRt;
	}

	/**
	 * Set the value related to the column: numRevisedChgOutRt
	 * @param numRevisedChgOutRt the numRevisedChgOutRt value
	 */
	public void setNumRevisedChgOutRt (java.math.BigDecimal numRevisedChgOutRt) {
		this.numRevisedChgOutRt = numRevisedChgOutRt;
	}



	/**
	 * Return the value associated with the column: numLastForcastSale
	 */
	public java.math.BigDecimal getNumLastForcastSale () {
		return numLastForcastSale;
	}

	/**
	 * Set the value related to the column: numLastForcastSale
	 * @param numLastForcastSale the numLastForcastSale value
	 */
	public void setNumLastForcastSale (java.math.BigDecimal numLastForcastSale) {
		this.numLastForcastSale = numLastForcastSale;
	}



	/**
	 * Return the value associated with the column: dteActCompleteDate
	 */
	public java.util.Date getDteActCompleteDate () {
		return dteActCompleteDate;
	}

	/**
	 * Set the value related to the column: dteActCompleteDate
	 * @param dteActCompleteDate the dteActCompleteDate value
	 */
	public void setDteActCompleteDate (java.util.Date dteActCompleteDate) {
		this.dteActCompleteDate = dteActCompleteDate;
	}



	/**
	 * Return the value associated with the column: dteSchedStartDate
	 */
	public java.util.Date getDteSchedStartDate () {
		return dteSchedStartDate;
	}

	/**
	 * Set the value related to the column: dteSchedStartDate
	 * @param dteSchedStartDate the dteSchedStartDate value
	 */
	public void setDteSchedStartDate (java.util.Date dteSchedStartDate) {
		this.dteSchedStartDate = dteSchedStartDate;
	}



	/**
	 * Return the value associated with the column: numQTYInvoiced
	 */
	public java.math.BigDecimal getNumQTYInvoiced () {
		return numQTYInvoiced;
	}

	/**
	 * Set the value related to the column: numQTYInvoiced
	 * @param numQTYInvoiced the numQTYInvoiced value
	 */
	public void setNumQTYInvoiced (java.math.BigDecimal numQTYInvoiced) {
		this.numQTYInvoiced = numQTYInvoiced;
	}



	/**
	 * Return the value associated with the column: siProfitRecMethod
	 */
	public java.lang.Short getSiProfitRecMethod () {
		return siProfitRecMethod;
	}

	/**
	 * Set the value related to the column: siProfitRecMethod
	 * @param siProfitRecMethod the siProfitRecMethod value
	 */
	public void setSiProfitRecMethod (java.lang.Short siProfitRecMethod) {
		this.siProfitRecMethod = siProfitRecMethod;
	}



	/**
	 * Return the value associated with the column: numQuantityToInv
	 */
	public java.math.BigDecimal getNumQuantityToInv () {
		return numQuantityToInv;
	}

	/**
	 * Set the value related to the column: numQuantityToInv
	 * @param numQuantityToInv the numQuantityToInv value
	 */
	public void setNumQuantityToInv (java.math.BigDecimal numQuantityToInv) {
		this.numQuantityToInv = numQuantityToInv;
	}



	/**
	 * Return the value associated with the column: numEstimatedQTY
	 */
	public java.math.BigDecimal getNumEstimatedQTY () {
		return numEstimatedQTY;
	}

	/**
	 * Set the value related to the column: numEstimatedQTY
	 * @param numEstimatedQTY the numEstimatedQTY value
	 */
	public void setNumEstimatedQTY (java.math.BigDecimal numEstimatedQTY) {
		this.numEstimatedQTY = numEstimatedQTY;
	}



	/**
	 * Return the value associated with the column: numRetainPercent
	 */
	public java.math.BigDecimal getNumRetainPercent () {
		return numRetainPercent;
	}

	/**
	 * Set the value related to the column: numRetainPercent
	 * @param numRetainPercent the numRetainPercent value
	 */
	public void setNumRetainPercent (java.math.BigDecimal numRetainPercent) {
		this.numRetainPercent = numRetainPercent;
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
	 * Return the value associated with the column: dteActualStartDate
	 */
	public java.util.Date getDteActualStartDate () {
		return dteActualStartDate;
	}

	/**
	 * Set the value related to the column: dteActualStartDate
	 * @param dteActualStartDate the dteActualStartDate value
	 */
	public void setDteActualStartDate (java.util.Date dteActualStartDate) {
		this.dteActualStartDate = dteActualStartDate;
	}



	/**
	 * Return the value associated with the column: numSalesRecognized
	 */
	public java.math.BigDecimal getNumSalesRecognized () {
		return numSalesRecognized;
	}

	/**
	 * Set the value related to the column: numSalesRecognized
	 * @param numSalesRecognized the numSalesRecognized value
	 */
	public void setNumSalesRecognized (java.math.BigDecimal numSalesRecognized) {
		this.numSalesRecognized = numSalesRecognized;
	}



	/**
	 * Return the value associated with the column: tiCreatePO
	 */
	public java.lang.Byte getTiCreatePO () {
		return tiCreatePO;
	}

	/**
	 * Set the value related to the column: tiCreatePO
	 * @param tiCreatePO the tiCreatePO value
	 */
	public void setTiCreatePO (java.lang.Byte tiCreatePO) {
		this.tiCreatePO = tiCreatePO;
	}



	/**
	 * Return the value associated with the column: numRevisedEmpCstRt
	 */
	public java.math.BigDecimal getNumRevisedEmpCstRt () {
		return numRevisedEmpCstRt;
	}

	/**
	 * Set the value related to the column: numRevisedEmpCstRt
	 * @param numRevisedEmpCstRt the numRevisedEmpCstRt value
	 */
	public void setNumRevisedEmpCstRt (java.math.BigDecimal numRevisedEmpCstRt) {
		this.numRevisedEmpCstRt = numRevisedEmpCstRt;
	}



	/**
	 * Return the value associated with the column: numActualQuantity
	 */
	public java.math.BigDecimal getNumActualQuantity () {
		return numActualQuantity;
	}

	/**
	 * Set the value related to the column: numActualQuantity
	 * @param numActualQuantity the numActualQuantity value
	 */
	public void setNumActualQuantity (java.math.BigDecimal numActualQuantity) {
		this.numActualQuantity = numActualQuantity;
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
	 * Return the value associated with the column: chrDescription
	 */
	public java.lang.String getChrDescription () {
		return chrDescription;
	}

	/**
	 * Set the value related to the column: chrDescription
	 * @param chrDescription the chrDescription value
	 */
	public void setChrDescription (java.lang.String chrDescription) {
		this.chrDescription = chrDescription;
	}



	/**
	 * Return the value associated with the column: numJobTRXNEstCost
	 */
	public java.math.BigDecimal getNumJobTRXNEstCost () {
		return numJobTRXNEstCost;
	}

	/**
	 * Set the value related to the column: numJobTRXNEstCost
	 * @param numJobTRXNEstCost the numJobTRXNEstCost value
	 */
	public void setNumJobTRXNEstCost (java.math.BigDecimal numJobTRXNEstCost) {
		this.numJobTRXNEstCost = numJobTRXNEstCost;
	}



	/**
	 * Return the value associated with the column: numHoursBilled
	 */
	public java.math.BigDecimal getNumHoursBilled () {
		return numHoursBilled;
	}

	/**
	 * Set the value related to the column: numHoursBilled
	 * @param numHoursBilled the numHoursBilled value
	 */
	public void setNumHoursBilled (java.math.BigDecimal numHoursBilled) {
		this.numHoursBilled = numHoursBilled;
	}



	/**
	 * Return the value associated with the column: numJobTRXNActlCost
	 */
	public java.math.BigDecimal getNumJobTRXNActlCost () {
		return numJobTRXNActlCost;
	}

	/**
	 * Set the value related to the column: numJobTRXNActlCost
	 * @param numJobTRXNActlCost the numJobTRXNActlCost value
	 */
	public void setNumJobTRXNActlCost (java.math.BigDecimal numJobTRXNActlCost) {
		this.numJobTRXNActlCost = numJobTRXNActlCost;
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
	 * Return the value associated with the column: numNewForcastCosts
	 */
	public java.math.BigDecimal getNumNewForcastCosts () {
		return numNewForcastCosts;
	}

	/**
	 * Set the value related to the column: numNewForcastCosts
	 * @param numNewForcastCosts the numNewForcastCosts value
	 */
	public void setNumNewForcastCosts (java.math.BigDecimal numNewForcastCosts) {
		this.numNewForcastCosts = numNewForcastCosts;
	}



	/**
	 * Return the value associated with the column: numRetainAmount
	 */
	public java.math.BigDecimal getNumRetainAmount () {
		return numRetainAmount;
	}

	/**
	 * Set the value related to the column: numRetainAmount
	 * @param numRetainAmount the numRetainAmount value
	 */
	public void setNumRetainAmount (java.math.BigDecimal numRetainAmount) {
		this.numRetainAmount = numRetainAmount;
	}



	/**
	 * Return the value associated with the column: numJobTRXNRvEstSal
	 */
	public java.math.BigDecimal getNumJobTRXNRvEstSal () {
		return numJobTRXNRvEstSal;
	}

	/**
	 * Set the value related to the column: numJobTRXNRvEstSal
	 * @param numJobTRXNRvEstSal the numJobTRXNRvEstSal value
	 */
	public void setNumJobTRXNRvEstSal (java.math.BigDecimal numJobTRXNRvEstSal) {
		this.numJobTRXNRvEstSal = numJobTRXNRvEstSal;
	}



	/**
	 * Return the value associated with the column: numChargeOutRate
	 */
	public java.math.BigDecimal getNumChargeOutRate () {
		return numChargeOutRate;
	}

	/**
	 * Set the value related to the column: numChargeOutRate
	 * @param numChargeOutRate the numChargeOutRate value
	 */
	public void setNumChargeOutRate (java.math.BigDecimal numChargeOutRate) {
		this.numChargeOutRate = numChargeOutRate;
	}



	/**
	 * Return the value associated with the column: numEmployeeCstRate
	 */
	public java.math.BigDecimal getNumEmployeeCstRate () {
		return numEmployeeCstRate;
	}

	/**
	 * Set the value related to the column: numEmployeeCstRate
	 * @param numEmployeeCstRate the numEmployeeCstRate value
	 */
	public void setNumEmployeeCstRate (java.math.BigDecimal numEmployeeCstRate) {
		this.numEmployeeCstRate = numEmployeeCstRate;
	}



	/**
	 * Return the value associated with the column: numLineSeqNumber
	 */
	public java.math.BigDecimal getNumLineSeqNumber () {
		return numLineSeqNumber;
	}

	/**
	 * Set the value related to the column: numLineSeqNumber
	 * @param numLineSeqNumber the numLineSeqNumber value
	 */
	public void setNumLineSeqNumber (java.math.BigDecimal numLineSeqNumber) {
		this.numLineSeqNumber = numLineSeqNumber;
	}



	/**
	 * Return the value associated with the column: numMarkupPercent
	 */
	public java.math.BigDecimal getNumMarkupPercent () {
		return numMarkupPercent;
	}

	/**
	 * Set the value related to the column: numMarkupPercent
	 * @param numMarkupPercent the numMarkupPercent value
	 */
	public void setNumMarkupPercent (java.math.BigDecimal numMarkupPercent) {
		this.numMarkupPercent = numMarkupPercent;
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
	 * Return the value associated with the column: numRecoverablesAmt
	 */
	public java.math.BigDecimal getNumRecoverablesAmt () {
		return numRecoverablesAmt;
	}

	/**
	 * Set the value related to the column: numRecoverablesAmt
	 * @param numRecoverablesAmt the numRecoverablesAmt value
	 */
	public void setNumRecoverablesAmt (java.math.BigDecimal numRecoverablesAmt) {
		this.numRecoverablesAmt = numRecoverablesAmt;
	}



	/**
	 * Return the value associated with the column: intEmployeeKey
	 */
	public java.lang.Integer getIntEmployeeKey () {
		return intEmployeeKey;
	}

	/**
	 * Set the value related to the column: intEmployeeKey
	 * @param intEmployeeKey the intEmployeeKey value
	 */
	public void setIntEmployeeKey (java.lang.Integer intEmployeeKey) {
		this.intEmployeeKey = intEmployeeKey;
	}



	/**
	 * Return the value associated with the column: dtePromisedDate
	 */
	public java.util.Date getDtePromisedDate () {
		return dtePromisedDate;
	}

	/**
	 * Set the value related to the column: dtePromisedDate
	 * @param dtePromisedDate the dtePromisedDate value
	 */
	public void setDtePromisedDate (java.util.Date dtePromisedDate) {
		this.dtePromisedDate = dtePromisedDate;
	}



	/**
	 * Return the value associated with the column: tiPosted
	 */
	public java.lang.Short getTiPosted () {
		return tiPosted;
	}

	/**
	 * Set the value related to the column: tiPosted
	 * @param tiPosted the tiPosted value
	 */
	public void setTiPosted (java.lang.Short tiPosted) {
		this.tiPosted = tiPosted;
	}



	/**
	 * Return the value associated with the column: numLastForcastCost
	 */
	public java.math.BigDecimal getNumLastForcastCost () {
		return numLastForcastCost;
	}

	/**
	 * Set the value related to the column: numLastForcastCost
	 * @param numLastForcastCost the numLastForcastCost value
	 */
	public void setNumLastForcastCost (java.math.BigDecimal numLastForcastCost) {
		this.numLastForcastCost = numLastForcastCost;
	}



	/**
	 * Return the value associated with the column: numPercentComplete
	 */
	public java.math.BigDecimal getNumPercentComplete () {
		return numPercentComplete;
	}

	/**
	 * Set the value related to the column: numPercentComplete
	 * @param numPercentComplete the numPercentComplete value
	 */
	public void setNumPercentComplete (java.math.BigDecimal numPercentComplete) {
		this.numPercentComplete = numPercentComplete;
	}



	/**
	 * Return the value associated with the column: dteSchedComplete
	 */
	public java.util.Date getDteSchedComplete () {
		return dteSchedComplete;
	}

	/**
	 * Set the value related to the column: dteSchedComplete
	 * @param dteSchedComplete the dteSchedComplete value
	 */
	public void setDteSchedComplete (java.util.Date dteSchedComplete) {
		this.dteSchedComplete = dteSchedComplete;
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
	 * Return the value associated with the column: numJobTRXNWOCost
	 */
	public java.math.BigDecimal getNumJobTRXNWOCost () {
		return numJobTRXNWOCost;
	}

	/**
	 * Set the value related to the column: numJobTRXNWOCost
	 * @param numJobTRXNWOCost the numJobTRXNWOCost value
	 */
	public void setNumJobTRXNWOCost (java.math.BigDecimal numJobTRXNWOCost) {
		this.numJobTRXNWOCost = numJobTRXNWOCost;
	}



	/**
	 * Return the value associated with the column: numRevisedEstQTY
	 */
	public java.math.BigDecimal getNumRevisedEstQTY () {
		return numRevisedEstQTY;
	}

	/**
	 * Set the value related to the column: numRevisedEstQTY
	 * @param numRevisedEstQTY the numRevisedEstQTY value
	 */
	public void setNumRevisedEstQTY (java.math.BigDecimal numRevisedEstQTY) {
		this.numRevisedEstQTY = numRevisedEstQTY;
	}



	/**
	 * Return the value associated with the column: numJTDCommitedCsts
	 */
	public java.math.BigDecimal getNumJTDCommitedCsts () {
		return numJTDCommitedCsts;
	}

	/**
	 * Set the value related to the column: numJTDCommitedCsts
	 * @param numJTDCommitedCsts the numJTDCommitedCsts value
	 */
	public void setNumJTDCommitedCsts (java.math.BigDecimal numJTDCommitedCsts) {
		this.numJTDCommitedCsts = numJTDCommitedCsts;
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
	 * Return the value associated with the column: numNewForcastSales
	 */
	public java.math.BigDecimal getNumNewForcastSales () {
		return numNewForcastSales;
	}

	/**
	 * Set the value related to the column: numNewForcastSales
	 * @param numNewForcastSales the numNewForcastSales value
	 */
	public void setNumNewForcastSales (java.math.BigDecimal numNewForcastSales) {
		this.numNewForcastSales = numNewForcastSales;
	}



	/**
	 * Return the value associated with the column: intInvDescrKey
	 */
	public java.lang.Integer getIntInvDescrKey () {
		return intInvDescrKey;
	}

	/**
	 * Set the value related to the column: intInvDescrKey
	 * @param intInvDescrKey the intInvDescrKey value
	 */
	public void setIntInvDescrKey (java.lang.Integer intInvDescrKey) {
		this.intInvDescrKey = intInvDescrKey;
	}



	/**
	 * Return the value associated with the column: numJobTRXNRvEstCst
	 */
	public java.math.BigDecimal getNumJobTRXNRvEstCst () {
		return numJobTRXNRvEstCst;
	}

	/**
	 * Set the value related to the column: numJobTRXNRvEstCst
	 * @param numJobTRXNRvEstCst the numJobTRXNRvEstCst value
	 */
	public void setNumJobTRXNRvEstCst (java.math.BigDecimal numJobTRXNRvEstCst) {
		this.numJobTRXNRvEstCst = numJobTRXNRvEstCst;
	}



	/**
	 * Return the value associated with the column: numJobTRXNActlSale
	 */
	public java.math.BigDecimal getNumJobTRXNActlSale () {
		return numJobTRXNActlSale;
	}

	/**
	 * Set the value related to the column: numJobTRXNActlSale
	 * @param numJobTRXNActlSale the numJobTRXNActlSale value
	 */
	public void setNumJobTRXNActlSale (java.math.BigDecimal numJobTRXNActlSale) {
		this.numJobTRXNActlSale = numJobTRXNActlSale;
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



	/**
	 * Return the value associated with the column: numCostsRecognized
	 */
	public java.math.BigDecimal getNumCostsRecognized () {
		return numCostsRecognized;
	}

	/**
	 * Set the value related to the column: numCostsRecognized
	 * @param numCostsRecognized the numCostsRecognized value
	 */
	public void setNumCostsRecognized (java.math.BigDecimal numCostsRecognized) {
		this.numCostsRecognized = numCostsRecognized;
	}



	/**
	 * Return the value associated with the column: numJobTRXNEstSale
	 */
	public java.math.BigDecimal getNumJobTRXNEstSale () {
		return numJobTRXNEstSale;
	}

	/**
	 * Set the value related to the column: numJobTRXNEstSale
	 * @param numJobTRXNEstSale the numJobTRXNEstSale value
	 */
	public void setNumJobTRXNEstSale (java.math.BigDecimal numJobTRXNEstSale) {
		this.numJobTRXNEstSale = numJobTRXNEstSale;
	}



	/**
	 * Return the value associated with the column: numMarkup
	 */
	public java.math.BigDecimal getNumMarkup () {
		return numMarkup;
	}

	/**
	 * Set the value related to the column: numMarkup
	 * @param numMarkup the numMarkup value
	 */
	public void setNumMarkup (java.math.BigDecimal numMarkup) {
		this.numMarkup = numMarkup;
	}



	/**
	 * Return the value associated with the column: tiWriteOff
	 */
	public java.lang.Short getTiWriteOff () {
		return tiWriteOff;
	}

	/**
	 * Set the value related to the column: tiWriteOff
	 * @param tiWriteOff the tiWriteOff value
	 */
	public void setTiWriteOff (java.lang.Short tiWriteOff) {
		this.tiWriteOff = tiWriteOff;
	}



	/**
	 * Return the value associated with the column: numJobTRXNWOSale
	 */
	public java.math.BigDecimal getNumJobTRXNWOSale () {
		return numJobTRXNWOSale;
	}

	/**
	 * Set the value related to the column: numJobTRXNWOSale
	 * @param numJobTRXNWOSale the numJobTRXNWOSale value
	 */
	public void setNumJobTRXNWOSale (java.math.BigDecimal numJobTRXNWOSale) {
		this.numJobTRXNWOSale = numJobTRXNWOSale;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tpa00125)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tpa00125 tpa00125 = (com.bureaueye.beacon.model.mas500.Tpa00125) obj;
			if (null == this.getIntJobLineKey() || null == tpa00125.getIntJobLineKey()) return false;
			else return (this.getIntJobLineKey().equals(tpa00125.getIntJobLineKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIntJobLineKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIntJobLineKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}