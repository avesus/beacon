package com.bureaueye.beacon.webservice.quotation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.quotation.ListQuosummaryForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuohdrDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryChargeDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryCostDTO;
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
@SuppressWarnings("serial")
public final class SelectQuosummaryWebservice extends BaseWebservice {

	private static QuohdrBD quohdrbd;

	BigDecimal chgamtbasetotal;
	BigDecimal cstamtbasetotal;
	
	public static String REF = "Quosummary";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_LDGLOCATIONKEY2 = "Ldglocationkey2";
	public static String PROP_LDGLOCATIONKEY1 = "Ldglocationkey1";
	public static String PROP_CONSIGNEEADDRKEY = "Consigneeaddrkey";
	public static String PROP_CONSIGNEEREF = "Consigneeref";
	public static String PROP_MAINCHARGEKEY = "Mainchargekey";
	public static String PROP_MAINCHARGECCYKEY = "Mainchargeccykey";
	public static String PROP_QUOTNO = "Quotno";
	public static String PROP_INCOTERMKEY = "Incotermkey";

	public static String PROP_QUOTEDATE = "Quotedate";
	public static String PROP_QUOTEDATE_DDMMMYYYY = "Quotedateddmmmyyyy";

	public static String PROP_QUOTESTATUS = "Quotestatus";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_EXCHGDATE = "Exchgdate";
	public static String PROP_DCHLOCATIONKEY1 = "Dchlocationkey1";
	public static String PROP_APPROVALDATE = "Approvaldate";
	public static String PROP_DCHLOCATIONKEY2 = "Dchlocationkey2";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_CUSTOMERNAME = "Customername";
	public static String PROP_CUSTOMERREF = "Customerref";
	public static String PROP_EFFECTIVEDATE = "Effectivedate";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_DELTERM = "Delterm";
	public static String PROP_SHIPMETHOD = "Shipmethod";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_BROKERREF = "Brokerref";
	public static String PROP_QUOTEBYUSERID = "Quotebyuserid";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_FWDAGENTADDRKEY = "Fwdagentaddrkey";
	public static String PROP_CUSTOMERADDR2 = "Customeraddr2";
	public static String PROP_CUSTOMERADDR1 = "Customeraddr1";
	public static String PROP_CUSTOMERADDR5 = "Customeraddr5";
	public static String PROP_CUSTOMERADDR4 = "Customeraddr4";
	public static String PROP_CUSTOMERADDR3 = "Customeraddr3";
	public static String PROP_SHIPPERADDRKEY = "Shipperaddrkey";
	public static String PROP_BROKERADDRKEY = "Brokeraddrkey";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_SHIPPERREF = "Shipperref";
	public static String PROP_QUOTYPE = "Quotype";
	public static String PROP_FWDAGENTREF = "Fwdagentref";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_ORDERHDRSFOUND = "Orderhdrsfound";
	public static String PROP_NUMBEROFORDERS = "Numberoforders";
	public static String PROP_COSTTOTAL= "Costtotal";
	public static String PROP_CHARGETOTAL = "Chargetotal";
	public static String PROP_PROFITTOTAL = "Profittotal";

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
		quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		UserBD userbd = new UserBD(this.getSessionFactoryClusterMap());

		// get input parameters
		String param1 = "";
		String param2 = "";
		String param3 = "";
		try {
			param1 = request.getParameter("param1");// quoteno
			param2 = request.getParameter("param2");// userid
			param3 = request.getParameter("param3");// password
		} catch (Exception e) {
		}

		log.info("[" + this.getClass().getName() + "] "
				+ new java.util.Date() 
		+ " param1[" + param1 + "]"
		+ " param2[" + param2 + "]"
		+ " param3[" + param3 + "]"				
				);
		
		User user = null;
		try {
			user = userbd.read(param2);
		} catch (Exception e) {
		}

		// init output
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");

		// check user object exists and password correct
		if (user != null && user.getPassword().equals(param3)) {

			Quohdr dao = null;
			QuohdrDTO dto = null;
			chgamtbasetotal = new BigDecimal(0.0);
			cstamtbasetotal = new BigDecimal(0.0);			
			int numberoforders = 0;
			double profitTotal = 0.0;
			String profitTotalFormat = "0.00";			
			double baseTotal = 0.0;	
			double chargeTotal =  0.0;
			double costTotal =  0.0;				
			try {
				dao = quohdrbd.findQuohdrByQuotno(param1);
				dto = new QuohdrDTO(dao, this.getSessionFactoryClusterMap());
				//get number of orders generated from quote
				if (dto.getOrderhdrsfound().equals("true")) numberoforders=quohdrbd.getOrderhdrsByQuotno(dao.getQuotno()).size();

				// populate charge list items	
				this.setChargeLineItems(dto.getId().toString());	
				// populate cost list items	
				this.setCostLineItems(dto.getId().toString());				
				//calculate profit
				chargeTotal = chgamtbasetotal.doubleValue();
				costTotal = cstamtbasetotal.doubleValue();		
				try{
					baseTotal=chargeTotal-costTotal;
					profitTotal=(baseTotal/chargeTotal)*100;					
				}catch(Exception e){}	
				
				try{profitTotalFormat=new CurrencyFormatter().format(new BigDecimal(profitTotal));}catch(Exception e){}
				
			} catch (Exception e) {
			}



			// check object exists
			if (dto != null) {

				try {
					xml.append("<list generated=\""
							+ System.currentTimeMillis() + "\" total=\"" + "1"
							+ "\">\n");

					xml.append("<item id=\"" + dto.getId() + "\">\n");
					xml.append("<" + PROP_QUOHDR_ID + "><![CDATA[");
					xml.append(dto.getId());
					xml.append("]]></" + PROP_QUOHDR_ID + ">\n");
					xml.append("<" + PROP_CUSTOMERNAME + "><![CDATA[");
					xml.append(dto.getCustomername());
					xml.append("]]></" + PROP_CUSTOMERNAME + ">\n");
					xml.append("<" + PROP_CUSTOMERREF + "><![CDATA[");
					xml.append(dto.getCustomerref());
					xml.append("]]></" + PROP_CUSTOMERREF + ">\n");
					xml.append("<" + PROP_ORDERHDRSFOUND + "><![CDATA[");
					xml.append(dto.getOrderhdrsfound());
					xml.append("]]></" + PROP_ORDERHDRSFOUND + ">\n");
					xml.append("<" + PROP_LDGLOCATIONKEY2 + "><![CDATA[");
					xml.append(dto.getLdglocationkey2().getLocationName());
					xml.append("]]></" + PROP_LDGLOCATIONKEY2 + ">\n");
					xml.append("<" + PROP_DCHLOCATIONKEY2 + "><![CDATA[");
					xml.append(dto.getDchlocationkey2().getLocationName());
					xml.append("]]></" + PROP_DCHLOCATIONKEY2 + ">\n");

					xml.append("<" + PROP_SHIPMETHOD + "><![CDATA[");
					xml.append(dto.getShipmethod());
					xml.append("]]></" + PROP_SHIPMETHOD + ">\n");	
					xml.append("<" + PROP_CCYKEY + "><![CDATA[");
					xml.append(dto.getCcykey());
					xml.append("]]></" + PROP_CCYKEY + ">\n");	
					xml.append("<" + PROP_QUOTEBYUSERID + "><![CDATA[");
					xml.append(dto.getQuotebyuserid());
					xml.append("]]></" + PROP_QUOTEBYUSERID + ">\n");	
					xml.append("<" + PROP_QUOTEDATE + "><![CDATA[");
					xml.append(dto.getQuotedate());
					xml.append("]]></" + PROP_QUOTEDATE + ">\n");	
					xml.append("<" + PROP_QUOTEDATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getQuotedate()));
					xml.append("]]></" + PROP_QUOTEDATE_DDMMMYYYY + ">\n");						
					xml.append("<" + PROP_NUMBEROFORDERS+ "><![CDATA[");
					xml.append(numberoforders);
					xml.append("]]></" + PROP_NUMBEROFORDERS + ">\n");	
					
					xml.append("<" + PROP_COSTTOTAL+ "><![CDATA[");
					xml.append(new CurrencyFormatter().format(cstamtbasetotal));
					xml.append("]]></" + PROP_COSTTOTAL + ">\n");	
					xml.append("<" + PROP_CHARGETOTAL+ "><![CDATA[");
					xml.append(new CurrencyFormatter().format(chgamtbasetotal));
					xml.append("]]></" + PROP_CHARGETOTAL + ">\n");	
					xml.append("<" + PROP_PROFITTOTAL+ "><![CDATA[");
					xml.append(profitTotalFormat);
					xml.append("]]></" + PROP_PROFITTOTAL + ">\n");	
					
					xml.append("<" + PROP_QUOTNO+ "><![CDATA[");
					xml.append(dto.getQuotno());
					xml.append("]]></" + PROP_QUOTNO + ">\n");	

					xml.append("</item>\n");

					xml.append("</list>");

				} catch (Exception e) {

				}

			}// check object exists

		}// check valid user

		// clear
		quohdrbd = null;
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


	@SuppressWarnings("rawtypes")
	public void setChargeLineItems(String id) throws ApplicationException {

		ListQuosummaryForm listForm = new ListQuosummaryForm();
		listForm.setId(id);
		listForm.setGotoPage(0);
		listForm.setMaxResults(99);
		listForm.setOrderBy("Chargekey");
		listForm.setOrderByDesc("");		

		QuochargeBD quochargebd=new QuochargeBD(this.getSessionFactoryClusterMap());
		
		// set line items
		List list=quochargebd.findQuochargesForSummary(listForm);

		//calculate total
		for (Iterator it = list.iterator(); it.hasNext();) {
			QuosummaryChargeDTO dto = (QuosummaryChargeDTO)it.next();
			chgamtbasetotal=chgamtbasetotal.add(dto.getChgamt());
		}

		quochargebd=null;
	}


	@SuppressWarnings("rawtypes")
	public void setCostLineItems(String id) throws ApplicationException {

		ListQuosummaryForm listForm = new ListQuosummaryForm();
		listForm.setId(id);
		listForm.setGotoPage(0);
		listForm.setMaxResults(99);

		QuocostBD quocostbd=new QuocostBD(this.getSessionFactoryClusterMap());
		
		// quohdr costs
		listForm.setOrderBy("quocost.Costkey");
		// set line items
		List list=quocostbd.findQuohdrcostsForSummary(listForm);

		//calculate total
		for (Iterator it = list.iterator(); it.hasNext();) {
			QuosummaryCostDTO dto = (QuosummaryCostDTO)it.next();
			cstamtbasetotal=cstamtbasetotal.add(dto.getCstamtbase());
		}

		// quomov costs
		listForm.setOrderBy("quomov.Seqno, quocost.Costkey");
		// set line items
		List list2=quocostbd.findQuomovcostsForSummary(listForm);

		//calculate total
		for (Iterator it = list2.iterator(); it.hasNext();) {
			QuosummaryCostDTO dto = (QuosummaryCostDTO)it.next();
			cstamtbasetotal=cstamtbasetotal.add(dto.getCstamtbase());
		}

		quocostbd = null;		
	}


}
