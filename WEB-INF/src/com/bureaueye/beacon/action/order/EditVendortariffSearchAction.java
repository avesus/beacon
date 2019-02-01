package com.bureaueye.beacon.action.order;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.PopupBaseAction;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdermovBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;

public final class EditVendortariffSearchAction extends PopupBaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListForm vendortariffsearchForm = (ListForm) form;

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " EditVendortariffSearchAction: "
				+ vendortariffsearchForm.getId());

		Vendortariffhdr vendortariffhdr = new VendortariffhdrBD(
				this.getSessionFactoryClusterMap()).read(vendortariffsearchForm
				.getId());

		if (vendortariffhdr == null) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " No Vendor Tariff Header found for ID "
					+ vendortariffsearchForm.getId());

			// initialise parameters
			Ordermov mov = null;
			Orderhdr hdr = null;
			Orderprod orderprod = null;
			Product product = null;
			OrderhdrBD hdrbd = new OrderhdrBD(
					this.getSessionFactoryClusterMap());
			OrdermovBD movbd = new OrdermovBD(
					this.getSessionFactoryClusterMap());
			OrderprodBD orderprodbd = new OrderprodBD(
					this.getSessionFactoryClusterMap());
			ProductBD productbd = new ProductBD(
					this.getSessionFactoryClusterMap());

			// init locations
			vendortariffsearchForm.setSearchString3("");
			vendortariffsearchForm.setSearchString4("");
			vendortariffsearchForm.setSearchString5("");
			try {
				mov = movbd.read(new Integer(vendortariffsearchForm
						.getSearchString8()));
			} catch (Exception e) {
			}
			if (mov != null) {
				hdr = hdrbd.read(mov.getOrderhdrId());
				vendortariffsearchForm.setSearchString3(mov
						.getFromlocationkey());
				vendortariffsearchForm.setSearchString4(mov.getTolocationkey());
			} else {
				try {
					hdr = hdrbd.read(new Integer(vendortariffsearchForm
							.getSearchString11()));
				} catch (Exception e) {
				}
			}

			vendortariffsearchForm.setSearchString6("");
			vendortariffsearchForm.setSearchString12("");
			if (hdr != null) {
				// vendortariffsearchForm.setSearchString6(quohdr.getProductkey());
				// find product to init producthazardous
				try {
					orderprod = orderprodbd.findFirstOrderprodByOrderhdrId(hdr
							.getId());
					product = productbd.read(orderprod.getProductkey());
					if (product.isHazardous())
						vendortariffsearchForm.setSearchString12("Y");
					if (!product.isHazardous())
						vendortariffsearchForm.setSearchString12("N");
				} catch (Exception e) {
				}
			}
			vendortariffsearchForm.setSearchDate1(new Date());

			// clear
			hdrbd = null;
			movbd = null;
			orderprodbd = null;
			productbd = null;

		} else {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Populating Form from "
					+ vendortariffhdr);
			vendortariffsearchForm.setStartPage();
			vendortariffsearchForm.setSearchString1(vendortariffhdr
					.getVendoraddrkey());
			vendortariffsearchForm.setSearchString2(vendortariffhdr
					.getCostkey());
			// vendortariffsearchForm.setSearchString3(vendortariffhdr.getFromlocationkey().getLocationkey());
			// vendortariffsearchForm.setSearchString4(vendortariffhdr.getTolocationkey().getLocationkey());
			// vendortariffsearchForm.setSearchString5(vendortariffhdr.getTslocationkey().getLocationkey());
			// vendortariffsearchForm.setSearchString6(vendortariffhdr.getProductkey());
			vendortariffsearchForm
					.setSearchString7(vendortariffhdr.getCcykey());
			vendortariffsearchForm.setSearchDate1(vendortariffhdr.getValidto());
		}

		// Forward control to the edit page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}
}
