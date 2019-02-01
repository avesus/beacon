package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.G1code;
import com.bureaueye.beacon.model.standard.G2code;
import com.bureaueye.beacon.model.standard.G3code;
import com.bureaueye.beacon.model.standard.G4code;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.G1codeBD;
import com.bureaueye.beacon.model.standard.bd.G2codeBD;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;
import com.bureaueye.beacon.model.standard.bd.G4codeBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;

import javax.servlet.*;

import org.hibernate.SessionFactory;


public final class LookupLocationServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	public static String PROP_CDATA_START = "<![CDATA[";
	public static String PROP_CDATA_END = "]]>";
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String locationkey = "";
		String xfield = "";
		
		try {
			locationkey = request.getParameter("locationkey");
			xfield = request.getParameter("xfield");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " locationkey: " + locationkey 
				+ " xfield: " + xfield
				);
		
		// init output 
		StringBuffer results = new StringBuffer("");
		
		
		results.append("<channel>");
		
		// process if input parameters found
		if (locationkey != null) {
					
			this.setLocation(locationkey,"location",this.getSessionFactoryClusterMap());
			results.append(this.getLocation());
			
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

	
	
	private String location;	

	public java.lang.String getLocation() {	return location; }
	public void setLocation (
			String key,
			String PROP_LOCATION,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		this.location="";

		//init bd
		LocationBD locationbd = new LocationBD(sessionFactoryClusterMap);
		//init data objects
		Location locationdao = null;

		try{locationdao=locationbd.read(key);}catch(ApplicationException e){}		
		if (locationdao!=null) {

			this.location=  
				"<"+PROP_LOCATION+">"+
				"<locationkey>"+PROP_CDATA_START+locationdao.getLocationkey()+PROP_CDATA_END+"</locationkey>"+
				"<name>"+PROP_CDATA_START+locationdao.getLocationName()+PROP_CDATA_END+"</name>"+
				"<addr1>"+PROP_CDATA_START+locationdao.getAddress1()+PROP_CDATA_END+"</addr1>"+	
				"<addr2>"+PROP_CDATA_START+locationdao.getAddress2()+PROP_CDATA_END+"</addr2>"+	
				"<addr3>"+PROP_CDATA_START+locationdao.getAddress3()+PROP_CDATA_END+"</addr3>"+					
				"<country>"+PROP_CDATA_START+locationdao.getCountrykey()+PROP_CDATA_END+"</country>"+	
				"<telno>"+PROP_CDATA_START+locationdao.getPhone()+PROP_CDATA_END+"</telno>"+
				"<faxno>"+PROP_CDATA_START+locationdao.getFax()+PROP_CDATA_END+"</faxno>"+
				"<UNLocation>"+PROP_CDATA_START+locationdao.getLocationcode()+PROP_CDATA_END+"</UNLocation>"	
				;	


			G1codeBD g1codebd = new G1codeBD();
			G1code g1codedao = null;			
			try {
				g1codedao = 
					g1codebd.findG1codeByG1codekey(
							locationdao.getG1codekey()
					);
			}catch(ApplicationException e){}		
			if (g1codedao!=null) {	
				this.location=this.location+ 
				"<g1codekey>"+PROP_CDATA_START+g1codedao.getG1codekey()+PROP_CDATA_END+"</g1codekey>"+
				"<g1ldesc>"+PROP_CDATA_START+g1codedao.getLdesc()+PROP_CDATA_END+"</g1ldesc>";	
			}	
			g1codebd = null;

			G2codeBD g2codebd = new G2codeBD();
			G2code g2codedao = null;			
			try {
				g2codedao = 
					g2codebd.findG2codeByG1codekeyG2codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey()
					);
			}catch(ApplicationException e){}		
			if (g2codedao!=null) {	
				this.location=this.location+ 
				"<g2codekey>"+PROP_CDATA_START+g2codedao.getG2codekey()+PROP_CDATA_END+"</g2codekey>"+
				"<g2ldesc>"+PROP_CDATA_START+g2codedao.getLdesc()+PROP_CDATA_END+"</g2ldesc>";	
			}	
			g2codebd = null;

			G3codeBD g3codebd = new G3codeBD();
			G3code g3codedao = null;			
			try {
				g3codedao = 
					g3codebd.findG3codeByG1codekeyG2codekeyG3codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey(),
							locationdao.getG3codekey()
					);
			}catch(ApplicationException e){}		
			if (g3codedao!=null) {	
				this.location=this.location+ 
				"<g3codekey>"+PROP_CDATA_START+g3codedao.getG3codekey()+PROP_CDATA_END+"</g3codekey>"+
				"<g3ldesc>"+PROP_CDATA_START+g3codedao.getLdesc()+PROP_CDATA_END+"</g3ldesc>";	
			}	
			g3codebd = null;

			G4codeBD g4codebd = new G4codeBD();
			G4code g4codedao = null;			
			try {
				g4codedao = 
					g4codebd.findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey(),
							locationdao.getG3codekey(),
							locationdao.getG4codekey()
					);
			}catch(ApplicationException e){}		
			if (g4codedao!=null) {	
				this.location=this.location+ 
				"<g4codekey>"+PROP_CDATA_START+g4codedao.getG4codekey()+PROP_CDATA_END+"</g4codekey>"+
				"<g4ldesc>"+PROP_CDATA_START+g4codedao.getLdesc()+PROP_CDATA_END+"</g4ldesc>";	
			}	
			g4codebd = null;


			this.location=this.location+  
			"</"+PROP_LOCATION+">";		

		}

		//clear
		locationbd = null;	
		locationdao = null;

	}


	
	
	
}
