package com.bureaueye.beacon.model.purchaseorder.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the podtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="podtl"
 */

public abstract class BasePodtl  implements Serializable {

	public static String REF = "Podtl";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_PODTL_ID = "PodtlId";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_PRINTDATE = "Printdate";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_PRINTTIME = "Printtime";
	public static String PROP_POHDR_ID = "PohdrId";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_QTYRCVD = "Qtyrcvd";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_QTY = "Qty";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_TOTALAMT = "Totalamt";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_PRINTEDFLAG = "Printedflag";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_GLCODE1 = "Glcode1";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_GLCODE4 = "Glcode4";
	public static String PROP_GLCODE3 = "Glcode3";
	public static String PROP_POSTEDFLAG = "Postedflag";
	public static String PROP_GLCODE2 = "Glcode2";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_PERIODPOSTED = "Periodposted";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_LANGUAGEKEY = "Languagekey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_POSTEDDATE = "Posteddate";
	public static String PROP_PONO = "Pono";
	public static String PROP_RATEAMT = "Rateamt";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CONFIRMEDFLAG = "Confirmedflag";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BasePodtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePodtl (java.lang.Integer podtlId) {
		this.setPodtlId(podtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer podtlId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String periodposted;
	private java.lang.String activitykey;
	private java.lang.String ccykey;
	private java.lang.String glcode1;
	private java.util.Date createdate;
	private java.lang.String xlock;
	private java.lang.String pono;
	private java.lang.String systemlogaction;
	private java.util.Date posteddate;
	private java.lang.Integer pohdrId;
	private java.lang.String createtime;
	private java.math.BigDecimal totalamt;
	private java.lang.String printtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.math.BigDecimal rateamt;
	private boolean printedflag;
	private java.lang.String languagekey;
	private boolean postedflag;
	private java.lang.Integer qtyrcvd;
	private java.util.Date printdate;
	private java.lang.String companykey;
	private boolean confirmedflag;
	private java.lang.Integer qty;
	private java.lang.String txt1;
	private java.lang.String systemlogprogram;
	private java.lang.String txt2;
	private java.lang.String glcode4;
	private java.lang.String createuserid;
	private java.lang.String glcode3;
	private java.lang.String glcode2;
	private java.lang.String systemloguserid;
	private boolean deleteflag;
	private java.lang.String eqpkeyp1;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.String eqpkeyp5;
	private java.lang.String eqpkeyp6;
	private java.lang.String eqpkeyp7;
	private java.lang.String eqpkeyp8;
	private java.lang.String eqpkeyp9;
	private java.lang.String eqpkeyp10;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PODTL_ID"
     */
	public java.lang.Integer getPodtlId () {
		return podtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param podtlId the new ID
	 */
	public void setPodtlId (java.lang.Integer podtlId) {
		this.podtlId = podtlId;
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
	 * Return the value associated with the column: periodposted
	 */
	public java.lang.String getPeriodposted () {
		return periodposted;
	}

	/**
	 * Set the value related to the column: periodposted
	 * @param periodposted the periodposted value
	 */
	public void setPeriodposted (java.lang.String periodposted) {
		this.periodposted = periodposted;
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
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
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
	 * Return the value associated with the column: posteddate
	 */
	public java.util.Date getPosteddate () {
		return posteddate;
	}

	/**
	 * Set the value related to the column: posteddate
	 * @param posteddate the posteddate value
	 */
	public void setPosteddate (java.util.Date posteddate) {
		this.posteddate = posteddate;
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
	 * Return the value associated with the column: totalamt
	 */
	public java.math.BigDecimal getTotalamt () {
		return totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (java.math.BigDecimal totalamt) {
		this.totalamt = totalamt;
	}



	/**
	 * Return the value associated with the column: printtime
	 */
	public java.lang.String getPrinttime () {
		return printtime;
	}

	/**
	 * Set the value related to the column: printtime
	 * @param printtime the printtime value
	 */
	public void setPrinttime (java.lang.String printtime) {
		this.printtime = printtime;
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
	 * Return the value associated with the column: rateamt
	 */
	public java.math.BigDecimal getRateamt () {
		return rateamt;
	}

	/**
	 * Set the value related to the column: rateamt
	 * @param rateamt the rateamt value
	 */
	public void setRateamt (java.math.BigDecimal rateamt) {
		this.rateamt = rateamt;
	}



	/**
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag () {
		return printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * @param printedflag the printedflag value
	 */
	public void setPrintedflag (boolean printedflag) {
		this.printedflag = printedflag;
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
	 * Return the value associated with the column: postedflag
	 */
	public boolean isPostedflag () {
		return postedflag;
	}

	/**
	 * Set the value related to the column: postedflag
	 * @param postedflag the postedflag value
	 */
	public void setPostedflag (boolean postedflag) {
		this.postedflag = postedflag;
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
	 * Return the value associated with the column: printdate
	 */
	public java.util.Date getPrintdate () {
		return printdate;
	}

	/**
	 * Set the value related to the column: printdate
	 * @param printdate the printdate value
	 */
	public void setPrintdate (java.util.Date printdate) {
		this.printdate = printdate;
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
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.lang.Integer qty) {
		this.qty = qty;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseorder.Podtl)) return false;
		else {
			com.bureaueye.beacon.model.purchaseorder.Podtl podtl = (com.bureaueye.beacon.model.purchaseorder.Podtl) obj;
			if (null == this.getPodtlId() || null == podtl.getPodtlId()) return false;
			else return (this.getPodtlId().equals(podtl.getPodtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPodtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPodtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}