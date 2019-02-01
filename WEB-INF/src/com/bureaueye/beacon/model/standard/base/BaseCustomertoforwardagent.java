package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customertoforwardagent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customertoforwardagent"
 */

public abstract class BaseCustomertoforwardagent  implements Serializable {

	public static String REF = "Customertoforwardagent";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_CUSTOMERTOFORWARDAGENT_ID = "CustomertoforwardagentId";
	public static String PROP_TOKEY = "Tokey";


	// constructors
	public BaseCustomertoforwardagent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomertoforwardagent (java.lang.Integer customertoforwardagentId) {
		this.setCustomertoforwardagentId(customertoforwardagentId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomertoforwardagent (
		java.lang.Integer customertoforwardagentId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		this.setCustomertoforwardagentId(customertoforwardagentId);
		this.setTokey(tokey);
		this.setCustomeraddrkey(customeraddrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer customertoforwardagentId;

	// fields
	private java.lang.String tokey;
	private java.lang.String customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CUSTOMERTOFORWARDAGENT_ID"
     */
	public java.lang.Integer getCustomertoforwardagentId () {
		return customertoforwardagentId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customertoforwardagentId the new ID
	 */
	public void setCustomertoforwardagentId (java.lang.Integer customertoforwardagentId) {
		this.customertoforwardagentId = customertoforwardagentId;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Customertoforwardagent)) return false;
		else {
			com.bureaueye.beacon.model.standard.Customertoforwardagent customertoforwardagent = (com.bureaueye.beacon.model.standard.Customertoforwardagent) obj;
			if (null == this.getCustomertoforwardagentId() || null == customertoforwardagent.getCustomertoforwardagentId()) return false;
			else return (this.getCustomertoforwardagentId().equals(customertoforwardagent.getCustomertoforwardagentId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomertoforwardagentId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomertoforwardagentId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}