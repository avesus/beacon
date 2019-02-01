package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;



/**
 * 
 * Amendments
 * ----------
 * 
 * NT	2013-12-06	WSI-201311-0003	BEACON LAKER (WSI LINER) 
 *			- add 'Account Representative' and 'Commission Type' fields to Address maintenance
 *			- add 'External System Address Id' to Address maintenance
 * 
 */
public final class AddressForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;	
	
	private String action;

	private String addrkey;

	private String typekey;
	private String[] arraytypekeylist;
	
	private String name;

	private String addr1;

	private String addr2;

	private String addr3;

	private String addr4;

	private String postalcode;

	private String ccykey;

	private String country;

	private String city;
/*
	private String town;
*/
	private String state;

	private String shortname;

	private String telno1;
/*
	private String telno2;

	private String telno3;
*/
	private String faxno1;

	private String emailno;

	private String _payterms;

	private String _paytermstext;

	private String _rentaddrkey;
	
	private String _mainaccaddrkey;
	
	private String _paymenttoinstructions;
	

	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String g4codekey;

	private java.lang.String accsysaddressid;
	
	
//WSI-201311-0003	
	private java.lang.String accRep;
	private java.lang.String commissiontype;
	private java.lang.String extsysaddressid;	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPayterms() {return _payterms;}
	public void setPayterms(String _payterms) {this._payterms = _payterms;}
	
	public String getPaytermstext() {return _paytermstext;}
	public void setPaytermstext(String _paytermstext) {this._paytermstext = _paytermstext;}

	public String getRentaddrkey() {return _rentaddrkey;}
	public void setRentaddrkey(String _rentaddrkey) {this._rentaddrkey = _rentaddrkey;}

	public String getMainaccaddrkey() {return _mainaccaddrkey;}
	public void setMainaccaddrkey(String _mainaccaddrkey) {this._mainaccaddrkey = _mainaccaddrkey;}

	public String getPaymenttoinstructions() {return _paymenttoinstructions;}
	public void setPaymenttoinstructions(String _paymenttoinstructions) {this._paymenttoinstructions = _paymenttoinstructions;}

	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getAddrkey() {
		return addrkey;
	}

	public void setAddrkey(String addrkey) {
		this.addrkey = addrkey;
	}

	public String getCcykey() {
		return ccykey;
	}

	public void setCcykey(String ccykey) {
		this.ccykey = ccykey;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailno() {
		return emailno;
	}

	public void setEmailno(String emailno) {
		this.emailno = emailno;
	}

	public String getFaxno1() {
		return faxno1;
	}

	public void setFaxno1(String faxno1) {
		this.faxno1 = faxno1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTelno1() {
		return telno1;
	}

	public void setTelno1(String telno1) {
		this.telno1 = telno1;
	}
/*
	public String getTelno2() {
		return telno2;
	}

	public void setTelno2(String telno2) {
		this.telno2 = telno2;
	}

	public String getTelno3() {
		return telno3;
	}

	public void setTelno3(String telno3) {
		this.telno3 = telno3;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
*/
	public String getTypekey() {
		return typekey;
	}

	public void setTypekey(String typekey) {
		this.typekey = typekey;
	}


	
	/**
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}
	/**
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}


	/**
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}

	
	/**
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}
	/**
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}
	
	/**
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}
	/**
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}
	
	

	public java.lang.String getAccsysaddressid () {
		return accsysaddressid;
	}
	public void setAccsysaddressid (java.lang.String accsysaddressid) {
		this.accsysaddressid = accsysaddressid;
	}
	
	
//sWSI-201311-0003
	public java.lang.String getCommissiontype () {
		return commissiontype;
	}
	public void setCommissiontype (java.lang.String commissiontype) {
		this.commissiontype = commissiontype;
	}
	
	public java.lang.String getAccRep () {
		return accRep;
	}
	public void setAccRep (java.lang.String accRep) {
		this.accRep = accRep;
	}
	
	public java.lang.String getExtsysaddressid () {
		return extsysaddressid;
	}
	public void setExtsysaddressid (java.lang.String extsysaddressid) {
		this.extsysaddressid = extsysaddressid;
	}	
//eWSI-201311-0003	
	
	
	
	public String getTypekeylist() {
		return concatArray(arraytypekeylist);
	}

	public void setTypekeylist(String typekeylist) {
		if (typekeylist != null) {
			arraytypekeylist = typekeylist.split("\\|");
		}
	}
	
	public void setArraytypekeylist(String[] arraytypekeylist) {
		this.arraytypekeylist = arraytypekeylist;
	}

	public String[] getArraytypekeylist() {
		return arraytypekeylist;
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
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		//default typekey to first element in typekeylist
		try {this.typekey=this.arraytypekeylist[0];} catch (Exception e) {}
		
		addErrorIfBlank(errors, "addrkey", addrkey, "error.code.required");
		addErrorIfBlank(errors, "name", name, "error.name.required");
		addErrorIfBlank(errors, "typekey", typekey, "error.type.required");
		addErrorIfBlank(errors, "shortname", shortname, "error.shortname.required");
		//addErrorIfBlank(errors, "ccykey", ccykey, "error.ccykey.required");
		
		if (action.equals("Create")) {
			if (Util.invalidChars(this.addrkey)) errors.add("addrkey", new ActionMessage("error.code.invalidchars"));
		}
		
		
		return errors;
	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	

	
	
}
