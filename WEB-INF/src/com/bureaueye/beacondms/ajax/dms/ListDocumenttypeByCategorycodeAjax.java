package com.bureaueye.beacondms.ajax.dms;

import java.io.IOException;


import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.*;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;






public final class ListDocumenttypeByCategorycodeAjax extends BaseAJAX {
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

			List<Documenttype> itemList = null;		
			try {
				ListForm listForm = new ListForm();
				listForm.setSearchString1(key1);
				listForm.setSearchString2(null);
				listForm.setOrderBy("Doctype");
				listForm.setOrderByDesc("");
				listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
				itemList = bd.findDocumenttypesByCategorycode(listForm);
			} catch (ApplicationException ae) {}	


			try {
				xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+itemList.size()+"\">\n");

				for (Iterator<Documenttype> it = itemList.iterator(); it.hasNext();) {

					Documenttype dao = (Documenttype)it.next();

					xml.append("<item id=\""+dao.getDocumenttypeId()+"\">\n");				
					xml.append("<categorycode><![CDATA[");
					xml.append(dao.getCategorycode());
					xml.append("]]></categorycode>\n");
					xml.append("<doctype><![CDATA[");
					xml.append(dao.getDoctype());
					xml.append("]]></doctype>\n");
					xml.append("<description><![CDATA[");
					xml.append(dao.getDescription());
					xml.append("]]></description>\n");				
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
