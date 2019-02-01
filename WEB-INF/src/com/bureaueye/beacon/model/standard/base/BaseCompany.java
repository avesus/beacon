package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the company table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="company"
 */

public abstract class BaseCompany  implements Serializable {

	public static String REF = "Company";
	public static String PROP_NAME = "Name";
	public static String PROP_ACCSYSCOMPID = "Accsyscompid";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_AIOUTBUILDCLASS = "Aioutbuildclass";
	public static String PROP_EMAIL = "Email";
	public static String PROP_COMPID = "Compid";
	public static String PROP_PAYONINV = "Payoninv";
	public static String PROP_COMPANYHEADER_ID = "CompanyheaderId";


	// constructors
	public BaseCompany () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompany (java.lang.String compid) {
		this.setCompid(compid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String compid;

	// fields
	private boolean payoninv;
	private java.lang.Integer rowid;
	private java.lang.String email;
	private java.lang.String name;
	private java.lang.Integer companyheaderId;
	private java.lang.String accsyscompid;
	private java.lang.String aioutbuildclass;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="compid"
     */
	public java.lang.String getCompid () {
		return compid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param compid the new ID
	 */
	public void setCompid (java.lang.String compid) {
		this.compid = compid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: payoninv
	 */
	public boolean isPayoninv () {
		return payoninv;
	}

	/**
	 * Set the value related to the column: payoninv
	 * @param payoninv the payoninv value
	 */
	public void setPayoninv (boolean payoninv) {
		this.payoninv = payoninv;
	}



	/**
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: COMPANYHEADER_ID
	 */
	public java.lang.Integer getCompanyheaderId () {
		return companyheaderId;
	}

	/**
	 * Set the value related to the column: COMPANYHEADER_ID
	 * @param companyheaderId the COMPANYHEADER_ID value
	 */
	public void setCompanyheaderId (java.lang.Integer companyheaderId) {
		this.companyheaderId = companyheaderId;
	}



	/**
	 * Return the value associated with the column: accsyscompid
	 */
	public java.lang.String getAccsyscompid () {
		return accsyscompid;
	}

	/**
	 * Set the value related to the column: accsyscompid
	 * @param accsyscompid the accsyscompid value
	 */
	public void setAccsyscompid (java.lang.String accsyscompid) {
		this.accsyscompid = accsyscompid;
	}



	/**
	 * Return the value associated with the column: aioutbuildclass
	 */
	public java.lang.String getAioutbuildclass () {
		return aioutbuildclass;
	}

	/**
	 * Set the value related to the column: aioutbuildclass
	 * @param aioutbuildclass the aioutbuildclass value
	 */
	public void setAioutbuildclass (java.lang.String aioutbuildclass) {
		this.aioutbuildclass = aioutbuildclass;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Company)) return false;
		else {
			com.bureaueye.beacon.model.standard.Company company = (com.bureaueye.beacon.model.standard.Company) obj;
			if (null == this.getCompid() || null == company.getCompid()) return false;
			else return (this.getCompid().equals(company.getCompid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCompid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCompid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}