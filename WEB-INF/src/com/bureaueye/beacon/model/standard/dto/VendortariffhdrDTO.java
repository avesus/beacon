package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-01 BESL-201402-0001 QUOTE MOVE AND COST TEMPLATE WORK
 * 
 */
public final class VendortariffhdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// constructors
	public VendortariffhdrDTO() {
	}

	public VendortariffhdrDTO(Vendortariffhdr dao) throws ApplicationException {
		initialize(dao);
	}

	public VendortariffhdrDTO(Vendortariffhdr dao,
			Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	protected void initialize(Vendortariffhdr dao) throws ApplicationException {
		this.setVendtarfhdrId(dao.getVendtarfhdrId());
		this.setCcykey(dao.getCcykey());
		this.setCostkey(new CostBD(this.getSessionFactoryClusterMap()).read(dao
				.getCostkey()));
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap())
				.read(dao.getVendoraddrkey()));

		this.setFromlocationkey(new LocationBD(this
				.getSessionFactoryClusterMap()).read(dao.getFromlocationkey()));
		if (null == this.getFromlocationkey())
			this.setFromlocationkey(new Location());

		this.setTolocationkey(new LocationBD(this.getSessionFactoryClusterMap())
				.read(dao.getTolocationkey()));
		if (null == this.getTolocationkey())
			this.setTolocationkey(new Location());

		this.setTslocationkey(new LocationBD(this.getSessionFactoryClusterMap())
				.read(dao.getTslocationkey()));
		if (null == this.getTslocationkey())
			this.setTslocationkey(new Location());

		try {
			this.setLumpsum(dao.getLumpsum().toString());
		} catch (Exception e) {
		}
		this.setValidto(dao.getValidto());
		this.setValidfrom(dao.getValidfrom());
		this.setCcykey(dao.getCcykey());
		this.setUnittype(dao.getUnittype());
		this.setProducthazardous(dao.getProducthazardous());
		this.setNote1(dao.getNote1());
		this.setNote2(dao.getNote2());
	}

	public VendortariffhdrDTO(String _costkey, String _fromlocationkey,
			String _tolocationkey, String _producthazardous) {
		this.setCostkey2(_costkey);
		this.setFromlocationkey2(_fromlocationkey);
		this.setTolocationkey2(_tolocationkey);
		this.setProducthazardous(_producthazardous);
	}

	public VendortariffhdrDTO(String _costkey, String _fromlocationkey,
			String _tolocationkey, String _producthazardous, String _ccykey,
			Integer _fromvalue, Integer _tovalue) {
		this.setCostkey2(_costkey);
		this.setFromlocationkey2(_fromlocationkey);
		this.setTolocationkey2(_tolocationkey);
		this.setProducthazardous(_producthazardous);
		this.setFromvalue(_fromvalue);
		this.setTovalue(_tovalue);
		this.setCcykey(_ccykey);
	}

	// primary key
	private java.lang.String vendtarfhdrId;
	private java.lang.String vendtarfhdrId2;

	// fields
	// private java.util.Date validfrom;
	private String validfromdd;
	private String validfrommm;
	private String validfromyyyy;

	// private java.util.Date validto;
	private String validtodd;
	private String validtomm;
	private String validtoyyyy;

	private java.lang.String productkey;
	private java.lang.String ccykey;
	private java.lang.String lumpsum;
	private com.bureaueye.beacon.model.standard.Address vendoraddrkey;
	private com.bureaueye.beacon.model.standard.Cost costkey;
	private com.bureaueye.beacon.model.standard.Location fromlocationkey;
	private com.bureaueye.beacon.model.standard.Location tolocationkey;
	private com.bureaueye.beacon.model.standard.Location tslocationkey;
	private java.lang.String unittype;
	private java.lang.String producthazardous;
	private java.lang.String note1;
	private java.lang.String note2;

	private String costkey2;
	private String fromlocationkey2;
	private String tolocationkey2;

	private Integer fromvalue;
	private Integer tovalue;

	private String row;

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	/**
	 */
	public java.lang.String getVendtarfhdrId() {
		return vendtarfhdrId;
	}

	public void setVendtarfhdrId(java.lang.String vendtarfhdrId) {
		this.vendtarfhdrId = vendtarfhdrId;
	}

	/**
	 */
	public java.lang.String getVendtarfhdrId2() {
		return vendtarfhdrId2;
	}

	public void setVendtarfhdrId2(java.lang.String vendtarfhdrId2) {
		this.vendtarfhdrId2 = vendtarfhdrId2;
	}

	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey() {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * 
	 * @param productkey
	 *            the productkey value
	 */
	public void setProductkey(java.lang.String productkey) {
		this.productkey = productkey;
	}

	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey() {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * 
	 * @param ccykey
	 *            the ccykey value
	 */
	public void setCcykey(java.lang.String ccykey) {
		this.ccykey = ccykey;
	}

	/**
	 * Return the value associated with the column: lumpsum
	 */
	public java.lang.String getLumpsum() {
		return lumpsum;
	}

	/**
	 * Set the value related to the column: lumpsum
	 * 
	 * @param lumpsum
	 *            the lumpsum value
	 */
	public void setLumpsum(java.lang.String lumpsum) {
		this.lumpsum = lumpsum;
	}

	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public com.bureaueye.beacon.model.standard.Address getVendoraddrkey() {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * 
	 * @param vendoraddrkey
	 *            the vendoraddrkey value
	 */
	public void setVendoraddrkey(
			com.bureaueye.beacon.model.standard.Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}

	/**
	 * Return the value associated with the column: costkey
	 */
	public com.bureaueye.beacon.model.standard.Cost getCostkey() {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * 
	 * @param costkey
	 *            the costkey value
	 */
	public void setCostkey(com.bureaueye.beacon.model.standard.Cost costkey) {
		this.costkey = costkey;
	}

	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getFromlocationkey() {
		return fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * 
	 * @param fromlocationkey
	 *            the fromlocationkey value
	 */
	public void setFromlocationkey(
			com.bureaueye.beacon.model.standard.Location fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}

	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getTolocationkey() {
		return tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * 
	 * @param tolocationkey
	 *            the tolocationkey value
	 */
	public void setTolocationkey(
			com.bureaueye.beacon.model.standard.Location tolocationkey) {
		this.tolocationkey = tolocationkey;
	}

	/**
	 * Return the value associated with the column: tslocationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getTslocationkey() {
		return tslocationkey;
	}

	/**
	 * Set the value related to the column: tslocationkey
	 * 
	 * @param tslocationkey
	 *            the tslocationkey value
	 */
	public void setTslocationkey(
			com.bureaueye.beacon.model.standard.Location tslocationkey) {
		this.tslocationkey = tslocationkey;
	}

	/**
	 * Return the value associated with the column: note1
	 */
	public java.lang.String getNote1() {
		return note1;
	}

	/**
	 * Set the value related to the column: note1
	 * 
	 * @param note1
	 *            the note1 value
	 */
	public void setNote1(java.lang.String note1) {
		this.note1 = note1;
	}

	/**
	 * Return the value associated with the column: note2
	 */
	public java.lang.String getNote2() {
		return note2;
	}

	/**
	 * Set the value related to the column: note2
	 * 
	 * @param note2
	 *            the note2 value
	 */
	public void setNote2(java.lang.String note2) {
		this.note2 = note2;
	}

	/**
	 * Return the value associated with the column: unittype
	 */
	public java.lang.String getUnittype() {
		return unittype;
	}

	/**
	 * Set the value related to the column: unittype
	 * 
	 * @param unittype
	 *            the unittype value
	 */
	public void setUnittype(java.lang.String unittype) {
		this.unittype = unittype;
	}

	/**
	 */
	public java.lang.String getProducthazardous() {
		return producthazardous;
	}

	public void setProducthazardous(java.lang.String producthazardous) {
		this.producthazardous = producthazardous;
	}

	public Integer getFromvalue() {
		return fromvalue;
	}

	public void setFromvalue(Integer fromvalue) {
		this.fromvalue = fromvalue;
	}

	public Integer getTovalue() {
		return tovalue;
	}

	public void setTovalue(Integer tovalue) {
		this.tovalue = tovalue;
	}

	public java.lang.String getCostkey2() {
		return costkey2;
	}

	public void setCostkey2(java.lang.String costkey2) {
		this.costkey2 = costkey2;
	}

	public java.lang.String getFromlocationkey2() {
		return fromlocationkey2;
	}

	public void setFromlocationkey2(java.lang.String fromlocationkey2) {
		this.fromlocationkey2 = fromlocationkey2;
	}

	public java.lang.String getTolocationkey2() {
		return tolocationkey2;
	}

	public void setTolocationkey2(java.lang.String tolocationkey2) {
		this.tolocationkey2 = tolocationkey2;
	}

	public Date getValidto() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getValidtoyyyy()),
				Integer.parseInt(getValidtomm()) - 1,
				Integer.parseInt(getValidtodd()));
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

	public Date getValidfrom() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getValidfromyyyy()),
				Integer.parseInt(getValidfrommm()) - 1,
				Integer.parseInt(getValidfromdd()));
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
	}

}
