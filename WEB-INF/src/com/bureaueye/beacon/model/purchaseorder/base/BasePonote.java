package com.bureaueye.beacon.model.purchaseorder.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ponote table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ponote"
 */

public abstract class BasePonote  implements Serializable {

	public static String REF = "Ponote";
	public static String PROP_PONOTE_ID = "PonoteId";
	public static String PROP_NOTE1 = "Note1";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_POHDR_ID = "PohdrId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_PONO = "Pono";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_NOTE2 = "Note2";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BasePonote () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePonote (java.lang.Integer ponoteId) {
		this.setPonoteId(ponoteId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer ponoteId;

	// fields
	private java.util.Date systemlogdate;
	private java.lang.String status;
	private java.lang.String xlock;
	private java.lang.String pono;
	private java.lang.String note1;
	private java.lang.String createtime;
	private java.lang.String systemlogaction;
	private java.lang.Integer pohdrId;
	private java.lang.String createuserid;
	private java.lang.String systemlogprogram;
	private java.lang.String category;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.String priority;
	private java.lang.String note2;
	private java.lang.String systemloguserid;
	private boolean deleteflag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PONOTE_ID"
     */
	public java.lang.Integer getPonoteId () {
		return ponoteId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ponoteId the new ID
	 */
	public void setPonoteId (java.lang.Integer ponoteId) {
		this.ponoteId = ponoteId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: pono
	 */
	public java.lang.String getPono () {
		return pono;
	}

	/**
	 * Set the value related to the column: pono
	 * @param pono the pono value
	 */
	public void setPono (java.lang.String pono) {
		this.pono = pono;
	}



	/**
	 * Return the value associated with the column: note1
	 */
	public java.lang.String getNote1 () {
		return note1;
	}

	/**
	 * Set the value related to the column: note1
	 * @param note1 the note1 value
	 */
	public void setNote1 (java.lang.String note1) {
		this.note1 = note1;
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
	 * Return the value associated with the column: POHDR_ID
	 */
	public java.lang.Integer getPohdrId () {
		return pohdrId;
	}

	/**
	 * Set the value related to the column: POHDR_ID
	 * @param pohdrId the POHDR_ID value
	 */
	public void setPohdrId (java.lang.Integer pohdrId) {
		this.pohdrId = pohdrId;
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
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
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
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: note2
	 */
	public java.lang.String getNote2 () {
		return note2;
	}

	/**
	 * Set the value related to the column: note2
	 * @param note2 the note2 value
	 */
	public void setNote2 (java.lang.String note2) {
		this.note2 = note2;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseorder.Ponote)) return false;
		else {
			com.bureaueye.beacon.model.purchaseorder.Ponote ponote = (com.bureaueye.beacon.model.purchaseorder.Ponote) obj;
			if (null == this.getPonoteId() || null == ponote.getPonoteId()) return false;
			else return (this.getPonoteId().equals(ponote.getPonoteId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPonoteId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPonoteId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}