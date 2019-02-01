package com.bureaueye.beacon.model.report.dto;


import java.io.Serializable;

import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.Unit;


/**
 */

public final class UnitMoveDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public UnitMoveDTO (Unit unit, Jobmov jobmov, Jobhdr jobhdr, Orderhdr orderhdr) {
		this._jobmovId = jobmov.getJobmovId().toString();
		this._jobhdrId = jobhdr.getJobhdrId().toString();
		this._orderhdrId = jobhdr.getOrderhdrId().toString();
		this._orderno = jobhdr.getOrderno();
		
		this._unitId = unit.getUnitId().toString();
		this._unitkey = unit.getUnitkey();
		
		this._fromlocationkey = jobmov.getFromlocationkey();
		this._tolocationkey = jobmov.getTolocationkey();
		this._estfromdate = jobmov.getEstfromdate();
		this._esttodate = jobmov.getEsttodate();	
		this._actfromdate = jobmov.getActfromdate();
		this._acttodate = jobmov.getActtodate();	
		
		this._sectionkey = jobmov.getSectionkey();
		this._productkey = jobhdr.getProductkey();
		//if (quohdr.getOrderhdrs().size() > 0) this._orderhdrsfound = "true";		
	}	
	
	
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public UnitMoveDTO (Unit unit, Jobmov jobmov) {
		this._jobmovId = jobmov.getJobmovId().toString();
		
		this._unitId = unit.getUnitId().toString();
		this._unitkey = unit.getUnitkey();
		
		this._fromlocationkey = jobmov.getFromlocationkey();
		this._tolocationkey = jobmov.getTolocationkey();
		this._estfromdate = jobmov.getEstfromdate();
		this._esttodate = jobmov.getEsttodate();	
		this._actfromdate = jobmov.getActfromdate();
		this._acttodate = jobmov.getActtodate();	
		
		this._sectionkey = jobmov.getSectionkey();
		
		//if (quohdr.getOrderhdrs().size() > 0) this._orderhdrsfound = "true";		
	}
	
	
	public UnitMoveDTO (Jobhdr jobhdr, Jobmov jobmov) {
		this._jobmovId = jobmov.getJobmovId().toString();
		
//		
		this._unitkey = jobhdr.getUnitkey();
		this._unitId = jobhdr.getUnitId().toString();		
		
		this._fromlocationkey = jobmov.getFromlocationkey();
		this._tolocationkey = jobmov.getTolocationkey();		
		this._estfromdate = jobmov.getEstfromdate();
		this._esttodate = jobmov.getEsttodate();	
		this._actfromdate = jobmov.getActfromdate();
		this._acttodate = jobmov.getActtodate();	
		
		this._sectionkey = jobmov.getSectionkey();

		this._productkey = jobhdr.getProductkey();
		
		this.txt = jobmov.getTxt();
		this.movref = jobmov.getMovref();
		this.actfromtimeinmillis = jobmov.getActfromtimeinmillis();
		this.acttotimeinmillis = jobmov.getActtotimeinmillis();
		this.actfromtime = jobmov.getActfromtime();
		this.acttotime = jobmov.getActtotime();
		
		
		this.vessel = jobmov.getVessel();
		this.voyage = jobmov.getVoyage();
		this.vsbkcontact = jobmov.getVsbkcontact ();
		this.vsbkref = jobmov.getVsbkref();
		this.bookkey = jobmov.getBookkey();
		this.billoflading = jobmov.getBilloflading();
		this.lloydsnumber = jobmov.getLloydsnumber ();			
		this.vendoraddrkey = jobmov.getVendoraddrkey();
		this.sealnumbers = jobhdr.getSealnumbers();
		
		this.weightactual = jobhdr.getWeightactual();
		this.weightactualunit = jobhdr.getWeightactualunit();
		
		//if (quohdr.getOrderhdrs().size() > 0) this._orderhdrsfound = "true";		
	}
	
	
	
	public UnitMoveDTO (Jobhdr jobhdr, Jobmov jobmov, Orderhdr orderhdr) {
		this._jobmovId = jobmov.getJobmovId().toString();
		
//		
		this._unitkey = jobhdr.getUnitkey();
		this._unitId = jobhdr.getUnitId().toString();		
		
		this._fromlocationkey = jobmov.getFromlocationkey();
		this._tolocationkey = jobmov.getTolocationkey();		
		this._estfromdate = jobmov.getEstfromdate();
		this._esttodate = jobmov.getEsttodate();	
		this._actfromdate = jobmov.getActfromdate();
		this._acttodate = jobmov.getActtodate();	
		
		this._sectionkey = jobmov.getSectionkey();

		this._productkey = jobhdr.getProductkey();
		
		this.txt = jobmov.getTxt();
		this.txt2 = jobmov.getTxt2();
		this.txt3 = jobmov.getTxt3();
		this.movref = jobmov.getMovref();
		this.actfromtimeinmillis = jobmov.getActfromtimeinmillis();
		this.acttotimeinmillis = jobmov.getActtotimeinmillis();
		this.actfromtime = jobmov.getActfromtime();
		this.acttotime = jobmov.getActtotime();
		
		
		this.vessel = jobmov.getVessel();
		this.voyage = jobmov.getVoyage();
		this.vsbkcontact = jobmov.getVsbkcontact ();
		this.vsbkref = jobmov.getVsbkref();
		this.bookkey = jobmov.getBookkey();
		this.billoflading = jobmov.getBilloflading();
		this.lloydsnumber = jobmov.getLloydsnumber ();			
		this.vendoraddrkey = jobmov.getVendoraddrkey();
		this.sealnumbers = jobhdr.getSealnumbers();
		
		this.weightactual = jobhdr.getWeightactual();
		this.weightactualunit = jobhdr.getWeightactualunit();
		
		this._customeraddrkey = orderhdr.getCustomeraddrkey();
		this._orderno = orderhdr.getOrderno();
		
	}
	
	
	
	// --------------------------------------------------- Instance Variables
	
	/**
	 * The unique id.
	 */
	private String _unitId;
	private String _readonly = "false";
	private String _orderhdrsfound = "false";
	
	/**
	 */
	private String _jobmovId;
	private String _jobhdrId;
	private String _orderhdrId;
	private String _orderno;
	
	private String _fromlocationkey;
	private String _tolocationkey;
	private String _unitkey;
	private String _sectionkey;
	private String _productkey;
	private Location _fromlocation = new Location();
	private Location _tolocation = new Location();
	private Address _vendoraddr = new Address();
	private Section _section = new Section();
	private Product _product = new Product();
	private Unit _unit = new Unit();
	

	private String _customeraddrkey;
	private Address _customeraddr = new Address();
	
	
	private java.util.Date _actfromdate;
	private java.util.Date _acttodate;
	private java.util.Date _estfromdate;    
	private java.util.Date _esttodate; 
	
	private java.lang.String movref;
	private java.lang.Long acttotimeinmillis;
	private java.lang.Long actfromtimeinmillis;
	private java.lang.String txt;	
	private java.lang.String txt2;
	private java.lang.String txt3;
	private java.lang.String acttotime;
	private java.lang.String actfromtime;
	
	private boolean checked;
	
	
	
	private java.lang.String vessel;
	private java.lang.String voyage;
	private java.lang.String vsbkcontact;
	private java.lang.String vsbkref;
	private java.lang.String bookkey;
	private java.lang.String billoflading;
	private java.lang.String lloydsnumber;
	
	private java.lang.String vendoraddrkey;
	private java.lang.String sealnumbers;
	
	private java.lang.String weightactualunit;
	private java.math.BigDecimal weightactual;
	
	
	
	// ----------------------------------------------------------- Properties
	
	
	public boolean isChecked() { return (this.checked); }
	public void setChecked(boolean b) {
		this.checked = b;
	}
	
	
	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public String getOrderhdrsfound() {return _orderhdrsfound;}
	public void setOrderhdrsfound(String _orderhdrsfound) {this._orderhdrsfound = _orderhdrsfound;}
	
	
	
	
	/**
	 */
	public String getOrderno() {
		return (this._orderno);
	}
	/**
	 */
	public void setOrderno(String _orderno) {
		this._orderno = _orderno;
	}
	
	
	/**
	 */
	public String getSectionkey() {
		return (this._sectionkey);
	}
	/**
	 */
	public void setSectionkey(String _sectionkey) {
		this._sectionkey = _sectionkey;
	}
	
	/**
	 */
	public String getFromlocationkey() {
		return (this._fromlocationkey);
	}
	/**
	 */
	public void setFromlocationkey(String _fromlocationkey) {
		this._fromlocationkey = _fromlocationkey;
	}
	
	/**
	 */
	public String getTolocationkey() {
		return (this._tolocationkey);
	}
	/**
	 */
	public void setTolocationkey(String _tolocationkey) {
		this._tolocationkey = _tolocationkey;
	}
	
	/**
	 */
	public String getProductkey() {
		return (this._productkey);
	}
	/**
	 */
	public void setProductkey(String _productkey) {
		this._productkey = _productkey;
	}
	
	
	/**
	 */
	public String getUnitkey() {
		return (this._unitkey);
	}
	/**
	 */
	public void setUnitkey(String _unitkey) {
		this._unitkey = _unitkey;
	}
	
	/**
	 */
	public String getUnitId() {
		return (this._unitId);
	}
	/**
	 */
	public void setUnitId(String _unitId) {
		this._unitId = _unitId;
	}
	
	/**
	 */
	public String getJobhdrId() {
		return (this._jobhdrId);
	}
	/**
	 */
	public void setJobhdrId(String _jobhdrId) {
		this._jobhdrId = _jobhdrId;
	}
	
	
	/**
	 */
	public String getJobmovId() {
		return (this._jobmovId);
	}
	/**
	 */
	public void setJobmovId(String _jobmovId) {
		this._jobmovId = _jobmovId;
	}
	
	
	/**
	 */
	public String getOrderhdrId() {
		return (this._orderhdrId);
	}
	/**
	 */
	public void setOrderhdrId(String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: actfromdate
	 */
	public java.util.Date getActfromdate () {
		return _actfromdate;
	}
	
	/**
	 * Set the value related to the column: actfromdate
	 * @param _actfromdate the actfromdate value
	 */
	public void setActfromdate (java.util.Date _actfromdate) {
		this._actfromdate = _actfromdate;
	}
	
	
	/**
	 * Return the value associated with the column: acttodate
	 */
	public java.util.Date getActtodate () {
		return _acttodate;
	}
	
	/**
	 * Set the value related to the column: acttodate
	 * @param _acttodate the acttodate value
	 */
	public void setActtodate (java.util.Date _acttodate) {
		this._acttodate = _acttodate;
	}
	
	
	/**
	 * Return the value associated with the column: estfromdate
	 */
	public java.util.Date getEstfromdate () {
		return _estfromdate;
	}
	
	/**
	 * Set the value related to the column: estfromdate
	 * @param _estfromdate the estfromdate value
	 */
	public void setEstfromdate (java.util.Date _estfromdate) {
		this._estfromdate = _estfromdate;
	}
	
	
	/**
	 * Return the value associated with the column: esttodate
	 */
	public java.util.Date getEsttodate () {
		return _esttodate;
	}
	
	/**
	 * Set the value related to the column: esttodate
	 * @param _esttodate the esttodate value
	 */
	public void setEsttodate (java.util.Date _esttodate) {
		this._esttodate = _esttodate;
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
	public java.lang.String getSealnumbers () {
		return sealnumbers;
	}
	
	/**
	 */
	public void setSealnumbers(java.lang.String sealnumbers) {
		this.sealnumbers = sealnumbers;
	}
	
	
	
	/**
	 * Return the value associated with the column: MOVREF
	 */
	public java.lang.String getMovref () {
		return movref;
	}
	
	/**
	 * Set the value related to the column: MOVREF
	 * @param movref the MOVREF value
	 */
	public void setMovref (java.lang.String movref) {
		this.movref = movref;
	}
	
	
	/**
	 * Return the value associated with the column: acttotimeinmillis
	 */
	public java.lang.Long getActtotimeinmillis () {
		return acttotimeinmillis;
	}
	
	/**
	 * Set the value related to the column: acttotimeinmillis
	 * @param acttotimeinmillis the acttotimeinmillis value
	 */
	public void setActtotimeinmillis (java.lang.Long acttotimeinmillis) {
		this.acttotimeinmillis = acttotimeinmillis;
	}
	
	/**
	 * Return the value associated with the column: actfromtimeinmillis
	 */
	public java.lang.Long getActfromtimeinmillis () {
		return actfromtimeinmillis;
	}
	
	/**
	 * Set the value related to the column: actfromtimeinmillis
	 * @param actfromtimeinmillis the actfromtimeinmillis value
	 */
	public void setActfromtimeinmillis (java.lang.Long actfromtimeinmillis) {
		this.actfromtimeinmillis = actfromtimeinmillis;
	}
	
	/**
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return txt;
	}
	
	/**
	 * Set the value related to the column: TXT
	 * @param txt the TXT value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}

	/**
	 * Return the value associated with the column: TXT2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}
	
	/**
	 * Set the value related to the column: TXT2
	 * @param txt2 the TXT2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}

	/**
	 * Return the value associated with the column: TXT3
	 */
	public java.lang.String getTxt3 () {
		return txt3;
	}
	
	/**
	 * Set the value related to the column: TXT3
	 * @param txt3 the TXT3 value
	 */
	public void setTxt3 (java.lang.String txt3) {
		this.txt3 = txt3;
	}
	
	/**
	 * Return the value associated with the column: acttotime
	 */
	public java.lang.String getActtotime () {
		return acttotime;
	}
	
	/**
	 * Set the value related to the column: acttotime
	 * @param acttotime the acttotime value
	 */
	public void setActtotime (java.lang.String acttotime) {
		this.acttotime = acttotime;
	}
	
	
	/**
	 * Return the value associated with the column: actfromtime
	 */
	public java.lang.String getActfromtime () {
		return actfromtime;
	}
	
	/**
	 * Set the value related to the column: actfromtime
	 * @param actfromtime the actfromtime value
	 */
	public void setActfromtime (java.lang.String actfromtime) {
		this.actfromtime = actfromtime;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: lloydsnumber
	 */
	public java.lang.String getLloydsnumber () {
		return lloydsnumber;
	}
	
	/**
	 * Set the value related to the column: lloydsnumber
	 * @param lloydsnumber the lloydsnumber value
	 */
	public void setLloydsnumber (java.lang.String lloydsnumber) {
		this.lloydsnumber = lloydsnumber;
	}
	
	
	
	/**
	 * Return the value associated with the column: billoflading
	 */
	public java.lang.String getBilloflading () {
		return billoflading;
	}
	
	/**
	 * Set the value related to the column: billoflading
	 * @param billoflading the billoflading value
	 */
	public void setBilloflading (java.lang.String billoflading) {
		this.billoflading = billoflading;
	}
	
	
	
	
	
	/**
	 * Return the value associated with the column: VSBKCONTACT
	 */
	public java.lang.String getVsbkcontact () {
		return vsbkcontact;
	}
	
	/**
	 * Set the value related to the column: VSBKCONTACT
	 * @param vsbkcontact the VSBKCONTACT value
	 */
	public void setVsbkcontact (java.lang.String vsbkcontact) {
		this.vsbkcontact = vsbkcontact;
	}
	
	
	/**
	 * Return the value associated with the column: VESSEL
	 */
	public java.lang.String getVessel () {
		return vessel;
	}
	
	/**
	 * Set the value related to the column: VESSEL
	 * @param vessel the VESSEL value
	 */
	public void setVessel (java.lang.String vessel) {
		this.vessel = vessel;
	}
	
	
	
	/**
	 * Return the value associated with the column: BOOKKEY
	 */
	public java.lang.String getBookkey () {
		return bookkey;
	}
	
	/**
	 * Set the value related to the column: BOOKKEY
	 * @param bookkey the BOOKKEY value
	 */
	public void setBookkey (java.lang.String bookkey) {
		this.bookkey = bookkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: VSBKREF
	 */
	public java.lang.String getVsbkref () {
		return vsbkref;
	}
	
	/**
	 * Set the value related to the column: VSBKREF
	 * @param vsbkref the VSBKREF value
	 */
	public void setVsbkref (java.lang.String vsbkref) {
		this.vsbkref = vsbkref;
	}
	
	
	/**
	 * Return the value associated with the column: VOYAGE
	 */
	public java.lang.String getVoyage () {
		return voyage;
	}
	
	/**
	 * Set the value related to the column: VOYAGE
	 * @param voyage the VOYAGE value
	 */
	public void setVoyage (java.lang.String voyage) {
		this.voyage = voyage;
	}
	
	
	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}
	
	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: weightactualunit
	 */
	public java.lang.String getWeightactualunit () {
		return weightactualunit;
	}
	
	/**
	 * Set the value related to the column: weightactualunit
	 * @param weightactualunit the weightactualunit value
	 */
	public void setWeightactualunit (java.lang.String weightactualunit) {
		this.weightactualunit = weightactualunit;
	}
	
	
	
	/**
	 * Return the value associated with the column: weightactual
	 */
	public java.math.BigDecimal getWeightactual () {
		return weightactual;
	}
	
	/**
	 * Set the value related to the column: weightactual
	 * @param weightactual the weightactual value
	 */
	public void setWeightactual (java.math.BigDecimal weightactual) {
		this.weightactual = weightactual;
	}
	

	/**
	 * 
	 */
	public Unit getUnit () {return _unit;}
	/**
	 */
	public void setUnit (Unit _unit) {this._unit = _unit;}
	

	
	/**
	 */
	public String getCustomeraddrkey() {
		return (this._customeraddrkey);
	}
	/**
	 */
	public void setCustomeraddrkey(String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}
	
	/**
	 */
	public Address getCustomeraddr () {
		return _customeraddr;
	}
	
	/**
	 */
	public void setCustomeraddr(Address _customeraddr) {
		this._customeraddr = _customeraddr;
	}
	
	
}

