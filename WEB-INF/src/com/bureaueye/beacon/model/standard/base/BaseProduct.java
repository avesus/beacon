package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the product table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="product"
 */

public abstract class BaseProduct  implements Serializable {

	public static String REF = "Product";
	public static String PROP_EQPIDKEYP9 = "Eqpidkeyp9";
	public static String PROP_EQPIDKEYP8 = "Eqpidkeyp8";
	public static String PROP_EQPIDKEYP5 = "Eqpidkeyp5";
	public static String PROP_EQPIDKEYP4 = "Eqpidkeyp4";
	public static String PROP_HAZARDOUS = "Hazardous";
	public static String PROP_EQPIDKEYP7 = "Eqpidkeyp7";
	public static String PROP_EQPIDKEYP6 = "Eqpidkeyp6";
	public static String PROP_EQPIDKEYP1 = "Eqpidkeyp1";
	public static String PROP_EQPIDKEYP3 = "Eqpidkeyp3";
	public static String PROP_EQPIDKEYP2 = "Eqpidkeyp2";
	public static String PROP_VISCOSITY = "Viscosity";
	public static String PROP_CHEMNAME = "Chemname";
	public static String PROP_INDUSTRY_CLASS = "IndustryClass";
	public static String PROP_DGSTECHNICALNAME = "Dgstechnicalname";
	public static String PROP_PACKGRP = "Packgrp";
	public static String PROP_DOT_REGULATED = "DotRegulated";
	public static String PROP_PRODUCTCLASS = "productclass";
	public static String PROP_PRODCATGKEY = "Prodcatgkey";
	public static String PROP_HAZARDOUS_IMO = "HazardousImo";
	public static String PROP_BOILP = "Boilp";
	public static String PROP_IMDG = "Imdg";
	public static String PROP_UNTCODE = "Untcode";
	public static String PROP_CLEANGRP = "Cleangrp";
	public static String PROP_MAXCONTACTTEMP = "Maxcontacttemp";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_EMAIL = "Email";
	public static String PROP_REACHCODE = "Reachcode";
	public static String PROP_INSTRUCTIONS = "Instructions";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_PRDID = "Prdid";
	public static String PROP_TRADEDES = "Tradedes";
	public static String PROP_TEMPUNIT = "Tempunit";
	public static String PROP_MAXTEMP = "Maxtemp";
	public static String PROP_IMDGSC1 = "Imdgsc1";
	public static String PROP_IMDGSC2 = "Imdgsc2";
	public static String PROP_GGVE = "Ggve";
	public static String PROP_GGVSCLASS = "Ggvsclass";
	public static String PROP_TRAMCARD = "Tramcard";
	public static String PROP_PACKING_GROUP = "PackingGroup";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EQPIDKEY = "Eqpidkey";
	public static String PROP_TEMPHI = "Temphi";
	public static String PROP_HAZID = "Hazid";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_ADRREF = "Adrref";
	public static String PROP_ICAO = "Icao";
	public static String PROP_DGSFLAG = "Dgsflag";
	public static String PROP_MFAG = "Mfag";
	public static String PROP_FLASHP = "Flashp";
	public static String PROP_KEMMLER = "Kemmler";
	public static String PROP_GASKETS = "Gaskets";
	public static String PROP_FILLT = "Fillt";
	public static String PROP_INTLHARMCODE = "Intlharmcode";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_FLEETGRPKEY = "Fleetgrpkey";
	public static String PROP_DOT51ONLY = "Dot51only";
	public static String PROP_TXT = "Txt";
	public static String PROP_RID = "Rid";
	public static String PROP_IMO = "Imo";
	public static String PROP_NACODE2 = "Nacode2";
	public static String PROP_NACODE1 = "Nacode1";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_IMDGLABEL = "Imdglabel";
	public static String PROP_PRDLABEL = "Prdlabel";
	public static String PROP_EMS = "Ems";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_EMS1 = "Ems1";
	public static String PROP_EMS2 = "Ems2";
	public static String PROP_MELTP = "Meltp";
	public static String PROP_ADR = "Adr";
	public static String PROP_EMS3 = "Ems3";
	public static String PROP_EMERGENCY3 = "Emergency3";
	public static String PROP_EVILSMELLING = "Evilsmelling";
	public static String PROP_EMS4 = "Ems4";
	public static String PROP_EMERGENCY1 = "Emergency1";
	public static String PROP_EMERGENCY2 = "Emergency2";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_RIDREF = "Ridref";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_IATACLASS = "Iataclass";
	public static String PROP_DISCHGT = "Dischgt";
	public static String PROP_GGVSREF = "Ggvsref";
	public static String PROP_IMOKEY = "Imokey";
	public static String PROP_HEATERPAD = "Heaterpad";
	public static String PROP_TRADNAME = "Tradname";
	public static String PROP_XACTION = "Xaction";
	public static String PROP_TEMPLOW = "Templow";
	public static String PROP_HOMMEL = "Hommel";
	public static String PROP_SUPPLIERADDRKEY = "Supplieraddrkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_OPCL = "Opcl";
	public static String PROP_DGSPHONE1 = "Dgsphone1";
	public static String PROP_DGSPHONE2 = "Dgsphone2";
	public static String PROP_DGSINFORMATION = "Dgsinformation";
	public static String PROP_DGSPHONE3 = "Dgsphone3";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_MINIMUM_CAPACITY = "MinimumCapacity";
	public static String PROP_PRODCODE = "Prodcode";
	public static String PROP_OPCU = "Opcu";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_DGSCONTACT3 = "Dgscontact3";
	public static String PROP_SPECGRAV = "Specgrav";
	public static String PROP_BOTTOMFILL = "Bottomfill";
	public static String PROP_DGSCONTACT2 = "Dgscontact2";
	public static String PROP_LDESC = "Ldesc";
	public static String PROP_DGSCONTACT1 = "Dgscontact1";
	public static String PROP_COLOURKEY = "Colourkey";
	public static String PROP_CASNUMBER = "Casnumber";
	public static String PROP_MINTEMP = "Mintemp";
	public static String PROP_UNNO = "Unno";
	public static String PROP_DGSNOTES = "Dgsnotes";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_EQPIDKEYP10 = "Eqpidkeyp10";
	public static String PROP_GGVEREF = "Ggveref";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_HARMCODE = "Harmcode";


	// constructors
	public BaseProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProduct (java.lang.String productkey) {
		this.setProductkey(productkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String productkey;

	// fields
	private java.lang.String prodcode;
	private java.lang.String tradname;
	private java.lang.String imokey;
	private java.lang.String ldesc;
	private java.lang.String imdg;
	private java.lang.String ggve;
	private java.lang.String ggveref;
	private java.lang.String ggvsclass;
	private java.lang.String ggvsref;
	private java.lang.String prdlabel;
	private java.lang.String txt;
	private java.lang.String boilp;
	private java.lang.String tradedes;
	private java.lang.String meltp;
	private java.lang.Integer templow;
	private java.lang.String fillt;
	private java.lang.Integer temphi;
	private java.lang.String dischgt;
	private java.lang.String mintemp;
	private java.lang.String maxtemp;
	private java.lang.String hommel;
	private java.lang.String kemmler;
	private java.lang.String adr;
	private java.lang.String adrref;
	private java.lang.String rid;
	private java.lang.String ridref;
	private java.lang.String icao;
	private java.lang.String iataclass;
	private java.lang.String imo;
	private java.lang.String cleangrp;
	private java.lang.String ems;
	private java.lang.String mfag;
	private java.lang.String tramcard;
	private java.lang.String packgrp;
	private java.lang.String tempunit;
	private java.lang.String opcu;
	private java.lang.String opcl;
	private java.lang.String harmcode;
	private java.lang.String eqpidkey;
	private java.lang.String xuserid;
	private java.lang.String xtime;
	private java.lang.String xprog;
	private java.lang.String xaction;
	private java.lang.String xlock;
	private java.lang.String colourkey;
	private java.lang.String prodcatgkey;
	private java.lang.String fleetgrpkey;
	private java.math.BigDecimal minimumCapacity;
	private java.lang.String eqpidkeyp1;
	private java.lang.String eqpidkeyp2;
	private java.lang.String eqpidkeyp3;
	private java.lang.String eqpidkeyp4;
	private java.lang.String eqpidkeyp5;
	private java.lang.String eqpidkeyp6;
	private java.lang.String eqpidkeyp7;
	private java.lang.String eqpidkeyp8;
	private java.lang.String eqpidkeyp9;
	private java.lang.String eqpidkeyp10;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.lang.Integer rowid;
	private java.lang.String hazardousImo;
	private java.lang.String productclass;
	private java.lang.String industryClass;
	private java.lang.String supplieraddrkey;
	private java.lang.String flashp;
	private java.math.BigDecimal specgrav;
	private java.math.BigDecimal viscosity;
	private java.lang.String unno;
	private java.lang.String chemname;
	private java.lang.String emergency1;
	private java.lang.String emergency2;
	private java.lang.String emergency3;
	private java.lang.String email;
	private java.lang.String instructions;
	private java.lang.String packingGroup;
	private java.lang.String systemlogprogram;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogaction;
	private boolean hazardous;
	private java.lang.String dotRegulated;
	private java.lang.String active;
	private boolean bottomfill;
	private boolean evilsmelling;
	private java.util.Date systemlogdate;
	private java.lang.String hazid;
	private java.lang.String prdid;
	private java.lang.String untcode;
	private java.lang.String casnumber;
	private java.lang.String reachcode;
	private java.lang.String intlharmcode;
	private boolean heaterpad;
	private java.lang.String gaskets;
	private java.lang.String maxcontacttemp;
	private java.lang.String imdgsc1;
	private java.lang.String imdgsc2;
	private java.lang.String imdglabel;
	private java.lang.String ems1;
	private java.lang.String ems2;
	private java.lang.String ems3;
	private java.lang.String ems4;
	private boolean dot51only;
	private java.lang.String nacode1;
	private java.lang.String nacode2;
	private boolean dgsflag;
	private java.lang.String dgsnotes;
	private java.lang.String dgsinformation;
	private java.lang.String dgstechnicalname;
	private java.lang.String dgscontact1;
	private java.lang.String dgscontact2;
	private java.lang.String dgscontact3;
	private java.lang.String dgsphone1;
	private java.lang.String dgsphone2;
	private java.lang.String dgsphone3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="productkey"
     */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param productkey the new ID
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: prodcode
	 */
	public java.lang.String getProdcode () {
		return prodcode;
	}

	/**
	 * Set the value related to the column: prodcode
	 * @param prodcode the prodcode value
	 */
	public void setProdcode (java.lang.String prodcode) {
		this.prodcode = prodcode;
	}



	/**
	 * Return the value associated with the column: tradname
	 */
	public java.lang.String getTradname () {
		return tradname;
	}

	/**
	 * Set the value related to the column: tradname
	 * @param tradname the tradname value
	 */
	public void setTradname (java.lang.String tradname) {
		this.tradname = tradname;
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
	 * Return the value associated with the column: ldesc
	 */
	public java.lang.String getLdesc () {
		return ldesc;
	}

	/**
	 * Set the value related to the column: ldesc
	 * @param ldesc the ldesc value
	 */
	public void setLdesc (java.lang.String ldesc) {
		this.ldesc = ldesc;
	}



	/**
	 * Return the value associated with the column: imdg
	 */
	public java.lang.String getImdg () {
		return imdg;
	}

	/**
	 * Set the value related to the column: imdg
	 * @param imdg the imdg value
	 */
	public void setImdg (java.lang.String imdg) {
		this.imdg = imdg;
	}



	/**
	 * Return the value associated with the column: ggve
	 */
	public java.lang.String getGgve () {
		return ggve;
	}

	/**
	 * Set the value related to the column: ggve
	 * @param ggve the ggve value
	 */
	public void setGgve (java.lang.String ggve) {
		this.ggve = ggve;
	}



	/**
	 * Return the value associated with the column: ggveref
	 */
	public java.lang.String getGgveref () {
		return ggveref;
	}

	/**
	 * Set the value related to the column: ggveref
	 * @param ggveref the ggveref value
	 */
	public void setGgveref (java.lang.String ggveref) {
		this.ggveref = ggveref;
	}



	/**
	 * Return the value associated with the column: ggvsclass
	 */
	public java.lang.String getGgvsclass () {
		return ggvsclass;
	}

	/**
	 * Set the value related to the column: ggvsclass
	 * @param ggvsclass the ggvsclass value
	 */
	public void setGgvsclass (java.lang.String ggvsclass) {
		this.ggvsclass = ggvsclass;
	}



	/**
	 * Return the value associated with the column: ggvsref
	 */
	public java.lang.String getGgvsref () {
		return ggvsref;
	}

	/**
	 * Set the value related to the column: ggvsref
	 * @param ggvsref the ggvsref value
	 */
	public void setGgvsref (java.lang.String ggvsref) {
		this.ggvsref = ggvsref;
	}



	/**
	 * Return the value associated with the column: prdlabel
	 */
	public java.lang.String getPrdlabel () {
		return prdlabel;
	}

	/**
	 * Set the value related to the column: prdlabel
	 * @param prdlabel the prdlabel value
	 */
	public void setPrdlabel (java.lang.String prdlabel) {
		this.prdlabel = prdlabel;
	}



	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}



	/**
	 * Return the value associated with the column: boilp
	 */
	public java.lang.String getBoilp () {
		return boilp;
	}

	/**
	 * Set the value related to the column: boilp
	 * @param boilp the boilp value
	 */
	public void setBoilp (java.lang.String boilp) {
		this.boilp = boilp;
	}



	/**
	 * Return the value associated with the column: tradedes
	 */
	public java.lang.String getTradedes () {
		return tradedes;
	}

	/**
	 * Set the value related to the column: tradedes
	 * @param tradedes the tradedes value
	 */
	public void setTradedes (java.lang.String tradedes) {
		this.tradedes = tradedes;
	}



	/**
	 * Return the value associated with the column: meltp
	 */
	public java.lang.String getMeltp () {
		return meltp;
	}

	/**
	 * Set the value related to the column: meltp
	 * @param meltp the meltp value
	 */
	public void setMeltp (java.lang.String meltp) {
		this.meltp = meltp;
	}



	/**
	 * Return the value associated with the column: templow
	 */
	public java.lang.Integer getTemplow () {
		return templow;
	}

	/**
	 * Set the value related to the column: templow
	 * @param templow the templow value
	 */
	public void setTemplow (java.lang.Integer templow) {
		this.templow = templow;
	}



	/**
	 * Return the value associated with the column: fillt
	 */
	public java.lang.String getFillt () {
		return fillt;
	}

	/**
	 * Set the value related to the column: fillt
	 * @param fillt the fillt value
	 */
	public void setFillt (java.lang.String fillt) {
		this.fillt = fillt;
	}



	/**
	 * Return the value associated with the column: temphi
	 */
	public java.lang.Integer getTemphi () {
		return temphi;
	}

	/**
	 * Set the value related to the column: temphi
	 * @param temphi the temphi value
	 */
	public void setTemphi (java.lang.Integer temphi) {
		this.temphi = temphi;
	}



	/**
	 * Return the value associated with the column: dischgt
	 */
	public java.lang.String getDischgt () {
		return dischgt;
	}

	/**
	 * Set the value related to the column: dischgt
	 * @param dischgt the dischgt value
	 */
	public void setDischgt (java.lang.String dischgt) {
		this.dischgt = dischgt;
	}



	/**
	 * Return the value associated with the column: mintemp
	 */
	public java.lang.String getMintemp () {
		return mintemp;
	}

	/**
	 * Set the value related to the column: mintemp
	 * @param mintemp the mintemp value
	 */
	public void setMintemp (java.lang.String mintemp) {
		this.mintemp = mintemp;
	}



	/**
	 * Return the value associated with the column: maxtemp
	 */
	public java.lang.String getMaxtemp () {
		return maxtemp;
	}

	/**
	 * Set the value related to the column: maxtemp
	 * @param maxtemp the maxtemp value
	 */
	public void setMaxtemp (java.lang.String maxtemp) {
		this.maxtemp = maxtemp;
	}



	/**
	 * Return the value associated with the column: hommel
	 */
	public java.lang.String getHommel () {
		return hommel;
	}

	/**
	 * Set the value related to the column: hommel
	 * @param hommel the hommel value
	 */
	public void setHommel (java.lang.String hommel) {
		this.hommel = hommel;
	}



	/**
	 * Return the value associated with the column: kemmler
	 */
	public java.lang.String getKemmler () {
		return kemmler;
	}

	/**
	 * Set the value related to the column: kemmler
	 * @param kemmler the kemmler value
	 */
	public void setKemmler (java.lang.String kemmler) {
		this.kemmler = kemmler;
	}



	/**
	 * Return the value associated with the column: adr
	 */
	public java.lang.String getAdr () {
		return adr;
	}

	/**
	 * Set the value related to the column: adr
	 * @param adr the adr value
	 */
	public void setAdr (java.lang.String adr) {
		this.adr = adr;
	}



	/**
	 * Return the value associated with the column: adrref
	 */
	public java.lang.String getAdrref () {
		return adrref;
	}

	/**
	 * Set the value related to the column: adrref
	 * @param adrref the adrref value
	 */
	public void setAdrref (java.lang.String adrref) {
		this.adrref = adrref;
	}



	/**
	 * Return the value associated with the column: rid
	 */
	public java.lang.String getRid () {
		return rid;
	}

	/**
	 * Set the value related to the column: rid
	 * @param rid the rid value
	 */
	public void setRid (java.lang.String rid) {
		this.rid = rid;
	}



	/**
	 * Return the value associated with the column: ridref
	 */
	public java.lang.String getRidref () {
		return ridref;
	}

	/**
	 * Set the value related to the column: ridref
	 * @param ridref the ridref value
	 */
	public void setRidref (java.lang.String ridref) {
		this.ridref = ridref;
	}



	/**
	 * Return the value associated with the column: icao
	 */
	public java.lang.String getIcao () {
		return icao;
	}

	/**
	 * Set the value related to the column: icao
	 * @param icao the icao value
	 */
	public void setIcao (java.lang.String icao) {
		this.icao = icao;
	}



	/**
	 * Return the value associated with the column: iataclass
	 */
	public java.lang.String getIataclass () {
		return iataclass;
	}

	/**
	 * Set the value related to the column: iataclass
	 * @param iataclass the iataclass value
	 */
	public void setIataclass (java.lang.String iataclass) {
		this.iataclass = iataclass;
	}



	/**
	 * Return the value associated with the column: imo
	 */
	public java.lang.String getImo () {
		return imo;
	}

	/**
	 * Set the value related to the column: imo
	 * @param imo the imo value
	 */
	public void setImo (java.lang.String imo) {
		this.imo = imo;
	}



	/**
	 * Return the value associated with the column: cleangrp
	 */
	public java.lang.String getCleangrp () {
		return cleangrp;
	}

	/**
	 * Set the value related to the column: cleangrp
	 * @param cleangrp the cleangrp value
	 */
	public void setCleangrp (java.lang.String cleangrp) {
		this.cleangrp = cleangrp;
	}



	/**
	 * Return the value associated with the column: ems
	 */
	public java.lang.String getEms () {
		return ems;
	}

	/**
	 * Set the value related to the column: ems
	 * @param ems the ems value
	 */
	public void setEms (java.lang.String ems) {
		this.ems = ems;
	}



	/**
	 * Return the value associated with the column: mfag
	 */
	public java.lang.String getMfag () {
		return mfag;
	}

	/**
	 * Set the value related to the column: mfag
	 * @param mfag the mfag value
	 */
	public void setMfag (java.lang.String mfag) {
		this.mfag = mfag;
	}



	/**
	 * Return the value associated with the column: tramcard
	 */
	public java.lang.String getTramcard () {
		return tramcard;
	}

	/**
	 * Set the value related to the column: tramcard
	 * @param tramcard the tramcard value
	 */
	public void setTramcard (java.lang.String tramcard) {
		this.tramcard = tramcard;
	}



	/**
	 * Return the value associated with the column: packgrp
	 */
	public java.lang.String getPackgrp () {
		return packgrp;
	}

	/**
	 * Set the value related to the column: packgrp
	 * @param packgrp the packgrp value
	 */
	public void setPackgrp (java.lang.String packgrp) {
		this.packgrp = packgrp;
	}



	/**
	 * Return the value associated with the column: tempunit
	 */
	public java.lang.String getTempunit () {
		return tempunit;
	}

	/**
	 * Set the value related to the column: tempunit
	 * @param tempunit the tempunit value
	 */
	public void setTempunit (java.lang.String tempunit) {
		this.tempunit = tempunit;
	}



	/**
	 * Return the value associated with the column: opcu
	 */
	public java.lang.String getOpcu () {
		return opcu;
	}

	/**
	 * Set the value related to the column: opcu
	 * @param opcu the opcu value
	 */
	public void setOpcu (java.lang.String opcu) {
		this.opcu = opcu;
	}



	/**
	 * Return the value associated with the column: opcl
	 */
	public java.lang.String getOpcl () {
		return opcl;
	}

	/**
	 * Set the value related to the column: opcl
	 * @param opcl the opcl value
	 */
	public void setOpcl (java.lang.String opcl) {
		this.opcl = opcl;
	}



	/**
	 * Return the value associated with the column: harmcode
	 */
	public java.lang.String getHarmcode () {
		return harmcode;
	}

	/**
	 * Set the value related to the column: harmcode
	 * @param harmcode the harmcode value
	 */
	public void setHarmcode (java.lang.String harmcode) {
		this.harmcode = harmcode;
	}



	/**
	 * Return the value associated with the column: eqpidkey
	 */
	public java.lang.String getEqpidkey () {
		return eqpidkey;
	}

	/**
	 * Set the value related to the column: eqpidkey
	 * @param eqpidkey the eqpidkey value
	 */
	public void setEqpidkey (java.lang.String eqpidkey) {
		this.eqpidkey = eqpidkey;
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
	 * Return the value associated with the column: colourkey
	 */
	public java.lang.String getColourkey () {
		return colourkey;
	}

	/**
	 * Set the value related to the column: colourkey
	 * @param colourkey the colourkey value
	 */
	public void setColourkey (java.lang.String colourkey) {
		this.colourkey = colourkey;
	}



	/**
	 * Return the value associated with the column: prodcatgkey
	 */
	public java.lang.String getProdcatgkey () {
		return prodcatgkey;
	}

	/**
	 * Set the value related to the column: prodcatgkey
	 * @param prodcatgkey the prodcatgkey value
	 */
	public void setProdcatgkey (java.lang.String prodcatgkey) {
		this.prodcatgkey = prodcatgkey;
	}



	/**
	 * Return the value associated with the column: fleetgrpkey
	 */
	public java.lang.String getFleetgrpkey () {
		return fleetgrpkey;
	}

	/**
	 * Set the value related to the column: fleetgrpkey
	 * @param fleetgrpkey the fleetgrpkey value
	 */
	public void setFleetgrpkey (java.lang.String fleetgrpkey) {
		this.fleetgrpkey = fleetgrpkey;
	}



	/**
	 * Return the value associated with the column: minimum_capacity
	 */
	public java.math.BigDecimal getMinimumCapacity () {
		return minimumCapacity;
	}

	/**
	 * Set the value related to the column: minimum_capacity
	 * @param minimumCapacity the minimum_capacity value
	 */
	public void setMinimumCapacity (java.math.BigDecimal minimumCapacity) {
		this.minimumCapacity = minimumCapacity;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp1
	 */
	public java.lang.String getEqpidkeyp1 () {
		return eqpidkeyp1;
	}

	/**
	 * Set the value related to the column: eqpidkeyp1
	 * @param eqpidkeyp1 the eqpidkeyp1 value
	 */
	public void setEqpidkeyp1 (java.lang.String eqpidkeyp1) {
		this.eqpidkeyp1 = eqpidkeyp1;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp2
	 */
	public java.lang.String getEqpidkeyp2 () {
		return eqpidkeyp2;
	}

	/**
	 * Set the value related to the column: eqpidkeyp2
	 * @param eqpidkeyp2 the eqpidkeyp2 value
	 */
	public void setEqpidkeyp2 (java.lang.String eqpidkeyp2) {
		this.eqpidkeyp2 = eqpidkeyp2;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp3
	 */
	public java.lang.String getEqpidkeyp3 () {
		return eqpidkeyp3;
	}

	/**
	 * Set the value related to the column: eqpidkeyp3
	 * @param eqpidkeyp3 the eqpidkeyp3 value
	 */
	public void setEqpidkeyp3 (java.lang.String eqpidkeyp3) {
		this.eqpidkeyp3 = eqpidkeyp3;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp4
	 */
	public java.lang.String getEqpidkeyp4 () {
		return eqpidkeyp4;
	}

	/**
	 * Set the value related to the column: eqpidkeyp4
	 * @param eqpidkeyp4 the eqpidkeyp4 value
	 */
	public void setEqpidkeyp4 (java.lang.String eqpidkeyp4) {
		this.eqpidkeyp4 = eqpidkeyp4;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp5
	 */
	public java.lang.String getEqpidkeyp5 () {
		return eqpidkeyp5;
	}

	/**
	 * Set the value related to the column: eqpidkeyp5
	 * @param eqpidkeyp5 the eqpidkeyp5 value
	 */
	public void setEqpidkeyp5 (java.lang.String eqpidkeyp5) {
		this.eqpidkeyp5 = eqpidkeyp5;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp6
	 */
	public java.lang.String getEqpidkeyp6 () {
		return eqpidkeyp6;
	}

	/**
	 * Set the value related to the column: eqpidkeyp6
	 * @param eqpidkeyp6 the eqpidkeyp6 value
	 */
	public void setEqpidkeyp6 (java.lang.String eqpidkeyp6) {
		this.eqpidkeyp6 = eqpidkeyp6;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp7
	 */
	public java.lang.String getEqpidkeyp7 () {
		return eqpidkeyp7;
	}

	/**
	 * Set the value related to the column: eqpidkeyp7
	 * @param eqpidkeyp7 the eqpidkeyp7 value
	 */
	public void setEqpidkeyp7 (java.lang.String eqpidkeyp7) {
		this.eqpidkeyp7 = eqpidkeyp7;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp8
	 */
	public java.lang.String getEqpidkeyp8 () {
		return eqpidkeyp8;
	}

	/**
	 * Set the value related to the column: eqpidkeyp8
	 * @param eqpidkeyp8 the eqpidkeyp8 value
	 */
	public void setEqpidkeyp8 (java.lang.String eqpidkeyp8) {
		this.eqpidkeyp8 = eqpidkeyp8;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp9
	 */
	public java.lang.String getEqpidkeyp9 () {
		return eqpidkeyp9;
	}

	/**
	 * Set the value related to the column: eqpidkeyp9
	 * @param eqpidkeyp9 the eqpidkeyp9 value
	 */
	public void setEqpidkeyp9 (java.lang.String eqpidkeyp9) {
		this.eqpidkeyp9 = eqpidkeyp9;
	}



	/**
	 * Return the value associated with the column: eqpidkeyp10
	 */
	public java.lang.String getEqpidkeyp10 () {
		return eqpidkeyp10;
	}

	/**
	 * Set the value related to the column: eqpidkeyp10
	 * @param eqpidkeyp10 the eqpidkeyp10 value
	 */
	public void setEqpidkeyp10 (java.lang.String eqpidkeyp10) {
		this.eqpidkeyp10 = eqpidkeyp10;
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
	 * Return the value associated with the column: HazardousImo
	 */
	public java.lang.String getHazardousImo () {
		return hazardousImo;
	}

	/**
	 * Set the value related to the column: HazardousImo
	 * @param hazardousImo the HazardousImo value
	 */
	public void setHazardousImo (java.lang.String hazardousImo) {
		this.hazardousImo = hazardousImo;
	}



	/**
	 * Return the value associated with the column: class
	 */
	public java.lang.String getProductclass () {
		return productclass;
	}

	/**
	 * Set the value related to the column: class
	 * @param productclass the class value
	 */
	public void setProductclass (java.lang.String productclass) {
		this.productclass = productclass;
	}



	/**
	 * Return the value associated with the column: IndustryClass
	 */
	public java.lang.String getIndustryClass () {
		return industryClass;
	}

	/**
	 * Set the value related to the column: IndustryClass
	 * @param industryClass the IndustryClass value
	 */
	public void setIndustryClass (java.lang.String industryClass) {
		this.industryClass = industryClass;
	}



	/**
	 * Return the value associated with the column: supplieraddrkey
	 */
	public java.lang.String getSupplieraddrkey () {
		return supplieraddrkey;
	}

	/**
	 * Set the value related to the column: supplieraddrkey
	 * @param supplieraddrkey the supplieraddrkey value
	 */
	public void setSupplieraddrkey (java.lang.String supplieraddrkey) {
		this.supplieraddrkey = supplieraddrkey;
	}



	/**
	 * Return the value associated with the column: flashp
	 */
	public java.lang.String getFlashp () {
		return flashp;
	}

	/**
	 * Set the value related to the column: flashp
	 * @param flashp the flashp value
	 */
	public void setFlashp (java.lang.String flashp) {
		this.flashp = flashp;
	}



	/**
	 * Return the value associated with the column: specgrav
	 */
	public java.math.BigDecimal getSpecgrav () {
		return specgrav;
	}

	/**
	 * Set the value related to the column: specgrav
	 * @param specgrav the specgrav value
	 */
	public void setSpecgrav (java.math.BigDecimal specgrav) {
		this.specgrav = specgrav;
	}



	/**
	 * Return the value associated with the column: Viscosity
	 */
	public java.math.BigDecimal getViscosity () {
		return viscosity;
	}

	/**
	 * Set the value related to the column: Viscosity
	 * @param viscosity the Viscosity value
	 */
	public void setViscosity (java.math.BigDecimal viscosity) {
		this.viscosity = viscosity;
	}



	/**
	 * Return the value associated with the column: unno
	 */
	public java.lang.String getUnno () {
		return unno;
	}

	/**
	 * Set the value related to the column: unno
	 * @param unno the unno value
	 */
	public void setUnno (java.lang.String unno) {
		this.unno = unno;
	}



	/**
	 * Return the value associated with the column: chemname
	 */
	public java.lang.String getChemname () {
		return chemname;
	}

	/**
	 * Set the value related to the column: chemname
	 * @param chemname the chemname value
	 */
	public void setChemname (java.lang.String chemname) {
		this.chemname = chemname;
	}



	/**
	 * Return the value associated with the column: Emergency1
	 */
	public java.lang.String getEmergency1 () {
		return emergency1;
	}

	/**
	 * Set the value related to the column: Emergency1
	 * @param emergency1 the Emergency1 value
	 */
	public void setEmergency1 (java.lang.String emergency1) {
		this.emergency1 = emergency1;
	}



	/**
	 * Return the value associated with the column: Emergency2
	 */
	public java.lang.String getEmergency2 () {
		return emergency2;
	}

	/**
	 * Set the value related to the column: Emergency2
	 * @param emergency2 the Emergency2 value
	 */
	public void setEmergency2 (java.lang.String emergency2) {
		this.emergency2 = emergency2;
	}



	/**
	 * Return the value associated with the column: Emergency3
	 */
	public java.lang.String getEmergency3 () {
		return emergency3;
	}

	/**
	 * Set the value related to the column: Emergency3
	 * @param emergency3 the Emergency3 value
	 */
	public void setEmergency3 (java.lang.String emergency3) {
		this.emergency3 = emergency3;
	}



	/**
	 * Return the value associated with the column: Email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: Email
	 * @param email the Email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: Instructions
	 */
	public java.lang.String getInstructions () {
		return instructions;
	}

	/**
	 * Set the value related to the column: Instructions
	 * @param instructions the Instructions value
	 */
	public void setInstructions (java.lang.String instructions) {
		this.instructions = instructions;
	}



	/**
	 * Return the value associated with the column: PackingGroup
	 */
	public java.lang.String getPackingGroup () {
		return packingGroup;
	}

	/**
	 * Set the value related to the column: PackingGroup
	 * @param packingGroup the PackingGroup value
	 */
	public void setPackingGroup (java.lang.String packingGroup) {
		this.packingGroup = packingGroup;
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
	 * Return the value associated with the column: hazardous
	 */
	public boolean isHazardous () {
		return hazardous;
	}

	/**
	 * Set the value related to the column: hazardous
	 * @param hazardous the hazardous value
	 */
	public void setHazardous (boolean hazardous) {
		this.hazardous = hazardous;
	}



	/**
	 * Return the value associated with the column: DotRegulated
	 */
	public java.lang.String getDotRegulated () {
		return dotRegulated;
	}

	/**
	 * Set the value related to the column: DotRegulated
	 * @param dotRegulated the DotRegulated value
	 */
	public void setDotRegulated (java.lang.String dotRegulated) {
		this.dotRegulated = dotRegulated;
	}



	/**
	 * Return the value associated with the column: active
	 */
	public java.lang.String getActive () {
		return active;
	}

	/**
	 * Set the value related to the column: active
	 * @param active the active value
	 */
	public void setActive (java.lang.String active) {
		this.active = active;
	}



	/**
	 * Return the value associated with the column: bottomfill
	 */
	public boolean isBottomfill () {
		return bottomfill;
	}

	/**
	 * Set the value related to the column: bottomfill
	 * @param bottomfill the bottomfill value
	 */
	public void setBottomfill (boolean bottomfill) {
		this.bottomfill = bottomfill;
	}



	/**
	 * Return the value associated with the column: evilsmelling
	 */
	public boolean isEvilsmelling () {
		return evilsmelling;
	}

	/**
	 * Set the value related to the column: evilsmelling
	 * @param evilsmelling the evilsmelling value
	 */
	public void setEvilsmelling (boolean evilsmelling) {
		this.evilsmelling = evilsmelling;
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
	 * Return the value associated with the column: hazid
	 */
	public java.lang.String getHazid () {
		return hazid;
	}

	/**
	 * Set the value related to the column: hazid
	 * @param hazid the hazid value
	 */
	public void setHazid (java.lang.String hazid) {
		this.hazid = hazid;
	}



	/**
	 * Return the value associated with the column: prdid
	 */
	public java.lang.String getPrdid () {
		return prdid;
	}

	/**
	 * Set the value related to the column: prdid
	 * @param prdid the prdid value
	 */
	public void setPrdid (java.lang.String prdid) {
		this.prdid = prdid;
	}



	/**
	 * Return the value associated with the column: untcode
	 */
	public java.lang.String getUntcode () {
		return untcode;
	}

	/**
	 * Set the value related to the column: untcode
	 * @param untcode the untcode value
	 */
	public void setUntcode (java.lang.String untcode) {
		this.untcode = untcode;
	}



	/**
	 * Return the value associated with the column: casnumber
	 */
	public java.lang.String getCasnumber () {
		return casnumber;
	}

	/**
	 * Set the value related to the column: casnumber
	 * @param casnumber the casnumber value
	 */
	public void setCasnumber (java.lang.String casnumber) {
		this.casnumber = casnumber;
	}



	/**
	 * Return the value associated with the column: reachcode
	 */
	public java.lang.String getReachcode () {
		return reachcode;
	}

	/**
	 * Set the value related to the column: reachcode
	 * @param reachcode the reachcode value
	 */
	public void setReachcode (java.lang.String reachcode) {
		this.reachcode = reachcode;
	}



	/**
	 * Return the value associated with the column: intlharmcode
	 */
	public java.lang.String getIntlharmcode () {
		return intlharmcode;
	}

	/**
	 * Set the value related to the column: intlharmcode
	 * @param intlharmcode the intlharmcode value
	 */
	public void setIntlharmcode (java.lang.String intlharmcode) {
		this.intlharmcode = intlharmcode;
	}



	/**
	 * Return the value associated with the column: heaterpad
	 */
	public boolean isHeaterpad () {
		return heaterpad;
	}

	/**
	 * Set the value related to the column: heaterpad
	 * @param heaterpad the heaterpad value
	 */
	public void setHeaterpad (boolean heaterpad) {
		this.heaterpad = heaterpad;
	}



	/**
	 * Return the value associated with the column: gaskets
	 */
	public java.lang.String getGaskets () {
		return gaskets;
	}

	/**
	 * Set the value related to the column: gaskets
	 * @param gaskets the gaskets value
	 */
	public void setGaskets (java.lang.String gaskets) {
		this.gaskets = gaskets;
	}



	/**
	 * Return the value associated with the column: maxcontacttemp
	 */
	public java.lang.String getMaxcontacttemp () {
		return maxcontacttemp;
	}

	/**
	 * Set the value related to the column: maxcontacttemp
	 * @param maxcontacttemp the maxcontacttemp value
	 */
	public void setMaxcontacttemp (java.lang.String maxcontacttemp) {
		this.maxcontacttemp = maxcontacttemp;
	}



	/**
	 * Return the value associated with the column: imdgsc1
	 */
	public java.lang.String getImdgsc1 () {
		return imdgsc1;
	}

	/**
	 * Set the value related to the column: imdgsc1
	 * @param imdgsc1 the imdgsc1 value
	 */
	public void setImdgsc1 (java.lang.String imdgsc1) {
		this.imdgsc1 = imdgsc1;
	}



	/**
	 * Return the value associated with the column: imdgsc2
	 */
	public java.lang.String getImdgsc2 () {
		return imdgsc2;
	}

	/**
	 * Set the value related to the column: imdgsc2
	 * @param imdgsc2 the imdgsc2 value
	 */
	public void setImdgsc2 (java.lang.String imdgsc2) {
		this.imdgsc2 = imdgsc2;
	}



	/**
	 * Return the value associated with the column: imdglabel
	 */
	public java.lang.String getImdglabel () {
		return imdglabel;
	}

	/**
	 * Set the value related to the column: imdglabel
	 * @param imdglabel the imdglabel value
	 */
	public void setImdglabel (java.lang.String imdglabel) {
		this.imdglabel = imdglabel;
	}



	/**
	 * Return the value associated with the column: ems1
	 */
	public java.lang.String getEms1 () {
		return ems1;
	}

	/**
	 * Set the value related to the column: ems1
	 * @param ems1 the ems1 value
	 */
	public void setEms1 (java.lang.String ems1) {
		this.ems1 = ems1;
	}



	/**
	 * Return the value associated with the column: ems2
	 */
	public java.lang.String getEms2 () {
		return ems2;
	}

	/**
	 * Set the value related to the column: ems2
	 * @param ems2 the ems2 value
	 */
	public void setEms2 (java.lang.String ems2) {
		this.ems2 = ems2;
	}



	/**
	 * Return the value associated with the column: ems3
	 */
	public java.lang.String getEms3 () {
		return ems3;
	}

	/**
	 * Set the value related to the column: ems3
	 * @param ems3 the ems3 value
	 */
	public void setEms3 (java.lang.String ems3) {
		this.ems3 = ems3;
	}



	/**
	 * Return the value associated with the column: ems4
	 */
	public java.lang.String getEms4 () {
		return ems4;
	}

	/**
	 * Set the value related to the column: ems4
	 * @param ems4 the ems4 value
	 */
	public void setEms4 (java.lang.String ems4) {
		this.ems4 = ems4;
	}



	/**
	 * Return the value associated with the column: dot51only
	 */
	public boolean isDot51only () {
		return dot51only;
	}

	/**
	 * Set the value related to the column: dot51only
	 * @param dot51only the dot51only value
	 */
	public void setDot51only (boolean dot51only) {
		this.dot51only = dot51only;
	}



	/**
	 * Return the value associated with the column: nacode1
	 */
	public java.lang.String getNacode1 () {
		return nacode1;
	}

	/**
	 * Set the value related to the column: nacode1
	 * @param nacode1 the nacode1 value
	 */
	public void setNacode1 (java.lang.String nacode1) {
		this.nacode1 = nacode1;
	}



	/**
	 * Return the value associated with the column: nacode2
	 */
	public java.lang.String getNacode2 () {
		return nacode2;
	}

	/**
	 * Set the value related to the column: nacode2
	 * @param nacode2 the nacode2 value
	 */
	public void setNacode2 (java.lang.String nacode2) {
		this.nacode2 = nacode2;
	}



	/**
	 * Return the value associated with the column: dgsflag
	 */
	public boolean isDgsflag () {
		return dgsflag;
	}

	/**
	 * Set the value related to the column: dgsflag
	 * @param dgsflag the dgsflag value
	 */
	public void setDgsflag (boolean dgsflag) {
		this.dgsflag = dgsflag;
	}



	/**
	 * Return the value associated with the column: dgsnotes
	 */
	public java.lang.String getDgsnotes () {
		return dgsnotes;
	}

	/**
	 * Set the value related to the column: dgsnotes
	 * @param dgsnotes the dgsnotes value
	 */
	public void setDgsnotes (java.lang.String dgsnotes) {
		this.dgsnotes = dgsnotes;
	}



	/**
	 * Return the value associated with the column: dgsinformation
	 */
	public java.lang.String getDgsinformation () {
		return dgsinformation;
	}

	/**
	 * Set the value related to the column: dgsinformation
	 * @param dgsinformation the dgsinformation value
	 */
	public void setDgsinformation (java.lang.String dgsinformation) {
		this.dgsinformation = dgsinformation;
	}



	/**
	 * Return the value associated with the column: dgstechnicalname
	 */
	public java.lang.String getDgstechnicalname () {
		return dgstechnicalname;
	}

	/**
	 * Set the value related to the column: dgstechnicalname
	 * @param dgstechnicalname the dgstechnicalname value
	 */
	public void setDgstechnicalname (java.lang.String dgstechnicalname) {
		this.dgstechnicalname = dgstechnicalname;
	}



	/**
	 * Return the value associated with the column: dgscontact1
	 */
	public java.lang.String getDgscontact1 () {
		return dgscontact1;
	}

	/**
	 * Set the value related to the column: dgscontact1
	 * @param dgscontact1 the dgscontact1 value
	 */
	public void setDgscontact1 (java.lang.String dgscontact1) {
		this.dgscontact1 = dgscontact1;
	}



	/**
	 * Return the value associated with the column: dgscontact2
	 */
	public java.lang.String getDgscontact2 () {
		return dgscontact2;
	}

	/**
	 * Set the value related to the column: dgscontact2
	 * @param dgscontact2 the dgscontact2 value
	 */
	public void setDgscontact2 (java.lang.String dgscontact2) {
		this.dgscontact2 = dgscontact2;
	}



	/**
	 * Return the value associated with the column: dgscontact3
	 */
	public java.lang.String getDgscontact3 () {
		return dgscontact3;
	}

	/**
	 * Set the value related to the column: dgscontact3
	 * @param dgscontact3 the dgscontact3 value
	 */
	public void setDgscontact3 (java.lang.String dgscontact3) {
		this.dgscontact3 = dgscontact3;
	}



	/**
	 * Return the value associated with the column: dgsphone1
	 */
	public java.lang.String getDgsphone1 () {
		return dgsphone1;
	}

	/**
	 * Set the value related to the column: dgsphone1
	 * @param dgsphone1 the dgsphone1 value
	 */
	public void setDgsphone1 (java.lang.String dgsphone1) {
		this.dgsphone1 = dgsphone1;
	}



	/**
	 * Return the value associated with the column: dgsphone2
	 */
	public java.lang.String getDgsphone2 () {
		return dgsphone2;
	}

	/**
	 * Set the value related to the column: dgsphone2
	 * @param dgsphone2 the dgsphone2 value
	 */
	public void setDgsphone2 (java.lang.String dgsphone2) {
		this.dgsphone2 = dgsphone2;
	}



	/**
	 * Return the value associated with the column: dgsphone3
	 */
	public java.lang.String getDgsphone3 () {
		return dgsphone3;
	}

	/**
	 * Set the value related to the column: dgsphone3
	 * @param dgsphone3 the dgsphone3 value
	 */
	public void setDgsphone3 (java.lang.String dgsphone3) {
		this.dgsphone3 = dgsphone3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Product)) return false;
		else {
			com.bureaueye.beacon.model.standard.Product product = (com.bureaueye.beacon.model.standard.Product) obj;
			if (null == this.getProductkey() || null == product.getProductkey()) return false;
			else return (this.getProductkey().equals(product.getProductkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getProductkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getProductkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}