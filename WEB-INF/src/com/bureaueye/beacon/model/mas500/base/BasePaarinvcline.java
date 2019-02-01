package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the paarinvcline table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="paarinvcline"
 */

public abstract class BasePaarinvcline  implements Serializable {

	public static String REF = "Paarinvcline";
	public static String PROP_INT_JOB_LINE_KEY = "IntJobLineKey";
	public static String PROP_SI_FROM_T_S = "SiFromTS";
	public static String PROP_INT_JOB_KEY = "IntJobKey";
	public static String PROP_INT_PHASE_KEY = "IntPhaseKey";
	public static String PROP_INT_INV_DESCR_KEY = "IntInvDescrKey";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_INT_TASK_KEY = "IntTaskKey";
	public static String PROP_INVOICE_LINE_KEY = "InvoiceLineKey";


	// constructors
	public BasePaarinvcline () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaarinvcline (java.lang.Integer invoiceLineKey) {
		this.setInvoiceLineKey(invoiceLineKey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer invoiceLineKey;

	// fields
	private java.lang.Integer intTaskKey;
	private java.lang.Integer intInvDescrKey;
	private java.lang.Integer intJobLineKey;
	private java.lang.String comment;
	private java.lang.Short siFromTS;
	private java.lang.Integer intPhaseKey;
	private java.lang.Integer intJobKey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="InvoiceLineKey"
     */
	public java.lang.Integer getInvoiceLineKey () {
		return invoiceLineKey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param invoiceLineKey the new ID
	 */
	public void setInvoiceLineKey (java.lang.Integer invoiceLineKey) {
		this.invoiceLineKey = invoiceLineKey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: intTaskKey
	 */
	public java.lang.Integer getIntTaskKey () {
		return intTaskKey;
	}

	/**
	 * Set the value related to the column: intTaskKey
	 * @param intTaskKey the intTaskKey value
	 */
	public void setIntTaskKey (java.lang.Integer intTaskKey) {
		this.intTaskKey = intTaskKey;
	}



	/**
	 * Return the value associated with the column: intInvDescrKey
	 */
	public java.lang.Integer getIntInvDescrKey () {
		return intInvDescrKey;
	}

	/**
	 * Set the value related to the column: intInvDescrKey
	 * @param intInvDescrKey the intInvDescrKey value
	 */
	public void setIntInvDescrKey (java.lang.Integer intInvDescrKey) {
		this.intInvDescrKey = intInvDescrKey;
	}



	/**
	 * Return the value associated with the column: intJobLineKey
	 */
	public java.lang.Integer getIntJobLineKey () {
		return intJobLineKey;
	}

	/**
	 * Set the value related to the column: intJobLineKey
	 * @param intJobLineKey the intJobLineKey value
	 */
	public void setIntJobLineKey (java.lang.Integer intJobLineKey) {
		this.intJobLineKey = intJobLineKey;
	}



	/**
	 * Return the value associated with the column: Comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: Comment
	 * @param comment the Comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: siFromTS
	 */
	public java.lang.Short getSiFromTS () {
		return siFromTS;
	}

	/**
	 * Set the value related to the column: siFromTS
	 * @param siFromTS the siFromTS value
	 */
	public void setSiFromTS (java.lang.Short siFromTS) {
		this.siFromTS = siFromTS;
	}



	/**
	 * Return the value associated with the column: intPhaseKey
	 */
	public java.lang.Integer getIntPhaseKey () {
		return intPhaseKey;
	}

	/**
	 * Set the value related to the column: intPhaseKey
	 * @param intPhaseKey the intPhaseKey value
	 */
	public void setIntPhaseKey (java.lang.Integer intPhaseKey) {
		this.intPhaseKey = intPhaseKey;
	}



	/**
	 * Return the value associated with the column: intJobKey
	 */
	public java.lang.Integer getIntJobKey () {
		return intJobKey;
	}

	/**
	 * Set the value related to the column: intJobKey
	 * @param intJobKey the intJobKey value
	 */
	public void setIntJobKey (java.lang.Integer intJobKey) {
		this.intJobKey = intJobKey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Paarinvcline)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline = (com.bureaueye.beacon.model.mas500.Paarinvcline) obj;
			if (null == this.getInvoiceLineKey() || null == paarinvcline.getInvoiceLineKey()) return false;
			else return (this.getInvoiceLineKey().equals(paarinvcline.getInvoiceLineKey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getInvoiceLineKey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getInvoiceLineKey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}