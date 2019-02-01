package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;




public final class CustomertariffhdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public CustomertariffhdrDTO() {	
	}
	
	public CustomertariffhdrDTO(Customertariffhdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public CustomertariffhdrDTO(Customertariffhdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Customertariffhdr dao) throws ApplicationException {
		
		//init objects
		ChargeBD chargebd=new ChargeBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd=new LocationBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd=new AddressBD(this.getSessionFactoryClusterMap());
		
		this.setCusttarfhdrId(dao.getCusttarfhdrId());
		this.setCcykey(dao.getCcykey());
		this.setChargekey(chargebd.read(dao.getChargekey()));
		this.setCustomeraddrkey(addressbd.read(dao.getCustomeraddrkey()));
		
		this.setFromlocationkey(locationbd.read(dao.getFromlocationkey()));
		if (null == this.getFromlocationkey()) this.setFromlocationkey(new Location());
		
		this.setTolocationkey(locationbd.read(dao.getTolocationkey()));
		if (null == this.getTolocationkey()) this.setTolocationkey(new Location());
		
		this.setFromlocationkey2(locationbd.read(dao.getFromlocationkey2()));
		if (null == this.getFromlocationkey2()) this.setFromlocationkey2(new Location());
		
		this.setTolocationkey2(locationbd.read(dao.getTolocationkey2()));
		if (null == this.getTolocationkey2()) this.setTolocationkey2(new Location());
		
		
		try{this.setLumpsum(dao.getLumpsum().toString());}catch(Exception e){}
		this.setValidto(dao.getValidto());
		//this.setValidfrom(dao.getValidfrom());			
		this.setCcykey(dao.getCcykey());
		this.setUnittype(dao.getUnittype());
		
		//clear objects
		 chargebd=null;
		 locationbd=null;
		 addressbd=null;
		 
	}
	
	
	// primary key
	private java.lang.String custtarfhdrId;
	private java.lang.String custtarfhdrId2;
	
	// fields
	//private java.util.Date validfrom;
/*	private String validfromdd;
	private String validfrommm;
	private String validfromyyyy;*/	

	//private java.util.Date validto;
	private String validtodd;
	private String validtomm;
	private String validtoyyyy;
	
	private java.lang.String productkey;
	private java.lang.String ccykey;
	private java.lang.String lumpsum;
	private com.bureaueye.beacon.model.standard.Address customeraddrkey;
	private com.bureaueye.beacon.model.standard.Charge costkey;
	
	private com.bureaueye.beacon.model.standard.Location fromlocationkey;
	private com.bureaueye.beacon.model.standard.Location tolocationkey;
	private com.bureaueye.beacon.model.standard.Location fromlocationkey2;
	private com.bureaueye.beacon.model.standard.Location tolocationkey2;
	
	private java.lang.String unittype;
	private java.lang.String note1;
	private java.lang.String note2;
	
	private String row;



	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	

	public java.lang.String getCusttarfhdrId () {
		return custtarfhdrId;
	}
	public void setCusttarfhdrId (java.lang.String custtarfhdrId) {
		this.custtarfhdrId = custtarfhdrId;
	}
	
	public java.lang.String getCusttarfhdrId2 () {
		return custtarfhdrId2;
	}
	public void setCusttarfhdrId2 (java.lang.String custtarfhdrId2) {
		this.custtarfhdrId2 = custtarfhdrId2;
	}	
	
	
	
	
	public Date getValidto() {
		Calendar c = Calendar.getInstance();
		c
		.set(Integer.parseInt(getValidtoyyyy()), Integer
				.parseInt(getValidtomm()) - 1, Integer
				.parseInt(getValidtodd()));
		return c.getTime();
	}
	public void setValidto(Date validto) {
		Calendar c = Calendar.getInstance();
		c.setTime(validto);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setValidtoyyyy(c.get(Calendar.YEAR) + "");
		setValidtomm((month < 10 ? "0" : "") + month);
		setValidtodd((day < 10 ? "0" : "") + day);
	}
	public String getValidtodd() {
		return validtodd;
	}
	public void setValidtodd(String validtodd) {
		this.validtodd = validtodd;
	}
	public String getValidtomm() {
		return validtomm;
	}
	public void setValidtomm(String validtomm) {
		this.validtomm = validtomm;
	}
	public String getValidtoyyyy() {
		return validtoyyyy;
	}
	public void setValidtoyyyy(String validtoyyyy) {
		this.validtoyyyy = validtoyyyy;
	}



/*	public Date getValidfrom() {
		Calendar c = Calendar.getInstance();
		c
		.set(Integer.parseInt(getValidfromyyyy()), Integer
				.parseInt(getValidfrommm()) - 1, Integer
				.parseInt(getValidfromdd()));
		return c.getTime();
	}
	public void setValidfrom(Date validfrom) {
		Calendar c = Calendar.getInstance();
		c.setTime(validfrom);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setValidfromyyyy(c.get(Calendar.YEAR) + "");
		setValidfrommm((month < 10 ? "0" : "") + month);
		setValidfromdd((day < 10 ? "0" : "") + day);
	}	
	public String getValidfromdd() {
		return validfromdd;
	}
	public void setValidfromdd(String validfromdd) {
		this.validfromdd = validfromdd;
	}
	public String getValidfrommm() {
		return validfrommm;
	}
	public void setValidfrommm(String validfrommm) {
		this.validfrommm = validfrommm;
	}
	public String getValidfromyyyy() {
		return validfromyyyy;
	}
	public void setValidfromyyyy(String validfromyyyy) {
		this.validfromyyyy = validfromyyyy;
	}*/
	
	
	
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}
	
	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
	}
	
	
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}
	
	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}
	
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: lumpsum
	 */
	public java.lang.String getLumpsum () {
		return lumpsum;
	}

	/**
	 * Set the value related to the column: lumpsum
	 * @param lumpsum the lumpsum value
	 */
	public void setLumpsum (java.lang.String lumpsum) {
		this.lumpsum = lumpsum;
	}
	
	
	
	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public com.bureaueye.beacon.model.standard.Address getCustomeraddrkey () {
		return customeraddrkey;
	}
	
	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (com.bureaueye.beacon.model.standard.Address customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: costkey
	 */
	public com.bureaueye.beacon.model.standard.Charge getChargekey () {
		return costkey;
	}
	
	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setChargekey (com.bureaueye.beacon.model.standard.Charge costkey) {
		this.costkey = costkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getFromlocationkey () {
		return fromlocationkey;
	}
	
	/**
	 * Set the value related to the column: fromlocationkey
	 * @param fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (com.bureaueye.beacon.model.standard.Location fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getTolocationkey () {
		return tolocationkey;
	}
	
	/**
	 * Set the value related to the column: tolocationkey
	 * @param tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (com.bureaueye.beacon.model.standard.Location tolocationkey) {
		this.tolocationkey = tolocationkey;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: fromlocationkey2
	 */
	public com.bureaueye.beacon.model.standard.Location getFromlocationkey2 () {
		return fromlocationkey2;
	}
	
	/**
	 * Set the value related to the column: fromlocationkey2
	 * @param fromlocationkey the fromlocationkey2 value
	 */
	public void setFromlocationkey2 (com.bureaueye.beacon.model.standard.Location fromlocationkey2) {
		this.fromlocationkey2 = fromlocationkey2;
	}
	
	
	
	/**
	 * Return the value associated with the column: tolocationkey2
	 */
	public com.bureaueye.beacon.model.standard.Location getTolocationkey2 () {
		return tolocationkey2;
	}
	
	/**
	 * Set the value related to the column: tolocationkey2
	 * @param tolocationkey the tolocationkey2 value
	 */
	public void setTolocationkey2 (com.bureaueye.beacon.model.standard.Location tolocationkey2) {
		this.tolocationkey2 = tolocationkey2;
	}
	
	
	
	
	
	/**
	 * Return the value associated with the column: note1
	 */
	public java.lang.String getNote1 () {
		return note1;
	}
	
	/**
	 * Set the value related to the column: note1
	 * @param note1 the note1 value
	 */
	public void setNote1 (java.lang.String note1) {
		this.note1 = note1;
	}
	
	
	
	/**
	 * Return the value associated with the column: note2
	 */
	public java.lang.String getNote2 () {
		return note2;
	}
	
	/**
	 * Set the value related to the column: note2
	 * @param note2 the note2 value
	 */
	public void setNote2 (java.lang.String note2) {
		this.note2 = note2;
	}
	
	
	/**
	 * Return the value associated with the column: unittype
	 */
	public java.lang.String getUnittype () {
		return unittype;
	}
	
	/**
	 * Set the value related to the column: unittype
	 * @param unittype the unittype value
	 */
	public void setUnittype (java.lang.String unittype) {
		this.unittype = unittype;
	}
	
	
	
	
}
