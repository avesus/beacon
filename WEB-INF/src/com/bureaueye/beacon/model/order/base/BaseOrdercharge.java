package com.bureaueye.beacon.model.order.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ordercharge table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ordercharge"
 */

public abstract class BaseOrdercharge  implements Serializable {

	public static String REF = "Ordercharge";
	public static String PROP_MAINCHARGE = "Maincharge";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_INVOICEGROUPREF = "Invoicegroupref";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_INVOICECCYKEY = "Invoiceccykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_UNITS = "Units";
	public static String PROP_INVOICESTATUS = "Invoicestatus";
	public static String PROP_UNAME = "Uname";
	public static String PROP_JOBMOV_ID = "JobmovId";
	public static String PROP_CHGAMT = "Chgamt";
	public static String PROP_XRATEINV = "Xrateinv";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_ORDERCHARGE_ID = "OrderchargeId";
	public static String PROP_RATE = "Rate";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CUSTTARFHDR_ID = "CusttarfhdrId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_XRATEBASE = "Xratebase";
	public static String PROP_CHARGEKEY = "Chargekey";
	public static String PROP_DMRGFLAG = "Dmrgflag";
	public static String PROP_INVOICENO = "Invoiceno";
	public static String PROP_TARIFFKEY = "Tariffkey";
	public static String PROP_SIHDR_ID = "SihdrId";
	public static String PROP_INVOICEPREF = "Invoicepref";
	public static String PROP_CHARGETYPE = "Chargetype";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_TXT1 = "Txt1";


	// constructors
	public BaseOrdercharge () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrdercharge (java.lang.Integer orderchargeId) {
		this.setOrderchargeId(orderchargeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer orderchargeId;

	// fields
	private java.lang.Integer sihdrId;
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.math.BigDecimal xrateinv;
	private boolean deleted;
	private java.lang.String invoicepref;
	private java.lang.String invoicestatus;
	private java.lang.String tariffkey;
	private java.lang.String departmentkey;
	private java.lang.String chargetype;
	private boolean xinactive;
	private java.lang.String uname;
	private java.lang.String custtarfhdrId;
	private boolean dmrgflag;
	private java.lang.String invoiceccykey;
	private java.lang.String companykey;
	private java.lang.String systemlogtime;
	private java.math.BigDecimal xratebase;
	private java.lang.String txt1;
	private boolean maincharge;
	private java.lang.String createuserid;
	private java.lang.Integer orderhdrId;
	private java.lang.String txt2;
	private java.util.Date createdate;
	private java.math.BigDecimal chgamt;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String invoicegroupref;
	private java.lang.String activitykey;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.lang.String taxcode;
	private java.lang.String orderno;
	private java.lang.String invoiceno;
	private java.lang.String xlock;
	private java.math.BigDecimal rate;
	private java.lang.String customeraddrkey;
	private java.lang.String chargekey;
	private java.lang.Integer jobmovId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERCHARGE_ID"
     */
	public java.lang.Integer getOrderchargeId () {
		return orderchargeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param orderchargeId the new ID
	 */
	public void setOrderchargeId (java.lang.Integer orderchargeId) {
		this.orderchargeId = orderchargeId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: XRATEINV
	 */
	public java.math.BigDecimal getXrateinv () {
		return xrateinv;
	}

	/**
	 * Set the value related to the column: XRATEINV
	 * @param xrateinv the XRATEINV value
	 */
	public void setXrateinv (java.math.BigDecimal xrateinv) {
		this.xrateinv = xrateinv;
	}



	/**
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: invoicepref
	 */
	public java.lang.String getInvoicepref () {
		return invoicepref;
	}

	/**
	 * Set the value related to the column: invoicepref
	 * @param invoicepref the invoicepref value
	 */
	public void setInvoicepref (java.lang.String invoicepref) {
		this.invoicepref = invoicepref;
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
	 * Return the value associated with the column: TARIFFKEY
	 */
	public java.lang.String getTariffkey () {
		return tariffkey;
	}

	/**
	 * Set the value related to the column: TARIFFKEY
	 * @param tariffkey the TARIFFKEY value
	 */
	public void setTariffkey (java.lang.String tariffkey) {
		this.tariffkey = tariffkey;
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
	 * Return the value associated with the column: UNAME
	 */
	public java.lang.String getUname () {
		return uname;
	}

	/**
	 * Set the value related to the column: UNAME
	 * @param uname the UNAME value
	 */
	public void setUname (java.lang.String uname) {
		this.uname = uname;
	}



	/**
	 * Return the value associated with the column: CUSTTARFHDR_ID
	 */
	public java.lang.String getCusttarfhdrId () {
		return custtarfhdrId;
	}

	/**
	 * Set the value related to the column: CUSTTARFHDR_ID
	 * @param custtarfhdrId the CUSTTARFHDR_ID value
	 */
	public void setCusttarfhdrId (java.lang.String custtarfhdrId) {
		this.custtarfhdrId = custtarfhdrId;
	}



	/**
	 * Return the value associated with the column: DMRGFLAG
	 */
	public boolean isDmrgflag () {
		return dmrgflag;
	}

	/**
	 * Set the value related to the column: DMRGFLAG
	 * @param dmrgflag the DMRGFLAG value
	 */
	public void setDmrgflag (boolean dmrgflag) {
		this.dmrgflag = dmrgflag;
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
	 * Return the value associated with the column: XRATEBASE
	 */
	public java.math.BigDecimal getXratebase () {
		return xratebase;
	}

	/**
	 * Set the value related to the column: XRATEBASE
	 * @param xratebase the XRATEBASE value
	 */
	public void setXratebase (java.math.BigDecimal xratebase) {
		this.xratebase = xratebase;
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
	 * Return the value associated with the column: MAINCHARGE
	 */
	public boolean isMaincharge () {
		return maincharge;
	}

	/**
	 * Set the value related to the column: MAINCHARGE
	 * @param maincharge the MAINCHARGE value
	 */
	public void setMaincharge (boolean maincharge) {
		this.maincharge = maincharge;
	}



	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
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
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: CHGAMT
	 */
	public java.math.BigDecimal getChgamt () {
		return chgamt;
	}

	/**
	 * Set the value related to the column: CHGAMT
	 * @param chgamt the CHGAMT value
	 */
	public void setChgamt (java.math.BigDecimal chgamt) {
		this.chgamt = chgamt;
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
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: INVOICEGROUPREF
	 */
	public java.lang.String getInvoicegroupref () {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: INVOICEGROUPREF
	 * @param invoicegroupref the INVOICEGROUPREF value
	 */
	public void setInvoicegroupref (java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
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
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
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
	 * Return the value associated with the column: TAXCODE
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: TAXCODE
	 * @param taxcode the TAXCODE value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
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
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.order.Ordercharge)) return false;
		else {
			com.bureaueye.beacon.model.order.Ordercharge ordercharge = (com.bureaueye.beacon.model.order.Ordercharge) obj;
			if (null == this.getOrderchargeId() || null == ordercharge.getOrderchargeId()) return false;
			else return (this.getOrderchargeId().equals(ordercharge.getOrderchargeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOrderchargeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOrderchargeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}