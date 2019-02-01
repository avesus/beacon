package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.standard.Fitgrp;
import com.bureaueye.beacon.model.standard.Fittyp;
import com.bureaueye.beacon.model.standard.Unitfit;
import com.bureaueye.beacon.model.standard.bd.FitgrpBD;
import com.bureaueye.beacon.model.standard.bd.FittypBD;






public final class UnitfitDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitfitDTO(Unitfit dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitfitDTO(Unitfit dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Unitfit dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setFitgrpkey(new FitgrpBD(this.getSessionFactoryClusterMap()).read(dao.getFitgrpkey()));
		this.setFittypkey(new FittypBD(this.getSessionFactoryClusterMap()).read(dao.getFittypkey()));
		
		this.setUnitfitId(dao.getUnitfitId());
		
		this.setUnitId(dao.getUnitId());
		this.setUnitkey(dao.getUnitkey());
		this.setFitpos(dao.getFitpos());
		this.setFitcoddes(dao.getFitcoddes());
				
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	
	// primary key
	private java.lang.Integer unitfitId;

	// fields
	private java.lang.String unitkey;
	private Fitgrp fitgrpkey;
	private Fittyp fittypkey;
	private java.lang.String fitcodkey;
	private java.lang.String fitpos;
	private java.lang.String xlock;
	private java.lang.String fitcoddes;
	private java.lang.String mandrkey;
	private boolean deleted;
	private java.lang.Integer mandrlinkkey;
	private java.lang.Integer unitId;





	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITFIT_ID"
     */
	public java.lang.Integer getUnitfitId () {
		return unitfitId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitfitId the new ID
	 */
	public void setUnitfitId (java.lang.Integer unitfitId) {
		this.unitfitId = unitfitId;
	}




	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
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
	 * Return the value associated with the column: fitcodkey
	 */
	public java.lang.String getFitcodkey () {
		return fitcodkey;
	}

	/**
	 * Set the value related to the column: fitcodkey
	 * @param fitcodkey the fitcodkey value
	 */
	public void setFitcodkey (java.lang.String fitcodkey) {
		this.fitcodkey = fitcodkey;
	}



	/**
	 * Return the value associated with the column: fitpos
	 */
	public java.lang.String getFitpos () {
		return fitpos;
	}

	/**
	 * Set the value related to the column: fitpos
	 * @param fitpos the fitpos value
	 */
	public void setFitpos (java.lang.String fitpos) {
		this.fitpos = fitpos;
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








	/**
	 * Return the value associated with the column: mandrkey
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: mandrkey
	 * @param mandrkey the mandrkey value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
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
	 * Return the value associated with the column: mandrlinkkey
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: mandrlinkkey
	 * @param mandrlinkkey the mandrlinkkey value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
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

	
}
