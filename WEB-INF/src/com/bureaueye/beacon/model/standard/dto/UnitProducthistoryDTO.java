package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Date;

import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Product;


public class UnitProducthistoryDTO extends BaseDTO implements Serializable {

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
	
	private Product _product = new Product();
	private Address _customer = new Address();
	
	private String _productkey;
	private String _customeraddrkey;
	
	private java.lang.String _orderno;
	private java.lang.String _movref;
	private java.lang.String _vessel;
	private java.lang.String _unit;
	private java.lang.String _invsts;

	private String _testtype;
	private String _testflag;
	private Date _testduedate;	

	

	public UnitProducthistoryDTO (Jobhdr jobhdr, Orderhdr orderhdr) {
			this._productkey = jobhdr.getProductkey();
			this._customeraddrkey = orderhdr.getCustomeraddrkey();
			this._movref = jobhdr.getMovref();

			this._jobhdrId = jobhdr.getJobhdrId().toString();
			this._orderhdrId = jobhdr.getOrderhdrId().toString();
			this._orderno = orderhdr.getOrderno();
	}
	
	
	public UnitProducthistoryDTO () {}
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}


	/**
	 * 
	 */
	public Product getProduct () {return _product;}
	/**
	 */
	public void setProduct (Product _product) {this._product = _product;}
	
	/**
	 * 
	 */
	public Address getCustomer () {return _customer;}
	/**
	 */
	public void setCustomer (Address _customer) {this._customer = _customer;}


	/**
     */
	public java.lang.String getCustomeraddrkey () {return _customeraddrkey;}
	public void setCustomeraddrkey (java.lang.String _customeraddrkey) {this._customeraddrkey = _customeraddrkey;}
	
	/**
     */
	public java.lang.String getProductkey () {return _productkey;}
	public void setProductkey (java.lang.String _productkey) {this._productkey = _productkey;}
	
	
	/**
     */
	public java.lang.String getJobmovId () {return _jobmovId;}
	public void setJobmovId (java.lang.String _jobmovId) {this._jobmovId = _jobmovId;}

	/**
     */
	public java.lang.String getInvsts() {return _invsts;}
	public void setInvsts(java.lang.String _invsts) {this._invsts = _invsts;}
	

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

	
	
	

	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
}
