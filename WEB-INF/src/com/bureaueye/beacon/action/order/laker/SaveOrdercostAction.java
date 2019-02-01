package com.bureaueye.beacon.action.order.laker;

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
import com.bureaueye.beacon.form.order.OrdercostForm;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.bd.OrdercostBD;
import com.bureaueye.beacon.model.standard.User;


/**
 * 
 * Amendments
 * ----------
 * 
 * LAKER BESPOKE (COPY FROM com.bureaueye.beacon.action.order.SaveOrdercostAction)
 *  
 */
public final class SaveOrdercostAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrdercostForm saveForm = (OrdercostForm) form;
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
		OrdercostBD bd = new OrdercostBD(this.getSessionFactoryClusterMap());
		JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());		
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());


		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getOrdercostId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Ordercost dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Ordercost();
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
		BeanUtils.copyProperties(dao, saveForm);



		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {	

			try {
				//delete DUMMY Job cost record
				Jobcost jobcostdao = jobcostbd.findJobcostByCostlinkkey(dao.getOrdercostId().toString()); 
				// if linked jobcost found - delete
				if (jobcostdao!=null) {
					jobcostbd.delete(jobcostdao, user);
				}
			} catch (Exception e) {
			}			

			bd.delete(new Ordercost(pk), user);	

		} else {

			bd.createOrUpdate(dao, user);


			try {
				//generate and update DUMMY Job cost record
				Jobcost jobcostdao = jobcostbd.findJobcostByCostlinkkey(dao.getOrdercostId().toString()); 
				// not found create empty object
				if (jobcostdao==null) {
					jobcostdao = new Jobcost();
				}
				Jobhdr jobhdrdao = jobhdrbd.findFirstJobhdrByOrdhdrId(dao.getOrderhdrId().toString());
				// check header found
				if (jobhdrdao!=null) {
					BeanUtils.copyProperties(jobcostdao, dao);			
					jobcostdao.setJobhdrId(jobhdrdao.getJobhdrId());
					jobcostdao.setJobmovId(0);					
					jobcostdao.setOqlinkKey(dao.getOrdercostId());
					jobcostdao.setPoststatus("");					
					//store job cost record
					jobcostbd.createOrUpdate(jobcostdao, user);
				}
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update dummy job cost: Exception: "+e.getMessage());
			}


			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
		}


		//clear objects
		bd = null;
		jobhdrbd = null;		
		jobcostbd = null;


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);


	}
}
