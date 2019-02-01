package com.bureaueye.beacon.model.purchaseorder.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pohdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pohdr"
 */

public abstract class BasePohdr  implements Serializable {

	public static String REF = "Pohdr";
	public static String PROP_TAXCODE = "Taxcode";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_PRINTDATE = "Printdate";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_PRINTTIME = "Printtime";
	public static String PROP_POHDR_ID = "PohdrId";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SHIPVIA = "Shipvia";
	public static String PROP_POSTATUS = "Postatus";
	public static String PROP_TAXRATE = "Taxrate";
	public static String PROP_TOTALAMT = "Totalamt";
	public static String PROP_WORKORDERNO = "Workorderno";
	public static String PROP_PRINTEDFLAG = "Printedflag";
	public static String PROP_SHIPTOLOCATIONKEY = "Shiptolocationkey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_PAYMENTTERM = "Paymentterm";
	public static String PROP_POSTEDFLAG = "Postedflag";
	public static String PROP_WORKORDERTYPE = "Workordertype";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_PERIODPOSTED = "Periodposted";
	public static String PROP_DELETEFLAG = "Deleteflag";
	public static String PROP_SHIPPINGAMT = "Shippingamt";
	public static String PROP_TAXAMT = "Taxamt";
	public static String PROP_REJECTREASON = "Rejectreason";
	public static String PROP_LANGUAGEKEY = "Languagekey";
	public static String PROP_DELIVERYDATE = "Deliverydate";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_POSTEDDATE = "Posteddate";
	public static String PROP_PONO = "Pono";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SUBMITTEDFOR = "Submittedfor";
	public static String PROP_CONFIRMEDFLAG = "Confirmedflag";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_SUBTOTALAMT = "Subtotalamt";


	// constructors
	public BasePohdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePohdr (java.lang.Integer pohdrId) {
		this.setPohdrId(pohdrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer pohdrId;

	// fields
	private java.lang.String departmentkey;
	private java.util.Date systemlogdate;
	private java.lang.String periodposted;
	private java.lang.String activitykey;
	private java.lang.String ccykey;
	private java.util.Date createdate;
	private java.lang.String xlock;
	private java.lang.String pono;
	private java.lang.String workorderno;
	private java.lang.String workordertype;
	private java.util.Date deliverydate;
	private java.lang.String systemlogaction;
	private java.util.Date posteddate;
	private java.lang.String createtime;
	private java.math.BigDecimal taxrate;
	private java.math.BigDecimal totalamt;
	private java.math.BigDecimal shippingamt;
	private java.lang.String printtime;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.String shipvia;
	private boolean printedflag;
	private java.lang.String languagekey;
	private java.math.BigDecimal subtotalamt;
	private boolean postedflag;
	private java.util.Date printdate;
	private java.lang.String companykey;
	private java.lang.String paymentterm;
	private boolean confirmedflag;
	private java.lang.String submittedfor;
	private java.lang.String rejectreason;
	private java.lang.String txt1;
	private java.lang.String systemlogprogram;
	private java.lang.String txt2;
	private java.lang.String postatus;
	private java.math.BigDecimal taxamt;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private boolean deleteflag;
	private java.lang.String taxcode;
	private java.lang.String vendoraddrkey;
	private java.lang.String shiptolocationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="POHDR_ID"
     */
	public java.lang.Integer getPohdrId () {
		return pohdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pohdrId the new ID
	 */
	public void setPohdrId (java.lang.Integer pohdrId) {
		this.pohdrId = pohdrId;
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
	 * Return the value associated with the column: workorderno
	 */
	public java.lang.String getWorkorderno () {
		return workorderno;
	}

	/**
	 * Set the value related to the column: workorderno
	 * @param workorderno the workorderno value
	 */
	public void setWorkorderno (java.lang.String workorderno) {
		this.workorderno = workorderno;
	}



	/**
	 * Return the value associated with the column: workordertype
	 */
	public java.lang.String getWorkordertype () {
		return workordertype;
	}

	/**
	 * Set the value related to the column: workordertype
	 * @param workordertype the workordertype value
	 */
	public void setWorkordertype (java.lang.String workordertype) {
		this.workordertype = workordertype;
	}



	/**
	 * Return the value associated with the column: deliverydate
	 */
	public java.util.Date getDeliverydate () {
		return deliverydate;
	}

	/**
	 * Set the value related to the column: deliverydate
	 * @param deliverydate the deliverydate value
	 */
	public void setDeliverydate (java.util.Date deliverydate) {
		this.deliverydate = deliverydate;
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
	 * Return the value associated with the column: taxrate
	 */
	public java.math.BigDecimal getTaxrate () {
		return taxrate;
	}

	/**
	 * Set the value related to the column: taxrate
	 * @param taxrate the taxrate value
	 */
	public void setTaxrate (java.math.BigDecimal taxrate) {
		this.taxrate = taxrate;
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
	 * Return the value associated with the column: shippingamt
	 */
	public java.math.BigDecimal getShippingamt () {
		return shippingamt;
	}

	/**
	 * Set the value related to the column: shippingamt
	 * @param shippingamt the shippingamt value
	 */
	public void setShippingamt (java.math.BigDecimal shippingamt) {
		this.shippingamt = shippingamt;
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
	 * Return the value associated with the column: shipvia
	 */
	public java.lang.String getShipvia () {
		return shipvia;
	}

	/**
	 * Set the value related to the column: shipvia
	 * @param shipvia the shipvia value
	 */
	public void setShipvia (java.lang.String shipvia) {
		this.shipvia = shipvia;
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
	 * Return the value associated with the column: subtotalamt
	 */
	public java.math.BigDecimal getSubtotalamt () {
		return subtotalamt;
	}

	/**
	 * Set the value related to the column: subtotalamt
	 * @param subtotalamt the subtotalamt value
	 */
	public void setSubtotalamt (java.math.BigDecimal subtotalamt) {
		this.subtotalamt = subtotalamt;
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
	 * Return the value associated with the column: paymentterm
	 */
	public java.lang.String getPaymentterm () {
		return paymentterm;
	}

	/**
	 * Set the value related to the column: paymentterm
	 * @param paymentterm the paymentterm value
	 */
	public void setPaymentterm (java.lang.String paymentterm) {
		this.paymentterm = paymentterm;
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
	 * Return the value associated with the column: submittedfor
	 */
	public java.lang.String getSubmittedfor () {
		return submittedfor;
	}

	/**
	 * Set the value related to the column: submittedfor
	 * @param submittedfor the submittedfor value
	 */
	public void setSubmittedfor (java.lang.String submittedfor) {
		this.submittedfor = submittedfor;
	}



	/**
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason () {
		return rejectreason;
	}

	/**
	 * Set the value related to the column: rejectreason
	 * @param rejectreason the rejectreason value
	 */
	public void setRejectreason (java.lang.String rejectreason) {
		this.rejectreason = rejectreason;
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
	 * Return the value associated with the column: postatus
	 */
	public java.lang.String getPostatus () {
		return postatus;
	}

	/**
	 * Set the value related to the column: postatus
	 * @param postatus the postatus value
	 */
	public void setPostatus (java.lang.String postatus) {
		this.postatus = postatus;
	}



	/**
	 * Return the value associated with the column: taxamt
	 */
	public java.math.BigDecimal getTaxamt () {
		return taxamt;
	}

	/**
	 * Set the value related to the column: taxamt
	 * @param taxamt the taxamt value
	 */
	public void setTaxamt (java.math.BigDecimal taxamt) {
		this.taxamt = taxamt;
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
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * @param taxcode the taxcode value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: shiptolocationkey
	 */
	public java.lang.String getShiptolocationkey () {
		return shiptolocationkey;
	}

	/**
	 * Set the value related to the column: shiptolocationkey
	 * @param shiptolocationkey the shiptolocationkey value
	 */
	public void setShiptolocationkey (java.lang.String shiptolocationkey) {
		this.shiptolocationkey = shiptolocationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.purchaseorder.Pohdr)) return false;
		else {
			com.bureaueye.beacon.model.purchaseorder.Pohdr pohdr = (com.bureaueye.beacon.model.purchaseorder.Pohdr) obj;
			if (null == this.getPohdrId() || null == pohdr.getPohdrId()) return false;
			else return (this.getPohdrId().equals(pohdr.getPohdrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPohdrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPohdrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}