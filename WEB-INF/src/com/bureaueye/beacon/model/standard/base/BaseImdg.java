package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the imdg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="imdg"
 */

public abstract class BaseImdg  implements Serializable {

	public static String REF = "Imdg";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_FLASHPOINTMANDATORY = "Flashpointmandatory";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_IMDGKEY = "Imdgkey";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_IMDGSC1 = "Imdgsc1";
	public static String PROP_IMDGSC2 = "Imdgsc2";


	// constructors
	public BaseImdg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseImdg (java.lang.String imdgkey) {
		this.setImdgkey(imdgkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String imdgkey;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String createuserid;
	private java.lang.String xinactive;
	private java.lang.String description;
	private boolean flashpointmandatory;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String imdgsc1;
	private java.lang.String imdgsc2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="imdgkey"
     */
	public java.lang.String getImdgkey () {
		return imdgkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param imdgkey the new ID
	 */
	public void setImdgkey (java.lang.String imdgkey) {
		this.imdgkey = imdgkey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
	}



	/**
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: flashpointmandatory
	 */
	public boolean isFlashpointmandatory () {
		return flashpointmandatory;
	}

	/**
	 * Set the value related to the column: flashpointmandatory
	 * @param flashpointmandatory the flashpointmandatory value
	 */
	public void setFlashpointmandatory (boolean flashpointmandatory) {
		this.flashpointmandatory = flashpointmandatory;
	}



	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
	}



	/**
	 * Return the value associated with the column: imdgsc1
	 */
	public java.lang.String getImdgsc1 () {
		return imdgsc1;
	}

	/**
	 * Set the value related to the column: imdgsc1
	 * @param imdgsc1 the imdgsc1 value
	 */
	public void setImdgsc1 (java.lang.String imdgsc1) {
		this.imdgsc1 = imdgsc1;
	}



	/**
	 * Return the value associated with the column: imdgsc2
	 */
	public java.lang.String getImdgsc2 () {
		return imdgsc2;
	}

	/**
	 * Set the value related to the column: imdgsc2
	 * @param imdgsc2 the imdgsc2 value
	 */
	public void setImdgsc2 (java.lang.String imdgsc2) {
		this.imdgsc2 = imdgsc2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Imdg)) return false;
		else {
			com.bureaueye.beacon.model.standard.Imdg imdg = (com.bureaueye.beacon.model.standard.Imdg) obj;
			if (null == this.getImdgkey() || null == imdg.getImdgkey()) return false;
			else return (this.getImdgkey().equals(imdg.getImdgkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getImdgkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getImdgkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}