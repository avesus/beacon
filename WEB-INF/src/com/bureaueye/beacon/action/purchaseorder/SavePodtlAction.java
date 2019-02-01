package com.bureaueye.beacon.action.purchaseorder;



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
import com.bureaueye.beacon.form.purchaseorder.PodtlForm;
import com.bureaueye.beacon.model.purchaseorder.Podtl;
import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;



public final class SavePodtlAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PodtlForm saveForm = (PodtlForm) form;
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
		PodtlBD bd = new PodtlBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getPodtlId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Podtl dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Podtl();
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
			
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}
		
		try {
		// update totals on header
		PohdrBD pohdrbd = new PohdrBD(this.getSessionFactoryClusterMap());
		Pohdr pohdr = pohdrbd.read(new Integer(saveForm.getPohdrId()));
		
		// TODO: calculate Subtotal amount
		BigDecimal subtotalamt = new BigDecimal(0.0);
		subtotalamt=bd.podtlsAmtTotal(saveForm.getPohdrId());		
		pohdr.setSubtotalamt(subtotalamt);
		
		// TODO: calculate Tax amount
		BigDecimal taxamt = new BigDecimal(0.0);		
		BigDecimal rate = new BigDecimal(0.0);
		rate=new TaxcodeBD(this.getSessionFactoryClusterMap()).findTaxcodeByTaxcodekey(pohdr.getTaxcode()).getRate();
		taxamt=rate.multiply(subtotalamt).divide(new BigDecimal(100.0));	
		pohdr.setTaxamt(taxamt);	
		
		// TODO: calculate Total amount
		pohdr.setTotalamt(pohdr.getTaxamt().add(pohdr.getSubtotalamt()).add(pohdr.getShippingamt()));
		pohdrbd.createOrUpdate(pohdr,user);
		
		}catch(Exception e){}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	

	
	
	
	
}
