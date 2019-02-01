package com.bureaueye.beacon.model.purchaseorder.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;





public final class PohdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public PohdrDTO(Pohdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public PohdrDTO(Pohdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Pohdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));
		this.setShiptolocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getShiptolocationkey()));
		this.setPohdrId(dao.getPohdrId());
		this.setCreatedate(dao.getCreatedate());
		this.setPono(dao.getPono());
		this.setCcykey(dao.getCcykey());
		this.setTotalamt(dao.getTotalamt());	
		this.setTxt1(dao.getTxt1());
		this.setDepartmentkey(dao.getDepartmentkey());
		
		this.podtlssize = 0;
		try {
			List dtos = new PohdrBD(this.getSessionFactoryClusterMap()).getPodtls(dao.getPohdrId());
			if (dtos != null) this.podtlssize = dtos.size();
		} catch (Exception ae) {}		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	// extra
	private int podtlssize;
    
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getPodtlssize() {return podtlssize;}
	public void setPodtlssize(int podtlssize) {this.podtlssize = podtlssize;}

	
	
	
	// primary key
	private java.lang.Integer pohdrId;

	// fields
	private java.lang.String departmentkey;
	private java.lang.String pono;
	private java.util.Date createdate;
	private java.lang.String txt1;
	private java.lang.String ccykey;
	private java.math.BigDecimal totalamt;
	
	private Address vendoraddrkey;
	private Location shiptolocationkey;



	/**
     */
	public java.lang.Integer getPohdrId () {
		return pohdrId;
	}

	/**
	 */
	public void setPohdrId (java.lang.Integer pohdrId) {
		this.pohdrId = pohdrId;
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
	 */
	public java.lang.String getPono () {
		return pono;
	}

	/**
	 */
	public void setPono (java.lang.String pono) {
		this.pono = pono;
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
	public java.math.BigDecimal getTotalamt () {
		return totalamt;
	}

	/**
	 */
	public void setTotalamt (java.math.BigDecimal totalamt) {
		this.totalamt = totalamt;
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
	public Location getShiptolocationkey () {
		return shiptolocationkey;
	}

	/**
	 */
	public void setShiptolocationkey (Location shiptolocationkey) {
		this.shiptolocationkey = shiptolocationkey;
	}
	
	
	
}
