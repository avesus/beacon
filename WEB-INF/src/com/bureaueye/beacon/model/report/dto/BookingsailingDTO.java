package com.bureaueye.beacon.model.report.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * Amendments
 * ----------
 *	
 *										
 */
public class BookingsailingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String errorflag = "";

	private String row;



	// key fields
	private Integer _orderhdrid;
	private Integer _jobhdrid;	
	
	
	private java.lang.String _unitkey;
	private java.lang.String _jobno;
	private java.lang.String _orderno;
		
	private java.lang.String _customer;

	private java.lang.String _polcountry;
	private java.lang.String _podcountry;
	private java.lang.String _polcity;
	private java.lang.String _podcity;
	private java.lang.String _polportunicon;
	private java.lang.String _podportunicon;
	private java.lang.String _polname;
	private java.lang.String _podname;

	private int _numberoftanks;
	private float _rate;
	private java.lang.String _rateccykey;

	private float _revenue;	
	private float _grossprofit;
	private java.util.Date _poldateact;
	private java.util.Date _poldateest;
	private java.util.Date _createdate;
	private float _quochargetotal;
	private float _quohdrcosttotal;
	private float _quomovcosttotal;

	private java.lang.String _quohdrccykey;
	private float _revenuebase;
	private float _grossprofitbase;


	private java.lang.String _key;

	private java.lang.Integer _count;



	public BookingsailingDTO (
			String _count
	) {
		this._count = new Integer(_count);				
		this._key = "";
	}


	public BookingsailingDTO (
			String _key,
			String _count
	) {
		this._count = new Integer(_count);					
		this._key =	_key;
	}


	public BookingsailingDTO (
			String _locationcountry,
			String _locationname,
			String _locationid,
			String _status,
			String _count
	) {

	}




	public BookingsailingDTO (
			String _unitkey,
			String _jobno,
			String _orderno,			
			String _customer,
			String _polcountry,		
			String _podcountry,
			String _polcity,		
			String _podcity,
			String _polportunicon,		
			String _podportunicon,	
			String _polname,		
			String _podname,			
			Date _poldateest,
			Date _poldateact,
			Date _createdate,
			Integer _orderhdrid,
			Integer _jobhdrid			
	) {

		try{this._unitkey = _unitkey.toUpperCase();} catch (Exception e){}
		try{this._jobno = _jobno.toUpperCase();} catch (Exception e){}
		try{this._orderno = _orderno.toUpperCase();} catch (Exception e){}		
		try{this._customer = _customer.toUpperCase();} catch (Exception e){}

		try{this._polcountry = _polcountry.toUpperCase();} catch (Exception e){}
		try{this._podcountry = _podcountry.toUpperCase();} catch (Exception e){}
		try{this._polcity = _polcity.toUpperCase();} catch (Exception e){}
		try{this._podcity = _podcity.toUpperCase();} catch (Exception e){}	
		try{this._polportunicon = _polportunicon.toUpperCase();} catch (Exception e){}
		try{this._podportunicon = _podportunicon.toUpperCase();} catch (Exception e){}	

		try{this._polname = _polname.toUpperCase();} catch (Exception e){}
		try{this._podname = _podname.toUpperCase();} catch (Exception e){}	

		try{this._createdate = _createdate;} catch (Exception e){}
		try{this._poldateest = _poldateest;} catch (Exception e){}
		try{this._poldateact = _poldateact;} catch (Exception e){}				

		try{this._orderhdrid = _orderhdrid;} catch (Exception e){}	
		try{this._jobhdrid = _jobhdrid;} catch (Exception e){}	
		
	}




	public BookingsailingDTO () {}


	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}





	public Integer getCount() {return _count;}
	public void setCount(Integer _count) {this._count = _count;}


	public Integer getOrderhdrId() {return _orderhdrid;}
	public void setOrderhdrId(Integer _orderhdrid) {this._orderhdrid = _orderhdrid;}

	public Integer getJobhdrId() {return _jobhdrid;}
	public void setJobhdrId(Integer _jobhdrid) {this._jobhdrid = _jobhdrid;}
	
	public String getJobno() {return _jobno;}
	public void setJobno(String _jobno) {this._jobno = _jobno;}

	public String getOrderno() {return _orderno;}
	public void setOrderno(String _orderno) {this._orderno = _orderno;}
	
	public String getUnitkey() {return _unitkey;}
	public void setUnitkey(String _unitkey) {this._unitkey = _unitkey;}
	
	public String getCustomer() {return _customer;}
	public void setCustomer(String _customer) {this._customer = _customer;}


	public String getPolcountry() {return _polcountry;}
	public void setPolcountry(String _polcountry) {this._polcountry = _polcountry;}

	public String getPodcountry() {return _podcountry;}
	public void setPodcountry(String _podcountry) {this._podcountry = _podcountry;}

	public String getPolcity() {return _polcity;}
	public void setPolcity(String _polcity) {this._polcity = _polcity;}

	public String getPodcity() {return _podcity;}
	public void setPodcity(String _podcity) {this._podcity = _podcity;}

	public String getPolportunicon() {return _polportunicon;}
	public void setPolportunicon(String _polportunicon) {this._polportunicon = _polportunicon;}

	public String getPodportunicon() {return _podportunicon;}
	public void setPodportunicon(String _podportunicon) {this._podportunicon = _podportunicon;}


	public String getPolname() {return _polname;}
	public void setPolname(String _polname) {this._polname= _polname;}

	public String getPodname() {return _podname;}
	public void setPodname(String _podname) {this._podname= _podname;}



	public int getNumberoftanks() {return _numberoftanks;}
	public void setNumberoftanks(int _numberoftanks) {this._numberoftanks = _numberoftanks;}

	public float getRate() {return _rate;}
	public void setRate(float _rate) {this._rate = _rate;}

	public String getRateccykey() {return _rateccykey;}
	public void setRateccykey(String _rateccykey) {this._rateccykey = _rateccykey;}

	public float getRevenue() {return _revenue;}
	public void setRevenue(float _revenue) {this._revenue = _revenue;}

	public float getGrossprofit() {return _grossprofit;}
	public void setGrossprofit(float _grossprofit) {this._grossprofit = _grossprofit;}

	public java.util.Date getPoldateest() {return _poldateest;}
	public void setPoldateest(java.util.Date _poldateest) {this._poldateest = _poldateest;}	

	public java.util.Date getPoldateact() {return _poldateact;}
	public void setPoldateact(java.util.Date _poldateact) {this._poldateact = _poldateact;}

	public java.util.Date getCreatedate() {return _createdate;}
	public void setCreatedate(java.util.Date _createdate) {this._createdate = _createdate;}


	public String getKey() {return _key;}
	public void setKey(String _key) {this._key = _key;}


	public float getQuochargetotal() {return _quochargetotal;}
	public void setQuochargetotal(float _quochargetotal) {this._quochargetotal= _quochargetotal;}

	public float getQuohdrcosttotal() {return _quohdrcosttotal;}
	public void setQuohdrcosttotal(float _quohdrcosttotal) {this._quohdrcosttotal= _quohdrcosttotal;}

	public float getQuomovcosttotal() {return _quomovcosttotal;}
	public void setQuomovcosttotal(float _quomovcosttotal) {this._quomovcosttotal= _quomovcosttotal;}	



	public String getQuohdrccykey() {return _quohdrccykey;}
	public void setQuohdrccykey(String _quohdrccykey) {this._quohdrccykey = _quohdrccykey;}

	public float getRevenuebase() {return _revenuebase;}
	public void setRevenuebase(float _revenuebase) {this._revenuebase = _revenuebase;}

	public float getGrossprofitbase() {return _grossprofitbase;}
	public void setGrossprofitbase(float _grossprofitbase) {this._grossprofitbase = _grossprofitbase;}




	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}

}
