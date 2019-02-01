package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;






public final class JobcostDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public JobcostDTO(Jobcost dao) throws ApplicationException {
		initialize(dao);		
	}
	public JobcostDTO(Jobcost dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Jobcost dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));
		this.setCostkey(new CostBD(this.getSessionFactoryClusterMap()).read(dao.getCostkey()));
		
		this.setCosttype(dao.getCosttype());
		this.setCcykey(dao.getCcykey());
		this.setCstamt(dao.getCstamt());
		this.setTxt(dao.getTxt());
		
		this.setJobcostId(dao.getJobcostId());
		this.setJobhdrId(dao.getJobhdrId());
		this.setJobmovId(dao.getJobmovId());
		
		this.setPoststatus(dao.getPoststatus());
		
	}
	

	// primary key
	private java.lang.Integer jobcostId;

	// fields
	private java.lang.Integer jobhdrId;
	private java.math.BigDecimal cstamt;
	private Address mainvendoraddrkey;
	private java.lang.Integer accrlogLinkkey;
	private java.lang.String vendtarfhdrId;
	private boolean selfbillflag;
	private java.lang.String invstat;
	private java.lang.String accrstat;
	private java.lang.String costtype;
	private java.math.BigDecimal labourcstamt;
	private java.lang.Integer mandrlinkkey;
	private java.lang.String selfbillstat;
	private java.lang.String unitname;
	private boolean deleted;
	private java.util.Date invdate;
	private boolean mandrflag;
	private java.lang.Integer oqlinkKey;
	private java.lang.Integer jobmovId;
	private java.lang.String mandrkey;
	private java.lang.String txt;
	private java.lang.String pirefList;
	private java.math.BigDecimal xrate;
	private java.lang.Integer piLinkkey;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.math.BigDecimal materialcstamt;
	private java.lang.String orderno;
	private java.math.BigDecimal rate;
	private Address vendoraddrkey;
	private Cost costkey;
	private String poststatus;
	


    public String getPoststatus() {   	return (this.poststatus);    }
    public void setPoststatus(String poststatus) {        this.poststatus= poststatus;    }
    
    
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="JOBCOST_ID"
     */
	public java.lang.Integer getJobcostId () {
		return jobcostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param jobcostId the new ID
	 */
	public void setJobcostId (java.lang.Integer jobcostId) {
		this.jobcostId = jobcostId;
	}




	/**
	 * Return the value associated with the column: JOBHDR_ID
	 */
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 * Set the value related to the column: JOBHDR_ID
	 * @param jobhdrId the JOBHDR_ID value
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
	}







	/**
	 * Return the value associated with the column: CSTAMT
	 */
	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}

	/**
	 * Set the value related to the column: CSTAMT
	 * @param cstamt the CSTAMT value
	 */
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
	}



	/**
	 * Return the value associated with the column: mainvendoraddrkey
	 */
	public Address getMainvendoraddrkey () {
		return mainvendoraddrkey;
	}

	/**
	 * Set the value related to the column: mainvendoraddrkey
	 * @param mainvendoraddrkey the mainvendoraddrkey value
	 */
	public void setMainvendoraddrkey (Address mainvendoraddrkey) {
		this.mainvendoraddrkey = mainvendoraddrkey;
	}








	/**
	 * Return the value associated with the column: ACCRLOG_LINKKEY
	 */
	public java.lang.Integer getAccrlogLinkkey () {
		return accrlogLinkkey;
	}

	/**
	 * Set the value related to the column: ACCRLOG_LINKKEY
	 * @param accrlogLinkkey the ACCRLOG_LINKKEY value
	 */
	public void setAccrlogLinkkey (java.lang.Integer accrlogLinkkey) {
		this.accrlogLinkkey = accrlogLinkkey;
	}






	/**
	 * Return the value associated with the column: VENDTARFHDR_ID
	 */
	public java.lang.String getVendtarfhdrId () {
		return vendtarfhdrId;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrId (java.lang.String vendtarfhdrId) {
		this.vendtarfhdrId = vendtarfhdrId;
	}



	/**
	 * Return the value associated with the column: SELFBILLFLAG
	 */
	public boolean isSelfbillflag () {
		return selfbillflag;
	}

	/**
	 * Set the value related to the column: SELFBILLFLAG
	 * @param selfbillflag the SELFBILLFLAG value
	 */
	public void setSelfbillflag (boolean selfbillflag) {
		this.selfbillflag = selfbillflag;
	}



	/**
	 * Return the value associated with the column: INVSTAT
	 */
	public java.lang.String getInvstat () {
		return invstat;
	}

	/**
	 * Set the value related to the column: INVSTAT
	 * @param invstat the INVSTAT value
	 */
	public void setInvstat (java.lang.String invstat) {
		this.invstat = invstat;
	}






	/**
	 * Return the value associated with the column: ACCRSTAT
	 */
	public java.lang.String getAccrstat () {
		return accrstat;
	}

	/**
	 * Set the value related to the column: ACCRSTAT
	 * @param accrstat the ACCRSTAT value
	 */
	public void setAccrstat (java.lang.String accrstat) {
		this.accrstat = accrstat;
	}



	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param costtype the costtype value
	 */
	public void setCosttype (java.lang.String costtype) {
		this.costtype = costtype;
	}



	/**
	 * Return the value associated with the column: LABOURCSTAMT
	 */
	public java.math.BigDecimal getLabourcstamt () {
		return labourcstamt;
	}

	/**
	 * Set the value related to the column: LABOURCSTAMT
	 * @param labourcstamt the LABOURCSTAMT value
	 */
	public void setLabourcstamt (java.math.BigDecimal labourcstamt) {
		this.labourcstamt = labourcstamt;
	}





	/**
	 * Return the value associated with the column: MANDRLINKKEY
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: MANDRLINKKEY
	 * @param mandrlinkkey the MANDRLINKKEY value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
	}






	/**
	 * Return the value associated with the column: SELFBILLSTAT
	 */
	public java.lang.String getSelfbillstat () {
		return selfbillstat;
	}

	/**
	 * Set the value related to the column: SELFBILLSTAT
	 * @param selfbillstat the SELFBILLSTAT value
	 */
	public void setSelfbillstat (java.lang.String selfbillstat) {
		this.selfbillstat = selfbillstat;
	}



	/**
	 * Return the value associated with the column: unitname
	 */
	public java.lang.String getUnitname () {
		return unitname;
	}

	/**
	 * Set the value related to the column: unitname
	 * @param unitname the unitname value
	 */
	public void setUnitname (java.lang.String unitname) {
		this.unitname = unitname;
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
	 * Return the value associated with the column: INVDATE
	 */
	public java.util.Date getInvdate () {
		return invdate;
	}

	/**
	 * Set the value related to the column: INVDATE
	 * @param invdate the INVDATE value
	 */
	public void setInvdate (java.util.Date invdate) {
		this.invdate = invdate;
	}



	/**
	 * Return the value associated with the column: MANDRFLAG
	 */
	public boolean isMandrflag () {
		return mandrflag;
	}

	/**
	 * Set the value related to the column: MANDRFLAG
	 * @param mandrflag the MANDRFLAG value
	 */
	public void setMandrflag (boolean mandrflag) {
		this.mandrflag = mandrflag;
	}



	/**
	 * Return the value associated with the column: OQLINK_KEY
	 */
	public java.lang.Integer getOqlinkKey () {
		return oqlinkKey;
	}

	/**
	 * Set the value related to the column: OQLINK_KEY
	 * @param oqlinkKey the OQLINK_KEY value
	 */
	public void setOqlinkKey (java.lang.Integer oqlinkKey) {
		this.oqlinkKey = oqlinkKey;
	}



	/**
	 * Return the value associated with the column: JOBMOV_ID
	 */
	public java.lang.Integer getJobmovId () {
		return jobmovId;
	}

	/**
	 * Set the value related to the column: JOBMOV_ID
	 * @param jobmovId the JOBMOV_ID value
	 */
	public void setJobmovId (java.lang.Integer jobmovId) {
		this.jobmovId = jobmovId;
	}



	/**
	 * Return the value associated with the column: MANDRKEY
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: MANDRKEY
	 * @param mandrkey the MANDRKEY value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}






	/**
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: TXT
	 * @param txt the TXT value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}



	/**
	 * Return the value associated with the column: PIREF_LIST
	 */
	public java.lang.String getPirefList () {
		return pirefList;
	}

	/**
	 * Set the value related to the column: PIREF_LIST
	 * @param pirefList the PIREF_LIST value
	 */
	public void setPirefList (java.lang.String pirefList) {
		this.pirefList = pirefList;
	}



	/**
	 * Return the value associated with the column: XRATE
	 */
	public java.math.BigDecimal getXrate () {
		return xrate;
	}

	/**
	 * Set the value related to the column: XRATE
	 * @param xrate the XRATE value
	 */
	public void setXrate (java.math.BigDecimal xrate) {
		this.xrate = xrate;
	}












	/**
	 * Return the value associated with the column: PI_LINKKEY
	 */
	public java.lang.Integer getPiLinkkey () {
		return piLinkkey;
	}

	/**
	 * Set the value related to the column: PI_LINKKEY
	 * @param piLinkkey the PI_LINKKEY value
	 */
	public void setPiLinkkey (java.lang.Integer piLinkkey) {
		this.piLinkkey = piLinkkey;
	}



	/**
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
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
	 * Return the value associated with the column: MATERIALCSTAMT
	 */
	public java.math.BigDecimal getMaterialcstamt () {
		return materialcstamt;
	}

	/**
	 * Set the value related to the column: MATERIALCSTAMT
	 * @param materialcstamt the MATERIALCSTAMT value
	 */
	public void setMaterialcstamt (java.math.BigDecimal materialcstamt) {
		this.materialcstamt = materialcstamt;
	}



	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * @param orderno the orderno value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}







	/**
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: costkey
	 */
	public Cost getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (Cost costkey) {
		this.costkey = costkey;
	}
	

	
}
