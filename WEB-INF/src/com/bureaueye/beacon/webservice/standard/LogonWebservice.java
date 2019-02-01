package com.bureaueye.beacon.webservice.standard;

import java.io.IOException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.webservice.BaseWebservice;

import javax.servlet.*;




public final class LogonWebservice extends BaseWebservice {
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
		ListForm listForm = new ListForm();
		listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
		listForm.setGotoPage(0);

		try {
			listForm.setSearchString1(request.getParameter("userid"));
			listForm.setSearchString2(request.getParameter("password"));
		} catch (Exception e) {}


		// init output 
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");

		User userdao = null;
		try {
			userdao = new UserBD(this.getSessionFactoryClusterMap()).findUserByUserid(listForm.getSearchString1());
		} catch (Exception ae) {				
		}


		xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+"1"+"\">\n");
		String message = "";
		
		//check userid found
		if (userdao != null) {

			//check password matches
			if (userdao.getPassword().equals(listForm.getSearchString2())) {
				message="Logon successful";
				xml.append("<item id=\""+userdao.getUserid()+"\">\n");	
				xml.append("<message><![CDATA[");
				xml.append(message);
				xml.append("]]></message>\n");					
				xml.append("<userid><![CDATA[");
				xml.append(userdao.getUserid());
				xml.append("]]></userid>\n");	
				xml.append("<password><![CDATA[");
				xml.append(userdao.getPassword());
				xml.append("]]></password>\n");						
				xml.append("</item>\n");
			} else {
				//incorrect password 
				message="Incorrect password entered";
				xml.append("<item id=\""+userdao.getUserid()+"\">\n");				
				xml.append("<message><![CDATA[");
				xml.append(message);
				xml.append("]]></message>\n");						
				xml.append("</item>\n");		
			}

		} else {
			//incorrect userid
			message="Incorrect userid entered";
			xml.append("<item id=\""+""+"\">\n");				
			xml.append("<message><![CDATA[");
			xml.append(message);
			xml.append("]]></message>\n");						
			xml.append("</item>\n");			
		}

		xml.append("</list>");


		
		log.info("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + 
				" userid["+listForm.getSearchString1()+"]"+
				" password["+listForm.getSearchString2()+"]"+	
				" message["+message+"]"
				);



		
		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());


	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
