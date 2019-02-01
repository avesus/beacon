package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the unit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="unit"
 */

public abstract class BaseUnit  implements Serializable {

	public static String REF = "Unit";
	public static String PROP_XUNITKEY = "Xunitkey";
	public static String PROP_POSCHG = "Poschg";
	public static String PROP_REPAIRBY = "Repairby";
	public static String PROP_CAPIMPG = "Capimpg";
	public static String PROP_UN = "Un";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_MOVESTS = "Movests";
	public static String PROP_TARE = "Tare";
	public static String PROP_DMTHICK = "Dmthick";
	public static String PROP_LASTSTAT = "Laststat";
	public static String PROP_CALIBDOCDATE = "Calibdocdate";
	public static String PROP_JOBMOVDATE = "Jobmovdate";
	public static String PROP_TBWORK = "Tbwork";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_BILLFIRSTDATE = "Billfirstdate";
	public static String PROP_STACKW = "Stackw";
	public static String PROP_AAR = "Aar";
	public static String PROP_EQPKEY = "Eqpkey";
	public static String PROP_CERTIFDOCFILE = "Certifdocfile";
	public static String PROP_MFPRICE = "Mfprice";
	public static String PROP_OPTDATE = "Optdate";
	public static String PROP_TDESMAXF = "Tdesmaxf";
	public static String PROP_LESSEEADDRKEY = "Lesseeaddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_MOVEMSGTXT = "Movemsgtxt";
	public static String PROP_OPRSYSBLOCKALLOC = "Oprsysblockalloc";
	public static String PROP_MOVELOCATIONKEY = "Movelocationkey";
	public static String PROP_DISPOSALADDRKEY = "Disposaladdrkey";
	public static String PROP_MOVEADDRKEY = "Moveaddrkey";
	public static String PROP_WSTATUS = "Wstatus";
	public static String PROP_TKWORKP = "Tkworkp";
	public static String PROP_MFDATE = "Mfdate";
	public static String PROP_OPTEQPIDKEY = "Opteqpidkey";
	public static String PROP_HEADMAT = "Headmat";
	public static String PROP_JOBMOVREF = "Jobmovref";
	public static String PROP_ONHIRE_ID = "OnhireId";
	public static String PROP_JOBMOVTIME = "Jobmovtime";
	public static String PROP_MATRILS = "Matrils";
	public static String PROP_TKTEST = "Tktest";
	public static String PROP_OFFHIRE_ID = "OffhireId";
	public static String PROP_SSURARAP = "Ssurarap";
	public static String PROP_WRITEOFFREASON = "Writeoffreason";
	public static String PROP_RVALPRSP = "Rvalprsp";
	public static String PROP_UIC = "Uic";
	public static String PROP_OPRSYSMSGDATE = "Oprsysmsgdate";
	public static String PROP_TMAXCAR = "Tmaxcar";
	public static String PROP_ALTISO = "Altiso";
	public static String PROP_JOBMOVVESSEL = "Jobmovvessel";
	public static String PROP_MGRADDRKEY = "Mgraddrkey";
	public static String PROP_THFYEAR = "Thfyear";
	public static String PROP_JOBMOVLOCATIONKEY = "Jobmovlocationkey";
	public static String PROP_ACTOFFDATE = "Actoffdate";
	public static String PROP_LASTOP = "Lastop";
	public static String PROP_TMDMIN = "Tmdmin";
	public static String PROP_DRAWGRPKEY = "Drawgrpkey";
	public static String PROP_RID = "Rid";
	public static String PROP_DRAWFILE1 = "Drawfile1";
	public static String PROP_POKEY = "Pokey";
	public static String PROP_DRAWFILE2 = "Drawfile2";
	public static String PROP_CALIBDOCFILE = "Calibdocfile";
	public static String PROP_DRAWFILE3 = "Drawfile3";
	public static String PROP_MOVTYPEKEY = "Movtypekey";
	public static String PROP_THLEAK = "Thleak";
	public static String PROP_JOBMOVTIMEINMILLIS = "Jobmovtimeinmillis";
	public static String PROP_IMO = "Imo";
	public static String PROP_TIR = "Tir";
	public static String PROP_MOVETIME = "Movetime";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_MFCDE = "Mfcde";
	public static String PROP_ASME = "Asme";
	public static String PROP_TDESMINF = "Tdesminf";
	public static String PROP_TBWORKP = "Tbworkp";
	public static String PROP_TRANFRO = "Tranfro";
	public static String PROP_INTERMGRADDRKEY = "Intermgraddrkey";
	public static String PROP_ORIGUNITKEY = "Origunitkey";
	public static String PROP_CAPUSG = "Capusg";
	public static String PROP_MAINTEST = "Maintest";
	public static String PROP_ADR = "Adr";
	public static String PROP_TDESMAX = "Tdesmax";
	public static String PROP_RECORDKEY = "Recordkey";
	public static String PROP_TKTESTP = "Tktestp";
	public static String PROP_DIR = "Dir";
	public static String PROP_OFFHIREEQP_ID = "OffhireeqpId";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_TBTESTP = "Tbtestp";
	public static String PROP_TKWORK = "Tkwork";
	public static String PROP_IMOKEY = "Imokey";
	public static String PROP_TMAXCARF = "Tmaxcarf";
	public static String PROP_PREVISONUMKEY = "Previsonumkey";
	public static String PROP_ATT = "Att";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_SHDEPSS = "Shdepss";
	public static String PROP_RESERVETIME = "Reservetime";
	public static String PROP_LASTBY = "Lastby";
	public static String PROP_FIVTYPE = "Fivtype";
	public static String PROP_WRITEOFFDATE = "Writeoffdate";
	public static String PROP_RESERVEBOOKKEY = "Reservebookkey";
	public static String PROP_CSCDATE = "Cscdate";
	public static String PROP_MRKEY = "Mrkey";
	public static String PROP_FRAMDES = "Framdes";
	public static String PROP_MOVEPRODUCTKEY = "Moveproductkey";
	public static String PROP_PLANREB = "Planreb";
	public static String PROP_MFNUM = "Mfnum";
	public static String PROP_MFADDRKEY = "Mfaddrkey";
	public static String PROP_LASTWHERE = "Lastwhere";
	public static String PROP_WIDTHI = "Widthi";
	public static String PROP_WIDTHF = "Widthf";
	public static String PROP_EIRRECHG = "Eirrechg";
	public static String PROP_PAYLOAD = "Payload";
	public static String PROP_OPTLPREFNOKEY = "Optlprefnokey";
	public static String PROP_ONHIREEQP_ID = "OnhireeqpId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_INTERMGRACCEPTID = "Intermgracceptid";
	public static String PROP_PREVADDRKEY = "Prevaddrkey";
	public static String PROP_SSURARA = "Ssurara";
	public static String PROP_PAYLOADL = "Payloadl";
	public static String PROP_HEIGHTF = "Heightf";
	public static String PROP_MOVEEIRDATE = "Moveeirdate";
	public static String PROP_ONHIREDATE = "Onhiredate";
	public static String PROP_CAPCFEE = "Capcfee";
	public static String PROP_JFA = "Jfa";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CAPCM = "Capcm";
	public static String PROP_ACTOFFADDRKEY = "Actoffaddrkey";
	public static String PROP_UNITTCODE = "Unittcode";
	public static String PROP_MOVEREF = "Moveref";
	public static String PROP_INVSTS = "Invsts";
	public static String PROP_SYSIDKEY = "Sysidkey";
	public static String PROP_TMDMAXF = "Tmdmaxf";
	public static String PROP_WLOCAT = "Wlocat";
	public static String PROP_DOT51 = "Dot51";
	public static String PROP_DISPOSALDATE = "Disposaldate";
	public static String PROP_FSTTYPE = "Fsttype";
	public static String PROP_NEWPROD = "Newprod";
	public static String PROP_FSTWHERE = "Fstwhere";
	public static String PROP_MOVESEQNO = "Moveseqno";
	public static String PROP_RESERVEPRECLEARKEY = "Reservepreclearkey";
	public static String PROP_THFTYPE = "Thftype";
	public static String PROP_G2KEY = "G2key";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_NEXTTESTDESCR = "Nexttestdescr";
	public static String PROP_SHDEPMS = "Shdepms";
	public static String PROP_EQPKEYP5 = "Eqpkeyp5";
	public static String PROP_EQPKEYP6 = "Eqpkeyp6";
	public static String PROP_EQPKEYP7 = "Eqpkeyp7";
	public static String PROP_EQPKEYP8 = "Eqpkeyp8";
	public static String PROP_EQPKEYP9 = "Eqpkeyp9";
	public static String PROP_OPTEXPIRES = "Optexpires";
	public static String PROP_EQPKEYP10 = "Eqpkeyp10";
	public static String PROP_MOVEDATE = "Movedate";
	public static String PROP_TEUCOUNT = "Teucount";
	public static String PROP_FOODGRAD = "Foodgrad";
	public static String PROP_G4KEY = "G4key";
	public static String PROP_G3KEY = "G3key";
	public static String PROP_LASTLSE = "Lastlse";
	public static String PROP_DISPOSALNOTES = "Disposalnotes";
	public static String PROP_TAREL = "Tarel";
	public static String PROP_CSC = "Csc";
	public static String PROP_WMOVETYP = "Wmovetyp";
	public static String PROP_RVALVACP = "Rvalvacp";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPKEYP4 = "Eqpkeyp4";
	public static String PROP_EQPKEYP3 = "Eqpkeyp3";
	public static String PROP_EQPKEYP2 = "Eqpkeyp2";
	public static String PROP_EQPKEYP1 = "Eqpkeyp1";
	public static String PROP_USDOT = "Usdot";
	public static String PROP_FSTDATE = "Fstdate";
	public static String PROP_CTC = "Ctc";
	public static String PROP_GROSS = "Gross";
	public static String PROP_ONHIREADDRKEY = "Onhireaddrkey";
	public static String PROP_TRANTO = "Tranto";
	public static String PROP_LENGTH = "Length";
	public static String PROP_HEIGHTI = "Heighti";
	public static String PROP_TMDMAX = "Tmdmax";
	public static String PROP_OPTADDRKEY = "Optaddrkey";
	public static String PROP_MOVEMSGDISP = "Movemsgdisp";
	public static String PROP_MOVENOTES = "Movenotes";
	public static String PROP_MOVEEIRKEY = "Moveeirkey";
	public static String PROP_OPTRESNO = "Optresno";
	public static String PROP_RVALVAC = "Rvalvac";
	public static String PROP_RVALPRS = "Rvalprs";
	public static String PROP_ESTSTS = "Eststs";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_WRITEOFFFLAG = "Writeoffflag";
	public static String PROP_TBTEST = "Tbtest";
	public static String PROP_OPTUSER = "Optuser";
	public static String PROP_OPRSYSALLOCTXT = "Oprsysalloctxt";
	public static String PROP_INTERMGRDATE = "Intermgrdate";
	public static String PROP_PREVUNITKEY = "Prevunitkey";
	public static String PROP_WIDTH = "Width";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_TDESMIN = "Tdesmin";
	public static String PROP_MOVEMSGSTOP = "Movemsgstop";
	public static String PROP_UKDOT = "Ukdot";
	public static String PROP_MANUFLOCATIONKEY = "Manuflocationkey";
	public static String PROP_MOVEMSGDATE = "Movemsgdate";
	public static String PROP_GRITFIN = "Gritfin";
	public static String PROP_MAXTRIPS = "Maxtrips";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_PODTLRCVD_ID = "PodtlrcvdId";
	public static String PROP_CAPLIT = "Caplit";
	public static String PROP_GROSSL = "Grossl";
	public static String PROP_OPTFLAG = "Optflag";
	public static String PROP_FSTBY = "Fstby";
	public static String PROP_EIRDEPOTADDRKEY = "Eirdepotaddrkey";
	public static String PROP_MOVETIMEINMILLIS = "Movetimeinmillis";
	public static String PROP_TMDMINF = "Tmdminf";
	public static String PROP_NEXTTESTDUE = "Nexttestdue";
	public static String PROP_OWNERKEY = "Ownerkey";
	public static String PROP_TOPSPOOLNO = "Topspoolno";
	public static String PROP_LASTDATE = "Lastdate";
	public static String PROP_WAREXP = "Warexp";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LENGTHI = "Lengthi";
	public static String PROP_BAM = "Bam";
	public static String PROP_LENGTHF = "Lengthf";
	public static String PROP_REPAIRDATE = "Repairdate";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_LSTTYPE = "Lsttype";
	public static String PROP_INVSTSDATE = "Invstsdate";
	public static String PROP_G1KEY = "G1key";
	public static String PROP_STACKNO = "Stackno";
	public static String PROP_SHTHICK = "Shthick";
	public static String PROP_RESERVEDATE = "Reservedate";
	public static String PROP_DRAWTITLE1 = "Drawtitle1";
	public static String PROP_DRAWTITLE2 = "Drawtitle2";
	public static String PROP_DRAWTITLE3 = "Drawtitle3";
	public static String PROP_CERTIFDOCDATE = "Certifdocdate";
	public static String PROP_FRAMTYP = "Framtyp";
	public static String PROP_WMOVEDATE = "Wmovedate";
	public static String PROP_ALLOCNUMBER = "Allocnumber";
	public static String PROP_NEXTTEST = "Nexttest";
	public static String PROP_INVSTSBY = "Invstsby";
	public static String PROP_DEPTD = "Deptd";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_UNITSPECNO = "Unitspecno";
	public static String PROP_FIVEYEAR = "Fiveyear";
	public static String PROP_EIRCOST = "Eircost";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseUnit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnit (java.lang.Integer unitId) {
		this.setUnitId(unitId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer unitId;

	// fields
	private java.lang.String eqpkeyp5;
	private java.lang.String lesseeaddrkey;
	private java.lang.String mgraddrkey;
	private java.lang.String systemlogaction;
	private java.lang.String lastop;
	private java.util.Date fstdate;
	private java.math.BigDecimal tdesmaxf;
	private java.lang.String imokey;
	private java.lang.String drawgrpkey;
	private java.lang.String reservebookkey;
	private java.lang.String lsttype;
	private java.math.BigDecimal deptd;
	private java.lang.String eqpkeyp4;
	private java.lang.String movtypekey;
	private java.util.Date optdate;
	private java.lang.String disposalnotes;
	private java.lang.Integer lengthf;
	private java.util.Date onhiredate;
	private java.lang.String wlocat;
	private java.lang.String invstsby;
	private java.lang.String prevaddrkey;
	private java.util.Date repairdate;
	private java.lang.String nexttest;
	private java.math.BigDecimal poschg;
	private java.lang.String eststs;
	private java.lang.Integer thleak;
	private boolean writeoffflag;
	private java.math.BigDecimal tmdmax;
	private java.math.BigDecimal rvalvac;
	private java.math.BigDecimal ssurarap;
	private java.lang.String systemloguserid;
	private java.math.BigDecimal ssurara;
	private java.lang.String unitspecno;
	private java.lang.String eqpkey;
	private java.lang.String g3key;
	private boolean xinactive;
	private java.math.BigDecimal tbwork;
	private java.lang.String previsonumkey;
	private java.lang.Integer capusg;
	private java.lang.String g4key;
	private java.lang.Integer heighti;
	private java.util.Date actoffdate;
	private java.lang.Integer lengthi;
	private boolean foodgrad;
	private boolean ukdot;
	private java.math.BigDecimal eirrechg;
	private boolean csc;
	private java.lang.String matrils;
	private java.lang.Integer width;
	private boolean adr;
	private java.math.BigDecimal tmdmin;
	private java.math.BigDecimal tdesmin;
	private java.lang.String drawfile3;
	private boolean dir;
	private java.math.BigDecimal rvalprsp;
	private java.math.BigDecimal tmaxcar;
	private java.util.Date oprsysmsgdate;
	private java.lang.String prevunitkey;
	private java.lang.String fivtype;
	private java.math.BigDecimal tmaxcarf;
	private java.lang.String g2key;
	private java.lang.String optaddrkey;
	private java.util.Date lastdate;
	private java.lang.Integer widthi;
	private java.lang.String drawfile2;
	private java.util.Date writeoffdate;
	private java.math.BigDecimal tbtest;
	private java.lang.String oprsysalloctxt;
	private java.lang.String drawfile1;
	private java.util.Date invstsdate;
	private java.lang.Integer teucount;
	private java.lang.String framtyp;
	private java.util.Date planreb;
	private java.lang.String lastlse;
	private java.lang.String mfnum;
	private java.math.BigDecimal tranfro;
	private java.util.Date certifdocdate;
	private java.lang.String eqpkeyp9;
	private java.lang.String recordkey;
	private java.util.Date cscdate;
	private java.lang.String topspoolno;
	private java.math.BigDecimal tkworkp;
	private java.lang.String nexttestdescr;
	private java.lang.String eqpkeyp10;
	private java.lang.String lastby;
	private boolean oprsysblockalloc;
	private java.math.BigDecimal shthick;
	private java.math.BigDecimal tktestp;
	private java.lang.String thftype;
	private java.math.BigDecimal tdesminf;
	private java.lang.Integer stackno;
	private java.lang.String intermgraddrkey;
	private java.lang.String fstby;
	private java.util.Date wmovedate;
	private java.lang.String systemlogprogram;
	private java.lang.String repairby;
	private java.lang.String calibdocfile;
	private java.lang.String opteqpidkey;
	private java.lang.String disposaladdrkey;
	private java.math.BigDecimal tktest;
	private java.util.Date systemlogdate;
	private java.lang.String eirdepotaddrkey;
	private boolean dot51;
	private java.lang.String eqpkeyp7;
	private java.lang.Integer payloadl;
	private java.lang.String ownerkey;
	private boolean optflag;
	private java.lang.String actoffaddrkey;
	private java.util.Date mfdate;
	private java.lang.Integer payload;
	private java.lang.String unitkey;
	private boolean imo;
	private java.util.Date nexttestdue;
	private java.util.Date fiveyear;
	private java.lang.Integer capcfee;
	private java.lang.String eqpkeyp8;
	private java.util.Date calibdocdate;
	private java.lang.String fsttype;
	private java.lang.String optlprefnokey;
	private java.math.BigDecimal tbtestp;
	private boolean tir;
	private boolean usdot;
	private java.lang.String eqpkeyp6;
	private java.lang.String xunitkey;
	private java.lang.String origunitkey;
	private java.lang.String sysidkey;
	private boolean att;
	private java.math.BigDecimal eircost;
	private java.lang.String wmovetyp;
	private java.lang.String unittcode;
	private java.math.BigDecimal tkwork;
	private java.math.BigDecimal tranto;
	private java.lang.Integer stackw;
	private java.lang.Integer tare;
	private java.lang.String companykey;
	private java.lang.Integer grossl;
	private java.lang.String reservetime;
	private java.util.Date optexpires;
	private java.math.BigDecimal shdepms;
	private java.math.BigDecimal tdesmax;
	private java.lang.Integer length;
	private boolean un;
	private java.lang.String onhireaddrkey;
	private boolean jfa;
	private java.lang.String wstatus;
	private java.lang.String mrkey;
	private java.lang.String maintest;
	private java.math.BigDecimal shdepss;
	private java.lang.String laststat;
	private java.util.Date billfirstdate;
	private java.lang.Integer capimpg;
	private java.math.BigDecimal tbworkp;
	private boolean rid;
	private java.util.Date reservedate;
	private java.lang.String certifdocfile;
	private java.lang.String gritfin;
	private boolean aar;
	private java.math.BigDecimal mfprice;
	private java.lang.Integer widthf;
	private java.math.BigDecimal tmdminf;
	private java.lang.String departmentkey;
	private java.math.BigDecimal tmdmaxf;
	private java.lang.Integer gross;
	private java.lang.String drawtitle2;
	private java.math.BigDecimal rvalprs;
	private java.lang.String reservepreclearkey;
	private java.lang.String optuser;
	private java.lang.String systemlogtime;
	private java.lang.String headmat;
	private boolean newprod;
	private java.lang.String drawtitle3;
	private java.lang.String lastwhere;
	private boolean deleted;
	private boolean uic;
	private boolean bam;
	private java.lang.String framdes;
	private java.lang.String eqpkeyp1;
	private java.lang.Integer allocnumber;
	private java.lang.String createtime;
	private java.util.Date warexp;
	private boolean ctc;
	private boolean asme;
	private java.math.BigDecimal dmthick;
	private java.util.Date thfyear;
	private java.lang.String xlock;
	private java.lang.String fstwhere;
	private java.lang.Integer tarel;
	private java.lang.Integer heightf;
	private java.util.Date intermgrdate;
	private java.lang.String eqpkeyp2;
	private java.lang.String g1key;
	private java.lang.String mfcde;
	private java.lang.String eqpkeyp3;
	private java.lang.Integer height;
	private java.lang.String writeoffreason;
	private java.lang.Integer capcm;
	private java.lang.Integer caplit;
	private java.lang.String intermgracceptid;
	private java.lang.String drawtitle1;
	private java.lang.String pokey;
	private java.lang.Integer optresno;
	private java.lang.String createuserid;
	private java.math.BigDecimal rvalvacp;
	private java.lang.String altiso;
	private java.util.Date disposaldate;
	private java.lang.Integer maxtrips;
	private java.util.Date createdate;
	private java.lang.String activitykey;
	private java.lang.String mfaddrkey;
	private java.util.Date movemsgdate;
	private java.lang.String movemsgtxt;
	private java.lang.Integer moveseqno;
	private java.util.Date moveeirdate;
	private java.lang.String moveeirkey;
	private boolean movemsgstop;
	private boolean movemsgdisp;
	private java.lang.String movenotes;
	private java.util.Date movedate;
	private java.lang.Long movetimeinmillis;
	private java.lang.String movetime;
	private java.lang.String moveaddrkey;
	private java.lang.String moveref;
	private java.lang.String moveproductkey;
	private java.lang.String movests;
	private java.util.Date jobmovdate;
	private java.lang.String jobmovtime;
	private java.lang.Long jobmovtimeinmillis;
	private java.lang.String jobmovvessel;
	private java.lang.String invsts;
	private java.lang.String jobmovref;
	private java.lang.Integer podtlrcvdId;
	private java.lang.Integer onhireId;
	private java.lang.Integer offhireId;
	private java.lang.Integer onhireeqpId;
	private java.lang.Integer offhireeqpId;
	private java.lang.String movelocationkey;
	private java.lang.String jobmovlocationkey;
	private java.lang.String manuflocationkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNIT_ID"
     */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitId the new ID
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String eqpkeyp5) {
		this.eqpkeyp5 = eqpkeyp5;
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
	 * Return the value associated with the column: mgraddrkey
	 */
	public java.lang.String getMgraddrkey () {
		return mgraddrkey;
	}

	/**
	 * Set the value related to the column: mgraddrkey
	 * @param mgraddrkey the mgraddrkey value
	 */
	public void setMgraddrkey (java.lang.String mgraddrkey) {
		this.mgraddrkey = mgraddrkey;
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
	 * Return the value associated with the column: lastop
	 */
	public java.lang.String getLastop () {
		return lastop;
	}

	/**
	 * Set the value related to the column: lastop
	 * @param lastop the lastop value
	 */
	public void setLastop (java.lang.String lastop) {
		this.lastop = lastop;
	}



	/**
	 * Return the value associated with the column: fstdate
	 */
	public java.util.Date getFstdate () {
		return fstdate;
	}

	/**
	 * Set the value related to the column: fstdate
	 * @param fstdate the fstdate value
	 */
	public void setFstdate (java.util.Date fstdate) {
		this.fstdate = fstdate;
	}



	/**
	 * Return the value associated with the column: tdesmaxf
	 */
	public java.math.BigDecimal getTdesmaxf () {
		return tdesmaxf;
	}

	/**
	 * Set the value related to the column: tdesmaxf
	 * @param tdesmaxf the tdesmaxf value
	 */
	public void setTdesmaxf (java.math.BigDecimal tdesmaxf) {
		this.tdesmaxf = tdesmaxf;
	}



	/**
	 * Return the value associated with the column: imokey
	 */
	public java.lang.String getImokey () {
		return imokey;
	}

	/**
	 * Set the value related to the column: imokey
	 * @param imokey the imokey value
	 */
	public void setImokey (java.lang.String imokey) {
		this.imokey = imokey;
	}



	/**
	 * Return the value associated with the column: drawgrpkey
	 */
	public java.lang.String getDrawgrpkey () {
		return drawgrpkey;
	}

	/**
	 * Set the value related to the column: drawgrpkey
	 * @param drawgrpkey the drawgrpkey value
	 */
	public void setDrawgrpkey (java.lang.String drawgrpkey) {
		this.drawgrpkey = drawgrpkey;
	}



	/**
	 * Return the value associated with the column: reservebookkey
	 */
	public java.lang.String getReservebookkey () {
		return reservebookkey;
	}

	/**
	 * Set the value related to the column: reservebookkey
	 * @param reservebookkey the reservebookkey value
	 */
	public void setReservebookkey (java.lang.String reservebookkey) {
		this.reservebookkey = reservebookkey;
	}



	/**
	 * Return the value associated with the column: lsttype
	 */
	public java.lang.String getLsttype () {
		return lsttype;
	}

	/**
	 * Set the value related to the column: lsttype
	 * @param lsttype the lsttype value
	 */
	public void setLsttype (java.lang.String lsttype) {
		this.lsttype = lsttype;
	}



	/**
	 * Return the value associated with the column: deptd
	 */
	public java.math.BigDecimal getDeptd () {
		return deptd;
	}

	/**
	 * Set the value related to the column: deptd
	 * @param deptd the deptd value
	 */
	public void setDeptd (java.math.BigDecimal deptd) {
		this.deptd = deptd;
	}



	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String eqpkeyp4) {
		this.eqpkeyp4 = eqpkeyp4;
	}



	/**
	 * Return the value associated with the column: movtypekey
	 */
	public java.lang.String getMovtypekey () {
		return movtypekey;
	}

	/**
	 * Set the value related to the column: movtypekey
	 * @param movtypekey the movtypekey value
	 */
	public void setMovtypekey (java.lang.String movtypekey) {
		this.movtypekey = movtypekey;
	}



	/**
	 * Return the value associated with the column: optdate
	 */
	public java.util.Date getOptdate () {
		return optdate;
	}

	/**
	 * Set the value related to the column: optdate
	 * @param optdate the optdate value
	 */
	public void setOptdate (java.util.Date optdate) {
		this.optdate = optdate;
	}



	/**
	 * Return the value associated with the column: disposalnotes
	 */
	public java.lang.String getDisposalnotes () {
		return disposalnotes;
	}

	/**
	 * Set the value related to the column: disposalnotes
	 * @param disposalnotes the disposalnotes value
	 */
	public void setDisposalnotes (java.lang.String disposalnotes) {
		this.disposalnotes = disposalnotes;
	}



	/**
	 * Return the value associated with the column: lengthf
	 */
	public java.lang.Integer getLengthf () {
		return lengthf;
	}

	/**
	 * Set the value related to the column: lengthf
	 * @param lengthf the lengthf value
	 */
	public void setLengthf (java.lang.Integer lengthf) {
		this.lengthf = lengthf;
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
	 * Return the value associated with the column: wlocat
	 */
	public java.lang.String getWlocat () {
		return wlocat;
	}

	/**
	 * Set the value related to the column: wlocat
	 * @param wlocat the wlocat value
	 */
	public void setWlocat (java.lang.String wlocat) {
		this.wlocat = wlocat;
	}



	/**
	 * Return the value associated with the column: invstsby
	 */
	public java.lang.String getInvstsby () {
		return invstsby;
	}

	/**
	 * Set the value related to the column: invstsby
	 * @param invstsby the invstsby value
	 */
	public void setInvstsby (java.lang.String invstsby) {
		this.invstsby = invstsby;
	}



	/**
	 * Return the value associated with the column: prevaddrkey
	 */
	public java.lang.String getPrevaddrkey () {
		return prevaddrkey;
	}

	/**
	 * Set the value related to the column: prevaddrkey
	 * @param prevaddrkey the prevaddrkey value
	 */
	public void setPrevaddrkey (java.lang.String prevaddrkey) {
		this.prevaddrkey = prevaddrkey;
	}



	/**
	 * Return the value associated with the column: repairdate
	 */
	public java.util.Date getRepairdate () {
		return repairdate;
	}

	/**
	 * Set the value related to the column: repairdate
	 * @param repairdate the repairdate value
	 */
	public void setRepairdate (java.util.Date repairdate) {
		this.repairdate = repairdate;
	}



	/**
	 * Return the value associated with the column: nexttest
	 */
	public java.lang.String getNexttest () {
		return nexttest;
	}

	/**
	 * Set the value related to the column: nexttest
	 * @param nexttest the nexttest value
	 */
	public void setNexttest (java.lang.String nexttest) {
		this.nexttest = nexttest;
	}



	/**
	 * Return the value associated with the column: poschg
	 */
	public java.math.BigDecimal getPoschg () {
		return poschg;
	}

	/**
	 * Set the value related to the column: poschg
	 * @param poschg the poschg value
	 */
	public void setPoschg (java.math.BigDecimal poschg) {
		this.poschg = poschg;
	}



	/**
	 * Return the value associated with the column: eststs
	 */
	public java.lang.String getEststs () {
		return eststs;
	}

	/**
	 * Set the value related to the column: eststs
	 * @param eststs the eststs value
	 */
	public void setEststs (java.lang.String eststs) {
		this.eststs = eststs;
	}



	/**
	 * Return the value associated with the column: thleak
	 */
	public java.lang.Integer getThleak () {
		return thleak;
	}

	/**
	 * Set the value related to the column: thleak
	 * @param thleak the thleak value
	 */
	public void setThleak (java.lang.Integer thleak) {
		this.thleak = thleak;
	}



	/**
	 * Return the value associated with the column: writeoffflag
	 */
	public boolean isWriteoffflag () {
		return writeoffflag;
	}

	/**
	 * Set the value related to the column: writeoffflag
	 * @param writeoffflag the writeoffflag value
	 */
	public void setWriteoffflag (boolean writeoffflag) {
		this.writeoffflag = writeoffflag;
	}



	/**
	 * Return the value associated with the column: tmdmax
	 */
	public java.math.BigDecimal getTmdmax () {
		return tmdmax;
	}

	/**
	 * Set the value related to the column: tmdmax
	 * @param tmdmax the tmdmax value
	 */
	public void setTmdmax (java.math.BigDecimal tmdmax) {
		this.tmdmax = tmdmax;
	}



	/**
	 * Return the value associated with the column: rvalvac
	 */
	public java.math.BigDecimal getRvalvac () {
		return rvalvac;
	}

	/**
	 * Set the value related to the column: rvalvac
	 * @param rvalvac the rvalvac value
	 */
	public void setRvalvac (java.math.BigDecimal rvalvac) {
		this.rvalvac = rvalvac;
	}



	/**
	 * Return the value associated with the column: ssurarap
	 */
	public java.math.BigDecimal getSsurarap () {
		return ssurarap;
	}

	/**
	 * Set the value related to the column: ssurarap
	 * @param ssurarap the ssurarap value
	 */
	public void setSsurarap (java.math.BigDecimal ssurarap) {
		this.ssurarap = ssurarap;
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
	 * Return the value associated with the column: ssurara
	 */
	public java.math.BigDecimal getSsurara () {
		return ssurara;
	}

	/**
	 * Set the value related to the column: ssurara
	 * @param ssurara the ssurara value
	 */
	public void setSsurara (java.math.BigDecimal ssurara) {
		this.ssurara = ssurara;
	}



	/**
	 * Return the value associated with the column: unitspecno
	 */
	public java.lang.String getUnitspecno () {
		return unitspecno;
	}

	/**
	 * Set the value related to the column: unitspecno
	 * @param unitspecno the unitspecno value
	 */
	public void setUnitspecno (java.lang.String unitspecno) {
		this.unitspecno = unitspecno;
	}



	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String eqpkey) {
		this.eqpkey = eqpkey;
	}



	/**
	 * Return the value associated with the column: g3key
	 */
	public java.lang.String getG3key () {
		return g3key;
	}

	/**
	 * Set the value related to the column: g3key
	 * @param g3key the g3key value
	 */
	public void setG3key (java.lang.String g3key) {
		this.g3key = g3key;
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
	 * Return the value associated with the column: tbwork
	 */
	public java.math.BigDecimal getTbwork () {
		return tbwork;
	}

	/**
	 * Set the value related to the column: tbwork
	 * @param tbwork the tbwork value
	 */
	public void setTbwork (java.math.BigDecimal tbwork) {
		this.tbwork = tbwork;
	}



	/**
	 * Return the value associated with the column: previsonumkey
	 */
	public java.lang.String getPrevisonumkey () {
		return previsonumkey;
	}

	/**
	 * Set the value related to the column: previsonumkey
	 * @param previsonumkey the previsonumkey value
	 */
	public void setPrevisonumkey (java.lang.String previsonumkey) {
		this.previsonumkey = previsonumkey;
	}



	/**
	 * Return the value associated with the column: capusg
	 */
	public java.lang.Integer getCapusg () {
		return capusg;
	}

	/**
	 * Set the value related to the column: capusg
	 * @param capusg the capusg value
	 */
	public void setCapusg (java.lang.Integer capusg) {
		this.capusg = capusg;
	}



	/**
	 * Return the value associated with the column: g4key
	 */
	public java.lang.String getG4key () {
		return g4key;
	}

	/**
	 * Set the value related to the column: g4key
	 * @param g4key the g4key value
	 */
	public void setG4key (java.lang.String g4key) {
		this.g4key = g4key;
	}



	/**
	 * Return the value associated with the column: heighti
	 */
	public java.lang.Integer getHeighti () {
		return heighti;
	}

	/**
	 * Set the value related to the column: heighti
	 * @param heighti the heighti value
	 */
	public void setHeighti (java.lang.Integer heighti) {
		this.heighti = heighti;
	}



	/**
	 * Return the value associated with the column: actoffdate
	 */
	public java.util.Date getActoffdate () {
		return actoffdate;
	}

	/**
	 * Set the value related to the column: actoffdate
	 * @param actoffdate the actoffdate value
	 */
	public void setActoffdate (java.util.Date actoffdate) {
		this.actoffdate = actoffdate;
	}



	/**
	 * Return the value associated with the column: lengthi
	 */
	public java.lang.Integer getLengthi () {
		return lengthi;
	}

	/**
	 * Set the value related to the column: lengthi
	 * @param lengthi the lengthi value
	 */
	public void setLengthi (java.lang.Integer lengthi) {
		this.lengthi = lengthi;
	}



	/**
	 * Return the value associated with the column: foodgrad
	 */
	public boolean isFoodgrad () {
		return foodgrad;
	}

	/**
	 * Set the value related to the column: foodgrad
	 * @param foodgrad the foodgrad value
	 */
	public void setFoodgrad (boolean foodgrad) {
		this.foodgrad = foodgrad;
	}



	/**
	 * Return the value associated with the column: ukdot
	 */
	public boolean isUkdot () {
		return ukdot;
	}

	/**
	 * Set the value related to the column: ukdot
	 * @param ukdot the ukdot value
	 */
	public void setUkdot (boolean ukdot) {
		this.ukdot = ukdot;
	}



	/**
	 * Return the value associated with the column: eirrechg
	 */
	public java.math.BigDecimal getEirrechg () {
		return eirrechg;
	}

	/**
	 * Set the value related to the column: eirrechg
	 * @param eirrechg the eirrechg value
	 */
	public void setEirrechg (java.math.BigDecimal eirrechg) {
		this.eirrechg = eirrechg;
	}



	/**
	 * Return the value associated with the column: csc
	 */
	public boolean isCsc () {
		return csc;
	}

	/**
	 * Set the value related to the column: csc
	 * @param csc the csc value
	 */
	public void setCsc (boolean csc) {
		this.csc = csc;
	}



	/**
	 * Return the value associated with the column: matrils
	 */
	public java.lang.String getMatrils () {
		return matrils;
	}

	/**
	 * Set the value related to the column: matrils
	 * @param matrils the matrils value
	 */
	public void setMatrils (java.lang.String matrils) {
		this.matrils = matrils;
	}



	/**
	 * Return the value associated with the column: width
	 */
	public java.lang.Integer getWidth () {
		return width;
	}

	/**
	 * Set the value related to the column: width
	 * @param width the width value
	 */
	public void setWidth (java.lang.Integer width) {
		this.width = width;
	}



	/**
	 * Return the value associated with the column: adr
	 */
	public boolean isAdr () {
		return adr;
	}

	/**
	 * Set the value related to the column: adr
	 * @param adr the adr value
	 */
	public void setAdr (boolean adr) {
		this.adr = adr;
	}



	/**
	 * Return the value associated with the column: tmdmin
	 */
	public java.math.BigDecimal getTmdmin () {
		return tmdmin;
	}

	/**
	 * Set the value related to the column: tmdmin
	 * @param tmdmin the tmdmin value
	 */
	public void setTmdmin (java.math.BigDecimal tmdmin) {
		this.tmdmin = tmdmin;
	}



	/**
	 * Return the value associated with the column: tdesmin
	 */
	public java.math.BigDecimal getTdesmin () {
		return tdesmin;
	}

	/**
	 * Set the value related to the column: tdesmin
	 * @param tdesmin the tdesmin value
	 */
	public void setTdesmin (java.math.BigDecimal tdesmin) {
		this.tdesmin = tdesmin;
	}



	/**
	 * Return the value associated with the column: drawfile3
	 */
	public java.lang.String getDrawfile3 () {
		return drawfile3;
	}

	/**
	 * Set the value related to the column: drawfile3
	 * @param drawfile3 the drawfile3 value
	 */
	public void setDrawfile3 (java.lang.String drawfile3) {
		this.drawfile3 = drawfile3;
	}



	/**
	 * Return the value associated with the column: dir
	 */
	public boolean isDir () {
		return dir;
	}

	/**
	 * Set the value related to the column: dir
	 * @param dir the dir value
	 */
	public void setDir (boolean dir) {
		this.dir = dir;
	}



	/**
	 * Return the value associated with the column: rvalprsp
	 */
	public java.math.BigDecimal getRvalprsp () {
		return rvalprsp;
	}

	/**
	 * Set the value related to the column: rvalprsp
	 * @param rvalprsp the rvalprsp value
	 */
	public void setRvalprsp (java.math.BigDecimal rvalprsp) {
		this.rvalprsp = rvalprsp;
	}



	/**
	 * Return the value associated with the column: tmaxcar
	 */
	public java.math.BigDecimal getTmaxcar () {
		return tmaxcar;
	}

	/**
	 * Set the value related to the column: tmaxcar
	 * @param tmaxcar the tmaxcar value
	 */
	public void setTmaxcar (java.math.BigDecimal tmaxcar) {
		this.tmaxcar = tmaxcar;
	}



	/**
	 * Return the value associated with the column: oprsysmsgdate
	 */
	public java.util.Date getOprsysmsgdate () {
		return oprsysmsgdate;
	}

	/**
	 * Set the value related to the column: oprsysmsgdate
	 * @param oprsysmsgdate the oprsysmsgdate value
	 */
	public void setOprsysmsgdate (java.util.Date oprsysmsgdate) {
		this.oprsysmsgdate = oprsysmsgdate;
	}



	/**
	 * Return the value associated with the column: prevunitkey
	 */
	public java.lang.String getPrevunitkey () {
		return prevunitkey;
	}

	/**
	 * Set the value related to the column: prevunitkey
	 * @param prevunitkey the prevunitkey value
	 */
	public void setPrevunitkey (java.lang.String prevunitkey) {
		this.prevunitkey = prevunitkey;
	}



	/**
	 * Return the value associated with the column: fivtype
	 */
	public java.lang.String getFivtype () {
		return fivtype;
	}

	/**
	 * Set the value related to the column: fivtype
	 * @param fivtype the fivtype value
	 */
	public void setFivtype (java.lang.String fivtype) {
		this.fivtype = fivtype;
	}



	/**
	 * Return the value associated with the column: tmaxcarf
	 */
	public java.math.BigDecimal getTmaxcarf () {
		return tmaxcarf;
	}

	/**
	 * Set the value related to the column: tmaxcarf
	 * @param tmaxcarf the tmaxcarf value
	 */
	public void setTmaxcarf (java.math.BigDecimal tmaxcarf) {
		this.tmaxcarf = tmaxcarf;
	}



	/**
	 * Return the value associated with the column: g2key
	 */
	public java.lang.String getG2key () {
		return g2key;
	}

	/**
	 * Set the value related to the column: g2key
	 * @param g2key the g2key value
	 */
	public void setG2key (java.lang.String g2key) {
		this.g2key = g2key;
	}



	/**
	 * Return the value associated with the column: optaddrkey
	 */
	public java.lang.String getOptaddrkey () {
		return optaddrkey;
	}

	/**
	 * Set the value related to the column: optaddrkey
	 * @param optaddrkey the optaddrkey value
	 */
	public void setOptaddrkey (java.lang.String optaddrkey) {
		this.optaddrkey = optaddrkey;
	}



	/**
	 * Return the value associated with the column: lastdate
	 */
	public java.util.Date getLastdate () {
		return lastdate;
	}

	/**
	 * Set the value related to the column: lastdate
	 * @param lastdate the lastdate value
	 */
	public void setLastdate (java.util.Date lastdate) {
		this.lastdate = lastdate;
	}



	/**
	 * Return the value associated with the column: widthi
	 */
	public java.lang.Integer getWidthi () {
		return widthi;
	}

	/**
	 * Set the value related to the column: widthi
	 * @param widthi the widthi value
	 */
	public void setWidthi (java.lang.Integer widthi) {
		this.widthi = widthi;
	}



	/**
	 * Return the value associated with the column: drawfile2
	 */
	public java.lang.String getDrawfile2 () {
		return drawfile2;
	}

	/**
	 * Set the value related to the column: drawfile2
	 * @param drawfile2 the drawfile2 value
	 */
	public void setDrawfile2 (java.lang.String drawfile2) {
		this.drawfile2 = drawfile2;
	}



	/**
	 * Return the value associated with the column: writeoffdate
	 */
	public java.util.Date getWriteoffdate () {
		return writeoffdate;
	}

	/**
	 * Set the value related to the column: writeoffdate
	 * @param writeoffdate the writeoffdate value
	 */
	public void setWriteoffdate (java.util.Date writeoffdate) {
		this.writeoffdate = writeoffdate;
	}



	/**
	 * Return the value associated with the column: tbtest
	 */
	public java.math.BigDecimal getTbtest () {
		return tbtest;
	}

	/**
	 * Set the value related to the column: tbtest
	 * @param tbtest the tbtest value
	 */
	public void setTbtest (java.math.BigDecimal tbtest) {
		this.tbtest = tbtest;
	}



	/**
	 * Return the value associated with the column: oprsysalloctxt
	 */
	public java.lang.String getOprsysalloctxt () {
		return oprsysalloctxt;
	}

	/**
	 * Set the value related to the column: oprsysalloctxt
	 * @param oprsysalloctxt the oprsysalloctxt value
	 */
	public void setOprsysalloctxt (java.lang.String oprsysalloctxt) {
		this.oprsysalloctxt = oprsysalloctxt;
	}



	/**
	 * Return the value associated with the column: drawfile1
	 */
	public java.lang.String getDrawfile1 () {
		return drawfile1;
	}

	/**
	 * Set the value related to the column: drawfile1
	 * @param drawfile1 the drawfile1 value
	 */
	public void setDrawfile1 (java.lang.String drawfile1) {
		this.drawfile1 = drawfile1;
	}



	/**
	 * Return the value associated with the column: invstsdate
	 */
	public java.util.Date getInvstsdate () {
		return invstsdate;
	}

	/**
	 * Set the value related to the column: invstsdate
	 * @param invstsdate the invstsdate value
	 */
	public void setInvstsdate (java.util.Date invstsdate) {
		this.invstsdate = invstsdate;
	}



	/**
	 * Return the value associated with the column: teucount
	 */
	public java.lang.Integer getTeucount () {
		return teucount;
	}

	/**
	 * Set the value related to the column: teucount
	 * @param teucount the teucount value
	 */
	public void setTeucount (java.lang.Integer teucount) {
		this.teucount = teucount;
	}



	/**
	 * Return the value associated with the column: framtyp
	 */
	public java.lang.String getFramtyp () {
		return framtyp;
	}

	/**
	 * Set the value related to the column: framtyp
	 * @param framtyp the framtyp value
	 */
	public void setFramtyp (java.lang.String framtyp) {
		this.framtyp = framtyp;
	}



	/**
	 * Return the value associated with the column: planreb
	 */
	public java.util.Date getPlanreb () {
		return planreb;
	}

	/**
	 * Set the value related to the column: planreb
	 * @param planreb the planreb value
	 */
	public void setPlanreb (java.util.Date planreb) {
		this.planreb = planreb;
	}



	/**
	 * Return the value associated with the column: lastlse
	 */
	public java.lang.String getLastlse () {
		return lastlse;
	}

	/**
	 * Set the value related to the column: lastlse
	 * @param lastlse the lastlse value
	 */
	public void setLastlse (java.lang.String lastlse) {
		this.lastlse = lastlse;
	}



	/**
	 * Return the value associated with the column: mfnum
	 */
	public java.lang.String getMfnum () {
		return mfnum;
	}

	/**
	 * Set the value related to the column: mfnum
	 * @param mfnum the mfnum value
	 */
	public void setMfnum (java.lang.String mfnum) {
		this.mfnum = mfnum;
	}



	/**
	 * Return the value associated with the column: tranfro
	 */
	public java.math.BigDecimal getTranfro () {
		return tranfro;
	}

	/**
	 * Set the value related to the column: tranfro
	 * @param tranfro the tranfro value
	 */
	public void setTranfro (java.math.BigDecimal tranfro) {
		this.tranfro = tranfro;
	}



	/**
	 * Return the value associated with the column: certifdocdate
	 */
	public java.util.Date getCertifdocdate () {
		return certifdocdate;
	}

	/**
	 * Set the value related to the column: certifdocdate
	 * @param certifdocdate the certifdocdate value
	 */
	public void setCertifdocdate (java.util.Date certifdocdate) {
		this.certifdocdate = certifdocdate;
	}



	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String eqpkeyp9) {
		this.eqpkeyp9 = eqpkeyp9;
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
	 * Return the value associated with the column: cscdate
	 */
	public java.util.Date getCscdate () {
		return cscdate;
	}

	/**
	 * Set the value related to the column: cscdate
	 * @param cscdate the cscdate value
	 */
	public void setCscdate (java.util.Date cscdate) {
		this.cscdate = cscdate;
	}



	/**
	 * Return the value associated with the column: topspoolno
	 */
	public java.lang.String getTopspoolno () {
		return topspoolno;
	}

	/**
	 * Set the value related to the column: topspoolno
	 * @param topspoolno the topspoolno value
	 */
	public void setTopspoolno (java.lang.String topspoolno) {
		this.topspoolno = topspoolno;
	}



	/**
	 * Return the value associated with the column: tkworkp
	 */
	public java.math.BigDecimal getTkworkp () {
		return tkworkp;
	}

	/**
	 * Set the value related to the column: tkworkp
	 * @param tkworkp the tkworkp value
	 */
	public void setTkworkp (java.math.BigDecimal tkworkp) {
		this.tkworkp = tkworkp;
	}



	/**
	 * Return the value associated with the column: nexttestdescr
	 */
	public java.lang.String getNexttestdescr () {
		return nexttestdescr;
	}

	/**
	 * Set the value related to the column: nexttestdescr
	 * @param nexttestdescr the nexttestdescr value
	 */
	public void setNexttestdescr (java.lang.String nexttestdescr) {
		this.nexttestdescr = nexttestdescr;
	}



	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String eqpkeyp10) {
		this.eqpkeyp10 = eqpkeyp10;
	}



	/**
	 * Return the value associated with the column: lastby
	 */
	public java.lang.String getLastby () {
		return lastby;
	}

	/**
	 * Set the value related to the column: lastby
	 * @param lastby the lastby value
	 */
	public void setLastby (java.lang.String lastby) {
		this.lastby = lastby;
	}



	/**
	 * Return the value associated with the column: oprsysblockalloc
	 */
	public boolean isOprsysblockalloc () {
		return oprsysblockalloc;
	}

	/**
	 * Set the value related to the column: oprsysblockalloc
	 * @param oprsysblockalloc the oprsysblockalloc value
	 */
	public void setOprsysblockalloc (boolean oprsysblockalloc) {
		this.oprsysblockalloc = oprsysblockalloc;
	}



	/**
	 * Return the value associated with the column: shthick
	 */
	public java.math.BigDecimal getShthick () {
		return shthick;
	}

	/**
	 * Set the value related to the column: shthick
	 * @param shthick the shthick value
	 */
	public void setShthick (java.math.BigDecimal shthick) {
		this.shthick = shthick;
	}



	/**
	 * Return the value associated with the column: tktestp
	 */
	public java.math.BigDecimal getTktestp () {
		return tktestp;
	}

	/**
	 * Set the value related to the column: tktestp
	 * @param tktestp the tktestp value
	 */
	public void setTktestp (java.math.BigDecimal tktestp) {
		this.tktestp = tktestp;
	}



	/**
	 * Return the value associated with the column: thftype
	 */
	public java.lang.String getThftype () {
		return thftype;
	}

	/**
	 * Set the value related to the column: thftype
	 * @param thftype the thftype value
	 */
	public void setThftype (java.lang.String thftype) {
		this.thftype = thftype;
	}



	/**
	 * Return the value associated with the column: tdesminf
	 */
	public java.math.BigDecimal getTdesminf () {
		return tdesminf;
	}

	/**
	 * Set the value related to the column: tdesminf
	 * @param tdesminf the tdesminf value
	 */
	public void setTdesminf (java.math.BigDecimal tdesminf) {
		this.tdesminf = tdesminf;
	}



	/**
	 * Return the value associated with the column: stackno
	 */
	public java.lang.Integer getStackno () {
		return stackno;
	}

	/**
	 * Set the value related to the column: stackno
	 * @param stackno the stackno value
	 */
	public void setStackno (java.lang.Integer stackno) {
		this.stackno = stackno;
	}



	/**
	 * Return the value associated with the column: intermgraddrkey
	 */
	public java.lang.String getIntermgraddrkey () {
		return intermgraddrkey;
	}

	/**
	 * Set the value related to the column: intermgraddrkey
	 * @param intermgraddrkey the intermgraddrkey value
	 */
	public void setIntermgraddrkey (java.lang.String intermgraddrkey) {
		this.intermgraddrkey = intermgraddrkey;
	}



	/**
	 * Return the value associated with the column: fstby
	 */
	public java.lang.String getFstby () {
		return fstby;
	}

	/**
	 * Set the value related to the column: fstby
	 * @param fstby the fstby value
	 */
	public void setFstby (java.lang.String fstby) {
		this.fstby = fstby;
	}



	/**
	 * Return the value associated with the column: wmovedate
	 */
	public java.util.Date getWmovedate () {
		return wmovedate;
	}

	/**
	 * Set the value related to the column: wmovedate
	 * @param wmovedate the wmovedate value
	 */
	public void setWmovedate (java.util.Date wmovedate) {
		this.wmovedate = wmovedate;
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
	 * Return the value associated with the column: repairby
	 */
	public java.lang.String getRepairby () {
		return repairby;
	}

	/**
	 * Set the value related to the column: repairby
	 * @param repairby the repairby value
	 */
	public void setRepairby (java.lang.String repairby) {
		this.repairby = repairby;
	}



	/**
	 * Return the value associated with the column: calibdocfile
	 */
	public java.lang.String getCalibdocfile () {
		return calibdocfile;
	}

	/**
	 * Set the value related to the column: calibdocfile
	 * @param calibdocfile the calibdocfile value
	 */
	public void setCalibdocfile (java.lang.String calibdocfile) {
		this.calibdocfile = calibdocfile;
	}



	/**
	 * Return the value associated with the column: opteqpidkey
	 */
	public java.lang.String getOpteqpidkey () {
		return opteqpidkey;
	}

	/**
	 * Set the value related to the column: opteqpidkey
	 * @param opteqpidkey the opteqpidkey value
	 */
	public void setOpteqpidkey (java.lang.String opteqpidkey) {
		this.opteqpidkey = opteqpidkey;
	}



	/**
	 * Return the value associated with the column: disposaladdrkey
	 */
	public java.lang.String getDisposaladdrkey () {
		return disposaladdrkey;
	}

	/**
	 * Set the value related to the column: disposaladdrkey
	 * @param disposaladdrkey the disposaladdrkey value
	 */
	public void setDisposaladdrkey (java.lang.String disposaladdrkey) {
		this.disposaladdrkey = disposaladdrkey;
	}



	/**
	 * Return the value associated with the column: tktest
	 */
	public java.math.BigDecimal getTktest () {
		return tktest;
	}

	/**
	 * Set the value related to the column: tktest
	 * @param tktest the tktest value
	 */
	public void setTktest (java.math.BigDecimal tktest) {
		this.tktest = tktest;
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
	 * Return the value associated with the column: eirdepotaddrkey
	 */
	public java.lang.String getEirdepotaddrkey () {
		return eirdepotaddrkey;
	}

	/**
	 * Set the value related to the column: eirdepotaddrkey
	 * @param eirdepotaddrkey the eirdepotaddrkey value
	 */
	public void setEirdepotaddrkey (java.lang.String eirdepotaddrkey) {
		this.eirdepotaddrkey = eirdepotaddrkey;
	}



	/**
	 * Return the value associated with the column: dot51
	 */
	public boolean isDot51 () {
		return dot51;
	}

	/**
	 * Set the value related to the column: dot51
	 * @param dot51 the dot51 value
	 */
	public void setDot51 (boolean dot51) {
		this.dot51 = dot51;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String eqpkeyp7) {
		this.eqpkeyp7 = eqpkeyp7;
	}



	/**
	 * Return the value associated with the column: payloadl
	 */
	public java.lang.Integer getPayloadl () {
		return payloadl;
	}

	/**
	 * Set the value related to the column: payloadl
	 * @param payloadl the payloadl value
	 */
	public void setPayloadl (java.lang.Integer payloadl) {
		this.payloadl = payloadl;
	}



	/**
	 * Return the value associated with the column: ownerkey
	 */
	public java.lang.String getOwnerkey () {
		return ownerkey;
	}

	/**
	 * Set the value related to the column: ownerkey
	 * @param ownerkey the ownerkey value
	 */
	public void setOwnerkey (java.lang.String ownerkey) {
		this.ownerkey = ownerkey;
	}



	/**
	 * Return the value associated with the column: optflag
	 */
	public boolean isOptflag () {
		return optflag;
	}

	/**
	 * Set the value related to the column: optflag
	 * @param optflag the optflag value
	 */
	public void setOptflag (boolean optflag) {
		this.optflag = optflag;
	}



	/**
	 * Return the value associated with the column: actoffaddrkey
	 */
	public java.lang.String getActoffaddrkey () {
		return actoffaddrkey;
	}

	/**
	 * Set the value related to the column: actoffaddrkey
	 * @param actoffaddrkey the actoffaddrkey value
	 */
	public void setActoffaddrkey (java.lang.String actoffaddrkey) {
		this.actoffaddrkey = actoffaddrkey;
	}



	/**
	 * Return the value associated with the column: mfdate
	 */
	public java.util.Date getMfdate () {
		return mfdate;
	}

	/**
	 * Set the value related to the column: mfdate
	 * @param mfdate the mfdate value
	 */
	public void setMfdate (java.util.Date mfdate) {
		this.mfdate = mfdate;
	}



	/**
	 * Return the value associated with the column: payload
	 */
	public java.lang.Integer getPayload () {
		return payload;
	}

	/**
	 * Set the value related to the column: payload
	 * @param payload the payload value
	 */
	public void setPayload (java.lang.Integer payload) {
		this.payload = payload;
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
	 * Return the value associated with the column: imo
	 */
	public boolean isImo () {
		return imo;
	}

	/**
	 * Set the value related to the column: imo
	 * @param imo the imo value
	 */
	public void setImo (boolean imo) {
		this.imo = imo;
	}



	/**
	 * Return the value associated with the column: nexttestdue
	 */
	public java.util.Date getNexttestdue () {
		return nexttestdue;
	}

	/**
	 * Set the value related to the column: nexttestdue
	 * @param nexttestdue the nexttestdue value
	 */
	public void setNexttestdue (java.util.Date nexttestdue) {
		this.nexttestdue = nexttestdue;
	}



	/**
	 * Return the value associated with the column: fiveyear
	 */
	public java.util.Date getFiveyear () {
		return fiveyear;
	}

	/**
	 * Set the value related to the column: fiveyear
	 * @param fiveyear the fiveyear value
	 */
	public void setFiveyear (java.util.Date fiveyear) {
		this.fiveyear = fiveyear;
	}



	/**
	 * Return the value associated with the column: capcfee
	 */
	public java.lang.Integer getCapcfee () {
		return capcfee;
	}

	/**
	 * Set the value related to the column: capcfee
	 * @param capcfee the capcfee value
	 */
	public void setCapcfee (java.lang.Integer capcfee) {
		this.capcfee = capcfee;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String eqpkeyp8) {
		this.eqpkeyp8 = eqpkeyp8;
	}



	/**
	 * Return the value associated with the column: calibdocdate
	 */
	public java.util.Date getCalibdocdate () {
		return calibdocdate;
	}

	/**
	 * Set the value related to the column: calibdocdate
	 * @param calibdocdate the calibdocdate value
	 */
	public void setCalibdocdate (java.util.Date calibdocdate) {
		this.calibdocdate = calibdocdate;
	}



	/**
	 * Return the value associated with the column: fsttype
	 */
	public java.lang.String getFsttype () {
		return fsttype;
	}

	/**
	 * Set the value related to the column: fsttype
	 * @param fsttype the fsttype value
	 */
	public void setFsttype (java.lang.String fsttype) {
		this.fsttype = fsttype;
	}



	/**
	 * Return the value associated with the column: optlprefnokey
	 */
	public java.lang.String getOptlprefnokey () {
		return optlprefnokey;
	}

	/**
	 * Set the value related to the column: optlprefnokey
	 * @param optlprefnokey the optlprefnokey value
	 */
	public void setOptlprefnokey (java.lang.String optlprefnokey) {
		this.optlprefnokey = optlprefnokey;
	}



	/**
	 * Return the value associated with the column: tbtestp
	 */
	public java.math.BigDecimal getTbtestp () {
		return tbtestp;
	}

	/**
	 * Set the value related to the column: tbtestp
	 * @param tbtestp the tbtestp value
	 */
	public void setTbtestp (java.math.BigDecimal tbtestp) {
		this.tbtestp = tbtestp;
	}



	/**
	 * Return the value associated with the column: tir
	 */
	public boolean isTir () {
		return tir;
	}

	/**
	 * Set the value related to the column: tir
	 * @param tir the tir value
	 */
	public void setTir (boolean tir) {
		this.tir = tir;
	}



	/**
	 * Return the value associated with the column: usdot
	 */
	public boolean isUsdot () {
		return usdot;
	}

	/**
	 * Set the value related to the column: usdot
	 * @param usdot the usdot value
	 */
	public void setUsdot (boolean usdot) {
		this.usdot = usdot;
	}



	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String eqpkeyp6) {
		this.eqpkeyp6 = eqpkeyp6;
	}



	/**
	 * Return the value associated with the column: xunitkey
	 */
	public java.lang.String getXunitkey () {
		return xunitkey;
	}

	/**
	 * Set the value related to the column: xunitkey
	 * @param xunitkey the xunitkey value
	 */
	public void setXunitkey (java.lang.String xunitkey) {
		this.xunitkey = xunitkey;
	}



	/**
	 * Return the value associated with the column: origunitkey
	 */
	public java.lang.String getOrigunitkey () {
		return origunitkey;
	}

	/**
	 * Set the value related to the column: origunitkey
	 * @param origunitkey the origunitkey value
	 */
	public void setOrigunitkey (java.lang.String origunitkey) {
		this.origunitkey = origunitkey;
	}



	/**
	 * Return the value associated with the column: sysidkey
	 */
	public java.lang.String getSysidkey () {
		return sysidkey;
	}

	/**
	 * Set the value related to the column: sysidkey
	 * @param sysidkey the sysidkey value
	 */
	public void setSysidkey (java.lang.String sysidkey) {
		this.sysidkey = sysidkey;
	}



	/**
	 * Return the value associated with the column: att
	 */
	public boolean isAtt () {
		return att;
	}

	/**
	 * Set the value related to the column: att
	 * @param att the att value
	 */
	public void setAtt (boolean att) {
		this.att = att;
	}



	/**
	 * Return the value associated with the column: eircost
	 */
	public java.math.BigDecimal getEircost () {
		return eircost;
	}

	/**
	 * Set the value related to the column: eircost
	 * @param eircost the eircost value
	 */
	public void setEircost (java.math.BigDecimal eircost) {
		this.eircost = eircost;
	}



	/**
	 * Return the value associated with the column: wmovetyp
	 */
	public java.lang.String getWmovetyp () {
		return wmovetyp;
	}

	/**
	 * Set the value related to the column: wmovetyp
	 * @param wmovetyp the wmovetyp value
	 */
	public void setWmovetyp (java.lang.String wmovetyp) {
		this.wmovetyp = wmovetyp;
	}



	/**
	 * Return the value associated with the column: unittcode
	 */
	public java.lang.String getUnittcode () {
		return unittcode;
	}

	/**
	 * Set the value related to the column: unittcode
	 * @param unittcode the unittcode value
	 */
	public void setUnittcode (java.lang.String unittcode) {
		this.unittcode = unittcode;
	}



	/**
	 * Return the value associated with the column: tkwork
	 */
	public java.math.BigDecimal getTkwork () {
		return tkwork;
	}

	/**
	 * Set the value related to the column: tkwork
	 * @param tkwork the tkwork value
	 */
	public void setTkwork (java.math.BigDecimal tkwork) {
		this.tkwork = tkwork;
	}



	/**
	 * Return the value associated with the column: tranto
	 */
	public java.math.BigDecimal getTranto () {
		return tranto;
	}

	/**
	 * Set the value related to the column: tranto
	 * @param tranto the tranto value
	 */
	public void setTranto (java.math.BigDecimal tranto) {
		this.tranto = tranto;
	}



	/**
	 * Return the value associated with the column: stackw
	 */
	public java.lang.Integer getStackw () {
		return stackw;
	}

	/**
	 * Set the value related to the column: stackw
	 * @param stackw the stackw value
	 */
	public void setStackw (java.lang.Integer stackw) {
		this.stackw = stackw;
	}



	/**
	 * Return the value associated with the column: tare
	 */
	public java.lang.Integer getTare () {
		return tare;
	}

	/**
	 * Set the value related to the column: tare
	 * @param tare the tare value
	 */
	public void setTare (java.lang.Integer tare) {
		this.tare = tare;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}



	/**
	 * Return the value associated with the column: grossl
	 */
	public java.lang.Integer getGrossl () {
		return grossl;
	}

	/**
	 * Set the value related to the column: grossl
	 * @param grossl the grossl value
	 */
	public void setGrossl (java.lang.Integer grossl) {
		this.grossl = grossl;
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
	 * Return the value associated with the column: optexpires
	 */
	public java.util.Date getOptexpires () {
		return optexpires;
	}

	/**
	 * Set the value related to the column: optexpires
	 * @param optexpires the optexpires value
	 */
	public void setOptexpires (java.util.Date optexpires) {
		this.optexpires = optexpires;
	}



	/**
	 * Return the value associated with the column: shdepms
	 */
	public java.math.BigDecimal getShdepms () {
		return shdepms;
	}

	/**
	 * Set the value related to the column: shdepms
	 * @param shdepms the shdepms value
	 */
	public void setShdepms (java.math.BigDecimal shdepms) {
		this.shdepms = shdepms;
	}



	/**
	 * Return the value associated with the column: tdesmax
	 */
	public java.math.BigDecimal getTdesmax () {
		return tdesmax;
	}

	/**
	 * Set the value related to the column: tdesmax
	 * @param tdesmax the tdesmax value
	 */
	public void setTdesmax (java.math.BigDecimal tdesmax) {
		this.tdesmax = tdesmax;
	}



	/**
	 * Return the value associated with the column: length
	 */
	public java.lang.Integer getLength () {
		return length;
	}

	/**
	 * Set the value related to the column: length
	 * @param length the length value
	 */
	public void setLength (java.lang.Integer length) {
		this.length = length;
	}



	/**
	 * Return the value associated with the column: un
	 */
	public boolean isUn () {
		return un;
	}

	/**
	 * Set the value related to the column: un
	 * @param un the un value
	 */
	public void setUn (boolean un) {
		this.un = un;
	}



	/**
	 * Return the value associated with the column: onhireaddrkey
	 */
	public java.lang.String getOnhireaddrkey () {
		return onhireaddrkey;
	}

	/**
	 * Set the value related to the column: onhireaddrkey
	 * @param onhireaddrkey the onhireaddrkey value
	 */
	public void setOnhireaddrkey (java.lang.String onhireaddrkey) {
		this.onhireaddrkey = onhireaddrkey;
	}



	/**
	 * Return the value associated with the column: jfa
	 */
	public boolean isJfa () {
		return jfa;
	}

	/**
	 * Set the value related to the column: jfa
	 * @param jfa the jfa value
	 */
	public void setJfa (boolean jfa) {
		this.jfa = jfa;
	}



	/**
	 * Return the value associated with the column: wstatus
	 */
	public java.lang.String getWstatus () {
		return wstatus;
	}

	/**
	 * Set the value related to the column: wstatus
	 * @param wstatus the wstatus value
	 */
	public void setWstatus (java.lang.String wstatus) {
		this.wstatus = wstatus;
	}



	/**
	 * Return the value associated with the column: mrkey
	 */
	public java.lang.String getMrkey () {
		return mrkey;
	}

	/**
	 * Set the value related to the column: mrkey
	 * @param mrkey the mrkey value
	 */
	public void setMrkey (java.lang.String mrkey) {
		this.mrkey = mrkey;
	}



	/**
	 * Return the value associated with the column: maintest
	 */
	public java.lang.String getMaintest () {
		return maintest;
	}

	/**
	 * Set the value related to the column: maintest
	 * @param maintest the maintest value
	 */
	public void setMaintest (java.lang.String maintest) {
		this.maintest = maintest;
	}



	/**
	 * Return the value associated with the column: shdepss
	 */
	public java.math.BigDecimal getShdepss () {
		return shdepss;
	}

	/**
	 * Set the value related to the column: shdepss
	 * @param shdepss the shdepss value
	 */
	public void setShdepss (java.math.BigDecimal shdepss) {
		this.shdepss = shdepss;
	}



	/**
	 * Return the value associated with the column: laststat
	 */
	public java.lang.String getLaststat () {
		return laststat;
	}

	/**
	 * Set the value related to the column: laststat
	 * @param laststat the laststat value
	 */
	public void setLaststat (java.lang.String laststat) {
		this.laststat = laststat;
	}



	/**
	 * Return the value associated with the column: billfirstdate
	 */
	public java.util.Date getBillfirstdate () {
		return billfirstdate;
	}

	/**
	 * Set the value related to the column: billfirstdate
	 * @param billfirstdate the billfirstdate value
	 */
	public void setBillfirstdate (java.util.Date billfirstdate) {
		this.billfirstdate = billfirstdate;
	}



	/**
	 * Return the value associated with the column: capimpg
	 */
	public java.lang.Integer getCapimpg () {
		return capimpg;
	}

	/**
	 * Set the value related to the column: capimpg
	 * @param capimpg the capimpg value
	 */
	public void setCapimpg (java.lang.Integer capimpg) {
		this.capimpg = capimpg;
	}



	/**
	 * Return the value associated with the column: tbworkp
	 */
	public java.math.BigDecimal getTbworkp () {
		return tbworkp;
	}

	/**
	 * Set the value related to the column: tbworkp
	 * @param tbworkp the tbworkp value
	 */
	public void setTbworkp (java.math.BigDecimal tbworkp) {
		this.tbworkp = tbworkp;
	}



	/**
	 * Return the value associated with the column: rid
	 */
	public boolean isRid () {
		return rid;
	}

	/**
	 * Set the value related to the column: rid
	 * @param rid the rid value
	 */
	public void setRid (boolean rid) {
		this.rid = rid;
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
	 * Return the value associated with the column: certifdocfile
	 */
	public java.lang.String getCertifdocfile () {
		return certifdocfile;
	}

	/**
	 * Set the value related to the column: certifdocfile
	 * @param certifdocfile the certifdocfile value
	 */
	public void setCertifdocfile (java.lang.String certifdocfile) {
		this.certifdocfile = certifdocfile;
	}



	/**
	 * Return the value associated with the column: gritfin
	 */
	public java.lang.String getGritfin () {
		return gritfin;
	}

	/**
	 * Set the value related to the column: gritfin
	 * @param gritfin the gritfin value
	 */
	public void setGritfin (java.lang.String gritfin) {
		this.gritfin = gritfin;
	}



	/**
	 * Return the value associated with the column: aar
	 */
	public boolean isAar () {
		return aar;
	}

	/**
	 * Set the value related to the column: aar
	 * @param aar the aar value
	 */
	public void setAar (boolean aar) {
		this.aar = aar;
	}



	/**
	 * Return the value associated with the column: mfprice
	 */
	public java.math.BigDecimal getMfprice () {
		return mfprice;
	}

	/**
	 * Set the value related to the column: mfprice
	 * @param mfprice the mfprice value
	 */
	public void setMfprice (java.math.BigDecimal mfprice) {
		this.mfprice = mfprice;
	}



	/**
	 * Return the value associated with the column: widthf
	 */
	public java.lang.Integer getWidthf () {
		return widthf;
	}

	/**
	 * Set the value related to the column: widthf
	 * @param widthf the widthf value
	 */
	public void setWidthf (java.lang.Integer widthf) {
		this.widthf = widthf;
	}



	/**
	 * Return the value associated with the column: tmdminf
	 */
	public java.math.BigDecimal getTmdminf () {
		return tmdminf;
	}

	/**
	 * Set the value related to the column: tmdminf
	 * @param tmdminf the tmdminf value
	 */
	public void setTmdminf (java.math.BigDecimal tmdminf) {
		this.tmdminf = tmdminf;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: tmdmaxf
	 */
	public java.math.BigDecimal getTmdmaxf () {
		return tmdmaxf;
	}

	/**
	 * Set the value related to the column: tmdmaxf
	 * @param tmdmaxf the tmdmaxf value
	 */
	public void setTmdmaxf (java.math.BigDecimal tmdmaxf) {
		this.tmdmaxf = tmdmaxf;
	}



	/**
	 * Return the value associated with the column: gross
	 */
	public java.lang.Integer getGross () {
		return gross;
	}

	/**
	 * Set the value related to the column: gross
	 * @param gross the gross value
	 */
	public void setGross (java.lang.Integer gross) {
		this.gross = gross;
	}



	/**
	 * Return the value associated with the column: drawtitle2
	 */
	public java.lang.String getDrawtitle2 () {
		return drawtitle2;
	}

	/**
	 * Set the value related to the column: drawtitle2
	 * @param drawtitle2 the drawtitle2 value
	 */
	public void setDrawtitle2 (java.lang.String drawtitle2) {
		this.drawtitle2 = drawtitle2;
	}



	/**
	 * Return the value associated with the column: rvalprs
	 */
	public java.math.BigDecimal getRvalprs () {
		return rvalprs;
	}

	/**
	 * Set the value related to the column: rvalprs
	 * @param rvalprs the rvalprs value
	 */
	public void setRvalprs (java.math.BigDecimal rvalprs) {
		this.rvalprs = rvalprs;
	}



	/**
	 * Return the value associated with the column: reservepreclearkey
	 */
	public java.lang.String getReservepreclearkey () {
		return reservepreclearkey;
	}

	/**
	 * Set the value related to the column: reservepreclearkey
	 * @param reservepreclearkey the reservepreclearkey value
	 */
	public void setReservepreclearkey (java.lang.String reservepreclearkey) {
		this.reservepreclearkey = reservepreclearkey;
	}



	/**
	 * Return the value associated with the column: optuser
	 */
	public java.lang.String getOptuser () {
		return optuser;
	}

	/**
	 * Set the value related to the column: optuser
	 * @param optuser the optuser value
	 */
	public void setOptuser (java.lang.String optuser) {
		this.optuser = optuser;
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
	 * Return the value associated with the column: headmat
	 */
	public java.lang.String getHeadmat () {
		return headmat;
	}

	/**
	 * Set the value related to the column: headmat
	 * @param headmat the headmat value
	 */
	public void setHeadmat (java.lang.String headmat) {
		this.headmat = headmat;
	}



	/**
	 * Return the value associated with the column: newprod
	 */
	public boolean isNewprod () {
		return newprod;
	}

	/**
	 * Set the value related to the column: newprod
	 * @param newprod the newprod value
	 */
	public void setNewprod (boolean newprod) {
		this.newprod = newprod;
	}



	/**
	 * Return the value associated with the column: drawtitle3
	 */
	public java.lang.String getDrawtitle3 () {
		return drawtitle3;
	}

	/**
	 * Set the value related to the column: drawtitle3
	 * @param drawtitle3 the drawtitle3 value
	 */
	public void setDrawtitle3 (java.lang.String drawtitle3) {
		this.drawtitle3 = drawtitle3;
	}



	/**
	 * Return the value associated with the column: lastwhere
	 */
	public java.lang.String getLastwhere () {
		return lastwhere;
	}

	/**
	 * Set the value related to the column: lastwhere
	 * @param lastwhere the lastwhere value
	 */
	public void setLastwhere (java.lang.String lastwhere) {
		this.lastwhere = lastwhere;
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
	 * Return the value associated with the column: uic
	 */
	public boolean isUic () {
		return uic;
	}

	/**
	 * Set the value related to the column: uic
	 * @param uic the uic value
	 */
	public void setUic (boolean uic) {
		this.uic = uic;
	}



	/**
	 * Return the value associated with the column: bam
	 */
	public boolean isBam () {
		return bam;
	}

	/**
	 * Set the value related to the column: bam
	 * @param bam the bam value
	 */
	public void setBam (boolean bam) {
		this.bam = bam;
	}



	/**
	 * Return the value associated with the column: framdes
	 */
	public java.lang.String getFramdes () {
		return framdes;
	}

	/**
	 * Set the value related to the column: framdes
	 * @param framdes the framdes value
	 */
	public void setFramdes (java.lang.String framdes) {
		this.framdes = framdes;
	}



	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
	}



	/**
	 * Return the value associated with the column: allocnumber
	 */
	public java.lang.Integer getAllocnumber () {
		return allocnumber;
	}

	/**
	 * Set the value related to the column: allocnumber
	 * @param allocnumber the allocnumber value
	 */
	public void setAllocnumber (java.lang.Integer allocnumber) {
		this.allocnumber = allocnumber;
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
	 * Return the value associated with the column: warexp
	 */
	public java.util.Date getWarexp () {
		return warexp;
	}

	/**
	 * Set the value related to the column: warexp
	 * @param warexp the warexp value
	 */
	public void setWarexp (java.util.Date warexp) {
		this.warexp = warexp;
	}



	/**
	 * Return the value associated with the column: ctc
	 */
	public boolean isCtc () {
		return ctc;
	}

	/**
	 * Set the value related to the column: ctc
	 * @param ctc the ctc value
	 */
	public void setCtc (boolean ctc) {
		this.ctc = ctc;
	}



	/**
	 * Return the value associated with the column: asme
	 */
	public boolean isAsme () {
		return asme;
	}

	/**
	 * Set the value related to the column: asme
	 * @param asme the asme value
	 */
	public void setAsme (boolean asme) {
		this.asme = asme;
	}



	/**
	 * Return the value associated with the column: dmthick
	 */
	public java.math.BigDecimal getDmthick () {
		return dmthick;
	}

	/**
	 * Set the value related to the column: dmthick
	 * @param dmthick the dmthick value
	 */
	public void setDmthick (java.math.BigDecimal dmthick) {
		this.dmthick = dmthick;
	}



	/**
	 * Return the value associated with the column: thfyear
	 */
	public java.util.Date getThfyear () {
		return thfyear;
	}

	/**
	 * Set the value related to the column: thfyear
	 * @param thfyear the thfyear value
	 */
	public void setThfyear (java.util.Date thfyear) {
		this.thfyear = thfyear;
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
	 * Return the value associated with the column: fstwhere
	 */
	public java.lang.String getFstwhere () {
		return fstwhere;
	}

	/**
	 * Set the value related to the column: fstwhere
	 * @param fstwhere the fstwhere value
	 */
	public void setFstwhere (java.lang.String fstwhere) {
		this.fstwhere = fstwhere;
	}



	/**
	 * Return the value associated with the column: tarel
	 */
	public java.lang.Integer getTarel () {
		return tarel;
	}

	/**
	 * Set the value related to the column: tarel
	 * @param tarel the tarel value
	 */
	public void setTarel (java.lang.Integer tarel) {
		this.tarel = tarel;
	}



	/**
	 * Return the value associated with the column: heightf
	 */
	public java.lang.Integer getHeightf () {
		return heightf;
	}

	/**
	 * Set the value related to the column: heightf
	 * @param heightf the heightf value
	 */
	public void setHeightf (java.lang.Integer heightf) {
		this.heightf = heightf;
	}



	/**
	 * Return the value associated with the column: intermgrdate
	 */
	public java.util.Date getIntermgrdate () {
		return intermgrdate;
	}

	/**
	 * Set the value related to the column: intermgrdate
	 * @param intermgrdate the intermgrdate value
	 */
	public void setIntermgrdate (java.util.Date intermgrdate) {
		this.intermgrdate = intermgrdate;
	}



	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
	}



	/**
	 * Return the value associated with the column: g1key
	 */
	public java.lang.String getG1key () {
		return g1key;
	}

	/**
	 * Set the value related to the column: g1key
	 * @param g1key the g1key value
	 */
	public void setG1key (java.lang.String g1key) {
		this.g1key = g1key;
	}



	/**
	 * Return the value associated with the column: mfcde
	 */
	public java.lang.String getMfcde () {
		return mfcde;
	}

	/**
	 * Set the value related to the column: mfcde
	 * @param mfcde the mfcde value
	 */
	public void setMfcde (java.lang.String mfcde) {
		this.mfcde = mfcde;
	}



	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String eqpkeyp3) {
		this.eqpkeyp3 = eqpkeyp3;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.Integer height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: writeoffreason
	 */
	public java.lang.String getWriteoffreason () {
		return writeoffreason;
	}

	/**
	 * Set the value related to the column: writeoffreason
	 * @param writeoffreason the writeoffreason value
	 */
	public void setWriteoffreason (java.lang.String writeoffreason) {
		this.writeoffreason = writeoffreason;
	}



	/**
	 * Return the value associated with the column: capcm
	 */
	public java.lang.Integer getCapcm () {
		return capcm;
	}

	/**
	 * Set the value related to the column: capcm
	 * @param capcm the capcm value
	 */
	public void setCapcm (java.lang.Integer capcm) {
		this.capcm = capcm;
	}



	/**
	 * Return the value associated with the column: caplit
	 */
	public java.lang.Integer getCaplit () {
		return caplit;
	}

	/**
	 * Set the value related to the column: caplit
	 * @param caplit the caplit value
	 */
	public void setCaplit (java.lang.Integer caplit) {
		this.caplit = caplit;
	}



	/**
	 * Return the value associated with the column: intermgracceptid
	 */
	public java.lang.String getIntermgracceptid () {
		return intermgracceptid;
	}

	/**
	 * Set the value related to the column: intermgracceptid
	 * @param intermgracceptid the intermgracceptid value
	 */
	public void setIntermgracceptid (java.lang.String intermgracceptid) {
		this.intermgracceptid = intermgracceptid;
	}



	/**
	 * Return the value associated with the column: drawtitle1
	 */
	public java.lang.String getDrawtitle1 () {
		return drawtitle1;
	}

	/**
	 * Set the value related to the column: drawtitle1
	 * @param drawtitle1 the drawtitle1 value
	 */
	public void setDrawtitle1 (java.lang.String drawtitle1) {
		this.drawtitle1 = drawtitle1;
	}



	/**
	 * Return the value associated with the column: pokey
	 */
	public java.lang.String getPokey () {
		return pokey;
	}

	/**
	 * Set the value related to the column: pokey
	 * @param pokey the pokey value
	 */
	public void setPokey (java.lang.String pokey) {
		this.pokey = pokey;
	}



	/**
	 * Return the value associated with the column: optresno
	 */
	public java.lang.Integer getOptresno () {
		return optresno;
	}

	/**
	 * Set the value related to the column: optresno
	 * @param optresno the optresno value
	 */
	public void setOptresno (java.lang.Integer optresno) {
		this.optresno = optresno;
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
	 * Return the value associated with the column: rvalvacp
	 */
	public java.math.BigDecimal getRvalvacp () {
		return rvalvacp;
	}

	/**
	 * Set the value related to the column: rvalvacp
	 * @param rvalvacp the rvalvacp value
	 */
	public void setRvalvacp (java.math.BigDecimal rvalvacp) {
		this.rvalvacp = rvalvacp;
	}



	/**
	 * Return the value associated with the column: altiso
	 */
	public java.lang.String getAltiso () {
		return altiso;
	}

	/**
	 * Set the value related to the column: altiso
	 * @param altiso the altiso value
	 */
	public void setAltiso (java.lang.String altiso) {
		this.altiso = altiso;
	}



	/**
	 * Return the value associated with the column: disposaldate
	 */
	public java.util.Date getDisposaldate () {
		return disposaldate;
	}

	/**
	 * Set the value related to the column: disposaldate
	 * @param disposaldate the disposaldate value
	 */
	public void setDisposaldate (java.util.Date disposaldate) {
		this.disposaldate = disposaldate;
	}



	/**
	 * Return the value associated with the column: maxtrips
	 */
	public java.lang.Integer getMaxtrips () {
		return maxtrips;
	}

	/**
	 * Set the value related to the column: maxtrips
	 * @param maxtrips the maxtrips value
	 */
	public void setMaxtrips (java.lang.Integer maxtrips) {
		this.maxtrips = maxtrips;
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
	 * Return the value associated with the column: mfaddrkey
	 */
	public java.lang.String getMfaddrkey () {
		return mfaddrkey;
	}

	/**
	 * Set the value related to the column: mfaddrkey
	 * @param mfaddrkey the mfaddrkey value
	 */
	public void setMfaddrkey (java.lang.String mfaddrkey) {
		this.mfaddrkey = mfaddrkey;
	}



	/**
	 * Return the value associated with the column: movemsgdate
	 */
	public java.util.Date getMovemsgdate () {
		return movemsgdate;
	}

	/**
	 * Set the value related to the column: movemsgdate
	 * @param movemsgdate the movemsgdate value
	 */
	public void setMovemsgdate (java.util.Date movemsgdate) {
		this.movemsgdate = movemsgdate;
	}



	/**
	 * Return the value associated with the column: movemsgtxt
	 */
	public java.lang.String getMovemsgtxt () {
		return movemsgtxt;
	}

	/**
	 * Set the value related to the column: movemsgtxt
	 * @param movemsgtxt the movemsgtxt value
	 */
	public void setMovemsgtxt (java.lang.String movemsgtxt) {
		this.movemsgtxt = movemsgtxt;
	}



	/**
	 * Return the value associated with the column: moveseqno
	 */
	public java.lang.Integer getMoveseqno () {
		return moveseqno;
	}

	/**
	 * Set the value related to the column: moveseqno
	 * @param moveseqno the moveseqno value
	 */
	public void setMoveseqno (java.lang.Integer moveseqno) {
		this.moveseqno = moveseqno;
	}



	/**
	 * Return the value associated with the column: moveeirdate
	 */
	public java.util.Date getMoveeirdate () {
		return moveeirdate;
	}

	/**
	 * Set the value related to the column: moveeirdate
	 * @param moveeirdate the moveeirdate value
	 */
	public void setMoveeirdate (java.util.Date moveeirdate) {
		this.moveeirdate = moveeirdate;
	}



	/**
	 * Return the value associated with the column: moveeirkey
	 */
	public java.lang.String getMoveeirkey () {
		return moveeirkey;
	}

	/**
	 * Set the value related to the column: moveeirkey
	 * @param moveeirkey the moveeirkey value
	 */
	public void setMoveeirkey (java.lang.String moveeirkey) {
		this.moveeirkey = moveeirkey;
	}



	/**
	 * Return the value associated with the column: movemsgstop
	 */
	public boolean isMovemsgstop () {
		return movemsgstop;
	}

	/**
	 * Set the value related to the column: movemsgstop
	 * @param movemsgstop the movemsgstop value
	 */
	public void setMovemsgstop (boolean movemsgstop) {
		this.movemsgstop = movemsgstop;
	}



	/**
	 * Return the value associated with the column: movemsgdisp
	 */
	public boolean isMovemsgdisp () {
		return movemsgdisp;
	}

	/**
	 * Set the value related to the column: movemsgdisp
	 * @param movemsgdisp the movemsgdisp value
	 */
	public void setMovemsgdisp (boolean movemsgdisp) {
		this.movemsgdisp = movemsgdisp;
	}



	/**
	 * Return the value associated with the column: movenotes
	 */
	public java.lang.String getMovenotes () {
		return movenotes;
	}

	/**
	 * Set the value related to the column: movenotes
	 * @param movenotes the movenotes value
	 */
	public void setMovenotes (java.lang.String movenotes) {
		this.movenotes = movenotes;
	}



	/**
	 * Return the value associated with the column: movedate
	 */
	public java.util.Date getMovedate () {
		return movedate;
	}

	/**
	 * Set the value related to the column: movedate
	 * @param movedate the movedate value
	 */
	public void setMovedate (java.util.Date movedate) {
		this.movedate = movedate;
	}



	/**
	 * Return the value associated with the column: movetimeinmillis
	 */
	public java.lang.Long getMovetimeinmillis () {
		return movetimeinmillis;
	}

	/**
	 * Set the value related to the column: movetimeinmillis
	 * @param movetimeinmillis the movetimeinmillis value
	 */
	public void setMovetimeinmillis (java.lang.Long movetimeinmillis) {
		this.movetimeinmillis = movetimeinmillis;
	}



	/**
	 * Return the value associated with the column: movetime
	 */
	public java.lang.String getMovetime () {
		return movetime;
	}

	/**
	 * Set the value related to the column: movetime
	 * @param movetime the movetime value
	 */
	public void setMovetime (java.lang.String movetime) {
		this.movetime = movetime;
	}



	/**
	 * Return the value associated with the column: moveaddrkey
	 */
	public java.lang.String getMoveaddrkey () {
		return moveaddrkey;
	}

	/**
	 * Set the value related to the column: moveaddrkey
	 * @param moveaddrkey the moveaddrkey value
	 */
	public void setMoveaddrkey (java.lang.String moveaddrkey) {
		this.moveaddrkey = moveaddrkey;
	}



	/**
	 * Return the value associated with the column: moveref
	 */
	public java.lang.String getMoveref () {
		return moveref;
	}

	/**
	 * Set the value related to the column: moveref
	 * @param moveref the moveref value
	 */
	public void setMoveref (java.lang.String moveref) {
		this.moveref = moveref;
	}



	/**
	 * Return the value associated with the column: moveproductkey
	 */
	public java.lang.String getMoveproductkey () {
		return moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String moveproductkey) {
		this.moveproductkey = moveproductkey;
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
	 * Return the value associated with the column: jobmovdate
	 */
	public java.util.Date getJobmovdate () {
		return jobmovdate;
	}

	/**
	 * Set the value related to the column: jobmovdate
	 * @param jobmovdate the jobmovdate value
	 */
	public void setJobmovdate (java.util.Date jobmovdate) {
		this.jobmovdate = jobmovdate;
	}



	/**
	 * Return the value associated with the column: jobmovtime
	 */
	public java.lang.String getJobmovtime () {
		return jobmovtime;
	}

	/**
	 * Set the value related to the column: jobmovtime
	 * @param jobmovtime the jobmovtime value
	 */
	public void setJobmovtime (java.lang.String jobmovtime) {
		this.jobmovtime = jobmovtime;
	}



	/**
	 * Return the value associated with the column: jobmovtimeinmillis
	 */
	public java.lang.Long getJobmovtimeinmillis () {
		return jobmovtimeinmillis;
	}

	/**
	 * Set the value related to the column: jobmovtimeinmillis
	 * @param jobmovtimeinmillis the jobmovtimeinmillis value
	 */
	public void setJobmovtimeinmillis (java.lang.Long jobmovtimeinmillis) {
		this.jobmovtimeinmillis = jobmovtimeinmillis;
	}



	/**
	 * Return the value associated with the column: jobmovvessel
	 */
	public java.lang.String getJobmovvessel () {
		return jobmovvessel;
	}

	/**
	 * Set the value related to the column: jobmovvessel
	 * @param jobmovvessel the jobmovvessel value
	 */
	public void setJobmovvessel (java.lang.String jobmovvessel) {
		this.jobmovvessel = jobmovvessel;
	}



	/**
	 * Return the value associated with the column: invsts
	 */
	public java.lang.String getInvsts () {
		return invsts;
	}

	/**
	 * Set the value related to the column: invsts
	 * @param invsts the invsts value
	 */
	public void setInvsts (java.lang.String invsts) {
		this.invsts = invsts;
	}



	/**
	 * Return the value associated with the column: jobmovref
	 */
	public java.lang.String getJobmovref () {
		return jobmovref;
	}

	/**
	 * Set the value related to the column: jobmovref
	 * @param jobmovref the jobmovref value
	 */
	public void setJobmovref (java.lang.String jobmovref) {
		this.jobmovref = jobmovref;
	}



	/**
	 * Return the value associated with the column: PODTLRCVD_ID
	 */
	public java.lang.Integer getPodtlrcvdId () {
		return podtlrcvdId;
	}

	/**
	 * Set the value related to the column: PODTLRCVD_ID
	 * @param podtlrcvdId the PODTLRCVD_ID value
	 */
	public void setPodtlrcvdId (java.lang.Integer podtlrcvdId) {
		this.podtlrcvdId = podtlrcvdId;
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
	 * Return the value associated with the column: ONHIREEQP_ID
	 */
	public java.lang.Integer getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the value related to the column: ONHIREEQP_ID
	 * @param onhireeqpId the ONHIREEQP_ID value
	 */
	public void setOnhireeqpId (java.lang.Integer onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
	}



	/**
	 * Return the value associated with the column: OFFHIREEQP_ID
	 */
	public java.lang.Integer getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the value related to the column: OFFHIREEQP_ID
	 * @param offhireeqpId the OFFHIREEQP_ID value
	 */
	public void setOffhireeqpId (java.lang.Integer offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
	}



	/**
	 * Return the value associated with the column: movelocationkey
	 */
	public java.lang.String getMovelocationkey () {
		return movelocationkey;
	}

	/**
	 * Set the value related to the column: movelocationkey
	 * @param movelocationkey the movelocationkey value
	 */
	public void setMovelocationkey (java.lang.String movelocationkey) {
		this.movelocationkey = movelocationkey;
	}



	/**
	 * Return the value associated with the column: jobmovlocationkey
	 */
	public java.lang.String getJobmovlocationkey () {
		return jobmovlocationkey;
	}

	/**
	 * Set the value related to the column: jobmovlocationkey
	 * @param jobmovlocationkey the jobmovlocationkey value
	 */
	public void setJobmovlocationkey (java.lang.String jobmovlocationkey) {
		this.jobmovlocationkey = jobmovlocationkey;
	}



	/**
	 * Return the value associated with the column: manuflocationkey
	 */
	public java.lang.String getManuflocationkey () {
		return manuflocationkey;
	}

	/**
	 * Set the value related to the column: manuflocationkey
	 * @param manuflocationkey the manuflocationkey value
	 */
	public void setManuflocationkey (java.lang.String manuflocationkey) {
		this.manuflocationkey = manuflocationkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Unit)) return false;
		else {
			com.bureaueye.beacon.model.standard.Unit unit = (com.bureaueye.beacon.model.standard.Unit) obj;
			if (null == this.getUnitId() || null == unit.getUnitId()) return false;
			else return (this.getUnitId().equals(unit.getUnitId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUnitId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUnitId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}