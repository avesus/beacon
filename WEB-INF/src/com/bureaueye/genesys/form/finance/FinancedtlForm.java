package com.bureaueye.genesys.form.finance;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



public final class FinancedtlForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	
	
	private String _action;
	private String _readonly = "false";

	
	
	// primary key
	private String financedtlId;


	// fields
	private java.lang.String contractno;
	private java.lang.String eqpkeyp9;

	private java.lang.String activitykey;
	private java.lang.String eqpkeyp6;
	private java.lang.String eqpkeyp5;
	private java.lang.String eqpkeyp8;

	private java.lang.String eqpkeyp7;
	private java.lang.String xlock;
	
	private java.util.Date createdate;
	
	private java.lang.String subtypekey;
	private java.lang.String doctypekey;
	private String doclineno = "0";
	
	private java.lang.String lesseeaddrkey;

	private boolean xinactive;
	
	private java.lang.String unitkey;
	private java.lang.String companykey;
	private java.lang.String offhireno;
	private java.lang.String dockey;
	
	private String vatamount = "0.0";
	private java.lang.String eqpkeyp3;
	private java.lang.String eqpkeyp4;
	private java.lang.String eqpkeyp1;
	private java.lang.String createuserid;
	private java.lang.String eqpkeyp2;
	private java.lang.String eqpkey;
	private java.lang.String departmentkey;
	private String onhireeqpId;
	private java.lang.String ccykey;
	private String netamount = "0.0";
	private java.lang.String eqpkeyp10;
	private String offhireId;
	private java.lang.String locationkey;
	private java.lang.String createtime;
	private java.util.Date billdate;
	private String offhireeqpId;
	private java.lang.String leasetypekey;
	private String contractId;
	private String contracteqpId;
	private String contracteqplocId;
	private String grossamount = "0.0";
	private String onhireId;
	private String financehdrId;
	private String unitId;
	private String paidtoinv = "0.0";
	private java.lang.String onhireno;
	private String days = "0";
	private java.lang.String txt1;
	private java.lang.String txt2;
	

	
	
	// collections

	
	
	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FINANCEDTL_ID"
     */
	public String getFinancedtlId () {
		return financedtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param financedtlId the new ID
	 */
	public void setFinancedtlId (String financedtlId) {
		this.financedtlId = financedtlId;
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
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
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
	 * Return the value associated with the column: subtypekey
	 */
	public java.lang.String getSubtypekey () {
		return subtypekey;
	}

	/**
	 * Set the value related to the column: subtypekey
	 * @param subtypekey the subtypekey value
	 */
	public void setSubtypekey (java.lang.String subtypekey) {
		this.subtypekey = subtypekey;
	}



	/**
	 * Return the value associated with the column: doctypekey
	 */
	public java.lang.String getDoctypekey () {
		return doctypekey;
	}

	/**
	 * Set the value related to the column: doctypekey
	 * @param doctypekey the doctypekey value
	 */
	public void setDoctypekey (java.lang.String doctypekey) {
		this.doctypekey = doctypekey;
	}






	/**
	 * Return the value associated with the column: doclineno
	 */
	public String getDoclineno () {
		return doclineno;
	}

	/**
	 * Set the value related to the column: doclineno
	 * @param doclineno the doclineno value
	 */
	public void setDoclineno (String doclineno) {
		this.doclineno = doclineno;
	}



	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public java.lang.String getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (java.lang.String lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
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
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}



	/**
	 * Return the value associated with the column: offhireno
	 */
	public java.lang.String getOffhireno () {
		return offhireno;
	}

	/**
	 * Set the value related to the column: offhireno
	 * @param offhireno the offhireno value
	 */
	public void setOffhireno (java.lang.String offhireno) {
		this.offhireno = offhireno;
	}



	/**
	 * Return the value associated with the column: dockey
	 */
	public java.lang.String getDockey () {
		return dockey;
	}

	/**
	 * Set the value related to the column: dockey
	 * @param dockey the dockey value
	 */
	public void setDockey (java.lang.String dockey) {
		this.dockey = dockey;
	}



	/**
	 * Return the value associated with the column: vatamount
	 */
	public String getVatamount () {
		return vatamount;
	}

	/**
	 * Set the value related to the column: vatamount
	 * @param vatamount the vatamount value
	 */
	public void setVatamount (String vatamount) {
		this.vatamount = vatamount;
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
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: ONHIREEQP_ID
	 */
	public String getOnhireeqpId () {
		return onhireeqpId;
	}

	/**
	 * Set the value related to the column: ONHIREEQP_ID
	 * @param onhireeqpId the ONHIREEQP_ID value
	 */
	public void setOnhireeqpId (String onhireeqpId) {
		this.onhireeqpId = onhireeqpId;
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
	 * Return the value associated with the column: netamount
	 */
	public String getNetamount () {
		return netamount;
	}

	/**
	 * Set the value related to the column: netamount
	 * @param netamount the netamount value
	 */
	public void setNetamount (String netamount) {
		this.netamount = netamount;
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
	 * Return the value associated with the column: OFFHIRE_ID
	 */
	public String getOffhireId () {
		return offhireId;
	}

	/**
	 * Set the value related to the column: OFFHIRE_ID
	 * @param offhireId the OFFHIRE_ID value
	 */
	public void setOffhireId (String offhireId) {
		this.offhireId = offhireId;
	}



	/**
	 * Return the value associated with the column: locationkey
	 */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
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
	 * Return the value associated with the column: billdate
	 */
	public java.util.Date getBilldate () {
		return billdate;
	}

	/**
	 * Set the value related to the column: billdate
	 * @param billdate the billdate value
	 */
	public void setBilldate (java.util.Date billdate) {
		this.billdate = billdate;
	}



	/**
	 * Return the value associated with the column: OFFHIREEQP_ID
	 */
	public String getOffhireeqpId () {
		return offhireeqpId;
	}

	/**
	 * Set the value related to the column: OFFHIREEQP_ID
	 * @param offhireeqpId the OFFHIREEQP_ID value
	 */
	public void setOffhireeqpId (String offhireeqpId) {
		this.offhireeqpId = offhireeqpId;
	}





	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
	}



	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public String getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param contractId the CONTRACT_ID value
	 */
	public void setContractId (String contractId) {
		this.contractId = contractId;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQP_ID
	 */
	public String getContracteqpId () {
		return contracteqpId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQP_ID
	 * @param contracteqpId the CONTRACTEQP_ID value
	 */
	public void setContracteqpId (String contracteqpId) {
		this.contracteqpId = contracteqpId;
	}



	/**
	 * Return the value associated with the column: CONTRACTEQPLOC_ID
	 */
	public String getContracteqplocId () {
		return contracteqplocId;
	}

	/**
	 * Set the value related to the column: CONTRACTEQPLOC_ID
	 * @param contracteqplocId the CONTRACTEQPLOC_ID value
	 */
	public void setContracteqplocId (String contracteqplocId) {
		this.contracteqplocId = contracteqplocId;
	}



	/**
	 * Return the value associated with the column: grossamount
	 */
	public String getGrossamount () {
		return grossamount;
	}

	/**
	 * Set the value related to the column: grossamount
	 * @param grossamount the grossamount value
	 */
	public void setGrossamount (String grossamount) {
		this.grossamount = grossamount;
	}



	/**
	 * Return the value associated with the column: ONHIRE_ID
	 */
	public String getOnhireId () {
		return onhireId;
	}

	/**
	 * Set the value related to the column: ONHIRE_ID
	 * @param onhireId the ONHIRE_ID value
	 */
	public void setOnhireId (String onhireId) {
		this.onhireId = onhireId;
	}



	/**
	 * Return the value associated with the column: FINANCEHDR_ID
	 */
	public String getFinancehdrId () {
		return financehdrId;
	}

	/**
	 * Set the value related to the column: FINANCEHDR_ID
	 * @param financehdrId the FINANCEHDR_ID value
	 */
	public void setFinancehdrId (String financehdrId) {
		this.financehdrId = financehdrId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public String getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (String unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: paidtoinv
	 */
	public String getPaidtoinv () {
		return paidtoinv;
	}

	/**
	 * Set the value related to the column: paidtoinv
	 * @param paidtoinv the paidtoinv value
	 */
	public void setPaidtoinv (String paidtoinv) {
		this.paidtoinv = paidtoinv;
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
	 * Return the value associated with the column: days
	 */
	public String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String txt1) {
		this.txt1 = txt1;
	}



	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}


	
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	
		
		addErrorIfBlank(errors, "subtypekey", subtypekey, "error.charge.required");
		addErrorIfBlank(errors, "doclineno", doclineno, "error.lineno.required");
		//addErrorIfBlank(errors, "unitkey", unitkey, "error.unit.required");
		
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
