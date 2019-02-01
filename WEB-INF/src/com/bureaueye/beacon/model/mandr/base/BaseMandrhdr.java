package com.bureaueye.beacon.model.mandr.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mandrhdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mandrhdr"
 */

public abstract class BaseMandrhdr  implements Serializable {

	public static String REF = "Mandrhdr";
	public static String PROP_APPROVEDATE = "Approvedate";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_MOVEREF = "Moveref";
	public static String PROP_ESTIMATEREF = "Estimateref";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_LABORAMT = "Laboramt";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_OUTDATE = "Outdate";
	public static String PROP_TOTALAMT = "Totalamt";
	public static String PROP_MANDRTYPEKEY = "Mandrtypekey";
	public static String PROP_ORIGINALESTIMATEDATE = "Originalestimatedate";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_MANDRHDR_ID = "MandrhdrId";
	public static String PROP_VERSIONNO = "Versionno";
	public static String PROP_CLEANBY = "Cleanby";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_REOPENFLAG = "Reopenflag";
	public static String PROP_RETURNTOLESSORFLAG = "Returntolessorflag";
	public static String PROP_CANCELBY = "Cancelby";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_LABORRATE = "Laborrate";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_REPAIRDATE = "Repairdate";
	public static String PROP_INDATE = "Indate";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CLEANDATE = "Cleandate";
	public static String PROP_MATERIALAMT = "Materialamt";
	public static String PROP_REOPENDATE = "Reopendate";
	public static String PROP_LASTVERSIONFLAG = "Lastversionflag";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_MANDRNO = "Mandrno";
	public static String PROP_CANCELFLAG = "Cancelflag";
	public static String PROP_DEPOTLOCATIONKEY = "Depotlocationkey";
	public static String PROP_ESTIMATEDATE = "Estimatedate";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_CLEANFLAG = "Cleanflag";
	public static String PROP_DPPCCYKEY = "Dppccykey";
	public static String PROP_REOPENBY = "Reopenby";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_MANDRSTATUS = "Mandrstatus";
	public static String PROP_LABORHOURS = "Laborhours";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CANCELREASON = "Cancelreason";
	public static String PROP_DPPAMT = "Dppamt";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CANCELDATE = "Canceldate";


	// constructors
	public BaseMandrhdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMandrhdr (java.lang.Integer mandrhdrId) {
		this.setMandrhdrId(mandrhdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer mandrhdrId;

	// fields
	private java.math.BigDecimal materialamt;
	private java.math.BigDecimal laboramt;
	private java.math.BigDecimal totalamt;
	private java.lang.String mandrno;
	private java.lang.Integer versionno;
	private java.lang.String mandrtypekey;
	private java.lang.String estimateref;
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	private java.lang.String moveref;
	private java.lang.String lesseeaddrkey;
	private java.lang.String customeraddrkey;
	private java.lang.String depotlocationkey;
	private java.lang.String vendoraddrkey;
	private java.lang.String ccykey;
	private java.lang.String dppccykey;
	private java.math.BigDecimal laborrate;
	private java.math.BigDecimal dppamt;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String unitkey;
	private java.lang.Integer unitId;
	private boolean returntolessorflag;
	private java.lang.String productkey;
	private boolean cancelflag;
	private java.util.Date canceldate;
	private java.lang.String cancelby;
	private java.lang.String cancelreason;
	private boolean reopenflag;
	private java.util.Date reopendate;
	private java.lang.String reopenby;
	private boolean cleanflag;
	private java.util.Date cleandate;
	private java.lang.String cleanby;
	private java.lang.String mandrstatus;
	private java.util.Date approvedate;
	private java.util.Date estimatedate;
	private java.util.Date repairdate;
	private java.util.Date indate;
	private java.util.Date outdate;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.util.Date originalestimatedate;
	private boolean lastversionflag;
	private java.math.BigDecimal laborhours;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MANDRHDR_ID"
     */
	public java.lang.Integer getMandrhdrId () {
		return mandrhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param mandrhdrId the new ID
	 */
	public void setMandrhdrId (java.lang.Integer mandrhdrId) {
		this.mandrhdrId = mandrhdrId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: materialamt
	 */
	public java.math.BigDecimal getMaterialamt () {
		return materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (java.math.BigDecimal materialamt) {
		this.materialamt = materialamt;
	}



	/**
	 * Return the value associated with the column: laboramt
	 */
	public java.math.BigDecimal getLaboramt () {
		return laboramt;
	}

	/**
	 * Set the value related to the column: laboramt
	 * @param laboramt the laboramt value
	 */
	public void setLaboramt (java.math.BigDecimal laboramt) {
		this.laboramt = laboramt;
	}



	/**
	 * Return the value associated with the column: totalamt
	 */
	public java.math.BigDecimal getTotalamt () {
		return totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (java.math.BigDecimal totalamt) {
		this.totalamt = totalamt;
	}



	/**
	 * Return the value associated with the column: mandrno
	 */
	public java.lang.String getMandrno () {
		return mandrno;
	}

	/**
	 * Set the value related to the column: mandrno
	 * @param mandrno the mandrno value
	 */
	public void setMandrno (java.lang.String mandrno) {
		this.mandrno = mandrno;
	}



	/**
	 * Return the value associated with the column: versionno
	 */
	public java.lang.Integer getVersionno () {
		return versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param versionno the versionno value
	 */
	public void setVersionno (java.lang.Integer versionno) {
		this.versionno = versionno;
	}



	/**
	 * Return the value associated with the column: mandrtypekey
	 */
	public java.lang.String getMandrtypekey () {
		return mandrtypekey;
	}

	/**
	 * Set the value related to the column: mandrtypekey
	 * @param mandrtypekey the mandrtypekey value
	 */
	public void setMandrtypekey (java.lang.String mandrtypekey) {
		this.mandrtypekey = mandrtypekey;
	}



	/**
	 * Return the value associated with the column: estimateref
	 */
	public java.lang.String getEstimateref () {
		return estimateref;
	}

	/**
	 * Set the value related to the column: estimateref
	 * @param estimateref the estimateref value
	 */
	public void setEstimateref (java.lang.String estimateref) {
		this.estimateref = estimateref;
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
	 * Return the value associated with the column: moveref
	 */
	public java.lang.String getMoveref () {
		return moveref;
	}

	/**
	 * Set the value related to the column: moveref
	 * @param moveref the moveref value
	 */
	public void setMoveref (java.lang.String moveref) {
		this.moveref = moveref;
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
	 * Return the value associated with the column: depotlocationkey
	 */
	public java.lang.String getDepotlocationkey () {
		return depotlocationkey;
	}

	/**
	 * Set the value related to the column: depotlocationkey
	 * @param depotlocationkey the depotlocationkey value
	 */
	public void setDepotlocationkey (java.lang.String depotlocationkey) {
		this.depotlocationkey = depotlocationkey;
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
	 * Return the value associated with the column: dppccykey
	 */
	public java.lang.String getDppccykey () {
		return dppccykey;
	}

	/**
	 * Set the value related to the column: dppccykey
	 * @param dppccykey the dppccykey value
	 */
	public void setDppccykey (java.lang.String dppccykey) {
		this.dppccykey = dppccykey;
	}



	/**
	 * Return the value associated with the column: laborrate
	 */
	public java.math.BigDecimal getLaborrate () {
		return laborrate;
	}

	/**
	 * Set the value related to the column: laborrate
	 * @param laborrate the laborrate value
	 */
	public void setLaborrate (java.math.BigDecimal laborrate) {
		this.laborrate = laborrate;
	}



	/**
	 * Return the value associated with the column: dppamt
	 */
	public java.math.BigDecimal getDppamt () {
		return dppamt;
	}

	/**
	 * Set the value related to the column: dppamt
	 * @param dppamt the dppamt value
	 */
	public void setDppamt (java.math.BigDecimal dppamt) {
		this.dppamt = dppamt;
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
	 * Return the value associated with the column: returntolessorflag
	 */
	public boolean isReturntolessorflag () {
		return returntolessorflag;
	}

	/**
	 * Set the value related to the column: returntolessorflag
	 * @param returntolessorflag the returntolessorflag value
	 */
	public void setReturntolessorflag (boolean returntolessorflag) {
		this.returntolessorflag = returntolessorflag;
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
	 * Return the value associated with the column: cancelflag
	 */
	public boolean isCancelflag () {
		return cancelflag;
	}

	/**
	 * Set the value related to the column: cancelflag
	 * @param cancelflag the cancelflag value
	 */
	public void setCancelflag (boolean cancelflag) {
		this.cancelflag = cancelflag;
	}



	/**
	 * Return the value associated with the column: canceldate
	 */
	public java.util.Date getCanceldate () {
		return canceldate;
	}

	/**
	 * Set the value related to the column: canceldate
	 * @param canceldate the canceldate value
	 */
	public void setCanceldate (java.util.Date canceldate) {
		this.canceldate = canceldate;
	}



	/**
	 * Return the value associated with the column: cancelby
	 */
	public java.lang.String getCancelby () {
		return cancelby;
	}

	/**
	 * Set the value related to the column: cancelby
	 * @param cancelby the cancelby value
	 */
	public void setCancelby (java.lang.String cancelby) {
		this.cancelby = cancelby;
	}



	/**
	 * Return the value associated with the column: cancelreason
	 */
	public java.lang.String getCancelreason () {
		return cancelreason;
	}

	/**
	 * Set the value related to the column: cancelreason
	 * @param cancelreason the cancelreason value
	 */
	public void setCancelreason (java.lang.String cancelreason) {
		this.cancelreason = cancelreason;
	}



	/**
	 * Return the value associated with the column: reopenflag
	 */
	public boolean isReopenflag () {
		return reopenflag;
	}

	/**
	 * Set the value related to the column: reopenflag
	 * @param reopenflag the reopenflag value
	 */
	public void setReopenflag (boolean reopenflag) {
		this.reopenflag = reopenflag;
	}



	/**
	 * Return the value associated with the column: reopendate
	 */
	public java.util.Date getReopendate () {
		return reopendate;
	}

	/**
	 * Set the value related to the column: reopendate
	 * @param reopendate the reopendate value
	 */
	public void setReopendate (java.util.Date reopendate) {
		this.reopendate = reopendate;
	}



	/**
	 * Return the value associated with the column: reopenby
	 */
	public java.lang.String getReopenby () {
		return reopenby;
	}

	/**
	 * Set the value related to the column: reopenby
	 * @param reopenby the reopenby value
	 */
	public void setReopenby (java.lang.String reopenby) {
		this.reopenby = reopenby;
	}



	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean cleanflag) {
		this.cleanflag = cleanflag;
	}



	/**
	 * Return the value associated with the column: cleandate
	 */
	public java.util.Date getCleandate () {
		return cleandate;
	}

	/**
	 * Set the value related to the column: cleandate
	 * @param cleandate the cleandate value
	 */
	public void setCleandate (java.util.Date cleandate) {
		this.cleandate = cleandate;
	}



	/**
	 * Return the value associated with the column: cleanby
	 */
	public java.lang.String getCleanby () {
		return cleanby;
	}

	/**
	 * Set the value related to the column: cleanby
	 * @param cleanby the cleanby value
	 */
	public void setCleanby (java.lang.String cleanby) {
		this.cleanby = cleanby;
	}



	/**
	 * Return the value associated with the column: mandrstatus
	 */
	public java.lang.String getMandrstatus () {
		return mandrstatus;
	}

	/**
	 * Set the value related to the column: mandrstatus
	 * @param mandrstatus the mandrstatus value
	 */
	public void setMandrstatus (java.lang.String mandrstatus) {
		this.mandrstatus = mandrstatus;
	}



	/**
	 * Return the value associated with the column: approvedate
	 */
	public java.util.Date getApprovedate () {
		return approvedate;
	}

	/**
	 * Set the value related to the column: approvedate
	 * @param approvedate the approvedate value
	 */
	public void setApprovedate (java.util.Date approvedate) {
		this.approvedate = approvedate;
	}



	/**
	 * Return the value associated with the column: estimatedate
	 */
	public java.util.Date getEstimatedate () {
		return estimatedate;
	}

	/**
	 * Set the value related to the column: estimatedate
	 * @param estimatedate the estimatedate value
	 */
	public void setEstimatedate (java.util.Date estimatedate) {
		this.estimatedate = estimatedate;
	}



	/**
	 * Return the value associated with the column: repairdate
	 */
	public java.util.Date getRepairdate () {
		return repairdate;
	}

	/**
	 * Set the value related to the column: repairdate
	 * @param repairdate the repairdate value
	 */
	public void setRepairdate (java.util.Date repairdate) {
		this.repairdate = repairdate;
	}



	/**
	 * Return the value associated with the column: indate
	 */
	public java.util.Date getIndate () {
		return indate;
	}

	/**
	 * Set the value related to the column: indate
	 * @param indate the indate value
	 */
	public void setIndate (java.util.Date indate) {
		this.indate = indate;
	}



	/**
	 * Return the value associated with the column: outdate
	 */
	public java.util.Date getOutdate () {
		return outdate;
	}

	/**
	 * Set the value related to the column: outdate
	 * @param outdate the outdate value
	 */
	public void setOutdate (java.util.Date outdate) {
		this.outdate = outdate;
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
	 * Return the value associated with the column: originalestimatedate
	 */
	public java.util.Date getOriginalestimatedate () {
		return originalestimatedate;
	}

	/**
	 * Set the value related to the column: originalestimatedate
	 * @param originalestimatedate the originalestimatedate value
	 */
	public void setOriginalestimatedate (java.util.Date originalestimatedate) {
		this.originalestimatedate = originalestimatedate;
	}



	/**
	 * Return the value associated with the column: lastversionflag
	 */
	public boolean isLastversionflag () {
		return lastversionflag;
	}

	/**
	 * Set the value related to the column: lastversionflag
	 * @param lastversionflag the lastversionflag value
	 */
	public void setLastversionflag (boolean lastversionflag) {
		this.lastversionflag = lastversionflag;
	}



	/**
	 * Return the value associated with the column: laborhours
	 */
	public java.math.BigDecimal getLaborhours () {
		return laborhours;
	}

	/**
	 * Set the value related to the column: laborhours
	 * @param laborhours the laborhours value
	 */
	public void setLaborhours (java.math.BigDecimal laborhours) {
		this.laborhours = laborhours;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mandr.Mandrhdr)) return false;
		else {
			com.bureaueye.beacon.model.mandr.Mandrhdr mandrhdr = (com.bureaueye.beacon.model.mandr.Mandrhdr) obj;
			if (null == this.getMandrhdrId() || null == mandrhdr.getMandrhdrId()) return false;
			else return (this.getMandrhdrId().equals(mandrhdr.getMandrhdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getMandrhdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getMandrhdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}