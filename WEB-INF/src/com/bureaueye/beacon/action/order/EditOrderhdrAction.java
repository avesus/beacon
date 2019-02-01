package com.bureaueye.beacon.action.order;

import java.text.DecimalFormat;
import java.util.Calendar;
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
import com.bureaueye.beacon.form.order.OrderhdrForm;


import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Useraccess;
import com.bureaueye.beacon.model.standard.bd.DocnoBD;
import com.bureaueye.beacon.model.standard.bd.UseraccessBD;



public final class EditOrderhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);		
		OrderhdrForm editForm = (OrderhdrForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);

		String action = editForm.getAction();

		// If the session has timed-out then take the user back to the login page
		if (session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		
		// user access check ---------------------------------------------------->
		ActionMessages appInformationMessages = new ActionMessages();
		// check access for userid and type
		Useraccess useraccessdao = new UseraccessBD(this.getSessionFactoryClusterMap())
		.findUseraccessByKey1(user.getUserid(), mapping.getParameter());				
		if (useraccessdao!= null) {			
			// check action in grant action list
			if (!useraccessdao.getGrantactionlist().contains(action)) {
				// downgrade access to view only if view access in grant action list
				if (
						action.equals(com.bureaueye.beacon.bean.Constants.EDIT_ACTION) &&
						useraccessdao.getGrantactionlist().contains(com.bureaueye.beacon.bean.Constants.VIEW_ACTION)
				) {
					editForm.setAction(com.bureaueye.beacon.bean.Constants.VIEW_ACTION);
					action=com.bureaueye.beacon.bean.Constants.VIEW_ACTION;					
				} else {
					// if user does not have correct access - generate information message
					appInformationMessages.add(
							"errors.useraccess",
							new ActionMessage(
									"information.useraccess", 
									user.getUserid(),
									action,
									mapping.getParameter()
							)
					);	
					saveAppInformationMessages(request, appInformationMessages);
					// if user does not have correct access - return to failure mapping
					return findFailure(mapping);
				}
			}	
		}
		// user access check ---------------------------------------------------->
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction:  Processing " + action + " action");

		if (!(action == null || action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION))) {
			
			Orderhdr dao = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getId()));

			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction: No value found for id "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" EditAction: Populating Form from " + dao);
			
			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dao);				


			// set non-primitive fields 			

			
			// business delegates required for lookup fields
			//editForm.setCustomername(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey()).getName());				
			

			if (action.equals(com.bureaueye.beacon.bean.Constants.COPY_ACTION)) {
				editForm.setCopyId(editForm.getId());
				editForm.setId("");
				editForm.setOrderno("");
				editForm.setQuotno("");				
				editForm.setAction(com.bureaueye.beacon.bean.Constants.CREATE_ACTION);
				action=com.bureaueye.beacon.bean.Constants.CREATE_ACTION;
			}
		}

		// set defaults for Create process
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			
			try {
				PropertyResourceBundle props = 
					(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
				if (props.getString("orderno.auto.generate").equals("yes")) {
					// auto generate number
					int nextdocno = 0;
					Calendar c = Calendar.getInstance();
					nextdocno = new DocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
							"ORDER",
							user.getCompanykey(),
							c.get(Calendar.YEAR),
							user
					);
					DecimalFormat df = new DecimalFormat(props.getString ("orderno.format"));
					editForm.setOrderno(
							props.getString("orderno.prefix")+
							df.format(nextdocno)+
							props.getString("orderno.suffix")
							);
					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"nextdocno["+nextdocno+"]: "+
							"orderno["+editForm.getOrderno()+"]: "+
							"company["+user.getCompanykey()+"]: "+
							"userid["+user.getUserid()+"]"
							);					
				}
			} catch (Exception e) {
				log.error(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"Exception["+e.getMessage()+"]"
						);				
			}
			
			
			
			// default user information
			editForm.setCreateuserid(user.getUserid());
			editForm.setOrderbyuserid(user.getUserid());			
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());
			
			// default status information
			editForm.setOrderstatus("");
			editForm.setInvoicestatus("NOT INVOICED");
			editForm.setCompleteflag(false);	
			
			// default dates to today
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setOrderdate(c.getTime());
				editForm.setExchgdate(c.getTime());
				editForm.setDocumentclosingdate(c.getTime());
				editForm.setTankclosingdate(c.getTime());				
			} catch (Exception e) {}
			
		}
		
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);
	}
}
