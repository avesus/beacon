package com.bureaueye.genesys.ajax.contract;

import java.io.IOException;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.genesys.model.contract.bd.ContractBD;
import com.bureaueye.genesys.model.contract.dto.ContractDTO;


public final class ListContractServlet extends BaseAJAX {
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
		String searchString1 = "";

		
		try {
			searchString1 = request.getParameter("searchString1");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+
				" searchString1: " + searchString1);
		
		// init output 
		StringBuffer xml = new StringBuffer("");
	    xml.append("<?xml version=\"1.0\"?>\n");		
		
		// process if input parameters found
		if (searchString1 != null) {
			
			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(searchString1);
			
			listForm.setOrderBy("Contractno");
			listForm.setOrderByDesc("Asc");
			
			try {	
				listForm.setLineItems(new ContractBD(this.getSessionFactoryClusterMap()).findContractsByLesseeaddrkey(listForm));
			} catch (ApplicationException ae) {}

		    xml.append("<listcontract generated=\""+System.currentTimeMillis()+"\" total=\""+listForm.getLineItems().size()+"\">\n");
		    
			for(Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				ContractDTO dto = (ContractDTO)it.next();
			    xml.append("<item id=\""+dto.getContractId()+"\">\n");				
				xml.append("<contractid><![CDATA[");
				xml.append(dto.getContractId());
				xml.append("]]></contractid>\n");
				xml.append("<contractno><![CDATA[");
				xml.append(dto.getContractno());
				xml.append("]]></contractno>\n");
				xml.append("<lesseeaddrkey><![CDATA[");
				xml.append(dto.getLesseeaddrkey().getName());
				xml.append("]]></lesseeaddrkey>\n");				
			    xml.append("</item>\n");				
			}
		
			xml.append("</listcontract>");
		}
		
		
		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml=" + xml.toString());
		
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
