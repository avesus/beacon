package com.bureaueye.genesys.model.onhire.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.genesys.model.onhire.Onhireeqpotc;




public final class OnhireeqpotcDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public OnhireeqpotcDTO(Onhireeqpotc dao) throws ApplicationException {
		initialize(dao);		
	}
	public OnhireeqpotcDTO(Onhireeqpotc dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Onhireeqpotc dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setChargekey(new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getChargekey()));

		this.setOnhireId(dao.getOnhireId());
		this.setOnhireeqpId(dao.getOnhireeqpId());
		this.setOnhireeqpotcId(dao.getOnhireeqpotcId());

		this.setChargeamt(dao.getChargeamt());
	}
	
	
	
	
	private String readonly = "false";
	
	
	// primary key
	private java.lang.Integer onhireId;
	private java.lang.Integer onhireeqpId;
	private java.lang.Integer onhireeqpotcId;
	
	// fields
	private Charge chargekey;

	private java.util.Date createdate;
	private java.lang.String xlock;
	private java.lang.Integer unitId;
	private java.math.BigDecimal chargeamt;
	private java.lang.String createtime;
	private boolean xinactive;
	private java.lang.String createuserid;
	private java.lang.String unitkey;

	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIREEQPOTC_ID"
     */
	public java.lang.Integer getOnhireeqpotcId () {
		return onhireeqpotcId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param onhireeqpotcId the new ID
	 */
	public void setOnhireeqpotcId (java.lang.Integer onhireeqpotcId) {
		this.onhireeqpotcId = onhireeqpotcId;
	}







	/**
	 * Return the value associated with the column: ONHIREEQP_ID
	 */
	public java.lang.Integer getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the value related to the column: ONHIREEQP_ID
	 * @param onhireeqpId the ONHIREEQP_ID value
	 */
	public void setOnhireeqpId (java.lang.Integer onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
	}



	/**
	 * Return the value associated with the column: ONHIRE_ID
	 */
	public java.lang.Integer getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the value related to the column: ONHIRE_ID
	 * @param onhireId the ONHIRE_ID value
	 */
	public void setOnhireId (java.lang.Integer onhireId) {
		this.onhireId = onhireId;
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
	

}