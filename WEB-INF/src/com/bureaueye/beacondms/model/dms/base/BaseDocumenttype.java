package com.bureaueye.beacondms.model.dms.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the documenttype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="documenttype"
 */

public abstract class BaseDocumenttype  implements Serializable {

	public static String REF = "Documenttype";
	public static String PROP_MARGINTOPPAGE1 = "Margintoppage1";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_PAGESIZERECTANGLEURX = "Pagesizerectangleurx";
	public static String PROP_MARGINTOP = "Margintop";
	public static String PROP_CATEGORYCODE = "Categorycode";
	public static String PROP_PAGESIZERECTANGLEURY = "Pagesizerectangleury";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LANGUAGEID = "Languageid";
	public static String PROP_DOCUMENTTYPE_ID = "DocumenttypeId";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_FONTNAME = "Fontname";
	public static String PROP_TESTINDICATOR = "Testindicator";
	public static String PROP_MARGINLEFT = "Marginleft";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_MARGINBOTTOM = "Marginbottom";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_PAGESIZERECTANGLELLX = "Pagesizerectanglellx";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_PAGESIZERECTANGLELLY = "Pagesizerectanglelly";
	public static String PROP_FONTSIZE = "Fontsize";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_BUILDCLASS = "Buildclass";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_FONTSTYLE = "Fontstyle";
	public static String PROP_MARGINRIGHT = "Marginright";
	public static String PROP_DOCTYPE = "Doctype";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_SUBCATEGORYCODE = "Subcategorycode";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseDocumenttype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDocumenttype (java.lang.Integer documenttypeId) {
		this.setDocumenttypeId(documenttypeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer documenttypeId;

	// fields
	private java.lang.String description;
	private java.lang.String doctype;
	private java.lang.String languageid;
	private java.lang.String testindicator;
	private java.lang.String buildclass;
	private java.lang.String departmentkey;
	private java.lang.String companykey;
	private java.lang.String activitykey;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private boolean deleteflag;
	private java.util.Date deletedate;
	private java.lang.String deletetime;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogaction;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogtime;
	private java.lang.String systemloguserid;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.lang.Integer rowid;
	private java.math.BigDecimal marginleft;
	private java.math.BigDecimal marginright;
	private java.math.BigDecimal margintop;
	private java.math.BigDecimal margintoppage1;
	private java.math.BigDecimal marginbottom;
	private java.lang.String fontname;
	private java.math.BigDecimal fontsize;
	private java.lang.Integer fontstyle;
	private java.math.BigDecimal pagesizerectanglellx;
	private java.math.BigDecimal pagesizerectanglelly;
	private java.math.BigDecimal pagesizerectangleurx;
	private java.math.BigDecimal pagesizerectangleury;
	private java.lang.String categorycode;
	private java.lang.String subcategorycode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="DOCUMENTTYPE_ID"
     */
	public java.lang.Integer getDocumenttypeId () {
		return documenttypeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param documenttypeId the new ID
	 */
	public void setDocumenttypeId (java.lang.Integer documenttypeId) {
		this.documenttypeId = documenttypeId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: doctype
	 */
	public java.lang.String getDoctype () {
		return doctype;
	}

	/**
	 * Set the value related to the column: doctype
	 * @param doctype the doctype value
	 */
	public void setDoctype (java.lang.String doctype) {
		this.doctype = doctype;
	}



	/**
	 * Return the value associated with the column: languageid
	 */
	public java.lang.String getLanguageid () {
		return languageid;
	}

	/**
	 * Set the value related to the column: languageid
	 * @param languageid the languageid value
	 */
	public void setLanguageid (java.lang.String languageid) {
		this.languageid = languageid;
	}



	/**
	 * Return the value associated with the column: testindicator
	 */
	public java.lang.String getTestindicator () {
		return testindicator;
	}

	/**
	 * Set the value related to the column: testindicator
	 * @param testindicator the testindicator value
	 */
	public void setTestindicator (java.lang.String testindicator) {
		this.testindicator = testindicator;
	}



	/**
	 * Return the value associated with the column: buildclass
	 */
	public java.lang.String getBuildclass () {
		return buildclass;
	}

	/**
	 * Set the value related to the column: buildclass
	 * @param buildclass the buildclass value
	 */
	public void setBuildclass (java.lang.String buildclass) {
		this.buildclass = buildclass;
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
	 * Return the value associated with the column: deletedate
	 */
	public java.util.Date getDeletedate () {
		return deletedate;
	}

	/**
	 * Set the value related to the column: deletedate
	 * @param deletedate the deletedate value
	 */
	public void setDeletedate (java.util.Date deletedate) {
		this.deletedate = deletedate;
	}



	/**
	 * Return the value associated with the column: deletetime
	 */
	public java.lang.String getDeletetime () {
		return deletetime;
	}

	/**
	 * Set the value related to the column: deletetime
	 * @param deletetime the deletetime value
	 */
	public void setDeletetime (java.lang.String deletetime) {
		this.deletetime = deletetime;
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
	 * Return the value associated with the column: marginleft
	 */
	public java.math.BigDecimal getMarginleft () {
		return marginleft;
	}

	/**
	 * Set the value related to the column: marginleft
	 * @param marginleft the marginleft value
	 */
	public void setMarginleft (java.math.BigDecimal marginleft) {
		this.marginleft = marginleft;
	}



	/**
	 * Return the value associated with the column: marginright
	 */
	public java.math.BigDecimal getMarginright () {
		return marginright;
	}

	/**
	 * Set the value related to the column: marginright
	 * @param marginright the marginright value
	 */
	public void setMarginright (java.math.BigDecimal marginright) {
		this.marginright = marginright;
	}



	/**
	 * Return the value associated with the column: margintop
	 */
	public java.math.BigDecimal getMargintop () {
		return margintop;
	}

	/**
	 * Set the value related to the column: margintop
	 * @param margintop the margintop value
	 */
	public void setMargintop (java.math.BigDecimal margintop) {
		this.margintop = margintop;
	}



	/**
	 * Return the value associated with the column: margintoppage1
	 */
	public java.math.BigDecimal getMargintoppage1 () {
		return margintoppage1;
	}

	/**
	 * Set the value related to the column: margintoppage1
	 * @param margintoppage1 the margintoppage1 value
	 */
	public void setMargintoppage1 (java.math.BigDecimal margintoppage1) {
		this.margintoppage1 = margintoppage1;
	}



	/**
	 * Return the value associated with the column: marginbottom
	 */
	public java.math.BigDecimal getMarginbottom () {
		return marginbottom;
	}

	/**
	 * Set the value related to the column: marginbottom
	 * @param marginbottom the marginbottom value
	 */
	public void setMarginbottom (java.math.BigDecimal marginbottom) {
		this.marginbottom = marginbottom;
	}



	/**
	 * Return the value associated with the column: fontname
	 */
	public java.lang.String getFontname () {
		return fontname;
	}

	/**
	 * Set the value related to the column: fontname
	 * @param fontname the fontname value
	 */
	public void setFontname (java.lang.String fontname) {
		this.fontname = fontname;
	}



	/**
	 * Return the value associated with the column: fontsize
	 */
	public java.math.BigDecimal getFontsize () {
		return fontsize;
	}

	/**
	 * Set the value related to the column: fontsize
	 * @param fontsize the fontsize value
	 */
	public void setFontsize (java.math.BigDecimal fontsize) {
		this.fontsize = fontsize;
	}



	/**
	 * Return the value associated with the column: fontstyle
	 */
	public java.lang.Integer getFontstyle () {
		return fontstyle;
	}

	/**
	 * Set the value related to the column: fontstyle
	 * @param fontstyle the fontstyle value
	 */
	public void setFontstyle (java.lang.Integer fontstyle) {
		this.fontstyle = fontstyle;
	}



	/**
	 * Return the value associated with the column: pagesizerectanglellx
	 */
	public java.math.BigDecimal getPagesizerectanglellx () {
		return pagesizerectanglellx;
	}

	/**
	 * Set the value related to the column: pagesizerectanglellx
	 * @param pagesizerectanglellx the pagesizerectanglellx value
	 */
	public void setPagesizerectanglellx (java.math.BigDecimal pagesizerectanglellx) {
		this.pagesizerectanglellx = pagesizerectanglellx;
	}



	/**
	 * Return the value associated with the column: pagesizerectanglelly
	 */
	public java.math.BigDecimal getPagesizerectanglelly () {
		return pagesizerectanglelly;
	}

	/**
	 * Set the value related to the column: pagesizerectanglelly
	 * @param pagesizerectanglelly the pagesizerectanglelly value
	 */
	public void setPagesizerectanglelly (java.math.BigDecimal pagesizerectanglelly) {
		this.pagesizerectanglelly = pagesizerectanglelly;
	}



	/**
	 * Return the value associated with the column: pagesizerectangleurx
	 */
	public java.math.BigDecimal getPagesizerectangleurx () {
		return pagesizerectangleurx;
	}

	/**
	 * Set the value related to the column: pagesizerectangleurx
	 * @param pagesizerectangleurx the pagesizerectangleurx value
	 */
	public void setPagesizerectangleurx (java.math.BigDecimal pagesizerectangleurx) {
		this.pagesizerectangleurx = pagesizerectangleurx;
	}



	/**
	 * Return the value associated with the column: pagesizerectangleury
	 */
	public java.math.BigDecimal getPagesizerectangleury () {
		return pagesizerectangleury;
	}

	/**
	 * Set the value related to the column: pagesizerectangleury
	 * @param pagesizerectangleury the pagesizerectangleury value
	 */
	public void setPagesizerectangleury (java.math.BigDecimal pagesizerectangleury) {
		this.pagesizerectangleury = pagesizerectangleury;
	}



	/**
	 * Return the value associated with the column: categorycode
	 */
	public java.lang.String getCategorycode () {
		return categorycode;
	}

	/**
	 * Set the value related to the column: categorycode
	 * @param categorycode the categorycode value
	 */
	public void setCategorycode (java.lang.String categorycode) {
		this.categorycode = categorycode;
	}



	/**
	 * Return the value associated with the column: subcategorycode
	 */
	public java.lang.String getSubcategorycode () {
		return subcategorycode;
	}

	/**
	 * Set the value related to the column: subcategorycode
	 * @param subcategorycode the subcategorycode value
	 */
	public void setSubcategorycode (java.lang.String subcategorycode) {
		this.subcategorycode = subcategorycode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacondms.model.dms.Documenttype)) return false;
		else {
			com.bureaueye.beacondms.model.dms.Documenttype documenttype = (com.bureaueye.beacondms.model.dms.Documenttype) obj;
			if (null == this.getDocumenttypeId() || null == documenttype.getDocumenttypeId()) return false;
			else return (this.getDocumenttypeId().equals(documenttype.getDocumenttypeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getDocumenttypeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getDocumenttypeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}