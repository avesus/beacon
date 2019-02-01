package com.bureaueye.beacon.action.standard;

import java.lang.reflect.InvocationTargetException;
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
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.UnitForm;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UnitBD;



public final class SaveUnitAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		UnitForm unitForm = (UnitForm) form;	
		String action = unitForm.getAction();
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
		UnitBD bd = new UnitBD(this.getSessionFactoryClusterMap());
		JobmovBD jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());
		
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(unitForm.getUnitId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Unit dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Unit();
		}

		
		
		// business validation
		if (action.equals("Create")) {
			// check for duplicate number
			Unit duplicate = null;
			try{duplicate=bd.findUnitByUnitkey(unitForm.getUnitkey());}catch(ApplicationException ae){}
			if (duplicate != null) {
				errors.add("informationMessage",new ActionMessage("error.unit.unique"));				
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
			bd.delete(new Unit(pk), user);		
		} else {
	

			try {
				// populate data-transfer-object from form
				// init FORM with DTO values
				BeanUtils.copyProperties(dao, unitForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	

			
			// special code for Create
			if (action.equals("Create")) {
				// init movement details
				dao.setMovedate(dao.getMfdate());				
				dao.setMovetime("00:00");
				dao.setMovests(Constants.AVAILABLE_MOVSTS);
				dao.setMovelocationkey(dao.getManuflocationkey());
				dao.setJobmovdate(dao.getMfdate());				
				dao.setJobmovtime("00:00");
				dao.setInvsts(Constants.AVAILABLE_INVSTS);
				dao.setJobmovlocationkey(dao.getManuflocationkey());				
			}
			

			
			// make sure Movetime in mills is up-to-date
			try {			
				Calendar cal = Calendar.getInstance();
				cal.setTime(dao.getMovedate());
				int hour = 00;
				int minute = 00;
				int second = 00;
				try{hour=new Integer(dao.getMovetime().substring(0,2)).intValue();}catch(Exception e){}
				try{minute=new Integer(dao.getMovetime().substring(3,2)).intValue();}catch(Exception e){}
				cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),hour,minute,second);
				dao.setMovetimeinmillis(new Long(cal.getTimeInMillis()));
				dao.setJobmovtimeinmillis(new Long(cal.getTimeInMillis()));				
			} catch (Exception e) {
			}	
						
			
			bd.createOrUpdate(dao, user);

			
			// special code for Create
			if (action.equals("Create")) {
				// create dummy movement for new unit
				Jobmov jobmov = new Jobmov();
				jobmov.setJobhdrId(null);
				jobmov.setUnitId(dao.getUnitId());
				jobmov.setInvsts(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
				jobmov.setFromlocationkey(dao.getJobmovlocationkey());
				jobmov.setActfromdate(dao.getMovedate());
				jobmov.setActfromtime(dao.getMovetime());
				jobmov.setActfromtimeinmillis(dao.getMovetimeinmillis());
				jobmov.setFromdate(jobmov.getActfromdate());
				jobmov.setFromtime(jobmov.getActfromtime());
				jobmov.setFromtimeinmillis(jobmov.getActfromtimeinmillis());				
				jobmov.setTolocationkey(dao.getJobmovlocationkey());
				jobmov.setActtodate(dao.getMovedate());
				jobmov.setActtotime(dao.getMovetime());
				jobmov.setActtotimeinmillis(dao.getMovetimeinmillis());
				jobmov.setTodate(jobmov.getActtodate());
				jobmov.setTotime(jobmov.getActtotime());
				jobmov.setTotimeinmillis(jobmov.getActtotimeinmillis());
				
				jobmovbd.createOrUpdate(jobmov, user);				
			}
			
			
			// Find the quohdr form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());
			
			// Reset the parameters as if it was the first time in
			//listform.setStartPage();
			// Set the search parameters
			//listform.setSearchString1(dao.getUnitkey());
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);


	}

}
