package com.bureaueye.beacon.model.purchaseinvoice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;






public final class PidtlcostDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public PidtlcostDTO() throws ApplicationException {		
	}	
	public PidtlcostDTO(Pidtlcost dao) throws ApplicationException {
		initialize(dao);		
	}
	public PidtlcostDTO(Pidtlcost dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}



	protected void initialize (Pidtlcost dao) throws ApplicationException {

		// populate data-transfer-object from data-access-object
		this.setCstamtalloc(dao.getCstamtalloc());
		this.setTxt1(dao.getTxt1());
		this.setCstamttotal(dao.getCstamttotal());

		this.setPidtlcostId(dao.getPidtlcostId());
		this.setPidtlId(dao.getPidtlId());
		this.setJobcostId(dao.getJobcostId());
		
		CostBD costbd=new CostBD(this.getSessionFactoryClusterMap());		
		try{this.setCostkey(costbd.read(dao.getCostkey()));}catch(Exception e){}
		costbd=null;	

		PidtlcostBD pidtlcostbd=new PidtlcostBD(this.getSessionFactoryClusterMap());	
		try{this.setCstamtalloctotal(pidtlcostbd.pidtlcostsCstamtallocSumByJobcostid(this.getJobcostId()));}catch(Exception e){}
		pidtlcostbd=null;
		
	}


	public PidtlcostDTO (
			BigDecimal _cstamtalloc,
			String _txt1,
			BigDecimal _cstamttotal,
			String _costkey,
			Integer _pidtlcostId,
			Integer _pidtlId,
			String _vendoraddrkey,
			String _ccykey,
			String _pino,
			String _vendorref,
			String _jobno,
			String _baseccykey,
			String _orderno
	) {

		this.cstamtalloc = _cstamtalloc;
		this.cstamttotal = _cstamttotal;				
		this.txt1 = _txt1;
		this.costkey2 = _costkey;
		this.vendoraddrkey2 = _vendoraddrkey;
		
		this.ccykey = _ccykey;
		this.baseccykey = _baseccykey;
		
		this.pidtlcostId = _pidtlcostId;
		this.pidtlId = _pidtlId;	

		this.jobno = _jobno;		
		this.vendorref = _vendorref;		
		this.pino = _pino;		
		this.orderno = _orderno;		
		
		AddressBD addressbd=new AddressBD(this.getSessionFactoryClusterMap());
		CostBD costbd=new CostBD(this.getSessionFactoryClusterMap());		
		try{this.setCostkey(costbd.read(_costkey));}catch(Exception e){}
		try{this.setVendoraddrkey(addressbd.read(_vendoraddrkey));}catch(Exception e){}
		addressbd=null;
		costbd=null;					

		
		//exrate lookup
		CcyexBD ccyexbd=new CcyexBD(this.getSessionFactoryClusterMap());		
		ListForm ccyexListForm = new ListForm();
		ccyexListForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
		ccyexListForm.setGotoPage(0);
		ccyexListForm.setSearchDate1(new Date());
		ccyexListForm.setOrderBy("Exdate");
		ccyexListForm.setOrderByDesc("Desc");
		//to base ccy
		ccyexListForm.setSearchString2(_baseccykey);
		this.baseexrate = new BigDecimal(1);
		this.cstamtallocbase = _cstamtalloc;		
		try {						
			ccyexListForm.setSearchString1(_ccykey);//from ccy
			this.baseexrate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
			this.cstamtallocbase = (_cstamtalloc.multiply(this.baseexrate));
		} catch (Exception ae) {}
		ccyexbd=null;
		
	}	


	// primary key
	private java.lang.Integer pidtlcostId;
	private java.lang.Integer pidtlId;


	// fields
	private java.lang.Integer jobcostId;
	
	private java.math.BigDecimal cstamttotal;
	private java.math.BigDecimal cstamtalloc;
	private java.math.BigDecimal cstamtalloctotal;
	
	private java.math.BigDecimal cstamtallocbase;
	private java.math.BigDecimal baseexrate;	

	private Cost costkey;
	private java.lang.String costkey2;

	private java.lang.String txt1;
	private java.lang.String txt2;

	private Address vendoraddrkey;
	private java.lang.String vendoraddrkey2;

	private java.lang.String ccykey;
	private java.lang.String baseccykey;
	
	private java.lang.String pino;
	private java.lang.String vendorref;	
	private java.lang.String orderno;
	
	private java.lang.String jobno;	
	
	
	
	/**
	 */
	public java.lang.Integer getPidtlcostId () {
		return pidtlcostId;
	}

	/**
	 */
	public void setPidtlcostId (java.lang.Integer pidtlcostId) {
		this.pidtlcostId = pidtlcostId;
	}


	/**
	 */
	public java.lang.Integer getPidtlId () {
		return pidtlId;
	}
	/**
	 */
	public void setPidtlId (java.lang.Integer pidtlId) {
		this.pidtlId = pidtlId;
	}



	/**
	 */
	public java.lang.Integer getJobcostId () {
		return jobcostId;
	}
	public void setJobcostId (java.lang.Integer jobcostId) {
		this.jobcostId = jobcostId;
	}
	

	/**
	 */
	public java.math.BigDecimal getCstamtalloctotal () {
		return cstamtalloctotal;
	}
	public void setCstamtalloctotal (java.math.BigDecimal cstamtalloctotal) {
		this.cstamtalloctotal = cstamtalloctotal;
	}
	


	/**
	 */
	public java.math.BigDecimal getCstamttotal () {
		return cstamttotal;
	}
	/**
	 */
	public void setCstamttotal (java.math.BigDecimal cstamttotal) {
		this.cstamttotal = cstamttotal;
	}


	public java.math.BigDecimal getCstamtalloc () {
		return cstamtalloc;
	}
	public void setCstamtalloc (java.math.BigDecimal cstamtalloc) {
		this.cstamtalloc = cstamtalloc;
	}

	public java.math.BigDecimal getCstamtallocbase () {
		return cstamtallocbase;
	}
	public void setCstamtallocbase (java.math.BigDecimal cstamtallocbase) {
		this.cstamtallocbase = cstamtallocbase;
	}
	
	public java.math.BigDecimal getBaseexrate () {
		return baseexrate;
	}
	public void setBaserate (java.math.BigDecimal baseexrate) {
		this.baseexrate = baseexrate;
	}
	
	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String txt1) {
		this.txt1 = txt1;
	}



	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}





	public Cost getCostkey () {
		return costkey;
	}
	public void setCostkey (Cost costkey) {
		this.costkey = costkey;
	}

	public java.lang.String getCostkey2() {
		return costkey2;
	}
	public void setCostkey2 (java.lang.String costkey2) {
		this.costkey2 = costkey2;
	}



	public java.lang.String getCcykey () {
		return ccykey;
	}
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}
	
	public java.lang.String getBaseccykey () {
		return baseccykey;
	}
	public void setBaseccykey (java.lang.String baseccykey) {
		this.baseccykey = baseccykey;
	}
	
	

	public Address getVendoraddrkey () {
		return vendoraddrkey;
	}
	public void setVendoraddrkey (Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}	

	public java.lang.String getVendoraddrkey2 () {
		return vendoraddrkey2;
	}
	public void setVendoraddrkey2 (java.lang.String vendoraddrkey2) {
		this.vendoraddrkey2 = vendoraddrkey2;
	}


	public java.lang.String getPino () {
		return pino;
	}
	public void setPino (java.lang.String pino) {
		this.pino = pino;
	}
	
	public java.lang.String getVendorref () {
		return vendorref;
	}
	public void setVendorref (java.lang.String vendorref) {
		this.vendorref = vendorref;
	}

	public java.lang.String getJobno () {
		return jobno;
	}
	public void setJobno (java.lang.String jobno) {
		this.jobno = jobno;
	}

	public java.lang.String getOrderno () {
		return orderno;
	}
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}
	
	
}
