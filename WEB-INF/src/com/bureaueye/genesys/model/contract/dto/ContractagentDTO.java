package com.bureaueye.genesys.model.contract.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.genesys.model.contract.Contractagent;



public final class ContractagentDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public ContractagentDTO(Contractagent dao) throws ApplicationException {
		initialize(dao);		
	}
	public ContractagentDTO(Contractagent dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Contractagent dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setAgentaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getAgentaddrkey()));
		
		this.setContractId(dao.getContractId());
		this.setContractagentId(dao.getContractagentId());

		this.setScheme(dao.getScheme());
		this.setLumpsumamt(dao.getLumpsumamt());
		this.setPercentamt(dao.getPercentamt());
		
		this.setReadonly("false");
		this.setChecked(false);	
	}
	
	
	
	// extra
    private boolean checked;	
	private String readonly = "false";
	
	
	// primary keys
	private java.lang.Integer contractagentId;
	private java.lang.Integer contractId;
	
	// fields
	private Address agentaddrkey;
	private String scheme;
	private java.math.BigDecimal percentamt;
	private java.math.BigDecimal lumpsumamt;

	
	

    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) { this.checked = b; }
    
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	

	/**
	 * Return the value associated with the column: agentaddrkey
	 */
	public Address getAgentaddrkey () {
		return agentaddrkey;
	}

	/**
	 * Set the value related to the column: agentaddrkey
	 * @param agentaddrkey the agentaddrkey value
	 */
	public void setAgentaddrkey (Address agentaddrkey) {
		this.agentaddrkey = agentaddrkey;
	}	
	
	

	/**
     */
	public java.lang.Integer getContractagentId () {
		return contractagentId;
	}

	/**
	 */
	public void setContractagentId (java.lang.Integer contractagentId) {
		this.contractagentId = contractagentId;
	}


	/**
     */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}

	
	/**
	 * Return the value associated with the column: scheme
	 */
	public java.lang.String getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme
	 * @param scheme the scheme value
	 */
	public void setScheme (java.lang.String scheme) {
		this.scheme = scheme;
	}
	
	/**
	 * Return the value associated with the column: percentamt
	 */
	public java.math.BigDecimal getPercentamt () {
		return percentamt;
	}

	/**
	 * Set the value related to the column: percentamt
	 * @param percentamt the percentamt value
	 */
	public void setPercentamt (java.math.BigDecimal percentamt) {
		this.percentamt = percentamt;
	}
	

	/**
	 * Return the value associated with the column: lumpsumamt
	 */
	public java.math.BigDecimal getLumpsumamt () {
		return lumpsumamt;
	}

	/**
	 * Set the value related to the column: lumpsumamt
	 * @param lumpsumamt the lumpsumamt value
	 */
	public void setLumpsumamt (java.math.BigDecimal lumpsumamt) {
		this.lumpsumamt = lumpsumamt;
	}

}