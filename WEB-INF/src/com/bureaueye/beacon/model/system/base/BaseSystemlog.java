package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the systemlog table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="systemlog"
 */

public abstract class BaseSystemlog  implements Serializable {

	public static String REF = "Systemlog";
	public static String PROP_RECORDROWID = "Recordrowid";
	public static String PROP_USERID = "Userid";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_ACTION = "Action";
	public static String PROP_RECORDOBJECTCLASS = "Recordobjectclass";
	public static String PROP_LOGTIMESTAMP = "Logtimestamp";
	public static String PROP_RECORDOBJECTDATA = "Recordobjectdata";


	// constructors
	public BaseSystemlog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemlog (java.lang.Integer rowid) {
		this.setRowid(rowid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer rowid;

	// fields
	private java.lang.String action;
	private java.lang.String userid;
	private java.lang.String recordobjectclass;
	private java.lang.Integer recordrowid;
	private byte[] recordobjectdata;
	private java.util.Date logtimestamp;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="rowid"
     */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param rowid the new ID
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: action
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: action
	 * @param action the action value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: recordobjectclass
	 */
	public java.lang.String getRecordobjectclass () {
		return recordobjectclass;
	}

	/**
	 * Set the value related to the column: recordobjectclass
	 * @param recordobjectclass the recordobjectclass value
	 */
	public void setRecordobjectclass (java.lang.String recordobjectclass) {
		this.recordobjectclass = recordobjectclass;
	}



	/**
	 * Return the value associated with the column: recordrowid
	 */
	public java.lang.Integer getRecordrowid () {
		return recordrowid;
	}

	/**
	 * Set the value related to the column: recordrowid
	 * @param recordrowid the recordrowid value
	 */
	public void setRecordrowid (java.lang.Integer recordrowid) {
		this.recordrowid = recordrowid;
	}



	/**
	 * Return the value associated with the column: recordobjectdata
	 */
	public byte[] getRecordobjectdata () {
		return recordobjectdata;
	}

	/**
	 * Set the value related to the column: recordobjectdata
	 * @param recordobjectdata the recordobjectdata value
	 */
	public void setRecordobjectdata (byte[] recordobjectdata) {
		this.recordobjectdata = recordobjectdata;
	}



	/**
	 * Return the value associated with the column: logtimestamp
	 */
	public java.util.Date getLogtimestamp () {
		return logtimestamp;
	}

	/**
	 * Set the value related to the column: logtimestamp
	 * @param logtimestamp the logtimestamp value
	 */
	public void setLogtimestamp (java.util.Date logtimestamp) {
		this.logtimestamp = logtimestamp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.system.Systemlog)) return false;
		else {
			com.bureaueye.beacon.model.system.Systemlog systemlog = (com.bureaueye.beacon.model.system.Systemlog) obj;
			if (null == this.getRowid() || null == systemlog.getRowid()) return false;
			else return (this.getRowid().equals(systemlog.getRowid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getRowid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getRowid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}