package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.Imdg;
import com.bureaueye.beacon.model.standard.bd.ImdgBD;


import javax.servlet.*;




public final class FindImdgByIdAjax extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String id = "";
		
		
		try {
			id = request.getParameter("id");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " id: " + id 
		);
		
		
		// init output 
		StringBuffer xml = new StringBuffer("");
	    xml.append("<?xml version=\"1.0\"?>\n");		

		
		// process if input parameters found
		if (id != null) {
			
			Imdg dao = null;		
			try {
				dao = new ImdgBD(this.getSessionFactoryClusterMap()).read(id);
			} catch (ApplicationException ae) {}	
			
			if (dao!=null) {
				
			    xml.append("<imdgs generated=\""+System.currentTimeMillis()+"\">\n");
			    
			    xml.append("<item id=\""+dao.getImdgkey()+"\">\n");		
			    xml.append("<imdgsc1><![CDATA[");
			    xml.append(dao.getImdgsc1());
			    xml.append("]]></imdgsc1>\n");
			    xml.append("<imdgsc2><![CDATA[");
			    xml.append(dao.getImdgsc2());
			    xml.append("]]></imdgsc2>\n");
			    xml.append("<description><![CDATA[");
			    xml.append(dao.getDescription());
			    xml.append("]]></description>\n");					
			    xml.append("<flashpointmandatory><![CDATA[");
			    xml.append(dao.isFlashpointmandatory());
			    xml.append("]]></flashpointmandatory>\n");
			    xml.append("</item>\n");
			}
			
		}
		
		xml.append("</imdgs>");
		
		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml: " + xml.toString());
				
		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
}
