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
import com.bureaueye.genesys.model.contract.bd.ContracteqplocBD;
import com.bureaueye.genesys.model.contract.dto.ContracteqplocDTO;



public final class ListContracteqplocServlet extends BaseAJAX {
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
		String searchString2 = "";
		
		try {
			searchString1 = request.getParameter("searchString1");
			searchString2 = request.getParameter("searchString2");			
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+
				" searchString1=" + searchString1+
				" searchString2=" + searchString2
				);
		
		// init output 
		StringBuffer xml = new StringBuffer("");
	    xml.append("<?xml version=\"1.0\"?>\n");		
		
		// process if input parameters found
		if (searchString1 != null && searchString2 != null) {
			
			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(searchString1);
			listForm.setSearchString2(searchString2);
			
			listForm.setOrderBy("Locationkey");
			listForm.setOrderByDesc("Asc");
			
			try {	
				listForm.setLineItems(
						new ContracteqplocBD(this.getSessionFactoryClusterMap()).findContracteqplocsByKey3(listForm)
						);
			} catch (ApplicationException ae) {}

		    xml.append("<listcontracteqploc generated=\""+System.currentTimeMillis()+"\" total=\""+listForm.getLineItems().size()+"\">\n");
		    
			for(Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				ContracteqplocDTO dto = (ContracteqplocDTO)it.next();
			    xml.append("<item id=\""+dto.getContractId()+"\">\n");				
				xml.append("<contracteqplocid><![CDATA[");
				xml.append(dto.getContracteqplocId());
				xml.append("]]></contracteqplocid>\n");
				xml.append("<contracteqpid><![CDATA[");
				xml.append(dto.getContracteqpId());
				xml.append("]]></contracteqpid>\n");				
				xml.append("<locationkey><![CDATA[");
				xml.append(dto.getLocationkey().getLocationkey());
				xml.append("]]></locationkey>\n");					
				xml.append("<locationname><![CDATA[");
				xml.append(dto.getLocationkey().getLocationName());
				xml.append("]]></locationname>\n");
				xml.append("<shortname><![CDATA[");
				xml.append(dto.getLocationkey().getShortName());
				xml.append("]]></shortname>\n");				
				xml.append("<locationreturns><![CDATA[");
				xml.append(dto.getLocationreturns());
				xml.append("]]></locationreturns>\n");
				xml.append("<handchg><![CDATA[");
				xml.append(dto.getHandchg());
				xml.append("]]></handchg>\n");
				xml.append("<minreturns><![CDATA[");
				xml.append(dto.getMinreturns());
				xml.append("]]></minreturns>\n");				
				xml.append("<monthreturns><![CDATA[");
				xml.append(dto.getMonthreturns());
				xml.append("]]></monthreturns>\n");
				xml.append("<locationreturns><![CDATA[");
				xml.append(dto.getLocationreturns());
				xml.append("]]></locationreturns>\n");				
				xml.append("</item>\n");				
			}
		
			xml.append("</listcontracteqploc>");
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
