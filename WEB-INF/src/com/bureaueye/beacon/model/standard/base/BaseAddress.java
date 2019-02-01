package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the address table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="address"
 */

public abstract class BaseAddress  implements Serializable {

	public static String REF = "Address";
	public static String PROP_HEADOFFICE = "Headoffice";
	public static String PROP_UNITSALLOWED = "Unitsallowed";
	public static String PROP_STOPFLAG = "Stopflag";
	public static String PROP_AGENTTERRITORY = "Agentterritory";
	public static String PROP_PAYTOADDRKEY = "Paytoaddrkey";
	public static String PROP_FREEDAYS = "Freedays";
	public static String PROP_OLD_ACCOUNT = "OldAccount";
	public static String PROP_BANKCHKDGT = "Bankchkdgt";
	public static String PROP_CRDTEUONHIRE = "Crdteuonhire";
	public static String PROP_LEAD_SOURCE = "LeadSource";
	public static String PROP_PROSPECT_CHG_DATE = "ProspectChgDate";
	public static String PROP_RENTINVTYP = "Rentinvtyp";
	public static String PROP_VATCODE = "Vatcode";
	public static String PROP_BOOKEXPDAYS = "Bookexpdays";
	public static String PROP_PROSPECT_FLAG = "ProspectFlag";
	public static String PROP_CRDUNDWRTDATE = "Crdundwrtdate";
	public static String PROP_CONTACT2 = "Contact2";
	public static String PROP_CONTACT3 = "Contact3";
	public static String PROP_CONTACT1 = "Contact1";
	public static String PROP_RECHARGEMARKUP = "Rechargemarkup";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_DMRGFREEDAYS = "Dmrgfreedays";
	public static String PROP_SUNBATCH = "Sunbatch";
	public static String PROP_ADDR3 = "Addr3";
	public static String PROP_ADDR4 = "Addr4";
	public static String PROP_ADDR1 = "Addr1";
	public static String PROP_ADDR2 = "Addr2";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_MAXIMUM_GROSS = "MaximumGross";
	public static String PROP_ADDR5 = "Addr5";
	public static String PROP_RENTINVTIM = "Rentinvtim";
	public static String PROP_MARKETREP = "Marketrep";
	public static String PROP_LANGKEY = "Langkey";
	public static String PROP_STORAGERATE = "Storagerate";
	public static String PROP_INSEXPIRY = "Insexpiry";
	public static String PROP_RATING = "Rating";
	public static String PROP_G4CODEKEY = "G4codekey";
	public static String PROP_IMPORTID = "Importid";
	public static String PROP_ACCOUNTNAME = "Accountname";
	public static String PROP_INVPREF = "Invpref";
	public static String PROP_TEURATE = "Teurate";
	public static String PROP_MONINVDAT = "Moninvdat";
	public static String PROP_G3CODEKEY = "G3codekey";
	public static String PROP_PERIOD = "Period";
	public static String PROP_PREDMRGFREEDAYS = "Predmrgfreedays";
	public static String PROP_FAXNO2 = "Faxno2";
	public static String PROP_FAXNO3 = "Faxno3";
	public static String PROP_SMS_ENTITY = "SmsEntity";
	public static String PROP_FAXNO1 = "Faxno1";
	public static String PROP_DATAPROTECT = "Dataprotect";
	public static String PROP_ADDRKEY = "Addrkey";
	public static String PROP_GEO_CODE = "GeoCode";
	public static String PROP_CREDIT_STATUS = "CreditStatus";
	public static String PROP_PROSPECT_ADDRKEY = "ProspectAddrkey";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CRDREPNOTES = "Crdrepnotes";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_CUSBNKCCYKEYLIST = "Cusbnkccykeylist";
	public static String PROP_LESSORADDRKEY = "Lessoraddrkey";
	public static String PROP_BANKSORTCODE = "Banksortcode";
	public static String PROP_TYPEKEY = "Typekey";
	public static String PROP_BANKSWIFTCODE = "Bankswiftcode";
	public static String PROP_BLNOPREFX = "Blnoprefx";
	public static String PROP_EMAILNO2 = "Emailno2";
	public static String PROP_SALES_TERRITORY = "SalesTerritory";
	public static String PROP_EMAILNO1 = "Emailno1";
	public static String PROP_LOCALCENTRAL = "Localcentral";
	public static String PROP_EMAILNO3 = "Emailno3";
	public static String PROP_SHORTNAME = "Shortname";
	public static String PROP_PARTMARKUP = "Partmarkup";
	public static String PROP_SELFBILLFLAG = "Selfbillflag";
	public static String PROP_CITY = "City";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_OWNCOMPANY = "Owncompany";
	public static String PROP_CTITLE3 = "Ctitle3";
	public static String PROP_CTITLE1 = "Ctitle1";
	public static String PROP_INSTEXT = "Instext";
	public static String PROP_CTITLE2 = "Ctitle2";
	public static String PROP_ACCOUNTNO = "Accountno";
	public static String PROP_INSPOLICYGRADE = "Inspolicygrade";
	public static String PROP_INVOICEGROUPREF = "Invoicegroupref";
	public static String PROP_EDIADDRKEY = "Ediaddrkey";
	public static String PROP_G1CODEKEY = "G1codekey";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_EXTSYSADDRESSID = "Extsysaddressid";
	public static String PROP_CBSE_VALID = "CbseValid";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_REVIEWDATE = "Reviewdate";
	public static String PROP_BLSEQNO = "Blseqno";
	public static String PROP_INSPOLICYTYPE = "Inspolicytype";
	public static String PROP_RENTINVARRDES = "Rentinvarrdes";
	public static String PROP_SWIFTCODE = "Swiftcode";
	public static String PROP_CUST_ID = "CustId";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_ACCSYSADDRESSID = "Accsysaddressid";
	public static String PROP_PAYTERMSTEXT = "Paytermstext";
	public static String PROP_RECORDKEY = "Recordkey";
	public static String PROP_COMPCODE = "Compcode";
	public static String PROP_REVIEWNOTE = "Reviewnote";
	public static String PROP_POSTALCODE = "Postalcode";
	public static String PROP_LIMITCCY = "Limitccy";
	public static String PROP_COPYADD = "Copyadd";
	public static String PROP_ACC_REP = "AccRep";
	public static String PROP_RENTINVAMT = "Rentinvamt";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_CURRDLYRENT = "Currdlyrent";
	public static String PROP_CUSBNKADDRKEYLIST = "Cusbnkaddrkeylist";
	public static String PROP_LASTRENTINVDAT = "Lastrentinvdat";
	public static String PROP_BANKCODE = "Bankcode";
	public static String PROP_TERMS = "Terms";
	public static String PROP_SMS_BRANCH = "SmsBranch";
	public static String PROP_CRDUPDATEDATE = "Crdupdatedate";
	public static String PROP_CREDIT_REQ = "CreditReq";
	public static String PROP_CUSBNKACCNOLIST = "Cusbnkaccnolist";
	public static String PROP_COMMISSIONTYPE = "commissiontype";
	public static String PROP_BILLHDRTYPE = "Billhdrtype";
	public static String PROP_WEBADDRESS = "Webaddress";
	public static String PROP_NOTES = "Notes";
	public static String PROP_EMAILNO = "Emailno";
	public static String PROP_CRDTEULIMIT = "Crdteulimit";
	public static String PROP_LOCATIONCODE = "Locationcode";
	public static String PROP_MAINACCADDRKEY = "Mainaccaddrkey";
	public static String PROP_ACCCODE = "Acccode";
	public static String PROP_TOWN = "Town";
	public static String PROP_CRDUPDATEBY = "Crdupdateby";
	public static String PROP_TELNO3 = "Telno3";
	public static String PROP_TELNO2 = "Telno2";
	public static String PROP_VATNO = "Vatno";
	public static String PROP_TELNO1 = "Telno1";
	public static String PROP_SALESPER = "Salesper";
	public static String PROP_RENTINVDAT = "Rentinvdat";
	public static String PROP_CBSE_CORPCODE = "CbseCorpcode";
	public static String PROP_CUSTOMER_GROUP = "CustomerGroup";
	public static String PROP_TELNO = "Telno";
	public static String PROP_OVER_WEIGHT_PERMIT = "OverWeightPermit";
	public static String PROP_G2CODEKEY = "G2codekey";
	public static String PROP_VATREGISTER = "Vatregister";
	public static String PROP_ENTITY = "Entity";
	public static String PROP_XACTION = "Xaction";
	public static String PROP_LIFTONLIFTOFF = "Liftonliftoff";
	public static String PROP_COUNTRYKEY = "Countrykey";
	public static String PROP_SETID = "Setid";
	public static String PROP_RENTADDRKEY = "Rentaddrkey";
	public static String PROP_FAXNO = "Faxno";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_SURCHARGE = "Surcharge";
	public static String PROP_CRDDEFAULTDATE = "Crddefaultdate";
	public static String PROP_CRDMEMONOTES = "Crdmemonotes";
	public static String PROP_REVIEWBY = "Reviewby";
	public static String PROP_COLLECTREP = "Collectrep";
	public static String PROP_REGION = "Region";
	public static String PROP_PAYTERMS = "Payterms";
	public static String PROP_LOAD_MONTH = "LoadMonth";
	public static String PROP_BANKID = "Bankid";
	public static String PROP_CONTACT = "Contact";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_LOCALVNDR = "Localvndr";
	public static String PROP_PRECLEAREXPDAYS = "Preclearexpdays";
	public static String PROP_DEPOTTYPE = "Depottype";
	public static String PROP_CTITLE = "Ctitle";
	public static String PROP_DEPOTSTOCKFLAG = "Depotstockflag";
	public static String PROP_RECTYPE = "Rectype";
	public static String PROP_NAME = "Name";
	public static String PROP_BMAPPLIC = "Bmapplic";
	public static String PROP_TYPEKEYLIST = "Typekeylist";
	public static String PROP_LABRATE = "Labrate";
	public static String PROP_STATE = "State";
	public static String PROP_DIRINVREP = "Dirinvrep";
	public static String PROP_PROSPECT_CHG_USERID = "ProspectChgUserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CRDRCVSTS = "Crdrcvsts";
	public static String PROP_PAYMENTTOINSTRUCTIONS = "Paymenttoinstructions";


	// constructors
	public BaseAddress () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddress (java.lang.String addrkey) {
		this.setAddrkey(addrkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String addrkey;

	// fields
	private java.lang.Integer region;
	private java.lang.String xtime;
	private java.lang.String paytermstext;
	private java.lang.String vatno;
	private java.lang.String prospectAddrkey;
	private java.lang.String headoffice;
	private java.lang.String crdmemonotes;
	private java.lang.Integer crdteuonhire;
	private java.lang.String crdupdateby;
	private java.lang.String bankchkdgt;
	private java.lang.String localcentral;
	private java.lang.Integer preclearexpdays;
	private java.util.Date reviewdate;
	private java.lang.String oldAccount;
	private java.lang.String smsBranch;
	private java.lang.String marketrep;
	private java.lang.Integer predmrgfreedays;
	private java.lang.String postalcode;
	private java.lang.String depottype;
	private java.lang.String compcode;
	private java.lang.String rentinvtyp;
	private java.lang.Integer rentinvamt;
	private java.math.BigDecimal currdlyrent;
	private java.lang.String addr1;
	private java.lang.String typekey;
	private java.lang.String vatregister;
	private java.lang.Integer loadMonth;
	private java.lang.String state;
	private java.lang.String inspolicytype;
	private java.lang.String ccykey;
	private java.lang.String limitccy;
	private java.lang.String town;
	private java.lang.Integer crdteulimit;
	private java.lang.String prospectFlag;
	private java.lang.String crdrcvsts;
	private java.lang.Integer blseqno;
	private java.lang.String rating;
	private java.lang.String emailno1;
	private java.lang.String vatcode;
	private java.lang.String xinactive;
	private java.lang.String accRep;
	private java.lang.String inspolicygrade;
	private java.lang.String g1codekey;
	private java.lang.String teurate;
	private java.lang.String contact3;
	private java.lang.String g4codekey;
	private java.lang.String ctitle2;
	private java.util.Date prospectChgDate;
	private java.math.BigDecimal storagerate;
	private java.lang.String mainaccaddrkey;
	private java.lang.String rentaddrkey;
	private java.lang.String name;
	private java.lang.String city;
	private java.lang.String selfbillflag;
	private java.lang.String cusbnkaddrkeylist;
	private java.lang.String telno2;
	private java.lang.String copyadd;
	private java.lang.String invoicegroupref;
	private java.lang.String geoCode;
	private java.lang.String dirinvrep;
	private java.lang.String faxno1;
	private java.lang.String telno3;
	private java.lang.String createuserid;
	private java.lang.String bankswiftcode;
	private java.lang.String g3codekey;
	private java.lang.String webaddress;
	private java.lang.String leadSource;
	private java.lang.String faxno2;
	private java.lang.String country;
	private java.lang.String importid;
	private java.lang.String telno1;
	private java.lang.String emailno;
	private java.lang.String xuserid;
	private java.lang.Integer maximumGross;
	private java.lang.String reviewnote;
	private java.lang.String cusbnkccykeylist;
	private java.lang.String shortname;
	private java.math.BigDecimal creditReq;
	private java.lang.String ctitle3;
	private java.lang.String contact1;
	private java.lang.Integer unitsallowed;
	private java.lang.String accountname;
	private java.lang.String setid;
	private java.lang.String emailno3;
	private java.util.Date xdate;
	private java.lang.String rentinvtim;
	private java.math.BigDecimal liftonliftoff;
	private java.lang.String ctitle;
	private java.util.Date moninvdat;
	private java.lang.Integer dmrgfreedays;
	private java.lang.String xaction;
	private java.lang.String addr2;
	private java.lang.String addr4;
	private java.lang.String dataprotect;
	private java.lang.String contact2;
	private java.lang.String reviewby;
	private java.lang.String bankcode;
	private java.lang.String addr5;
	private java.lang.String ediaddrkey;
	private java.lang.String customerGroup;
	private java.lang.String bankid;
	private java.lang.String prospectChgUserid;
	private java.lang.String sunbatch;
	private java.util.Date crdundwrtdate;
	private java.lang.String deleted;
	private java.lang.String cbseCorpcode;
	private java.lang.String salesTerritory;
	private java.lang.String bmapplic;
	private java.lang.String notes;
	private java.lang.String custId;
	private java.lang.String entity;
	private java.lang.String depotstockflag;
	private java.lang.String banksortcode;
	private java.util.Date insexpiry;
	private java.lang.String faxno;
	private java.lang.String crdrepnotes;
	private java.lang.String emailno2;
	private java.lang.String contact;
	private java.lang.Integer freedays;
	private java.lang.Integer bookexpdays;
	private java.lang.String cusbnkaccnolist;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String xprog;
	private java.lang.String accountno;
	private java.lang.String terms;
	private java.lang.String collectrep;
	private java.lang.String lessoraddrkey;
	private java.lang.String g2codekey;
	private java.lang.String localvndr;
	private java.util.Date crdupdatedate;
	private java.lang.String invpref;
	private java.lang.String agentterritory;
	private java.util.Date rentinvdat;
	private java.lang.String instext;
	private java.lang.String salesper;
	private java.lang.String rentinvarrdes;
	private java.math.BigDecimal rechargemarkup;
	private java.lang.String langkey;
	private java.lang.String creditStatus;
	private java.lang.String ctitle1;
	private java.lang.String swiftcode;
	private java.util.Date crddefaultdate;
	private java.util.Date createdate;
	private java.math.BigDecimal labrate;
	private java.lang.String billhdrtype;
	private java.lang.String faxno3;
	private java.lang.String recordkey;
	private java.lang.String telno;
	private java.math.BigDecimal surcharge;
	private java.lang.String period;
	private java.lang.String stopflag;
	private java.lang.String paytoaddrkey;
	private java.lang.String addr3;
	private java.lang.Integer payterms;
	private java.util.Date lastrentinvdat;
	private java.math.BigDecimal partmarkup;
	private java.lang.Integer rowid;
	private java.lang.String cbseValid;
	private java.lang.String smsEntity;
	private java.lang.String acccode;
	private java.lang.String blnoprefx;
	private java.lang.String overWeightPermit;
	private java.lang.String rectype;
	private java.lang.String owncompany;
	private java.lang.String countrykey;
	private java.lang.String locationcode;
	private java.lang.String paymenttoinstructions;
	private java.lang.String typekeylist;
	private java.lang.String accsysaddressid;
	private java.lang.String commissiontype;
	private java.lang.String extsysaddressid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="addrkey"
     */
	public java.lang.String getAddrkey () {
		return addrkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param addrkey the new ID
	 */
	public void setAddrkey (java.lang.String addrkey) {
		this.addrkey = addrkey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: region
	 */
	public java.lang.Integer getRegion () {
		return region;
	}

	/**
	 * Set the value related to the column: region
	 * @param region the region value
	 */
	public void setRegion (java.lang.Integer region) {
		this.region = region;
	}



	/**
	 * Return the value associated with the column: xtime
	 */
	public java.lang.String getXtime () {
		return xtime;
	}

	/**
	 * Set the value related to the column: xtime
	 * @param xtime the xtime value
	 */
	public void setXtime (java.lang.String xtime) {
		this.xtime = xtime;
	}



	/**
	 * Return the value associated with the column: paytermstext
	 */
	public java.lang.String getPaytermstext () {
		return paytermstext;
	}

	/**
	 * Set the value related to the column: paytermstext
	 * @param paytermstext the paytermstext value
	 */
	public void setPaytermstext (java.lang.String paytermstext) {
		this.paytermstext = paytermstext;
	}



	/**
	 * Return the value associated with the column: vatno
	 */
	public java.lang.String getVatno () {
		return vatno;
	}

	/**
	 * Set the value related to the column: vatno
	 * @param vatno the vatno value
	 */
	public void setVatno (java.lang.String vatno) {
		this.vatno = vatno;
	}



	/**
	 * Return the value associated with the column: prospect_addrkey
	 */
	public java.lang.String getProspectAddrkey () {
		return prospectAddrkey;
	}

	/**
	 * Set the value related to the column: prospect_addrkey
	 * @param prospectAddrkey the prospect_addrkey value
	 */
	public void setProspectAddrkey (java.lang.String prospectAddrkey) {
		this.prospectAddrkey = prospectAddrkey;
	}



	/**
	 * Return the value associated with the column: headoffice
	 */
	public java.lang.String getHeadoffice () {
		return headoffice;
	}

	/**
	 * Set the value related to the column: headoffice
	 * @param headoffice the headoffice value
	 */
	public void setHeadoffice (java.lang.String headoffice) {
		this.headoffice = headoffice;
	}



	/**
	 * Return the value associated with the column: crdmemonotes
	 */
	public java.lang.String getCrdmemonotes () {
		return crdmemonotes;
	}

	/**
	 * Set the value related to the column: crdmemonotes
	 * @param crdmemonotes the crdmemonotes value
	 */
	public void setCrdmemonotes (java.lang.String crdmemonotes) {
		this.crdmemonotes = crdmemonotes;
	}



	/**
	 * Return the value associated with the column: crdteuonhire
	 */
	public java.lang.Integer getCrdteuonhire () {
		return crdteuonhire;
	}

	/**
	 * Set the value related to the column: crdteuonhire
	 * @param crdteuonhire the crdteuonhire value
	 */
	public void setCrdteuonhire (java.lang.Integer crdteuonhire) {
		this.crdteuonhire = crdteuonhire;
	}



	/**
	 * Return the value associated with the column: crdupdateby
	 */
	public java.lang.String getCrdupdateby () {
		return crdupdateby;
	}

	/**
	 * Set the value related to the column: crdupdateby
	 * @param crdupdateby the crdupdateby value
	 */
	public void setCrdupdateby (java.lang.String crdupdateby) {
		this.crdupdateby = crdupdateby;
	}



	/**
	 * Return the value associated with the column: bankchkdgt
	 */
	public java.lang.String getBankchkdgt () {
		return bankchkdgt;
	}

	/**
	 * Set the value related to the column: bankchkdgt
	 * @param bankchkdgt the bankchkdgt value
	 */
	public void setBankchkdgt (java.lang.String bankchkdgt) {
		this.bankchkdgt = bankchkdgt;
	}



	/**
	 * Return the value associated with the column: localcentral
	 */
	public java.lang.String getLocalcentral () {
		return localcentral;
	}

	/**
	 * Set the value related to the column: localcentral
	 * @param localcentral the localcentral value
	 */
	public void setLocalcentral (java.lang.String localcentral) {
		this.localcentral = localcentral;
	}



	/**
	 * Return the value associated with the column: preclearexpdays
	 */
	public java.lang.Integer getPreclearexpdays () {
		return preclearexpdays;
	}

	/**
	 * Set the value related to the column: preclearexpdays
	 * @param preclearexpdays the preclearexpdays value
	 */
	public void setPreclearexpdays (java.lang.Integer preclearexpdays) {
		this.preclearexpdays = preclearexpdays;
	}



	/**
	 * Return the value associated with the column: reviewdate
	 */
	public java.util.Date getReviewdate () {
		return reviewdate;
	}

	/**
	 * Set the value related to the column: reviewdate
	 * @param reviewdate the reviewdate value
	 */
	public void setReviewdate (java.util.Date reviewdate) {
		this.reviewdate = reviewdate;
	}



	/**
	 * Return the value associated with the column: old_account
	 */
	public java.lang.String getOldAccount () {
		return oldAccount;
	}

	/**
	 * Set the value related to the column: old_account
	 * @param oldAccount the old_account value
	 */
	public void setOldAccount (java.lang.String oldAccount) {
		this.oldAccount = oldAccount;
	}



	/**
	 * Return the value associated with the column: sms_branch
	 */
	public java.lang.String getSmsBranch () {
		return smsBranch;
	}

	/**
	 * Set the value related to the column: sms_branch
	 * @param smsBranch the sms_branch value
	 */
	public void setSmsBranch (java.lang.String smsBranch) {
		this.smsBranch = smsBranch;
	}



	/**
	 * Return the value associated with the column: marketrep
	 */
	public java.lang.String getMarketrep () {
		return marketrep;
	}

	/**
	 * Set the value related to the column: marketrep
	 * @param marketrep the marketrep value
	 */
	public void setMarketrep (java.lang.String marketrep) {
		this.marketrep = marketrep;
	}



	/**
	 * Return the value associated with the column: predmrgfreedays
	 */
	public java.lang.Integer getPredmrgfreedays () {
		return predmrgfreedays;
	}

	/**
	 * Set the value related to the column: predmrgfreedays
	 * @param predmrgfreedays the predmrgfreedays value
	 */
	public void setPredmrgfreedays (java.lang.Integer predmrgfreedays) {
		this.predmrgfreedays = predmrgfreedays;
	}



	/**
	 * Return the value associated with the column: postalcode
	 */
	public java.lang.String getPostalcode () {
		return postalcode;
	}

	/**
	 * Set the value related to the column: postalcode
	 * @param postalcode the postalcode value
	 */
	public void setPostalcode (java.lang.String postalcode) {
		this.postalcode = postalcode;
	}



	/**
	 * Return the value associated with the column: depottype
	 */
	public java.lang.String getDepottype () {
		return depottype;
	}

	/**
	 * Set the value related to the column: depottype
	 * @param depottype the depottype value
	 */
	public void setDepottype (java.lang.String depottype) {
		this.depottype = depottype;
	}



	/**
	 * Return the value associated with the column: compcode
	 */
	public java.lang.String getCompcode () {
		return compcode;
	}

	/**
	 * Set the value related to the column: compcode
	 * @param compcode the compcode value
	 */
	public void setCompcode (java.lang.String compcode) {
		this.compcode = compcode;
	}



	/**
	 * Return the value associated with the column: rentinvtyp
	 */
	public java.lang.String getRentinvtyp () {
		return rentinvtyp;
	}

	/**
	 * Set the value related to the column: rentinvtyp
	 * @param rentinvtyp the rentinvtyp value
	 */
	public void setRentinvtyp (java.lang.String rentinvtyp) {
		this.rentinvtyp = rentinvtyp;
	}



	/**
	 * Return the value associated with the column: rentinvamt
	 */
	public java.lang.Integer getRentinvamt () {
		return rentinvamt;
	}

	/**
	 * Set the value related to the column: rentinvamt
	 * @param rentinvamt the rentinvamt value
	 */
	public void setRentinvamt (java.lang.Integer rentinvamt) {
		this.rentinvamt = rentinvamt;
	}



	/**
	 * Return the value associated with the column: currdlyrent
	 */
	public java.math.BigDecimal getCurrdlyrent () {
		return currdlyrent;
	}

	/**
	 * Set the value related to the column: currdlyrent
	 * @param currdlyrent the currdlyrent value
	 */
	public void setCurrdlyrent (java.math.BigDecimal currdlyrent) {
		this.currdlyrent = currdlyrent;
	}



	/**
	 * Return the value associated with the column: addr1
	 */
	public java.lang.String getAddr1 () {
		return addr1;
	}

	/**
	 * Set the value related to the column: addr1
	 * @param addr1 the addr1 value
	 */
	public void setAddr1 (java.lang.String addr1) {
		this.addr1 = addr1;
	}



	/**
	 * Return the value associated with the column: typekey
	 */
	public java.lang.String getTypekey () {
		return typekey;
	}

	/**
	 * Set the value related to the column: typekey
	 * @param typekey the typekey value
	 */
	public void setTypekey (java.lang.String typekey) {
		this.typekey = typekey;
	}



	/**
	 * Return the value associated with the column: vatregister
	 */
	public java.lang.String getVatregister () {
		return vatregister;
	}

	/**
	 * Set the value related to the column: vatregister
	 * @param vatregister the vatregister value
	 */
	public void setVatregister (java.lang.String vatregister) {
		this.vatregister = vatregister;
	}



	/**
	 * Return the value associated with the column: load_month
	 */
	public java.lang.Integer getLoadMonth () {
		return loadMonth;
	}

	/**
	 * Set the value related to the column: load_month
	 * @param loadMonth the load_month value
	 */
	public void setLoadMonth (java.lang.Integer loadMonth) {
		this.loadMonth = loadMonth;
	}



	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: inspolicytype
	 */
	public java.lang.String getInspolicytype () {
		return inspolicytype;
	}

	/**
	 * Set the value related to the column: inspolicytype
	 * @param inspolicytype the inspolicytype value
	 */
	public void setInspolicytype (java.lang.String inspolicytype) {
		this.inspolicytype = inspolicytype;
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
	 * Return the value associated with the column: limitccy
	 */
	public java.lang.String getLimitccy () {
		return limitccy;
	}

	/**
	 * Set the value related to the column: limitccy
	 * @param limitccy the limitccy value
	 */
	public void setLimitccy (java.lang.String limitccy) {
		this.limitccy = limitccy;
	}



	/**
	 * Return the value associated with the column: town
	 */
	public java.lang.String getTown () {
		return town;
	}

	/**
	 * Set the value related to the column: town
	 * @param town the town value
	 */
	public void setTown (java.lang.String town) {
		this.town = town;
	}



	/**
	 * Return the value associated with the column: crdteulimit
	 */
	public java.lang.Integer getCrdteulimit () {
		return crdteulimit;
	}

	/**
	 * Set the value related to the column: crdteulimit
	 * @param crdteulimit the crdteulimit value
	 */
	public void setCrdteulimit (java.lang.Integer crdteulimit) {
		this.crdteulimit = crdteulimit;
	}



	/**
	 * Return the value associated with the column: prospect_flag
	 */
	public java.lang.String getProspectFlag () {
		return prospectFlag;
	}

	/**
	 * Set the value related to the column: prospect_flag
	 * @param prospectFlag the prospect_flag value
	 */
	public void setProspectFlag (java.lang.String prospectFlag) {
		this.prospectFlag = prospectFlag;
	}



	/**
	 * Return the value associated with the column: crdrcvsts
	 */
	public java.lang.String getCrdrcvsts () {
		return crdrcvsts;
	}

	/**
	 * Set the value related to the column: crdrcvsts
	 * @param crdrcvsts the crdrcvsts value
	 */
	public void setCrdrcvsts (java.lang.String crdrcvsts) {
		this.crdrcvsts = crdrcvsts;
	}



	/**
	 * Return the value associated with the column: blseqno
	 */
	public java.lang.Integer getBlseqno () {
		return blseqno;
	}

	/**
	 * Set the value related to the column: blseqno
	 * @param blseqno the blseqno value
	 */
	public void setBlseqno (java.lang.Integer blseqno) {
		this.blseqno = blseqno;
	}



	/**
	 * Return the value associated with the column: rating
	 */
	public java.lang.String getRating () {
		return rating;
	}

	/**
	 * Set the value related to the column: rating
	 * @param rating the rating value
	 */
	public void setRating (java.lang.String rating) {
		this.rating = rating;
	}



	/**
	 * Return the value associated with the column: emailno1
	 */
	public java.lang.String getEmailno1 () {
		return emailno1;
	}

	/**
	 * Set the value related to the column: emailno1
	 * @param emailno1 the emailno1 value
	 */
	public void setEmailno1 (java.lang.String emailno1) {
		this.emailno1 = emailno1;
	}



	/**
	 * Return the value associated with the column: vatcode
	 */
	public java.lang.String getVatcode () {
		return vatcode;
	}

	/**
	 * Set the value related to the column: vatcode
	 * @param vatcode the vatcode value
	 */
	public void setVatcode (java.lang.String vatcode) {
		this.vatcode = vatcode;
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
	 * Return the value associated with the column: acc_rep
	 */
	public java.lang.String getAccRep () {
		return accRep;
	}

	/**
	 * Set the value related to the column: acc_rep
	 * @param accRep the acc_rep value
	 */
	public void setAccRep (java.lang.String accRep) {
		this.accRep = accRep;
	}



	/**
	 * Return the value associated with the column: inspolicygrade
	 */
	public java.lang.String getInspolicygrade () {
		return inspolicygrade;
	}

	/**
	 * Set the value related to the column: inspolicygrade
	 * @param inspolicygrade the inspolicygrade value
	 */
	public void setInspolicygrade (java.lang.String inspolicygrade) {
		this.inspolicygrade = inspolicygrade;
	}



	/**
	 * Return the value associated with the column: g1codekey
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}

	/**
	 * Set the value related to the column: g1codekey
	 * @param g1codekey the g1codekey value
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}



	/**
	 * Return the value associated with the column: teurate
	 */
	public java.lang.String getTeurate () {
		return teurate;
	}

	/**
	 * Set the value related to the column: teurate
	 * @param teurate the teurate value
	 */
	public void setTeurate (java.lang.String teurate) {
		this.teurate = teurate;
	}



	/**
	 * Return the value associated with the column: contact3
	 */
	public java.lang.String getContact3 () {
		return contact3;
	}

	/**
	 * Set the value related to the column: contact3
	 * @param contact3 the contact3 value
	 */
	public void setContact3 (java.lang.String contact3) {
		this.contact3 = contact3;
	}



	/**
	 * Return the value associated with the column: g4codekey
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}

	/**
	 * Set the value related to the column: g4codekey
	 * @param g4codekey the g4codekey value
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}



	/**
	 * Return the value associated with the column: ctitle2
	 */
	public java.lang.String getCtitle2 () {
		return ctitle2;
	}

	/**
	 * Set the value related to the column: ctitle2
	 * @param ctitle2 the ctitle2 value
	 */
	public void setCtitle2 (java.lang.String ctitle2) {
		this.ctitle2 = ctitle2;
	}



	/**
	 * Return the value associated with the column: prospect_chg_date
	 */
	public java.util.Date getProspectChgDate () {
		return prospectChgDate;
	}

	/**
	 * Set the value related to the column: prospect_chg_date
	 * @param prospectChgDate the prospect_chg_date value
	 */
	public void setProspectChgDate (java.util.Date prospectChgDate) {
		this.prospectChgDate = prospectChgDate;
	}



	/**
	 * Return the value associated with the column: storagerate
	 */
	public java.math.BigDecimal getStoragerate () {
		return storagerate;
	}

	/**
	 * Set the value related to the column: storagerate
	 * @param storagerate the storagerate value
	 */
	public void setStoragerate (java.math.BigDecimal storagerate) {
		this.storagerate = storagerate;
	}



	/**
	 * Return the value associated with the column: mainaccaddrkey
	 */
	public java.lang.String getMainaccaddrkey () {
		return mainaccaddrkey;
	}

	/**
	 * Set the value related to the column: mainaccaddrkey
	 * @param mainaccaddrkey the mainaccaddrkey value
	 */
	public void setMainaccaddrkey (java.lang.String mainaccaddrkey) {
		this.mainaccaddrkey = mainaccaddrkey;
	}



	/**
	 * Return the value associated with the column: rentaddrkey
	 */
	public java.lang.String getRentaddrkey () {
		return rentaddrkey;
	}

	/**
	 * Set the value related to the column: rentaddrkey
	 * @param rentaddrkey the rentaddrkey value
	 */
	public void setRentaddrkey (java.lang.String rentaddrkey) {
		this.rentaddrkey = rentaddrkey;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: selfbillflag
	 */
	public java.lang.String getSelfbillflag () {
		return selfbillflag;
	}

	/**
	 * Set the value related to the column: selfbillflag
	 * @param selfbillflag the selfbillflag value
	 */
	public void setSelfbillflag (java.lang.String selfbillflag) {
		this.selfbillflag = selfbillflag;
	}



	/**
	 * Return the value associated with the column: cusbnkaddrkeylist
	 */
	public java.lang.String getCusbnkaddrkeylist () {
		return cusbnkaddrkeylist;
	}

	/**
	 * Set the value related to the column: cusbnkaddrkeylist
	 * @param cusbnkaddrkeylist the cusbnkaddrkeylist value
	 */
	public void setCusbnkaddrkeylist (java.lang.String cusbnkaddrkeylist) {
		this.cusbnkaddrkeylist = cusbnkaddrkeylist;
	}



	/**
	 * Return the value associated with the column: telno2
	 */
	public java.lang.String getTelno2 () {
		return telno2;
	}

	/**
	 * Set the value related to the column: telno2
	 * @param telno2 the telno2 value
	 */
	public void setTelno2 (java.lang.String telno2) {
		this.telno2 = telno2;
	}



	/**
	 * Return the value associated with the column: copyadd
	 */
	public java.lang.String getCopyadd () {
		return copyadd;
	}

	/**
	 * Set the value related to the column: copyadd
	 * @param copyadd the copyadd value
	 */
	public void setCopyadd (java.lang.String copyadd) {
		this.copyadd = copyadd;
	}



	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref () {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * @param invoicegroupref the invoicegroupref value
	 */
	public void setInvoicegroupref (java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
	}



	/**
	 * Return the value associated with the column: geo_code
	 */
	public java.lang.String getGeoCode () {
		return geoCode;
	}

	/**
	 * Set the value related to the column: geo_code
	 * @param geoCode the geo_code value
	 */
	public void setGeoCode (java.lang.String geoCode) {
		this.geoCode = geoCode;
	}



	/**
	 * Return the value associated with the column: dirinvrep
	 */
	public java.lang.String getDirinvrep () {
		return dirinvrep;
	}

	/**
	 * Set the value related to the column: dirinvrep
	 * @param dirinvrep the dirinvrep value
	 */
	public void setDirinvrep (java.lang.String dirinvrep) {
		this.dirinvrep = dirinvrep;
	}



	/**
	 * Return the value associated with the column: faxno1
	 */
	public java.lang.String getFaxno1 () {
		return faxno1;
	}

	/**
	 * Set the value related to the column: faxno1
	 * @param faxno1 the faxno1 value
	 */
	public void setFaxno1 (java.lang.String faxno1) {
		this.faxno1 = faxno1;
	}



	/**
	 * Return the value associated with the column: telno3
	 */
	public java.lang.String getTelno3 () {
		return telno3;
	}

	/**
	 * Set the value related to the column: telno3
	 * @param telno3 the telno3 value
	 */
	public void setTelno3 (java.lang.String telno3) {
		this.telno3 = telno3;
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
	 * Return the value associated with the column: bankswiftcode
	 */
	public java.lang.String getBankswiftcode () {
		return bankswiftcode;
	}

	/**
	 * Set the value related to the column: bankswiftcode
	 * @param bankswiftcode the bankswiftcode value
	 */
	public void setBankswiftcode (java.lang.String bankswiftcode) {
		this.bankswiftcode = bankswiftcode;
	}



	/**
	 * Return the value associated with the column: g3codekey
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}

	/**
	 * Set the value related to the column: g3codekey
	 * @param g3codekey the g3codekey value
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}



	/**
	 * Return the value associated with the column: webaddress
	 */
	public java.lang.String getWebaddress () {
		return webaddress;
	}

	/**
	 * Set the value related to the column: webaddress
	 * @param webaddress the webaddress value
	 */
	public void setWebaddress (java.lang.String webaddress) {
		this.webaddress = webaddress;
	}



	/**
	 * Return the value associated with the column: lead_source
	 */
	public java.lang.String getLeadSource () {
		return leadSource;
	}

	/**
	 * Set the value related to the column: lead_source
	 * @param leadSource the lead_source value
	 */
	public void setLeadSource (java.lang.String leadSource) {
		this.leadSource = leadSource;
	}



	/**
	 * Return the value associated with the column: faxno2
	 */
	public java.lang.String getFaxno2 () {
		return faxno2;
	}

	/**
	 * Set the value related to the column: faxno2
	 * @param faxno2 the faxno2 value
	 */
	public void setFaxno2 (java.lang.String faxno2) {
		this.faxno2 = faxno2;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: importid
	 */
	public java.lang.String getImportid () {
		return importid;
	}

	/**
	 * Set the value related to the column: importid
	 * @param importid the importid value
	 */
	public void setImportid (java.lang.String importid) {
		this.importid = importid;
	}



	/**
	 * Return the value associated with the column: telno1
	 */
	public java.lang.String getTelno1 () {
		return telno1;
	}

	/**
	 * Set the value related to the column: telno1
	 * @param telno1 the telno1 value
	 */
	public void setTelno1 (java.lang.String telno1) {
		this.telno1 = telno1;
	}



	/**
	 * Return the value associated with the column: emailno
	 */
	public java.lang.String getEmailno () {
		return emailno;
	}

	/**
	 * Set the value related to the column: emailno
	 * @param emailno the emailno value
	 */
	public void setEmailno (java.lang.String emailno) {
		this.emailno = emailno;
	}



	/**
	 * Return the value associated with the column: xuserid
	 */
	public java.lang.String getXuserid () {
		return xuserid;
	}

	/**
	 * Set the value related to the column: xuserid
	 * @param xuserid the xuserid value
	 */
	public void setXuserid (java.lang.String xuserid) {
		this.xuserid = xuserid;
	}



	/**
	 * Return the value associated with the column: MaximumGross
	 */
	public java.lang.Integer getMaximumGross () {
		return maximumGross;
	}

	/**
	 * Set the value related to the column: MaximumGross
	 * @param maximumGross the MaximumGross value
	 */
	public void setMaximumGross (java.lang.Integer maximumGross) {
		this.maximumGross = maximumGross;
	}



	/**
	 * Return the value associated with the column: reviewnote
	 */
	public java.lang.String getReviewnote () {
		return reviewnote;
	}

	/**
	 * Set the value related to the column: reviewnote
	 * @param reviewnote the reviewnote value
	 */
	public void setReviewnote (java.lang.String reviewnote) {
		this.reviewnote = reviewnote;
	}



	/**
	 * Return the value associated with the column: cusbnkccykeylist
	 */
	public java.lang.String getCusbnkccykeylist () {
		return cusbnkccykeylist;
	}

	/**
	 * Set the value related to the column: cusbnkccykeylist
	 * @param cusbnkccykeylist the cusbnkccykeylist value
	 */
	public void setCusbnkccykeylist (java.lang.String cusbnkccykeylist) {
		this.cusbnkccykeylist = cusbnkccykeylist;
	}



	/**
	 * Return the value associated with the column: shortname
	 */
	public java.lang.String getShortname () {
		return shortname;
	}

	/**
	 * Set the value related to the column: shortname
	 * @param shortname the shortname value
	 */
	public void setShortname (java.lang.String shortname) {
		this.shortname = shortname;
	}



	/**
	 * Return the value associated with the column: credit_req
	 */
	public java.math.BigDecimal getCreditReq () {
		return creditReq;
	}

	/**
	 * Set the value related to the column: credit_req
	 * @param creditReq the credit_req value
	 */
	public void setCreditReq (java.math.BigDecimal creditReq) {
		this.creditReq = creditReq;
	}



	/**
	 * Return the value associated with the column: ctitle3
	 */
	public java.lang.String getCtitle3 () {
		return ctitle3;
	}

	/**
	 * Set the value related to the column: ctitle3
	 * @param ctitle3 the ctitle3 value
	 */
	public void setCtitle3 (java.lang.String ctitle3) {
		this.ctitle3 = ctitle3;
	}



	/**
	 * Return the value associated with the column: contact1
	 */
	public java.lang.String getContact1 () {
		return contact1;
	}

	/**
	 * Set the value related to the column: contact1
	 * @param contact1 the contact1 value
	 */
	public void setContact1 (java.lang.String contact1) {
		this.contact1 = contact1;
	}



	/**
	 * Return the value associated with the column: unitsallowed
	 */
	public java.lang.Integer getUnitsallowed () {
		return unitsallowed;
	}

	/**
	 * Set the value related to the column: unitsallowed
	 * @param unitsallowed the unitsallowed value
	 */
	public void setUnitsallowed (java.lang.Integer unitsallowed) {
		this.unitsallowed = unitsallowed;
	}



	/**
	 * Return the value associated with the column: accountname
	 */
	public java.lang.String getAccountname () {
		return accountname;
	}

	/**
	 * Set the value related to the column: accountname
	 * @param accountname the accountname value
	 */
	public void setAccountname (java.lang.String accountname) {
		this.accountname = accountname;
	}



	/**
	 * Return the value associated with the column: setid
	 */
	public java.lang.String getSetid () {
		return setid;
	}

	/**
	 * Set the value related to the column: setid
	 * @param setid the setid value
	 */
	public void setSetid (java.lang.String setid) {
		this.setid = setid;
	}



	/**
	 * Return the value associated with the column: emailno3
	 */
	public java.lang.String getEmailno3 () {
		return emailno3;
	}

	/**
	 * Set the value related to the column: emailno3
	 * @param emailno3 the emailno3 value
	 */
	public void setEmailno3 (java.lang.String emailno3) {
		this.emailno3 = emailno3;
	}



	/**
	 * Return the value associated with the column: xdate
	 */
	public java.util.Date getXdate () {
		return xdate;
	}

	/**
	 * Set the value related to the column: xdate
	 * @param xdate the xdate value
	 */
	public void setXdate (java.util.Date xdate) {
		this.xdate = xdate;
	}



	/**
	 * Return the value associated with the column: rentinvtim
	 */
	public java.lang.String getRentinvtim () {
		return rentinvtim;
	}

	/**
	 * Set the value related to the column: rentinvtim
	 * @param rentinvtim the rentinvtim value
	 */
	public void setRentinvtim (java.lang.String rentinvtim) {
		this.rentinvtim = rentinvtim;
	}



	/**
	 * Return the value associated with the column: liftonliftoff
	 */
	public java.math.BigDecimal getLiftonliftoff () {
		return liftonliftoff;
	}

	/**
	 * Set the value related to the column: liftonliftoff
	 * @param liftonliftoff the liftonliftoff value
	 */
	public void setLiftonliftoff (java.math.BigDecimal liftonliftoff) {
		this.liftonliftoff = liftonliftoff;
	}



	/**
	 * Return the value associated with the column: ctitle
	 */
	public java.lang.String getCtitle () {
		return ctitle;
	}

	/**
	 * Set the value related to the column: ctitle
	 * @param ctitle the ctitle value
	 */
	public void setCtitle (java.lang.String ctitle) {
		this.ctitle = ctitle;
	}



	/**
	 * Return the value associated with the column: moninvdat
	 */
	public java.util.Date getMoninvdat () {
		return moninvdat;
	}

	/**
	 * Set the value related to the column: moninvdat
	 * @param moninvdat the moninvdat value
	 */
	public void setMoninvdat (java.util.Date moninvdat) {
		this.moninvdat = moninvdat;
	}



	/**
	 * Return the value associated with the column: dmrgfreedays
	 */
	public java.lang.Integer getDmrgfreedays () {
		return dmrgfreedays;
	}

	/**
	 * Set the value related to the column: dmrgfreedays
	 * @param dmrgfreedays the dmrgfreedays value
	 */
	public void setDmrgfreedays (java.lang.Integer dmrgfreedays) {
		this.dmrgfreedays = dmrgfreedays;
	}



	/**
	 * Return the value associated with the column: xaction
	 */
	public java.lang.String getXaction () {
		return xaction;
	}

	/**
	 * Set the value related to the column: xaction
	 * @param xaction the xaction value
	 */
	public void setXaction (java.lang.String xaction) {
		this.xaction = xaction;
	}



	/**
	 * Return the value associated with the column: addr2
	 */
	public java.lang.String getAddr2 () {
		return addr2;
	}

	/**
	 * Set the value related to the column: addr2
	 * @param addr2 the addr2 value
	 */
	public void setAddr2 (java.lang.String addr2) {
		this.addr2 = addr2;
	}



	/**
	 * Return the value associated with the column: addr4
	 */
	public java.lang.String getAddr4 () {
		return addr4;
	}

	/**
	 * Set the value related to the column: addr4
	 * @param addr4 the addr4 value
	 */
	public void setAddr4 (java.lang.String addr4) {
		this.addr4 = addr4;
	}



	/**
	 * Return the value associated with the column: dataprotect
	 */
	public java.lang.String getDataprotect () {
		return dataprotect;
	}

	/**
	 * Set the value related to the column: dataprotect
	 * @param dataprotect the dataprotect value
	 */
	public void setDataprotect (java.lang.String dataprotect) {
		this.dataprotect = dataprotect;
	}



	/**
	 * Return the value associated with the column: contact2
	 */
	public java.lang.String getContact2 () {
		return contact2;
	}

	/**
	 * Set the value related to the column: contact2
	 * @param contact2 the contact2 value
	 */
	public void setContact2 (java.lang.String contact2) {
		this.contact2 = contact2;
	}



	/**
	 * Return the value associated with the column: reviewby
	 */
	public java.lang.String getReviewby () {
		return reviewby;
	}

	/**
	 * Set the value related to the column: reviewby
	 * @param reviewby the reviewby value
	 */
	public void setReviewby (java.lang.String reviewby) {
		this.reviewby = reviewby;
	}



	/**
	 * Return the value associated with the column: bankcode
	 */
	public java.lang.String getBankcode () {
		return bankcode;
	}

	/**
	 * Set the value related to the column: bankcode
	 * @param bankcode the bankcode value
	 */
	public void setBankcode (java.lang.String bankcode) {
		this.bankcode = bankcode;
	}



	/**
	 * Return the value associated with the column: addr5
	 */
	public java.lang.String getAddr5 () {
		return addr5;
	}

	/**
	 * Set the value related to the column: addr5
	 * @param addr5 the addr5 value
	 */
	public void setAddr5 (java.lang.String addr5) {
		this.addr5 = addr5;
	}



	/**
	 * Return the value associated with the column: ediaddrkey
	 */
	public java.lang.String getEdiaddrkey () {
		return ediaddrkey;
	}

	/**
	 * Set the value related to the column: ediaddrkey
	 * @param ediaddrkey the ediaddrkey value
	 */
	public void setEdiaddrkey (java.lang.String ediaddrkey) {
		this.ediaddrkey = ediaddrkey;
	}



	/**
	 * Return the value associated with the column: customer_group
	 */
	public java.lang.String getCustomerGroup () {
		return customerGroup;
	}

	/**
	 * Set the value related to the column: customer_group
	 * @param customerGroup the customer_group value
	 */
	public void setCustomerGroup (java.lang.String customerGroup) {
		this.customerGroup = customerGroup;
	}



	/**
	 * Return the value associated with the column: bankid
	 */
	public java.lang.String getBankid () {
		return bankid;
	}

	/**
	 * Set the value related to the column: bankid
	 * @param bankid the bankid value
	 */
	public void setBankid (java.lang.String bankid) {
		this.bankid = bankid;
	}



	/**
	 * Return the value associated with the column: prospect_chg_userid
	 */
	public java.lang.String getProspectChgUserid () {
		return prospectChgUserid;
	}

	/**
	 * Set the value related to the column: prospect_chg_userid
	 * @param prospectChgUserid the prospect_chg_userid value
	 */
	public void setProspectChgUserid (java.lang.String prospectChgUserid) {
		this.prospectChgUserid = prospectChgUserid;
	}



	/**
	 * Return the value associated with the column: sunbatch
	 */
	public java.lang.String getSunbatch () {
		return sunbatch;
	}

	/**
	 * Set the value related to the column: sunbatch
	 * @param sunbatch the sunbatch value
	 */
	public void setSunbatch (java.lang.String sunbatch) {
		this.sunbatch = sunbatch;
	}



	/**
	 * Return the value associated with the column: crdundwrtdate
	 */
	public java.util.Date getCrdundwrtdate () {
		return crdundwrtdate;
	}

	/**
	 * Set the value related to the column: crdundwrtdate
	 * @param crdundwrtdate the crdundwrtdate value
	 */
	public void setCrdundwrtdate (java.util.Date crdundwrtdate) {
		this.crdundwrtdate = crdundwrtdate;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public java.lang.String getDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (java.lang.String deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: cbse_corpcode
	 */
	public java.lang.String getCbseCorpcode () {
		return cbseCorpcode;
	}

	/**
	 * Set the value related to the column: cbse_corpcode
	 * @param cbseCorpcode the cbse_corpcode value
	 */
	public void setCbseCorpcode (java.lang.String cbseCorpcode) {
		this.cbseCorpcode = cbseCorpcode;
	}



	/**
	 * Return the value associated with the column: sales_territory
	 */
	public java.lang.String getSalesTerritory () {
		return salesTerritory;
	}

	/**
	 * Set the value related to the column: sales_territory
	 * @param salesTerritory the sales_territory value
	 */
	public void setSalesTerritory (java.lang.String salesTerritory) {
		this.salesTerritory = salesTerritory;
	}



	/**
	 * Return the value associated with the column: bmapplic
	 */
	public java.lang.String getBmapplic () {
		return bmapplic;
	}

	/**
	 * Set the value related to the column: bmapplic
	 * @param bmapplic the bmapplic value
	 */
	public void setBmapplic (java.lang.String bmapplic) {
		this.bmapplic = bmapplic;
	}



	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: cust_id
	 */
	public java.lang.String getCustId () {
		return custId;
	}

	/**
	 * Set the value related to the column: cust_id
	 * @param custId the cust_id value
	 */
	public void setCustId (java.lang.String custId) {
		this.custId = custId;
	}



	/**
	 * Return the value associated with the column: entity
	 */
	public java.lang.String getEntity () {
		return entity;
	}

	/**
	 * Set the value related to the column: entity
	 * @param entity the entity value
	 */
	public void setEntity (java.lang.String entity) {
		this.entity = entity;
	}



	/**
	 * Return the value associated with the column: depotstockflag
	 */
	public java.lang.String getDepotstockflag () {
		return depotstockflag;
	}

	/**
	 * Set the value related to the column: depotstockflag
	 * @param depotstockflag the depotstockflag value
	 */
	public void setDepotstockflag (java.lang.String depotstockflag) {
		this.depotstockflag = depotstockflag;
	}



	/**
	 * Return the value associated with the column: banksortcode
	 */
	public java.lang.String getBanksortcode () {
		return banksortcode;
	}

	/**
	 * Set the value related to the column: banksortcode
	 * @param banksortcode the banksortcode value
	 */
	public void setBanksortcode (java.lang.String banksortcode) {
		this.banksortcode = banksortcode;
	}



	/**
	 * Return the value associated with the column: insexpiry
	 */
	public java.util.Date getInsexpiry () {
		return insexpiry;
	}

	/**
	 * Set the value related to the column: insexpiry
	 * @param insexpiry the insexpiry value
	 */
	public void setInsexpiry (java.util.Date insexpiry) {
		this.insexpiry = insexpiry;
	}



	/**
	 * Return the value associated with the column: faxno
	 */
	public java.lang.String getFaxno () {
		return faxno;
	}

	/**
	 * Set the value related to the column: faxno
	 * @param faxno the faxno value
	 */
	public void setFaxno (java.lang.String faxno) {
		this.faxno = faxno;
	}



	/**
	 * Return the value associated with the column: crdrepnotes
	 */
	public java.lang.String getCrdrepnotes () {
		return crdrepnotes;
	}

	/**
	 * Set the value related to the column: crdrepnotes
	 * @param crdrepnotes the crdrepnotes value
	 */
	public void setCrdrepnotes (java.lang.String crdrepnotes) {
		this.crdrepnotes = crdrepnotes;
	}



	/**
	 * Return the value associated with the column: emailno2
	 */
	public java.lang.String getEmailno2 () {
		return emailno2;
	}

	/**
	 * Set the value related to the column: emailno2
	 * @param emailno2 the emailno2 value
	 */
	public void setEmailno2 (java.lang.String emailno2) {
		this.emailno2 = emailno2;
	}



	/**
	 * Return the value associated with the column: contact
	 */
	public java.lang.String getContact () {
		return contact;
	}

	/**
	 * Set the value related to the column: contact
	 * @param contact the contact value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}



	/**
	 * Return the value associated with the column: freedays
	 */
	public java.lang.Integer getFreedays () {
		return freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param freedays the freedays value
	 */
	public void setFreedays (java.lang.Integer freedays) {
		this.freedays = freedays;
	}



	/**
	 * Return the value associated with the column: bookexpdays
	 */
	public java.lang.Integer getBookexpdays () {
		return bookexpdays;
	}

	/**
	 * Set the value related to the column: bookexpdays
	 * @param bookexpdays the bookexpdays value
	 */
	public void setBookexpdays (java.lang.Integer bookexpdays) {
		this.bookexpdays = bookexpdays;
	}



	/**
	 * Return the value associated with the column: cusbnkaccnolist
	 */
	public java.lang.String getCusbnkaccnolist () {
		return cusbnkaccnolist;
	}

	/**
	 * Set the value related to the column: cusbnkaccnolist
	 * @param cusbnkaccnolist the cusbnkaccnolist value
	 */
	public void setCusbnkaccnolist (java.lang.String cusbnkaccnolist) {
		this.cusbnkaccnolist = cusbnkaccnolist;
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
	 * Return the value associated with the column: xprog
	 */
	public java.lang.String getXprog () {
		return xprog;
	}

	/**
	 * Set the value related to the column: xprog
	 * @param xprog the xprog value
	 */
	public void setXprog (java.lang.String xprog) {
		this.xprog = xprog;
	}



	/**
	 * Return the value associated with the column: accountno
	 */
	public java.lang.String getAccountno () {
		return accountno;
	}

	/**
	 * Set the value related to the column: accountno
	 * @param accountno the accountno value
	 */
	public void setAccountno (java.lang.String accountno) {
		this.accountno = accountno;
	}



	/**
	 * Return the value associated with the column: terms
	 */
	public java.lang.String getTerms () {
		return terms;
	}

	/**
	 * Set the value related to the column: terms
	 * @param terms the terms value
	 */
	public void setTerms (java.lang.String terms) {
		this.terms = terms;
	}



	/**
	 * Return the value associated with the column: collectrep
	 */
	public java.lang.String getCollectrep () {
		return collectrep;
	}

	/**
	 * Set the value related to the column: collectrep
	 * @param collectrep the collectrep value
	 */
	public void setCollectrep (java.lang.String collectrep) {
		this.collectrep = collectrep;
	}



	/**
	 * Return the value associated with the column: lessoraddrkey
	 */
	public java.lang.String getLessoraddrkey () {
		return lessoraddrkey;
	}

	/**
	 * Set the value related to the column: lessoraddrkey
	 * @param lessoraddrkey the lessoraddrkey value
	 */
	public void setLessoraddrkey (java.lang.String lessoraddrkey) {
		this.lessoraddrkey = lessoraddrkey;
	}



	/**
	 * Return the value associated with the column: g2codekey
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 * Set the value related to the column: g2codekey
	 * @param g2codekey the g2codekey value
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}



	/**
	 * Return the value associated with the column: localvndr
	 */
	public java.lang.String getLocalvndr () {
		return localvndr;
	}

	/**
	 * Set the value related to the column: localvndr
	 * @param localvndr the localvndr value
	 */
	public void setLocalvndr (java.lang.String localvndr) {
		this.localvndr = localvndr;
	}



	/**
	 * Return the value associated with the column: crdupdatedate
	 */
	public java.util.Date getCrdupdatedate () {
		return crdupdatedate;
	}

	/**
	 * Set the value related to the column: crdupdatedate
	 * @param crdupdatedate the crdupdatedate value
	 */
	public void setCrdupdatedate (java.util.Date crdupdatedate) {
		this.crdupdatedate = crdupdatedate;
	}



	/**
	 * Return the value associated with the column: invpref
	 */
	public java.lang.String getInvpref () {
		return invpref;
	}

	/**
	 * Set the value related to the column: invpref
	 * @param invpref the invpref value
	 */
	public void setInvpref (java.lang.String invpref) {
		this.invpref = invpref;
	}



	/**
	 * Return the value associated with the column: agentterritory
	 */
	public java.lang.String getAgentterritory () {
		return agentterritory;
	}

	/**
	 * Set the value related to the column: agentterritory
	 * @param agentterritory the agentterritory value
	 */
	public void setAgentterritory (java.lang.String agentterritory) {
		this.agentterritory = agentterritory;
	}



	/**
	 * Return the value associated with the column: rentinvdat
	 */
	public java.util.Date getRentinvdat () {
		return rentinvdat;
	}

	/**
	 * Set the value related to the column: rentinvdat
	 * @param rentinvdat the rentinvdat value
	 */
	public void setRentinvdat (java.util.Date rentinvdat) {
		this.rentinvdat = rentinvdat;
	}



	/**
	 * Return the value associated with the column: instext
	 */
	public java.lang.String getInstext () {
		return instext;
	}

	/**
	 * Set the value related to the column: instext
	 * @param instext the instext value
	 */
	public void setInstext (java.lang.String instext) {
		this.instext = instext;
	}



	/**
	 * Return the value associated with the column: salesper
	 */
	public java.lang.String getSalesper () {
		return salesper;
	}

	/**
	 * Set the value related to the column: salesper
	 * @param salesper the salesper value
	 */
	public void setSalesper (java.lang.String salesper) {
		this.salesper = salesper;
	}



	/**
	 * Return the value associated with the column: rentinvarrdes
	 */
	public java.lang.String getRentinvarrdes () {
		return rentinvarrdes;
	}

	/**
	 * Set the value related to the column: rentinvarrdes
	 * @param rentinvarrdes the rentinvarrdes value
	 */
	public void setRentinvarrdes (java.lang.String rentinvarrdes) {
		this.rentinvarrdes = rentinvarrdes;
	}



	/**
	 * Return the value associated with the column: rechargemarkup
	 */
	public java.math.BigDecimal getRechargemarkup () {
		return rechargemarkup;
	}

	/**
	 * Set the value related to the column: rechargemarkup
	 * @param rechargemarkup the rechargemarkup value
	 */
	public void setRechargemarkup (java.math.BigDecimal rechargemarkup) {
		this.rechargemarkup = rechargemarkup;
	}



	/**
	 * Return the value associated with the column: langkey
	 */
	public java.lang.String getLangkey () {
		return langkey;
	}

	/**
	 * Set the value related to the column: langkey
	 * @param langkey the langkey value
	 */
	public void setLangkey (java.lang.String langkey) {
		this.langkey = langkey;
	}



	/**
	 * Return the value associated with the column: credit_status
	 */
	public java.lang.String getCreditStatus () {
		return creditStatus;
	}

	/**
	 * Set the value related to the column: credit_status
	 * @param creditStatus the credit_status value
	 */
	public void setCreditStatus (java.lang.String creditStatus) {
		this.creditStatus = creditStatus;
	}



	/**
	 * Return the value associated with the column: ctitle1
	 */
	public java.lang.String getCtitle1 () {
		return ctitle1;
	}

	/**
	 * Set the value related to the column: ctitle1
	 * @param ctitle1 the ctitle1 value
	 */
	public void setCtitle1 (java.lang.String ctitle1) {
		this.ctitle1 = ctitle1;
	}



	/**
	 * Return the value associated with the column: swiftcode
	 */
	public java.lang.String getSwiftcode () {
		return swiftcode;
	}

	/**
	 * Set the value related to the column: swiftcode
	 * @param swiftcode the swiftcode value
	 */
	public void setSwiftcode (java.lang.String swiftcode) {
		this.swiftcode = swiftcode;
	}



	/**
	 * Return the value associated with the column: crddefaultdate
	 */
	public java.util.Date getCrddefaultdate () {
		return crddefaultdate;
	}

	/**
	 * Set the value related to the column: crddefaultdate
	 * @param crddefaultdate the crddefaultdate value
	 */
	public void setCrddefaultdate (java.util.Date crddefaultdate) {
		this.crddefaultdate = crddefaultdate;
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
	 * Return the value associated with the column: labrate
	 */
	public java.math.BigDecimal getLabrate () {
		return labrate;
	}

	/**
	 * Set the value related to the column: labrate
	 * @param labrate the labrate value
	 */
	public void setLabrate (java.math.BigDecimal labrate) {
		this.labrate = labrate;
	}



	/**
	 * Return the value associated with the column: billhdrtype
	 */
	public java.lang.String getBillhdrtype () {
		return billhdrtype;
	}

	/**
	 * Set the value related to the column: billhdrtype
	 * @param billhdrtype the billhdrtype value
	 */
	public void setBillhdrtype (java.lang.String billhdrtype) {
		this.billhdrtype = billhdrtype;
	}



	/**
	 * Return the value associated with the column: faxno3
	 */
	public java.lang.String getFaxno3 () {
		return faxno3;
	}

	/**
	 * Set the value related to the column: faxno3
	 * @param faxno3 the faxno3 value
	 */
	public void setFaxno3 (java.lang.String faxno3) {
		this.faxno3 = faxno3;
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
	 * Return the value associated with the column: telno
	 */
	public java.lang.String getTelno () {
		return telno;
	}

	/**
	 * Set the value related to the column: telno
	 * @param telno the telno value
	 */
	public void setTelno (java.lang.String telno) {
		this.telno = telno;
	}



	/**
	 * Return the value associated with the column: Surcharge
	 */
	public java.math.BigDecimal getSurcharge () {
		return surcharge;
	}

	/**
	 * Set the value related to the column: Surcharge
	 * @param surcharge the Surcharge value
	 */
	public void setSurcharge (java.math.BigDecimal surcharge) {
		this.surcharge = surcharge;
	}



	/**
	 * Return the value associated with the column: period
	 */
	public java.lang.String getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * @param period the period value
	 */
	public void setPeriod (java.lang.String period) {
		this.period = period;
	}



	/**
	 * Return the value associated with the column: stopflag
	 */
	public java.lang.String getStopflag () {
		return stopflag;
	}

	/**
	 * Set the value related to the column: stopflag
	 * @param stopflag the stopflag value
	 */
	public void setStopflag (java.lang.String stopflag) {
		this.stopflag = stopflag;
	}



	/**
	 * Return the value associated with the column: paytoaddrkey
	 */
	public java.lang.String getPaytoaddrkey () {
		return paytoaddrkey;
	}

	/**
	 * Set the value related to the column: paytoaddrkey
	 * @param paytoaddrkey the paytoaddrkey value
	 */
	public void setPaytoaddrkey (java.lang.String paytoaddrkey) {
		this.paytoaddrkey = paytoaddrkey;
	}



	/**
	 * Return the value associated with the column: addr3
	 */
	public java.lang.String getAddr3 () {
		return addr3;
	}

	/**
	 * Set the value related to the column: addr3
	 * @param addr3 the addr3 value
	 */
	public void setAddr3 (java.lang.String addr3) {
		this.addr3 = addr3;
	}



	/**
	 * Return the value associated with the column: payterms
	 */
	public java.lang.Integer getPayterms () {
		return payterms;
	}

	/**
	 * Set the value related to the column: payterms
	 * @param payterms the payterms value
	 */
	public void setPayterms (java.lang.Integer payterms) {
		this.payterms = payterms;
	}



	/**
	 * Return the value associated with the column: lastrentinvdat
	 */
	public java.util.Date getLastrentinvdat () {
		return lastrentinvdat;
	}

	/**
	 * Set the value related to the column: lastrentinvdat
	 * @param lastrentinvdat the lastrentinvdat value
	 */
	public void setLastrentinvdat (java.util.Date lastrentinvdat) {
		this.lastrentinvdat = lastrentinvdat;
	}



	/**
	 * Return the value associated with the column: partmarkup
	 */
	public java.math.BigDecimal getPartmarkup () {
		return partmarkup;
	}

	/**
	 * Set the value related to the column: partmarkup
	 * @param partmarkup the partmarkup value
	 */
	public void setPartmarkup (java.math.BigDecimal partmarkup) {
		this.partmarkup = partmarkup;
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
	 * Return the value associated with the column: cbse_valid
	 */
	public java.lang.String getCbseValid () {
		return cbseValid;
	}

	/**
	 * Set the value related to the column: cbse_valid
	 * @param cbseValid the cbse_valid value
	 */
	public void setCbseValid (java.lang.String cbseValid) {
		this.cbseValid = cbseValid;
	}



	/**
	 * Return the value associated with the column: sms_entity
	 */
	public java.lang.String getSmsEntity () {
		return smsEntity;
	}

	/**
	 * Set the value related to the column: sms_entity
	 * @param smsEntity the sms_entity value
	 */
	public void setSmsEntity (java.lang.String smsEntity) {
		this.smsEntity = smsEntity;
	}



	/**
	 * Return the value associated with the column: acccode
	 */
	public java.lang.String getAcccode () {
		return acccode;
	}

	/**
	 * Set the value related to the column: acccode
	 * @param acccode the acccode value
	 */
	public void setAcccode (java.lang.String acccode) {
		this.acccode = acccode;
	}



	/**
	 * Return the value associated with the column: blnoprefx
	 */
	public java.lang.String getBlnoprefx () {
		return blnoprefx;
	}

	/**
	 * Set the value related to the column: blnoprefx
	 * @param blnoprefx the blnoprefx value
	 */
	public void setBlnoprefx (java.lang.String blnoprefx) {
		this.blnoprefx = blnoprefx;
	}



	/**
	 * Return the value associated with the column: OverWeightPermit
	 */
	public java.lang.String getOverWeightPermit () {
		return overWeightPermit;
	}

	/**
	 * Set the value related to the column: OverWeightPermit
	 * @param overWeightPermit the OverWeightPermit value
	 */
	public void setOverWeightPermit (java.lang.String overWeightPermit) {
		this.overWeightPermit = overWeightPermit;
	}



	/**
	 * Return the value associated with the column: rectype
	 */
	public java.lang.String getRectype () {
		return rectype;
	}

	/**
	 * Set the value related to the column: rectype
	 * @param rectype the rectype value
	 */
	public void setRectype (java.lang.String rectype) {
		this.rectype = rectype;
	}



	/**
	 * Return the value associated with the column: owncompany
	 */
	public java.lang.String getOwncompany () {
		return owncompany;
	}

	/**
	 * Set the value related to the column: owncompany
	 * @param owncompany the owncompany value
	 */
	public void setOwncompany (java.lang.String owncompany) {
		this.owncompany = owncompany;
	}



	/**
	 * Return the value associated with the column: countrykey
	 */
	public java.lang.String getCountrykey () {
		return countrykey;
	}

	/**
	 * Set the value related to the column: countrykey
	 * @param countrykey the countrykey value
	 */
	public void setCountrykey (java.lang.String countrykey) {
		this.countrykey = countrykey;
	}



	/**
	 * Return the value associated with the column: locationcode
	 */
	public java.lang.String getLocationcode () {
		return locationcode;
	}

	/**
	 * Set the value related to the column: locationcode
	 * @param locationcode the locationcode value
	 */
	public void setLocationcode (java.lang.String locationcode) {
		this.locationcode = locationcode;
	}



	/**
	 * Return the value associated with the column: paymenttoinstructions
	 */
	public java.lang.String getPaymenttoinstructions () {
		return paymenttoinstructions;
	}

	/**
	 * Set the value related to the column: paymenttoinstructions
	 * @param paymenttoinstructions the paymenttoinstructions value
	 */
	public void setPaymenttoinstructions (java.lang.String paymenttoinstructions) {
		this.paymenttoinstructions = paymenttoinstructions;
	}



	/**
	 * Return the value associated with the column: typekeylist
	 */
	public java.lang.String getTypekeylist () {
		return typekeylist;
	}

	/**
	 * Set the value related to the column: typekeylist
	 * @param typekeylist the typekeylist value
	 */
	public void setTypekeylist (java.lang.String typekeylist) {
		this.typekeylist = typekeylist;
	}



	/**
	 * Return the value associated with the column: accsysaddressid
	 */
	public java.lang.String getAccsysaddressid () {
		return accsysaddressid;
	}

	/**
	 * Set the value related to the column: accsysaddressid
	 * @param accsysaddressid the accsysaddressid value
	 */
	public void setAccsysaddressid (java.lang.String accsysaddressid) {
		this.accsysaddressid = accsysaddressid;
	}



	/**
	 * Return the value associated with the column: commissiontype
	 */
	public java.lang.String getCommissiontype () {
		return commissiontype;
	}

	/**
	 * Set the value related to the column: commissiontype
	 * @param commissiontype the commissiontype value
	 */
	public void setCommissiontype (java.lang.String commissiontype) {
		this.commissiontype = commissiontype;
	}



	/**
	 * Return the value associated with the column: extsysaddressid
	 */
	public java.lang.String getExtsysaddressid () {
		return extsysaddressid;
	}

	/**
	 * Set the value related to the column: extsysaddressid
	 * @param extsysaddressid the extsysaddressid value
	 */
	public void setExtsysaddressid (java.lang.String extsysaddressid) {
		this.extsysaddressid = extsysaddressid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Address)) return false;
		else {
			com.bureaueye.beacon.model.standard.Address address = (com.bureaueye.beacon.model.standard.Address) obj;
			if (null == this.getAddrkey() || null == address.getAddrkey()) return false;
			else return (this.getAddrkey().equals(address.getAddrkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAddrkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAddrkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}