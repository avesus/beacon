package com.bureaueye.beacon.ajax.report;

import java.io.IOException;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.report.bd.ReportBD;
import com.bureaueye.beacon.model.report.dto.UnitMoveDTO;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.genesys.model.contract.dto.ContractDTO;

import javax.servlet.*;




public final class ListMovrefAjax extends BaseAJAX {
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
			listForm.setSearchString1(request.getParameter("searchString1"));//unitkey;
			//listForm.setSearchString2(request.getParameter("searchString2"));//movref;
			listForm.setSearchString3(request.getParameter("searchString3"));//customeraddrkey
			listForm.setSearchString4(request.getParameter("searchString4"));//sectionkey
			listForm.setSearchDate1dd(request.getParameter("searchDate1dd"));
			listForm.setSearchDate1mm(request.getParameter("searchDate1mm"));
			listForm.setSearchDate1yyyy(request.getParameter("searchDate1yyyy"));
			listForm.setSearchDate2dd(request.getParameter("searchDate2dd"));
			listForm.setSearchDate2mm(request.getParameter("searchDate2mm"));
			listForm.setSearchDate2yyyy(request.getParameter("searchDate2yyyy"));
			listForm.setOrderBy(request.getParameter("orderBy"));
		} catch (Exception e) {}


		// init output 
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");


		try {
			listForm.setLineItems(new ReportBD(this.getSessionFactoryClusterMap()).groupUnitMoves(listForm));
		} catch (Exception ae) {				
		}

		if (listForm.getLineItems() != null) {

			xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+listForm.getLineItems().size()+"\">\n");

			for (Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
				UnitMoveDTO dto=(UnitMoveDTO)it.next();
				if (!dto.getMovref().equals("")) {
					xml.append("<item id=\""+dto.getMovref()+"\">\n");				
					xml.append("<movref><![CDATA[");
					xml.append(dto.getMovref());
					xml.append("]]></movref>\n");				
					xml.append("</item>\n");				
				}
			}				


			xml.append("</list>");
		}





		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml=" + xml.toString());

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());


	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
