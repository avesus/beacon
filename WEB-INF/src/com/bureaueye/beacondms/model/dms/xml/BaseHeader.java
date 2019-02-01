package com.bureaueye.beacondms.model.dms.xml;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;




public class BaseHeader  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	


	//public static String PROP_CDATA_START = "<![CDATA[";
	//public static String PROP_CDATA_END = "]]>";
	public static String PROP_CDATA_START = "";
	public static String PROP_CDATA_END = "";


	// constructors
	public BaseHeader () {
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.String emailfrom;
	private java.lang.String emailcc;
	private java.lang.String emailto;
	private java.lang.String companyheader;
	private java.lang.String subject;
	private java.lang.String languageid;
	private java.lang.String userid;



	public java.lang.String getUserid() {
		return userid;
	}
	public void setUserid(java.lang.String userid) {
		this.userid = "<user_id>"+PROP_CDATA_START+userid+PROP_CDATA_END+"</user_id>";
	}
	
	
	public java.lang.String getLanguageid () {
		return languageid;
	}
	public void setLangaugeid(java.lang.String languageid) {
		this.languageid = "<language_id>"+PROP_CDATA_START+languageid+PROP_CDATA_END+"</language_id>";
	}
	
	

	public java.lang.String getEmailfrom () {
		return emailfrom;
	}
	public void setEmailfrom (java.lang.String emailfrom) {
		this.emailfrom = "<email_from>"+PROP_CDATA_START+emailfrom+PROP_CDATA_END+"</email_from>";
	}

	
	public java.lang.String getEmailto () {
		return emailto;
	}
	public void setEmailto (java.lang.String emailto) {
		this.emailto = "<email_to>"+PROP_CDATA_START+emailto+PROP_CDATA_END+"</email_to>";
	}
	

	public java.lang.String getEmailcc () {
		return emailcc;
	}
	public void setEmailcc (java.lang.String emailcc) {
		this.emailcc = "<email_cc>"+PROP_CDATA_START+emailcc+PROP_CDATA_END+"</email_cc>";
	}
	
	
	public java.lang.String getSubject () {
		return subject;
	}
	public void setSubject(java.lang.String subject) {
		this.subject= "<subject>"+PROP_CDATA_START+subject+PROP_CDATA_END+"</subject>";
	}
	

	public void setCompanyheader (Integer key, Map<String, SessionFactory> sessionFactoryClusterMap) {		
		CompanyheaderBD companyheaderbd = new CompanyheaderBD(sessionFactoryClusterMap);
		Companyheader companyheaderdao = null;			
		try {companyheaderdao  = companyheaderbd.read(key);}catch(ApplicationException e){}
		if (companyheaderdao!=null) {
		this.companyheader = 
			"<company_header>"+
			"<company_header_id>"+PROP_CDATA_START+companyheaderdao.getCompanyheaderId()+PROP_CDATA_END+"</company_header_id>"+
			"<company_name>"+PROP_CDATA_START+companyheaderdao.getCompanyName()+PROP_CDATA_END+"</company_name>"+
			"<address>"+PROP_CDATA_START+companyheaderdao.getAddress()+PROP_CDATA_END+"</address>"+
			"<city>"+PROP_CDATA_START+companyheaderdao.getCity()+PROP_CDATA_END+"</city>"+
			"<phone>"+PROP_CDATA_START+companyheaderdao.getPhone()+PROP_CDATA_END+"</phone>"+
			"<fax>"+PROP_CDATA_START+companyheaderdao.getFax()+PROP_CDATA_END+"</fax>"+
			"<logo>"+PROP_CDATA_START+companyheaderdao.getLogo()+PROP_CDATA_END+"</logo>"+
			"</company_header>";
		}
		companyheaderbd=null;
	}
	public java.lang.String getCompanyheader () {
		return companyheader;
	}







	@Override
	public String toString () {
		String xml =
			subject+
			emailto+
			emailfrom+
			emailcc+
			companyheader;
		return xml;
	}




}