package com.bureaueye.beacon.action.account;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.account.AIOutForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.standard.User;





/**
 *
 * Amendments
 * ----------
 *										
 */
public final class SaveAIOutAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		AIOutForm saveForm = (AIOutForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		


		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("Cancel transaction");
			return findSuccess(mapping);
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		// Generate Business Delegate
		AioutBD bd = new AioutBD(this.getSessionFactoryClusterMap());

		// process to Fix Error or Re-send
		if (
				action.equals("FixError") ||
				action.equals("ReSend")
		) {

			Aiout dao = bd.read(new Integer(saveForm.getAioutId()));
			dao.setSentdate(null);
			dao.setSenttime(null);
			dao.setAistatus("PENDING");
			dao.setAibatchId(null);
			dao.setErrors("");
			dao.setDocument("");

			bd.createOrUpdate(dao, user);

		}
		else {	

			//delete
			if (action.equals("Delete")) {
				bd.delete(new Aiout(new Integer(saveForm.getAioutId())), user);
				
				//reset status 
				//IF 'AP_ACCRUAL' DOCUMENT TYPE (ORDER SUMMARY COST POST)
				//AIOUT_ID STORED ON JOBCOST
				
				//IF 'AP_ACTUAL' DOCUMENT TYPE (PURCHASE INVOICE HEADER APPROVED INVOICE)
				//AIOUT_ID STORED ON PIHDR
				
				//IF 'AR' DOCUMENT TYPE (SALES INVOICE PRINT INVOICE)
				//AIOUT_ID STORED ON SIHDR
				
				
			} else {

				//edit action
				if (action.equals("Edit")) {
					//create, edit and copy
					// set primary key
					Integer pk = null;		
					try {
						pk = new Integer(saveForm.getAioutId());			
					} catch (Exception e) {}

					//read record
					Aiout dao = bd.read(pk);				

					try {
						BeanUtils.copyProperties(dao, saveForm);
					} catch (IllegalAccessException ite) {	
					} catch (InvocationTargetException ite) {
					} catch (Exception e) {
					}

					bd.createOrUpdate(dao, user);

				} 
				//create or copy action
				else {						

					Aiout dao = new Aiout();

					try {
						BeanUtils.copyProperties(dao, saveForm);
					} catch (IllegalAccessException ite) {	
					} catch (InvocationTargetException ite) {
					} catch (Exception e) {
					}

					bd.createOrUpdate(dao, user);					
				}


				// Find the form
				ListForm listform = (ListForm) session.getAttribute("List"+mapping.getName());

				// 	Reset the parameters as if it was the first time in
				listform.setStartPage();

			}

		}

		//clear bd
		bd=null;


		log.debug(" Forwarding to success page");
		return findSuccess(mapping);

	}

}
