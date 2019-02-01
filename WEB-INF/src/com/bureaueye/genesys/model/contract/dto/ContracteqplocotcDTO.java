package com.bureaueye.genesys.model.contract.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.genesys.model.contract.Contracteqplocotc;








public final class ContracteqplocotcDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public ContracteqplocotcDTO(Contracteqplocotc dao) throws ApplicationException {
		initialize(dao);		
	}
	public ContracteqplocotcDTO(Contracteqplocotc dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Contracteqplocotc dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setChargekey(new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getChargekey()));
		this.setLocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLocationkey()));
		
		this.setContractId(dao.getContractId());
		this.setContracteqpId(dao.getContracteqpId());
		this.setContracteqplocId(dao.getContracteqplocId());
		this.setContracteqplocotcId(dao.getContracteqplocotcId());
		
		this.setReadonly("false");
		this.setChecked(false);	
	}
	
	
	
	// extra
    private boolean checked;	
	private String readonly = "false";
	
	
	// primary keys
	private java.lang.Integer contracteqplocotcId;
	private java.lang.Integer contracteqplocId;
	private java.lang.Integer contracteqpId;
	private java.lang.Integer contractId;
	
	// fields
	private Charge chargekey;
	private java.lang.String eqpkeyp5;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkey;
	private java.lang.String eqpkeyp7;
	private boolean xinactive;
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.String eqpkeyp9;
	private java.lang.String eqpkeyp8;
	private java.lang.String eqpkeyp10;
	private java.lang.String eqpkeyp1;
	private java.lang.String createuserid;
	private Location locationkey;
	private java.lang.String eqpkeyp6;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String pudoflag;
	private java.math.BigDecimal chargeamt;
	private java.lang.String xlock;




	
	

    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) { this.checked = b; }
    
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	

	/**
	 * Return the value associated with the column: chargekey
	 */
	public Charge getChargekey () {
		return chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param chargekey the chargekey value
	 */
	public void setChargekey (Charge chargekey) {
		this.chargekey = chargekey;
	}	
	


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTEQPLOCOTC_ID"
     */
	public java.lang.Integer getContracteqplocotcId () {
		return contracteqplocotcId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contracteqplocotcId the new ID
	 */
	public void setContracteqplocotcId (java.lang.Integer contracteqplocotcId) {
		this.contracteqplocotcId = contracteqplocotcId;
	}






	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String eqpkeyp5) {
		this.eqpkeyp5 = eqpkeyp5;
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
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String eqpkey) {
		this.eqpkey = eqpkey;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String eqpkeyp7) {
		this.eqpkeyp7 = eqpkeyp7;
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
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String eqpkeyp3) {
		this.eqpkeyp3 = eqpkeyp3;
	}



	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String eqpkeyp4) {
		this.eqpkeyp4 = eqpkeyp4;
	}





	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String eqpkeyp9) {
		this.eqpkeyp9 = eqpkeyp9;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQPLOC_ID
	 */
	public java.lang.Integer getContracteqplocId () {
		return contracteqplocId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQPLOC_ID
	 * @param contracteqplocId the CONTRACTEQPLOC_ID value
	 */
	public void setContracteqplocId (java.lang.Integer contracteqplocId) {
		this.contracteqplocId = contracteqplocId;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String eqpkeyp8) {
		this.eqpkeyp8 = eqpkeyp8;
	}



	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String eqpkeyp10) {
		this.eqpkeyp10 = eqpkeyp10;
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
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
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



	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String eqpkeyp6) {
		this.eqpkeyp6 = eqpkeyp6;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQP_ID
	 */
	public java.lang.Integer getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQP_ID
	 * @param contracteqpId the CONTRACTEQP_ID value
	 */
	public void setContracteqpId (java.lang.Integer contracteqpId) {
		this.contracteqpId = contracteqpId;
	}



	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
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
	 * Return the value associated with the column: pudoflag
	 */
	public java.lang.String getPudoflag () {
		return pudoflag;
	}

	/**
	 * Set the value related to the column: pudoflag
	 * @param pudoflag the pudoflag value
	 */
	public void setPudoflag (java.lang.String pudoflag) {
		this.pudoflag = pudoflag;
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
	


}