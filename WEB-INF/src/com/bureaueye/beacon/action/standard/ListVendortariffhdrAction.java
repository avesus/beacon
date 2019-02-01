package com.bureaueye.beacon.action.standard;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.standard.ListVendortariffhdrForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;

import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.VendortariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;
import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;
import com.bureaueye.beacon.util.Util;




/**
 *
 * Amendments
 * ----------
 *   	 											
 *
 */
public final class ListVendortariffhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();


		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" actionFormName = " + actionFormName + "\t Mapping = "
					+ mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}


		ListVendortariffhdrForm listForm = (ListVendortariffhdrForm) form;
		String action = listForm.getAction();
		listForm.setAction("");


		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();


		// update list if action selected
		if (action != null && action.equals("Update")) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" updateButton pressed");

			//init business delegates
			VendortariffhdrBD vendortariffhdrbd = new VendortariffhdrBD(this.getSessionFactoryClusterMap());
			VendortariffdtlBD vendortariffdtlbd = new VendortariffdtlBD(this.getSessionFactoryClusterMap());

			int addRecord=0;
			int updateRecord=0;
			int errorRecord=0;
			if (listForm.getList() != null) {

				User user = (User) request.getSession().getAttribute(Constants.USER_KEY);

				IN_LOOP1:
					for (Iterator it = listForm.getList().iterator(); it.hasNext();) {

						VendortariffhdrDTO dto = (VendortariffhdrDTO) it.next();
						Vendortariffhdr fromVendortariffhdr = null;
						Vendortariffhdr toVendortariffhdr = null;							
						List vendortariffdtls = null; 

						if (!dto.getVendtarfhdrId().equals("")) {

							//convert to upper case
							dto.setVendtarfhdrId(dto.getVendtarfhdrId().toUpperCase());

							
							// Check valid from date entered
							try {
								if (
										dto.getValidfromdd().equals("") ||
										dto.getValidfrommm().equals("") ||
										dto.getValidfromyyyy().equals("")
								) {
									appErrorMessages.add("errors.vendortariffhdr",
											new ActionMessage(
													"error.validfrom.required2", dto.getRow()));
									errorRecord++;									
									continue IN_LOOP1;								
								}
							} catch (Exception e) {
							}

							// Check valid to date entered
							try {
								if (
										dto.getValidtodd().equals("") ||
										dto.getValidtomm().equals("") ||
										dto.getValidtoyyyy().equals("")
								) {
									appErrorMessages.add("errors.vendortariffhdr",
											new ActionMessage(
													"error.validto.required2", dto.getRow()));
									errorRecord++;									
									continue IN_LOOP1;								
								}
							} catch (Exception e) {
							}

							// Check that all the values are valid
							try {
								Double.parseDouble(dto.getLumpsum().toString());
							} catch (Exception nfe) {
								// Add an error message if one of the numbers is crap
								appErrorMessages.add("errors.vendortariffhdr",
										new ActionMessage(
												"error.lumpsum.required2", dto.getRow()));
								errorRecord++;
								continue IN_LOOP1;
							}

							

							//only process if no errors found
							
							
							//check new 
							if (!dto.getVendtarfhdrId().equals(dto.getVendtarfhdrId2())) {

								//check valid chars
								if (Util.invalidChars(dto.getVendtarfhdrId())) {
									// Add an error message if invalid characters entered in id
									appErrorMessages.add("errors.vendortariffhdr",
											new ActionMessage(
													"error.code.invalidchars", dto.getRow()));
									errorRecord++;
									continue IN_LOOP1;								
								}
								
								//check new code is unique
								Vendortariffhdr checkVendortariffhdr = vendortariffhdrbd.read(dto.getVendtarfhdrId());
								if (checkVendortariffhdr!=null) {
									// Add an error message
									appErrorMessages.add("errors.vendortariffhdr",
											new ActionMessage(
													"error.code.unique2", dto.getRow()));
									errorRecord++;
									continue IN_LOOP1;								
								}
								
								//increment add record
								addRecord++;

								//retrieve detail records to copy to new header record
								vendortariffdtls = vendortariffdtlbd.findVendortariffdtlsByVendtarfhdrId(dto.getVendtarfhdrId2());

							} else {

								//increment update
								updateRecord++;

							}



							try {
								//set records
								fromVendortariffhdr = vendortariffhdrbd.read(dto.getVendtarfhdrId2());
								toVendortariffhdr = vendortariffhdrbd.read(dto.getVendtarfhdrId());
								if (toVendortariffhdr==null)toVendortariffhdr = new Vendortariffhdr();	

								//copy all details
								BeanUtils.copyProperties(toVendortariffhdr,fromVendortariffhdr);

								//copy screen details
								toVendortariffhdr.setVendtarfhdrId(dto.getVendtarfhdrId());
								toVendortariffhdr.setValidfrom(dto.getValidfrom());
								toVendortariffhdr.setValidto(dto.getValidto());		
								toVendortariffhdr.setLumpsum(new BigDecimal(dto.getLumpsum()));	
								//toVendortariffhdr.setUnittype(dto.getUnittype());
								toVendortariffhdr.setProducthazardous(dto.getProducthazardous());	
								toVendortariffhdr.setNote1(dto.getNote1());
								toVendortariffhdr.setNote2(dto.getNote2());

								//persist header data object
								vendortariffhdrbd.createOrUpdate(toVendortariffhdr, user);
								
								//persist details only if add
								if (vendortariffdtls!=null) {
									for (Iterator it2 = vendortariffdtls.iterator(); it2.hasNext();) {
										Vendortariffdtl vendortariffdtl = new Vendortariffdtl();
										BeanUtils.copyProperties(vendortariffdtl, it2.next());
										vendortariffdtl.setVendtarfhdrId(toVendortariffhdr.getVendtarfhdrId());
										vendortariffdtl.setVendtarfdtlId(null);										
										vendortariffdtlbd.createOrUpdate(vendortariffdtl, user);
									}
								}
							} catch (Exception e) {
							}

						}//check ID entered

					}//list iterator

				//IN_LOOP1

				//clear objects
				vendortariffhdrbd = null;
				vendortariffdtlbd = null;

			}//check list has records


			//init information message
			appInformationMessages.add("messages.vendortariffhdr",
					new ActionMessage(
							"information.update2", updateRecord));
			appInformationMessages.add("messages.vendortariffhdr",
					new ActionMessage(
							"information.add2", addRecord));
			appInformationMessages.add("messages.vendortariffhdr",
					new ActionMessage(
							"information.error2", errorRecord));			

		}//check update action





		// Calculate the total number of results before any buttons are 
		// generated and default values
		setTotalResults(listForm);

		// Calculate the total number of results before any buttons are
		// generated and default values from SESSION 
		setTotalResults(listForm, session);



		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+ " ListForm Parameters = "+listForm.toString()
		);


		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}



		if (appErrorMessages.size()>0) {
			saveAppErrorMessages(request, appErrorMessages);
		} 
		if (appInformationMessages.size()>0) {
			saveAppInformationMessages(request, appInformationMessages);
		}					



		// Forward control to the edit user registration page
		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath()
		);

		return findSuccess(mapping);
	}



	public void setTotalResults(ListVendortariffhdrForm listForm) throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("vendortariffhdr.VendtarfhdrId");
		}

		// order by sequence
		listForm.setOrderByDesc("");


		// active/expired 
		if (listForm.getSearchString15() == null || listForm.getSearchString15().equals("")) {
			listForm.setSearchString15("ACTIVE");
		}

		// expiry/active date check
		listForm.setSearchDate1(new Date());

		int total = 0;
		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total
				);	
	}

	public void setTotalResults(ListVendortariffhdrForm listForm, HttpSession session) throws ApplicationException {
	}

	public ActionMessages setLineItems(ListVendortariffhdrForm listForm)
	throws ApplicationException {

		VendortariffhdrBD bd = new VendortariffhdrBD(this.getSessionFactoryClusterMap());

		List vendortariffhdrs = null;
		if (listForm.getSearchString15().equals("ACTIVE")) {
			vendortariffhdrs = bd.findVendortariffhdrsForSearchActive(listForm);
		} 
		if (listForm.getSearchString15().equals("EXPIRED")) {			
			vendortariffhdrs = bd.findVendortariffhdrsForSearchExpired(listForm);				
		}
		if (listForm.getSearchString15().equals("ALL")) {			
			vendortariffhdrs = bd.findVendortariffhdrsForSearch(listForm);				
		}


		List vendortariffhdrDTOs = new ArrayList();
		int row = 0;
		for (Iterator it = vendortariffhdrs.iterator(); it.hasNext();) {
			row++;
			VendortariffhdrDTO dto = new VendortariffhdrDTO();
			try { 
				BeanUtils.copyProperties(dto, it.next());
				dto.setVendtarfhdrId2(dto.getVendtarfhdrId());
			} catch (Exception e) {
			}
			dto.setRow(new Integer(row).toString());
			vendortariffhdrDTOs.add(dto);
		}

		listForm.setList(vendortariffhdrDTOs);

		// Reset the delete boxes
		listForm.setSelectedObjects(null);


		bd=null;


		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+" ListForm Parameters: "+listForm.toString()
				);

		return null;
	}







}
