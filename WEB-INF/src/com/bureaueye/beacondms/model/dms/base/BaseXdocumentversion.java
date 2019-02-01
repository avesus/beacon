package com.bureaueye.beacondms.model.dms.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the xdocumentversion table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="xdocumentversion"
 */

public abstract class BaseXdocumentversion  implements Serializable {

	public static String REF = "Xdocumentversion";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_XDOCUMENTVERSION_ID = "XdocumentversionId";
	public static String PROP_VERSIONTIME = "Versiontime";
	public static String PROP_CONTENTTYPE = "Contenttype";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_VERSIONDATE = "Versiondate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_FILESIZE = "Filesize";
	public static String PROP_FILEBIN = "Filebin";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_VERSIONUSERID = "Versionuserid";
	public static String PROP_DOCKEY = "Dockey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_VERSIONNO = "Versionno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CREATEACTION = "Createaction";
	public static String PROP_VERSIONDESCRIPTION = "Versiondescription";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseXdocumentversion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseXdocumentversion (java.lang.Integer xdocumentversionId) {
		this.setXdocumentversionId(xdocumentversionId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer xdocumentversionId;

	// fields
	private java.lang.String dockey;
	private java.lang.Integer versionno;
	private java.util.Date versiondate;
	private java.lang.String versiontime;
	private java.lang.String versionuserid;
	private java.lang.String versiondescription;
	private java.lang.String filename;
	private java.sql.Blob filebin;
	private java.lang.Integer filesize;
	private java.lang.String contenttype;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createaction;
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



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="XDOCUMENTVERSION_ID"
     */
	public java.lang.Integer getXdocumentversionId () {
		return xdocumentversionId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param xdocumentversionId the new ID
	 */
	public void setXdocumentversionId (java.lang.Integer xdocumentversionId) {
		this.xdocumentversionId = xdocumentversionId;
		this.hashCode = Integer.MIN_VALUE;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacondms.model.dms.Xdocumentversion)) return false;
		else {
			com.bureaueye.beacondms.model.dms.Xdocumentversion xdocumentversion = (com.bureaueye.beacondms.model.dms.Xdocumentversion) obj;
			if (null == this.getXdocumentversionId() || null == xdocumentversion.getXdocumentversionId()) return false;
			else return (this.getXdocumentversionId().equals(xdocumentversion.getXdocumentversionId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getXdocumentversionId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getXdocumentversionId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}