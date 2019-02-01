package com.bureaueye.beacon.action.agent;

import java.lang.reflect.InvocationTargetException;


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






public final class EditAgentJobmovAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		AgentjobForm editForm1 = (AgentjobForm) session.getAttribute("AgentjobForm");	
		AgentJobmovForm editForm2 = (AgentJobmovForm) form;

		// Extract attributes we will need
		String action = editForm2.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm2.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		AgentJobmovDTO dto = null; 
			
		if ( 
				!(action == null || action.equals("Create")) 
			) {

			dto = (AgentJobmovDTO) editForm1.getJobmovs().get(new Integer(editForm2.getJobmovId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm2.getJobhdrId() + ", "
						+ "movid: " + editForm2.getJobmovId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm2.getJobhdrId()
								+ " - " + editForm2.getJobmovId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm2, dto);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		

			
			if (action.equals("Copy")) {	
				editForm2.setJobmovId("");
				editForm2.setActfromdate(null);
				editForm2.setActfromdatedd("00");
				editForm2.setActfromdatemm("00");
				editForm2.setActfromdateyyyy("0000");
				editForm2.setActfromtime("00:00");
				editForm2.setActfromtimehh("00");
				editForm2.setActfromtimemm("00");
				editForm2.setActfromtimeinmillis("0");
				editForm2.setActtodate(null);
				editForm2.setActtodatedd("00");
				editForm2.setActtodatemm("00");
				editForm2.setActtodateyyyy("0000");
				editForm2.setActtotime("00:00");
				editForm2.setActtotimehh("00");
				editForm2.setActtotimemm("00");
				editForm2.setActtotimeinmillis("0");
				editForm2.setAction("Create");
				action="Create";
			}
			
		}

		
/*		Jobhdr hdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getJobhdrId()));
		
		// init Unit id 
		if (action.equals("Create")) {	
			if (hdr != null) {				
				editForm.setUnitId(hdr.getUnitId().toString());
			}
		}

		
		// set collections
		if (hdr != null && action.equals("Edit")) {				
			// for multiple Movement Update process
			List jobmovs = null;
			List jobmovs = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovsByKey3(
					editForm.getJobmovId(),
					hdr.getOrderhdrId().toString(),
					editForm.getSectionkey().getSectionkey(),
					editForm.getFromlocationkey().getLocationkey(),
					editForm.getTolocationkey().getLocationkey(),
					editForm.getVendoraddrkey().getAddrkey(),
					0,
					999,
					"jobhdr.Unitkey"
			);
			jobmovs = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovsByKey5(
					editForm.getJobmovId(),
					hdr.getOrderhdrId().toString(),
					editForm.getMmulink(),
					0,
					999,
					"jobhdr.Unitkey"
					);
			
			List<JobhdrmovDTO> jobmovDTOs = new ArrayList<JobhdrmovDTO>();
			//int row = 0;
			for (Iterator it = jobmovs.iterator(); it.hasNext();) {
					jobmovDTOs.add((JobhdrmovDTO)it.next());
			}
			
			editForm.setMmuList(jobmovDTOs);
			// Reset the delete boxes
			editForm.setSelectedObjects(null);		
		}*/
		
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
