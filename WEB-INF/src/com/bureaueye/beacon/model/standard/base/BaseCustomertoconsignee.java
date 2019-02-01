package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoconsignee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoconsignee"
 */

public abstract class BaseCustomertoconsignee  implements Serializable {

	public static String REF = "Customertoconsignee";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_TOKEY = "Tokey";
	public static String PROP_CUSTOMERTOCONSIGNEE_ID = "CustomertoconsigneeId";


	// constructors
	public BaseCustomertoconsignee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoconsignee (java.lang.Integer customertoconsigneeId) {
		this.setCustomertoconsigneeId(customertoconsigneeId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoconsignee (
		java.lang.Integer customertoconsigneeId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoconsigneeId(customertoconsigneeId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoconsigneeId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOCONSIGNEE_ID"
     */
	public java.lang.Integer getCustomertoconsigneeId () {
		return customertoconsigneeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoconsigneeId the new ID
	 */
	public void setCustomertoconsigneeId (java.lang.Integer customertoconsigneeId) {
		this.customertoconsigneeId = customertoconsigneeId;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoconsignee)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee = (com.bureaueye.beacon.model.standard.Customertoconsignee) obj;
			if (null == this.getCustomertoconsigneeId() || null == customertoconsignee.getCustomertoconsigneeId()) return false;
			else return (this.getCustomertoconsigneeId().equals(customertoconsignee.getCustomertoconsigneeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoconsigneeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoconsigneeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}