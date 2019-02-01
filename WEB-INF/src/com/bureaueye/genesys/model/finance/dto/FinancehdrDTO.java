package com.bureaueye.genesys.model.finance.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.genesys.model.finance.Financehdr;








public final class FinancehdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public FinancehdrDTO(Financehdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public FinancehdrDTO(Financehdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Financehdr dao) throws ApplicationException {
		
		// populate data-transfer-object from data-access-object
		this.setLesseeaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getLesseeaddrkey()));

		this.setFinancehdrId(dao.getFinancehdrId());
		this.setContractno(dao.getContractno());
		
		this.setDocdate(dao.getDocdate());
		this.setCreatedate(dao.getCreatedate());
		this.setPrintdate(dao.getPrintdate());
		
		this.setDoctypekey(dao.getDoctypekey());
		this.setDockey(dao.getDockey());
		
		this.setCcykey(dao.getCcykey());
		this.setGrossamount(dao.getGrossamount());
		this.setNetamount(dao.getNetamount());
		
		this.setManualflag(dao.isManualflag());
		this.setPrintedflag(dao.isPrintedflag());
		
	}
	
	
	
	
	private String readonly = "false";
	
	
	// primary key
	private java.lang.Integer financehdrId;

	// fields
	private String contractno;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	private java.math.BigDecimal netamount;
	private java.lang.String ccykey;
	private java.util.Date createdate;
	private java.lang.String doctypekey;
	private java.lang.String createtime;
	private java.util.Date billdate;
	private java.util.Date printdate;
	private boolean xinactive;
	private java.math.BigDecimal cashalloctotal;
	private java.lang.String leasetypekey;
	private java.lang.Integer contractId;
	private java.util.Date postdate;
	private java.util.Date docdate;
	private java.math.BigDecimal grossamount;
	private java.lang.String companykey;
	private java.math.BigDecimal cashallocpayout;
	private java.lang.String dockey;
	private java.math.BigDecimal vatamount;
	private boolean pyodoneflag;
	private boolean printedflag;
	private boolean manualflag;
	private java.math.BigDecimal payoutamount;
	private java.lang.String createuserid;

	// many-to-one
	private Address lesseeaddrkey;

	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	

	/**
     */
	public java.lang.Integer getFinancehdrId () {
		return financehdrId;
	}

	/**
	 */
	public void setFinancehdrId (java.lang.Integer financehdrId) {
		this.financehdrId = financehdrId;
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
	 * Return the value associated with the column: netamount
	 */
	public java.math.BigDecimal getNetamount () {
		return netamount;
	}

	/**
	 * Set the value related to the column: netamount
	 * @param netamount the netamount value
	 */
	public void setNetamount (java.math.BigDecimal netamount) {
		this.netamount = netamount;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}





	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: doctypekey
	 */
	public java.lang.String getDoctypekey () {
		return doctypekey;
	}

	/**
	 * Set the value related to the column: doctypekey
	 * @param doctypekey the doctypekey value
	 */
	public void setDoctypekey (java.lang.String doctypekey) {
		this.doctypekey = doctypekey;
	}






	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: billdate
	 */
	public java.util.Date getBilldate () {
		return billdate;
	}

	/**
	 * Set the value related to the column: billdate
	 * @param billdate the billdate value
	 */
	public void setBilldate (java.util.Date billdate) {
		this.billdate = billdate;
	}






	/**
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (boolean xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: cashalloctotal
	 */
	public java.math.BigDecimal getCashalloctotal () {
		return cashalloctotal;
	}

	/**
	 * Set the value related to the column: cashalloctotal
	 * @param cashalloctotal the cashalloctotal value
	 */
	public void setCashalloctotal (java.math.BigDecimal cashalloctotal) {
		this.cashalloctotal = cashalloctotal;
	}



	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
	}



	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}



	/**
	 * Return the value associated with the column: postdate
	 */
	public java.util.Date getPostdate () {
		return postdate;
	}

	/**
	 * Set the value related to the column: postdate
	 * @param postdate the postdate value
	 */
	public void setPostdate (java.util.Date postdate) {
		this.postdate = postdate;
	}



	/**
	 * Return the value associated with the column: docdate
	 */
	public java.util.Date getDocdate () {
		return docdate;
	}

	/**
	 * Set the value related to the column: docdate
	 * @param docdate the docdate value
	 */
	public void setDocdate (java.util.Date docdate) {
		this.docdate = docdate;
	}



	/**
	 * Return the value associated with the column: grossamount
	 */
	public java.math.BigDecimal getGrossamount () {
		return grossamount;
	}

	/**
	 * Set the value related to the column: grossamount
	 * @param grossamount the grossamount value
	 */
	public void setGrossamount (java.math.BigDecimal grossamount) {
		this.grossamount = grossamount;
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
	 * Return the value associated with the column: cashallocpayout
	 */
	public java.math.BigDecimal getCashallocpayout () {
		return cashallocpayout;
	}

	/**
	 * Set the value related to the column: cashallocpayout
	 * @param cashallocpayout the cashallocpayout value
	 */
	public void setCashallocpayout (java.math.BigDecimal cashallocpayout) {
		this.cashallocpayout = cashallocpayout;
	}



	/**
	 * Return the value associated with the column: dockey
	 */
	public java.lang.String getDockey () {
		return dockey;
	}

	/**
	 * Set the value related to the column: dockey
	 * @param dockey the dockey value
	 */
	public void setDockey (java.lang.String dockey) {
		this.dockey = dockey;
	}



	/**
	 * Return the value associated with the column: vatamount
	 */
	public java.math.BigDecimal getVatamount () {
		return vatamount;
	}

	/**
	 * Set the value related to the column: vatamount
	 * @param vatamount the vatamount value
	 */
	public void setVatamount (java.math.BigDecimal vatamount) {
		this.vatamount = vatamount;
	}



	/**
	 */
	public boolean isManualflag() {
		return manualflag;
	}

	/**
	 */
	public void setManualflag (boolean manualflag) {
		this.manualflag = manualflag;
	}
	

	/**
	 */
	public boolean isPrintedflag() {
		return printedflag;
	}

	
	
	/**
	 */
	public void setPrintedflag (boolean printedflag) {
		this.printedflag = printedflag;
	}
	
	/**
	 */
	public java.util.Date getPrintdate () {
		return printdate;
	}

	/**
	 */
	public void setPrintdate (java.util.Date printdate) {
		this.printdate = printdate;
	}
	
	
	/**
	 * Return the value associated with the column: pyodoneflag
	 */
	public boolean isPyodoneflag () {
		return pyodoneflag;
	}

	/**
	 * Set the value related to the column: pyodoneflag
	 * @param pyodoneflag the pyodoneflag value
	 */
	public void setPyodoneflag (boolean pyodoneflag) {
		this.pyodoneflag = pyodoneflag;
	}



	/**
	 * Return the value associated with the column: payoutamount
	 */
	public java.math.BigDecimal getPayoutamount () {
		return payoutamount;
	}

	/**
	 * Set the value related to the column: payoutamount
	 * @param payoutamount the payoutamount value
	 */
	public void setPayoutamount (java.math.BigDecimal payoutamount) {
		this.payoutamount = payoutamount;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}







	/**
	 * Return the value associated with the column: contractno
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: contractno
	 * @param contractno the contractno value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
	}







	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public Address getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (Address lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}


}