package com.bureaueye.genesys.model.finance.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.genesys.model.finance.Financedtl;








public final class FinancedtlDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public FinancedtlDTO(Financedtl dao) throws ApplicationException {
		initialize(dao);		
	}
	public FinancedtlDTO(Financedtl dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Financedtl dao) throws ApplicationException {
		
		// populate data-transfer-object from data-access-object
		this.setSubtypekey(new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getSubtypekey()));

		this.setFinancedtlId(dao.getFinancedtlId());
		this.setFinancehdrId(dao.getFinancehdrId());
		
		this.setCcykey(dao.getCcykey());
		this.setGrossamount(dao.getGrossamount());
		this.setNetamount(dao.getNetamount());
		this.setVatamount(dao.getVatamount());
		this.setDoclineno(dao.getDoclineno());
		this.setUnitkey(dao.getUnitkey());
		
	}
	
	
	
	
	private String readonly = "false";
	
	
	// primary key
	private java.lang.Integer financehdrId;
	private java.lang.Integer financedtlId;
	
	// fields
	private java.math.BigDecimal netamount;
	private java.lang.String ccykey;
	private java.lang.String unitkey;
	private Integer doclineno;
	private java.math.BigDecimal vatamount;
	private java.math.BigDecimal grossamount;
	

	// many-to-one
	private Charge subtypekey;

	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	

	/**
     */
	public java.lang.Integer getFinancedtlId () {
		return financedtlId;
	}

	/**
	 */
	public void setFinancedtlId (java.lang.Integer financedtlId) {
		this.financedtlId = financedtlId;
	}


	/**
     */
	public java.lang.Integer getFinancehdrId () {
		return financehdrId;
	}

	/**
	 */
	public void setFinancehdrId (java.lang.Integer financehdrId) {
		this.financehdrId = financehdrId;
	}
	









	/**
	 * Return the value associated with the column: netamount
	 */
	public java.math.BigDecimal getNetamount () {
		return netamount;
	}

	/**
	 * Set the value related to the column: netamount
	 * @param netamount the netamount value
	 */
	public void setNetamount (java.math.BigDecimal netamount) {
		this.netamount = netamount;
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
	 * Return the value associated with the column: grossamount
	 */
	public java.math.BigDecimal getGrossamount () {
		return grossamount;
	}

	/**
	 * Set the value related to the column: grossamount
	 * @param grossamount the grossamount value
	 */
	public void setGrossamount (java.math.BigDecimal grossamount) {
		this.grossamount = grossamount;
	}





	/**
	 * Return the value associated with the column: vatamount
	 */
	public java.math.BigDecimal getVatamount () {
		return vatamount;
	}

	/**
	 * Set the value related to the column: vatamount
	 * @param vatamount the vatamount value
	 */
	public void setVatamount (java.math.BigDecimal vatamount) {
		this.vatamount = vatamount;
	}




	/**
	 */
	public Charge getSubtypekey () {
		return subtypekey;
	}

	/**
	 */
	public void setSubtypekey (Charge subtypekey) {
		this.subtypekey = subtypekey;
	}

	
	/**
	 * Return the value associated with the column: doclineno
	 */
	public java.lang.Integer getDoclineno () {
		return doclineno;
	}

	/**
	 * Set the value related to the column: doclineno
	 * @param doclineno the doclineno value
	 */
	public void setDoclineno (java.lang.Integer doclineno) {
		this.doclineno = doclineno;
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


}