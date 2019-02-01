package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Fitgrp;
import com.bureaueye.beacon.model.standard.Fittyp;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unitmandr;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.FitgrpBD;
import com.bureaueye.beacon.model.standard.bd.FittypBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;






public final class UnitmandrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitmandrDTO(Unitmandr dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitmandrDTO(Unitmandr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Unitmandr dao) throws ApplicationException {
		
		// populate data-transfer-object from data-access-object
		this.setFitgrpkey(new FitgrpBD(this.getSessionFactoryClusterMap()).read(dao.getFitgrpkey()));
		this.setFittypkey(new FittypBD(this.getSessionFactoryClusterMap()).read(dao.getFittypkey()));
		this.setLesseeaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getLesseeaddrkey()));
		this.setLocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLocationkey()));
		this.setUnitkey(new UnitBD(this.getSessionFactoryClusterMap()).read(dao.getUnitId()));
		
		this.setUnitmandrId(dao.getUnitmandrId());
		
		this.setUnitId(dao.getUnitId());

		this.setMandrdate(dao.getMandrdate());
		this.setMandrref(dao.getMandrref());
		this.setMandrdesc(dao.getMandrdesc());

		this.setCcykey(dao.getCcykey());
		this.setLabouramt(dao.getLabouramt());
		this.setMaterialamt(dao.getMaterialamt());
		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	
	// primary key
	private java.lang.Integer unitmandrId;

	// fields
	private Unit unitkey;
	private Fitgrp fitgrpkey;
	private Fittyp fittypkey;
	private java.lang.String xlock;
	private boolean xinactive;
	private boolean deleted;
	private java.lang.Integer unitId;
	private java.lang.String mandrdesc;
	private java.lang.String mandrref;
	private java.lang.String ccykey;
	private java.math.BigDecimal labouramt;
	private java.math.BigDecimal materialamt;
	private java.util.Date mandrdate;
	private Address lesseeaddrkey;
	private Location locationkey;;





	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITMANDR_ID"
     */
	public java.lang.Integer getUnitmandrId () {
		return unitmandrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitmandrId the new ID
	 */
	public void setUnitmandrId (java.lang.Integer unitmandrId) {
		this.unitmandrId = unitmandrId;
	}




	/**
	 * Return the value associated with the column: unitkey
	 */
	public Unit getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (Unit unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: fitgrpkey
	 */
	public Fitgrp getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (Fitgrp fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}



	/**
	 * Return the value associated with the column: fittypkey
	 */
	public Fittyp getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (Fittyp fittypkey) {
		this.fittypkey = fittypkey;
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
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}






	/**
	 * Return the value associated with the column: mandrdesc
	 */
	public java.lang.String getMandrdesc () {
		return mandrdesc;
	}

	/**
	 * Set the value related to the column: mandrdesc
	 * @param mandrdesc the mandrdesc value
	 */
	public void setMandrdesc (java.lang.String mandrdesc) {
		this.mandrdesc = mandrdesc;
	}



	/**
	 * Return the value associated with the column: mandrref
	 */
	public java.lang.String getMandrref () {
		return mandrref;
	}

	/**
	 * Set the value related to the column: mandrref
	 * @param mandrref the mandrref value
	 */
	public void setMandrref (java.lang.String mandrref) {
		this.mandrref = mandrref;
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
	 * Return the value associated with the column: labouramt
	 */
	public java.math.BigDecimal getLabouramt () {
		return labouramt;
	}

	/**
	 * Set the value related to the column: labouramt
	 * @param labouramt the labouramt value
	 */
	public void setLabouramt (java.math.BigDecimal labouramt) {
		this.labouramt = labouramt;
	}



	/**
	 * Return the value associated with the column: materialamt
	 */
	public java.math.BigDecimal getMaterialamt () {
		return materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (java.math.BigDecimal materialamt) {
		this.materialamt = materialamt;
	}



	/**
	 * Return the value associated with the column: mandrdate
	 */
	public java.util.Date getMandrdate () {
		return mandrdate;
	}

	/**
	 * Set the value related to the column: mandrdate
	 * @param mandrdate the mandrdate value
	 */
	public void setMandrdate (java.util.Date mandrdate) {
		this.mandrdate = mandrdate;
	}



	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public Address getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (Address lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}



	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (Location locationkey) {
		this.locationkey = locationkey;
	}

	
	
}
