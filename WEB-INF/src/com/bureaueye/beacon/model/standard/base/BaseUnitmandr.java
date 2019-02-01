package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the unitmandr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="unitmandr"
 */

public abstract class BaseUnitmandr  implements Serializable {

	public static String REF = "Unitmandr";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_LABOURAMT = "Labouramt";
	public static String PROP_LOCATIONKEY = "Locationkey";
	public static String PROP_FITTYPKEY = "Fittypkey";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_MANDRREF = "Mandrref";
	public static String PROP_MATERIALAMT = "Materialamt";
	public static String PROP_FITCODKEY = "Fitcodkey";
	public static String PROP_MANDRDATE = "Mandrdate";
	public static String PROP_SEQNO = "Seqno";
	public static String PROP_UNITMANDR_ID = "UnitmandrId";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_MANDRDESC = "Mandrdesc";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_FITCODDES = "Fitcoddes";
	public static String PROP_RECNO = "Recno";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_FITPOS = "Fitpos";
	public static String PROP_FITGRPKEY = "Fitgrpkey";
	public static String PROP_MANDR_ID = "MandrId";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseUnitmandr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitmandr (java.lang.Integer unitmandrId) {
		this.setUnitmandrId(unitmandrId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer unitmandrId;

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
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private boolean deleted;
	private java.lang.Integer unitId;
	private java.lang.Integer mandrId;
	private java.lang.String mandrdesc;
	private java.lang.String mandrref;
	private java.lang.String ccykey;
	private java.math.BigDecimal labouramt;
	private java.math.BigDecimal materialamt;
	private java.util.Date mandrdate;
	private java.lang.String lesseeaddrkey;
	private java.lang.String locationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITMANDR_ID"
     */
	public java.lang.Integer getUnitmandrId () {
		return unitmandrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitmandrId the new ID
	 */
	public void setUnitmandrId (java.lang.Integer unitmandrId) {
		this.unitmandrId = unitmandrId;
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
	 * Return the value associated with the column: MANDR_ID
	 */
	public java.lang.Integer getMandrId () {
		return mandrId;
	}

	/**
	 * Set the value related to the column: MANDR_ID
	 * @param mandrId the MANDR_ID value
	 */
	public void setMandrId (java.lang.Integer mandrId) {
		this.mandrId = mandrId;
	}



	/**
	 * Return the value associated with the column: mandrdesc
	 */
	public java.lang.String getMandrdesc () {
		return mandrdesc;
	}

	/**
	 * Set the value related to the column: mandrdesc
	 * @param mandrdesc the mandrdesc value
	 */
	public void setMandrdesc (java.lang.String mandrdesc) {
		this.mandrdesc = mandrdesc;
	}



	/**
	 * Return the value associated with the column: mandrref
	 */
	public java.lang.String getMandrref () {
		return mandrref;
	}

	/**
	 * Set the value related to the column: mandrref
	 * @param mandrref the mandrref value
	 */
	public void setMandrref (java.lang.String mandrref) {
		this.mandrref = mandrref;
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
	 * Return the value associated with the column: labouramt
	 */
	public java.math.BigDecimal getLabouramt () {
		return labouramt;
	}

	/**
	 * Set the value related to the column: labouramt
	 * @param labouramt the labouramt value
	 */
	public void setLabouramt (java.math.BigDecimal labouramt) {
		this.labouramt = labouramt;
	}



	/**
	 * Return the value associated with the column: materialamt
	 */
	public java.math.BigDecimal getMaterialamt () {
		return materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (java.math.BigDecimal materialamt) {
		this.materialamt = materialamt;
	}



	/**
	 * Return the value associated with the column: mandrdate
	 */
	public java.util.Date getMandrdate () {
		return mandrdate;
	}

	/**
	 * Set the value related to the column: mandrdate
	 * @param mandrdate the mandrdate value
	 */
	public void setMandrdate (java.util.Date mandrdate) {
		this.mandrdate = mandrdate;
	}



	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public java.lang.String getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (java.lang.String lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}



	/**
	 * Return the value associated with the column: locationkey
	 */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Unitmandr)) return false;
		else {
			com.bureaueye.beacon.model.standard.Unitmandr unitmandr = (com.bureaueye.beacon.model.standard.Unitmandr) obj;
			if (null == this.getUnitmandrId() || null == unitmandr.getUnitmandrId()) return false;
			else return (this.getUnitmandrId().equals(unitmandr.getUnitmandrId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUnitmandrId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUnitmandrId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}