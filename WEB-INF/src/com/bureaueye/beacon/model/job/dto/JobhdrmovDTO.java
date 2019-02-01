package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.util.Date;

import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;

public class JobhdrmovDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String errorflag = "";

	private String row;
	

	// primary key
	private java.lang.String _jobmovId;

	// key fields
	private java.lang.String _jobhdrId;
	private java.lang.String _orderhdrId;
	
	
	private Location _fromlocation = new Location();
	private Location _tolocation = new Location();
	private Address _vendoraddr = new Address();
	private Section _section = new Section();
	private Product _product = new Product();

	private String _fromlocationkey;
	private String _tolocationkey;
	private String _vendoraddrkey;
	private String _sectionkey;
	private String _productkey;
	
	
	private java.lang.String _orderno;
	private java.lang.String _movref;
	private java.lang.String _vessel;
	private java.lang.String _unit;
	
	private Date _estfromdate;
	private Date _esttodate;
	private Date _actfromdate;
	private Date _acttodate;

	private String _estfromtime;
	private String _esttotime;
	private String _actfromtime;
	private String _acttotime;

	private java.lang.Long _actfromtimeinmillis;
	private java.lang.Long _acttotimeinmillis;

	
	private Date _fromdate;
	private String _fromtime;
	private java.lang.Long _fromtimeinmillis;	
	private Date _todate;	
	private String _totime;
	private java.lang.Long _totimeinmillis;
	
	
	
	private java.lang.String _invsts;
	private java.lang.String _movests;

	
	private java.lang.String _orderbyuserid;
	
	
	public JobhdrmovDTO (Jobhdr jobhdr, Jobmov jobmov) {
		if (jobmov != null) {
			this._sectionkey = jobmov.getSectionkey();
			this._fromlocationkey = jobmov.getFromlocationkey();
			this._tolocationkey = jobmov.getTolocationkey();
			this._vendoraddrkey = jobmov.getVendoraddrkey();
			this._jobmovId = jobmov.getJobmovId().toString();
			this._movref = jobmov.getMovref();
			this._vessel = jobmov.getVessel();

			this._movests = jobmov.getMovests();
			this._invsts = jobmov.getInvsts();
			
			this._actfromdate = jobmov.getActfromdate();
			this._acttodate = jobmov.getActtodate();
			this._estfromdate = jobmov.getEstfromdate();
			this._esttodate = jobmov.getEsttodate();
		
			this._actfromtime = jobmov.getActfromtime();
			this._acttotime = jobmov.getActtotime();
			this._estfromtime = jobmov.getEstfromtime();
			this._esttotime = jobmov.getEsttotime();
			
			this._actfromtimeinmillis = jobmov.getActfromtimeinmillis();
			this._acttotimeinmillis = jobmov.getActtotimeinmillis();


			this._fromdate = jobmov.getFromdate();
			this._todate = jobmov.getTodate();
			this._fromtime = jobmov.getFromtime();
			this._totime = jobmov.getTotime();			
			this._fromtimeinmillis = jobmov.getFromtimeinmillis();
			this._totimeinmillis = jobmov.getTotimeinmillis();
			
		}
		
		if (jobhdr != null) {
			this._unit = jobhdr.getUnitkey();
			this._jobhdrId = jobhdr.getJobhdrId().toString();
			this._orderhdrId = jobhdr.getOrderhdrId().toString();
			this._orderno = jobhdr.getOrderno();
			this._productkey = jobhdr.getProductkey();
		}		
	}
	
	
	public JobhdrmovDTO (Orderhdr orderhdr, Jobhdr jobhdr, Jobmov jobmov) {
		if (jobmov != null) {
			this._sectionkey = jobmov.getSectionkey();
			this._fromlocationkey = jobmov.getFromlocationkey();
			this._tolocationkey = jobmov.getTolocationkey();
			this._vendoraddrkey = jobmov.getVendoraddrkey();
			this._jobmovId = jobmov.getJobmovId().toString();
			this._movref = jobmov.getMovref();
			this._vessel = jobmov.getVessel();


			this._movests = jobmov.getMovests();
			this._invsts = jobmov.getInvsts();
			
			this._actfromdate = jobmov.getActfromdate();
			this._acttodate = jobmov.getActtodate();
			this._estfromdate = jobmov.getEstfromdate();
			this._esttodate = jobmov.getEsttodate();
		
			this._actfromtime = jobmov.getActfromtime();
			this._acttotime = jobmov.getActtotime();
			this._estfromtime = jobmov.getEstfromtime();
			this._esttotime = jobmov.getEsttotime();
			
			this._actfromtimeinmillis = jobmov.getActfromtimeinmillis();
			this._acttotimeinmillis = jobmov.getActtotimeinmillis();
			
			this._fromdate = jobmov.getFromdate();
			this._todate = jobmov.getTodate();
			this._fromtime = jobmov.getFromtime();
			this._totime = jobmov.getTotime();			
			this._fromtimeinmillis = jobmov.getFromtimeinmillis();
			this._totimeinmillis = jobmov.getTotimeinmillis();			
		}
		
		if (jobhdr != null) {
			this._unit = jobhdr.getUnitkey();
			this._jobhdrId = jobhdr.getJobhdrId().toString();
			this._orderhdrId = jobhdr.getOrderhdrId().toString();
			this._orderno = jobhdr.getOrderno();
			this._productkey = jobhdr.getProductkey();
		}
		
		if (orderhdr != null) {
			this._orderno = orderhdr.getOrderno();
			this._orderbyuserid = orderhdr.getOrderbyuserid();			
		}
		
	}
	
	
	

	public JobhdrmovDTO () {}
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	
	

	public String getOrderbyuserid() {return _orderbyuserid;}
	public void setOrderbyuserid(String _orderbyuserid) {this._orderbyuserid = _orderbyuserid;}

	public String getInvsts() {return _invsts;}
	public void setInvsts(String _invsts) {this._invsts = _invsts;}
	
	public String getMovests() {return _movests;}
	public void setMovests(String _movests) {this._movests = _movests;}
	
	
	/**
     */
	public Date getFromdate() {return _fromdate;}
	public void setFromdate (Date _fromdate) {this._fromdate = _fromdate;}	
	/**
     */
	public String getFromtime() {return _fromtime;}
	public void setFromtime (String _fromtime) {this._fromtime = _fromtime;}
	/**
     */
	public java.lang.Long getFromtimeinmillis() {return _fromtimeinmillis;}
	public void setFromtimeinmillis (java.lang.Long _fromtimeinmillis) {this._fromtimeinmillis = _fromtimeinmillis;}	
	
	/**
     */
	public Date getTodate() {return _todate;}
	public void setTodate (Date _todate) {this._todate = _todate;}	
	/**
     */
	public String getTotime() {return _totime;}
	public void setTotime (String _totime) {this._totime = _totime;}
	/**
     */
	public java.lang.Long getTotimeinmillis() {return _totimeinmillis;}
	public void setTotimeinmillis (java.lang.Long _totimeinmillis) {this._totimeinmillis = _fromtimeinmillis;}	

	
	
	
	/**
     */
	public Date getEstfromdate() {return _estfromdate;}
	public void setEstfromdate (Date _estfromdate) {this._estfromdate = _estfromdate;}	
	/**
     */
	public Date getEsttodate() {return _esttodate;}
	public void setEsttodate (Date _esttodate) {this._esttodate = _esttodate;}
	/**
     */
	public Date getActfromdate() {return _actfromdate;}
	public void setActfromdate (Date _actfromdate) {this._actfromdate = _actfromdate;}	
	/**
     */
	public Date getActtodate() {return _acttodate;}
	public void setActtodate (Date _acttodate) {this._acttodate = _acttodate;}

	/**
     */
	public String getEstfromtime() {return _estfromtime;}
	public void setEstfromtime (String _estfromtime) {this._estfromtime = _estfromtime;}	
	/**
     */
	public String getEsttotime() {return _esttotime;}
	public void setEsttotime (String _esttotime) {this._esttotime = _esttotime;}
	/**
     */
	public String getActfromtime() {return _actfromtime;}
	public void setActfromtime (String _actfromtime) {this._actfromtime = _actfromtime;}	
	/**
     */
	public String getActtotime() {return _acttotime;}
	public void setActtotime (String _acttotime) {this._acttotime = _acttotime;}
	
	/**
     */
	public java.lang.Long getActfromtimeinmillis() {return _actfromtimeinmillis;}
	public void setActfromtimeinmillis (java.lang.Long _actfromtimeinmillis) {this._actfromtimeinmillis = _actfromtimeinmillis;}	
	/**
     */
	public java.lang.Long getActtotimeinmillis() {return _acttotimeinmillis;}
	public void setActtotimeinmillis (java.lang.Long _acttotimeinmillis) {this._acttotimeinmillis = _acttotimeinmillis;}

	
	/**
     */
	public java.lang.String getJobmovId () {
		return _jobmovId;
	}
	/**
	 */
	public void setJobmovId (java.lang.String _jobmovId) {
		this._jobmovId = _jobmovId;
	}


	/**
     */
	public java.lang.String getOrderhdrId () {
		return _orderhdrId;
	}
	/**
	 */
	public void setOrderhdrId (java.lang.String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}
	

	/**
	 * 
	 */
	public Product getProduct () {return _product;}
	/**
	 */
	public void setProduct (Product _product) {this._product = _product;}
	
	

	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public Location getFromlocation () {
		return _fromlocation;
	}

	/**
	 * Set the value related to the column: fromlocation
	 * @param _fromlocation the fromlocation value
	 */
	public void setFromlocation (Location _fromlocation) {
		this._fromlocation = _fromlocation;
	}


	/**
	 * Return the value associated with the column: tolocation
	 */
	public Location getTolocation () {
		return _tolocation;
	}

	/**
	 * Set the value related to the column: tolocation
	 * @param _tolocation the tolocation value
	 */
	public void setTolocation (Location _tolocation) {
		this._tolocation = _tolocation;
	}





	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddr () {
		return _vendoraddr;
	}

	/**
	 * Set the value related to the column: vendoraddr
	 * @param _vendoraddr the vendoraddr value
	 */
	public void setVendoraddr (Address _vendoraddr) {
		this._vendoraddr = _vendoraddr;
	}





	/**
	 * Return the value associated with the column: sectionkey
	 */
	public Section getSection () {
		return _section;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param _sectionkey the sectionkey value
	 */
	public void setSection (Section _section) {
		this._section = _section;
	}





	/**
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

/**
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}




	/**
	 */
	public java.lang.String getJobhdrId () {return _jobhdrId;}
	/**
	 */
	public void setJobhdrId (java.lang.String _jobhdrId) {this._jobhdrId = _jobhdrId;}

	/**
	 */
	public java.lang.String getUnit () {return _unit;}
	/**
	 */
	public void setUnit (java.lang.String _unit) {this._unit = _unit;}


	/**
	 */
	public java.lang.String getMovref () {return _movref;}
	/**
	 */
	public void setMovref (java.lang.String _movref) {this._movref = _movref;}

	
	/**
	 */
	public java.lang.String getVessel () {return _vessel;}
	/**
	 */
	public void setVessel (java.lang.String _vessel) {this._vessel = _vessel;}

	
	
	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this._vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public java.lang.String getFromlocationkey () {
		return _fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (java.lang.String fromlocationkey) {
		this._fromlocationkey = fromlocationkey;
	}



	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public java.lang.String getTolocationkey () {
		return _tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (java.lang.String tolocationkey) {
		this._tolocationkey = tolocationkey;
	}



	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey () {
		return _sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this._sectionkey = sectionkey;
	}
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return _productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this._productkey = productkey;
	}
	
	
	
	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
}
