package com.bureaueye.beacon.action.salesinvoice;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrderhdrchargeDTO;
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
 * NT 2014-03-12 201400010 Fix Tax and Invoice amount totalling
 * 
 * NT 2014-06-06 201400025 Patch Fix for Order charge duplication problem
 * - Add Check to Sales Invoice Build and Delete process to check for Order charge duplications
 * 
 */
public final class SaveSalesinvoicebuildAction extends BaseAction {

	@SuppressWarnings("rawtypes")
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ListForm saveForm = (ListForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();

		// If the session has timed-out then take the user back to the login
		// page
		if (session == null || user == null) {
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

		// validation

		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, messages);
			return (mapping.getInputForward());
		}

		// get selected rows
		int[] selectedObjects = saveForm.getSelectedObjects();
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		if (selectedObjects != null) {
			for (int i = 0; i < selectedObjects.length; i++) {
				tm.put(new Integer(selectedObjects[i]), new Integer(
						selectedObjects[i]));
			}
		}

		// validation
		// for Group Invoices
		if (!saveForm.getSearchString7().equals("")) {
			boolean processOnce = false;
			String groupCustomer = "";
			String groupCcy = "";
			int row = 0;
			for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {
				row++;
				// get row
				OrderhdrchargeDTO dto = (OrderhdrchargeDTO) it.next();

				// selected
				if (tm.get(dto.getOrderchargeId()) != null) {

					// store customer and invoice ccy if first row
					if (!processOnce) {
						// store fields
						groupCustomer = dto.getCustomeraddrkey();
						groupCcy = dto.getInvoiceccykey();
						processOnce = true;
						continue;
					}

					// check customers and ccy are same for each Group row
					if (!groupCustomer.equals(dto.getCustomeraddrkey())) {
						// Add an error message
						appErrorMessages.add("errors.salesinvoicebuild",
								new ActionMessage("error.billingaccount.isnot",
										new Integer(row).toString(),
										groupCustomer));
					}
					if (!groupCcy.equals(dto.getInvoiceccykey())) {
						// Add an error message
						appErrorMessages.add("errors.salesinvoicebuild",
								new ActionMessage("error.invoiceccy.isnot",
										new Integer(row).toString(), groupCcy));
					}

				} // selected check
			} // lineitem iterator
		} // group invoice

		// update - if no error messages
		if (appErrorMessages.isEmpty()) {
			// init buisness delegates
			OrderchargeBD _orderchargeBD = new OrderchargeBD(
					this.getSessionFactoryClusterMap());
			OrderhdrBD _orderhdrBD = new OrderhdrBD(
					this.getSessionFactoryClusterMap());
			SihdrBD _sihdrBD = new SihdrBD(this.getSessionFactoryClusterMap());
			SidtlBD _sidtlBD = new SidtlBD(this.getSessionFactoryClusterMap());
			AddressBD _addressBD = new AddressBD(
					this.getSessionFactoryClusterMap());
			TaxcodeBD taxcodebd = new TaxcodeBD(
					this.getSessionFactoryClusterMap());

			// double taxamt = 0.0;//201400010
			BigDecimal taxamt = new BigDecimal(0.0);// 201400010

			// for Group Invoices
			if (!saveForm.getSearchString7().equals("")) {
				boolean processOnce = false;

				// double invoiceamt = 0.0;//201400010
				BigDecimal invoiceamt = new BigDecimal(0.0);// 201400010

				// create dto for invoice header
				Sihdr sihdr = null;
				Sidtl sidtl = null;
				String taxcode = "";

				for (Iterator it = saveForm.getLineItems().iterator(); it
						.hasNext();) {
					// get row
					OrderhdrchargeDTO dto = (OrderhdrchargeDTO) it.next();

					// selected
					if (tm.get(dto.getOrderchargeId()) != null) {

						// store customer and invoice ccy if first row
						if (!processOnce) {
							// store fields
							processOnce = true;

							// required data
							Orderhdr orderhdr = null;
							try {
								orderhdr = _orderhdrBD
										.read(dto.getOrderhdrId());
							} catch (ApplicationException ae) {
							}

							// init header fields
							sihdr = new Sihdr();
							sihdr.setInvoicegroupref(saveForm
									.getSearchString7());
							sihdr.setInvoiceref("");
							sihdr.setInvoiceno("");
							sihdr.setCompanykey(orderhdr.getCompanykey());
							sihdr.setDepartmentkey(orderhdr.getDepartmentkey());
							sihdr.setActivitykey(orderhdr.getActivitykey());
							sihdr.setInvoiceccykey(dto.getInvoiceccykey());
							sihdr.setCustomeraddrkey(dto.getCustomeraddrkey());
							sihdr.setBatchId(0);
							sihdr.setTxt1("");
							sihdr.setTxt2("");

							sihdr.setCustomerref("");
							if (orderhdr != null) {
								sihdr.setCustomerref(orderhdr.getCustomerref());
							}

							// sihdr.setInvoiceamt(dto.getChgamtinv());
							sihdr.setOrderno(dto.getOrderno());
							sihdr.setPaymentterm(_addressBD.read(
									dto.getCustomeraddrkey()).getPaytermstext());

							// update header
							_sihdrBD.createOrUpdate(sihdr, user);
						}

						// create dto for invoice detail
						sidtl = new Sidtl();
						sidtl.setSihdrId(sihdr.getSihdrId());

						Ordercharge ordercharge = null;
						try {
							ordercharge = _orderchargeBD.read(dto
									.getOrderchargeId());
						} catch (ApplicationException ae) {
						}

						// init detail fields
						sidtl.setInvoicegroupref(saveForm.getSearchString7());
						sidtl.setInvoiceref("");
						sidtl.setCcykey(dto.getCcykey());
						sidtl.setChgamt(dto.getChgamt());
						sidtl.setOrderno(dto.getOrderno());
						sidtl.setChargekey(dto.getChargekey());
						sidtl.setChargetype(ordercharge.getChargetype());
						sidtl.setRate(ordercharge.getRate());
						sidtl.setTxt1(ordercharge.getTxt1());
						sidtl.setTxt2(ordercharge.getTxt2());
						sidtl.setUname(ordercharge.getUname());
						sidtl.setUnits(ordercharge.getUnits());
						sidtl.setXratebase(ordercharge.getXratebase());
						sidtl.setXrateinv(ordercharge.getXrateinv());
						sidtl.setInvoiceccykey(ordercharge.getInvoiceccykey());
						sidtl.setInvoiceamt(dto.getChgamtinv());
						sidtl.setOrderhdrId(dto.getOrderhdrId());
						sidtl.setOrderchargeId(ordercharge.getOrderchargeId());

						// ------------------------------------------------------------------->
						taxcode = ordercharge.getTaxcode();
						sidtl.setTaxcode(taxcode);
						// get tax rate
						Taxcode taxcodedao = null;
						try {
							taxcodedao = taxcodebd
									.findTaxcodeByTaxcodekey(sidtl.getTaxcode());
						} catch (ApplicationException ae) {
						}
						sidtl.setTaxamt(new BigDecimal(0.0));
						if (taxcode != null) {
							try {
								sidtl.setTaxamt(sidtl.getInvoiceamt()
										.multiply(taxcodedao.getRate())
										.divide(new BigDecimal(100)));
							} catch (Exception e) {
							}
						}

						// taxamt =
						// taxamt+sidtl.getTaxamt().doubleValue();//201400010
						try {
							taxamt = taxamt.add(sidtl.getTaxamt());
						} catch (Exception e) {
						}// 201400010

						// ----------------------------------------------------------------->

						// invoiceamt =
						// invoiceamt+sidtl.getInvoiceamt().doubleValue();//201400010
						try {
							invoiceamt = invoiceamt.add(sidtl.getInvoiceamt());
						} catch (Exception e) {
						}// 201400010

						// update details
						_sidtlBD.createOrUpdate(sidtl, user);

						// update charge
						ordercharge.setInvoicestatus("CREATED");
						ordercharge.setSihdrId(sihdr.getSihdrId());
						_orderchargeBD.createOrUpdate(ordercharge, user);

						//201400025
						log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
								" build Sihdr - SihdrId: "+sihdr.getSihdrId()+
								"  / Processing Ordercharge init - OrderchargeId: "+ordercharge.getOrderchargeId()
								);
						
					} // selected check
				} // lineitem iterator

				if (sihdr != null) {

					// sihdr.setInvoiceamt(new
					// BigDecimal(invoiceamt));//201400010
					// sihdr.setTaxamt(new BigDecimal(taxamt));//201400010
					sihdr.setInvoiceamt(invoiceamt);// 201400010
					sihdr.setTaxamt(taxamt);// 201400010

					sihdr.setTaxcode(taxcode);
					// update header
					_sihdrBD.createOrUpdate(sihdr, user);

					// Add information message
					appInformationMessages
							.add("messages.salesinvoicebuild",
									new ActionMessage(
											"information.salesinvoicebuild.groupcreate",
											saveForm.getSearchString7()));
				}
			} // group invoice

			// for Single Invoices
			if (saveForm.getSearchString7().equals("")) {
				int row = 0;
				for (Iterator it = saveForm.getLineItems().iterator(); it
						.hasNext();) {
					// get row
					OrderhdrchargeDTO dto = (OrderhdrchargeDTO) it.next();

					// selected
					if (tm.get(dto.getOrderchargeId()) != null) {
						row++;
						// create dto for invoice header
						Sihdr sihdr = new Sihdr();
						// create dto for invoice detail
						Sidtl sidtl = new Sidtl();

						// required data
						Orderhdr orderhdr = null;
						try {
							orderhdr = _orderhdrBD.read(dto.getOrderhdrId());
						} catch (ApplicationException ae) {
						}
						Ordercharge ordercharge = null;
						try {
							ordercharge = _orderchargeBD.read(dto
									.getOrderchargeId());
						} catch (ApplicationException ae) {
						}

						// init header fields
						sihdr.setInvoicegroupref("");
						sihdr.setInvoiceref(orderhdr.getOrderno());
						sihdr.setInvoiceno("");
						sihdr.setCompanykey(user.getCompanykey());
						sihdr.setDepartmentkey(user.getDepartmentkey());
						sihdr.setActivitykey(user.getActivitykey());
						sihdr.setInvoiceccykey(dto.getInvoiceccykey());
						sihdr.setCustomeraddrkey(dto.getCustomeraddrkey());
						sihdr.setTxt1("");
						sihdr.setTxt2("");

						sihdr.setCustomerref("");
						if (orderhdr != null) {
							sihdr.setCustomerref(orderhdr.getCustomerref());
						}

						sihdr.setInvoiceamt(dto.getChgamtinv());
						sihdr.setOrderno(dto.getOrderno());
						sihdr.setPaymentterm(_addressBD.read(
								dto.getCustomeraddrkey()).getPaytermstext());

						// init detail fields
						sidtl.setInvoicegroupref("");
						sidtl.setInvoiceref(orderhdr.getOrderno());
						sidtl.setCcykey(dto.getCcykey());
						sidtl.setChgamt(dto.getChgamt());
						sidtl.setOrderno(dto.getOrderno());
						sidtl.setChargekey(dto.getChargekey());
						sidtl.setChargetype(ordercharge.getChargetype());
						sidtl.setRate(ordercharge.getRate());
						sidtl.setTxt1(ordercharge.getTxt1());
						sidtl.setTxt2(ordercharge.getTxt2());
						sidtl.setUname(ordercharge.getUname());
						sidtl.setUnits(ordercharge.getUnits());
						sidtl.setXratebase(ordercharge.getXratebase());
						sidtl.setXrateinv(ordercharge.getXrateinv());
						sidtl.setInvoiceccykey(ordercharge.getInvoiceccykey());
						sidtl.setInvoiceamt(dto.getChgamtinv());
						sidtl.setOrderhdrId(dto.getOrderhdrId());
						sidtl.setOrderchargeId(ordercharge.getOrderchargeId());

						// ------------------------------------------------------------------->
						sidtl.setTaxcode(ordercharge.getTaxcode());
						// get tax rate
						Taxcode taxcode = null;
						try {
							taxcode = taxcodebd.findTaxcodeByTaxcodekey(sidtl
									.getTaxcode());
						} catch (ApplicationException ae) {
						}
						sidtl.setTaxamt(new BigDecimal(0.0));
						if (taxcode != null) {
							try {
								sidtl.setTaxamt(sidtl.getInvoiceamt()
										.multiply(taxcode.getRate())
										.divide(new BigDecimal(100)));
							} catch (Exception e) {
							}
						}
						// taxamt =
						// taxamt+sidtl.getTaxamt().doubleValue();//201400010
						try {
							taxamt = taxamt.add(sidtl.getTaxamt());
						} catch (Exception e) {
						}// 201400010
						// ----------------------------------------------------------------->
						// sihdr.setTaxamt(new BigDecimal(taxamt));//201400010
						sihdr.setTaxamt(taxamt);// 201400010

						// update header
						_sihdrBD.createOrUpdate(sihdr, user);

						// update details
						sidtl.setSihdrId(sihdr.getSihdrId());
						_sidtlBD.createOrUpdate(sidtl, user);

						// update charge
						ordercharge.setInvoicestatus("CREATED");
						ordercharge.setSihdrId(sihdr.getSihdrId());
						_orderchargeBD.createOrUpdate(ordercharge, user);

						/*
						 * // Add invformation message
						 * appInformationMessages.add(
						 * "messages.salesinvoicebuild", new ActionMessage(
						 * "information.salesinvoicebuild.create", new
						 * Integer(row).toString() ) );
						 */

					} // selected check
				} // lineitem iterator

				if (row > 0) {
					// Add invformation message
					appInformationMessages.add("messages.salesinvoicebuild",
							new ActionMessage(
									"information.salesinvoicebuild.create",
									new Integer(row).toString()));
				}

			} // single invoice

			// clear buisness delegates
			_orderchargeBD = null;
			_orderhdrBD = null;
			_sihdrBD = null;
			_sidtlBD = null;
			_addressBD = null;
			taxcodebd = null;

		} // no errors check

		saveForm.setSearchString7(""); // reset Group ref

		// Report any errors back to the original form
		if (!appErrorMessages.isEmpty()) {
			saveAppErrorMessages(request, appErrorMessages);
		} else {
			// Report any information back to the original form
			if (!appInformationMessages.isEmpty()) {
				saveAppInformationMessages(request, appInformationMessages);
			}
		}

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to success page");
		return findSuccess(mapping);

	}

}
