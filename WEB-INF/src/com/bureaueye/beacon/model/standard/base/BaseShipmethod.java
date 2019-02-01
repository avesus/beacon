package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shipmethod table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shipmethod"
 */

public abstract class BaseShipmethod  implements Serializable {

	public static String REF = "Shipmethod";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_SHIPMETHOD_ID = "ShipmethodId";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_SHIP_METHOD = "ShipMethod";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_XACTION = "Xaction";


	// constructors
	public BaseShipmethod () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShipmethod (java.lang.Integer shipmethodId) {
		this.setShipmethodId(shipmethodId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer shipmethodId;

	// fields
	private java.lang.String shipMethod;
	private java.lang.String xuserid;
	private java.util.Date xdate;
	private java.lang.String xtime;
	private java.lang.String xprog;
	private java.lang.String xaction;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ShipMethodId"
     */
	public java.lang.Integer getShipmethodId () {
		return shipmethodId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param shipmethodId the new ID
	 */
	public void setShipmethodId (java.lang.Integer shipmethodId) {
		this.shipmethodId = shipmethodId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ShipMethod
	 */
	public java.lang.String getShipMethod () {
		return shipMethod;
	}

	/**
	 * Set the value related to the column: ShipMethod
	 * @param shipMethod the ShipMethod value
	 */
	public void setShipMethod (java.lang.String shipMethod) {
		this.shipMethod = shipMethod;
	}



	/**
	 * Return the value associated with the column: xuserid
	 */
	public java.lang.String getXuserid () {
		return xuserid;
	}

	/**
	 * Set the value related to the column: xuserid
	 * @param xuserid the xuserid value
	 */
	public void setXuserid (java.lang.String xuserid) {
		this.xuserid = xuserid;
	}



	/**
	 * Return the value associated with the column: xdate
	 */
	public java.util.Date getXdate () {
		return xdate;
	}

	/**
	 * Set the value related to the column: xdate
	 * @param xdate the xdate value
	 */
	public void setXdate (java.util.Date xdate) {
		this.xdate = xdate;
	}



	/**
	 * Return the value associated with the column: xtime
	 */
	public java.lang.String getXtime () {
		return xtime;
	}

	/**
	 * Set the value related to the column: xtime
	 * @param xtime the xtime value
	 */
	public void setXtime (java.lang.String xtime) {
		this.xtime = xtime;
	}



	/**
	 * Return the value associated with the column: xprog
	 */
	public java.lang.String getXprog () {
		return xprog;
	}

	/**
	 * Set the value related to the column: xprog
	 * @param xprog the xprog value
	 */
	public void setXprog (java.lang.String xprog) {
		this.xprog = xprog;
	}



	/**
	 * Return the value associated with the column: xaction
	 */
	public java.lang.String getXaction () {
		return xaction;
	}

	/**
	 * Set the value related to the column: xaction
	 * @param xaction the xaction value
	 */
	public void setXaction (java.lang.String xaction) {
		this.xaction = xaction;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Shipmethod)) return false;
		else {
			com.bureaueye.beacon.model.standard.Shipmethod shipmethod = (com.bureaueye.beacon.model.standard.Shipmethod) obj;
			if (null == this.getShipmethodId() || null == shipmethod.getShipmethodId()) return false;
			else return (this.getShipmethodId().equals(shipmethod.getShipmethodId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getShipmethodId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getShipmethodId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}