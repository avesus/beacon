package com.bureaueye.beacon.model.order.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orderfile table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orderfile"
 */

public abstract class BaseOrderfile  implements Serializable {

	public static String REF = "Orderfile";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ORDERFILE_ID = "OrderfileId";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_CONTENTTYPE = "Contenttype";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_FILEBIN = "Filebin";
	public static String PROP_FILESIZE = "Filesize";
	public static String PROP_ORDERNOTE_ID = "OrdernoteId";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseOrderfile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderfile (java.lang.Integer orderfileId) {
		this.setOrderfileId(orderfileId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer orderfileId;

	// fields
	private java.lang.String filename;
	private java.lang.String description;
	private java.lang.String contenttype;
	private java.sql.Blob filebin;
	private java.lang.Integer filesize;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogtime;
	private java.lang.String systemloguserid;
	private java.lang.String xlock;
	private java.lang.String xinactive;
	private java.lang.Integer rowid;
	private java.lang.Integer ordernoteId;
	private java.lang.Integer orderhdrId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERFILE_ID"
     */
	public java.lang.Integer getOrderfileId () {
		return orderfileId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param orderfileId the new ID
	 */
	public void setOrderfileId (java.lang.Integer orderfileId) {
		this.orderfileId = orderfileId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: ORDERNOTE_ID
	 */
	public java.lang.Integer getOrdernoteId () {
		return ordernoteId;
	}

	/**
	 * Set the value related to the column: ORDERNOTE_ID
	 * @param ordernoteId the ORDERNOTE_ID value
	 */
	public void setOrdernoteId (java.lang.Integer ordernoteId) {
		this.ordernoteId = ordernoteId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.order.Orderfile)) return false;
		else {
			com.bureaueye.beacon.model.order.Orderfile orderfile = (com.bureaueye.beacon.model.order.Orderfile) obj;
			if (null == this.getOrderfileId() || null == orderfile.getOrderfileId()) return false;
			else return (this.getOrderfileId().equals(orderfile.getOrderfileId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOrderfileId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOrderfileId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}