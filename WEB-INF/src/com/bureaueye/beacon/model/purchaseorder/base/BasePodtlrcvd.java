package com.bureaueye.beacon.model.purchaseorder.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the podtlrcvd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="podtlrcvd"
 */

public abstract class BasePodtlrcvd  implements Serializable {

	public static String REF = "Podtlrcvd";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_PODTL_ID = "PodtlId";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_SHIPMENTNO = "Shipmentno";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_QTYRCVD = "Qtyrcvd";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_GLCODE1 = "Glcode1";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_UNITGENERATEDFLAG = "Unitgeneratedflag";
	public static String PROP_GLCODE4 = "Glcode4";
	public static String PROP_GLCODE3 = "Glcode3";
	public static String PROP_GLCODE2 = "Glcode2";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_PODTLRCVD_ID = "PodtlrcvdId";
	public static String PROP_LANGUAGEKEY = "Languagekey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_PONO = "Pono";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CONFIRMEDFLAG = "Confirmedflag";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_RCVDDATE = "Rcvddate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_TXT1 = "Txt1";


	// constructors
	public BasePodtlrcvd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePodtlrcvd (java.lang.Integer podtlrcvdId) {
		this.setPodtlrcvdId(podtlrcvdId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer podtlrcvdId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String activitykey;
	private java.lang.String glcode1;
	private java.util.Date createdate;
	private java.lang.String pono;
	private java.lang.String xlock;
	private java.lang.String systemlogaction;
	private java.lang.String createtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.String languagekey;
	private boolean unitgeneratedflag;
	private java.lang.Integer podtlId;
	private java.lang.String shipmentno;
	private java.lang.Integer qtyrcvd;
	private java.lang.String companykey;
	private boolean confirmedflag;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String systemlogprogram;
	private java.util.Date rcvddate;
	private java.lang.String glcode4;
	private java.lang.String createuserid;
	private java.lang.String glcode3;
	private java.lang.String glcode2;
	private java.lang.String systemloguserid;
	private boolean deleteflag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PODTLRCVD_ID"
     */
	public java.lang.Integer getPodtlrcvdId () {
		return podtlrcvdId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param podtlrcvdId the new ID
	 */
	public void setPodtlrcvdId (java.lang.Integer podtlrcvdId) {
		this.podtlrcvdId = podtlrcvdId;
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
	 * Return the value associated with the column: glcode1
	 */
	public java.lang.String getGlcode1 () {
		return glcode1;
	}

	/**
	 * Set the value related to the column: glcode1
	 * @param glcode1 the glcode1 value
	 */
	public void setGlcode1 (java.lang.String glcode1) {
		this.glcode1 = glcode1;
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
	 * Return the value associated with the column: languagekey
	 */
	public java.lang.String getLanguagekey () {
		return languagekey;
	}

	/**
	 * Set the value related to the column: languagekey
	 * @param languagekey the languagekey value
	 */
	public void setLanguagekey (java.lang.String languagekey) {
		this.languagekey = languagekey;
	}



	/**
	 * Return the value associated with the column: unitgeneratedflag
	 */
	public boolean isUnitgeneratedflag () {
		return unitgeneratedflag;
	}

	/**
	 * Set the value related to the column: unitgeneratedflag
	 * @param unitgeneratedflag the unitgeneratedflag value
	 */
	public void setUnitgeneratedflag (boolean unitgeneratedflag) {
		this.unitgeneratedflag = unitgeneratedflag;
	}



	/**
	 * Return the value associated with the column: PODTL_ID
	 */
	public java.lang.Integer getPodtlId () {
		return podtlId;
	}

	/**
	 * Set the value related to the column: PODTL_ID
	 * @param podtlId the PODTL_ID value
	 */
	public void setPodtlId (java.lang.Integer podtlId) {
		this.podtlId = podtlId;
	}



	/**
	 * Return the value associated with the column: shipmentno
	 */
	public java.lang.String getShipmentno () {
		return shipmentno;
	}

	/**
	 * Set the value related to the column: shipmentno
	 * @param shipmentno the shipmentno value
	 */
	public void setShipmentno (java.lang.String shipmentno) {
		this.shipmentno = shipmentno;
	}



	/**
	 * Return the value associated with the column: qtyrcvd
	 */
	public java.lang.Integer getQtyrcvd () {
		return qtyrcvd;
	}

	/**
	 * Set the value related to the column: qtyrcvd
	 * @param qtyrcvd the qtyrcvd value
	 */
	public void setQtyrcvd (java.lang.Integer qtyrcvd) {
		this.qtyrcvd = qtyrcvd;
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
	 * Return the value associated with the column: confirmedflag
	 */
	public boolean isConfirmedflag () {
		return confirmedflag;
	}

	/**
	 * Set the value related to the column: confirmedflag
	 * @param confirmedflag the confirmedflag value
	 */
	public void setConfirmedflag (boolean confirmedflag) {
		this.confirmedflag = confirmedflag;
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
	 * Return the value associated with the column: rcvddate
	 */
	public java.util.Date getRcvddate () {
		return rcvddate;
	}

	/**
	 * Set the value related to the column: rcvddate
	 * @param rcvddate the rcvddate value
	 */
	public void setRcvddate (java.util.Date rcvddate) {
		this.rcvddate = rcvddate;
	}



	/**
	 * Return the value associated with the column: glcode4
	 */
	public java.lang.String getGlcode4 () {
		return glcode4;
	}

	/**
	 * Set the value related to the column: glcode4
	 * @param glcode4 the glcode4 value
	 */
	public void setGlcode4 (java.lang.String glcode4) {
		this.glcode4 = glcode4;
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
	 * Return the value associated with the column: glcode3
	 */
	public java.lang.String getGlcode3 () {
		return glcode3;
	}

	/**
	 * Set the value related to the column: glcode3
	 * @param glcode3 the glcode3 value
	 */
	public void setGlcode3 (java.lang.String glcode3) {
		this.glcode3 = glcode3;
	}



	/**
	 * Return the value associated with the column: glcode2
	 */
	public java.lang.String getGlcode2 () {
		return glcode2;
	}

	/**
	 * Set the value related to the column: glcode2
	 * @param glcode2 the glcode2 value
	 */
	public void setGlcode2 (java.lang.String glcode2) {
		this.glcode2 = glcode2;
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
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseorder.Podtlrcvd)) return false;
		else {
			com.bureaueye.beacon.model.purchaseorder.Podtlrcvd podtlrcvd = (com.bureaueye.beacon.model.purchaseorder.Podtlrcvd) obj;
			if (null == this.getPodtlrcvdId() || null == podtlrcvd.getPodtlrcvdId()) return false;
			else return (this.getPodtlrcvdId().equals(podtlrcvd.getPodtlrcvdId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPodtlrcvdId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPodtlrcvdId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}