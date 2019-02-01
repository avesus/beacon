/*
 * $Id: ListQuoapproveRequestAction.java 54929 2005-09-09 ntankard $ 
 */

package com.bureaueye.beacon.action.quotation;


import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.quotation.ListQuoapproveRequestForm;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;

/**
 * @version $Rev: 
 */
public final class ListQuoapproveRequestAction extends BaseAction {
	
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

		ListQuoapproveRequestForm listForm = (ListQuoapproveRequestForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");

		// Calculate the total number of results before any buttons are
		// generated
		setTotalResults(listForm);

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
	
	
	public void setTotalResults(ListQuoapproveRequestForm listForm) throws ApplicationException {
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" QuoapproveRequest - totalresults: Total = " + 0);

	}
	
	public void setLineItems(ListQuoapproveRequestForm listForm) throws ApplicationException {

		// get header information
		//Quohdr quohdr = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));		
		// set line items
		//listForm.setLineItems(new LinkedList(quohdr.getQuoapproves()));
		
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		listForm.setLineItems(
				new LinkedList(quohdrbd.getQuoapproves(new Integer(listForm.getId())))
				);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Start = " + listForm.getGotoPage() + ", "
				+ listForm.getMaxResults() + ", " + listForm.getGotoPage()
				+ ", id = " + listForm.getId());	
	}
	
}
