package com.bureaueye.genesys.ajax.contract;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;


public final class FindContracteqpbyidServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	    Enumeration headers = request.getHeaderNames();
	    while (headers.hasMoreElements()) {
	      String header  =(String) headers.nextElement();
	      log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+	      
	    		  header+": "+request.getHeader(header));
	    }
	    
		// get input parameters
		String id = "";
		
		try {
			id = request.getParameter("id");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+
				" id=" + id);
		
		// init output 
		StringBuffer xml = new StringBuffer("");
	    xml.append("<?xml version=\"1.0\"?>\n");	
		
		// process if input parameters found
		if (id != null) {
			
		    xml.append("<contracteqps generated=\""+System.currentTimeMillis()+"\">\n");
		    
/*			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(id);
			listForm.setOrderBy("Eqpkeyp1");
			listForm.setOrderByDesc("Asc");	*/		
			
			Contracteqp dto = null;
			try {	
				dto = new ContracteqpBD(this.getSessionFactoryClusterMap()).read(new Integer(id));
			} catch (ApplicationException ae) {}
			
			if (dto != null) {

			    xml.append("<item id=\""+dto.getContracteqpId()+"\">\n");		
			    xml.append("<eqpkeyp1><![CDATA[");
			    xml.append(dto.getEqpkeyp1());
			    xml.append("]]></eqpkeyp1>\n");
			    xml.append("<eqpkeyp2><![CDATA[");
			    xml.append(dto.getEqpkeyp2());
			    xml.append("]]></eqpkeyp2>\n");
			    xml.append("<mindays><![CDATA[");
			    xml.append(dto.getMindays());
			    xml.append("]]></mindays>\n");					
			    xml.append("<freedays><![CDATA[");
			    xml.append(dto.getFreedays());
			    xml.append("]]></freedays>\n");
			    xml.append("</item>\n");			    

			}

			xml.append("</contracteqps>");
		}
		
		
		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml: " + xml.toString());
				
		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}		
}
