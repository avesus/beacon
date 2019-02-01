package com.bureaueye.beacon.model.salesinvoice.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sidtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sidtl"
 */

public abstract class BaseSidtl  implements Serializable {

	public static String REF = "Sidtl";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_INVOICEGROUPREF = "Invoicegroupref";
	public static String PROP_PRINTDATE = "Printdate";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_INVOICEREF = "Invoiceref";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_INVOICECCYKEY = "Invoiceccykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CHGAMT = "Chgamt";
	public static String PROP_DEMURRAGEDAYS = "Demurragedays";
	public static String PROP_XRATEINV = "Xrateinv";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_POSTEDTIME = "Postedtime";
	public static String PROP_ORDERCHARGE_ID = "OrderchargeId";
	public static String PROP_ADDDATA10 = "Adddata10";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_CHARGEKEY = "Chargekey";
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
	public static String PROP_SAPBOOKDATE = "Sapbookdate";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_PRINTTIME = "Printtime";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_UNITS = "Units";
	public static String PROP_PRINTEDFLAG = "Printedflag";
	public static String PROP_UNAME = "Uname";
	public static String PROP_AIOUT_ID = "AioutId";
	public static String PROP_MAINCHARGEFLAG = "Mainchargeflag";
	public static String PROP_RATE = "Rate";
	public static String PROP_INVOICEAMT = "Invoiceamt";
	public static String PROP_SIDTL_ID = "SidtlId";
	public static String PROP_POSTEDFLAG = "Postedflag";
	public static String PROP_XRATEBASE = "Xratebase";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SIHDR_ID = "SihdrId";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_SAPBOOKPERIOD = "Sapbookperiod";
	public static String PROP_CHARGETYPE = "Chargetype";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseSidtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSidtl (java.lang.Integer sidtlId) {
		this.setSidtlId(sidtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer sidtlId;

	// fields
	private java.lang.String systemlogprogram;
	private java.math.BigDecimal chgamt;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private boolean mainchargeflag;
	private java.math.BigDecimal units;
	private java.util.Date sapbookdate;
	private java.lang.Integer sihdrId;
	private boolean xinactive;
	private java.lang.String chargetype;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.Integer demurragedays;
	private java.lang.String unitkey;
	private java.math.BigDecimal rate;
	private java.lang.String invoicegroupref;
	private java.math.BigDecimal xrateinv;
	private java.lang.String invoiceref;
	private java.lang.String createuserid;
	private boolean printedflag;
	private java.lang.String sapbookperiod;
	private boolean deleteflag;
	private java.lang.String txt1;
	private java.math.BigDecimal xratebase;
	private java.util.Date printdate;
	private java.lang.String uname;
	private java.lang.String txt2;
	private java.lang.String printtime;
	private java.lang.String ccykey;
	private java.lang.String createtime;
	private java.lang.String orderno;
	private java.lang.String xlock;
	private java.lang.String invoiceccykey;
	private java.lang.String taxcode;
	private java.math.BigDecimal invoiceamt;
	private java.math.BigDecimal taxamt;
	private java.lang.Integer orderhdrId;
	private java.lang.Integer orderchargeId;
	private java.lang.String chargekey;
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
	private java.lang.Integer aioutId;
	private boolean postedflag;
	private java.util.Date posteddate;
	private java.lang.String postedtime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SIDTL_ID"
     */
	public java.lang.Integer getSidtlId () {
		return sidtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sidtlId the new ID
	 */
	public void setSidtlId (java.lang.Integer sidtlId) {
		this.sidtlId = sidtlId;
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
	 * Return the value associated with the column: chgamt
	 */
	public java.math.BigDecimal getChgamt () {
		return chgamt;
	}

	/**
	 * Set the value related to the column: chgamt
	 * @param chgamt the chgamt value
	 */
	public void setChgamt (java.math.BigDecimal chgamt) {
		this.chgamt = chgamt;
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
	 * Return the value associated with the column: units
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: units
	 * @param units the units value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
	}



	/**
	 * Return the value associated with the column: sapbookdate
	 */
	public java.util.Date getSapbookdate () {
		return sapbookdate;
	}

	/**
	 * Set the value related to the column: sapbookdate
	 * @param sapbookdate the sapbookdate value
	 */
	public void setSapbookdate (java.util.Date sapbookdate) {
		this.sapbookdate = sapbookdate;
	}



	/**
	 * Return the value associated with the column: SIHDR_ID
	 */
	public java.lang.Integer getSihdrId () {
		return sihdrId;
	}

	/**
	 * Set the value related to the column: SIHDR_ID
	 * @param sihdrId the SIHDR_ID value
	 */
	public void setSihdrId (java.lang.Integer sihdrId) {
		this.sihdrId = sihdrId;
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
	 * Return the value associated with the column: chargetype
	 */
	public java.lang.String getChargetype () {
		return chargetype;
	}

	/**
	 * Set the value related to the column: chargetype
	 * @param chargetype the chargetype value
	 */
	public void setChargetype (java.lang.String chargetype) {
		this.chargetype = chargetype;
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
	 * Return the value associated with the column: demurragedays
	 */
	public java.lang.Integer getDemurragedays () {
		return demurragedays;
	}

	/**
	 * Set the value related to the column: demurragedays
	 * @param demurragedays the demurragedays value
	 */
	public void setDemurragedays (java.lang.Integer demurragedays) {
		this.demurragedays = demurragedays;
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
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: xrateinv
	 */
	public java.math.BigDecimal getXrateinv () {
		return xrateinv;
	}

	/**
	 * Set the value related to the column: xrateinv
	 * @param xrateinv the xrateinv value
	 */
	public void setXrateinv (java.math.BigDecimal xrateinv) {
		this.xrateinv = xrateinv;
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
	 * Return the value associated with the column: sapbookperiod
	 */
	public java.lang.String getSapbookperiod () {
		return sapbookperiod;
	}

	/**
	 * Set the value related to the column: sapbookperiod
	 * @param sapbookperiod the sapbookperiod value
	 */
	public void setSapbookperiod (java.lang.String sapbookperiod) {
		this.sapbookperiod = sapbookperiod;
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
	 * Return the value associated with the column: xratebase
	 */
	public java.math.BigDecimal getXratebase () {
		return xratebase;
	}

	/**
	 * Set the value related to the column: xratebase
	 * @param xratebase the xratebase value
	 */
	public void setXratebase (java.math.BigDecimal xratebase) {
		this.xratebase = xratebase;
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
	 * Return the value associated with the column: uname
	 */
	public java.lang.String getUname () {
		return uname;
	}

	/**
	 * Set the value related to the column: uname
	 * @param uname the uname value
	 */
	public void setUname (java.lang.String uname) {
		this.uname = uname;
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
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}



	/**
	 * Return the value associated with the column: ORDERCHARGE_ID
	 */
	public java.lang.Integer getOrderchargeId () {
		return orderchargeId;
	}

	/**
	 * Set the value related to the column: ORDERCHARGE_ID
	 * @param orderchargeId the ORDERCHARGE_ID value
	 */
	public void setOrderchargeId (java.lang.Integer orderchargeId) {
		this.orderchargeId = orderchargeId;
	}



	/**
	 * Return the value associated with the column: chargekey
	 */
	public java.lang.String getChargekey () {
		return chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param chargekey the chargekey value
	 */
	public void setChargekey (java.lang.String chargekey) {
		this.chargekey = chargekey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.salesinvoice.Sidtl)) return false;
		else {
			com.bureaueye.beacon.model.salesinvoice.Sidtl sidtl = (com.bureaueye.beacon.model.salesinvoice.Sidtl) obj;
			if (null == this.getSidtlId() || null == sidtl.getSidtlId()) return false;
			else return (this.getSidtlId().equals(sidtl.getSidtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSidtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSidtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}