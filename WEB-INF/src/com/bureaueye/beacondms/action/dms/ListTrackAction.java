package com.bureaueye.beacondms.action.dms;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.form.dms.ListTrackForm;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;






public final class ListTrackAction extends BaseAction {


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();



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

		ListTrackForm listForm = (ListTrackForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");





		// Initialise button if button pressed
		listForm.setButton("");
		if (request.getParameter("emailAttachmentsButton") != null) listForm.setButton("EMAILATTACHMENTS");


		// checkbox process if action selected
		if (
				listForm.getButton() != null &&
				(listForm.getSelectedObjects() != null || listForm.getSearchString15() != null) &&
				listForm.getButton().equals("EMAILATTACHMENTS")  
		) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Action = " + listForm.getButton());
			listForm.setAction(listForm.getButton());			

			return mapping.findForward("trackmail");
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


		// Report any errors back to the original form		
		if (!appErrorMessages.isEmpty()) {
			saveAppErrorMessages(request, appErrorMessages);
		} else {
			// Report any information back to the original form
			if (!appInformationMessages.isEmpty()) {
				saveAppInformationMessages(request, appInformationMessages);
			}					
		}


		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListTrackForm listForm) throws ApplicationException {


		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Createdate");
		}		
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Createdate")) listForm.setOrderByDesc("desc");

		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}

		//doc id
		if (listForm.getSearchString1()==null) {	
			listForm.setSearchString1("");
		}
		//doc type
		if (listForm.getSearchString2()==null) {	
			listForm.setSearchString2("");
		}
		//category
		if (listForm.getSearchString3()==null) {	
			listForm.setSearchString3("");
		}
		//sub-category
		if (listForm.getSearchString4()==null) {	
			listForm.setSearchString4("");
		}
		//company id
		if (listForm.getSearchString5()==null) {	
			listForm.setSearchString5("");
		}
		//create user id
		if (listForm.getSearchString6()==null) {	
			listForm.setSearchString6("");
		}
		//description
		if (listForm.getSearchString7()==null) {	
			listForm.setSearchString7("");
		}

		//create date
		int dateRangeDays = 7;
		try{
			dateRangeDays = 
				new Integer(
						new SystemcodeBD(
								this.getSessionFactoryClusterMap()
						)
						.read(new SystemcodePK("DATERANGEDAYS","LISTTRACK")).getDescr()).intValue();
		}catch(Exception e){}	

		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);		
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}


	}


	public void setTotalResults(ListTrackForm listForm, HttpSession session) throws ApplicationException {
	}

	public ActionMessages setLineItems(ListTrackForm listForm) throws ApplicationException {

		try {
			
			//clear line items
			listForm.setLineItems(null);
			//init bd
			com.bureaueye.beacondms.model.dms.bd.XdocumentBD dmsXdocumentbd = new com.bureaueye.beacondms.model.dms.bd.XdocumentBD();
			//init collection
			List<Xdocument> xdocumnentdaos = new LinkedList<Xdocument>();


			//DOCID search selected
			if (!listForm.getSearchString1().equals("")) {	

				//retrieve stored documents using docid
				xdocumnentdaos = dmsXdocumentbd.findXdocumentsByDocid(listForm);
				listForm.setLineItems(xdocumnentdaos);

			} else {

				//retrieve stored documents using general search
				xdocumnentdaos = dmsXdocumentbd.findXdocumentsBySearch(listForm);
				listForm.setLineItems(xdocumnentdaos);

			}


			
			
			/*	REMOVED THE XQUERY FOR NOW.....NEED TO RE-MODEL THE MONITOR XML TO BE BETTER STRUCTURED
			 * 		//XQUERY search selected
			if (
					!listForm.getSearchString2().equals("") ||
					!listForm.getSearchString5().equals("")
			) {	

				com.bureaueye.beacondms.model.xmldb.bd.XdocumentBD xmldbXdocumentbd = new com.bureaueye.beacondms.model.xmldb.bd.XdocumentBD();
				try {
					xmldbXdocumentbd.updateDocuments();

					listForm = xmldbXdocumentbd.findXdocumentsByXquery(
							listForm
					);

					listForm.setSearchString2("");	
					listForm.setSearchString3("=");
					listForm.setSearchString4("");


				} catch (Exception ae) {
				}	

			}
			 */
			//}

		} catch (Exception e) {

		}

		return null;

	}
}
