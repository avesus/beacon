package com.bureaueye.genesys.action.contract;



import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

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
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.genesys.form.contract.ContracteqpForm;
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.Contracteqploc;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqplocBD;



public final class SaveContracteqpAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ContracteqpForm saveForm = (ContracteqpForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		
		
		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");
		
		
		// Generate Business Delegate
		ContracteqpBD bd = new ContracteqpBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getContracteqpId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Contracteqp dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Contracteqp();
		}
		
		
		
		// error validation 
		
		
		
		
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}				
		
		
		if (action.equals("Delete")) {	

			bd.delete(dto, user);	
			
		} else {
			
			
			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dto, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	
			
			bd.createOrUpdate(dto, user);
			
			
			// copy all details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Processing copyContracteqp from id: "+saveForm.getCopyId());
				Integer contracteqpId = null;
				try{contracteqpId = new Integer(saveForm.getCopyId());}catch(Exception e){}
				if (contracteqpId != null) {
					copyContracteqpToNew(contracteqpId, dto, user);
				}
			}
			
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	

	
	
	public void copyContracteqpToNew(
			Integer contracteqpId, 
			Contracteqp dto,
			User user
	) throws Exception {

		ContracteqpBD contracteqpbd = new ContracteqpBD(this.getSessionFactoryClusterMap());	
		ContracteqplocBD contracteqplocbd = new ContracteqplocBD(this.getSessionFactoryClusterMap());	
				
			// copy and store equipment locations
			for (Iterator it = contracteqpbd.getContracteqplocs(contracteqpId).iterator(); it.hasNext();) {
				Contracteqploc contracteqploc = new Contracteqploc();
				BeanUtils.copyProperties(contracteqploc, it.next());					
				contracteqploc.setContracteqpId(dto.getContracteqpId());
				contracteqploc.setContracteqplocId(null);				
				contracteqplocbd.createOrUpdate(contracteqploc, user);	
			}				
				
	}
	
	
	
}
