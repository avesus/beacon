package com.bureaueye.beacon.action.purchaseinvoice;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;




public final class ListPihdrcostAction extends BaseAction {


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages appInformationMessages = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();


		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: isNew = " + session.isNew());

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

		ListForm listForm = (ListForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");





		if (listForm.getButton() != null) {


			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" button = " + listForm.getButton());



			// APPROVE PROCESS==========================================================>
			if (listForm.getButton().equals("APPROVE")) {

				try {

					//find pi header
					//init business delegates
					PihdrBD hdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
					PidtlBD dtlbd = new PidtlBD(this.getSessionFactoryClusterMap());					
					PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());

					// set header information
					Pidtl dtl = dtlbd.read(new Integer(listForm.getId()));
					Pihdr hdr = hdrbd.read(dtl.getPihdrId());

					BigDecimal invoiceamt = new BigDecimal(0.0);
					try {
						invoiceamt = dtlbd.pidtlsInvoiceamtTotal(hdr.getPihdrId()+"");
					} catch (Exception ae) {}
					BigDecimal allocamt = new BigDecimal(0.0);					
					try {
						allocamt = pidtlcostbd.pidtlcostsCstamtallocSumByPihdrid(hdr.getPihdrId()+"");
					} catch (Exception ae) {}

					//check all detail input amounts equal header net amount
					BigDecimal hdrNetamount = hdr.getNetamt();				
					try {
						BigDecimal dtlInvoiceamtTotal = invoiceamt;			
						if (dtlInvoiceamtTotal.floatValue()!=hdrNetamount.floatValue()) {
							appErrorMessages.add(
									"informationMessage",
									new ActionMessage(
											"error.approve.netamount1",
											hdr.getNetamt(),
											invoiceamt
									)
							);				
						}				
					} catch (Exception e) {
					}

					//check all cost allocated amounts equal header net amount	
					try {
						BigDecimal dtlcstAmtallocTotal = allocamt;
						if (dtlcstAmtallocTotal.floatValue()!=hdrNetamount.floatValue()) {
							appErrorMessages.add(
									"informationMessage",
									new ActionMessage(
											"error.approve.netamount2",
											hdr.getNetamt(),
											allocamt
									)
							);				
						}				
					} catch (Exception e) {
					}


					// update - if no error messages
					if (appErrorMessages.isEmpty()) {

						hdr.setInvoicestatus(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
						dtl.setInvoicestatus(com.bureaueye.beacon.bean.Constants.APPROVED_STATUS);
						
						//generate posting record===============================================>
						AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
						Aiout aioutdao = null;
						//retrieve aiout record 
						if (hdr.getAioutId()!=null) {
							try {
								aioutdao = aioutbd.read(hdr.getAioutId()); 
							} catch (Exception e) {}
						}
						if (aioutdao==null) aioutdao = new Aiout();

						try {
							//check not already sent
							if (aioutdao.getSentdate()==null) {
								aioutdao.setDockey(hdr.getPino());
								aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
								aioutdao.setDoctype(com.bureaueye.beacon.bean.Constants.AP_ACTUAL);
								aioutdao.setCompanykey(hdr.getCompanykey());
								aioutdao.setDepartmentkey(hdr.getDepartmentkey());
								aioutdao.setActivitykey(hdr.getActivitykey());
								aioutdao.setErrors("");
								aioutdao.setDocument("");

								// create/update aiout recod
								aioutbd.createOrUpdate(aioutdao, user);

								hdr.setAioutId(aioutdao.getAioutId());
							}
						} catch (Exception e) {
						}
						aioutbd = null;						
						//generate posting record===============================================<						

						//store header/detail
						hdrbd.createOrUpdate(hdr, user);
						dtlbd.createOrUpdate(dtl, user);
						
						// Add information message 
						appInformationMessages.add(
								"informationMessage",
								new ActionMessage(
										"information.approve.purchaseinvoice",
										hdr.getPino()
								)
						);

					}


				}
				catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" executeApprove: Exception: "+e.getMessage());			
				}
				finally {
					// reset select objects
					listForm.setButton("");
				}			

			}
			// APPROVE PROCESS==========================================================<

		}//getButton




		setTotalResults(listForm);


		setTotalResults(listForm, session);


		// Initialise previous page results if action selected
		if (request.getParameter("previousButton.x") != null)
			listForm.setPreviousPage();
		else
			// initialise next page results if action selected
			if (request.getParameter("nextButton.x") != null)
				listForm.setNextPage();
			else
				// initialise start page results
				if (request.getParameter("startButton.x") != null)
					listForm.setStartPage();
				else
					// initialise end page results
					if (request.getParameter("endButton.x") != null)
						listForm.setEndPage();

		if (request.getParameter("searchButton.x") != null)
			// reset page/result values if new Search
			listForm.setStartPage();

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()
		+ " GotoPage = "+listForm.getGotoPage()
		+ ", maxResults = "+listForm.getMaxResults() 
		+ ", totalResults = "+listForm.getTotalResults()
		+ ", searchButton.x = "+request.getParameter("searchButton.x")
		+ ", previousButton.x = "+request.getParameter("previousButton.x")
		+ ", nextButton.x = "+request.getParameter("nextButton.x")
		+ ", endButton.x = "+request.getParameter("endButton.x")
		+ ", startButton.x = "+request.getParameter("startButton.x")
		);

		if ((listForm.getGotoPage() * listForm.getMaxResults() == listForm
				.getTotalResults())
				&& listForm.getGotoPage() > 0) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Taking one off");
			listForm.setPreviousPage();
		}

		// populate list items
		ActionMessages messages = 
			setLineItems(listForm);		
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}


		// Report any errors back to the original form		
		if (!appErrorMessages.isEmpty()) {
			saveAppErrorMessages(request, appErrorMessages);
		} else {
			// Report any information back to the original form
			if (!appInformationMessages.isEmpty()) {
				saveAppInformationMessages(request, appInformationMessages);
			}					
		}


		// initialise Pagination
		if (listForm.getGotoPage() == 0) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Setting firstpage to true");
			listForm.setFirstPage(true);
		}
		if (listForm.getGotoPage() == ((listForm.getTotalResults() - 1) / listForm
				.getMaxResults())) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Setting lastpage to true");
			listForm.setLastPage(true);
		}




		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Costkey");
		}

		//set default max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		// invoice status search
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1("%");
		}

		int total = 0;
		listForm.setTotalResults(total);
	}


	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}


	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		//init business delegates
		PihdrBD hdrbd = new PihdrBD(this.getSessionFactoryClusterMap());
		PidtlBD dtlbd = new PidtlBD(this.getSessionFactoryClusterMap());
		PidtlcostBD dtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());		
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());

		// set header information
		Pidtl dtl = dtlbd.read(new Integer(listForm.getId()));
		Pihdr hdr = hdrbd.read(dtl.getPihdrId());

		listForm.setHeaderInfo1(hdr.getPino());
		listForm.setHeaderInfo2(hdr.getVendorref());		
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getInvoicedate())
		);
		listForm.setHeaderInfo4(hdr.getCcykey());
		listForm.setHeaderInfo5(
				addressbd.read(hdr.getVendoraddrkey()).getName()		
		);
		try {
			listForm.setHeaderInfo6(hdr.getGrossamt().toString());
		} catch (Exception e) {
			listForm.setHeaderInfo6("0.00");
		}

		listForm.setHeaderInfo7(new Boolean(hdr.isMiscflag()).toString());
		listForm.setHeaderInfo8(dtl.getJobno());
		listForm.setHeaderInfo9(dtl.getOrderno());
		listForm.setHeaderInfo10(new Boolean(hdr.isPostedflag()).toString());
		listForm.setHeaderInfo11(hdr.getInvoicestatus());
		

		// set line items
		listForm.setLineItems(
				dtlcostbd.findPidtlcostsById(
						listForm.getId(),
						0,
						listForm.getMaxResults(),
						listForm.getOrderBy()
				)
		);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);


		//clear objects
		dtl=null;		
		hdr=null;
		hdrbd=null;
		dtlbd=null;
		dtlcostbd=null;
		addressbd=null;


		return null;
	}


}
