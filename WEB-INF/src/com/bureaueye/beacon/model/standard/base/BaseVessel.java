package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vessel table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vessel"
 */

public abstract class BaseVessel  implements Serializable {

	public static String REF = "Vessel";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_VESSELFLAG = "Vesselflag";
	public static String PROP_VESSELNAME = "Vesselname";
	public static String PROP_VESSELKEY = "Vesselkey";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_REGNO = "Regno";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CREATEDATE = "Createdate";


	// constructors
	public BaseVessel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVessel (java.lang.String vesselkey) {
		this.setVesselkey(vesselkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String vesselkey;

	// fields
	private java.lang.String vesselname;
	private java.lang.String createuserid;
	private java.lang.String xinactive;
	private java.lang.Integer rowid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String regno;
	private java.lang.String vesselflag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="vesselkey"
     */
	public java.lang.String getVesselkey () {
		return vesselkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param vesselkey the new ID
	 */
	public void setVesselkey (java.lang.String vesselkey) {
		this.vesselkey = vesselkey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: vesselname
	 */
	public java.lang.String getVesselname () {
		return vesselname;
	}

	/**
	 * Set the value related to the column: vesselname
	 * @param vesselname the vesselname value
	 */
	public void setVesselname (java.lang.String vesselname) {
		this.vesselname = vesselname;
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
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
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
	 * Return the value associated with the column: regno
	 */
	public java.lang.String getRegno () {
		return regno;
	}

	/**
	 * Set the value related to the column: regno
	 * @param regno the regno value
	 */
	public void setRegno (java.lang.String regno) {
		this.regno = regno;
	}



	/**
	 * Return the value associated with the column: vesselflag
	 */
	public java.lang.String getVesselflag () {
		return vesselflag;
	}

	/**
	 * Set the value related to the column: vesselflag
	 * @param vesselflag the vesselflag value
	 */
	public void setVesselflag (java.lang.String vesselflag) {
		this.vesselflag = vesselflag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Vessel)) return false;
		else {
			com.bureaueye.beacon.model.standard.Vessel vessel = (com.bureaueye.beacon.model.standard.Vessel) obj;
			if (null == this.getVesselkey() || null == vessel.getVesselkey()) return false;
			else return (this.getVesselkey().equals(vessel.getVesselkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getVesselkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getVesselkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}