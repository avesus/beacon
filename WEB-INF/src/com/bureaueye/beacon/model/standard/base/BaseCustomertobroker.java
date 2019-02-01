package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertobroker table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertobroker"
 */

public abstract class BaseCustomertobroker  implements Serializable {

	public static String REF = "Customertobroker";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_CUSTOMERTOBROKER_ID = "CustomertobrokerId";


	// constructors
	public BaseCustomertobroker () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertobroker (java.lang.Integer customertobrokerId) {
		this.setCustomertobrokerId(customertobrokerId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertobroker (
		java.lang.Integer customertobrokerId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertobrokerId(customertobrokerId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertobrokerId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOBROKER_ID"
     */
	public java.lang.Integer getCustomertobrokerId () {
		return customertobrokerId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertobrokerId the new ID
	 */
	public void setCustomertobrokerId (java.lang.Integer customertobrokerId) {
		this.customertobrokerId = customertobrokerId;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertobroker)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertobroker customertobroker = (com.bureaueye.beacon.model.standard.Customertobroker) obj;
			if (null == this.getCustomertobrokerId() || null == customertobroker.getCustomertobrokerId()) return false;
			else return (this.getCustomertobrokerId().equals(customertobroker.getCustomertobrokerId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertobrokerId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertobrokerId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}