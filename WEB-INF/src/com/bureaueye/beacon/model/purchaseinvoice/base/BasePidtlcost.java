package com.bureaueye.beacon.model.purchaseinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pidtlcost table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pidtlcost"
 */

public abstract class BasePidtlcost  implements Serializable {

	public static String REF = "Pidtlcost";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_JOBHDR_ID = "JobhdrId";
	public static String PROP_PIDTLCOST_ID = "PidtlcostId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_PIDTL_ID = "PidtlId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_JOBCOST_ID = "JobcostId";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_CSTAMTALLOC = "Cstamtalloc";
	public static String PROP_JOBMOV_ID = "JobmovId";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_CSTAMTTOTAL = "Cstamttotal";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BasePidtlcost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePidtlcost (java.lang.Integer pidtlcostId) {
		this.setPidtlcostId(pidtlcostId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer pidtlcostId;

	// fields
	private java.util.Date createdate;
	private java.lang.String xlock;
	private java.lang.String systemlogaction;
	private java.lang.String createtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.Integer pidtlId;
	private java.lang.String systemlogprogram;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private boolean deleteflag;
	private java.math.BigDecimal cstamtalloc;
	private java.math.BigDecimal cstamttotal;
	private java.lang.String ccykey;
	private java.lang.String vendoraddrkey;
	private java.lang.String costkey;
	private java.lang.Integer jobhdrId;
	private java.lang.Integer jobmovId;
	private java.lang.Integer jobcostId;
	private java.lang.Integer unitId;
	private java.lang.String txt1;
	private java.lang.String txt2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PIDTLCOST_ID"
     */
	public java.lang.Integer getPidtlcostId () {
		return pidtlcostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pidtlcostId the new ID
	 */
	public void setPidtlcostId (java.lang.Integer pidtlcostId) {
		this.pidtlcostId = pidtlcostId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: PIDTL_ID
	 */
	public java.lang.Integer getPidtlId () {
		return pidtlId;
	}

	/**
	 * Set the value related to the column: PIDTL_ID
	 * @param pidtlId the PIDTL_ID value
	 */
	public void setPidtlId (java.lang.Integer pidtlId) {
		this.pidtlId = pidtlId;
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
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag () {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param deleteflag the deleteflag value
	 */
	public void setDeleteflag (boolean deleteflag) {
		this.deleteflag = deleteflag;
	}



	/**
	 * Return the value associated with the column: cstamtalloc
	 */
	public java.math.BigDecimal getCstamtalloc () {
		return cstamtalloc;
	}

	/**
	 * Set the value related to the column: cstamtalloc
	 * @param cstamtalloc the cstamtalloc value
	 */
	public void setCstamtalloc (java.math.BigDecimal cstamtalloc) {
		this.cstamtalloc = cstamtalloc;
	}



	/**
	 * Return the value associated with the column: cstamttotal
	 */
	public java.math.BigDecimal getCstamttotal () {
		return cstamttotal;
	}

	/**
	 * Set the value related to the column: cstamttotal
	 * @param cstamttotal the cstamttotal value
	 */
	public void setCstamttotal (java.math.BigDecimal cstamttotal) {
		this.cstamttotal = cstamttotal;
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
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}



	/**
	 * Return the value associated with the column: JOBHDR_ID
	 */
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 * Set the value related to the column: JOBHDR_ID
	 * @param jobhdrId the JOBHDR_ID value
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
	}



	/**
	 * Return the value associated with the column: JOBMOV_ID
	 */
	public java.lang.Integer getJobmovId () {
		return jobmovId;
	}

	/**
	 * Set the value related to the column: JOBMOV_ID
	 * @param jobmovId the JOBMOV_ID value
	 */
	public void setJobmovId (java.lang.Integer jobmovId) {
		this.jobmovId = jobmovId;
	}



	/**
	 * Return the value associated with the column: JOBCOST_ID
	 */
	public java.lang.Integer getJobcostId () {
		return jobcostId;
	}

	/**
	 * Set the value related to the column: JOBCOST_ID
	 * @param jobcostId the JOBCOST_ID value
	 */
	public void setJobcostId (java.lang.Integer jobcostId) {
		this.jobcostId = jobcostId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String txt1) {
		this.txt1 = txt1;
	}



	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost)) return false;
		else {
			com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost pidtlcost = (com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost) obj;
			if (null == this.getPidtlcostId() || null == pidtlcost.getPidtlcostId()) return false;
			else return (this.getPidtlcostId().equals(pidtlcost.getPidtlcostId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPidtlcostId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPidtlcostId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}