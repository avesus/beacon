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
import com.bureaueye.beacon.form.standard.ListCustomertariffdtlForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Customertariffdtl;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.bd.CustomertariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;
import com.bureaueye.beacon.model.standard.dto.CustomertariffdtlDTO;
import com.bureaueye.beacon.model.standard.dto.CustomertariffhdrDTO;



public final class ListCustomertariffdtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the request is cancelled then return to the parent page
		if (isCancelled(request)) {
			return findFailure(mapping);
		}


		ListCustomertariffdtlForm listForm = (ListCustomertariffdtlForm) form;
		String action = listForm.getAction();


		ActionMessages appErrorMessages = null;
		ActionMessages appInformationMessages = null;

		//init bd
		CustomertariffhdrBD hdrbd = new CustomertariffhdrBD(this.getSessionFactoryClusterMap());
		CustomertariffdtlBD dtlbd = new CustomertariffdtlBD(this.getSessionFactoryClusterMap());


		// List all the Customertariffdtl records
		if (action == null || action.equals("List")) {

			// Get the Customer Tariff Header
			Customertariffhdr tariffhdr = hdrbd.read(listForm.getId());

			// If the Customer Tariff Header no longer exists then generate an
			// error and return to the parent
			if (tariffhdr == null) {
				return findFailure(mapping);
			}

			Customertariffhdr _dao=tariffhdr;
			CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 			
			listForm.setHeader(_dto);			

			List customertariffdtls = dtlbd.findCustomertariffdtlsByCusttarfhdrId(listForm.getId());

			List customertariffdtlDTOs = new ArrayList();
			int row = 0;
			for (Iterator it = customertariffdtls.iterator(); it.hasNext();) {
				row++;
				CustomertariffdtlDTO customertariffdtldto = new CustomertariffdtlDTO();
				BeanUtils.copyProperties(customertariffdtldto, it.next());
				customertariffdtldto.setRow(new Integer(row).toString());
				customertariffdtlDTOs.add(customertariffdtldto);
			}

			// Add a blank customertariffdtlDTO
			customertariffdtlDTOs.add(new CustomertariffdtlDTO());

			listForm.setList(customertariffdtlDTOs);

			// Reset the delete boxes
			listForm.setSelectedObjects(null);

			return mapping.findForward(Constants.LIST);

		} else if (action.equals("Delete")) {
			int[] selectedObjects = ((ListCustomertariffdtlForm) form)
			.getSelectedObjects();

			if (selectedObjects != null) {
				User user = (User) request.getSession().getAttribute(
						Constants.USER_KEY);
				for (int i = 0; i < selectedObjects.length; i++) {
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListCustomertariffdtlAction: Deleting: "
							+ selectedObjects[i]);
					dtlbd.delete(new Customertariffdtl(new Integer(
							selectedObjects[i])), user);
				}				
				appInformationMessages = new ActionMessages();
				appInformationMessages.add("messages.customertariffdtl",
						new ActionMessage(
						"information.delete"));
			}
		} else if (action.equals("Update")) {

			if ((((ListCustomertariffdtlForm) form).getList()) != null) {

				User user = (User) request.getSession().getAttribute(
						Constants.USER_KEY);

				for (Iterator it = ((ListCustomertariffdtlForm) form).getList()
						.iterator(); it.hasNext();) {

					// Mark a new Customer Tariff Detail record ready for
					// insertion
					CustomertariffdtlDTO customertariffdtldto = (CustomertariffdtlDTO) it
					.next();

					Customertariffdtl customertariffdtl = null;
					if (customertariffdtldto.getCusttarfdtlId().equals("")) {

						// Ignore the new customertariffdtl of all the values are
						// blank
						if (customertariffdtldto.getFromvalue().equals("")
								&& customertariffdtldto.getTovalue().equals("")
								&& customertariffdtldto.getLumpsum().equals("")
								&& customertariffdtldto.getUnitrate().equals("")) {
							continue;
						}
						customertariffdtl = new Customertariffdtl();
						customertariffdtl
						.setCusttarfhdrId(listForm
								.getId().toString());

					} else if (
							(customertariffdtl = dtlbd.read(new Integer(customertariffdtldto.getCusttarfdtlId()))) == null
					) {
						// Ignore a deleted customertariffdtl
						continue;
					}

					// Check that all the values are valid
					try {
						Integer.parseInt(customertariffdtldto.getFromvalue());
					} catch (NumberFormatException e) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.customertariffdtl",
								new ActionMessage(
										"error.fromvalue.required2", customertariffdtldto.getRow()));
						continue;
					}

					// Check that all the values are valid
					try {
						Integer.parseInt(customertariffdtldto.getTovalue());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.customertariffdtl",
								new ActionMessage(
										"error.tovalue.required2", customertariffdtldto.getRow()));
						continue;
					}

					// Check that all the values are valid
					try {
						Double.parseDouble(customertariffdtldto.getLumpsum());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.customertariffdtl",
								new ActionMessage(
										"error.lumpsum.required2", customertariffdtldto.getRow()));
						continue;
					}

					// Check that all the values are valid
					try {
						Double.parseDouble(customertariffdtldto.getUnitrate());
					} catch (NumberFormatException nfe) {
						// Add an error message if one of the numbers is crap
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.customertariffdtl",
								new ActionMessage(
										"error.unitrate.required2", customertariffdtldto.getRow()));
						continue;
					}

					if (Integer.parseInt(customertariffdtldto.getFromvalue()) >= Integer
							.parseInt(customertariffdtldto.getTovalue())) {
						// Add an error message
						appErrorMessages = new ActionMessages();
						appErrorMessages.add("errors.customertariffdtl",
								new ActionMessage(
										"error.tovalue.afterfromvalue2", customertariffdtldto.getRow()));
						continue;
					}

					// no errors found

					// copy details to data object 
					BeanUtils.copyProperties(customertariffdtl,
							customertariffdtldto);

					// If the vendtarfdtlid is not specified then set it to null
					// (transient state)
					if (customertariffdtldto.getCusttarfdtlId().equals("")) {
						customertariffdtl.setCusttarfdtlId(null);
					}

					// persist data object
					dtlbd.createOrUpdate(customertariffdtl, user);
					appInformationMessages = new ActionMessages();
					appInformationMessages.add("messages.customertariffdtl",
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


		//clear objects
		hdrbd = null;
		dtlbd = null;


		return findSuccess(mapping);
	}
}
