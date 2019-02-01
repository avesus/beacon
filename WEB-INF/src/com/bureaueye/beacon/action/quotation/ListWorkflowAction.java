package com.bureaueye.beacon.action.quotation;


import java.util.Arrays;
import java.util.Calendar;
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
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.quotation.bd.QuoapproveBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-09-02		200900032		Add Approve Flag to Workflow search criteria 												
 *
 */

public final class ListWorkflowAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages appInformationMessages = new ActionMessages();
		
		
		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" formsToSkip = " + formsToSkip);
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

		// Calculate the total number of results before any buttons are
		// generated
		setTotalResults(listForm, user);

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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" GotoPage = " + listForm.getGotoPage() + ", maxResults = "
				+ listForm.getMaxResults() + ", totalResults = "
				+ listForm.getMaxResults());
		if ((listForm.getGotoPage() * listForm.getMaxResults() == listForm
				.getTotalResults())
				&& listForm.getGotoPage() > 0) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Taking one off");
			listForm.setPreviousPage();
		}

		// populate list items
		setLineItems(listForm);

		
		
		
		
		
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

		// Set a transactional control token to prevent double posting
		// log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Setting transactional control token");
		// saveToken(request);

		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());

		return findSuccess(mapping);
	}
	
	public void setTotalResults(ListForm listForm, User user) throws ApplicationException {
		// Set the default ordering
		if (listForm.getOrderBy() == null) {

			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Quotedate");
			}
		}
		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Quotedate")) listForm.setOrderByDesc("desc");

		
		
		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}
		
		
		
		// set default field values
		// userid
		if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
			listForm.setSearchString1(user.getUserid());
			//listForm.setSearchString1("%");			
		}
		// user groupid
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			//listForm.setSearchString2(user.getUsergroupid());
			listForm.setSearchString2("%");			
		}

		
		//s200900032
		// approve flag
		if (listForm.getSearchString4() == null || listForm.getSearchString4().equals("")) {
			listForm.setSearchString4("");			
		}
		//e200900032
		
		
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap()).read(new SystemcodePK("DATERANGEDAYS","LISTWORKFLOW")).getDescr()).intValue();
		}catch(Exception e){}			
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			// default 'from' date to today minus 7
			c.add(Calendar.DATE,-1*dateRangeDays);			
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

		// approve date 'from'
		if (listForm.getSearchDate3() == null) {
			// default 'from' date to today minus 365
			c.add(Calendar.DATE,-365);			
			try {
				listForm.setSearchDate3(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// approve date 'to'		
		if (listForm.getSearchDate4() == null) {			
			// default 'to' date to today 
			c.add(Calendar.DATE,+365);
			try {
				listForm.setSearchDate4(c.getTime());
			} catch (Exception e) {
			}								
		}
	
		int total = 0;
		//int total = new QuoapproveBD(this.getSessionFactoryClusterMap()).findQuoapprovesTotalResults(listForm);
		listForm.setTotalResults(total);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Total number of results = " + total);
	}

	public void setLineItems(ListForm listForm) throws ApplicationException {

		listForm.setLineItems(		
		new QuoapproveBD(this.getSessionFactoryClusterMap())
			.findQuoapprovesBySearch(listForm)
		);
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage());

	}
}
