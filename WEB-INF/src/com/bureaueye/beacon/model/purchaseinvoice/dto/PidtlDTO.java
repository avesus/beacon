package com.bureaueye.beacon.model.purchaseinvoice.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;






public final class PidtlDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public PidtlDTO(Pidtl dao) throws ApplicationException {
		initialize(dao);		
	}
	public PidtlDTO(Pidtl dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Pidtl dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setTxt1(dao.getTxt1());
		this.setTxt2(dao.getTxt2());
		this.setInvoiceamt(dao.getInvoiceamt());

		this.setCstamt(dao.getCstamt());
		this.setCostkey(dao.getCostkey());

		this.setUnitkey(dao.getUnitkey());
		this.setUnitId(dao.getUnitId());
		
		this.setJobno(dao.getJobno());
		this.setOrderno(dao.getOrderno());		
		this.setJobhdrId(dao.getJobhdrId());

		this.setInvoicestatus(dao.getInvoicestatus());
		this.setApprovedflag(dao.isApprovedflag());
		this.setDisputemessage(dao.getDisputemessage());
		
		this.setPidtlId(dao.getPidtlId());
		this.setPihdrId(dao.getPihdrId());
	}
	


	// primary key
	private java.lang.Integer pidtlId;

	// fields
	private java.math.BigDecimal invoiceamt;
	private java.math.BigDecimal cstamt;
	
	private boolean approvedflag;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String disputemessage;
	private java.lang.String invoicestatus;
	private java.lang.String costkey;
	
	private java.lang.String jobno;
	private java.lang.String orderno;	
	private java.lang.Integer jobhdrId;
	
	private java.lang.Integer unitId;
	private java.lang.String unitkey;
	
	private java.lang.Integer pihdrId;

	

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
	public java.lang.String getInvoicestatus() {
		return invoicestatus;
	}
	/**
	 */
	public void setInvoicestatus(java.lang.String invoicestatus) {
		this.invoicestatus = invoicestatus;
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
	public java.lang.Integer getPihdrId () {
		return pihdrId;
	}

	/**
	 */
	public void setPihdrId (java.lang.Integer pihdrId) {
		this.pihdrId = pihdrId;
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
	public boolean isApprovedflag () {
		return approvedflag;
	}

	/**
	 * Set the value related to the column: confirmedflag
	 * @param confirmedflag the confirmedflag value
	 */
	public void setApprovedflag (boolean approvedflag) {
		this.approvedflag = approvedflag;
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










	
	
}
