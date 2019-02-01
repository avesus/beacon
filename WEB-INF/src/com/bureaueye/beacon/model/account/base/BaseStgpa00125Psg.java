package com.bureaueye.beacon.model.account.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the stgpa00125_psg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="stgpa00125_psg"
 */

public abstract class BaseStgpa00125Psg  implements Serializable {

	public static String REF = "Stgpa00125Psg";
	public static String PROP_PERCENT_COMPLETE = "PercentComplete";
	public static String PROP_ACTION_CODE = "ActionCode";
	public static String PROP_JOB_T_R_X_N_W_O_SALE = "JobTRXNWOSale";
	public static String PROP_MARKUP = "Markup";
	public static String PROP_RECOVERABLES_AMT = "RecoverablesAmt";
	public static String PROP_RETAIN_AMOUNT = "RetainAmount";
	public static String PROP_CREATE_P_O = "CreatePO";
	public static String PROP_J_T_D_COMMITED_CSTS = "JTDCommitedCsts";
	public static String PROP_PROCESS_STATUS = "ProcessStatus";
	public static String PROP_NEW_FORCAST_SALES = "NewForcastSales";
	public static String PROP_UNIT_MEAS_KEY = "UnitMeasKey";
	public static String PROP_CST_CLSIFICATN_D_D_L = "CstClsificatnDDL";
	public static String PROP_CHARGE_OUT_RATE = "ChargeOutRate";
	public static String PROP_PROMISED_DATE = "PromisedDate";
	public static String PROP_EMPLOYEE_KEY = "EmployeeKey";
	public static String PROP_JOB_T_R_X_N_RV_EST_CST = "JobTRXNRvEstCst";
	public static String PROP_SALES_RECOGNIZED = "SalesRecognized";
	public static String PROP_SESSION_KEY = "SessionKey";
	public static String PROP_IS_VARIATION = "IsVariation";
	public static String PROP_JOB_T_R_X_N_ACTL_SALE = "JobTRXNActlSale";
	public static String PROP_ERROR_NO = "ErrorNo";
	public static String PROP_ACTUAL_START_DATE = "ActualStartDate";
	public static String PROP_JOB_T_R_X_N_EST_SALE = "JobTRXNEstSale";
	public static String PROP_EMPLOYEE_CST_RATE = "EmployeeCstRate";
	public static String PROP_COSTS_RECOGNIZED = "CostsRecognized";
	public static String PROP_RETAIN_PERCENT = "RetainPercent";
	public static String PROP_ERROR_MSG = "ErrorMsg";
	public static String PROP_POSTED = "Posted";
	public static String PROP_VEND_KEY = "VendKey";
	public static String PROP_WRITE_OFF = "WriteOff";
	public static String PROP_PHASE_KEY = "PhaseKey";
	public static String PROP_ESTIMATED_QTY = "EstimatedQty";
	public static String PROP_ITEM_I_D = "ItemID";
	public static String PROP_REVISED_CHG_OUT_RT = "RevisedChgOutRt";
	public static String PROP_EMPLOYEE_NUMBER = "EmployeeNumber";
	public static String PROP_JOB_T_R_X_N_EST_COST = "JobTRXNEstCost";
	public static String PROP_HOURS_BILLED = "HoursBilled";
	public static String PROP_UNIT_MEAS_I_D = "UnitMeasID";
	public static String PROP_TASK_KEY = "TaskKey";
	public static String PROP_ACTUAL_QUANTITY = "ActualQuantity";
	public static String PROP_JOB_KEY = "JobKey";
	public static String PROP_JOB_T_R_X_N_RV_EST_SAL = "JobTRXNRvEstSal";
	public static String PROP_SCHED_START_DATE = "SchedStartDate";
	public static String PROP_LINE_SEQ_NUMBER = "LineSeqNumber";
	public static String PROP_ACT_COMPLETE_DATE = "ActCompleteDate";
	public static String PROP_REVISED_EMP_CST_RT = "RevisedEmpCstRt";
	public static String PROP_RECOVERABLES = "Recoverables";
	public static String PROP_JOB_T_R_X_N_W_O_COST = "JobTRXNWOCost";
	public static String PROP_LAST_FORCAST_COST = "LastForcastCost";
	public static String PROP_VEND_I_D = "VendID";
	public static String PROP_QTY_INVOICED = "QtyInvoiced";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_JOB_NUMBER = "JobNumber";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_ROW_KEY = "RowKey";
	public static String PROP_JOB_T_R_X_N_ACTL_COST = "JobTRXNActlCost";
	public static String PROP_REVISED_EST_QTY = "RevisedEstQty";
	public static String PROP_NEW_FORCAST_COSTS = "NewForcastCosts";
	public static String PROP_JOB_LINE_KEY = "JobLineKey";
	public static String PROP_QUANTITY_TO_INV = "QuantityToInv";
	public static String PROP_ITEM_KEY = "ItemKey";
	public static String PROP_TASK_NUMBER = "TaskNumber";
	public static String PROP_JOB_ROW_KEY = "JobRowKey";
	public static String PROP_INV_DESCR_I_D = "InvDescrID";
	public static String PROP_MARKUP_PERCENT = "MarkupPercent";
	public static String PROP_SCHED_COMPLETE = "SchedComplete";
	public static String PROP_PROFIT_REC_METHOD = "ProfitRecMethod";
	public static String PROP_INV_DESCR_KEY = "InvDescrKey";
	public static String PROP_LAST_FORCAST_SALE = "LastForcastSale";
	public static String PROP_PHASE_NUMBER = "PhaseNumber";


	// constructors
	public BaseStgpa00125Psg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStgpa00125Psg (java.lang.Integer rowKey) {
		this.setRowKey(rowKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer rowKey;

	// fields
	private java.math.BigDecimal percentComplete;
	private java.lang.String actionCode;
	private java.math.BigDecimal jobTRXNWOSale;
	private java.math.BigDecimal markup;
	private java.math.BigDecimal recoverablesAmt;
	private java.math.BigDecimal retainAmount;
	private java.lang.Byte createPO;
	private java.math.BigDecimal jTDCommitedCsts;
	private java.lang.Integer processStatus;
	private java.math.BigDecimal newForcastSales;
	private java.lang.Integer unitMeasKey;
	private java.lang.Short cstClsificatnDDL;
	private java.math.BigDecimal chargeOutRate;
	private java.lang.Integer employeeKey;
	private java.util.Date promisedDate;
	private java.math.BigDecimal jobTRXNRvEstCst;
	private java.lang.Integer sessionKey;
	private java.math.BigDecimal salesRecognized;
	private java.lang.Short isVariation;
	private java.math.BigDecimal jobTRXNActlSale;
	private java.lang.Integer errorNo;
	private java.util.Date actualStartDate;
	private java.math.BigDecimal costsRecognized;
	private java.math.BigDecimal employeeCstRate;
	private java.math.BigDecimal jobTRXNEstSale;
	private java.math.BigDecimal retainPercent;
	private java.lang.String errorMsg;
	private java.lang.Short posted;
	private java.lang.Integer vendKey;
	private java.lang.Short writeOff;
	private java.lang.Integer phaseKey;
	private java.math.BigDecimal estimatedQty;
	private java.lang.String itemID;
	private java.math.BigDecimal revisedChgOutRt;
	private java.lang.String employeeNumber;
	private java.math.BigDecimal jobTRXNEstCost;
	private java.math.BigDecimal hoursBilled;
	private java.lang.String unitMeasID;
	private java.lang.Integer taskKey;
	private java.math.BigDecimal actualQuantity;
	private java.lang.Integer jobKey;
	private java.math.BigDecimal jobTRXNRvEstSal;
	private java.util.Date schedStartDate;
	private java.math.BigDecimal lineSeqNumber;
	private java.util.Date actCompleteDate;
	private java.math.BigDecimal revisedEmpCstRt;
	private java.math.BigDecimal recoverables;
	private java.math.BigDecimal jobTRXNWOCost;
	private java.math.BigDecimal lastForcastCost;
	private java.lang.String vendID;
	private java.math.BigDecimal qtyInvoiced;
	private java.lang.String jobNumber;
	private java.lang.String description;
	private java.lang.String companyID;
	private java.math.BigDecimal revisedEstQty;
	private java.math.BigDecimal jobTRXNActlCost;
	private java.math.BigDecimal newForcastCosts;
	private java.lang.Integer jobLineKey;
	private java.lang.Integer itemKey;
	private java.math.BigDecimal quantityToInv;
	private java.lang.String taskNumber;
	private java.lang.Integer jobRowKey;
	private java.lang.String invDescrID;
	private java.math.BigDecimal markupPercent;
	private java.lang.Short profitRecMethod;
	private java.util.Date schedComplete;
	private java.lang.Integer invDescrKey;
	private java.lang.String phaseNumber;
	private java.math.BigDecimal lastForcastSale;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="RowKey"
     */
	public java.lang.Integer getRowKey () {
		return rowKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param rowKey the new ID
	 */
	public void setRowKey (java.lang.Integer rowKey) {
		this.rowKey = rowKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PercentComplete
	 */
	public java.math.BigDecimal getPercentComplete () {
		return percentComplete;
	}

	/**
	 * Set the value related to the column: PercentComplete
	 * @param percentComplete the PercentComplete value
	 */
	public void setPercentComplete (java.math.BigDecimal percentComplete) {
		this.percentComplete = percentComplete;
	}



	/**
	 * Return the value associated with the column: ActionCode
	 */
	public java.lang.String getActionCode () {
		return actionCode;
	}

	/**
	 * Set the value related to the column: ActionCode
	 * @param actionCode the ActionCode value
	 */
	public void setActionCode (java.lang.String actionCode) {
		this.actionCode = actionCode;
	}



	/**
	 * Return the value associated with the column: JobTRXNWOSale
	 */
	public java.math.BigDecimal getJobTRXNWOSale () {
		return jobTRXNWOSale;
	}

	/**
	 * Set the value related to the column: JobTRXNWOSale
	 * @param jobTRXNWOSale the JobTRXNWOSale value
	 */
	public void setJobTRXNWOSale (java.math.BigDecimal jobTRXNWOSale) {
		this.jobTRXNWOSale = jobTRXNWOSale;
	}



	/**
	 * Return the value associated with the column: Markup
	 */
	public java.math.BigDecimal getMarkup () {
		return markup;
	}

	/**
	 * Set the value related to the column: Markup
	 * @param markup the Markup value
	 */
	public void setMarkup (java.math.BigDecimal markup) {
		this.markup = markup;
	}



	/**
	 * Return the value associated with the column: RecoverablesAmt
	 */
	public java.math.BigDecimal getRecoverablesAmt () {
		return recoverablesAmt;
	}

	/**
	 * Set the value related to the column: RecoverablesAmt
	 * @param recoverablesAmt the RecoverablesAmt value
	 */
	public void setRecoverablesAmt (java.math.BigDecimal recoverablesAmt) {
		this.recoverablesAmt = recoverablesAmt;
	}



	/**
	 * Return the value associated with the column: RetainAmount
	 */
	public java.math.BigDecimal getRetainAmount () {
		return retainAmount;
	}

	/**
	 * Set the value related to the column: RetainAmount
	 * @param retainAmount the RetainAmount value
	 */
	public void setRetainAmount (java.math.BigDecimal retainAmount) {
		this.retainAmount = retainAmount;
	}



	/**
	 * Return the value associated with the column: CreatePO
	 */
	public java.lang.Byte getCreatePO () {
		return createPO;
	}

	/**
	 * Set the value related to the column: CreatePO
	 * @param createPO the CreatePO value
	 */
	public void setCreatePO (java.lang.Byte createPO) {
		this.createPO = createPO;
	}



	/**
	 * Return the value associated with the column: JTDCommitedCsts
	 */
	public java.math.BigDecimal getJTDCommitedCsts () {
		return jTDCommitedCsts;
	}

	/**
	 * Set the value related to the column: JTDCommitedCsts
	 * @param jTDCommitedCsts the JTDCommitedCsts value
	 */
	public void setJTDCommitedCsts (java.math.BigDecimal jTDCommitedCsts) {
		this.jTDCommitedCsts = jTDCommitedCsts;
	}



	/**
	 * Return the value associated with the column: ProcessStatus
	 */
	public java.lang.Integer getProcessStatus () {
		return processStatus;
	}

	/**
	 * Set the value related to the column: ProcessStatus
	 * @param processStatus the ProcessStatus value
	 */
	public void setProcessStatus (java.lang.Integer processStatus) {
		this.processStatus = processStatus;
	}



	/**
	 * Return the value associated with the column: NewForcastSales
	 */
	public java.math.BigDecimal getNewForcastSales () {
		return newForcastSales;
	}

	/**
	 * Set the value related to the column: NewForcastSales
	 * @param newForcastSales the NewForcastSales value
	 */
	public void setNewForcastSales (java.math.BigDecimal newForcastSales) {
		this.newForcastSales = newForcastSales;
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
	 * Return the value associated with the column: CstClsificatnDDL
	 */
	public java.lang.Short getCstClsificatnDDL () {
		return cstClsificatnDDL;
	}

	/**
	 * Set the value related to the column: CstClsificatnDDL
	 * @param cstClsificatnDDL the CstClsificatnDDL value
	 */
	public void setCstClsificatnDDL (java.lang.Short cstClsificatnDDL) {
		this.cstClsificatnDDL = cstClsificatnDDL;
	}



	/**
	 * Return the value associated with the column: ChargeOutRate
	 */
	public java.math.BigDecimal getChargeOutRate () {
		return chargeOutRate;
	}

	/**
	 * Set the value related to the column: ChargeOutRate
	 * @param chargeOutRate the ChargeOutRate value
	 */
	public void setChargeOutRate (java.math.BigDecimal chargeOutRate) {
		this.chargeOutRate = chargeOutRate;
	}



	/**
	 * Return the value associated with the column: EmployeeKey
	 */
	public java.lang.Integer getEmployeeKey () {
		return employeeKey;
	}

	/**
	 * Set the value related to the column: EmployeeKey
	 * @param employeeKey the EmployeeKey value
	 */
	public void setEmployeeKey (java.lang.Integer employeeKey) {
		this.employeeKey = employeeKey;
	}



	/**
	 * Return the value associated with the column: PromisedDate
	 */
	public java.util.Date getPromisedDate () {
		return promisedDate;
	}

	/**
	 * Set the value related to the column: PromisedDate
	 * @param promisedDate the PromisedDate value
	 */
	public void setPromisedDate (java.util.Date promisedDate) {
		this.promisedDate = promisedDate;
	}



	/**
	 * Return the value associated with the column: JobTRXNRvEstCst
	 */
	public java.math.BigDecimal getJobTRXNRvEstCst () {
		return jobTRXNRvEstCst;
	}

	/**
	 * Set the value related to the column: JobTRXNRvEstCst
	 * @param jobTRXNRvEstCst the JobTRXNRvEstCst value
	 */
	public void setJobTRXNRvEstCst (java.math.BigDecimal jobTRXNRvEstCst) {
		this.jobTRXNRvEstCst = jobTRXNRvEstCst;
	}



	/**
	 * Return the value associated with the column: SessionKey
	 */
	public java.lang.Integer getSessionKey () {
		return sessionKey;
	}

	/**
	 * Set the value related to the column: SessionKey
	 * @param sessionKey the SessionKey value
	 */
	public void setSessionKey (java.lang.Integer sessionKey) {
		this.sessionKey = sessionKey;
	}



	/**
	 * Return the value associated with the column: SalesRecognized
	 */
	public java.math.BigDecimal getSalesRecognized () {
		return salesRecognized;
	}

	/**
	 * Set the value related to the column: SalesRecognized
	 * @param salesRecognized the SalesRecognized value
	 */
	public void setSalesRecognized (java.math.BigDecimal salesRecognized) {
		this.salesRecognized = salesRecognized;
	}



	/**
	 * Return the value associated with the column: IsVariation
	 */
	public java.lang.Short getIsVariation () {
		return isVariation;
	}

	/**
	 * Set the value related to the column: IsVariation
	 * @param isVariation the IsVariation value
	 */
	public void setIsVariation (java.lang.Short isVariation) {
		this.isVariation = isVariation;
	}



	/**
	 * Return the value associated with the column: JobTRXNActlSale
	 */
	public java.math.BigDecimal getJobTRXNActlSale () {
		return jobTRXNActlSale;
	}

	/**
	 * Set the value related to the column: JobTRXNActlSale
	 * @param jobTRXNActlSale the JobTRXNActlSale value
	 */
	public void setJobTRXNActlSale (java.math.BigDecimal jobTRXNActlSale) {
		this.jobTRXNActlSale = jobTRXNActlSale;
	}



	/**
	 * Return the value associated with the column: ErrorNo
	 */
	public java.lang.Integer getErrorNo () {
		return errorNo;
	}

	/**
	 * Set the value related to the column: ErrorNo
	 * @param errorNo the ErrorNo value
	 */
	public void setErrorNo (java.lang.Integer errorNo) {
		this.errorNo = errorNo;
	}



	/**
	 * Return the value associated with the column: ActualStartDate
	 */
	public java.util.Date getActualStartDate () {
		return actualStartDate;
	}

	/**
	 * Set the value related to the column: ActualStartDate
	 * @param actualStartDate the ActualStartDate value
	 */
	public void setActualStartDate (java.util.Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}



	/**
	 * Return the value associated with the column: CostsRecognized
	 */
	public java.math.BigDecimal getCostsRecognized () {
		return costsRecognized;
	}

	/**
	 * Set the value related to the column: CostsRecognized
	 * @param costsRecognized the CostsRecognized value
	 */
	public void setCostsRecognized (java.math.BigDecimal costsRecognized) {
		this.costsRecognized = costsRecognized;
	}



	/**
	 * Return the value associated with the column: EmployeeCstRate
	 */
	public java.math.BigDecimal getEmployeeCstRate () {
		return employeeCstRate;
	}

	/**
	 * Set the value related to the column: EmployeeCstRate
	 * @param employeeCstRate the EmployeeCstRate value
	 */
	public void setEmployeeCstRate (java.math.BigDecimal employeeCstRate) {
		this.employeeCstRate = employeeCstRate;
	}



	/**
	 * Return the value associated with the column: JobTRXNEstSale
	 */
	public java.math.BigDecimal getJobTRXNEstSale () {
		return jobTRXNEstSale;
	}

	/**
	 * Set the value related to the column: JobTRXNEstSale
	 * @param jobTRXNEstSale the JobTRXNEstSale value
	 */
	public void setJobTRXNEstSale (java.math.BigDecimal jobTRXNEstSale) {
		this.jobTRXNEstSale = jobTRXNEstSale;
	}



	/**
	 * Return the value associated with the column: RetainPercent
	 */
	public java.math.BigDecimal getRetainPercent () {
		return retainPercent;
	}

	/**
	 * Set the value related to the column: RetainPercent
	 * @param retainPercent the RetainPercent value
	 */
	public void setRetainPercent (java.math.BigDecimal retainPercent) {
		this.retainPercent = retainPercent;
	}



	/**
	 * Return the value associated with the column: ErrorMsg
	 */
	public java.lang.String getErrorMsg () {
		return errorMsg;
	}

	/**
	 * Set the value related to the column: ErrorMsg
	 * @param errorMsg the ErrorMsg value
	 */
	public void setErrorMsg (java.lang.String errorMsg) {
		this.errorMsg = errorMsg;
	}



	/**
	 * Return the value associated with the column: Posted
	 */
	public java.lang.Short getPosted () {
		return posted;
	}

	/**
	 * Set the value related to the column: Posted
	 * @param posted the Posted value
	 */
	public void setPosted (java.lang.Short posted) {
		this.posted = posted;
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
	 * Return the value associated with the column: WriteOff
	 */
	public java.lang.Short getWriteOff () {
		return writeOff;
	}

	/**
	 * Set the value related to the column: WriteOff
	 * @param writeOff the WriteOff value
	 */
	public void setWriteOff (java.lang.Short writeOff) {
		this.writeOff = writeOff;
	}



	/**
	 * Return the value associated with the column: PhaseKey
	 */
	public java.lang.Integer getPhaseKey () {
		return phaseKey;
	}

	/**
	 * Set the value related to the column: PhaseKey
	 * @param phaseKey the PhaseKey value
	 */
	public void setPhaseKey (java.lang.Integer phaseKey) {
		this.phaseKey = phaseKey;
	}



	/**
	 * Return the value associated with the column: EstimatedQty
	 */
	public java.math.BigDecimal getEstimatedQty () {
		return estimatedQty;
	}

	/**
	 * Set the value related to the column: EstimatedQty
	 * @param estimatedQty the EstimatedQty value
	 */
	public void setEstimatedQty (java.math.BigDecimal estimatedQty) {
		this.estimatedQty = estimatedQty;
	}



	/**
	 * Return the value associated with the column: ItemID
	 */
	public java.lang.String getItemID () {
		return itemID;
	}

	/**
	 * Set the value related to the column: ItemID
	 * @param itemID the ItemID value
	 */
	public void setItemID (java.lang.String itemID) {
		this.itemID = itemID;
	}



	/**
	 * Return the value associated with the column: RevisedChgOutRt
	 */
	public java.math.BigDecimal getRevisedChgOutRt () {
		return revisedChgOutRt;
	}

	/**
	 * Set the value related to the column: RevisedChgOutRt
	 * @param revisedChgOutRt the RevisedChgOutRt value
	 */
	public void setRevisedChgOutRt (java.math.BigDecimal revisedChgOutRt) {
		this.revisedChgOutRt = revisedChgOutRt;
	}



	/**
	 * Return the value associated with the column: EmployeeNumber
	 */
	public java.lang.String getEmployeeNumber () {
		return employeeNumber;
	}

	/**
	 * Set the value related to the column: EmployeeNumber
	 * @param employeeNumber the EmployeeNumber value
	 */
	public void setEmployeeNumber (java.lang.String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	/**
	 * Return the value associated with the column: JobTRXNEstCost
	 */
	public java.math.BigDecimal getJobTRXNEstCost () {
		return jobTRXNEstCost;
	}

	/**
	 * Set the value related to the column: JobTRXNEstCost
	 * @param jobTRXNEstCost the JobTRXNEstCost value
	 */
	public void setJobTRXNEstCost (java.math.BigDecimal jobTRXNEstCost) {
		this.jobTRXNEstCost = jobTRXNEstCost;
	}



	/**
	 * Return the value associated with the column: HoursBilled
	 */
	public java.math.BigDecimal getHoursBilled () {
		return hoursBilled;
	}

	/**
	 * Set the value related to the column: HoursBilled
	 * @param hoursBilled the HoursBilled value
	 */
	public void setHoursBilled (java.math.BigDecimal hoursBilled) {
		this.hoursBilled = hoursBilled;
	}



	/**
	 * Return the value associated with the column: UnitMeasID
	 */
	public java.lang.String getUnitMeasID () {
		return unitMeasID;
	}

	/**
	 * Set the value related to the column: UnitMeasID
	 * @param unitMeasID the UnitMeasID value
	 */
	public void setUnitMeasID (java.lang.String unitMeasID) {
		this.unitMeasID = unitMeasID;
	}



	/**
	 * Return the value associated with the column: TaskKey
	 */
	public java.lang.Integer getTaskKey () {
		return taskKey;
	}

	/**
	 * Set the value related to the column: TaskKey
	 * @param taskKey the TaskKey value
	 */
	public void setTaskKey (java.lang.Integer taskKey) {
		this.taskKey = taskKey;
	}



	/**
	 * Return the value associated with the column: ActualQuantity
	 */
	public java.math.BigDecimal getActualQuantity () {
		return actualQuantity;
	}

	/**
	 * Set the value related to the column: ActualQuantity
	 * @param actualQuantity the ActualQuantity value
	 */
	public void setActualQuantity (java.math.BigDecimal actualQuantity) {
		this.actualQuantity = actualQuantity;
	}



	/**
	 * Return the value associated with the column: JobKey
	 */
	public java.lang.Integer getJobKey () {
		return jobKey;
	}

	/**
	 * Set the value related to the column: JobKey
	 * @param jobKey the JobKey value
	 */
	public void setJobKey (java.lang.Integer jobKey) {
		this.jobKey = jobKey;
	}



	/**
	 * Return the value associated with the column: JobTRXNRvEstSal
	 */
	public java.math.BigDecimal getJobTRXNRvEstSal () {
		return jobTRXNRvEstSal;
	}

	/**
	 * Set the value related to the column: JobTRXNRvEstSal
	 * @param jobTRXNRvEstSal the JobTRXNRvEstSal value
	 */
	public void setJobTRXNRvEstSal (java.math.BigDecimal jobTRXNRvEstSal) {
		this.jobTRXNRvEstSal = jobTRXNRvEstSal;
	}



	/**
	 * Return the value associated with the column: SchedStartDate
	 */
	public java.util.Date getSchedStartDate () {
		return schedStartDate;
	}

	/**
	 * Set the value related to the column: SchedStartDate
	 * @param schedStartDate the SchedStartDate value
	 */
	public void setSchedStartDate (java.util.Date schedStartDate) {
		this.schedStartDate = schedStartDate;
	}



	/**
	 * Return the value associated with the column: LineSeqNumber
	 */
	public java.math.BigDecimal getLineSeqNumber () {
		return lineSeqNumber;
	}

	/**
	 * Set the value related to the column: LineSeqNumber
	 * @param lineSeqNumber the LineSeqNumber value
	 */
	public void setLineSeqNumber (java.math.BigDecimal lineSeqNumber) {
		this.lineSeqNumber = lineSeqNumber;
	}



	/**
	 * Return the value associated with the column: ActCompleteDate
	 */
	public java.util.Date getActCompleteDate () {
		return actCompleteDate;
	}

	/**
	 * Set the value related to the column: ActCompleteDate
	 * @param actCompleteDate the ActCompleteDate value
	 */
	public void setActCompleteDate (java.util.Date actCompleteDate) {
		this.actCompleteDate = actCompleteDate;
	}



	/**
	 * Return the value associated with the column: RevisedEmpCstRt
	 */
	public java.math.BigDecimal getRevisedEmpCstRt () {
		return revisedEmpCstRt;
	}

	/**
	 * Set the value related to the column: RevisedEmpCstRt
	 * @param revisedEmpCstRt the RevisedEmpCstRt value
	 */
	public void setRevisedEmpCstRt (java.math.BigDecimal revisedEmpCstRt) {
		this.revisedEmpCstRt = revisedEmpCstRt;
	}



	/**
	 * Return the value associated with the column: Recoverables
	 */
	public java.math.BigDecimal getRecoverables () {
		return recoverables;
	}

	/**
	 * Set the value related to the column: Recoverables
	 * @param recoverables the Recoverables value
	 */
	public void setRecoverables (java.math.BigDecimal recoverables) {
		this.recoverables = recoverables;
	}



	/**
	 * Return the value associated with the column: JobTRXNWOCost
	 */
	public java.math.BigDecimal getJobTRXNWOCost () {
		return jobTRXNWOCost;
	}

	/**
	 * Set the value related to the column: JobTRXNWOCost
	 * @param jobTRXNWOCost the JobTRXNWOCost value
	 */
	public void setJobTRXNWOCost (java.math.BigDecimal jobTRXNWOCost) {
		this.jobTRXNWOCost = jobTRXNWOCost;
	}



	/**
	 * Return the value associated with the column: LastForcastCost
	 */
	public java.math.BigDecimal getLastForcastCost () {
		return lastForcastCost;
	}

	/**
	 * Set the value related to the column: LastForcastCost
	 * @param lastForcastCost the LastForcastCost value
	 */
	public void setLastForcastCost (java.math.BigDecimal lastForcastCost) {
		this.lastForcastCost = lastForcastCost;
	}



	/**
	 * Return the value associated with the column: VendID
	 */
	public java.lang.String getVendID () {
		return vendID;
	}

	/**
	 * Set the value related to the column: VendID
	 * @param vendID the VendID value
	 */
	public void setVendID (java.lang.String vendID) {
		this.vendID = vendID;
	}



	/**
	 * Return the value associated with the column: QtyInvoiced
	 */
	public java.math.BigDecimal getQtyInvoiced () {
		return qtyInvoiced;
	}

	/**
	 * Set the value related to the column: QtyInvoiced
	 * @param qtyInvoiced the QtyInvoiced value
	 */
	public void setQtyInvoiced (java.math.BigDecimal qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
	}



	/**
	 * Return the value associated with the column: JobNumber
	 */
	public java.lang.String getJobNumber () {
		return jobNumber;
	}

	/**
	 * Set the value related to the column: JobNumber
	 * @param jobNumber the JobNumber value
	 */
	public void setJobNumber (java.lang.String jobNumber) {
		this.jobNumber = jobNumber;
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
	 * Return the value associated with the column: RevisedEstQty
	 */
	public java.math.BigDecimal getRevisedEstQty () {
		return revisedEstQty;
	}

	/**
	 * Set the value related to the column: RevisedEstQty
	 * @param revisedEstQty the RevisedEstQty value
	 */
	public void setRevisedEstQty (java.math.BigDecimal revisedEstQty) {
		this.revisedEstQty = revisedEstQty;
	}



	/**
	 * Return the value associated with the column: JobTRXNActlCost
	 */
	public java.math.BigDecimal getJobTRXNActlCost () {
		return jobTRXNActlCost;
	}

	/**
	 * Set the value related to the column: JobTRXNActlCost
	 * @param jobTRXNActlCost the JobTRXNActlCost value
	 */
	public void setJobTRXNActlCost (java.math.BigDecimal jobTRXNActlCost) {
		this.jobTRXNActlCost = jobTRXNActlCost;
	}



	/**
	 * Return the value associated with the column: NewForcastCosts
	 */
	public java.math.BigDecimal getNewForcastCosts () {
		return newForcastCosts;
	}

	/**
	 * Set the value related to the column: NewForcastCosts
	 * @param newForcastCosts the NewForcastCosts value
	 */
	public void setNewForcastCosts (java.math.BigDecimal newForcastCosts) {
		this.newForcastCosts = newForcastCosts;
	}



	/**
	 * Return the value associated with the column: JobLineKey
	 */
	public java.lang.Integer getJobLineKey () {
		return jobLineKey;
	}

	/**
	 * Set the value related to the column: JobLineKey
	 * @param jobLineKey the JobLineKey value
	 */
	public void setJobLineKey (java.lang.Integer jobLineKey) {
		this.jobLineKey = jobLineKey;
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
	 * Return the value associated with the column: QuantityToInv
	 */
	public java.math.BigDecimal getQuantityToInv () {
		return quantityToInv;
	}

	/**
	 * Set the value related to the column: QuantityToInv
	 * @param quantityToInv the QuantityToInv value
	 */
	public void setQuantityToInv (java.math.BigDecimal quantityToInv) {
		this.quantityToInv = quantityToInv;
	}



	/**
	 * Return the value associated with the column: TaskNumber
	 */
	public java.lang.String getTaskNumber () {
		return taskNumber;
	}

	/**
	 * Set the value related to the column: TaskNumber
	 * @param taskNumber the TaskNumber value
	 */
	public void setTaskNumber (java.lang.String taskNumber) {
		this.taskNumber = taskNumber;
	}



	/**
	 * Return the value associated with the column: JobRowKey
	 */
	public java.lang.Integer getJobRowKey () {
		return jobRowKey;
	}

	/**
	 * Set the value related to the column: JobRowKey
	 * @param jobRowKey the JobRowKey value
	 */
	public void setJobRowKey (java.lang.Integer jobRowKey) {
		this.jobRowKey = jobRowKey;
	}



	/**
	 * Return the value associated with the column: InvDescrID
	 */
	public java.lang.String getInvDescrID () {
		return invDescrID;
	}

	/**
	 * Set the value related to the column: InvDescrID
	 * @param invDescrID the InvDescrID value
	 */
	public void setInvDescrID (java.lang.String invDescrID) {
		this.invDescrID = invDescrID;
	}



	/**
	 * Return the value associated with the column: MarkupPercent
	 */
	public java.math.BigDecimal getMarkupPercent () {
		return markupPercent;
	}

	/**
	 * Set the value related to the column: MarkupPercent
	 * @param markupPercent the MarkupPercent value
	 */
	public void setMarkupPercent (java.math.BigDecimal markupPercent) {
		this.markupPercent = markupPercent;
	}



	/**
	 * Return the value associated with the column: ProfitRecMethod
	 */
	public java.lang.Short getProfitRecMethod () {
		return profitRecMethod;
	}

	/**
	 * Set the value related to the column: ProfitRecMethod
	 * @param profitRecMethod the ProfitRecMethod value
	 */
	public void setProfitRecMethod (java.lang.Short profitRecMethod) {
		this.profitRecMethod = profitRecMethod;
	}



	/**
	 * Return the value associated with the column: SchedComplete
	 */
	public java.util.Date getSchedComplete () {
		return schedComplete;
	}

	/**
	 * Set the value related to the column: SchedComplete
	 * @param schedComplete the SchedComplete value
	 */
	public void setSchedComplete (java.util.Date schedComplete) {
		this.schedComplete = schedComplete;
	}



	/**
	 * Return the value associated with the column: InvDescrKey
	 */
	public java.lang.Integer getInvDescrKey () {
		return invDescrKey;
	}

	/**
	 * Set the value related to the column: InvDescrKey
	 * @param invDescrKey the InvDescrKey value
	 */
	public void setInvDescrKey (java.lang.Integer invDescrKey) {
		this.invDescrKey = invDescrKey;
	}



	/**
	 * Return the value associated with the column: PhaseNumber
	 */
	public java.lang.String getPhaseNumber () {
		return phaseNumber;
	}

	/**
	 * Set the value related to the column: PhaseNumber
	 * @param phaseNumber the PhaseNumber value
	 */
	public void setPhaseNumber (java.lang.String phaseNumber) {
		this.phaseNumber = phaseNumber;
	}



	/**
	 * Return the value associated with the column: LastForcastSale
	 */
	public java.math.BigDecimal getLastForcastSale () {
		return lastForcastSale;
	}

	/**
	 * Set the value related to the column: LastForcastSale
	 * @param lastForcastSale the LastForcastSale value
	 */
	public void setLastForcastSale (java.math.BigDecimal lastForcastSale) {
		this.lastForcastSale = lastForcastSale;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.account.Stgpa00125Psg)) return false;
		else {
			com.bureaueye.beacon.model.account.Stgpa00125Psg stgpa00125Psg = (com.bureaueye.beacon.model.account.Stgpa00125Psg) obj;
			if (null == this.getRowKey() || null == stgpa00125Psg.getRowKey()) return false;
			else return (this.getRowKey().equals(stgpa00125Psg.getRowKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getRowKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getRowKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}