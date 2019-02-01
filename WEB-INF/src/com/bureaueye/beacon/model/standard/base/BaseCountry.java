package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the country table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="country"
 */

public abstract class BaseCountry  implements Serializable {

	public static String REF = "Country";
	public static String PROP_COUNTRYKEY = "Countrykey";
	public static String PROP_COUNTRY = "Country";


	// constructors
	public BaseCountry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCountry (java.lang.String countrykey) {
		this.setCountrykey(countrykey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String countrykey;

	// fields
	private java.lang.String country;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="countrykey"
     */
	public java.lang.String getCountrykey () {
		return countrykey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param countrykey the new ID
	 */
	public void setCountrykey (java.lang.String countrykey) {
		this.countrykey = countrykey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: Country
	 * @param country the Country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Country)) return false;
		else {
			com.bureaueye.beacon.model.standard.Country country = (com.bureaueye.beacon.model.standard.Country) obj;
			if (null == this.getCountrykey() || null == country.getCountrykey()) return false;
			else return (this.getCountrykey().equals(country.getCountrykey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCountrykey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCountrykey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}