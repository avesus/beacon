package com.bureaueye.beacon.action.job;





import java.util.Iterator;
import java.util.TreeMap;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.struts.action.ActionMessages;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.form.job.MultipleUpdateForm;



import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrmovDTO;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UnitBD;




/**
 *
 * Amendments
 * ----------
 * 	
 */
public final class MultipleUpdate2Action extends BaseAction {





	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {		


		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		MultipleUpdateForm saveForm = (MultipleUpdateForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();


		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		log.info(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				" Form parameters: "+saveForm.toString()
		);	




		// error validation		

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


			//init bd				
			JobmovBD jobmovbd=new JobmovBD(this.getSessionFactoryClusterMap());

			Jobmov jobmovCopyfrom = null;




			//GET SELECTED MOVEMENTS FOR ORDER JOBS========================================================>
			// get selected rows
			if (saveForm.getList1() != null) {			
				int[] selectedObjects1 = saveForm.getSelectedObjects1();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();
				if (selectedObjects1 != null) {
					for (int i = 0; i < selectedObjects1.length; i++) {
						tm.put(new Integer(selectedObjects1[i]),new Integer(selectedObjects1[i]));			
					}
				}
				int count=0;
				jobmovCopyfrom = jobmovbd.read(new Integer(saveForm.getJobmovId()));
				if (jobmovCopyfrom != null) {
					for (Iterator it = saveForm.getList1().iterator(); it.hasNext();) {
						// get row
						JobhdrmovDTO row = (JobhdrmovDTO)it.next();
						// selected
						if (tm.get(new Integer(row.getJobmovId())) != null) {

							log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
									" selected List1 = " + row.getJobmovId());


							// set primary key
							Integer pk = null;		
							try {
								pk = new Integer(row.getJobmovId());			
							} catch (Exception e) {}
							// find data-access-object using primary key
							Jobmov jobmovCopyto = jobmovbd.read(pk);						


							try {

								//BeanUtils.copyProperties(jobmovCopyto, jobmovCopyfrom);
								jobmovCopyto.setActfromdate(jobmovCopyfrom.getActfromdate());
								jobmovCopyto.setActtodate(jobmovCopyfrom.getActtodate());							
								jobmovCopyto.setEstfromdate(jobmovCopyfrom.getEstfromdate());
								jobmovCopyto.setEsttodate(jobmovCopyfrom.getEsttodate());

								jobmovCopyto.setEstfromtime(jobmovCopyfrom.getEstfromtime());
								jobmovCopyto.setEsttotime(jobmovCopyfrom.getEsttotime());								
								jobmovCopyto.setActfromtime(jobmovCopyfrom.getActfromtime());
								jobmovCopyto.setActtotime(jobmovCopyfrom.getActtotime());	

								jobmovCopyto.setEstfromtimeinmillis(jobmovCopyfrom.getEstfromtimeinmillis());
								jobmovCopyto.setEsttotimeinmillis(jobmovCopyfrom.getEsttotimeinmillis());
								jobmovCopyto.setActfromtimeinmillis(jobmovCopyfrom.getActfromtimeinmillis());
								jobmovCopyto.setActtotimeinmillis(jobmovCopyfrom.getActtotimeinmillis());

								jobmovbd.createOrUpdate(jobmovCopyto, user);

								// init latest movement details for unit
								Jobmov mov = null;
								if (jobmovCopyto.getActfromtimeinmillis().longValue() > 0 || jobmovCopyto.getActtotimeinmillis().longValue() > 0) {
									mov = jobmovbd.findLastActualJobmovByUnitId(jobmovCopyto.getUnitId());
									if (mov != null) {		
										UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
										Unit unitdao = unitbd.read(jobmovCopyto.getUnitId());
										// update unit job movement details 	
										if (unitdao != null) {
											if (mov.getActfromtimeinmillis().longValue() > 0) {
												unitdao.setJobmovlocationkey(mov.getFromlocationkey());
												unitdao.setJobmovtime(mov.getActfromtime());
												unitdao.setJobmovdate(mov.getActfromdate());
												unitdao.setJobmovtimeinmillis(mov.getActfromtimeinmillis());									
											}
											if (mov.getActtotimeinmillis().longValue() > 0) {
												unitdao.setJobmovlocationkey(mov.getTolocationkey());
												unitdao.setJobmovtime(mov.getActtotime());
												unitdao.setJobmovdate(mov.getActtodate());
												unitdao.setJobmovtimeinmillis(mov.getActtotimeinmillis());								
											}						
											unitdao.setJobmovref(mov.getMovref());

											unitdao.setInvsts(mov.getInvsts());
											unitdao.setMovests(mov.getMovests());

											unitdao.setJobmovvessel(mov.getVessel());										

											unitbd.createOrUpdate(unitdao, user);
										}					

									}
								} // check actualised

								count++;
							} catch (Exception e) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
										" Order Jobs Movement update for JobmovId: "+row.getJobmovId()+
										" exception: "+e.getMessage()
								);									
							}

						}
					}

					if (count>0) {
						// Add information message 
						appInformationMessages.add(
								"messages.multipleupdate",
								new ActionMessage(
										"information.jobmovements.updated",
										count
								)
						);
						saveAppInformationMessages(request, appInformationMessages);
					}

				}
			}
			//GET SELECTED MOVEMENTS FOR ORDER JOBS========================================================<			




			//GET SELECTED MOVEMENTS FOR ORDER CONSIGNMENTS========================================================>
			// get selected rows
			if (saveForm.getList2() != null) {			
				int[] selectedObjects2 = saveForm.getSelectedObjects2();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();
				if (selectedObjects2 != null) {
					for (int i = 0; i < selectedObjects2.length; i++) {
						tm.put(new Integer(selectedObjects2[i]),new Integer(selectedObjects2[i]));			
					}
				}
				int count=0;
				jobmovCopyfrom = jobmovbd.read(new Integer(saveForm.getJobmovId()));
				if (jobmovCopyfrom != null) {
					for (Iterator it = saveForm.getList2().iterator(); it.hasNext();) {
						// get row
						JobhdrmovDTO row = (JobhdrmovDTO)it.next();
						// selected
						if (tm.get(new Integer(row.getJobmovId())) != null) {

							log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
									" selected List2 = " + row.getJobmovId());


							// set primary key
							Integer pk = null;		
							try {
								pk = new Integer(row.getJobmovId());			
							} catch (Exception e) {}
							// find data-access-object using primary key
							Jobmov jobmovCopyto = jobmovbd.read(pk);						


							try {

								//BeanUtils.copyProperties(jobmovCopyto, jobmovCopyfrom);
								jobmovCopyto.setActfromdate(jobmovCopyfrom.getActfromdate());
								jobmovCopyto.setActtodate(jobmovCopyfrom.getActtodate());							
								jobmovCopyto.setEstfromdate(jobmovCopyfrom.getEstfromdate());
								jobmovCopyto.setEsttodate(jobmovCopyfrom.getEsttodate());

								jobmovCopyto.setEstfromtime(jobmovCopyfrom.getEstfromtime());
								jobmovCopyto.setEsttotime(jobmovCopyfrom.getEsttotime());								
								jobmovCopyto.setActfromtime(jobmovCopyfrom.getActfromtime());
								jobmovCopyto.setActtotime(jobmovCopyfrom.getActtotime());	

								jobmovCopyto.setEstfromtimeinmillis(jobmovCopyfrom.getEstfromtimeinmillis());
								jobmovCopyto.setEsttotimeinmillis(jobmovCopyfrom.getEsttotimeinmillis());
						
								jobmovCopyto.setActfromtimeinmillis(jobmovCopyfrom.getActfromtimeinmillis());
								jobmovCopyto.setActtotimeinmillis(jobmovCopyfrom.getActtotimeinmillis());

								jobmovCopyto.setTotimeinmillis(jobmovCopyfrom.getTotimeinmillis());		
								jobmovCopyto.setFromtimeinmillis(jobmovCopyfrom.getFromtimeinmillis());		
								
								jobmovbd.createOrUpdate(jobmovCopyto, user);

								// init latest movement details for unit
								Jobmov mov = null;
								if (jobmovCopyto.getActfromtimeinmillis().longValue() > 0 || jobmovCopyto.getActtotimeinmillis().longValue() > 0) {
									mov = jobmovbd.findLastActualJobmovByUnitId(jobmovCopyto.getUnitId());
									if (mov != null) {		
										UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
										Unit unitdao = unitbd.read(jobmovCopyto.getUnitId());
										// update unit job movement details 	
										if (unitdao != null) {
											if (mov.getActfromtimeinmillis().longValue() > 0) {
												unitdao.setJobmovlocationkey(mov.getFromlocationkey());
												unitdao.setJobmovtime(mov.getActfromtime());
												unitdao.setJobmovdate(mov.getActfromdate());
												unitdao.setJobmovtimeinmillis(mov.getActfromtimeinmillis());									
											}
											if (mov.getActtotimeinmillis().longValue() > 0) {
												unitdao.setJobmovlocationkey(mov.getTolocationkey());
												unitdao.setJobmovtime(mov.getActtotime());
												unitdao.setJobmovdate(mov.getActtodate());
												unitdao.setJobmovtimeinmillis(mov.getActtotimeinmillis());								
											}						
											unitdao.setJobmovref(mov.getMovref());

											unitdao.setInvsts(mov.getInvsts());
											unitdao.setMovests(mov.getMovests());

											unitdao.setJobmovvessel(mov.getVessel());										

											unitbd.createOrUpdate(unitdao, user);
										}					

									}
								} // check actualised

								count++;
							} catch (Exception e) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
										" Order Consignments Movement update for JobmovId: "+row.getJobmovId()+
										" exception: "+e.getMessage()
								);									
							}

						}
					}

					if (count>0) {
						// Add information message 
						appInformationMessages.add(
								"messages.multipleupdate",
								new ActionMessage(
										"information.consignmentmovements.updated",
										count
								)
						);
						saveAppInformationMessages(request, appInformationMessages);
					}

				}
			}
			//GET SELECTED MOVEMENTS FOR ORDER CONSIGNMENTS========================================================<




			//clear bd		
			jobmovbd=null;

			
			//UPDATE DASHBOARD POOL========================================================>
			// check dashboard pool already exists
			DashboardPool pool = DashboardPool.getPool(session);
			if (pool!=null) {
			
				//JOB_MOVEMENTS_TO_ACTUALISE
				try {
					pool.setJOB_MOVEMENTS_TO_ACTUALISE();
				} catch (Exception e) {	
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
							"JOB_MOVEMENTS_TO_ACTUALISE - Exception: "+e.getMessage());					
				}				

				//store dashboard pool in user's session
				DashboardPool.setPool(session, pool);

			}//if (pool==null) {
			//UPDATE DASHBOARD POOL========================================================<
			
			
			
		}//check submit button not null




		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
	}


	void println(String s) { System.out.println(s); }







}
