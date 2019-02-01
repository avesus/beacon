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

import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.system.SystemcodeForm;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;




public final class SaveSystemcodeAction extends BaseAction {
	
	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		SystemcodeForm saveForm = (SystemcodeForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Process: "+action+
				" Codekey/Typekey: "+saveForm.getCodekey()+"/"+saveForm.getTypekey()
		);
		
		
		// Generate Business Delegate
		SystemcodeBD bd = new SystemcodeBD(this.getSessionFactoryClusterMap());
		
		SystemcodePK pkey = new SystemcodePK(saveForm.getTypekey(),saveForm.getCodekey());
		
		if (action.equals("Delete")) {			
			bd.delete(new Systemcode(pkey), user);
		} else {
			
			Systemcode dao =null;
			try {
				dao = bd.read(pkey);
			} catch (Exception e) {
			}
			
			if (dao == null) {
				dao = new Systemcode();
			}
			BeanUtils.copyProperties(dao, saveForm);
			dao.setId(pkey);			
			bd.createOrUpdate(dao, user);
			
			// Find the form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());
			
			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
}
