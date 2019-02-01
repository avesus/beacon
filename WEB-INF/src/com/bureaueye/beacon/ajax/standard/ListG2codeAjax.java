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
import com.bureaueye.beacon.model.standard.G2code;
import com.bureaueye.beacon.model.standard.bd.G2codeBD;





public final class ListG2codeAjax extends BaseAJAX {
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
		G2codeBD bd = new G2codeBD(this.getSessionFactoryClusterMap());


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

			List<G2code> itemList = null;		
			try {
				ListForm listForm = new ListForm();
				listForm.setSearchString1(key1);
				listForm.setSearchString2(null);
				listForm.setOrderBy("G2codekey");
				listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);
				itemList = bd.findG2codesBySearch(listForm);
			} catch (ApplicationException ae) {}	


			try {
				xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+itemList.size()+"\">\n");

				for (Iterator<G2code> it = itemList.iterator(); it.hasNext();) {

					G2code dao = (G2code)it.next();

					xml.append("<item id=\""+dao.getG2codeId()+"\">\n");				
					xml.append("<g1codekey><![CDATA[");
					xml.append(dao.getG1codekey());
					xml.append("]]></g1codekey>\n");
					xml.append("<g2codekey><![CDATA[");
					xml.append(dao.getG2codekey());
					xml.append("]]></g2codekey>\n");
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
