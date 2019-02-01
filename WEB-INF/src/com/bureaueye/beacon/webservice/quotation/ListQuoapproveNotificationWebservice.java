package com.bureaueye.beacon.webservice.quotation;

import java.io.IOException; 

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.quotation.bd.QuoapproveWebserviceBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.beacon.webservice.BaseWebservice;

import javax.servlet.*;
 
/**
 * 
 * Amendments ----------
 * 
 * NT 2014-04-01 BESL-201404-0001 RAVEMAX & WEBSERVICE
 * 
 */
public final class ListQuoapproveNotificationWebservice extends BaseWebservice {
	private static final long serialVersionUID = 1L;

	private static QuoapproveWebserviceBD quoapprovebd;
	private static ListForm listForm; 

	public static String REF = "Quoapprove";
	public static String PROP_APPROVEDATE = "Approvedate";
	public static String PROP_USERID = "Userid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_APPROVETIME = "Approvetime";
	public static String PROP_USERGROUPID = "Usergroupid";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_CREATETIMESTAMP = "Createtimestamp";	
	public static String PROP_CREATEDATE_DDMMMYYYY = "Createdateddmmmyyyy";
	public static String PROP_CREATEDATE_DDMMM = "Createdateddmmm";	
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_REJECTREASON = "Rejectreason";
	public static String PROP_NOTES = "Notes";
	public static String PROP_QUOAPPROVE_ID = "QuoapproveId";
	public static String PROP_APPROVEFLAG = "Approveflag";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_CREATETIME_HHMM = "Createtimehhmm";	
	public static String PROP_APPROVETYPE = "Approvetype";
	public static String PROP_QUOTEDATE = "Quotedate";
	public static String PROP_CUSTOMERNAME= "Customername";
	public static String PROP_QUOTNO= "Quotno";
	public static String PROP_QUOTEBY_USERID= "Quotebyuserid";
	
	@SuppressWarnings("unchecked")
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
		quoapprovebd = new QuoapproveWebserviceBD(this.getSessionFactoryClusterMap());
		UserBD userbd = new UserBD(this.getSessionFactoryClusterMap());

		// get input parameters
		String param1 = "";
		String param2 = "";
		String param3 = "";
		String param4 = "";
		String param5 = "";			
		try {
			param1 = request.getParameter("param1");// userid
			param2 = request.getParameter("param2");// usergroupid
			param3 = request.getParameter("param3");// approveflag
			param4 = request.getParameter("param4");// createtimestamp
			param5 = request.getParameter("param5");// password
		} catch (Exception e) {
		}

		User user = null;
		try {
			user = userbd.read(param1);
			//default user group parameter if not supplied
			if (param2.equals("")) param2=user.getUsergroupid();
		} catch (Exception e) {
		}
		
		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " param1[" + param1 + "]" + " param2[" + param2 + "]"
				+ " param3[" + param3 + "]"
				+ " param4[" + param4 + "]"
				+ " param5[" + param5 + "]"					
				);

		
		// init output
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");

		// check user object exists and password correct
		if (user != null && user.getPassword().equals(param5)) {

			List<com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem> itemList = null;
			listForm = new ListForm();
			try {
				this.setSearchParams(param1,param2,param3,param4);
				this.setLineItems();
				itemList = listForm.getLineItems();
			} catch (ApplicationException ae) {
			}

			try {
				xml.append("<list generated=\"" + System.currentTimeMillis()
						+ "\" total=\"" + itemList.size() + "\">\n");	

			
					for (Iterator<com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem> it = itemList.iterator(); it
							.hasNext();) {

						com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem dao = (com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem) it.next();

						xml.append("<item id=\"" + dao.getQuoapproveId() + "\">\n");
						xml.append("<"+PROP_QUOAPPROVE_ID+"><![CDATA[");
						xml.append(dao.getQuoapproveId());
						xml.append("]]></"+PROP_QUOAPPROVE_ID+">\n");
						xml.append("<"+PROP_QUOHDR_ID+"><![CDATA[");
						xml.append(dao.getQuohdrId());
						xml.append("]]></"+PROP_QUOHDR_ID+">\n");
						xml.append("<"+PROP_USERID+"><![CDATA[");
						xml.append(dao.getUserid());
						xml.append("]]></"+PROP_USERID+">\n");
						xml.append("<"+PROP_USERGROUPID+"><![CDATA[");
						xml.append(dao.getUsergroupid());
						xml.append("]]></"+PROP_USERGROUPID+">\n");
						xml.append("<"+PROP_APPROVETYPE+"><![CDATA[");
						xml.append(dao.getApprovetype());
						xml.append("]]></"+PROP_APPROVETYPE+">\n");
						xml.append("<"+PROP_NOTES+"><![CDATA[");
						xml.append(dao.getNotes());
						xml.append("]]></"+PROP_NOTES+">\n");
						xml.append("<"+PROP_PRIORITY+"><![CDATA[");
						xml.append(dao.getPriority());
						xml.append("]]></"+PROP_PRIORITY+">\n");
						xml.append("<"+PROP_APPROVEFLAG+"><![CDATA[");
						xml.append(dao.getApproveflag());
						xml.append("]]></"+PROP_APPROVEFLAG+">\n");	
						xml.append("<"+PROP_APPROVEDATE+"><![CDATA[");
						xml.append(dao.getApprovedate());
						xml.append("]]></"+PROP_APPROVEDATE+">\n");						
						xml.append("<"+PROP_APPROVETIME+"><![CDATA[");
						xml.append(dao.getApprovetime());
						xml.append("]]></"+PROP_APPROVETIME+">\n");	
						xml.append("<"+PROP_QUOTEDATE+"><![CDATA[");
						xml.append(dao.getQuotedate());
						xml.append("]]></"+PROP_QUOTEDATE+">\n");
						xml.append("<"+PROP_CUSTOMERNAME+"><![CDATA[");
						xml.append(dao.getCustomername());
						xml.append("]]></"+PROP_CUSTOMERNAME+">\n");
						
						xml.append("<"+PROP_CREATEDATE+"><![CDATA[");
						xml.append(dao.getCreatedate());
						xml.append("]]></"+PROP_CREATEDATE+">\n");	
						xml.append("<"+PROP_CREATEDATE_DDMMMYYYY+"><![CDATA[");
						xml.append(Util.dateTextFormat2(dao.getCreatedate()));
						xml.append("]]></"+PROP_CREATEDATE_DDMMMYYYY+">\n");						
						xml.append("<"+PROP_CREATETIME+"><![CDATA[");
						xml.append(dao.getCreatetime());
						xml.append("]]></"+PROP_CREATETIME+">\n");	
						xml.append("<"+PROP_CREATETIME_HHMM+"><![CDATA[");
						xml.append(dao.getCreatetime().substring(0, 5));
						xml.append("]]></"+PROP_CREATETIME_HHMM+">\n");	

						xml.append("<"+PROP_REJECTREASON+"><![CDATA[");
						xml.append(dao.getRejectreason());
						xml.append("]]></"+PROP_REJECTREASON+">\n");	
						
						xml.append("<"+PROP_CREATETIMESTAMP+"><![CDATA[");
						xml.append(dao.getCreatetimestamp());
						xml.append("]]></"+PROP_CREATETIMESTAMP+">\n");	

						xml.append("<"+PROP_QUOTNO+"><![CDATA[");
						xml.append(dao.getQuotno());
						xml.append("]]></"+PROP_QUOTNO+">\n");	

						xml.append("<"+PROP_QUOTEBY_USERID+"><![CDATA[");
						xml.append(dao.getQuotebyuserid());
						xml.append("]]></"+PROP_QUOTEBY_USERID+">\n");	
					
						xml.append("<"+PROP_CREATEDATE_DDMMM+"><![CDATA[");
						xml.append(Util.dateTextFormat4(dao.getCreatedate()));
						xml.append("]]></"+PROP_CREATEDATE_DDMMM+">\n");
						
					xml.append("</item>\n");

				}

				xml.append("</list>");

			} catch (Exception e) {

			}

		}//check user
			

		// clear
		quoapprovebd = null;
		userbd = null;
		listForm = null;

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " xml[" + xml.toString() + "]");

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	public void setSearchParams(
			String param1,//userid 
			String param2,//usergroupid
			String param3,//approveflag
			String param4//createtimestamp
			) throws ApplicationException {
		// Set the default ordering
		listForm.setOrderBy("quoapprove.Createtimestamp");

		// order by
		listForm.setOrderByDesc("asc");

		// set default max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);

		// set default field values
		// userid
		listForm.setSearchString1(param1);
		
		// user groupid
		listForm.setSearchString2(param2);

		// approve flag
		listForm.setSearchString3(param3);

		// create timestamp
		listForm.setSearchString4(param4);

		int total = 0;
		listForm.setTotalResults(total);
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Total number of results = " + total);
	}

	public void setLineItems() throws ApplicationException {
		listForm.setLineItems(
				quoapprovebd.findQuoapproveNotifications(listForm)
				);
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());

	}
	
}
