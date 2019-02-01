package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import javax.servlet.*;

import org.hibernate.SessionFactory;


public final class LookupAddressServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	public static String PROP_CDATA_START = "<![CDATA[";
	public static String PROP_CDATA_END = "]]>";
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String addrkey = "";
		String xfield = "";
		
		try {
			addrkey = request.getParameter("addrkey");
			xfield = request.getParameter("xfield");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " addrkey: " + addrkey 
				+ " xfield: " + xfield
				);
		
		// init output 
		StringBuffer results = new StringBuffer("");
		
		
		results.append("<channel>");
		
		// process if input parameters found
		if (addrkey != null) {
					
			this.setAddress(addrkey,"address",this.getSessionFactoryClusterMap());
			results.append(this.getAddress());
			
		}
		
		results.append("</channel>");

		
		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " results: " + results.toString());
	
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(results.toString());
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	private String address;	

	public java.lang.String getAddress() {	return address; }
	public void setAddress(
			String key,
			String PROP_ADDRESS,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.address="";

		//init bd
		AddressBD addressbd = new AddressBD(sessionFactoryClusterMap);
		//init data objects
		Address addressdao = null;

		try{addressdao=addressbd.read(key);}catch(ApplicationException e){}		
		if (addressdao!=null) {

			this.address=  
				"<"+PROP_ADDRESS+">"+
				"<addrkey>"+PROP_CDATA_START+addressdao.getAddrkey()+PROP_CDATA_END+"</addrkey>"+
				"<name>"+PROP_CDATA_START+addressdao.getName()+PROP_CDATA_END+"</name>"+
				"<addr1>"+PROP_CDATA_START+addressdao.getAddr1()+PROP_CDATA_END+"</addr1>"+	
				"<addr2>"+PROP_CDATA_START+addressdao.getAddr2()+PROP_CDATA_END+"</addr2>"+	
				"<addr3>"+PROP_CDATA_START+addressdao.getAddr3()+PROP_CDATA_END+"</addr3>"+	
				"<addr4>"+PROP_CDATA_START+addressdao.getAddr4()+PROP_CDATA_END+"</addr4>"+
				"<addr5>"+PROP_CDATA_START+addressdao.getCountry()+PROP_CDATA_END+"</addr5>"+
				"<addr6>"+PROP_CDATA_START+""+PROP_CDATA_END+"</addr6>"+	
				"<addr7>"+PROP_CDATA_START+""+PROP_CDATA_END+"</addr7>"+					
				"<country>"+PROP_CDATA_START+addressdao.getCountry()+PROP_CDATA_END+"</country>"+	
				"<telno>"+PROP_CDATA_START+addressdao.getTelno1()+PROP_CDATA_END+"</telno>"+
				"<faxno>"+PROP_CDATA_START+addressdao.getFaxno1()+PROP_CDATA_END+"</faxno>"+
				"<email>"+PROP_CDATA_START+addressdao.getEmailno()+PROP_CDATA_END+"</email>"+				
				"<ccykey>"+PROP_CDATA_START+addressdao.getCcykey()+PROP_CDATA_END+"</ccykey>"+				
				"<paytermstext>"+PROP_CDATA_START+addressdao.getPaytermstext()+PROP_CDATA_END+"</paytermstext>"+
				"<paymenttoinstructions>"+PROP_CDATA_START+addressdao.getPaymenttoinstructions()+PROP_CDATA_END+"</paymenttoinstructions>"				
				;						
			this.address=this.address+  
			"</"+PROP_ADDRESS+">";		

		}

		//clear
		addressbd = null;	
		addressdao = null;

	}
	
	
}
