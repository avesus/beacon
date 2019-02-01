package com.bureaueye.genesys.action.onhire;



import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.genesys.form.onhire.OnhireForm;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.Contracteqploc;
import com.bureaueye.genesys.model.contract.bd.ContractBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqplocBD;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;




public final class SaveOnhireAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OnhireForm saveForm = (OnhireForm) form;
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
		OnhireBD bd = new OnhireBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Onhire dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Onhire();
		}
		
		
		
		// error validation 

		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			Onhire duplicate = null;
			try{duplicate=bd.findOnhireByOnhireno(saveForm.getOnhireno());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.contract.unique"));				
			}
		}
		
		
			
		
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
			} catch (java.lang.NumberFormatException nfe) {
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {				
			}	
			
			
			if (action.equals("Create")) {
				Contract contract = new ContractBD(this.getSessionFactoryClusterMap()).read(dto.getContractId());
				dto.setContractno(contract.getContractno());
				Contracteqp contracteqp = new ContracteqpBD(this.getSessionFactoryClusterMap()).read(dto.getContracteqpId());
				dto.setEqpkeyp1(contracteqp.getEqpkeyp1());
				dto.setEqpkeyp2(contracteqp.getEqpkeyp2());
				Contracteqploc contracteqploc = new ContracteqplocBD(this.getSessionFactoryClusterMap()).read(dto.getContracteqplocId());
				dto.setLocationkey(contracteqploc.getLocationkey());			
			}
			
			bd.createOrUpdate(dto, user);
			
			
			// copy all details
			if (!saveForm.getCopyId().equals("")) {

			}
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			// Set the search parameters
			listform.setSearchString1(dto.getOnhireno());
		}
		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	

	
		
}
