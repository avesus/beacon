package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import javax.servlet.*;


public final class RefreshCcyexServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String fromccykey = "";
		String toccykey = "";
		String xfield = "";
		
		try {
			fromccykey = request.getParameter("fromccykey");
			toccykey = request.getParameter("toccykey");
			xfield = request.getParameter("xfield");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " fromccykey: " + fromccykey + " toccykey: " + toccykey
				+ " xfield: " + xfield
				);
		
		// init output 
		StringBuffer results = new StringBuffer("");
		
		results.append("<channel>");
		
		// process if input parameters found
		if (fromccykey != null && toccykey != null) {
			
			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(fromccykey);
			listForm.setSearchString2(toccykey);
			listForm.setSearchDate1(new Date());
			listForm.setOrderBy("Exdate");
			listForm.setOrderByDesc("Desc");
			
			//Ccyex dto = null;	
			String exrate = "1.0";
			try {
				exrate = new Double(new CcyexBD(this.getSessionFactoryClusterMap()).getExrate(listForm)).toString();
			} catch (Exception ae) {				
			}
			
			results.append("<ccyex>");
			results.append("<fromccykey><![CDATA[");
			results.append(fromccykey);
			results.append("]]></fromccykey>");
			results.append("<toccykey><![CDATA[");
			results.append(toccykey);
			results.append("]]></toccykey>");
			results.append("<exrate><![CDATA[");
			results.append(exrate);
			results.append("]]></exrate>");
			results.append("<xfield><![CDATA[");
			results.append(xfield);
			results.append("]]></xfield>");			
			results.append("</ccyex>");
			
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
	
}
