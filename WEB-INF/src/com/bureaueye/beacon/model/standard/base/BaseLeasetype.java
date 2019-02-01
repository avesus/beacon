package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the leasetype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="leasetype"
 */

public abstract class BaseLeasetype  implements Serializable {

	public static String REF = "Leasetype";
	public static String PROP_LEASETYPEKEY = "Leasetypekey";
	public static String PROP_LDESC = "Ldesc";
	public static String PROP_LEASETYPE_ID = "LeasetypeId";


	// constructors
	public BaseLeasetype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeasetype (java.lang.Integer leasetypeId) {
		this.setLeasetypeId(leasetypeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer leasetypeId;

	// fields
	private java.lang.String leasetypekey;
	private java.lang.String ldesc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="LEASETYPE_ID"
     */
	public java.lang.Integer getLeasetypeId () {
		return leasetypeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param leasetypeId the new ID
	 */
	public void setLeasetypeId (java.lang.Integer leasetypeId) {
		this.leasetypeId = leasetypeId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
	}



	/**
	 * Return the value associated with the column: ldesc
	 */
	public java.lang.String getLdesc () {
		return ldesc;
	}

	/**
	 * Set the value related to the column: ldesc
	 * @param ldesc the ldesc value
	 */
	public void setLdesc (java.lang.String ldesc) {
		this.ldesc = ldesc;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Leasetype)) return false;
		else {
			com.bureaueye.beacon.model.standard.Leasetype leasetype = (com.bureaueye.beacon.model.standard.Leasetype) obj;
			if (null == this.getLeasetypeId() || null == leasetype.getLeasetypeId()) return false;
			else return (this.getLeasetypeId().equals(leasetype.getLeasetypeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getLeasetypeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getLeasetypeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}