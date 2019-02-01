package com.bureaueye.beacon.action.salesinvoice;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.salesinvoice.SidtlForm;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function
 * to Sales Invoice module
 * 
 */
public final class EditSidtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SidtlForm editForm = (SidtlForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		Sidtl dto = null;

		if (!(action == null || action
				.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {

			dto = new SidtlBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getSidtlId()));

			if (dto == null) {
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " No Record found for hdrId: "
						+ editForm.getSihdrId() + ", " + "dtlid: "
						+ editForm.getSidtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getSihdrId() + " - "
								+ editForm.getSidtlId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}

			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setSidtlId("");
				editForm.setPrintedflag(false);
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action = com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}

		}

		// set header information
		Sihdr hdr = new SihdrBD(this.getSessionFactoryClusterMap())
				.read(new Integer(editForm.getSihdrId()));
		if (hdr != null)
			editForm.setBaseccykey(hdr.getInvoiceccykey());

		// set defaults for Create process
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {

			// default user information
			if (hdr != null) {
				editForm.setInvoiceccykey(hdr.getInvoiceccykey());
				editForm.setCcykey(hdr.getInvoiceccykey());
				editForm.setOrderno(hdr.getOrderno());
				editForm.setInvoiceref(hdr.getInvoiceref());
				editForm.setInvoicegroupref(hdr.getInvoicegroupref());
				editForm.setTaxcode(hdr.getTaxcode());
			}

			editForm.setXratebase("1.0");
			editForm.setXrateinv("1.0");

		}

		// Forward control to the edit page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
