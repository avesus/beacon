package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;

/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-26		200900019		Add Validation
 * 												
 *
 */
public final class ProductForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String _action;
	private String _readonly = "false";
	private String forwardname = "";
	
	// primary key
	private java.lang.String _productkey;
	
	// fields
	private java.lang.String _tempunit;
	private java.lang.String _eqpidkeyp4;
	private java.lang.String _adr;
	private boolean _evilsmelling;
	private java.lang.String _cleangrp;
	private java.lang.String _ggve;
	private java.lang.String _hazardousImo;
	private java.lang.String _eqpidkeyp1;
	private java.lang.String _opcl;
	private java.lang.String _imdg;
	private java.lang.String _eqpidkeyp6;
	private java.lang.String _packingGroup;
	private java.lang.String _productclass;
	private java.lang.String _ggveref;
	private java.lang.String _prodcatgkey;
	private java.lang.String _imo;
	private java.lang.String _eqpidkey;
	private java.lang.String _active;
	private java.lang.String _icao;
	private java.lang.String _ridref;
	private java.lang.String _harmcode;
	private java.lang.String _hazardous;
	private boolean _heaterpad;
	private java.lang.String _eqpidkeyp8;
	private java.lang.String _prodcode;
	private java.lang.String _txt;
	private java.lang.String _eqpidkeyp2;
	private java.lang.String _dotRegulated;
	private java.lang.String _ldesc;
	private java.lang.String _opcu;
	private java.lang.String _emergency1;
	private java.lang.String _eqpidkeyp3;
	private java.lang.String _dischgt;
	private java.lang.String _flashp;
	private java.lang.String _eqpidkeyp10;
	private java.lang.String _tradname;
	private java.lang.String _colourkey;
	private java.lang.String _hommel;
	private java.lang.String _minimumCapacity = "0.0";
	private java.lang.String _iataclass;
	private java.lang.String _industryClass;
	private java.lang.String _mfag;
	private java.lang.String _maxtemp;
	private java.lang.String _emergency3;
	private java.lang.String _unno;
	private java.lang.String _eqpidkeyp9;
	private java.lang.String _eqpidkeyp7;
	private java.lang.String _ggvsclass;
	private java.lang.String _fleetgrpkey;
	private boolean _bottomfill;
	private java.lang.String _tramcard;
	private java.lang.String _instructions;
	private java.lang.String _eqpidkeyp5;
	private java.lang.String _supplieraddrkey;
	private java.lang.String _specgrav = "0.0";
	private java.lang.String _chemname;
	private java.lang.String _email;
	private java.lang.String _adrref;
	private java.lang.String _mintemp;
	private java.lang.String _ggvsref;
	private java.lang.String _emergency2;
	private java.lang.String _kemmler;
	private java.lang.String _rid;
	private java.lang.String _meltp;	
	private java.lang.String _boilp;
	private java.lang.String _fillt;
	
	private java.lang.String _hazid;
	private java.lang.String _prdid;
	private java.lang.String _untcode;
	private java.lang.String _casnumber;
	private java.lang.String _reachcode;
	private boolean _marinepollutant;
	private java.lang.String _intlharmcode;
	private java.lang.String _gaskets;
	private java.lang.String _maxcontacttemp;
	private java.lang.String _imdgsc1;
	private java.lang.String _imdgsc2;
	private java.lang.String _imdglabel;
	private java.lang.String _ems1;
	private java.lang.String _ems2;
	private java.lang.String _ems3;
	private java.lang.String _ems4;
	private boolean _dot51only;
	private java.lang.String _nacode1;
	private java.lang.String _nacode2;
	

	
	private boolean dgsflag;
	private java.lang.String dgsnotes;
	private java.lang.String dgsinformation;
	private java.lang.String dgstechnicalname;
	private java.lang.String dgscontact1;
	private java.lang.String dgsphone1;
	
	
	
	
	// collections
	
	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	
	
	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public String getForwardname() {return forwardname;}
	public void setForwardname(String forwardname) {this.forwardname=forwardname;}
	
	
	
	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="assigned"
	 *  column="productkey"
	 */
	public java.lang.String getProductkey () {
		return _productkey;
	}
	
	/**
	 * Set the unique identifier of this class
	 * @param _productkey the new ID
	 */
	public void setProductkey (java.lang.String _productkey) {
		this._productkey = _productkey;
	}
	
	
	

	
	
	/**
	 * Return the value associated with the column: tempunit
	 */
	public java.lang.String getTempunit () {
		return _tempunit;
	}
	
	/**
	 * Set the value related to the column: tempunit
	 * @param _tempunit the tempunit value
	 */
	public void setTempunit (java.lang.String _tempunit) {
		this._tempunit = _tempunit;
	}
	

	
	/**
	 * Return the value associated with the column: meltp
	 */
	public java.lang.String getMeltp () {
		return _meltp;
	}

	/**
	 * Set the value related to the column: meltp
	 * @param meltp the meltp value
	 */
	public void setMeltp (java.lang.String _meltp) {
		this._meltp = _meltp;
	}	
	
	/**
	 * Return the value associated with the column: boilp
	 */
	public java.lang.String getBoilp () {
		return _boilp;
	}

	/**
	 * Set the value related to the column: boilp
	 * @param boilp the boilp value
	 */
	public void setBoilp (java.lang.String _boilp) {
		this._boilp = _boilp;
	}
	
	/**
	 * Return the value associated with the column: fillt
	 */
	public java.lang.String getFillt () {
		return _fillt;
	}

	/**
	 * Set the value related to the column: fillt
	 * @param fillt the fillt value
	 */
	public void setFillt (java.lang.String _fillt) {
		this._fillt = _fillt;
	}
	
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp4
	 */
	public java.lang.String getEqpidkeyp4 () {
		return _eqpidkeyp4;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp4
	 * @param _eqpidkeyp4 the eqpidkeyp4 value
	 */
	public void setEqpidkeyp4 (java.lang.String _eqpidkeyp4) {
		this._eqpidkeyp4 = _eqpidkeyp4;
	}
	
	
	/**
	 * Return the value associated with the column: adr
	 */
	public java.lang.String getAdr () {
		return _adr;
	}
	
	/**
	 * Set the value related to the column: adr
	 * @param _adr the adr value
	 */
	public void setAdr (java.lang.String _adr) {
		this._adr = _adr;
	}
	
	
	/**
	 * Return the value associated with the column: evilsmelling
	 */
	public boolean isEvilsmelling () {
		return _evilsmelling;
	}
	
	/**
	 * Set the value related to the column: evilsmelling
	 * @param _evilsmelling the evilsmelling value
	 */
	public void setEvilsmelling (boolean _evilsmelling) {
		this._evilsmelling = _evilsmelling;
	}
	
	

	
	
	/**
	 * Return the value associated with the column: cleangrp
	 */
	public java.lang.String getCleangrp () {
		return _cleangrp;
	}
	
	/**
	 * Set the value related to the column: cleangrp
	 * @param _cleangrp the cleangrp value
	 */
	public void setCleangrp (java.lang.String _cleangrp) {
		this._cleangrp = _cleangrp;
	}
	
	
	/**
	 * Return the value associated with the column: ggve
	 */
	public java.lang.String getGgve () {
		return _ggve;
	}
	
	/**
	 * Set the value related to the column: ggve
	 * @param _ggve the ggve value
	 */
	public void setGgve (java.lang.String _ggve) {
		this._ggve = _ggve;
	}
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: HazardousImo
	 */
	public java.lang.String getHazardousImo () {
		return _hazardousImo;
	}
	
	/**
	 * Set the value related to the column: HazardousImo
	 * @param _hazardousImo the HazardousImo value
	 */
	public void setHazardousImo (java.lang.String _hazardousImo) {
		this._hazardousImo = _hazardousImo;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp1
	 */
	public java.lang.String getEqpidkeyp1 () {
		return _eqpidkeyp1;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp1
	 * @param _eqpidkeyp1 the eqpidkeyp1 value
	 */
	public void setEqpidkeyp1 (java.lang.String _eqpidkeyp1) {
		this._eqpidkeyp1 = _eqpidkeyp1;
	}
	
	
	/**
	 * Return the value associated with the column: opcl
	 */
	public java.lang.String getOpcl () {
		return _opcl;
	}
	
	/**
	 * Set the value related to the column: opcl
	 * @param _opcl the opcl value
	 */
	public void setOpcl (java.lang.String _opcl) {
		this._opcl = _opcl;
	}
	
	
	/**
	 * Return the value associated with the column: imdg
	 */
	public java.lang.String getImdg () {
		return _imdg;
	}
	
	/**
	 * Set the value related to the column: imdg
	 * @param _imdg the imdg value
	 */
	public void setImdg (java.lang.String _imdg) {
		this._imdg = _imdg;
	}
	
	
	
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp6
	 */
	public java.lang.String getEqpidkeyp6 () {
		return _eqpidkeyp6;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp6
	 * @param _eqpidkeyp6 the eqpidkeyp6 value
	 */
	public void setEqpidkeyp6 (java.lang.String _eqpidkeyp6) {
		this._eqpidkeyp6 = _eqpidkeyp6;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: PackingGroup
	 */
	public java.lang.String getPackingGroup () {
		return _packingGroup;
	}
	
	/**
	 * Set the value related to the column: PackingGroup
	 * @param _packingGroup the PackingGroup value
	 */
	public void setPackingGroup (java.lang.String _packingGroup) {
		this._packingGroup = _packingGroup;
	}
	
	
	/**
	 * Return the value associated with the column: productclass
	 */
	public java.lang.String getProductclass () {
		return _productclass;
	}
	
	/**
	 * Set the value related to the column: productclass
	 * @param _productclass the productclass value
	 */
	public void setProductclass (java.lang.String _productclass) {
		this._productclass = _productclass;
	}
	
	
	/**
	 * Return the value associated with the column: ggveref
	 */
	public java.lang.String getGgveref () {
		return _ggveref;
	}
	
	/**
	 * Set the value related to the column: ggveref
	 * @param _ggveref the ggveref value
	 */
	public void setGgveref (java.lang.String _ggveref) {
		this._ggveref = _ggveref;
	}
	
	
	/**
	 * Return the value associated with the column: prodcatgkey
	 */
	public java.lang.String getProdcatgkey () {
		return _prodcatgkey;
	}
	
	/**
	 * Set the value related to the column: prodcatgkey
	 * @param _prodcatgkey the prodcatgkey value
	 */
	public void setProdcatgkey (java.lang.String _prodcatgkey) {
		this._prodcatgkey = _prodcatgkey;
	}
	
	
	
	
	

	
	
	/**
	 * Return the value associated with the column: imo
	 */
	public java.lang.String getImo () {
		return _imo;
	}
	
	/**
	 * Set the value related to the column: imo
	 * @param _imo the imo value
	 */
	public void setImo (java.lang.String _imo) {
		this._imo = _imo;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkey
	 */
	public java.lang.String getEqpidkey () {
		return _eqpidkey;
	}
	
	/**
	 * Set the value related to the column: eqpidkey
	 * @param _eqpidkey the eqpidkey value
	 */
	public void setEqpidkey (java.lang.String _eqpidkey) {
		this._eqpidkey = _eqpidkey;
	}
	
	
	/**
	 * Return the value associated with the column: active
	 */
	public java.lang.String getActive () {
		return _active;
	}
	
	/**
	 * Set the value related to the column: active
	 * @param _active the active value
	 */
	public void setActive (java.lang.String _active) {
		this._active = _active;
	}
	
	
	/**
	 * Return the value associated with the column: icao
	 */
	public java.lang.String getIcao () {
		return _icao;
	}
	
	/**
	 * Set the value related to the column: icao
	 * @param _icao the icao value
	 */
	public void setIcao (java.lang.String _icao) {
		this._icao = _icao;
	}
	
	
	/**
	 * Return the value associated with the column: ridref
	 */
	public java.lang.String getRidref () {
		return _ridref;
	}
	
	/**
	 * Set the value related to the column: ridref
	 * @param _ridref the ridref value
	 */
	public void setRidref (java.lang.String _ridref) {
		this._ridref = _ridref;
	}
	
	
	/**
	 * Return the value associated with the column: harmcode
	 */
	public java.lang.String getHarmcode () {
		return _harmcode;
	}
	
	/**
	 * Set the value related to the column: harmcode
	 * @param _harmcode the harmcode value
	 */
	public void setHarmcode (java.lang.String _harmcode) {
		this._harmcode = _harmcode;
	}
	
	
	/**
	 * Return the value associated with the column: hazardous
	 */
	public java.lang.String getHazardous () {
		return _hazardous;
	}
	
	/**
	 * Set the value related to the column: hazardous
	 * @param _hazardous the hazardous value
	 */
	public void setHazardous (java.lang.String _hazardous) {
		this._hazardous = _hazardous;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp8
	 */
	public java.lang.String getEqpidkeyp8 () {
		return _eqpidkeyp8;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp8
	 * @param _eqpidkeyp8 the eqpidkeyp8 value
	 */
	public void setEqpidkeyp8 (java.lang.String _eqpidkeyp8) {
		this._eqpidkeyp8 = _eqpidkeyp8;
	}
	
	
	/**
	 * Return the value associated with the column: prodcode
	 */
	public java.lang.String getProdcode () {
		return _prodcode;
	}
	
	/**
	 * Set the value related to the column: prodcode
	 * @param _prodcode the prodcode value
	 */
	public void setProdcode (java.lang.String _prodcode) {
		this._prodcode = _prodcode;
	}
	
	
	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return _txt;
	}
	
	/**
	 * Set the value related to the column: txt
	 * @param _txt the txt value
	 */
	public void setTxt (java.lang.String _txt) {
		this._txt = _txt;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp2
	 */
	public java.lang.String getEqpidkeyp2 () {
		return _eqpidkeyp2;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp2
	 * @param _eqpidkeyp2 the eqpidkeyp2 value
	 */
	public void setEqpidkeyp2 (java.lang.String _eqpidkeyp2) {
		this._eqpidkeyp2 = _eqpidkeyp2;
	}
	
	

	
	
	/**
	 * Return the value associated with the column: DotRegulated
	 */
	public java.lang.String getDotRegulated () {
		return _dotRegulated;
	}
	
	/**
	 * Set the value related to the column: DotRegulated
	 * @param _dotRegulated the DotRegulated value
	 */
	public void setDotRegulated (java.lang.String _dotRegulated) {
		this._dotRegulated = _dotRegulated;
	}
	
	
	/**
	 * Return the value associated with the column: ldesc
	 */
	public java.lang.String getLdesc () {
		return _ldesc;
	}
	
	/**
	 * Set the value related to the column: ldesc
	 * @param _ldesc the ldesc value
	 */
	public void setLdesc (java.lang.String _ldesc) {
		this._ldesc = _ldesc;
	}
	
	
	/**
	 * Return the value associated with the column: opcu
	 */
	public java.lang.String getOpcu () {
		return _opcu;
	}
	
	/**
	 * Set the value related to the column: opcu
	 * @param _opcu the opcu value
	 */
	public void setOpcu (java.lang.String _opcu) {
		this._opcu = _opcu;
	}
	
	

	
	
	
	
	/**
	 * Return the value associated with the column: Emergency1
	 */
	public java.lang.String getEmergency1 () {
		return _emergency1;
	}
	
	/**
	 * Set the value related to the column: Emergency1
	 * @param _emergency1 the Emergency1 value
	 */
	public void setEmergency1 (java.lang.String _emergency1) {
		this._emergency1 = _emergency1;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp3
	 */
	public java.lang.String getEqpidkeyp3 () {
		return _eqpidkeyp3;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp3
	 * @param _eqpidkeyp3 the eqpidkeyp3 value
	 */
	public void setEqpidkeyp3 (java.lang.String _eqpidkeyp3) {
		this._eqpidkeyp3 = _eqpidkeyp3;
	}
	
	
	/**
	 * Return the value associated with the column: dischgt
	 */
	public java.lang.String getDischgt () {
		return _dischgt;
	}
	
	/**
	 * Set the value related to the column: dischgt
	 * @param _dischgt the dischgt value
	 */
	public void setDischgt (java.lang.String _dischgt) {
		this._dischgt = _dischgt;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: flashp
	 */
	public java.lang.String getFlashp () {
		return _flashp;
	}
	
	/**
	 * Set the value related to the column: flashp
	 * @param _flashp the flashp value
	 */
	public void setFlashp (java.lang.String _flashp) {
		this._flashp = _flashp;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp10
	 */
	public java.lang.String getEqpidkeyp10 () {
		return _eqpidkeyp10;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp10
	 * @param _eqpidkeyp10 the eqpidkeyp10 value
	 */
	public void setEqpidkeyp10 (java.lang.String _eqpidkeyp10) {
		this._eqpidkeyp10 = _eqpidkeyp10;
	}
	
	
	/**
	 * Return the value associated with the column: tradname
	 */
	public java.lang.String getTradname () {
		return _tradname;
	}
	
	/**
	 * Set the value related to the column: tradname
	 * @param _tradname the tradname value
	 */
	public void setTradname (java.lang.String _tradname) {
		this._tradname = _tradname;
	}
	
	
	
	/**
	 * Return the value associated with the column: colourkey
	 */
	public java.lang.String getColourkey () {
		return _colourkey;
	}
	
	/**
	 * Set the value related to the column: colourkey
	 * @param _colourkey the colourkey value
	 */
	public void setColourkey (java.lang.String _colourkey) {
		this._colourkey = _colourkey;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: hommel
	 */
	public java.lang.String getHommel () {
		return _hommel;
	}
	
	/**
	 * Set the value related to the column: hommel
	 * @param _hommel the hommel value
	 */
	public void setHommel (java.lang.String _hommel) {
		this._hommel = _hommel;
	}
	
	
	/**
	 * Return the value associated with the column: minimum_capacity
	 */
	public java.lang.String getMinimumCapacity () {
		return _minimumCapacity;
	}
	
	/**
	 * Set the value related to the column: minimum_capacity
	 * @param _minimumCapacity the minimum_capacity value
	 */
	public void setMinimumCapacity (java.lang.String _minimumCapacity) {
		this._minimumCapacity = _minimumCapacity;
	}
	
	
	/**
	 * Return the value associated with the column: iataclass
	 */
	public java.lang.String getIataclass () {
		return _iataclass;
	}
	
	/**
	 * Set the value related to the column: iataclass
	 * @param _iataclass the iataclass value
	 */
	public void setIataclass (java.lang.String _iataclass) {
		this._iataclass = _iataclass;
	}
	
	
	/**
	 * Return the value associated with the column: IndustryClass
	 */
	public java.lang.String getIndustryClass () {
		return _industryClass;
	}
	
	/**
	 * Set the value related to the column: IndustryClass
	 * @param _industryClass the IndustryClass value
	 */
	public void setIndustryClass (java.lang.String _industryClass) {
		this._industryClass = _industryClass;
	}
	
	
	/**
	 * Return the value associated with the column: mfag
	 */
	public java.lang.String getMfag () {
		return _mfag;
	}
	
	/**
	 * Set the value related to the column: mfag
	 * @param _mfag the mfag value
	 */
	public void setMfag (java.lang.String _mfag) {
		this._mfag = _mfag;
	}
	
	
	/**
	 * Return the value associated with the column: maxtemp
	 */
	public java.lang.String getMaxtemp () {
		return _maxtemp;
	}
	
	/**
	 * Set the value related to the column: maxtemp
	 * @param _maxtemp the maxtemp value
	 */
	public void setMaxtemp (java.lang.String _maxtemp) {
		this._maxtemp = _maxtemp;
	}
	
	
	/**
	 * Return the value associated with the column: Emergency3
	 */
	public java.lang.String getEmergency3 () {
		return _emergency3;
	}
	
	/**
	 * Set the value related to the column: Emergency3
	 * @param _emergency3 the Emergency3 value
	 */
	public void setEmergency3 (java.lang.String _emergency3) {
		this._emergency3 = _emergency3;
	}
	
	
	/**
	 * Return the value associated with the column: unno
	 */
	public java.lang.String getUnno () {
		return _unno;
	}
	
	/**
	 * Set the value related to the column: unno
	 * @param _unno the unno value
	 */
	public void setUnno (java.lang.String _unno) {
		this._unno = _unno;
	}
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp9
	 */
	public java.lang.String getEqpidkeyp9 () {
		return _eqpidkeyp9;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp9
	 * @param _eqpidkeyp9 the eqpidkeyp9 value
	 */
	public void setEqpidkeyp9 (java.lang.String _eqpidkeyp9) {
		this._eqpidkeyp9 = _eqpidkeyp9;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp7
	 */
	public java.lang.String getEqpidkeyp7 () {
		return _eqpidkeyp7;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp7
	 * @param _eqpidkeyp7 the eqpidkeyp7 value
	 */
	public void setEqpidkeyp7 (java.lang.String _eqpidkeyp7) {
		this._eqpidkeyp7 = _eqpidkeyp7;
	}
	
	

	
	
	
	/**
	 * Return the value associated with the column: ggvsclass
	 */
	public java.lang.String getGgvsclass () {
		return _ggvsclass;
	}
	
	/**
	 * Set the value related to the column: ggvsclass
	 * @param _ggvsclass the ggvsclass value
	 */
	public void setGgvsclass (java.lang.String _ggvsclass) {
		this._ggvsclass = _ggvsclass;
	}
	
	
	/**
	 * Return the value associated with the column: fleetgrpkey
	 */
	public java.lang.String getFleetgrpkey () {
		return _fleetgrpkey;
	}
	
	/**
	 * Set the value related to the column: fleetgrpkey
	 * @param _fleetgrpkey the fleetgrpkey value
	 */
	public void setFleetgrpkey (java.lang.String _fleetgrpkey) {
		this._fleetgrpkey = _fleetgrpkey;
	}
	
	
	/**
	 * Return the value associated with the column: bottomfill
	 */
	public boolean isBottomfill () {
		return _bottomfill;
	}
	
	/**
	 * Set the value related to the column: bottomfill
	 * @param _bottomfill the bottomfill value
	 */
	public void setBottomfill (boolean _bottomfill) {
		this._bottomfill = _bottomfill;
	}
	
	
	/**
	 * Return the value associated with the column: tramcard
	 */
	public java.lang.String getTramcard () {
		return _tramcard;
	}
	
	/**
	 * Set the value related to the column: tramcard
	 * @param _tramcard the tramcard value
	 */
	public void setTramcard (java.lang.String _tramcard) {
		this._tramcard = _tramcard;
	}
	
	
	/**
	 * Return the value associated with the column: Instructions
	 */
	public java.lang.String getInstructions () {
		return _instructions;
	}
	
	/**
	 * Set the value related to the column: Instructions
	 * @param _instructions the Instructions value
	 */
	public void setInstructions (java.lang.String _instructions) {
		this._instructions = _instructions;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: eqpidkeyp5
	 */
	public java.lang.String getEqpidkeyp5 () {
		return _eqpidkeyp5;
	}
	
	/**
	 * Set the value related to the column: eqpidkeyp5
	 * @param _eqpidkeyp5 the eqpidkeyp5 value
	 */
	public void setEqpidkeyp5 (java.lang.String _eqpidkeyp5) {
		this._eqpidkeyp5 = _eqpidkeyp5;
	}
	
	
	/**
	 * Return the value associated with the column: supplieraddrkey
	 */
	public java.lang.String getSupplieraddrkey () {
		return _supplieraddrkey;
	}
	
	/**
	 * Set the value related to the column: supplieraddrkey
	 * @param _supplieraddrkey the supplieraddrkey value
	 */
	public void setSupplieraddrkey (java.lang.String _supplieraddrkey) {
		this._supplieraddrkey = _supplieraddrkey;
	}
	
	
	/**
	 * Return the value associated with the column: specgrav
	 */
	public java.lang.String getSpecgrav () {
		return _specgrav;
	}
	
	/**
	 * Set the value related to the column: specgrav
	 * @param _specgrav the specgrav value
	 */
	public void setSpecgrav (java.lang.String _specgrav) {
		this._specgrav = _specgrav;
	}
	
	
	/**
	 * Return the value associated with the column: chemname
	 */
	public java.lang.String getChemname () {
		return _chemname;
	}
	
	/**
	 * Set the value related to the column: chemname
	 * @param _chemname the chemname value
	 */
	public void setChemname (java.lang.String _chemname) {
		this._chemname = _chemname;
	}
	
	
	/**
	 * Return the value associated with the column: Email
	 */
	public java.lang.String getEmail () {
		return _email;
	}
	
	/**
	 * Set the value related to the column: Email
	 * @param _email the Email value
	 */
	public void setEmail (java.lang.String _email) {
		this._email = _email;
	}
	
	
	
	/**
	 * Return the value associated with the column: adrref
	 */
	public java.lang.String getAdrref () {
		return _adrref;
	}
	
	/**
	 * Set the value related to the column: adrref
	 * @param _adrref the adrref value
	 */
	public void setAdrref (java.lang.String _adrref) {
		this._adrref = _adrref;
	}
	
	
	/**
	 * Return the value associated with the column: mintemp
	 */
	public java.lang.String getMintemp () {
		return _mintemp;
	}
	
	/**
	 * Set the value related to the column: mintemp
	 * @param _mintemp the mintemp value
	 */
	public void setMintemp (java.lang.String _mintemp) {
		this._mintemp = _mintemp;
	}
	
	

	
	
	/**
	 * Return the value associated with the column: ggvsref
	 */
	public java.lang.String getGgvsref () {
		return _ggvsref;
	}
	
	/**
	 * Set the value related to the column: ggvsref
	 * @param _ggvsref the ggvsref value
	 */
	public void setGgvsref (java.lang.String _ggvsref) {
		this._ggvsref = _ggvsref;
	}
	
	
	/**
	 * Return the value associated with the column: Emergency2
	 */
	public java.lang.String getEmergency2 () {
		return _emergency2;
	}
	
	/**
	 * Set the value related to the column: Emergency2
	 * @param _emergency2 the Emergency2 value
	 */
	public void setEmergency2 (java.lang.String _emergency2) {
		this._emergency2 = _emergency2;
	}
	
	
	/**
	 * Return the value associated with the column: kemmler
	 */
	public java.lang.String getKemmler () {
		return _kemmler;
	}
	
	/**
	 * Set the value related to the column: kemmler
	 * @param _kemmler the kemmler value
	 */
	public void setKemmler (java.lang.String _kemmler) {
		this._kemmler = _kemmler;
	}
	
	

	
	
	/**
	 * Return the value associated with the column: rid
	 */
	public java.lang.String getRid () {
		return _rid;
	}
	
	/**
	 * Set the value related to the column: rid
	 * @param _rid the rid value
	 */
	public void setRid (java.lang.String _rid) {
		this._rid = _rid;
	}
	
	
	
	/**
	 * Return the value associated with the column: hazid
	 */
	public java.lang.String getHazid () {
		return _hazid;
	}

	/**
	 * Set the value related to the column: hazid
	 * @param hazid the hazid value
	 */
	public void setHazid (java.lang.String hazid) {
		this._hazid = hazid;
	}



	/**
	 * Return the value associated with the column: prdid
	 */
	public java.lang.String getPrdid () {
		return _prdid;
	}

	/**
	 * Set the value related to the column: prdid
	 * @param prdid the prdid value
	 */
	public void setPrdid (java.lang.String prdid) {
		this._prdid = prdid;
	}



	/**
	 * Return the value associated with the column: untcode
	 */
	public java.lang.String getUntcode () {
		return _untcode;
	}

	/**
	 * Set the value related to the column: untcode
	 * @param untcode the untcode value
	 */
	public void setUntcode (java.lang.String untcode) {
		this._untcode = untcode;
	}



	/**
	 * Return the value associated with the column: casnumber
	 */
	public java.lang.String getCasnumber () {
		return _casnumber;
	}

	/**
	 * Set the value related to the column: casnumber
	 * @param casnumber the casnumber value
	 */
	public void setCasnumber (java.lang.String casnumber) {
		this._casnumber = casnumber;
	}



	/**
	 * Return the value associated with the column: reachcode
	 */
	public java.lang.String getReachcode () {
		return _reachcode;
	}

	/**
	 * Set the value related to the column: reachcode
	 * @param reachcode the reachcode value
	 */
	public void setReachcode (java.lang.String reachcode) {
		this._reachcode = reachcode;
	}



	/**
	 * Return the value associated with the column: marinepollutant
	 */
	public boolean isMarinepollutant () {
		return _marinepollutant;
	}

	/**
	 * Set the value related to the column: marinepollutant
	 * @param marinepollutant the marinepollutant value
	 */
	public void setMarinepollutant (boolean marinepollutant) {
		this._marinepollutant = marinepollutant;
	}



	/**
	 * Return the value associated with the column: intlharmcode
	 */
	public java.lang.String getIntlharmcode () {
		return _intlharmcode;
	}

	/**
	 * Set the value related to the column: intlharmcode
	 * @param intlharmcode the intlharmcode value
	 */
	public void setIntlharmcode (java.lang.String intlharmcode) {
		this._intlharmcode = intlharmcode;
	}



	/**
	 * Return the value associated with the column: heaterpad
	 */
	public boolean isHeaterpad () {
		return _heaterpad;
	}

	/**
	 * Set the value related to the column: heaterpad
	 * @param heaterpad the heaterpad value
	 */
	public void setHeaterpad (boolean heaterpad) {
		this._heaterpad = heaterpad;
	}



	/**
	 * Return the value associated with the column: gaskets
	 */
	public java.lang.String getGaskets () {
		return _gaskets;
	}

	/**
	 * Set the value related to the column: gaskets
	 * @param gaskets the gaskets value
	 */
	public void setGaskets (java.lang.String gaskets) {
		this._gaskets = gaskets;
	}



	/**
	 * Return the value associated with the column: maxcontacttemp
	 */
	public java.lang.String getMaxcontacttemp () {
		return _maxcontacttemp;
	}

	/**
	 * Set the value related to the column: maxcontacttemp
	 * @param maxcontacttemp the maxcontacttemp value
	 */
	public void setMaxcontacttemp (java.lang.String maxcontacttemp) {
		this._maxcontacttemp = maxcontacttemp;
	}



	/**
	 * Return the value associated with the column: imdgsc1
	 */
	public java.lang.String getImdgsc1 () {
		return _imdgsc1;
	}

	/**
	 * Set the value related to the column: imdgsc1
	 * @param imdgsc1 the imdgsc1 value
	 */
	public void setImdgsc1 (java.lang.String imdgsc1) {
		this._imdgsc1 = imdgsc1;
	}



	/**
	 * Return the value associated with the column: imdgsc2
	 */
	public java.lang.String getImdgsc2 () {
		return _imdgsc2;
	}

	/**
	 * Set the value related to the column: imdgsc2
	 * @param imdgsc2 the imdgsc2 value
	 */
	public void setImdgsc2 (java.lang.String imdgsc2) {
		this._imdgsc2 = imdgsc2;
	}



	/**
	 * Return the value associated with the column: imdglabel
	 */
	public java.lang.String getImdglabel () {
		return _imdglabel;
	}

	/**
	 * Set the value related to the column: imdglabel
	 * @param imdglabel the imdglabel value
	 */
	public void setImdglabel (java.lang.String imdglabel) {
		this._imdglabel = imdglabel;
	}



	/**
	 * Return the value associated with the column: ems1
	 */
	public java.lang.String getEms1 () {
		return _ems1;
	}

	/**
	 * Set the value related to the column: ems1
	 * @param ems1 the ems1 value
	 */
	public void setEms1 (java.lang.String ems1) {
		this._ems1 = ems1;
	}



	/**
	 * Return the value associated with the column: ems2
	 */
	public java.lang.String getEms2 () {
		return _ems2;
	}

	/**
	 * Set the value related to the column: ems2
	 * @param ems2 the ems2 value
	 */
	public void setEms2 (java.lang.String ems2) {
		this._ems2 = ems2;
	}



	/**
	 * Return the value associated with the column: ems3
	 */
	public java.lang.String getEms3 () {
		return _ems3;
	}

	/**
	 * Set the value related to the column: ems3
	 * @param ems3 the ems3 value
	 */
	public void setEms3 (java.lang.String ems3) {
		this._ems3 = ems3;
	}



	/**
	 * Return the value associated with the column: ems4
	 */
	public java.lang.String getEms4 () {
		return _ems4;
	}

	/**
	 * Set the value related to the column: ems4
	 * @param ems4 the ems4 value
	 */
	public void setEms4 (java.lang.String ems4) {
		this._ems4 = ems4;
	}



	/**
	 * Return the value associated with the column: dot51only
	 */
	public boolean isDot51only () {
		return _dot51only;
	}

	/**
	 * Set the value related to the column: dot51only
	 * @param dot51only the dot51only value
	 */
	public void setDot51only (boolean dot51only) {
		this._dot51only = dot51only;
	}



	/**
	 * Return the value associated with the column: nacode1
	 */
	public java.lang.String getNacode1 () {
		return _nacode1;
	}

	/**
	 * Set the value related to the column: nacode1
	 * @param nacode1 the nacode1 value
	 */
	public void setNacode1 (java.lang.String nacode1) {
		this._nacode1 = nacode1;
	}



	/**
	 * Return the value associated with the column: nacode2
	 */
	public java.lang.String getNacode2 () {
		return _nacode2;
	}

	/**
	 * Set the value related to the column: nacode2
	 * @param nacode2 the nacode2 value
	 */
	public void setNacode2 (java.lang.String nacode2) {
		this._nacode2 = nacode2;
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








	
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;
		
		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
		//200900019
		addErrorIfBlank(errors, "productkey", _productkey, "error.code.required");
		addErrorIfBlank(errors, "tradname", _tradname, "error.name.required");
		
		if (_action.equals("Create")) {
			if (Util.invalidChars(this._productkey)) errors.add("productkey", new ActionMessage("error.code.invalidchars"));
		}
		
		return errors;
		
	}
	
	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}
	
	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
