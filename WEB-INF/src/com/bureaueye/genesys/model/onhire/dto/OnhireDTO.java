package com.bureaueye.genesys.model.onhire.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.genesys.model.onhire.Onhire;








public final class OnhireDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public OnhireDTO(Onhire dao) throws ApplicationException {
		initialize(dao);		
	}
	public OnhireDTO(Onhire dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Onhire dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setLesseeaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getLesseeaddrkey()));
		this.setLocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLocationkey()));

		this.setOnhireId(dao.getOnhireId());
		this.setOnhireno(dao.getOnhireno());
		
		this.setContractno(dao.getContractno());
		this.setEqpkeyp1(dao.getEqpkeyp1());
		this.setEqpkeyp2(dao.getEqpkeyp2());
		this.setSubmitteddate(dao.getSubmitteddate());
		this.setSubmittedby(dao.getSubmittedby());		
	}
	
	
	
	
	private String readonly = "false";
	private String onhireeqpsfound = "false";	
	
	
	// primary key
	private java.lang.Integer onhireId;

	// fields
	private Location locationkey;
	private java.lang.String onhireno;
	private Address lesseeaddrkey;
	private java.lang.String contractno;
	private java.lang.String eqpkeyp1;
	private java.lang.String eqpkeyp2;
	private java.util.Date submitteddate;
	private java.lang.String submittedby;


	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public String getOnhireeqpsfound() {return onhireeqpsfound;}
	public void setOnhireeqpsfound(String onhireeqpsfound) {this.onhireeqpsfound = onhireeqpsfound;}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIRE_ID"
     */
	public java.lang.Integer getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param onhireId the new ID
	 */
	public void setOnhireId (java.lang.Integer onhireId) {
		this.onhireId = onhireId;
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
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String submittedby) {
		this.submittedby = submittedby;
	}





	/**
	 * Return the value associated with the column: onhireno
	 */
	public java.lang.String getOnhireno () {
		return onhireno;
	}

	/**
	 * Set the value related to the column: onhireno
	 * @param onhireno the onhireno value
	 */
	public void setOnhireno (java.lang.String onhireno) {
		this.onhireno = onhireno;
	}





	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String eqpkeyp1) {
		this.eqpkeyp1 = eqpkeyp1;
	}


	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String eqpkeyp2) {
		this.eqpkeyp2 = eqpkeyp2;
	}




	/**
	 * Return the value associated with the column: submitteddate
	 */
	public java.util.Date getSubmitteddate () {
		return submitteddate;
	}

	/**
	 * Set the value related to the column: submitteddate
	 * @param submitteddate the submitteddate value
	 */
	public void setSubmitteddate (java.util.Date submitteddate) {
		this.submitteddate = submitteddate;
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



	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (Location locationkey) {
		this.locationkey = locationkey;
	}	
	

}