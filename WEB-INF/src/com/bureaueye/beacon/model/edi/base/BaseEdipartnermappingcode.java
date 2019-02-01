package com.bureaueye.beacon.model.edi.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the edipartnermappingcode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="edipartnermappingcode"
 */

public abstract class BaseEdipartnermappingcode  implements Serializable {

	public static String REF = "Edipartnermappingcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_CODETYPE = "Codetype";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_EDIPARTNERMAPPINGCODE_ID = "EdipartnermappingcodeId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_DELETETIME = "Deletetime";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_EDIID = "Ediid";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_DELETEDATE = "Deletedate";
	public static String PROP_PARTNERCODE = "Partnercode";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_ITTCODE = "Ittcode";


	// constructors
	public BaseEdipartnermappingcode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEdipartnermappingcode (java.lang.Integer edipartnermappingcodeId) {
		this.setEdipartnermappingcodeId(edipartnermappingcodeId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEdipartnermappingcode (
		java.lang.Integer edipartnermappingcodeId,
		java.lang.String ediid) {

		this.setEdipartnermappingcodeId(edipartnermappingcodeId);
		this.setEdiid(ediid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer edipartnermappingcodeId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String ittcode;
	private java.lang.String ediid;
	private java.lang.String createuserid;
	private boolean deleteflag;
	private java.lang.String departmentkey;
	private java.lang.String codetype;
	private java.lang.String partnercode;
	private java.util.Date deletedate;
	private boolean xinactive;
	private java.lang.String deletetime;
	private java.lang.String companykey;
	private java.lang.Integer rowid;
	private java.lang.String systemlogtime;
	private java.lang.String activitykey;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="EDIPARTNERMAPPINGCODE_ID"
     */
	public java.lang.Integer getEdipartnermappingcodeId () {
		return edipartnermappingcodeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param edipartnermappingcodeId the new ID
	 */
	public void setEdipartnermappingcodeId (java.lang.Integer edipartnermappingcodeId) {
		this.edipartnermappingcodeId = edipartnermappingcodeId;
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
	 * Return the value associated with the column: ittcode
	 */
	public java.lang.String getIttcode () {
		return ittcode;
	}

	/**
	 * Set the value related to the column: ittcode
	 * @param ittcode the ittcode value
	 */
	public void setIttcode (java.lang.String ittcode) {
		this.ittcode = ittcode;
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
	 * Return the value associated with the column: codetype
	 */
	public java.lang.String getCodetype () {
		return codetype;
	}

	/**
	 * Set the value related to the column: codetype
	 * @param codetype the codetype value
	 */
	public void setCodetype (java.lang.String codetype) {
		this.codetype = codetype;
	}



	/**
	 * Return the value associated with the column: partnercode
	 */
	public java.lang.String getPartnercode () {
		return partnercode;
	}

	/**
	 * Set the value related to the column: partnercode
	 * @param partnercode the partnercode value
	 */
	public void setPartnercode (java.lang.String partnercode) {
		this.partnercode = partnercode;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.edi.Edipartnermappingcode)) return false;
		else {
			com.bureaueye.beacon.model.edi.Edipartnermappingcode edipartnermappingcode = (com.bureaueye.beacon.model.edi.Edipartnermappingcode) obj;
			if (null == this.getEdipartnermappingcodeId() || null == edipartnermappingcode.getEdipartnermappingcodeId()) return false;
			else return (this.getEdipartnermappingcodeId().equals(edipartnermappingcode.getEdipartnermappingcodeId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getEdipartnermappingcodeId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getEdipartnermappingcodeId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}