package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public final class CosttemplateForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	private String readonly = "false";
	
	// primary key
	private java.lang.String costtemplateId;

	// fields
	private java.lang.String costkey;
	private java.lang.String sectionkey;
	private java.lang.String vendoraddrkey;
	private java.lang.String costtype = "LUMPSUM";	
	private java.lang.String ccykey;
	private boolean avgtariffcalcflag;
	private boolean tariffvarianceflag;	
	private String mintariffvariance = "0.0";
	private String maxtariffvariance = "0.0";
	private String avgtariffratebase = "0.0";
	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
     */
	public java.lang.String getCosttemplateId () {
		return costtemplateId;
	}

	/**
	 */
	public void setCosttemplateId (java.lang.String costtemplateId) {
		this.costtemplateId = costtemplateId;
	}




	/**
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}



	/**
	 */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}

	/**
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
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
	 * Return the value associated with the column: avgtariffcalcflag
	 */
	public boolean isAvgtariffcalcflag () {
		return avgtariffcalcflag;
	}

	/**
	 * Set the value related to the column: avgtariffcalcflag
	 * @param avgtariffcalcflag the avgtariffcalcflag value
	 */
	public void setAvgtariffcalcflag (boolean avgtariffcalcflag) {
		this.avgtariffcalcflag = avgtariffcalcflag;
	}


	/**
	 * Return the value associated with the column: tariffvarianceflag
	 */
	public boolean isTariffvarianceflag () {
		return tariffvarianceflag;
	}

	/**
	 * Set the value related to the column: tariffvarianceflag
	 * @param tariffvarianceflag the tariffvarianceflag value
	 */
	public void setTariffvarianceflag (boolean tariffvarianceflag) {
		this.tariffvarianceflag = tariffvarianceflag;
	}
	

	/**
	 * Return the value associated with the column: mintariffvariance
	 */
	public String getMintariffvariance () {
		return mintariffvariance;
	}

	/**
	 * Set the value related to the column: mintariffvariance
	 * @param mintariffvariance the mintariffvariance value
	 */
	public void setMintariffvariance (String mintariffvariance) {
		this.mintariffvariance = mintariffvariance;
	}



	/**
	 * Return the value associated with the column: maxtariffvariance
	 */
	public String getMaxtariffvariance () {
		return maxtariffvariance;
	}

	/**
	 * Set the value related to the column: maxtariffvariance
	 * @param maxtariffvariance the maxtariffvariance value
	 */
	public void setMaxtariffvariance (String maxtariffvariance) {
		this.maxtariffvariance = maxtariffvariance;
	}



	/**
	 */
	public String getAvgtariffratebase () {
		return avgtariffratebase;
	}

	/**
	 */
	public void setAvgtariffratebase (String avgtariffratebase) {
		this.avgtariffratebase = avgtariffratebase;
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






	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();


		addErrorIfBlank(errors, "costkey", costkey,	"error.cost.required");
		
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

}
