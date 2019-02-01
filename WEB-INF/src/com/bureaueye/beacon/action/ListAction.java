package com.bureaueye.beacon.action;


import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Userlistform;
import com.bureaueye.beacon.model.standard.bd.UserlistformBD;


public abstract class ListAction extends BaseAction {

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
		if (request.getParameter("printButton.x") != null) listForm.setButton("PRINT");
		if (request.getParameter("testprintButton.x") != null) listForm.setButton("TESTPRINT");



		// init listform with latest user search criteria==============================================>
		//only process MAIN lists
		if (mapping.getName().contains("hdr")) {
			UserlistformBD userlistformbd = new UserlistformBD(this.getSessionFactoryClusterMap());	
			User user = (User) session.getAttribute(Constants.USER_KEY);
			//check first time in
			if (listForm.getOrderBy()==null) {	
				listForm.setOrderBy2("");
				log.info(
						"["+this.getClass().getName()+"] "+new java.util.Date()+
						" ListAction: Init UserListForm: "+
						" Userid: " + user.getUserid()+
						" ListForm: " +  mapping.getName()					
				);
				//retrieve user listform record
				Userlistform userlistformdao = null;
				try{userlistformdao = userlistformbd.findUserlistformByKey1(user.getUserid(), mapping.getName());}catch(ApplicationException e){}				
				if (userlistformdao!= null) {
					try {
						BeanUtils.copyProperties(listForm, userlistformdao);
						//refresh search dates - these will not be included in the search criteria 
						listForm.setSearchDate1dd("");
						listForm.setSearchDate2dd("");						
						log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: Retrieve UserListForm: Id: " + userlistformdao.getUserlistformId());
					} catch (Exception e) {				
					}
				}
				userlistformdao=null;			
			} 
			// store listform user search
			else {
				log.info(
						"["+this.getClass().getName()+"] "+new java.util.Date()+
						" ListAction: Store UserListForm: "+
						" Userid: " + user.getUserid()+
						" ListForm: " +  mapping.getName()				
				);			
				//retreive user listform record
				Userlistform userlistformdao = null;
				try{userlistformdao = userlistformbd.findUserlistformByKey1(user.getUserid(), mapping.getName());}catch(ApplicationException e){}
				if (userlistformdao==null) {
					userlistformdao=new Userlistform();
					userlistformdao.setUserid(user.getUserid());
					userlistformdao.setListform(mapping.getName());
				}
				if (userlistformdao!= null) {

					try {
						BeanUtils.copyProperties(userlistformdao, listForm);
						userlistformbd.createOrUpdate(userlistformdao, user);
						log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: createOrUpdate UserListForm: Id: " + userlistformdao.getUserlistformId());
					} catch (Exception e) {				
					}

				}
				userlistformdao=null;			
			}
			userlistformbd=null;
		}
		// init listform with latest user search criteria==============================================<




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



		// Set a transactional control token to prevent double posting
		// log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Setting transactional control token");
		// saveToken(request);

		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}

	// Set the total number of results
	public abstract void setTotalResults(ListForm listForm)
	throws ApplicationException;

	// Set the total number of results
	public abstract void setTotalResults(ListForm listForm, HttpSession session)
	throws ApplicationException;

	// Set the items to be displayed in the form
	public abstract ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException;

}
