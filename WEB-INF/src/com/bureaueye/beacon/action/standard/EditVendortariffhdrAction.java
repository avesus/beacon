package com.bureaueye.beacon.action.standard;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.standard.VendortariffhdrForm;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;



/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-16		ITT-200906-0004		Vendor Tariff Lump Sum Breakdown
 * 												
 *
 */
public final class EditVendortariffhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		VendortariffhdrForm hdrForm = (VendortariffhdrForm) form;

		String action = hdrForm.getAction();

		// If action isn't supplied then invalidate the session
		if (action == null) {
			log
					.error("VendortariffhdrForm not supplied for EditVendortariffhdrAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditVendortariffhdrAction:  Processing " + action
				+ " action");

		if (!(action == null || action.equals("Create"))) {

			Vendortariffhdr hdr = new VendortariffhdrBD(this.getSessionFactoryClusterMap())
					.read(hdrForm.getVendtarfhdrId());

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Vendortariffhdr id = "
					+ hdr.getVendtarfhdrId());
			if (hdr == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Vendortariffhdr found for customertariffhdr: "
						+ hdrForm.getVendtarfhdrId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", hdrForm
								.getVendtarfhdrId()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't copy: forwarding to: "
						+ mapping.findForward("failure"));
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating VendortariffhdrForm from "
					+ hdr);
			BeanUtils.copyProperties(hdrForm, hdr);

			if (action.equals("Copy")) {
				hdrForm.setVendtarfhdrId(null);
				hdrForm.setAction("Create");
			}
			
			
/*			//sITT-200906-0004
			// initialise lump sum breakdown details			
			List lumpsums = new VendortarifflumpsumBD(this.getSessionFactoryClusterMap())
			.findVendortarifflumpsumsById(hdr.getVendtarfhdrId(),"VendtarfhdrId2");				
			List<VendortarifflumpsumDTO> lumpsumDTOs = new ArrayList<VendortarifflumpsumDTO>();
			int row = 0;
			for (Iterator it = lumpsums.iterator(); it.hasNext();) {
				row++;
				VendortarifflumpsumDTO dto = new VendortarifflumpsumDTO();
				BeanUtils.copyProperties(dto, it.next());
				dto.setRow(new Integer(row).toString());
				
				// retrieve vendor tariff link details
				Vendortariffhdr hdr2=new VendortariffhdrBD(this.getSessionFactoryClusterMap()).read(dto.getVendtarfhdrId2());				
				dto.setCostkey(new CostBD(this.getSessionFactoryClusterMap()).read(hdr2.getCostkey()));
				dto.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr2.getVendoraddrkey()));
				dto.setLumpsum(new CurrencyFormatter().format(hdr2.getLumpsum()));
				lumpsumDTOs.add(dto);
			}			
			hdrForm.setList(lumpsumDTOs);
			// Reset the delete boxes
			hdrForm.setSelectedObjects(null);
			//eITT-200906-0004
*/			
			
		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
