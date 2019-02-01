package com.bureaueye.beacon.action.job;



import java.util.Calendar;

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
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.bean.standard.Gcode;
import com.bureaueye.beacon.form.job.JobmovForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;
import com.bureaueye.beacon.util.Util;





public final class SaveJobmovAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		JobmovForm saveForm = (JobmovForm) form;
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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveJobmovAction:  Processing " + action+ " action");

		// Generate Business Delegate
		JobmovBD bd = new JobmovBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getJobmovId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Jobmov dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Jobmov();
		}



		if (saveForm.getActtotimeinmillis() > 0 && saveForm.getActfromtimeinmillis() == 0) {
			errors.add("actfromdatedd", new ActionMessage("error.actfromdate.required"));						
		}

		// movement error validation
		// find latest movement details for unit
		Jobmov latestActualJobmov = bd.findLastActualJobmovByUnitId(dao.getUnitId());

		// check actual FROM date/time entered
		if (saveForm.getActfromtimeinmillis() > 0 && 
				(dao.getActfromtimeinmillis() == null || dao.getActfromtimeinmillis().longValue() == 0)
		) {
			// latest Actual movement not found
			if (latestActualJobmov != null) {	
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" from date/time validation - latestActualJobmov.getActfromtime: "+
						latestActualJobmov.getActfromdate()+" "+latestActualJobmov.getActfromtime()+
						" latestActualJobmov.getActtotime: "+
						latestActualJobmov.getActtodate()+" "+latestActualJobmov.getActtotime()+
						" saveForm.getActfromtime: "+
						saveForm.getActfromdate()+" "+saveForm.getActfromtime()						
				);
				if (latestActualJobmov.getActfromtimeinmillis().longValue() > saveForm.getActfromtimeinmillis()) {
					errors.add("actfromdatedd",
							new ActionMessage(
									"error.actfromdate.afterlastmovefromdate", 
									Util.dateTextFormat2(latestActualJobmov.getActfromdate()),
									latestActualJobmov.getActfromtime()
							)
					); 					
				}
				if (latestActualJobmov.getActtotimeinmillis().longValue() > saveForm.getActfromtimeinmillis()) {
					errors.add("actfromdatedd",
							new ActionMessage(
									"error.actfromdate.afterlastmovetodate", 
									Util.dateTextFormat2(latestActualJobmov.getActtodate()),
									latestActualJobmov.getActtotime()
							)
					); 					
				}
			}
		}

		// check actual TO date/time entered
		if (saveForm.getActtotimeinmillis() > 0 && 
				(dao.getActtotimeinmillis() == null || dao.getActtotimeinmillis().longValue() == 0)
		) {
			// latest Actual movement not found 
			if (latestActualJobmov != null) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" to date/time validation - latestActualJobmov.getActfromtime: "+
						latestActualJobmov.getActfromdate()+" "+latestActualJobmov.getActfromtime()+
						" latestActualJobmov.getActtotime: "+
						latestActualJobmov.getActtodate()+" "+latestActualJobmov.getActtotime()+
						" saveForm.getActtotime: "+
						saveForm.getActtodate()+" "+saveForm.getActtotime()						
				);			
				if (latestActualJobmov.getActfromtimeinmillis().longValue() > saveForm.getActtotimeinmillis()) {
					errors.add("acttodatedd",
							new ActionMessage(
									"error.acttodate.afterlastmovefromdate", 
									Util.dateTextFormat2(latestActualJobmov.getActfromdate()),
									latestActualJobmov.getActfromtime()
							)
					); 					
				}
				if (latestActualJobmov.getActtotimeinmillis().longValue() > saveForm.getActtotimeinmillis()) {
					errors.add("acttodatedd",
							new ActionMessage(
									"error.acttodate.afterlastmovetodate", 
									Util.dateTextFormat2(latestActualJobmov.getActtodate()),
									latestActualJobmov.getActtotime()
							)
					); 					
				}
			}
		}





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




		if (action.equals("Delete")) {		
			//bd.delete(dao, user);
			// delete parent/children
			bd.deleteAll(new Integer(saveForm.getJobmovId()), user);

		} else {


			// populate data-transfer-object from form
			// init FORM with DTO values
			BeanUtils.copyProperties(dao, saveForm);


			// set times in millis for Create process
			if (action.equals("Create")) {
				try {
					// set times
					Calendar _time = Calendar.getInstance();
					_time.setTime(dao.getEstfromdate());
					_time.set(Calendar.HOUR_OF_DAY,new Integer(saveForm.getEstfromtimehh()).intValue());
					_time.set(Calendar.MINUTE,new Integer(saveForm.getEstfromtimemm()).intValue());
					_time.set(Calendar.SECOND,0);			
					dao.setEstfromtimeinmillis(new Long(_time.getTimeInMillis()));
					_time.setTime(dao.getEsttodate());
					_time.set(Calendar.HOUR_OF_DAY,new Integer(saveForm.getEsttotimehh()).intValue());
					_time.set(Calendar.MINUTE,new Integer(saveForm.getEsttotimemm()).intValue());			
					_time.set(Calendar.SECOND,0);				
					dao.setEsttotimeinmillis(new Long(_time.getTimeInMillis()));	
				}catch (Exception e){}
			}

			// init from time
			dao.setFromtimeinmillis(dao.getEstfromtimeinmillis());
			dao.setFromtime(dao.getEstfromtime());
			dao.setFromdate(dao.getEstfromdate());				
			if (dao.getActfromtimeinmillis().longValue() > 0) { 
				dao.setFromtimeinmillis(dao.getActfromtimeinmillis());
				dao.setFromtime(dao.getActfromtime());
				dao.setFromdate(dao.getActfromdate());
			}
			// init to time				
			dao.setTotimeinmillis(dao.getEsttotimeinmillis());
			dao.setTotime(dao.getEsttotime());
			dao.setTodate(dao.getEsttodate());				
			if (dao.getActtotimeinmillis().longValue() > 0) { 
				dao.setTotimeinmillis(dao.getActtotimeinmillis());
				dao.setTotime(dao.getActtotime());
				dao.setTodate(dao.getActtodate());
			}


			// lookup fields
			try{
				Section _section = new Section();
				_section = new SectionBD(this.getSessionFactoryClusterMap()).read(dao.getSectionkey());
				dao.setInvsts(_section.getInvsts());
				dao.setMovests(_section.getMovests());
			}
			catch(Exception e){}


			//if (action.equals("Create")) {	
			//init FROM g codes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getFromlocationkey());
				dao.setFromg1key(gcode.getG1codekey());
				dao.setFromg2key(gcode.getG2codekey());
				dao.setFromg3key(gcode.getG3codekey());
				dao.setFromg4key(gcode.getG4codekey());
			} catch (Exception e){			
			}
			//init TO g codes
			try {
				Gcode gcode = new Gcode(this.getSessionFactoryClusterMap());
				gcode.initGcodesByLocation(dao.getTolocationkey());
				dao.setTog1key(gcode.getG1codekey());
				dao.setTog2key(gcode.getG2codekey());
				dao.setTog3key(gcode.getG3codekey());
				dao.setTog4key(gcode.getG4codekey());
			} catch (Exception e){			
			}
			//}


			//UPDATE SHIP INFO ON ORDER HEADER========================================================>
			// find system SHIP movement section code
			SystemmappingcodeBD systemmappingcodebd=new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
			String shipSection = "";
			try{shipSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "SHIP").getCompanycode();}catch(Exception e){}

			//check this movement is a SHIP movement
			if (shipSection.equals(dao.getSectionkey())) {

				//find job header
				JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
				Jobhdr jobhdrdao = null;
				try{jobhdrdao = jobhdrbd.read(dao.getJobhdrId());}catch (Exception e){}

				if (jobhdrdao != null) {

					//find order header
					OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
					Orderhdr orderhdrdao = null;				
					try{orderhdrdao = orderhdrbd.read(jobhdrdao.getOrderhdrId());}catch (Exception e){}

					//init SHIP info
					if (orderhdrdao != null) {

						orderhdrdao.setShipvendoraddrkey(dao.getVendoraddrkey());
						orderhdrdao.setShipvessel(dao.getVessel());
						orderhdrdao.setShipvoyage(dao.getVoyage());					
						//update order header
						orderhdrbd.createOrUpdate(orderhdrdao, user);

					}//if (orderhdrdao != null) {				

					orderhdrbd=null;
				}//if (jobhdrdao != null) {

				jobhdrbd=null;
			}//if (pool==null) {

			systemmappingcodebd=null;
			//UPDATE SHIP INFO ON ORDER HEADER========================================================<



			bd.createOrUpdate(dao, user);

		}


		// init latest movement details for unit
		Jobmov mov = null;
		if (dao.getActfromtimeinmillis().longValue() > 0 || dao.getActtotimeinmillis().longValue() > 0) {
			mov = bd.findLastActualJobmovByUnitId(dao.getUnitId());
			if (mov != null) {		
				UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
				Unit unitdao = unitbd.read(dao.getUnitId());
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


		//multiple movement update function
		if (saveForm.getMmu().equals("yes")) {
			//return mapping.findForward("multipleupdate1");	
			ActionForward forward = mapping.findForward("multipleupdate1");
			return new ActionForward(forward.getPath() + "?jobmovId=" + saveForm.getJobmovId());			
		}
		/***		
		// multiple updates
		if (action.equals("Edit")) {
			// 	multiple update function
			// get selected 
			int[] selectedObjects = saveForm.getSelectedObjects();

			if (selectedObjects != null) {
				for (int i = 0; i < selectedObjects.length; i++) {
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Multiple Update: "+selectedObjects[i]);
					// 	find row
					Jobmov updateDTO = bd.read(new Integer(selectedObjects[i]));				
					if (updateDTO != null) {
						// store non-update fields
						Integer jobmovId = updateDTO.getJobmovId();
						Integer jobhdrId = updateDTO.getJobhdrId();
						Integer unitId = updateDTO.getUnitId();
						String createuserid = updateDTO.getCreateuserid();
						Date createdate = updateDTO.getCreatedate();
						String createtime = updateDTO.getCreatetime();
						// populate data-transfer-object
						try {
							BeanUtils.copyProperties(updateDTO, dao);
						} catch (IllegalAccessException ite) {} 
						catch (InvocationTargetException ite) {} 
						catch (Exception e) {}

						// init from time
						updateDTO.setFromtimeinmillis(updateDTO.getEstfromtimeinmillis());
						updateDTO.setFromtime(updateDTO.getEstfromtime());
						updateDTO.setFromdate(updateDTO.getEstfromdate());				
						if (updateDTO.getActfromtimeinmillis().longValue() > 0) { 
							updateDTO.setFromtimeinmillis(updateDTO.getActfromtimeinmillis());
							updateDTO.setFromtime(updateDTO.getActfromtime());
							updateDTO.setFromdate(updateDTO.getActfromdate());
						}
						// init to time				
						updateDTO.setTotimeinmillis(updateDTO.getEsttotimeinmillis());
						updateDTO.setTotime(updateDTO.getEsttotime());
						updateDTO.setTodate(updateDTO.getEsttodate());				
						if (updateDTO.getActtotimeinmillis().longValue() > 0) { 
							updateDTO.setTotimeinmillis(updateDTO.getActtotimeinmillis());
							updateDTO.setTotime(updateDTO.getActtotime());
							updateDTO.setTodate(updateDTO.getActtodate());
						}

						//restore non-update fields
						updateDTO.setJobmovId(jobmovId);
						updateDTO.setJobhdrId(jobhdrId);
						updateDTO.setUnitId(unitId);
						updateDTO.setCreateuserid(createuserid);
						updateDTO.setCreatedate(createdate);
						updateDTO.setCreatetime(createtime);						
						// update row						
						bd.createOrUpdate(updateDTO, user);


						// init latest movement details for unit
						if (updateDTO.getActfromtimeinmillis().longValue() > 0 || updateDTO.getActtotimeinmillis().longValue() > 0) {
							mov = bd.findLastActualJobmovByUnitId(updateDTO.getUnitId());
							if (mov != null) {
								UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
								Unit unitdao = unitbd.read(updateDTO.getUnitId());								
								// not found 
								if (unitdao != null) {
									if (mov.getActfromtimeinmillis().floatValue() > 0) {
										unitdao.setJobmovlocationkey(mov.getFromlocationkey());
										unitdao.setJobmovtime(mov.getActfromtime());
										unitdao.setJobmovdate(mov.getActfromdate());
										unitdao.setJobmovtimeinmillis(mov.getActfromtimeinmillis());									
									}
									if (mov.getActtotimeinmillis().floatValue() > 0) {
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
							} // latest movement unit update

						} // check actualised

					} // retrieve movement to update
				} // selected loop
			} // are objects selected?
		} // multiple updates	
		 ***/



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



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}



}
