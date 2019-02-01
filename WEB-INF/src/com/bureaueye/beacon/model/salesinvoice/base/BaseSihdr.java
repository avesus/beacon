package com.bureaueye.beacon.model.salesinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sihdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sihdr"
 */

public abstract class BaseSihdr  implements Serializable {

	public static String REF = "Sihdr";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_INVOICEGROUPREF = "Invoicegroupref";
	public static String PROP_PRINTDATE = "Printdate";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_INVOICEREF = "Invoiceref";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_INVOICECCYKEY = "Invoiceccykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_MANUALFLAG = "Manualflag";
	public static String PROP_CUSTOMERREF = "Customerref";
	public static String PROP_RECHARGEFLAG = "Rechargeflag";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_POSTEDTIME = "Postedtime";
	public static String PROP_ADDDATA10 = "Adddata10";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_CONFIRMEDDATE = "Confirmeddate";
	public static String PROP_INVOICENO = "Invoiceno";
	public static String PROP_TAXAMT = "Taxamt";
	public static String PROP_ADDDATA9 = "Adddata9";
	public static String PROP_ADDDATA7 = "Adddata7";
	public static String PROP_ADDDATA8 = "Adddata8";
	public static String PROP_ADDDATA5 = "Adddata5";
	public static String PROP_ADDDATA6 = "Adddata6";
	public static String PROP_ADDDATA3 = "Adddata3";
	public static String PROP_ADDDATA4 = "Adddata4";
	public static String PROP_ADDDATA1 = "Adddata1";
	public static String PROP_POSTEDDATE = "Posteddate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_ADDDATA2 = "Adddata2";
	public static String PROP_CONFIRMEDFLAG = "Confirmedflag";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_PRINTTIME = "Printtime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_PRINTEDFLAG = "Printedflag";
	public static String PROP_AIOUT_ID = "AioutId";
	public static String PROP_MAINCHARGEFLAG = "Mainchargeflag";
	public static String PROP_INVOICEAMT = "Invoiceamt";
	public static String PROP_PAYMENTTERM = "Paymentterm";
	public static String PROP_POSTEDFLAG = "Postedflag";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_PERIODPOSTED = "Periodposted";
	public static String PROP_BATCH_ID = "BatchId";
	public static String PROP_RECTYPE = "Rectype";
	public static String PROP_SIHDR_ID = "SihdrId";
	public static String PROP_LANGUAGEKEY = "Languagekey";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_REASONKEY = "Reasonkey";


	// constructors
	public BaseSihdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSihdr (java.lang.Integer sihdrId) {
		this.setSihdrId(sihdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer sihdrId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String reasonkey;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private boolean mainchargeflag;
	private java.lang.String departmentkey;
	private boolean manualflag;
	private boolean xinactive;
	private java.lang.Integer batchId;
	private java.lang.String languagekey;
	private java.lang.String companykey;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String invoiceno;
	private boolean confirmedflag;
	private java.lang.String unitkey;
	private java.util.Date posteddate;
	private java.lang.String postedtime;
	private java.util.Date confirmeddate;
	private java.lang.String invoicegroupref;
	private java.lang.String invoiceref;
	private java.lang.String createuserid;
	private boolean printedflag;
	private boolean deleteflag;
	private java.lang.String txt1;
	private java.lang.String paymentterm;
	private java.util.Date printdate;
	private java.math.BigDecimal invoiceamt;
	private java.lang.String txt2;
	private java.lang.String customerref;
	private java.lang.String taxcode;
	private java.lang.String printtime;
	private boolean postedflag;
	private java.lang.String activitykey;
	private java.lang.String invoiceccykey;
	private java.lang.String periodposted;
	private java.lang.String createtime;
	private boolean rechargeflag;
	private java.lang.String rectype;
	private java.lang.String orderno;
	private java.lang.String xlock;
	private java.math.BigDecimal taxamt;
	private java.lang.String customeraddrkey;
	private java.lang.Integer aioutId;
	private java.lang.String adddata1;
	private java.lang.String adddata2;
	private java.lang.String adddata3;
	private java.lang.String adddata4;
	private java.lang.String adddata5;
	private java.lang.String adddata6;
	private java.lang.String adddata7;
	private java.lang.String adddata8;
	private java.lang.String adddata9;
	private java.lang.String adddata10;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SIHDR_ID"
     */
	public java.lang.Integer getSihdrId () {
		return sihdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sihdrId the new ID
	 */
	public void setSihdrId (java.lang.Integer sihdrId) {
		this.sihdrId = sihdrId;
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
	 * Return the value associated with the column: reasonkey
	 */
	public java.lang.String getReasonkey () {
		return reasonkey;
	}

	/**
	 * Set the value related to the column: reasonkey
	 * @param reasonkey the reasonkey value
	 */
	public void setReasonkey (java.lang.String reasonkey) {
		this.reasonkey = reasonkey;
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
	 * Return the value associated with the column: mainchargeflag
	 */
	public boolean isMainchargeflag () {
		return mainchargeflag;
	}

	/**
	 * Set the value related to the column: mainchargeflag
	 * @param mainchargeflag the mainchargeflag value
	 */
	public void setMainchargeflag (boolean mainchargeflag) {
		this.mainchargeflag = mainchargeflag;
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
	 * Return the value associated with the column: manualflag
	 */
	public boolean isManualflag () {
		return manualflag;
	}

	/**
	 * Set the value related to the column: manualflag
	 * @param manualflag the manualflag value
	 */
	public void setManualflag (boolean manualflag) {
		this.manualflag = manualflag;
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
	 * Return the value associated with the column: BATCH_ID
	 */
	public java.lang.Integer getBatchId () {
		return batchId;
	}

	/**
	 * Set the value related to the column: BATCH_ID
	 * @param batchId the BATCH_ID value
	 */
	public void setBatchId (java.lang.Integer batchId) {
		this.batchId = batchId;
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
	 * Return the value associated with the column: invoiceno
	 */
	public java.lang.String getInvoiceno () {
		return invoiceno;
	}

	/**
	 * Set the value related to the column: invoiceno
	 * @param invoiceno the invoiceno value
	 */
	public void setInvoiceno (java.lang.String invoiceno) {
		this.invoiceno = invoiceno;
	}



	/**
	 * Return the value associated with the column: confirmedflag
	 */
	public boolean isConfirmedflag () {
		return confirmedflag;
	}

	/**
	 * Set the value related to the column: confirmedflag
	 * @param confirmedflag the confirmedflag value
	 */
	public void setConfirmedflag (boolean confirmedflag) {
		this.confirmedflag = confirmedflag;
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
	 * Return the value associated with the column: confirmeddate
	 */
	public java.util.Date getConfirmeddate () {
		return confirmeddate;
	}

	/**
	 * Set the value related to the column: confirmeddate
	 * @param confirmeddate the confirmeddate value
	 */
	public void setConfirmeddate (java.util.Date confirmeddate) {
		this.confirmeddate = confirmeddate;
	}



	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref () {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * @param invoicegroupref the invoicegroupref value
	 */
	public void setInvoicegroupref (java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
	}



	/**
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref () {
		return invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * @param invoiceref the invoiceref value
	 */
	public void setInvoiceref (java.lang.String invoiceref) {
		this.invoiceref = invoiceref;
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
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag () {
		return printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * @param printedflag the printedflag value
	 */
	public void setPrintedflag (boolean printedflag) {
		this.printedflag = printedflag;
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
	 * Return the value associated with the column: paymentterm
	 */
	public java.lang.String getPaymentterm () {
		return paymentterm;
	}

	/**
	 * Set the value related to the column: paymentterm
	 * @param paymentterm the paymentterm value
	 */
	public void setPaymentterm (java.lang.String paymentterm) {
		this.paymentterm = paymentterm;
	}



	/**
	 * Return the value associated with the column: printdate
	 */
	public java.util.Date getPrintdate () {
		return printdate;
	}

	/**
	 * Set the value related to the column: printdate
	 * @param printdate the printdate value
	 */
	public void setPrintdate (java.util.Date printdate) {
		this.printdate = printdate;
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
	 * Return the value associated with the column: customerref
	 */
	public java.lang.String getCustomerref () {
		return customerref;
	}

	/**
	 * Set the value related to the column: customerref
	 * @param customerref the customerref value
	 */
	public void setCustomerref (java.lang.String customerref) {
		this.customerref = customerref;
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
	 * Return the value associated with the column: printtime
	 */
	public java.lang.String getPrinttime () {
		return printtime;
	}

	/**
	 * Set the value related to the column: printtime
	 * @param printtime the printtime value
	 */
	public void setPrinttime (java.lang.String printtime) {
		this.printtime = printtime;
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
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey () {
		return invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * @param invoiceccykey the invoiceccykey value
	 */
	public void setInvoiceccykey (java.lang.String invoiceccykey) {
		this.invoiceccykey = invoiceccykey;
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
	 * Return the value associated with the column: rechargeflag
	 */
	public boolean isRechargeflag () {
		return rechargeflag;
	}

	/**
	 * Set the value related to the column: rechargeflag
	 * @param rechargeflag the rechargeflag value
	 */
	public void setRechargeflag (boolean rechargeflag) {
		this.rechargeflag = rechargeflag;
	}



	/**
	 * Return the value associated with the column: rectype
	 */
	public java.lang.String getRectype () {
		return rectype;
	}

	/**
	 * Set the value related to the column: rectype
	 * @param rectype the rectype value
	 */
	public void setRectype (java.lang.String rectype) {
		this.rectype = rectype;
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
	 * Return the value associated with the column: adddata1
	 */
	public java.lang.String getAdddata1 () {
		return adddata1;
	}

	/**
	 * Set the value related to the column: adddata1
	 * @param adddata1 the adddata1 value
	 */
	public void setAdddata1 (java.lang.String adddata1) {
		this.adddata1 = adddata1;
	}



	/**
	 * Return the value associated with the column: adddata2
	 */
	public java.lang.String getAdddata2 () {
		return adddata2;
	}

	/**
	 * Set the value related to the column: adddata2
	 * @param adddata2 the adddata2 value
	 */
	public void setAdddata2 (java.lang.String adddata2) {
		this.adddata2 = adddata2;
	}



	/**
	 * Return the value associated with the column: adddata3
	 */
	public java.lang.String getAdddata3 () {
		return adddata3;
	}

	/**
	 * Set the value related to the column: adddata3
	 * @param adddata3 the adddata3 value
	 */
	public void setAdddata3 (java.lang.String adddata3) {
		this.adddata3 = adddata3;
	}



	/**
	 * Return the value associated with the column: adddata4
	 */
	public java.lang.String getAdddata4 () {
		return adddata4;
	}

	/**
	 * Set the value related to the column: adddata4
	 * @param adddata4 the adddata4 value
	 */
	public void setAdddata4 (java.lang.String adddata4) {
		this.adddata4 = adddata4;
	}



	/**
	 * Return the value associated with the column: adddata5
	 */
	public java.lang.String getAdddata5 () {
		return adddata5;
	}

	/**
	 * Set the value related to the column: adddata5
	 * @param adddata5 the adddata5 value
	 */
	public void setAdddata5 (java.lang.String adddata5) {
		this.adddata5 = adddata5;
	}



	/**
	 * Return the value associated with the column: adddata6
	 */
	public java.lang.String getAdddata6 () {
		return adddata6;
	}

	/**
	 * Set the value related to the column: adddata6
	 * @param adddata6 the adddata6 value
	 */
	public void setAdddata6 (java.lang.String adddata6) {
		this.adddata6 = adddata6;
	}



	/**
	 * Return the value associated with the column: adddata7
	 */
	public java.lang.String getAdddata7 () {
		return adddata7;
	}

	/**
	 * Set the value related to the column: adddata7
	 * @param adddata7 the adddata7 value
	 */
	public void setAdddata7 (java.lang.String adddata7) {
		this.adddata7 = adddata7;
	}



	/**
	 * Return the value associated with the column: adddata8
	 */
	public java.lang.String getAdddata8 () {
		return adddata8;
	}

	/**
	 * Set the value related to the column: adddata8
	 * @param adddata8 the adddata8 value
	 */
	public void setAdddata8 (java.lang.String adddata8) {
		this.adddata8 = adddata8;
	}



	/**
	 * Return the value associated with the column: adddata9
	 */
	public java.lang.String getAdddata9 () {
		return adddata9;
	}

	/**
	 * Set the value related to the column: adddata9
	 * @param adddata9 the adddata9 value
	 */
	public void setAdddata9 (java.lang.String adddata9) {
		this.adddata9 = adddata9;
	}



	/**
	 * Return the value associated with the column: adddata10
	 */
	public java.lang.String getAdddata10 () {
		return adddata10;
	}

	/**
	 * Set the value related to the column: adddata10
	 * @param adddata10 the adddata10 value
	 */
	public void setAdddata10 (java.lang.String adddata10) {
		this.adddata10 = adddata10;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.salesinvoice.Sihdr)) return false;
		else {
			com.bureaueye.beacon.model.salesinvoice.Sihdr sihdr = (com.bureaueye.beacon.model.salesinvoice.Sihdr) obj;
			if (null == this.getSihdrId() || null == sihdr.getSihdrId()) return false;
			else return (this.getSihdrId().equals(sihdr.getSihdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSihdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSihdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}