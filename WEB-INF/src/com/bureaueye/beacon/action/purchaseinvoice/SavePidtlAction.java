package com.bureaueye.beacon.action.purchaseinvoice;



import java.lang.reflect.InvocationTargetException;


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
import com.bureaueye.beacon.form.purchaseinvoice.PidtlForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;


import com.bureaueye.beacon.model.standard.User;




public final class SavePidtlAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PidtlForm saveForm = (PidtlForm) form;
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
		PidtlBD bd = new PidtlBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getPidtlId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Pidtl dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Pidtl();
		}



		// error validation 
		// - Check Job number exists




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


		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {	

			bd.deleteAll(dao.getPidtlId(), user);

		} else {


			// populate data-transfer-object from form
			// init FORM with dao values
			try {
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}				


			if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {				
				//init jobhdrid 
				JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
				Jobhdr jobhdrdao = null;			
				try {				
					jobhdrdao=jobhdrbd.findJobhdrByJobno(dao.getJobno());
					dao.setJobhdrId(jobhdrdao.getJobhdrId());
					//init order no				
					OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
					Orderhdr orderhdrdao = null;
					try {					
						orderhdrdao=orderhdrbd.read(jobhdrdao.getOrderhdrId());				
						dao.setOrderno(orderhdrdao.getOrderno());	
					} catch (Exception e) {}
					orderhdrbd = null;
					orderhdrdao = null;					
				} catch (Exception e) {}
				jobhdrbd = null;
				jobhdrdao = null;
				
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Orderno " + dao.getOrderno()+
						" JobhdrId " + dao.getJobhdrId()						
						);
				
			}

			bd.createOrUpdate(dao, user);







			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();

		}




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}






}
