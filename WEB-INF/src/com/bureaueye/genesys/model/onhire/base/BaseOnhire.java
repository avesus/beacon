package com.bureaueye.genesys.model.onhire.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the onhire table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="onhire"
 */

public abstract class BaseOnhire  implements Serializable {

	public static String REF = "Onhire";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_MINDAYS = "Mindays";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LOCATIONKEY = "Locationkey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_FREEDAYS = "Freedays";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_ONHIRE_ID = "OnhireId";
	public static String PROP_CONTRACTNO = "Contractno";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_QTYOFUNITS = "Qtyofunits";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_ESTRELDATE = "Estreldate";
	public static String PROP_SUBMITTEDBY = "Submittedby";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_ONHIRENO = "Onhireno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_CONTRACTEQP_ID = "ContracteqpId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_OTHER = "Other";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_EQPKEY = "Eqpkey";
	public static String PROP_NOTES = "Notes";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_CONTRACTEQPLOC_ID = "ContracteqplocId";
	public static String PROP_RELEASEREF = "Releaseref";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_SUBMITTEDDATE = "Submitteddate";


	// constructors
	public BaseOnhire () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOnhire (java.lang.Integer onhireId) {
		this.setOnhireId(onhireId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer onhireId;

	// fields
	private java.lang.String departmentkey;
	private java.lang.String contractno;
	private java.util.Date systemlogdate;
	private java.lang.String eqpkeyp9;
	private java.lang.String activitykey;
	private java.lang.String other;
	private java.lang.String releaseref;
	private java.lang.String eqpkeyp6;
	private java.lang.String submittedby;
	private java.lang.Integer qtyofunits;
	private java.lang.String eqpkeyp5;
	private java.lang.String eqpkeyp8;
	private java.lang.String eqpkeyp7;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.Integer mindays;
	private java.lang.String eqpkeyp10;
	private java.lang.String systemlogaction;
	private java.util.Date estreldate;
	private java.lang.String createtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.Integer freedays;
	private java.lang.Integer contractId;
	private java.lang.Integer contracteqpId;
	private java.lang.Integer contracteqplocId;
	private java.lang.String companykey;
	private java.lang.String onhireno;
	private java.lang.String systemlogprogram;
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.String createuserid;
	private java.lang.String eqpkeyp1;
	private java.lang.String eqpkeyp2;
	private java.lang.String notes;
	private java.lang.String systemloguserid;
	private java.lang.String eqpkey;
	private java.lang.String comments;
	private java.util.Date submitteddate;
	private java.lang.String lesseeaddrkey;
	private java.lang.String locationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIRE_ID"
     */
	public java.lang.Integer getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param onhireId the new ID
	 */
	public void setOnhireId (java.lang.Integer onhireId) {
		this.onhireId = onhireId;
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
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String eqpkeyp9) {
		this.eqpkeyp9 = eqpkeyp9;
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
	 * Return the value associated with the column: other
	 */
	public java.lang.String getOther () {
		return other;
	}

	/**
	 * Set the value related to the column: other
	 * @param other the other value
	 */
	public void setOther (java.lang.String other) {
		this.other = other;
	}



	/**
	 * Return the value associated with the column: releaseref
	 */
	public java.lang.String getReleaseref () {
		return releaseref;
	}

	/**
	 * Set the value related to the column: releaseref
	 * @param releaseref the releaseref value
	 */
	public void setReleaseref (java.lang.String releaseref) {
		this.releaseref = releaseref;
	}



	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String eqpkeyp6) {
		this.eqpkeyp6 = eqpkeyp6;
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
	 * Return the value associated with the column: qtyofunits
	 */
	public java.lang.Integer getQtyofunits () {
		return qtyofunits;
	}

	/**
	 * Set the value related to the column: qtyofunits
	 * @param qtyofunits the qtyofunits value
	 */
	public void setQtyofunits (java.lang.Integer qtyofunits) {
		this.qtyofunits = qtyofunits;
	}



	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String eqpkeyp5) {
		this.eqpkeyp5 = eqpkeyp5;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String eqpkeyp8) {
		this.eqpkeyp8 = eqpkeyp8;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String eqpkeyp7) {
		this.eqpkeyp7 = eqpkeyp7;
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
	 * Return the value associated with the column: mindays
	 */
	public java.lang.Integer getMindays () {
		return mindays;
	}

	/**
	 * Set the value related to the column: mindays
	 * @param mindays the mindays value
	 */
	public void setMindays (java.lang.Integer mindays) {
		this.mindays = mindays;
	}



	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String eqpkeyp10) {
		this.eqpkeyp10 = eqpkeyp10;
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
	 * Return the value associated with the column: estreldate
	 */
	public java.util.Date getEstreldate () {
		return estreldate;
	}

	/**
	 * Set the value related to the column: estreldate
	 * @param estreldate the estreldate value
	 */
	public void setEstreldate (java.util.Date estreldate) {
		this.estreldate = estreldate;
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
	 * Return the value associated with the column: freedays
	 */
	public java.lang.Integer getFreedays () {
		return freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param freedays the freedays value
	 */
	public void setFreedays (java.lang.Integer freedays) {
		this.freedays = freedays;
	}



	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQP_ID
	 */
	public java.lang.Integer getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQP_ID
	 * @param contracteqpId the CONTRACTEQP_ID value
	 */
	public void setContracteqpId (java.lang.Integer contracteqpId) {
		this.contracteqpId = contracteqpId;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQPLOC_ID
	 */
	public java.lang.Integer getContracteqplocId () {
		return contracteqplocId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQPLOC_ID
	 * @param contracteqplocId the CONTRACTEQPLOC_ID value
	 */
	public void setContracteqplocId (java.lang.Integer contracteqplocId) {
		this.contracteqplocId = contracteqplocId;
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
	 * Return the value associated with the column: onhireno
	 */
	public java.lang.String getOnhireno () {
		return onhireno;
	}

	/**
	 * Set the value related to the column: onhireno
	 * @param onhireno the onhireno value
	 */
	public void setOnhireno (java.lang.String onhireno) {
		this.onhireno = onhireno;
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
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String eqpkeyp3) {
		this.eqpkeyp3 = eqpkeyp3;
	}



	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String eqpkeyp4) {
		this.eqpkeyp4 = eqpkeyp4;
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
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
	}



	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
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
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String eqpkey) {
		this.eqpkey = eqpkey;
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



	/**
	 * Return the value associated with the column: locationkey
	 */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.onhire.Onhire)) return false;
		else {
			com.bureaueye.genesys.model.onhire.Onhire onhire = (com.bureaueye.genesys.model.onhire.Onhire) obj;
			if (null == this.getOnhireId() || null == onhire.getOnhireId()) return false;
			else return (this.getOnhireId().equals(onhire.getOnhireId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOnhireId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOnhireId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}