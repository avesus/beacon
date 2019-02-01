package com.bureaueye.beacon.form.print;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.model.print.Companyheader;


/**
 * Amendments
 * ----------
 *
 * NT	2009-10-26		ITT-200910-0002		Quotation Letter (changes not marked)
 *  												
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 */
public final class PrinthdrForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String _action;
	private String _readonly;
	private String _btnsubmit;
	private String _language;
	
	
	// keys
	private java.lang.String _printhdrId;
	private java.lang.String _orderhdrId;
	private java.lang.String _quohdrId;
	private java.lang.String _contractId;
	private java.lang.String _onhireId;
	private java.lang.String _offhireId;
	private java.lang.String _jobhdrId;
	private java.lang.String _jobmovId;
	private java.lang.String _companyheaderId;
	private java.lang.String _printId;
	
	
	// fields
	private java.lang.String _refreshdata;
	
	private java.lang.String _jobNumber;
	private java.lang.String _reportType;							
	private java.lang.String _bookingNumber;				
	private java.lang.String _memo1;
	private java.lang.String _memo2;
	private java.lang.String _memo3;
	private java.lang.String _memo4;
	private java.lang.String _memo5;			
	private java.lang.String _memo6;
	private java.lang.String _memo7;
	private java.lang.String _memo8;			
	private java.lang.String _memo9;			
	private java.lang.String _memo10;
	private java.lang.String _memo11;
	private java.lang.String _shipper;			
	private java.lang.String _consignee;
	private java.lang.String _customer;
	private java.lang.String _customerRef;
	private java.lang.String _shipMethod;
	
	private java.lang.String _consigneeAddress2;
	//private java.lang.String _shipperMblAddress3;
	//private java.lang.String _collectTotal = "0.00";;
	//private java.lang.String _notifyCSZC;
	//private java.lang.String _shipperMblCSZC;
	private java.lang.String _consigneeAddress3;
	private java.lang.String _shipLine;
	//private java.lang.String _collect;
	//private java.lang.String _drArrivedTime;
	private java.lang.String _vesselVoyage;
	//private java.lang.String _oceanFreight = "0.00";;
	private java.lang.String _notifyAddress3;
	private java.lang.String _pod;
	private java.lang.String _vessel;
	//private java.lang.String _numberOfTanks;
	private java.lang.String _consigneeRef;
	//private java.lang.String _inlandfreightccy;
	private java.lang.String _voyage;
	//private java.lang.String _emergency1;
	//private java.lang.String _inlandFreight = "0.00";;
	private java.lang.String _placeOfReceipt;
	private java.lang.String _shipperAddress1;
	//private java.lang.String _brokerContact;
	private java.lang.String _fwdAgent;
	//private java.lang.String _drUnloadedTime;
	//private java.lang.String _shipperDrAddress1;
	//private java.lang.String _hbl;
	//private java.lang.String _memo12;
	private java.lang.String _shipperRef;
	private java.lang.String _finalDelivery;
	private java.lang.String _consigneeAddress1;
	//private java.lang.String _shipperMbl;
	//private java.lang.String _pOLDateMonth;
	private java.lang.String _brokerAddress3;
	//private java.lang.String _chk3;
//	private java.lang.String _pOLPier;
	private java.lang.String _shipperAddress2;
	//private java.lang.String _pOLDateYear;
	private java.lang.String _rate = "0.00";
	private java.lang.String _rateccy;
//	private java.lang.String _shipperDrCSZC;
//	private java.lang.String _shipperCSZC;
	private java.lang.String _preCarriageBy;
//	private java.lang.String _prepaid;
	private java.lang.String _cutoffDateTime;
//	private java.lang.String _drCheckedBy;
	private java.lang.String _fwdAgentAddress2;
	private java.lang.String _shipperAddress3;
//	private java.lang.String _regarding;
	private java.lang.String _containerized;
	private java.lang.String _exportTruckInstructions;
	private java.lang.String _weightPerTankAprox;
	private java.lang.String _brokerAddress1;
//	private java.lang.String _prepaidTotal = "0.00";
//	private java.lang.String _chk1;
	private java.lang.String _brokerAddress2;
//	private java.lang.String _bafPerTank = "0.00";
//	private java.lang.String _brokerCSZC;
	private java.lang.String _customerAddress3;
	private java.lang.String _weightType;
//	private java.lang.String _pOLDateDay;
//	private java.lang.String _oceanfreightccy;
//	private java.lang.String _prepaidTotal2;
	private java.lang.String _brokerFax;
	private java.lang.String _notifyRef;
	private java.lang.String _fwdAgentFax;
	private java.lang.String _shipperFax;
//	private java.lang.String _shipperDr;
//	private java.lang.String _mbl;
//	private java.lang.String _collectTotal2;
//	private java.lang.String _freightCharge = "0.00";
	private java.lang.String _fwdAgentAddress3;
//	private java.lang.String _customerCSZC;
//	private java.lang.String _consigneeCSZC;
	private java.lang.String _consigneeFax;
	private java.lang.String _pickupPlant;
//	private java.lang.String _shipperMblAddress2;
//	private java.lang.String _truckerImport;
	private java.lang.String _notifyAddress1;
	private java.lang.String _notifyContact;
//	private java.lang.String _pickupPlantState;
	private java.lang.String _fromcontact;
	private java.lang.String _pol;
//	private java.lang.String _fwdAgentCSZC;
	private java.lang.String _fwdAgentAddress1;
//	private java.lang.String _drLighterTruck;
//	private java.lang.String _shipperDrAddress3;
//	private java.lang.String _subjectToCorrection;
	private java.lang.String _notifyFax;
	private java.lang.String _notifyAddress2;
//	private java.lang.String _shipperDrAddress2;
//	private java.lang.String _notifyCompany;
	private java.lang.String _customerFax;
	private java.lang.String _customerAddress1;
//	private java.lang.String _chk2;
	private java.lang.String _exportInstructions;
	private java.lang.String _customerAddress2;
//	private java.lang.String _shipperMblAddress1;
//	private java.lang.String _importDeliveryInstructions;
//	private java.lang.String _pODPier;
	private java.lang.String _broker;
	private java.lang.String _fwdAgentRef;
	
	
//	private java.util.Date _pODdate;
//	private java.util.Date _drUnloadedDate;
	
	private java.lang.String _finalDeliveryDateEstdd;
	private java.lang.String _finalDeliveryDateEstmm;
	private java.lang.String _finalDeliveryDateEstyyyy;
	
//	private java.util.Date _drArrivedDate;
	private java.lang.String _reportDatedd;
	private java.lang.String _reportDatemm;
	private java.lang.String _reportDateyyyy;
	
	private java.lang.String _pOLdateEstdd;
	private java.lang.String _pOLdateEstmm;
	private java.lang.String _pOLdateEstyyyy;
	
	private java.lang.String _pODdateEstdd;
	private java.lang.String _pODdateEstmm;
	private java.lang.String _pODdateEstyyyy;
	

	private java.lang.String _dmrgccykey;//ITT-201001-0001
	
	
	// objects
	Companyheader _companyheader;
	
	
	// collections
	private java.util.Set _printdtls;
	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}
	
	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public String getBtnSubmit() {return _btnsubmit;}
	public void setBtnSubmit(String _btnsubmit) {this._btnsubmit = _btnsubmit;}
	
	public String getLanguage() {return _language;}
	public void setLanguage(String _language) {this._language = _language;}
	

	public String getDmrgccykey() {return _dmrgccykey;}//ITT-201001-0001
	public void setDmrgccykey(String _dmrgccykey) {this._dmrgccykey = _dmrgccykey;}//ITT-201001-0001
	
	
	/**
	 */
	public java.lang.String getPrinthdrId () {return _printhdrId;}
	/**
	 */
	public void setPrinthdrId (java.lang.String _printhdrId) {this._printhdrId = _printhdrId;}
	
	
	/**
	 */
	public java.lang.String getContractId () {return _contractId;}
	/**
	 */
	public void setContractId (java.lang.String _contractId) {this._contractId = _contractId;}
	
	/**
	 */
	public java.lang.String getOnhireId () {return _onhireId;}
	/**
	 */
	public void setOnhireId (java.lang.String _onhireId) {this._onhireId = _onhireId;}
	
	/**
	 */
	public java.lang.String getOffhireId () {return _offhireId;}
	/**
	 */
	public void setOffhireId (java.lang.String _offhireId) {this._offhireId = _offhireId;}
	
	
	
	/**
	 */
	public java.lang.String getOrderhdrId () {return _orderhdrId;}
	/**
	 */
	public void setOrderhdrId (java.lang.String _orderhdrId) {this._orderhdrId = _orderhdrId;}
	
	
	
	/**
	 */
	public java.lang.String getQuohdrId () {return _quohdrId;}
	/**
	 */
	public void setQuohdrId (java.lang.String _quohdrId) {this._quohdrId = _quohdrId;}
	
	
	
	/**
	 */
	public java.lang.String getJobhdrId () {return _jobhdrId;}
	/**
	 */
	public void setJobhdrId (java.lang.String _jobhdrId) {this._jobhdrId = _jobhdrId;}
	

	/**
	 */
	public java.lang.String getJobmovId () {return _jobmovId;}
	/**
	 */
	public void setJobmovId (java.lang.String _jobmovId) {this._jobmovId = _jobmovId;}
	
	
	/**
	 */
	public java.lang.String getPrintId () {return _printId;}
	/**
	 */
	public void setPrintId (java.lang.String _printId) {this._printId = _printId;}
	
	
	/**
	 */
	public java.lang.String getRefreshdata() {return _refreshdata;}
	/**
	 */
	public void setRefreshdata (java.lang.String _refreshdata) {this._refreshdata = _refreshdata;}
	
	
	
	/**
	 */
	public java.lang.String getCompanyheaderId () {return _companyheaderId;}
	/**
	 */
	public void setCompanyheaderId (java.lang.String _companyheaderId) {this._companyheaderId = _companyheaderId;}
	
	
	
	
	/**
	 * Return the value associated with the column: ConsigneeAddress2
	 */
	public java.lang.String getConsigneeAddress2 () {
		return _consigneeAddress2;
	}
	
	/**
	 * Set the value related to the column: ConsigneeAddress2
	 * @param _consigneeAddress2 the ConsigneeAddress2 value
	 */
	public void setConsigneeAddress2 (java.lang.String _consigneeAddress2) {
		this._consigneeAddress2 = _consigneeAddress2;
	}
	
	
	
	
	
	
	
//	/**
//	* Return the value associated with the column: ShipperMblAddress3
//	*/
//	public java.lang.String getShipperMblAddress3 () {
//	return _shipperMblAddress3;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperMblAddress3
//	* @param _shipperMblAddress3 the ShipperMblAddress3 value
//	*/
//	public void setShipperMblAddress3 (java.lang.String _shipperMblAddress3) {
//	this._shipperMblAddress3 = _shipperMblAddress3;
//	}
//	
//	
//	
//	
//	/**
//	* Return the value associated with the column: CollectTotal
//	*/
//	public java.lang.String getCollectTotal () {
//	return _collectTotal;
//	}
//	
//	/**
//	* Set the value related to the column: CollectTotal
//	* @param _collectTotal the CollectTotal value
//	*/
//	public void setCollectTotal (java.lang.String _collectTotal) {
//	this._collectTotal = _collectTotal;
//	}
	
	
	
	
	/**
	 * Return the value associated with the column: Memo9
	 */
	public java.lang.String getMemo9 () {
		return _memo9;
	}
	
	/**
	 * Set the value related to the column: Memo9
	 * @param _memo9 the Memo9 value
	 */
	public void setMemo9 (java.lang.String _memo9) {
		this._memo9 = _memo9;
	}
	
	
//	/**
//	* Return the value associated with the column: NotifyCSZC
//	*/
//	public java.lang.String getNotifyCSZC () {
//	return _notifyCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: NotifyCSZC
//	* @param _notifyCSZC the NotifyCSZC value
//	*/
//	public void setNotifyCSZC (java.lang.String _notifyCSZC) {
//	this._notifyCSZC = _notifyCSZC;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperMblCSZC
//	*/
//	public java.lang.String getShipperMblCSZC () {
//	return _shipperMblCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperMblCSZC
//	* @param _shipperMblCSZC the ShipperMblCSZC value
//	*/
//	public void setShipperMblCSZC (java.lang.String _shipperMblCSZC) {
//	this._shipperMblCSZC = _shipperMblCSZC;
//	}
//	
//	
	/**
	 * Return the value associated with the column: ConsigneeAddress3
	 */
	public java.lang.String getConsigneeAddress3 () {
		return _consigneeAddress3;
	}
	
	/**
	 * Set the value related to the column: ConsigneeAddress3
	 * @param _consigneeAddress3 the ConsigneeAddress3 value
	 */
	public void setConsigneeAddress3 (java.lang.String _consigneeAddress3) {
		this._consigneeAddress3 = _consigneeAddress3;
	}
//	
//	
	/**
	 * Return the value associated with the column: ShipLine
	 */
	public java.lang.String getShipLine () {
		return _shipLine;
	}
	
	/**
	 * Set the value related to the column: ShipLine
	 * @param _shipLine the ShipLine value
	 */
	public void setShipLine (java.lang.String _shipLine) {
		this._shipLine = _shipLine;
	}
//	
//	
//	/**
//	* Return the value associated with the column: Collect
//	*/
//	public java.lang.String getCollect () {
//	return _collect;
//	}
//	
//	/**
//	* Set the value related to the column: Collect
//	* @param _collect the Collect value
//	*/
//	public void setCollect (java.lang.String _collect) {
//	this._collect = _collect;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: drArrivedTime
//	*/
//	public java.lang.String getDrArrivedTime () {
//	return _drArrivedTime;
//	}
//	
//	/**
//	* Set the value related to the column: drArrivedTime
//	* @param _drArrivedTime the drArrivedTime value
//	*/
//	public void setDrArrivedTime (java.lang.String _drArrivedTime) {
//	this._drArrivedTime = _drArrivedTime;
//	}
//	
//	
	/**
	 * Return the value associated with the column: VesselVoyage
	 */
	public java.lang.String getVesselVoyage () {
		return _vesselVoyage;
	}
	
	/**
	 * Set the value related to the column: VesselVoyage
	 * @param _vesselVoyage the VesselVoyage value
	 */
	public void setVesselVoyage (java.lang.String _vesselVoyage) {
		this._vesselVoyage = _vesselVoyage;
	}
	
	
	
	/**
	 * Return the value associated with the column: Memo3
	 */
	public java.lang.String getMemo3 () {
		return _memo3;
	}
	
	/**
	 * Set the value related to the column: Memo3
	 * @param _memo3 the Memo3 value
	 */
	public void setMemo3 (java.lang.String _memo3) {
		this._memo3 = _memo3;
	}
	
	
	/**
	 * Return the value associated with the column: Memo11
	 */
	public java.lang.String getMemo11 () {
		return _memo11;
	}
	
	/**
	 * Set the value related to the column: Memo11
	 * @param _memo11 the Memo11 value
	 */
	public void setMemo11 (java.lang.String _memo11) {
		this._memo11 = _memo11;
	}
	
	
	/**
	 * Return the value associated with the column: NotifyAddress3
	 */
	public java.lang.String getNotifyAddress3 () {
		return _notifyAddress3;
	}
	
	/**
	 * Set the value related to the column: NotifyAddress3
	 * @param _notifyAddress3 the NotifyAddress3 value
	 */
	public void setNotifyAddress3 (java.lang.String _notifyAddress3) {
		this._notifyAddress3 = _notifyAddress3;
	}
	
	
	/**
	 * Return the value associated with the column: POD
	 */
	public java.lang.String getPod () {
		return _pod;
	}
	
	/**
	 * Set the value related to the column: POD
	 * @param _pod the POD value
	 */
	public void setPod (java.lang.String _pod) {
		this._pod = _pod;
	}
	
	
	/**
	 * Return the value associated with the column: Vessel
	 */
	public java.lang.String getVessel () {
		return _vessel;
	}
	
	/**
	 * Set the value related to the column: Vessel
	 * @param _vessel the Vessel value
	 */
	public void setVessel (java.lang.String _vessel) {
		this._vessel = _vessel;
	}
//	
//	
//	/**
//	* Return the value associated with the column: NumberOfTanks
//	*/
//	public java.lang.String getNumberOfTanks () {
//	return _numberOfTanks;
//	}
//	
//	/**
//	* Set the value related to the column: NumberOfTanks
//	* @param _numberOfTanks the NumberOfTanks value
//	*/
//	public void setNumberOfTanks (java.lang.String _numberOfTanks) {
//	this._numberOfTanks = _numberOfTanks;
//	}
//	
//	
	/**
	 * Return the value associated with the column: ConsigneeRef
	 */
	public java.lang.String getConsigneeRef () {
		return _consigneeRef;
	}
	
	/**
	 * Set the value related to the column: ConsigneeRef
	 * @param _consigneeRef the ConsigneeRef value
	 */
	public void setConsigneeRef (java.lang.String _consigneeRef) {
		this._consigneeRef = _consigneeRef;
	}
	
	
	/**
	 * Return the value associated with the column: Memo7
	 */
	public java.lang.String getMemo7 () {
		return _memo7;
	}
	
	/**
	 * Set the value related to the column: Memo7
	 * @param _memo7 the Memo7 value
	 */
	public void setMemo7 (java.lang.String _memo7) {
		this._memo7 = _memo7;
	}
	
	
//	/**
//	* Return the value associated with the column: inlandfreightccy
//	*/
//	public java.lang.String getInlandfreightccy () {
//	return _inlandfreightccy;
//	}
//	
//	/**
//	* Set the value related to the column: inlandfreightccy
//	* @param _inlandfreightccy the inlandfreightccy value
//	*/
//	public void setInlandfreightccy (java.lang.String _inlandfreightccy) {
//	this._inlandfreightccy = _inlandfreightccy;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: PODdate
//	*/
//	public java.util.Date getPODdate_ () {
//	return _pODdate;
//	}
//	
//	/**
//	* Set the value related to the column: PODdate
//	* @param _pODdate the PODdate value
//	*/
//	public void setPODdate_ (java.util.Date _pODdate) {
//	this._pODdate = _pODdate;
//	}
//	
//	
	/**
	 * Return the value associated with the column: Voyage
	 */
	public java.lang.String getVoyage () {
		return _voyage;
	}
	
	/**
	 * Set the value related to the column: Voyage
	 * @param _voyage the Voyage value
	 */
	public void setVoyage (java.lang.String _voyage) {
		this._voyage = _voyage;
	}
//	
//	
//	/**
//	* Return the value associated with the column: Emergency1
//	*/
//	public java.lang.String getEmergency1 () {
//	return _emergency1;
//	}
//	
//	/**
//	* Set the value related to the column: Emergency1
//	* @param _emergency1 the Emergency1 value
//	*/
//	public void setEmergency1 (java.lang.String _emergency1) {
//	this._emergency1 = _emergency1;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: InlandFreight
//	*/
//	public java.lang.String getInlandFreight () {
//	return _inlandFreight;
//	}
//	
//	/**
//	* Set the value related to the column: InlandFreight
//	* @param _inlandFreight the InlandFreight value
//	*/
//	public void setInlandFreight (java.lang.String _inlandFreight) {
//	this._inlandFreight = _inlandFreight;
//	}
//	
//	
	/**
	 * Return the value associated with the column: PlaceOfReceipt
	 */
	public java.lang.String getPlaceOfReceipt () {
		return _placeOfReceipt;
	}
	
	/**
	 * Set the value related to the column: PlaceOfReceipt
	 * @param _placeOfReceipt the PlaceOfReceipt value
	 */
	public void setPlaceOfReceipt (java.lang.String _placeOfReceipt) {
		this._placeOfReceipt = _placeOfReceipt;
	}
	
	
	/**
	 * Return the value associated with the column: Memo1
	 */
	public java.lang.String getMemo1 () {
		return _memo1;
	}
	
	/**
	 * Set the value related to the column: Memo1
	 * @param _memo1 the Memo1 value
	 */
	public void setMemo1 (java.lang.String _memo1) {
		this._memo1 = _memo1;
	}
	
	
//	/**
//	* Return the value associated with the column: drUnloadedDate
//	*/
//	public java.util.Date getDrUnloadedDate_ () {
//	return _drUnloadedDate;
//	}
//	
//	/**
//	* Set the value related to the column: drUnloadedDate
//	* @param _drUnloadedDate the drUnloadedDate value
//	*/
//	public void setDrUnloadedDate_ (java.util.Date _drUnloadedDate) {
//	this._drUnloadedDate = _drUnloadedDate;
//	}
//	
//	
	/**
	 * Return the value associated with the column: ShipperAddress1
	 */
	public java.lang.String getShipperAddress1 () {
		return _shipperAddress1;
	}
	
	/**
	 * Set the value related to the column: ShipperAddress1
	 * @param _shipperAddress1 the ShipperAddress1 value
	 */
	public void setShipperAddress1 (java.lang.String _shipperAddress1) {
		this._shipperAddress1 = _shipperAddress1;
	}
//	
//	
//	
//	/**
//	* Return the value associated with the column: BrokerContact
//	*/
//	public java.lang.String getBrokerContact () {
//	return _brokerContact;
//	}
//	
//	/**
//	* Set the value related to the column: BrokerContact
//	* @param _brokerContact the BrokerContact value
//	*/
//	public void setBrokerContact (java.lang.String _brokerContact) {
//	this._brokerContact = _brokerContact;
//	}
//	
//	
//	
//	
	/**
	 * Return the value associated with the column: FwdAgent
	 */
	public java.lang.String getFwdAgent () {
		return _fwdAgent;
	}
	
	/**
	 * Set the value related to the column: FwdAgent
	 * @param _fwdAgent the FwdAgent value
	 */
	public void setFwdAgent (java.lang.String _fwdAgent) {
		this._fwdAgent = _fwdAgent;
	}
	
	
	/**
	 * Return the value associated with the column: JobNumber
	 */
	public java.lang.String getJobNumber () {
		return _jobNumber;
	}
	
	/**
	 * Set the value related to the column: JobNumber
	 * @param _jobNumber the JobNumber value
	 */
	public void setJobNumber (java.lang.String _jobNumber) {
		this._jobNumber = _jobNumber;
	}
	
	
//	/**
//	* Return the value associated with the column: drUnloadedTime
//	*/
//	public java.lang.String getDrUnloadedTime () {
//	return _drUnloadedTime;
//	}
//	
//	/**
//	* Set the value related to the column: drUnloadedTime
//	* @param _drUnloadedTime the drUnloadedTime value
//	*/
//	public void setDrUnloadedTime (java.lang.String _drUnloadedTime) {
//	this._drUnloadedTime = _drUnloadedTime;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperDrAddress1
//	*/
//	public java.lang.String getShipperDrAddress1 () {
//	return _shipperDrAddress1;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperDrAddress1
//	* @param _shipperDrAddress1 the ShipperDrAddress1 value
//	*/
//	public void setShipperDrAddress1 (java.lang.String _shipperDrAddress1) {
//	this._shipperDrAddress1 = _shipperDrAddress1;
//	}
//	
//	
//	
//	/**
//	* Return the value associated with the column: drArrivedDate
//	*/
//	public java.util.Date getDrArrivedDate_ () {
//	return _drArrivedDate;
//	}
//	
//	/**
//	* Set the value related to the column: drArrivedDate
//	* @param _drArrivedDate the drArrivedDate value
//	*/
//	public void setDrArrivedDate_ (java.util.Date _drArrivedDate) {
//	this._drArrivedDate = _drArrivedDate;
//	}
	
	
	/**
	 * Return the value associated with the column: Consignee
	 */
	public java.lang.String getConsignee () {
		return _consignee;
	}
	
	/**
	 * Set the value related to the column: Consignee
	 * @param _consignee the Consignee value
	 */
	public void setConsignee (java.lang.String _consignee) {
		this._consignee = _consignee;
	}
	
	
//	/**
//	* Return the value associated with the column: HBL
//	*/
//	public java.lang.String getHbl () {
//	return _hbl;
//	}
//	
//	/**
//	* Set the value related to the column: HBL
//	* @param _hbl the HBL value
//	*/
//	public void setHbl (java.lang.String _hbl) {
//	this._hbl = _hbl;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: Memo12
//	*/
//	public java.lang.String getMemo12 () {
//	return _memo12;
//	}
//	
//	/**
//	* Set the value related to the column: Memo12
//	* @param _memo12 the Memo12 value
//	*/
//	public void setMemo12 (java.lang.String _memo12) {
//	this._memo12 = _memo12;
//	}
	
	
	/**
	 * Return the value associated with the column: Memo2
	 */
	public java.lang.String getMemo2 () {
		return _memo2;
	}
	
	/**
	 * Set the value related to the column: Memo2
	 * @param _memo2 the Memo2 value
	 */
	public void setMemo2 (java.lang.String _memo2) {
		this._memo2 = _memo2;
	}
	
	
	/**
	 * Return the value associated with the column: ShipperRef
	 */
	public java.lang.String getShipperRef () {
		return _shipperRef;
	}
	
	/**
	 * Set the value related to the column: ShipperRef
	 * @param _shipperRef the ShipperRef value
	 */
	public void setShipperRef (java.lang.String _shipperRef) {
		this._shipperRef = _shipperRef;
	}
	
	
	/**
	 * Return the value associated with the column: FinalDelivery
	 */
	public java.lang.String getFinalDelivery () {
		return _finalDelivery;
	}
	
	/**
	 * Set the value related to the column: FinalDelivery
	 * @param _finalDelivery the FinalDelivery value
	 */
	public void setFinalDelivery (java.lang.String _finalDelivery) {
		this._finalDelivery = _finalDelivery;
	}
	
	
	/**
	 * Return the value associated with the column: ConsigneeAddress1
	 */
	public java.lang.String getConsigneeAddress1 () {
		return _consigneeAddress1;
	}
	
	/**
	 * Set the value related to the column: ConsigneeAddress1
	 * @param _consigneeAddress1 the ConsigneeAddress1 value
	 */
	public void setConsigneeAddress1 (java.lang.String _consigneeAddress1) {
		this._consigneeAddress1 = _consigneeAddress1;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperMbl
//	*/
//	public java.lang.String getShipperMbl () {
//	return _shipperMbl;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperMbl
//	* @param _shipperMbl the ShipperMbl value
//	*/
//	public void setShipperMbl (java.lang.String _shipperMbl) {
//	this._shipperMbl = _shipperMbl;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: POLDateMonth
//	*/
//	public java.lang.String getPOLDateMonth () {
//	return _pOLDateMonth;
//	}
//	
//	/**
//	* Set the value related to the column: POLDateMonth
//	* @param _pOLDateMonth the POLDateMonth value
//	*/
//	public void setPOLDateMonth (java.lang.String _pOLDateMonth) {
//	this._pOLDateMonth = _pOLDateMonth;
//	}
//	
//	
//	
//	
	/**
	 * Return the value associated with the column: BrokerAddress3
	 */
	public java.lang.String getBrokerAddress3 () {
		return _brokerAddress3;
	}
	
	/**
	 * Set the value related to the column: BrokerAddress3
	 * @param _brokerAddress3 the BrokerAddress3 value
	 */
	public void setBrokerAddress3 (java.lang.String _brokerAddress3) {
		this._brokerAddress3 = _brokerAddress3;
	}
	
	
	/**
	 * Return the value associated with the column: ReportType
	 */
	public java.lang.String getReportType () {
		return _reportType;
	}
	
	/**
	 * Set the value related to the column: ReportType
	 * @param _reportType the ReportType value
	 */
	public void setReportType (java.lang.String _reportType) {
		this._reportType = _reportType;
	}
	
	
//	/**
//	* Return the value associated with the column: Chk3
//	*/
//	public java.lang.String getChk3 () {
//	return _chk3;
//	}
//	
//	/**
//	* Set the value related to the column: Chk3
//	* @param _chk3 the Chk3 value
//	*/
//	public void setChk3 (java.lang.String _chk3) {
//	this._chk3 = _chk3;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: POLPier
//	*/
//	public java.lang.String getPOLPier () {
//	return _pOLPier;
//	}
//	
//	/**
//	* Set the value related to the column: POLPier
//	* @param _pOLPier the POLPier value
//	*/
//	public void setPOLPier (java.lang.String _pOLPier) {
//	this._pOLPier = _pOLPier;
//	}
//	
//	
	/**
	 * Return the value associated with the column: ShipperAddress2
	 */
	public java.lang.String getShipperAddress2 () {
		return _shipperAddress2;
	}
	
	/**
	 * Set the value related to the column: ShipperAddress2
	 * @param _shipperAddress2 the ShipperAddress2 value
	 */
	public void setShipperAddress2 (java.lang.String _shipperAddress2) {
		this._shipperAddress2 = _shipperAddress2;
	}
//	
//	
//	/**
//	* Return the value associated with the column: POLDateYear
//	*/
//	public java.lang.String getPOLDateYear () {
//	return _pOLDateYear;
//	}
//	
//	/**
//	* Set the value related to the column: POLDateYear
//	* @param _pOLDateYear the POLDateYear value
//	*/
//	public void setPOLDateYear (java.lang.String _pOLDateYear) {
//	this._pOLDateYear = _pOLDateYear;
//	}
//	
//	
	
	
	
	
	/**
	 * Return the value associated with the column: Rate
	 */
	public java.lang.String getRate () {
		return _rate;
	}
	
	/**
	 * Set the value related to the column: Rate
	 * @param _rate the Rate value
	 */
	public void setRate (java.lang.String _rate) {
		this._rate = _rate;
	}
	
	
	/**
	 * Return the value associated with the column: rateccy
	 */
	public java.lang.String getRateccy () {
		return _rateccy;
	}
	
	/**
	 * Set the value related to the column: rateccy
	 * @param _rateccy the rateccy value
	 */
	public void setRateccy (java.lang.String _rateccy) {
		this._rateccy = _rateccy;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperDrCSZC
//	*/
//	public java.lang.String getShipperDrCSZC () {
//	return _shipperDrCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperDrCSZC
//	* @param _shipperDrCSZC the ShipperDrCSZC value
//	*/
//	public void setShipperDrCSZC (java.lang.String _shipperDrCSZC) {
//	this._shipperDrCSZC = _shipperDrCSZC;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperCSZC
//	*/
//	public java.lang.String getShipperCSZC () {
//	return _shipperCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperCSZC
//	* @param _shipperCSZC the ShipperCSZC value
//	*/
//	public void setShipperCSZC (java.lang.String _shipperCSZC) {
//	this._shipperCSZC = _shipperCSZC;
//	}
//	
//	
	/**
	 * Return the value associated with the column: PreCarriageBy
	 */
	public java.lang.String getPreCarriageBy () {
		return _preCarriageBy;
	}
	
	/**
	 * Set the value related to the column: PreCarriageBy
	 * @param _preCarriageBy the PreCarriageBy value
	 */
	public void setPreCarriageBy (java.lang.String _preCarriageBy) {
		this._preCarriageBy = _preCarriageBy;
	}
//	
//	
//	/**
//	* Return the value associated with the column: Prepaid
//	*/
//	public java.lang.String getPrepaid () {
//	return _prepaid;
//	}
//	
//	/**
//	* Set the value related to the column: Prepaid
//	* @param _prepaid the Prepaid value
//	*/
//	public void setPrepaid (java.lang.String _prepaid) {
//	this._prepaid = _prepaid;
//	}
//	
//	
	/**
	 * Return the value associated with the column: CutoffDateTime
	 */
	public java.lang.String getCutoffDateTime () {
		return _cutoffDateTime;
	}
	
	/**
	 * Set the value related to the column: CutoffDateTime
	 * @param _cutoffDateTime the CutoffDateTime value
	 */
	public void setCutoffDateTime (java.lang.String _cutoffDateTime) {
		this._cutoffDateTime = _cutoffDateTime;
	}
//	
//	
//	/**
//	* Return the value associated with the column: drCheckedBy
//	*/
//	public java.lang.String getDrCheckedBy () {
//	return _drCheckedBy;
//	}
//	
//	/**
//	* Set the value related to the column: drCheckedBy
//	* @param _drCheckedBy the drCheckedBy value
//	*/
//	public void setDrCheckedBy (java.lang.String _drCheckedBy) {
//	this._drCheckedBy = _drCheckedBy;
//	}
//	
//	
	/**
	 * Return the value associated with the column: FwdAgentAddress2
	 */
	public java.lang.String getFwdAgentAddress2 () {
		return _fwdAgentAddress2;
	}
	
	/**
	 * Set the value related to the column: FwdAgentAddress2
	 * @param _fwdAgentAddress2 the FwdAgentAddress2 value
	 */
	public void setFwdAgentAddress2 (java.lang.String _fwdAgentAddress2) {
		this._fwdAgentAddress2 = _fwdAgentAddress2;
	}
	
	
	/**
	 * Return the value associated with the column: ShipperAddress3
	 */
	public java.lang.String getShipperAddress3 () {
		return _shipperAddress3;
	}
	
	/**
	 * Set the value related to the column: ShipperAddress3
	 * @param _shipperAddress3 the ShipperAddress3 value
	 */
	public void setShipperAddress3 (java.lang.String _shipperAddress3) {
		this._shipperAddress3 = _shipperAddress3;
	}
//	
//	
//	/**
//	* Return the value associated with the column: Regarding
//	*/
//	public java.lang.String getRegarding () {
//	return _regarding;
//	}
//	
//	/**
//	* Set the value related to the column: Regarding
//	* @param _regarding the Regarding value
//	*/
//	public void setRegarding (java.lang.String _regarding) {
//	this._regarding = _regarding;
//	}
//	
//	
	/**
	 * Return the value associated with the column: Containerized
	 */
	public java.lang.String getContainerized () {
		return _containerized;
	}
	
	/**
	 * Set the value related to the column: Containerized
	 * @param _containerized the Containerized value
	 */
	public void setContainerized (java.lang.String _containerized) {
		this._containerized = _containerized;
	}
	
	
	/**
	 * Return the value associated with the column: ExportTruckInstructions
	 */
	public java.lang.String getExportTruckInstructions () {
		return _exportTruckInstructions;
	}
	
	/**
	 * Set the value related to the column: ExportTruckInstructions
	 * @param _exportTruckInstructions the ExportTruckInstructions value
	 */
	public void setExportTruckInstructions (java.lang.String _exportTruckInstructions) {
		this._exportTruckInstructions = _exportTruckInstructions;
	}
//	
//	
//	
//	
	/**
	 * Return the value associated with the column: WeightPerTankAprox
	 */
	public java.lang.String getWeightPerTankAprox () {
		return _weightPerTankAprox;
	}
	
	/**
	 * Set the value related to the column: WeightPerTankAprox
	 * @param _weightPerTankAprox the WeightPerTankAprox value
	 */
	public void setWeightPerTankAprox (java.lang.String _weightPerTankAprox) {
		this._weightPerTankAprox = _weightPerTankAprox;
	}
//	
//	
	/**
	 * Return the value associated with the column: BrokerAddress1
	 */
	public java.lang.String getBrokerAddress1 () {
		return _brokerAddress1;
	}
	
	/**
	 * Set the value related to the column: BrokerAddress1
	 * @param _brokerAddress1 the BrokerAddress1 value
	 */
	public void setBrokerAddress1 (java.lang.String _brokerAddress1) {
		this._brokerAddress1 = _brokerAddress1;
	}
//	
//	
//	/**
//	* Return the value associated with the column: PrepaidTotal
//	*/
//	public java.lang.String getPrepaidTotal () {
//	return _prepaidTotal;
//	}
//	
//	/**
//	* Set the value related to the column: PrepaidTotal
//	* @param _prepaidTotal the PrepaidTotal value
//	*/
//	public void setPrepaidTotal (java.lang.String _prepaidTotal) {
//	this._prepaidTotal = _prepaidTotal;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: Chk1
//	*/
//	public java.lang.String getChk1 () {
//	return _chk1;
//	}
//	
//	/**
//	* Set the value related to the column: Chk1
//	* @param _chk1 the Chk1 value
//	*/
//	public void setChk1 (java.lang.String _chk1) {
//	this._chk1 = _chk1;
//	}
//	
//	
	/**
	 * Return the value associated with the column: BrokerAddress2
	 */
	public java.lang.String getBrokerAddress2 () {
		return _brokerAddress2;
	}
	
	/**
	 * Set the value related to the column: BrokerAddress2
	 * @param _brokerAddress2 the BrokerAddress2 value
	 */
	public void setBrokerAddress2 (java.lang.String _brokerAddress2) {
		this._brokerAddress2 = _brokerAddress2;
	}
//	
//	
//	/**
//	* Return the value associated with the column: BafPerTank
//	*/
//	public java.lang.String getBafPerTank () {
//	return _bafPerTank;
//	}
//	
//	/**
//	* Set the value related to the column: BafPerTank
//	* @param _bafPerTank the BafPerTank value
//	*/
//	public void setBafPerTank (java.lang.String _bafPerTank) {
//	this._bafPerTank = _bafPerTank;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: BrokerCSZC
//	*/
//	public java.lang.String getBrokerCSZC () {
//	return _brokerCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: BrokerCSZC
//	* @param _brokerCSZC the BrokerCSZC value
//	*/
//	public void setBrokerCSZC (java.lang.String _brokerCSZC) {
//	this._brokerCSZC = _brokerCSZC;
//	}
	
	
	/**
	 * Return the value associated with the column: CustomerRef
	 */
	public java.lang.String getCustomerRef () {
		return _customerRef;
	}
	
	/**
	 * Set the value related to the column: CustomerRef
	 * @param _customerRef the CustomerRef value
	 */
	public void setCustomerRef (java.lang.String _customerRef) {
		this._customerRef = _customerRef;
	}
	
	
	/**
	 * Return the value associated with the column: CustomerAddress3
	 */
	public java.lang.String getCustomerAddress3 () {
		return _customerAddress3;
	}
	
	/**
	 * Set the value related to the column: CustomerAddress3
	 * @param _customerAddress3 the CustomerAddress3 value
	 */
	public void setCustomerAddress3 (java.lang.String _customerAddress3) {
		this._customerAddress3 = _customerAddress3;
	}
	
	
	/**
	 * Return the value associated with the column: Memo5
	 */
	public java.lang.String getMemo5 () {
		return _memo5;
	}
	
	/**
	 * Set the value related to the column: Memo5
	 * @param _memo5 the Memo5 value
	 */
	public void setMemo5 (java.lang.String _memo5) {
		this._memo5 = _memo5;
	}
	
	
	/**
	 * Return the value associated with the column: WeightType
	 */
	public java.lang.String getWeightType () {
		return _weightType;
	}
	
	/**
	 * Set the value related to the column: WeightType
	 * @param _weightType the WeightType value
	 */
	public void setWeightType (java.lang.String _weightType) {
		this._weightType = _weightType;
	}
//	
//	
//	/**
//	* Return the value associated with the column: POLDateDay
//	*/
//	public java.lang.String getPOLDateDay () {
//	return _pOLDateDay;
//	}
//	
//	/**
//	* Set the value related to the column: POLDateDay
//	* @param _pOLDateDay the POLDateDay value
//	*/
//	public void setPOLDateDay (java.lang.String _pOLDateDay) {
//	this._pOLDateDay = _pOLDateDay;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: oceanfreightccy
//	*/
//	public java.lang.String getOceanfreightccy () {
//	return _oceanfreightccy;
//	}
//	
//	/**
//	* Set the value related to the column: oceanfreightccy
//	* @param _oceanfreightccy the oceanfreightccy value
//	*/
//	public void setOceanfreightccy (java.lang.String _oceanfreightccy) {
//	this._oceanfreightccy = _oceanfreightccy;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: PrepaidTotal2
//	*/
//	public java.lang.String getPrepaidTotal2 () {
//	return _prepaidTotal2;
//	}
//	
//	/**
//	* Set the value related to the column: PrepaidTotal2
//	* @param _prepaidTotal2 the PrepaidTotal2 value
//	*/
//	public void setPrepaidTotal2 (java.lang.String _prepaidTotal2) {
//	this._prepaidTotal2 = _prepaidTotal2;
//	}
	
	
	/**
	 * Return the value associated with the column: BookingNumber
	 */
	public java.lang.String getBookingNumber () {
		return _bookingNumber;
	}
	
	/**
	 * Set the value related to the column: BookingNumber
	 * @param _bookingNumber the BookingNumber value
	 */
	public void setBookingNumber (java.lang.String _bookingNumber) {
		this._bookingNumber = _bookingNumber;
	}
	
	
	/**
	 * Return the value associated with the column: BrokerFax
	 */
	public java.lang.String getBrokerFax () {
		return _brokerFax;
	}
	
	/**
	 * Set the value related to the column: BrokerFax
	 * @param _brokerFax the BrokerFax value
	 */
	public void setBrokerFax (java.lang.String _brokerFax) {
		this._brokerFax = _brokerFax;
	}
	
	
	/**
	 * Return the value associated with the column: NotifyRef
	 */
	public java.lang.String getNotifyRef () {
		return _notifyRef;
	}
	
	/**
	 * Set the value related to the column: NotifyRef
	 * @param _notifyRef the NotifyRef value
	 */
	public void setNotifyRef (java.lang.String _notifyRef) {
		this._notifyRef = _notifyRef;
	}
	
	
	/**
	 * Return the value associated with the column: FwdAgentFax
	 */
	public java.lang.String getFwdAgentFax () {
		return _fwdAgentFax;
	}
	
	/**
	 * Set the value related to the column: FwdAgentFax
	 * @param _fwdAgentFax the FwdAgentFax value
	 */
	public void setFwdAgentFax (java.lang.String _fwdAgentFax) {
		this._fwdAgentFax = _fwdAgentFax;
	}
	
	
	/**
	 * Return the value associated with the column: ShipperFax
	 */
	public java.lang.String getShipperFax () {
		return _shipperFax;
	}
	
	/**
	 * Set the value related to the column: ShipperFax
	 * @param _shipperFax the ShipperFax value
	 */
	public void setShipperFax (java.lang.String _shipperFax) {
		this._shipperFax = _shipperFax;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperDr
//	*/
//	public java.lang.String getShipperDr () {
//	return _shipperDr;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperDr
//	* @param _shipperDr the ShipperDr value
//	*/
//	public void setShipperDr (java.lang.String _shipperDr) {
//	this._shipperDr = _shipperDr;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: MBL
//	*/
//	public java.lang.String getMbl () {
//	return _mbl;
//	}
//	
//	/**
//	* Set the value related to the column: MBL
//	* @param _mbl the MBL value
//	*/
//	public void setMbl (java.lang.String _mbl) {
//	this._mbl = _mbl;
//	}
//	
//	
//	
//	
//	/**
//	* Return the value associated with the column: CollectTotal2
//	*/
//	public java.lang.String getCollectTotal2 () {
//	return _collectTotal2;
//	}
//	
//	/**
//	* Set the value related to the column: CollectTotal2
//	* @param _collectTotal2 the CollectTotal2 value
//	*/
//	public void setCollectTotal2 (java.lang.String _collectTotal2) {
//	this._collectTotal2 = _collectTotal2;
//	}
//	
//	
//	
//	
//	/**
//	* Return the value associated with the column: FreightCharge
//	*/
//	public java.lang.String getFreightCharge () {
//	return _freightCharge;
//	}
//	
//	/**
//	* Set the value related to the column: FreightCharge
//	* @param _freightCharge the FreightCharge value
//	*/
//	public void setFreightCharge (java.lang.String _freightCharge) {
//	this._freightCharge = _freightCharge;
//	}
	
	
	/**
	 * Return the value associated with the column: Shipper
	 */
	public java.lang.String getShipper () {
		return _shipper;
	}
	
	/**
	 * Set the value related to the column: Shipper
	 * @param _shipper the Shipper value
	 */
	public void setShipper (java.lang.String _shipper) {
		this._shipper = _shipper;
	}
	
	
	/**
	 * Return the value associated with the column: FwdAgentAddress3
	 */
	public java.lang.String getFwdAgentAddress3 () {
		return _fwdAgentAddress3;
	}
	
	/**
	 * Set the value related to the column: FwdAgentAddress3
	 * @param _fwdAgentAddress3 the FwdAgentAddress3 value
	 */
	public void setFwdAgentAddress3 (java.lang.String _fwdAgentAddress3) {
		this._fwdAgentAddress3 = _fwdAgentAddress3;
	}
//	
//	
//	/**
//	* Return the value associated with the column: CustomerCSZC
//	*/
//	public java.lang.String getCustomerCSZC () {
//	return _customerCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: CustomerCSZC
//	* @param _customerCSZC the CustomerCSZC value
//	*/
//	public void setCustomerCSZC (java.lang.String _customerCSZC) {
//	this._customerCSZC = _customerCSZC;
//	}
	
	
	/**
	 * Return the value associated with the column: Memo10
	 */
	public java.lang.String getMemo10 () {
		return _memo10;
	}
	
	/**
	 * Set the value related to the column: Memo10
	 * @param _memo10 the Memo10 value
	 */
	public void setMemo10 (java.lang.String _memo10) {
		this._memo10 = _memo10;
	}
	
	
//	/**
//	* Return the value associated with the column: ConsigneeCSZC
//	*/
//	public java.lang.String getConsigneeCSZC () {
//	return _consigneeCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: ConsigneeCSZC
//	* @param _consigneeCSZC the ConsigneeCSZC value
//	*/
//	public void setConsigneeCSZC (java.lang.String _consigneeCSZC) {
//	this._consigneeCSZC = _consigneeCSZC;
//	}
	
	
	/**
	 * Return the value associated with the column: Customer
	 */
	public java.lang.String getCustomer () {
		return _customer;
	}
	
	/**
	 * Set the value related to the column: Customer
	 * @param _customer the Customer value
	 */
	public void setCustomer (java.lang.String _customer) {
		this._customer = _customer;
	}
	
	
	/**
	 * Return the value associated with the column: ConsigneeFax
	 */
	public java.lang.String getConsigneeFax () {
		return _consigneeFax;
	}
	
	/**
	 * Set the value related to the column: ConsigneeFax
	 * @param _consigneeFax the ConsigneeFax value
	 */
	public void setConsigneeFax (java.lang.String _consigneeFax) {
		this._consigneeFax = _consigneeFax;
	}
	
	
	/**
	 * Return the value associated with the column: PickupPlant
	 */
	public java.lang.String getPickupPlant () {
		return _pickupPlant;
	}
	
	/**
	 * Set the value related to the column: PickupPlant
	 * @param _pickupPlant the PickupPlant value
	 */
	public void setPickupPlant (java.lang.String _pickupPlant) {
		this._pickupPlant = _pickupPlant;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperMblAddress2
//	*/
//	public java.lang.String getShipperMblAddress2 () {
//	return _shipperMblAddress2;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperMblAddress2
//	* @param _shipperMblAddress2 the ShipperMblAddress2 value
//	*/
//	public void setShipperMblAddress2 (java.lang.String _shipperMblAddress2) {
//	this._shipperMblAddress2 = _shipperMblAddress2;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: TruckerImport
//	*/
//	public java.lang.String getTruckerImport () {
//	return _truckerImport;
//	}
//	
//	/**
//	* Set the value related to the column: TruckerImport
//	* @param _truckerImport the TruckerImport value
//	*/
//	public void setTruckerImport (java.lang.String _truckerImport) {
//	this._truckerImport = _truckerImport;
//	}
//	
//	
	/**
	 * Return the value associated with the column: NotifyAddress1
	 */
	public java.lang.String getNotifyAddress1 () {
		return _notifyAddress1;
	}
	
	/**
	 * Set the value related to the column: NotifyAddress1
	 * @param _notifyAddress1 the NotifyAddress1 value
	 */
	public void setNotifyAddress1 (java.lang.String _notifyAddress1) {
		this._notifyAddress1 = _notifyAddress1;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: NotifyContact
	 */
	public java.lang.String getNotifyContact () {
		return _notifyContact;
	}
	
	/**
	 * Set the value related to the column: NotifyContact
	 * @param _notifyContact the NotifyContact value
	 */
	public void setNotifyContact (java.lang.String _notifyContact) {
		this._notifyContact = _notifyContact;
	}
	
	
	/**
	 * Return the value associated with the column: ShipMethod
	 */
	public java.lang.String getShipMethod () {
		return _shipMethod;
	}
	
	/**
	 * Set the value related to the column: ShipMethod
	 * @param _shipMethod the ShipMethod value
	 */
	public void setShipMethod (java.lang.String _shipMethod) {
		this._shipMethod = _shipMethod;
	}
	
	
//	/**
//	* Return the value associated with the column: PickupPlantState
//	*/
//	public java.lang.String getPickupPlantState () {
//	return _pickupPlantState;
//	}
//	
//	/**
//	* Set the value related to the column: PickupPlantState
//	* @param _pickupPlantState the PickupPlantState value
//	*/
//	public void setPickupPlantState (java.lang.String _pickupPlantState) {
//	this._pickupPlantState = _pickupPlantState;
//	}
	
	
	/**
	 * Return the value associated with the column: Memo8
	 */
	public java.lang.String getMemo8 () {
		return _memo8;
	}
	
	/**
	 * Set the value related to the column: Memo8
	 * @param _memo8 the Memo8 value
	 */
	public void setMemo8 (java.lang.String _memo8) {
		this._memo8 = _memo8;
	}
	
	
	/**
	 * Return the value associated with the column: From
	 */
	public java.lang.String getFromcontact () {
		return _fromcontact;
	}
	
	/**
	 * Set the value related to the column: From
	 * @param _from the From value
	 */
	public void setFromcontact (java.lang.String _fromcontact) {
		this._fromcontact = _fromcontact;
	}
	
	
	/**
	 * Return the value associated with the column: POL
	 */
	public java.lang.String getPol () {
		return _pol;
	}
	
	/**
	 * Set the value related to the column: POL
	 * @param _pol the POL value
	 */
	public void setPol (java.lang.String _pol) {
		this._pol = _pol;
	}
//	
//	
//	/**
//	* Return the value associated with the column: FwdAgentCSZC
//	*/
//	public java.lang.String getFwdAgentCSZC () {
//	return _fwdAgentCSZC;
//	}
//	
//	/**
//	* Set the value related to the column: FwdAgentCSZC
//	* @param _fwdAgentCSZC the FwdAgentCSZC value
//	*/
//	public void setFwdAgentCSZC (java.lang.String _fwdAgentCSZC) {
//	this._fwdAgentCSZC = _fwdAgentCSZC;
//	}
//	
//	
	/**
	 * Return the value associated with the column: FwdAgentAddress1
	 */
	public java.lang.String getFwdAgentAddress1 () {
		return _fwdAgentAddress1;
	}
	
	/**
	 * Set the value related to the column: FwdAgentAddress1
	 * @param _fwdAgentAddress1 the FwdAgentAddress1 value
	 */
	public void setFwdAgentAddress1 (java.lang.String _fwdAgentAddress1) {
		this._fwdAgentAddress1 = _fwdAgentAddress1;
	}
//	
//	
//	/**
//	* Return the value associated with the column: drLighterTruck
//	*/
//	public java.lang.String getDrLighterTruck () {
//	return _drLighterTruck;
//	}
//	
//	/**
//	* Set the value related to the column: drLighterTruck
//	* @param _drLighterTruck the drLighterTruck value
//	*/
//	public void setDrLighterTruck (java.lang.String _drLighterTruck) {
//	this._drLighterTruck = _drLighterTruck;
//	}
//	
//	
	/**
	 * Return the value associated with the column: Memo6
	 */
	public java.lang.String getMemo6 () {
		return _memo6;
	}
	
	/**
	 * Set the value related to the column: Memo6
	 * @param _memo6 the Memo6 value
	 */
	public void setMemo6 (java.lang.String _memo6) {
		this._memo6 = _memo6;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperDrAddress3
//	*/
//	public java.lang.String getShipperDrAddress3 () {
//	return _shipperDrAddress3;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperDrAddress3
//	* @param _shipperDrAddress3 the ShipperDrAddress3 value
//	*/
//	public void setShipperDrAddress3 (java.lang.String _shipperDrAddress3) {
//	this._shipperDrAddress3 = _shipperDrAddress3;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: SubjectToCorrection
//	*/
//	public java.lang.String getSubjectToCorrection () {
//	return _subjectToCorrection;
//	}
//	
//	/**
//	* Set the value related to the column: SubjectToCorrection
//	* @param _subjectToCorrection the SubjectToCorrection value
//	*/
//	public void setSubjectToCorrection (java.lang.String _subjectToCorrection) {
//	this._subjectToCorrection = _subjectToCorrection;
//	}
//	
//	
//	
//	
//	
	/**
	 * Return the value associated with the column: NotifyFax
	 */
	public java.lang.String getNotifyFax () {
		return _notifyFax;
	}
	
	/**
	 * Set the value related to the column: NotifyFax
	 * @param _notifyFax the NotifyFax value
	 */
	public void setNotifyFax (java.lang.String _notifyFax) {
		this._notifyFax = _notifyFax;
	}
	
	
	/**
	 * Return the value associated with the column: NotifyAddress2
	 */
	public java.lang.String getNotifyAddress2 () {
		return _notifyAddress2;
	}
	
	/**
	 * Set the value related to the column: NotifyAddress2
	 * @param _notifyAddress2 the NotifyAddress2 value
	 */
	public void setNotifyAddress2 (java.lang.String _notifyAddress2) {
		this._notifyAddress2 = _notifyAddress2;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperDrAddress2
//	*/
//	public java.lang.String getShipperDrAddress2 () {
//	return _shipperDrAddress2;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperDrAddress2
//	* @param _shipperDrAddress2 the ShipperDrAddress2 value
//	*/
//	public void setShipperDrAddress2 (java.lang.String _shipperDrAddress2) {
//	this._shipperDrAddress2 = _shipperDrAddress2;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: NotifyCompany
//	*/
//	public java.lang.String getNotifyCompany () {
//	return _notifyCompany;
//	}
//	
//	/**
//	* Set the value related to the column: NotifyCompany
//	* @param _notifyCompany the NotifyCompany value
//	*/
//	public void setNotifyCompany (java.lang.String _notifyCompany) {
//	this._notifyCompany = _notifyCompany;
//	}
//	
//	
	/**
	 * Return the value associated with the column: CustomerFax
	 */
	public java.lang.String getCustomerFax () {
		return _customerFax;
	}
	
	/**
	 * Set the value related to the column: CustomerFax
	 * @param _customerFax the CustomerFax value
	 */
	public void setCustomerFax (java.lang.String _customerFax) {
		this._customerFax = _customerFax;
	}
	
	
	/**
	 * Return the value associated with the column: CustomerAddress1
	 */
	public java.lang.String getCustomerAddress1 () {
		return _customerAddress1;
	}
	
	/**
	 * Set the value related to the column: CustomerAddress1
	 * @param _customerAddress1 the CustomerAddress1 value
	 */
	public void setCustomerAddress1 (java.lang.String _customerAddress1) {
		this._customerAddress1 = _customerAddress1;
	}
//	
//	
//	/**
//	* Return the value associated with the column: Chk2
//	*/
//	public java.lang.String getChk2 () {
//	return _chk2;
//	}
//	
//	/**
//	* Set the value related to the column: Chk2
//	* @param _chk2 the Chk2 value
//	*/
//	public void setChk2 (java.lang.String _chk2) {
//	this._chk2 = _chk2;
//	}
//	
//	
	/**
	 * Return the value associated with the column: ExportInstructions
	 */
	public java.lang.String getExportInstructions () {
		return _exportInstructions;
	}
	
	/**
	 * Set the value related to the column: ExportInstructions
	 * @param _exportInstructions the ExportInstructions value
	 */
	public void setExportInstructions (java.lang.String _exportInstructions) {
		this._exportInstructions = _exportInstructions;
	}
	
	
	
	
	public Date getReportDate() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(getReportDateyyyy()), Integer
					.parseInt(getReportDatemm()) - 1, Integer
					.parseInt(getReportDatedd()));
			return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setReportDate(Date reportDate) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(reportDate);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			setReportDateyyyy(c.get(Calendar.YEAR) + "");
			setReportDatemm((month < 10 ? "0" : "") + month);
			setReportDatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setReportDateyyyy("0000");
			setReportDatemm("00");
			setReportDatedd("00");			
		}
	}
	public String getReportDatedd () {return _reportDatedd;}
	public void setReportDatedd (String _reportDatedd) {this._reportDatedd = _reportDatedd;}
	public String getReportDatemm () {return _reportDatemm;}
	public void setReportDatemm (String _reportDatemm) {this._reportDatemm = _reportDatemm;}
	public String getReportDateyyyy () {return _reportDateyyyy;}
	public void setReportDateyyyy (String _reportDateyyyy) {this._reportDateyyyy = _reportDateyyyy;}
	
	
	
	public Date getFinalDeliveryDateEst() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(getFinalDeliveryDateEstyyyy()), Integer
					.parseInt(getFinalDeliveryDateEstmm()) - 1, Integer
					.parseInt(getFinalDeliveryDateEstdd()));
			return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setFinalDeliveryDateEst(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			setFinalDeliveryDateEstyyyy(c.get(Calendar.YEAR) + "");
			setFinalDeliveryDateEstmm((month < 10 ? "0" : "") + month);
			setFinalDeliveryDateEstdd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setFinalDeliveryDateEstyyyy("0000");
			setFinalDeliveryDateEstmm("00");
			setFinalDeliveryDateEstdd("00");			
		}
	}
	public String getFinalDeliveryDateEstdd () {return _finalDeliveryDateEstdd;}
	public void setFinalDeliveryDateEstdd (String dd) {this._finalDeliveryDateEstdd = dd;}
	public String getFinalDeliveryDateEstmm () {return _finalDeliveryDateEstmm;}
	public void setFinalDeliveryDateEstmm (String mm) {this._finalDeliveryDateEstmm = mm;}
	public String getFinalDeliveryDateEstyyyy () {return _finalDeliveryDateEstyyyy;}
	public void setFinalDeliveryDateEstyyyy (String yyyy) {this._finalDeliveryDateEstyyyy = yyyy;}
	
	
	
	public Date getPoldateest() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(getPOLdateEstyyyy()), Integer
					.parseInt(getPOLdateEstmm()) - 1, Integer
					.parseInt(getPOLdateEstdd()));
			return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setPoldateest(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			setPOLdateEstyyyy(c.get(Calendar.YEAR) + "");
			setPOLdateEstmm((month < 10 ? "0" : "") + month);
			setPOLdateEstdd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setPOLdateEstyyyy("0000");
			setPOLdateEstmm("00");
			setPOLdateEstdd("00");			
		}
	}
	public String getPOLdateEstdd () {return _pOLdateEstdd;}
	public void setPOLdateEstdd (String dd) {this._pOLdateEstdd = dd;}
	public String getPOLdateEstmm () {return _pOLdateEstmm;}
	public void setPOLdateEstmm (String mm) {this._pOLdateEstmm = mm;}
	public String getPOLdateEstyyyy () {return _pOLdateEstyyyy;}
	public void setPOLdateEstyyyy (String yyyy) {this._pOLdateEstyyyy = yyyy;}
	
	
	public Date getPoddateest() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(getPODdateEstyyyy()), Integer
					.parseInt(getPODdateEstmm()) - 1, Integer
					.parseInt(getPODdateEstdd()));
			return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setPoddateest(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			setPODdateEstyyyy(c.get(Calendar.YEAR) + "");
			setPODdateEstmm((month < 10 ? "0" : "") + month);
			setPODdateEstdd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setPODdateEstyyyy("0000");
			setPODdateEstmm("00");
			setPODdateEstdd("00");			
		}
	}
	public String getPODdateEstdd () {return _pODdateEstdd;}
	public void setPODdateEstdd (String dd) {this._pODdateEstdd = dd;}
	public String getPODdateEstmm () {return _pODdateEstmm;}
	public void setPODdateEstmm (String mm) {this._pODdateEstmm = mm;}
	public String getPODdateEstyyyy () {return _pODdateEstyyyy;}
	public void setPODdateEstyyyy (String yyyy) {this._pODdateEstyyyy = yyyy;}
	
	
	
	/**
	 * Return the value associated with the column: CustomerAddress2
	 */
	public java.lang.String getCustomerAddress2 () {
		return _customerAddress2;
	}
	
	/**
	 * Set the value related to the column: CustomerAddress2
	 * @param _customerAddress2 the CustomerAddress2 value
	 */
	public void setCustomerAddress2 (java.lang.String _customerAddress2) {
		this._customerAddress2 = _customerAddress2;
	}
//	
//	
//	/**
//	* Return the value associated with the column: ShipperMblAddress1
//	*/
//	public java.lang.String getShipperMblAddress1 () {
//	return _shipperMblAddress1;
//	}
//	
//	/**
//	* Set the value related to the column: ShipperMblAddress1
//	* @param _shipperMblAddress1 the ShipperMblAddress1 value
//	*/
//	public void setShipperMblAddress1 (java.lang.String _shipperMblAddress1) {
//	this._shipperMblAddress1 = _shipperMblAddress1;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: ImportDeliveryInstructions
//	*/
//	public java.lang.String getImportDeliveryInstructions () {
//	return _importDeliveryInstructions;
//	}
//	
//	/**
//	* Set the value related to the column: ImportDeliveryInstructions
//	* @param _importDeliveryInstructions the ImportDeliveryInstructions value
//	*/
//	public void setImportDeliveryInstructions (java.lang.String _importDeliveryInstructions) {
//	this._importDeliveryInstructions = _importDeliveryInstructions;
//	}
//	
//	
//	/**
//	* Return the value associated with the column: PODPier
//	*/
//	public java.lang.String getPODPier () {
//	return _pODPier;
//	}
//	
//	/**
//	* Set the value related to the column: PODPier
//	* @param _pODPier the PODPier value
//	*/
//	public void setPODPier (java.lang.String _pODPier) {
//	this._pODPier = _pODPier;
//	}
	
	
	/**
	 * Return the value associated with the column: Memo4
	 */
	public java.lang.String getMemo4 () {
		return _memo4;
	}
	
	/**
	 * Set the value related to the column: Memo4
	 * @param _memo4 the Memo4 value
	 */
	public void setMemo4 (java.lang.String _memo4) {
		this._memo4 = _memo4;
	}
	
	
	/**
	 * Return the value associated with the column: Broker
	 */
	public java.lang.String getBroker () {
		return _broker;
	}
	
	/**
	 * Set the value related to the column: Broker
	 * @param _broker the Broker value
	 */
	public void setBroker (java.lang.String _broker) {
		this._broker = _broker;
	}
	
	
	/**
	 * Return the value associated with the column: FwdAgentRef
	 */
	public java.lang.String getFwdAgentRef () {
		return _fwdAgentRef;
	}
	
	/**
	 * Set the value related to the column: FwdAgentRef
	 * @param _fwdAgentRef the FwdAgentRef value
	 */
	public void setFwdAgentRef (java.lang.String _fwdAgentRef) {
		this._fwdAgentRef = _fwdAgentRef;
	}
	
	
	
	
	
	/**
	 */
	public Companyheader getCompanyheader() {return _companyheader;}
	/**
	 */
	public void setCompanyheader (Companyheader _companyheader) {this._companyheader = _companyheader;}
	
	
	
	
	/**
	 * Return the value associated with the column: Printdtls
	 */
	public java.util.Set getPrintdtls () {
		return this._printdtls;
	}
	
	/**
	 * Set the value related to the column: Printdtls
	 * @param _printdtls the Printdtls value
	 */
	public void setPrintdtls (java.util.Set _printdtls) {
		this._printdtls = _printdtls;
	}
	
	public void addToPrintdtls (Object obj) {
		if (null == this._printdtls) this._printdtls = new java.util.HashSet();
		this._printdtls.add(obj);
	}
	
	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;
		
		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
		
		return errors;
		
	}
	
	/*	private void addErrorIfBlank(ActionErrors errors, String fieldName,
	 String fieldValue, String message) {
	 if (fieldValue == null || fieldValue.trim().equals("")) {
	 errors.add(fieldName, new ActionMessage(message));
	 }
	 }*/
	
	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();		
		
		return keysToSkip;
	}
	
	
}
