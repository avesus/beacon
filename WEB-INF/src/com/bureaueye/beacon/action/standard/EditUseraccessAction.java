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
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.standard.UseraccessForm;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;




/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module 
 *
 */
public final class EditUseraccessAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UseraccessForm editForm = (UseraccessForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals("Create"))) {

			Integer pk = new Integer(editForm.getUseraccessId());
			Useraccess dao = new UseraccessBD(this.getSessionFactoryClusterMap()).read(pk);

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for Main Id: "
						+ editForm.getUserid() + ", "
						+ "Record Id: " + editForm.getAccessid());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getUserid()
								+ " - " + editForm.getAccessid()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dao);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			}  catch (Exception e) {
				}		

			if (action.equals("Copy")) {
				editForm.setUseraccessId(null);
				editForm.setAction("Create");
			}


			
		}

		
		// set collections

		
		// set defaults for Create process
		if (action.equals("Create")) {
			// default user information			
		}
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
