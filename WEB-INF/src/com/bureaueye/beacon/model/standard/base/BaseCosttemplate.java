package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the costtemplate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="costtemplate"
 */

public abstract class BaseCosttemplate  implements Serializable {

	public static String REF = "Costtemplate";
	public static String PROP_MINTARIFFVARIANCE = "Mintariffvariance";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_AVGTARIFFRATEBASE = "Avgtariffratebase";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_AVGTARIFFCALCFLAG = "Avgtariffcalcflag";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_MAXTARIFFVARIANCE = "Maxtariffvariance";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TARIFFVARIANCEFLAG = "Tariffvarianceflag";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_SECTIONKEY = "Sectionkey";
	public static String PROP_COSTTYPE = "Costtype";
	public static String PROP_COSTTEMPLATE_ID = "CosttemplateId";


	// constructors
	public BaseCosttemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCosttemplate (java.lang.Integer costtemplateId) {
		this.setCosttemplateId(costtemplateId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer costtemplateId;

	// fields
	private java.lang.String costkey;
	private java.lang.String sectionkey;
	private java.lang.String costtype;
	private java.lang.String ccykey;
	private java.lang.String vendoraddrkey;
	private boolean avgtariffcalcflag;
	private boolean tariffvarianceflag;
	private java.math.BigDecimal mintariffvariance;
	private java.math.BigDecimal maxtariffvariance;
	private java.math.BigDecimal avgtariffratebase;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="COSTTEMPLATE_ID"
     */
	public java.lang.Integer getCosttemplateId () {
		return costtemplateId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param costtemplateId the new ID
	 */
	public void setCosttemplateId (java.lang.Integer costtemplateId) {
		this.costtemplateId = costtemplateId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}



	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
	}



	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param costtype the costtype value
	 */
	public void setCosttype (java.lang.String costtype) {
		this.costtype = costtype;
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
	 * Return the value associated with the column: avgtariffcalcflag
	 */
	public boolean isAvgtariffcalcflag () {
		return avgtariffcalcflag;
	}

	/**
	 * Set the value related to the column: avgtariffcalcflag
	 * @param avgtariffcalcflag the avgtariffcalcflag value
	 */
	public void setAvgtariffcalcflag (boolean avgtariffcalcflag) {
		this.avgtariffcalcflag = avgtariffcalcflag;
	}



	/**
	 * Return the value associated with the column: tariffvarianceflag
	 */
	public boolean isTariffvarianceflag () {
		return tariffvarianceflag;
	}

	/**
	 * Set the value related to the column: tariffvarianceflag
	 * @param tariffvarianceflag the tariffvarianceflag value
	 */
	public void setTariffvarianceflag (boolean tariffvarianceflag) {
		this.tariffvarianceflag = tariffvarianceflag;
	}



	/**
	 * Return the value associated with the column: mintariffvariance
	 */
	public java.math.BigDecimal getMintariffvariance () {
		return mintariffvariance;
	}

	/**
	 * Set the value related to the column: mintariffvariance
	 * @param mintariffvariance the mintariffvariance value
	 */
	public void setMintariffvariance (java.math.BigDecimal mintariffvariance) {
		this.mintariffvariance = mintariffvariance;
	}



	/**
	 * Return the value associated with the column: maxtariffvariance
	 */
	public java.math.BigDecimal getMaxtariffvariance () {
		return maxtariffvariance;
	}

	/**
	 * Set the value related to the column: maxtariffvariance
	 * @param maxtariffvariance the maxtariffvariance value
	 */
	public void setMaxtariffvariance (java.math.BigDecimal maxtariffvariance) {
		this.maxtariffvariance = maxtariffvariance;
	}



	/**
	 * Return the value associated with the column: avgtariffratebase
	 */
	public java.math.BigDecimal getAvgtariffratebase () {
		return avgtariffratebase;
	}

	/**
	 * Set the value related to the column: avgtariffratebase
	 * @param avgtariffratebase the avgtariffratebase value
	 */
	public void setAvgtariffratebase (java.math.BigDecimal avgtariffratebase) {
		this.avgtariffratebase = avgtariffratebase;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Costtemplate)) return false;
		else {
			com.bureaueye.beacon.model.standard.Costtemplate costtemplate = (com.bureaueye.beacon.model.standard.Costtemplate) obj;
			if (null == this.getCosttemplateId() || null == costtemplate.getCosttemplateId()) return false;
			else return (this.getCosttemplateId().equals(costtemplate.getCosttemplateId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCosttemplateId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCosttemplateId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}