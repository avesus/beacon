package com.bureaueye.beacondms.ajax.dms;

import java.io.IOException;


import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.*;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;







public final class FindDocumenttypeAjax extends BaseAJAX {
	private static final long serialVersionUID = 1L;



	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header  =(String) headers.nextElement();
			log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+	      
					header+": "+request.getHeader(header));
		}


		//init
		DocumenttypeBD bd = new DocumenttypeBD(this.getSessionFactoryClusterMap());


		// get input parameters
		String key1="";
		try {
			key1=request.getParameter("key1");//
		} catch (Exception e) {}


		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " key1[" + key1+"]"
		);


		// init output 
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");


		if (!key1.equals("")) {

			Documenttype dao = null;		
			try {
				dao = bd.findDocumenttypeByDoctype(key1);
			} catch (ApplicationException ae) {}	



			try {			

				if (dao != null) {

					xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\"1\">\n");


					xml.append("<item id=\""+dao.getDocumenttypeId()+"\">\n");	
					xml.append("<doctype><![CDATA[");
					xml.append(dao.getDoctype());
					xml.append("]]></doctype>\n");					
					xml.append("<categorycode><![CDATA[");
					xml.append(dao.getCategorycode());
					xml.append("]]></categorycode>\n");
					xml.append("<subcategorycode><![CDATA[");
					xml.append(dao.getSubcategorycode());
					xml.append("]]></subcategorycode>\n");					
					xml.append("<description><![CDATA[");
					xml.append(dao.getDescription());
					xml.append("]]></description>\n");
					xml.append("<companykey><![CDATA[");
					xml.append(dao.getCompanykey());
					xml.append("]]></companykey>\n");	
					xml.append("<departmentkey><![CDATA[");
					xml.append(dao.getDepartmentkey());
					xml.append("]]></departmentkey>\n");	
					xml.append("<activitykey><![CDATA[");
					xml.append(dao.getActivitykey());
					xml.append("]]></activitykey>\n");	
					xml.append("<languageid><![CDATA[");
					xml.append(dao.getLanguageid());
					xml.append("]]></languageid>\n");						
					xml.append("</item>\n");	

				}				


				xml.append("</list>");


			} catch (Exception e) {
			}

		}

		//clear
		bd=null;



		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml[" + xml.toString()+"]");

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());


	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
