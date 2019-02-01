package com.bureaueye.beacon.model.print.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the printdtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="printdtl"
 */

public abstract class BasePrintdtl  implements Serializable {

	public static String REF = "Printdtl";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_REPORT_ID = "ReportId";
	public static String PROP_HAZARDOUS = "Hazardous";
	public static String PROP_TANK_NUMBER = "TankNumber";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ADD_INSTRUCTIONS = "AddInstructions";
	public static String PROP_REPORT_TYPE = "ReportType";
	public static String PROP_PU_PLANT_LOAD_DATE = "PuPlantLoadDate";
	public static String PROP_VESSEL = "Vessel";
	public static String PROP_EMERGENCY1 = "Emergency1";
	public static String PROP_WEIGHT_TYPE = "WeightType";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_PRINTDTL_ID = "PrintdtlId";
	public static String PROP_PU_PLANT_APPT_TIME = "PuPlantApptTime";
	public static String PROP_NUMBER_OF_TANKS = "NumberOfTanks";
	public static String PROP_JOB_NUMBER = "JobNumber";
	public static String PROP_MOVREF = "Movref";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_PICKUP_PLANT_REF = "PickupPlantRef";
	public static String PROP_ACTUAL_WEIGHT = "ActualWeight";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_MEMO_B = "MemoB";
	public static String PROP_MEMO_A = "MemoA";
	public static String PROP_ID_TYPE = "IdType";
	public static String PROP_PRINTHDR_ID = "PrinthdrId";
	public static String PROP_ACTUAL_WEIGHT2 = "ActualWeight2";
	public static String PROP_HAZARDOUS_I_M_O = "HazardousIMO";
	public static String PROP_PRODUCT_ID = "ProductId";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_SEAL_NUMBERS = "SealNumbers";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_ID = "Id";
	public static String PROP_PU_PLANT_APPT_DATE = "PuPlantApptDate";
	public static String PROP_CLASS_UN_PG_FP = "ClassUnPgFp";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BasePrintdtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrintdtl (java.lang.Integer printdtlId) {
		this.setPrintdtlId(printdtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer printdtlId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.util.Date puPlantApptDate;
	private java.util.Date systemlogdate;
	private java.lang.String idType;
	private java.lang.String tankNumber;
	private java.lang.String jobNumber;
	private java.lang.String puPlantApptTime;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String productId;
	private java.util.Date puPlantLoadDate;
	private java.lang.Integer printhdrId;
	private boolean hazardous;
	private java.lang.String memoB;
	private java.lang.String product;
	private java.lang.String createuserid;
	private java.lang.String weightType;
	private java.lang.String memoA;
	private java.lang.String classUnPgFp;
	private java.lang.String reportId;
	private java.lang.String reportType;
	private java.lang.String addInstructions;
	private java.lang.Integer numberOfTanks;
	private java.lang.Float actualWeight;
	private java.lang.String xuserid;
	private java.lang.String actualWeight2;
	private java.lang.String sealNumbers;
	private java.lang.String createtime;
	private java.lang.String hazardousIMO;
	private java.lang.String id;
	private java.lang.String emergency1;
	private java.lang.String xlock;
	private java.lang.String pickupPlantRef;
	private java.lang.String movref;
	private java.lang.String vessel;
	private java.lang.String vendor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PRINTDTL_ID"
     */
	public java.lang.Integer getPrintdtlId () {
		return printdtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param printdtlId the new ID
	 */
	public void setPrintdtlId (java.lang.Integer printdtlId) {
		this.printdtlId = printdtlId;
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
	 * Return the value associated with the column: PuPlantApptDate
	 */
	public java.util.Date getPuPlantApptDate () {
		return puPlantApptDate;
	}

	/**
	 * Set the value related to the column: PuPlantApptDate
	 * @param puPlantApptDate the PuPlantApptDate value
	 */
	public void setPuPlantApptDate (java.util.Date puPlantApptDate) {
		this.puPlantApptDate = puPlantApptDate;
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
	 * Return the value associated with the column: IdType
	 */
	public java.lang.String getIdType () {
		return idType;
	}

	/**
	 * Set the value related to the column: IdType
	 * @param idType the IdType value
	 */
	public void setIdType (java.lang.String idType) {
		this.idType = idType;
	}



	/**
	 * Return the value associated with the column: TankNumber
	 */
	public java.lang.String getTankNumber () {
		return tankNumber;
	}

	/**
	 * Set the value related to the column: TankNumber
	 * @param tankNumber the TankNumber value
	 */
	public void setTankNumber (java.lang.String tankNumber) {
		this.tankNumber = tankNumber;
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
	 * Return the value associated with the column: PuPlantApptTime
	 */
	public java.lang.String getPuPlantApptTime () {
		return puPlantApptTime;
	}

	/**
	 * Set the value related to the column: PuPlantApptTime
	 * @param puPlantApptTime the PuPlantApptTime value
	 */
	public void setPuPlantApptTime (java.lang.String puPlantApptTime) {
		this.puPlantApptTime = puPlantApptTime;
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
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
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
	 * Return the value associated with the column: ProductId
	 */
	public java.lang.String getProductId () {
		return productId;
	}

	/**
	 * Set the value related to the column: ProductId
	 * @param productId the ProductId value
	 */
	public void setProductId (java.lang.String productId) {
		this.productId = productId;
	}



	/**
	 * Return the value associated with the column: PuPlantLoadDate
	 */
	public java.util.Date getPuPlantLoadDate () {
		return puPlantLoadDate;
	}

	/**
	 * Set the value related to the column: PuPlantLoadDate
	 * @param puPlantLoadDate the PuPlantLoadDate value
	 */
	public void setPuPlantLoadDate (java.util.Date puPlantLoadDate) {
		this.puPlantLoadDate = puPlantLoadDate;
	}



	/**
	 * Return the value associated with the column: PRINTHDR_ID
	 */
	public java.lang.Integer getPrinthdrId () {
		return printhdrId;
	}

	/**
	 * Set the value related to the column: PRINTHDR_ID
	 * @param printhdrId the PRINTHDR_ID value
	 */
	public void setPrinthdrId (java.lang.Integer printhdrId) {
		this.printhdrId = printhdrId;
	}



	/**
	 * Return the value associated with the column: Hazardous
	 */
	public boolean isHazardous () {
		return hazardous;
	}

	/**
	 * Set the value related to the column: Hazardous
	 * @param hazardous the Hazardous value
	 */
	public void setHazardous (boolean hazardous) {
		this.hazardous = hazardous;
	}



	/**
	 * Return the value associated with the column: MemoB
	 */
	public java.lang.String getMemoB () {
		return memoB;
	}

	/**
	 * Set the value related to the column: MemoB
	 * @param memoB the MemoB value
	 */
	public void setMemoB (java.lang.String memoB) {
		this.memoB = memoB;
	}



	/**
	 * Return the value associated with the column: Product
	 */
	public java.lang.String getProduct () {
		return product;
	}

	/**
	 * Set the value related to the column: Product
	 * @param product the Product value
	 */
	public void setProduct (java.lang.String product) {
		this.product = product;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: WeightType
	 */
	public java.lang.String getWeightType () {
		return weightType;
	}

	/**
	 * Set the value related to the column: WeightType
	 * @param weightType the WeightType value
	 */
	public void setWeightType (java.lang.String weightType) {
		this.weightType = weightType;
	}



	/**
	 * Return the value associated with the column: MemoA
	 */
	public java.lang.String getMemoA () {
		return memoA;
	}

	/**
	 * Set the value related to the column: MemoA
	 * @param memoA the MemoA value
	 */
	public void setMemoA (java.lang.String memoA) {
		this.memoA = memoA;
	}



	/**
	 * Return the value associated with the column: ClassUnPgFp
	 */
	public java.lang.String getClassUnPgFp () {
		return classUnPgFp;
	}

	/**
	 * Set the value related to the column: ClassUnPgFp
	 * @param classUnPgFp the ClassUnPgFp value
	 */
	public void setClassUnPgFp (java.lang.String classUnPgFp) {
		this.classUnPgFp = classUnPgFp;
	}



	/**
	 * Return the value associated with the column: ReportId
	 */
	public java.lang.String getReportId () {
		return reportId;
	}

	/**
	 * Set the value related to the column: ReportId
	 * @param reportId the ReportId value
	 */
	public void setReportId (java.lang.String reportId) {
		this.reportId = reportId;
	}



	/**
	 * Return the value associated with the column: ReportType
	 */
	public java.lang.String getReportType () {
		return reportType;
	}

	/**
	 * Set the value related to the column: ReportType
	 * @param reportType the ReportType value
	 */
	public void setReportType (java.lang.String reportType) {
		this.reportType = reportType;
	}



	/**
	 * Return the value associated with the column: AddInstructions
	 */
	public java.lang.String getAddInstructions () {
		return addInstructions;
	}

	/**
	 * Set the value related to the column: AddInstructions
	 * @param addInstructions the AddInstructions value
	 */
	public void setAddInstructions (java.lang.String addInstructions) {
		this.addInstructions = addInstructions;
	}



	/**
	 * Return the value associated with the column: NumberOfTanks
	 */
	public java.lang.Integer getNumberOfTanks () {
		return numberOfTanks;
	}

	/**
	 * Set the value related to the column: NumberOfTanks
	 * @param numberOfTanks the NumberOfTanks value
	 */
	public void setNumberOfTanks (java.lang.Integer numberOfTanks) {
		this.numberOfTanks = numberOfTanks;
	}



	/**
	 * Return the value associated with the column: ActualWeight
	 */
	public java.lang.Float getActualWeight () {
		return actualWeight;
	}

	/**
	 * Set the value related to the column: ActualWeight
	 * @param actualWeight the ActualWeight value
	 */
	public void setActualWeight (java.lang.Float actualWeight) {
		this.actualWeight = actualWeight;
	}



	/**
	 * Return the value associated with the column: xuserid
	 */
	public java.lang.String getXuserid () {
		return xuserid;
	}

	/**
	 * Set the value related to the column: xuserid
	 * @param xuserid the xuserid value
	 */
	public void setXuserid (java.lang.String xuserid) {
		this.xuserid = xuserid;
	}



	/**
	 * Return the value associated with the column: ActualWeight2
	 */
	public java.lang.String getActualWeight2 () {
		return actualWeight2;
	}

	/**
	 * Set the value related to the column: ActualWeight2
	 * @param actualWeight2 the ActualWeight2 value
	 */
	public void setActualWeight2 (java.lang.String actualWeight2) {
		this.actualWeight2 = actualWeight2;
	}



	/**
	 * Return the value associated with the column: SealNumbers
	 */
	public java.lang.String getSealNumbers () {
		return sealNumbers;
	}

	/**
	 * Set the value related to the column: SealNumbers
	 * @param sealNumbers the SealNumbers value
	 */
	public void setSealNumbers (java.lang.String sealNumbers) {
		this.sealNumbers = sealNumbers;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: HazardousIMO
	 */
	public java.lang.String getHazardousIMO () {
		return hazardousIMO;
	}

	/**
	 * Set the value related to the column: HazardousIMO
	 * @param hazardousIMO the HazardousIMO value
	 */
	public void setHazardousIMO (java.lang.String hazardousIMO) {
		this.hazardousIMO = hazardousIMO;
	}



	/**
	 * Return the value associated with the column: Id
	 */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the value related to the column: Id
	 * @param id the Id value
	 */
	public void setId (java.lang.String id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: Emergency1
	 */
	public java.lang.String getEmergency1 () {
		return emergency1;
	}

	/**
	 * Set the value related to the column: Emergency1
	 * @param emergency1 the Emergency1 value
	 */
	public void setEmergency1 (java.lang.String emergency1) {
		this.emergency1 = emergency1;
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
	 * Return the value associated with the column: PickupPlantRef
	 */
	public java.lang.String getPickupPlantRef () {
		return pickupPlantRef;
	}

	/**
	 * Set the value related to the column: PickupPlantRef
	 * @param pickupPlantRef the PickupPlantRef value
	 */
	public void setPickupPlantRef (java.lang.String pickupPlantRef) {
		this.pickupPlantRef = pickupPlantRef;
	}



	/**
	 * Return the value associated with the column: movref
	 */
	public java.lang.String getMovref () {
		return movref;
	}

	/**
	 * Set the value related to the column: movref
	 * @param movref the movref value
	 */
	public void setMovref (java.lang.String movref) {
		this.movref = movref;
	}



	/**
	 * Return the value associated with the column: vessel
	 */
	public java.lang.String getVessel () {
		return vessel;
	}

	/**
	 * Set the value related to the column: vessel
	 * @param vessel the vessel value
	 */
	public void setVessel (java.lang.String vessel) {
		this.vessel = vessel;
	}



	/**
	 * Return the value associated with the column: vendor
	 */
	public java.lang.String getVendor () {
		return vendor;
	}

	/**
	 * Set the value related to the column: vendor
	 * @param vendor the vendor value
	 */
	public void setVendor (java.lang.String vendor) {
		this.vendor = vendor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.print.Printdtl)) return false;
		else {
			com.bureaueye.beacon.model.print.Printdtl printdtl = (com.bureaueye.beacon.model.print.Printdtl) obj;
			if (null == this.getPrintdtlId() || null == printdtl.getPrintdtlId()) return false;
			else return (this.getPrintdtlId().equals(printdtl.getPrintdtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPrintdtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPrintdtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}