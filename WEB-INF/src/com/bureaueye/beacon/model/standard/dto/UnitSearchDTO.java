/*
 * $Id: CustomertariffSearchLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.model.standard.dto;



import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Fitgrp;
import com.bureaueye.beacon.model.standard.Fittyp;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unittest;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.FitgrpBD;
import com.bureaueye.beacon.model.standard.bd.FittypBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.beacon.util.Util;





/**
 */

public final class UnitSearchDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitSearchDTO(Unit dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitSearchDTO(Unit dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	public UnitSearchDTO(UnitUnitfitDTO dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitSearchDTO(UnitUnitfitDTO dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Unit dao) throws ApplicationException {
		
		// populate data-transfer-object from data-access-object
		try {
			this._movelocationkey = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getJobmovlocationkey());
		} catch (Exception e) {}
		try {
			this._moveaddrkey = new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getMoveaddrkey());
		} catch (Exception e) {}
		try {
			this._movelocationkey2 = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getMovelocationkey());
		} catch (Exception e) {}

		try {
			this.setOwneraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getOwnerkey()));
		} catch (Exception e) {}	
		
		this._unitId = dao.getUnitId();		
		this._unitkey = dao.getUnitkey();
		
		this._moveref = dao.getMoveref();
		this._movests = dao.getMovests();
		
		this._moveproductkey = dao.getMoveproductkey();
		
		this.eqpkeyp1 = dao.getEqpkeyp1();
		this.eqpkeyp2 = dao.getEqpkeyp2();
		
		//this._returnParams = this._unitkey+"|"+this._unitId;

		this._returnParams = 
			this._unitkey+"|"+
			this._unitId+"|"+
			this.eqpkeyp1+"|"+
			this.eqpkeyp2+"|"+
			this._owneraddr.getName()+"|"+
			this._moveref+"|"+
			this._movests;		
		try {
			Unittest unittestdao = new UnittestBD(this.getSessionFactoryClusterMap()).getNextUnittestDue(dao.getUnitId());
			this._returnParams = 
				this._returnParams+"|"+
				unittestdao.getTesttypekey()+"|"+
				Util.dateTextFormat2(unittestdao.getDuedate());
		} catch (Exception e) {}

	}
	
	
	protected void initialize (UnitUnitfitDTO dao) throws ApplicationException {
		
		// populate data-transfer-object from data-access-object
		//this._movelocationkey = new LocationBD(this.getSessionFactoryClusterMap()).read(unit.getJobmovlocationkey());
		try {
			this._moveaddrkey = new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getMoveaddrkey());
		} catch (Exception e) {}		
		try {
			this._movelocationkey2 = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getMovelocationkey());
		} catch (Exception e) {}
		
		try {
			this.setFitgrpkey(new FitgrpBD(this.getSessionFactoryClusterMap()).read(dao.getFitgrpkey()));
		} catch (Exception e) {}
		try {
			this.setFittypkey(new FittypBD(this.getSessionFactoryClusterMap()).read(dao.getFittypkey()));
		} catch (Exception e) {}		
		
		this._unitId = dao.getUnitId();		
		this._unitkey = dao.getUnitkey();
		
		this._moveref = dao.getMoveref();
		this._movests = dao.getMovests();
		
		this._moveproductkey = dao.getMoveproductkey();
		
		this.eqpkeyp1 = dao.getEqpkeyp1();
		this.eqpkeyp2 = dao.getEqpkeyp2();

		this.setFitcoddes(dao.getFitcoddes());
		
		
		this._returnParams = this._unitkey+"|"+this._unitId;
		
	}
	
	
	// primary key
	private String _id;
	
	// fields
	private java.lang.Integer _unitId;
	private String _unitkey;	
	
	
	private String _movests;
	private String _moveref;
	private String _moveproductkey;	
	private Location _movelocationkey = new Location();
	private Location _movelocationkey2 = new Location();
	private Address _moveaddrkey = new Address();	
	private Address _owneraddr = new Address();	
	
	private java.lang.String eqpkeyp1;
	private java.lang.String eqpkeyp2;
	
	private Fitgrp fitgrpkey;
	private Fittyp fittypkey;
	private java.lang.String fitcoddes;
	
	private String _returnParams;
	private String _returnParams2;
	
	private boolean checked;
	
	
	
	
	public boolean isChecked() { return (this.checked); }
	public void setChecked(boolean b) {
		this.checked = b;
	}
	
	/**
	 */
	public String getReturnParams() {
		return (this._returnParams);
	}
	/**
	 */
	public void setReturnParams(String _returnParams) {
		this._returnParams = _returnParams;
	}
	

	/**
	 */
	public String getReturnParams2() {
		return (this._returnParams2);
	}
	/**
	 */
	public void setReturnParams2(String _returnParams2) {
		this._returnParams2 = _returnParams2;
	}
	
	
	/**
	 */
	public String getId() {
		return (this._id);
	}
	/**
	 */
	public void setId(String _id) {
		this._id = _id;
	}
	
	
	
	
	
	/**
	 */
	public Integer getUnitId() {
		return (this._unitId);
	}
	/**
	 */
	public void setUnitId(Integer _unitId) {
		this._unitId = _unitId;
	}
	
	
	/**
	 */
	public String getUnitkey() {
		return (this._unitkey);
	}
	/**
	 */
	public void setUnitkey(String _unitkey) {
		this._unitkey = _unitkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public Location getMovelocationkey () {
		return _movelocationkey;
	}
	
	/**
	 * Set the value related to the column: _movelocationkey
	 * @param __movelocationkey the _movelocationkey value
	 */
	public void setMovelocationkey (Location _movelocationkey) {
		this._movelocationkey = _movelocationkey;
	}
	
	
	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public Location getMovelocationkey2 () {
		return _movelocationkey2;
	}
	
	/**
	 */
	public void setMovelocationkey2 (Location _movelocationkey2) {
		this._movelocationkey2 = _movelocationkey2;
	}
	
	
	
	/**
	 */
	public Address getMoveaddrkey () {
		return _moveaddrkey;
	}
	
	/**
	 */
	public void setMoveaddrkey (Address _moveaddrkey) {
		this._moveaddrkey = _moveaddrkey;
	}
	

	/**
	 */
	public Address getOwneraddr () {
		return _owneraddr;
	}
	
	/**
	 */
	public void setOwneraddr (Address _owneraddr) {
		this._owneraddr = _owneraddr;
	}
	
	
	
	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return _movests;
	}
	
	/**
	 * Set the value related to the column: movests
	 * @param _movests the movests value
	 */
	public void setMovests (java.lang.String _movests) {
		this._movests = _movests;
	}	
	
	
	/**
	 */
	public java.lang.String getMoveref () {
		return _moveref;
	}
	
	/**
	 */
	public void setMoveref (java.lang.String _moveref) {
		this._moveref = _moveref;
	}
	
	
	/**
	 * Return the value associated with the column: moveproductkey
	 */
	public java.lang.String getMoveproductkey () {
		return _moveproductkey;
	}
	
	/**
	 * Set the value related to the column: moveproductkey
	 * @param _moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String _moveproductkey) {
		this._moveproductkey = _moveproductkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}
	
	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
	}
	
	
	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}
	
	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
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
	 * Return the value associated with the column: fitcoddes
	 */
	public java.lang.String getFitcoddes () {
		return fitcoddes;
	}
	
	/**
	 * Set the value related to the column: fitcoddes
	 * @param fitcoddes the fitcoddes value
	 */
	public void setFitcoddes (java.lang.String fitcoddes) {
		this.fitcoddes = fitcoddes;
	}
	
	
	// --------------------------------------------------------- Public Methods
	
	
	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {         
		this.checked = false;        
	}
	
	
	/**
	 * Validate the properties that have been set from this HTTP request,
	 * and return an <code>ActionErrors</code> object that encapsulates any
	 * validation errors that have been found.  If no errors are found, return
	 * <code>null</code> or an <code>ActionErrors</code> object with no
	 * recorded error messages.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		return (errors);
		
	}
	
	
}

