package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoshipline table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoshipline"
 */

public abstract class BaseCustomertoshipline  implements Serializable {

	public static String REF = "Customertoshipline";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_CUSTOMERTOSHIPLINE_ID = "CustomertoshiplineId";


	// constructors
	public BaseCustomertoshipline () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoshipline (java.lang.Integer customertoshiplineId) {
		this.setCustomertoshiplineId(customertoshiplineId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoshipline (
		java.lang.Integer customertoshiplineId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoshiplineId(customertoshiplineId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoshiplineId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOSHIPLINE_ID"
     */
	public java.lang.Integer getCustomertoshiplineId () {
		return customertoshiplineId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoshiplineId the new ID
	 */
	public void setCustomertoshiplineId (java.lang.Integer customertoshiplineId) {
		this.customertoshiplineId = customertoshiplineId;
		this.hashCode = Integer.MIN_VALUE;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoshipline)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoshipline customertoshipline = (com.bureaueye.beacon.model.standard.Customertoshipline) obj;
			if (null == this.getCustomertoshiplineId() || null == customertoshipline.getCustomertoshiplineId()) return false;
			else return (this.getCustomertoshiplineId().equals(customertoshipline.getCustomertoshiplineId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoshiplineId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoshiplineId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}