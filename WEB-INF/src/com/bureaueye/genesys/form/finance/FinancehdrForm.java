package com.bureaueye.genesys.form.finance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class FinancehdrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private String financehdrId;

	// fields
	private java.lang.String departmentkey;
	private java.lang.String contractno;
	private java.lang.String activitykey;

	private java.lang.String ccykey;
	private java.lang.String xlock;

	private java.lang.String doctypekey;
	
	private java.lang.String billdatedd;
	private java.lang.String billdatemm;
	private java.lang.String billdateyyyy;
	
	private boolean xinactive;

	private boolean manualflag;
	private boolean printedflag;
	private java.util.Date printdate;
	
	private java.lang.String leasetypekey;
	private String contractId;
	
	private java.util.Date postdate;
	
	private java.lang.String docdatedd;
	private java.lang.String docdatemm;
	private java.lang.String docdateyyyy;
	
	private String cashallocpayout = "0.0";
	private String grossamount = "0.0";
	private String vatamount = "0.0";
	private String payoutamount = "0.0";
	private String cashalloctotal = "0.0";
	private String netamount = "0.0";
	
	private java.lang.String companykey;

	private java.lang.String dockey;

	private boolean pyodoneflag;
	
	private java.lang.String createuserid;
	private java.lang.String lesseeaddrkey;
	
	private java.lang.String invoiceref;
	private java.lang.String taxcode;
	
	
	// collections
	
	
	
	public String getAction() {return _action;}

	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	

	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FINANCEHDR_ID"
     */
	public String getId () {
		return financehdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param financehdrId the new ID
	 */
	public void setId (String financehdrId) {
		this.financehdrId = financehdrId;
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








	public Date getBilldate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getBilldateyyyy()), Integer
						.parseInt(getBilldatemm()) - 1, Integer
						.parseInt(getBilldatedd()));
		return c.getTime();
	}
	public void setBilldate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setBilldateyyyy(c.get(Calendar.YEAR) + "");
		setBilldatemm((month < 10 ? "0" : "") + month);
		setBilldatedd((day < 10 ? "0" : "") + day);
	}
	public String getBilldatedd () {return billdatedd;}
	public void setBilldatedd (String billdatedd) {this.billdatedd = billdatedd;}
	public String getBilldatemm () {return billdatemm;}
	public void setBilldatemm (String billdatemm) {this.billdatemm = billdatemm;}
	public String getBilldateyyyy () {return billdateyyyy;}
	public void setBilldateyyyy (String billdateyyyy) {this.billdateyyyy = billdateyyyy;}




	/**
	 */
	public boolean isManualflag() {
		return manualflag;
	}

	/**
	 */
	public void setManualflag (boolean manualflag) {
		this.manualflag = manualflag;
	}
	

	/**
	 */
	public boolean isPrintedflag() {
		return printedflag;
	}

	/**
	 */
	public void setPrintedflag (boolean printedflag) {
		this.printedflag = printedflag;
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
	 * Return the value associated with the column: cashalloctotal
	 */
	public String getCashalloctotal () {
		return cashalloctotal;
	}

	/**
	 * Set the value related to the column: cashalloctotal
	 * @param cashalloctotal the cashalloctotal value
	 */
	public void setCashalloctotal (String cashalloctotal) {
		this.cashalloctotal = cashalloctotal;
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
	 * Return the value associated with the column: postdate
	 */
	public java.util.Date getPostdate () {
		return postdate;
	}

	/**
	 * Set the value related to the column: postdate
	 * @param postdate the postdate value
	 */
	public void setPostdate (java.util.Date postdate) {
		this.postdate = postdate;
	}


	/**
	 */
	public java.util.Date getPrintdate () {
		return printdate;
	}

	/**
	 */
	public void setPrintdate (java.util.Date printdate) {
		this.printdate = printdate;
	}
	

	public Date getDocdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDocdateyyyy()), Integer
						.parseInt(getDocdatemm()) - 1, Integer
						.parseInt(getDocdatedd()));
		return c.getTime();
	}
	public void setDocdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDocdateyyyy(c.get(Calendar.YEAR) + "");
		setDocdatemm((month < 10 ? "0" : "") + month);
		setDocdatedd((day < 10 ? "0" : "") + day);
	}
	public String getDocdatedd () {return docdatedd;}
	public void setDocdatedd (String docdatedd) {this.docdatedd = docdatedd;}
	public String getDocdatemm () {return docdatemm;}
	public void setDocdatemm (String docdatemm) {this.docdatemm = docdatemm;}
	public String getDocdateyyyy () {return docdateyyyy;}
	public void setDocdateyyyy (String docdateyyyy) {this.docdateyyyy = docdateyyyy;}




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
	 * Return the value associated with the column: cashallocpayout
	 */
	public String getCashallocpayout () {
		return cashallocpayout;
	}

	/**
	 * Set the value related to the column: cashallocpayout
	 * @param cashallocpayout the cashallocpayout value
	 */
	public void setCashallocpayout (String cashallocpayout) {
		this.cashallocpayout = cashallocpayout;
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
	 * Return the value associated with the column: pyodoneflag
	 */
	public boolean isPyodoneflag () {
		return pyodoneflag;
	}

	/**
	 * Set the value related to the column: pyodoneflag
	 * @param pyodoneflag the pyodoneflag value
	 */
	public void setPyodoneflag (boolean pyodoneflag) {
		this.pyodoneflag = pyodoneflag;
	}



	/**
	 * Return the value associated with the column: payoutamount
	 */
	public String getPayoutamount () {
		return payoutamount;
	}

	/**
	 * Set the value related to the column: payoutamount
	 * @param payoutamount the payoutamount value
	 */
	public void setPayoutamount (String payoutamount) {
		this.payoutamount = payoutamount;
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
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref () {
		return invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * @param invoiceref the invoiceref value
	 */
	public void setInvoiceref (java.lang.String invoiceref) {
		this.invoiceref = invoiceref;
	}



	/**
	 * Return the value associated with the column: taxcode
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: taxcode
	 * @param taxcode the taxcode value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
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

		addErrorIfBlank(errors, "lesseeaddrkey", lesseeaddrkey, "error.lessee.required");
		addErrorIfBlank(errors, "ccykey", ccykey, "error.ccykey.required");
		addErrorIfBlank(errors, "companykey", companykey, "error.company.required");
		
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
