package com.bureaueye.beacon.action.quotation;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
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
import com.bureaueye.beacon.form.quotation.QuohdrForm;
import com.bureaueye.beacon.model.quotation.Quocharge;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.Quonote;
import com.bureaueye.beacon.model.quotation.Quonotecust;
import com.bureaueye.beacon.model.quotation.Quoprod;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.quotation.bd.QuonoteBD;
import com.bureaueye.beacon.model.quotation.bd.QuonotecustBD;
import com.bureaueye.beacon.model.quotation.bd.QuoprodBD;
import com.bureaueye.beacon.model.standard.Address;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2011-05-23 ITT-201105-0001 Quotation Exchange Rates Update
 * 
 * NT 2014-06-11 201400025 Patch Fix for Order charge duplication problem -
 * clear CopyId after copy process
 * 
 */
public final class SaveQuohdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		QuohdrForm saveForm = (QuohdrForm) form;
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

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		// Generate Business Delegate
		QuohdrBD bd = new QuohdrBD(this.getSessionFactoryClusterMap());

		// find record
		Quohdr dao = null;
		try {
			dao = bd.read(new Integer(saveForm.getId()));
		} catch (Exception e) {
		}
		// not found create empty object
		if (dao == null) {
			dao = new Quohdr();
		}

		// //PropertyUtils.copyProperties(quohdr, saveForm);
		// //PropertyUtils.copyProperties(dao, customertariffhdrForm);
		// // init FORM with dao values
		// //PropertyUtils.copyProperties(saveForm, dao);
		// saveForm.setExpirydate(
		// saveForm.getExpirydateyyyy()+"-"+
		// saveForm.getExpirydatemm()+"-"+
		// saveForm.getExpirydatedd()
		// );
		// saveForm.setQuotedate(
		// saveForm.getQuotedateyyyy()+"-"+
		// saveForm.getQuotedatemm()+"-"+
		// saveForm.getQuotedatedd()
		// );
		// try {
		// saveForm.populate(dao,BaseForm.TO_OBJECT);
		// //BeanUtils.copyProperties(dao,saveForm);
		// }
		// catch (FormattingException fe) {
		// fe.printStackTrace();
		// }

		/*
		 * REMOVED THIS FOR NOW *10-JUN-2013* NOT SURE IF THIS WILL WORK QUOHDR
		 * TAB SCREENS-- if (request.getParameter("findDmrgratesButton.x") !=
		 * null) { log.debug("["+this.getClass().getName()+"] "+new
		 * java.util.Date
		 * ()+" SaveQuohdrAction:  Processing findDmrgratesButton ");
		 * Customertoport customertoportDTO = new
		 * CustomertoportBD(this.getSessionFactoryClusterMap())
		 * .findCustomertoportByCustomerLocation( saveForm.getCustomeraddrkey(),
		 * saveForm.getDmrglocationkey() ); if (customertoportDTO != null) { //
		 * init FORM with DTO values try { CurrencyFormatter currencyFormatter =
		 * new CurrencyFormatter(); IntegerFormatter integerFormatter = new
		 * IntegerFormatter();
		 * saveForm.setDmrgfreedays(integerFormatter.format(customertoportDTO
		 * .getFreeDays()));
		 * saveForm.setDmrgdays1(integerFormatter.format(customertoportDTO
		 * .getDemPeriod1()));
		 * saveForm.setDmrgdays2(integerFormatter.format(customertoportDTO
		 * .getDemPeriod2()));
		 * saveForm.setDmrgdlyrate1(currencyFormatter.format(
		 * customertoportDTO.getDemRate1()));
		 * saveForm.setDmrgdlyrate2(currencyFormatter
		 * .format(customertoportDTO.getDemRate2()));
		 * saveForm.setDmrgdlyrate3(currencyFormatter
		 * .format(customertoportDTO.getDemRate3())); } catch
		 * (FormattingException fe) { //fe.printStackTrace(); } messages.add(
		 * "informationMessage", new
		 * ActionMessage("message.demurrage.ratefound")); } else { messages.add(
		 * "informationMessage", new
		 * ActionMessage("message.demurrage.noratefound")); }
		 * saveForm.setForwardname("quohdr3"); return
		 * (mapping.findForward(saveForm.getForwardname())); }
		 */

		// business validation
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			// check for duplicate number
			Quohdr duplicate = null;
			try {
				duplicate = bd.findQuohdrByQuotno(saveForm.getQuotno());
			} catch (ApplicationException ae) {
			}
			if (duplicate != null) {
				errors.add("informationMessage", new ActionMessage(
						"error.quohdr.unique"));
			}
		}

		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}

		// dto.setId(saveForm.getId());

		/*
		 * if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION))
		 * { bd.delete(dto, user); } else if
		 * (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
		 * bd.createOrUpdate(dto, user);
		 * 
		 * // Find the quohdr form ListForm listform = (ListForm)
		 * session.getAttribute("List" + mapping.getName());
		 * 
		 * // Reset the parameters as if it was the first time in
		 * listform.setStartPage(); // Set the search parameters
		 * listform.setSearchString1(dto.getQuotno());
		 * listform.setSearchString2(dto.getCustomeraddrkey()); } else {
		 * bd.createOrUpdate(dto, user); }
		 */

		try {
			// populate data-transfer-object from form
			// init FORM with DTO values
			BeanUtils.copyProperties(dao, saveForm);
		} catch (IllegalAccessException ite) {
		} catch (InvocationTargetException ite) {
		} catch (Exception e) {
		}

		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " SaveQuohdrAction:  Processing Delete for id: "
					+ saveForm.getId());

			// delete parent/children
			bd.deleteAll(new Integer(saveForm.getId()), user);
			// delete parent
			// bd.delete(dao, user);
		} else {

			// if
			// (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))
			// {
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

			// init customer details
			if (!dao.getCustomeraddrkey().equals("")) {
				Address customer = new AddressBD(
						this.getSessionFactoryClusterMap()).read(dao
						.getCustomeraddrkey());
				if (customer != null) {
					dao.setCustomername(customer.getName());
					dao.setCustomeraddr1(customer.getAddr1());
					dao.setCustomeraddr2(customer.getAddr2());
					dao.setCustomeraddr3(customer.getAddr3());
					dao.setCustomeraddr4(customer.getAddr4());
					dao.setCustomeraddr5(customer.getAddr5());
					dao.setCustomercontact(customer.getContact());
					dao.setCustomertelno(customer.getTelno());
					dao.setCustomerfaxno(customer.getFaxno());
					dao.setCustomeremail(customer.getEmailno());
				}
			}
			bd.createOrUpdate(dao, user);

			// Find the quohdr form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();

			// if create function display new record
			if (action
					.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
				// Set the search parameters
				listform.setSearchString1(dao.getQuotno());
				listform.setSearchString2(dao.getCustomeraddrkey());
			}

		}

		// process other quotation copy records - charges, products, movements,
		// notes, costs
		if (!saveForm.getCopyId().equals("")) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " SaveQuohdrAction:  Processing copyQuotation from id: "
					+ saveForm.getCopyId());

			Quohdr copydao = new QuohdrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(saveForm.getCopyId()));
			if (copydao != null) {
				copyQuotationToNew(copydao, dao, user);
			}
			saveForm.setCopyId("");// 201400025
		}

		// sITT-201105-0001
		// NEW PROCESS FOR QUOATION EXCHANGE RATES
		// UPDATE---------------------------------->
		if (saveForm.getExchgrateupd() != null
				&& saveForm.getExchgrateupd().equals("YES")) {
			this.exchgRateUpd(dao, user);
		}
		// NEW PROCESS FOR QUOATION EXCHANGE RATES
		// UPDATE----------------------------------<
		// eITT-201105-0001

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to success page");
		return findSuccess(mapping);

	}

	@SuppressWarnings("rawtypes")
	public void copyQuotationToNew(Quohdr copydao, Quohdr dao, User user)
			throws Exception {

		QuohdrBD hdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuochargeBD chargebd = new QuochargeBD(
				this.getSessionFactoryClusterMap());
		QuoprodBD prodbd = new QuoprodBD(this.getSessionFactoryClusterMap());
		QuomovBD movbd = new QuomovBD(this.getSessionFactoryClusterMap());
		QuocostBD costbd = new QuocostBD(this.getSessionFactoryClusterMap());
		QuonoteBD notebd = new QuonoteBD(this.getSessionFactoryClusterMap());
		QuonotecustBD notecustbd = new QuonotecustBD(
				this.getSessionFactoryClusterMap());

		// copy and store charges
		for (Iterator it = hdrbd.getQuocharges(copydao.getId()).iterator(); it
				.hasNext();) {
			Quocharge charge = new Quocharge();
			BeanUtils.copyProperties(charge, it.next());
			charge.setQuochargeId(null);
			charge.setQuohdrId(dao.getId());
			charge.setQuotno(dao.getQuotno());
			charge.setCusttarfhdrId(""); // blank for a copy process
			chargebd.createOrUpdate(charge, user);
		}
		// copy and store notes
		for (Iterator it = hdrbd.getQuonotes(copydao.getId()).iterator(); it
				.hasNext();) {
			Quonote note = new Quonote();
			BeanUtils.copyProperties(note, it.next());
			note.setQuonoteId(null);
			note.setQuohdrId(dao.getId());
			note.setQuotno(dao.getQuotno());
			notebd.createOrUpdate(note, user);
		}
		// copy and store products
		for (Iterator it = hdrbd.getQuoprods(copydao.getId()).iterator(); it
				.hasNext();) {
			Quoprod prod = new Quoprod();
			BeanUtils.copyProperties(prod, it.next());
			prod.setQuoprodId(null);
			prod.setQuohdrId(dao.getId());
			prod.setQuotno(dao.getQuotno());
			prodbd.createOrUpdate(prod, user);
		}
		// copy and store movements
		for (Iterator it = hdrbd.getQuomovs(copydao.getId()).iterator(); it
				.hasNext();) {
			Quomov mov = new Quomov();
			Quomov quomov = (Quomov) it.next();
			BeanUtils.copyProperties(mov, quomov);
			mov.setQuomovId(null);
			mov.setQuohdrId(dao.getId());
			mov.setQuotno(dao.getQuotno());
			// persist movement
			movbd.createOrUpdate(mov, user);

			// copy and store movement costs
			for (Iterator it2 = movbd.getQuocosts(quomov.getQuomovId())
					.iterator(); it2.hasNext();) {
				Quocost cost = new Quocost();
				BeanUtils.copyProperties(cost, it2.next());
				cost.setQuocostId(null);
				cost.setQuomovId(mov.getQuomovId());
				cost.setQuohdrId(dao.getId());
				cost.setQuotno(dao.getQuotno());
				cost.setVendtarfhdrId(""); // blank for a copy process
				costbd.createOrUpdate(cost, user);
			}
		}

		// copy and store header costs
		for (Iterator it = hdrbd.getQuocosts(copydao.getId()).iterator(); it
				.hasNext();) {
			Quocost cost = new Quocost();
			BeanUtils.copyProperties(cost, it.next());
			cost.setQuocostId(null);
			cost.setQuomovId(0);
			cost.setQuohdrId(dao.getId());
			cost.setQuotno(dao.getQuotno());
			cost.setVendtarfhdrId(""); // blank for a copy process
			costbd.createOrUpdate(cost, user);
		}

		// copy and store customer notes
		for (Iterator it = hdrbd.getQuonotecusts(copydao.getId()).iterator(); it
				.hasNext();) {
			Quonotecust notecust = new Quonotecust();
			BeanUtils.copyProperties(notecust, it.next());
			notecust.setQuonotecustId(null);
			notecust.setQuohdrId(dao.getId());
			notecust.setQuotno(dao.getQuotno());
			notecustbd.createOrUpdate(notecust, user);
		}

	}

	// sITT-201105-0001
	@SuppressWarnings("rawtypes")
	public void exchgRateUpd(Quohdr quohdr, User user) throws Exception {

		QuochargeBD chargebd = new QuochargeBD(
				this.getSessionFactoryClusterMap());
		QuocostBD costbd = new QuocostBD(this.getSessionFactoryClusterMap());
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuomovBD quomovbd = new QuomovBD(this.getSessionFactoryClusterMap());

		// charges
		for (Iterator it = quohdrbd.getQuocharges(quohdr.getId()).iterator(); it
				.hasNext();) {
			try {
				Quocharge charge = (Quocharge) it.next();
				double exchgrate = this.getExchgRate(charge.getCcykey(),
						quohdr.getCcykey(), quohdr.getExchgdate());
				charge.setXratebase(new BigDecimal(exchgrate));
				exchgrate = this.getExchgRate(charge.getCcykey(),
						charge.getInvoiceccykey(), quohdr.getExchgdate());
				charge.setXrateinv(new BigDecimal(exchgrate));
				chargebd.createOrUpdate(charge, user);
			} catch (Exception e) {
			}
		}

		// movement costs
		for (Iterator it = quohdrbd.getQuomovs(quohdr.getId()).iterator(); it
				.hasNext();) {
			Quomov quomov = (Quomov) it.next();
			// movement costs
			for (Iterator it2 = quomovbd.getQuocosts(quomov.getQuomovId())
					.iterator(); it2.hasNext();) {
				try {
					Quocost cost = (Quocost) it2.next();
					double exchgrate = this.getExchgRate(cost.getCcykey(),
							quohdr.getCcykey(), quohdr.getExchgdate());
					cost.setXrate(new BigDecimal(exchgrate));
					costbd.createOrUpdate(cost, user);
				} catch (Exception e) {
				}
			}
		}

		// header costs
		for (Iterator it = quohdrbd.getQuocosts(quohdr.getId()).iterator(); it
				.hasNext();) {
			try {
				Quocost cost = (Quocost) it.next();
				double exchgrate = this.getExchgRate(cost.getCcykey(),
						quohdr.getCcykey(), quohdr.getExchgdate());
				cost.setXrate(new BigDecimal(exchgrate));
				costbd.createOrUpdate(cost, user);
			} catch (Exception e) {
			}
		}

		// clear
		chargebd = null;
		costbd = null;
		quohdrbd = null;
		quomovbd = null;

	}

	public double getExchgRate(String fromccykey, String toccykey,
			Date exchgdate) throws Exception {

		double exchgrate = 1.0;
		CcyexBD ccyexbd = new CcyexBD(this.getSessionFactoryClusterMap());

		// process if input parameters found
		if (fromccykey != null && toccykey != null) {

			// init business delegate fields
			ListForm listForm = new ListForm();
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(fromccykey);
			listForm.setSearchString2(toccykey);
			listForm.setSearchDate1(exchgdate);
			listForm.setOrderBy("Exdate");
			listForm.setOrderByDesc("Desc");

			// Ccyex dao = null;
			try {
				exchgrate = ccyexbd.getExrate(listForm);
			} catch (Exception ae) {
			}

		}

		// clear
		ccyexbd = null;

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " getExchgRate: " + " fromccykey[" + fromccykey + "]"
				+ " toccykey[" + toccykey + "]" + " exchgdate[" + exchgdate
				+ "]" + " exchgrate[" + exchgrate + "]");

		return exchgrate;
	}
	// eITT-201105-0001

}
