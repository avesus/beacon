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
import com.bureaueye.beacon.form.standard.ListCustomertariffhdrForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Customertariffdtl;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.bd.CustomertariffdtlBD;
import com.bureaueye.beacon.model.standard.bd.CustomertariffhdrBD;
import com.bureaueye.beacon.model.standard.dto.CustomertariffhdrDTO;
import com.bureaueye.beacon.util.Util;



/**
 *
 * Amendments
 * ----------
 * 	 											
 *
 */
public final class ListCustomertariffhdrAction extends BaseAction {


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
		List<String> formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
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


		ListCustomertariffhdrForm listForm = (ListCustomertariffhdrForm) form;
		String action = listForm.getAction();
		listForm.setAction("");


		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();


		// update list if action selected
		if (action != null && action.equals("Update")) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" updateButton pressed");

			//init business delegates
			CustomertariffhdrBD tariffhdrbd = new CustomertariffhdrBD(this.getSessionFactoryClusterMap());
			CustomertariffdtlBD tariffdtlbd = new CustomertariffdtlBD(this.getSessionFactoryClusterMap());

			int addRecord=0;
			int updateRecord=0;
			int errorRecord=0;
			if (listForm.getList() != null) {

				User user = (User) request.getSession().getAttribute(Constants.USER_KEY);

				IN_LOOP1:
					for (Iterator<CustomertariffhdrDTO> it = listForm.getList().iterator(); it.hasNext();) {

						CustomertariffhdrDTO dto = (CustomertariffhdrDTO) it.next();
						Customertariffhdr fromCustomertariffhdr = null;
						Customertariffhdr toCustomertariffhdr = null;							
						List<Customertariffdtl> tariffdtls = null; 

						if (!dto.getCusttarfhdrId().equals("")) {

							//convert to upper case
							dto.setCusttarfhdrId(dto.getCusttarfhdrId().toUpperCase());


							// Check valid from date entered
/*							try {
								if (
										dto.getValidfromdd().equals("") ||
										dto.getValidfrommm().equals("") ||
										dto.getValidfromyyyy().equals("")
								) {
									appErrorMessages.add("errors.tariffhdr",
											new ActionMessage(
													"error.validfrom.required2", dto.getRow()));
									errorRecord++;									
									continue IN_LOOP1;								
								}
							} catch (Exception e) {
							}*/

							// Check valid to date entered
							try {
								if (
										dto.getValidtodd().equals("") ||
										dto.getValidtomm().equals("") ||
										dto.getValidtoyyyy().equals("")
								) {
									appErrorMessages.add("errors.tariffhdr",
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
								appErrorMessages.add("errors.tariffhdr",
										new ActionMessage(
												"error.lumpsum.required2", dto.getRow()));
								errorRecord++;
								continue IN_LOOP1;
							}



							//only process if no errors found
							
							//check new 
							if (!dto.getCusttarfhdrId().equals(dto.getCusttarfhdrId2())) {

								//check valid chars
								if (Util.invalidChars(dto.getCusttarfhdrId())) {
									// Add an error message if invalid characters entered in id
									appErrorMessages.add("errors.tariffhdr",
											new ActionMessage(
													"error.code.invalidchars", dto.getRow()));
									errorRecord++;
									continue IN_LOOP1;								
								}

								//check new code is unique
								Customertariffhdr checkCustomertariffhdr = tariffhdrbd.read(dto.getCusttarfhdrId());
								if (checkCustomertariffhdr!=null) {
									// Add an error message
									appErrorMessages.add("errors.tariffhdr",
											new ActionMessage(
													"error.code.unique2", dto.getRow()));
									errorRecord++;
									continue IN_LOOP1;								
								}

								//increment add record
								addRecord++;

								//retrieve detail records to copy to new header record
								tariffdtls = tariffdtlbd.findCustomertariffdtlsByCusttarfhdrId(dto.getCusttarfhdrId2());

							} else {

								//increment update
								updateRecord++;

							}



							try {
								//set records
								fromCustomertariffhdr = tariffhdrbd.read(dto.getCusttarfhdrId2());
								toCustomertariffhdr = tariffhdrbd.read(dto.getCusttarfhdrId());
								if (toCustomertariffhdr==null)toCustomertariffhdr = new Customertariffhdr();	

								//copy all details
								BeanUtils.copyProperties(toCustomertariffhdr,fromCustomertariffhdr);

								//copy screen details
								toCustomertariffhdr.setCusttarfhdrId(dto.getCusttarfhdrId());
								//toCustomertariffhdr.setValidfrom(dto.getValidfrom());
								toCustomertariffhdr.setValidto(dto.getValidto());		
								toCustomertariffhdr.setLumpsum(new BigDecimal(dto.getLumpsum()));	
								toCustomertariffhdr.setUnittype(dto.getUnittype());	

								//persist header data object
								tariffhdrbd.createOrUpdate(toCustomertariffhdr, user);

								//persist details only if add
								if (tariffdtls!=null) {
									for (Iterator<Customertariffdtl> it2 = tariffdtls.iterator(); it2.hasNext();) {
										Customertariffdtl tariffdtl = new Customertariffdtl();
										BeanUtils.copyProperties(tariffdtl, it2.next());
										tariffdtl.setCusttarfhdrId(toCustomertariffhdr.getCusttarfhdrId());
										tariffdtl.setCusttarfdtlId(null);										
										tariffdtlbd.createOrUpdate(tariffdtl, user);
									}
								}
							} catch (Exception e) {
							}

						}//check ID entered

					}//list iterator

				//IN_LOOP1

				//clear objects
				tariffhdrbd = null;
				tariffdtlbd = null;

			}//check list has records


			//init information message
			appInformationMessages.add("messages.tariffhdr",
					new ActionMessage(
							"information.update2", updateRecord));
			appInformationMessages.add("messages.tariffhdr",
					new ActionMessage(
							"information.add2", addRecord));
			appInformationMessages.add("messages.tariffhdr",
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





	public void setTotalResults(ListCustomertariffhdrForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("customertariffhdr.CusttarfhdrId");
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
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
	}


	public void setTotalResults(ListCustomertariffhdrForm listForm, HttpSession session) throws ApplicationException {
	}


	public ActionMessages setLineItems(ListCustomertariffhdrForm listForm)
	throws ApplicationException {

		CustomertariffhdrBD bd = new CustomertariffhdrBD(this.getSessionFactoryClusterMap());

		List<CustomertariffhdrDTO> tariffhdrs = null;
		if (listForm.getSearchString15().equals("ACTIVE")) {
			tariffhdrs=bd.findCustomertariffhdrsForSearchActive(listForm);
		} 
		if (listForm.getSearchString15().equals("EXPIRED")) {			
			tariffhdrs=bd.findCustomertariffhdrsForSearchExpired(listForm);				
		}
		if (listForm.getSearchString15().equals("ALL")) {			
			tariffhdrs=bd.findCustomertariffhdrsForSearch(listForm);				
		}

		List<CustomertariffhdrDTO> tariffhdrDTOs = new ArrayList<CustomertariffhdrDTO>();
		int row = 0;
		for (Iterator<CustomertariffhdrDTO> it = tariffhdrs.iterator(); it.hasNext();) {
			row++;
			CustomertariffhdrDTO dto = new CustomertariffhdrDTO();
			try { 
				BeanUtils.copyProperties(dto, it.next());
				dto.setCusttarfhdrId2(dto.getCusttarfhdrId());
			} catch (Exception e) {		
			}
			dto.setRow(new Integer(row).toString());
			tariffhdrDTOs.add(dto);
		}

		listForm.setList(tariffhdrDTOs);

		// Reset the delete boxes
		listForm.setSelectedObjects(null);


		bd=null;


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}


}
