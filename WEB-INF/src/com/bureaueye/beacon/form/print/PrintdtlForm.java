package com.bureaueye.beacon.form.print;

import java.util.Calendar;
import java.util.Date;


import com.bureaueye.beacon.form.BaseForm;

public final class PrintdtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String _action;
	private String _readonly;

	
	// keys
	private java.lang.String _printdtlId;
	private java.lang.String _printhdrId;
		
	// fields
	private java.lang.String _idType;
	private java.lang.String _tankNumber;
	private java.lang.String _jobNumber;
	private java.lang.String _puPlantApptTime;
	private java.lang.String _productId;
	private boolean _hazardous;
	private java.lang.String _memoB;
	private java.lang.String _product;
	private java.lang.String _createuserid;
	private java.lang.String _weightType;
	private java.lang.String _memoA;
	private java.lang.String _classUnPgFp;
	private java.lang.String _reportId;
	private java.lang.String _reportType;
	private java.lang.String _addInstructions;
	private java.lang.String _numberOfTanks = "0";
	private java.lang.String _actualWeight = "0.0";
	private java.lang.String _actualWeight2;
	private java.lang.String _sealNumbers;
	private java.lang.String _hazardousIMO;
	private java.lang.String _id;
	private java.lang.String _emergency1;
	private java.lang.String _pickupPlantRef;
	private java.lang.String _vessel;
	private java.lang.String _movref;
	private java.lang.String _vendor;
	
	
	private java.lang.String _puPlantLoadDatedd;
	private java.lang.String _puPlantLoadDatemm;
	private java.lang.String _puPlantLoadDateyyyy;	
	private java.lang.String _puPlantApptDatedd;
	private java.lang.String _puPlantApptDatemm;
	private java.lang.String _puPlantApptDateyyyy;
	

	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	/**
     */
	public java.lang.String getPrinthdrId () {return _printhdrId;}
	/**
	 */
	public void setPrinthdrId (java.lang.String _printhdrId) {this._printhdrId = _printhdrId;}

	
	
	/**
     */
	public java.lang.String getActualWeight () {return _actualWeight;}
	/**
	 */
	public void setActualWeight (java.lang.String _actualWeight) {this._actualWeight = _actualWeight;}

	/**
     */
	public java.lang.String getWeightType () {return _weightType;}
	/**
	 */
	public void setWeightType (java.lang.String _weightType) {this._weightType = _weightType;}

	
	
	
	
	/**
     */
	public java.lang.String getPrintdtlId () {return _printdtlId;}
	/**
	 */
	public void setPrintdtlId (java.lang.String _printdtlId) {this._printdtlId = _printdtlId;}
	


	/**
     */
	public java.lang.String getMovref() {return _movref;}
	/**
	 */
	public void setMovref(java.lang.String _movref) {this._movref = _movref;}


	/**
     */
	public java.lang.String getVessel() {return _vessel;}
	/**
	 */
	public void setVessel(java.lang.String _vessel) {this._vessel = _vessel;}

	/**
     */
	public java.lang.String getVendor() {return _vendor;}
	/**
	 */
	public void setVendor(java.lang.String _vendor) {this._vendor = _vendor;}
	
	
	/**
     */
	public java.lang.String getPickupPlantRef() {return _pickupPlantRef;}
	/**
	 */
	public void setPickupPlantRef(java.lang.String _pickupPlantRef) {this._pickupPlantRef = _pickupPlantRef;}

	
	/**
     */
	public java.lang.String getAddInstructions() {return _addInstructions;}
	/**
	 */
	public void setAddInstructions(java.lang.String _addInstructions) {this._addInstructions = _addInstructions;}
	
	
	
	
	/**
     */
	public java.lang.String getTankNumber() {return _tankNumber;}
	/**
	 */
	public void setTankNumber (java.lang.String _tankNumber) {this._tankNumber = _tankNumber;}

	/**
     */
	public java.lang.String getProductId() {return _productId;}
	/**
	 */
	public void setProductId (java.lang.String _productId) {this._productId = _productId;}

	/**
     */
	public java.lang.String getId() {return _id;}
	/**
	 */
	public void setId (java.lang.String _id) {this._id = _id;}

	/**
     */
	public java.lang.String getIdType() {return _idType;}
	/**
	 */
	public void setIdType (java.lang.String _idType) {this._idType = _idType;}
	
	/**
     */
	public java.lang.String getReportType() {return _reportType;}
	/**
	 */
	public void setReportType (java.lang.String _reportType) {this._reportType = _reportType;}
	
	/**
     */
	public java.lang.String getJobNumber() {return _jobNumber;}
	/**
	 */
	public void setJobNumber(java.lang.String _jobNumber) {this._jobNumber = _jobNumber;}
	

	/**
     */
	public java.lang.String getNumberOfTanks() {return _numberOfTanks;}
	/**
	 */
	public void setNumberOfTanks(java.lang.String _numberOfTanks) {this._numberOfTanks = _numberOfTanks;}

	
	
	
	/**
     */
	public java.lang.String getMemoA() {return _memoA;}
	/**
	 */
	public void setMemoA (java.lang.String _memoA) {this._memoA = _memoA;}

	/**
     */
	public java.lang.String getMemoB() {return _memoB;}
	/**
	 */
	public void setMemoB (java.lang.String _memoB) {this._memoB = _memoB;}
	
	
	

	public Date getPuPlantLoadDate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPuPlantLoadDateyyyy()), Integer
						.parseInt(getPuPlantLoadDatemm()) - 1, Integer
						.parseInt(getPuPlantLoadDatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setPuPlantLoadDate(Date date) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPuPlantLoadDateyyyy(c.get(Calendar.YEAR) + "");
		setPuPlantLoadDatemm((month < 10 ? "0" : "") + month);
		setPuPlantLoadDatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setPuPlantLoadDateyyyy("0000");
			setPuPlantLoadDatemm("00");
			setPuPlantLoadDatedd("00");			
		}
	}
	public String getPuPlantLoadDatedd () {return _puPlantLoadDatedd;}
	public void setPuPlantLoadDatedd (String dd) {this._puPlantLoadDatedd = dd;}
	public String getPuPlantLoadDatemm () {return _puPlantLoadDatemm;}
	public void setPuPlantLoadDatemm (String mm) {this._puPlantLoadDatemm = mm;}
	public String getPuPlantLoadDateyyyy () {return _puPlantLoadDateyyyy;}
	public void setPuPlantLoadDateyyyy (String yyyy) {this._puPlantLoadDateyyyy = yyyy;}

	
	public Date getPuPlantApptDate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPuPlantApptDateyyyy()), Integer
						.parseInt(getPuPlantApptDatemm()) - 1, Integer
						.parseInt(getPuPlantApptDatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setPuPlantApptDate(Date date) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPuPlantApptDateyyyy(c.get(Calendar.YEAR) + "");
		setPuPlantApptDatemm((month < 10 ? "0" : "") + month);
		setPuPlantApptDatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setPuPlantApptDateyyyy("0000");
			setPuPlantApptDatemm("00");
			setPuPlantApptDatedd("00");			
		}
	}
	public String getPuPlantApptDatedd () {return _puPlantApptDatedd;}
	public void setPuPlantApptDatedd (String dd) {this._puPlantApptDatedd = dd;}
	public String getPuPlantApptDatemm () {return _puPlantApptDatemm;}
	public void setPuPlantApptDatemm (String mm) {this._puPlantApptDatemm = mm;}
	public String getPuPlantApptDateyyyy () {return _puPlantApptDateyyyy;}
	public void setPuPlantApptDateyyyy (String yyyy) {this._puPlantApptDateyyyy = yyyy;}
	
	
}
