package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fitgrp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fitgrp"
 */

public abstract class BaseFitgrp  implements Serializable {

	public static String REF = "Fitgrp";
	public static String PROP_FITGRPKEY = "Fitgrpkey";
	public static String PROP_LDESC = "Ldesc";


	// constructors
	public BaseFitgrp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFitgrp (java.lang.String fitgrpkey) {
		this.setFitgrpkey(fitgrpkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String fitgrpkey;

	// fields
	private java.lang.String ldesc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="fitgrpkey"
     */
	public java.lang.String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param fitgrpkey the new ID
	 */
	public void setFitgrpkey (java.lang.String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
		this.hashCode = Integer.MIN_VALUE;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Fitgrp)) return false;
		else {
			com.bureaueye.beacon.model.standard.Fitgrp fitgrp = (com.bureaueye.beacon.model.standard.Fitgrp) obj;
			if (null == this.getFitgrpkey() || null == fitgrp.getFitgrpkey()) return false;
			else return (this.getFitgrpkey().equals(fitgrp.getFitgrpkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getFitgrpkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getFitgrpkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}