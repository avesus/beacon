package com.bureaueye.beacon.model.edi.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ediinbound table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ediinbound"
 */

public abstract class BaseEdiinbound  implements Serializable {

	public static String REF = "Ediinbound";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_XMLDOCUMENT = "Xmldocument";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_EDIID = "Ediid";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EDISTATUS = "Edistatus";
	public static String PROP_PROCESSDATE = "Processdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_PROCESSTIME = "Processtime";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_RECEIVETIME = "Receivetime";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_EDIINBOUND_ID = "EdiinboundId";
	public static String PROP_CONTROLID = "Controlid";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_ERRORS = "Errors";
	public static String PROP_DOCTYPE = "Doctype";
	public static String PROP_RECEIVEDATE = "Receivedate";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseEdiinbound () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEdiinbound (java.lang.Integer ediinboundId) {
		this.setEdiinboundId(ediinboundId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer ediinboundId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String ediid;
	private java.lang.String receivetime;
	private java.lang.String processtime;
	private java.lang.String departmentkey;
	private java.lang.String dockey;
	private java.lang.String xinactive;
	private java.lang.String deletetime;
	private java.lang.String doctype;
	private java.lang.String companykey;
	private java.lang.String document;
	private java.lang.String xmldocument;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String controlid;
	private java.lang.String createuserid;
	private java.lang.String edistatus;
	private java.util.Date receivedate;
	private java.lang.String deleteflag;
	private java.util.Date deletedate;
	private java.lang.String errors;
	private java.util.Date processdate;
	private java.lang.Integer rowid;
	private java.lang.String activitykey;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String filename;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="EDIINBOUND_ID"
     */
	public java.lang.Integer getEdiinboundId () {
		return ediinboundId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ediinboundId the new ID
	 */
	public void setEdiinboundId (java.lang.Integer ediinboundId) {
		this.ediinboundId = ediinboundId;
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
	 * Return the value associated with the column: ediid
	 */
	public java.lang.String getEdiid () {
		return ediid;
	}

	/**
	 * Set the value related to the column: ediid
	 * @param ediid the ediid value
	 */
	public void setEdiid (java.lang.String ediid) {
		this.ediid = ediid;
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
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
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
	 * Return the value associated with the column: edistatus
	 */
	public java.lang.String getEdistatus () {
		return edistatus;
	}

	/**
	 * Set the value related to the column: edistatus
	 * @param edistatus the edistatus value
	 */
	public void setEdistatus (java.lang.String edistatus) {
		this.edistatus = edistatus;
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
	public java.lang.String getDeleteflag () {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param deleteflag the deleteflag value
	 */
	public void setDeleteflag (java.lang.String deleteflag) {
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.edi.Ediinbound)) return false;
		else {
			com.bureaueye.beacon.model.edi.Ediinbound ediinbound = (com.bureaueye.beacon.model.edi.Ediinbound) obj;
			if (null == this.getEdiinboundId() || null == ediinbound.getEdiinboundId()) return false;
			else return (this.getEdiinboundId().equals(ediinbound.getEdiinboundId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getEdiinboundId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getEdiinboundId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}