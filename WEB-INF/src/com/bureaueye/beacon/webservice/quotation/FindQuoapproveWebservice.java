package com.bureaueye.beacon.webservice.quotation;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.webservice.BaseWebservice;

import javax.servlet.*;
 
/**
 * 
 * Amendments ----------
 * 
 * NT 2014-04-01 BESL-201404-0001 RAVEMAX & WEBSERVICE
 * 
 */
@SuppressWarnings("serial")
public final class FindQuoapproveWebservice extends BaseWebservice {

	private static QuoapproveBD quoapprovebd;

	public static String REF = "Quoapprove";
	public static String PROP_APPROVEDATE = "Approvedate";
	public static String PROP_USERID = "Userid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_APPROVETIME = "Approvetime";
	public static String PROP_USERGROUPID = "Usergroupid";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_REJECTREASON = "Rejectreason";
	public static String PROP_NOTES = "Notes";
	public static String PROP_QUOAPPROVE_ID = "QuoapproveId";
	public static String PROP_APPROVEFLAG = "Approveflag";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_APPROVETYPE = "Approvetype";
	public static String PROP_QUOTEDATE = "Quotedate";
	public static String PROP_CUSTOMERNAME = "Customername";

	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("rawtypes")
		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = (String) headers.nextElement();
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + header + ": "
					+ request.getHeader(header));
		}

		// init
		quoapprovebd = new QuoapproveBD(this.getSessionFactoryClusterMap());

		// get input parameters
		String id = "";
		try {
			id = request.getParameter("id");
		} catch (Exception e) {
		}

		Quoapprove dao = null;
		try {
			dao = quoapprovebd.read(new Integer(id));
		} catch (Exception e) {
		}

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " id[" + id + "]");

		// init output
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");

		// check object exists
		if (dao != null) {

			try {
				xml.append("<list generated=\"" + System.currentTimeMillis()
						+ "\" total=\"" + "1" + "\">\n");

				xml.append("<item id=\"" + dao.getQuoapproveId() + "\">\n");
				xml.append("<" + PROP_QUOAPPROVE_ID + "><![CDATA[");
				xml.append(dao.getQuoapproveId());
				xml.append("]]></" + PROP_QUOAPPROVE_ID + ">\n");
				xml.append("<" + PROP_QUOHDR_ID + "><![CDATA[");
				xml.append(dao.getQuohdrId());
				xml.append("]]></" + PROP_QUOHDR_ID + ">\n");
				xml.append("<" + PROP_USERID + "><![CDATA[");
				xml.append(dao.getUserid());
				xml.append("]]></" + PROP_USERID + ">\n");
				xml.append("<" + PROP_USERGROUPID + "><![CDATA[");
				xml.append(dao.getUsergroupid());
				xml.append("]]></" + PROP_USERGROUPID + ">\n");
				xml.append("<" + PROP_APPROVETYPE + "><![CDATA[");
				xml.append(dao.getApprovetype());
				xml.append("]]></" + PROP_APPROVETYPE + ">\n");
				xml.append("<" + PROP_NOTES + "><![CDATA[");
				xml.append(dao.getNotes());
				xml.append("]]></" + PROP_NOTES + ">\n");
				xml.append("<" + PROP_PRIORITY + "><![CDATA[");
				xml.append(dao.getPriority());
				xml.append("]]></" + PROP_PRIORITY + ">\n");
				xml.append("<" + PROP_APPROVEFLAG + "><![CDATA[");
				xml.append(dao.getApproveflag());
				xml.append("]]></" + PROP_APPROVEFLAG + ">\n");
				xml.append("<" + PROP_APPROVEDATE + "><![CDATA[");
				xml.append(dao.getApprovedate());
				xml.append("]]></" + PROP_APPROVEDATE + ">\n");
				xml.append("<" + PROP_APPROVETIME + "><![CDATA[");
				xml.append(dao.getApprovetime());
				xml.append("]]></" + PROP_APPROVETIME + ">\n");
				xml.append("</item>\n");

				xml.append("</list>");

			} catch (Exception e) {

			}

		}

		// clear
		quoapprovebd = null;

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " xml[" + xml.toString() + "]");

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
