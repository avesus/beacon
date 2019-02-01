package com.bureaueye.genesys.model.contract.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.genesys.model.contract.Contracteqp;








public final class ContracteqpDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public ContracteqpDTO(Contracteqp dao) throws ApplicationException {
		initialize(dao);		
	}
	public ContracteqpDTO(Contracteqp dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Contracteqp dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object

		this.setContractId(dao.getContractId());
		this.setContracteqpId(dao.getContracteqpId());
		
		this.setContracteqplocsfound("false");
		this.setReadonly("false");
		this.setContracteqplocssize(0);
		this.setChecked(false);	
	}
	
	
	
	// extra
	private int contracteqplocssize;
    private boolean checked;	
	private String readonly = "false";
    private String contracteqplocsfound = "false";
	
	
	// primary key
	private java.lang.Integer contracteqpId;
	private java.lang.Integer contractId;
	
	// fields
	private java.lang.String eqpkeyp5;
	private java.lang.Integer erowithin;
	private java.lang.String eqpkeyp2;
	private java.util.Date erodate;
	private java.lang.Integer erodays;
	private java.lang.String eqpkey;
	private java.lang.String eqpkeyp7;
	private boolean xinactive;
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.Integer eroadd;
	private java.lang.String eqpkeyp9;
	private java.math.BigDecimal fixdlyrat;
	private java.math.BigDecimal erorate;
	private java.math.BigDecimal eroincrease;
	private java.lang.String eqpkeyp8;
	private java.lang.String eqpkeyp10;
	private java.lang.String eroperiod;
	private java.lang.String eqpkeyp1;
	private java.lang.String createuserid;
	private java.lang.Integer freedays;
	private java.lang.String eqpkeyp6;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.Integer mindays;
	private java.lang.String xlock;
	private java.math.BigDecimal rate1;
	private java.lang.Integer fromday1;
	private java.lang.Integer today1;
	private java.math.BigDecimal rate2;
	private java.lang.Integer fromday2;
	private java.lang.Integer today2;
	private java.math.BigDecimal rate3;
	private java.lang.Integer fromday3;
	private java.lang.Integer today3;
	private java.math.BigDecimal rate4;
	private java.lang.Integer fromday4;
	private java.lang.Integer today4;
	private java.math.BigDecimal rate5;
	private java.lang.Integer fromday5;
	private java.lang.Integer today5;


	
	

    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getContracteqplocssize() {return contracteqplocssize;}
	public void setContracteqplocssize(int contracteqplocssize) {this.contracteqplocssize = contracteqplocssize;}

	public String getContracteqplocsfound() {return contracteqplocsfound;}
	public void setContracteqplocsfound(String contracteqplocsfound) {this.contracteqplocsfound = contracteqplocsfound;}
	


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACTEQP_ID"
     */
	public java.lang.Integer getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contracteqpId the new ID
	 */
	public void setContracteqpId (java.lang.Integer contracteqpId) {
		this.contracteqpId = contracteqpId;
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
	 * Return the value associated with the column: erowithin
	 */
	public java.lang.Integer getErowithin () {
		return erowithin;
	}

	/**
	 * Set the value related to the column: erowithin
	 * @param erowithin the erowithin value
	 */
	public void setErowithin (java.lang.Integer erowithin) {
		this.erowithin = erowithin;
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
	 * Return the value associated with the column: erodate
	 */
	public java.util.Date getErodate () {
		return erodate;
	}

	/**
	 * Set the value related to the column: erodate
	 * @param erodate the erodate value
	 */
	public void setErodate (java.util.Date erodate) {
		this.erodate = erodate;
	}



	/**
	 * Return the value associated with the column: erodays
	 */
	public java.lang.Integer getErodays () {
		return erodays;
	}

	/**
	 * Set the value related to the column: erodays
	 * @param erodays the erodays value
	 */
	public void setErodays (java.lang.Integer erodays) {
		this.erodays = erodays;
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
	 * Return the value associated with the column: eroadd
	 */
	public java.lang.Integer getEroadd () {
		return eroadd;
	}

	/**
	 * Set the value related to the column: eroadd
	 * @param eroadd the eroadd value
	 */
	public void setEroadd (java.lang.Integer eroadd) {
		this.eroadd = eroadd;
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
	 * Return the value associated with the column: fixdlyrat
	 */
	public java.math.BigDecimal getFixdlyrat () {
		return fixdlyrat;
	}

	/**
	 * Set the value related to the column: fixdlyrat
	 * @param fixdlyrat the fixdlyrat value
	 */
	public void setFixdlyrat (java.math.BigDecimal fixdlyrat) {
		this.fixdlyrat = fixdlyrat;
	}



	/**
	 * Return the value associated with the column: erorate
	 */
	public java.math.BigDecimal getErorate () {
		return erorate;
	}

	/**
	 * Set the value related to the column: erorate
	 * @param erorate the erorate value
	 */
	public void setErorate (java.math.BigDecimal erorate) {
		this.erorate = erorate;
	}



	/**
	 * Return the value associated with the column: eroincrease
	 */
	public java.math.BigDecimal getEroincrease () {
		return eroincrease;
	}

	/**
	 * Set the value related to the column: eroincrease
	 * @param eroincrease the eroincrease value
	 */
	public void setEroincrease (java.math.BigDecimal eroincrease) {
		this.eroincrease = eroincrease;
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
	 * Return the value associated with the column: eroperiod
	 */
	public java.lang.String getEroperiod () {
		return eroperiod;
	}

	/**
	 * Set the value related to the column: eroperiod
	 * @param eroperiod the eroperiod value
	 */
	public void setEroperiod (java.lang.String eroperiod) {
		this.eroperiod = eroperiod;
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
	 * Return the value associated with the column: freedays
	 */
	public java.lang.Integer getFreedays () {
		return freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param freedays the freedays value
	 */
	public void setFreedays (java.lang.Integer freedays) {
		this.freedays = freedays;
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
	 * Return the value associated with the column: mindays
	 */
	public java.lang.Integer getMindays () {
		return mindays;
	}

	/**
	 * Set the value related to the column: mindays
	 * @param mindays the mindays value
	 */
	public void setMindays (java.lang.Integer mindays) {
		this.mindays = mindays;
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
	 * Return the value associated with the column: rate1
	 */
	public java.math.BigDecimal getRate1 () {
		return rate1;
	}

	/**
	 * Set the value related to the column: rate1
	 * @param rate1 the rate1 value
	 */
	public void setRate1 (java.math.BigDecimal rate1) {
		this.rate1 = rate1;
	}



	/**
	 * Return the value associated with the column: fromday1
	 */
	public java.lang.Integer getFromday1 () {
		return fromday1;
	}

	/**
	 * Set the value related to the column: fromday1
	 * @param fromday1 the fromday1 value
	 */
	public void setFromday1 (java.lang.Integer fromday1) {
		this.fromday1 = fromday1;
	}



	/**
	 * Return the value associated with the column: today1
	 */
	public java.lang.Integer getToday1 () {
		return today1;
	}

	/**
	 * Set the value related to the column: today1
	 * @param today1 the today1 value
	 */
	public void setToday1 (java.lang.Integer today1) {
		this.today1 = today1;
	}



	/**
	 * Return the value associated with the column: rate2
	 */
	public java.math.BigDecimal getRate2 () {
		return rate2;
	}

	/**
	 * Set the value related to the column: rate2
	 * @param rate2 the rate2 value
	 */
	public void setRate2 (java.math.BigDecimal rate2) {
		this.rate2 = rate2;
	}



	/**
	 * Return the value associated with the column: fromday2
	 */
	public java.lang.Integer getFromday2 () {
		return fromday2;
	}

	/**
	 * Set the value related to the column: fromday2
	 * @param fromday2 the fromday2 value
	 */
	public void setFromday2 (java.lang.Integer fromday2) {
		this.fromday2 = fromday2;
	}



	/**
	 * Return the value associated with the column: today2
	 */
	public java.lang.Integer getToday2 () {
		return today2;
	}

	/**
	 * Set the value related to the column: today2
	 * @param today2 the today2 value
	 */
	public void setToday2 (java.lang.Integer today2) {
		this.today2 = today2;
	}



	/**
	 * Return the value associated with the column: rate3
	 */
	public java.math.BigDecimal getRate3 () {
		return rate3;
	}

	/**
	 * Set the value related to the column: rate3
	 * @param rate3 the rate3 value
	 */
	public void setRate3 (java.math.BigDecimal rate3) {
		this.rate3 = rate3;
	}



	/**
	 * Return the value associated with the column: fromday3
	 */
	public java.lang.Integer getFromday3 () {
		return fromday3;
	}

	/**
	 * Set the value related to the column: fromday3
	 * @param fromday3 the fromday3 value
	 */
	public void setFromday3 (java.lang.Integer fromday3) {
		this.fromday3 = fromday3;
	}



	/**
	 * Return the value associated with the column: today3
	 */
	public java.lang.Integer getToday3 () {
		return today3;
	}

	/**
	 * Set the value related to the column: today3
	 * @param today3 the today3 value
	 */
	public void setToday3 (java.lang.Integer today3) {
		this.today3 = today3;
	}



	/**
	 * Return the value associated with the column: rate4
	 */
	public java.math.BigDecimal getRate4 () {
		return rate4;
	}

	/**
	 * Set the value related to the column: rate4
	 * @param rate4 the rate4 value
	 */
	public void setRate4 (java.math.BigDecimal rate4) {
		this.rate4 = rate4;
	}



	/**
	 * Return the value associated with the column: fromday4
	 */
	public java.lang.Integer getFromday4 () {
		return fromday4;
	}

	/**
	 * Set the value related to the column: fromday4
	 * @param fromday4 the fromday4 value
	 */
	public void setFromday4 (java.lang.Integer fromday4) {
		this.fromday4 = fromday4;
	}



	/**
	 * Return the value associated with the column: today4
	 */
	public java.lang.Integer getToday4 () {
		return today4;
	}

	/**
	 * Set the value related to the column: today4
	 * @param today4 the today4 value
	 */
	public void setToday4 (java.lang.Integer today4) {
		this.today4 = today4;
	}



	/**
	 * Return the value associated with the column: rate5
	 */
	public java.math.BigDecimal getRate5 () {
		return rate5;
	}

	/**
	 * Set the value related to the column: rate5
	 * @param rate5 the rate5 value
	 */
	public void setRate5 (java.math.BigDecimal rate5) {
		this.rate5 = rate5;
	}



	/**
	 * Return the value associated with the column: fromday5
	 */
	public java.lang.Integer getFromday5 () {
		return fromday5;
	}

	/**
	 * Set the value related to the column: fromday5
	 * @param fromday5 the fromday5 value
	 */
	public void setFromday5 (java.lang.Integer fromday5) {
		this.fromday5 = fromday5;
	}



	/**
	 * Return the value associated with the column: today5
	 */
	public java.lang.Integer getToday5 () {
		return today5;
	}

	/**
	 * Set the value related to the column: today5
	 * @param today5 the today5 value
	 */
	public void setToday5 (java.lang.Integer today5) {
		this.today5 = today5;
	}


	


}