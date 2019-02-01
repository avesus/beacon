package com.bureaueye.genesys.model.contract.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the contract table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contract"
 */

public abstract class BaseContract  implements Serializable {

	public static String REF = "Contract";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_BILLFREQTYPE = "Billfreqtype";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_NOTICEDAYS = "Noticedays";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CONTRACTNO = "Contractno";
	public static String PROP_VERSIONDATE = "Versiondate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_BILLCCYKEY = "Billccykey";
	public static String PROP_BILLTYPE = "Billtype";
	public static String PROP_CONTRACTDATE = "Contractdate";
	public static String PROP_PERIODENDDATE = "Periodenddate";
	public static String PROP_BILLAMEND = "Billamend";
	public static String PROP_BILLFREQNUM = "Billfreqnum";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_VERSIONNO = "Versionno";
	public static String PROP_SUBMITTEDBY = "Submittedby";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_LEASETYPEKEY = "Leasetypekey";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SIGNEDDATE = "Signeddate";
	public static String PROP_NOTES = "Notes";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_PERIODSTARTDATE = "Periodstartdate";
	public static String PROP_SUBMITTEDDATE = "Submitteddate";


	// constructors
	public BaseContract () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContract (java.lang.Integer contractId) {
		this.setContractId(contractId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer contractId;

	// fields
	private java.lang.String comments;
	private java.lang.String billfreqtype;
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String billtype;
	private java.lang.String departmentkey;
	private boolean xinactive;
	private java.util.Date periodenddate;
	private java.lang.String billccykey;
	private java.lang.String systemloglock;
	private java.util.Date contractdate;
	private java.lang.String companykey;
	private java.lang.String systemlogtime;
	private java.lang.String notes;
	private java.lang.String submittedby;
	private java.util.Date submitteddate;
	private java.util.Date signeddate;
	private java.util.Date periodstartdate;
	private java.lang.String leasetypekey;
	private java.lang.String createuserid;
	private java.util.Date versiondate;
	private boolean billamend;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String contractno;
	private java.lang.String activitykey;
	private java.lang.Integer versionno;
	private java.lang.Integer noticedays;
	private java.lang.Integer billfreqnum;
	private java.lang.String xlock;
	private java.lang.String lesseeaddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACT_ID"
     */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contractId the new ID
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: billfreqtype
	 */
	public java.lang.String getBillfreqtype () {
		return billfreqtype;
	}

	/**
	 * Set the value related to the column: billfreqtype
	 * @param billfreqtype the billfreqtype value
	 */
	public void setBillfreqtype (java.lang.String billfreqtype) {
		this.billfreqtype = billfreqtype;
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
	 * Return the value associated with the column: billtype
	 */
	public java.lang.String getBilltype () {
		return billtype;
	}

	/**
	 * Set the value related to the column: billtype
	 * @param billtype the billtype value
	 */
	public void setBilltype (java.lang.String billtype) {
		this.billtype = billtype;
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
	 * Return the value associated with the column: periodenddate
	 */
	public java.util.Date getPeriodenddate () {
		return periodenddate;
	}

	/**
	 * Set the value related to the column: periodenddate
	 * @param periodenddate the periodenddate value
	 */
	public void setPeriodenddate (java.util.Date periodenddate) {
		this.periodenddate = periodenddate;
	}



	/**
	 * Return the value associated with the column: billccykey
	 */
	public java.lang.String getBillccykey () {
		return billccykey;
	}

	/**
	 * Set the value related to the column: billccykey
	 * @param billccykey the billccykey value
	 */
	public void setBillccykey (java.lang.String billccykey) {
		this.billccykey = billccykey;
	}



	/**
	 * Return the value associated with the column: systemloglock
	 */
	public java.lang.String getSystemloglock () {
		return systemloglock;
	}

	/**
	 * Set the value related to the column: systemloglock
	 * @param systemloglock the systemloglock value
	 */
	public void setSystemloglock (java.lang.String systemloglock) {
		this.systemloglock = systemloglock;
	}



	/**
	 * Return the value associated with the column: contractdate
	 */
	public java.util.Date getContractdate () {
		return contractdate;
	}

	/**
	 * Set the value related to the column: contractdate
	 * @param contractdate the contractdate value
	 */
	public void setContractdate (java.util.Date contractdate) {
		this.contractdate = contractdate;
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
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String submittedby) {
		this.submittedby = submittedby;
	}



	/**
	 * Return the value associated with the column: submitteddate
	 */
	public java.util.Date getSubmitteddate () {
		return submitteddate;
	}

	/**
	 * Set the value related to the column: submitteddate
	 * @param submitteddate the submitteddate value
	 */
	public void setSubmitteddate (java.util.Date submitteddate) {
		this.submitteddate = submitteddate;
	}



	/**
	 * Return the value associated with the column: signeddate
	 */
	public java.util.Date getSigneddate () {
		return signeddate;
	}

	/**
	 * Set the value related to the column: signeddate
	 * @param signeddate the signeddate value
	 */
	public void setSigneddate (java.util.Date signeddate) {
		this.signeddate = signeddate;
	}



	/**
	 * Return the value associated with the column: periodstartdate
	 */
	public java.util.Date getPeriodstartdate () {
		return periodstartdate;
	}

	/**
	 * Set the value related to the column: periodstartdate
	 * @param periodstartdate the periodstartdate value
	 */
	public void setPeriodstartdate (java.util.Date periodstartdate) {
		this.periodstartdate = periodstartdate;
	}



	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
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
	 * Return the value associated with the column: billamend
	 */
	public boolean isBillamend () {
		return billamend;
	}

	/**
	 * Set the value related to the column: billamend
	 * @param billamend the billamend value
	 */
	public void setBillamend (boolean billamend) {
		this.billamend = billamend;
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
	 * Return the value associated with the column: contractno
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: contractno
	 * @param contractno the contractno value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
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
	 * Return the value associated with the column: noticedays
	 */
	public java.lang.Integer getNoticedays () {
		return noticedays;
	}

	/**
	 * Set the value related to the column: noticedays
	 * @param noticedays the noticedays value
	 */
	public void setNoticedays (java.lang.Integer noticedays) {
		this.noticedays = noticedays;
	}



	/**
	 * Return the value associated with the column: billfreqnum
	 */
	public java.lang.Integer getBillfreqnum () {
		return billfreqnum;
	}

	/**
	 * Set the value related to the column: billfreqnum
	 * @param billfreqnum the billfreqnum value
	 */
	public void setBillfreqnum (java.lang.Integer billfreqnum) {
		this.billfreqnum = billfreqnum;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.contract.Contract)) return false;
		else {
			com.bureaueye.genesys.model.contract.Contract contract = (com.bureaueye.genesys.model.contract.Contract) obj;
			if (null == this.getContractId() || null == contract.getContractId()) return false;
			else return (this.getContractId().equals(contract.getContractId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getContractId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getContractId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}