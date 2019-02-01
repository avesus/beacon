package com.bureaueye.beacon.model.report.dto;

import java.io.Serializable;
import java.util.Date;

import com.bureaueye.beacon.model.job.dto.JobhdrmovDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.Unit;

public class FasttrackDTO implements Serializable {

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
	
	private Date _estfromdate;
	private Date _esttodate;
	private Date _actfromdate;
	private Date _acttodate;

	private Date _fromdate;
	private Date _todate;
	private String _fromtime;
	private String _totime;
	
	private String _estfromtime;
	private String _esttotime;
	private String _actfromtime;
	private String _acttotime;

	private java.lang.Long _actfromtimeinmillis;
	private java.lang.Long _acttotimeinmillis;

	private boolean _actfromflag = false;
	private boolean _acttoflag = false;
	
	private java.lang.String _orderno;
	private java.lang.String _movref;
	private java.lang.String _vessel;
	private java.lang.String _unit;
	private java.lang.String _invsts;
	private java.lang.String _movests;
	private int _colspan;
	private String _nextflag;
	private String _previousflag;
	private String _actualflag;
	
	private String _testtype;
	private String _testflag;
	private Date _testduedate;	

	
	public FasttrackDTO (Unit unit, JobmovDTO jobmovdto) {
		if (unit != null) {
			this._unit = unit.getUnitkey();
		}
		if (jobmovdto != null) {

			this._section= jobmovdto.getSectionkey();
			this._fromlocation= jobmovdto.getFromlocationkey();
			this._tolocation= jobmovdto.getTolocationkey();
			this._vendoraddr= jobmovdto.getVendoraddrkey();
			
			this._jobmovId = jobmovdto.getJobmovId().toString();
			this._movref = jobmovdto.getMovref();
			this._vessel = jobmovdto.getVessel();

			this._movests = jobmovdto.getMovests();
			this._invsts = jobmovdto.getInvsts();
			
			this._actfromdate = jobmovdto.getActfromdate();
			this._acttodate = jobmovdto.getActtodate();
			this._estfromdate = jobmovdto.getEstfromdate();
			this._esttodate = jobmovdto.getEsttodate();
			
			this._actfromtime = jobmovdto.getActfromtime();
			this._acttotime = jobmovdto.getActtotime();
			this._estfromtime = jobmovdto.getEstfromtime();
			this._esttotime = jobmovdto.getEsttotime();
	
			
			this._actfromtimeinmillis = jobmovdto.getActfromtimeinmillis();
			this._acttotimeinmillis = jobmovdto.getActtotimeinmillis();
			
			this._fromdate = jobmovdto.getFromdate();
			this._fromtime = jobmovdto.getFromtime();			
			this._todate = jobmovdto.getTodate();
			this._totime = jobmovdto.getTotime();			
			if (this._actfromtimeinmillis.longValue() > 0) {				
				this._actfromflag = true;
			}
			if (this._acttotimeinmillis.longValue() > 0) {				
				this._acttoflag = true;			
			}
			
		}
			
	}
	

	public FasttrackDTO (JobhdrmovDTO dto) {
			
			this._unit = dto.getUnit();
			this._section = dto.getSection();
			this._fromlocation = dto.getFromlocation();
			this._tolocation = dto.getTolocation();
			this._vendoraddr = dto.getVendoraddr();
			this._product = dto.getProduct();
			
			this._jobmovId = dto.getJobmovId().toString();

			this._movref = dto.getMovref();
			this._vessel = dto.getVessel();

			this._movests = dto.getMovests();
			this._invsts = dto.getInvsts();
			
			this._actfromdate = dto.getActfromdate();
			this._acttodate = dto.getActtodate();
			this._estfromdate = dto.getEstfromdate();
			this._esttodate = dto.getEsttodate();
			
			if (_actfromdate != null && _acttodate != null) this._actualflag = "Y";

			
			this._actfromtime = dto.getActfromtime();
			this._acttotime = dto.getActtotime();
			this._estfromtime = dto.getEstfromtime();
			this._esttotime = dto.getEsttotime();

			
			this._actfromtimeinmillis = dto.getActfromtimeinmillis();
			this._acttotimeinmillis = dto.getActtotimeinmillis();

			this._fromdate = dto.getFromdate();
			this._fromtime = dto.getFromtime();			
			this._todate = dto.getTodate();
			this._totime = dto.getTotime();			
			if (this._actfromtimeinmillis.longValue() > 0) {				
				this._actfromflag = true;
			}
			if (this._acttotimeinmillis.longValue() > 0) {				
				this._acttoflag = true;			
			}
			
			this._jobhdrId = dto.getJobhdrId().toString();
			this._orderhdrId = dto.getOrderhdrId().toString();
			this._orderno = dto.getOrderno();

	}
	
	
	public FasttrackDTO () {}
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}

	public void setActfromtimeinmillis(java.lang.Long _actfromtimeinmillis)	{
		this._actfromtimeinmillis = _actfromtimeinmillis;	
	}
	public java.lang.Long getActfromtimeinmillis()	{
		return this._actfromtimeinmillis;	
	}

	public void setActtotimeinmillis(java.lang.Long _acttotimeinmillis)	{
		this._acttotimeinmillis = _acttotimeinmillis;	
	}
	public java.lang.Long getActtotimeinmillis()	{
		return this._acttotimeinmillis;	
	}

	
	public void setActfromflag(boolean _actfromflag)	{
		this._actfromflag = _actfromflag;	
	}
	public boolean getActfromflag()	{
		return this._actfromflag;	
	}

	public void setActtoflag(boolean _acttoflag)	{
		this._acttoflag = _acttoflag;	
	}
	public boolean getActtoflag()	{
		return this._acttoflag;	
	}
	
	
	public int getColspan() {return _colspan;}
	public void setColspan(int _colspan) {this._colspan = _colspan;}

	public java.lang.String getNextflag () {return _nextflag;}
	public void setNextflag (java.lang.String _nextflag) {this._nextflag = _nextflag;}
	public java.lang.String getPreviousflag () {return _previousflag ;}
	public void setPreviousflag  (java.lang.String _previousflag ) {this._previousflag  = _previousflag ;}
	
	public java.lang.String getActualflag () {return _actualflag ;}
	public void setActualflag  (java.lang.String _actualflag ) {this._actualflag  = _actualflag ;}


	/**
	 * 
	 */
	public Product getProduct () {return _product;}
	/**
	 */
	public void setProduct (Product _product) {this._product = _product;}
	
	
	/**
     */
	public java.lang.String getJobmovId () {return _jobmovId;}
	public void setJobmovId (java.lang.String _jobmovId) {this._jobmovId = _jobmovId;}

	

	public String getInvsts() {return _invsts;}
	public void setInvsts(String _invsts) {this._invsts = _invsts;}
	
	public String getMovests() {return _movests;}
	public void setMovests(String _movests) {this._movests = _movests;}
	
	
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
     */
	public Date getTestduedate() {return _testduedate;}
	public void setTestduedate (Date _testduedate) {this._testduedate = _testduedate;}	
	/**
	 */
	public void setTesttype(java.lang.String _testtype) {this._testtype = _testtype;}	
	public java.lang.String getTesttype () {return _testtype;}	
	/**
	 */
	public void setTestflag(java.lang.String _testflag) {this._testflag = _testflag;}	
	public java.lang.String getTestflag () {return _testflag;}	
	
	

	/**
     */
	public Date getFromdate() {return _fromdate;}
	public void setFromdate (Date _fromdate) {this._fromdate = _fromdate;}	
	public String getFromtime() {return _fromtime;}
	public void setFromtime (String _fromtime) {this._fromtime = _fromtime;}		
	/**
     */
	public Date getTodate() {return _todate;}
	public void setTodate (Date _todate) {this._todate = _todate;}	
	public String getTotime() {return _totime;}
	public void setTotime (String _totime) {this._totime = _totime;}
	
	
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
	public void setUnit (java.lang.String unit) {this._unit = unit;}


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
