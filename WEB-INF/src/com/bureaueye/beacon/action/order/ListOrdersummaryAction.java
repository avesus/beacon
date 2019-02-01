package com.bureaueye.beacon.action.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.order.ListOrdersummaryForm;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrdercostBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryChargeDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.util.Util;

/**
 * 
 * AMENDMENTS ----------
 * 
 * NT 2014-05-22 WSI-201405-0001 Order Financial Summary Modifications
 *				 - add Accounts Receivable summary
 *				 - add Accounts Payable summary 
 *
 * NT 2014-07-10 201400029 Modify Zero Units Amount calculation in Order,
 * Quotation and Sales Invoice modules
 * 
 */
public final class ListOrdersummaryAction extends BaseAction {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " actionFormName = "
					+ actionFormName + "\t Mapping = " + mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		ListOrdersummaryForm listForm = (ListOrdersummaryForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		PidtlcostBD pidtlcostbd = new PidtlcostBD(
				this.getSessionFactoryClusterMap());
		SidtlBD sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());

		// populate header info
		setHeaderInfo(listForm);

		// populate list items
		// setChargeLineItems(listForm);
		List ordercharges = new OrderchargeBD(
				this.getSessionFactoryClusterMap())
				.findOrderchargesByOrderhdrIdForSummary(listForm.getId(), 0,
						999, "Chargekey");
		List ordersummaryOrderchargeDTOs = new ArrayList();
		BigDecimal chgamtbasetotal = new BigDecimal(0.0);
		for (Iterator it = ordercharges.iterator(); it.hasNext();) {
			OrdersummaryChargeDTO dto = (OrdersummaryChargeDTO) it.next();
			ordersummaryOrderchargeDTOs.add(dto);
			chgamtbasetotal = chgamtbasetotal.add(dto.getChgamt());
		}
		listForm.setList(ordersummaryOrderchargeDTOs);
		listForm.setTotals(chgamtbasetotal, 0);
		// Reset the update boxes
		listForm.setSelectedObjects(null);

		// populate order cost list items
		List ordercosts = new OrdercostBD(this.getSessionFactoryClusterMap())
				.findOrdercostsByOrderhdrIdForSummary(listForm.getId(), 0, 999,
						"Costkey");
		List ordersummaryOrdercostDTOs = new ArrayList();
		for (Iterator it = ordercosts.iterator(); it.hasNext();) {
			ordersummaryOrdercostDTOs.add(it.next());
		}
		listForm.setLineItems(ordersummaryOrdercostDTOs, 0);

		// populate job header cost list items
		List jobhdrs = new JobhdrBD(this.getSessionFactoryClusterMap())
				.findJobhdrsById(listForm.getId(), 0, 999, "Unitkey");
		List ordersummaryJobcostDTOs = new ArrayList();
		BigDecimal cstamtbasetotal2 = new BigDecimal(0.0);
		for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
			JobhdrDTO jobhdr = (JobhdrDTO) it.next();
			List jobcosts = new JobcostBD(this.getSessionFactoryClusterMap())
					.findJobhdrcostsByJobhdrIdForSummary(jobhdr.getJobhdrId()
							.toString(), 0, 999, "jobcost.Costkey");

			for (Iterator it2 = jobcosts.iterator(); it2.hasNext();) {
				OrdersummaryJobcostDTO dto = (OrdersummaryJobcostDTO) it2
						.next();
				ordersummaryJobcostDTOs.add(dto);
				cstamtbasetotal2 = cstamtbasetotal2.add(dto.getCstamtbase());
			}
		}
		listForm.setLineItems(ordersummaryJobcostDTOs, 1);
		listForm.setTotals(cstamtbasetotal2, 1);
		// Reset the update boxes
		listForm.setSelectedObjects2(null);

		ordersummaryJobcostDTOs = new ArrayList();
		BigDecimal cstamtbasetotal3 = new BigDecimal(0.0);
		for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
			JobhdrDTO jobhdr = (JobhdrDTO) it.next();
			List jobcosts = new JobcostBD(this.getSessionFactoryClusterMap())
					.findJobmovcostsByJobhdrIdForSummary(jobhdr.getJobhdrId()
							.toString(), 0, 999,
							"jobmov.Totimeinmillis, jobmov.Fromtimeinmillis, jobcost.Costkey");

			for (Iterator it2 = jobcosts.iterator(); it2.hasNext();) {
				OrdersummaryJobcostDTO dto = (OrdersummaryJobcostDTO) it2
						.next();
				ordersummaryJobcostDTOs.add(dto);
				cstamtbasetotal3 = cstamtbasetotal3.add(dto.getCstamtbase());
			}

		}
		listForm.setLineItems(ordersummaryJobcostDTOs, 2);
		listForm.setTotals(cstamtbasetotal3, 2);
		// Reset the update boxes
		listForm.setSelectedObjects3(null);

		// init profit and base totals
		double profittotal = 0.0;
		double basetotal = 0.0;
		try {
			basetotal = chgamtbasetotal.doubleValue()
					- cstamtbasetotal2.doubleValue()
					- cstamtbasetotal3.doubleValue();
			listForm.setTotals(new BigDecimal(basetotal), 3);
		} catch (Exception e) {
		}
		try {
			// 201400029
			if (chgamtbasetotal.doubleValue() != 0) {
				profittotal = (basetotal / chgamtbasetotal.doubleValue()) * 100;
			}			
			listForm.setTotals(new BigDecimal(profittotal), 4);
		} catch (Exception e) {
		}

		// sWSI-201405-0001 =================================================>
		// populate accounts payable list items
		List accountspayableDTOs = new ArrayList();
		BigDecimal cstamtalloctotal = new BigDecimal(0.0);
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
		listForm.setLineItems(accountspayableDTOs, 3);
		listForm.setTotals(cstamtalloctotal, 5);

		// populate accounts receivable list items
		List accountsreceivableDTOs = new ArrayList();
		BigDecimal invoiceamttotal = new BigDecimal(0.0);
		// get sales invoice for order number
		List sidtldtos = null;
		sidtldtos = sidtlbd.findSidtlsByOrdhdrIdForAccountsreceivable(
				listForm.getId(),// orderhdrid
				0, Constants.MAX_RESULTS_NOLIMIT, "address.Name,sidtl.Txt1");

		Iterator it = sidtldtos.iterator();
		while (it.hasNext()) {
			SidtlDTO dto = (SidtlDTO) it.next();
			accountsreceivableDTOs.add(dto);
			invoiceamttotal = invoiceamttotal.add(dto.getInvoiceamtbase());
		}
		listForm.setLineItems(accountsreceivableDTOs, 4);
		listForm.setTotals(invoiceamttotal, 6);

		// init balance total
		// (invoiceamttotal - cstamtalloctotal)
		double balancetotal = 0.0;
		try {
			balancetotal = invoiceamttotal.doubleValue()
					- cstamtalloctotal.doubleValue();
			listForm.setTotals(new BigDecimal(balancetotal), 7);
		} catch (Exception e) {
		}
		// eWSI-201405-0001 =================================================<

		// clear business delegates
		pidtlcostbd = null;
		sidtlbd = null;

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());

		return findSuccess(mapping);
	}

	public void setHeaderInfo(ListOrdersummaryForm listForm)
			throws ApplicationException {

		// set header information
		Orderhdr hdr = new OrderhdrBD(this.getSessionFactoryClusterMap())
				.read(new Integer(listForm.getId()));

		listForm.setHeaderInfo(hdr.getOrderno(), 1);
		try {
			listForm.setHeaderInfo(Util.dateTextFormat2(hdr.getOrderdate()), 2);
		} catch (Exception e) {
		}

		listForm.setHeaderInfo(hdr.getCustomerref(), 3);
		listForm.setHeaderInfo("", 4);
		try {
			listForm.setHeaderInfo(
					new AddressBD(this.getSessionFactoryClusterMap()).read(
							hdr.getCustomeraddrkey()).getName(), 4);
		} catch (Exception e) {
		}

		listForm.setHeaderInfo(hdr.getOrderbyuserid(), 5);

		listForm.setHeaderInfo("", 6);
		try {
			listForm.setHeaderInfo(
					new LocationBD(this.getSessionFactoryClusterMap()).read(
							hdr.getLdglocationkey2()).getLocationName(), 6);
		} catch (Exception e) {
		}
		listForm.setHeaderInfo("", 7);
		try {
			listForm.setHeaderInfo(
					new LocationBD(this.getSessionFactoryClusterMap()).read(
							hdr.getDchlocationkey2()).getLocationName(), 7);
		} catch (Exception e) {
		}

		listForm.setHeaderInfo(hdr.getCcykey(), 8);

		listForm.setHeaderInfo("", 10);
		try {
			listForm.setHeaderInfo(
					new ProductBD(this.getSessionFactoryClusterMap()).read(
							hdr.getProductkey()).getTradname(), 10);
		} catch (Exception e) {
		}

		// init content display modes
		if (listForm.getDisplayContent1() == null)
			listForm.setDisplayContent1("");
		if (listForm.getDisplayContent2() == null)
			listForm.setDisplayContent2("");
		if (listForm.getDisplayContent3() == null)
			listForm.setDisplayContent3("");
		if (listForm.getDisplayContent4() == null)
			listForm.setDisplayContent4("");
		if (listForm.getDisplayContent5() == null)
			listForm.setDisplayContent5("");

	}

}
