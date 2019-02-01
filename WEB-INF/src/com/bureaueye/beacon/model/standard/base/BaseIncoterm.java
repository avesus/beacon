package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the incoterm table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="incoterm"
 */

public abstract class BaseIncoterm  implements Serializable {

	public static String REF = "Incoterm";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_INCOTERMKEY = "Incotermkey";
	public static String PROP_TXT = "Txt";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseIncoterm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIncoterm (java.lang.String incotermkey) {
		this.setIncotermkey(incotermkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String incotermkey;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String createuserid;
	private java.lang.String xinactive;
	private java.lang.String description;
	private java.lang.String txt;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="incotermkey"
     */
	public java.lang.String getIncotermkey () {
		return incotermkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param incotermkey the new ID
	 */
	public void setIncotermkey (java.lang.String incotermkey) {
		this.incotermkey = incotermkey;
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
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Incoterm)) return false;
		else {
			com.bureaueye.beacon.model.standard.Incoterm incoterm = (com.bureaueye.beacon.model.standard.Incoterm) obj;
			if (null == this.getIncotermkey() || null == incoterm.getIncotermkey()) return false;
			else return (this.getIncotermkey().equals(incoterm.getIncotermkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIncotermkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIncotermkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}