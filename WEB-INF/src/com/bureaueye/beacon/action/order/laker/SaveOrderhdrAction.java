package com.bureaueye.beacon.action.order.laker;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletContext;
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
import com.bureaueye.beacon.bean.standard.DataPool;
import com.bureaueye.beacon.bean.standard.Gcode;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.order.laker.OrderhdrForm;



import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrdercostBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vessel;
import com.bureaueye.beacon.model.standard.bd.VesselBD;



/**
 * 
 * Amendments
 * ----------
 * 
 * LAKER BESPOKE (COPY FROM com.bureaueye.beacon.action.order.SaveOrderhdrAction)
 *
 * NT 2014-05-26 201400021 Add Log messages to Order Copy routine to check for record duplications
 *
 * NT 2014-06-06 201400025 Patch Fix for Order charge duplication problem
 * - Add Check to Sales Invoice Build and Delete process to check for Order charge duplications
 * - clear CopyId after copy process
 *
 * NT 2015-04-02 201500012 Beacon enhancements 
 * 	- Assign Orderno to Jobno and JobhdrId 
 * 
 */
public final class SaveOrderhdrAction extends BaseAction {


	//laker default fields
	private static String SECTIONKEY="AVES";
	private static String PRODUCTKEY="NOPRODUCT";
	private static String UNITKEY="VSSL1111111";
	private static String UNIT_ID="1";	
	private static String SHIPMETHOD="PP";
	private static String CONTRACTTYPE="SPOT";
	private static String WGHTUNIT="kgs";


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {


		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OrderhdrForm saveForm = (OrderhdrForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();


		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}


		//check for navigation
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Navigate to " + saveForm.getForwardname());
		if (!saveForm.getForwardname().equals("")) {				
			return (mapping.findForward(saveForm.getForwardname()));
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");


		// Generate Business Delegate
		OrderhdrBD bd = new OrderhdrBD(this.getSessionFactoryClusterMap());	
		JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
		JobmovBD jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());
		OrderprodBD orderprodbd = new OrderprodBD(this.getSessionFactoryClusterMap());


		// find record
		Orderhdr dao = null;
		try {
			dao = bd.read(new Integer(saveForm.getId()));
		} catch (Exception e) {
		}



		// business validation
		if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
			// check for duplicate number
			Orderhdr duplicate = null;
			try{duplicate=bd.findOrderhdrByOrderno(saveForm.getOrderno());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.orderhdr.unique"));				
			}
		}


		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			saveForm.setForwardname("orderhdr1");
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			saveForm.setForwardname("orderhdr1");			
			return (mapping.getInputForward());
		}


		if (action.equals(com.bureaueye.beacon.bean.Constants.DELETE_ACTION)) {

			//201400021
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Processing Delete Order - OrderhdrId: "+saveForm.getId()+
					" Userid: "+user.getUserid()
					);
			
			try {
				//delete all job records
				Jobhdr jobhdrdao = jobhdrbd.findFirstJobhdrByOrdhdrId(saveForm.getId());
				if (jobhdrdao!=null) {				

					//201400021
					log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Processing Delete Job - JobhdrId: "+jobhdrdao.getJobhdrId()+
							" Userid: "+user.getUserid()
							);
					
					jobhdrbd.deleteAll(jobhdrdao.getJobhdrId(), user);						
				}
			} catch (Exception e) {
			}

			//delete all order records
			bd.deleteAll(new Integer(saveForm.getId()), user);

		} else {


			if (dao == null) { dao = new Orderhdr(); }


			//check complete flag changed
			try {
				if (saveForm.isCompleteflag()!=dao.isCompleteflag()) {
					//clear audit fields
					dao.setCompletedate(null);
					dao.setCompletetime("");
					dao.setCompleteuserid("");	
					if (saveForm.isCompleteflag()) {
						//set audit fields
						Calendar c = Calendar.getInstance();
						dao.setCompletedate(c.getTime());
						dao.setCompletetime(com.bureaueye.beacon.util.Util.toTime(c));
						dao.setCompleteuserid(user.getUserid());
					}
				}
			} catch (Exception e){			
			}


			//if create function 
			if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
				//special code to generate VESSEL if entered manually
				if (saveForm.getShipvessel().equals("") && !saveForm.getShipvessel2().equals("")) {
					try {
						VesselBD vesselbd = new VesselBD(this.getSessionFactoryClusterMap());	
						//check vessel not already in database
						Vessel vesseldao = null;
						vesseldao = vesselbd.read(saveForm.getShipvessel2());
						if (vesseldao==null) {
							//create vessel and store in database
							vesseldao = new Vessel();
							vesseldao.setVesselkey(saveForm.getShipvessel2());
							vesseldao.setVesselname(saveForm.getShipvessel2());
							vesselbd.createOrUpdate(vesseldao, user);
							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" Create Vessel [" + saveForm.getShipvessel2()+"]"
									);
							
							//refresh vessel datapool list===========================>
							ServletContext context = session.getServletContext();							
							DataPool datapool = null;
							datapool = (DataPool)context.getAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY);
							if (datapool != null) {
								try {
									datapool.setVessels();
								} catch (Exception e) {
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
											"Datapool.setVessels - Exception: "+e.getMessage());					
								}
								context.setAttribute(com.bureaueye.beacon.bean.Constants.DATA_POOL_KEY,datapool);
							}
							//refresh vessel datapool list===========================<
							
						}
						//init shipvessel
						saveForm.setShipvessel(saveForm.getShipvessel2());
					} catch (Exception e) {
					}					
				}
			}//CREATE ACTION
			
			
			
			BeanUtils.copyProperties(dao, saveForm);




			//init LOADING2 gcodes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getLdglocationkey2());
				dao.setLdgg1key2(gcode.getG1codekey());
				dao.setLdgg2key2(gcode.getG2codekey());
				dao.setLdgg3key2(gcode.getG3codekey());
				dao.setLdgg4key2(gcode.getG4codekey());
			} catch (Exception e){			
			}


			//extra init
			dao.setExchgdate(dao.getOrderdate());
			dao.setConsignmentno(dao.getOrderno());
			dao.setContracttype(CONTRACTTYPE);
			dao.setProductkey(PRODUCTKEY);
			dao.setShipmethod(SHIPMETHOD);				
			dao.setDchfromdate(dao.getLdgfromdate());
			dao.setDchtodate(dao.getLdgtodate());		
			dao.setDchlocationkey2(dao.getLdglocationkey2());			
			dao.setDchg1key2(dao.getLdgg1key2());
			dao.setDchg2key2(dao.getLdgg2key2());
			dao.setDchg3key2(dao.getLdgg3key2());
			dao.setDchg4key2(dao.getLdgg4key2());		
			dao.setShipvendoraddrkey(dao.getCustomeraddrkey());
			
			//save header record
			bd.createOrUpdate(dao, user);



			Jobhdr jobhdrdao = null;
			try {
				//generate and update DUMMY Job Header record
				jobhdrdao = jobhdrbd.findFirstJobhdrByOrdhdrId(dao.getId().toString());
				// not found create empty object
				if (jobhdrdao==null) {
					jobhdrdao = new Jobhdr();
					//assign jobhdrid only on new record
					jobhdrdao.setJobhdrId(new Integer(dao.getOrderno()));//201500011					
				}				
				jobhdrdao.setOrderhdrId(dao.getId());
				jobhdrdao.setOrderno(dao.getOrderno());
							
				jobhdrdao.setUnitkey(UNITKEY);
				jobhdrdao.setUnitId(new Integer(UNIT_ID));

				jobhdrdao.setCompanykey(dao.getCompanykey());
				jobhdrdao.setDepartmentkey(dao.getDepartmentkey());	
				jobhdrdao.setActivitykey(dao.getActivitykey());	

				jobhdrdao.setCcykey(dao.getCcykey());
				jobhdrdao.setProductkey(PRODUCTKEY);
				jobhdrdao.setMovref("");
				jobhdrdao.setSealnumber1("");
				jobhdrdao.setSealnumber2("");
				jobhdrdao.setSealnumber3("");
				jobhdrdao.setSealnumber4("");
				jobhdrdao.setSealnumber5("");
				jobhdrdao.setAddinstruction("");			
				jobhdrdao.setWeightactual(new BigDecimal("0.0"));
				jobhdrdao.setWeightactualunit(WGHTUNIT);

				//store job record
				jobhdrbd.createOrUpdate(jobhdrdao, user);	
				// if create then init jobno and save again
				if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
					//jobhdrdao.setJobno(jobhdrdao.getJobhdrId().toString());//201500011
					jobhdrdao.setJobno(dao.getOrderno());//201500011
					jobhdrbd.createOrUpdate(jobhdrdao, user);
				}
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update dummy job header: Exception: "+e.getMessage());
			}

			try {
				//generate and update DUMMY Job Movement record
				Jobmov jobmovdao = jobmovbd.findJobmovByJobhdrIdSectionkey(
						jobhdrdao.getJobhdrId().toString(), 
						SECTIONKEY
				);
				// not found create empty object
				if (jobmovdao==null) {
					jobmovdao = new Jobmov();
				}				
				jobmovdao.setJobhdrId(jobhdrdao.getJobhdrId());
				jobmovdao.setVendoraddrkey(dao.getShipvendoraddrkey());
				jobmovdao.setSectionkey(SECTIONKEY);	
				jobmovdao.setInvsts(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
				jobmovdao.setOrderno(jobhdrdao.getOrderno());

				jobmovdao.setCompanykey(dao.getCompanykey());
				jobmovdao.setDepartmentkey(dao.getDepartmentkey());	
				jobmovdao.setActivitykey(dao.getActivitykey());	

				jobmovdao.setFromdate(dao.getLdgfromdate());
				jobmovdao.setFromtime(dao.getLdgfromtime());			
				jobmovdao.setEstfromdate(dao.getLdgfromdate());
				jobmovdao.setEstfromtime(dao.getLdgfromtime());			
				jobmovdao.setActfromdate(dao.getLdgfromdate());
				jobmovdao.setActfromtime(dao.getLdgfromtime());	

				jobmovdao.setTodate(dao.getLdgtodate());
				jobmovdao.setTotime(dao.getLdgtotime());			
				jobmovdao.setEsttodate(dao.getLdgtodate());
				jobmovdao.setEsttotime(dao.getLdgtotime());
				jobmovdao.setActtodate(dao.getLdgtodate());	
				jobmovdao.setActtotime(dao.getLdgtotime());	

				Calendar _time = Calendar.getInstance();
				_time.setTime(jobmovdao.getEstfromdate());
				_time.set(Calendar.HOUR_OF_DAY,0);
				_time.set(Calendar.MINUTE,0);
				_time.set(Calendar.SECOND,0);			
				jobmovdao.setEstfromtimeinmillis(new Long(_time.getTimeInMillis()));
				jobmovdao.setActfromtimeinmillis(jobmovdao.getEstfromtimeinmillis());
				jobmovdao.setFromtimeinmillis(jobmovdao.getEstfromtimeinmillis());					
				_time.setTime(jobmovdao.getEsttodate());
				_time.set(Calendar.HOUR_OF_DAY,0);
				_time.set(Calendar.MINUTE,0);			
				_time.set(Calendar.SECOND,0);				
				jobmovdao.setEsttotimeinmillis(new Long(_time.getTimeInMillis()));
				jobmovdao.setActtotimeinmillis(jobmovdao.getEsttotimeinmillis());									
				jobmovdao.setTotimeinmillis(jobmovdao.getEsttotimeinmillis());				

				jobmovdao.setFromlocationkey(dao.getLdglocationkey2());
				jobmovdao.setFromg1key(dao.getLdgg1key2());
				jobmovdao.setFromg2key(dao.getLdgg2key2());	
				jobmovdao.setFromg3key(dao.getLdgg3key2());	
				jobmovdao.setFromg4key(dao.getLdgg4key2());					
				jobmovdao.setTolocationkey(dao.getLdglocationkey2());
				jobmovdao.setTog1key(dao.getLdgg1key2());
				jobmovdao.setTog2key(dao.getLdgg2key2());	
				jobmovdao.setTog3key(dao.getLdgg3key2());	
				jobmovdao.setTog4key(dao.getLdgg4key2());				
				jobmovdao.setTodate(dao.getLdgtodate());

				jobmovdao.setVessel(dao.getShipvessel());
				jobmovdao.setVoyage(dao.getShipvoyage());
				jobmovdao.setUnitId(jobhdrdao.getUnitId());
				jobmovdao.setMovests(com.bureaueye.beacon.bean.Constants.AVAILABLE_MOVSTS);
				jobmovdao.setBilloflading("");
				jobmovdao.setLloydsnumber("");
				jobmovdao.setTxt("");
				jobmovdao.setTxt2("");
				jobmovdao.setTxt3("");
				jobmovdao.setMovref("");
				jobmovdao.setMmulink("");

				//store movement record
				jobmovbd.createOrUpdate(jobmovdao, user);
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update dummy job movement: Exception: "+e.getMessage());
			}

			try {
				//generate and update DUMMY Order product record
				Orderprod orderproddao = orderprodbd.findFirstOrderprodByOrderhdrId(dao.getId()); 
				// not found create empty object
				if (orderproddao==null) {
					orderproddao = new Orderprod();
				}				
				orderproddao.setOrderhdrId(dao.getId());
				orderproddao.setOrderno(dao.getOrderno());
				orderproddao.setProductkey(PRODUCTKEY);
				orderproddao.setLdgtemp("0.0");
				orderproddao.setLqdtemp("0.0");
				orderproddao.setDchtemp("0.0");
				orderproddao.setSurftemp("0.0");
				orderproddao.setWeight(new BigDecimal(0.0));
				orderproddao.setVolume(new BigDecimal(0.0));
				orderproddao.setComprt("0");				

				//store order product record
				orderprodbd.createOrUpdate(orderproddao, user);
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update dummy order product: Exception: "+e.getMessage());
			}


			// copy all order details
			if (!saveForm.getCopyId().equals("")) {	
				//201400021
				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Processing copyOrder - CopyId: "+saveForm.getCopyId()+
						" Userid: "+user.getUserid()
						);
				Integer orderhdrId = null;
				try{orderhdrId = new Integer(saveForm.getCopyId());}catch(Exception e){}
				if (orderhdrId != null) {
					copyOrderToOrder(orderhdrId, dao, user);
				}
				saveForm.setCopyId("");//201400025
			} 
			
			

			// Find the form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();

			//if create function display new record
			/*if (action.equals(com.bureaueye.beacon.bean.Constants.CREATE_ACTION)) {
				// Set the search parameters
				listform.setSearchString1(dao.getOrderno());
				listform.setSearchString2(dao.getCustomeraddrkey());
			}*/

		}



		//clear objects
		bd = null;	
		jobhdrbd = null;
		jobmovbd = null;
		orderprodbd = null;



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}




	@SuppressWarnings("rawtypes")
	public void copyOrderToOrder(
			Integer orderhdrId, 
			Orderhdr dao,
			User user
	) throws Exception {

		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());			
		OrderchargeBD orderchargebd = new OrderchargeBD(this.getSessionFactoryClusterMap());		
		OrdercostBD ordercostbd = new OrdercostBD(this.getSessionFactoryClusterMap());
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());

		// copy and store charges 
		for (Iterator it = orderhdrbd.getOrdercharges(orderhdrId).iterator(); it.hasNext();) {			
			Ordercharge ordercharge = new Ordercharge();
			BeanUtils.copyProperties(ordercharge, it.next());
			
			//201400021
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" copyOrderToOrder:  Processing Ordercharge from OrderchargeId: "+ordercharge.getOrderchargeId()
					);
			
			ordercharge.setOrderhdrId(dao.getId());
			ordercharge.setOrderchargeId(null);
			ordercharge.setInvoicestatus("");
			ordercharge.setSihdrId(null);//201400025
			ordercharge.setJobmovId(null);//201400025			
			ordercharge.setInvoiceno("");//201400025
			ordercharge.setRowid(0);//201400025			
			orderchargebd.createOrUpdate(ordercharge, user);
		}		

		// copy and store header costs
		for (Iterator it = orderhdrbd.getOrdercosts(orderhdrId).iterator(); it.hasNext();) {			
			Ordercost ordercost = new Ordercost();
			BeanUtils.copyProperties(ordercost, it.next());
			
			//201400021
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" copyOrderToOrder:  Processing Ordercost from OrdercostId: "+ordercost.getOrdercostId()
					);
			
			ordercost.setOrderhdrId(dao.getId());
			ordercost.setOrdercostId(null);					
			ordercostbd.createOrUpdate(ordercost, user);

			try {
				//generate and update DUMMY Job cost record
				Jobcost	jobcostdao = new Jobcost();
				Jobhdr jobhdrdao = jobhdrbd.findFirstJobhdrByOrdhdrId(dao.getId().toString());
				// check header found
				if (jobhdrdao!=null) {			
					BeanUtils.copyProperties(jobcostdao, ordercost);	
					
					//201400021
					log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
							" copyOrderToOrder:  Processing Jobcost for JobhdrId: "+jobhdrdao.getJobhdrId()
							);
					
					jobcostdao.setJobhdrId(jobhdrdao.getJobhdrId());
					jobcostdao.setJobmovId(0);	
					jobcostdao.setJobcostId(null);						
					jobcostdao.setOqlinkKey(ordercost.getOrdercostId());
					jobcostdao.setPoststatus("");
					//store job cost record
					jobcostbd.createOrUpdate(jobcostdao, user);				
				}
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update dummy job cost: Exception: "+e.getMessage());
			}

		}

		orderhdrbd = null;
		jobhdrbd = null;			
		orderchargebd = null;		
		ordercostbd = null;		
		jobcostbd = null;

	}


}
