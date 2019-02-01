package com.bureaueye.beacon.model.purchaseinvoice.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;






public final class PihdrdtlDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public PihdrdtlDTO(Pihdr pihdr, Pidtl pidtl) throws ApplicationException {
		initialize(pihdr, pidtl);		
	}
	public PihdrdtlDTO(Pihdr pihdr, Pidtl pidtl, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(pihdr, pidtl);
	}

	
	protected void initialize (Pihdr pihdr, Pidtl pidtl) throws ApplicationException {
		
		//init business delegates
		AddressBD addressbd=new AddressBD(this.getSessionFactoryClusterMap());
		PihdrBD pihdrbd=new PihdrBD(this.getSessionFactoryClusterMap());
		
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(addressbd.read(pihdr.getVendoraddrkey()));
		
		//header
		this.setPihdrId(pihdr.getPihdrId());
		this.setPino(pihdr.getPino());
		this.setCreatedate(pihdr.getCreatedate());
		this.setInvoicedate(pihdr.getInvoicedate());		
		this.setCcykey(pihdr.getCcykey());
		this.setGrossamt(pihdr.getGrossamt());
		this.setNetamt(pihdr.getNetamt());		
		this.setVendorref(pihdr.getVendorref());
		this.setApprovedflag(pihdr.isApprovedflag());
		this.setPostedflag(pihdr.isPostedflag());		
		this.setInvoicestatus(pihdr.getInvoicestatus());	
		this.setTxt1(pihdr.getTxt1());
		this.setMiscflag(pihdr.isMiscflag());
		
		//detail
		this.setPidtlId(pidtl.getPidtlId());		
		this.setUnitkey(pidtl.getUnitkey());
		this.setUnitId(pidtl.getUnitId());	
		this.setJobno(pidtl.getJobno());
		this.setOrderno(pidtl.getOrderno());		
		this.setJobhdrId(pidtl.getJobhdrId());
		
		
		this.pidtlssize = 1;
/*		try {
			List dtos = pihdrbd.getPidtls(pihdr.getPihdrId());
			if (dtos != null) this.pidtlssize = dtos.size();
		} catch (Exception ae) {}	*/
		
		//clear objects
		pihdrbd=null;
		addressbd=null;
		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	// extra
	private int pidtlssize;
    
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getPidtlssize() {return pidtlssize;}
	public void setPidtlssize(int pidtlssize) {this.pidtlssize = pidtlssize;}

	
	
	
	// primary key
	private java.lang.Integer pihdrId;

	// fields
	private java.util.Date createdate;
	private java.util.Date invoicedate;
	private java.lang.String txt1;
	private java.lang.String pino;
	private java.lang.String ccykey;
	private java.math.BigDecimal grossamt;
	private java.math.BigDecimal netamt;	
	private java.lang.String vendorref;
	private boolean approvedflag;
	private boolean postedflag;	
	private java.lang.String invoicestatus;
	private boolean miscflag;		
	private Address vendoraddrkey;


	
	//PIDTL fields
	private java.lang.Integer pidtlId;
	private java.math.BigDecimal invoiceamt;
	private java.math.BigDecimal cstamt;	
	private java.lang.String disputemessage;
	private java.lang.String costkey;	
	private java.lang.String jobno;
	private java.lang.String orderno;	
	private java.lang.Integer jobhdrId;	
	private java.lang.Integer unitId;
	private java.lang.String unitkey;
	

	
	
	

	/**
     */
	public java.lang.Integer getPihdrId () {
		return pihdrId;
	}

	/**
	 */
	public void setPihdrId (java.lang.Integer pihdrId) {
		this.pihdrId = pihdrId;
	}











	public boolean isApprovedflag() {
		return approvedflag;
	}
	public void setApprovedflag(boolean approvedflag) {
		this.approvedflag = approvedflag;
	}


	public boolean isPostedflag() {
		return postedflag;
	}
	public void setPostedflag(boolean postedflag) {
		this.postedflag = postedflag;
	}

	public boolean isMiscflag() {
		return miscflag;
	}
	public void setMiscflag(boolean miscflag) {
		this.miscflag = miscflag;
	}
	
	

	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate() {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}
	

	/**
	 */
	public java.util.Date getInvoicedate() {
		return invoicedate;
	}

	/**
	 */
	public void setInvoicedate(java.util.Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	
	/**
	 */
	public java.lang.String getInvoicestatus () {
		return invoicestatus;
	}
	/**
	 */
	public void setInvoicestatus (java.lang.String invoicestatus) {
		this.invoicestatus = invoicestatus;
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
	 */
	public java.lang.String getPino() {
		return pino;
	}

	/**
	 */
	public void setPino(java.lang.String pino) {
		this.pino = pino;
	}
	
	/**
	 */
	public java.lang.String getVendorref () {
		return vendorref;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setVendorref (java.lang.String vendorref) {
		this.vendorref = vendorref;
	}
	


	/**
	 */
	public java.math.BigDecimal getGrossamt () {
		return grossamt;
	}
	/**
	 */
	public void setGrossamt (java.math.BigDecimal grossamt) {
		this.grossamt = grossamt;
	}



	/**
	 */
	public java.math.BigDecimal getNetamt () {
		return netamt;
	}
	/**
	 */
	public void setNetamt (java.math.BigDecimal netamt) {
		this.netamt = netamt;
	}
	





	/**
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}







	/**
	 */
	public Address getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 */
	public void setVendoraddrkey (Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
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
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
	}






	/**
	 */
	public java.lang.String getJobno () {
		return jobno;
	}
	/**
	 */
	public void setJobno (java.lang.String jobno) {
		this.jobno = jobno;
	}


	/**
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}
	/**
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}
	


	/**
	 */
	public java.lang.String getCostkey() {
		return costkey;
	}
	/**
	 */
	public void setCostkey(java.lang.String costkey) {
		this.costkey = costkey;
	}


	/**
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}
	/**
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}
	/**
	 */
	public java.lang.String getUnitkey() {
		return unitkey;
	}
	/**
	 */
	public void setUnitkey(java.lang.String unitkey) {
		this.unitkey = unitkey;
	}
	

	/**
	 */
	public java.math.BigDecimal getInvoiceamt () {
		return invoiceamt;
	}
	/**
	 */
	public void setInvoiceamt (java.math.BigDecimal invoiceamt) {
		this.invoiceamt = invoiceamt;
	}



	/**
	 */
	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}
	/**
	 */
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
	}



	/**
	 */
	public java.lang.String getDisputemessage () {
		return disputemessage;
	}

	/**
	 */
	public void setDisputemessage (java.lang.String disputemessage) {
		this.disputemessage = disputemessage;
	}
	



	
	
	
	
	
}
