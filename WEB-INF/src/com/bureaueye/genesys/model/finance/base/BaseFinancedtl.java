package com.bureaueye.genesys.model.finance.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the financedtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="financedtl"
 */

public abstract class BaseFinancedtl  implements Serializable {

	public static String REF = "Financedtl";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_FINANCEHDR_ID = "FinancehdrId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_NETAMOUNT = "Netamount";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_ONHIRENO = "Onhireno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_OFFHIREEQP_ID = "OffhireeqpId";
	public static String PROP_LEASETYPEKEY = "Leasetypekey";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_GROSSAMOUNT = "Grossamount";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_EQPKEY = "Eqpkey";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_BILLFROMDATE = "Billfromdate";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_SUBTYPEKEY = "Subtypekey";
	public static String PROP_LOCATIONKEY = "Locationkey";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CONTRACTNO = "Contractno";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ONHIRE_ID = "OnhireId";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_VATAMOUNT = "Vatamount";
	public static String PROP_DOCTYPEKEY = "Doctypekey";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_BILLTODATE = "Billtodate";
	public static String PROP_DAYS = "Days";
	public static String PROP_PAIDTOINV = "Paidtoinv";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_OFFHIRE_ID = "OffhireId";
	public static String PROP_OFFHIRENO = "Offhireno";
	public static String PROP_CONTRACTEQP_ID = "ContracteqpId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ONHIREEQP_ID = "OnhireeqpId";
	public static String PROP_OFFHIREDATE = "Offhiredate";
	public static String PROP_BILLDATE = "Billdate";
	public static String PROP_CONTRACTEQPLOC_ID = "ContracteqplocId";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_FINANCEDTL_ID = "FinancedtlId";
	public static String PROP_DOCLINENO = "Doclineno";
	public static String PROP_ONHIREDATE = "Onhiredate";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseFinancedtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFinancedtl (java.lang.Integer financedtlId) {
		this.setFinancedtlId(financedtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer financedtlId;

	// fields
	private java.lang.String contractno;
	private java.lang.String eqpkeyp9;
	private java.util.Date systemlogdate;
	private java.util.Date onhiredate;
	private java.lang.String activitykey;
	private java.lang.String eqpkeyp6;
	private java.lang.String eqpkeyp5;
	private java.lang.String eqpkeyp8;
	private java.util.Date billfromdate;
	private java.lang.String eqpkeyp7;
	private java.lang.String xlock;
	private java.util.Date billtodate;
	private java.util.Date createdate;
	private java.lang.String subtypekey;
	private java.lang.String doctypekey;
	private java.lang.String systemlogaction;
	private java.lang.Integer doclineno;
	private java.lang.String lesseeaddrkey;
	private java.util.Date offhiredate;
	private boolean xinactive;
	private java.lang.String unitkey;
	private java.lang.String companykey;
	private java.lang.String offhireno;
	private java.lang.String dockey;
	private java.math.BigDecimal vatamount;
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.String eqpkeyp1;
	private java.lang.String createuserid;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkey;
	private java.lang.String departmentkey;
	private java.lang.Integer onhireeqpId;
	private java.lang.String ccykey;
	private java.math.BigDecimal netamount;
	private java.lang.String eqpkeyp10;
	private java.lang.Integer offhireId;
	private java.lang.String locationkey;
	private java.lang.String createtime;
	private java.util.Date billdate;
	private java.lang.Integer offhireeqpId;
	private java.lang.String systemlogtime;
	private java.lang.String leasetypekey;
	private java.lang.Integer contractId;
	private java.lang.Integer contracteqpId;
	private java.lang.Integer contracteqplocId;
	private java.math.BigDecimal grossamount;
	private java.lang.Integer onhireId;
	private java.lang.Integer financehdrId;
	private java.lang.Integer unitId;
	private java.math.BigDecimal paidtoinv;
	private java.lang.String onhireno;
	private java.lang.String systemlogprogram;
	private java.lang.Integer days;
	private java.lang.String systemloguserid;
	private java.lang.String txt1;
	private java.lang.String txt2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FINANCEDTL_ID"
     */
	public java.lang.Integer getFinancedtlId () {
		return financedtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param financedtlId the new ID
	 */
	public void setFinancedtlId (java.lang.Integer financedtlId) {
		this.financedtlId = financedtlId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String eqpkeyp9) {
		this.eqpkeyp9 = eqpkeyp9;
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
	 * Return the value associated with the column: onhiredate
	 */
	public java.util.Date getOnhiredate () {
		return onhiredate;
	}

	/**
	 * Set the value related to the column: onhiredate
	 * @param onhiredate the onhiredate value
	 */
	public void setOnhiredate (java.util.Date onhiredate) {
		this.onhiredate = onhiredate;
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
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String eqpkeyp6) {
		this.eqpkeyp6 = eqpkeyp6;
	}



	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String eqpkeyp5) {
		this.eqpkeyp5 = eqpkeyp5;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String eqpkeyp8) {
		this.eqpkeyp8 = eqpkeyp8;
	}



	/**
	 * Return the value associated with the column: billfromdate
	 */
	public java.util.Date getBillfromdate () {
		return billfromdate;
	}

	/**
	 * Set the value related to the column: billfromdate
	 * @param billfromdate the billfromdate value
	 */
	public void setBillfromdate (java.util.Date billfromdate) {
		this.billfromdate = billfromdate;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String eqpkeyp7) {
		this.eqpkeyp7 = eqpkeyp7;
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
	 * Return the value associated with the column: billtodate
	 */
	public java.util.Date getBilltodate () {
		return billtodate;
	}

	/**
	 * Set the value related to the column: billtodate
	 * @param billtodate the billtodate value
	 */
	public void setBilltodate (java.util.Date billtodate) {
		this.billtodate = billtodate;
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
	 * Return the value associated with the column: subtypekey
	 */
	public java.lang.String getSubtypekey () {
		return subtypekey;
	}

	/**
	 * Set the value related to the column: subtypekey
	 * @param subtypekey the subtypekey value
	 */
	public void setSubtypekey (java.lang.String subtypekey) {
		this.subtypekey = subtypekey;
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
	 * Return the value associated with the column: doclineno
	 */
	public java.lang.Integer getDoclineno () {
		return doclineno;
	}

	/**
	 * Set the value related to the column: doclineno
	 * @param doclineno the doclineno value
	 */
	public void setDoclineno (java.lang.Integer doclineno) {
		this.doclineno = doclineno;
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
	 * Return the value associated with the column: offhiredate
	 */
	public java.util.Date getOffhiredate () {
		return offhiredate;
	}

	/**
	 * Set the value related to the column: offhiredate
	 * @param offhiredate the offhiredate value
	 */
	public void setOffhiredate (java.util.Date offhiredate) {
		this.offhiredate = offhiredate;
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
	 * Return the value associated with the column: offhireno
	 */
	public java.lang.String getOffhireno () {
		return offhireno;
	}

	/**
	 * Set the value related to the column: offhireno
	 * @param offhireno the offhireno value
	 */
	public void setOffhireno (java.lang.String offhireno) {
		this.offhireno = offhireno;
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
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String eqpkeyp3) {
		this.eqpkeyp3 = eqpkeyp3;
	}



	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String eqpkeyp4) {
		this.eqpkeyp4 = eqpkeyp4;
	}



	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
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
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
	}



	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String eqpkey) {
		this.eqpkey = eqpkey;
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
	 * Return the value associated with the column: ONHIREEQP_ID
	 */
	public java.lang.Integer getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the value related to the column: ONHIREEQP_ID
	 * @param onhireeqpId the ONHIREEQP_ID value
	 */
	public void setOnhireeqpId (java.lang.Integer onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
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
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String eqpkeyp10) {
		this.eqpkeyp10 = eqpkeyp10;
	}



	/**
	 * Return the value associated with the column: OFFHIRE_ID
	 */
	public java.lang.Integer getOffhireId () {
		return offhireId;
	}

	/**
	 * Set the value related to the column: OFFHIRE_ID
	 * @param offhireId the OFFHIRE_ID value
	 */
	public void setOffhireId (java.lang.Integer offhireId) {
		this.offhireId = offhireId;
	}



	/**
	 * Return the value associated with the column: locationkey
	 */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
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
	 * Return the value associated with the column: OFFHIREEQP_ID
	 */
	public java.lang.Integer getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the value related to the column: OFFHIREEQP_ID
	 * @param offhireeqpId the OFFHIREEQP_ID value
	 */
	public void setOffhireeqpId (java.lang.Integer offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
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
	 * Return the value associated with the column: CONTRACTEQP_ID
	 */
	public java.lang.Integer getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQP_ID
	 * @param contracteqpId the CONTRACTEQP_ID value
	 */
	public void setContracteqpId (java.lang.Integer contracteqpId) {
		this.contracteqpId = contracteqpId;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQPLOC_ID
	 */
	public java.lang.Integer getContracteqplocId () {
		return contracteqplocId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQPLOC_ID
	 * @param contracteqplocId the CONTRACTEQPLOC_ID value
	 */
	public void setContracteqplocId (java.lang.Integer contracteqplocId) {
		this.contracteqplocId = contracteqplocId;
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
	 * Return the value associated with the column: ONHIRE_ID
	 */
	public java.lang.Integer getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the value related to the column: ONHIRE_ID
	 * @param onhireId the ONHIRE_ID value
	 */
	public void setOnhireId (java.lang.Integer onhireId) {
		this.onhireId = onhireId;
	}



	/**
	 * Return the value associated with the column: FINANCEHDR_ID
	 */
	public java.lang.Integer getFinancehdrId () {
		return financehdrId;
	}

	/**
	 * Set the value related to the column: FINANCEHDR_ID
	 * @param financehdrId the FINANCEHDR_ID value
	 */
	public void setFinancehdrId (java.lang.Integer financehdrId) {
		this.financehdrId = financehdrId;
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
	 * Return the value associated with the column: paidtoinv
	 */
	public java.math.BigDecimal getPaidtoinv () {
		return paidtoinv;
	}

	/**
	 * Set the value related to the column: paidtoinv
	 * @param paidtoinv the paidtoinv value
	 */
	public void setPaidtoinv (java.math.BigDecimal paidtoinv) {
		this.paidtoinv = paidtoinv;
	}



	/**
	 * Return the value associated with the column: onhireno
	 */
	public java.lang.String getOnhireno () {
		return onhireno;
	}

	/**
	 * Set the value related to the column: onhireno
	 * @param onhireno the onhireno value
	 */
	public void setOnhireno (java.lang.String onhireno) {
		this.onhireno = onhireno;
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
	 * Return the value associated with the column: days
	 */
	public java.lang.Integer getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.Integer days) {
		this.days = days;
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
		if (!(obj instanceof com.bureaueye.genesys.model.finance.Financedtl)) return false;
		else {
			com.bureaueye.genesys.model.finance.Financedtl financedtl = (com.bureaueye.genesys.model.finance.Financedtl) obj;
			if (null == this.getFinancedtlId() || null == financedtl.getFinancedtlId()) return false;
			else return (this.getFinancedtlId().equals(financedtl.getFinancedtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getFinancedtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getFinancedtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}