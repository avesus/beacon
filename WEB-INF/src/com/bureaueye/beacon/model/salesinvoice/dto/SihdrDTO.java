package com.bureaueye.beacon.model.salesinvoice.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;





public final class SihdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public SihdrDTO(Sihdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public SihdrDTO(Sihdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Sihdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setCustomeraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey()));
		this.setSihdrId(dao.getSihdrId());
		this.setCreatedate(dao.getCreatedate());
		this.setInvoiceno(dao.getInvoiceno());
		this.setPrintdate(dao.getPrintdate());
		this.setInvoiceccykey(dao.getInvoiceccykey());
		this.setInvoiceamt(dao.getInvoiceamt());	
		this.setPrintedflag(dao.isPrintedflag());
		this.setManualflag(dao.isManualflag());	
		this.setInvoiceamt(dao.getInvoiceamt());	
		
		this.sidtlssize = 0;
		try {
			List<Sidtl> daos = new SihdrBD(this.getSessionFactoryClusterMap()).getSidtls(dao.getSihdrId());
			if (daos != null) this.sidtlssize = daos.size();
		} catch (Exception ae) {}		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	// extra
	private int sidtlssize;
    
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getSidtlssize() {return sidtlssize;}
	public void setSidtlssize(int sidtlssize) {this.sidtlssize = sidtlssize;}

	
	
	
	// primary key
	private java.lang.Integer sihdrId;

	// fields
	private java.lang.String reasonkey;
	private boolean mainchargeflag;
	private java.lang.String departmentkey;
	private boolean manualflag;
	private java.lang.Integer batchId;
	private java.lang.String languagekey;
	private java.lang.String companykey;
	private java.lang.String invoiceno;
	private boolean confirmedflag;
	private java.lang.String unitkey;
	private java.util.Date posteddate;
	private java.util.Date createdate;
	private java.util.Date confirmeddate;
	private java.lang.String invoicegroupref;
	private java.lang.String invoiceref;
	private boolean printedflag;
	private boolean deleteflag;
	private java.lang.String txt1;
	private java.lang.String paymentterm;
	private java.util.Date printdate;
	private java.math.BigDecimal invoiceamt;
	private java.lang.String txt2;
	private java.lang.String customerref;
	private java.lang.String taxcode;
	private java.lang.String printtime;
	private boolean postedflag;
	private java.lang.String activitykey;
	private java.lang.String invoiceccykey;
	private java.lang.String periodposted;
	private boolean rechargeflag;
	private java.lang.String rectype;
	private java.lang.String orderno;
	private Address customeraddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SIHDR_ID"
     */
	public java.lang.Integer getSihdrId () {
		return sihdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sihdrId the new ID
	 */
	public void setSihdrId (java.lang.Integer sihdrId) {
		this.sihdrId = sihdrId;
	}







	/**
	 * Return the value associated with the column: reasonkey
	 */
	public java.lang.String getReasonkey () {
		return reasonkey;
	}

	/**
	 * Set the value related to the column: reasonkey
	 * @param reasonkey the reasonkey value
	 */
	public void setReasonkey (java.lang.String reasonkey) {
		this.reasonkey = reasonkey;
	}








	/**
	 * Return the value associated with the column: mainchargeflag
	 */
	public boolean isMainchargeflag () {
		return mainchargeflag;
	}

	/**
	 * Set the value related to the column: mainchargeflag
	 * @param mainchargeflag the mainchargeflag value
	 */
	public void setMainchargeflag (boolean mainchargeflag) {
		this.mainchargeflag = mainchargeflag;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: manualflag
	 */
	public boolean isManualflag () {
		return manualflag;
	}

	/**
	 * Set the value related to the column: manualflag
	 * @param manualflag the manualflag value
	 */
	public void setManualflag (boolean manualflag) {
		this.manualflag = manualflag;
	}





	/**
	 * Return the value associated with the column: BATCH_ID
	 */
	public java.lang.Integer getBatchId () {
		return batchId;
	}

	/**
	 * Set the value related to the column: BATCH_ID
	 * @param batchId the BATCH_ID value
	 */
	public void setBatchId (java.lang.Integer batchId) {
		this.batchId = batchId;
	}



	/**
	 * Return the value associated with the column: languagekey
	 */
	public java.lang.String getLanguagekey () {
		return languagekey;
	}

	/**
	 * Set the value related to the column: languagekey
	 * @param languagekey the languagekey value
	 */
	public void setLanguagekey (java.lang.String languagekey) {
		this.languagekey = languagekey;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}





	/**
	 * Return the value associated with the column: invoiceno
	 */
	public java.lang.String getInvoiceno () {
		return invoiceno;
	}

	/**
	 * Set the value related to the column: invoiceno
	 * @param invoiceno the invoiceno value
	 */
	public void setInvoiceno (java.lang.String invoiceno) {
		this.invoiceno = invoiceno;
	}



	/**
	 * Return the value associated with the column: confirmedflag
	 */
	public boolean isConfirmedflag () {
		return confirmedflag;
	}

	/**
	 * Set the value related to the column: confirmedflag
	 * @param confirmedflag the confirmedflag value
	 */
	public void setConfirmedflag (boolean confirmedflag) {
		this.confirmedflag = confirmedflag;
	}



	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: posteddate
	 */
	public java.util.Date getPosteddate () {
		return posteddate;
	}

	/**
	 * Set the value related to the column: posteddate
	 * @param posteddate the posteddate value
	 */
	public void setPosteddate (java.util.Date posteddate) {
		this.posteddate = posteddate;
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
	 * Return the value associated with the column: confirmeddate
	 */
	public java.util.Date getConfirmeddate () {
		return confirmeddate;
	}

	/**
	 * Set the value related to the column: confirmeddate
	 * @param confirmeddate the confirmeddate value
	 */
	public void setConfirmeddate (java.util.Date confirmeddate) {
		this.confirmeddate = confirmeddate;
	}



	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref () {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * @param invoicegroupref the invoicegroupref value
	 */
	public void setInvoicegroupref (java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
	}



	/**
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref () {
		return invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * @param invoiceref the invoiceref value
	 */
	public void setInvoiceref (java.lang.String invoiceref) {
		this.invoiceref = invoiceref;
	}





	/**
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag () {
		return printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * @param printedflag the printedflag value
	 */
	public void setPrintedflag (boolean printedflag) {
		this.printedflag = printedflag;
	}



	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag () {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param deleteflag the deleteflag value
	 */
	public void setDeleteflag (boolean deleteflag) {
		this.deleteflag = deleteflag;
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
	 * Return the value associated with the column: paymentterm
	 */
	public java.lang.String getPaymentterm () {
		return paymentterm;
	}

	/**
	 * Set the value related to the column: paymentterm
	 * @param paymentterm the paymentterm value
	 */
	public void setPaymentterm (java.lang.String paymentterm) {
		this.paymentterm = paymentterm;
	}



	/**
	 * Return the value associated with the column: printdate
	 */
	public java.util.Date getPrintdate () {
		return printdate;
	}

	/**
	 * Set the value related to the column: printdate
	 * @param printdate the printdate value
	 */
	public void setPrintdate (java.util.Date printdate) {
		this.printdate = printdate;
	}



	/**
	 * Return the value associated with the column: invoiceamt
	 */
	public java.math.BigDecimal getInvoiceamt () {
		return invoiceamt;
	}

	/**
	 * Set the value related to the column: invoiceamt
	 * @param invoiceamt the invoiceamt value
	 */
	public void setInvoiceamt (java.math.BigDecimal invoiceamt) {
		this.invoiceamt = invoiceamt;
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



	/**
	 * Return the value associated with the column: customerref
	 */
	public java.lang.String getCustomerref () {
		return customerref;
	}

	/**
	 * Set the value related to the column: customerref
	 * @param customerref the customerref value
	 */
	public void setCustomerref (java.lang.String customerref) {
		this.customerref = customerref;
	}



	/**
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * @param taxcode the taxcode value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
	}



	/**
	 * Return the value associated with the column: printtime
	 */
	public java.lang.String getPrinttime () {
		return printtime;
	}

	/**
	 * Set the value related to the column: printtime
	 * @param printtime the printtime value
	 */
	public void setPrinttime (java.lang.String printtime) {
		this.printtime = printtime;
	}



	/**
	 * Return the value associated with the column: postedflag
	 */
	public boolean isPostedflag () {
		return postedflag;
	}

	/**
	 * Set the value related to the column: postedflag
	 * @param postedflag the postedflag value
	 */
	public void setPostedflag (boolean postedflag) {
		this.postedflag = postedflag;
	}



	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
	}



	/**
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey () {
		return invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * @param invoiceccykey the invoiceccykey value
	 */
	public void setInvoiceccykey (java.lang.String invoiceccykey) {
		this.invoiceccykey = invoiceccykey;
	}



	/**
	 * Return the value associated with the column: periodposted
	 */
	public java.lang.String getPeriodposted () {
		return periodposted;
	}

	/**
	 * Set the value related to the column: periodposted
	 * @param periodposted the periodposted value
	 */
	public void setPeriodposted (java.lang.String periodposted) {
		this.periodposted = periodposted;
	}






	/**
	 * Return the value associated with the column: rechargeflag
	 */
	public boolean isRechargeflag () {
		return rechargeflag;
	}

	/**
	 * Set the value related to the column: rechargeflag
	 * @param rechargeflag the rechargeflag value
	 */
	public void setRechargeflag (boolean rechargeflag) {
		this.rechargeflag = rechargeflag;
	}



	/**
	 * Return the value associated with the column: rectype
	 */
	public java.lang.String getRectype () {
		return rectype;
	}

	/**
	 * Set the value related to the column: rectype
	 * @param rectype the rectype value
	 */
	public void setRectype (java.lang.String rectype) {
		this.rectype = rectype;
	}



	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * @param orderno the orderno value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}







	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public Address getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (Address customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}
	
	
	
	
}
