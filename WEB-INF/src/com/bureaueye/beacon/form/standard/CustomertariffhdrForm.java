package com.bureaueye.beacon.form.standard;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;

public final class CustomertariffhdrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String custtarfhdrId;

	private String customeraddrkey;

	private String chargekey;

	private String fromlocationkey;

	private String tolocationkey;

	private String fromlocationkey2;

	private String tolocationkey2;
	
	private String productkey;

	private String ccykey;

	private String validtodd;

	private String validtomm;

	private String validtoyyyy;

	private String unittype;
	
	private String lumpsum = "0.0";	

	public Date getValidto() {
		Calendar c = Calendar.getInstance();
		c
				.set(Integer.parseInt(getValidtoyyyy()), Integer
						.parseInt(getValidtomm()) - 1, Integer
						.parseInt(getValidtodd()));
		return c.getTime();
	}

	public void setValidto(Date validto) {
		Calendar c = Calendar.getInstance();
		c.setTime(validto);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setValidtoyyyy(c.get(Calendar.YEAR) + "");
		setValidtomm((month < 10 ? "0" : "") + month);
		setValidtodd((day < 10 ? "0" : "") + day);
	}

	public String getLumpsum() {
		return lumpsum;
	}

	public void setLumpsum(String lumpsum) {
		this.lumpsum = lumpsum;
	}
	
	public String getFromlocationkey() {
		return fromlocationkey;
	}

	public void setFromlocationkey(String fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}

	public String getFromlocationkey2() {
		return fromlocationkey2;
	}

	public void setFromlocationkey2(String fromlocationkey2) {
		this.fromlocationkey2 = fromlocationkey2;
	}
	
	public String getChargekey() {
		return chargekey;
	}

	public void setChargekey(String chargekey) {
		this.chargekey = chargekey;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCusttarfhdrId() {
		return custtarfhdrId;
	}

	public void setCusttarfhdrId(String custtarfhdrId) {
		this.custtarfhdrId = custtarfhdrId;
	}

	public String getCustomeraddrkey() {
		return customeraddrkey;
	}

	public void setCustomeraddrkey(String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}

	public String getCcykey() {
		return ccykey;
	}

	public void setCcykey(String ccykey) {
		this.ccykey = ccykey;
	}

	public String getProductkey() {
		return productkey;
	}

	public void setProductkey(String productkey) {
		this.productkey = productkey;
	}

	public String getTolocationkey() {
		return tolocationkey;
	}

	public void setTolocationkey(String tolocationkey) {
		this.tolocationkey = tolocationkey;
	}

	public String getTolocationkey2() {
		return tolocationkey2;
	}

	public void setTolocationkey2(String tolocationkey2) {
		this.tolocationkey2 = tolocationkey2;
	}

	public String getUnittype() {
		return unittype;
	}

	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}

	public String getValidtodd() {
		return validtodd;
	}

	public void setValidtodd(String validtodd) {
		this.validtodd = validtodd;
	}

	public String getValidtomm() {
		return validtomm;
	}

	public void setValidtomm(String validtomm) {
		this.validtomm = validtomm;
	}

	public String getValidtoyyyy() {
		return validtoyyyy;
	}

	public void setValidtoyyyy(String validtoyyyy) {
		this.validtoyyyy = validtoyyyy;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		// do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors =
			super.validate(mapping, request);
			if (errors==null) errors = new ActionErrors();
//		ActionErrors errors = new ActionErrors();
//
//		addErrorIfBlank(errors, "custtarfhdrId",
//				custtarfhdrId, "error.custtarfhdrid.required");		
//		addErrorIfBlank(errors, "customeraddrkey",
//				customeraddrkey.getAddrkey(), "error.addrkey.required");
//		addErrorIfBlank(errors, "chargekey", chargekey.getChargekey(),
//				"error.chargekey.required");
//		addErrorIfBlank(errors, "validtodd", validtodd,
//				"error.validtodd.required");
//		addErrorIfBlank(errors, "validtomm", validtomm,
//				"error.validtomm.required");
//		addErrorIfBlank(errors, "validtoyyyy", validtoyyyy,
//				"error.validtoyyyy.required");
		
			if (action.equals("Create")) {
				if (Util.invalidChars(this.custtarfhdrId)) errors.add("custtarfhdrId", new ActionMessage("error.code.invalidchars"));
			}
			
		return errors;

	}

/*	private void addErrorIfBlank(ActionErrors errors, 
			String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}*/

}
