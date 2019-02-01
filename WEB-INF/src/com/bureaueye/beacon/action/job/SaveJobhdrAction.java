package com.bureaueye.beacon.action.job;


import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.job.JobhdrForm;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdermovBD;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;


public final class SaveJobhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		JobhdrForm saveForm = (JobhdrForm) form;
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
		JobhdrBD bd = new JobhdrBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getJobhdrId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Jobhdr dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Jobhdr();
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



		if (action.equals("Delete")) {		
			// delete parent/children
			bd.deleteAll(new Integer(saveForm.getJobhdrId()), user);


			// update unit job movement details		
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			// update unit job movement details 	
			if (unitdao != null) {
				Jobmov latestActualJobmov = 
					new JobmovBD(this.getSessionFactoryClusterMap())
				.findLastActualJobmovByUnitId(new Integer(saveForm.getUnitId()));
				if (latestActualJobmov != null) {					
					if (latestActualJobmov.getActfromtimeinmillis().longValue() > 0) {
						unitdao.setJobmovlocationkey(latestActualJobmov.getFromlocationkey());
						unitdao.setJobmovtime(latestActualJobmov.getActfromtime());
						unitdao.setJobmovdate(latestActualJobmov.getActfromdate());
						unitdao.setJobmovtimeinmillis(latestActualJobmov.getActfromtimeinmillis());									
					}
					if (latestActualJobmov.getActtotimeinmillis().longValue() > 0) {
						unitdao.setJobmovlocationkey(latestActualJobmov.getTolocationkey());
						unitdao.setJobmovtime(latestActualJobmov.getActfromtime());
						unitdao.setJobmovdate(latestActualJobmov.getActtodate());
						unitdao.setJobmovtimeinmillis(latestActualJobmov.getActtotimeinmillis());								
					}						
					unitdao.setJobmovref(latestActualJobmov.getMovref());
					unitdao.setJobmovvessel(latestActualJobmov.getVessel());
				}
				unitdao.setMovests(Constants.AVAILABLE_MOVSTS);
				unitdao.setInvsts(Constants.AVAILABLE_INVSTS);	

				unitbd.createOrUpdate(unitdao, user);
			}					



		} else {

			bd.createOrUpdate(dao, user);


			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
		}


		if (action.equals("Create")) {
			Orderhdr orderhdrDTO = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(saveForm.getOrderhdrId()));		
			if (orderhdrDTO != null) {	
				copyOrderToJob(orderhdrDTO, dao, user);		
			}


			// update unit job movement details		
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			// update unit job movement details 	
			if (unitdao != null) {
				Jobmov latestActualJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findLastActualJobmovByUnitId(new Integer(saveForm.getUnitId()));
				if (latestActualJobmov != null) {					
					if (latestActualJobmov.getActfromtimeinmillis().floatValue() > 0) {
						unitdao.setJobmovlocationkey(latestActualJobmov.getFromlocationkey());
						unitdao.setJobmovtime(latestActualJobmov.getActfromtime());
						unitdao.setJobmovdate(latestActualJobmov.getActfromdate());
						unitdao.setJobmovtimeinmillis(latestActualJobmov.getActfromtimeinmillis());									
					}
					if (latestActualJobmov.getActtotimeinmillis().floatValue() > 0) {
						unitdao.setJobmovlocationkey(latestActualJobmov.getTolocationkey());
						unitdao.setJobmovtime(latestActualJobmov.getActfromtime());
						unitdao.setJobmovdate(latestActualJobmov.getActtodate());
						unitdao.setJobmovtimeinmillis(latestActualJobmov.getActtotimeinmillis());								
					}						
					unitdao.setJobmovref(latestActualJobmov.getMovref());
					unitdao.setJobmovvessel(latestActualJobmov.getVessel());					
				}
				unitdao.setMovests(Constants.OPERATOR_STATUS);
				unitdao.setInvsts(Constants.AVAILABLE_INVSTS);				
				
				try {
					PropertyResourceBundle props = 
						(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
					if (props.getString("reserveunit").equals("yes")) {
						// set to reserve when unit assigned
						unitdao.setInvsts(Constants.RESERVED_INVSTS);			
					}
				} catch (Exception e) {				
				}
				
				
				unitbd.createOrUpdate(unitdao, user);
			}					


			// if create then init jobno and save again
			if (action.equals("Create")) {
				dao.setJobno(dao.getJobhdrId().toString());
				bd.createOrUpdate(dao, user);
			}


		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}






	public void copyOrderToJob(
			Orderhdr orderhdrDTO, 
			Jobhdr jobhdrdao,
			User user
	) throws Exception {

		JobmovBD jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());
		OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		OrdermovBD ordermovbd = new OrdermovBD(this.getSessionFactoryClusterMap());


		// copy and store movements 
		int count=0;
		List ordermovs=orderhdrbd.getOrdermovs(orderhdrDTO.getId());
		if (ordermovs!=null) {
			for (Iterator it = ordermovs.iterator(); it.hasNext();) {
				try {
					count++;
					Jobmov jobmov = new Jobmov();
					Ordermov ordermov = (Ordermov)it.next();
					BeanUtils.copyProperties(jobmov, ordermov);

					// set times
					//Calendar _cal = Calendar.getInstance();
					Calendar _time = Calendar.getInstance();
					_time.setTime(jobmov.getEstfromdate());
					_time.set(Calendar.HOUR_OF_DAY,0);_time.set(Calendar.MINUTE,0);_time.set(Calendar.SECOND,0);			
					jobmov.setEstfromtimeinmillis(new Long(_time.getTimeInMillis()));
					jobmov.setEstfromtime("00:00");
					jobmov.setActfromtime("00:00");			
					_time.setTime(jobmov.getEsttodate());
					_time.set(Calendar.HOUR_OF_DAY,0);_time.set(Calendar.MINUTE,0);_time.set(Calendar.SECOND,0);				
					jobmov.setEsttotimeinmillis(new Long(_time.getTimeInMillis()));			
					jobmov.setEsttotime("00:00");
					jobmov.setActtotime("00:00");				
					// init from time
					jobmov.setFromtimeinmillis(jobmov.getEstfromtimeinmillis());
					jobmov.setFromtime(jobmov.getEstfromtime());
					jobmov.setFromdate(jobmov.getEstfromdate());				
					// init to time				
					jobmov.setTotimeinmillis(jobmov.getEsttotimeinmillis());
					jobmov.setTotime(jobmov.getEsttotime());
					jobmov.setTodate(jobmov.getEsttodate());				

					jobmov.setMovref("");
					jobmov.setVessel("");
					jobmov.setVoyage("");
					jobmov.setTxt("");					
					jobmov.setTxt2("");
					jobmov.setTxt3("");
					jobmov.setLloydsnumber("");
					jobmov.setBilloflading("");
					jobmov.setVsbkcontact("");
					jobmov.setVsbkref("");
					
					
					// lookup fields
					try{
						Section _section = new Section();
						_section = new SectionBD(this.getSessionFactoryClusterMap()).read(ordermov.getSectionkey());
						jobmov.setInvsts(_section.getInvsts());
						jobmov.setMovests(_section.getMovests());
					}
					catch(Exception e){}

					jobmov.setJobhdrId(jobhdrdao.getJobhdrId());				
					jobmov.setOrderno(jobhdrdao.getOrderno());
					jobmov.setUnitId(jobhdrdao.getUnitId());
					// set unique multiple movement update link
					jobmov.setMmulink(orderhdrDTO.getId()+"-"+count);

					// persist movement 
					jobmovbd.createOrUpdate(jobmov, user);


					// copy and store order movement costs
					List ordercosts=ordermovbd.getOrdercosts(ordermov.getOrdermovId());
					if (ordercosts!=null) {
						for (Iterator it2 = ordercosts.iterator(); it2.hasNext();) {
							try {
								Jobcost jobcost = new Jobcost();
								Ordercost ordercost = (Ordercost)it2.next();
								BeanUtils.copyProperties(jobcost, ordercost);						
								jobcost.setJobmovId(jobmov.getJobmovId());
								
								
								jobcost.setJobhdrId(jobhdrdao.getJobhdrId());
								jobcost.setOrderno(jobhdrdao.getOrderno());
								jobcost.setPoststatus("");								
								jobcostbd.createOrUpdate(jobcost, user);
							}
							catch (Exception e) {			
							}
						}	
					}//check null list
					
				}
				catch (Exception e) {					
				}				
				
			}
		}//check null list

		// copy and store order costs
		List ordercosts=orderhdrbd.getOrdercosts(orderhdrDTO.getId());
		if (ordercosts!=null) {
			for (
					Iterator it3 = ordercosts.iterator(); it3.hasNext();
			) {
				try {
					Jobcost jobcost = new Jobcost();
					Ordercost ordercost = (Ordercost)it3.next();
					BeanUtils.copyProperties(jobcost, ordercost);						
					jobcost.setJobmovId(new Integer(0));
					jobcost.setJobhdrId(jobhdrdao.getJobhdrId());
					jobcost.setOrderno(jobhdrdao.getOrderno());
					jobcost.setPoststatus("");						
					jobcostbd.createOrUpdate(jobcost, user);
				}
				catch (Exception e) {			
				}
			}
		}//check null list

		//clear bd
		jobmovbd=null;
		jobcostbd=null;
		orderhdrbd=null;
		ordermovbd=null;
		
	}

}
