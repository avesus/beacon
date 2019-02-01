package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.bd.ProductBD;







public final class JobhdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public JobhdrDTO(Jobhdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public JobhdrDTO(Jobhdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	
	protected void initialize (Jobhdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setProductkey(new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getProductkey()));
		this.setJobhdrId(dao.getJobhdrId());
		this.setJobno(dao.getJobno());
		this.setOrderhdrId(dao.getOrderhdrId());
		this.setOrderno(dao.getOrderno());
		this.setUnitId(dao.getUnitId());
		this.setUnitkey(dao.getUnitkey());
		this.setMovref(dao.getMovref());
		this.setSealnumber1(dao.getSealnumber1());
		this.setSealnumber2(dao.getSealnumber2());	
		this.setSealnumber3(dao.getSealnumber3());	
		this.setSealnumber4(dao.getSealnumber4());	
		this.setSealnumber5(dao.getSealnumber5());
		this.setWeightactual(dao.getWeightactual());
		this.setWeightactualunit(dao.getWeightactualunit());			
	}
	
	
	
	
	private String readonly = "false";
	private String jobhdrsfound = "false";	
	
	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public String getJobhdrsfound() {return jobhdrsfound;}
	public void setJobhdrsfound(String jobhdrsfound) {this.jobhdrsfound = jobhdrsfound;}


	// primary key
	private java.lang.Integer jobhdrId;
	private java.lang.String jobno;
	
	// fields
	private java.lang.String sealnumber1;
	private java.lang.String sealnumber2;
	private java.lang.String sealnumber3;
	private java.lang.String sealnumber4;
	private java.lang.String sealnumber5;
	
	private java.lang.String movref;
	private java.lang.String sealnumbers;
	private java.lang.String addinstruction;
	private java.lang.String weightactualunit;
	private java.math.BigDecimal weightactual;
	private java.lang.String dmrgstat;
	private java.lang.String unitkey3;
	private java.lang.String departmentkey;
	private boolean complete;
	private java.lang.String ownregion;
	private java.lang.String unitkey;
	private java.util.Date accrdate;
	private java.lang.String unitkey5;
	private java.lang.String companykey;
	private java.lang.String unitkey4;
	private java.lang.String closeoutstat;
	private java.lang.String predmrgstat;
	private java.lang.String unitkey2;
	private java.util.Date closeoutdate;
	private boolean mandrflag;
	private java.lang.String mandrkey;
	private boolean unitavail;
	private java.lang.Integer orderhdrId;
	private java.lang.String accrstat;
	private java.lang.String activitykey;
	private java.lang.String ccykey;
	private java.util.Date loaddate;
	private java.lang.String orderno;
	private java.lang.Integer unitId;
	private java.lang.Integer unitId2;
	private java.lang.Integer unitId3;
	private java.lang.Integer unitId4;
	private java.lang.Integer unitId5;
	private Product productkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="JOBHDR_ID"
     */
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param jobhdrId the new ID
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
	}


	/**
	 * Return the value associated with the column: sealnumber1
	 */
	public java.lang.String getSealnumber1 () {
		return sealnumber1;
	}

	/**
	 * Set the value related to the column: sealnumber1
	 * @param sealnumber1 the sealnumber1 value
	 */
	public void setSealnumber1 (java.lang.String sealnumber1) {
		this.sealnumber1 = sealnumber1;
	}



	/**
	 * Return the value associated with the column: sealnumber2
	 */
	public java.lang.String getSealnumber2 () {
		return sealnumber2;
	}

	/**
	 * Set the value related to the column: sealnumber2
	 * @param sealnumber2 the sealnumber2 value
	 */
	public void setSealnumber2 (java.lang.String sealnumber2) {
		this.sealnumber2 = sealnumber2;
	}



	/**
	 * Return the value associated with the column: sealnumber3
	 */
	public java.lang.String getSealnumber3 () {
		return sealnumber3;
	}

	/**
	 * Set the value related to the column: sealnumber3
	 * @param sealnumber3 the sealnumber3 value
	 */
	public void setSealnumber3 (java.lang.String sealnumber3) {
		this.sealnumber3 = sealnumber3;
	}



	/**
	 * Return the value associated with the column: sealnumber4
	 */
	public java.lang.String getSealnumber4 () {
		return sealnumber4;
	}

	/**
	 * Set the value related to the column: sealnumber4
	 * @param sealnumber4 the sealnumber4 value
	 */
	public void setSealnumber4 (java.lang.String sealnumber4) {
		this.sealnumber4 = sealnumber4;
	}



	/**
	 * Return the value associated with the column: sealnumber5
	 */
	public java.lang.String getSealnumber5 () {
		return sealnumber5;
	}

	/**
	 * Set the value related to the column: sealnumber5
	 * @param sealnumber5 the sealnumber5 value
	 */
	public void setSealnumber5 (java.lang.String sealnumber5) {
		this.sealnumber5 = sealnumber5;
	}


	

	/**
	 * Return the value associated with the column: jobno
	 */
	public java.lang.String getJobno () {
		return jobno;
	}

	/**
	 * Set the value related to the column: jobno
	 * @param jobno the jobno value
	 */
	public void setJobno (java.lang.String jobno) {
		this.jobno = jobno;
	}
	



	/**
	 * Return the value associated with the column: movref
	 */
	public java.lang.String getMovref () {
		return movref;
	}

	/**
	 * Set the value related to the column: movref
	 * @param movref the movref value
	 */
	public void setMovref (java.lang.String movref) {
		this.movref = movref;
	}



	/**
	 * Return the value associated with the column: sealnumbers
	 */
	public java.lang.String getSealnumbers () {
		return sealnumbers;
	}

	/**
	 * Set the value related to the column: sealnumbers
	 * @param sealnumbers the sealnumbers value
	 */
	public void setSealnumbers (java.lang.String sealnumbers) {
		this.sealnumbers = sealnumbers;
	}



	/**
	 * Return the value associated with the column: addinstruction
	 */
	public java.lang.String getAddinstruction () {
		return addinstruction;
	}

	/**
	 * Set the value related to the column: addinstruction
	 * @param addinstruction the addinstruction value
	 */
	public void setAddinstruction (java.lang.String addinstruction) {
		this.addinstruction = addinstruction;
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
	 * Return the value associated with the column: dmrgstat
	 */
	public java.lang.String getDmrgstat () {
		return dmrgstat;
	}

	/**
	 * Set the value related to the column: dmrgstat
	 * @param dmrgstat the dmrgstat value
	 */
	public void setDmrgstat (java.lang.String dmrgstat) {
		this.dmrgstat = dmrgstat;
	}



	/**
	 * Return the value associated with the column: UNITKEY3
	 */
	public java.lang.String getUnitkey3 () {
		return unitkey3;
	}

	/**
	 * Set the value related to the column: UNITKEY3
	 * @param unitkey3 the UNITKEY3 value
	 */
	public void setUnitkey3 (java.lang.String unitkey3) {
		this.unitkey3 = unitkey3;
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
	 * Return the value associated with the column: complete
	 */
	public boolean isComplete () {
		return complete;
	}

	/**
	 * Set the value related to the column: complete
	 * @param complete the complete value
	 */
	public void setComplete (boolean complete) {
		this.complete = complete;
	}



	/**
	 * Return the value associated with the column: OWNREGION
	 */
	public java.lang.String getOwnregion () {
		return ownregion;
	}

	/**
	 * Set the value related to the column: OWNREGION
	 * @param ownregion the OWNREGION value
	 */
	public void setOwnregion (java.lang.String ownregion) {
		this.ownregion = ownregion;
	}






	/**
	 * Return the value associated with the column: UNITKEY
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: UNITKEY
	 * @param unitkey the UNITKEY value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: accrdate
	 */
	public java.util.Date getAccrdate () {
		return accrdate;
	}

	/**
	 * Set the value related to the column: accrdate
	 * @param accrdate the accrdate value
	 */
	public void setAccrdate (java.util.Date accrdate) {
		this.accrdate = accrdate;
	}



	/**
	 * Return the value associated with the column: UNITKEY5
	 */
	public java.lang.String getUnitkey5 () {
		return unitkey5;
	}

	/**
	 * Set the value related to the column: UNITKEY5
	 * @param unitkey5 the UNITKEY5 value
	 */
	public void setUnitkey5 (java.lang.String unitkey5) {
		this.unitkey5 = unitkey5;
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
	 * Return the value associated with the column: UNITKEY4
	 */
	public java.lang.String getUnitkey4 () {
		return unitkey4;
	}

	/**
	 * Set the value related to the column: UNITKEY4
	 * @param unitkey4 the UNITKEY4 value
	 */
	public void setUnitkey4 (java.lang.String unitkey4) {
		this.unitkey4 = unitkey4;
	}



	/**
	 * Return the value associated with the column: closeoutstat
	 */
	public java.lang.String getCloseoutstat () {
		return closeoutstat;
	}

	/**
	 * Set the value related to the column: closeoutstat
	 * @param closeoutstat the closeoutstat value
	 */
	public void setCloseoutstat (java.lang.String closeoutstat) {
		this.closeoutstat = closeoutstat;
	}



	/**
	 * Return the value associated with the column: predmrgstat
	 */
	public java.lang.String getPredmrgstat () {
		return predmrgstat;
	}

	/**
	 * Set the value related to the column: predmrgstat
	 * @param predmrgstat the predmrgstat value
	 */
	public void setPredmrgstat (java.lang.String predmrgstat) {
		this.predmrgstat = predmrgstat;
	}



	/**
	 * Return the value associated with the column: UNITKEY2
	 */
	public java.lang.String getUnitkey2 () {
		return unitkey2;
	}

	/**
	 * Set the value related to the column: UNITKEY2
	 * @param unitkey2 the UNITKEY2 value
	 */
	public void setUnitkey2 (java.lang.String unitkey2) {
		this.unitkey2 = unitkey2;
	}



	/**
	 * Return the value associated with the column: closeoutdate
	 */
	public java.util.Date getCloseoutdate () {
		return closeoutdate;
	}

	/**
	 * Set the value related to the column: closeoutdate
	 * @param closeoutdate the closeoutdate value
	 */
	public void setCloseoutdate (java.util.Date closeoutdate) {
		this.closeoutdate = closeoutdate;
	}



	/**
	 * Return the value associated with the column: MANDRFLAG
	 */
	public boolean isMandrflag () {
		return mandrflag;
	}

	/**
	 * Set the value related to the column: MANDRFLAG
	 * @param mandrflag the MANDRFLAG value
	 */
	public void setMandrflag (boolean mandrflag) {
		this.mandrflag = mandrflag;
	}



	/**
	 * Return the value associated with the column: MANDRKEY
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: MANDRKEY
	 * @param mandrkey the MANDRKEY value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: unitavail
	 */
	public boolean isUnitavail () {
		return unitavail;
	}

	/**
	 * Set the value related to the column: unitavail
	 * @param unitavail the unitavail value
	 */
	public void setUnitavail (boolean unitavail) {
		this.unitavail = unitavail;
	}





	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}



	/**
	 * Return the value associated with the column: accrstat
	 */
	public java.lang.String getAccrstat () {
		return accrstat;
	}

	/**
	 * Set the value related to the column: accrstat
	 * @param accrstat the accrstat value
	 */
	public void setAccrstat (java.lang.String accrstat) {
		this.accrstat = accrstat;
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
	 * Return the value associated with the column: loaddate
	 */
	public java.util.Date getLoaddate () {
		return loaddate;
	}

	/**
	 * Set the value related to the column: loaddate
	 * @param loaddate the loaddate value
	 */
	public void setLoaddate (java.util.Date loaddate) {
		this.loaddate = loaddate;
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
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID2
	 */
	public java.lang.Integer getUnitId2 () {
		return unitId2;
	}

	/**
	 * Set the value related to the column: UNIT_ID2
	 * @param unitId2 the UNIT_ID2 value
	 */
	public void setUnitId2 (java.lang.Integer unitId2) {
		this.unitId2 = unitId2;
	}



	/**
	 * Return the value associated with the column: UNIT_ID3
	 */
	public java.lang.Integer getUnitId3 () {
		return unitId3;
	}

	/**
	 * Set the value related to the column: UNIT_ID3
	 * @param unitId3 the UNIT_ID3 value
	 */
	public void setUnitId3 (java.lang.Integer unitId3) {
		this.unitId3 = unitId3;
	}



	/**
	 * Return the value associated with the column: UNIT_ID4
	 */
	public java.lang.Integer getUnitId4 () {
		return unitId4;
	}

	/**
	 * Set the value related to the column: UNIT_ID4
	 * @param unitId4 the UNIT_ID4 value
	 */
	public void setUnitId4 (java.lang.Integer unitId4) {
		this.unitId4 = unitId4;
	}



	/**
	 * Return the value associated with the column: UNIT_ID5
	 */
	public java.lang.Integer getUnitId5 () {
		return unitId5;
	}

	/**
	 * Set the value related to the column: UNIT_ID5
	 * @param unitId5 the UNIT_ID5 value
	 */
	public void setUnitId5 (java.lang.Integer unitId5) {
		this.unitId5 = unitId5;
	}



	/**
	 * Return the value associated with the column: productkey
	 */
	public Product getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (Product productkey) {
		this.productkey = productkey;
	}


	
	
	
	
	
}