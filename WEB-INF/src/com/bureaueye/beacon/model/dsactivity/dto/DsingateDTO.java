package com.bureaueye.beacon.model.dsactivity.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.dsactivity.Dsingate;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;






public final class DsingateDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public DsingateDTO(Dsingate dao) throws ApplicationException {
		initialize(dao);		
	}
	public DsingateDTO(Dsingate dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Dsingate dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setCustomeraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey()));
		this.setDepotlocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getDepotlocationkey()));
		
		this.setDsingateId(dao.getDsingateId());
		
		this.setEirin(dao.getEirin());
		this.setCreatedate(dao.getCreatedate());
		this.setCreateuserid(dao.getCreateuserid());
	
	}
	
	
	
	
	// fields
	private String readonly = "false";
		
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	

	
	
	
	// primary key
	private java.lang.Integer dsingateId;

	// fields
	private java.lang.String eirin;
	private java.lang.Integer eirinver;
	private java.util.Date indate;
	private java.lang.String intime;
	private java.lang.String con1;
	private java.lang.String cha1;
	private java.lang.String consize;
	private java.lang.String contype;
	private java.lang.String chasize;
	private java.lang.String chatype;

	
	private Address customeraddrkey;
	private Location depotlocationkey;

	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	
	
	/**
     */
	public java.lang.Integer getDsingateId () {
		return dsingateId;
	}

	/**
	 */
	public void setDsingateId (java.lang.Integer dsingateId) {
		this.dsingateId = dsingateId;
	}





	/**
	 * Return the value associated with the column: EIRIN
	 */
	public java.lang.String getEirin () {
		return eirin;
	}

	/**
	 * Set the value related to the column: EIRIN
	 * @param eirin the EIRIN value
	 */
	public void setEirin (java.lang.String eirin) {
		this.eirin = eirin;
	}



	/**
	 * Return the value associated with the column: EIRINVER
	 */
	public java.lang.Integer getEirinver () {
		return eirinver;
	}

	/**
	 * Set the value related to the column: EIRINVER
	 * @param eirinver the EIRINVER value
	 */
	public void setEirinver (java.lang.Integer eirinver) {
		this.eirinver = eirinver;
	}









	/**
	 * Return the value associated with the column: INDATE
	 */
	public java.util.Date getIndate () {
		return indate;
	}

	/**
	 * Set the value related to the column: INDATE
	 * @param indate the INDATE value
	 */
	public void setIndate (java.util.Date indate) {
		this.indate = indate;
	}



	/**
	 * Return the value associated with the column: INTIME
	 */
	public java.lang.String getIntime () {
		return intime;
	}

	/**
	 * Set the value related to the column: INTIME
	 * @param intime the INTIME value
	 */
	public void setIntime (java.lang.String intime) {
		this.intime = intime;
	}






	/**
	 * Return the value associated with the column: con1
	 */
	public java.lang.String getCon1 () {
		return con1;
	}

	/**
	 * Set the value related to the column: con1
	 * @param con1 the con1 value
	 */
	public void setCon1 (java.lang.String con1) {
		this.con1 = con1;
	}



	/**
	 * Return the value associated with the column: cha1
	 */
	public java.lang.String getCha1 () {
		return cha1;
	}

	/**
	 * Set the value related to the column: cha1
	 * @param cha1 the cha1 value
	 */
	public void setCha1 (java.lang.String cha1) {
		this.cha1 = cha1;
	}







	/**
	 * Return the value associated with the column: CONSIZE
	 */
	public java.lang.String getConsize () {
		return consize;
	}

	/**
	 * Set the value related to the column: CONSIZE
	 * @param consize the CONSIZE value
	 */
	public void setConsize (java.lang.String consize) {
		this.consize = consize;
	}



	/**
	 * Return the value associated with the column: CONTYPE
	 */
	public java.lang.String getContype () {
		return contype;
	}

	/**
	 * Set the value related to the column: CONTYPE
	 * @param contype the CONTYPE value
	 */
	public void setContype (java.lang.String contype) {
		this.contype = contype;
	}







	/**
	 * Return the value associated with the column: CHASIZE
	 */
	public java.lang.String getChasize () {
		return chasize;
	}

	/**
	 * Set the value related to the column: CHASIZE
	 * @param chasize the CHASIZE value
	 */
	public void setChasize (java.lang.String chasize) {
		this.chasize = chasize;
	}



	/**
	 * Return the value associated with the column: CHATYPE
	 */
	public java.lang.String getChatype () {
		return chatype;
	}

	/**
	 * Set the value related to the column: CHATYPE
	 * @param chatype the CHATYPE value
	 */
	public void setChatype (java.lang.String chatype) {
		this.chatype = chatype;
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









	/**
	 */
	public Address getCustomeraddrkey () {	return customeraddrkey;}
	public void setCustomeraddrkey (Address customeraddrkey) {	this.customeraddrkey = customeraddrkey;}
	

	/**
	 */
	public Location getDepotlocationkey () {	return depotlocationkey;}
	public void setDepotlocationkey (Location depotlocationkey) {	this.depotlocationkey = depotlocationkey;}
	
	
	
}
