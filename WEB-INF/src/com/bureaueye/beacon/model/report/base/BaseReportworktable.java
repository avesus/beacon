package com.bureaueye.beacon.model.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the reportworktable table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="reportworktable"
 */

public abstract class BaseReportworktable  implements Serializable {

	public static String REF = "Reportworktable";
	public static String PROP_FIELD37 = "Field37";
	public static String PROP_FIELD38 = "Field38";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_FIELD35 = "Field35";
	public static String PROP_FIELD36 = "Field36";
	public static String PROP_FIELD33 = "Field33";
	public static String PROP_FIELD34 = "Field34";
	public static String PROP_FIELD31 = "Field31";
	public static String PROP_FIELD32 = "Field32";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_FIELD30 = "Field30";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_FIELD29 = "Field29";
	public static String PROP_FIELD28 = "Field28";
	public static String PROP_FIELD24 = "Field24";
	public static String PROP_FIELD3 = "Field3";
	public static String PROP_FIELD2 = "Field2";
	public static String PROP_FIELD25 = "Field25";
	public static String PROP_FIELD5 = "Field5";
	public static String PROP_FIELD26 = "Field26";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_FIELD4 = "Field4";
	public static String PROP_FIELD27 = "Field27";
	public static String PROP_FIELD20 = "Field20";
	public static String PROP_FIELD7 = "Field7";
	public static String PROP_FIELD21 = "Field21";
	public static String PROP_FIELD6 = "Field6";
	public static String PROP_FIELD22 = "Field22";
	public static String PROP_FIELD9 = "Field9";
	public static String PROP_FIELD23 = "Field23";
	public static String PROP_FIELD8 = "Field8";
	public static String PROP_FIELD1 = "Field1";
	public static String PROP_REPORTWORKTABLE_ID = "ReportworktableId";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_FIELD18 = "Field18";
	public static String PROP_FIELD17 = "Field17";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_FIELD19 = "Field19";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_FIELD12 = "Field12";
	public static String PROP_FIELD11 = "Field11";
	public static String PROP_FIELD10 = "Field10";
	public static String PROP_FIELD16 = "Field16";
	public static String PROP_FIELD15 = "Field15";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_FIELD14 = "Field14";
	public static String PROP_FIELD50 = "Field50";
	public static String PROP_FIELD13 = "Field13";
	public static String PROP_REPORTKEY = "Reportkey";
	public static String PROP_FIELD42 = "Field42";
	public static String PROP_FIELD43 = "Field43";
	public static String PROP_FIELD44 = "Field44";
	public static String PROP_FIELD45 = "Field45";
	public static String PROP_FIELD46 = "Field46";
	public static String PROP_FIELD47 = "Field47";
	public static String PROP_FIELD48 = "Field48";
	public static String PROP_FIELD49 = "Field49";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_FIELD40 = "Field40";
	public static String PROP_FIELD41 = "Field41";
	public static String PROP_FIELD39 = "Field39";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseReportworktable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportworktable (java.lang.Integer reportworktableId) {
		this.setReportworktableId(reportworktableId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer reportworktableId;

	// fields
	private java.lang.String reportkey;
	private java.lang.String field1;
	private java.lang.String field2;
	private java.lang.String field3;
	private java.lang.String field4;
	private java.lang.String field5;
	private java.lang.String field6;
	private java.lang.String field7;
	private java.lang.String field8;
	private java.lang.String field9;
	private java.lang.String field10;
	private java.lang.String field11;
	private java.lang.String field12;
	private java.lang.String field13;
	private java.lang.String field14;
	private java.lang.String field15;
	private java.lang.String field16;
	private java.lang.String field17;
	private java.lang.String field18;
	private java.lang.String field19;
	private java.lang.String field20;
	private java.util.Date field21;
	private java.util.Date field22;
	private java.util.Date field23;
	private java.util.Date field24;
	private java.util.Date field25;
	private java.util.Date field26;
	private java.util.Date field27;
	private java.util.Date field28;
	private java.util.Date field29;
	private java.util.Date field30;
	private java.math.BigDecimal field31;
	private java.math.BigDecimal field32;
	private java.math.BigDecimal field33;
	private java.math.BigDecimal field34;
	private java.math.BigDecimal field35;
	private java.math.BigDecimal field36;
	private java.math.BigDecimal field37;
	private java.math.BigDecimal field38;
	private java.math.BigDecimal field39;
	private java.math.BigDecimal field40;
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
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
	private java.lang.Integer field41;
	private java.lang.Integer field42;
	private java.lang.Integer field43;
	private java.lang.Integer field44;
	private java.lang.Integer field45;
	private java.lang.Integer field46;
	private java.lang.Integer field47;
	private java.lang.Integer field48;
	private java.lang.Integer field49;
	private java.lang.Integer field50;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="REPORTWORKTABLE_ID"
     */
	public java.lang.Integer getReportworktableId () {
		return reportworktableId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param reportworktableId the new ID
	 */
	public void setReportworktableId (java.lang.Integer reportworktableId) {
		this.reportworktableId = reportworktableId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: reportkey
	 */
	public java.lang.String getReportkey () {
		return reportkey;
	}

	/**
	 * Set the value related to the column: reportkey
	 * @param reportkey the reportkey value
	 */
	public void setReportkey (java.lang.String reportkey) {
		this.reportkey = reportkey;
	}



	/**
	 * Return the value associated with the column: field1
	 */
	public java.lang.String getField1 () {
		return field1;
	}

	/**
	 * Set the value related to the column: field1
	 * @param field1 the field1 value
	 */
	public void setField1 (java.lang.String field1) {
		this.field1 = field1;
	}



	/**
	 * Return the value associated with the column: field2
	 */
	public java.lang.String getField2 () {
		return field2;
	}

	/**
	 * Set the value related to the column: field2
	 * @param field2 the field2 value
	 */
	public void setField2 (java.lang.String field2) {
		this.field2 = field2;
	}



	/**
	 * Return the value associated with the column: field3
	 */
	public java.lang.String getField3 () {
		return field3;
	}

	/**
	 * Set the value related to the column: field3
	 * @param field3 the field3 value
	 */
	public void setField3 (java.lang.String field3) {
		this.field3 = field3;
	}



	/**
	 * Return the value associated with the column: field4
	 */
	public java.lang.String getField4 () {
		return field4;
	}

	/**
	 * Set the value related to the column: field4
	 * @param field4 the field4 value
	 */
	public void setField4 (java.lang.String field4) {
		this.field4 = field4;
	}



	/**
	 * Return the value associated with the column: field5
	 */
	public java.lang.String getField5 () {
		return field5;
	}

	/**
	 * Set the value related to the column: field5
	 * @param field5 the field5 value
	 */
	public void setField5 (java.lang.String field5) {
		this.field5 = field5;
	}



	/**
	 * Return the value associated with the column: field6
	 */
	public java.lang.String getField6 () {
		return field6;
	}

	/**
	 * Set the value related to the column: field6
	 * @param field6 the field6 value
	 */
	public void setField6 (java.lang.String field6) {
		this.field6 = field6;
	}



	/**
	 * Return the value associated with the column: field7
	 */
	public java.lang.String getField7 () {
		return field7;
	}

	/**
	 * Set the value related to the column: field7
	 * @param field7 the field7 value
	 */
	public void setField7 (java.lang.String field7) {
		this.field7 = field7;
	}



	/**
	 * Return the value associated with the column: field8
	 */
	public java.lang.String getField8 () {
		return field8;
	}

	/**
	 * Set the value related to the column: field8
	 * @param field8 the field8 value
	 */
	public void setField8 (java.lang.String field8) {
		this.field8 = field8;
	}



	/**
	 * Return the value associated with the column: field9
	 */
	public java.lang.String getField9 () {
		return field9;
	}

	/**
	 * Set the value related to the column: field9
	 * @param field9 the field9 value
	 */
	public void setField9 (java.lang.String field9) {
		this.field9 = field9;
	}



	/**
	 * Return the value associated with the column: field10
	 */
	public java.lang.String getField10 () {
		return field10;
	}

	/**
	 * Set the value related to the column: field10
	 * @param field10 the field10 value
	 */
	public void setField10 (java.lang.String field10) {
		this.field10 = field10;
	}



	/**
	 * Return the value associated with the column: field11
	 */
	public java.lang.String getField11 () {
		return field11;
	}

	/**
	 * Set the value related to the column: field11
	 * @param field11 the field11 value
	 */
	public void setField11 (java.lang.String field11) {
		this.field11 = field11;
	}



	/**
	 * Return the value associated with the column: field12
	 */
	public java.lang.String getField12 () {
		return field12;
	}

	/**
	 * Set the value related to the column: field12
	 * @param field12 the field12 value
	 */
	public void setField12 (java.lang.String field12) {
		this.field12 = field12;
	}



	/**
	 * Return the value associated with the column: field13
	 */
	public java.lang.String getField13 () {
		return field13;
	}

	/**
	 * Set the value related to the column: field13
	 * @param field13 the field13 value
	 */
	public void setField13 (java.lang.String field13) {
		this.field13 = field13;
	}



	/**
	 * Return the value associated with the column: field14
	 */
	public java.lang.String getField14 () {
		return field14;
	}

	/**
	 * Set the value related to the column: field14
	 * @param field14 the field14 value
	 */
	public void setField14 (java.lang.String field14) {
		this.field14 = field14;
	}



	/**
	 * Return the value associated with the column: field15
	 */
	public java.lang.String getField15 () {
		return field15;
	}

	/**
	 * Set the value related to the column: field15
	 * @param field15 the field15 value
	 */
	public void setField15 (java.lang.String field15) {
		this.field15 = field15;
	}



	/**
	 * Return the value associated with the column: field16
	 */
	public java.lang.String getField16 () {
		return field16;
	}

	/**
	 * Set the value related to the column: field16
	 * @param field16 the field16 value
	 */
	public void setField16 (java.lang.String field16) {
		this.field16 = field16;
	}



	/**
	 * Return the value associated with the column: field17
	 */
	public java.lang.String getField17 () {
		return field17;
	}

	/**
	 * Set the value related to the column: field17
	 * @param field17 the field17 value
	 */
	public void setField17 (java.lang.String field17) {
		this.field17 = field17;
	}



	/**
	 * Return the value associated with the column: field18
	 */
	public java.lang.String getField18 () {
		return field18;
	}

	/**
	 * Set the value related to the column: field18
	 * @param field18 the field18 value
	 */
	public void setField18 (java.lang.String field18) {
		this.field18 = field18;
	}



	/**
	 * Return the value associated with the column: field19
	 */
	public java.lang.String getField19 () {
		return field19;
	}

	/**
	 * Set the value related to the column: field19
	 * @param field19 the field19 value
	 */
	public void setField19 (java.lang.String field19) {
		this.field19 = field19;
	}



	/**
	 * Return the value associated with the column: field20
	 */
	public java.lang.String getField20 () {
		return field20;
	}

	/**
	 * Set the value related to the column: field20
	 * @param field20 the field20 value
	 */
	public void setField20 (java.lang.String field20) {
		this.field20 = field20;
	}



	/**
	 * Return the value associated with the column: field21
	 */
	public java.util.Date getField21 () {
		return field21;
	}

	/**
	 * Set the value related to the column: field21
	 * @param field21 the field21 value
	 */
	public void setField21 (java.util.Date field21) {
		this.field21 = field21;
	}



	/**
	 * Return the value associated with the column: field22
	 */
	public java.util.Date getField22 () {
		return field22;
	}

	/**
	 * Set the value related to the column: field22
	 * @param field22 the field22 value
	 */
	public void setField22 (java.util.Date field22) {
		this.field22 = field22;
	}



	/**
	 * Return the value associated with the column: field23
	 */
	public java.util.Date getField23 () {
		return field23;
	}

	/**
	 * Set the value related to the column: field23
	 * @param field23 the field23 value
	 */
	public void setField23 (java.util.Date field23) {
		this.field23 = field23;
	}



	/**
	 * Return the value associated with the column: field24
	 */
	public java.util.Date getField24 () {
		return field24;
	}

	/**
	 * Set the value related to the column: field24
	 * @param field24 the field24 value
	 */
	public void setField24 (java.util.Date field24) {
		this.field24 = field24;
	}



	/**
	 * Return the value associated with the column: field25
	 */
	public java.util.Date getField25 () {
		return field25;
	}

	/**
	 * Set the value related to the column: field25
	 * @param field25 the field25 value
	 */
	public void setField25 (java.util.Date field25) {
		this.field25 = field25;
	}



	/**
	 * Return the value associated with the column: field26
	 */
	public java.util.Date getField26 () {
		return field26;
	}

	/**
	 * Set the value related to the column: field26
	 * @param field26 the field26 value
	 */
	public void setField26 (java.util.Date field26) {
		this.field26 = field26;
	}



	/**
	 * Return the value associated with the column: field27
	 */
	public java.util.Date getField27 () {
		return field27;
	}

	/**
	 * Set the value related to the column: field27
	 * @param field27 the field27 value
	 */
	public void setField27 (java.util.Date field27) {
		this.field27 = field27;
	}



	/**
	 * Return the value associated with the column: field28
	 */
	public java.util.Date getField28 () {
		return field28;
	}

	/**
	 * Set the value related to the column: field28
	 * @param field28 the field28 value
	 */
	public void setField28 (java.util.Date field28) {
		this.field28 = field28;
	}



	/**
	 * Return the value associated with the column: field29
	 */
	public java.util.Date getField29 () {
		return field29;
	}

	/**
	 * Set the value related to the column: field29
	 * @param field29 the field29 value
	 */
	public void setField29 (java.util.Date field29) {
		this.field29 = field29;
	}



	/**
	 * Return the value associated with the column: field30
	 */
	public java.util.Date getField30 () {
		return field30;
	}

	/**
	 * Set the value related to the column: field30
	 * @param field30 the field30 value
	 */
	public void setField30 (java.util.Date field30) {
		this.field30 = field30;
	}



	/**
	 * Return the value associated with the column: field31
	 */
	public java.math.BigDecimal getField31 () {
		return field31;
	}

	/**
	 * Set the value related to the column: field31
	 * @param field31 the field31 value
	 */
	public void setField31 (java.math.BigDecimal field31) {
		this.field31 = field31;
	}



	/**
	 * Return the value associated with the column: field32
	 */
	public java.math.BigDecimal getField32 () {
		return field32;
	}

	/**
	 * Set the value related to the column: field32
	 * @param field32 the field32 value
	 */
	public void setField32 (java.math.BigDecimal field32) {
		this.field32 = field32;
	}



	/**
	 * Return the value associated with the column: field33
	 */
	public java.math.BigDecimal getField33 () {
		return field33;
	}

	/**
	 * Set the value related to the column: field33
	 * @param field33 the field33 value
	 */
	public void setField33 (java.math.BigDecimal field33) {
		this.field33 = field33;
	}



	/**
	 * Return the value associated with the column: field34
	 */
	public java.math.BigDecimal getField34 () {
		return field34;
	}

	/**
	 * Set the value related to the column: field34
	 * @param field34 the field34 value
	 */
	public void setField34 (java.math.BigDecimal field34) {
		this.field34 = field34;
	}



	/**
	 * Return the value associated with the column: field35
	 */
	public java.math.BigDecimal getField35 () {
		return field35;
	}

	/**
	 * Set the value related to the column: field35
	 * @param field35 the field35 value
	 */
	public void setField35 (java.math.BigDecimal field35) {
		this.field35 = field35;
	}



	/**
	 * Return the value associated with the column: field36
	 */
	public java.math.BigDecimal getField36 () {
		return field36;
	}

	/**
	 * Set the value related to the column: field36
	 * @param field36 the field36 value
	 */
	public void setField36 (java.math.BigDecimal field36) {
		this.field36 = field36;
	}



	/**
	 * Return the value associated with the column: field37
	 */
	public java.math.BigDecimal getField37 () {
		return field37;
	}

	/**
	 * Set the value related to the column: field37
	 * @param field37 the field37 value
	 */
	public void setField37 (java.math.BigDecimal field37) {
		this.field37 = field37;
	}



	/**
	 * Return the value associated with the column: field38
	 */
	public java.math.BigDecimal getField38 () {
		return field38;
	}

	/**
	 * Set the value related to the column: field38
	 * @param field38 the field38 value
	 */
	public void setField38 (java.math.BigDecimal field38) {
		this.field38 = field38;
	}



	/**
	 * Return the value associated with the column: field39
	 */
	public java.math.BigDecimal getField39 () {
		return field39;
	}

	/**
	 * Set the value related to the column: field39
	 * @param field39 the field39 value
	 */
	public void setField39 (java.math.BigDecimal field39) {
		this.field39 = field39;
	}



	/**
	 * Return the value associated with the column: field40
	 */
	public java.math.BigDecimal getField40 () {
		return field40;
	}

	/**
	 * Set the value related to the column: field40
	 * @param field40 the field40 value
	 */
	public void setField40 (java.math.BigDecimal field40) {
		this.field40 = field40;
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
	 * Return the value associated with the column: field41
	 */
	public java.lang.Integer getField41 () {
		return field41;
	}

	/**
	 * Set the value related to the column: field41
	 * @param field41 the field41 value
	 */
	public void setField41 (java.lang.Integer field41) {
		this.field41 = field41;
	}



	/**
	 * Return the value associated with the column: field42
	 */
	public java.lang.Integer getField42 () {
		return field42;
	}

	/**
	 * Set the value related to the column: field42
	 * @param field42 the field42 value
	 */
	public void setField42 (java.lang.Integer field42) {
		this.field42 = field42;
	}



	/**
	 * Return the value associated with the column: field43
	 */
	public java.lang.Integer getField43 () {
		return field43;
	}

	/**
	 * Set the value related to the column: field43
	 * @param field43 the field43 value
	 */
	public void setField43 (java.lang.Integer field43) {
		this.field43 = field43;
	}



	/**
	 * Return the value associated with the column: field44
	 */
	public java.lang.Integer getField44 () {
		return field44;
	}

	/**
	 * Set the value related to the column: field44
	 * @param field44 the field44 value
	 */
	public void setField44 (java.lang.Integer field44) {
		this.field44 = field44;
	}



	/**
	 * Return the value associated with the column: field45
	 */
	public java.lang.Integer getField45 () {
		return field45;
	}

	/**
	 * Set the value related to the column: field45
	 * @param field45 the field45 value
	 */
	public void setField45 (java.lang.Integer field45) {
		this.field45 = field45;
	}



	/**
	 * Return the value associated with the column: field46
	 */
	public java.lang.Integer getField46 () {
		return field46;
	}

	/**
	 * Set the value related to the column: field46
	 * @param field46 the field46 value
	 */
	public void setField46 (java.lang.Integer field46) {
		this.field46 = field46;
	}



	/**
	 * Return the value associated with the column: field47
	 */
	public java.lang.Integer getField47 () {
		return field47;
	}

	/**
	 * Set the value related to the column: field47
	 * @param field47 the field47 value
	 */
	public void setField47 (java.lang.Integer field47) {
		this.field47 = field47;
	}



	/**
	 * Return the value associated with the column: field48
	 */
	public java.lang.Integer getField48 () {
		return field48;
	}

	/**
	 * Set the value related to the column: field48
	 * @param field48 the field48 value
	 */
	public void setField48 (java.lang.Integer field48) {
		this.field48 = field48;
	}



	/**
	 * Return the value associated with the column: field49
	 */
	public java.lang.Integer getField49 () {
		return field49;
	}

	/**
	 * Set the value related to the column: field49
	 * @param field49 the field49 value
	 */
	public void setField49 (java.lang.Integer field49) {
		this.field49 = field49;
	}



	/**
	 * Return the value associated with the column: field50
	 */
	public java.lang.Integer getField50 () {
		return field50;
	}

	/**
	 * Set the value related to the column: field50
	 * @param field50 the field50 value
	 */
	public void setField50 (java.lang.Integer field50) {
		this.field50 = field50;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.report.Reportworktable)) return false;
		else {
			com.bureaueye.beacon.model.report.Reportworktable reportworktable = (com.bureaueye.beacon.model.report.Reportworktable) obj;
			if (null == this.getReportworktableId() || null == reportworktable.getReportworktableId()) return false;
			else return (this.getReportworktableId().equals(reportworktable.getReportworktableId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getReportworktableId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getReportworktableId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}