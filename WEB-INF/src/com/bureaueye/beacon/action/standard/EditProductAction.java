package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.standard.ProductForm;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.bd.ProductBD;


/*
 *
 * Amendments
 * ----------
 *
 * NT	2010-04-20		201000020		Make Product Maintenance compatible with ITT Tank Traker system
 * 												
 */
public final class EditProductAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		ProductForm editForm = (ProductForm) form;
		
		String action = editForm.getAction();
		
		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" ProductForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		if (!(action == null || action.equals("Create"))) {
			
			Product dto = new ProductBD(this.getSessionFactoryClusterMap()).read(editForm.getProductkey());
			
			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No record found for unit: " + editForm.getProductkey());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getProductkey()));
				saveMessages(request, errors);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Can't delete: forwarding to: "
						+ findFailure(mapping).getPath());
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);
			
			
			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dto);
			} catch (IllegalAccessException ite) {	
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
			}	
			
			
			if (action.equals("Copy")) {
				editForm.setProductkey("");
				editForm.setAction("Create");
			}
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
	}
}
