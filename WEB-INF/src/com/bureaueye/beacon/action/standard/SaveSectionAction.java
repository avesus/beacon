package com.bureaueye.beacon.action.standard;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.SectionForm;

import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.SectionBD;

public final class SaveSectionAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		SectionForm sectionForm = (SectionForm) form;
		String action = sectionForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Processing " + action	+ " action");
		
		// Generate Business Delegate
		SectionBD sectionbd = new SectionBD(this.getSessionFactoryClusterMap());

		if (action.equals("Delete")) {
			sectionbd.delete(new Section(sectionForm.getSectionkey()), user);
		} else {
			Section section = sectionbd.read(sectionForm.getSectionkey());

			if (section == null) {
				section = new Section();
			}
			BeanUtils.copyProperties(section, sectionForm);

			sectionbd.createOrUpdate(section, user);

			// Find the section form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			//listform.setStartPage();
			//listform.setSearchString1(section.getSectionkey());
			
			if (action.equals("Create")) {
				// refresh datapool
				ServletContext context = session.getServletContext();			
				DataPool datapool = null;
				datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
				if (datapool != null) {
					datapool.setSections();		
					context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,	datapool);
					// 
					log.debug(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY+" refreshed on ServletContext");
				}
			}
			
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
