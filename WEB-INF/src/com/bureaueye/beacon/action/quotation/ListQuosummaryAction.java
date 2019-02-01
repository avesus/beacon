package com.bureaueye.beacon.action.quotation;

import java.math.BigDecimal;
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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.quotation.ListQuosummaryForm;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryChargeDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryCostDTO;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.util.Util;

/**
 * 
 * AMENDMENTS ----------
 * 
 * NT 2014-07-10 201400029 Modify Zero Units Amount calculation in Order,
 * Quotation and Sales Invoice modules
 * 
 */
public final class ListQuosummaryAction extends BaseAction {

	@SuppressWarnings("rawtypes")
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

		ListQuosummaryForm listForm = (ListQuosummaryForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		// populate header info
		setHeaderInfo(listForm);

		// populate list items
		setChargeLineItems(listForm);

		// populate list items
		setCostLineItems(listForm);

		// init profit and base totals
		// (chgamtbasetotal - cstamtbasetotal2 - cstamtbasetotal3) /
		// chgamtbasetotal * 100}
		double profittotal = 0.0;
		double basetotal = 0.0;
		try {
			basetotal = listForm.getTotals(0).doubleValue()
					- listForm.getTotals(1).doubleValue()
					- listForm.getTotals(2).doubleValue();
			// 201400029			
			if (listForm.getTotals(0).doubleValue() != 0) {
				profittotal = (basetotal / listForm.getTotals(0).doubleValue()) * 100;
			}
		} catch (Exception e) {
		}
		listForm.setTotals(new BigDecimal(basetotal), 3);
		listForm.setTotals(new BigDecimal(profittotal), 4);

		// Set a transactional control token to prevent double posting
		// log.debug("["+this.getClass().getName()+"] "+new
		// java.util.Date()+"  Setting transactional control token");
		// saveToken(request);

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());

		return findSuccess(mapping);
	}

	public void setHeaderInfo(ListQuosummaryForm listForm)
			throws ApplicationException {

		// set header information
		Quohdr quohdr = new QuohdrBD(this.getSessionFactoryClusterMap())
				.read(new Integer(listForm.getId()));

		listForm.setHeaderInfo(quohdr.getQuotno(), 1);
		try {
			listForm.setHeaderInfo(Util.dateTextFormat2(quohdr.getQuotedate()),
					2);
		} catch (Exception e) {
		}
		try {
			listForm.setHeaderInfo(
					Util.dateTextFormat2(quohdr.getExpirydate()), 3);
		} catch (Exception e) {
		}
		listForm.setHeaderInfo(quohdr.getCustomername(), 4);
		listForm.setHeaderInfo(quohdr.getQuotebyuserid(), 5);
		listForm.setHeaderInfo("", 6);
		try {
			listForm.setHeaderInfo(
					new LocationBD(this.getSessionFactoryClusterMap()).read(
							quohdr.getLdglocationkey2()).getLocationName(), 6);
		} catch (Exception e) {
		}
		listForm.setHeaderInfo("", 7);
		try {
			listForm.setHeaderInfo(
					new LocationBD(this.getSessionFactoryClusterMap()).read(
							quohdr.getDchlocationkey2()).getLocationName(), 7);
		} catch (Exception e) {
		}
		listForm.setHeaderInfo(quohdr.getCcykey(), 8);

		listForm.setHeaderInfo(
				new ProductBD(this.getSessionFactoryClusterMap()).read(
						quohdr.getProductkey()).getTradname(), 10);

		listForm.setHeaderInfo(quohdr.getShipmethod(), 12);

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

	@SuppressWarnings("rawtypes")
	public void setChargeLineItems(ListQuosummaryForm listForm)
			throws ApplicationException {

		listForm.setGotoPage(0);
		listForm.setMaxResults(99);
		listForm.setOrderBy("Chargekey");
		listForm.setOrderByDesc("");

		// set line items
		listForm.setLineItems(
				new QuochargeBD(this.getSessionFactoryClusterMap())
						.findQuochargesForSummary(listForm), 0);

		// calculate total
		BigDecimal chgamtbasetotal = new BigDecimal(0.0);
		for (Iterator it = listForm.getLineItems(0).iterator(); it.hasNext();) {
			QuosummaryChargeDTO dto = (QuosummaryChargeDTO) it.next();
			chgamtbasetotal = chgamtbasetotal.add(dto.getChgamt());
		}
		listForm.setTotals(chgamtbasetotal, 0);

	}

	@SuppressWarnings("rawtypes")
	public void setCostLineItems(ListQuosummaryForm listForm)
			throws ApplicationException {

		listForm.setGotoPage(0);
		listForm.setMaxResults(99);

		// quohdr costs
		listForm.setOrderBy("quocost.Costkey");
		// set line items
		listForm.setLineItems(new QuocostBD(this.getSessionFactoryClusterMap())
				.findQuohdrcostsForSummary(listForm), 1);

		// calculate total
		BigDecimal cstamtbasetotal2 = new BigDecimal(0.0);
		for (Iterator it = listForm.getLineItems(1).iterator(); it.hasNext();) {
			QuosummaryCostDTO dto = (QuosummaryCostDTO) it.next();
			cstamtbasetotal2 = cstamtbasetotal2.add(dto.getCstamtbase());
		}
		listForm.setTotals(cstamtbasetotal2, 1);

		// quomov costs
		listForm.setOrderBy("quomov.Seqno, quocost.Costkey");
		// set line items
		listForm.setLineItems(new QuocostBD(this.getSessionFactoryClusterMap())
				.findQuomovcostsForSummary(listForm), 2);

		// calculate total
		BigDecimal cstamtbasetotal3 = new BigDecimal(0.0);
		for (Iterator it = listForm.getLineItems(2).iterator(); it.hasNext();) {
			QuosummaryCostDTO dto = (QuosummaryCostDTO) it.next();
			cstamtbasetotal3 = cstamtbasetotal3.add(dto.getCstamtbase());
		}
		listForm.setTotals(cstamtbasetotal3, 2);

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListForm Parameters: " + listForm.toString());

	}

}
