package com.bureaueye.beacon.action.order;

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
import com.bureaueye.beacon.form.order.OrderchargeForm;

import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.User;


public final class SaveOrderchargeAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrderchargeForm orderchargeForm = (OrderchargeForm) form;
		String action = orderchargeForm.getAction();
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
		OrderchargeBD bd = new OrderchargeBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(orderchargeForm.getOrderchargeId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Ordercharge dto = bd.read(pk);
		// not found create empty object
		if (dto == null) {
			dto = new Ordercharge();
		}

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
		
		
		// populate data-transfer-object from form
		// init FORM with DTO values
		BeanUtils.copyProperties(dto, orderchargeForm);
					
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Ordercharge(pk), user);		
		} else {
			
			bd.createOrUpdate(dto, user);

			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName()))
					.setStartPage();
		}

		
		// update header information
		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		Orderhdr orderhdr = null;
		try{orderhdr = orderhdrbd.read(new Integer(orderchargeForm.getOrderhdrId()));}catch (Exception e){}
		if (orderhdr != null) {
			orderhdr.setInvoicestatus(orderhdrbd.getOrderhdrInvoicestatus(orderchargeForm.getOrderhdrId()));
			orderhdrbd.createOrUpdate(orderhdr, user);
		}		


		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}
}
