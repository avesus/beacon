package com.bureaueye.beacon.model.print.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the printhdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="printhdr"
 */

public abstract class BasePrinthdr  implements Serializable {

	public static String REF = "Printhdr";
	public static String PROP_MEMO6 = "Memo6";
	public static String PROP_MEMO7 = "Memo7";
	public static String PROP_MEMO8 = "Memo8";
	public static String PROP_MEMO9 = "Memo9";
	public static String PROP_FWD_AGENT_FAX = "FwdAgentFax";
	public static String PROP_FWD_AGENT_REF = "FwdAgentRef";
	public static String PROP_MEMO2 = "Memo2";
	public static String PROP_REPORT_DATE = "ReportDate";
	public static String PROP_MEMO3 = "Memo3";
	public static String PROP_COLLECT = "Collect";
	public static String PROP_MEMO4 = "Memo4";
	public static String PROP_SHIPPER_MBL_C_S_Z_C = "ShipperMblCSZC";
	public static String PROP_MEMO5 = "Memo5";
	public static String PROP_MEMO1 = "Memo1";
	public static String PROP_HBL = "Hbl";
	public static String PROP_NOTIFY_C_S_Z_C = "NotifyCSZC";
	public static String PROP_IMPORT_DELIVERY_INSTRUCTIONS = "ImportDeliveryInstructions";
	public static String PROP_WEIGHT_PER_TANK_APROX = "WeightPerTankAprox";
	public static String PROP_CONSIGNEE = "Consignee";
	public static String PROP_SHIPPER_DR_C_S_Z_C = "ShipperDrCSZC";
	public static String PROP_OCEANFREIGHTCCY = "Oceanfreightccy";
	public static String PROP_CONTAINERIZED = "Containerized";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_PREPAID = "Prepaid";
	public static String PROP_BOOKING_NUMBER = "BookingNumber";
	public static String PROP_CONSIGNEE_REF = "ConsigneeRef";
	public static String PROP_NOTIFY_CONTACT = "NotifyContact";
	public static String PROP_COLLECT_TOTAL2 = "CollectTotal2";
	public static String PROP_REPORT_TYPE = "ReportType";
	public static String PROP_PRE_CARRIAGE_BY = "PreCarriageBy";
	public static String PROP_P_O_L_PIER = "POLPier";
	public static String PROP_CONSIGNEE_FAX = "ConsigneeFax";
	public static String PROP_VESSEL = "Vessel";
	public static String PROP_SHIPPER_C_S_Z_C = "ShipperCSZC";
	public static String PROP_WEIGHT_TYPE = "WeightType";
	public static String PROP_SHIPPER_FAX = "ShipperFax";
	public static String PROP_NUMBER_OF_TANKS = "NumberOfTanks";
	public static String PROP_JOB_NUMBER = "JobNumber";
	public static String PROP_FWD_AGENT = "FwdAgent";
	public static String PROP_FWD_AGENT_ADDRESS1 = "FwdAgentAddress1";
	public static String PROP_FINAL_DELIVERY = "FinalDelivery";
	public static String PROP_FWD_AGENT_ADDRESS2 = "FwdAgentAddress2";
	public static String PROP_SHIPPER_REF = "ShipperRef";
	public static String PROP_FWD_AGENT_ADDRESS3 = "FwdAgentAddress3";
	public static String PROP_NOTIFY_REF = "NotifyRef";
	public static String PROP_POLDATEEST = "Poldateest";
	public static String PROP_PICKUP_PLANT_STATE = "PickupPlantState";
	public static String PROP_CUSTOMER_REF = "CustomerRef";
	public static String PROP_PLACE_OF_RECEIPT = "PlaceOfReceipt";
	public static String PROP_SHIPPER_MBL = "ShipperMbl";
	public static String PROP_NOTIFY_ADDRESS3 = "NotifyAddress3";
	public static String PROP_PODDATEEST = "Poddateest";
	public static String PROP_SHIPPER_DR = "ShipperDr";
	public static String PROP_SHIPPER = "Shipper";
	public static String PROP_SHIPPER_MBL_ADDRESS2 = "ShipperMblAddress2";
	public static String PROP_RATECCY = "Rateccy";
	public static String PROP_SHIPPER_MBL_ADDRESS3 = "ShipperMblAddress3";
	public static String PROP_SHIPPER_DR_ADDRESS3 = "ShipperDrAddress3";
	public static String PROP_SHIPPER_DR_ADDRESS2 = "ShipperDrAddress2";
	public static String PROP_SHIPPER_DR_ADDRESS1 = "ShipperDrAddress1";
	public static String PROP_P_O_D_PIER = "PODPier";
	public static String PROP_SHIPPER_ADDRESS3 = "ShipperAddress3";
	public static String PROP_NOTIFY_ADDRESS1 = "NotifyAddress1";
	public static String PROP_SHIPPER_MBL_ADDRESS1 = "ShipperMblAddress1";
	public static String PROP_SHIPPER_ADDRESS2 = "ShipperAddress2";
	public static String PROP_SHIPPER_ADDRESS1 = "ShipperAddress1";
	public static String PROP_FINAL_DELIVERY_DATE_EST = "FinalDeliveryDateEst";
	public static String PROP_EXPORT_INSTRUCTIONS = "ExportInstructions";
	public static String PROP_TRUCKER_IMPORT = "TruckerImport";
	public static String PROP_INLANDFREIGHTCCY = "Inlandfreightccy";
	public static String PROP_VOYAGE = "Voyage";
	public static String PROP_VESSEL_VOYAGE = "VesselVoyage";
	public static String PROP_FROMCONTACT = "Fromcontact";
	public static String PROP_EXPORT_TRUCK_INSTRUCTIONS = "ExportTruckInstructions";
	public static String PROP_PRINT_ID = "PrintId";
	public static String PROP_SHIP_LINE = "ShipLine";
	public static String PROP_SHIP_METHOD = "ShipMethod";
	public static String PROP_MEMO10 = "Memo10";
	public static String PROP_MEMO12 = "Memo12";
	public static String PROP_MEMO11 = "Memo11";
	public static String PROP_MBL = "Mbl";
	public static String PROP_CHK1 = "Chk1";
	public static String PROP_CHK2 = "Chk2";
	public static String PROP_CHK3 = "Chk3";
	public static String PROP_RATE = "Rate";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_POD = "Pod";
	public static String PROP_FWD_AGENT_C_S_Z_C = "FwdAgentCSZC";
	public static String PROP_COLLECT_TOTAL = "CollectTotal";
	public static String PROP_POL = "Pol";
	public static String PROP_PRINTHDR_ID = "PrinthdrId";
	public static String PROP_CONSIGNEE_C_S_Z_C = "ConsigneeCSZC";
	public static String PROP_PICKUP_PLANT = "PickupPlant";
	public static String PROP_PREPAID_TOTAL2 = "PrepaidTotal2";
	public static String PROP_CONSIGNEE_ADDRESS3 = "ConsigneeAddress3";
	public static String PROP_CONSIGNEE_ADDRESS2 = "ConsigneeAddress2";
	public static String PROP_CONSIGNEE_ADDRESS1 = "ConsigneeAddress1";


	// constructors
	public BasePrinthdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrinthdr (java.lang.Integer printhdrId) {
		this.setPrinthdrId(printhdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer printhdrId;

	// fields
	private java.lang.String printId;
	private java.util.Date reportDate;
	private java.lang.String consigneeAddress2;
	private java.lang.String shipperMblAddress3;
	private java.lang.String collectTotal;
	private java.lang.String memo9;
	private java.lang.String notifyCSZC;
	private java.lang.String shipperMblCSZC;
	private java.lang.String consigneeAddress3;
	private java.lang.String shipLine;
	private java.lang.String collect;
	private java.lang.String vesselVoyage;
	private java.lang.String memo3;
	private java.lang.String memo11;
	private java.lang.String notifyAddress3;
	private java.lang.String pod;
	private java.lang.String vessel;
	private java.lang.String numberOfTanks;
	private java.lang.String consigneeRef;
	private java.lang.String memo7;
	private java.lang.String inlandfreightccy;
	private java.lang.String voyage;
	private java.lang.String placeOfReceipt;
	private java.lang.String memo1;
	private java.lang.String shipperAddress1;
	private java.lang.String systemloguserid;
	private java.lang.String fwdAgent;
	private java.lang.String jobNumber;
	private java.lang.String shipperDrAddress1;
	private java.lang.String consignee;
	private java.lang.String hbl;
	private java.lang.String memo12;
	private java.lang.String memo2;
	private java.lang.String shipperRef;
	private java.lang.String finalDelivery;
	private java.lang.String consigneeAddress1;
	private java.lang.String shipperMbl;
	private java.lang.String reportType;
	private java.lang.String chk3;
	private java.lang.String pOLPier;
	private java.lang.String shipperAddress2;
	private java.lang.String rateccy;
	private java.lang.String shipperDrCSZC;
	private java.lang.String shipperCSZC;
	private java.lang.String preCarriageBy;
	private java.lang.String prepaid;
	private java.lang.String fwdAgentAddress2;
	private java.lang.String shipperAddress3;
	private java.lang.String containerized;
	private java.lang.String exportTruckInstructions;
	private java.lang.String weightPerTankAprox;
	private java.lang.String chk1;
	private java.lang.String customerRef;
	private java.lang.String memo5;
	private java.lang.String weightType;
	private java.lang.String oceanfreightccy;
	private java.lang.String prepaidTotal2;
	private java.lang.String bookingNumber;
	private java.lang.String notifyRef;
	private java.lang.String fwdAgentFax;
	private java.lang.String shipperFax;
	private java.lang.String shipperDr;
	private java.lang.String mbl;
	private java.lang.String collectTotal2;
	private java.lang.String shipper;
	private java.lang.String fwdAgentAddress3;
	private java.lang.String memo10;
	private java.lang.String consigneeCSZC;
	private java.lang.String customer;
	private java.lang.String consigneeFax;
	private java.lang.String pickupPlant;
	private java.lang.String shipperMblAddress2;
	private java.lang.String truckerImport;
	private java.lang.String notifyAddress1;
	private java.lang.String notifyContact;
	private java.lang.String shipMethod;
	private java.lang.String pickupPlantState;
	private java.lang.String memo8;
	private java.lang.String pol;
	private java.util.Date poddateest;
	private java.util.Date finalDeliveryDateEst;
	private java.util.Date poldateest;
	private java.lang.String fwdAgentCSZC;
	private java.lang.String fwdAgentAddress1;
	private java.lang.String memo6;
	private java.lang.String shipperDrAddress3;
	private java.lang.String shipperDrAddress2;
	private java.lang.String chk2;
	private java.lang.String exportInstructions;
	private java.lang.String shipperMblAddress1;
	private java.lang.String importDeliveryInstructions;
	private java.lang.String pODPier;
	private java.lang.String memo4;
	private java.lang.String fwdAgentRef;
	private java.lang.String fromcontact;
	private java.lang.String rate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PRINTHDR_ID"
     */
	public java.lang.Integer getPrinthdrId () {
		return printhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param printhdrId the new ID
	 */
	public void setPrinthdrId (java.lang.Integer printhdrId) {
		this.printhdrId = printhdrId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PrintId
	 */
	public java.lang.String getPrintId () {
		return printId;
	}

	/**
	 * Set the value related to the column: PrintId
	 * @param printId the PrintId value
	 */
	public void setPrintId (java.lang.String printId) {
		this.printId = printId;
	}



	/**
	 * Return the value associated with the column: ReportDate
	 */
	public java.util.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: ReportDate
	 * @param reportDate the ReportDate value
	 */
	public void setReportDate (java.util.Date reportDate) {
		this.reportDate = reportDate;
	}



	/**
	 * Return the value associated with the column: ConsigneeAddress2
	 */
	public java.lang.String getConsigneeAddress2 () {
		return consigneeAddress2;
	}

	/**
	 * Set the value related to the column: ConsigneeAddress2
	 * @param consigneeAddress2 the ConsigneeAddress2 value
	 */
	public void setConsigneeAddress2 (java.lang.String consigneeAddress2) {
		this.consigneeAddress2 = consigneeAddress2;
	}



	/**
	 * Return the value associated with the column: ShipperMblAddress3
	 */
	public java.lang.String getShipperMblAddress3 () {
		return shipperMblAddress3;
	}

	/**
	 * Set the value related to the column: ShipperMblAddress3
	 * @param shipperMblAddress3 the ShipperMblAddress3 value
	 */
	public void setShipperMblAddress3 (java.lang.String shipperMblAddress3) {
		this.shipperMblAddress3 = shipperMblAddress3;
	}



	/**
	 * Return the value associated with the column: CollectTotal
	 */
	public java.lang.String getCollectTotal () {
		return collectTotal;
	}

	/**
	 * Set the value related to the column: CollectTotal
	 * @param collectTotal the CollectTotal value
	 */
	public void setCollectTotal (java.lang.String collectTotal) {
		this.collectTotal = collectTotal;
	}



	/**
	 * Return the value associated with the column: Memo9
	 */
	public java.lang.String getMemo9 () {
		return memo9;
	}

	/**
	 * Set the value related to the column: Memo9
	 * @param memo9 the Memo9 value
	 */
	public void setMemo9 (java.lang.String memo9) {
		this.memo9 = memo9;
	}



	/**
	 * Return the value associated with the column: NotifyCSZC
	 */
	public java.lang.String getNotifyCSZC () {
		return notifyCSZC;
	}

	/**
	 * Set the value related to the column: NotifyCSZC
	 * @param notifyCSZC the NotifyCSZC value
	 */
	public void setNotifyCSZC (java.lang.String notifyCSZC) {
		this.notifyCSZC = notifyCSZC;
	}



	/**
	 * Return the value associated with the column: ShipperMblCSZC
	 */
	public java.lang.String getShipperMblCSZC () {
		return shipperMblCSZC;
	}

	/**
	 * Set the value related to the column: ShipperMblCSZC
	 * @param shipperMblCSZC the ShipperMblCSZC value
	 */
	public void setShipperMblCSZC (java.lang.String shipperMblCSZC) {
		this.shipperMblCSZC = shipperMblCSZC;
	}



	/**
	 * Return the value associated with the column: ConsigneeAddress3
	 */
	public java.lang.String getConsigneeAddress3 () {
		return consigneeAddress3;
	}

	/**
	 * Set the value related to the column: ConsigneeAddress3
	 * @param consigneeAddress3 the ConsigneeAddress3 value
	 */
	public void setConsigneeAddress3 (java.lang.String consigneeAddress3) {
		this.consigneeAddress3 = consigneeAddress3;
	}



	/**
	 * Return the value associated with the column: ShipLine
	 */
	public java.lang.String getShipLine () {
		return shipLine;
	}

	/**
	 * Set the value related to the column: ShipLine
	 * @param shipLine the ShipLine value
	 */
	public void setShipLine (java.lang.String shipLine) {
		this.shipLine = shipLine;
	}



	/**
	 * Return the value associated with the column: Collect
	 */
	public java.lang.String getCollect () {
		return collect;
	}

	/**
	 * Set the value related to the column: Collect
	 * @param collect the Collect value
	 */
	public void setCollect (java.lang.String collect) {
		this.collect = collect;
	}



	/**
	 * Return the value associated with the column: VesselVoyage
	 */
	public java.lang.String getVesselVoyage () {
		return vesselVoyage;
	}

	/**
	 * Set the value related to the column: VesselVoyage
	 * @param vesselVoyage the VesselVoyage value
	 */
	public void setVesselVoyage (java.lang.String vesselVoyage) {
		this.vesselVoyage = vesselVoyage;
	}



	/**
	 * Return the value associated with the column: Memo3
	 */
	public java.lang.String getMemo3 () {
		return memo3;
	}

	/**
	 * Set the value related to the column: Memo3
	 * @param memo3 the Memo3 value
	 */
	public void setMemo3 (java.lang.String memo3) {
		this.memo3 = memo3;
	}



	/**
	 * Return the value associated with the column: Memo11
	 */
	public java.lang.String getMemo11 () {
		return memo11;
	}

	/**
	 * Set the value related to the column: Memo11
	 * @param memo11 the Memo11 value
	 */
	public void setMemo11 (java.lang.String memo11) {
		this.memo11 = memo11;
	}



	/**
	 * Return the value associated with the column: NotifyAddress3
	 */
	public java.lang.String getNotifyAddress3 () {
		return notifyAddress3;
	}

	/**
	 * Set the value related to the column: NotifyAddress3
	 * @param notifyAddress3 the NotifyAddress3 value
	 */
	public void setNotifyAddress3 (java.lang.String notifyAddress3) {
		this.notifyAddress3 = notifyAddress3;
	}



	/**
	 * Return the value associated with the column: POD
	 */
	public java.lang.String getPod () {
		return pod;
	}

	/**
	 * Set the value related to the column: POD
	 * @param pod the POD value
	 */
	public void setPod (java.lang.String pod) {
		this.pod = pod;
	}



	/**
	 * Return the value associated with the column: Vessel
	 */
	public java.lang.String getVessel () {
		return vessel;
	}

	/**
	 * Set the value related to the column: Vessel
	 * @param vessel the Vessel value
	 */
	public void setVessel (java.lang.String vessel) {
		this.vessel = vessel;
	}



	/**
	 * Return the value associated with the column: NumberOfTanks
	 */
	public java.lang.String getNumberOfTanks () {
		return numberOfTanks;
	}

	/**
	 * Set the value related to the column: NumberOfTanks
	 * @param numberOfTanks the NumberOfTanks value
	 */
	public void setNumberOfTanks (java.lang.String numberOfTanks) {
		this.numberOfTanks = numberOfTanks;
	}



	/**
	 * Return the value associated with the column: ConsigneeRef
	 */
	public java.lang.String getConsigneeRef () {
		return consigneeRef;
	}

	/**
	 * Set the value related to the column: ConsigneeRef
	 * @param consigneeRef the ConsigneeRef value
	 */
	public void setConsigneeRef (java.lang.String consigneeRef) {
		this.consigneeRef = consigneeRef;
	}



	/**
	 * Return the value associated with the column: Memo7
	 */
	public java.lang.String getMemo7 () {
		return memo7;
	}

	/**
	 * Set the value related to the column: Memo7
	 * @param memo7 the Memo7 value
	 */
	public void setMemo7 (java.lang.String memo7) {
		this.memo7 = memo7;
	}



	/**
	 * Return the value associated with the column: inlandfreightccy
	 */
	public java.lang.String getInlandfreightccy () {
		return inlandfreightccy;
	}

	/**
	 * Set the value related to the column: inlandfreightccy
	 * @param inlandfreightccy the inlandfreightccy value
	 */
	public void setInlandfreightccy (java.lang.String inlandfreightccy) {
		this.inlandfreightccy = inlandfreightccy;
	}



	/**
	 * Return the value associated with the column: Voyage
	 */
	public java.lang.String getVoyage () {
		return voyage;
	}

	/**
	 * Set the value related to the column: Voyage
	 * @param voyage the Voyage value
	 */
	public void setVoyage (java.lang.String voyage) {
		this.voyage = voyage;
	}



	/**
	 * Return the value associated with the column: PlaceOfReceipt
	 */
	public java.lang.String getPlaceOfReceipt () {
		return placeOfReceipt;
	}

	/**
	 * Set the value related to the column: PlaceOfReceipt
	 * @param placeOfReceipt the PlaceOfReceipt value
	 */
	public void setPlaceOfReceipt (java.lang.String placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}



	/**
	 * Return the value associated with the column: Memo1
	 */
	public java.lang.String getMemo1 () {
		return memo1;
	}

	/**
	 * Set the value related to the column: Memo1
	 * @param memo1 the Memo1 value
	 */
	public void setMemo1 (java.lang.String memo1) {
		this.memo1 = memo1;
	}



	/**
	 * Return the value associated with the column: ShipperAddress1
	 */
	public java.lang.String getShipperAddress1 () {
		return shipperAddress1;
	}

	/**
	 * Set the value related to the column: ShipperAddress1
	 * @param shipperAddress1 the ShipperAddress1 value
	 */
	public void setShipperAddress1 (java.lang.String shipperAddress1) {
		this.shipperAddress1 = shipperAddress1;
	}



	/**
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: FwdAgent
	 */
	public java.lang.String getFwdAgent () {
		return fwdAgent;
	}

	/**
	 * Set the value related to the column: FwdAgent
	 * @param fwdAgent the FwdAgent value
	 */
	public void setFwdAgent (java.lang.String fwdAgent) {
		this.fwdAgent = fwdAgent;
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
	 * Return the value associated with the column: ShipperDrAddress1
	 */
	public java.lang.String getShipperDrAddress1 () {
		return shipperDrAddress1;
	}

	/**
	 * Set the value related to the column: ShipperDrAddress1
	 * @param shipperDrAddress1 the ShipperDrAddress1 value
	 */
	public void setShipperDrAddress1 (java.lang.String shipperDrAddress1) {
		this.shipperDrAddress1 = shipperDrAddress1;
	}



	/**
	 * Return the value associated with the column: Consignee
	 */
	public java.lang.String getConsignee () {
		return consignee;
	}

	/**
	 * Set the value related to the column: Consignee
	 * @param consignee the Consignee value
	 */
	public void setConsignee (java.lang.String consignee) {
		this.consignee = consignee;
	}



	/**
	 * Return the value associated with the column: HBL
	 */
	public java.lang.String getHbl () {
		return hbl;
	}

	/**
	 * Set the value related to the column: HBL
	 * @param hbl the HBL value
	 */
	public void setHbl (java.lang.String hbl) {
		this.hbl = hbl;
	}



	/**
	 * Return the value associated with the column: Memo12
	 */
	public java.lang.String getMemo12 () {
		return memo12;
	}

	/**
	 * Set the value related to the column: Memo12
	 * @param memo12 the Memo12 value
	 */
	public void setMemo12 (java.lang.String memo12) {
		this.memo12 = memo12;
	}



	/**
	 * Return the value associated with the column: Memo2
	 */
	public java.lang.String getMemo2 () {
		return memo2;
	}

	/**
	 * Set the value related to the column: Memo2
	 * @param memo2 the Memo2 value
	 */
	public void setMemo2 (java.lang.String memo2) {
		this.memo2 = memo2;
	}



	/**
	 * Return the value associated with the column: ShipperRef
	 */
	public java.lang.String getShipperRef () {
		return shipperRef;
	}

	/**
	 * Set the value related to the column: ShipperRef
	 * @param shipperRef the ShipperRef value
	 */
	public void setShipperRef (java.lang.String shipperRef) {
		this.shipperRef = shipperRef;
	}



	/**
	 * Return the value associated with the column: FinalDelivery
	 */
	public java.lang.String getFinalDelivery () {
		return finalDelivery;
	}

	/**
	 * Set the value related to the column: FinalDelivery
	 * @param finalDelivery the FinalDelivery value
	 */
	public void setFinalDelivery (java.lang.String finalDelivery) {
		this.finalDelivery = finalDelivery;
	}



	/**
	 * Return the value associated with the column: ConsigneeAddress1
	 */
	public java.lang.String getConsigneeAddress1 () {
		return consigneeAddress1;
	}

	/**
	 * Set the value related to the column: ConsigneeAddress1
	 * @param consigneeAddress1 the ConsigneeAddress1 value
	 */
	public void setConsigneeAddress1 (java.lang.String consigneeAddress1) {
		this.consigneeAddress1 = consigneeAddress1;
	}



	/**
	 * Return the value associated with the column: ShipperMbl
	 */
	public java.lang.String getShipperMbl () {
		return shipperMbl;
	}

	/**
	 * Set the value related to the column: ShipperMbl
	 * @param shipperMbl the ShipperMbl value
	 */
	public void setShipperMbl (java.lang.String shipperMbl) {
		this.shipperMbl = shipperMbl;
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
	 * Return the value associated with the column: Chk3
	 */
	public java.lang.String getChk3 () {
		return chk3;
	}

	/**
	 * Set the value related to the column: Chk3
	 * @param chk3 the Chk3 value
	 */
	public void setChk3 (java.lang.String chk3) {
		this.chk3 = chk3;
	}



	/**
	 * Return the value associated with the column: POLPier
	 */
	public java.lang.String getPOLPier () {
		return pOLPier;
	}

	/**
	 * Set the value related to the column: POLPier
	 * @param pOLPier the POLPier value
	 */
	public void setPOLPier (java.lang.String pOLPier) {
		this.pOLPier = pOLPier;
	}



	/**
	 * Return the value associated with the column: ShipperAddress2
	 */
	public java.lang.String getShipperAddress2 () {
		return shipperAddress2;
	}

	/**
	 * Set the value related to the column: ShipperAddress2
	 * @param shipperAddress2 the ShipperAddress2 value
	 */
	public void setShipperAddress2 (java.lang.String shipperAddress2) {
		this.shipperAddress2 = shipperAddress2;
	}



	/**
	 * Return the value associated with the column: rateccy
	 */
	public java.lang.String getRateccy () {
		return rateccy;
	}

	/**
	 * Set the value related to the column: rateccy
	 * @param rateccy the rateccy value
	 */
	public void setRateccy (java.lang.String rateccy) {
		this.rateccy = rateccy;
	}



	/**
	 * Return the value associated with the column: ShipperDrCSZC
	 */
	public java.lang.String getShipperDrCSZC () {
		return shipperDrCSZC;
	}

	/**
	 * Set the value related to the column: ShipperDrCSZC
	 * @param shipperDrCSZC the ShipperDrCSZC value
	 */
	public void setShipperDrCSZC (java.lang.String shipperDrCSZC) {
		this.shipperDrCSZC = shipperDrCSZC;
	}



	/**
	 * Return the value associated with the column: ShipperCSZC
	 */
	public java.lang.String getShipperCSZC () {
		return shipperCSZC;
	}

	/**
	 * Set the value related to the column: ShipperCSZC
	 * @param shipperCSZC the ShipperCSZC value
	 */
	public void setShipperCSZC (java.lang.String shipperCSZC) {
		this.shipperCSZC = shipperCSZC;
	}



	/**
	 * Return the value associated with the column: PreCarriageBy
	 */
	public java.lang.String getPreCarriageBy () {
		return preCarriageBy;
	}

	/**
	 * Set the value related to the column: PreCarriageBy
	 * @param preCarriageBy the PreCarriageBy value
	 */
	public void setPreCarriageBy (java.lang.String preCarriageBy) {
		this.preCarriageBy = preCarriageBy;
	}



	/**
	 * Return the value associated with the column: Prepaid
	 */
	public java.lang.String getPrepaid () {
		return prepaid;
	}

	/**
	 * Set the value related to the column: Prepaid
	 * @param prepaid the Prepaid value
	 */
	public void setPrepaid (java.lang.String prepaid) {
		this.prepaid = prepaid;
	}



	/**
	 * Return the value associated with the column: FwdAgentAddress2
	 */
	public java.lang.String getFwdAgentAddress2 () {
		return fwdAgentAddress2;
	}

	/**
	 * Set the value related to the column: FwdAgentAddress2
	 * @param fwdAgentAddress2 the FwdAgentAddress2 value
	 */
	public void setFwdAgentAddress2 (java.lang.String fwdAgentAddress2) {
		this.fwdAgentAddress2 = fwdAgentAddress2;
	}



	/**
	 * Return the value associated with the column: ShipperAddress3
	 */
	public java.lang.String getShipperAddress3 () {
		return shipperAddress3;
	}

	/**
	 * Set the value related to the column: ShipperAddress3
	 * @param shipperAddress3 the ShipperAddress3 value
	 */
	public void setShipperAddress3 (java.lang.String shipperAddress3) {
		this.shipperAddress3 = shipperAddress3;
	}



	/**
	 * Return the value associated with the column: Containerized
	 */
	public java.lang.String getContainerized () {
		return containerized;
	}

	/**
	 * Set the value related to the column: Containerized
	 * @param containerized the Containerized value
	 */
	public void setContainerized (java.lang.String containerized) {
		this.containerized = containerized;
	}



	/**
	 * Return the value associated with the column: ExportTruckInstructions
	 */
	public java.lang.String getExportTruckInstructions () {
		return exportTruckInstructions;
	}

	/**
	 * Set the value related to the column: ExportTruckInstructions
	 * @param exportTruckInstructions the ExportTruckInstructions value
	 */
	public void setExportTruckInstructions (java.lang.String exportTruckInstructions) {
		this.exportTruckInstructions = exportTruckInstructions;
	}



	/**
	 * Return the value associated with the column: WeightPerTankAprox
	 */
	public java.lang.String getWeightPerTankAprox () {
		return weightPerTankAprox;
	}

	/**
	 * Set the value related to the column: WeightPerTankAprox
	 * @param weightPerTankAprox the WeightPerTankAprox value
	 */
	public void setWeightPerTankAprox (java.lang.String weightPerTankAprox) {
		this.weightPerTankAprox = weightPerTankAprox;
	}



	/**
	 * Return the value associated with the column: Chk1
	 */
	public java.lang.String getChk1 () {
		return chk1;
	}

	/**
	 * Set the value related to the column: Chk1
	 * @param chk1 the Chk1 value
	 */
	public void setChk1 (java.lang.String chk1) {
		this.chk1 = chk1;
	}



	/**
	 * Return the value associated with the column: CustomerRef
	 */
	public java.lang.String getCustomerRef () {
		return customerRef;
	}

	/**
	 * Set the value related to the column: CustomerRef
	 * @param customerRef the CustomerRef value
	 */
	public void setCustomerRef (java.lang.String customerRef) {
		this.customerRef = customerRef;
	}



	/**
	 * Return the value associated with the column: Memo5
	 */
	public java.lang.String getMemo5 () {
		return memo5;
	}

	/**
	 * Set the value related to the column: Memo5
	 * @param memo5 the Memo5 value
	 */
	public void setMemo5 (java.lang.String memo5) {
		this.memo5 = memo5;
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
	 * Return the value associated with the column: oceanfreightccy
	 */
	public java.lang.String getOceanfreightccy () {
		return oceanfreightccy;
	}

	/**
	 * Set the value related to the column: oceanfreightccy
	 * @param oceanfreightccy the oceanfreightccy value
	 */
	public void setOceanfreightccy (java.lang.String oceanfreightccy) {
		this.oceanfreightccy = oceanfreightccy;
	}



	/**
	 * Return the value associated with the column: PrepaidTotal2
	 */
	public java.lang.String getPrepaidTotal2 () {
		return prepaidTotal2;
	}

	/**
	 * Set the value related to the column: PrepaidTotal2
	 * @param prepaidTotal2 the PrepaidTotal2 value
	 */
	public void setPrepaidTotal2 (java.lang.String prepaidTotal2) {
		this.prepaidTotal2 = prepaidTotal2;
	}



	/**
	 * Return the value associated with the column: BookingNumber
	 */
	public java.lang.String getBookingNumber () {
		return bookingNumber;
	}

	/**
	 * Set the value related to the column: BookingNumber
	 * @param bookingNumber the BookingNumber value
	 */
	public void setBookingNumber (java.lang.String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}



	/**
	 * Return the value associated with the column: NotifyRef
	 */
	public java.lang.String getNotifyRef () {
		return notifyRef;
	}

	/**
	 * Set the value related to the column: NotifyRef
	 * @param notifyRef the NotifyRef value
	 */
	public void setNotifyRef (java.lang.String notifyRef) {
		this.notifyRef = notifyRef;
	}



	/**
	 * Return the value associated with the column: FwdAgentFax
	 */
	public java.lang.String getFwdAgentFax () {
		return fwdAgentFax;
	}

	/**
	 * Set the value related to the column: FwdAgentFax
	 * @param fwdAgentFax the FwdAgentFax value
	 */
	public void setFwdAgentFax (java.lang.String fwdAgentFax) {
		this.fwdAgentFax = fwdAgentFax;
	}



	/**
	 * Return the value associated with the column: ShipperFax
	 */
	public java.lang.String getShipperFax () {
		return shipperFax;
	}

	/**
	 * Set the value related to the column: ShipperFax
	 * @param shipperFax the ShipperFax value
	 */
	public void setShipperFax (java.lang.String shipperFax) {
		this.shipperFax = shipperFax;
	}



	/**
	 * Return the value associated with the column: ShipperDr
	 */
	public java.lang.String getShipperDr () {
		return shipperDr;
	}

	/**
	 * Set the value related to the column: ShipperDr
	 * @param shipperDr the ShipperDr value
	 */
	public void setShipperDr (java.lang.String shipperDr) {
		this.shipperDr = shipperDr;
	}



	/**
	 * Return the value associated with the column: MBL
	 */
	public java.lang.String getMbl () {
		return mbl;
	}

	/**
	 * Set the value related to the column: MBL
	 * @param mbl the MBL value
	 */
	public void setMbl (java.lang.String mbl) {
		this.mbl = mbl;
	}



	/**
	 * Return the value associated with the column: CollectTotal2
	 */
	public java.lang.String getCollectTotal2 () {
		return collectTotal2;
	}

	/**
	 * Set the value related to the column: CollectTotal2
	 * @param collectTotal2 the CollectTotal2 value
	 */
	public void setCollectTotal2 (java.lang.String collectTotal2) {
		this.collectTotal2 = collectTotal2;
	}



	/**
	 * Return the value associated with the column: Shipper
	 */
	public java.lang.String getShipper () {
		return shipper;
	}

	/**
	 * Set the value related to the column: Shipper
	 * @param shipper the Shipper value
	 */
	public void setShipper (java.lang.String shipper) {
		this.shipper = shipper;
	}



	/**
	 * Return the value associated with the column: FwdAgentAddress3
	 */
	public java.lang.String getFwdAgentAddress3 () {
		return fwdAgentAddress3;
	}

	/**
	 * Set the value related to the column: FwdAgentAddress3
	 * @param fwdAgentAddress3 the FwdAgentAddress3 value
	 */
	public void setFwdAgentAddress3 (java.lang.String fwdAgentAddress3) {
		this.fwdAgentAddress3 = fwdAgentAddress3;
	}



	/**
	 * Return the value associated with the column: Memo10
	 */
	public java.lang.String getMemo10 () {
		return memo10;
	}

	/**
	 * Set the value related to the column: Memo10
	 * @param memo10 the Memo10 value
	 */
	public void setMemo10 (java.lang.String memo10) {
		this.memo10 = memo10;
	}



	/**
	 * Return the value associated with the column: ConsigneeCSZC
	 */
	public java.lang.String getConsigneeCSZC () {
		return consigneeCSZC;
	}

	/**
	 * Set the value related to the column: ConsigneeCSZC
	 * @param consigneeCSZC the ConsigneeCSZC value
	 */
	public void setConsigneeCSZC (java.lang.String consigneeCSZC) {
		this.consigneeCSZC = consigneeCSZC;
	}



	/**
	 * Return the value associated with the column: Customer
	 */
	public java.lang.String getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: Customer
	 * @param customer the Customer value
	 */
	public void setCustomer (java.lang.String customer) {
		this.customer = customer;
	}



	/**
	 * Return the value associated with the column: ConsigneeFax
	 */
	public java.lang.String getConsigneeFax () {
		return consigneeFax;
	}

	/**
	 * Set the value related to the column: ConsigneeFax
	 * @param consigneeFax the ConsigneeFax value
	 */
	public void setConsigneeFax (java.lang.String consigneeFax) {
		this.consigneeFax = consigneeFax;
	}



	/**
	 * Return the value associated with the column: PickupPlant
	 */
	public java.lang.String getPickupPlant () {
		return pickupPlant;
	}

	/**
	 * Set the value related to the column: PickupPlant
	 * @param pickupPlant the PickupPlant value
	 */
	public void setPickupPlant (java.lang.String pickupPlant) {
		this.pickupPlant = pickupPlant;
	}



	/**
	 * Return the value associated with the column: ShipperMblAddress2
	 */
	public java.lang.String getShipperMblAddress2 () {
		return shipperMblAddress2;
	}

	/**
	 * Set the value related to the column: ShipperMblAddress2
	 * @param shipperMblAddress2 the ShipperMblAddress2 value
	 */
	public void setShipperMblAddress2 (java.lang.String shipperMblAddress2) {
		this.shipperMblAddress2 = shipperMblAddress2;
	}



	/**
	 * Return the value associated with the column: TruckerImport
	 */
	public java.lang.String getTruckerImport () {
		return truckerImport;
	}

	/**
	 * Set the value related to the column: TruckerImport
	 * @param truckerImport the TruckerImport value
	 */
	public void setTruckerImport (java.lang.String truckerImport) {
		this.truckerImport = truckerImport;
	}



	/**
	 * Return the value associated with the column: NotifyAddress1
	 */
	public java.lang.String getNotifyAddress1 () {
		return notifyAddress1;
	}

	/**
	 * Set the value related to the column: NotifyAddress1
	 * @param notifyAddress1 the NotifyAddress1 value
	 */
	public void setNotifyAddress1 (java.lang.String notifyAddress1) {
		this.notifyAddress1 = notifyAddress1;
	}



	/**
	 * Return the value associated with the column: NotifyContact
	 */
	public java.lang.String getNotifyContact () {
		return notifyContact;
	}

	/**
	 * Set the value related to the column: NotifyContact
	 * @param notifyContact the NotifyContact value
	 */
	public void setNotifyContact (java.lang.String notifyContact) {
		this.notifyContact = notifyContact;
	}



	/**
	 * Return the value associated with the column: ShipMethod
	 */
	public java.lang.String getShipMethod () {
		return shipMethod;
	}

	/**
	 * Set the value related to the column: ShipMethod
	 * @param shipMethod the ShipMethod value
	 */
	public void setShipMethod (java.lang.String shipMethod) {
		this.shipMethod = shipMethod;
	}



	/**
	 * Return the value associated with the column: PickupPlantState
	 */
	public java.lang.String getPickupPlantState () {
		return pickupPlantState;
	}

	/**
	 * Set the value related to the column: PickupPlantState
	 * @param pickupPlantState the PickupPlantState value
	 */
	public void setPickupPlantState (java.lang.String pickupPlantState) {
		this.pickupPlantState = pickupPlantState;
	}



	/**
	 * Return the value associated with the column: Memo8
	 */
	public java.lang.String getMemo8 () {
		return memo8;
	}

	/**
	 * Set the value related to the column: Memo8
	 * @param memo8 the Memo8 value
	 */
	public void setMemo8 (java.lang.String memo8) {
		this.memo8 = memo8;
	}



	/**
	 * Return the value associated with the column: POL
	 */
	public java.lang.String getPol () {
		return pol;
	}

	/**
	 * Set the value related to the column: POL
	 * @param pol the POL value
	 */
	public void setPol (java.lang.String pol) {
		this.pol = pol;
	}



	/**
	 * Return the value associated with the column: PODdateEst
	 */
	public java.util.Date getPoddateest () {
		return poddateest;
	}

	/**
	 * Set the value related to the column: PODdateEst
	 * @param poddateest the PODdateEst value
	 */
	public void setPoddateest (java.util.Date poddateest) {
		this.poddateest = poddateest;
	}



	/**
	 * Return the value associated with the column: FinalDeliveryDateEst
	 */
	public java.util.Date getFinalDeliveryDateEst () {
		return finalDeliveryDateEst;
	}

	/**
	 * Set the value related to the column: FinalDeliveryDateEst
	 * @param finalDeliveryDateEst the FinalDeliveryDateEst value
	 */
	public void setFinalDeliveryDateEst (java.util.Date finalDeliveryDateEst) {
		this.finalDeliveryDateEst = finalDeliveryDateEst;
	}



	/**
	 * Return the value associated with the column: POLdateEst
	 */
	public java.util.Date getPoldateest () {
		return poldateest;
	}

	/**
	 * Set the value related to the column: POLdateEst
	 * @param poldateest the POLdateEst value
	 */
	public void setPoldateest (java.util.Date poldateest) {
		this.poldateest = poldateest;
	}



	/**
	 * Return the value associated with the column: FwdAgentCSZC
	 */
	public java.lang.String getFwdAgentCSZC () {
		return fwdAgentCSZC;
	}

	/**
	 * Set the value related to the column: FwdAgentCSZC
	 * @param fwdAgentCSZC the FwdAgentCSZC value
	 */
	public void setFwdAgentCSZC (java.lang.String fwdAgentCSZC) {
		this.fwdAgentCSZC = fwdAgentCSZC;
	}



	/**
	 * Return the value associated with the column: FwdAgentAddress1
	 */
	public java.lang.String getFwdAgentAddress1 () {
		return fwdAgentAddress1;
	}

	/**
	 * Set the value related to the column: FwdAgentAddress1
	 * @param fwdAgentAddress1 the FwdAgentAddress1 value
	 */
	public void setFwdAgentAddress1 (java.lang.String fwdAgentAddress1) {
		this.fwdAgentAddress1 = fwdAgentAddress1;
	}



	/**
	 * Return the value associated with the column: Memo6
	 */
	public java.lang.String getMemo6 () {
		return memo6;
	}

	/**
	 * Set the value related to the column: Memo6
	 * @param memo6 the Memo6 value
	 */
	public void setMemo6 (java.lang.String memo6) {
		this.memo6 = memo6;
	}



	/**
	 * Return the value associated with the column: ShipperDrAddress3
	 */
	public java.lang.String getShipperDrAddress3 () {
		return shipperDrAddress3;
	}

	/**
	 * Set the value related to the column: ShipperDrAddress3
	 * @param shipperDrAddress3 the ShipperDrAddress3 value
	 */
	public void setShipperDrAddress3 (java.lang.String shipperDrAddress3) {
		this.shipperDrAddress3 = shipperDrAddress3;
	}



	/**
	 * Return the value associated with the column: ShipperDrAddress2
	 */
	public java.lang.String getShipperDrAddress2 () {
		return shipperDrAddress2;
	}

	/**
	 * Set the value related to the column: ShipperDrAddress2
	 * @param shipperDrAddress2 the ShipperDrAddress2 value
	 */
	public void setShipperDrAddress2 (java.lang.String shipperDrAddress2) {
		this.shipperDrAddress2 = shipperDrAddress2;
	}



	/**
	 * Return the value associated with the column: Chk2
	 */
	public java.lang.String getChk2 () {
		return chk2;
	}

	/**
	 * Set the value related to the column: Chk2
	 * @param chk2 the Chk2 value
	 */
	public void setChk2 (java.lang.String chk2) {
		this.chk2 = chk2;
	}



	/**
	 * Return the value associated with the column: ExportInstructions
	 */
	public java.lang.String getExportInstructions () {
		return exportInstructions;
	}

	/**
	 * Set the value related to the column: ExportInstructions
	 * @param exportInstructions the ExportInstructions value
	 */
	public void setExportInstructions (java.lang.String exportInstructions) {
		this.exportInstructions = exportInstructions;
	}



	/**
	 * Return the value associated with the column: ShipperMblAddress1
	 */
	public java.lang.String getShipperMblAddress1 () {
		return shipperMblAddress1;
	}

	/**
	 * Set the value related to the column: ShipperMblAddress1
	 * @param shipperMblAddress1 the ShipperMblAddress1 value
	 */
	public void setShipperMblAddress1 (java.lang.String shipperMblAddress1) {
		this.shipperMblAddress1 = shipperMblAddress1;
	}



	/**
	 * Return the value associated with the column: ImportDeliveryInstructions
	 */
	public java.lang.String getImportDeliveryInstructions () {
		return importDeliveryInstructions;
	}

	/**
	 * Set the value related to the column: ImportDeliveryInstructions
	 * @param importDeliveryInstructions the ImportDeliveryInstructions value
	 */
	public void setImportDeliveryInstructions (java.lang.String importDeliveryInstructions) {
		this.importDeliveryInstructions = importDeliveryInstructions;
	}



	/**
	 * Return the value associated with the column: PODPier
	 */
	public java.lang.String getPODPier () {
		return pODPier;
	}

	/**
	 * Set the value related to the column: PODPier
	 * @param pODPier the PODPier value
	 */
	public void setPODPier (java.lang.String pODPier) {
		this.pODPier = pODPier;
	}



	/**
	 * Return the value associated with the column: Memo4
	 */
	public java.lang.String getMemo4 () {
		return memo4;
	}

	/**
	 * Set the value related to the column: Memo4
	 * @param memo4 the Memo4 value
	 */
	public void setMemo4 (java.lang.String memo4) {
		this.memo4 = memo4;
	}



	/**
	 * Return the value associated with the column: FwdAgentRef
	 */
	public java.lang.String getFwdAgentRef () {
		return fwdAgentRef;
	}

	/**
	 * Set the value related to the column: FwdAgentRef
	 * @param fwdAgentRef the FwdAgentRef value
	 */
	public void setFwdAgentRef (java.lang.String fwdAgentRef) {
		this.fwdAgentRef = fwdAgentRef;
	}



	/**
	 * Return the value associated with the column: fromcontact
	 */
	public java.lang.String getFromcontact () {
		return fromcontact;
	}

	/**
	 * Set the value related to the column: fromcontact
	 * @param fromcontact the fromcontact value
	 */
	public void setFromcontact (java.lang.String fromcontact) {
		this.fromcontact = fromcontact;
	}



	/**
	 * Return the value associated with the column: Rate
	 */
	public java.lang.String getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: Rate
	 * @param rate the Rate value
	 */
	public void setRate (java.lang.String rate) {
		this.rate = rate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.print.Printhdr)) return false;
		else {
			com.bureaueye.beacon.model.print.Printhdr printhdr = (com.bureaueye.beacon.model.print.Printhdr) obj;
			if (null == this.getPrinthdrId() || null == printhdr.getPrinthdrId()) return false;
			else return (this.getPrinthdrId().equals(printhdr.getPrinthdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPrinthdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPrinthdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}