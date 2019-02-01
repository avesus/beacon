package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Movement;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.bd.LocationBD;




public final class MovementDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public MovementDTO(Movement dao) throws ApplicationException {
		initialize(dao);		
	}
	public MovementDTO(Movement dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Movement dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setMovelocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getMovelocationkey()));
		this.setMovekey(dao.getMovekey());
		this.setMoveref(dao.getMoveref());
		this.setMovetime(dao.getMovetime());
		this.setUnitId(dao.getUnitId());
		this.setNotes(dao.getNotes());
		this.setInvsts(dao.getInvsts());
		this.setMovests(dao.getMovests());
		this.setUnitkey(dao.getUnitkey());
		this.setMovedate(dao.getMovedate());
		this.setMovementId(dao.getMovementId());
	}
	

	// primary key
	private java.lang.Integer movementId;

	// fields
	private java.lang.String movekey;
	private java.lang.String moveref;
	private java.lang.String movetime;
	private java.lang.Integer unitId;
	private java.lang.String notes;
	private java.util.Date movetimestamp;
	private java.lang.String invsts;
	private java.lang.String movests;
	private java.util.Date movedate;
	private java.lang.Long movetimeinmillis;
	private java.lang.String unitkey;
	private Product moveproductkey;
	private Address moveaddrkey;
	private java.lang.Integer onhireeqpId;
	private java.lang.Integer offhireeqpId;
	private Location movelocationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MOVEMENT_ID"
     */
	public java.lang.Integer getMovementId () {
		return movementId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param movementId the new ID
	 */
	public void setMovementId (java.lang.Integer movementId) {
		this.movementId = movementId;
	}




	/**
	 * Return the value associated with the column: movekey
	 */
	public java.lang.String getMovekey () {
		return movekey;
	}

	/**
	 * Set the value related to the column: movekey
	 * @param movekey the movekey value
	 */
	public void setMovekey (java.lang.String movekey) {
		this.movekey = movekey;
	}



	/**
	 * Return the value associated with the column: moveref
	 */
	public java.lang.String getMoveref () {
		return moveref;
	}

	/**
	 * Set the value related to the column: moveref
	 * @param moveref the moveref value
	 */
	public void setMoveref (java.lang.String moveref) {
		this.moveref = moveref;
	}





	/**
	 * Return the value associated with the column: movetime
	 */
	public java.lang.String getMovetime () {
		return movetime;
	}

	/**
	 * Set the value related to the column: movetime
	 * @param movetime the movetime value
	 */
	public void setMovetime (java.lang.String movetime) {
		this.movetime = movetime;
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
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: movetimestamp
	 */
	public java.util.Date getMovetimestamp () {
		return movetimestamp;
	}

	/**
	 * Set the value related to the column: movetimestamp
	 * @param movetimestamp the movetimestamp value
	 */
	public void setMovetimestamp (java.util.Date movetimestamp) {
		this.movetimestamp = movetimestamp;
	}



	/**
	 * Return the value associated with the column: invsts
	 */
	public java.lang.String getInvsts () {
		return invsts;
	}

	/**
	 * Set the value related to the column: invsts
	 * @param invsts the invsts value
	 */
	public void setInvsts (java.lang.String invsts) {
		this.invsts = invsts;
	}





	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param movests the movests value
	 */
	public void setMovests (java.lang.String movests) {
		this.movests = movests;
	}



	/**
	 * Return the value associated with the column: movedate
	 */
	public java.util.Date getMovedate () {
		return movedate;
	}

	/**
	 * Set the value related to the column: movedate
	 * @param movedate the movedate value
	 */
	public void setMovedate (java.util.Date movedate) {
		this.movedate = movedate;
	}



	/**
	 * Return the value associated with the column: movetimeinmillis
	 */
	public java.lang.Long getMovetimeinmillis () {
		return movetimeinmillis;
	}

	/**
	 * Set the value related to the column: movetimeinmillis
	 * @param movetimeinmillis the movetimeinmillis value
	 */
	public void setMovetimeinmillis (java.lang.Long movetimeinmillis) {
		this.movetimeinmillis = movetimeinmillis;
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
	 * Return the value associated with the column: moveproductkey
	 */
	public Product getMoveproductkey () {
		return moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (Product moveproductkey) {
		this.moveproductkey = moveproductkey;
	}





	/**
	 * Return the value associated with the column: moveaddrkey
	 */
	public Address getMoveaddrkey () {
		return moveaddrkey;
	}

	/**
	 * Set the value related to the column: moveaddrkey
	 * @param moveaddrkey the moveaddrkey value
	 */
	public void setMoveaddrkey (Address moveaddrkey) {
		this.moveaddrkey = moveaddrkey;
	}



	/**
	 * Return the value associated with the column: ONHIREEQP_ID
	 */
	public java.lang.Integer getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the value related to the column: ONHIREEQP_ID
	 * @param onhireeqpId the ONHIREEQP_ID value
	 */
	public void setOnhireeqpId (java.lang.Integer onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
	}



	/**
	 * Return the value associated with the column: OFFHIREEQP_ID
	 */
	public java.lang.Integer getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the value related to the column: OFFHIREEQP_ID
	 * @param offhireeqpId the OFFHIREEQP_ID value
	 */
	public void setOffhireeqpId (java.lang.Integer offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
	}



	/**
	 * Return the value associated with the column: movelocationkey
	 */
	public Location getMovelocationkey () {
		return movelocationkey;
	}

	/**
	 * Set the value related to the column: movelocationkey
	 * @param movelocationkey the movelocationkey value
	 */
	public void setMovelocationkey (Location movelocationkey) {
		this.movelocationkey = movelocationkey;
	}

	
	
	
}
