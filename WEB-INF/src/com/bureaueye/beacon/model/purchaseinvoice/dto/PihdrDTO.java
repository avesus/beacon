package com.bureaueye.beacon.model.purchaseinvoice.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;






public final class PihdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public PihdrDTO(Pihdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public PihdrDTO(Pihdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Pihdr dao) throws ApplicationException {
		
		//init business delegates
		AddressBD addressbd=new AddressBD(this.getSessionFactoryClusterMap());
		PihdrBD pihdrbd=new PihdrBD(this.getSessionFactoryClusterMap());
		
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(addressbd.read(dao.getVendoraddrkey()));
		
		this.setPihdrId(dao.getPihdrId());
		this.setPino(dao.getPino());
		this.setCreatedate(dao.getCreatedate());
		this.setInvoicedate(dao.getInvoicedate());		
		this.setCcykey(dao.getCcykey());
		this.setGrossamt(dao.getGrossamt());
		this.setNetamt(dao.getNetamt());		
		this.setVendorref(dao.getVendorref());
		this.setApprovedflag(dao.isApprovedflag());
		this.setPostedflag(dao.isPostedflag());		
		this.setInvoicestatus(dao.getInvoicestatus());	
		this.setTxt1(dao.getTxt1());
		
		this.pidtlssize = 0;
		try {
			List dtos = pihdrbd.getPidtls(dao.getPihdrId());
			if (dtos != null) this.pidtlssize = dtos.size();
		} catch (Exception ae) {}	
		
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
	
	private Address vendoraddrkey;



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
	


	
	
	
}
