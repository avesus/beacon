/**
*  Copyright (c) 2007-APR by BureauEye
*  All rights reserved.
*
*
*  This software is provided without warranty
*  either expressed or implied.
*/
package com.bureaueye.genesys.model.finance.dto;

import java.io.*;
import java.util.*;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.Onhireeqp;


/**
*
*/
public class OnhireeqpBillingrunDTO implements Serializable
{


   	
   	
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public OnhireeqpBillingrunDTO (Onhire onhire, Onhireeqp onhireeqp, Contract contract) {
		
		// onhire header details
		this._onhireId = onhire.getOnhireId();
		this._onhireno = onhire.getOnhireno();
		
		this._contracteqpId = onhire.getContracteqpId();
		this._contracteqplocId = onhire.getContracteqplocId();
		
		this._lesseeaddrkey = onhire.getLesseeaddrkey();		
		this._locationkey = onhire.getLocationkey();	

		this._eqpkey = onhire.getEqpkey();
		this._eqpkeyp1 = onhire.getEqpkeyp1();		
		this._eqpkeyp2 = onhire.getEqpkeyp2();
		this._eqpkeyp3 = onhire.getEqpkeyp3();
		this._eqpkeyp4 = onhire.getEqpkeyp4();
		this._eqpkeyp5 = onhire.getEqpkeyp5();

		// onhire eqp details
		this._onhireeqpId = onhireeqp.getOnhireeqpId();
		this._unitkey = onhireeqp.getUnitkey();
		this._unitId = onhireeqp.getUnitId();		

		this.setOnhiredate(onhireeqp.getOnhiredate());
		this.setOnhiretime(onhireeqp.getOnhiretime());
		this._actualflag = onhireeqp.isActualflag();
		
		this.setReservedate(onhireeqp.getReservedate());
		this.setReservetime(onhireeqp.getReservetime());
		this._reserveflag = onhireeqp.isReserveflag();
		
		
		this._productkey = onhireeqp.getProductkey();
		this._msdsflag = onhireeqp.isMsdsflag();
		this._cleanflag = onhireeqp.isCleanflag();
			
		this.setBillstartdate(onhireeqp.getBillstartdate());
		this.setBilluptodate(onhireeqp.getBilluptodate());
		
		this._billstart = onhireeqp.isBillstart();
		this._billfinish = onhireeqp.isBillfinish();
					
		this._freedays = onhireeqp.getFreedays();
		this._dppfreedays = onhireeqp.getDppfreedays();		
		this._mindays = onhireeqp.getMindays();
		

		this.setPrimarykey();
		
		
		
		// contract details
		this._contractno = contract.getContractno();
		this._contractId = contract.getContractId();
		this._leasetypekey = contract.getLeasetypekey();
		this._billfreqnum = contract.getBillfreqnum();
		this._billfreqtype = contract.getBillfreqtype();
		this._billtype = contract.getBilltype();
		//this._billamendflag = contract.getBillamendflag();	
		this._billccykey = contract.getBillccykey();	
		this.setPeriodstartdate(contract.getPeriodstartdate());
		this.setPeriodenddate(contract.getPeriodenddate());
		this._lesseeaddrkey = contract.getLesseeaddrkey();
		
		this._companykey = contract.getCompanykey();
		this._activitykey = contract.getActivitykey();
		this._departmentkey = contract.getDepartmentkey();
		
	}
	
	


   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	// primary key
	private String _primarykey;
	private Integer _onhireeqpId;
	private Integer _onhireId;
	
	
	// fields
	private Integer _mindays;
	private Integer _dppfreedays;
	private Integer _freedays;

	private java.lang.String _productkey;
	
	private Integer _unitId;
	private java.lang.String _unitkey;
	
	private java.lang.String _onhiredatedd;
	private java.lang.String _onhiredatemm;
	private java.lang.String _onhiredateyyyy;
	private java.lang.String _onhiretimehh;
	private java.lang.String _onhiretimemm;
	private java.lang.String _onhiretimess;
	private java.lang.String _onhiretimeinmillis;	

	private java.lang.String _reservedatedd;
	private java.lang.String _reservedatemm;
	private java.lang.String _reservedateyyyy;
	private java.lang.String _reservetimehh;
	private java.lang.String _reservetimemm;
	private java.lang.String _reservetimeinmillis;		

	private java.util.Date _billstartdate;
	private java.util.Date _billuptodate;
	
	private boolean _msdsflag;
	private boolean _cleanflag;
	private boolean _diflag;
	private boolean _reserveflag;
	private boolean _actualflag;	
	private boolean _billstart;	
	private boolean _billfinish;		
	


	// fields
	private Integer _contracteqpId;
	private Integer _contracteqplocId;
	
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	
	private java.lang.String _submittedby;
	private java.lang.String _submitteddatedd;
	private java.lang.String _submitteddatemm;
	private java.lang.String _submitteddateyyyy;

	private java.lang.String _estreldatedd;
	private java.lang.String _estreldatemm;
	private java.lang.String _estreldateyyyy;

	private java.lang.String _releaseref;
	
	private java.lang.String _notes;
	private java.lang.String _other;
	private java.lang.String _comments;
	
	private java.lang.String _eqpkey;
	private java.lang.String _eqpkeyp5;
	private java.lang.String _eqpkeyp2;	
	private java.lang.String _eqpkeyp6;	
	private java.lang.String _eqpkeyp7;
	private java.lang.String _eqpkeyp3;
	private java.lang.String _eqpkeyp4;
	private java.lang.String _eqpkeyp9;
	private java.lang.String _eqpkeyp8;
	private java.lang.String _eqpkeyp10;
	private java.lang.String _eqpkeyp1;
	
	private Integer _qtyofunits;	

	private java.lang.String _createuserid;
	private java.util.Date _createdate;
	
	private java.lang.String _onhireno;
	private java.lang.String _contractno;
	


	// many to one
	private String _lesseeaddrkey;
	private String _locationkey;
	private Address _lesseeaddr = new Address();
	private Location _location = new Location();
	
	
	

	// primary key
	private Integer _contractId;


	// fields
	
	private java.lang.String _billfreqtype;
	private Integer _billfreqnum;
	private java.lang.String _billtype;
	private java.lang.String _billccykey;
	//private boolean _billamend;
	
	
	private java.lang.String _periodenddatedd;
	private java.lang.String _periodenddatemm;
	private java.lang.String _periodenddateyyyy;
		
	private java.lang.String _periodstartdatedd;
	private java.lang.String _periodstartdatemm;
	private java.lang.String _periodstartdateyyyy;
	
	private java.lang.String _contractdatedd;
	private java.lang.String _contractdatemm;
	private java.lang.String _contractdateyyyy;
	
	
	private Integer _noticedays;

	private java.lang.String _signeddatedd;
	private java.lang.String _signeddatemm;
	private java.lang.String _signeddateyyyy;
	
	private java.lang.String _leasetypekey;
	
	private java.lang.String _versiondatedd;
	private java.lang.String _versiondatemm;
	private java.lang.String _versiondateyyyy;
	
	private String _versionno = "1";
	



	
	


	/**
	 * Return the unique identifier of this class
    * @hibernate.id
    *  generator-class="native"
    *  column="ONHIREEQP_ID"
    */
	public Integer getOnhireeqpId () {
		return _onhireeqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _onhireeqpId the new ID
	 */
	public void setOnhireeqpId (Integer _onhireeqpId) {
		this._onhireeqpId = _onhireeqpId;
	}


	/**
	 * Return the unique identifier of this class
    * @hibernate.id
    *  generator-class="native"
    *  column="CONTRACT_ID"
    */
	public Integer getContractId () {
		return _contractId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _contractId the new ID
	 */
	public void setContractId (Integer _contractId) {
		this._contractId = _contractId;
	}
	
	
	
	public Date getOnhiredate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOnhiredateyyyy()), Integer
						.parseInt(getOnhiredatemm()) - 1, Integer
						.parseInt(getOnhiredatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setOnhiredate(Date onhiredate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(onhiredate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOnhiredateyyyy(c.get(Calendar.YEAR) + "");
		setOnhiredatemm((month < 10 ? "0" : "") + month);
		setOnhiredatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setOnhiredateyyyy("0000");
			setOnhiredatemm("00");
			setOnhiredatedd("00");			
		}
	}
	public String getOnhiredatedd () {return _onhiredatedd;}
	public void setOnhiredatedd (String _onhiredatedd) {this._onhiredatedd = _onhiredatedd;}
	public String getOnhiredatemm () {return _onhiredatemm;}
	public void setOnhiredatemm (String _onhiredatemm) {this._onhiredatemm = _onhiredatemm;}
	public String getOnhiredateyyyy () {return _onhiredateyyyy;}
	public void setOnhiredateyyyy (String _onhiredateyyyy) {this._onhiredateyyyy = _onhiredateyyyy;}

	public String getOnhiretime() {
		try {
		String time = getOnhiretimehh()+":"+getOnhiretimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setOnhiretime(String onhiretime) {
		try {
		String hh = "00";
		try{hh = onhiretime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = onhiretime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setOnhiretimehh(hh);
		setOnhiretimemm(mm);
		} catch (Exception e) {
			setOnhiretimehh("00");
			setOnhiretimemm("00");			
		}
	}
	public String getOnhiretimehh () {return _onhiretimehh;}
	public void setOnhiretimehh (String _onhiretimehh) {this._onhiretimehh = _onhiretimehh;}
	public String getOnhiretimemm () {return _onhiretimemm;}
	public void setOnhiretimemm (String _onhiretimemm) {this._onhiretimemm = _onhiretimemm;}
	public String getOnhiretimess () {return _onhiretimess;}
	public void setOnhiretimess (String _onhiretimess) {this._onhiretimess = _onhiretimess;}
	
	public long getOnhiretimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getOnhiredateyyyy()), 
					Integer.parseInt(getOnhiredatemm()) - 1, 
					Integer.parseInt(getOnhiredatedd()),
					Integer.parseInt(getOnhiretimehh()),
					Integer.parseInt(getOnhiretimemm()),
					Integer.parseInt(getOnhiretimess())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setOnhiretimeinmillis(String _onhiretimeinmillis)	{
		this._onhiretimeinmillis = _onhiretimeinmillis;	
	}
	

	
	
	public Date getReservedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getReservedateyyyy()), Integer
						.parseInt(getReservedatemm()) - 1, Integer
						.parseInt(getReservedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setReservedate(Date reservedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(reservedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setReservedateyyyy(c.get(Calendar.YEAR) + "");
		setReservedatemm((month < 10 ? "0" : "") + month);
		setReservedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setReservedateyyyy("0000");
			setReservedatemm("00");
			setReservedatedd("00");			
		}
	}
	public String getReservedatedd () {return _reservedatedd;}
	public void setReservedatedd (String _reservedatedd) {this._reservedatedd = _reservedatedd;}
	public String getReservedatemm () {return _reservedatemm;}
	public void setReservedatemm (String _reservedatemm) {this._reservedatemm = _reservedatemm;}
	public String getReservedateyyyy () {return _reservedateyyyy;}
	public void setReservedateyyyy (String _reservedateyyyy) {this._reservedateyyyy = _reservedateyyyy;}

	public String getReservetime() {
		try {
		String time = getReservetimehh()+":"+getReservetimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setReservetime(String reservetime) {
		try {
		String hh = "00";
		try{hh = reservetime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = reservetime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setReservetimehh(hh);
		setReservetimemm(mm);
		} catch (Exception e) {
			setReservetimehh("00");
			setReservetimemm("00");			
		}
	}
	public String getReservetimehh () {return _reservetimehh;}
	public void setReservetimehh (String _reservetimehh) {this._reservetimehh = _reservetimehh;}
	public String getReservetimemm () {return _reservetimemm;}
	public void setReservetimemm (String _reservetimemm) {this._reservetimemm = _reservetimemm;}
	
	public long getReservetimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getReservedateyyyy()), 
					Integer.parseInt(getReservedatemm()) - 1, 
					Integer.parseInt(getReservedatedd()),
					Integer.parseInt(getReservetimehh()),
					Integer.parseInt(getReservetimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setReservetimeinmillis(String _reservetimeinmillis)	{
		this._reservetimeinmillis = _reservetimeinmillis;	
	}
	
	
	
	
	/**
	 * Return the value associated with the column: diflag
	 */
	public boolean isDiflag () {
		return _diflag;
	}

	/**
	 * Set the value related to the column: diflag
	 * @param _diflag the diflag value
	 */
	public void setDiflag (boolean _diflag) {
		this._diflag = _diflag;
	}




	/**
	 * Return the value associated with the column: reserveflag
	 */
	public boolean isReserveflag () {
		return _reserveflag;
	}

	/**
	 * Set the value related to the column: reserveflag
	 * @param _reserveflag the reserveflag value
	 */
	public void setReserveflag (boolean _reserveflag) {
		this._reserveflag = _reserveflag;
	}




	/**
	 * Return the value associated with the column: mindays
	 */
	public Integer getMindays () {
		return _mindays;
	}

	/**
	 * Set the value related to the column: mindays
	 * @param _mindays the mindays value
	 */
	public void setMindays (Integer _mindays) {
		this._mindays = _mindays;
	}




	/**
	 * Return the value associated with the column: actualflag
	 */
	public boolean isActualflag () {
		return _actualflag;
	}

	/**
	 * Set the value related to the column: actualflag
	 * @param _actualflag the actualflag value
	 */
	public void setActualflag (boolean _actualflag) {
		this._actualflag = _actualflag;
	}



	/**
	 * Return the value associated with the column: billstart
	 */
	public boolean isBillstart () {
		return _billstart;
	}

	/**
	 * Set the value related to the column: billstart
	 * @param _billstart the billstart value
	 */
	public void setBillstart (boolean _billstart) {
		this._billstart = _billstart;
	}
	
	
	/**
	 * Return the value associated with the column: billfinish
	 */
	public boolean isBillfinish () {
		return _billfinish;
	}

	/**
	 * Set the value related to the column: billfinish
	 * @param __billfinish the billfinish value
	 */
	public void setBillfinish (boolean _billfinish) {
		this._billfinish = _billfinish;
	}
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return _productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param _productkey the productkey value
	 */
	public void setProductkey (java.lang.String _productkey) {
		this._productkey = _productkey;
	}




	/**
	 * Return the value associated with the column: dppfreedays
	 */
	public Integer getDppfreedays () {
		return _dppfreedays;
	}

	/**
	 * Set the value related to the column: dppfreedays
	 * @param _dppfreedays the dppfreedays value
	 */
	public void setDppfreedays (Integer _dppfreedays) {
		this._dppfreedays = _dppfreedays;
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
	 * Return the value associated with the column: unitId
	 */
	public Integer getUnitId () {
		return _unitId;
	}

	/**
	 * Set the value related to the column: unitId
	 * @param _unitId the unitId value
	 */
	public void setUnitId (Integer _unitId) {
		this._unitId = _unitId;
	}
	




	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return _cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param _cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean _cleanflag) {
		this._cleanflag = _cleanflag;
	}


	/**
	 * Return the value associated with the column: billuptodate
	 */
	public java.util.Date getBilluptodate () {
		return _billuptodate;
	}

	/**
	 * Set the value related to the column: billuptodate
	 * @param _billuptodate the billuptodate value
	 */
	public void setBilluptodate (java.util.Date _billuptodate) {
		this._billuptodate = _billuptodate;
	}
	


	/**
	 * Return the value associated with the column: billstartdate
	 */
	public java.util.Date getBillstartdate () {
		return _billstartdate;
	}

	/**
	 * Set the value related to the column: billstartdate
	 * @param _billstartdate the billstartdate value
	 */
	public void setBillstartdate (java.util.Date _billstartdate) {
		this._billstartdate = _billstartdate;
	}


	/**
	 * Return the value associated with the column: msdsflag
	 */
	public boolean isMsdsflag () {
		return _msdsflag;
	}

	/**
	 * Set the value related to the column: msdsflag
	 * @param _msdsflag the msdsflag value
	 */
	public void setMsdsflag (boolean _msdsflag) {
		this._msdsflag = _msdsflag;
	}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIRE_ID"
     */
	public Integer getOnhireId () {
		return _onhireId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _onhireId the new ID
	 */
	public void setOnhireId (Integer _onhireId) {
		this._onhireId = _onhireId;
	}


	
	

    /**
     *  column="CONTRACTEQP_ID"
     */
	public Integer getContracteqpId () {
		return _contracteqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __contracteqpId the new ID
	 */
	public void setContracteqpId (Integer _contracteqpId) {
		this._contracteqpId = _contracteqpId;
	}	
	
	

    /**
     *  column="CONTRACTEQPLOC_ID"
     */
	public Integer getContracteqplocId () {
		return _contracteqplocId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ___contracteqplocId the new ID
	 */
	public void setContracteqplocId (Integer _contracteqplocId) {
		this._contracteqplocId = _contracteqplocId;
	}
	
	
	/**
	 * Return the value associated with the column: onhireno
	 */
	public java.lang.String getOnhireno () {
		return _onhireno;
	}

	/**
	 * Set the value related to the column: onhireno
	 * @param _onhireno the onhireno value
	 */
	public void setOnhireno (java.lang.String _onhireno) {
		this._onhireno = _onhireno;
	}

	
	/**
	 * Return the value associated with the column: _contractno
	 */
	public java.lang.String getContractno () {
		return _contractno;
	}

	/**
	 * Set the value related to the column: _contractno
	 * @param __contractno the _contractno value
	 */
	public void setContractno (java.lang.String _contractno) {
		this._contractno = _contractno;
	}
	

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





	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2_ () {
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
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1_ () {
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
	 * Return the value associated with the column: freedays
	 */
	public Integer getFreedays () {
		return _freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param _freedays the freedays value
	 */
	public void setFreedays (Integer _freedays) {
		this._freedays = _freedays;
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
	 * Return the value associated with the column: qtyofunits
	 */
	public Integer getQtyofunits () {
		return _qtyofunits;
	}

	/**
	 * Set the value related to the column: qtyofunits
	 * @param _qtyofunits the qtyofunits value
	 */
	public void setQtyofunits (Integer _qtyofunits) {
		this._qtyofunits = _qtyofunits;
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

	
	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param _departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
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
	
	

	
	public Date getSubmitteddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getSubmitteddateyyyy()), Integer
						.parseInt(getSubmitteddatemm()) - 1, Integer
						.parseInt(getSubmitteddatedd()));
		return c.getTime();
	}
	public void setSubmitteddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSubmitteddateyyyy(c.get(Calendar.YEAR) + "");
		setSubmitteddatemm((month < 10 ? "0" : "") + month);
		setSubmitteddatedd((day < 10 ? "0" : "") + day);
	}
	public String getSubmitteddatedd () {return _submitteddatedd;}
	public void setSubmitteddatedd (String _submitteddatedd) {this._submitteddatedd = _submitteddatedd;}
	public String getSubmitteddatemm () {return _submitteddatemm;}
	public void setSubmitteddatemm (String _submitteddatemm) {this._submitteddatemm = _submitteddatemm;}
	public String getSubmitteddateyyyy () {return _submitteddateyyyy;}
	public void setSubmitteddateyyyy (String _submitteddateyyyy) {this._submitteddateyyyy = _submitteddateyyyy;}

	
	public Date getEstreldate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEstreldateyyyy()), Integer
						.parseInt(getEstreldatemm()) - 1, Integer
						.parseInt(getEstreldatedd()));
		return c.getTime();
	}
	public void setEstreldate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEstreldateyyyy(c.get(Calendar.YEAR) + "");
		setEstreldatemm((month < 10 ? "0" : "") + month);
		setEstreldatedd((day < 10 ? "0" : "") + day);
	}
	public String getEstreldatedd () {return _estreldatedd;}
	public void setEstreldatedd (String _estreldatedd) {this._estreldatedd = _estreldatedd;}
	public String getEstreldatemm () {return _estreldatemm;}
	public void setEstreldatemm (String _estreldatemm) {this._estreldatemm = _estreldatemm;}
	public String getEstreldateyyyy () {return _estreldateyyyy;}
	public void setEstreldateyyyy (String _estreldateyyyy) {this._estreldateyyyy = _estreldateyyyy;}

	


	
	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate_ () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param _createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}
	
	
	

	
	
	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return _comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param _comments the comments value
	 */
	public void setComments (java.lang.String _comments) {
		this._comments = _comments;
	}


	/**
	 * Return the value associated with the column: other
	 */
	public java.lang.String getOther() {
		return _other;
	}

	/**
	 * Set the value related to the column: other
	 * @param _other the comments value
	 */
	public void setOther (java.lang.String _other) {
		this._other = _other;
	}
	

	/**
	 * Return the value associated with the column: releaseref
	 */
	public java.lang.String getReleaseref () {
		return _releaseref;
	}

	/**
	 * Set the value related to the column: releaseref
	 * @param _releaseref the releaseref value
	 */
	public void setReleaseref (java.lang.String _releaseref) {
		this._releaseref = _releaseref;
	}
	
	
	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return _notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param _notes the notes value
	 */
	public void setNotes (java.lang.String _notes) {
		this._notes = _notes;
	}


	/**
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return _submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param _submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String _submittedby) {
		this._submittedby = _submittedby;
	}





	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param _createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}







	/**
     * @hibernate.property
     *  column=lesseeaddrkey
	 */
	public com.bureaueye.beacon.model.standard.Address getLesseeaddr () {
		return this._lesseeaddr;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param _lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddr (com.bureaueye.beacon.model.standard.Address _lesseeaddr) {
		this._lesseeaddr = _lesseeaddr;
	}

	/**
     * @hibernate.property
     *  column=lesseeaddrkey
	 */
	public String getLesseeaddrkey () {
		return this._lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param _lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (String _lesseeaddrkey) {
		this._lesseeaddrkey = _lesseeaddrkey;
	}
	
	
	
		/**
     * @hibernate.property
     *  column=locationkey
	 */
	public com.bureaueye.beacon.model.standard.Location getLocation () {
		return this._location;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setLocation (com.bureaueye.beacon.model.standard.Location _location) {
		this._location = _location;
	}

	/**
     * @hibernate.property
     *  column=locationkey
	 */
	public String getLocationkey () {
		return this._locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setLocationkey (String _locationkey) {
		this._locationkey = _locationkey;
	}
	



	



	
	
	public Date getContractdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getContractdateyyyy()), Integer
						.parseInt(getContractdatemm()) - 1, Integer
						.parseInt(getContractdatedd()));
		return c.getTime();
	}
	public void setContractdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setContractdateyyyy(c.get(Calendar.YEAR) + "");
		setContractdatemm((month < 10 ? "0" : "") + month);
		setContractdatedd((day < 10 ? "0" : "") + day);
	}
	public String getContractdatedd () {return _contractdatedd;}
	public void setContractdatedd (String _contractdatedd) {this._contractdatedd = _contractdatedd;}
	public String getContractdatemm () {return _contractdatemm;}
	public void setContractdatemm (String _contractdatemm) {this._contractdatemm = _contractdatemm;}
	public String getContractdateyyyy () {return _contractdateyyyy;}
	public void setContractdateyyyy (String _contractdateyyyy) {this._contractdateyyyy = _contractdateyyyy;}

	
	public Date getPeriodenddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPeriodenddateyyyy()), Integer
						.parseInt(getPeriodenddatemm()) - 1, Integer
						.parseInt(getPeriodenddatedd()));
		return c.getTime();
	}
	public void setPeriodenddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPeriodenddateyyyy(c.get(Calendar.YEAR) + "");
		setPeriodenddatemm((month < 10 ? "0" : "") + month);
		setPeriodenddatedd((day < 10 ? "0" : "") + day);
	}
	public String getPeriodenddatedd () {return _periodenddatedd;}
	public void setPeriodenddatedd (String _periodenddatedd) {this._periodenddatedd = _periodenddatedd;}
	public String getPeriodenddatemm () {return _periodenddatemm;}
	public void setPeriodenddatemm (String _periodenddatemm) {this._periodenddatemm = _periodenddatemm;}
	public String getPeriodenddateyyyy () {return _periodenddateyyyy;}
	public void setPeriodenddateyyyy (String _periodenddateyyyy) {this._periodenddateyyyy = _periodenddateyyyy;}

	
	public Date getPeriodstartdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPeriodstartdateyyyy()), Integer
						.parseInt(getPeriodstartdatemm()) - 1, Integer
						.parseInt(getPeriodstartdatedd()));
		return c.getTime();
	}
	public void setPeriodstartdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPeriodstartdateyyyy(c.get(Calendar.YEAR) + "");
		setPeriodstartdatemm((month < 10 ? "0" : "") + month);
		setPeriodstartdatedd((day < 10 ? "0" : "") + day);
	}
	public String getPeriodstartdatedd () {return _periodstartdatedd;}
	public void setPeriodstartdatedd (String _periodstartdatedd) {this._periodstartdatedd = _periodstartdatedd;}
	public String getPeriodstartdatemm () {return _periodstartdatemm;}
	public void setPeriodstartdatemm (String _periodstartdatemm) {this._periodstartdatemm = _periodstartdatemm;}
	public String getPeriodstartdateyyyy () {return _periodstartdateyyyy;}
	public void setPeriodstartdateyyyy (String _periodstartdateyyyy) {this._periodstartdateyyyy = _periodstartdateyyyy;}
	

	public Date getSigneddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getSigneddateyyyy()), Integer
						.parseInt(getSigneddatemm()) - 1, Integer
						.parseInt(getSigneddatedd()));
		return c.getTime();
	}
	public void setSigneddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSigneddateyyyy(c.get(Calendar.YEAR) + "");
		setSigneddatemm((month < 10 ? "0" : "") + month);
		setSigneddatedd((day < 10 ? "0" : "") + day);
	}
	public String getSigneddatedd () {return _signeddatedd;}
	public void setSigneddatedd (String _signeddatedd) {this._signeddatedd = _signeddatedd;}
	public String getSigneddatemm () {return _signeddatemm;}
	public void setSigneddatemm (String _signeddatemm) {this._signeddatemm = _signeddatemm;}
	public String getSigneddateyyyy () {return _signeddateyyyy;}
	public void setSigneddateyyyy (String _signeddateyyyy) {this._signeddateyyyy = _signeddateyyyy;}

	
	public Date getVersiondate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getVersiondateyyyy()), Integer
						.parseInt(getVersiondatemm()) - 1, Integer
						.parseInt(getVersiondatedd()));
		return c.getTime();
	}
	public void setVersiondate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setVersiondateyyyy(c.get(Calendar.YEAR) + "");
		setVersiondatemm((month < 10 ? "0" : "") + month);
		setVersiondatedd((day < 10 ? "0" : "") + day);
	}
	public String getVersiondatedd () {return _versiondatedd;}
	public void setVersiondatedd (String _versiondatedd) {this._versiondatedd = _versiondatedd;}
	public String getVersiondatemm () {return _versiondatemm;}
	public void setVersiondatemm (String _versiondatemm) {this._versiondatemm = _versiondatemm;}
	public String getVersiondateyyyy () {return _versiondateyyyy;}
	public void setVersiondateyyyy (String _versiondateyyyy) {this._versiondateyyyy = _versiondateyyyy;}

	


	/**
	 * Return the value associated with the column: billfreqtype
	 */
	public java.lang.String getBillfreqtype () {
		return _billfreqtype;
	}

	/**
	 * Set the value related to the column: billfreqtype
	 * @param _billfreqtype the billfreqtype value
	 */
	public void setBillfreqtype (java.lang.String _billfreqtype) {
		this._billfreqtype = _billfreqtype;
	}


	/**
	 * Return the value associated with the column: billfreqnum
	 */
	public Integer getBillfreqnum () {
		return _billfreqnum;
	}

	/**
	 * Set the value related to the column: billfreqnum
	 * @param _billfreqnum the billfreqnum value
	 */
	public void setBillfreqnum (Integer _billfreqnum) {
		this._billfreqnum = _billfreqnum;
	}


	/**
	 * Return the value associated with the column: billtype
	 */
	public java.lang.String getBilltype () {
		return _billtype;
	}

	/**
	 * Set the value related to the column: billtype
	 * @param _billtype the billtype value
	 */
	public void setBilltype (java.lang.String _billtype) {
		this._billtype = _billtype;
	}






	/**
	 * Return the value associated with the column: billccykey
	 */
	public java.lang.String getBillccykey () {
		return _billccykey;
	}

	/**
	 * Set the value related to the column: billccykey
	 * @param _billccykey the billccykey value
	 */
	public void setBillccykey (java.lang.String _billccykey) {
		this._billccykey = _billccykey;
	}













	/**
	 * Return the value associated with the column: noticedays
	 */
	public Integer getNoticedays () {
		return _noticedays;
	}

	/**
	 * Set the value related to the column: noticedays
	 * @param _noticedays the noticedays value
	 */
	public void setNoticedays (Integer _noticedays) {
		this._noticedays = _noticedays;
	}





	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return _leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param _leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String _leasetypekey) {
		this._leasetypekey = _leasetypekey;
	}












	/**
	 * Return the value associated with the column: versionno
	 */
	public String getVersionno () {
		return _versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param _versionno the versionno value
	 */
	public void setVersionno (String _versionno) {
		this._versionno = _versionno;
	}




	
	/**
	 * Return the value associated with the column: primarykey
	 */
	public String getPrimarykey () {
		return _primarykey;
	}

	/**
	 * Set the value related to the column: primarykey
	 * @param _primarykey the primarykey value
	 */
	public void setPrimarykey () {
		this._primarykey = this._onhireId+"|"+this._unitId;
	}
	


	
	


	

}
