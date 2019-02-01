package com.bureaueye.beacon.ajax.standard;

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
import com.bureaueye.beacon.model.standard.G3code;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;





public final class ListG3codeAjax extends BaseAJAX {
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
		G3codeBD bd = new G3codeBD(this.getSessionFactoryClusterMap());


		// get input parameters
		String key1="";
		String key2="";
		try {
			key1=request.getParameter("key1");//
			key2=request.getParameter("key2");//
		} catch (Exception e) {}


		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() 
				+ " key1[" + key1+"]"
				+ " key2[" + key2+"]"
		);


		// init output 
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");


		if (!key1.equals("") && !key2.equals("")) {

			List<G3code> itemList = null;		
			try {
				ListForm listForm = new ListForm();
				listForm.setSearchString1(key1);
				listForm.setSearchString2(key2);
				listForm.setSearchString3(null);
				listForm.setOrderBy("G3codekey");
				listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
				itemList = bd.findG3codesBySearch(listForm);
			} catch (ApplicationException ae) {}	


			try {
				xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+itemList.size()+"\">\n");

				for (Iterator<G3code> it = itemList.iterator(); it.hasNext();) {

					G3code dao = (G3code)it.next();

					xml.append("<item id=\""+dao.getG3codeId()+"\">\n");				
					xml.append("<g1codekey><![CDATA[");
					xml.append(dao.getG1codekey());
					xml.append("]]></g1codekey>\n");
					xml.append("<g2codekey><![CDATA[");
					xml.append(dao.getG2codekey());
					xml.append("]]></g2codekey>\n");
					xml.append("<g3codekey><![CDATA[");
					xml.append(dao.getG3codekey());
					xml.append("]]></g3codekey>\n");					
					xml.append("<ldesc><![CDATA[");
					xml.append(dao.getLdesc());
					xml.append("]]></ldesc>\n");
					xml.append("<sdesc><![CDATA[");
					xml.append(dao.getSdesc());
					xml.append("]]></sdesc>\n");
					xml.append("<locationcode><![CDATA[");
					xml.append(dao.getLocationcode());
					xml.append("]]></locationcode>\n");						
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
