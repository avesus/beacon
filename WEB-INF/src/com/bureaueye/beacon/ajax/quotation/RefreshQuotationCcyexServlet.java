package com.bureaueye.beacon.ajax.quotation;

import java.io.IOException;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import javax.servlet.*;




public final class RefreshQuotationCcyexServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String fromccykey = "";
		String toccykey = "";
		String xfield = "";
		String id1 = "";
		String id2 = "";
		Date exchgdate = new Date();
		
		try {
			fromccykey = request.getParameter("fromccykey");
			toccykey = request.getParameter("toccykey");
			xfield = request.getParameter("xfield");
			id1 = request.getParameter("id1");
			id2 = request.getParameter("id2");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " fromccykey: " + fromccykey 
				+ " toccykey: " + toccykey
				+ " xfield: " + xfield
				+ " id1: " + id1
				+ " id2: " + id2
				);
	
		// find quotation id1 if zero
		if (id1.equals("0") || id1.equals("") || id1==null) {
			try {
				id1 = new QuomovBD(this.getSessionFactoryClusterMap()).read(new Integer(id2)).getQuohdrId().toString();
			} catch (Exception e) {				
			}
		}
		// find quotation header id exchange rate date
		try {
			exchgdate = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(id1)).getExchgdate();
		} catch (Exception e) {				
		}		
		
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
			listForm.setSearchDate1(exchgdate);
			listForm.setOrderBy("Exdate");
			listForm.setOrderByDesc("Desc");
			
			//Ccyex dto = null;	
			String exrate = "1.0";
			try {
				//exrate = new Double(new CcyexBD(this.getSessionFactoryClusterMap()).getExrate(listForm)).toString().substring(0,9);
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
