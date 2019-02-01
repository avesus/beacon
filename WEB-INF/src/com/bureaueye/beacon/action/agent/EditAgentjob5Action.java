package com.bureaueye.beacon.action.agent;


import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;

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
import com.bureaueye.beacon.form.agent.AgentjobForm;

import com.bureaueye.beacon.model.agent.dto.AgentJobcostDTO;
import com.bureaueye.beacon.model.agent.dto.AgentJobmovDTO;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;





public final class EditAgentjob5Action extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession();
		AgentjobForm editForm = (AgentjobForm) form;
		String action = editForm.getAction();
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
			return mapping.findForward("beaconmenu");
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		
		
		// init dao and bd
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		
		
		
		// business validation
		
		
		
		// field validation
		
		
		
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
		
		
		
		// intialise form fields
		
		
		// initialise movements and costs
		Integer jobmovId = new Integer(0);
		Hashtable<Integer,AgentJobmovDTO> jobmovs = new Hashtable<Integer,AgentJobmovDTO>(); 
		QuomovBD quomovbd = new QuomovBD(this.getSessionFactoryClusterMap());
		try {

			for (Iterator it = quohdrbd.getQuomovs(new Integer(editForm.getQuohdrId())).iterator(); it.hasNext();) {
				AgentJobmovDTO jobmov = new AgentJobmovDTO();
				Quomov quomov = (Quomov)it.next();
				BeanUtils.copyProperties(jobmov, quomov);
				// init estimated 'from' date using Loading date +/- 'from' days
				if (quomov.isInitfromday()) {
					Calendar c = Calendar.getInstance();
					try {
						c.setTime(editForm.getLdgfromdate());
						c.add(Calendar.DATE,quomov.getFromdayno().intValue());
						jobmov.setEstfromdate(c.getTime());
					} catch (Exception e) {}								
				}
				// init estimated 'to' date using Loading date +/- 'to' days
				if (quomov.isInittoday()) {
					Calendar c = Calendar.getInstance();			
					try {
						c.setTime(editForm.getLdgfromdate());
						c.add(Calendar.DATE,quomov.getTodayno().intValue());
						jobmov.setEsttodate(c.getTime());
					} catch (Exception e) {}			
				}
				jobmov.setFromlocation(new LocationBD(this.getSessionFactoryClusterMap()).read(jobmov.getFromlocationkey()));
				jobmov.setTolocation(new LocationBD(this.getSessionFactoryClusterMap()).read(jobmov.getTolocationkey()));
				jobmov.setVendoraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(jobmov.getVendoraddrkey()));
				jobmov.setSection(new SectionBD(this.getSessionFactoryClusterMap()).read(jobmov.getSectionkey()));
				jobmov.setJobhdrId(new Integer(editForm.getQuohdrId()));
				jobmov.setJobmovId(jobmov.getJobhdrId()+jobmovId);
				
				// copy and store movement costs
				Integer jobcostId = new Integer(0);
				Hashtable<Integer,AgentJobcostDTO> jobcosts = new Hashtable<Integer,AgentJobcostDTO>(); 
				for (Iterator it2 = quomovbd.getQuocosts(quomov.getQuomovId()).iterator(); it2.hasNext();) {
					AgentJobcostDTO jobcost = new AgentJobcostDTO();
					Quocost quocost = (Quocost)it.next();
					BeanUtils.copyProperties(jobcost, quocost);
					jobcost.setVendoraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(quocost.getVendoraddrkey()));
					jobcost.setCost(new CostBD(this.getSessionFactoryClusterMap()).read(quocost.getCostkey()));
					jobcost.setJobhdrId(new Integer(editForm.getQuohdrId()));
					jobcost.setJobmovId(jobmov.getJobmovId());					
					jobcost.setJobcostId(jobcost.getJobmovId()+jobcostId);
					jobcosts.put(jobcost.getJobcostId(),jobcost);
					jobcostId++;
				}
				jobmov.setJobcosts(jobcosts);
				jobmovs.put(jobmov.getJobmovId(),jobmov);
				jobmovId++;
			}

			editForm.setJobmovs_(jobmovs);
		} catch (Exception e) {
		}
		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
}
