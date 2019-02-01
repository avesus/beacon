package com.bureaueye.beacon.action.agent;



import java.util.Calendar;
import java.util.Hashtable;

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
import com.bureaueye.beacon.form.agent.AgentJobmovForm;
import com.bureaueye.beacon.form.agent.AgentjobForm;
import com.bureaueye.beacon.model.agent.dto.AgentJobmovDTO;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.util.Util;





public final class SaveAgentJobmovAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession();
		AgentjobForm editForm = (AgentjobForm) session.getAttribute("AgentjobForm");
		AgentJobmovForm saveForm = (AgentJobmovForm) form;
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
		JobmovBD jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getJobmovId());			
		} catch (Exception e) {}
		/*		// find data-access-object using primary key
		 Jobmov dto = bd.read(pk);
		 // not found create empty object
		  if (dto == null) {
		  
		  }*/
		AgentJobmovDTO dto = new AgentJobmovDTO();		
		
		
		if (saveForm.getActtotimeinmillis() > 0 && saveForm.getActfromtimeinmillis() == 0) {
			errors.add("actfromdatedd", new ActionMessage("error.actfromdate.required"));						
		}
		
		// movement error validation
		// find latest movement details for unit
		Jobmov latestActualJobmov = jobmovbd.findLastActualJobmovByUnitId(
				new Integer(editForm.getUnitId()
				)
		);
		
		// check actual FROM date/time entered
		if (saveForm.getActfromtimeinmillis() > 0 && 
				(dto.getActfromtimeinmillis() == null || dto.getActfromtimeinmillis().longValue() == 0)
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
				(dto.getActtotimeinmillis() == null || dto.getActtotimeinmillis().longValue() == 0)
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
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return findFailure(mapping);
		}				
		

		
		Hashtable<Integer,AgentJobmovDTO> jobmovs = new Hashtable<Integer,AgentJobmovDTO>();
		try {
			jobmovs=editForm.getJobmovs();
		} catch (Exception e) {
		}
		

		
		if (action.equals("Delete")) {		
			
			try {
				jobmovs.remove(pk);				
			} catch (Exception e) {
			}
			
			
		} else {
			
			BeanUtils.copyProperties(dto, saveForm);
			
			
			// set times in millis for Create process
			if (action.equals("Create")) {
				try {
					// set times
					Calendar _time = Calendar.getInstance();
					_time.setTime(dto.getEstfromdate());
					_time.set(Calendar.HOUR_OF_DAY,new Integer(saveForm.getEstfromtimehh()).intValue());
					_time.set(Calendar.MINUTE,new Integer(saveForm.getEstfromtimemm()).intValue());
					_time.set(Calendar.SECOND,0);			
					dto.setEstfromtimeinmillis(new Long(_time.getTimeInMillis()));
					_time.setTime(dto.getEsttodate());
					_time.set(Calendar.HOUR_OF_DAY,new Integer(saveForm.getEsttotimehh()).intValue());
					_time.set(Calendar.MINUTE,new Integer(saveForm.getEsttotimemm()).intValue());			
					_time.set(Calendar.SECOND,0);				
					dto.setEsttotimeinmillis(new Long(_time.getTimeInMillis()));
					dto.setJobhdrId(null);					
					dto.setJobmovId(_time.hashCode());
				} catch (Exception e){}
			}
			
			// init from time
			dto.setFromtimeinmillis(dto.getEstfromtimeinmillis());
			dto.setFromtime(dto.getEstfromtime());
			dto.setFromdate(dto.getEstfromdate());				
			if (dto.getActfromtimeinmillis().longValue() > 0) { 
				dto.setFromtimeinmillis(dto.getActfromtimeinmillis());
				dto.setFromtime(dto.getActfromtime());
				dto.setFromdate(dto.getActfromdate());
			}
			// init to time				
			dto.setTotimeinmillis(dto.getEsttotimeinmillis());
			dto.setTotime(dto.getEsttotime());
			dto.setTodate(dto.getEsttodate());				
			if (dto.getActtotimeinmillis().longValue() > 0) { 
				dto.setTotimeinmillis(dto.getActtotimeinmillis());
				dto.setTotime(dto.getActtotime());
				dto.setTodate(dto.getActtodate());
			}
			
			
			// lookup fields
			try{
				Section _section = new Section();
				_section = new SectionBD(this.getSessionFactoryClusterMap()).read(dto.getSectionkey());
				dto.setInvsts(_section.getInvsts());
				dto.setMovests(_section.getMovests());
				
				dto.setSection(_section);
				
				dto.setFromlocation(new LocationBD(this.getSessionFactoryClusterMap()).read(dto.getFromlocationkey()));
				dto.setTolocation(new LocationBD(this.getSessionFactoryClusterMap()).read(dto.getTolocationkey()));
				dto.setVendoraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getVendoraddrkey()));
				
			}
			catch(Exception e){}
			
			
			jobmovs.put(dto.getJobmovId().hashCode(),dto);
			
		}
		
		
		editForm.setJobmovs_(jobmovs);
		
	
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
}
