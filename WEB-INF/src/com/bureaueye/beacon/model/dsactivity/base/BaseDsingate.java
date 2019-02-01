package com.bureaueye.beacon.model.dsactivity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dsingate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dsingate"
 */

public abstract class BaseDsingate  implements Serializable {

	public static String REF = "Dsingate";
	public static String PROP_DROPCUSTOMERADDRKEY = "Dropcustomeraddrkey";
	public static String PROP_CONCUEIR = "Concueir";
	public static String PROP_GRIDLOC = "Gridloc";
	public static String PROP_CHAFHEXT = "Chafhext";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_UPDTTIME = "Updttime";
	public static String PROP_CDXREDEL = "Cdxredel";
	public static String PROP_CONMFGDT = "Conmfgdt";
	public static String PROP_FOREIGNTARGET = "Foreigntarget";
	public static String PROP_UPDTUSER = "Updtuser";
	public static String PROP_CHAFHDTE = "Chafhdte";
	public static String PROP_SCAC = "Scac";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_TURNENDDATE = "Turnenddate";
	public static String PROP_CDXREF = "Cdxref";
	public static String PROP_INSPECTOR = "Inspector";
	public static String PROP_TURNENDTIME = "Turnendtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_IXD = "Ixd";
	public static String PROP_CHAPLATE = "Chaplate";
	public static String PROP_CONCOND = "Concond";
	public static String PROP_WAIVEINSPFEE = "Waiveinspfee";
	public static String PROP_INTIME = "Intime";
	public static String PROP_WAIVELIFTFEE = "Waiveliftfee";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_CHASTACK = "Chastack";
	public static String PROP_EIRIN = "Eirin";
	public static String PROP_INTREM = "Intrem";
	public static String PROP_UPDTDATE = "Updtdate";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_MU = "Mu";
	public static String PROP_LOADEMPTY = "Loadempty";
	public static String PROP_CHANEWST = "Chanewst";
	public static String PROP_CUSTREM = "Custrem";
	public static String PROP_TARGETEQ = "Targeteq";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CHAMFG = "Chamfg";
	public static String PROP_INDATE = "Indate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SHUTTLFEE = "Shuttlfee";
	public static String PROP_CONMFG = "Conmfg";
	public static String PROP_SHIPSEAL = "Shipseal";
	public static String PROP_GRADE = "Grade";
	public static String PROP_CON1 = "Con1";
	public static String PROP_CHA5 = "Cha5";
	public static String PROP_CHA4 = "Cha4";
	public static String PROP_CHAEXPDT = "Chaexpdt";
	public static String PROP_DSINGATE_ID = "DsingateId";
	public static String PROP_DEPOTLOCATIONKEY = "Depotlocationkey";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_CONSIZE = "Consize";
	public static String PROP_CONMATL = "Conmatl";
	public static String PROP_SHUTTLEMOVE = "Shuttlemove";
	public static String PROP_CHA3 = "Cha3";
	public static String PROP_CHA2 = "Cha2";
	public static String PROP_CHASIZE = "Chasize";
	public static String PROP_CHA1 = "Cha1";
	public static String PROP_SHUTTLECUSTOMERADDRKEY = "Shuttlecustomeraddrkey";
	public static String PROP_CHAEIR3 = "Chaeir3";
	public static String PROP_CHACOND = "Chacond";
	public static String PROP_CHAEIR2 = "Chaeir2";
	public static String PROP_CHAEIR5 = "Chaeir5";
	public static String PROP_CONTYPE = "Contype";
	public static String PROP_EIRINVER = "Eirinver";
	public static String PROP_CHAEIR4 = "Chaeir4";
	public static String PROP_CHATYPE = "Chatype";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CHANEWPT = "Chanewpt";
	public static String PROP_DROPLOT = "Droplot";
	public static String PROP_CHACUEIR = "Chacueir";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_TRACTOR = "Tractor";


	// constructors
	public BaseDsingate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDsingate (java.lang.Integer dsingateId) {
		this.setDsingateId(dsingateId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer dsingateId;

	// fields
	private java.lang.String eirin;
	private java.lang.Integer eirinver;
	private java.lang.String depotlocationkey;
	private java.lang.String updtuser;
	private java.lang.String customeraddrkey;
	private java.util.Date indate;
	private java.lang.String intime;
	private java.lang.String inspector;
	private java.lang.String con1;
	private java.lang.String cha1;
	private java.util.Date turnenddate;
	private java.lang.String turnendtime;
	private java.lang.String loadempty;
	private java.lang.String ixd;
	private java.lang.String mu;
	private java.lang.String consize;
	private java.lang.String contype;
	private java.lang.String conmatl;
	private java.lang.String concueir;
	private java.lang.String chasize;
	private java.lang.String chatype;
	private java.lang.String chacueir;
	private boolean chastack;
	private java.lang.String chaplate;
	private java.util.Date chaexpdt;
	private java.util.Date chafhdte;
	private java.lang.String chafhext;
	private java.lang.String chanewst;
	private java.lang.String chanewpt;
	private java.lang.String scac;
	private java.lang.String tractor;
	private java.lang.String shipseal;
	private java.lang.String custrem;
	private java.lang.String intrem;
	private java.lang.String cdxref;
	private java.lang.String cdxredel;
	private java.lang.String grade;
	private java.lang.String concond;
	private java.lang.String chacond;
	private java.lang.String gridloc;
	private boolean waiveinspfee;
	private boolean waiveliftfee;
	private java.util.Date updtdate;
	private java.lang.String updttime;
	private boolean shuttlemove;
	private java.math.BigDecimal shuttlfee;
	private java.lang.String shuttlecustomeraddrkey;
	private boolean droplot;
	private java.lang.String dropcustomeraddrkey;
	private boolean foreigntarget;
	private java.lang.String cha2;
	private java.lang.String chaeir2;
	private java.lang.String cha3;
	private java.lang.String chaeir3;
	private java.lang.String cha4;
	private java.lang.String chaeir4;
	private java.lang.String cha5;
	private java.lang.String chaeir5;
	private java.lang.String targeteq;
	private java.lang.String conmfg;
	private java.util.Date conmfgdt;
	private java.lang.String chamfg;
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
     *  column="DSINGATE_ID"
     */
	public java.lang.Integer getDsingateId () {
		return dsingateId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param dsingateId the new ID
	 */
	public void setDsingateId (java.lang.Integer dsingateId) {
		this.dsingateId = dsingateId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: EIRIN
	 */
	public java.lang.String getEirin () {
		return eirin;
	}

	/**
	 * Set the value related to the column: EIRIN
	 * @param eirin the EIRIN value
	 */
	public void setEirin (java.lang.String eirin) {
		this.eirin = eirin;
	}



	/**
	 * Return the value associated with the column: EIRINVER
	 */
	public java.lang.Integer getEirinver () {
		return eirinver;
	}

	/**
	 * Set the value related to the column: EIRINVER
	 * @param eirinver the EIRINVER value
	 */
	public void setEirinver (java.lang.Integer eirinver) {
		this.eirinver = eirinver;
	}



	/**
	 * Return the value associated with the column: depotlocationkey
	 */
	public java.lang.String getDepotlocationkey () {
		return depotlocationkey;
	}

	/**
	 * Set the value related to the column: depotlocationkey
	 * @param depotlocationkey the depotlocationkey value
	 */
	public void setDepotlocationkey (java.lang.String depotlocationkey) {
		this.depotlocationkey = depotlocationkey;
	}



	/**
	 * Return the value associated with the column: UPDTUSER
	 */
	public java.lang.String getUpdtuser () {
		return updtuser;
	}

	/**
	 * Set the value related to the column: UPDTUSER
	 * @param updtuser the UPDTUSER value
	 */
	public void setUpdtuser (java.lang.String updtuser) {
		this.updtuser = updtuser;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}



	/**
	 * Return the value associated with the column: INDATE
	 */
	public java.util.Date getIndate () {
		return indate;
	}

	/**
	 * Set the value related to the column: INDATE
	 * @param indate the INDATE value
	 */
	public void setIndate (java.util.Date indate) {
		this.indate = indate;
	}



	/**
	 * Return the value associated with the column: INTIME
	 */
	public java.lang.String getIntime () {
		return intime;
	}

	/**
	 * Set the value related to the column: INTIME
	 * @param intime the INTIME value
	 */
	public void setIntime (java.lang.String intime) {
		this.intime = intime;
	}



	/**
	 * Return the value associated with the column: INSPECTOR
	 */
	public java.lang.String getInspector () {
		return inspector;
	}

	/**
	 * Set the value related to the column: INSPECTOR
	 * @param inspector the INSPECTOR value
	 */
	public void setInspector (java.lang.String inspector) {
		this.inspector = inspector;
	}



	/**
	 * Return the value associated with the column: con1
	 */
	public java.lang.String getCon1 () {
		return con1;
	}

	/**
	 * Set the value related to the column: con1
	 * @param con1 the con1 value
	 */
	public void setCon1 (java.lang.String con1) {
		this.con1 = con1;
	}



	/**
	 * Return the value associated with the column: cha1
	 */
	public java.lang.String getCha1 () {
		return cha1;
	}

	/**
	 * Set the value related to the column: cha1
	 * @param cha1 the cha1 value
	 */
	public void setCha1 (java.lang.String cha1) {
		this.cha1 = cha1;
	}



	/**
	 * Return the value associated with the column: TURNENDDATE
	 */
	public java.util.Date getTurnenddate () {
		return turnenddate;
	}

	/**
	 * Set the value related to the column: TURNENDDATE
	 * @param turnenddate the TURNENDDATE value
	 */
	public void setTurnenddate (java.util.Date turnenddate) {
		this.turnenddate = turnenddate;
	}



	/**
	 * Return the value associated with the column: TURNENDTIME
	 */
	public java.lang.String getTurnendtime () {
		return turnendtime;
	}

	/**
	 * Set the value related to the column: TURNENDTIME
	 * @param turnendtime the TURNENDTIME value
	 */
	public void setTurnendtime (java.lang.String turnendtime) {
		this.turnendtime = turnendtime;
	}



	/**
	 * Return the value associated with the column: LOADEMPTY
	 */
	public java.lang.String getLoadempty () {
		return loadempty;
	}

	/**
	 * Set the value related to the column: LOADEMPTY
	 * @param loadempty the LOADEMPTY value
	 */
	public void setLoadempty (java.lang.String loadempty) {
		this.loadempty = loadempty;
	}



	/**
	 * Return the value associated with the column: IXD
	 */
	public java.lang.String getIxd () {
		return ixd;
	}

	/**
	 * Set the value related to the column: IXD
	 * @param ixd the IXD value
	 */
	public void setIxd (java.lang.String ixd) {
		this.ixd = ixd;
	}



	/**
	 * Return the value associated with the column: MU
	 */
	public java.lang.String getMu () {
		return mu;
	}

	/**
	 * Set the value related to the column: MU
	 * @param mu the MU value
	 */
	public void setMu (java.lang.String mu) {
		this.mu = mu;
	}



	/**
	 * Return the value associated with the column: CONSIZE
	 */
	public java.lang.String getConsize () {
		return consize;
	}

	/**
	 * Set the value related to the column: CONSIZE
	 * @param consize the CONSIZE value
	 */
	public void setConsize (java.lang.String consize) {
		this.consize = consize;
	}



	/**
	 * Return the value associated with the column: CONTYPE
	 */
	public java.lang.String getContype () {
		return contype;
	}

	/**
	 * Set the value related to the column: CONTYPE
	 * @param contype the CONTYPE value
	 */
	public void setContype (java.lang.String contype) {
		this.contype = contype;
	}



	/**
	 * Return the value associated with the column: CONMATL
	 */
	public java.lang.String getConmatl () {
		return conmatl;
	}

	/**
	 * Set the value related to the column: CONMATL
	 * @param conmatl the CONMATL value
	 */
	public void setConmatl (java.lang.String conmatl) {
		this.conmatl = conmatl;
	}



	/**
	 * Return the value associated with the column: CONCUEIR
	 */
	public java.lang.String getConcueir () {
		return concueir;
	}

	/**
	 * Set the value related to the column: CONCUEIR
	 * @param concueir the CONCUEIR value
	 */
	public void setConcueir (java.lang.String concueir) {
		this.concueir = concueir;
	}



	/**
	 * Return the value associated with the column: CHASIZE
	 */
	public java.lang.String getChasize () {
		return chasize;
	}

	/**
	 * Set the value related to the column: CHASIZE
	 * @param chasize the CHASIZE value
	 */
	public void setChasize (java.lang.String chasize) {
		this.chasize = chasize;
	}



	/**
	 * Return the value associated with the column: CHATYPE
	 */
	public java.lang.String getChatype () {
		return chatype;
	}

	/**
	 * Set the value related to the column: CHATYPE
	 * @param chatype the CHATYPE value
	 */
	public void setChatype (java.lang.String chatype) {
		this.chatype = chatype;
	}



	/**
	 * Return the value associated with the column: CHACUEIR
	 */
	public java.lang.String getChacueir () {
		return chacueir;
	}

	/**
	 * Set the value related to the column: CHACUEIR
	 * @param chacueir the CHACUEIR value
	 */
	public void setChacueir (java.lang.String chacueir) {
		this.chacueir = chacueir;
	}



	/**
	 * Return the value associated with the column: CHASTACK
	 */
	public boolean isChastack () {
		return chastack;
	}

	/**
	 * Set the value related to the column: CHASTACK
	 * @param chastack the CHASTACK value
	 */
	public void setChastack (boolean chastack) {
		this.chastack = chastack;
	}



	/**
	 * Return the value associated with the column: CHAPLATE
	 */
	public java.lang.String getChaplate () {
		return chaplate;
	}

	/**
	 * Set the value related to the column: CHAPLATE
	 * @param chaplate the CHAPLATE value
	 */
	public void setChaplate (java.lang.String chaplate) {
		this.chaplate = chaplate;
	}



	/**
	 * Return the value associated with the column: CHAEXPDT
	 */
	public java.util.Date getChaexpdt () {
		return chaexpdt;
	}

	/**
	 * Set the value related to the column: CHAEXPDT
	 * @param chaexpdt the CHAEXPDT value
	 */
	public void setChaexpdt (java.util.Date chaexpdt) {
		this.chaexpdt = chaexpdt;
	}



	/**
	 * Return the value associated with the column: CHAFHDTE
	 */
	public java.util.Date getChafhdte () {
		return chafhdte;
	}

	/**
	 * Set the value related to the column: CHAFHDTE
	 * @param chafhdte the CHAFHDTE value
	 */
	public void setChafhdte (java.util.Date chafhdte) {
		this.chafhdte = chafhdte;
	}



	/**
	 * Return the value associated with the column: CHAFHEXT
	 */
	public java.lang.String getChafhext () {
		return chafhext;
	}

	/**
	 * Set the value related to the column: CHAFHEXT
	 * @param chafhext the CHAFHEXT value
	 */
	public void setChafhext (java.lang.String chafhext) {
		this.chafhext = chafhext;
	}



	/**
	 * Return the value associated with the column: CHANEWST
	 */
	public java.lang.String getChanewst () {
		return chanewst;
	}

	/**
	 * Set the value related to the column: CHANEWST
	 * @param chanewst the CHANEWST value
	 */
	public void setChanewst (java.lang.String chanewst) {
		this.chanewst = chanewst;
	}



	/**
	 * Return the value associated with the column: CHANEWPT
	 */
	public java.lang.String getChanewpt () {
		return chanewpt;
	}

	/**
	 * Set the value related to the column: CHANEWPT
	 * @param chanewpt the CHANEWPT value
	 */
	public void setChanewpt (java.lang.String chanewpt) {
		this.chanewpt = chanewpt;
	}



	/**
	 * Return the value associated with the column: scac
	 */
	public java.lang.String getScac () {
		return scac;
	}

	/**
	 * Set the value related to the column: scac
	 * @param scac the scac value
	 */
	public void setScac (java.lang.String scac) {
		this.scac = scac;
	}



	/**
	 * Return the value associated with the column: TRACTOR
	 */
	public java.lang.String getTractor () {
		return tractor;
	}

	/**
	 * Set the value related to the column: TRACTOR
	 * @param tractor the TRACTOR value
	 */
	public void setTractor (java.lang.String tractor) {
		this.tractor = tractor;
	}



	/**
	 * Return the value associated with the column: SHIPSEAL
	 */
	public java.lang.String getShipseal () {
		return shipseal;
	}

	/**
	 * Set the value related to the column: SHIPSEAL
	 * @param shipseal the SHIPSEAL value
	 */
	public void setShipseal (java.lang.String shipseal) {
		this.shipseal = shipseal;
	}



	/**
	 * Return the value associated with the column: CUSTREM
	 */
	public java.lang.String getCustrem () {
		return custrem;
	}

	/**
	 * Set the value related to the column: CUSTREM
	 * @param custrem the CUSTREM value
	 */
	public void setCustrem (java.lang.String custrem) {
		this.custrem = custrem;
	}



	/**
	 * Return the value associated with the column: INTREM
	 */
	public java.lang.String getIntrem () {
		return intrem;
	}

	/**
	 * Set the value related to the column: INTREM
	 * @param intrem the INTREM value
	 */
	public void setIntrem (java.lang.String intrem) {
		this.intrem = intrem;
	}



	/**
	 * Return the value associated with the column: CDXREF
	 */
	public java.lang.String getCdxref () {
		return cdxref;
	}

	/**
	 * Set the value related to the column: CDXREF
	 * @param cdxref the CDXREF value
	 */
	public void setCdxref (java.lang.String cdxref) {
		this.cdxref = cdxref;
	}



	/**
	 * Return the value associated with the column: CDXREDEL
	 */
	public java.lang.String getCdxredel () {
		return cdxredel;
	}

	/**
	 * Set the value related to the column: CDXREDEL
	 * @param cdxredel the CDXREDEL value
	 */
	public void setCdxredel (java.lang.String cdxredel) {
		this.cdxredel = cdxredel;
	}



	/**
	 * Return the value associated with the column: GRADE
	 */
	public java.lang.String getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: GRADE
	 * @param grade the GRADE value
	 */
	public void setGrade (java.lang.String grade) {
		this.grade = grade;
	}



	/**
	 * Return the value associated with the column: CONCOND
	 */
	public java.lang.String getConcond () {
		return concond;
	}

	/**
	 * Set the value related to the column: CONCOND
	 * @param concond the CONCOND value
	 */
	public void setConcond (java.lang.String concond) {
		this.concond = concond;
	}



	/**
	 * Return the value associated with the column: CHACOND
	 */
	public java.lang.String getChacond () {
		return chacond;
	}

	/**
	 * Set the value related to the column: CHACOND
	 * @param chacond the CHACOND value
	 */
	public void setChacond (java.lang.String chacond) {
		this.chacond = chacond;
	}



	/**
	 * Return the value associated with the column: GRIDLOC
	 */
	public java.lang.String getGridloc () {
		return gridloc;
	}

	/**
	 * Set the value related to the column: GRIDLOC
	 * @param gridloc the GRIDLOC value
	 */
	public void setGridloc (java.lang.String gridloc) {
		this.gridloc = gridloc;
	}



	/**
	 * Return the value associated with the column: waiveinspfee
	 */
	public boolean isWaiveinspfee () {
		return waiveinspfee;
	}

	/**
	 * Set the value related to the column: waiveinspfee
	 * @param waiveinspfee the waiveinspfee value
	 */
	public void setWaiveinspfee (boolean waiveinspfee) {
		this.waiveinspfee = waiveinspfee;
	}



	/**
	 * Return the value associated with the column: waiveliftfee
	 */
	public boolean isWaiveliftfee () {
		return waiveliftfee;
	}

	/**
	 * Set the value related to the column: waiveliftfee
	 * @param waiveliftfee the waiveliftfee value
	 */
	public void setWaiveliftfee (boolean waiveliftfee) {
		this.waiveliftfee = waiveliftfee;
	}



	/**
	 * Return the value associated with the column: UPDTDATE
	 */
	public java.util.Date getUpdtdate () {
		return updtdate;
	}

	/**
	 * Set the value related to the column: UPDTDATE
	 * @param updtdate the UPDTDATE value
	 */
	public void setUpdtdate (java.util.Date updtdate) {
		this.updtdate = updtdate;
	}



	/**
	 * Return the value associated with the column: UPDTTIME
	 */
	public java.lang.String getUpdttime () {
		return updttime;
	}

	/**
	 * Set the value related to the column: UPDTTIME
	 * @param updttime the UPDTTIME value
	 */
	public void setUpdttime (java.lang.String updttime) {
		this.updttime = updttime;
	}



	/**
	 * Return the value associated with the column: shuttlemove
	 */
	public boolean isShuttlemove () {
		return shuttlemove;
	}

	/**
	 * Set the value related to the column: shuttlemove
	 * @param shuttlemove the shuttlemove value
	 */
	public void setShuttlemove (boolean shuttlemove) {
		this.shuttlemove = shuttlemove;
	}



	/**
	 * Return the value associated with the column: SHUTTLFEE
	 */
	public java.math.BigDecimal getShuttlfee () {
		return shuttlfee;
	}

	/**
	 * Set the value related to the column: SHUTTLFEE
	 * @param shuttlfee the SHUTTLFEE value
	 */
	public void setShuttlfee (java.math.BigDecimal shuttlfee) {
		this.shuttlfee = shuttlfee;
	}



	/**
	 * Return the value associated with the column: shuttlecustomeraddrkey
	 */
	public java.lang.String getShuttlecustomeraddrkey () {
		return shuttlecustomeraddrkey;
	}

	/**
	 * Set the value related to the column: shuttlecustomeraddrkey
	 * @param shuttlecustomeraddrkey the shuttlecustomeraddrkey value
	 */
	public void setShuttlecustomeraddrkey (java.lang.String shuttlecustomeraddrkey) {
		this.shuttlecustomeraddrkey = shuttlecustomeraddrkey;
	}



	/**
	 * Return the value associated with the column: droplot
	 */
	public boolean isDroplot () {
		return droplot;
	}

	/**
	 * Set the value related to the column: droplot
	 * @param droplot the droplot value
	 */
	public void setDroplot (boolean droplot) {
		this.droplot = droplot;
	}



	/**
	 * Return the value associated with the column: dropcustomeraddrkey
	 */
	public java.lang.String getDropcustomeraddrkey () {
		return dropcustomeraddrkey;
	}

	/**
	 * Set the value related to the column: dropcustomeraddrkey
	 * @param dropcustomeraddrkey the dropcustomeraddrkey value
	 */
	public void setDropcustomeraddrkey (java.lang.String dropcustomeraddrkey) {
		this.dropcustomeraddrkey = dropcustomeraddrkey;
	}



	/**
	 * Return the value associated with the column: foreigntarget
	 */
	public boolean isForeigntarget () {
		return foreigntarget;
	}

	/**
	 * Set the value related to the column: foreigntarget
	 * @param foreigntarget the foreigntarget value
	 */
	public void setForeigntarget (boolean foreigntarget) {
		this.foreigntarget = foreigntarget;
	}



	/**
	 * Return the value associated with the column: cha2
	 */
	public java.lang.String getCha2 () {
		return cha2;
	}

	/**
	 * Set the value related to the column: cha2
	 * @param cha2 the cha2 value
	 */
	public void setCha2 (java.lang.String cha2) {
		this.cha2 = cha2;
	}



	/**
	 * Return the value associated with the column: CHAEIR2
	 */
	public java.lang.String getChaeir2 () {
		return chaeir2;
	}

	/**
	 * Set the value related to the column: CHAEIR2
	 * @param chaeir2 the CHAEIR2 value
	 */
	public void setChaeir2 (java.lang.String chaeir2) {
		this.chaeir2 = chaeir2;
	}



	/**
	 * Return the value associated with the column: cha3
	 */
	public java.lang.String getCha3 () {
		return cha3;
	}

	/**
	 * Set the value related to the column: cha3
	 * @param cha3 the cha3 value
	 */
	public void setCha3 (java.lang.String cha3) {
		this.cha3 = cha3;
	}



	/**
	 * Return the value associated with the column: CHAEIR3
	 */
	public java.lang.String getChaeir3 () {
		return chaeir3;
	}

	/**
	 * Set the value related to the column: CHAEIR3
	 * @param chaeir3 the CHAEIR3 value
	 */
	public void setChaeir3 (java.lang.String chaeir3) {
		this.chaeir3 = chaeir3;
	}



	/**
	 * Return the value associated with the column: cha4
	 */
	public java.lang.String getCha4 () {
		return cha4;
	}

	/**
	 * Set the value related to the column: cha4
	 * @param cha4 the cha4 value
	 */
	public void setCha4 (java.lang.String cha4) {
		this.cha4 = cha4;
	}



	/**
	 * Return the value associated with the column: CHAEIR4
	 */
	public java.lang.String getChaeir4 () {
		return chaeir4;
	}

	/**
	 * Set the value related to the column: CHAEIR4
	 * @param chaeir4 the CHAEIR4 value
	 */
	public void setChaeir4 (java.lang.String chaeir4) {
		this.chaeir4 = chaeir4;
	}



	/**
	 * Return the value associated with the column: cha5
	 */
	public java.lang.String getCha5 () {
		return cha5;
	}

	/**
	 * Set the value related to the column: cha5
	 * @param cha5 the cha5 value
	 */
	public void setCha5 (java.lang.String cha5) {
		this.cha5 = cha5;
	}



	/**
	 * Return the value associated with the column: CHAEIR5
	 */
	public java.lang.String getChaeir5 () {
		return chaeir5;
	}

	/**
	 * Set the value related to the column: CHAEIR5
	 * @param chaeir5 the CHAEIR5 value
	 */
	public void setChaeir5 (java.lang.String chaeir5) {
		this.chaeir5 = chaeir5;
	}



	/**
	 * Return the value associated with the column: targeteq
	 */
	public java.lang.String getTargeteq () {
		return targeteq;
	}

	/**
	 * Set the value related to the column: targeteq
	 * @param targeteq the targeteq value
	 */
	public void setTargeteq (java.lang.String targeteq) {
		this.targeteq = targeteq;
	}



	/**
	 * Return the value associated with the column: CONMFG
	 */
	public java.lang.String getConmfg () {
		return conmfg;
	}

	/**
	 * Set the value related to the column: CONMFG
	 * @param conmfg the CONMFG value
	 */
	public void setConmfg (java.lang.String conmfg) {
		this.conmfg = conmfg;
	}



	/**
	 * Return the value associated with the column: CONMFGDT
	 */
	public java.util.Date getConmfgdt () {
		return conmfgdt;
	}

	/**
	 * Set the value related to the column: CONMFGDT
	 * @param conmfgdt the CONMFGDT value
	 */
	public void setConmfgdt (java.util.Date conmfgdt) {
		this.conmfgdt = conmfgdt;
	}



	/**
	 * Return the value associated with the column: CHAMFG
	 */
	public java.lang.String getChamfg () {
		return chamfg;
	}

	/**
	 * Set the value related to the column: CHAMFG
	 * @param chamfg the CHAMFG value
	 */
	public void setChamfg (java.lang.String chamfg) {
		this.chamfg = chamfg;
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
		if (!(obj instanceof com.bureaueye.beacon.model.dsactivity.Dsingate)) return false;
		else {
			com.bureaueye.beacon.model.dsactivity.Dsingate dsingate = (com.bureaueye.beacon.model.dsactivity.Dsingate) obj;
			if (null == this.getDsingateId() || null == dsingate.getDsingateId()) return false;
			else return (this.getDsingateId().equals(dsingate.getDsingateId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getDsingateId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getDsingateId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}