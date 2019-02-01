package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoshipper table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoshipper"
 */

public abstract class BaseCustomertoshipper  implements Serializable {

	public static String REF = "Customertoshipper";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_CUSTOMERTOSHIPPER_ID = "CustomertoshipperId";


	// constructors
	public BaseCustomertoshipper () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoshipper (java.lang.Integer customertoshipperId) {
		this.setCustomertoshipperId(customertoshipperId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoshipper (
		java.lang.Integer customertoshipperId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoshipperId(customertoshipperId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoshipperId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOSHIPPER_ID"
     */
	public java.lang.Integer getCustomertoshipperId () {
		return customertoshipperId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoshipperId the new ID
	 */
	public void setCustomertoshipperId (java.lang.Integer customertoshipperId) {
		this.customertoshipperId = customertoshipperId;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoshipper)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoshipper customertoshipper = (com.bureaueye.beacon.model.standard.Customertoshipper) obj;
			if (null == this.getCustomertoshipperId() || null == customertoshipper.getCustomertoshipperId()) return false;
			else return (this.getCustomertoshipperId().equals(customertoshipper.getCustomertoshipperId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoshipperId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoshipperId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}