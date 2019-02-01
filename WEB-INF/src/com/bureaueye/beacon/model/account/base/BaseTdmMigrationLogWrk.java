package com.bureaueye.beacon.model.account.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tdmmigrationlogwrk table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tdmmigrationlogwrk"
 */

public abstract class BaseTdmMigrationLogWrk  implements Serializable {

	public static String REF = "TdmMigrationLogWrk";
	public static String PROP_STATUS = "Status";
	public static String PROP_COLUMN_I_D = "ColumnID";
	public static String PROP_DUPLICATE = "Duplicate";
	public static String PROP_COLUMN_VALUE = "ColumnValue";
	public static String PROP_SESSION_KEY = "SessionKey";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ENTITY_I_D = "EntityID";


	// constructors
	public BaseTdmMigrationLogWrk () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTdmMigrationLogWrk (java.lang.Integer entryNo) {
		this.setEntryNo(entryNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer entryNo;

	// fields
	private java.lang.String status;
	private java.lang.Short duplicate;
	private java.lang.String columnID;
	private java.lang.String columnValue;
	private java.lang.Integer sessionKey;
	private java.lang.String comment;
	private java.lang.String entityID;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="EntryNo"
     */
	public java.lang.Integer getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the unique identifier of this class
	 * @param entryNo the new ID
	 */
	public void setEntryNo (java.lang.Integer entryNo) {
		this.entryNo = entryNo;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: Duplicate
	 */
	public java.lang.Short getDuplicate () {
		return duplicate;
	}

	/**
	 * Set the value related to the column: Duplicate
	 * @param duplicate the Duplicate value
	 */
	public void setDuplicate (java.lang.Short duplicate) {
		this.duplicate = duplicate;
	}



	/**
	 * Return the value associated with the column: ColumnID
	 */
	public java.lang.String getColumnID () {
		return columnID;
	}

	/**
	 * Set the value related to the column: ColumnID
	 * @param columnID the ColumnID value
	 */
	public void setColumnID (java.lang.String columnID) {
		this.columnID = columnID;
	}



	/**
	 * Return the value associated with the column: ColumnValue
	 */
	public java.lang.String getColumnValue () {
		return columnValue;
	}

	/**
	 * Set the value related to the column: ColumnValue
	 * @param columnValue the ColumnValue value
	 */
	public void setColumnValue (java.lang.String columnValue) {
		this.columnValue = columnValue;
	}



	/**
	 * Return the value associated with the column: SessionKey
	 */
	public java.lang.Integer getSessionKey () {
		return sessionKey;
	}

	/**
	 * Set the value related to the column: SessionKey
	 * @param sessionKey the SessionKey value
	 */
	public void setSessionKey (java.lang.Integer sessionKey) {
		this.sessionKey = sessionKey;
	}



	/**
	 * Return the value associated with the column: Comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: Comment
	 * @param comment the Comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: EntityID
	 */
	public java.lang.String getEntityID () {
		return entityID;
	}

	/**
	 * Set the value related to the column: EntityID
	 * @param entityID the EntityID value
	 */
	public void setEntityID (java.lang.String entityID) {
		this.entityID = entityID;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.account.TdmMigrationLogWrk)) return false;
		else {
			com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk = (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) obj;
			if (null == this.getEntryNo() || null == tdmMigrationLogWrk.getEntryNo()) return false;
			else return (this.getEntryNo().equals(tdmMigrationLogWrk.getEntryNo()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getEntryNo()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getEntryNo().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}