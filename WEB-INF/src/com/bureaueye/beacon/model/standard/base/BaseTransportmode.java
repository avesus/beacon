package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the transportmode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="transportmode"
 */

public abstract class BaseTransportmode  implements Serializable {

	public static String REF = "Transportmode";
	public static String PROP_TRANSPORTMODE = "Transportmode";
	public static String PROP_DESCR = "Descr";


	// constructors
	public BaseTransportmode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTransportmode (java.lang.String transportmode) {
		this.setTransportmode(transportmode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String transportmode;

	// fields
	private java.lang.String descr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="transportmode"
     */
	public java.lang.String getTransportmode () {
		return transportmode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param transportmode the new ID
	 */
	public void setTransportmode (java.lang.String transportmode) {
		this.transportmode = transportmode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: descr
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: descr
	 * @param descr the descr value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Transportmode)) return false;
		else {
			com.bureaueye.beacon.model.standard.Transportmode transportmode = (com.bureaueye.beacon.model.standard.Transportmode) obj;
			if (null == this.getTransportmode() || null == transportmode.getTransportmode()) return false;
			else return (this.getTransportmode().equals(transportmode.getTransportmode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTransportmode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTransportmode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}