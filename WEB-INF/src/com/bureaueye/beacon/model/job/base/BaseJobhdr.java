package com.bureaueye.beacon.model.job.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jobhdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jobhdr"
 */

public abstract class BaseJobhdr  implements Serializable {

	public static String REF = "Jobhdr";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_SEALNUMBER1 = "Sealnumber1";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_SEALNUMBER2 = "Sealnumber2";
	public static String PROP_SEALNUMBER3 = "Sealnumber3";
	public static String PROP_SEALNUMBER4 = "Sealnumber4";
	public static String PROP_SEALNUMBER5 = "Sealnumber5";
	public static String PROP_WEIGHTACTUALUNIT = "Weightactualunit";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_LOADDATE = "Loaddate";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_UNITKEY2 = "Unitkey2";
	public static String PROP_UNITKEY4 = "Unitkey4";
	public static String PROP_UNITKEY3 = "Unitkey3";
	public static String PROP_UNITKEY5 = "Unitkey5";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_MANDRKEY = "Mandrkey";
	public static String PROP_PREDMRGSTAT = "Predmrgstat";
	public static String PROP_MOVREF = "Movref";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_DMRGSTAT = "Dmrgstat";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_COMPLETE = "Complete";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_UNITAVAIL = "Unitavail";
	public static String PROP_SEALNUMBERS = "Sealnumbers";
	public static String PROP_OWNREGION = "Ownregion";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_WEIGHTACTUAL = "Weightactual";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_ADDINSTRUCTION = "Addinstruction";
	public static String PROP_JOBHDR_ID = "JobhdrId";
	public static String PROP_JOBNO = "Jobno";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_MANDRFLAG = "Mandrflag";
	public static String PROP_ACCRDATE = "Accrdate";
	public static String PROP_CLOSEOUTSTAT = "Closeoutstat";
	public static String PROP_UNIT_ID5 = "UnitId5";
	public static String PROP_UNIT_ID3 = "UnitId3";
	public static String PROP_ACCRSTAT = "Accrstat";
	public static String PROP_UNIT_ID4 = "UnitId4";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_UNIT_ID2 = "UnitId2";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CLOSEOUTDATE = "Closeoutdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseJobhdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJobhdr (java.lang.Integer jobhdrId) {
		this.setJobhdrId(jobhdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer jobhdrId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String movref;
	private java.lang.String jobno;
	private java.lang.String sealnumbers;
	private java.lang.String addinstruction;
	private java.lang.String weightactualunit;
	private java.math.BigDecimal weightactual;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String dmrgstat;
	private java.lang.String unitkey3;
	private java.lang.String departmentkey;
	private boolean complete;
	private java.lang.String ownregion;
	private boolean xinactive;
	private java.lang.String unitkey;
	private java.util.Date accrdate;
	private java.lang.String unitkey5;
	private java.lang.String systemloglock;
	private java.lang.String companykey;
	private java.lang.String systemlogtime;
	private java.lang.String unitkey4;
	private java.lang.String closeoutstat;
	private java.lang.String predmrgstat;
	private java.lang.String unitkey2;
	private java.util.Date closeoutdate;
	private boolean mandrflag;
	private java.lang.String mandrkey;
	private boolean unitavail;
	private java.lang.String createuserid;
	private java.lang.Integer orderhdrId;
	private java.lang.String accrstat;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String activitykey;
	private java.lang.String ccykey;
	private java.util.Date loaddate;
	private java.lang.String orderno;
	private java.lang.String xlock;
	private java.lang.Integer unitId;
	private java.lang.Integer unitId2;
	private java.lang.Integer unitId3;
	private java.lang.Integer unitId4;
	private java.lang.Integer unitId5;
	private java.lang.String productkey;
	private java.lang.String sealnumber1;
	private java.lang.String sealnumber2;
	private java.lang.String sealnumber3;
	private java.lang.String sealnumber4;
	private java.lang.String sealnumber5;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="JOBHDR_ID"
     */
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param jobhdrId the new ID
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
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
	 * Return the value associated with the column: movref
	 */
	public java.lang.String getMovref () {
		return movref;
	}

	/**
	 * Set the value related to the column: movref
	 * @param movref the movref value
	 */
	public void setMovref (java.lang.String movref) {
		this.movref = movref;
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
	 * Return the value associated with the column: sealnumbers
	 */
	public java.lang.String getSealnumbers () {
		return sealnumbers;
	}

	/**
	 * Set the value related to the column: sealnumbers
	 * @param sealnumbers the sealnumbers value
	 */
	public void setSealnumbers (java.lang.String sealnumbers) {
		this.sealnumbers = sealnumbers;
	}



	/**
	 * Return the value associated with the column: addinstruction
	 */
	public java.lang.String getAddinstruction () {
		return addinstruction;
	}

	/**
	 * Set the value related to the column: addinstruction
	 * @param addinstruction the addinstruction value
	 */
	public void setAddinstruction (java.lang.String addinstruction) {
		this.addinstruction = addinstruction;
	}



	/**
	 * Return the value associated with the column: weightactualunit
	 */
	public java.lang.String getWeightactualunit () {
		return weightactualunit;
	}

	/**
	 * Set the value related to the column: weightactualunit
	 * @param weightactualunit the weightactualunit value
	 */
	public void setWeightactualunit (java.lang.String weightactualunit) {
		this.weightactualunit = weightactualunit;
	}



	/**
	 * Return the value associated with the column: weightactual
	 */
	public java.math.BigDecimal getWeightactual () {
		return weightactual;
	}

	/**
	 * Set the value related to the column: weightactual
	 * @param weightactual the weightactual value
	 */
	public void setWeightactual (java.math.BigDecimal weightactual) {
		this.weightactual = weightactual;
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
	 * Return the value associated with the column: dmrgstat
	 */
	public java.lang.String getDmrgstat () {
		return dmrgstat;
	}

	/**
	 * Set the value related to the column: dmrgstat
	 * @param dmrgstat the dmrgstat value
	 */
	public void setDmrgstat (java.lang.String dmrgstat) {
		this.dmrgstat = dmrgstat;
	}



	/**
	 * Return the value associated with the column: UNITKEY3
	 */
	public java.lang.String getUnitkey3 () {
		return unitkey3;
	}

	/**
	 * Set the value related to the column: UNITKEY3
	 * @param unitkey3 the UNITKEY3 value
	 */
	public void setUnitkey3 (java.lang.String unitkey3) {
		this.unitkey3 = unitkey3;
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
	 * Return the value associated with the column: complete
	 */
	public boolean isComplete () {
		return complete;
	}

	/**
	 * Set the value related to the column: complete
	 * @param complete the complete value
	 */
	public void setComplete (boolean complete) {
		this.complete = complete;
	}



	/**
	 * Return the value associated with the column: OWNREGION
	 */
	public java.lang.String getOwnregion () {
		return ownregion;
	}

	/**
	 * Set the value related to the column: OWNREGION
	 * @param ownregion the OWNREGION value
	 */
	public void setOwnregion (java.lang.String ownregion) {
		this.ownregion = ownregion;
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
	 * Return the value associated with the column: UNITKEY
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: UNITKEY
	 * @param unitkey the UNITKEY value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: accrdate
	 */
	public java.util.Date getAccrdate () {
		return accrdate;
	}

	/**
	 * Set the value related to the column: accrdate
	 * @param accrdate the accrdate value
	 */
	public void setAccrdate (java.util.Date accrdate) {
		this.accrdate = accrdate;
	}



	/**
	 * Return the value associated with the column: UNITKEY5
	 */
	public java.lang.String getUnitkey5 () {
		return unitkey5;
	}

	/**
	 * Set the value related to the column: UNITKEY5
	 * @param unitkey5 the UNITKEY5 value
	 */
	public void setUnitkey5 (java.lang.String unitkey5) {
		this.unitkey5 = unitkey5;
	}



	/**
	 * Return the value associated with the column: systemloglock
	 */
	public java.lang.String getSystemloglock () {
		return systemloglock;
	}

	/**
	 * Set the value related to the column: systemloglock
	 * @param systemloglock the systemloglock value
	 */
	public void setSystemloglock (java.lang.String systemloglock) {
		this.systemloglock = systemloglock;
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
	 * Return the value associated with the column: UNITKEY4
	 */
	public java.lang.String getUnitkey4 () {
		return unitkey4;
	}

	/**
	 * Set the value related to the column: UNITKEY4
	 * @param unitkey4 the UNITKEY4 value
	 */
	public void setUnitkey4 (java.lang.String unitkey4) {
		this.unitkey4 = unitkey4;
	}



	/**
	 * Return the value associated with the column: closeoutstat
	 */
	public java.lang.String getCloseoutstat () {
		return closeoutstat;
	}

	/**
	 * Set the value related to the column: closeoutstat
	 * @param closeoutstat the closeoutstat value
	 */
	public void setCloseoutstat (java.lang.String closeoutstat) {
		this.closeoutstat = closeoutstat;
	}



	/**
	 * Return the value associated with the column: predmrgstat
	 */
	public java.lang.String getPredmrgstat () {
		return predmrgstat;
	}

	/**
	 * Set the value related to the column: predmrgstat
	 * @param predmrgstat the predmrgstat value
	 */
	public void setPredmrgstat (java.lang.String predmrgstat) {
		this.predmrgstat = predmrgstat;
	}



	/**
	 * Return the value associated with the column: UNITKEY2
	 */
	public java.lang.String getUnitkey2 () {
		return unitkey2;
	}

	/**
	 * Set the value related to the column: UNITKEY2
	 * @param unitkey2 the UNITKEY2 value
	 */
	public void setUnitkey2 (java.lang.String unitkey2) {
		this.unitkey2 = unitkey2;
	}



	/**
	 * Return the value associated with the column: closeoutdate
	 */
	public java.util.Date getCloseoutdate () {
		return closeoutdate;
	}

	/**
	 * Set the value related to the column: closeoutdate
	 * @param closeoutdate the closeoutdate value
	 */
	public void setCloseoutdate (java.util.Date closeoutdate) {
		this.closeoutdate = closeoutdate;
	}



	/**
	 * Return the value associated with the column: MANDRFLAG
	 */
	public boolean isMandrflag () {
		return mandrflag;
	}

	/**
	 * Set the value related to the column: MANDRFLAG
	 * @param mandrflag the MANDRFLAG value
	 */
	public void setMandrflag (boolean mandrflag) {
		this.mandrflag = mandrflag;
	}



	/**
	 * Return the value associated with the column: MANDRKEY
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: MANDRKEY
	 * @param mandrkey the MANDRKEY value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: unitavail
	 */
	public boolean isUnitavail () {
		return unitavail;
	}

	/**
	 * Set the value related to the column: unitavail
	 * @param unitavail the unitavail value
	 */
	public void setUnitavail (boolean unitavail) {
		this.unitavail = unitavail;
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
	 * Return the value associated with the column: accrstat
	 */
	public java.lang.String getAccrstat () {
		return accrstat;
	}

	/**
	 * Set the value related to the column: accrstat
	 * @param accrstat the accrstat value
	 */
	public void setAccrstat (java.lang.String accrstat) {
		this.accrstat = accrstat;
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
	 * Return the value associated with the column: loaddate
	 */
	public java.util.Date getLoaddate () {
		return loaddate;
	}

	/**
	 * Set the value related to the column: loaddate
	 * @param loaddate the loaddate value
	 */
	public void setLoaddate (java.util.Date loaddate) {
		this.loaddate = loaddate;
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
	 * Return the value associated with the column: UNIT_ID2
	 */
	public java.lang.Integer getUnitId2 () {
		return unitId2;
	}

	/**
	 * Set the value related to the column: UNIT_ID2
	 * @param unitId2 the UNIT_ID2 value
	 */
	public void setUnitId2 (java.lang.Integer unitId2) {
		this.unitId2 = unitId2;
	}



	/**
	 * Return the value associated with the column: UNIT_ID3
	 */
	public java.lang.Integer getUnitId3 () {
		return unitId3;
	}

	/**
	 * Set the value related to the column: UNIT_ID3
	 * @param unitId3 the UNIT_ID3 value
	 */
	public void setUnitId3 (java.lang.Integer unitId3) {
		this.unitId3 = unitId3;
	}



	/**
	 * Return the value associated with the column: UNIT_ID4
	 */
	public java.lang.Integer getUnitId4 () {
		return unitId4;
	}

	/**
	 * Set the value related to the column: UNIT_ID4
	 * @param unitId4 the UNIT_ID4 value
	 */
	public void setUnitId4 (java.lang.Integer unitId4) {
		this.unitId4 = unitId4;
	}



	/**
	 * Return the value associated with the column: UNIT_ID5
	 */
	public java.lang.Integer getUnitId5 () {
		return unitId5;
	}

	/**
	 * Set the value related to the column: UNIT_ID5
	 * @param unitId5 the UNIT_ID5 value
	 */
	public void setUnitId5 (java.lang.Integer unitId5) {
		this.unitId5 = unitId5;
	}



	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
	}



	/**
	 * Return the value associated with the column: sealnumber1
	 */
	public java.lang.String getSealnumber1 () {
		return sealnumber1;
	}

	/**
	 * Set the value related to the column: sealnumber1
	 * @param sealnumber1 the sealnumber1 value
	 */
	public void setSealnumber1 (java.lang.String sealnumber1) {
		this.sealnumber1 = sealnumber1;
	}



	/**
	 * Return the value associated with the column: sealnumber2
	 */
	public java.lang.String getSealnumber2 () {
		return sealnumber2;
	}

	/**
	 * Set the value related to the column: sealnumber2
	 * @param sealnumber2 the sealnumber2 value
	 */
	public void setSealnumber2 (java.lang.String sealnumber2) {
		this.sealnumber2 = sealnumber2;
	}



	/**
	 * Return the value associated with the column: sealnumber3
	 */
	public java.lang.String getSealnumber3 () {
		return sealnumber3;
	}

	/**
	 * Set the value related to the column: sealnumber3
	 * @param sealnumber3 the sealnumber3 value
	 */
	public void setSealnumber3 (java.lang.String sealnumber3) {
		this.sealnumber3 = sealnumber3;
	}



	/**
	 * Return the value associated with the column: sealnumber4
	 */
	public java.lang.String getSealnumber4 () {
		return sealnumber4;
	}

	/**
	 * Set the value related to the column: sealnumber4
	 * @param sealnumber4 the sealnumber4 value
	 */
	public void setSealnumber4 (java.lang.String sealnumber4) {
		this.sealnumber4 = sealnumber4;
	}



	/**
	 * Return the value associated with the column: sealnumber5
	 */
	public java.lang.String getSealnumber5 () {
		return sealnumber5;
	}

	/**
	 * Set the value related to the column: sealnumber5
	 * @param sealnumber5 the sealnumber5 value
	 */
	public void setSealnumber5 (java.lang.String sealnumber5) {
		this.sealnumber5 = sealnumber5;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.job.Jobhdr)) return false;
		else {
			com.bureaueye.beacon.model.job.Jobhdr jobhdr = (com.bureaueye.beacon.model.job.Jobhdr) obj;
			if (null == this.getJobhdrId() || null == jobhdr.getJobhdrId()) return false;
			else return (this.getJobhdrId().equals(jobhdr.getJobhdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getJobhdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getJobhdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}