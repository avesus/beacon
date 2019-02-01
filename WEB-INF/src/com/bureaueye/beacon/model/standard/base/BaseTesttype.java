package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the testtype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="testtype"
 */

public abstract class BaseTesttype  implements Serializable {

	public static String REF = "Testtype";
	public static String PROP_SDESC = "Sdesc";
	public static String PROP_TESTTYPEKEY = "Testtypekey";
	public static String PROP_LDESC = "Ldesc";


	// constructors
	public BaseTesttype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTesttype (java.lang.String testtypekey) {
		this.setTesttypekey(testtypekey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String testtypekey;

	// fields
	private java.lang.String sdesc;
	private java.lang.String ldesc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="testtypekey"
     */
	public java.lang.String getTesttypekey () {
		return testtypekey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param testtypekey the new ID
	 */
	public void setTesttypekey (java.lang.String testtypekey) {
		this.testtypekey = testtypekey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: sdesc
	 */
	public java.lang.String getSdesc () {
		return sdesc;
	}

	/**
	 * Set the value related to the column: sdesc
	 * @param sdesc the sdesc value
	 */
	public void setSdesc (java.lang.String sdesc) {
		this.sdesc = sdesc;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Testtype)) return false;
		else {
			com.bureaueye.beacon.model.standard.Testtype testtype = (com.bureaueye.beacon.model.standard.Testtype) obj;
			if (null == this.getTesttypekey() || null == testtype.getTesttypekey()) return false;
			else return (this.getTesttypekey().equals(testtype.getTesttypekey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTesttypekey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTesttypekey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}