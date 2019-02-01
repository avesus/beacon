package com.bureaueye.beacon.action.purchaseorder;



import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Iterator;

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
import com.bureaueye.beacon.form.purchaseorder.PohdrForm;
import com.bureaueye.beacon.model.purchaseorder.Podtl;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;
import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlrcvdBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;




public final class SavePohdrAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PohdrForm saveForm = (PohdrForm) form;
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
		PohdrBD bd = new PohdrBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Pohdr dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Pohdr();
		}
		
		
		
		// error validation 

		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			Pohdr duplicate = null;
			try{duplicate=bd.findPohdrByPono(saveForm.getPono());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.purchaseorder.unique"));				
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

			try{
			// TODO: calculate Tax amount
			BigDecimal taxamt = new BigDecimal(0.0);		
			BigDecimal rate = new BigDecimal(0.0);
			rate=new TaxcodeBD(this.getSessionFactoryClusterMap()).findTaxcodeByTaxcodekey(dto.getTaxcode()).getRate();
			taxamt=rate.multiply(dto.getSubtotalamt()).divide(new BigDecimal(100.0));	
			dto.setTaxamt(taxamt);	
			
			// TODO: calculate Total amount
			dto.setTotalamt(dto.getTaxamt().add(dto.getSubtotalamt()).add(dto.getShippingamt()));
			} catch (Exception e){}
			
			bd.createOrUpdate(dto, user);
			
			
			// copy all details
			if (!saveForm.getCopyId().equals("")) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Processing copyPohdr from id: "+saveForm.getCopyId());
				Integer copyId = null;
				try{copyId = new Integer(saveForm.getCopyId());}catch(Exception e){}
				if (copyId != null) {
					copyPohdrToNew(copyId, dto, user);
				}
			}
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();
			// Set the search parameters
			listform.setSearchString1(dto.getPono());
		}
		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	

	
	
	public void copyPohdrToNew(
			Integer pohdrId, 
			Pohdr dto,
			User user
	) throws Exception {

		PohdrBD pohdrbd = new PohdrBD(this.getSessionFactoryClusterMap());	
		PodtlBD podtlbd = new PodtlBD(this.getSessionFactoryClusterMap());		
		//PonoteBD ponotebd = new PonoteBD(this.getSessionFactoryClusterMap());	
		PodtlrcvdBD podtlrcvdbd = new PodtlrcvdBD(this.getSessionFactoryClusterMap());	
		
		// copy and store equipment
		for (Iterator it = pohdrbd.getPodtls(pohdrId).iterator(); it.hasNext();) {			
			Podtl podtl = new Podtl();
			Podtl copyPodtl = (Podtl)it.next();			
			BeanUtils.copyProperties(podtl, copyPodtl);
			podtl.setPohdrId(dto.getPohdrId());
			podtl.setPodtlId(null);			
			podtlbd.createOrUpdate(podtl, user);
			
			// copy and store equipment locations
			for (Iterator it2 = podtlrcvdbd.findPodtlrcvdsByPodtlId(copyPodtl.getPodtlId()).iterator(); it2.hasNext();) {
				Podtlrcvd podtlrcvd = new Podtlrcvd();
				BeanUtils.copyProperties(podtlrcvd, it2.next());						
				podtlrcvd.setPodtlId(podtl.getPodtlId());
				podtlrcvd.setPodtlrcvdId(null);				
				podtlrcvdbd.createOrUpdate(podtlrcvd, user);	
			}				
		}

/*		// copy and store charges 
		for (Iterator it = pohdrbd.getPonotes(pohdrId).iterator(); it.hasNext();) {			
			Ponote ponote = new Ponote();
			BeanUtils.copyProperties(ponote, it.next());
			ponote.setPohdrId(dto.getPohdrId());
			ponote.setPonoteId(null);			
			ponotebd.createOrUpdate(ponote, user);
		}*/
		
		
	}
	
	
	
}
