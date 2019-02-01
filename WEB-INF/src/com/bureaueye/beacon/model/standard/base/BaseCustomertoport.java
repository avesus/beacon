package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoport table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoport"
 */

public abstract class BaseCustomertoport  implements Serializable {

	public static String REF = "Customertoport";
	public static String PROP_DEM_RATE1 = "DemRate1";
	public static String PROP_DEM_PERIOD1 = "DemPeriod1";
	public static String PROP_DEM_RATE3 = "DemRate3";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_DEM_RATE2 = "DemRate2";
	public static String PROP_DEM_PERIOD2 = "DemPeriod2";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_FREE_DAYS = "FreeDays";
	public static String PROP_CUSTOMERTOPORT_ID = "CustomertoportId";


	// constructors
	public BaseCustomertoport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoport (java.lang.Integer customertoportId) {
		this.setCustomertoportId(customertoportId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoport (
		java.lang.Integer customertoportId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoportId(customertoportId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoportId;

	// fields
	private java.math.BigDecimal demRate3;
	private java.math.BigDecimal demRate1;
	private java.lang.Integer demPeriod2;
	private java.lang.Integer demPeriod1;
	private java.lang.String tokey;
	private java.math.BigDecimal demRate2;
	private java.lang.Integer freeDays;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOPORT_ID"
     */
	public java.lang.Integer getCustomertoportId () {
		return customertoportId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoportId the new ID
	 */
	public void setCustomertoportId (java.lang.Integer customertoportId) {
		this.customertoportId = customertoportId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: DemRate3
	 */
	public java.math.BigDecimal getDemRate3 () {
		return demRate3;
	}

	/**
	 * Set the value related to the column: DemRate3
	 * @param demRate3 the DemRate3 value
	 */
	public void setDemRate3 (java.math.BigDecimal demRate3) {
		this.demRate3 = demRate3;
	}



	/**
	 * Return the value associated with the column: DemRate1
	 */
	public java.math.BigDecimal getDemRate1 () {
		return demRate1;
	}

	/**
	 * Set the value related to the column: DemRate1
	 * @param demRate1 the DemRate1 value
	 */
	public void setDemRate1 (java.math.BigDecimal demRate1) {
		this.demRate1 = demRate1;
	}



	/**
	 * Return the value associated with the column: DemPeriod2
	 */
	public java.lang.Integer getDemPeriod2 () {
		return demPeriod2;
	}

	/**
	 * Set the value related to the column: DemPeriod2
	 * @param demPeriod2 the DemPeriod2 value
	 */
	public void setDemPeriod2 (java.lang.Integer demPeriod2) {
		this.demPeriod2 = demPeriod2;
	}



	/**
	 * Return the value associated with the column: DemPeriod1
	 */
	public java.lang.Integer getDemPeriod1 () {
		return demPeriod1;
	}

	/**
	 * Set the value related to the column: DemPeriod1
	 * @param demPeriod1 the DemPeriod1 value
	 */
	public void setDemPeriod1 (java.lang.Integer demPeriod1) {
		this.demPeriod1 = demPeriod1;
	}



	/**
	 * Return the value associated with the column: tokey
	 */
	public java.lang.String getTokey () {
		return tokey;
	}

	/**
	 * Set the value related to the column: tokey
	 * @param tokey the tokey value
	 */
	public void setTokey (java.lang.String tokey) {
		this.tokey = tokey;
	}



	/**
	 * Return the value associated with the column: DemRate2
	 */
	public java.math.BigDecimal getDemRate2 () {
		return demRate2;
	}

	/**
	 * Set the value related to the column: DemRate2
	 * @param demRate2 the DemRate2 value
	 */
	public void setDemRate2 (java.math.BigDecimal demRate2) {
		this.demRate2 = demRate2;
	}



	/**
	 * Return the value associated with the column: FreeDays
	 */
	public java.lang.Integer getFreeDays () {
		return freeDays;
	}

	/**
	 * Set the value related to the column: FreeDays
	 * @param freeDays the FreeDays value
	 */
	public void setFreeDays (java.lang.Integer freeDays) {
		this.freeDays = freeDays;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoport)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoport customertoport = (com.bureaueye.beacon.model.standard.Customertoport) obj;
			if (null == this.getCustomertoportId() || null == customertoport.getCustomertoportId()) return false;
			else return (this.getCustomertoportId().equals(customertoport.getCustomertoportId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoportId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoportId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}