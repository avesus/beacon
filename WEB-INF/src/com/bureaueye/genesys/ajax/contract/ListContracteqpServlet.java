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
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;



public final class ListContracteqpServlet extends BaseAJAX {
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
				" searchString1=" + searchString1);
		
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
			
			listForm.setOrderBy("Eqpkeyp1");
			listForm.setOrderByDesc("Asc");
			
			try {	
				listForm.setLineItems(new ContracteqpBD(this.getSessionFactoryClusterMap())
						.findContracteqpsById(
								listForm.getSearchString1(),
								listForm.getGotoPage(),
								listForm.getMaxResults(),
								listForm.getOrderBy()
								)
							);
			} catch (ApplicationException ae) {}

		    xml.append("<listcontracteqp generated=\""+System.currentTimeMillis()+"\" total=\""+listForm.getLineItems().size()+"\">\n");
		    
			for(Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				Contracteqp dto = (Contracteqp)it.next();
			    xml.append("<item id=\""+dto.getContractId()+"\">\n");				
				xml.append("<contractid><![CDATA[");
				xml.append(dto.getContractId());
				xml.append("]]></contractid>\n");
				xml.append("<contracteqpid><![CDATA[");
				xml.append(dto.getContracteqpId());
				xml.append("]]></contracteqpid>\n");				
				xml.append("<eqpkeyp1><![CDATA[");
				xml.append(dto.getEqpkeyp1());
				xml.append("]]></eqpkeyp1>\n");
				xml.append("<eqpkeyp2><![CDATA[");
				xml.append(dto.getEqpkeyp2());
				xml.append("]]></eqpkeyp2>\n");					
			    xml.append("</item>\n");				
			}
		
			xml.append("</listcontracteqp>");
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
