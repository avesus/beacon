package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the charge table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="charge"
 */

public abstract class BaseCharge  implements Serializable {

	public static String REF = "Charge";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_INCACCT = "Incacct";
	public static String PROP_ACTLACCT = "Actlacct";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CASHSETT_REV_DCH_CATG = "CashsettRevDchCatg";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_CASHSETT_REV_LDG_CATG = "CashsettRevLdgCatg";
	public static String PROP_ADJUSTKEY = "Adjustkey";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_ACCSYSCHARGEKEY = "Accsyschargekey";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_TAX = "Tax";
	public static String PROP_LDESC = "Ldesc";
	public static String PROP_ACCSYSITEMID = "Accsysitemid";
	public static String PROP_CHARGEKEY = "Chargekey";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_CASHSETT_EXP_LDG_CATG = "CashsettExpLdgCatg";
	public static String PROP_CASHSETT_EXP_DCH_CATG = "CashsettExpDchCatg";
	public static String PROP_ACCRACCT = "Accracct";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_XACTION = "Xaction";


	// constructors
	public BaseCharge () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCharge (java.lang.String chargekey) {
		this.setChargekey(chargekey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String chargekey;

	// fields
	private java.lang.String xprog;
	private java.lang.String deleted;
	private boolean tax;
	private java.lang.String xtime;
	private java.lang.String xuserid;
	private java.lang.String adjustkey;
	private java.lang.String createuserid;
	private java.lang.String xinactive;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String accsyschargekey;
	private java.lang.String xaction;
	private java.util.Date xdate;
	private java.lang.String ldesc;
	private java.lang.String cashsettRevLdgCatg;
	private java.lang.String cashsettExpDchCatg;
	private java.lang.String cashsettRevDchCatg;
	private java.lang.String cashsettExpLdgCatg;
	private java.lang.String accracct;
	private java.lang.String incacct;
	private java.lang.String actlacct;
	private java.lang.String accsysitemid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="Chargekey"
     */
	public java.lang.String getChargekey () {
		return chargekey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param chargekey the new ID
	 */
	public void setChargekey (java.lang.String chargekey) {
		this.chargekey = chargekey;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: TAX
	 */
	public boolean isTax () {
		return tax;
	}

	/**
	 * Set the value related to the column: TAX
	 * @param tax the TAX value
	 */
	public void setTax (boolean tax) {
		this.tax = tax;
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
	 * Return the value associated with the column: ADJUSTKEY
	 */
	public java.lang.String getAdjustkey () {
		return adjustkey;
	}

	/**
	 * Set the value related to the column: ADJUSTKEY
	 * @param adjustkey the ADJUSTKEY value
	 */
	public void setAdjustkey (java.lang.String adjustkey) {
		this.adjustkey = adjustkey;
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
	 * Return the value associated with the column: ACCSYSCHARGEKEY
	 */
	public java.lang.String getAccsyschargekey () {
		return accsyschargekey;
	}

	/**
	 * Set the value related to the column: ACCSYSCHARGEKEY
	 * @param accsyschargekey the ACCSYSCHARGEKEY value
	 */
	public void setAccsyschargekey (java.lang.String accsyschargekey) {
		this.accsyschargekey = accsyschargekey;
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



	/**
	 * Return the value associated with the column: LDESC
	 */
	public java.lang.String getLdesc () {
		return ldesc;
	}

	/**
	 * Set the value related to the column: LDESC
	 * @param ldesc the LDESC value
	 */
	public void setLdesc (java.lang.String ldesc) {
		this.ldesc = ldesc;
	}



	/**
	 * Return the value associated with the column: CASHSETT_REV_LDG_CATG
	 */
	public java.lang.String getCashsettRevLdgCatg () {
		return cashsettRevLdgCatg;
	}

	/**
	 * Set the value related to the column: CASHSETT_REV_LDG_CATG
	 * @param cashsettRevLdgCatg the CASHSETT_REV_LDG_CATG value
	 */
	public void setCashsettRevLdgCatg (java.lang.String cashsettRevLdgCatg) {
		this.cashsettRevLdgCatg = cashsettRevLdgCatg;
	}



	/**
	 * Return the value associated with the column: CASHSETT_EXP_DCH_CATG
	 */
	public java.lang.String getCashsettExpDchCatg () {
		return cashsettExpDchCatg;
	}

	/**
	 * Set the value related to the column: CASHSETT_EXP_DCH_CATG
	 * @param cashsettExpDchCatg the CASHSETT_EXP_DCH_CATG value
	 */
	public void setCashsettExpDchCatg (java.lang.String cashsettExpDchCatg) {
		this.cashsettExpDchCatg = cashsettExpDchCatg;
	}



	/**
	 * Return the value associated with the column: CASHSETT_REV_DCH_CATG
	 */
	public java.lang.String getCashsettRevDchCatg () {
		return cashsettRevDchCatg;
	}

	/**
	 * Set the value related to the column: CASHSETT_REV_DCH_CATG
	 * @param cashsettRevDchCatg the CASHSETT_REV_DCH_CATG value
	 */
	public void setCashsettRevDchCatg (java.lang.String cashsettRevDchCatg) {
		this.cashsettRevDchCatg = cashsettRevDchCatg;
	}



	/**
	 * Return the value associated with the column: CASHSETT_EXP_LDG_CATG
	 */
	public java.lang.String getCashsettExpLdgCatg () {
		return cashsettExpLdgCatg;
	}

	/**
	 * Set the value related to the column: CASHSETT_EXP_LDG_CATG
	 * @param cashsettExpLdgCatg the CASHSETT_EXP_LDG_CATG value
	 */
	public void setCashsettExpLdgCatg (java.lang.String cashsettExpLdgCatg) {
		this.cashsettExpLdgCatg = cashsettExpLdgCatg;
	}



	/**
	 * Return the value associated with the column: ACCRACCT
	 */
	public java.lang.String getAccracct () {
		return accracct;
	}

	/**
	 * Set the value related to the column: ACCRACCT
	 * @param accracct the ACCRACCT value
	 */
	public void setAccracct (java.lang.String accracct) {
		this.accracct = accracct;
	}



	/**
	 * Return the value associated with the column: INCACCT
	 */
	public java.lang.String getIncacct () {
		return incacct;
	}

	/**
	 * Set the value related to the column: INCACCT
	 * @param incacct the INCACCT value
	 */
	public void setIncacct (java.lang.String incacct) {
		this.incacct = incacct;
	}



	/**
	 * Return the value associated with the column: ACTLACCT
	 */
	public java.lang.String getActlacct () {
		return actlacct;
	}

	/**
	 * Set the value related to the column: ACTLACCT
	 * @param actlacct the ACTLACCT value
	 */
	public void setActlacct (java.lang.String actlacct) {
		this.actlacct = actlacct;
	}



	/**
	 * Return the value associated with the column: accsysitemid
	 */
	public java.lang.String getAccsysitemid () {
		return accsysitemid;
	}

	/**
	 * Set the value related to the column: accsysitemid
	 * @param accsysitemid the accsysitemid value
	 */
	public void setAccsysitemid (java.lang.String accsysitemid) {
		this.accsysitemid = accsysitemid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Charge)) return false;
		else {
			com.bureaueye.beacon.model.standard.Charge charge = (com.bureaueye.beacon.model.standard.Charge) obj;
			if (null == this.getChargekey() || null == charge.getChargekey()) return false;
			else return (this.getChargekey().equals(charge.getChargekey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getChargekey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getChargekey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}