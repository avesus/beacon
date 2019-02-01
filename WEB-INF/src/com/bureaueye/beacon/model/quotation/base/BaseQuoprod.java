package com.bureaueye.beacon.model.quotation.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the quoprod table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="quoprod"
 */

public abstract class BaseQuoprod  implements Serializable {

	public static String REF = "Quoprod";
	public static String PROP_LDGTEMP = "Ldgtemp";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_VOLUNIT = "Volunit";
	public static String PROP_QUOPROD_ID = "QuoprodId";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_WGHTUNIT = "Wghtunit";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_QUOTNO = "Quotno";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_COMPRT = "Comprt";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SURFTEMP = "Surftemp";
	public static String PROP_PRODUCTNAME = "Productname";
	public static String PROP_UNNO = "Unno";
	public static String PROP_LQDTEMP = "Lqdtemp";
	public static String PROP_DCHTEMP = "Dchtemp";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TEMPUNIT = "Tempunit";
	public static String PROP_IMO = "Imo";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseQuoprod () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQuoprod (java.lang.Integer quoprodId) {
		this.setQuoprodId(quoprodId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer quoprodId;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String surftemp;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private boolean deleted;
	private java.util.Date systemlogdate;
	private java.lang.String volunit;
	private boolean xinactive;
	private java.lang.String systemlogtime;
	private java.lang.String ldgtemp;
	private java.lang.String comprt;
	private java.math.BigDecimal volume;
	private java.lang.String tempunit;
	private java.lang.String wghtunit;
	private java.lang.String lqdtemp;
	private java.lang.String quotno;
	private java.lang.Integer quohdrId;
	private java.math.BigDecimal weight;
	private java.lang.String createuserid;
	private java.lang.String imo;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String dchtemp;
	private java.lang.String productname;
	private java.lang.String xlock;
	private java.lang.String unno;
	private java.lang.String productkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOPROD_ID"
     */
	public java.lang.Integer getQuoprodId () {
		return quoprodId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quoprodId the new ID
	 */
	public void setQuoprodId (java.lang.Integer quoprodId) {
		this.quoprodId = quoprodId;
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
	 * Return the value associated with the column: SURFTEMP
	 */
	public java.lang.String getSurftemp () {
		return surftemp;
	}

	/**
	 * Set the value related to the column: SURFTEMP
	 * @param surftemp the SURFTEMP value
	 */
	public void setSurftemp (java.lang.String surftemp) {
		this.surftemp = surftemp;
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
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
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
	 * Return the value associated with the column: VOLUNIT
	 */
	public java.lang.String getVolunit () {
		return volunit;
	}

	/**
	 * Set the value related to the column: VOLUNIT
	 * @param volunit the VOLUNIT value
	 */
	public void setVolunit (java.lang.String volunit) {
		this.volunit = volunit;
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
	 * Return the value associated with the column: LDGTEMP
	 */
	public java.lang.String getLdgtemp () {
		return ldgtemp;
	}

	/**
	 * Set the value related to the column: LDGTEMP
	 * @param ldgtemp the LDGTEMP value
	 */
	public void setLdgtemp (java.lang.String ldgtemp) {
		this.ldgtemp = ldgtemp;
	}



	/**
	 * Return the value associated with the column: COMPRT
	 */
	public java.lang.String getComprt () {
		return comprt;
	}

	/**
	 * Set the value related to the column: COMPRT
	 * @param comprt the COMPRT value
	 */
	public void setComprt (java.lang.String comprt) {
		this.comprt = comprt;
	}



	/**
	 * Return the value associated with the column: VOLUME
	 */
	public java.math.BigDecimal getVolume () {
		return volume;
	}

	/**
	 * Set the value related to the column: VOLUME
	 * @param volume the VOLUME value
	 */
	public void setVolume (java.math.BigDecimal volume) {
		this.volume = volume;
	}



	/**
	 * Return the value associated with the column: TEMPUNIT
	 */
	public java.lang.String getTempunit () {
		return tempunit;
	}

	/**
	 * Set the value related to the column: TEMPUNIT
	 * @param tempunit the TEMPUNIT value
	 */
	public void setTempunit (java.lang.String tempunit) {
		this.tempunit = tempunit;
	}



	/**
	 * Return the value associated with the column: WGHTUNIT
	 */
	public java.lang.String getWghtunit () {
		return wghtunit;
	}

	/**
	 * Set the value related to the column: WGHTUNIT
	 * @param wghtunit the WGHTUNIT value
	 */
	public void setWghtunit (java.lang.String wghtunit) {
		this.wghtunit = wghtunit;
	}



	/**
	 * Return the value associated with the column: LQDTEMP
	 */
	public java.lang.String getLqdtemp () {
		return lqdtemp;
	}

	/**
	 * Set the value related to the column: LQDTEMP
	 * @param lqdtemp the LQDTEMP value
	 */
	public void setLqdtemp (java.lang.String lqdtemp) {
		this.lqdtemp = lqdtemp;
	}



	/**
	 * Return the value associated with the column: QUOTNO
	 */
	public java.lang.String getQuotno () {
		return quotno;
	}

	/**
	 * Set the value related to the column: QUOTNO
	 * @param quotno the QUOTNO value
	 */
	public void setQuotno (java.lang.String quotno) {
		this.quotno = quotno;
	}



	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer quohdrId) {
		this.quohdrId = quohdrId;
	}



	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: WEIGHT
	 * @param weight the WEIGHT value
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
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
	 * Return the value associated with the column: IMO
	 */
	public java.lang.String getImo () {
		return imo;
	}

	/**
	 * Set the value related to the column: IMO
	 * @param imo the IMO value
	 */
	public void setImo (java.lang.String imo) {
		this.imo = imo;
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
	 * Return the value associated with the column: DCHTEMP
	 */
	public java.lang.String getDchtemp () {
		return dchtemp;
	}

	/**
	 * Set the value related to the column: DCHTEMP
	 * @param dchtemp the DCHTEMP value
	 */
	public void setDchtemp (java.lang.String dchtemp) {
		this.dchtemp = dchtemp;
	}



	/**
	 * Return the value associated with the column: productname
	 */
	public java.lang.String getProductname () {
		return productname;
	}

	/**
	 * Set the value related to the column: productname
	 * @param productname the productname value
	 */
	public void setProductname (java.lang.String productname) {
		this.productname = productname;
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
	 * Return the value associated with the column: UNNO
	 */
	public java.lang.String getUnno () {
		return unno;
	}

	/**
	 * Set the value related to the column: UNNO
	 * @param unno the UNNO value
	 */
	public void setUnno (java.lang.String unno) {
		this.unno = unno;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.quotation.Quoprod)) return false;
		else {
			com.bureaueye.beacon.model.quotation.Quoprod quoprod = (com.bureaueye.beacon.model.quotation.Quoprod) obj;
			if (null == this.getQuoprodId() || null == quoprod.getQuoprodId()) return false;
			else return (this.getQuoprodId().equals(quoprod.getQuoprodId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getQuoprodId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getQuoprodId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}