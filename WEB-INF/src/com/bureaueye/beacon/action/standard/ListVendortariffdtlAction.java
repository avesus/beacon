package com.bureaueye.beacon.action.standard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.bureaueye.beacon.form.standard.ListVendortariffdtlForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.VendortariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;
import com.bureaueye.beacon.model.standard.dto.VendortariffdtlDTO;
import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;

public final class ListVendortariffdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the request is cancelled then return to the parent page
		if (isCancelled(request)) {
			return findFailure(mapping);
		}
		
		
		ListVendortariffdtlForm listvendortariffdtlform = (ListVendortariffdtlForm) form;
		String action = listvendortariffdtlform.getAction();

		
		ActionMessages appErrorMessages = null;
		ActionMessages appInformationMessages = null;
		
		
		// List all the Vendortariffdtl records
		if (action == null || action.equals("List")) {

			// Get the Vendor Tariff Header
			Vendortariffhdr vendortariffhdr = new VendortariffhdrBD(this.getSessionFactoryClusterMap())
					.read(listvendortariffdtlform.getId());
			
			// If the Vendor Tariff Header no longer exists then generate an
			// error and return to the parent
			if (vendortariffhdr == null) {
				return findFailure(mapping);
			}
			
			Vendortariffhdr _dao=vendortariffhdr;
			VendortariffhdrDTO _dto=new VendortariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 			
			listvendortariffdtlform.setHeader(_dto);
			
			List vendortariffdtls = new VendortariffdtlBD(this.getSessionFactoryClusterMap())
					.findVendortariffdtlsByVendtarfhdrId(listvendortariffdtlform
							.getId());

			List vendortariffdtlDTOs = new ArrayList();
			int row = 0;
			for (Iterator it = vendortariffdtls.iterator(); it.hasNext();) {
				row++;
				VendortariffdtlDTO vendortariffdtldto = new VendortariffdtlDTO();
				BeanUtils.copyProperties(vendortariffdtldto, it.next());
				vendortariffdtldto.setRow(new Integer(row).toString());
				vendortariffdtlDTOs.add(vendortariffdtldto);
			}

			// Add a blank vendortariffdtlDTO
			vendortariffdtlDTOs.add(new VendortariffdtlDTO());

			listvendortariffdtlform.setList(vendortariffdtlDTOs);

			// Reset the delete boxes
			listvendortariffdtlform.setSelectedObjects(null);

			return mapping.findForward(Constants.LIST);

		} else if (action.equals("Delete")) {
			int[] selectedObjects = ((ListVendortariffdtlForm) form)
					.getSelectedObjects();

			if (selectedObjects != null) {
				User user = (User) request.getSession().getAttribute(
						Constants.USER_KEY);
				VendortariffdtlBD vendortariffdtlbd = new VendortariffdtlBD(this.getSessionFactoryClusterMap());
				for (int i = 0; i < selectedObjects.length; i++) {
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListVendortariffdtlAction: Deleting: "
							+ selectedObjects[i]);
					vendortariffdtlbd.delete(new Vendortariffdtl(new Integer(
							selectedObjects[i])), user);
				}				
				appInformationMessages = new ActionMessages();
				appInformationMessages.add("messages.vendortariffdtl",
						new ActionMessage(
								"information.delete"));
			}
		} else if (action.equals("Update")) {

			VendortariffdtlBD vendortariffdtlbd = new VendortariffdtlBD(this.getSessionFactoryClusterMap());

			if ((((ListVendortariffdtlForm) form).getList()) != null) {
				
				User user = (User) request.getSession().getAttribute(
						Constants.USER_KEY);
				
				for (Iterator it = ((ListVendortariffdtlForm) form).getList()
						.iterator(); it.hasNext();) {

					// Mark a new Vendor Tariff Detail record ready for
					// insertion
					VendortariffdtlDTO vendortariffdtldto = (VendortariffdtlDTO) it
							.next();

					Vendortariffdtl vendortariffdtl = null;
					if (vendortariffdtldto.getVendtarfdtlId().equals("")) {

						// Ignore the new vendortariffdtl of all the values are
						// blank
						if (vendortariffdtldto.getFromvalue().equals("")
								&& vendortariffdtldto.getTovalue().equals("")
								&& vendortariffdtldto.getLumpsum().equals("")
								&& vendortariffdtldto.getUnitrate().equals("")) {
							continue;
						}
						vendortariffdtl = new Vendortariffdtl();
						vendortariffdtl
								.setVendtarfhdrId(listvendortariffdtlform
										.getId().toString());

					} else if ((vendortariffdtl = vendortariffdtlbd
							.read(new Integer(vendortariffdtldto
									.getVendtarfdtlId()))) == null) {
						// Ignore a deleted vendortariffdtl
						continue;
					}

					// Check that all the values are valid
					try {
						Integer.parseInt(vendortariffdtldto.getFromvalue());
					} catch (NumberFormatException e) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.vendortariffdtl",
								new ActionMessage(
										"error.fromvalue.required2", vendortariffdtldto.getRow()));
						continue;
					}

					// Check that all the values are valid
					try {
						Integer.parseInt(vendortariffdtldto.getTovalue());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.vendortariffdtl",
								new ActionMessage(
										"error.tovalue.required2", vendortariffdtldto.getRow()));
						continue;
					}
					
					// Check that all the values are valid
					try {
						Double.parseDouble(vendortariffdtldto.getLumpsum());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.vendortariffdtl",
								new ActionMessage(
										"error.lumpsum.required2", vendortariffdtldto.getRow()));
						continue;
					}
					
					// Check that all the values are valid
					try {
						Double.parseDouble(vendortariffdtldto.getUnitrate());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.vendortariffdtl",
								new ActionMessage(
										"error.unitrate.required2", vendortariffdtldto.getRow()));
						continue;
					}
					
					if (Integer.parseInt(vendortariffdtldto.getFromvalue()) >= Integer
							.parseInt(vendortariffdtldto.getTovalue())) {
						// Add an error message
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.vendortariffdtl",
								new ActionMessage(
										"error.tovalue.afterfromvalue2", vendortariffdtldto.getRow()));
						continue;
					}
					
					// no errors found
					
					// copy details to data object 
					BeanUtils.copyProperties(vendortariffdtl,
							vendortariffdtldto);

					// If the vendtarfdtlid is not specified then set it to null
					// (transient state)
					if (vendortariffdtldto.getVendtarfdtlId().equals("")) {
						vendortariffdtl.setVendtarfdtlId(null);
					}

					// persist data object
					vendortariffdtlbd.createOrUpdate(vendortariffdtl, user);
					appInformationMessages = new ActionMessages();
					appInformationMessages.add("messages.vendortariffdtl",
							new ActionMessage(
									"information.update"));
				} // list iterator
				
			}

		}
		
		if (appErrorMessages != null) {
			saveAppErrorMessages(request, appErrorMessages);
		} else {
			if (appInformationMessages != null) {
				saveAppInformationMessages(request, appInformationMessages);
			}					
		}
		
		return findSuccess(mapping);
	}
}
