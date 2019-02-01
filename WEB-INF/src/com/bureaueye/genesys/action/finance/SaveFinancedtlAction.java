package com.bureaueye.genesys.action.finance;



import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

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
import com.bureaueye.genesys.form.finance.FinancedtlForm;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancedtlBD;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;



public final class SaveFinancedtlAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		FinancedtlForm saveForm = (FinancedtlForm) form;
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
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveFinancedtlAction:  Processing " + action+ " action");
		
		// Generate Business Delegate
		FinancedtlBD bd = new FinancedtlBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getFinancedtlId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Financedtl dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Financedtl();
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
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}
		
		
		
		
		
		
		
		// update totals on header
		FinancehdrBD financehdrbd = new FinancehdrBD(this.getSessionFactoryClusterMap());
		Financehdr financehdr = financehdrbd.read(new Integer(saveForm.getFinancehdrId()));
		Object[] amounts = null;
		try {amounts=bd.financedtlsAmountTotals(saveForm.getFinancehdrId());}catch(Exception e){}
		try {	
			financehdr.setNetamount((BigDecimal)amounts[0]);
			financehdr.setVatamount((BigDecimal)amounts[1]);
			financehdr.setGrossamount((BigDecimal)amounts[2]);
		} catch (Exception e) {}
		financehdrbd.createOrUpdate(financehdr,user);
		
		
		
		// clear Business Delegate for garbage collection
		bd = null;
		financehdrbd = null;
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
}
