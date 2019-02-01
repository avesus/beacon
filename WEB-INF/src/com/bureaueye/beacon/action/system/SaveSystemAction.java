package com.bureaueye.beacon.action.system;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.form.system.SystemForm;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.system.bd.SystemXBD;




public final class SaveSystemAction extends BaseAction {
	
	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		SystemForm saveForm = (SystemForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Process: "+action+
				" key: "+saveForm.getSystemId()
		);
		
		
		// Generate Business Delegate
		SystemXBD bd = new SystemXBD(this.getSessionFactoryClusterMap());
		
		Integer pkey = new Integer(saveForm.getSystemId());
		
			SystemX dao =null;
			try {
				dao = bd.read(pkey);
			} catch (Exception e) {
			}
			

			BeanUtils.copyProperties(dao, saveForm);
			
			bd.createOrUpdate(dao, user);
			
			
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
}
