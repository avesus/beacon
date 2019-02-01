package com.bureaueye.beacon.action.salesinvoice;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.salesinvoice.SihdrForm;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;

import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Taxcode;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function
 * to Sales Invoice module (changes not commented)
 * 
 * NT 2014-06-06 201400025 Patch Fix for Order charge duplication problem
 * - Add Check to Sales Invoice Build and Delete process to check for Order charge duplications
 * 
 */
public final class SaveSihdrAction extends BaseAction {

	@SuppressWarnings("rawtypes")
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		SihdrForm saveForm = (SihdrForm) form;
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

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		// Generate Business Delegate
		SihdrBD bd = new SihdrBD(this.getSessionFactoryClusterMap());
		OrderchargeBD orderchargebd = new OrderchargeBD(
				this.getSessionFactoryClusterMap());
		SidtlBD sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;
		try {
			pk = new Integer(saveForm.getId());
		} catch (Exception e) {
		}
		// find data-access-object using primary key
		Sihdr dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Sihdr();
		}

		// error validation

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

		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {
			// set order charges back to blank invoice status
			if (!dao.isManualflag()) {// do not process if manual entry
				// loop all invoice detail lines
				List set = bd.getSidtls(dao.getSihdrId());
				if (set != null) {
					for (Iterator it = set.iterator(); it.hasNext();) {
						Sidtl sidtldao = (Sidtl) it.next();
						// find order charge record
						Ordercharge orderchargedao = orderchargebd
								.read(sidtldao.getOrderchargeId());
						if (orderchargedao != null) {
							// reset invoice status
							orderchargedao.setInvoicestatus("");
							orderchargedao.setSihdrId(null);//201400025		
							orderchargedao.setInvoiceno("");//201400025							
							orderchargebd.createOrUpdate(orderchargedao, user);
							
							//201400025
							log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
									" delete Sihdr - SihdrId: "+dao.getSihdrId()+
									"  / Processing Ordercharge reset - OrderchargeId: "+orderchargedao.getOrderchargeId()
									);
							
						}// check charge record found
					}// loop detail lines
				}
			}// manual check

			// delete invoice header and lines
			bd.deleteAll(dao.getSihdrId(), user);
		} else {

			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}

			// only process if NOT a copy function
			if (saveForm.getCopyId().equals("")) {
				// update invoice total on header
				// set invoice amount
				BigDecimal amount = new BigDecimal(0.0);
				try {
					amount = sidtlbd.sidtlsChgamtTotal(saveForm.getId());
				} catch (Exception e) {
				}
				if (amount == null)
					amount = new BigDecimal(0.0);
				dao.setInvoiceamt(amount);
				// set tax amount
				dao.setTaxamt(new BigDecimal(0.0));
				// ------------------------------------------------------------------->
				// get tax rate
				try {
					TaxcodeBD taxcodebd = new TaxcodeBD(
							this.getSessionFactoryClusterMap());
					Taxcode taxcode = taxcodebd
							.findTaxcodeByTaxcodekey(saveForm.getTaxcode());
					if (taxcode != null) {
						dao.setTaxamt(dao.getInvoiceamt()
								.multiply(taxcode.getRate())
								.divide(new BigDecimal(100)));
					}
					taxcodebd = null;
				} catch (Exception e) {
				}
				// ----------------------------------------------------------------->
				// only for create process
				if (action
						.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
					// init payment terms
					dao.setPaymentterm(addressbd.read(
							saveForm.getCustomeraddrkey()).getPaytermstext());
				}
			}// check if copy function

			//
			bd.createOrUpdate(dao, user);

			// process copy function - details
			if (!saveForm.getCopyId().equals("") && saveForm.getManualflag()) {
				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " SaveSihdrAction:  Processing copyToNew from id: "
						+ saveForm.getCopyId());
				Sihdr copydao = new SihdrBD(this.getSessionFactoryClusterMap())
						.read(new Integer(saveForm.getCopyId()));
				if (copydao != null) {
					copyToNew(copydao, dao, user);
				}
			}

			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName()))
					.setStartPage();

		}

		// clear bd
		bd = null;
		orderchargebd = null;
		sidtlbd = null;
		addressbd = null;

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to success page");
		return findSuccess(mapping);

	}

	@SuppressWarnings("rawtypes")
	public void copyToNew(Sihdr copydao, Sihdr dao, User user) throws Exception {
		try {
			SihdrBD hdrbd = new SihdrBD(this.getSessionFactoryClusterMap());
			SidtlBD dtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
			// copy and store charges
			for (Iterator it = hdrbd.getSidtls(copydao.getSihdrId()).iterator(); it
					.hasNext();) {
				Sidtl copyTo = new Sidtl();
				Sidtl copyFrom = (Sidtl) it.next();
				copyTo.setUnits(copyFrom.getUnits());
				copyTo.setUname(copyFrom.getUname());				
				copyTo.setCcykey(copyFrom.getCcykey());
				copyTo.setInvoiceccykey(copyFrom.getInvoiceccykey());
				copyTo.setChargekey(copyFrom.getChargekey());
				copyTo.setChgamt(copyFrom.getChgamt());
				copyTo.setInvoiceamt(copyFrom.getInvoiceamt());
				copyTo.setChargetype(copyFrom.getChargetype());
				copyTo.setRate(copyFrom.getRate());
				copyTo.setTxt1(copyFrom.getTxt1());
				copyTo.setTxt2(copyFrom.getTxt2());
				copyTo.setXratebase(copyFrom.getXratebase());
				copyTo.setXrateinv(copyFrom.getXrateinv());
				copyTo.setTaxamt(copyFrom.getTaxamt());
				copyTo.setTaxcode(copyFrom.getTaxcode());				
				copyTo.setAdddata1(copyFrom.getAdddata1());
				copyTo.setAdddata2(copyFrom.getAdddata2());
				copyTo.setAdddata3(copyFrom.getAdddata3());
				copyTo.setAdddata4(copyFrom.getAdddata4());
				copyTo.setAdddata5(copyFrom.getAdddata5());
				copyTo.setAdddata6(copyFrom.getAdddata6());
				copyTo.setAdddata7(copyFrom.getAdddata7());
				copyTo.setAdddata8(copyFrom.getAdddata8());
				copyTo.setAdddata9(copyFrom.getAdddata9());
				copyTo.setAdddata10(copyFrom.getAdddata10());
				copyTo.setSidtlId(null);
				copyTo.setSihdrId(dao.getSihdrId());
				dtlbd.createOrUpdate(copyTo, user);
			}
			hdrbd = null;
			dtlbd = null;
		} catch (Exception e) {
		}
	}

}
