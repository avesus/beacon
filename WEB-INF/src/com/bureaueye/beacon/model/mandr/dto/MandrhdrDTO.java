package com.bureaueye.beacon.model.mandr.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;





public final class MandrhdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public MandrhdrDTO(Mandrhdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public MandrhdrDTO(Mandrhdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Mandrhdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(dao.getVendoraddrkey());
		try{this.setVendoraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));}catch(Exception e){}

		this.setProductkey(dao.getProductkey());
		try{this.setProduct(new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getProductkey()));}catch(Exception e){}
		
		this.setUnitId(dao.getUnitId());
		this.setUnitkey(dao.getUnitkey());
		try{
			Unit unitdao = new UnitBD(this.getSessionFactoryClusterMap()).read(dao.getUnitId());
			if (unitdao!=null) {
				this.setUnit(unitdao);
			}
			
		}catch(Exception e){}
		
		this.setCustomeraddrkey(dao.getCustomeraddrkey());
		try{this.setCustomeraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey()));}catch(Exception e){}
		
		this.setDepotlocationkey(dao.getDepotlocationkey());
		try{this.setDepotlocation(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getDepotlocationkey()));}catch(Exception e){}
				
		this.setEstimateref(dao.getEstimateref());
		
		this.setMandrhdrId(dao.getMandrhdrId());
		this.setCreatedate(dao.getCreatedate());
		this.setCreateuserid(dao.getCreateuserid());
		this.setCreatetime(dao.getCreatetime());
		this.setOriginalestimatedate(dao.getOriginalestimatedate());
		
		this.setMandrno(dao.getMandrno());
		this.setVersionno(dao.getVersionno());

		this.setMoveref(dao.getMoveref());
		
		this.setLastversionflag(dao.isLastversionflag());
		
		
		this.mandrdtlssize = 0;
		try {
			List dtos = new MandrhdrBD(this.getSessionFactoryClusterMap()).getMandrdtls(dao.getMandrhdrId());
			if (dtos != null) this.mandrdtlssize = dtos.size();
		} catch (Exception ae) {}		
	}
	
	
	
	// primary key
	private java.lang.Integer mandrhdrId;
	
	
	// fields
	private String readonly = "false";
	

	private java.math.BigDecimal chargeamt;
	private java.math.BigDecimal costamt;
	private java.math.BigDecimal totalamt;
	
	private java.lang.String mandrno;
	private Integer versionno;
	private java.lang.String mandrtypekey;
	private java.lang.String estimateref;
	
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	
	private java.lang.String moveref;

	private java.lang.String ccykey;
	private java.lang.String dppccykey;
	
	private java.math.BigDecimal laborrate;
	private java.math.BigDecimal dppamt;
	private java.lang.String unitkey;
	private boolean returntolessorflag;

	private boolean cancelflag;
	private java.util.Date canceldate;
	private java.lang.String cancelby;
	private java.lang.String cancelreason;
	private boolean reopenflag;
	private java.util.Date reopendate;
	private java.lang.String reopenby;
	private boolean cleanflag;
	private java.util.Date cleandate;
	private java.lang.String cleanby;
	private java.lang.String mandrstatus;
	private java.util.Date approvedate;
	private java.util.Date estimatedate;
	private java.util.Date originalestimatedate;
	private java.util.Date repairdate;
	private java.util.Date indate;
	private java.util.Date outdate;

	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	
	private java.lang.String lesseeaddrkey;
	private java.lang.String customeraddrkey;
	private java.lang.String depotlocationkey;
	private java.lang.String vendoraddrkey;
	
	private java.lang.Integer unitId;
	
	private java.lang.String productkey;
	private boolean lastversionflag;
	
	private Address lesseeaddr = new Address();
	private Address customeraddr = new Address();
	private Location depotlocation = new Location();
	private Address vendoraddr = new Address();
	private Unit unit = new Unit();
	private Product product = new Product();
	
	
	// extra
	private int mandrdtlssize;
    
	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getMandrdtlssize() {return mandrdtlssize;}
	public void setMandrdtlssize(int mandrdtlssize) {this.mandrdtlssize = mandrdtlssize;}

	
	





	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MANDRHDR_ID"
     */
	public java.lang.Integer getMandrhdrId () {
		return mandrhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param mandrId the new ID
	 */
	public void setMandrhdrId (java.lang.Integer mandrhdrId) {
		this.mandrhdrId = mandrhdrId;
	}




	/**
	 * Return the value associated with the column: chargeamt
	 */
	public java.math.BigDecimal getChargeamt () {
		return chargeamt;
	}

	/**
	 * Set the value related to the column: chargeamt
	 * @param chargeamt the chargeamt value
	 */
	public void setChargeamt (java.math.BigDecimal chargeamt) {
		this.chargeamt = chargeamt;
	}



	/**
	 * Return the value associated with the column: costamt
	 */
	public java.math.BigDecimal getCostamt () {
		return costamt;
	}

	/**
	 * Set the value related to the column: costamt
	 * @param costamt the costamt value
	 */
	public void setCostamt (java.math.BigDecimal costamt) {
		this.costamt = costamt;
	}



	/**
	 * Return the value associated with the column: totalamt
	 */
	public java.math.BigDecimal getTotalamt () {
		return totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (java.math.BigDecimal totalamt) {
		this.totalamt = totalamt;
	}



	/**
	 * Return the value associated with the column: mandrno
	 */
	public java.lang.String getMandrno () {
		return mandrno;
	}

	/**
	 * Set the value related to the column: mandrno
	 * @param mandrno the mandrno value
	 */
	public void setMandrno (java.lang.String mandrno) {
		this.mandrno = mandrno;
	}



	/**
	 * Return the value associated with the column: versionno
	 */
	public Integer getVersionno () {
		return versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param versionno the versionno value
	 */
	public void setVersionno (Integer versionno) {
		this.versionno = versionno;
	}



	/**
	 * Return the value associated with the column: mandrtypekey
	 */
	public java.lang.String getMandrtypekey () {
		return mandrtypekey;
	}

	/**
	 * Set the value related to the column: mandrtypekey
	 * @param mandrtypekey the mandrtypekey value
	 */
	public void setMandrtypekey (java.lang.String mandrtypekey) {
		this.mandrtypekey = mandrtypekey;
	}



	/**
	 * Return the value associated with the column: estimateref
	 */
	public java.lang.String getEstimateref () {
		return estimateref;
	}

	/**
	 * Set the value related to the column: estimateref
	 * @param estimateref the estimateref value
	 */
	public void setEstimateref (java.lang.String estimateref) {
		this.estimateref = estimateref;
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
	 * Return the value associated with the column: jobno
	 */
	public java.lang.String getMoveref () {
		return moveref;
	}

	/**
	 * Set the value related to the column: jobno
	 * @param jobno the jobno value
	 */
	public void setMoveref (java.lang.String moveref) {
		this.moveref= moveref;
	}



	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public java.lang.String getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (java.lang.String lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}



	/**
	 * Return the value associated with the column: depotlocationkey
	 */
	public java.lang.String getDepotlocationkey () {
		return depotlocationkey;
	}

	/**
	 * Set the value related to the column: depotlocationkey
	 * @param depotlocationkey the depotlocationkey value
	 */
	public void setDepotlocationkey (java.lang.String depotlocationkey) {
		this.depotlocationkey = depotlocationkey;
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
	 * Return the value associated with the column: dppccykey
	 */
	public java.lang.String getDppccykey () {
		return dppccykey;
	}

	/**
	 * Set the value related to the column: dppccykey
	 * @param dppccykey the dppccykey value
	 */
	public void setDppccykey (java.lang.String dppccykey) {
		this.dppccykey = dppccykey;
	}



	/**
	 * Return the value associated with the column: laborrate
	 */
	public java.math.BigDecimal getLaborrate () {
		return laborrate;
	}

	/**
	 * Set the value related to the column: laborrate
	 * @param laborrate the laborrate value
	 */
	public void setLaborrate (java.math.BigDecimal laborrate) {
		this.laborrate = laborrate;
	}



	/**
	 * Return the value associated with the column: dppamt
	 */
	public java.math.BigDecimal getDppamt () {
		return dppamt;
	}

	/**
	 * Set the value related to the column: dppamt
	 * @param dppamt the dppamt value
	 */
	public void setDppamt (java.math.BigDecimal dppamt) {
		this.dppamt = dppamt;
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
	 * Return the value associated with the column: returntolessorflag
	 */
	public boolean isReturntolessorflag () {
		return returntolessorflag;
	}

	/**
	 * Set the value related to the column: returntolessorflag
	 * @param returntolessorflag the returntolessorflag value
	 */
	public void setReturntolessorflag (boolean returntolessorflag) {
		this.returntolessorflag = returntolessorflag;
	}



	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this.productkey = productkey;
	}



	/**
	 * Return the value associated with the column: cancelflag
	 */
	public boolean isCancelflag () {
		return cancelflag;
	}

	/**
	 * Set the value related to the column: cancelflag
	 * @param cancelflag the cancelflag value
	 */
	public void setCancelflag (boolean cancelflag) {
		this.cancelflag = cancelflag;
	}



	/**
	 * Return the value associated with the column: canceldate
	 */
	public java.util.Date getCanceldate () {
		return canceldate;
	}

	/**
	 * Set the value related to the column: canceldate
	 * @param canceldate the canceldate value
	 */
	public void setCanceldate (java.util.Date canceldate) {
		this.canceldate = canceldate;
	}



	/**
	 * Return the value associated with the column: cancelby
	 */
	public java.lang.String getCancelby () {
		return cancelby;
	}

	/**
	 * Set the value related to the column: cancelby
	 * @param cancelby the cancelby value
	 */
	public void setCancelby (java.lang.String cancelby) {
		this.cancelby = cancelby;
	}



	/**
	 * Return the value associated with the column: cancelreason
	 */
	public java.lang.String getCancelreason () {
		return cancelreason;
	}

	/**
	 * Set the value related to the column: cancelreason
	 * @param cancelreason the cancelreason value
	 */
	public void setCancelreason (java.lang.String cancelreason) {
		this.cancelreason = cancelreason;
	}



	/**
	 * Return the value associated with the column: reopenflag
	 */
	public boolean isReopenflag () {
		return reopenflag;
	}

	/**
	 * Set the value related to the column: reopenflag
	 * @param reopenflag the reopenflag value
	 */
	public void setReopenflag (boolean reopenflag) {
		this.reopenflag = reopenflag;
	}



	/**
	 * Return the value associated with the column: reopendate
	 */
	public java.util.Date getReopendate () {
		return reopendate;
	}

	/**
	 * Set the value related to the column: reopendate
	 * @param reopendate the reopendate value
	 */
	public void setReopendate (java.util.Date reopendate) {
		this.reopendate = reopendate;
	}



	/**
	 * Return the value associated with the column: reopenby
	 */
	public java.lang.String getReopenby () {
		return reopenby;
	}

	/**
	 * Set the value related to the column: reopenby
	 * @param reopenby the reopenby value
	 */
	public void setReopenby (java.lang.String reopenby) {
		this.reopenby = reopenby;
	}



	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean cleanflag) {
		this.cleanflag = cleanflag;
	}



	/**
	 * Return the value associated with the column: cleandate
	 */
	public java.util.Date getCleandate () {
		return cleandate;
	}

	/**
	 * Set the value related to the column: cleandate
	 * @param cleandate the cleandate value
	 */
	public void setCleandate (java.util.Date cleandate) {
		this.cleandate = cleandate;
	}



	/**
	 * Return the value associated with the column: cleanby
	 */
	public java.lang.String getCleanby () {
		return cleanby;
	}

	/**
	 * Set the value related to the column: cleanby
	 * @param cleanby the cleanby value
	 */
	public void setCleanby (java.lang.String cleanby) {
		this.cleanby = cleanby;
	}



	/**
	 * Return the value associated with the column: mandrstatus
	 */
	public java.lang.String getMandrstatus () {
		return mandrstatus;
	}

	/**
	 * Set the value related to the column: mandrstatus
	 * @param mandrstatus the mandrstatus value
	 */
	public void setMandrstatus (java.lang.String mandrstatus) {
		this.mandrstatus = mandrstatus;
	}



	/**
	 * Return the value associated with the column: approvedate
	 */
	public java.util.Date getApprovedate () {
		return approvedate;
	}

	/**
	 * Set the value related to the column: approvedate
	 * @param approvedate the approvedate value
	 */
	public void setApprovedate (java.util.Date approvedate) {
		this.approvedate = approvedate;
	}



	/**
	 * Return the value associated with the column: estimatedate
	 */
	public java.util.Date getEstimatedate () {
		return estimatedate;
	}

	/**
	 * Set the value related to the column: estimatedate
	 * @param estimatedate the estimatedate value
	 */
	public void setEstimatedate (java.util.Date estimatedate) {
		this.estimatedate = estimatedate;
	}

	

	public java.util.Date getOriginalestimatedate () {
		return originalestimatedate;
	}
	public void setOriginalestimatedate (java.util.Date originalestimatedate) {
		this.originalestimatedate = originalestimatedate;
	}
	
	


	/**
	 * Return the value associated with the column: repairdate
	 */
	public java.util.Date getRepairdate () {
		return repairdate;
	}

	/**
	 * Set the value related to the column: repairdate
	 * @param repairdate the repairdate value
	 */
	public void setRepairdate (java.util.Date repairdate) {
		this.repairdate = repairdate;
	}



	/**
	 * Return the value associated with the column: indate
	 */
	public java.util.Date getIndate () {
		return indate;
	}

	/**
	 * Set the value related to the column: indate
	 * @param indate the indate value
	 */
	public void setIndate (java.util.Date indate) {
		this.indate = indate;
	}



	/**
	 * Return the value associated with the column: outdate
	 */
	public java.util.Date getOutdate () {
		return outdate;
	}

	/**
	 * Set the value related to the column: outdate
	 * @param outdate the outdate value
	 */
	public void setOutdate (java.util.Date outdate) {
		this.outdate = outdate;
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





	public Address getLesseeaddr () {
		return lesseeaddr;
	}
	public void setLesseeaddr (Address lesseeaddr) {
		this.lesseeaddr = lesseeaddr;
	}


	public Address getCustomeraddr () {
		return customeraddr;
	}
	public void setCustomeraddr (Address customeraddr) {
		this.customeraddr = customeraddr;
	}

	
	public Location getDepotlocation () {
		return depotlocation;
	}
	public void setDepotlocation (Location depotlocation) {
		this.depotlocation = depotlocation;
	}


	public Address getVendoraddr () {
		return vendoraddr;
	}
	public void setVendoraddr (Address vendoraddr) {
		this.vendoraddr = vendoraddr;
	}


	public Unit getUnit () {
		return unit;
	}
	public void setUnit (Unit unit) {
		this.unit = unit;
	}
	
	
	public Product getProduct () {
		return product;
	}
	public void setProduct (Product product) {
		this.product = product;
	}
	
	
	/**
	 * Return the value associated with the column: lastversionflag
	 */
	public boolean isLastversionflag () {
		return lastversionflag;
	}

	/**
	 * Set the value related to the column: lastversionflag
	 * @param lastversionflag the lastversionflag value
	 */
	public void setLastversionflag (boolean lastversionflag) {
		this.lastversionflag = lastversionflag;
	}
	
	
	
}
