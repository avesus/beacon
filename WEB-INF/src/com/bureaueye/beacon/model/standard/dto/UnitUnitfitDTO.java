package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;



import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unitfit;







public final class UnitUnitfitDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitUnitfitDTO(Unit unit, Unitfit dao) throws ApplicationException {
		initialize(unit, dao);		
	}

	
	protected void initialize (Unit unit, Unitfit dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setFitgrpkey(dao.getFitgrpkey());
		this.setFittypkey(dao.getFittypkey());
		
		this.setUnitfitId(dao.getUnitfitId());
		
		this.setUnitId(unit.getUnitId());
		this.setUnitkey(unit.getUnitkey());
		
		this.setFitpos(dao.getFitpos());
		this.setFitcoddes(dao.getFitcoddes());

		this.movelocationkey = unit.getJobmovlocationkey();

		this.moveaddrkey = unit.getMoveaddrkey();
	
		this.movelocationkey2 = unit.getMovelocationkey();
		

		this.moveref = unit.getMoveref();
		this.movests = unit.getMovests();
		
		this.moveproductkey = unit.getMoveproductkey();
		
		this.eqpkeyp1 = unit.getEqpkeyp1();
		this.eqpkeyp2 = unit.getEqpkeyp2();
		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	
	// primary key
	private java.lang.Integer unitfitId;

	// fields
	private java.lang.String unitkey;
	private String fitgrpkey;
	private String fittypkey;
	private java.lang.String fitcodkey;
	private java.lang.String fitpos;
	private java.lang.String xlock;
	private java.lang.String fitcoddes;
	private java.lang.String mandrkey;
	private boolean deleted;
	private java.lang.Integer mandrlinkkey;
	private java.lang.Integer unitId;

	private String movests;
	private String moveref;
	private String moveproductkey;	
	private String movelocationkey;
	private String movelocationkey2;
	private String moveaddrkey;	

	private java.lang.String eqpkeyp1;
	private java.lang.String eqpkeyp2;

	



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
	public String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}



	/**
	 * Return the value associated with the column: fittypkey
	 */
	public String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (String fittypkey) {
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


	
	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public String getMovelocationkey () {
		return movelocationkey;
	}

	/**
	 * Set the value related to the column: _movelocationkey
	 * @param __movelocationkey the _movelocationkey value
	 */
	public void setMovelocationkey (String movelocationkey) {
		this.movelocationkey = movelocationkey;
	}

	
	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public String getMovelocationkey2 () {
		return movelocationkey2;
	}

	/**
	 */
	public void setMovelocationkey2 (String movelocationkey2) {
		this.movelocationkey2 = movelocationkey2;
	}
	
	

	/**
	 */
	public String getMoveaddrkey () {
		return moveaddrkey;
	}

	/**
	 */
	public void setMoveaddrkey (String moveaddrkey) {
		this.moveaddrkey = moveaddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param _movests the movests value
	 */
	public void setMovests (java.lang.String movests) {
		this.movests = movests;
	}	

	
	/**
	 */
	public java.lang.String getMoveref () {
		return moveref;
	}

	/**
	 */
	public void setMoveref (java.lang.String moveref) {
		this.moveref = moveref;
	}
	
	
	/**
	 * Return the value associated with the column: moveproductkey
	 */
	public java.lang.String getMoveproductkey () {
		return moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param _moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String moveproductkey) {
		this.moveproductkey = moveproductkey;
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
	
	
}
