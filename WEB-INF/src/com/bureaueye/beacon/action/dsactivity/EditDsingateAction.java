package com.bureaueye.beacon.action.dsactivity;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

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
import com.bureaueye.beacon.form.dsactivity.DsingateForm;
import com.bureaueye.beacon.model.dsactivity.Dsingate;
import com.bureaueye.beacon.model.dsactivity.bd.DsingateBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.DocnoBD;






public final class EditDsingateAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);	
		DsingateForm editForm = (DsingateForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Dsingate dao = null; 
			
		if (!(action == null || action.equals("Create"))) {

			dao = new DsingateBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getDsingateId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getDsingateId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getDsingateId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		
			
	
			if (action.equals("Copy")) {
				editForm.setCopyId(editForm.getDsingateId());											
				editForm.setAction("Create");
				action="Create";
			}
						
			
		}



		// set defaults for Create process
		if (action.equals("Create")) {
			
			try {
				PropertyResourceBundle props = 
					(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
				if (props.getString("eirin.auto.generate").equals("yes")) {
					// get next doc no
					int nextdocno = 0;
					nextdocno = new DocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
							"EIRIN",
							"",
							0,
							user
					);
					DecimalFormat df = new DecimalFormat(props.getString ("eirin.format"));
					editForm.setEirin(df.format(nextdocno));
					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"nextdocno["+editForm.getEirin()+"]: "+
							"userid["+user.getUserid()+"]"
							);					
				}
				editForm.setEirinver("1");//always default to first version
			} catch (Exception e) {				
				log.error(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"Exception["+e.getMessage()+"]"
						);				
			}
		
		
		}
		


				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
