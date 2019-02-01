package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the unitfit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="unitfit"
 */

public abstract class BaseUnitfit  implements Serializable {

	public static String REF = "Unitfit";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_MANDRKEY = "Mandrkey";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_FITTYPKEY = "Fittypkey";
	public static String PROP_FITCODDES = "Fitcoddes";
	public static String PROP_UNITFIT_ID = "UnitfitId";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_MANDRLINKKEY = "Mandrlinkkey";
	public static String PROP_RECNO = "Recno";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_FITGRPKEY = "Fitgrpkey";
	public static String PROP_FITCODKEY = "Fitcodkey";
	public static String PROP_FITPOS = "Fitpos";
	public static String PROP_RECORDKEY = "Recordkey";
	public static String PROP_SEQNO = "Seqno";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseUnitfit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitfit (java.lang.Integer unitfitId) {
		this.setUnitfitId(unitfitId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer unitfitId;

	// fields
	private java.lang.String unitkey;
	private java.lang.String fitgrpkey;
	private java.lang.String fittypkey;
	private java.lang.String fitcodkey;
	private java.lang.String fitpos;
	private java.lang.String xlock;
	private java.lang.String fitcoddes;
	private boolean xinactive;
	private java.lang.Integer seqno;
	private java.lang.Integer recno;
	private java.lang.String recordkey;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.lang.String mandrkey;
	private boolean deleted;
	private java.lang.Integer mandrlinkkey;
	private java.lang.Integer unitId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITFIT_ID"
     */
	public java.lang.Integer getUnitfitId () {
		return unitfitId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitfitId the new ID
	 */
	public void setUnitfitId (java.lang.Integer unitfitId) {
		this.unitfitId = unitfitId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: fitgrpkey
	 */
	public java.lang.String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (java.lang.String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}



	/**
	 * Return the value associated with the column: fittypkey
	 */
	public java.lang.String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (java.lang.String fittypkey) {
		this.fittypkey = fittypkey;
	}



	/**
	 * Return the value associated with the column: fitcodkey
	 */
	public java.lang.String getFitcodkey () {
		return fitcodkey;
	}

	/**
	 * Set the value related to the column: fitcodkey
	 * @param fitcodkey the fitcodkey value
	 */
	public void setFitcodkey (java.lang.String fitcodkey) {
		this.fitcodkey = fitcodkey;
	}



	/**
	 * Return the value associated with the column: fitpos
	 */
	public java.lang.String getFitpos () {
		return fitpos;
	}

	/**
	 * Set the value related to the column: fitpos
	 * @param fitpos the fitpos value
	 */
	public void setFitpos (java.lang.String fitpos) {
		this.fitpos = fitpos;
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
	 * Return the value associated with the column: fitcoddes
	 */
	public java.lang.String getFitcoddes () {
		return fitcoddes;
	}

	/**
	 * Set the value related to the column: fitcoddes
	 * @param fitcoddes the fitcoddes value
	 */
	public void setFitcoddes (java.lang.String fitcoddes) {
		this.fitcoddes = fitcoddes;
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
	 * Return the value associated with the column: seqno
	 */
	public java.lang.Integer getSeqno () {
		return seqno;
	}

	/**
	 * Set the value related to the column: seqno
	 * @param seqno the seqno value
	 */
	public void setSeqno (java.lang.Integer seqno) {
		this.seqno = seqno;
	}



	/**
	 * Return the value associated with the column: recno
	 */
	public java.lang.Integer getRecno () {
		return recno;
	}

	/**
	 * Set the value related to the column: recno
	 * @param recno the recno value
	 */
	public void setRecno (java.lang.Integer recno) {
		this.recno = recno;
	}



	/**
	 * Return the value associated with the column: recordkey
	 */
	public java.lang.String getRecordkey () {
		return recordkey;
	}

	/**
	 * Set the value related to the column: recordkey
	 * @param recordkey the recordkey value
	 */
	public void setRecordkey (java.lang.String recordkey) {
		this.recordkey = recordkey;
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



	/**
	 * Return the value associated with the column: mandrkey
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: mandrkey
	 * @param mandrkey the mandrkey value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: mandrlinkkey
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: mandrlinkkey
	 * @param mandrlinkkey the mandrlinkkey value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Unitfit)) return false;
		else {
			com.bureaueye.beacon.model.standard.Unitfit unitfit = (com.bureaueye.beacon.model.standard.Unitfit) obj;
			if (null == this.getUnitfitId() || null == unitfit.getUnitfitId()) return false;
			else return (this.getUnitfitId().equals(unitfit.getUnitfitId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUnitfitId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUnitfitId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}