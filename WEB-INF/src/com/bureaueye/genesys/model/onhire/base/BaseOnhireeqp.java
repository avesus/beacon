package com.bureaueye.genesys.model.onhire.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the onhireeqp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="onhireeqp"
 */

public abstract class BaseOnhireeqp  implements Serializable {

	public static String REF = "Onhireeqp";
	public static String PROP_ACTUALFLAG = "Actualflag";
	public static String PROP_MINDAYS = "Mindays";
	public static String PROP_RESERVETIME = "Reservetime";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ONHIRETIMEINMILLIS = "Onhiretimeinmillis";
	public static String PROP_BILLUPTODATE = "Billuptodate";
	public static String PROP_FREEDAYS = "Freedays";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ONHIRE_ID = "OnhireId";
	public static String PROP_RESERVEFLAG = "Reserveflag";
	public static String PROP_DIFLAG = "Diflag";
	public static String PROP_BILLSTARTDATE = "Billstartdate";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_RESERVEDATE = "Reservedate";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_MSDSFLAG = "Msdsflag";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_ONHIREEQP_ID = "OnhireeqpId";
	public static String PROP_BILLSTART = "Billstart";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_DPPFREEDAYS = "Dppfreedays";
	public static String PROP_CLEANFLAG = "Cleanflag";
	public static String PROP_ONHIRETIME = "Onhiretime";
	public static String PROP_BILLFINISH = "Billfinish";
	public static String PROP_RESERVETIMEINMILLIS = "Reservetimeinmillis";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_ONHIREDATE = "Onhiredate";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseOnhireeqp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOnhireeqp (java.lang.Integer onhireeqpId) {
		this.setOnhireeqpId(onhireeqpId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer onhireeqpId;

	// fields
	private boolean diflag;
	private java.util.Date systemlogdate;
	private java.util.Date onhiredate;
	private boolean reserveflag;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.Integer mindays;
	private boolean billfinish;
	private java.lang.String systemlogaction;
	private boolean actualflag;
	private java.lang.String createtime;
	private java.lang.String productkey;
	private java.lang.String systemlogtime;
	private boolean xinactive;
	private java.lang.Integer dppfreedays;
	private java.lang.Integer freedays;
	private java.lang.String unitkey;
	private java.lang.Long onhiretimeinmillis;
	private java.lang.String reservetime;
	private java.lang.Long reservetimeinmillis;
	private java.util.Date billuptodate;
	private java.lang.Integer onhireId;
	private java.lang.Integer unitId;
	private java.lang.String onhiretime;
	private boolean cleanflag;
	private java.lang.String systemlogprogram;
	private java.util.Date reservedate;
	private boolean billstart;
	private java.util.Date billstartdate;
	private boolean msdsflag;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIREEQP_ID"
     */
	public java.lang.Integer getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param onhireeqpId the new ID
	 */
	public void setOnhireeqpId (java.lang.Integer onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: diflag
	 */
	public boolean isDiflag () {
		return diflag;
	}

	/**
	 * Set the value related to the column: diflag
	 * @param diflag the diflag value
	 */
	public void setDiflag (boolean diflag) {
		this.diflag = diflag;
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
	 * Return the value associated with the column: onhiredate
	 */
	public java.util.Date getOnhiredate () {
		return onhiredate;
	}

	/**
	 * Set the value related to the column: onhiredate
	 * @param onhiredate the onhiredate value
	 */
	public void setOnhiredate (java.util.Date onhiredate) {
		this.onhiredate = onhiredate;
	}



	/**
	 * Return the value associated with the column: reserveflag
	 */
	public boolean isReserveflag () {
		return reserveflag;
	}

	/**
	 * Set the value related to the column: reserveflag
	 * @param reserveflag the reserveflag value
	 */
	public void setReserveflag (boolean reserveflag) {
		this.reserveflag = reserveflag;
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
	 * Return the value associated with the column: billfinish
	 */
	public boolean isBillfinish () {
		return billfinish;
	}

	/**
	 * Set the value related to the column: billfinish
	 * @param billfinish the billfinish value
	 */
	public void setBillfinish (boolean billfinish) {
		this.billfinish = billfinish;
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
	 * Return the value associated with the column: actualflag
	 */
	public boolean isActualflag () {
		return actualflag;
	}

	/**
	 * Set the value related to the column: actualflag
	 * @param actualflag the actualflag value
	 */
	public void setActualflag (boolean actualflag) {
		this.actualflag = actualflag;
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
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
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
	 * Return the value associated with the column: dppfreedays
	 */
	public java.lang.Integer getDppfreedays () {
		return dppfreedays;
	}

	/**
	 * Set the value related to the column: dppfreedays
	 * @param dppfreedays the dppfreedays value
	 */
	public void setDppfreedays (java.lang.Integer dppfreedays) {
		this.dppfreedays = dppfreedays;
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
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: onhiretimeinmillis
	 */
	public java.lang.Long getOnhiretimeinmillis () {
		return onhiretimeinmillis;
	}

	/**
	 * Set the value related to the column: onhiretimeinmillis
	 * @param onhiretimeinmillis the onhiretimeinmillis value
	 */
	public void setOnhiretimeinmillis (java.lang.Long onhiretimeinmillis) {
		this.onhiretimeinmillis = onhiretimeinmillis;
	}



	/**
	 * Return the value associated with the column: reservetime
	 */
	public java.lang.String getReservetime () {
		return reservetime;
	}

	/**
	 * Set the value related to the column: reservetime
	 * @param reservetime the reservetime value
	 */
	public void setReservetime (java.lang.String reservetime) {
		this.reservetime = reservetime;
	}



	/**
	 * Return the value associated with the column: reservetimeinmillis
	 */
	public java.lang.Long getReservetimeinmillis () {
		return reservetimeinmillis;
	}

	/**
	 * Set the value related to the column: reservetimeinmillis
	 * @param reservetimeinmillis the reservetimeinmillis value
	 */
	public void setReservetimeinmillis (java.lang.Long reservetimeinmillis) {
		this.reservetimeinmillis = reservetimeinmillis;
	}



	/**
	 * Return the value associated with the column: billuptodate
	 */
	public java.util.Date getBilluptodate () {
		return billuptodate;
	}

	/**
	 * Set the value related to the column: billuptodate
	 * @param billuptodate the billuptodate value
	 */
	public void setBilluptodate (java.util.Date billuptodate) {
		this.billuptodate = billuptodate;
	}



	/**
	 * Return the value associated with the column: ONHIRE_ID
	 */
	public java.lang.Integer getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the value related to the column: ONHIRE_ID
	 * @param onhireId the ONHIRE_ID value
	 */
	public void setOnhireId (java.lang.Integer onhireId) {
		this.onhireId = onhireId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: onhiretime
	 */
	public java.lang.String getOnhiretime () {
		return onhiretime;
	}

	/**
	 * Set the value related to the column: onhiretime
	 * @param onhiretime the onhiretime value
	 */
	public void setOnhiretime (java.lang.String onhiretime) {
		this.onhiretime = onhiretime;
	}



	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean cleanflag) {
		this.cleanflag = cleanflag;
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
	 * Return the value associated with the column: reservedate
	 */
	public java.util.Date getReservedate () {
		return reservedate;
	}

	/**
	 * Set the value related to the column: reservedate
	 * @param reservedate the reservedate value
	 */
	public void setReservedate (java.util.Date reservedate) {
		this.reservedate = reservedate;
	}



	/**
	 * Return the value associated with the column: billstart
	 */
	public boolean isBillstart () {
		return billstart;
	}

	/**
	 * Set the value related to the column: billstart
	 * @param billstart the billstart value
	 */
	public void setBillstart (boolean billstart) {
		this.billstart = billstart;
	}



	/**
	 * Return the value associated with the column: billstartdate
	 */
	public java.util.Date getBillstartdate () {
		return billstartdate;
	}

	/**
	 * Set the value related to the column: billstartdate
	 * @param billstartdate the billstartdate value
	 */
	public void setBillstartdate (java.util.Date billstartdate) {
		this.billstartdate = billstartdate;
	}



	/**
	 * Return the value associated with the column: msdsflag
	 */
	public boolean isMsdsflag () {
		return msdsflag;
	}

	/**
	 * Set the value related to the column: msdsflag
	 * @param msdsflag the msdsflag value
	 */
	public void setMsdsflag (boolean msdsflag) {
		this.msdsflag = msdsflag;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.onhire.Onhireeqp)) return false;
		else {
			com.bureaueye.genesys.model.onhire.Onhireeqp onhireeqp = (com.bureaueye.genesys.model.onhire.Onhireeqp) obj;
			if (null == this.getOnhireeqpId() || null == onhireeqp.getOnhireeqpId()) return false;
			else return (this.getOnhireeqpId().equals(onhireeqp.getOnhireeqpId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOnhireeqpId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOnhireeqpId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}