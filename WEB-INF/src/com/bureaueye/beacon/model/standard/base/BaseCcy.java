package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ccy table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ccy"
 */

public abstract class BaseCcy  implements Serializable {

	public static String REF = "Ccy";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_EURO = "Euro";
	public static String PROP_DECPL = "Decpl";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CCYNAME = "Ccyname";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_PRTPRE = "Prtpre";
	public static String PROP_PRTCHR = "Prtchr";
	public static String PROP_CCYSHORT = "Ccyshort";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_XACTION = "Xaction";


	// constructors
	public BaseCcy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCcy (java.lang.String ccykey) {
		this.setCcykey(ccykey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String ccykey;

	// fields
	private boolean euro;
	private java.lang.String xprog;
	private java.lang.String deleted;
	private boolean prtpre;
	private java.lang.String prtchr;
	private java.lang.String xtime;
	private java.lang.String xuserid;
	private java.lang.String createuserid;
	private java.lang.Byte decpl;
	private java.lang.String xinactive;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String ccyname;
	private java.lang.String ccyshort;
	private java.lang.String xaction;
	private java.util.Date xdate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="CCYKEY"
     */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ccykey the new ID
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: EURO
	 */
	public boolean isEuro () {
		return euro;
	}

	/**
	 * Set the value related to the column: EURO
	 * @param euro the EURO value
	 */
	public void setEuro (boolean euro) {
		this.euro = euro;
	}



	/**
	 * Return the value associated with the column: XPROG
	 */
	public java.lang.String getXprog () {
		return xprog;
	}

	/**
	 * Set the value related to the column: XPROG
	 * @param xprog the XPROG value
	 */
	public void setXprog (java.lang.String xprog) {
		this.xprog = xprog;
	}



	/**
	 * Return the value associated with the column: DELETED
	 */
	public java.lang.String getDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (java.lang.String deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: PRTPRE
	 */
	public boolean isPrtpre () {
		return prtpre;
	}

	/**
	 * Set the value related to the column: PRTPRE
	 * @param prtpre the PRTPRE value
	 */
	public void setPrtpre (boolean prtpre) {
		this.prtpre = prtpre;
	}



	/**
	 * Return the value associated with the column: PRTCHR
	 */
	public java.lang.String getPrtchr () {
		return prtchr;
	}

	/**
	 * Set the value related to the column: PRTCHR
	 * @param prtchr the PRTCHR value
	 */
	public void setPrtchr (java.lang.String prtchr) {
		this.prtchr = prtchr;
	}



	/**
	 * Return the value associated with the column: XTIME
	 */
	public java.lang.String getXtime () {
		return xtime;
	}

	/**
	 * Set the value related to the column: XTIME
	 * @param xtime the XTIME value
	 */
	public void setXtime (java.lang.String xtime) {
		this.xtime = xtime;
	}



	/**
	 * Return the value associated with the column: XUSERID
	 */
	public java.lang.String getXuserid () {
		return xuserid;
	}

	/**
	 * Set the value related to the column: XUSERID
	 * @param xuserid the XUSERID value
	 */
	public void setXuserid (java.lang.String xuserid) {
		this.xuserid = xuserid;
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
	 * Return the value associated with the column: DECPL
	 */
	public java.lang.Byte getDecpl () {
		return decpl;
	}

	/**
	 * Set the value related to the column: DECPL
	 * @param decpl the DECPL value
	 */
	public void setDecpl (java.lang.Byte decpl) {
		this.decpl = decpl;
	}



	/**
	 * Return the value associated with the column: XINACTIVE
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: XINACTIVE
	 * @param xinactive the XINACTIVE value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: XLOCK
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: XLOCK
	 * @param xlock the XLOCK value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
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
	 * Return the value associated with the column: CCYNAME
	 */
	public java.lang.String getCcyname () {
		return ccyname;
	}

	/**
	 * Set the value related to the column: CCYNAME
	 * @param ccyname the CCYNAME value
	 */
	public void setCcyname (java.lang.String ccyname) {
		this.ccyname = ccyname;
	}



	/**
	 * Return the value associated with the column: CCYSHORT
	 */
	public java.lang.String getCcyshort () {
		return ccyshort;
	}

	/**
	 * Set the value related to the column: CCYSHORT
	 * @param ccyshort the CCYSHORT value
	 */
	public void setCcyshort (java.lang.String ccyshort) {
		this.ccyshort = ccyshort;
	}



	/**
	 * Return the value associated with the column: XACTION
	 */
	public java.lang.String getXaction () {
		return xaction;
	}

	/**
	 * Set the value related to the column: XACTION
	 * @param xaction the XACTION value
	 */
	public void setXaction (java.lang.String xaction) {
		this.xaction = xaction;
	}



	/**
	 * Return the value associated with the column: XDATE
	 */
	public java.util.Date getXdate () {
		return xdate;
	}

	/**
	 * Set the value related to the column: XDATE
	 * @param xdate the XDATE value
	 */
	public void setXdate (java.util.Date xdate) {
		this.xdate = xdate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Ccy)) return false;
		else {
			com.bureaueye.beacon.model.standard.Ccy ccy = (com.bureaueye.beacon.model.standard.Ccy) obj;
			if (null == this.getCcykey() || null == ccy.getCcykey()) return false;
			else return (this.getCcykey().equals(ccy.getCcykey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCcykey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCcykey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}