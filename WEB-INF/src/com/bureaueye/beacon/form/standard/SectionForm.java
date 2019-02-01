package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;

public final class SectionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String sectionkey;

	private String descr;

	private boolean mandrflag;

	private String invsts;
	
	private String movests;
	
	
	private String transportmode;
	
	private String[] arraycost;

	private String[] arrayfromlocationtype;

	private String[] arraytolocationtype;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getInvsts() {
		return invsts;
	}

	public void setInvsts(String invsts) {
		this.invsts = invsts;
	}

	public String getMovests() {
		return movests;
	}

	public void setMovests(String movests) {
		this.movests = movests;
	}
	
	
	public boolean isMandrflag() {
		return mandrflag;
	}

	public void setMandrflag(boolean mandrflag) {
		this.mandrflag = mandrflag;
	}

	public String getSectionkey() {
		return sectionkey;
	}

	public void setSectionkey(String sectionkey) {
		this.sectionkey = sectionkey;
	}

	public String getTransportmode() {
		return transportmode;
	}

	public void setTransportmode(String transportmode) {
		this.transportmode = transportmode;
	}

	public String getCost() {
		return concatArray(arraycost);
	}

	public void setCost(String cost) {
		if (cost != null) {
			arraycost = cost.split("\\|");
		}
	}

	public String getFromlocationtype() {
		return concatArray(arrayfromlocationtype);
	}

	public void setFromlocationtype(String fromlocationtype) {
		if (fromlocationtype != null) {
			arrayfromlocationtype = fromlocationtype.split("\\|");
		}
	}

	public String getTolocationtype() {
		return concatArray(arraytolocationtype);
	}

	public void setTolocationtype(String tolocationtype) {
		if (tolocationtype != null) {
			arraytolocationtype = tolocationtype.split("\\|");
		}
	}

	public String[] getArraycost() {
		return arraycost;
	}

	public void setArraycost(String[] arraycost) {
		this.arraycost = arraycost;
	}

	public String[] getArrayfromlocationtype() {
		return arrayfromlocationtype;
	}

	public void setArrayfromlocationtype(String[] arrayfromlocationtype) {
		this.arrayfromlocationtype = arrayfromlocationtype;
	}

	public String[] getArraytolocationtype() {
		return arraytolocationtype;
	}

	public void setArraytolocationtype(String[] arraytolocationtype) {
		this.arraytolocationtype = arraytolocationtype;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "sectionkey", sectionkey, "error.sectionkey.required");
		addErrorIfBlank(errors, "descr", descr, "error.description.required");
		addErrorIfBlank(errors, "invsts", invsts, "error.invsts.required");
		addErrorIfBlank(errors, "movests", movests, "error.movests.required");
		
		if (action.equals("Create")) {
			if (Util.invalidChars(this.sectionkey)) errors.add("sectionkey", new ActionMessage("error.code.invalidchars"));
		}

		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	private String concatArray(String[] array) {
		StringBuffer concat = new StringBuffer();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].length() > 0) {
					concat.append(array[i]);
					if (i < array.length - 1) {
						concat.append("|");
					}
				}
			}
		}
		return concat.toString();
	}
}
