package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fittyp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fittyp"
 */

public abstract class BaseFittyp  implements Serializable {

	public static String REF = "Fittyp";
	public static String PROP_FITTYPKEY = "Fittypkey";
	public static String PROP_FITGRPKEY = "Fitgrpkey";
	public static String PROP_LDESC = "Ldesc";


	// constructors
	public BaseFittyp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFittyp (java.lang.String fittypkey) {
		this.setFittypkey(fittypkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String fittypkey;

	// fields
	private java.lang.String ldesc;
	private java.lang.String fitgrpkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="fittypkey"
     */
	public java.lang.String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param fittypkey the new ID
	 */
	public void setFittypkey (java.lang.String fittypkey) {
		this.fittypkey = fittypkey;
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



	/**
	 * Return the value associated with the column: fitgrpkey
	 */
	public java.lang.String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (java.lang.String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Fittyp)) return false;
		else {
			com.bureaueye.beacon.model.standard.Fittyp fittyp = (com.bureaueye.beacon.model.standard.Fittyp) obj;
			if (null == this.getFittypkey() || null == fittyp.getFittypkey()) return false;
			else return (this.getFittypkey().equals(fittyp.getFittypkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getFittypkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getFittypkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}