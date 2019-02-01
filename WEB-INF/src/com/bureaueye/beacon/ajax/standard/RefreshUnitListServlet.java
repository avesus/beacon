package com.bureaueye.beacon.ajax.standard;

import java.io.IOException;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import javax.servlet.*;


public final class RefreshUnitListServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		// get input parameters
		String invsts = "";

		
		try {
			invsts = request.getParameter("invsts");
		} catch (Exception e) {}
		
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " invsts: " + invsts 
				);
		
		// init output 
		StringBuffer results = new StringBuffer("");
		
		results.append("<channel>");
		
		// process if input parameters found
		if (invsts != null) {
			
			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(invsts);
			LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
			
/*			Calendar c = Calendar.getInstance();
			int dateRangeDays = 7;
			try{
				dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap())
												.read("DATERANGEDAYS","LISTQUOHDR")
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
			}*/
			listForm.setOrderBy("Unitkey");
			//listForm.setOrderByDesc("Asc");
			
			try {	
				listForm.setLineItems(new UnitBD(this.getSessionFactoryClusterMap()).findUnitsByMovests(listForm));
			} catch (ApplicationException ae) {}
			
			for(Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				Unit dto = (Unit)it.next();
				results.append("<unitlist>");
				results.append("<unitid><![CDATA[");
				results.append(dto.getUnitId());
				results.append("]]></unitid>");
				results.append("<jobmovdate><![CDATA[");
				results.append(dto.getJobmovdate());
				results.append("]]></jobmovdate>");				
				results.append("<movedate><![CDATA[");
				results.append(dto.getMovedate());
				results.append("]]></movedate>");
				results.append("<jobmovlocationkey><![CDATA[");
				
				try {
					results.append(locationbd.read(dto.getJobmovlocationkey()).getLocationName());
				} catch (Exception e) {}
				
				results.append("]]></jobmovlocationkey>");
				results.append("<movests><![CDATA[");
				results.append(dto.getMovests());
				results.append("]]></movests>");
				results.append("<invsts><![CDATA[");
				results.append(dto.getInvsts());
				results.append("]]></invsts>");
				results.append("<unitkey><![CDATA[");
				results.append(dto.getUnitkey());
				results.append("]]></unitkey>");				
				results.append("</unitlist>");
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
