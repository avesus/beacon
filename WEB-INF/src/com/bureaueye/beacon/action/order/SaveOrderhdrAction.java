package com.bureaueye.beacon.action.order;

import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.bean.standard.Gcode;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.order.OrderhdrForm;

import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.formatter.FormattingException;
import com.bureaueye.beacon.formatter.IntegerFormatter;

import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.Ordernote;
import com.bureaueye.beacon.model.order.Ordernotecust;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrdercostBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdermovBD;
import com.bureaueye.beacon.model.order.bd.OrdernoteBD;
import com.bureaueye.beacon.model.order.bd.OrdernotecustBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.Customertoport;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.CustomertoportBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-06-06 201400025 Patch Fix for Order charge duplication problem -
 * clear CopyId after copy process
 * 
 */
public final class SaveOrderhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrderhdrForm saveForm = (OrderhdrForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();

		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Cancel transaction");
			return findSuccess(mapping);
		}

		// check for navigation
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Navigate to " + saveForm.getForwardname());
		if (!saveForm.getForwardname().equals("")) {
			return (mapping.findForward(saveForm.getForwardname()));
		}

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		// Generate Business Delegate
		OrderhdrBD bd = new OrderhdrBD(this.getSessionFactoryClusterMap());

		// find record
		Orderhdr dao = null;
		try {
			dao = bd.read(new Integer(saveForm.getId()));
		} catch (Exception e) {
		}

		// process quotation copy
		Quohdr quohdrDTO = null;
		if (saveForm.getCopyQuotationButton() != null
				&& !saveForm.getCopyQuotationButton().equals("")
				&& !saveForm.getCopyQuoteId().equals("")
				&& action.equals("Create")) {
			log.debug("["
					+ this.getClass().getName()
					+ "] "
					+ new java.util.Date()
					+ " SaveOrderhdrAction:  Processing copyQuotation from id: "
					+ saveForm.getCopyQuoteId());

			quohdrDTO = new QuohdrBD(this.getSessionFactoryClusterMap())
					.findQuohdrByQuotno(saveForm.getCopyQuoteId());
			if (quohdrDTO != null) {
				if (!quohdrDTO.getQuotestatus().equals("APPROVED")) {
					errors.add("informationMessage", new ActionMessage(
							"message.copyquote.notapproved"));
				} else {
					// store header details
					// init FORM with DTO values
					BeanUtils.copyProperties(saveForm, quohdrDTO);
					saveForm.setId("");
					saveForm.setQuotno(saveForm.getCopyQuoteId());
					saveForm.setQuohdrId(quohdrDTO.getId().toString());
				}
			} else {
				errors.add("informationMessage", new ActionMessage(
						"message.copyquote.noquotefound"));
			}
		}

		// process find demurrage rates
		if (request.getParameter("findDmrgratesButton.x") != null) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " SaveOrderhdrAction:  Processing findDmrgratesButton ");
			Customertoport customertoportDTO = new CustomertoportBD(
					this.getSessionFactoryClusterMap())
					.findCustomertoportByCustomerLocation(
							saveForm.getCustomeraddrkey(),
							saveForm.getDmrglocationkey());
			if (customertoportDTO != null) {
				// init FORM with DTO values
				try {
					CurrencyFormatter currencyFormatter = new CurrencyFormatter();
					IntegerFormatter integerFormatter = new IntegerFormatter();
					saveForm.setDmrgfreedays(integerFormatter
							.format(customertoportDTO.getFreeDays()));
					saveForm.setDmrgdays1(integerFormatter
							.format(customertoportDTO.getDemPeriod1()));
					saveForm.setDmrgdays2(integerFormatter
							.format(customertoportDTO.getDemPeriod2()));
					saveForm.setDmrgdlyrate1(currencyFormatter
							.format(customertoportDTO.getDemRate1()));
					saveForm.setDmrgdlyrate2(currencyFormatter
							.format(customertoportDTO.getDemRate2()));
					saveForm.setDmrgdlyrate3(currencyFormatter
							.format(customertoportDTO.getDemRate3()));
				} catch (FormattingException fe) {
					// fe.printStackTrace();
				}
				messages.add("informationMessage", new ActionMessage(
						"message.demurrage.ratefound"));
			} else {
				messages.add("informationMessage", new ActionMessage(
						"message.demurrage.noratefound"));
			}
			saveForm.setForwardname("orderhdr3");
			return (mapping.findForward(saveForm.getForwardname()));
		}

		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			Orderhdr duplicate = null;
			try {
				duplicate = bd.findOrderhdrByOrderno(saveForm.getOrderno());
			} catch (ApplicationException ae) {
			}
			if (duplicate != null) {
				errors.add("informationMessage", new ActionMessage(
						"error.orderhdr.unique"));
			}
		}

		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			saveForm.setForwardname("orderhdr1");
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			saveForm.setForwardname("orderhdr1");
			return (mapping.getInputForward());
		}

		if (action.equals("Delete")) {
			// delete parent/children
			bd.deleteAll(new Integer(saveForm.getId()), user);
			// delete parent
			// bd.delete(new Orderhdr(new Integer(saveForm.getId())), user);
		} else {

			if (dao == null) {
				dao = new Orderhdr();
			}

			// check complete flag changed
			try {
				log.info("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " saveForm.isCompleteflag()["
						+ saveForm.isCompleteflag() + "]"
						+ " dao.isCompleteflag()[" + dao.isCompleteflag() + "]");
				if (saveForm.isCompleteflag() != dao.isCompleteflag()) {
					// clear audit fields
					dao.setCompletedate(null);
					dao.setCompletetime("");
					dao.setCompleteuserid("");
					if (saveForm.isCompleteflag()) {
						// set audit fields
						Calendar c = Calendar.getInstance();
						dao.setCompletedate(c.getTime());
						dao.setCompletetime(com.bureaueye.beacon.util.Util
								.toTime(c));
						dao.setCompleteuserid(user.getUserid());
					}
				}
			} catch (Exception e) {
			}

			BeanUtils.copyProperties(dao, saveForm);

			// do not copy ship details
			if (!saveForm.getCopyId().equals("")) {
				dao.setShipvessel("");
				dao.setShipvendoraddrkey("");
				dao.setShipvoyage("");
			}

			// if (action.equals("Create")) {
			// init LOADING1 gcodes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getLdglocationkey1());
				dao.setLdgg1key1(gcode.getG1codekey());
				dao.setLdgg2key1(gcode.getG2codekey());
				dao.setLdgg3key1(gcode.getG3codekey());
				dao.setLdgg4key1(gcode.getG4codekey());
			} catch (Exception e) {
			}
			// init LOADING2 gcodes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getLdglocationkey2());
				dao.setLdgg1key2(gcode.getG1codekey());
				dao.setLdgg2key2(gcode.getG2codekey());
				dao.setLdgg3key2(gcode.getG3codekey());
				dao.setLdgg4key2(gcode.getG4codekey());
			} catch (Exception e) {
			}
			// init DISCHARGE1 gcodes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getDchlocationkey1());
				dao.setDchg1key1(gcode.getG1codekey());
				dao.setDchg2key1(gcode.getG2codekey());
				dao.setDchg3key1(gcode.getG3codekey());
				dao.setDchg4key1(gcode.getG4codekey());
			} catch (Exception e) {
			}
			// init DISCHARGE2 gcodes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getDchlocationkey2());
				dao.setDchg1key2(gcode.getG1codekey());
				dao.setDchg2key2(gcode.getG2codekey());
				dao.setDchg3key2(gcode.getG3codekey());
				dao.setDchg4key2(gcode.getG4codekey());
			} catch (Exception e) {
			}
			// }

			bd.createOrUpdate(dao, user);

			// copy all order details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["
						+ this.getClass().getName()
						+ "] "
						+ new java.util.Date()
						+ " SaveOrderhdrAction:  Processing copyOrder from id: "
						+ saveForm.getCopyId());
				Integer orderhdrId = null;
				try {
					orderhdrId = new Integer(saveForm.getCopyId());
				} catch (Exception e) {
				}
				if (orderhdrId != null) {
					copyOrderToOrder(orderhdrId, dao, user);
				}
				saveForm.setCopyId("");//201400025 
			}

			// Find the quohdr form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();

			// if create function display new record
			if (action.equals("Create")) {
				// Set the search parameters
				listform.setSearchString1(dao.getOrderno());
				listform.setSearchString2(dao.getCustomeraddrkey());
			}

		}

		// process other quotation copy records - charges, products, movements,
		// notes, costs
		if (saveForm.getCopyQuotationButton() != null
				&& !saveForm.getCopyQuotationButton().equals("")
				&& !saveForm.getCopyQuoteId().equals("")
				&& action.equals("Create")) {
			log.debug("["
					+ this.getClass().getName()
					+ "] "
					+ new java.util.Date()
					+ " SaveOrderhdrAction:  Processing copyQuotation from id: "
					+ saveForm.getCopyQuoteId());

			// Quohdr quohdrDTO = new
			// QuohdrBD(this.getSessionFactoryClusterMap()).findQuohdrByQuotno(saveForm.getCopyQuote());
			if (quohdrDTO != null) {
				copyQuotationToOrder(quohdrDTO, dao, user);
			}
		}

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to success page");
		return findSuccess(mapping);

	}

	@SuppressWarnings("rawtypes")
	public void copyQuotationToOrder(Quohdr quohdrDTO, Orderhdr dao, User user)
			throws Exception {

		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuomovBD quomovbd = new QuomovBD(this.getSessionFactoryClusterMap());
		OrderchargeBD orderchargebd = new OrderchargeBD(
				this.getSessionFactoryClusterMap());
		OrderprodBD orderprodbd = new OrderprodBD(
				this.getSessionFactoryClusterMap());
		OrdermovBD ordermovbd = new OrdermovBD(
				this.getSessionFactoryClusterMap());
		OrdercostBD ordercostbd = new OrdercostBD(
				this.getSessionFactoryClusterMap());
		OrdernoteBD ordernotebd = new OrdernoteBD(
				this.getSessionFactoryClusterMap());
		OrdernotecustBD ordernotecustbd = new OrdernotecustBD(
				this.getSessionFactoryClusterMap());

		// copy and store charges
		for (Iterator it = quohdrbd.getQuocharges(quohdrDTO.getId()).iterator(); it
				.hasNext();) {
			Ordercharge ordercharge = new Ordercharge();
			BeanUtils.copyProperties(ordercharge, it.next());
			ordercharge.setOrderhdrId(dao.getId());
			ordercharge.setOrderno(dao.getOrderno());
			ordercharge.setInvoicestatus("");
			// if the charge customer has been left blank use the header
			// customer
			if (ordercharge.getCustomeraddrkey().equals("")) {
				ordercharge.setCustomeraddrkey(dao.getCustomeraddrkey());
			}
			orderchargebd.createOrUpdate(ordercharge, user);
		}
		// copy and store notes
		for (Iterator it = quohdrbd.getQuonotes(quohdrDTO.getId()).iterator(); it
				.hasNext();) {
			Ordernote ordernote = new Ordernote();
			BeanUtils.copyProperties(ordernote, it.next());
			ordernote.setOrderhdrId(dao.getId());
			ordernote.setOrderno(dao.getOrderno());
			ordernotebd.createOrUpdate(ordernote, user);
		}
		// copy and store products
		for (Iterator it = quohdrbd.getQuoprods(quohdrDTO.getId()).iterator(); it
				.hasNext();) {
			Orderprod orderprod = new Orderprod();
			BeanUtils.copyProperties(orderprod, it.next());
			orderprod.setOrderhdrId(dao.getId());
			orderprod.setOrderno(dao.getOrderno());
			orderprodbd.createOrUpdate(orderprod, user);
		}
		// copy and store movements
		for (Iterator it = quohdrbd.getQuomovs(quohdrDTO.getId()).iterator(); it
				.hasNext();) {
			Ordermov ordermov = new Ordermov();
			Quomov quomov = (Quomov) it.next();
			BeanUtils.copyProperties(ordermov, quomov);
			ordermov.setOrderhdrId(dao.getId());
			ordermov.setOrderno(dao.getOrderno());
			// init estimated 'from' date using Loading date +/- 'from' days
			if (quomov.isInitfromday()) {
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(dao.getLdgfromdate());
					c.add(Calendar.DATE, quomov.getFromdayno().intValue());
					ordermov.setEstfromdate(c.getTime());
				} catch (Exception e) {
				}
			}
			// init estimated 'to' date using Loading date +/- 'to' days
			if (quomov.isInittoday()) {
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(dao.getLdgtodate());
					c.add(Calendar.DATE, quomov.getTodayno().intValue());
					ordermov.setEsttodate(c.getTime());
				} catch (Exception e) {
				}
			}

			// persist movement
			ordermovbd.createOrUpdate(ordermov, user);

			// copy and store movement costs
			for (Iterator it2 = quomovbd.getQuocosts(quomov.getQuomovId())
					.iterator(); it2.hasNext();) {
				Ordercost ordercost = new Ordercost();
				BeanUtils.copyProperties(ordercost, it2.next());
				ordercost.setOrdermovId(ordermov.getOrdermovId());
				ordercost.setOrderhdrId(0);
				ordercost.setOrderno(dao.getOrderno());
				ordercostbd.createOrUpdate(ordercost, user);
			}

		}

		// copy and store header costs
		for (Iterator it = quohdrbd.getQuocosts(quohdrDTO.getId()).iterator(); it
				.hasNext();) {
			Ordercost ordercost = new Ordercost();
			BeanUtils.copyProperties(ordercost, it.next());
			ordercost.setOrderhdrId(dao.getId());
			ordercost.setOrdermovId(0);
			ordercost.setOrderno(dao.getOrderno());
			ordercostbd.createOrUpdate(ordercost, user);
		}

		// copy and store notes
		for (Iterator it = quohdrbd.getQuonotecusts(quohdrDTO.getId())
				.iterator(); it.hasNext();) {
			Ordernotecust notecust = new Ordernotecust();
			BeanUtils.copyProperties(notecust, it.next());
			notecust.setOrderhdrId(dao.getId());
			notecust.setOrderno(dao.getOrderno());
			ordernotecustbd.createOrUpdate(notecust, user);
		}

	}

	@SuppressWarnings("rawtypes")
	public void copyOrderToOrder(Integer orderhdrId, Orderhdr dao, User user)
			throws Exception {

		OrderhdrBD orderhdrbd = new OrderhdrBD(
				this.getSessionFactoryClusterMap());
		OrderchargeBD orderchargebd = new OrderchargeBD(
				this.getSessionFactoryClusterMap());
		OrderprodBD orderprodbd = new OrderprodBD(
				this.getSessionFactoryClusterMap());
		OrdermovBD ordermovbd = new OrdermovBD(
				this.getSessionFactoryClusterMap());
		OrdercostBD ordercostbd = new OrdercostBD(
				this.getSessionFactoryClusterMap());
		OrdernoteBD ordernotebd = new OrdernoteBD(
				this.getSessionFactoryClusterMap());

		// copy and store charges
		for (Iterator it = orderhdrbd.getOrdercharges(orderhdrId).iterator(); it
				.hasNext();) {
			Ordercharge ordercharge = new Ordercharge();
			BeanUtils.copyProperties(ordercharge, it.next());
			ordercharge.setOrderhdrId(dao.getId());
			ordercharge.setOrderchargeId(null);
			ordercharge.setOrderno(dao.getOrderno());
			ordercharge.setInvoicestatus("");
			orderchargebd.createOrUpdate(ordercharge, user);
		}

		// copy and store notes
		for (Iterator it = orderhdrbd.getOrdernotes(orderhdrId).iterator(); it
				.hasNext();) {
			Ordernote ordernote = new Ordernote();
			BeanUtils.copyProperties(ordernote, it.next());
			ordernote.setOrderhdrId(dao.getId());
			ordernote.setOrdernoteId(null);
			ordernote.setOrderno(dao.getOrderno());
			ordernotebd.createOrUpdate(ordernote, user);
		}

		// copy and store products
		for (Iterator it = orderhdrbd.getOrderprods(orderhdrId).iterator(); it
				.hasNext();) {
			Orderprod orderprod = new Orderprod();
			BeanUtils.copyProperties(orderprod, it.next());
			orderprod.setOrderhdrId(dao.getId());
			orderprod.setOrderprodId(null);
			orderprod.setOrderno(dao.getOrderno());
			orderprodbd.createOrUpdate(orderprod, user);
		}

		// copy and store movements
		for (Iterator it = orderhdrbd.getOrdermovs(orderhdrId).iterator(); it
				.hasNext();) {
			Ordermov ordermov = new Ordermov();
			BeanUtils.copyProperties(ordermov, it.next());
			ordermov.setOrderhdrId(dao.getId());
			ordermov.setOrdermovId(null);
			ordermov.setOrderno(dao.getOrderno());
			ordermovbd.createOrUpdate(ordermov, user);
		}

		// copy and store header costs
		for (Iterator it = orderhdrbd.getOrdercosts(orderhdrId).iterator(); it
				.hasNext();) {
			Ordercost ordercost = new Ordercost();
			BeanUtils.copyProperties(ordercost, it.next());
			ordercost.setOrderhdrId(dao.getId());
			ordercost.setOrdercostId(null);
			ordercost.setOrderno(dao.getOrderno());
			ordercostbd.createOrUpdate(ordercost, user);
		}

	}

}
