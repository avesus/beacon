package com.bureaueye.genesys.model.offhire.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.genesys.model.offhire.Offhireeqpotc;




public final class OffhireeqpotcDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public OffhireeqpotcDTO(Offhireeqpotc dao) throws ApplicationException {
		initialize(dao);		
	}
	public OffhireeqpotcDTO(Offhireeqpotc dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Offhireeqpotc dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setChargekey(new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getChargekey()));

		this.setOffhireId(dao.getOffhireId());
		this.setOffhireeqpId(dao.getOffhireeqpId());
		this.setOffhireeqpotcId(dao.getOffhireeqpotcId());

		this.setChargeamt(dao.getChargeamt());
	}
	
	
	
	
	private String readonly = "false";
	
	
	// primary key
	private java.lang.Integer offhireId;
	private java.lang.Integer offhireeqpId;
	private java.lang.Integer offhireeqpotcId;
	
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
     *  column="OFFHIREEQPOTC_ID"
     */
	public java.lang.Integer getOffhireeqpotcId () {
		return offhireeqpotcId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param offhireeqpotcId the new ID
	 */
	public void setOffhireeqpotcId (java.lang.Integer offhireeqpotcId) {
		this.offhireeqpotcId = offhireeqpotcId;
	}







	/**
	 * Return the value associated with the column: OFFHIREEQP_ID
	 */
	public java.lang.Integer getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the value related to the column: OFFHIREEQP_ID
	 * @param offhireeqpId the OFFHIREEQP_ID value
	 */
	public void setOffhireeqpId (java.lang.Integer offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
	}



	/**
	 * Return the value associated with the column: OFFHIRE_ID
	 */
	public java.lang.Integer getOffhireId () {
		return offhireId;
	}

	/**
	 * Set the value related to the column: OFFHIRE_ID
	 * @param offhireId the OFFHIRE_ID value
	 */
	public void setOffhireId (java.lang.Integer offhireId) {
		this.offhireId = offhireId;
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