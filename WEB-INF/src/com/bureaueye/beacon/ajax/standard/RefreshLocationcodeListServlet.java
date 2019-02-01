package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.Locationcode;

import com.bureaueye.beacon.model.standard.bd.LocationcodeBD;
import javax.servlet.*;


public final class RefreshLocationcodeListServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		String countrykey = request.getParameter("countrykey");
			
		StringBuffer results = new StringBuffer("");
		
		// get countrykey from country ---- THIS IS TEMPORARY
		
		
		results.append("<channel>");
		
		List dtos = null;		
		try {
			dtos = new LocationcodeBD(this.getSessionFactoryClusterMap())
						.findLocationcodesByCountrykey(countrykey);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Locationcode dto = (Locationcode)it.next();
				results.append("<locationcode>");
				results.append("<key>");
				results.append(dto.getLocationcode());
				results.append("</key>");
				results.append("<ldesc><![CDATA[");
				results.append(dto.getLdesc());
				results.append("]]></ldesc>");						
				results.append("</locationcode>");													
		}
		
		results.append("</channel>");
		
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");		
		response.getWriter().write(results.toString());
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
