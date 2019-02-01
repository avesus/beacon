package com.bureaueye.beacon.webservice.quotation;

import java.io.IOException;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.webservice.BaseWebservice;

import javax.servlet.*;
 
/**
 * 
 * Amendments ----------
 * 
 * NT 2014-04-01 BESL-201404-0001 RAVEMAX & WEBSERVICE
 * 
 */
public final class UpdateQuoapproveWebservice extends BaseWebservice {
	private static final long serialVersionUID = 1L;

	public static String PROP_ID = "Id";
	public static String PROP_ACTION_TYPE = "Actiontype";
	public static String PROP_RESPONSE_TYPE = "Responsetype";
	
	public static String PROP_UPDATE = "Update";
	public static String PROP_SUCCESS = "Success";
	
	
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
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuoapproveBD quoapprovebd = new QuoapproveBD(
				this.getSessionFactoryClusterMap());
		UserBD userbd = new UserBD(this.getSessionFactoryClusterMap());

		// get input parameters
		String param1 = "";
		String param2 = "";
		String param3 = "";
		String param4 = "";
		String param5 = "";
		String param6 = "";
		try {
			param1 = request.getParameter("param1");// quoapprove id
			param2 = request.getParameter("param2");// user id
			param3 = request.getParameter("param3");// approveflag
			param4 = request.getParameter("param4");// rejectreason
			param5 = request.getParameter("param5");// notes
			param6 = request.getParameter("param6");// password
		} catch (Exception e) {
		}

		User user = null;
		try {
			user = userbd.read(param2);
		} catch (Exception e) {
		}

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " param1[" + param1 + "]" + " param2[" + param2 + "]"
				+ " param3[" + param3 + "]" + " param4[" + param4 + "]"
				+ " param5[" + param5 + "]" + " param6[" + param6 + "]");

		// init output
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");

		// check id exists
		if (param1 != null && !param1.equals("")) {

			// check user object exists and password correct
			if (user != null && user.getPassword().equals(param6)) {

				Quoapprove dao = null;
				try {
					// find record
					dao = quoapprovebd.read(new Integer(param1));

					// assign updated fields
					// process if change
					if (!dao.getApproveflag().equals(param3)) {
						// update transaction
						try {
							dao.setRejectreason(param4);
							dao.setNotes(param5);
						} catch (NullPointerException npe) {
						}
						dao.setApproveflag(param3);
						if (param3.equals("")) {
							dao.setApprovedate(null);
							dao.setApprovetime("");
						} else {
							Calendar c = Calendar.getInstance();
							dao.setApprovedate(c.getTime());
							dao.setApprovetime(com.bureaueye.beacon.util.Util
									.toTime(c));
						}

						// update record
						quoapprovebd.createOrUpdate(dao, user);

						// update quohdr
						// status=================================>
						// init approval header fields
						String quohdrQuotestatus = "";
						String quohdrRejectreason = "";
						String quohdrNotes = "";
						int actionCount = 0;
						int approvedCount = 0;
						int rejectedCount = 0;
						for (Iterator<Quoapprove> it = quohdrbd.getQuoapproves(
								dao.getQuohdrId()).iterator(); it.hasNext();) {
							actionCount++;
							Quoapprove dao2 = it.next();

							// increment APPROVED count
							if (dao2.getApproveflag().equals(
									Constants.APPROVED_STATUS))
								approvedCount++;
							// increment REJECTED count
							if (dao2.getApproveflag().equals(
									Constants.REJECTED_STATUS))
								rejectedCount++;

							// store approve status on header
							// - REJECTED STATUS always overrides others
							if (quohdrQuotestatus.equals("")
									|| dao2.getApproveflag().equals(
											Constants.REJECTED_STATUS)) {
								quohdrRejectreason = dao2.getRejectreason();
								quohdrNotes = dao.getNotes();
								quohdrQuotestatus = dao.getApproveflag();
							}
						}

						log.info("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + " " + "quohdrId["
								+ dao.getQuohdrId() + "]: " + "actionCount["
								+ actionCount + "]: " + "approvedCount["
								+ approvedCount + "]: " + "rejectedCount["
								+ rejectedCount + "]: " + "quohdrRejectreason["
								+ quohdrRejectreason + "]: " + "quohdrNotes["
								+ quohdrNotes + "]: " + "quohdrQuotestatus["
								+ quohdrQuotestatus + "]");

						// if not all actioned set to PENDING STATUS
						// OR
						// header status is blank set to PENDING STATUS
						if (actionCount != (approvedCount + rejectedCount)
								|| quohdrQuotestatus.equals("")) {
							quohdrQuotestatus = Constants.PENDING_STATUS;
							quohdrNotes = "";
							quohdrRejectreason = "";
						}

						// update header if all records actioned
						// retreive object
						Quohdr quohdrdao = null;
						quohdrdao = quohdrbd.read(dao.getQuohdrId());
						// set approval fields
						quohdrdao.setRejectreason(quohdrRejectreason);
						quohdrdao.setNotes(quohdrNotes);
						quohdrdao.setQuotestatus(quohdrQuotestatus);
						Calendar c = Calendar.getInstance();
						quohdrdao.setApprovaldate(c.getTime());
						quohdrbd.createOrUpdate(quohdrdao, user);

					}

					// acknowledgement message
					xml.append("<list generated=\""
							+ System.currentTimeMillis() + "\" total=\"" + "1"
							+ "\">\n");

					xml.append("<item id=\"" + dao.getQuoapproveId() + "\">\n");
					xml.append("<" + PROP_ID + "><![CDATA[");
					xml.append(dao.getQuoapproveId());
					xml.append("]]></" + PROP_ID + ">\n");
					xml.append("<" + PROP_ACTION_TYPE + "><![CDATA[");
					xml.append(PROP_UPDATE);
					xml.append("]]></" + PROP_ACTION_TYPE + ">\n");
					xml.append("<" + PROP_RESPONSE_TYPE + "><![CDATA[");
					xml.append(PROP_SUCCESS);
					xml.append("]]></" + PROP_RESPONSE_TYPE + ">\n");

					xml.append("</item>\n");

					xml.append("</list>");

				} catch (Exception e) {
					log.error("[" + this.getClass().getName() + "] " + new java.util.Date()
					+ " Exception: " + e.getMessage() );
				}

			}// check user

		}// check id

		// clear
		quoapprovebd = null;
		userbd = null;

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
