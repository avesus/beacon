package com.bureaueye.beacon.model.account.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the aiout table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="aiout"
 */

public abstract class BaseAiout  implements Serializable {

	public static String REF = "Aiout";
	public static String PROP_AISTATUS = "Aistatus";
	public static String PROP_ACKREQFLAG = "Ackreqflag";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ACTIONCODE = "Actioncode";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_WARNINGS = "Warnings";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_AIBATCH_ID = "AibatchId";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_FADATE = "Fadate";
	public static String PROP_PROCESSSTATUS = "Processstatus";
	public static String PROP_TESTFLAG = "Testflag";
	public static String PROP_AIOUT_ID = "AioutId";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CONTROLID = "Controlid";
	public static String PROP_FAID = "Faid";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SENTTIME = "Senttime";
	public static String PROP_FATIME = "Fatime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_COMPANYID = "Companyid";
	public static String PROP_ERRORS = "Errors";
	public static String PROP_SENTDATE = "Sentdate";
	public static String PROP_DOCTYPE = "Doctype";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_AIID = "Aiid";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseAiout () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAiout (java.lang.Integer aioutId) {
		this.setAioutId(aioutId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer aioutId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String aistatus;
	private java.lang.String activitykey;
	private java.util.Date deletedate;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.String systemlogaction;
	private java.lang.Integer aibatchId;
	private java.lang.String createtime;
	private boolean testflag;
	private java.lang.String document;
	private java.lang.String errors;
	private java.lang.String warnings;
	private java.lang.String senttime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.String aiid;
	private java.lang.String faid;
	private java.lang.String controlid;
	private java.lang.String companykey;
	private boolean ackreqflag;
	private java.lang.String deletetime;
	private java.lang.String fatime;
	private java.util.Date fadate;
	private java.lang.String systemlogprogram;
	private java.lang.String dockey;
	private java.lang.String filename;
	private java.util.Date sentdate;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.String doctype;
	private java.lang.Integer rowid;
	private boolean deleteflag;
	private java.lang.String companyid;
	private java.lang.String processstatus;
	private java.lang.String actioncode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="AIOUT_ID"
     */
	public java.lang.Integer getAioutId () {
		return aioutId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param aioutId the new ID
	 */
	public void setAioutId (java.lang.Integer aioutId) {
		this.aioutId = aioutId;
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
	 * Return the value associated with the column: aistatus
	 */
	public java.lang.String getAistatus () {
		return aistatus;
	}

	/**
	 * Set the value related to the column: aistatus
	 * @param aistatus the aistatus value
	 */
	public void setAistatus (java.lang.String aistatus) {
		this.aistatus = aistatus;
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
	 * Return the value associated with the column: AIBATCH_ID
	 */
	public java.lang.Integer getAibatchId () {
		return aibatchId;
	}

	/**
	 * Set the value related to the column: AIBATCH_ID
	 * @param aibatchId the AIBATCH_ID value
	 */
	public void setAibatchId (java.lang.Integer aibatchId) {
		this.aibatchId = aibatchId;
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
	 * Return the value associated with the column: testflag
	 */
	public boolean isTestflag () {
		return testflag;
	}

	/**
	 * Set the value related to the column: testflag
	 * @param testflag the testflag value
	 */
	public void setTestflag (boolean testflag) {
		this.testflag = testflag;
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
	 * Return the value associated with the column: senttime
	 */
	public java.lang.String getSenttime () {
		return senttime;
	}

	/**
	 * Set the value related to the column: senttime
	 * @param senttime the senttime value
	 */
	public void setSenttime (java.lang.String senttime) {
		this.senttime = senttime;
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
	 * Return the value associated with the column: aiid
	 */
	public java.lang.String getAiid () {
		return aiid;
	}

	/**
	 * Set the value related to the column: aiid
	 * @param aiid the aiid value
	 */
	public void setAiid (java.lang.String aiid) {
		this.aiid = aiid;
	}



	/**
	 * Return the value associated with the column: faid
	 */
	public java.lang.String getFaid () {
		return faid;
	}

	/**
	 * Set the value related to the column: faid
	 * @param faid the faid value
	 */
	public void setFaid (java.lang.String faid) {
		this.faid = faid;
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
	 * Return the value associated with the column: ackreqflag
	 */
	public boolean isAckreqflag () {
		return ackreqflag;
	}

	/**
	 * Set the value related to the column: ackreqflag
	 * @param ackreqflag the ackreqflag value
	 */
	public void setAckreqflag (boolean ackreqflag) {
		this.ackreqflag = ackreqflag;
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
	 * Return the value associated with the column: fatime
	 */
	public java.lang.String getFatime () {
		return fatime;
	}

	/**
	 * Set the value related to the column: fatime
	 * @param fatime the fatime value
	 */
	public void setFatime (java.lang.String fatime) {
		this.fatime = fatime;
	}



	/**
	 * Return the value associated with the column: fadate
	 */
	public java.util.Date getFadate () {
		return fadate;
	}

	/**
	 * Set the value related to the column: fadate
	 * @param fadate the fadate value
	 */
	public void setFadate (java.util.Date fadate) {
		this.fadate = fadate;
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
	 * Return the value associated with the column: sentdate
	 */
	public java.util.Date getSentdate () {
		return sentdate;
	}

	/**
	 * Set the value related to the column: sentdate
	 * @param sentdate the sentdate value
	 */
	public void setSentdate (java.util.Date sentdate) {
		this.sentdate = sentdate;
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
	 * Return the value associated with the column: companyid
	 */
	public java.lang.String getCompanyid () {
		return companyid;
	}

	/**
	 * Set the value related to the column: companyid
	 * @param companyid the companyid value
	 */
	public void setCompanyid (java.lang.String companyid) {
		this.companyid = companyid;
	}



	/**
	 * Return the value associated with the column: processstatus
	 */
	public java.lang.String getProcessstatus () {
		return processstatus;
	}

	/**
	 * Set the value related to the column: processstatus
	 * @param processstatus the processstatus value
	 */
	public void setProcessstatus (java.lang.String processstatus) {
		this.processstatus = processstatus;
	}



	/**
	 * Return the value associated with the column: actioncode
	 */
	public java.lang.String getActioncode () {
		return actioncode;
	}

	/**
	 * Set the value related to the column: actioncode
	 * @param actioncode the actioncode value
	 */
	public void setActioncode (java.lang.String actioncode) {
		this.actioncode = actioncode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.account.Aiout)) return false;
		else {
			com.bureaueye.beacon.model.account.Aiout aiout = (com.bureaueye.beacon.model.account.Aiout) obj;
			if (null == this.getAioutId() || null == aiout.getAioutId()) return false;
			else return (this.getAioutId().equals(aiout.getAioutId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAioutId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAioutId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}