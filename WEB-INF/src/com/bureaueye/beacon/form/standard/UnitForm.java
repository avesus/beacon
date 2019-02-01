package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.util.Util;



public final class UnitForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _unitId;

	
	// fields
	private java.lang.String _eqpkeyp5;
	
	//private Address _mgraddrkey = new Address();
	
	private java.lang.String _tdesmaxf = "0.0";
	private java.lang.String _imokey;
	private java.lang.String _lsttype;
	private java.lang.String _eqpkeyp4;
	private java.lang.String _disposalnotes;
	private java.lang.String _lengthf = "0";
	private java.lang.String _thleak = "0";
	private boolean _writeoffflag;
	private java.lang.String _tmdmax = "0.0";
	private java.lang.String _rvalvac = "0.0";
	private java.lang.String _ssurarap = "0.0";
	private java.lang.String _ssurara = "0.0";
	private java.lang.String _eqpkey;
	private java.lang.String _g3key;
	private boolean _xinactive;
	private java.lang.String _tbwork = "0.0";
	private java.lang.String _capusg = "0";
	private java.lang.String _g4key;
	private java.lang.String _heighti = "0";
	private java.lang.String _lengthi = "0";
	private boolean _foodgrad;
	private boolean _ukdot;
	private boolean _csc;
	private java.lang.String _matrils;
	private java.lang.String _width = "0";
	private boolean _adr;
	private java.lang.String _tmdmin = "0.0";
	private java.lang.String _tdesmin = "0.0";
	private boolean _dir;
	private java.lang.String _rvalprsp = "0.0";
	private java.lang.String _tmaxcar = "0.0";
	private java.lang.String _tmaxcarf = "0.0";
	private java.lang.String _g2key;
	private java.lang.String _widthi = "0";
	private java.lang.String _tbtest = "0.0";
	private java.lang.String _teucount = "0";
	private java.lang.String _framtyp;
	private java.lang.String _mfnum;
	private java.lang.String _tranfro = "0.0";
	private java.lang.String _eqpkeyp9;
	private java.lang.String _topspoolno;
	private java.lang.String _tkworkp = "0.0";
	private java.lang.String _eqpkeyp10;
	private java.lang.String _shthick = "0.0";
	private java.lang.String _tktestp = "0.0";
	private java.lang.String _tdesminf = "0.0";
	private java.lang.String _stackno = "0";
	private java.lang.String _tktest = "0.0";
	private boolean _dot51;
	private java.lang.String _eqpkeyp7;
	private java.lang.String _payloadl = "0";
	private java.lang.String _ownerkey;
	private java.lang.String _moveproductkey;
	private java.lang.String _moveaddrkey;
	
	//private Address _mfaddrkey = new Address();
	
	private java.lang.String _mfdatedd;
	private java.lang.String _mfdatemm;
	private java.lang.String _mfdateyyyy;
	
	private java.lang.String _payload = "0";
	private java.lang.String _unitkey;
	private boolean _imo;
	private java.lang.String _capcfee;
	private java.lang.String _eqpkeyp8;
	private java.lang.String _tbtestp = "0.0";
	private boolean _tir;
	private boolean _usdot;
	private java.lang.String _eqpkeyp6;
	private boolean _att;

	private java.lang.String _unittcode;
	private java.lang.String _tkwork = "0.0";
	private java.lang.String _tranto = "0.0";
	private java.lang.String _stackw = "0";
	private java.lang.String _tare = "0";
	private java.lang.String _companykey;
	private java.lang.String _grossl = "0";
	private java.lang.String _shdepms = "0.0";
	private java.lang.String _tdesmax = "0.0";
	private java.lang.String _movemsgtxt;
	private java.lang.String _length = "0";
	private boolean _un;
	private boolean _jfa;
	private java.lang.String _shdepss = "0.0";


	private String _manuflocationkey;
	
	
	private java.lang.String _movedatedd;
	private java.lang.String _movedatemm;
	private java.lang.String _movedateyyyy;
	private java.lang.String _movetimehh;
	private java.lang.String _movetimemm;

	private String _movelocationkey;
	private java.lang.String _movests;	
	private java.lang.String _moveref;
	
	
	private java.lang.String _jobmovvessel;	
	private java.lang.String _jobmovdatedd;
	private java.lang.String _jobmovdatemm;
	private java.lang.String _jobmovdateyyyy;
	private java.lang.String _jobmovtimehh;
	private java.lang.String _jobmovtimemm;

	private String _jobmovlocationkey;
	private java.lang.String _invsts;	
	private java.lang.String _jobmovref;
	
	
	private java.lang.String _laststat;
	private java.lang.String _capimpg = "0";
	private java.lang.String _tbworkp = "0.0";
	private boolean _rid;
	private java.lang.String _gritfin;
	private boolean _aar;
	private java.lang.String _mfprice = "0.0";
	private java.lang.String _widthf = "0";
	private java.lang.String _tmdminf = "0.0";
	private java.lang.String _tmdmaxf = "0.0";
	private java.lang.String _gross = "0";
	private java.lang.String _rvalprs = "0.0";
	private java.lang.String _headmat;
	private boolean _deleted;
	private boolean _uic;
	private boolean _bam;
	private java.lang.String _framdes;
	private java.lang.String _eqpkeyp1;
	private java.lang.String _allocnumber = "0";
	private boolean _ctc;
	private boolean _asme;
	private java.lang.String _dmthick = "0.0";
	private java.lang.String _tarel = "0";
	private java.lang.String _heightf = "0";
	private java.lang.String _eqpkeyp2;
	

	
	private java.lang.String _g1key;
	private java.lang.String _mfcde;
	private java.lang.String _eqpkeyp3;
	private java.lang.String _height = "0";
	private java.lang.String _writeoffreason;
	private java.lang.String _capcm = "0";
	private java.lang.String _caplit = "0";
	private java.lang.String _intermgracceptid;
	private java.lang.String _pokey;
	private java.lang.String _rvalvacp = "0.0";
	private java.lang.String _altiso;
	
	
	private java.lang.String _disposaldatedd;
	private java.lang.String _disposaldatemm;
	private java.lang.String _disposaldateyyyy;	
	
	private java.lang.String _maxtrips = "0";
	private java.lang.String _activitykey;


	private java.lang.String _certificatedirectory;
	private java.lang.String _certificatepath;
	
	// collections
	private List _certificates;

	
	public String getCertificatepath() {return _certificatepath;}
	public void setCertificatepath(String _certificatepath) {this._certificatepath = _certificatepath;}	
	
	public String getCertificatedirectory() {return _certificatedirectory;}
	public void setCertificatedirectory(String _certificatedirectory) {this._certificatedirectory = _certificatedirectory;}	
	
	public void setCertificates() {
		_certificates = new LinkedList();
	    if (this._certificatepath != null && this._certificatedirectory != null) {	
	    	
	    	 java.io.File directory = new java.io.File(this._certificatedirectory);
	    	 java.lang.String[] dirContents = directory.list();
	    	 
	    	 int arraySize = 0;
	    	 java.lang.String dirContentString = "";
	    	 
	    	 try  {	    		 
	    	    while (dirContentString != null)  {
	    	       dirContentString = dirContents[arraySize++];
					if (this._unitkey.toUpperCase().substring(0,10)
	    					 .equals(dirContentString.substring(0,10).toUpperCase())) {
	    				 _certificates.add(dirContentString);
	    			 }
	    	    }
	    	 } catch (java.lang.ArrayIndexOutOfBoundsException e) {
	    	        arraySize = arraySize - 1;
	    	 }
	    }
	}
	public List getCertificates() {return _certificates;}	 

	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	

	/**
	 */
	public java.lang.String getUnitId () {return _unitId;}

	/**
	 */
	public void setUnitId (java.lang.String _unitId) {this._unitId = _unitId;}



	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return _eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param _eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String _eqpkeyp5) {
		this._eqpkeyp5 = _eqpkeyp5;
	}



/*	*//**
	 * Return the value associated with the column: mgraddrkey
	 *//*
	public Address getMgraddrkey () {
		return _mgraddrkey;
	}

	*//**
	 * Set the value related to the column: mgraddrkey
	 * @param _mgraddrkey the mgraddrkey value
	 *//*
	public void setMgraddrkey (Address _mgraddrkey) {
		this._mgraddrkey = _mgraddrkey;
	}*/






	/**
	 * Return the value associated with the column: tdesmaxf
	 */
	public java.lang.String getTdesmaxf () {
		return _tdesmaxf;
	}

	/**
	 * Set the value related to the column: tdesmaxf
	 * @param _tdesmaxf the tdesmaxf value
	 */
	public void setTdesmaxf (java.lang.String _tdesmaxf) {
		this._tdesmaxf = _tdesmaxf;
	}


	/**
	 * Return the value associated with the column: imokey
	 */
	public java.lang.String getImokey () {
		return _imokey;
	}

	/**
	 * Set the value related to the column: imokey
	 * @param _imokey the imokey value
	 */
	public void setImokey (java.lang.String _imokey) {
		this._imokey = _imokey;
	}


	/**
	 * Return the value associated with the column: movevessel
	 */
	public java.lang.String getJobmovvessel() {return _jobmovvessel;}
	/**
	 * Set the value related to the column: movevessel
	 */
	public void setJobmovvessel (java.lang.String _jobmovvessel) {this._jobmovvessel = _jobmovvessel;
	}
	

	

	/**
	 * Return the value associated with the column: lsttype
	 */
	public java.lang.String getLsttype () {
		return _lsttype;
	}

	/**
	 * Set the value related to the column: lsttype
	 * @param _lsttype the lsttype value
	 */
	public void setLsttype (java.lang.String _lsttype) {
		this._lsttype = _lsttype;
	}




	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return _eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param _eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String _eqpkeyp4) {
		this._eqpkeyp4 = _eqpkeyp4;
	}





	/**
	 * Return the value associated with the column: disposalnotes
	 */
	public java.lang.String getDisposalnotes () {
		return _disposalnotes;
	}

	/**
	 * Set the value related to the column: disposalnotes
	 * @param _disposalnotes the disposalnotes value
	 */
	public void setDisposalnotes (java.lang.String _disposalnotes) {
		this._disposalnotes = _disposalnotes;
	}


	/**
	 * Return the value associated with the column: lengthf
	 */
	public java.lang.String getLengthf () {
		return _lengthf;
	}

	/**
	 * Set the value related to the column: lengthf
	 * @param _lengthf the lengthf value
	 */
	public void setLengthf (java.lang.String _lengthf) {
		this._lengthf = _lengthf;
	}





	/**
	 * Return the value associated with the column: thleak
	 */
	public java.lang.String getThleak () {
		return _thleak;
	}

	/**
	 * Set the value related to the column: thleak
	 * @param _thleak the thleak value
	 */
	public void setThleak (java.lang.String _thleak) {
		this._thleak = _thleak;
	}


	/**
	 * Return the value associated with the column: writeoffflag
	 */
	public boolean isWriteoffflag () {
		return _writeoffflag;
	}

	/**
	 * Set the value related to the column: writeoffflag
	 * @param _writeoffflag the writeoffflag value
	 */
	public void setWriteoffflag (boolean _writeoffflag) {
		this._writeoffflag = _writeoffflag;
	}


	/**
	 * Return the value associated with the column: tmdmax
	 */
	public java.lang.String getTmdmax () {
		return _tmdmax;
	}

	/**
	 * Set the value related to the column: tmdmax
	 * @param _tmdmax the tmdmax value
	 */
	public void setTmdmax (java.lang.String _tmdmax) {
		this._tmdmax = _tmdmax;
	}


	/**
	 * Return the value associated with the column: rvalvac
	 */
	public java.lang.String getRvalvac () {
		return _rvalvac;
	}

	/**
	 * Set the value related to the column: rvalvac
	 * @param _rvalvac the rvalvac value
	 */
	public void setRvalvac (java.lang.String _rvalvac) {
		this._rvalvac = _rvalvac;
	}


	/**
	 * Return the value associated with the column: ssurarap
	 */
	public java.lang.String getSsurarap () {
		return _ssurarap;
	}

	/**
	 * Set the value related to the column: ssurarap
	 * @param _ssurarap the ssurarap value
	 */
	public void setSsurarap (java.lang.String _ssurarap) {
		this._ssurarap = _ssurarap;
	}




	/**
	 * Return the value associated with the column: ssurara
	 */
	public java.lang.String getSsurara () {
		return _ssurara;
	}

	/**
	 * Set the value related to the column: ssurara
	 * @param _ssurara the ssurara value
	 */
	public void setSsurara (java.lang.String _ssurara) {
		this._ssurara = _ssurara;
	}




	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return _eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param _eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String _eqpkey) {
		this._eqpkey = _eqpkey;
	}


	/**
	 * Return the value associated with the column: g3key
	 */
	public java.lang.String getG3key () {
		return _g3key;
	}

	/**
	 * Set the value related to the column: g3key
	 * @param _g3key the g3key value
	 */
	public void setG3key (java.lang.String _g3key) {
		this._g3key = _g3key;
	}


	/**
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return _xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param _xinactive the xinactive value
	 */
	public void setXinactive (boolean _xinactive) {
		this._xinactive = _xinactive;
	}


	/**
	 * Return the value associated with the column: tbwork
	 */
	public java.lang.String getTbwork () {
		return _tbwork;
	}

	/**
	 * Set the value related to the column: tbwork
	 * @param _tbwork the tbwork value
	 */
	public void setTbwork (java.lang.String _tbwork) {
		this._tbwork = _tbwork;
	}



	/**
	 * Return the value associated with the column: capusg
	 */
	public java.lang.String getCapusg () {
		return _capusg;
	}

	/**
	 * Set the value related to the column: capusg
	 * @param _capusg the capusg value
	 */
	public void setCapusg (java.lang.String _capusg) {
		this._capusg = _capusg;
	}


	/**
	 * Return the value associated with the column: g4key
	 */
	public java.lang.String getG4key () {
		return _g4key;
	}

	/**
	 * Set the value related to the column: g4key
	 * @param _g4key the g4key value
	 */
	public void setG4key (java.lang.String _g4key) {
		this._g4key = _g4key;
	}


	/**
	 * Return the value associated with the column: heighti
	 */
	public java.lang.String getHeighti () {
		return _heighti;
	}

	/**
	 * Set the value related to the column: heighti
	 * @param _heighti the heighti value
	 */
	public void setHeighti (java.lang.String _heighti) {
		this._heighti = _heighti;
	}





	/**
	 * Return the value associated with the column: lengthi
	 */
	public java.lang.String getLengthi () {
		return _lengthi;
	}

	/**
	 * Set the value related to the column: lengthi
	 * @param _lengthi the lengthi value
	 */
	public void setLengthi (java.lang.String _lengthi) {
		this._lengthi = _lengthi;
	}


	/**
	 * Return the value associated with the column: foodgrad
	 */
	public boolean isFoodgrad () {
		return _foodgrad;
	}

	/**
	 * Set the value related to the column: foodgrad
	 * @param _foodgrad the foodgrad value
	 */
	public void setFoodgrad (boolean _foodgrad) {
		this._foodgrad = _foodgrad;
	}


	/**
	 * Return the value associated with the column: ukdot
	 */
	public boolean isUkdot () {
		return _ukdot;
	}

	/**
	 * Set the value related to the column: ukdot
	 * @param _ukdot the ukdot value
	 */
	public void setUkdot (boolean _ukdot) {
		this._ukdot = _ukdot;
	}




	/**
	 * Return the value associated with the column: csc
	 */
	public boolean isCsc () {
		return _csc;
	}

	/**
	 * Set the value related to the column: csc
	 * @param _csc the csc value
	 */
	public void setCsc (boolean _csc) {
		this._csc = _csc;
	}


	/**
	 * Return the value associated with the column: matrils
	 */
	public java.lang.String getMatrils () {
		return _matrils;
	}

	/**
	 * Set the value related to the column: matrils
	 * @param _matrils the matrils value
	 */
	public void setMatrils (java.lang.String _matrils) {
		this._matrils = _matrils;
	}


	/**
	 * Return the value associated with the column: width
	 */
	public java.lang.String getWidth () {
		return _width;
	}

	/**
	 * Set the value related to the column: width
	 * @param _width the width value
	 */
	public void setWidth (java.lang.String _width) {
		this._width = _width;
	}


	/**
	 * Return the value associated with the column: adr
	 */
	public boolean isAdr () {
		return _adr;
	}

	/**
	 * Set the value related to the column: adr
	 * @param _adr the adr value
	 */
	public void setAdr (boolean _adr) {
		this._adr = _adr;
	}


	/**
	 * Return the value associated with the column: tmdmin
	 */
	public java.lang.String getTmdmin () {
		return _tmdmin;
	}

	/**
	 * Set the value related to the column: tmdmin
	 * @param _tmdmin the tmdmin value
	 */
	public void setTmdmin (java.lang.String _tmdmin) {
		this._tmdmin = _tmdmin;
	}


	/**
	 * Return the value associated with the column: tdesmin
	 */
	public java.lang.String getTdesmin () {
		return _tdesmin;
	}

	/**
	 * Set the value related to the column: tdesmin
	 * @param _tdesmin the tdesmin value
	 */
	public void setTdesmin (java.lang.String _tdesmin) {
		this._tdesmin = _tdesmin;
	}




	/**
	 * Return the value associated with the column: dir
	 */
	public boolean isDir () {
		return _dir;
	}

	/**
	 * Set the value related to the column: dir
	 * @param _dir the dir value
	 */
	public void setDir (boolean _dir) {
		this._dir = _dir;
	}


	/**
	 * Return the value associated with the column: rvalprsp
	 */
	public java.lang.String getRvalprsp () {
		return _rvalprsp;
	}

	/**
	 * Set the value related to the column: rvalprsp
	 * @param _rvalprsp the rvalprsp value
	 */
	public void setRvalprsp (java.lang.String _rvalprsp) {
		this._rvalprsp = _rvalprsp;
	}




	/**
	 * Return the value associated with the column: tmaxcar
	 */
	public java.lang.String getTmaxcar () {
		return _tmaxcar;
	}

	/**
	 * Set the value related to the column: tmaxcar
	 * @param _tmaxcar the tmaxcar value
	 */
	public void setTmaxcar (java.lang.String _tmaxcar) {
		this._tmaxcar = _tmaxcar;
	}




	/**
	 * Return the value associated with the column: tmaxcarf
	 */
	public java.lang.String getTmaxcarf () {
		return _tmaxcarf;
	}

	/**
	 * Set the value related to the column: tmaxcarf
	 * @param _tmaxcarf the tmaxcarf value
	 */
	public void setTmaxcarf (java.lang.String _tmaxcarf) {
		this._tmaxcarf = _tmaxcarf;
	}


	/**
	 * Return the value associated with the column: g2key
	 */
	public java.lang.String getG2key () {
		return _g2key;
	}

	/**
	 * Set the value related to the column: g2key
	 * @param _g2key the g2key value
	 */
	public void setG2key (java.lang.String _g2key) {
		this._g2key = _g2key;
	}





	/**
	 * Return the value associated with the column: widthi
	 */
	public java.lang.String getWidthi () {
		return _widthi;
	}

	/**
	 * Set the value related to the column: widthi
	 * @param _widthi the widthi value
	 */
	public void setWidthi (java.lang.String _widthi) {
		this._widthi = _widthi;
	}





	/**
	 * Return the value associated with the column: tbtest
	 */
	public java.lang.String getTbtest () {
		return _tbtest;
	}

	/**
	 * Set the value related to the column: tbtest
	 * @param _tbtest the tbtest value
	 */
	public void setTbtest (java.lang.String _tbtest) {
		this._tbtest = _tbtest;
	}




	/**
	 * Return the value associated with the column: teucount
	 */
	public java.lang.String getTeucount () {
		return _teucount;
	}

	/**
	 * Set the value related to the column: teucount
	 * @param _teucount the teucount value
	 */
	public void setTeucount (java.lang.String _teucount) {
		this._teucount = _teucount;
	}


	/**
	 * Return the value associated with the column: framtyp
	 */
	public java.lang.String getFramtyp () {
		return _framtyp;
	}

	/**
	 * Set the value related to the column: framtyp
	 * @param _framtyp the framtyp value
	 */
	public void setFramtyp (java.lang.String _framtyp) {
		this._framtyp = _framtyp;
	}





	/**
	 * Return the value associated with the column: mfnum
	 */
	public java.lang.String getMfnum () {
		return _mfnum;
	}

	/**
	 * Set the value related to the column: mfnum
	 * @param _mfnum the mfnum value
	 */
	public void setMfnum (java.lang.String _mfnum) {
		this._mfnum = _mfnum;
	}


	/**
	 * Return the value associated with the column: tranfro
	 */
	public java.lang.String getTranfro () {
		return _tranfro;
	}

	/**
	 * Set the value related to the column: tranfro
	 * @param _tranfro the tranfro value
	 */
	public void setTranfro (java.lang.String _tranfro) {
		this._tranfro = _tranfro;
	}




	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return _eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param _eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String _eqpkeyp9) {
		this._eqpkeyp9 = _eqpkeyp9;
	}






	/**
	 * Return the value associated with the column: topspoolno
	 */
	public java.lang.String getTopspoolno () {
		return _topspoolno;
	}

	/**
	 * Set the value related to the column: topspoolno
	 * @param _topspoolno the topspoolno value
	 */
	public void setTopspoolno (java.lang.String _topspoolno) {
		this._topspoolno = _topspoolno;
	}


	/**
	 * Return the value associated with the column: tkworkp
	 */
	public java.lang.String getTkworkp () {
		return _tkworkp;
	}

	/**
	 * Set the value related to the column: tkworkp
	 * @param _tkworkp the tkworkp value
	 */
	public void setTkworkp (java.lang.String _tkworkp) {
		this._tkworkp = _tkworkp;
	}





	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return _eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param _eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String _eqpkeyp10) {
		this._eqpkeyp10 = _eqpkeyp10;
	}





	/**
	 * Return the value associated with the column: shthick
	 */
	public java.lang.String getShthick () {
		return _shthick;
	}

	/**
	 * Set the value related to the column: shthick
	 * @param _shthick the shthick value
	 */
	public void setShthick (java.lang.String _shthick) {
		this._shthick = _shthick;
	}


	/**
	 * Return the value associated with the column: tktestp
	 */
	public java.lang.String getTktestp () {
		return _tktestp;
	}

	/**
	 * Set the value related to the column: tktestp
	 * @param _tktestp the tktestp value
	 */
	public void setTktestp (java.lang.String _tktestp) {
		this._tktestp = _tktestp;
	}



	/**
	 * Return the value associated with the column: tdesminf
	 */
	public java.lang.String getTdesminf () {
		return _tdesminf;
	}

	/**
	 * Set the value related to the column: tdesminf
	 * @param _tdesminf the tdesminf value
	 */
	public void setTdesminf (java.lang.String _tdesminf) {
		this._tdesminf = _tdesminf;
	}


	/**
	 * Return the value associated with the column: stackno
	 */
	public java.lang.String getStackno () {
		return _stackno;
	}

	/**
	 * Set the value related to the column: stackno
	 * @param _stackno the stackno value
	 */
	public void setStackno (java.lang.String _stackno) {
		this._stackno = _stackno;
	}





	/**
	 * Return the value associated with the column: tktest
	 */
	public java.lang.String getTktest () {
		return _tktest;
	}

	/**
	 * Set the value related to the column: tktest
	 * @param _tktest the tktest value
	 */
	public void setTktest (java.lang.String _tktest) {
		this._tktest = _tktest;
	}


	/**
	 * Return the value associated with the column: jobmovref
	 */
	public java.lang.String getJobmovref () {
		return _jobmovref;
	}

	/**
	 * Set the value related to the column: _jobmovref
	 * @param __jobmovref the _jobmovref value
	 */
	public void setJobmovref (java.lang.String _jobmovref) {
		this._jobmovref = _jobmovref;
	}
	
	

	/**
	 * Return the value associated with the column: moveref
	 */
	public java.lang.String getMoveref () {
		return _moveref;
	}

	/**
	 * Set the value related to the column: moveref
	 * @param _moveref the moveref value
	 */
	public void setMoveref (java.lang.String _moveref) {
		this._moveref = _moveref;
	}




	/**
	 * Return the value associated with the column: dot51
	 */
	public boolean isDot51 () {
		return _dot51;
	}

	/**
	 * Set the value related to the column: dot51
	 * @param _dot51 the dot51 value
	 */
	public void setDot51 (boolean _dot51) {
		this._dot51 = _dot51;
	}


	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return _eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param _eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String _eqpkeyp7) {
		this._eqpkeyp7 = _eqpkeyp7;
	}


	/**
	 * Return the value associated with the column: payloadl
	 */
	public java.lang.String getPayloadl () {
		return _payloadl;
	}

	/**
	 * Set the value related to the column: payloadl
	 * @param _payloadl the payloadl value
	 */
	public void setPayloadl (java.lang.String _payloadl) {
		this._payloadl = _payloadl;
	}


	/**
	 * Return the value associated with the column: ownerkey
	 */
	public java.lang.String getOwnerkey () {
		return _ownerkey;
	}

	/**
	 * Set the value related to the column: ownerkey
	 * @param _ownerkey the ownerkey value
	 */
	public void setOwnerkey (java.lang.String _ownerkey) {
		this._ownerkey = _ownerkey;
	}


	/**
	 * Return the value associated with the column: moveproductkey
	 */
	public java.lang.String getMoveproductkey () {
		return _moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param _moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String _moveproductkey) {
		this._moveproductkey = _moveproductkey;
	}




/*	*//**
	 * Return the value associated with the column: mfaddrkey
	 *//*
	public Address getMfaddrkey () {
		return _mfaddrkey;
	}

	*//**
	 * Set the value related to the column: mfaddrkey
	 * @param _mfaddrkey the mfaddrkey value
	 *//*
	public void setMfaddrkey (Address _mfaddrkey) {
		this._mfaddrkey = _mfaddrkey;
	}*/


	public Date getMfdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getMfdateyyyy()), Integer
						.parseInt(getMfdatemm()) - 1, Integer
						.parseInt(getMfdatedd()));
		return c.getTime();
	}
	public void setMfdate(Date _mfdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(_mfdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setMfdateyyyy(c.get(Calendar.YEAR) + "");
		setMfdatemm((month < 10 ? "0" : "") + month);
		setMfdatedd((day < 10 ? "0" : "") + day);
	}
	public String getMfdatedd () {return _mfdatedd;}
	public void setMfdatedd (String _mfdatedd) {this._mfdatedd = _mfdatedd;}
	public String getMfdatemm () {return _mfdatemm;}
	public void setMfdatemm (String _mfdatemm) {this._mfdatemm = _mfdatemm;}
	public String getMfdateyyyy () {return _mfdateyyyy;}
	public void setMfdateyyyy (String _mfdateyyyy) {this._mfdateyyyy = _mfdateyyyy;}


	public Date getDisposaldate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDisposaldateyyyy()), Integer
						.parseInt(getDisposaldatemm()) - 1, Integer
						.parseInt(getDisposaldatedd()));
		return c.getTime();
		} catch (Exception e) { return null; }
	}
	public void setDisposaldate(Date _disposaldate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_disposaldate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDisposaldateyyyy(c.get(Calendar.YEAR) + "");
		setDisposaldatemm((month < 10 ? "0" : "") + month);
		setDisposaldatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setDisposaldateyyyy("0000");
		setDisposaldatemm("00");
		setDisposaldatedd("00");			
	}
	}
	public String getDisposaldatedd () {return _disposaldatedd;}
	public void setDisposaldatedd (String _disposaldatedd) {this._disposaldatedd = _disposaldatedd;}
	public String getDisposaldatemm () {return _disposaldatemm;}
	public void setDisposaldatemm (String _disposaldatemm) {this._disposaldatemm = _disposaldatemm;}
	public String getDisposaldateyyyy () {return _disposaldateyyyy;}
	public void setDisposaldateyyyy (String _disposaldateyyyy) {this._disposaldateyyyy = _disposaldateyyyy;}

	
	public Date getMovedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getMovedateyyyy()), Integer
						.parseInt(getMovedatemm()) - 1, Integer
						.parseInt(getMovedatedd()));
		return c.getTime();
	} catch(Exception e) { return null; }
	}
	public void setMovedate(Date _movedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_movedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setMovedateyyyy(c.get(Calendar.YEAR) + "");
		setMovedatemm((month < 10 ? "0" : "") + month);
		setMovedatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setMovedateyyyy("0000");
		setMovedatemm("00");
		setMovedatedd("00");			
	}		
	}
	public String getMovedatedd () {return _movedatedd;}
	public void setMovedatedd (String _movedatedd) {this._movedatedd = _movedatedd;}
	public String getMovedatemm () {return _movedatemm;}
	public void setMovedatemm (String _movedatemm) {this._movedatemm = _movedatemm;}
	public String getMovedateyyyy () {return _movedateyyyy;}
	public void setMovedateyyyy (String _movedateyyyy) {this._movedateyyyy = _movedateyyyy;}

	public String getMovetime() {
		try {
		String time = getMovetimehh()+":"+getMovetimemm();
		return time;
	} catch(Exception e) { return "00:00"; }
	}
	public void setMovetime(String _movetime) {
		try {
		String hh = "00";
		try{hh = _movetime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = _movetime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setMovetimehh(hh);
		setMovetimemm(mm);
	} catch (Exception e) {
		setMovetimehh("00");
		setMovetimemm("00");			
	}
	}
	public String getMovetimehh () {return _movetimehh;}
	public void setMovetimehh (String _movetimehh) {this._movetimehh = _movetimehh;}
	public String getMovetimemm () {return _movetimemm;}
	public void setMovetimemm (String _movetimemm) {this._movetimemm = _movetimemm;}

	

	
	public Date getJobmovdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getJobmovdateyyyy()), Integer
						.parseInt(getJobmovdatemm()) - 1, Integer
						.parseInt(getJobmovdatedd()));
		return c.getTime();
	} catch(Exception e) { return null; }
	}
	public void setJobmovdate(Date _jobmovdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_jobmovdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setJobmovdateyyyy(c.get(Calendar.YEAR) + "");
		setJobmovdatemm((month < 10 ? "0" : "") + month);
		setJobmovdatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setJobmovdateyyyy("0000");
		setJobmovdatemm("00");
		setJobmovdatedd("00");			
	}		
	}
	public String getJobmovdatedd () {return _jobmovdatedd;}
	public void setJobmovdatedd (String _jobmovdatedd) {this._jobmovdatedd = _jobmovdatedd;}
	public String getJobmovdatemm () {return _jobmovdatemm;}
	public void setJobmovdatemm (String _jobmovdatemm) {this._jobmovdatemm = _jobmovdatemm;}
	public String getJobmovdateyyyy () {return _jobmovdateyyyy;}
	public void setJobmovdateyyyy (String _jobmovdateyyyy) {this._jobmovdateyyyy = _jobmovdateyyyy;}

	public String getJobmovtime() {
		try {
		String time = getJobmovtimehh()+":"+getJobmovtimemm();
		return time;
	} catch(Exception e) { return "00:00"; }
	}
	public void setJobmovtime(String _jobmovtime) {
		try {
		String hh = "00";
		try{hh = _jobmovtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = _jobmovtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setJobmovtimehh(hh);
		setJobmovtimemm(mm);
	} catch (Exception e) {
		setJobmovtimehh("00");
		setJobmovtimemm("00");			
	}
	}
	public String getJobmovtimehh () {return _jobmovtimehh;}
	public void setJobmovtimehh (String _jobmovtimehh) {this._jobmovtimehh = _jobmovtimehh;}
	public String getJobmovtimemm () {return _jobmovtimemm;}
	public void setJobmovtimemm (String _jobmovtimemm) {this._jobmovtimemm = _jobmovtimemm;}

	
	
	

	/**
	 * Return the value associated with the column: payload
	 */
	public java.lang.String getPayload () {
		return _payload;
	}

	/**
	 * Set the value related to the column: payload
	 * @param _payload the payload value
	 */
	public void setPayload (java.lang.String _payload) {
		this._payload = _payload;
	}


	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param _unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}


	/**
	 * Return the value associated with the column: imo
	 */
	public boolean isImo () {
		return _imo;
	}

	/**
	 * Set the value related to the column: imo
	 * @param _imo the imo value
	 */
	public void setImo (boolean _imo) {
		this._imo = _imo;
	}



	/**
	 * Return the value associated with the column: capcfee
	 */
	public java.lang.String getCapcfee () {
		return _capcfee;
	}

	/**
	 * Set the value related to the column: capcfee
	 * @param _capcfee the capcfee value
	 */
	public void setCapcfee (java.lang.String _capcfee) {
		this._capcfee = _capcfee;
	}


	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return _eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param _eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String _eqpkeyp8) {
		this._eqpkeyp8 = _eqpkeyp8;
	}




	/**
	 * Return the value associated with the column: tbtestp
	 */
	public java.lang.String getTbtestp () {
		return _tbtestp;
	}

	/**
	 * Set the value related to the column: tbtestp
	 * @param _tbtestp the tbtestp value
	 */
	public void setTbtestp (java.lang.String _tbtestp) {
		this._tbtestp = _tbtestp;
	}


	/**
	 * Return the value associated with the column: tir
	 */
	public boolean isTir () {
		return _tir;
	}

	/**
	 * Set the value related to the column: tir
	 * @param _tir the tir value
	 */
	public void setTir (boolean _tir) {
		this._tir = _tir;
	}


	/**
	 * Return the value associated with the column: usdot
	 */
	public boolean isUsdot () {
		return _usdot;
	}

	/**
	 * Set the value related to the column: usdot
	 * @param _usdot the usdot value
	 */
	public void setUsdot (boolean _usdot) {
		this._usdot = _usdot;
	}


	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return _eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param _eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String _eqpkeyp6) {
		this._eqpkeyp6 = _eqpkeyp6;
	}




	/**
	 * Return the value associated with the column: att
	 */
	public boolean isAtt () {
		return _att;
	}

	/**
	 * Set the value related to the column: att
	 * @param _att the att value
	 */
	public void setAtt (boolean _att) {
		this._att = _att;
	}




	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return _movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param _movests the movests value
	 */
	public void setMovests (java.lang.String _movests) {
		this._movests = _movests;
	}





	/**
	 * Return the value associated with the column: unittcode
	 */
	public java.lang.String getUnittcode () {
		return _unittcode;
	}

	/**
	 * Set the value related to the column: unittcode
	 * @param _unittcode the unittcode value
	 */
	public void setUnittcode (java.lang.String _unittcode) {
		this._unittcode = _unittcode;
	}


	/**
	 * Return the value associated with the column: tkwork
	 */
	public java.lang.String getTkwork () {
		return _tkwork;
	}

	/**
	 * Set the value related to the column: tkwork
	 * @param _tkwork the tkwork value
	 */
	public void setTkwork (java.lang.String _tkwork) {
		this._tkwork = _tkwork;
	}


	/**
	 * Return the value associated with the column: tranto
	 */
	public java.lang.String getTranto () {
		return _tranto;
	}

	/**
	 * Set the value related to the column: tranto
	 * @param _tranto the tranto value
	 */
	public void setTranto (java.lang.String _tranto) {
		this._tranto = _tranto;
	}


	/**
	 * Return the value associated with the column: stackw
	 */
	public java.lang.String getStackw () {
		return _stackw;
	}

	/**
	 * Set the value related to the column: stackw
	 * @param _stackw the stackw value
	 */
	public void setStackw (java.lang.String _stackw) {
		this._stackw = _stackw;
	}


	/**
	 * Return the value associated with the column: tare
	 */
	public java.lang.String getTare () {
		return _tare;
	}

	/**
	 * Set the value related to the column: tare
	 * @param _tare the tare value
	 */
	public void setTare (java.lang.String _tare) {
		this._tare = _tare;
	}


	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param _companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}


	/**
	 * Return the value associated with the column: grossl
	 */
	public java.lang.String getGrossl () {
		return _grossl;
	}

	/**
	 * Set the value related to the column: grossl
	 * @param _grossl the grossl value
	 */
	public void setGrossl (java.lang.String _grossl) {
		this._grossl = _grossl;
	}



	/**
	 * Return the value associated with the column: shdepms
	 */
	public java.lang.String getShdepms () {
		return _shdepms;
	}

	/**
	 * Set the value related to the column: shdepms
	 * @param _shdepms the shdepms value
	 */
	public void setShdepms (java.lang.String _shdepms) {
		this._shdepms = _shdepms;
	}


	/**
	 * Return the value associated with the column: tdesmax
	 */
	public java.lang.String getTdesmax () {
		return _tdesmax;
	}

	/**
	 * Set the value related to the column: tdesmax
	 * @param _tdesmax the tdesmax value
	 */
	public void setTdesmax (java.lang.String _tdesmax) {
		this._tdesmax = _tdesmax;
	}


	/**
	 * Return the value associated with the column: movemsgtxt
	 */
	public java.lang.String getMovemsgtxt () {
		return _movemsgtxt;
	}

	/**
	 * Set the value related to the column: movemsgtxt
	 * @param _movemsgtxt the movemsgtxt value
	 */
	public void setMovemsgtxt (java.lang.String _movemsgtxt) {
		this._movemsgtxt = _movemsgtxt;
	}


	/**
	 * Return the value associated with the column: length
	 */
	public java.lang.String getLength () {
		return _length;
	}

	/**
	 * Set the value related to the column: length
	 * @param _length the length value
	 */
	public void setLength (java.lang.String _length) {
		this._length = _length;
	}


	/**
	 * Return the value associated with the column: un
	 */
	public boolean isUn () {
		return _un;
	}

	/**
	 * Set the value related to the column: un
	 * @param _un the un value
	 */
	public void setUn (boolean _un) {
		this._un = _un;
	}



	/**
	 * Return the value associated with the column: jfa
	 */
	public boolean isJfa () {
		return _jfa;
	}

	/**
	 * Set the value related to the column: jfa
	 * @param _jfa the jfa value
	 */
	public void setJfa (boolean _jfa) {
		this._jfa = _jfa;
	}





	/**
	 * Return the value associated with the column: shdepss
	 */
	public java.lang.String getShdepss () {
		return _shdepss;
	}

	/**
	 * Set the value related to the column: shdepss
	 * @param _shdepss the shdepss value
	 */
	public void setShdepss (java.lang.String _shdepss) {
		this._shdepss = _shdepss;
	}





	/**
	 * Return the value associated with the column: laststat
	 */
	public java.lang.String getLaststat () {
		return _laststat;
	}

	/**
	 * Set the value related to the column: laststat
	 * @param _laststat the laststat value
	 */
	public void setLaststat (java.lang.String _laststat) {
		this._laststat = _laststat;
	}



	/**
	 * Return the value associated with the column: capimpg
	 */
	public java.lang.String getCapimpg () {
		return _capimpg;
	}

	/**
	 * Set the value related to the column: capimpg
	 * @param _capimpg the capimpg value
	 */
	public void setCapimpg (java.lang.String _capimpg) {
		this._capimpg = _capimpg;
	}


	/**
	 * Return the value associated with the column: tbworkp
	 */
	public java.lang.String getTbworkp () {
		return _tbworkp;
	}

	/**
	 * Set the value related to the column: tbworkp
	 * @param _tbworkp the tbworkp value
	 */
	public void setTbworkp (java.lang.String _tbworkp) {
		this._tbworkp = _tbworkp;
	}


	/**
	 * Return the value associated with the column: rid
	 */
	public boolean isRid () {
		return _rid;
	}

	/**
	 * Set the value related to the column: rid
	 * @param _rid the rid value
	 */
	public void setRid (boolean _rid) {
		this._rid = _rid;
	}




	/**
	 * Return the value associated with the column: gritfin
	 */
	public java.lang.String getGritfin () {
		return _gritfin;
	}

	/**
	 * Set the value related to the column: gritfin
	 * @param _gritfin the gritfin value
	 */
	public void setGritfin (java.lang.String _gritfin) {
		this._gritfin = _gritfin;
	}


	/**
	 * Return the value associated with the column: aar
	 */
	public boolean isAar () {
		return _aar;
	}

	/**
	 * Set the value related to the column: aar
	 * @param _aar the aar value
	 */
	public void setAar (boolean _aar) {
		this._aar = _aar;
	}


	/**
	 * Return the value associated with the column: mfprice
	 */
	public java.lang.String getMfprice () {
		return _mfprice;
	}

	/**
	 * Set the value related to the column: mfprice
	 * @param _mfprice the mfprice value
	 */
	public void setMfprice (java.lang.String _mfprice) {
		this._mfprice = _mfprice;
	}


	/**
	 * Return the value associated with the column: widthf
	 */
	public java.lang.String getWidthf () {
		return _widthf;
	}

	/**
	 * Set the value related to the column: widthf
	 * @param _widthf the widthf value
	 */
	public void setWidthf (java.lang.String _widthf) {
		this._widthf = _widthf;
	}


	/**
	 * Return the value associated with the column: tmdminf
	 */
	public java.lang.String getTmdminf () {
		return _tmdminf;
	}

	/**
	 * Set the value related to the column: tmdminf
	 * @param _tmdminf the tmdminf value
	 */
	public void setTmdminf (java.lang.String _tmdminf) {
		this._tmdminf = _tmdminf;
	}





	/**
	 * Return the value associated with the column: tmdmaxf
	 */
	public java.lang.String getTmdmaxf () {
		return _tmdmaxf;
	}

	/**
	 * Set the value related to the column: tmdmaxf
	 * @param _tmdmaxf the tmdmaxf value
	 */
	public void setTmdmaxf (java.lang.String _tmdmaxf) {
		this._tmdmaxf = _tmdmaxf;
	}


	/**
	 * Return the value associated with the column: gross
	 */
	public java.lang.String getGross () {
		return _gross;
	}

	/**
	 * Set the value related to the column: gross
	 * @param _gross the gross value
	 */
	public void setGross (java.lang.String _gross) {
		this._gross = _gross;
	}




	/**
	 * Return the value associated with the column: rvalprs
	 */
	public java.lang.String getRvalprs () {
		return _rvalprs;
	}

	/**
	 * Set the value related to the column: rvalprs
	 * @param _rvalprs the rvalprs value
	 */
	public void setRvalprs (java.lang.String _rvalprs) {
		this._rvalprs = _rvalprs;
	}




	/**
	 * Return the value associated with the column: headmat
	 */
	public java.lang.String getHeadmat () {
		return _headmat;
	}

	/**
	 * Set the value related to the column: headmat
	 * @param _headmat the headmat value
	 */
	public void setHeadmat (java.lang.String _headmat) {
		this._headmat = _headmat;
	}





	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return _deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param _deleted the deleted value
	 */
	public void setDeleted (boolean _deleted) {
		this._deleted = _deleted;
	}


	/**
	 * Return the value associated with the column: uic
	 */
	public boolean isUic () {
		return _uic;
	}

	/**
	 * Set the value related to the column: uic
	 * @param _uic the uic value
	 */
	public void setUic (boolean _uic) {
		this._uic = _uic;
	}


	/**
	 * Return the value associated with the column: bam
	 */
	public boolean isBam () {
		return _bam;
	}

	/**
	 * Set the value related to the column: bam
	 * @param _bam the bam value
	 */
	public void setBam (boolean _bam) {
		this._bam = _bam;
	}


	/**
	 * Return the value associated with the column: framdes
	 */
	public java.lang.String getFramdes () {
		return _framdes;
	}

	/**
	 * Set the value related to the column: framdes
	 * @param _framdes the framdes value
	 */
	public void setFramdes (java.lang.String _framdes) {
		this._framdes = _framdes;
	}


	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return _eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String _eqpkeyp1) {
		this._eqpkeyp1 = _eqpkeyp1;
	}


	/**
	 * Return the value associated with the column: allocnumber
	 */
	public java.lang.String getAllocnumber () {
		return _allocnumber;
	}

	/**
	 * Set the value related to the column: allocnumber
	 * @param _allocnumber the allocnumber value
	 */
	public void setAllocnumber (java.lang.String _allocnumber) {
		this._allocnumber = _allocnumber;
	}


	/**
	 * Return the value associated with the column: invsts
	 */
	public java.lang.String getInvsts () {
		return _invsts;
	}

	/**
	 * Set the value related to the column: invsts
	 * @param _invsts the invsts value
	 */
	public void setInvsts (java.lang.String _invsts) {
		this._invsts = _invsts;
	}




	/**
	 * Return the value associated with the column: ctc
	 */
	public boolean isCtc () {
		return _ctc;
	}

	/**
	 * Set the value related to the column: ctc
	 * @param _ctc the ctc value
	 */
	public void setCtc (boolean _ctc) {
		this._ctc = _ctc;
	}


	/**
	 * Return the value associated with the column: asme
	 */
	public boolean isAsme () {
		return _asme;
	}

	/**
	 * Set the value related to the column: asme
	 * @param _asme the asme value
	 */
	public void setAsme (boolean _asme) {
		this._asme = _asme;
	}


	/**
	 * Return the value associated with the column: dmthick
	 */
	public java.lang.String getDmthick () {
		return _dmthick;
	}

	/**
	 * Set the value related to the column: dmthick
	 * @param _dmthick the dmthick value
	 */
	public void setDmthick (java.lang.String _dmthick) {
		this._dmthick = _dmthick;
	}





	/**
	 * Return the value associated with the column: tarel
	 */
	public java.lang.String getTarel () {
		return _tarel;
	}

	/**
	 * Set the value related to the column: tarel
	 * @param _tarel the tarel value
	 */
	public void setTarel (java.lang.String _tarel) {
		this._tarel = _tarel;
	}


	/**
	 * Return the value associated with the column: heightf
	 */
	public java.lang.String getHeightf () {
		return _heightf;
	}

	/**
	 * Set the value related to the column: heightf
	 * @param _heightf the heightf value
	 */
	public void setHeightf (java.lang.String _heightf) {
		this._heightf = _heightf;
	}





	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return _eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param _eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String _eqpkeyp2) {
		this._eqpkeyp2 = _eqpkeyp2;
	}


	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public String getMovelocationkey () {
		return _movelocationkey;
	}

	/**
	 * Set the value related to the column: _movelocationkey
	 * @param __movelocationkey the _movelocationkey value
	 */
	public void setMovelocationkey (String _movelocationkey) {
		this._movelocationkey = _movelocationkey;
	}

	
	/**
	 * Return the value associated with the column: moveaddrkey
	 */
	public java.lang.String getMoveaddrkey () {
		return _moveaddrkey;
	}

	/**
	 * Set the value related to the column: moveaddrkey
	 * @param moveaddrkey the moveaddrkey value
	 */
	public void setMoveaddrkey (java.lang.String _moveaddrkey) {
		this._moveaddrkey = _moveaddrkey;
	}
	
	

	/**
	 * Return the value associated with the column: __manuflocationkey
	 */
	public String getManuflocationkey () {
		return _manuflocationkey;
	}

	/**
	 * Set the value related to the column: __manuflocationkey
	 * @param ___manuflocationkey the __manuflocationkey value
	 */
	public void setManuflocationkey (String _manuflocationkey) {
		this._manuflocationkey = _manuflocationkey;
	}

	
	
	/**
	 * Return the value associated with the column: __jobmovlocationkey
	 */
	public String getJobmovlocationkey () {
		return _jobmovlocationkey;
	}

	/**
	 * Set the value related to the column: __jobmovlocationkey
	 * @param ___jobmovlocationkey the __jobmovlocationkey value
	 */
	public void setJobmovlocationkey (String _jobmovlocationkey) {
		this._jobmovlocationkey = _jobmovlocationkey;
	}
	
	
	/**
	 * Return the value associated with the column: g1key
	 */
	public java.lang.String getG1key () {
		return _g1key;
	}

	/**
	 * Set the value related to the column: g1key
	 * @param _g1key the g1key value
	 */
	public void setG1key (java.lang.String _g1key) {
		this._g1key = _g1key;
	}


	/**
	 * Return the value associated with the column: mfcde
	 */
	public java.lang.String getMfcde () {
		return _mfcde;
	}

	/**
	 * Set the value related to the column: mfcde
	 * @param _mfcde the mfcde value
	 */
	public void setMfcde (java.lang.String _mfcde) {
		this._mfcde = _mfcde;
	}


	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return _eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param _eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String _eqpkeyp3) {
		this._eqpkeyp3 = _eqpkeyp3;
	}


	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return _height;
	}

	/**
	 * Set the value related to the column: height
	 * @param _height the height value
	 */
	public void setHeight (java.lang.String _height) {
		this._height = _height;
	}


	/**
	 * Return the value associated with the column: writeoffreason
	 */
	public java.lang.String getWriteoffreason () {
		return _writeoffreason;
	}

	/**
	 * Set the value related to the column: writeoffreason
	 * @param _writeoffreason the writeoffreason value
	 */
	public void setWriteoffreason (java.lang.String _writeoffreason) {
		this._writeoffreason = _writeoffreason;
	}


	/**
	 * Return the value associated with the column: capcm
	 */
	public java.lang.String getCapcm () {
		return _capcm;
	}

	/**
	 * Set the value related to the column: capcm
	 * @param _capcm the capcm value
	 */
	public void setCapcm (java.lang.String _capcm) {
		this._capcm = _capcm;
	}


	/**
	 * Return the value associated with the column: caplit
	 */
	public java.lang.String getCaplit () {
		return _caplit;
	}

	/**
	 * Set the value related to the column: caplit
	 * @param _caplit the caplit value
	 */
	public void setCaplit (java.lang.String _caplit) {
		this._caplit = _caplit;
	}


	/**
	 * Return the value associated with the column: intermgracceptid
	 */
	public java.lang.String getIntermgracceptid () {
		return _intermgracceptid;
	}

	/**
	 * Set the value related to the column: intermgracceptid
	 * @param _intermgracceptid the intermgracceptid value
	 */
	public void setIntermgracceptid (java.lang.String _intermgracceptid) {
		this._intermgracceptid = _intermgracceptid;
	}



	/**
	 * Return the value associated with the column: pokey
	 */
	public java.lang.String getPokey () {
		return _pokey;
	}

	/**
	 * Set the value related to the column: pokey
	 * @param _pokey the pokey value
	 */
	public void setPokey (java.lang.String _pokey) {
		this._pokey = _pokey;
	}






	/**
	 * Return the value associated with the column: rvalvacp
	 */
	public java.lang.String getRvalvacp () {
		return _rvalvacp;
	}

	/**
	 * Set the value related to the column: rvalvacp
	 * @param _rvalvacp the rvalvacp value
	 */
	public void setRvalvacp (java.lang.String _rvalvacp) {
		this._rvalvacp = _rvalvacp;
	}


	/**
	 * Return the value associated with the column: altiso
	 */
	public java.lang.String getAltiso () {
		return _altiso;
	}

	/**
	 * Set the value related to the column: altiso
	 * @param _altiso the altiso value
	 */
	public void setAltiso (java.lang.String _altiso) {
		this._altiso = _altiso;
	}



	/**
	 * Return the value associated with the column: maxtrips
	 */
	public java.lang.String getMaxtrips () {
		return _maxtrips;
	}

	/**
	 * Set the value related to the column: maxtrips
	 * @param _maxtrips the maxtrips value
	 */
	public void setMaxtrips (java.lang.String _maxtrips) {
		this._maxtrips = _maxtrips;
	}




	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param _activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
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
		
        if ((_unitkey == null) || (_unitkey.length() < 1))
            errors.add("unitkey",
                    new ActionMessage("error.unit.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this._unitkey)) errors.add("unitkey", new ActionMessage("error.code.invalidchars"));
		}

        
		addErrorIfBlank(errors, "manuflocationkey", _manuflocationkey, "error.manufacturerlocation.required");
		addErrorIfBlank(errors, "ownerkey", _ownerkey, "error.owner.required");
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_mfdateyyyy+"-"+
									_mfdatemm+"-"+ 
									_mfdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("mfdatedd", new ActionMessage("error.mfdate.required")); 
        
      
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
