package com.bureaueye.beacon.ajax.purchaseinvoice;

import java.io.IOException;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;



public final class ListVendorjobsServlet extends BaseAJAX {
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
		
		
		//if ccy blank default from address
		try {
			if (searchString2.equals("")) {
				//init business delegate
				AddressBD addressbd= new AddressBD(this.getSessionFactoryClusterMap());
				Address address=addressbd.read(searchString1);
				if (address!=null) searchString2=address.getCcykey();
				//clear objects
				address=null;
				addressbd=null;
			}
		} catch (Exception e) {}
		
		
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+
				" searchString1[" + searchString1+"]"+
				" searchString2[" + searchString2+"]"				
				);
		
		
		// init output 
		StringBuffer xml = new StringBuffer("");
	    xml.append("<?xml version=\"1.0\"?>\n");		
		
		// process if input parameters found
		if (searchString1 != null && searchString2 != null) {

			List lineItems=null;
			try {
				// set purchase invoice vendor job list
				JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

				lineItems=jobcostbd.findJobcostsByVendoraddrkeyCcykey(
								searchString1,//vendor
								searchString2,//ccy
								0,
								com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
								"jobhdr.JobhdrId"
						);

				//clear objects
				jobcostbd=null;
			} catch (Exception e) {}
			

		    xml.append("<listvendorjobs generated=\""+System.currentTimeMillis()+"\" total=\""+lineItems.size()+"\">\n");
		    
			for(Iterator it = lineItems.iterator(); it.hasNext();) {
				com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO dto = (com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO)it.next();
			    xml.append("<item id=\""+dto.getJobhdrId()+"\">\n");				
				xml.append("<jobno><![CDATA[");
				xml.append(dto.getJobno());
				xml.append("]]></jobno>\n");
				xml.append("<orderno><![CDATA[");
				xml.append(dto.getOrderno());
				xml.append("]]></orderno>\n");
				xml.append("<jobhdrid><![CDATA[");
				xml.append(dto.getJobhdrId());
				xml.append("]]></jobhdrid>\n");
				xml.append("<orderhdrid><![CDATA[");
				xml.append(dto.getOrderhdrId());
				xml.append("]]></orderhdrid>\n");
				xml.append("<unitkey><![CDATA[");
				xml.append(dto.getUnitkey());
				xml.append("]]></unitkey>\n");					
			    xml.append("</item>\n");				
			}
		
			xml.append("</listvendorjobs>");
		}
		
		
		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + 
				" xml["+xml.toString()+"]"
				);
		
		
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
