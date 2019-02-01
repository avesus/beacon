package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.AddressBD;




public final class UnitDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitDTO(Unit dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitDTO(Unit dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Unit dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		try {
			this.setOwnerkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getOwnerkey()));
		} catch (Exception e) {
			this.setOwnerkey(new Address());
		}
		
		this.setUnitId(dao.getUnitId());
		
		this.setUnitkey(dao.getUnitkey());
		this.setMfdate(dao.getMfdate());
				
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	
	// primary key
	private java.lang.Integer unitId;

	// fields
	private java.lang.String unitkey;
	private java.lang.String xlock;
	private boolean deleted;
	private java.util.Date mfdate;
	
	private Address ownerkey;
	




	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}







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
	 */
	public Address getOwnerkey () {
		return ownerkey;
	}

	/**
	 */
	public void setOwnerkey (Address ownerkey) {
		this.ownerkey = ownerkey;
	}




	/**
	 * Return the value associated with the column: mfdate
	 */
	public java.util.Date getMfdate () {
		return mfdate;
	}

	/**
	 * Set the value related to the column: mfdate
	 * @param mfdate the mfdate value
	 */
	public void setMfdate (java.util.Date mfdate) {
		this.mfdate = mfdate;
	}
	
	


	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
	}












	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
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

	
}
