package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;





public final class AddressDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public AddressDTO(Address dao) throws ApplicationException {
		initialize(dao);		
	}
	public AddressDTO(Address dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Address dao) throws ApplicationException {

		this.setAddrkey(dao.getAddrkey());
		this.setShortname(dao.getShortname());
		this.setName(dao.getName());
		this.setAddr1(dao.getAddr1());
		this.setAddr2(dao.getAddr2());
		this.setAddr3(dao.getAddr3());
		this.setAddr4(dao.getAddr4());	
		this.setAddr5(dao.getAddr5());
		this.setCountrykey(dao.getCountrykey());
		this.setCity(dao.getCity());
		this.setPostalcode(dao.getPostalcode());
		this.setTypekey(dao.getTypekey());

		this.setState(dao.getState());
		this.setTelno1(dao.getTelno1());
		this.setEmailno(dao.getEmailno());
		this.setFaxno1(dao.getFaxno1());
		this.setCountry(dao.getCountry());
		this.setCcykey(dao.getCcykey());
		
		//convert string list to list collection
		this.setTypekeylist	(dao.getTypekeylist());	
		if (this.getTypekeylist().size()==0) this.setTypekeylist(dao.getTypekey());

		
		try {this.setName(this.getName().substring(0,30));}catch(Exception e){}
		this.setLongLabel(this.getName()+" "+"["+dao.getTypekey().toLowerCase()+"]");

		this.setShortname(dao.getShortname());
		try {this.setShortname(this.getShortname().substring(0,18));}catch(Exception e){}
		String typekey = dao.getTypekey();
		try {typekey = dao.getTypekey().substring(0,3);}catch(Exception e){}
		this.setShortLabel(this.getShortname()+" "+"["+typekey.toLowerCase()+"]");
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	// primary key
	private java.lang.String addrkey;

	// fields
	private java.lang.String shortname;
	private java.lang.String name;
	private java.lang.String addr1;
	private java.lang.String addr2;
	private java.lang.String addr3;	
	private java.lang.String addr4;
	private java.lang.String addr5;
	private java.lang.String countrykey;
	private java.lang.String city;	
	private java.lang.String postalcode;
	private java.lang.String state;
	private java.lang.String telno1;
	private java.lang.String emailno;
	private java.lang.String faxno1;
	private java.lang.String country;
	private java.lang.String ccykey;
	
	private java.lang.String typekey;
	private List<String> typekeylist;

	private java.lang.String longLabel;
	private java.lang.String shortLabel;	




	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}


	
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
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}
	
	
	/**
	 * Return the value associated with the column: emailno
	 */
	public java.lang.String getEmailno () {
		return emailno;
	}

	/**
	 * Set the value related to the column: emailno
	 * @param emailno the emailno value
	 */
	public void setEmailno (java.lang.String emailno) {
		this.emailno = emailno;
	}
	
	
	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * Return the value associated with the column: telno1
	 */
	public java.lang.String getTelno1 () {
		return telno1;
	}

	/**
	 * Set the value related to the column: telno1
	 * @param telno1 the telno1 value
	 */
	public void setTelno1 (java.lang.String telno1) {
		this.telno1 = telno1;
	}
	
	/**
	 * Return the value associated with the column: faxno1
	 */
	public java.lang.String getFaxno1 () {
		return faxno1;
	}

	/**
	 * Set the value related to the column: faxno1
	 * @param faxno1 the faxno1 value
	 */
	public void setFaxno1 (java.lang.String faxno1) {
		this.faxno1 = faxno1;
	}
	
	
	/**
     */
	public java.lang.String getLongLabel () {
		return longLabel;
	}
	/**
	 */
	public void setLongLabel (java.lang.String _longLabel) {
		this.longLabel = _longLabel;
	}

	/**
     */
	public java.lang.String getShortLabel () {
		return shortLabel;
	}
	/**
	 */
	public void setShortLabel (java.lang.String _shortLabel) {
		this.shortLabel = _shortLabel;
	}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="addrkey"
     */
	public java.lang.String getAddrkey () {
		return addrkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param addrkey the new ID
	 */
	public void setAddrkey (java.lang.String addrkey) {
		this.addrkey = addrkey;
	}








	/**
	 * Return the value associated with the column: postalcode
	 */
	public java.lang.String getPostalcode () {
		return postalcode;
	}

	/**
	 * Set the value related to the column: postalcode
	 * @param postalcode the postalcode value
	 */
	public void setPostalcode (java.lang.String postalcode) {
		this.postalcode = postalcode;
	}




	/**
	 * Return the value associated with the column: addr1
	 */
	public java.lang.String getAddr1 () {
		return addr1;
	}

	/**
	 * Set the value related to the column: addr1
	 * @param addr1 the addr1 value
	 */
	public void setAddr1 (java.lang.String addr1) {
		this.addr1 = addr1;
	}



	/**
	 * Return the value associated with the column: typekey
	 */
	public java.lang.String getTypekey () {
		return typekey;
	}

	/**
	 * Set the value related to the column: typekey
	 * @param typekey the typekey value
	 */
	public void setTypekey (java.lang.String typekey) {
		this.typekey = typekey;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}









	/**
	 * Return the value associated with the column: shortname
	 */
	public java.lang.String getShortname () {
		return shortname;
	}

	/**
	 * Set the value related to the column: shortname
	 * @param shortname the shortname value
	 */
	public void setShortname (java.lang.String shortname) {
		this.shortname = shortname;
	}






	/**
	 * Return the value associated with the column: addr2
	 */
	public java.lang.String getAddr2 () {
		return addr2;
	}

	/**
	 * Set the value related to the column: addr2
	 * @param addr2 the addr2 value
	 */
	public void setAddr2 (java.lang.String addr2) {
		this.addr2 = addr2;
	}


	/**
	 * Return the value associated with the column: addr3
	 */
	public java.lang.String getAddr3 () {
		return addr3;
	}

	/**
	 * Set the value related to the column: addr3
	 * @param addr3 the addr3 value
	 */
	public void setAddr3 (java.lang.String addr3) {
		this.addr3 = addr3;
	}
	

	/**
	 * Return the value associated with the column: addr4
	 */
	public java.lang.String getAddr4 () {
		return addr4;
	}

	/**
	 * Set the value related to the column: addr4
	 * @param addr4 the addr4 value
	 */
	public void setAddr4 (java.lang.String addr4) {
		this.addr4 = addr4;
	}






	/**
	 * Return the value associated with the column: addr5
	 */
	public java.lang.String getAddr5 () {
		return addr5;
	}

	/**
	 * Set the value related to the column: addr5
	 * @param addr5 the addr5 value
	 */
	public void setAddr5 (java.lang.String addr5) {
		this.addr5 = addr5;
	}














	/**
	 * Return the value associated with the column: countrykey
	 */
	public java.lang.String getCountrykey () {
		return countrykey;
	}

	/**
	 * Set the value related to the column: countrykey
	 * @param countrykey the countrykey value
	 */
	public void setCountrykey (java.lang.String countrykey) {
		this.countrykey = countrykey;
	}



	/**
	 * Return the value associated with the column: typekeylist
	 */
	public List getTypekeylist () {
		return typekeylist;
	}

	/**
	 * Set the value related to the column: typekeylist
	 * @param typekeylist the typekeylist value
	 */
	public void setTypekeylist(String _typekeylist) {
		typekeylist = new LinkedList<String>();
		try {
			StringTokenizer st = new StringTokenizer(_typekeylist, "\\|");
			while (st.hasMoreTokens())
				typekeylist.add(st.nextToken());
		} catch (Exception e) {
		}
	}







	
}
