package com.bureaueye.beacon.action.salesinvoice;



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
import com.bureaueye.beacon.form.salesinvoice.SidtlForm;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Taxcode;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;



public final class SaveSidtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		SidtlForm saveForm = (SidtlForm) form;
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveAction:  Processing " + action+ " action");

		// Generate Business Delegate
		SidtlBD bd = new SidtlBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getSidtlId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Sidtl dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Sidtl();
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





		// update invoice total on header
		SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());
		Sihdr sihdr = sihdrbd.read(new Integer(saveForm.getSihdrId()));
		//set invoice amount
		BigDecimal amount = new BigDecimal(0.0);
		try {amount=bd.sidtlsChgamtTotal(saveForm.getSihdrId());}catch(Exception e){}
		if (amount==null) amount = new BigDecimal(0.0);
		sihdr.setInvoiceamt(amount);
		//set tax amount
		sihdr.setTaxamt(new BigDecimal(0.0));
		//------------------------------------------------------------------->
		// get tax rate
		try {
			TaxcodeBD taxcodebd=new TaxcodeBD(this.getSessionFactoryClusterMap());
			Taxcode taxcode = taxcodebd.findTaxcodeByTaxcodekey(sihdr.getTaxcode());
			if (taxcode !=null) {
				sihdr.setTaxamt(
						sihdr.getInvoiceamt()
						.multiply(taxcode.getRate())
						.divide(new BigDecimal(100))
				);
			} 
			taxcodebd=null;
		} catch (Exception e) {
		}
		//----------------------------------------------------------------->	
		sihdrbd.createOrUpdate(sihdr,user);

		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}



}
