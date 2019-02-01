package com.bureaueye.beacon.action.order;



import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.order.ListOrdersummaryForm;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryChargeDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.standard.User;






public final class SaveOrdersummaryAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ListOrdersummaryForm saveForm = (ListOrdersummaryForm) form;
		//String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();


		// If the session has timed-out then take the user back to the login page
		if (
				//action == null || 
				session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
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


		
		if (saveForm.getBtnSubmit() != null) {


			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" button = " + saveForm.getBtnSubmit());


			//PROCESS INVOICE========================================================>
			if (saveForm.getBtnSubmit().equals("Invoice")) {

				//init bd
				OrderchargeBD orderchargebd = new OrderchargeBD(this.getSessionFactoryClusterMap());

				// get selected rows
				int[] selectedObjects = saveForm.getSelectedObjects();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();

				if (selectedObjects != null) {
					for (int i = 0; i < selectedObjects.length; i++) {
						tm.put(new Integer(selectedObjects[i]),new Integer(selectedObjects[i]));			
					}
				}


				for (Iterator it = saveForm.getList().iterator(); it.hasNext();) {

					// get row
					OrdersummaryChargeDTO row = (OrdersummaryChargeDTO)it.next();

					// only process rows which are NOT INVOICED or READY FOR INVOICING
					if (
							row.getInvoicestatus().equals("") || 
							row.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)
					) {

						// selected
						if (tm.get(row.getOrderchargeId()) != null) {
							// and NOT INVOICED - flag to READY FOR INVOICING
							if (row.getInvoicestatus().equals("")) {
								// 	find row
								Ordercharge updateDTO = orderchargebd.read( row.getOrderchargeId() );				
								if (updateDTO != null) {
									// store non-update fields
									// populate data-transfer-object 
									updateDTO.setInvoicestatus(com.bureaueye.beacon.bean.Constants.READY_STATUS);
									//restore non-update fields
									// update row						
									orderchargebd.createOrUpdate(updateDTO, user);
								}
							}					
						} 
						// not selected 
						else {
							// and READY FOR INVOICE was set - flag back to NOT INVOICED
							if (row.getInvoicestatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)) {
								// 	find row
								Ordercharge updateDTO = orderchargebd.read( row.getOrderchargeId() );				
								if (updateDTO != null) {
									// store non-update fields
									// populate data-transfer-object 
									updateDTO.setInvoicestatus("");
									//restore non-update fields
									// update row						
									orderchargebd.createOrUpdate(updateDTO, user);
								}
							}						
						}

					}

				}

				//clear bd
				orderchargebd=null;

			}
			//PROCESS INVOICE========================================================<		




			//PROCESS JOB HEADER COST POST========================================================>
			if (saveForm.getBtnSubmit().equals("Post1")) {

				//init bd
				JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

				// get selected rows
				int[] selectedObjects = saveForm.getSelectedObjects2();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();

				if (selectedObjects != null) {
					for (int i = 0; i < selectedObjects.length; i++) {
						tm.put(new Integer(selectedObjects[i]),new Integer(selectedObjects[i]));					
					}
				}

				List lineItems = saveForm.getLineItems(1);			
				for (Iterator it = lineItems.iterator(); it.hasNext();) {

					// get row
					OrdersummaryJobcostDTO row = (OrdersummaryJobcostDTO)it.next();

					// only process rows which are NOT INVOICED or READY FOR INVOICING
					if (
							row.getPoststatus().equals("") || 
							row.getPoststatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)
					) {

						// selected
						if (tm.get(row.getJobcostId()) != null) {
							// and NOT POSTED - flag to READY 
							if (row.getPoststatus().equals("")) {
								// 	find row
								Jobcost jobcostdao = jobcostbd.read( row.getJobcostId() );				
								if (jobcostdao != null) {
									// store fields
									jobcostdao.setPoststatus(com.bureaueye.beacon.bean.Constants.READY_STATUS);
									jobcostdao.setAioutId(createPost(jobcostdao,user));
									// update row						
									jobcostbd.createOrUpdate(jobcostdao, user);
								}
							}					
						} 
						// not selected 
						else {
							// and READY  was set - flag back to NOT POSTED
							if (row.getPoststatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)) {
								// 	find row
								Jobcost jobcostdao = jobcostbd.read( row.getJobcostId() );				
								if (jobcostdao != null) {
									//delete posting
									deletePost(jobcostdao,user);
									// reset fields
									jobcostdao.setPoststatus("");
									jobcostdao.setAioutId(null);
									// update row						
									jobcostbd.createOrUpdate(jobcostdao, user);
								}
							}						
						}

					}

				}

				//clear bd
				jobcostbd=null;

			}
			//PROCESS JOB HEADER COST POST========================================================<




			//PROCESS JOB MOVEMENT COST POST========================================================>
			if (saveForm.getBtnSubmit().equals("Post2")) {

				//init bd
				JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

				// get selected rows
				int[] selectedObjects = saveForm.getSelectedObjects3();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();

				if (selectedObjects != null) {
					for (int i = 0; i < selectedObjects.length; i++) {
						tm.put(new Integer(selectedObjects[i]),new Integer(selectedObjects[i]));					
					}
				}

				List lineItems = saveForm.getLineItems(2);			
				for (Iterator it = lineItems.iterator(); it.hasNext();) {

					// get row
					OrdersummaryJobcostDTO row = (OrdersummaryJobcostDTO)it.next();

					// only process rows which are NOT INVOICED or READY FOR INVOICING
					if (
							row.getPoststatus().equals("") || 
							row.getPoststatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)
					) {

						// selected
						if (tm.get(row.getJobcostId()) != null) {
							// and NOT POSTED - flag to READY 
							if (row.getPoststatus().equals("")) {
								// 	find row
								Jobcost jobcostdao = jobcostbd.read( row.getJobcostId() );				
								if (jobcostdao != null) {
									// store fields
									jobcostdao.setPoststatus(com.bureaueye.beacon.bean.Constants.READY_STATUS);
									jobcostdao.setAioutId(createPost(jobcostdao,user));
									// update row						
									jobcostbd.createOrUpdate(jobcostdao, user);
								}
							}					
						} 
						// not selected 
						else {
							// and READY  was set - flag back to NOT POSTED
							if (row.getPoststatus().equals(com.bureaueye.beacon.bean.Constants.READY_STATUS)) {
								// 	find row
								Jobcost jobcostdao = jobcostbd.read( row.getJobcostId() );				
								if (jobcostdao != null) {
									//delete posting
									deletePost(jobcostdao,user);
									// reset fields
									jobcostdao.setPoststatus("");
									jobcostdao.setAioutId(null);
									// update row						
									jobcostbd.createOrUpdate(jobcostdao, user);
								}
							}						
						}

					}

				}

				//clear bd
				jobcostbd=null;

			}
			//PROCESS JOB MOVEMENT COST POST========================================================<




		}//button check



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}



	//generate posting record===============================================>
	public Integer createPost(
			Jobcost dao,
			User user
	) throws Exception {	
		
		Integer aioutId = 0;
		
		AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
		JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		
		//retreive header
		Jobhdr jobhdrdao = jobhdrbd.read( dao.getJobhdrId() );
		
		if (jobhdrdao!=null) {
			Orderhdr orderhdrdao = orderhdrbd.read( jobhdrdao.getOrderhdrId() );
			
			Aiout aioutdao = new Aiout();
			//retrieve aiout record 
			if (dao.getAioutId()!=null) {
				try {
					aioutdao = aioutbd.read(dao.getAioutId()); 
				} catch (Exception e) {}
			}

			try {
				//check not already sent
				if (aioutdao.getSentdate()==null) {
					aioutdao.setDockey(dao.getJobhdrId().toString()+"-"+dao.getJobcostId().toString());
					aioutdao.setAiid(dao.getJobhdrId().toString()+"-"+dao.getJobcostId().toString());					
					aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
					aioutdao.setDoctype(com.bureaueye.beacon.bean.Constants.AP_ACCRUAL);
					aioutdao.setCompanykey(orderhdrdao.getCompanykey());
					aioutdao.setDepartmentkey(orderhdrdao.getDepartmentkey());
					aioutdao.setActivitykey(orderhdrdao.getActivitykey());
					aioutdao.setWarnings("");					
					aioutdao.setErrors("");
					aioutdao.setDocument("");
					aioutdao.setCompanyid("");						
					aioutdao.setActioncode("");	
					aioutdao.setProcessstatus("");	
					aioutdao.setFilename("");
					aioutdao.setControlid("");
					
					// create/update aiout recod
					aioutbd.createOrUpdate(aioutdao, user);

					aioutId=aioutdao.getAioutId();
				}
			} catch (Exception e) {
			}
		}
		aioutbd = null;
		jobhdrbd = null;
		orderhdrbd = null;
		
		return aioutId;
	}
	//generate posting record===============================================<


	//remove posting record===============================================>
	public void deletePost(
			Jobcost dao,
			User user
	) throws Exception {	
		AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());

		Aiout aioutdao = new Aiout();
		//retrieve aiout record 
		if (dao.getAioutId()!=null) {
			try {
				aioutdao = aioutbd.read(dao.getAioutId()); 
			} catch (Exception e) {}
		}

		try {
			//check not already sent
			if (aioutdao.getSentdate()==null) {
				// create/update aiout recod
				aioutbd.delete(aioutdao, user);
			}
		} catch (Exception e) {
		}

		aioutbd = null;
	}
	//remove posting record===============================================<



}
