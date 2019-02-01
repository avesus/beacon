package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the movement table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="movement"
 */

public abstract class BaseMovement  implements Serializable {

	public static String REF = "Movement";
	public static String PROP_MOVETIME = "Movetime";
	public static String PROP_MOVEREF = "Moveref";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_MOVEADDRKEY = "Moveaddrkey";
	public static String PROP_MOVETIMESTAMP = "Movetimestamp";
	public static String PROP_MOVEMENT_ID = "MovementId";
	public static String PROP_INVSTS = "Invsts";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_MOVESTS = "Movests";
	public static String PROP_MOVEPRODUCTKEY = "Moveproductkey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_OFFHIREEQP_ID = "OffhireeqpId";
	public static String PROP_MOVEKEY = "Movekey";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ONHIREEQP_ID = "OnhireeqpId";
	public static String PROP_NOTES = "Notes";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_MOVEDATE = "Movedate";
	public static String PROP_MOVETIMEINMILLIS = "Movetimeinmillis";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_MOVELOCATIONKEY = "Movelocationkey";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseMovement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMovement (java.lang.Integer movementId) {
		this.setMovementId(movementId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer movementId;

	// fields
	private java.lang.String movekey;
	private java.lang.String moveref;
	private java.lang.String systemlogprogram;
	private java.lang.String movetime;
	private java.lang.Integer unitId;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String notes;
	private java.util.Date movetimestamp;
	private java.lang.String invsts;
	private boolean xinactive;
	private java.lang.String movests;
	private java.util.Date movedate;
	private java.lang.Long movetimeinmillis;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String unitkey;
	private java.lang.String moveproductkey;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.lang.String xlock;
	private java.lang.String moveaddrkey;
	private java.lang.Integer onhireeqpId;
	private java.lang.Integer offhireeqpId;
	private java.lang.String movelocationkey;



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
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
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
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
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
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
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
	public java.lang.String getMoveproductkey () {
		return moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String moveproductkey) {
		this.moveproductkey = moveproductkey;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
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
	 * Return the value associated with the column: moveaddrkey
	 */
	public java.lang.String getMoveaddrkey () {
		return moveaddrkey;
	}

	/**
	 * Set the value related to the column: moveaddrkey
	 * @param moveaddrkey the moveaddrkey value
	 */
	public void setMoveaddrkey (java.lang.String moveaddrkey) {
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
	public java.lang.String getMovelocationkey () {
		return movelocationkey;
	}

	/**
	 * Set the value related to the column: movelocationkey
	 * @param movelocationkey the movelocationkey value
	 */
	public void setMovelocationkey (java.lang.String movelocationkey) {
		this.movelocationkey = movelocationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Movement)) return false;
		else {
			com.bureaueye.beacon.model.standard.Movement movement = (com.bureaueye.beacon.model.standard.Movement) obj;
			if (null == this.getMovementId() || null == movement.getMovementId()) return false;
			else return (this.getMovementId().equals(movement.getMovementId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getMovementId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getMovementId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}