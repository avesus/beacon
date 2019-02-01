package com.bureaueye.beacon.ajax.quotation;

import java.io.IOException;

import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import javax.servlet.*;



public final class RefreshQuohdrListServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String userid = "";

		
		try {
			userid = request.getParameter("userid");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " userid: " + userid 
				);
		
		// init output 
		StringBuffer results = new StringBuffer("");
		
		results.append("<channel>");
		
		// process if input parameters found
		if (userid != null) {
			
			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(userid);
			AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
			
			Calendar c = Calendar.getInstance();
			int dateRangeDays = 7;
			try{
				dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap())
												.read(new SystemcodePK("DATERANGEDAYS","LISTQUOHDR"))
												.getDescr())
												.intValue();
			}catch(Exception e){}
			// quote date 'from'
			if (listForm.getSearchDate1() == null) {
				c.add(Calendar.DATE,-1*dateRangeDays);			
				// default 'from' date to today minus 7
				try {
					listForm.setSearchDate1(c.getTime());
				} catch (Exception e) {				
				}					
			}
			// quote date 'to'		
			if (listForm.getSearchDate2() == null) {			
				// default 'to' date plus 7 
				c.add(Calendar.DATE,dateRangeDays);
				try {
					listForm.setSearchDate2(c.getTime());
				} catch (Exception e) {
				}								
			}
			listForm.setOrderBy("Quotedate");
			listForm.setOrderByDesc("Desc");
			
			try {	
				listForm.setLineItems(new QuohdrBD(this.getSessionFactoryClusterMap()).findQuohdrsByKey1(listForm));
			} catch (ApplicationException ae) {}
			
			for(Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				Quohdr dao = (Quohdr)it.next();
				results.append("<quohdrlist>");
				results.append("<quohdrid><![CDATA[");
				results.append(dao.getId());
				results.append("]]></quohdrid>");
				results.append("<quotno><![CDATA[");
				results.append(dao.getQuotno());
				results.append("]]></quotno>");
				results.append("<customeraddrkey><![CDATA[");
				
				try {
					results.append(addressbd.read(dao.getCustomeraddrkey()).getName());
				} catch (Exception e) {}
				
				results.append("]]></customeraddrkey>");
				results.append("<quotestatus><![CDATA[");
				results.append(dao.getQuotestatus());
				results.append("]]></quotestatus>");
				results.append("<quotedate><![CDATA[");
				results.append(dao.getQuotedate());
				results.append("]]></quotedate>");				
				results.append("</quohdrlist>");
			}
			
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
