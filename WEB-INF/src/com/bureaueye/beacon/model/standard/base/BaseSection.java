package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the section table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="section"
 */

public abstract class BaseSection  implements Serializable {

	public static String REF = "Section";
	public static String PROP_CSTCODE5 = "Cstcode5";
	public static String PROP_CSTCODE6 = "Cstcode6";
	public static String PROP_CSTCODE7 = "Cstcode7";
	public static String PROP_CSTCODE8 = "Cstcode8";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_TRANSPORTMODE = "Transportmode";
	public static String PROP_CSTCODE1 = "Cstcode1";
	public static String PROP_CSTCODE2 = "Cstcode2";
	public static String PROP_CSTCODE3 = "Cstcode3";
	public static String PROP_CSTCODE4 = "Cstcode4";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_INVSTS = "Invsts";
	public static String PROP_CSTCODE9 = "Cstcode9";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_MOVESTS = "Movests";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_FROMLOCATIONTYPE = "Fromlocationtype";
	public static String PROP_AVLSTAT = "Avlstat";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_SECTIONKEY = "Sectionkey";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_TOLOCATIONTYPE = "Tolocationtype";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_CSTCODE10 = "Cstcode10";
	public static String PROP_DESCR = "Descr";
	public static String PROP_MANDRFLAG = "Mandrflag";
	public static String PROP_COST = "Cost";
	public static String PROP_TRTYPE = "Trtype";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseSection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSection (java.lang.String sectionkey) {
		this.setSectionkey(sectionkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String sectionkey;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String deleted;
	private java.lang.String cstcode3;
	private java.lang.String avlstat;
	private java.lang.String descr;
	private java.lang.String cstcode10;
	private java.lang.String cost;
	private java.lang.String cstcode8;
	private java.lang.String xinactive;
	private java.lang.String cstcode4;
	private java.lang.String cstcode9;
	private java.lang.String systemlogtime;
	private java.lang.String cstcode2;
	private java.lang.String cstcode7;
	private boolean mandrflag;
	private java.lang.String cstcode1;
	private java.lang.String fromlocationtype;
	private java.lang.String tolocationtype;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String cstcode5;
	private java.lang.String activitykey;
	private java.lang.String invsts;
	private java.lang.String movests;
	private java.lang.String cstcode6;
	private java.lang.String trtype;
	private java.lang.String xlock;
	private java.lang.String transportmode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="sectionkey"
     */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sectionkey the new ID
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
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
	 * Return the value associated with the column: CSTCODE__3
	 */
	public java.lang.String getCstcode3 () {
		return cstcode3;
	}

	/**
	 * Set the value related to the column: CSTCODE__3
	 * @param cstcode3 the CSTCODE__3 value
	 */
	public void setCstcode3 (java.lang.String cstcode3) {
		this.cstcode3 = cstcode3;
	}



	/**
	 * Return the value associated with the column: AVLSTAT
	 */
	public java.lang.String getAvlstat () {
		return avlstat;
	}

	/**
	 * Set the value related to the column: AVLSTAT
	 * @param avlstat the AVLSTAT value
	 */
	public void setAvlstat (java.lang.String avlstat) {
		this.avlstat = avlstat;
	}



	/**
	 * Return the value associated with the column: DESCR
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: DESCR
	 * @param descr the DESCR value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
	}



	/**
	 * Return the value associated with the column: CSTCODE__10
	 */
	public java.lang.String getCstcode10 () {
		return cstcode10;
	}

	/**
	 * Set the value related to the column: CSTCODE__10
	 * @param cstcode10 the CSTCODE__10 value
	 */
	public void setCstcode10 (java.lang.String cstcode10) {
		this.cstcode10 = cstcode10;
	}



	/**
	 * Return the value associated with the column: COST
	 */
	public java.lang.String getCost () {
		return cost;
	}

	/**
	 * Set the value related to the column: COST
	 * @param cost the COST value
	 */
	public void setCost (java.lang.String cost) {
		this.cost = cost;
	}



	/**
	 * Return the value associated with the column: CSTCODE__8
	 */
	public java.lang.String getCstcode8 () {
		return cstcode8;
	}

	/**
	 * Set the value related to the column: CSTCODE__8
	 * @param cstcode8 the CSTCODE__8 value
	 */
	public void setCstcode8 (java.lang.String cstcode8) {
		this.cstcode8 = cstcode8;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: CSTCODE__4
	 */
	public java.lang.String getCstcode4 () {
		return cstcode4;
	}

	/**
	 * Set the value related to the column: CSTCODE__4
	 * @param cstcode4 the CSTCODE__4 value
	 */
	public void setCstcode4 (java.lang.String cstcode4) {
		this.cstcode4 = cstcode4;
	}



	/**
	 * Return the value associated with the column: CSTCODE__9
	 */
	public java.lang.String getCstcode9 () {
		return cstcode9;
	}

	/**
	 * Set the value related to the column: CSTCODE__9
	 * @param cstcode9 the CSTCODE__9 value
	 */
	public void setCstcode9 (java.lang.String cstcode9) {
		this.cstcode9 = cstcode9;
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
	 * Return the value associated with the column: CSTCODE__2
	 */
	public java.lang.String getCstcode2 () {
		return cstcode2;
	}

	/**
	 * Set the value related to the column: CSTCODE__2
	 * @param cstcode2 the CSTCODE__2 value
	 */
	public void setCstcode2 (java.lang.String cstcode2) {
		this.cstcode2 = cstcode2;
	}



	/**
	 * Return the value associated with the column: CSTCODE__7
	 */
	public java.lang.String getCstcode7 () {
		return cstcode7;
	}

	/**
	 * Set the value related to the column: CSTCODE__7
	 * @param cstcode7 the CSTCODE__7 value
	 */
	public void setCstcode7 (java.lang.String cstcode7) {
		this.cstcode7 = cstcode7;
	}



	/**
	 * Return the value associated with the column: MANDRFLAG
	 */
	public boolean isMandrflag () {
		return mandrflag;
	}

	/**
	 * Set the value related to the column: MANDRFLAG
	 * @param mandrflag the MANDRFLAG value
	 */
	public void setMandrflag (boolean mandrflag) {
		this.mandrflag = mandrflag;
	}



	/**
	 * Return the value associated with the column: CSTCODE__1
	 */
	public java.lang.String getCstcode1 () {
		return cstcode1;
	}

	/**
	 * Set the value related to the column: CSTCODE__1
	 * @param cstcode1 the CSTCODE__1 value
	 */
	public void setCstcode1 (java.lang.String cstcode1) {
		this.cstcode1 = cstcode1;
	}



	/**
	 * Return the value associated with the column: fromlocationtype
	 */
	public java.lang.String getFromlocationtype () {
		return fromlocationtype;
	}

	/**
	 * Set the value related to the column: fromlocationtype
	 * @param fromlocationtype the fromlocationtype value
	 */
	public void setFromlocationtype (java.lang.String fromlocationtype) {
		this.fromlocationtype = fromlocationtype;
	}



	/**
	 * Return the value associated with the column: tolocationtype
	 */
	public java.lang.String getTolocationtype () {
		return tolocationtype;
	}

	/**
	 * Set the value related to the column: tolocationtype
	 * @param tolocationtype the tolocationtype value
	 */
	public void setTolocationtype (java.lang.String tolocationtype) {
		this.tolocationtype = tolocationtype;
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
	 * Return the value associated with the column: CSTCODE__5
	 */
	public java.lang.String getCstcode5 () {
		return cstcode5;
	}

	/**
	 * Set the value related to the column: CSTCODE__5
	 * @param cstcode5 the CSTCODE__5 value
	 */
	public void setCstcode5 (java.lang.String cstcode5) {
		this.cstcode5 = cstcode5;
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
	 * Return the value associated with the column: INVSTS
	 */
	public java.lang.String getInvsts () {
		return invsts;
	}

	/**
	 * Set the value related to the column: INVSTS
	 * @param invsts the INVSTS value
	 */
	public void setInvsts (java.lang.String invsts) {
		this.invsts = invsts;
	}



	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param movests the movests value
	 */
	public void setMovests (java.lang.String movests) {
		this.movests = movests;
	}



	/**
	 * Return the value associated with the column: CSTCODE__6
	 */
	public java.lang.String getCstcode6 () {
		return cstcode6;
	}

	/**
	 * Set the value related to the column: CSTCODE__6
	 * @param cstcode6 the CSTCODE__6 value
	 */
	public void setCstcode6 (java.lang.String cstcode6) {
		this.cstcode6 = cstcode6;
	}



	/**
	 * Return the value associated with the column: TRTYPE
	 */
	public java.lang.String getTrtype () {
		return trtype;
	}

	/**
	 * Set the value related to the column: TRTYPE
	 * @param trtype the TRTYPE value
	 */
	public void setTrtype (java.lang.String trtype) {
		this.trtype = trtype;
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
	 * Return the value associated with the column: transportmode
	 */
	public java.lang.String getTransportmode () {
		return transportmode;
	}

	/**
	 * Set the value related to the column: transportmode
	 * @param transportmode the transportmode value
	 */
	public void setTransportmode (java.lang.String transportmode) {
		this.transportmode = transportmode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Section)) return false;
		else {
			com.bureaueye.beacon.model.standard.Section section = (com.bureaueye.beacon.model.standard.Section) obj;
			if (null == this.getSectionkey() || null == section.getSectionkey()) return false;
			else return (this.getSectionkey().equals(section.getSectionkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSectionkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSectionkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}