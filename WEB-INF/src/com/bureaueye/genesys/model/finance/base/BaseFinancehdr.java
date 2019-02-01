package com.bureaueye.genesys.model.finance.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the financehdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="financehdr"
 */

public abstract class BaseFinancehdr  implements Serializable {

	public static String REF = "Financehdr";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_PRINTDATE = "Printdate";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_INVOICEREF = "Invoiceref";
	public static String PROP_PRINTTIME = "Printtime";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_FINANCEHDR_ID = "FinancehdrId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CONTRACTNO = "Contractno";
	public static String PROP_MANUALFLAG = "Manualflag";
	public static String PROP_VATAMOUNT = "Vatamount";
	public static String PROP_DOCTYPEKEY = "Doctypekey";
	public static String PROP_PRINTEDFLAG = "Printedflag";
	public static String PROP_PYODONEFLAG = "Pyodoneflag";
	public static String PROP_NETAMOUNT = "Netamount";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_POSTDATE = "Postdate";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_LEASETYPEKEY = "Leasetypekey";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_GROSSAMOUNT = "Grossamount";
	public static String PROP_PAYOUTAMOUNT = "Payoutamount";
	public static String PROP_DOCDATE = "Docdate";
	public static String PROP_BILLDATE = "Billdate";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CASHALLOCTOTAL = "Cashalloctotal";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_CASHALLOCPAYOUT = "Cashallocpayout";


	// constructors
	public BaseFinancehdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFinancehdr (java.lang.Integer financehdrId) {
		this.setFinancehdrId(financehdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer financehdrId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String contractno;
	private java.lang.String activitykey;
	private java.math.BigDecimal netamount;
	private java.lang.String ccykey;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.String doctypekey;
	private java.lang.String systemlogaction;
	private java.lang.String createtime;
	private java.util.Date billdate;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private boolean manualflag;
	private java.math.BigDecimal cashalloctotal;
	private java.lang.String leasetypekey;
	private java.lang.Integer contractId;
	private java.util.Date postdate;
	private java.util.Date docdate;
	private java.util.Date printdate;
	private java.math.BigDecimal grossamount;
	private java.lang.String companykey;
	private java.lang.String systemlogprogram;
	private java.math.BigDecimal cashallocpayout;
	private java.lang.String dockey;
	private java.math.BigDecimal vatamount;
	private boolean pyodoneflag;
	private boolean printedflag;
	private java.math.BigDecimal payoutamount;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.String lesseeaddrkey;
	private java.lang.String invoiceref;
	private java.lang.String taxcode;
	private java.lang.String printtime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FINANCEHDR_ID"
     */
	public java.lang.Integer getFinancehdrId () {
		return financehdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param financehdrId the new ID
	 */
	public void setFinancehdrId (java.lang.Integer financehdrId) {
		this.financehdrId = financehdrId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: contractno
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: contractno
	 * @param contractno the contractno value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
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
	 * Return the value associated with the column: netamount
	 */
	public java.math.BigDecimal getNetamount () {
		return netamount;
	}

	/**
	 * Set the value related to the column: netamount
	 * @param netamount the netamount value
	 */
	public void setNetamount (java.math.BigDecimal netamount) {
		this.netamount = netamount;
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
	 * Return the value associated with the column: doctypekey
	 */
	public java.lang.String getDoctypekey () {
		return doctypekey;
	}

	/**
	 * Set the value related to the column: doctypekey
	 * @param doctypekey the doctypekey value
	 */
	public void setDoctypekey (java.lang.String doctypekey) {
		this.doctypekey = doctypekey;
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
	 * Return the value associated with the column: billdate
	 */
	public java.util.Date getBilldate () {
		return billdate;
	}

	/**
	 * Set the value related to the column: billdate
	 * @param billdate the billdate value
	 */
	public void setBilldate (java.util.Date billdate) {
		this.billdate = billdate;
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
	 * Return the value associated with the column: cashalloctotal
	 */
	public java.math.BigDecimal getCashalloctotal () {
		return cashalloctotal;
	}

	/**
	 * Set the value related to the column: cashalloctotal
	 * @param cashalloctotal the cashalloctotal value
	 */
	public void setCashalloctotal (java.math.BigDecimal cashalloctotal) {
		this.cashalloctotal = cashalloctotal;
	}



	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
	}



	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}



	/**
	 * Return the value associated with the column: postdate
	 */
	public java.util.Date getPostdate () {
		return postdate;
	}

	/**
	 * Set the value related to the column: postdate
	 * @param postdate the postdate value
	 */
	public void setPostdate (java.util.Date postdate) {
		this.postdate = postdate;
	}



	/**
	 * Return the value associated with the column: docdate
	 */
	public java.util.Date getDocdate () {
		return docdate;
	}

	/**
	 * Set the value related to the column: docdate
	 * @param docdate the docdate value
	 */
	public void setDocdate (java.util.Date docdate) {
		this.docdate = docdate;
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
	 * Return the value associated with the column: grossamount
	 */
	public java.math.BigDecimal getGrossamount () {
		return grossamount;
	}

	/**
	 * Set the value related to the column: grossamount
	 * @param grossamount the grossamount value
	 */
	public void setGrossamount (java.math.BigDecimal grossamount) {
		this.grossamount = grossamount;
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
	 * Return the value associated with the column: cashallocpayout
	 */
	public java.math.BigDecimal getCashallocpayout () {
		return cashallocpayout;
	}

	/**
	 * Set the value related to the column: cashallocpayout
	 * @param cashallocpayout the cashallocpayout value
	 */
	public void setCashallocpayout (java.math.BigDecimal cashallocpayout) {
		this.cashallocpayout = cashallocpayout;
	}



	/**
	 * Return the value associated with the column: dockey
	 */
	public java.lang.String getDockey () {
		return dockey;
	}

	/**
	 * Set the value related to the column: dockey
	 * @param dockey the dockey value
	 */
	public void setDockey (java.lang.String dockey) {
		this.dockey = dockey;
	}



	/**
	 * Return the value associated with the column: vatamount
	 */
	public java.math.BigDecimal getVatamount () {
		return vatamount;
	}

	/**
	 * Set the value related to the column: vatamount
	 * @param vatamount the vatamount value
	 */
	public void setVatamount (java.math.BigDecimal vatamount) {
		this.vatamount = vatamount;
	}



	/**
	 * Return the value associated with the column: pyodoneflag
	 */
	public boolean isPyodoneflag () {
		return pyodoneflag;
	}

	/**
	 * Set the value related to the column: pyodoneflag
	 * @param pyodoneflag the pyodoneflag value
	 */
	public void setPyodoneflag (boolean pyodoneflag) {
		this.pyodoneflag = pyodoneflag;
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
	 * Return the value associated with the column: payoutamount
	 */
	public java.math.BigDecimal getPayoutamount () {
		return payoutamount;
	}

	/**
	 * Set the value related to the column: payoutamount
	 * @param payoutamount the payoutamount value
	 */
	public void setPayoutamount (java.math.BigDecimal payoutamount) {
		this.payoutamount = payoutamount;
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
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public java.lang.String getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (java.lang.String lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.finance.Financehdr)) return false;
		else {
			com.bureaueye.genesys.model.finance.Financehdr financehdr = (com.bureaueye.genesys.model.finance.Financehdr) obj;
			if (null == this.getFinancehdrId() || null == financehdr.getFinancehdrId()) return false;
			else return (this.getFinancehdrId().equals(financehdr.getFinancehdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getFinancehdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getFinancehdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}