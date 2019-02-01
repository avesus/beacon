package com.bureaueye.beacon.action.agent;

import java.text.DecimalFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.agent.AgentjobForm;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.DocnoBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;





public final class EditAgentjob2Action extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession();
		AgentjobForm editForm = (AgentjobForm) form;
		String action = editForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		
		
		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return mapping.findForward("beaconmenu");
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		
		
		// init dao and bd
		Quohdr quohdrdao = null;
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		
		// business validation
		quohdrdao = quohdrbd.findQuohdrByQuotno(editForm.getQuotno());		
		if (quohdrdao != null) {			
			if (!quohdrdao.getQuotestatus().equals("APPROVED")) {
				errors.add("informationMessage",new ActionMessage("message.copyquote.notapproved"));
			}
		}
		else {
			errors.add("informationMessage",new ActionMessage("message.copyquote.noquotefound"));			
		}
		
  
		
        
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return findFailure(mapping);
		}
		
		
		// generate order no
		try {
			PropertyResourceBundle props = 
				(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
			// auto generate quotation number
			int nextdocno = 0;
			nextdocno = new DocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
					"ORDER",
					"",
					0,
					user
			);
			DecimalFormat df = new DecimalFormat(props.getString ("orderno.format"));
			editForm.setOrderno(df.format(nextdocno));
			editForm.setJobno(df.format(nextdocno));
			log.debug(
					"["+this.getClass().getName()+"] "+
					new java.util.Date()+" "+
					"nextdocno["+editForm.getQuotno()+"]: "+
					"userid["+user.getUserid()+"]"
			);					
		} catch (Exception e) {
			log.error(
					"["+this.getClass().getName()+"] "+
					new java.util.Date()+" "+
					"Exception["+e.getMessage()+"]"
			);				
		}
		
		
		// intialise form fields
		editForm.setQuohdrId(quohdrdao.getId().toString());
		editForm.setLdglocationkey2(quohdrdao.getLdglocationkey2());
		editForm.setDchlocationkey2(quohdrdao.getDchlocationkey2());
		
		editForm.setIncotermkey(quohdrdao.getIncotermkey());

		// product fields
		editForm.setProductkey(quohdrdao.getProductkey());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		Product productdao = null;
		try {productdao = productbd.read(editForm.getProductkey());} catch (Exception e) {}		
		if (productdao != null) {
			editForm.setTradname(productdao.getTradname());
			editForm.setProductname(productdao.getChemname());
			editForm.setUnno(productdao.getUnno());
		}
		
		
	
		
		// notes
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	

	
	
}
