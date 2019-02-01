package com.bureaueye.beacon.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import javax.servlet.*;


public final class RefreshLocationListServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	

	private static List locations = new ArrayList();
	
	private static String[] arrayfromlocationtype;
	
	private static String[] arraytolocationtype;	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			
		String sectionkey = request.getParameter("sectionkey");

		Section section = null;
		try {
			section = new SectionBD(this.getSessionFactoryClusterMap()).read(sectionkey);
		} catch (ApplicationException ae) {}
		
		
		StringBuffer results = new StringBuffer("");
		
		if (section != null) {
			
			results.append("<channel>");
			
			setFromlocationtype(section.getFromlocationtype());
			
			if (arrayfromlocationtype != null) {
				for (int i = 0; i < arrayfromlocationtype.length; i++) {			
					
					try {
						locations = new LocationBD(this.getSessionFactoryClusterMap()).findLocationsByType(arrayfromlocationtype[i], "LocationName");
					} catch (ApplicationException ae) {}
					
					int i2 = 0;
					for(Iterator it2 = locations.iterator(); it2.hasNext();) {
						i2++;
						if (i2 > 20) break;
						Location location = (Location)it2.next();
						results.append("<item>");
						results.append("<title>");
						results.append(location.getLocationkey());
						results.append("</title>");
						results.append("<description><![CDATA[");
						results.append(location.getLocationName());
						results.append("]]></description>");						
						results.append("</item>");											
//						if (!results.equals("")) {
//							results.append("|");
//						}						
//						results.append(location.getLocationkey());						
					}
				}
			}
			results.append("</channel>");
		}
		
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");		
		response.getWriter().write(results.toString());
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void setTolocationtype(String tolocationtype) {
		if (tolocationtype != null) {
			arraytolocationtype = tolocationtype.split("\\|");
		}
	}
	public void setFromlocationtype(String fromlocationtype) {
		if (fromlocationtype != null) {
			arrayfromlocationtype = fromlocationtype.split("\\|");
		}
	}
	
}
