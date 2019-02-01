package com.bureaueye.beacon.action.standard;

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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.standard.MovementForm;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.standard.Movement;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.MovementBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.util.Util;




public final class SaveMovementAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		MovementForm saveForm = (MovementForm) form;
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
		MovementBD bd = new MovementBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getMovementId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Movement dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Movement();
		}

		

		// movement error validation
		// check movement date entered
		if (action.equals("Create")) {		
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			// not found 
			if (unitdao != null) {	
				if (unitdao.getMovetimeinmillis().longValue() >= saveForm.getMovetimeinmillis()) {
					errors.add("movedatedd",
							new ActionMessage(
									"error.movedate.afterlastmovedate", 
									Util.dateTextFormat2(unitdao.getMovedate()),
									unitdao.getMovetime()
							)
					); 						
				}
			}
			
			// find latest movement details for unit
			Jobmov latestActualJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findLastActualJobmovByUnitId(dao.getUnitId());			
			if (latestActualJobmov != null) {	
				if (latestActualJobmov.getTotimeinmillis().longValue() >= saveForm.getMovetimeinmillis()) {
					errors.add("movedatedd",
							new ActionMessage(
									"error.movedate.afterlastjobmovdate", 
									Util.dateTextFormat2(latestActualJobmov.getTodate()),
									latestActualJobmov.getTotime()
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
		
		
		try {	
			// populate data-transfer-object from form
			// init FORM with DTO values
			BeanUtils.copyProperties(dao, saveForm);
		} catch (IllegalAccessException ite) {
		} catch (InvocationTargetException ite) {			
		}  catch (Exception e) {		
		}			
		
	
/*		// set times in millis for Create process
		if (action.equals("Create")) {
			try {
				// set times
				Calendar _time = Calendar.getInstance();
				_time.setTime(dao.getMovedate());
				_time.set(Calendar.HOUR_OF_DAY,new Integer(saveForm.getMovetimehh()).intValue());
				_time.set(Calendar.MINUTE,new Integer(saveForm.getMovetimemm()).intValue());
				_time.set(Calendar.SECOND,0);			
				dao.setMovetimeinmillis(new Long(_time.getTimeInMillis()));	
			}catch (Exception e){}
		}*/
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Movement(pk), user);		
		} else {
			
			bd.createOrUpdate(dao, user);
			
		
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
		}
		
		
		// process if a create or delete action
		if (action.equals("Create") || action.equals("Delete")) {	
			// 	update latest movement information
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			if (unitdao != null) {
				MovementBD movementbd = new MovementBD(this.getSessionFactoryClusterMap());				
				Movement lastMovement = movementbd.findLastMovementByUnitId(unitdao.getUnitId());

				// 	update Unit movement data
				unitdao.setMovedate(lastMovement.getMovedate());
				unitdao.setMovetime(lastMovement.getMovetime());
				unitdao.setMovetimeinmillis(lastMovement.getMovetimeinmillis());
				unitdao.setMovelocationkey(lastMovement.getMovelocationkey());
				unitdao.setMovests(lastMovement.getMovests());
				unitdao.setInvsts(lastMovement.getInvsts());
				unitdao.setMoveaddrkey(lastMovement.getMoveaddrkey());				
				unitdao.setMoveref(lastMovement.getMoveref());				
				unitdao.setMoveproductkey(lastMovement.getMoveproductkey());
				// update record
				unitbd.createOrUpdate(unitdao, user);
			}
		}
		
		

			
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
	
}
