package com.bureaueye.beacon.action.quotation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.report.ReportRow;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.quotation.ListQuosummaryForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuohdrDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryChargeDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryCostDTO;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


public final class ListQuohdrExchgdateAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		
		
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
		
		
		/*		// init breadcrumbs
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  breadcrumbs - init");		
		 Map breadcrumbMap = (HashMap) session.getAttribute(com.bureaueye.beacon.bean.Constants.BREADCRUMB_KEY);
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  breadcrumbs -"+
		 " breadcrumbMap found: "+(breadcrumbMap!=null));	
		 Breadcrumb breadcrumb = listForm.getBreadCrumb();
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  breadcrumbs -"+
		 " breadcrumb found: "+(breadcrumb!=null));
		 if (breadcrumbMap != null && breadcrumb != null) {
		 if (breadcrumb.getSequence().equals("1")) {
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  breadcrumbs - clear");
		 breadcrumbMap.clear();
		 breadcrumbMap.put("1",breadcrumb);
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		 "  breadcrumbs - put: "+
		 breadcrumb.getUrl()+
		 " sequence: "+breadcrumbMap.size());         		
		 } else {      		
		 breadcrumbMap.put(new Integer(breadcrumbMap.size()+1).toString(),breadcrumb);
		 log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
		 "  breadcrumbs - put: "+
		 breadcrumb.getUrl()+
		 " sequence: "+breadcrumbMap.size());        		
		 }
		 session.setAttribute(com.bureaueye.beacon.bean.Constants.BREADCRUMB_KEY, breadcrumbMap);
		 }*/
		
		
		// Initialise button if button pressed
		listForm.setButton("");
		if (request.getParameter("updateButton.x") != null) listForm.setButton("UPDATE");
		
		
		// print process if action selected
		if (
				listForm.getButton() != null &&
				(listForm.getSelectedObjects() != null || listForm.getSearchString15() != null) &&
				listForm.getButton().equals("UPDATE")
		) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Action = " + listForm.getButton());
			
			User _user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
			
						
			// init buisness delegates
			QuohdrBD hdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
			
			try {
												
				// get selected rows
				int[] selectedObjects = listForm.getSelectedObjects();
				if (selectedObjects != null) {
					// process SELECTED
					for (int i = 0; i < selectedObjects.length; i++) {				
						Integer _id = new Integer(selectedObjects[i]);			

						// TODO: update exchange date and exhange rates
						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" selectedObjects: " +  	
								" _id = " + _id
								);

						// retrieve objects
						Quohdr hdr = null;
						try {hdr  = hdrbd.read(_id);}catch (ApplicationException ae) {}
						
						// init fields
						hdr.setExchgdate(listForm.getSearchDate3());

						// update objects
						hdrbd.createOrUpdate(hdr, _user);
						
					}					
				} else {
					// process ALL
					if (listForm.getLineItems().size() > 0) {
						
						for (Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
							ReportRow rr = (ReportRow)it.next();				
							Integer _id = new Integer(rr.getCell2());			
							
							// TODO: update exchange date and exhange rates
							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" allObjects: " +  	
									" _id = " + _id
									);
						
							// retrieve objects
							Quohdr hdr = null;
							try {hdr  = hdrbd.read(_id);}catch (ApplicationException ae) {}
							
							// init fields
							hdr.setExchgdate(listForm.getSearchDate3());

							// update objects
							hdrbd.createOrUpdate(hdr, _user);
							
						}					
					}					
				}
				 
				
			}
			catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" executeUpdate: Exception: "+e.getMessage());			
			}
			finally {
				// reset select objects
				listForm.setSearchString15(null);
				listForm.setSelectedObjects(null);
			}			
			
			//return null;
		}
		
		
		
		// Calculate the total number of results before any buttons are 
		// generated and default values
		setTotalResults(listForm);
		
		// Calculate the total number of results before any buttons are
		// generated and default values from SESSION 
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
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Setting previous page");
			listForm.setPreviousPage();
		}
		
		// populate list items
		ActionMessages messages = 
			setLineItems(listForm);
		
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
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

		// reset select objects
		listForm.setSelectedObjects(null);
		listForm.setSearchString15(null);		
		
		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());
		
		return findSuccess(mapping);
	}
	

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {

			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Quotedate");
			}
		}
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Quotedate")) listForm.setOrderByDesc("desc");
		
		
		// set default field values
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);
		
		// customer
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
		}
		// status
		if (listForm.getSearchString9() == null || listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("%");
		}
		
		// location
		if (listForm.getSearchString10() == null || listForm.getSearchString10().equals("")) {
			listForm.setSearchString10("%");
		}	
		// location
		if (listForm.getSearchString11() == null || listForm.getSearchString11().equals("")) {
			listForm.setSearchString11("%");
		}
		// location
		if (listForm.getSearchString12() == null || listForm.getSearchString12().equals("")) {
			listForm.setSearchString12("%");
		}
		// location
		if (listForm.getSearchString13() == null || listForm.getSearchString13().equals("")) {
			listForm.setSearchString13("%");
		}
				
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTQUOHDR")).getDescr()).intValue();
		}catch(Exception e){}
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// quote date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}

		
		// exdate
		if (listForm.getSearchDate3() == null) {			
			// default 'to' today 
			try {
				listForm.setSearchDate3(new Date());
			} catch (Exception e) {
			}								
		}
		
		
		int total = 0;
		listForm.setTotalResults(total);

	}

	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
		
		//default company
		User user = (User) session.getAttribute(Constants.USER_KEY);
		if (listForm.getSearchString19() == null || listForm.getSearchString19().equals("")) {
			listForm.setSearchString19(user.getCompanykey());
		}
		
	}

	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		if (listForm.getSearchString1() == null || 
			listForm.getSearchString1().equals("")) {
			listForm.setLineItems(		
					new QuohdrBD(
							this.getSessionFactoryClusterMap()
							)
							.findQuohdrsBySearch(listForm)
						);		
		}
		else { 
			listForm.setLineItems(		
					new QuohdrBD(
							this.getSessionFactoryClusterMap()
							)
							.findQuohdrsBySearchByQuotno(listForm)
						);		
		}

		// exrate lookup
		ListForm ccyexListForm = new ListForm();
		ccyexListForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
		ccyexListForm.setGotoPage(0);
		// exdate upto date
		ccyexListForm.setSearchDate1(listForm.getSearchDate3());
		ccyexListForm.setOrderBy("Exdate");
		ccyexListForm.setOrderByDesc("Desc");		

		
		// transfer lineitems into ReportRows
		List<ReportRow> reportWorkfile = new LinkedList<ReportRow>();
		int count = 1;
		for (Iterator it = listForm.getLineItems().iterator(); it.hasNext();) {
			QuohdrDTO dto = (QuohdrDTO)it.next();						
	
			// to ccy
			ccyexListForm.setSearchString2(dto.getCcykey());
			
			ListQuosummaryForm listQuosummaryForm = new ListQuosummaryForm();
			listQuosummaryForm.setId(dto.getId().toString());
			
			// populate list items	
			List chargeLineItems = new LinkedList();
			chargeLineItems = getChargeLineItems(listQuosummaryForm);
			
			// populate list items	
			List costLineItems = new LinkedList();
			costLineItems = getCostLineItems(listQuosummaryForm);
			
			ReportRow rr = new ReportRow();
			
			rr.setCell1(new Integer(count).toString());
			rr.setCell2(dto.getId().toString());
			rr.setCell3(dto.getQuotno());
			
			if (dto.getQuotedate() != null) 
				rr.setCell4(com.bureaueye.beacon.util.Util.dateTextFormat2(dto.getQuotedate()));	
			else rr.setCell4( "" );
			if (dto.getExchgdate() != null) 
				rr.setCell5(com.bureaueye.beacon.util.Util.dateTextFormat2(dto.getExchgdate()));	
			else rr.setCell5( "" );
			if (listForm.getSearchDate3() != null) 
				rr.setCell13(com.bureaueye.beacon.util.Util.dateTextFormat2(listForm.getSearchDate3()));	
			else rr.setCell13( "" );

			rr.setCell6(dto.getCcykey());

			double chargeTotal = 0.0;
			double chargeTotal2 = 0.0;			
			// process charge list collection
			if (chargeLineItems != null) {
				Iterator it0 = chargeLineItems.iterator();
				int row = 0;
				while (it0.hasNext()) {
					// init 
					QuosummaryChargeDTO lineItem = (QuosummaryChargeDTO) it0.next();
					
					// init select parameter					
					try {							
						// increment charge total
						chargeTotal = chargeTotal + lineItem.getChgamtbase().doubleValue();					
					}
					catch (NullPointerException npe) {}	 

					// find new exchange rate for ccy to base
					BigDecimal exrate = new BigDecimal(1);
					BigDecimal chgamtbase2 = new BigDecimal(0);
					try {
						// from ccy
						ccyexListForm.setSearchString1(lineItem.getCcykey());
						// get new exchange rate
						exrate = new BigDecimal(new CcyexBD(this.getSessionFactoryClusterMap()).getExrate(ccyexListForm));
					} catch (Exception ae) {}
					try {
						// calculate new base amount
						chgamtbase2 = (lineItem.getChgamt().multiply(exrate));
					} catch (Exception e) {
						chgamtbase2 = new BigDecimal(0);	
					}
					try {							
						// increment new charge total
						chargeTotal2 = chargeTotal2 + chgamtbase2.doubleValue();					
					}
					catch (NullPointerException npe) {}	 
					
					// increment pointer
					row++;					
				} // end list loop
			}	// end 
			
			// output totals
			rr.setCell7(new CurrencyFormatter().format(new BigDecimal(chargeTotal)));
			rr.setCell8(new CurrencyFormatter().format(new BigDecimal(chargeTotal2)));
			
			double costTotal = 0.0;
			double costTotal2 = 0.0;	
			// process cost list collection
			if (costLineItems != null) {
				Iterator it1 = costLineItems.iterator();
				int row = 0;
				while (it1.hasNext()) {
					// init 
					QuosummaryCostDTO lineItem = (QuosummaryCostDTO) it1.next();
					
					// init select parameter					
					try {							
						// increment cost amount
						costTotal = costTotal + lineItem.getCstamtbase().doubleValue();					
					}
					catch (NullPointerException npe) {}
					
					// find new exchange rate for ccy to base
					BigDecimal exrate = new BigDecimal(1);
					BigDecimal cstamtbase2 = new BigDecimal(0);
					try {
						// from ccy
						ccyexListForm.setSearchString1(lineItem.getCcykey());
						// get new exchange rate
						exrate = new BigDecimal(new CcyexBD(this.getSessionFactoryClusterMap()).getExrate(ccyexListForm));
					} catch (Exception ae) {}
					try {
						// calculate new base amount
						cstamtbase2 = (lineItem.getCstamt().multiply(exrate));
					} catch (Exception e) {
						cstamtbase2 = new BigDecimal(0);	
					}
					try {							
						// increment new cost total
						costTotal2 = costTotal2 + cstamtbase2.doubleValue();					
					}
					catch (NullPointerException npe) {}	
					
					// increment pointer
					row++;					
				} // end list loop
			}	// end 
			
			// output totals
			rr.setCell9(new CurrencyFormatter().format(new BigDecimal(costTotal)));
			rr.setCell10(new CurrencyFormatter().format(new BigDecimal(costTotal2)));
			
			// output profits 
			rr.setCell11(new CurrencyFormatter().format(new BigDecimal(chargeTotal - costTotal)));
			rr.setCell12(new CurrencyFormatter().format(new BigDecimal(chargeTotal2 - costTotal2)));
			
			count++;
			
			reportWorkfile.add(rr);			
			
		}
		
		listForm.setLineItems( reportWorkfile );
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()
				+ " setLineItems = "+listForm.toString()
				);
		return null;
	}

	
	
	
	public List getChargeLineItems(ListQuosummaryForm listQuosummaryForm) throws ApplicationException {
		
		listQuosummaryForm.setGotoPage(0);
		listQuosummaryForm.setMaxResults(99);
		listQuosummaryForm.setOrderBy("Chargekey");
		listQuosummaryForm.setOrderByDesc("");		
		
		// set line items
		List lineItems = null;
		lineItems = 
			new QuochargeBD(
					this.getSessionFactoryClusterMap()
					)
					.findQuochargesForSummary(listQuosummaryForm);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getChargeLineItems: " +  	
				" toString = " + listQuosummaryForm.toString()
				);
		
		return lineItems;
	}
	
	
	public List getCostLineItems(ListQuosummaryForm listQuosummaryForm) throws ApplicationException {
		
		listQuosummaryForm.setGotoPage(0);
		listQuosummaryForm.setMaxResults(99);
		listQuosummaryForm.setOrderBy("Costkey");
		
		// set line items
		List lineItems = null;
		lineItems = 
			new QuocostBD(
					this.getSessionFactoryClusterMap()
					)
					.findQuocostsForSummary(listQuosummaryForm);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getCostLineItems: " +  	
				" toString = " + listQuosummaryForm.toString()
				);
		
		return lineItems;	
	}
	


	
	
	
}
