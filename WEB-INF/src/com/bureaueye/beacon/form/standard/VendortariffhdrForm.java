package com.bureaueye.beacon.form.standard;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;

/**
 * 
 * Amendments ----------
 * 
 * NT 2009-06-16 ITT-200906-0004 Vendor Tariff Lump Sum Breakdown
 * 
 * NT 2009-09-14 200900037 Add 'Valid From' Date
 * 
 */
public final class VendortariffhdrForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private String vendtarfhdrId;

	private String action;

	private String ccykey;

	private String validtodd;
	private String validtomm;
	private String validtoyyyy;

	private String validfromdd;// 200900037
	private String validfrommm;// 200900037
	private String validfromyyyy;// 200900037

	private String tolocationkey;

	private String tslocationkey;

	private String fromlocationkey;

	private String vendoraddrkey;

	private String costkey;

	private String unittype;

	private String note1;

	private String note2;

	private String productkey;
	private java.lang.String producthazardous;
	private java.lang.String inclavgtarfcalcflag;

	private String lumpsum = "0.0";

	public Date getValidto() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getValidtoyyyy()),
				Integer.parseInt(getValidtomm()) - 1,
				Integer.parseInt(getValidtodd()));
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

	public String getFromlocationkey() {
		return fromlocationkey;
	}

	public void setFromlocationkey(String fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getTslocationkey() {
		return tslocationkey;
	}

	public void setTslocationkey(String tslocationkey) {
		this.tslocationkey = tslocationkey;
	}

	public String getTolocationkey() {
		return tolocationkey;
	}

	public void setTolocationkey(String tolocationkey) {
		this.tolocationkey = tolocationkey;
	}

	public String getProductkey() {
		return productkey;
	}

	public void setProductkey(String productkey) {
		this.productkey = productkey;
	}

	public String getLumpsum() {
		return lumpsum;
	}

	public void setLumpsum(String lumpsum) {
		this.lumpsum = lumpsum;
	}

	public String getVendoraddrkey() {
		return vendoraddrkey;
	}

	public void setVendoraddrkey(String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}

	public String getUnittype() {
		return unittype;
	}

	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}

	public String getCostkey() {
		return costkey;
	}

	public void setCostkey(String costkey) {
		this.costkey = costkey;
	}

	public String getCcykey() {
		return ccykey;
	}

	public void setCcykey(String ccykey) {
		this.ccykey = ccykey;
	}

	/**
	 */
	public java.lang.String getProducthazardous() {
		return producthazardous;
	}

	public void setProducthazardous(java.lang.String producthazardous) {
		this.producthazardous = producthazardous;
	}

	/**
	 */
	public java.lang.String getInclavgtarfcalcflag() {
		return inclavgtarfcalcflag;
	}

	public void setInclavgtarfcalcflag(java.lang.String inclavgtarfcalcflag) {
		this.inclavgtarfcalcflag = inclavgtarfcalcflag;
	}

	// s200900037
	public Date getValidfrom() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getValidfromyyyy()),
				Integer.parseInt(getValidfrommm()) - 1,
				Integer.parseInt(getValidfromdd()));
		return c.getTime();
	}

	public void setValidfrom(Date validfrom) {
		Calendar c = Calendar.getInstance();
		c.setTime(validfrom);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setValidfromyyyy(c.get(Calendar.YEAR) + "");
		setValidfrommm((month < 10 ? "0" : "") + month);
		setValidfromdd((day < 10 ? "0" : "") + day);
	}

	public String getValidfromdd() {
		return validfromdd;
	}

	public void setValidfromdd(String validfromdd) {
		this.validfromdd = validfromdd;
	}

	public String getValidfrommm() {
		return validfrommm;
	}

	public void setValidfrommm(String validfrommm) {
		this.validfrommm = validfrommm;
	}

	public String getValidfromyyyy() {
		return validfromyyyy;
	}

	public void setValidfromyyyy(String validfromyyyy) {
		this.validfromyyyy = validfromyyyy;
	}

	// e200900037

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getVendtarfhdrId() {
		return vendtarfhdrId;
	}

	public void setVendtarfhdrId(String vendtarfhdrId) {
		this.vendtarfhdrId = vendtarfhdrId;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = super.validate(mapping, request);
		if (errors == null)
			errors = new ActionErrors();
		// ActionErrors errors = new ActionErrors();
		//
		// addErrorIfBlank(errors, "validtodd", validtodd,
		// "error.validtodd.required");
		// addErrorIfBlank(errors, "validtomm", validtomm,
		// "error.validtomm.required");
		// addErrorIfBlank(errors, "validtoyyyy", validtoyyyy,
		// "error.validtoyyyy.required");
		// addErrorIfBlank(errors, "costkey.costkey", costkey.getCostkey(),
		// "error.costkey.required");
		// addErrorIfBlank(errors, "vendoraddrkey.addrkey", vendoraddrkey
		// .getAddrkey(), "error.vendoraddrkey.required");

		if (action.equals("Create")) {
			if (Util.invalidChars(this.vendtarfhdrId))
				errors.add("vendtarfhdrId", new ActionMessage(
						"error.code.invalidchars"));
		}

		return errors;

	}

	/*
	 * private void addErrorIfBlank(ActionErrors errors, String fieldName,
	 * String fieldValue, String message) { if (fieldValue == null ||
	 * fieldValue.trim().equals("")) { errors.add(fieldName, new
	 * ActionMessage(message)); } }
	 */

	/*
	 * //sITT-200906-0004 // code for the vendor tariff lump sum process private
	 * String action2;
	 * 
	 * private List<VendortarifflumpsumDTO> list;
	 * 
	 * private int[] selectedObjects;
	 * 
	 * private String vendtarfhdrId2;
	 * 
	 * private Object header;
	 * 
	 * public String getAction2() { return action2; }
	 * 
	 * public void setAction2(String action2) { this.action2 = action2; }
	 * 
	 * public Object getHeader() { return header; }
	 * 
	 * public void setHeader(Object header) { this.header = header; }
	 * 
	 * public String getVendtarfhdrId2() { return vendtarfhdrId2; }
	 * 
	 * public void setVendtarfhdrId2(String vendtarfhdrId2) {
	 * this.vendtarfhdrId2 = vendtarfhdrId2; }
	 * 
	 * public void setSelectedObjects(int[] selectedObjects) {
	 * this.selectedObjects = selectedObjects; }
	 * 
	 * 
	 * 
	 * public int[] getSelectedObjects() { return selectedObjects; }
	 * 
	 * public VendortarifflumpsumDTO getVendortarifflumpsumDTO(int i) { if
	 * (getList() == null) { setList(new ArrayList<VendortarifflumpsumDTO>()); }
	 * 
	 * while (getList().size() <= i) { getList().add(new
	 * VendortarifflumpsumDTO()); }
	 * 
	 * return (VendortarifflumpsumDTO) getList().get(i); } public
	 * List<VendortarifflumpsumDTO> getList() { return list; }
	 * 
	 * public void setList(List<VendortarifflumpsumDTO> list) { this.list =
	 * list; } //eITT-200906-0004
	 */

}
