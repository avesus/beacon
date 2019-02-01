package com.bureaueye.genesys.model.offhire.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the offhireeqp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="offhireeqp"
 */

public abstract class BaseOffhireeqp  implements Serializable {

	public static String REF = "Offhireeqp";
	public static String PROP_ACTUALFLAG = "Actualflag";
	public static String PROP_RESERVETIME = "Reservetime";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_BILLSTOPDATE = "Billstopdate";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_ONHIRE_ID = "OnhireId";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_RESERVEFLAG = "Reserveflag";
	public static String PROP_DIFLAG = "Diflag";
	public static String PROP_OFFHIRETIME = "Offhiretime";
	public static String PROP_OFFHIRE_ID = "OffhireId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_RESERVEDATE = "Reservedate";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_MSDSFLAG = "Msdsflag";
	public static String PROP_OFFHIREEQP_ID = "OffhireeqpId";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_CLEANFLAG = "Cleanflag";
	public static String PROP_OFFHIRETIMEINMILLIS = "Offhiretimeinmillis";
	public static String PROP_OFFHIREDATE = "Offhiredate";
	public static String PROP_BILLFINISH = "Billfinish";
	public static String PROP_RESERVETIMEINMILLIS = "Reservetimeinmillis";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseOffhireeqp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOffhireeqp (java.lang.Integer offhireeqpId) {
		this.setOffhireeqpId(offhireeqpId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer offhireeqpId;

	// fields
	private boolean diflag;
	private java.util.Date systemlogdate;
	private boolean reserveflag;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private boolean billfinish;
	private java.lang.Integer offhireId;
	private java.lang.String systemlogaction;
	private java.util.Date billstopdate;
	private boolean actualflag;
	private java.lang.String createtime;
	private java.lang.String productkey;
	private java.lang.String systemlogtime;
	private java.util.Date offhiredate;
	private boolean xinactive;
	private java.lang.String unitkey;
	private java.lang.String offhiretime;
	private java.lang.String reservetime;
	private java.lang.Long reservetimeinmillis;
	private java.lang.Integer unitId;
	private boolean cleanflag;
	private java.lang.String systemlogprogram;
	private java.lang.Long offhiretimeinmillis;
	private java.util.Date reservedate;
	private boolean msdsflag;
	private java.lang.String createuserid;
	private java.lang.String systemloguserid;
	private java.lang.Integer onhireId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="OFFHIREEQP_ID"
     */
	public java.lang.Integer getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param offhireeqpId the new ID
	 */
	public void setOffhireeqpId (java.lang.Integer offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
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
	 * Return the value associated with the column: OFFHIRE_ID
	 */
	public java.lang.Integer getOffhireId () {
		return offhireId;
	}

	/**
	 * Set the value related to the column: OFFHIRE_ID
	 * @param offhireId the OFFHIRE_ID value
	 */
	public void setOffhireId (java.lang.Integer offhireId) {
		this.offhireId = offhireId;
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
	 * Return the value associated with the column: billstopdate
	 */
	public java.util.Date getBillstopdate () {
		return billstopdate;
	}

	/**
	 * Set the value related to the column: billstopdate
	 * @param billstopdate the billstopdate value
	 */
	public void setBillstopdate (java.util.Date billstopdate) {
		this.billstopdate = billstopdate;
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
	 * Return the value associated with the column: offhiredate
	 */
	public java.util.Date getOffhiredate () {
		return offhiredate;
	}

	/**
	 * Set the value related to the column: offhiredate
	 * @param offhiredate the offhiredate value
	 */
	public void setOffhiredate (java.util.Date offhiredate) {
		this.offhiredate = offhiredate;
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
	 * Return the value associated with the column: offhiretime
	 */
	public java.lang.String getOffhiretime () {
		return offhiretime;
	}

	/**
	 * Set the value related to the column: offhiretime
	 * @param offhiretime the offhiretime value
	 */
	public void setOffhiretime (java.lang.String offhiretime) {
		this.offhiretime = offhiretime;
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
	 * Return the value associated with the column: offhiretimeinmillis
	 */
	public java.lang.Long getOffhiretimeinmillis () {
		return offhiretimeinmillis;
	}

	/**
	 * Set the value related to the column: offhiretimeinmillis
	 * @param offhiretimeinmillis the offhiretimeinmillis value
	 */
	public void setOffhiretimeinmillis (java.lang.Long offhiretimeinmillis) {
		this.offhiretimeinmillis = offhiretimeinmillis;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.genesys.model.offhire.Offhireeqp)) return false;
		else {
			com.bureaueye.genesys.model.offhire.Offhireeqp offhireeqp = (com.bureaueye.genesys.model.offhire.Offhireeqp) obj;
			if (null == this.getOffhireeqpId() || null == offhireeqp.getOffhireeqpId()) return false;
			else return (this.getOffhireeqpId().equals(offhireeqp.getOffhireeqpId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOffhireeqpId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOffhireeqpId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}