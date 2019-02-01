package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.ProductForm;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.ProductBD;


/*
 *
 * Amendments
 * ----------
 *
 * NT	2010-04-20		201000020		Make Product Maintenance compatible with ITT Tank Traker system
 * 												
 */
public final class SaveProductAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ProductForm saveForm = (ProductForm) form;	
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

		
		
		//check for navigation
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Navigate to " + saveForm.getForwardname());
		if (!saveForm.getForwardname().equals("")) {				
			return (mapping.findForward(saveForm.getForwardname()));
		}
			
			
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");
		
		
		
		
		
		
		// Generate Business Delegate
		ProductBD bd = new ProductBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		String pk = null;		
		try {
			pk = saveForm.getProductkey();			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Product dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Product();
		}
		
		
		
		// error validation 
		
		
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, messages);
			return (mapping.getInputForward());
		}		
		
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Product(pk), user);		
		} else {
			
			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(dto, saveForm);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {			
			} catch (Exception e) {						
			}	
			
			
			//special code to init TT database fields
			dto.setHazardousImo(dto.getDgsnotes());//201000020
			

			bd.createOrUpdate(dto, user);
			
			// Find the quohdr form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());
			
			// Reset the parameters as if it was the first time in
			//listform.setStartPage();
			// Set the search parameters
			//listform.setSearchString3(dto.getChemname());
			
			
			// refresh datapool
			if (action.equals("Create") || action.equals("Delete")) {
				ServletContext context = session.getServletContext();
				
				DataPool datapool = null;
				datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
				if (datapool != null) {
					
					datapool.setProducts();
					
					context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,	datapool);
					// 
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
							com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY
							+ " refreshed on ServletContext");				
				}	
			}
			
			
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
		
	}
	
}
