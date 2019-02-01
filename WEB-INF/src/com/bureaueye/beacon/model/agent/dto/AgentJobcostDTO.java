package com.bureaueye.beacon.model.agent.dto;

import java.io.Serializable;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;


/**
 * This is an object that contains data related to the jobcost table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jobcost"
 */

public class AgentJobcostDTO  implements Serializable {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	// constructors
	public AgentJobcostDTO () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public AgentJobcostDTO (java.lang.Integer jobcostId) {
		this.setJobcostId(jobcostId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer jobcostId;

	// fields
	private java.lang.Integer jobhdrId;
	private java.lang.String systemlogprogram;
	private java.math.BigDecimal cstamt;
	private java.lang.String mainvendoraddrkey;
	private java.lang.String systemloguserid;
	private java.lang.String systemlogaction;
	private java.lang.Integer accrlogLinkkey;
	private java.util.Date systemlogdate;
	private java.lang.String vendtarfhdrId;
	private boolean selfbillflag;
	private java.lang.String invstat;
	private boolean xinactive;
	private java.lang.String accrstat;
	private java.lang.String costtype;
	private java.math.BigDecimal labourcstamt;
	private java.lang.String systemloglock;
	private java.lang.Integer mandrlinkkey;
	private java.lang.String systemlogtime;
	private java.lang.String selfbillstat;
	private java.lang.String unitname;
	private boolean deleted;
	private java.util.Date invdate;
	private boolean mandrflag;
	private java.lang.Integer oqlinkKey;
	private java.lang.Integer jobmovId;
	private java.lang.String mandrkey;
	private java.lang.String createuserid;
	private java.lang.String txt;
	private java.lang.String pirefList;
	private java.math.BigDecimal xrate;
	private java.util.Date createdate;
	private java.lang.Integer rowid;
	private java.lang.String createtime;
	private java.lang.Integer piLinkkey;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.math.BigDecimal materialcstamt;
	private java.lang.String orderno;
	private java.lang.String xlock;
	private java.math.BigDecimal rate;
	private java.lang.String vendoraddrkey;
	private java.lang.String costkey;

	private Address vendoraddr;
	private Cost cost;

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
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddr () {
		return vendoraddr;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddr (Address vendoraddr) {
		this.vendoraddr = vendoraddr;
	}



	/**
	 * Return the value associated with the column: costkey
	 */
	public Cost getCost () {
		return cost;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCost (Cost cost) {
		this.cost= cost;
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
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
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
	public java.lang.String getMainvendoraddrkey () {
		return mainvendoraddrkey;
	}

	/**
	 * Set the value related to the column: mainvendoraddrkey
	 * @param mainvendoraddrkey the mainvendoraddrkey value
	 */
	public void setMainvendoraddrkey (java.lang.String mainvendoraddrkey) {
		this.mainvendoraddrkey = mainvendoraddrkey;
	}



	/**
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
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
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
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
	 * Return the value associated with the column: systemloglock
	 */
	public java.lang.String getSystemloglock () {
		return systemloglock;
	}

	/**
	 * Set the value related to the column: systemloglock
	 * @param systemloglock the systemloglock value
	 */
	public void setSystemloglock (java.lang.String systemloglock) {
		this.systemloglock = systemloglock;
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
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
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
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
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
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.job.Jobcost)) return false;
		else {
			com.bureaueye.beacon.model.job.Jobcost jobcost = (com.bureaueye.beacon.model.job.Jobcost) obj;
			if (null == this.getJobcostId() || null == jobcost.getJobcostId()) return false;
			else return (this.getJobcostId().equals(jobcost.getJobcostId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getJobcostId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getJobcostId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}