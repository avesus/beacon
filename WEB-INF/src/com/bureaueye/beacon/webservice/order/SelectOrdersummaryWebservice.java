package com.bureaueye.beacon.webservice.order;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrdercostBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrderhdrDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryChargeDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryCostDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
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
public final class SelectOrdersummaryWebservice extends BaseWebservice {

	private static OrderhdrBD orderhdrbd;
	private static JobhdrBD jobhdrbd;

	BigDecimal chgamtbasetotal;
	BigDecimal ordercstamtbasetotal;
	BigDecimal jobcstamtbasetotal;
	BigDecimal cstamtalloctotal;	
	BigDecimal invoiceamttotal;
	
	public static String REF = "Ordersummary";
	public static String PROP_ORDERHDR_ID = "OrderhdrId";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_LDGLOCATIONKEY2 = "Ldglocationkey2";
	public static String PROP_LDGLOCATIONKEY1 = "Ldglocationkey1";
	public static String PROP_CONSIGNEEADDRKEY = "Consigneeaddrkey";
	public static String PROP_CONSIGNEEREF = "Consigneeref";
	public static String PROP_MAINCHARGEKEY = "Mainchargekey";
	public static String PROP_MAINCHARGECCYKEY = "Mainchargeccykey";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_INCOTERMKEY = "Incotermkey";

	public static String PROP_ORDERDATE = "Orderdate";
	public static String PROP_ORDERDATE_DDMMMYYYY = "Orderdateddmmmyyyy";

	public static String PROP_ORDERSTATUS = "Orderstatus";
	public static String PROP_INVOICESTATUS = "Invoicestatus";

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
	public static String PROP_ORDERBYUSERID = "Orderbyuserid";
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
	public static String PROP_ORDERTYPE = "Ordertype";
	public static String PROP_FWDAGENTREF = "Fwdagentref";
	public static String PROP_CREATETIME = "Createtime";
	
	public static String PROP_NUMBEROFUNITS = "Numberofunits";
	
	public static String PROP_JOBCOSTTOTAL = "Jobcosttotal";
	public static String PROP_ORDERCOSTTOTAL = "Ordercosttotal";
	public static String PROP_CHARGETOTAL = "Chargetotal";
	public static String PROP_PROFITTOTAL = "Profittotal";
	public static String PROP_COSTAMTALLOCTOTAL = "Costamtalloctotal";
	public static String PROP_INVOICEAMTTOTAL = "Invoiceamttotal";
	public static String PROP_BALANCETOTAL = "Balancetotal";

	public static String PROP_LDGFROMDATE = "Ldgfromdate";
	public static String PROP_LDGFROMDATE_DDMMMYYYY = "Ldgfromdateddmmmyyyy";	
	public static String PROP_LDGTODATE = "Ldgtodate";
	public static String PROP_LDGTODATE_DDMMMYYYY = "Ldgtodateddmmmyyyy";	
	public static String PROP_DCHFROMDATE = "Dchfromdate";
	public static String PROP_DCHFROMDATE_DDMMMYYYY = "Dchfromdateddmmmyyyy";	
	public static String PROP_DCHTODATE = "Dchtodate";
	public static String PROP_DCHTODATE_DDMMMYYYY = "Dchtodateddmmmyyyy";	
		
	public static String PROP_PRODUCTNAME		 = "Productname";	
	public static String PROP_SHIPVENDORNAME			 = "Shipvendorname";	
	public static String PROP_SHIPVESSEL = "Shipvessel";	
	public static String PROP_SHIPVOYAGE = "Shipvoyage";	
	public static String PROP_COMPLETEFLAG = "Completeflag";	
	
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
		orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
		UserBD userbd = new UserBD(this.getSessionFactoryClusterMap());

		// get input parameters
		String param1 = "";
		String param2 = "";
		String param3 = "";
		try {
			param1 = request.getParameter("param1");// order no
			param2 = request.getParameter("param2");// userid
			param3 = request.getParameter("param3");// password
		} catch (Exception e) {
		}

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " param1[" + param1 + "]" + " param2[" + param2 + "]"
				+ " param3[" + param3 + "]");

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

			Orderhdr dao = null;
			OrderhdrDTO dto = null;
			chgamtbasetotal = new BigDecimal(0.0);
			ordercstamtbasetotal = new BigDecimal(0.0);
			jobcstamtbasetotal = new BigDecimal(0.0);
			invoiceamttotal = new BigDecimal(0.0);
			cstamtalloctotal = new BigDecimal(0.0);
			double balancetotal = 0.0;
			int numberofunits = 0;
			double profitTotal = 0.0;
			String profitTotalFormat = "0.00";			
			double baseTotal = 0.0;
			double chargeTotal = 0.0;
			double jobcstTotal = 0.0;
			try {
				dao = orderhdrbd.findOrderhdrByOrderno(param1);
				dto = new OrderhdrDTO(dao, this.getSessionFactoryClusterMap());
				// get number of units allocated to order
				if (dto.getJobhdrsfound().equals("true"))	numberofunits = orderhdrbd.getOrderjobscount(dao.getId().toString());

				// populate charge list items
				this.setOrderchargeLineItems(dto.getId().toString());
				// populate order cost list items
				this.setOrdercostLineItems(dto.getId().toString());
				// populate job cost list items
				this.setJobcostLineItems(dto.getId().toString());				
				// calculate profit
				chargeTotal = chgamtbasetotal.doubleValue();
				jobcstTotal = jobcstamtbasetotal.doubleValue();
				try {
					baseTotal = chargeTotal - jobcstTotal;
					profitTotal = (baseTotal / chargeTotal) * 100;
				} catch (Exception e) {
				}
				
				// init balance total
				try {
					balancetotal = invoiceamttotal.doubleValue()
							- cstamtalloctotal.doubleValue();
				} catch (Exception e) {
				}				
				
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
					xml.append("<" + PROP_ORDERHDR_ID + "><![CDATA[");
					xml.append(dto.getId());
					xml.append("]]></" + PROP_ORDERHDR_ID + ">\n");

					xml.append("<" + PROP_CUSTOMERNAME + "><![CDATA[");
					xml.append(dto.getCustomeraddrkey().getName());
					xml.append("]]></" + PROP_CUSTOMERNAME + ">\n");
					xml.append("<" + PROP_CUSTOMERREF + "><![CDATA[");
					xml.append(dto.getCustomerref());
					xml.append("]]></" + PROP_CUSTOMERREF + ">\n");

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
					xml.append("<" + PROP_ORDERBYUSERID + "><![CDATA[");
					xml.append(dto.getCreateuserid());
					xml.append("]]></" + PROP_ORDERBYUSERID + ">\n");
					xml.append("<" + PROP_ORDERDATE + "><![CDATA[");
					xml.append(dto.getOrderdate());
					xml.append("]]></" + PROP_ORDERDATE + ">\n");
					xml.append("<" + PROP_ORDERDATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getOrderdate()));
					xml.append("]]></" + PROP_ORDERDATE_DDMMMYYYY + ">\n");

					xml.append("<" + PROP_NUMBEROFUNITS + "><![CDATA[");
					xml.append(numberofunits);
					xml.append("]]></" + PROP_NUMBEROFUNITS + ">\n");

					xml.append("<" + PROP_ORDERCOSTTOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter()
							.format(ordercstamtbasetotal));
					xml.append("]]></" + PROP_ORDERCOSTTOTAL + ">\n");
					xml.append("<" + PROP_JOBCOSTTOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter()
							.format(jobcstamtbasetotal));
					xml.append("]]></" + PROP_JOBCOSTTOTAL + ">\n");
					xml.append("<" + PROP_CHARGETOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter().format(chgamtbasetotal));
					xml.append("]]></" + PROP_CHARGETOTAL + ">\n");
				
					xml.append("<" + PROP_COSTAMTALLOCTOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter().format(cstamtalloctotal));
					xml.append("]]></" + PROP_COSTAMTALLOCTOTAL + ">\n");
					xml.append("<" + PROP_INVOICEAMTTOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter().format(invoiceamttotal));
					xml.append("]]></" + PROP_INVOICEAMTTOTAL + ">\n");
					xml.append("<" + PROP_BALANCETOTAL + "><![CDATA[");
					xml.append(new CurrencyFormatter().format(new BigDecimal(balancetotal)));
					xml.append("]]></" + PROP_BALANCETOTAL + ">\n");
					
					xml.append("<" + PROP_PROFITTOTAL + "><![CDATA[");
					xml.append(profitTotalFormat);
					xml.append("]]></" + PROP_PROFITTOTAL + ">\n");

					xml.append("<" + PROP_ORDERNO + "><![CDATA[");
					xml.append(dto.getOrderno());
					xml.append("]]></" + PROP_ORDERNO + ">\n");
					
					xml.append("<" + PROP_ORDERSTATUS + "><![CDATA[");
					xml.append(dto.getOrderstatus());
					xml.append("]]></" + PROP_ORDERSTATUS + ">\n");
					xml.append("<" + PROP_INVOICESTATUS + "><![CDATA[");
					xml.append(dto.getInvoicestatus());
					xml.append("]]></" + PROP_INVOICESTATUS + ">\n");

					xml.append("<" + PROP_COMPANYKEY + "><![CDATA[");
					xml.append(dto.getCompanykey());
					xml.append("]]></" + PROP_COMPANYKEY + ">\n");
					xml.append("<" + PROP_DEPARTMENTKEY + "><![CDATA[");
					xml.append(dto.getDepartmentkey());
					xml.append("]]></" + PROP_DEPARTMENTKEY + ">\n");
					xml.append("<" + PROP_ACTIVITYKEY + "><![CDATA[");
					xml.append(dto.getActivitykey());
					xml.append("]]></" + PROP_ACTIVITYKEY + ">\n");					
									
					xml.append("<" + PROP_LDGFROMDATE + "><![CDATA[");
					xml.append(dto.getLdgfromdate());
					xml.append("]]></" + PROP_LDGFROMDATE + ">\n");
					xml.append("<" + PROP_LDGFROMDATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getLdgfromdate()));
					xml.append("]]></" + PROP_LDGFROMDATE_DDMMMYYYY + ">\n");
					xml.append("<" + PROP_LDGTODATE + "><![CDATA[");
					xml.append(dto.getLdgtodate());
					xml.append("]]></" + PROP_LDGTODATE + ">\n");
					xml.append("<" + PROP_LDGTODATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getLdgtodate()));
					xml.append("]]></" +PROP_LDGTODATE_DDMMMYYYY + ">\n");
					
					xml.append("<" + PROP_DCHFROMDATE + "><![CDATA[");
					xml.append(dto.getDchfromdate());
					xml.append("]]></" + PROP_DCHFROMDATE + ">\n");
					xml.append("<" + PROP_DCHFROMDATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getDchfromdate()));
					xml.append("]]></" + PROP_DCHFROMDATE_DDMMMYYYY + ">\n");
					xml.append("<" + PROP_DCHTODATE + "><![CDATA[");
					xml.append(dto.getDchtodate());
					xml.append("]]></" + PROP_DCHTODATE + ">\n");
					xml.append("<" + PROP_DCHTODATE_DDMMMYYYY + "><![CDATA[");
					xml.append(Util.dateTextFormat2(dto.getDchtodate()));
					xml.append("]]></" +PROP_DCHTODATE_DDMMMYYYY + ">\n");	

					xml.append("<" + PROP_PRODUCTNAME+ "><![CDATA[");
					xml.append(dto.getProductkey().getTradname());
					xml.append("]]></" +PROP_PRODUCTNAME + ">\n");				

					xml.append("<" + PROP_SHIPVENDORNAME+ "><![CDATA[");
					xml.append(dto.getShipvendoraddrkey().getName());
					xml.append("]]></" +PROP_SHIPVENDORNAME + ">\n");					
					xml.append("<" + PROP_SHIPVESSEL+ "><![CDATA[");
					xml.append(dto.getShipvessel());
					xml.append("]]></" +PROP_SHIPVESSEL+ ">\n");		
					xml.append("<" + PROP_SHIPVOYAGE+ "><![CDATA[");
					xml.append(dto.getShipvoyage());
					xml.append("]]></" +PROP_SHIPVOYAGE+ ">\n");

					xml.append("<" + PROP_COMPLETEFLAG+ "><![CDATA[");
					xml.append(dto.isCompleteflag());
					xml.append("]]></" +PROP_COMPLETEFLAG+ ">\n");		
					
					xml.append("</item>\n");

					xml.append("</list>");

				} catch (Exception e) {

				}

			}// check object exists

		}// check valid user

		// clear
		orderhdrbd = null;
		jobhdrbd = null;
		userbd = null;

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " xml[" + xml.toString() + "]");

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setOrderchargeLineItems(String id) throws ApplicationException {

		OrderchargeBD orderchargebd = new OrderchargeBD(
				this.getSessionFactoryClusterMap());

		// populate list items
		// setChargeLineItems(listForm);
		List ordercharges = orderchargebd
				.findOrderchargesByOrderhdrIdForSummary(id, 0, 999, "Chargekey");
		List ordersummaryOrderchargeDTOs = new ArrayList();
		for (Iterator it = ordercharges.iterator(); it.hasNext();) {
			OrdersummaryChargeDTO dto = (OrdersummaryChargeDTO) it.next();
			ordersummaryOrderchargeDTOs.add(dto);
			chgamtbasetotal = chgamtbasetotal.add(dto.getChgamt());
		}

		// populate accounts receivable list items
		SidtlBD sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
		
		List accountsreceivableDTOs = new ArrayList();
		// get sales invoice for order number
		List sidtldtos = null;
		sidtldtos = sidtlbd.findSidtlsByOrdhdrIdForAccountsreceivable(
				id,// orderhdrid
				0, Constants.MAX_RESULTS_NOLIMIT, "address.Name,sidtl.Txt1");

		Iterator it = sidtldtos.iterator();
		while (it.hasNext()) {
			SidtlDTO dto = (SidtlDTO) it.next();
			accountsreceivableDTOs.add(dto);
			invoiceamttotal = invoiceamttotal.add(dto.getInvoiceamtbase());
		}
		
		orderchargebd = null;
		sidtlbd = null;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setOrdercostLineItems(String id) throws ApplicationException {

		OrdercostBD ordercostbd = new OrdercostBD(
				this.getSessionFactoryClusterMap());

		List ordercosts = ordercostbd.findOrdercostsByOrderhdrIdForSummary(id,
				0, 999, "Costkey");
		List ordersummaryOrdercostDTOs = new ArrayList();
		for (Iterator it = ordercosts.iterator(); it.hasNext();) {
			OrdersummaryCostDTO dto = (OrdersummaryCostDTO) it.next();
			ordersummaryOrdercostDTOs.add(it.next());
			ordercstamtbasetotal = ordercstamtbasetotal
					.add(dto.getCstamtbase());
		}
		
		ordercostbd = null;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setJobcostLineItems(String id) throws ApplicationException {

		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

		// populate job header cost list items
		List jobhdrs = jobhdrbd.findJobhdrsById(id, 0, 999, "Unitkey");
		List ordersummaryJobcostDTOs = new ArrayList();
		for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
			JobhdrDTO jobhdr = (JobhdrDTO) it.next();
			List jobcosts = jobcostbd.findJobhdrcostsByJobhdrIdForSummary(
					jobhdr.getJobhdrId().toString(), 0, 999, "jobcost.Costkey");

			for (Iterator it2 = jobcosts.iterator(); it2.hasNext();) {
				OrdersummaryJobcostDTO dto = (OrdersummaryJobcostDTO) it2
						.next();
				ordersummaryJobcostDTOs.add(dto);
				jobcstamtbasetotal = jobcstamtbasetotal
						.add(dto.getCstamtbase());
			}
		}

		ordersummaryJobcostDTOs = new ArrayList();
		for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
			JobhdrDTO jobhdr = (JobhdrDTO) it.next();
			List jobcosts = jobcostbd
					.findJobmovcostsByJobhdrIdForSummary(jobhdr.getJobhdrId()
							.toString(), 0, 999,
							"jobmov.Totimeinmillis, jobmov.Fromtimeinmillis, jobcost.Costkey");

			for (Iterator it2 = jobcosts.iterator(); it2.hasNext();) {
				OrdersummaryJobcostDTO dto = (OrdersummaryJobcostDTO) it2
						.next();
				ordersummaryJobcostDTOs.add(dto);
				jobcstamtbasetotal = jobcstamtbasetotal
						.add(dto.getCstamtbase());
			}

		}

		// populate accounts payable list items
		PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());
		
		List accountspayableDTOs = new ArrayList();
		for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
			JobhdrDTO jobhdrdto = (JobhdrDTO) it.next();

			// get purchase accounts payable for Job number
			List pidtlcostdtos = null;
			pidtlcostdtos = pidtlcostbd
					.findPidtlcostsByJobhdrIdForAccountspayable(jobhdrdto
							.getJobhdrId().toString(), 0,
							Constants.MAX_RESULTS_NOLIMIT,
							"address.Name,pidtlcost.Txt1");

			Iterator it2 = pidtlcostdtos.iterator();
			while (it2.hasNext()) {
				PidtlcostDTO dto = (PidtlcostDTO) it2.next();
				accountspayableDTOs.add(dto);
				cstamtalloctotal = cstamtalloctotal.add(dto
						.getCstamtallocbase());
			}

		}// jobhdrs
		
		pidtlcostbd = null;
		jobcostbd = null;
		
	}

	
	
}
