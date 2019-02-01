package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the system table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="system"
 */

public abstract class BaseSystemX  implements Serializable {

	public static String REF = "SystemX";
	public static String PROP_CERTIFPATH = "Certifpath";
	public static String PROP_SYSTEM_ID = "SystemId";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_CERTIFDIR = "Certifdir";
	public static String PROP_SYSTEMTASKAGENTSLEEP = "Systemtaskagentsleep";
	public static String PROP_SYSTEMTASKSTOP = "Systemtaskstop";
	public static String PROP_EDIID = "Ediid";


	// constructors
	public BaseSystemX () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemX (java.lang.Integer systemId) {
		this.setSystemId(systemId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer systemId;

	// fields
	private java.lang.String systemtaskstop;
	private java.lang.String ediid;
	private java.lang.String certifpath;
	private java.lang.String certifdir;
	private java.lang.String ccykey;
	private java.lang.Integer systemtaskagentsleep;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SYSTEM_ID"
     */
	public java.lang.Integer getSystemId () {
		return systemId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemId the new ID
	 */
	public void setSystemId (java.lang.Integer systemId) {
		this.systemId = systemId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: systemtaskstop
	 */
	public java.lang.String getSystemtaskstop () {
		return systemtaskstop;
	}

	/**
	 * Set the value related to the column: systemtaskstop
	 * @param systemtaskstop the systemtaskstop value
	 */
	public void setSystemtaskstop (java.lang.String systemtaskstop) {
		this.systemtaskstop = systemtaskstop;
	}



	/**
	 * Return the value associated with the column: ediid
	 */
	public java.lang.String getEdiid () {
		return ediid;
	}

	/**
	 * Set the value related to the column: ediid
	 * @param ediid the ediid value
	 */
	public void setEdiid (java.lang.String ediid) {
		this.ediid = ediid;
	}



	/**
	 * Return the value associated with the column: certifpath
	 */
	public java.lang.String getCertifpath () {
		return certifpath;
	}

	/**
	 * Set the value related to the column: certifpath
	 * @param certifpath the certifpath value
	 */
	public void setCertifpath (java.lang.String certifpath) {
		this.certifpath = certifpath;
	}



	/**
	 * Return the value associated with the column: certifdir
	 */
	public java.lang.String getCertifdir () {
		return certifdir;
	}

	/**
	 * Set the value related to the column: certifdir
	 * @param certifdir the certifdir value
	 */
	public void setCertifdir (java.lang.String certifdir) {
		this.certifdir = certifdir;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}



	/**
	 * Return the value associated with the column: systemtaskagentsleep
	 */
	public java.lang.Integer getSystemtaskagentsleep () {
		return systemtaskagentsleep;
	}

	/**
	 * Set the value related to the column: systemtaskagentsleep
	 * @param systemtaskagentsleep the systemtaskagentsleep value
	 */
	public void setSystemtaskagentsleep (java.lang.Integer systemtaskagentsleep) {
		this.systemtaskagentsleep = systemtaskagentsleep;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.system.SystemX)) return false;
		else {
			com.bureaueye.beacon.model.system.SystemX systemX = (com.bureaueye.beacon.model.system.SystemX) obj;
			if (null == this.getSystemId() || null == systemX.getSystemId()) return false;
			else return (this.getSystemId().equals(systemX.getSystemId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSystemId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSystemId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}