package com.bureaueye.beacon.action.purchaseinvoice;



import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.StringTokenizer;

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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.purchaseinvoice.PidtlcostForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.standard.User;




public final class SavePihdrcostAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PidtlcostForm saveForm = (PidtlcostForm) form;
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
		PidtlcostBD bd = new PidtlcostBD(this.getSessionFactoryClusterMap());
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());


		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getPidtlcostId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Pidtlcost dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Pidtlcost();
		}



		//check not a miscellaneous invoice
		if (!saveForm.isMiscflag()) {

			//init job cost id
			Integer jobcostid = dao.getJobcostId();
			Jobcost jobcostdao = null;
			if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {	

				//init cost field
				try {
					StringTokenizer tokenizer = new StringTokenizer(saveForm.getCostkey(),"|");
					jobcostid = new Integer(tokenizer.nextToken());
				} catch (Exception e) {
				}

				//init cost field
				try {
					jobcostdao = jobcostbd.read(jobcostid);
					//init job cost fields
					saveForm.setCostkey(jobcostdao.getCostkey());
					saveForm.setCstamttotal(jobcostdao.getCstamt().toString());
					saveForm.setJobhdrId(jobcostdao.getJobhdrId().toString());
					saveForm.setJobmovId(jobcostdao.getJobmovId().toString());
					saveForm.setJobcostId(jobcostdao.getJobcostId().toString());
				} catch (Exception e) {}	


				//error validation==================================================>

				// THIS WORKS -- check actual cost entered is not more than estimate cost
				try {
					float estimatecost = new BigDecimal(saveForm.getCstamttotal()).floatValue();
					float actualcost = new BigDecimal(saveForm.getCstamtalloc()).floatValue();

					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+
							" esimate cost: " +estimatecost+
							" actual cost: " +actualcost
					);

					if (actualcost > estimatecost) {
						errors.add("informationMessage",new ActionMessage("errors.cannotbegreaterthan","Actual Cost","Job Cost"));									
					}
				} catch (Exception e) {
					errors.add("informationMessage",new ActionMessage("errors.invalid","Actual Cost"));
				}	


				// THIS WORKS -- check ALL actual costs entered FOR ALL PI are not more than Job Cost 
				try {
					float estimatecost = new BigDecimal(saveForm.getCstamttotal()).floatValue();
					float cstamtalloc = new BigDecimal(saveForm.getCstamtalloc()).floatValue();				
					BigDecimal cstamtalloctotal = bd.pidtlcostsCstamtallocSumByJobcostid(jobcostid);
					float cstamtalloctotal2 = 0;
					if (cstamtalloctotal!=null) cstamtalloctotal2=cstamtalloctotal.floatValue()+cstamtalloc;
					else cstamtalloctotal2=cstamtalloc;

					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+
							" job cost amount: " +estimatecost+
							" cost amounts allocated total: " +cstamtalloctotal2
					);				

					if (cstamtalloctotal2 > estimatecost) {
						errors.add("informationMessage",new ActionMessage(
								"errors.cannotbegreaterthan",
								"Actual Cost Total: "+new CurrencyFormatter().format(new BigDecimal(cstamtalloctotal2)),
								"Job Cost Amount: "+new CurrencyFormatter().format(new BigDecimal(estimatecost))
						)
						);					
					}	

				} catch (Exception e) {
				}			
				//error validation==================================================<

			}//end of create action

		}//check miscellaneous invoice



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

			bd.delete(dao, user);	

		} else {


			// populate data-transfer-object from form
			// init FORM with dao values
			try {
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	




			bd.createOrUpdate(dao, user);



			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();

		}

		// clear Business Delegate
		bd = null;
		jobcostbd = null; 		


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}






}
