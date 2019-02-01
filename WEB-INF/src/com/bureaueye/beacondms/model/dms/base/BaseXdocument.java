package com.bureaueye.beacondms.model.dms.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the xdocument table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="xdocument"
 */

public abstract class BaseXdocument  implements Serializable {

	public static String REF = "Xdocument";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_VERSIONTIME = "Versiontime";
	public static String PROP_DOCID = "Docid";
	public static String PROP_WARNINGS = "Warnings";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_VERSIONDATE = "Versiondate";
	public static String PROP_TESTINDICATOR = "Testindicator";
	public static String PROP_PROCESSDATE = "Processdate";
	public static String PROP_VERSIONUSERID = "Versionuserid";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_RECEIVETIME = "Receivetime";
	public static String PROP_VERSIONNO = "Versionno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_VERSIONDESCRIPTION = "Versiondescription";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_ERRORS = "Errors";
	public static String PROP_DOCTYPE = "Doctype";
	public static String PROP_CHECKOUTTIME = "Checkouttime";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_CHECKOUTUSERID = "Checkoutuserid";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_CHECKOUTDATE = "Checkoutdate";
	public static String PROP_CATEGORYCODE = "Categorycode";
	public static String PROP_MODULEID = "Moduleid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XMLDOCUMENT = "Xmldocument";
	public static String PROP_LANGUAGEID = "Languageid";
	public static String PROP_CONTENTTYPE = "Contenttype";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_FILESIZE = "Filesize";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_PROCESSTIME = "Processtime";
	public static String PROP_FILEBIN = "Filebin";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_CONTROLID = "Controlid";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATEACTION = "Createaction";
	public static String PROP_CHECKOUTFLAG = "Checkoutflag";
	public static String PROP_GROUPID = "Groupid";
	public static String PROP_COMPANYHEADERID = "Companyheaderid";
	public static String PROP_XMLHEADER = "Xmlheader";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_TRANSACTIONID = "Transactionid";
	public static String PROP_RECEIVEDATE = "Receivedate";
	public static String PROP_SUBCATEGORYCODE = "Subcategorycode";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SOURCEFILENAME = "Sourcefilename";
	public static String PROP_XDOCUMENT_ID = "XdocumentId";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseXdocument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseXdocument (java.lang.Integer xdocumentId) {
		this.setXdocumentId(xdocumentId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer xdocumentId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String receivetime;
	private java.lang.String processtime;
	private java.lang.String departmentkey;
	private java.lang.String dockey;
	private java.lang.String docid;
	private boolean xinactive;
	private java.lang.String deletetime;
	private java.lang.String doctype;
	private java.lang.String companykey;
	private java.lang.String document;
	private java.lang.String xmldocument;
	private java.lang.String xmlheader;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String controlid;
	private java.lang.String createuserid;
	private java.util.Date receivedate;
	private boolean deleteflag;
	private java.util.Date deletedate;
	private java.lang.String testindicator;
	private java.lang.String errors;
	private java.lang.String warnings;
	private java.util.Date processdate;
	private java.lang.Integer rowid;
	private java.lang.String activitykey;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String filename;
	private java.lang.String sourcefilename;
	private java.lang.Integer versionno;
	private java.lang.String versiontime;
	private java.util.Date versiondate;
	private java.lang.String versiondescription;
	private java.lang.String versionuserid;
	private boolean checkoutflag;
	private java.lang.String checkouttime;
	private java.util.Date checkoutdate;
	private java.lang.String checkoutuserid;
	private java.lang.String groupid;
	private java.lang.String transactionid;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String description;
	private java.lang.String contenttype;
	private java.sql.Blob filebin;
	private java.lang.Integer filesize;
	private java.lang.String moduleid;
	private java.lang.String companyheaderid;
	private java.lang.String languageid;
	private java.lang.String categorycode;
	private java.lang.String subcategorycode;
	private java.lang.String createaction;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="XDOCUMENT_ID"
     */
	public java.lang.Integer getXdocumentId () {
		return xdocumentId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param xdocumentId the new ID
	 */
	public void setXdocumentId (java.lang.Integer xdocumentId) {
		this.xdocumentId = xdocumentId;
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
	 * Return the value associated with the column: receivetime
	 */
	public java.lang.String getReceivetime () {
		return receivetime;
	}

	/**
	 * Set the value related to the column: receivetime
	 * @param receivetime the receivetime value
	 */
	public void setReceivetime (java.lang.String receivetime) {
		this.receivetime = receivetime;
	}



	/**
	 * Return the value associated with the column: processtime
	 */
	public java.lang.String getProcesstime () {
		return processtime;
	}

	/**
	 * Set the value related to the column: processtime
	 * @param processtime the processtime value
	 */
	public void setProcesstime (java.lang.String processtime) {
		this.processtime = processtime;
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
	 * Return the value associated with the column: docid
	 */
	public java.lang.String getDocid () {
		return docid;
	}

	/**
	 * Set the value related to the column: docid
	 * @param docid the docid value
	 */
	public void setDocid (java.lang.String docid) {
		this.docid = docid;
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
	 * Return the value associated with the column: document
	 */
	public java.lang.String getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: document
	 * @param document the document value
	 */
	public void setDocument (java.lang.String document) {
		this.document = document;
	}



	/**
	 * Return the value associated with the column: xmldocument
	 */
	public java.lang.String getXmldocument () {
		return xmldocument;
	}

	/**
	 * Set the value related to the column: xmldocument
	 * @param xmldocument the xmldocument value
	 */
	public void setXmldocument (java.lang.String xmldocument) {
		this.xmldocument = xmldocument;
	}



	/**
	 * Return the value associated with the column: xmlheader
	 */
	public java.lang.String getXmlheader () {
		return xmlheader;
	}

	/**
	 * Set the value related to the column: xmlheader
	 * @param xmlheader the xmlheader value
	 */
	public void setXmlheader (java.lang.String xmlheader) {
		this.xmlheader = xmlheader;
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
	 * Return the value associated with the column: controlid
	 */
	public java.lang.String getControlid () {
		return controlid;
	}

	/**
	 * Set the value related to the column: controlid
	 * @param controlid the controlid value
	 */
	public void setControlid (java.lang.String controlid) {
		this.controlid = controlid;
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
	 * Return the value associated with the column: receivedate
	 */
	public java.util.Date getReceivedate () {
		return receivedate;
	}

	/**
	 * Set the value related to the column: receivedate
	 * @param receivedate the receivedate value
	 */
	public void setReceivedate (java.util.Date receivedate) {
		this.receivedate = receivedate;
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
	 * Return the value associated with the column: errors
	 */
	public java.lang.String getErrors () {
		return errors;
	}

	/**
	 * Set the value related to the column: errors
	 * @param errors the errors value
	 */
	public void setErrors (java.lang.String errors) {
		this.errors = errors;
	}



	/**
	 * Return the value associated with the column: warnings
	 */
	public java.lang.String getWarnings () {
		return warnings;
	}

	/**
	 * Set the value related to the column: warnings
	 * @param warnings the warnings value
	 */
	public void setWarnings (java.lang.String warnings) {
		this.warnings = warnings;
	}



	/**
	 * Return the value associated with the column: processdate
	 */
	public java.util.Date getProcessdate () {
		return processdate;
	}

	/**
	 * Set the value related to the column: processdate
	 * @param processdate the processdate value
	 */
	public void setProcessdate (java.util.Date processdate) {
		this.processdate = processdate;
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
	 * Return the value associated with the column: filename
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: filename
	 * @param filename the filename value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: sourcefilename
	 */
	public java.lang.String getSourcefilename () {
		return sourcefilename;
	}

	/**
	 * Set the value related to the column: sourcefilename
	 * @param sourcefilename the sourcefilename value
	 */
	public void setSourcefilename (java.lang.String sourcefilename) {
		this.sourcefilename = sourcefilename;
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
	 * Return the value associated with the column: versiontime
	 */
	public java.lang.String getVersiontime () {
		return versiontime;
	}

	/**
	 * Set the value related to the column: versiontime
	 * @param versiontime the versiontime value
	 */
	public void setVersiontime (java.lang.String versiontime) {
		this.versiontime = versiontime;
	}



	/**
	 * Return the value associated with the column: versiondate
	 */
	public java.util.Date getVersiondate () {
		return versiondate;
	}

	/**
	 * Set the value related to the column: versiondate
	 * @param versiondate the versiondate value
	 */
	public void setVersiondate (java.util.Date versiondate) {
		this.versiondate = versiondate;
	}



	/**
	 * Return the value associated with the column: versiondescription
	 */
	public java.lang.String getVersiondescription () {
		return versiondescription;
	}

	/**
	 * Set the value related to the column: versiondescription
	 * @param versiondescription the versiondescription value
	 */
	public void setVersiondescription (java.lang.String versiondescription) {
		this.versiondescription = versiondescription;
	}



	/**
	 * Return the value associated with the column: versionuserid
	 */
	public java.lang.String getVersionuserid () {
		return versionuserid;
	}

	/**
	 * Set the value related to the column: versionuserid
	 * @param versionuserid the versionuserid value
	 */
	public void setVersionuserid (java.lang.String versionuserid) {
		this.versionuserid = versionuserid;
	}



	/**
	 * Return the value associated with the column: checkoutflag
	 */
	public boolean isCheckoutflag () {
		return checkoutflag;
	}

	/**
	 * Set the value related to the column: checkoutflag
	 * @param checkoutflag the checkoutflag value
	 */
	public void setCheckoutflag (boolean checkoutflag) {
		this.checkoutflag = checkoutflag;
	}



	/**
	 * Return the value associated with the column: checkouttime
	 */
	public java.lang.String getCheckouttime () {
		return checkouttime;
	}

	/**
	 * Set the value related to the column: checkouttime
	 * @param checkouttime the checkouttime value
	 */
	public void setCheckouttime (java.lang.String checkouttime) {
		this.checkouttime = checkouttime;
	}



	/**
	 * Return the value associated with the column: checkoutdate
	 */
	public java.util.Date getCheckoutdate () {
		return checkoutdate;
	}

	/**
	 * Set the value related to the column: checkoutdate
	 * @param checkoutdate the checkoutdate value
	 */
	public void setCheckoutdate (java.util.Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}



	/**
	 * Return the value associated with the column: checkoutuserid
	 */
	public java.lang.String getCheckoutuserid () {
		return checkoutuserid;
	}

	/**
	 * Set the value related to the column: checkoutuserid
	 * @param checkoutuserid the checkoutuserid value
	 */
	public void setCheckoutuserid (java.lang.String checkoutuserid) {
		this.checkoutuserid = checkoutuserid;
	}



	/**
	 * Return the value associated with the column: groupid
	 */
	public java.lang.String getGroupid () {
		return groupid;
	}

	/**
	 * Set the value related to the column: groupid
	 * @param groupid the groupid value
	 */
	public void setGroupid (java.lang.String groupid) {
		this.groupid = groupid;
	}



	/**
	 * Return the value associated with the column: transactionid
	 */
	public java.lang.String getTransactionid () {
		return transactionid;
	}

	/**
	 * Set the value related to the column: transactionid
	 * @param transactionid the transactionid value
	 */
	public void setTransactionid (java.lang.String transactionid) {
		this.transactionid = transactionid;
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
	 * Return the value associated with the column: contenttype
	 */
	public java.lang.String getContenttype () {
		return contenttype;
	}

	/**
	 * Set the value related to the column: contenttype
	 * @param contenttype the contenttype value
	 */
	public void setContenttype (java.lang.String contenttype) {
		this.contenttype = contenttype;
	}



	/**
	 * Return the value associated with the column: filebin
	 */
	public java.sql.Blob getFilebin () {
		return filebin;
	}

	/**
	 * Set the value related to the column: filebin
	 * @param filebin the filebin value
	 */
	public void setFilebin (java.sql.Blob filebin) {
		this.filebin = filebin;
	}



	/**
	 * Return the value associated with the column: filesize
	 */
	public java.lang.Integer getFilesize () {
		return filesize;
	}

	/**
	 * Set the value related to the column: filesize
	 * @param filesize the filesize value
	 */
	public void setFilesize (java.lang.Integer filesize) {
		this.filesize = filesize;
	}



	/**
	 * Return the value associated with the column: moduleid
	 */
	public java.lang.String getModuleid () {
		return moduleid;
	}

	/**
	 * Set the value related to the column: moduleid
	 * @param moduleid the moduleid value
	 */
	public void setModuleid (java.lang.String moduleid) {
		this.moduleid = moduleid;
	}



	/**
	 * Return the value associated with the column: companyheaderid
	 */
	public java.lang.String getCompanyheaderid () {
		return companyheaderid;
	}

	/**
	 * Set the value related to the column: companyheaderid
	 * @param companyheaderid the companyheaderid value
	 */
	public void setCompanyheaderid (java.lang.String companyheaderid) {
		this.companyheaderid = companyheaderid;
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



	/**
	 * Return the value associated with the column: createaction
	 */
	public java.lang.String getCreateaction () {
		return createaction;
	}

	/**
	 * Set the value related to the column: createaction
	 * @param createaction the createaction value
	 */
	public void setCreateaction (java.lang.String createaction) {
		this.createaction = createaction;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacondms.model.dms.Xdocument)) return false;
		else {
			com.bureaueye.beacondms.model.dms.Xdocument xdocument = (com.bureaueye.beacondms.model.dms.Xdocument) obj;
			if (null == this.getXdocumentId() || null == xdocument.getXdocumentId()) return false;
			else return (this.getXdocumentId().equals(xdocument.getXdocumentId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getXdocumentId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getXdocumentId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}