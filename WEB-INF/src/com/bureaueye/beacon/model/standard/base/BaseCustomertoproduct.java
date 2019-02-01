package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoproduct table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoproduct"
 */

public abstract class BaseCustomertoproduct  implements Serializable {

	public static String REF = "Customertoproduct";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_CUSTOMERTOPRODUCT_ID = "CustomertoproductId";


	// constructors
	public BaseCustomertoproduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoproduct (java.lang.Integer customertoproductId) {
		this.setCustomertoproductId(customertoproductId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoproduct (
		java.lang.Integer customertoproductId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoproductId(customertoproductId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoproductId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOPRODUCT_ID"
     */
	public java.lang.Integer getCustomertoproductId () {
		return customertoproductId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoproductId the new ID
	 */
	public void setCustomertoproductId (java.lang.Integer customertoproductId) {
		this.customertoproductId = customertoproductId;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoproduct)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoproduct customertoproduct = (com.bureaueye.beacon.model.standard.Customertoproduct) obj;
			if (null == this.getCustomertoproductId() || null == customertoproduct.getCustomertoproductId()) return false;
			else return (this.getCustomertoproductId().equals(customertoproduct.getCustomertoproductId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoproductId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoproductId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}