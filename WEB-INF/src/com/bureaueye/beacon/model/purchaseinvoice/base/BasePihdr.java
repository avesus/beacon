package com.bureaueye.beacon.model.purchaseinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pihdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pihdr"
 */

public abstract class BasePihdr  implements Serializable {

	public static String REF = "Pihdr";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_FINANCIALYEAR = "Financialyear";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_INVOICEDATE = "Invoicedate";
	public static String PROP_APPROVEDFLAG = "Approvedflag";
	public static String PROP_TAXRATE = "Taxrate";
	public static String PROP_VENDORREF = "Vendorref";
	public static String PROP_PINO = "Pino";
	public static String PROP_INVOICESTATUS = "Invoicestatus";
	public static String PROP_BATCHNO = "Batchno";
	public static String PROP_AIOUT_ID = "AioutId";
	public static String PROP_MISCFLAG = "Miscflag";
	public static String PROP_GROSSAMT = "Grossamt";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_POSTEDTIME = "Postedtime";
	public static String PROP_PIHDR_ID = "PihdrId";
	public static String PROP_FINANCIALMONTH = "Financialmonth";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_JOBNO = "Jobno";
	public static String PROP_POSTEDFLAG = "Postedflag";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_PERIODPOSTED = "Periodposted";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_NETAMT = "Netamt";
	public static String PROP_TAXAMT = "Taxamt";
	public static String PROP_LANGUAGEKEY = "Languagekey";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_POSTEDDATE = "Posteddate";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_TXT1 = "Txt1";


	// constructors
	public BasePihdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePihdr (java.lang.Integer pihdrId) {
		this.setPihdrId(pihdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer pihdrId;

	// fields
	private java.lang.String pino;
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String periodposted;
	private java.lang.String activitykey;
	private java.lang.String ccykey;
	private java.util.Date createdate;
	private java.util.Date invoicedate;
	private java.lang.String xlock;
	private java.lang.String systemlogaction;
	private java.util.Date posteddate;
	private java.lang.String postedtime;
	private java.lang.String createtime;
	private java.math.BigDecimal taxrate;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.String languagekey;
	private java.lang.String jobno;
	private java.lang.String batchno;
	private java.lang.String orderno;
	private boolean postedflag;
	private java.lang.String companykey;
	private boolean approvedflag;
	private java.lang.String txt1;
	private java.lang.String systemlogprogram;
	private java.lang.String txt2;
	private java.math.BigDecimal taxamt;
	private java.math.BigDecimal grossamt;
	private java.math.BigDecimal netamt;
	private java.lang.String financialyear;
	private java.lang.String financialmonth;
	private java.lang.String createuserid;
	private java.lang.String invoicestatus;
	private java.lang.String systemloguserid;
	private java.lang.String vendorref;
	private boolean deleteflag;
	private java.lang.String taxcode;
	private java.lang.String vendoraddrkey;
	private java.lang.Integer aioutId;
	private boolean miscflag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PIHDR_ID"
     */
	public java.lang.Integer getPihdrId () {
		return pihdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pihdrId the new ID
	 */
	public void setPihdrId (java.lang.Integer pihdrId) {
		this.pihdrId = pihdrId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: pino
	 */
	public java.lang.String getPino () {
		return pino;
	}

	/**
	 * Set the value related to the column: pino
	 * @param pino the pino value
	 */
	public void setPino (java.lang.String pino) {
		this.pino = pino;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
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
	 * Return the value associated with the column: periodposted
	 */
	public java.lang.String getPeriodposted () {
		return periodposted;
	}

	/**
	 * Set the value related to the column: periodposted
	 * @param periodposted the periodposted value
	 */
	public void setPeriodposted (java.lang.String periodposted) {
		this.periodposted = periodposted;
	}



	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
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
	 * Return the value associated with the column: invoicedate
	 */
	public java.util.Date getInvoicedate () {
		return invoicedate;
	}

	/**
	 * Set the value related to the column: invoicedate
	 * @param invoicedate the invoicedate value
	 */
	public void setInvoicedate (java.util.Date invoicedate) {
		this.invoicedate = invoicedate;
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
	 * Return the value associated with the column: posteddate
	 */
	public java.util.Date getPosteddate () {
		return posteddate;
	}

	/**
	 * Set the value related to the column: posteddate
	 * @param posteddate the posteddate value
	 */
	public void setPosteddate (java.util.Date posteddate) {
		this.posteddate = posteddate;
	}



	/**
	 * Return the value associated with the column: postedtime
	 */
	public java.lang.String getPostedtime () {
		return postedtime;
	}

	/**
	 * Set the value related to the column: postedtime
	 * @param postedtime the postedtime value
	 */
	public void setPostedtime (java.lang.String postedtime) {
		this.postedtime = postedtime;
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
	 * Return the value associated with the column: taxrate
	 */
	public java.math.BigDecimal getTaxrate () {
		return taxrate;
	}

	/**
	 * Set the value related to the column: taxrate
	 * @param taxrate the taxrate value
	 */
	public void setTaxrate (java.math.BigDecimal taxrate) {
		this.taxrate = taxrate;
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
	 * Return the value associated with the column: languagekey
	 */
	public java.lang.String getLanguagekey () {
		return languagekey;
	}

	/**
	 * Set the value related to the column: languagekey
	 * @param languagekey the languagekey value
	 */
	public void setLanguagekey (java.lang.String languagekey) {
		this.languagekey = languagekey;
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
	 * Return the value associated with the column: batchno
	 */
	public java.lang.String getBatchno () {
		return batchno;
	}

	/**
	 * Set the value related to the column: batchno
	 * @param batchno the batchno value
	 */
	public void setBatchno (java.lang.String batchno) {
		this.batchno = batchno;
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



	/**
	 * Return the value associated with the column: postedflag
	 */
	public boolean isPostedflag () {
		return postedflag;
	}

	/**
	 * Set the value related to the column: postedflag
	 * @param postedflag the postedflag value
	 */
	public void setPostedflag (boolean postedflag) {
		this.postedflag = postedflag;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
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
	 * Return the value associated with the column: taxamt
	 */
	public java.math.BigDecimal getTaxamt () {
		return taxamt;
	}

	/**
	 * Set the value related to the column: taxamt
	 * @param taxamt the taxamt value
	 */
	public void setTaxamt (java.math.BigDecimal taxamt) {
		this.taxamt = taxamt;
	}



	/**
	 * Return the value associated with the column: grossamt
	 */
	public java.math.BigDecimal getGrossamt () {
		return grossamt;
	}

	/**
	 * Set the value related to the column: grossamt
	 * @param grossamt the grossamt value
	 */
	public void setGrossamt (java.math.BigDecimal grossamt) {
		this.grossamt = grossamt;
	}



	/**
	 * Return the value associated with the column: netamt
	 */
	public java.math.BigDecimal getNetamt () {
		return netamt;
	}

	/**
	 * Set the value related to the column: netamt
	 * @param netamt the netamt value
	 */
	public void setNetamt (java.math.BigDecimal netamt) {
		this.netamt = netamt;
	}



	/**
	 * Return the value associated with the column: financialyear
	 */
	public java.lang.String getFinancialyear () {
		return financialyear;
	}

	/**
	 * Set the value related to the column: financialyear
	 * @param financialyear the financialyear value
	 */
	public void setFinancialyear (java.lang.String financialyear) {
		this.financialyear = financialyear;
	}



	/**
	 * Return the value associated with the column: financialmonth
	 */
	public java.lang.String getFinancialmonth () {
		return financialmonth;
	}

	/**
	 * Set the value related to the column: financialmonth
	 * @param financialmonth the financialmonth value
	 */
	public void setFinancialmonth (java.lang.String financialmonth) {
		this.financialmonth = financialmonth;
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
	 * Return the value associated with the column: vendorref
	 */
	public java.lang.String getVendorref () {
		return vendorref;
	}

	/**
	 * Set the value related to the column: vendorref
	 * @param vendorref the vendorref value
	 */
	public void setVendorref (java.lang.String vendorref) {
		this.vendorref = vendorref;
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
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * @param taxcode the taxcode value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
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
	 * Return the value associated with the column: AIOUT_ID
	 */
	public java.lang.Integer getAioutId () {
		return aioutId;
	}

	/**
	 * Set the value related to the column: AIOUT_ID
	 * @param aioutId the AIOUT_ID value
	 */
	public void setAioutId (java.lang.Integer aioutId) {
		this.aioutId = aioutId;
	}



	/**
	 * Return the value associated with the column: miscflag
	 */
	public boolean isMiscflag () {
		return miscflag;
	}

	/**
	 * Set the value related to the column: miscflag
	 * @param miscflag the miscflag value
	 */
	public void setMiscflag (boolean miscflag) {
		this.miscflag = miscflag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseinvoice.Pihdr)) return false;
		else {
			com.bureaueye.beacon.model.purchaseinvoice.Pihdr pihdr = (com.bureaueye.beacon.model.purchaseinvoice.Pihdr) obj;
			if (null == this.getPihdrId() || null == pihdr.getPihdrId()) return false;
			else return (this.getPihdrId().equals(pihdr.getPihdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPihdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPihdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}