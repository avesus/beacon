package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the cost table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="cost"
 */

public abstract class BaseCost  implements Serializable {

	public static String REF = "Cost";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_MANDRSEVERITYCODE = "Mandrseveritycode";
	public static String PROP_INCACCT = "Incacct";
	public static String PROP_ACTLACCT = "Actlacct";
	public static String PROP_MANDRTESTFLAG = "Mandrtestflag";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_GLPRODCODE = "Glprodcode";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CASHSETT_REV_DCH_CATG = "CashsettRevDchCatg";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_CASHSETT_REV_LDG_CATG = "CashsettRevLdgCatg";
	public static String PROP_CSTTYPE = "Csttype";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_MANDRRECHARGEFLAG = "Mandrrechargeflag";
	public static String PROP_ACCSYSITEMID = "Accsysitemid";
	public static String PROP_TAX = "Tax";
	public static String PROP_DESCR = "Descr";
	public static String PROP_MANDRFLAG = "Mandrflag";
	public static String PROP_ACTVCODE = "Actvcode";
	public static String PROP_TCODE = "Tcode";
	public static String PROP_CASHSETT_EXP_LDG_CATG = "CashsettExpLdgCatg";
	public static String PROP_CSTCATG = "Cstcatg";
	public static String PROP_DEVIAT = "Deviat";
	public static String PROP_SYSTEMLOGLOCK = "Systemloglock";
	public static String PROP_CASHSETT_EXP_DCH_CATG = "CashsettExpDchCatg";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_ACCRACCT = "Accracct";
	public static String PROP_MANDRFITTINGFLAG = "Mandrfittingflag";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseCost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCost (java.lang.String costkey) {
		this.setCostkey(costkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String costkey;

	// fields
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.util.Date systemlogdate;
	private java.lang.String deleted;
	private java.lang.String descr;
	private java.lang.String cashsettRevLdgCatg;
	private java.lang.String cashsettExpDchCatg;
	private java.lang.String cashsettRevDchCatg;
	private java.lang.String cashsettExpLdgCatg;
	private java.lang.String tcode;
	private java.lang.String actvcode;
	private java.lang.String systemloglock;
	private java.lang.String accracct;
	private java.lang.String incacct;
	private java.lang.String systemlogtime;
	private java.lang.String deviat;
	private java.lang.String mandrseveritycode;
	private boolean mandrflag;
	private boolean tax;
	private java.lang.String mandrrechargeflag;
	private java.lang.String createuserid;
	private java.lang.String csttype;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.String glprodcode;
	private java.lang.String actlacct;
	private java.lang.String mandrfittingflag;
	private java.lang.String cstcatg;
	private java.lang.String mandrtestflag;
	private java.lang.String accsysitemid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="costkey"
     */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param costkey the new ID
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
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
	 * Return the value associated with the column: TCODE
	 */
	public java.lang.String getTcode () {
		return tcode;
	}

	/**
	 * Set the value related to the column: TCODE
	 * @param tcode the TCODE value
	 */
	public void setTcode (java.lang.String tcode) {
		this.tcode = tcode;
	}



	/**
	 * Return the value associated with the column: ACTVCODE
	 */
	public java.lang.String getActvcode () {
		return actvcode;
	}

	/**
	 * Set the value related to the column: ACTVCODE
	 * @param actvcode the ACTVCODE value
	 */
	public void setActvcode (java.lang.String actvcode) {
		this.actvcode = actvcode;
	}



	/**
	 * Return the value associated with the column: systemloglock
	 */
	public java.lang.String getSystemloglock () {
		return systemloglock;
	}

	/**
	 * Set the value related to the column: systemloglock
	 * @param systemloglock the systemloglock value
	 */
	public void setSystemloglock (java.lang.String systemloglock) {
		this.systemloglock = systemloglock;
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
	 * Return the value associated with the column: DEVIAT
	 */
	public java.lang.String getDeviat () {
		return deviat;
	}

	/**
	 * Set the value related to the column: DEVIAT
	 * @param deviat the DEVIAT value
	 */
	public void setDeviat (java.lang.String deviat) {
		this.deviat = deviat;
	}



	/**
	 * Return the value associated with the column: MANDRSEVERITYCODE
	 */
	public java.lang.String getMandrseveritycode () {
		return mandrseveritycode;
	}

	/**
	 * Set the value related to the column: MANDRSEVERITYCODE
	 * @param mandrseveritycode the MANDRSEVERITYCODE value
	 */
	public void setMandrseveritycode (java.lang.String mandrseveritycode) {
		this.mandrseveritycode = mandrseveritycode;
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
	 * Return the value associated with the column: MANDRRECHARGEFLAG
	 */
	public java.lang.String getMandrrechargeflag () {
		return mandrrechargeflag;
	}

	/**
	 * Set the value related to the column: MANDRRECHARGEFLAG
	 * @param mandrrechargeflag the MANDRRECHARGEFLAG value
	 */
	public void setMandrrechargeflag (java.lang.String mandrrechargeflag) {
		this.mandrrechargeflag = mandrrechargeflag;
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
	 * Return the value associated with the column: CSTTYPE
	 */
	public java.lang.String getCsttype () {
		return csttype;
	}

	/**
	 * Set the value related to the column: CSTTYPE
	 * @param csttype the CSTTYPE value
	 */
	public void setCsttype (java.lang.String csttype) {
		this.csttype = csttype;
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
	 * Return the value associated with the column: GLPRODCODE
	 */
	public java.lang.String getGlprodcode () {
		return glprodcode;
	}

	/**
	 * Set the value related to the column: GLPRODCODE
	 * @param glprodcode the GLPRODCODE value
	 */
	public void setGlprodcode (java.lang.String glprodcode) {
		this.glprodcode = glprodcode;
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
	 * Return the value associated with the column: MANDRFITTINGFLAG
	 */
	public java.lang.String getMandrfittingflag () {
		return mandrfittingflag;
	}

	/**
	 * Set the value related to the column: MANDRFITTINGFLAG
	 * @param mandrfittingflag the MANDRFITTINGFLAG value
	 */
	public void setMandrfittingflag (java.lang.String mandrfittingflag) {
		this.mandrfittingflag = mandrfittingflag;
	}



	/**
	 * Return the value associated with the column: CSTCATG
	 */
	public java.lang.String getCstcatg () {
		return cstcatg;
	}

	/**
	 * Set the value related to the column: CSTCATG
	 * @param cstcatg the CSTCATG value
	 */
	public void setCstcatg (java.lang.String cstcatg) {
		this.cstcatg = cstcatg;
	}



	/**
	 * Return the value associated with the column: MANDRTESTFLAG
	 */
	public java.lang.String getMandrtestflag () {
		return mandrtestflag;
	}

	/**
	 * Set the value related to the column: MANDRTESTFLAG
	 * @param mandrtestflag the MANDRTESTFLAG value
	 */
	public void setMandrtestflag (java.lang.String mandrtestflag) {
		this.mandrtestflag = mandrtestflag;
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
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Cost)) return false;
		else {
			com.bureaueye.beacon.model.standard.Cost cost = (com.bureaueye.beacon.model.standard.Cost) obj;
			if (null == this.getCostkey() || null == cost.getCostkey()) return false;
			else return (this.getCostkey().equals(cost.getCostkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCostkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCostkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}