package com.bureaueye.beacon.action.mandr;



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
import com.bureaueye.beacon.form.mandr.MandrdtlForm;

import com.bureaueye.beacon.model.mandr.Mandrdtl;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrdtlBD;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;
import com.bureaueye.beacon.model.standard.User;




public final class SaveMandrdtlAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		MandrdtlForm saveForm = (MandrdtlForm) form;
		String action = saveForm.getAction();

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
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveAction:  Processing " + action+ " action");
		
		// Generate Business Delegate
		MandrdtlBD bd = new MandrdtlBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getMandrdtlId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Mandrdtl dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Mandrdtl();
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
			bd.delete(dao, user);		
		} else {
			
			
			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	
			
			bd.createOrUpdate(dao, user);
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}
		
		
		
		// update totals on header
		MandrhdrBD hdrbd = new MandrhdrBD(this.getSessionFactoryClusterMap());
		Mandrhdr hdr = hdrbd.read(new Integer(saveForm.getMandrhdrId()));
		Object[] amounts = null;
		try {
			amounts=bd.findMandrdtlsTotals(new Integer(saveForm.getMandrhdrId()));
		}
		catch(Exception e){		
		}
		try {	
			hdr.setMaterialamt((BigDecimal)amounts[0]);
			hdr.setLaboramt((BigDecimal)amounts[1]);
			hdr.setTotalamt((BigDecimal)amounts[2]);
			hdr.setLaborhours((BigDecimal)amounts[3]);			
		} catch (Exception e) {		
		}
		hdrbd.createOrUpdate(hdr,user);
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
}
