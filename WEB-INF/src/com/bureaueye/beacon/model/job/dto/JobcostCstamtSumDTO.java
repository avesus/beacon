package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;





public final class JobcostCstamtSumDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public JobcostCstamtSumDTO(
			String Vendoraddrkey, 
			Integer JobhdrId, 
			String Costkey, 
			String Ccykey, 
			BigDecimal Cstamt					
			) throws ApplicationException {
		initialize(
				 Vendoraddrkey, 
				 JobhdrId, 
				 Costkey, 
				 Ccykey, 
				 Cstamt				 
				);		
	}
	
	
	protected void initialize (
			String Vendoraddrkey, 
			Integer JobhdrId, 
			String Costkey, 
			String Ccykey, 
			BigDecimal Cstamt			
			) throws ApplicationException {		
		this.setJobhdrId(JobhdrId);	
		this.setVendoraddrkey(Vendoraddrkey);
		this.setCostkey(Costkey);
		this.setCcykey(Ccykey);
		this.setCstamt(Cstamt);			
	}
	

	// primary key
	private java.lang.Integer jobcostId;

	// fields
	private java.lang.Integer jobhdrId;
	private java.lang.Integer orderhdrId;	
	private java.math.BigDecimal cstamt;
	private String vendoraddrkey;
	private String costkey;
	private String ccykey;
    



    
	public java.lang.Integer getOrderhdrId () {		return orderhdrId;	}
	public void setOrderhdrId (java.lang.Integer _orderhdrId) {		this.orderhdrId = _orderhdrId;	}
	
	

	public java.lang.Integer getJobcostId () {
		return jobcostId;
	}
	public void setJobcostId (java.lang.Integer jobcostId) {
		this.jobcostId = jobcostId;
	}





	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
	}








	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
	}







	public java.lang.String getCcykey () {
		return ccykey;
	}
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}






	public String getVendoraddrkey () {
		return vendoraddrkey;
	}
	public void setVendoraddrkey (String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	public String getCostkey () {
		return costkey;
	}
	public void setCostkey (String costkey) {
		this.costkey = costkey;
	}
	

	
}
