package com.bureaueye.beacon.model.purchaseinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pidtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pidtl"
 */

public abstract class BasePidtl  implements Serializable {

	public static String REF = "Pidtl";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_APPROVEDFLAG = "Approvedflag";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_CSTAMT = "Cstamt";
	public static String PROP_DISPUTEMESSAGE = "Disputemessage";
	public static String PROP_INVOICESTATUS = "Invoicestatus";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_INVOICEAMT = "Invoiceamt";
	public static String PROP_PIHDR_ID = "PihdrId";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_JOBHDR_ID = "JobhdrId";
	public static String PROP_JOBNO = "Jobno";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_PIDTL_ID = "PidtlId";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_TXT1 = "Txt1";


	// constructors
	public BasePidtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePidtl (java.lang.Integer pidtlId) {
		this.setPidtlId(pidtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer pidtlId;

	// fields
	private java.util.Date systemlogdate;
	private java.lang.String invoicestatus;
	private java.util.Date createdate;
	private java.lang.String xlock;
	private java.lang.String systemlogaction;
	private java.lang.Integer pihdrId;
	private java.lang.Integer jobhdrId;
	private java.lang.String createtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.math.BigDecimal invoiceamt;
	private java.math.BigDecimal cstamt;
	private java.lang.Integer unitId;
	private boolean approvedflag;
	private java.lang.String disputemessage;
	private java.lang.String systemlogprogram;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private boolean deleteflag;
	private java.lang.String jobno;
	private java.lang.String unitkey;
	private java.lang.String costkey;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String orderno;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PIDTL_ID"
     */
	public java.lang.Integer getPidtlId () {
		return pidtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pidtlId the new ID
	 */
	public void setPidtlId (java.lang.Integer pidtlId) {
		this.pidtlId = pidtlId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: invoicestatus
	 */
	public java.lang.String getInvoicestatus () {
		return invoicestatus;
	}

	/**
	 * Set the value related to the column: invoicestatus
	 * @param invoicestatus the invoicestatus value
	 */
	public void setInvoicestatus (java.lang.String invoicestatus) {
		this.invoicestatus = invoicestatus;
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
	 * Return the value associated with the column: PIHDR_ID
	 */
	public java.lang.Integer getPihdrId () {
		return pihdrId;
	}

	/**
	 * Set the value related to the column: PIHDR_ID
	 * @param pihdrId the PIHDR_ID value
	 */
	public void setPihdrId (java.lang.Integer pihdrId) {
		this.pihdrId = pihdrId;
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
	 * Return the value associated with the column: invoiceamt
	 */
	public java.math.BigDecimal getInvoiceamt () {
		return invoiceamt;
	}

	/**
	 * Set the value related to the column: invoiceamt
	 * @param invoiceamt the invoiceamt value
	 */
	public void setInvoiceamt (java.math.BigDecimal invoiceamt) {
		this.invoiceamt = invoiceamt;
	}



	/**
	 * Return the value associated with the column: cstamt
	 */
	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}

	/**
	 * Set the value related to the column: cstamt
	 * @param cstamt the cstamt value
	 */
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
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
	 * Return the value associated with the column: approvedflag
	 */
	public boolean isApprovedflag () {
		return approvedflag;
	}

	/**
	 * Set the value related to the column: approvedflag
	 * @param approvedflag the approvedflag value
	 */
	public void setApprovedflag (boolean approvedflag) {
		this.approvedflag = approvedflag;
	}



	/**
	 * Return the value associated with the column: disputemessage
	 */
	public java.lang.String getDisputemessage () {
		return disputemessage;
	}

	/**
	 * Set the value related to the column: disputemessage
	 * @param disputemessage the disputemessage value
	 */
	public void setDisputemessage (java.lang.String disputemessage) {
		this.disputemessage = disputemessage;
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
	 * Return the value associated with the column: jobno
	 */
	public java.lang.String getJobno () {
		return jobno;
	}

	/**
	 * Set the value related to the column: jobno
	 * @param jobno the jobno value
	 */
	public void setJobno (java.lang.String jobno) {
		this.jobno = jobno;
	}



	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
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



	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * @param orderno the orderno value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseinvoice.Pidtl)) return false;
		else {
			com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl = (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) obj;
			if (null == this.getPidtlId() || null == pidtl.getPidtlId()) return false;
			else return (this.getPidtlId().equals(pidtl.getPidtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPidtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPidtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}