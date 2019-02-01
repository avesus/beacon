package com.bureaueye.beacon.model.report.dto;

import java.io.Serializable;
import java.sql.ResultSet;


/**
 *
 * Amendments
 * ----------
 *												
 */


public class LocationinventoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String errorflag = "";

	private String row;
	

	// primary key

	// key fields
	
	private java.lang.Integer _count;
	private java.lang.String _status;
	private java.lang.String _invsts;
	private java.lang.String _tsid;
	private java.lang.String _locationid;
	private java.lang.String _locationcountry;
	private java.lang.String _locationname;
	private java.lang.String _tanknumber;
	private java.lang.Integer _capacity;
	private java.lang.String _capacitytype;	
	private java.lang.Integer _tareweight;
	private java.lang.String _tareweighttype;	
	private java.lang.String _imo;
	private java.lang.Byte _heated;
	private java.lang.Byte _insulated;
	private java.lang.String _discharge;
	private java.lang.String _heatingtype;
	private java.lang.Byte _assigned;
	private String _active;
	private java.lang.String _manufactured;

	private java.lang.String _fromlocation;
	private java.lang.String _tolocation;
	private java.util.Date _estfromdate;
	private java.util.Date _esttodate;
	private java.util.Date _actfromdate;
	private java.util.Date _acttodate;
	private String _movref;
	private String _customer;
	private String _customerref;
	private String _consignee;
	private String _consigneeref;
	private String _product;
	private String _shipmethod;

	private String _infreedays;
	private String _indemurrage;
	private java.util.Date _poddateactual;	
	private Integer _demfreedays;	

	private String _shippedfull;//ITT-200902-0001
	private String _shippedempty;//ITT-200902-0001
	
	private java.lang.String _key;
	


	
	public LocationinventoryDTO (
			String _locationcountry,
			String _locationname,
			String _locationid,
			String _status,
			String _count
			) {
				this._count = new Integer(_count);
				this._locationid = _locationid.toUpperCase();
				this._locationname = _locationname.toUpperCase();
				this._locationcountry = _locationcountry.toUpperCase();
				this._status = _status.toUpperCase();
				
				this._key =
					this._locationcountry + "|" +
					this._locationid + "|" +
					this._status;
	}		
	
	
	public LocationinventoryDTO (
		String _locationcountry,
		String _locationname,
		String _locationid,		
		String _status,
		String _invsts,
		String _tanknumber,
		String _tsid
		) {

			this._locationid = _locationid.toUpperCase();
			this._locationcountry = _locationcountry.toUpperCase();
			this._locationname = _locationname.toUpperCase();
			this._invsts = _invsts.toUpperCase();
			this._status = _status.toUpperCase();			
			this._tanknumber = _tanknumber.toUpperCase();
			this._tsid = _tsid;			
			
			this._key =
				this._locationcountry + "|" +
				this._locationid + "|" +
				this._status;
	}
	
	public LocationinventoryDTO (
			String _status
			) {

				this._status = _status.toUpperCase();
				
				this._key =
					this._status;
	}	

	public LocationinventoryDTO (
			String _locationcountry,
			String _locationname,
			String _locationid
			) {

				this._locationid = _locationid.toUpperCase();
				this._locationname = _locationname.toUpperCase();
				this._locationcountry = _locationcountry.toUpperCase();
				
				this._key =
					this._locationcountry + "|" +
					this._locationid;
	}
	

	
	public LocationinventoryDTO (
			String _locationcountry,
			String _locationname,
			String _locationid,		
			String _status,
			String _invsts,
			String _imo,
			String _tanknumber,
			String _capacity,
			String _tareweight,
			String _movref
			) {

				this._locationid = _locationid.toUpperCase();
				this._locationcountry = _locationcountry.toUpperCase();
				this._locationname = _locationname.toUpperCase();
				this._invsts = _invsts.toUpperCase();
				this._status = _status.toUpperCase();			
				this._imo = _imo.toUpperCase();
				//this._heated = _heated;
				this._tanknumber = _tanknumber.toUpperCase();
				//this._tsid = _tsid;			
				this._capacity = new Integer(_capacity);
				//this._capacitytype = _capacitytype.toUpperCase();

				//this._active = _active;
				//this._assigned = _assigned;
				//this._insulated = _insulated;
				this._tareweight = new Integer(_tareweight);
				//this._tareweighttype = _tareweighttype.toUpperCase();
				//this._discharge = _discharge.toUpperCase();
				//this._heatingtype = _heatingtype.toUpperCase();
				//this._manufactured = _manufactured.toUpperCase();

				this._movref = _movref;//ITT-200902-0001
				
				this._infreedays="";
				this._indemurrage="";

				this._shippedfull="";//ITT-200902-0001
				this._shippedempty="";//ITT-200902-0001
				
				this._key =
					this._locationcountry + "|" +
					this._locationid + "|" +
					this._status;
		}
	
	
	public LocationinventoryDTO () {}
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	
	



	public String getFromlocation() {return _fromlocation;}
	public void setFromlocation(String _fromlocation) {this._fromlocation = _fromlocation;}
	
	public String getTolocation() {return _tolocation;}
	public void setTolocation(String _tolocation) {this._tolocation = _tolocation;}	

	public java.util.Date getEstfromdate() {return _estfromdate;}
	public void setEstfromdate(java.util.Date _estfromdate) {this._estfromdate = _estfromdate;}	

	public java.util.Date getEsttodate() {return _esttodate;}
	public void setEsttodate(java.util.Date _esttodate) {this._esttodate = _esttodate;}	
	
	public java.util.Date getActfromdate() {return _actfromdate;}
	public void setActfromdate(java.util.Date _actfromdate) {this._actfromdate = _actfromdate;}	

	public java.util.Date getActtodate() {return _acttodate;}
	public void setActtodate(java.util.Date _acttodate) {this._acttodate = _acttodate;}	
	
	public String getMovref() {return _movref;}
	public void setMovref(String _movref) {this._movref = _movref;}	

	public String getCustomer() {return _customer;}
	public void setCustomer(String _customer) {this._customer = _customer;}	
	public String getCustomerref() {return _customerref;}
	public void setCustomerref(String _customerref) {this._customerref = _customerref;}	

	public String getConsignee() {return _consignee;}
	public void setConsignee(String _consignee) {this._consignee = _consignee;}	
	public String getConsigneeref() {return _consigneeref;}
	public void setConsigneeref(String _consigneeref) {this._consigneeref = _consigneeref;}	
	
	public String getProduct() {return _product;}
	public void setProduct(String _product) {this._product = _product;}	
	
	public String getShipmethod() {return _shipmethod;}
	public void setShipmethod(String _shipmethod) {this._shipmethod = _shipmethod;}	
	
	
	public Integer getCount() {return _count;}
	public void setCount(Integer _count) {this._count = _count;}

	public String getStatus() {return _status;}
	public void setStatus(String _status) {this._status = _status;}

	public String getInvsts() {return _invsts;}
	public void setInvsts(String _invsts) {this._invsts = _invsts;}
	
	public String getTsid() {return _tsid;}
	public void setTsid(String _tsid) {this._tsid = _tsid;}
	
	public String getTanknumber() {return _tanknumber;}
	public void setTanknumber(String _tanknumber) {this._tanknumber = _tanknumber;}

	public Integer getCapacity() {return _capacity;}
	public void setCapacity(Integer _capacity) {this._capacity = _capacity;}

	public String getCapacitytype() {return _capacitytype;}
	public void setCapacitytype(String _capacitytype) {this._capacitytype = _capacitytype;}
	
	public String getLocationname() {return _locationname;}
	public void setLocationname(String _locationname) {this._locationname = _locationname;}
	
	public String getLocationid() {return _locationid;}
	public void setLocationid(String _locationid) {this._locationid = _locationid;}

	public String getLocationcountry() {return _locationcountry;}
	public void setLocationcountry(String _locationcountry) {this._locationcountry = _locationcountry;}
	
	public String getImo() {return _imo;}
	public void setImo(String _imo) {this._imo = _imo;}

	public java.lang.Byte getHeated() {return _heated;}
	public void setHeated(java.lang.Byte _heated) {this._heated = _heated;}

	public String getActive() {return _active;}
	public void setActive(String _active) {this._active = _active;}

	public java.lang.Byte getAssigned() {return _assigned;}
	public void setAssigned(java.lang.Byte _assigned) {this._assigned = _assigned;}

	public java.lang.Byte getInsulated() {return _insulated;}
	public void setInsulated(java.lang.Byte _insulated) {this._insulated = _insulated;}

	public Integer getTareweight() {return _tareweight;}
	public void setTareweight(Integer _tareweight) {this._tareweight = _tareweight;}

	public String getTareweighttype() {return _tareweighttype;}
	public void setTareweighttype(String _tareweighttype) {this._tareweighttype = _tareweighttype;}

	public String getDischarge() {return _discharge;}
	public void setDischarge(String _discharge) {this._discharge = _discharge;}
	
	public String getHeatingtype() {return _heatingtype;}
	public void setHeatingtype(String _heatingtype) {this._heatingtype = _heatingtype;}
	
	public java.lang.String getManufactured() {return _manufactured;}
	public void setManufactured(java.lang.String _manufactured) {this._manufactured = _manufactured;}
	
	
	public String getKey() {return _key;}
	public void setKey(String _key) {this._key = _key;}

	
	
	public String getInfreedays() {return _infreedays;}
	public void setInfreedays(String _infreedays) {this._infreedays= _infreedays;}
	
	public String getIndemurrage() {return _indemurrage;}
	public void setIndemurrage(String _indemurrage) {this._indemurrage= _indemurrage;}

	public Integer getDemfreedays() {return _demfreedays;}
	public void setDemfreedays(Integer _demfreedays) {this._demfreedays= _demfreedays;}	
	
	public java.util.Date getPoddateactual() {return _poddateactual;}
	public void setPoddateactual(java.util.Date _poddateactual) {this._poddateactual= _poddateactual;}	
	

	public String getShippedfull() {return _shippedfull;}//ITT-200902-0001
	public void setShippedfull(String _shippedfull) {this._shippedfull= _shippedfull;}//ITT-200902-0001
	public String getShippedempty() {return _shippedempty;}//ITT-200902-0001
	public void setShippedempty(String _shippedempty) {this._shippedempty= _shippedempty;}//ITT-200902-0001
	
	

	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
}
