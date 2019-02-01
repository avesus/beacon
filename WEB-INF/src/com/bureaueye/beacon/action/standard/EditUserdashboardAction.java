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
import com.bureaueye.beacon.form.standard.UserdashboardForm;
import com.bureaueye.beacon.model.standard.Userdashboard;
import com.bureaueye.beacon.model.standard.bd.UserdashboardBD;




/**
 * Amendments
 * ----------
 * 												
 */
public final class EditUserdashboardAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserdashboardForm editForm = (UserdashboardForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals("Create"))) {

			Integer pk = new Integer(editForm.getUserdashboardId());
			Userdashboard dao = new UserdashboardBD(this.getSessionFactoryClusterMap()).read(pk);

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for Main Id: "
						+ editForm.getUserid() + ", "
						+ "Record Id: " + editForm.getDashboardid());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getUserid()
								+ " - " + editForm.getDashboardid()));
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
				editForm.setUserdashboardId(null);
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
