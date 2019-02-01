package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the systemlogconfig table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="systemlogconfig"
 */

public abstract class BaseSystemlogconfig  implements Serializable {

	public static String REF = "Systemlogconfig";
	public static String PROP_FLAG = "Flag";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_ACTION = "Action";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_RECORDOBJECTCLASS = "Recordobjectclass";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SYSTEMLOGCONFIG_ID = "SystemlogconfigId";


	// constructors
	public BaseSystemlogconfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemlogconfig (java.lang.Integer systemlogconfigId) {
		this.setSystemlogconfigId(systemlogconfigId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer systemlogconfigId;

	// fields
	private boolean xinactive;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String action;
	private java.lang.String createuserid;
	private boolean flag;
	private java.util.Date createdate;
	private java.lang.String recordobjectclass;
	private java.lang.String createtime;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SYSTEMLOGCONFIG_ID"
     */
	public java.lang.Integer getSystemlogconfigId () {
		return systemlogconfigId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemlogconfigId the new ID
	 */
	public void setSystemlogconfigId (java.lang.Integer systemlogconfigId) {
		this.systemlogconfigId = systemlogconfigId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (boolean xinactive) {
		this.xinactive = xinactive;
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
	 * Return the value associated with the column: action
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: action
	 * @param action the action value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
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
	 * Return the value associated with the column: flag
	 */
	public boolean isFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (boolean flag) {
		this.flag = flag;
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
	 * Return the value associated with the column: recordobjectclass
	 */
	public java.lang.String getRecordobjectclass () {
		return recordobjectclass;
	}

	/**
	 * Set the value related to the column: recordobjectclass
	 * @param recordobjectclass the recordobjectclass value
	 */
	public void setRecordobjectclass (java.lang.String recordobjectclass) {
		this.recordobjectclass = recordobjectclass;
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
		if (!(obj instanceof com.bureaueye.beacon.model.system.Systemlogconfig)) return false;
		else {
			com.bureaueye.beacon.model.system.Systemlogconfig systemlogconfig = (com.bureaueye.beacon.model.system.Systemlogconfig) obj;
			if (null == this.getSystemlogconfigId() || null == systemlogconfig.getSystemlogconfigId()) return false;
			else return (this.getSystemlogconfigId().equals(systemlogconfig.getSystemlogconfigId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSystemlogconfigId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSystemlogconfigId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}