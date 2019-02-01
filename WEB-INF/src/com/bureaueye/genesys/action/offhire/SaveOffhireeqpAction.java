package com.bureaueye.genesys.action.offhire;



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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Movement;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.MovementBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.form.offhire.OffhireeqpForm;
import com.bureaueye.genesys.model.offhire.Offhire;
import com.bureaueye.genesys.model.offhire.Offhireeqp;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpBD;




public final class SaveOffhireeqpAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OffhireeqpForm saveForm = (OffhireeqpForm) form;
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
		OffhireeqpBD bd = new OffhireeqpBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getOffhireeqpId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Offhireeqp dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Offhireeqp();
		}
		
		
		
		// error validation 
		
		// movement error validation
		// check offhire date entered when actualised  
		if (saveForm.getOffhiretimeinmillis() > 0 && saveForm.isActualflag()) {			
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			// not found 
			if (unitdao != null) {	
				if (unitdao.getMovetimeinmillis().longValue() >= saveForm.getOffhiretimeinmillis()) {
					errors.add("offhiredatedd",
							new ActionMessage(
									"error.offhiredate.afterlastmovedate", 
									Util.dateTextFormat2(unitdao.getMovedate()),
									unitdao.getMovetime()
							)
					); 
					// reset actual flag
					saveForm.setActualflag(false);					
				}
				if (!unitdao.getMovests().equals(com.bureaueye.beacon.bean.Constants.ONHIRE_STATUS)) {
					errors.add("unitkey",
							new ActionMessage(
									"error.unit.notcorrectstatus",
									com.bureaueye.beacon.bean.Constants.ONHIRE_STATUS
									)
					); 
					// reset actual flag
					saveForm.setActualflag(false);					
				}				
			}
			
			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					"After Validation: "+
					"unit.Movetimeinmillis["+unitdao.getMovetimeinmillis().longValue()+"]: "+
					"onhireeqp.Onhiretimeinmillis["+saveForm.getOffhiretimeinmillis()+"]: "+	
					"unit.Movests["+unitdao.getMovests()+"] "
					);	
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

			bd.delete(dao, user);	
			
		} else {
			
			
			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	

			
			
			// check actual offhire date entered
			if (saveForm.getOffhiretimeinmillis() > 0 && saveForm.isActualflag()) {	
				// get header information
				OffhireBD offhirebd = new OffhireBD(this.getSessionFactoryClusterMap());				
				Offhire offhiredao = offhirebd.read(dao.getOffhireId());		
				
				// TODO: create movement
				MovementBD movementbd = new MovementBD(this.getSessionFactoryClusterMap());				
				Movement movementdao = new Movement();	
				try {				
				movementdao.setUnitId(dao.getUnitId());				
				movementdao.setMovedate(dao.getOffhiredate());
				movementdao.setMovetime(dao.getOffhiretime());
				movementdao.setMovetimeinmillis(dao.getOffhiretimeinmillis());
				movementdao.setMovelocationkey(offhiredao.getLocationkey());
				movementdao.setMovests(com.bureaueye.beacon.bean.Constants.AVAILABLE_MOVSTS);
				movementdao.setInvsts(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
				movementdao.setMoveaddrkey(offhiredao.getLesseeaddrkey());			
				movementdao.setMoveref(offhiredao.getOffhireno());				
				movementdao.setMoveproductkey(dao.getProductkey());
				movementdao.setOffhireeqpId(dao.getOffhireeqpId());
				// update movement record
				movementbd.createOrUpdate(movementdao, user);
				} catch(Exception e){
					log.error(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"Movement.createOrUpdate Exception[" +e.getMessage()+"]"
							);					
				}
				
				
				try {
				// TODO: update latest movement information
				UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
				Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));			
				//Movement lastMovement = movementbd.findLastMovementByUnitId(dao.getUnitId());
				// 	update Unit movement data
				unitdao.setMovedate(movementdao.getMovedate());
				unitdao.setMovetime(movementdao.getMovetime());
				unitdao.setMovetimeinmillis(movementdao.getMovetimeinmillis());
				unitdao.setMovelocationkey(movementdao.getMovelocationkey());
				unitdao.setMovests(movementdao.getMovests());
				unitdao.setInvsts(movementdao.getInvsts());
				unitdao.setMoveaddrkey(movementdao.getMoveaddrkey());				
				unitdao.setMoveref(movementdao.getMoveref());				
				unitdao.setMoveproductkey(movementdao.getMoveproductkey());
				unitdao.setOffhireId(dao.getOffhireId());
				unitdao.setOnhireId(new Integer(0));				
				// update record
				unitbd.createOrUpdate(unitdao, user);
				} catch(Exception e){
					log.error(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"Unit.createOrUpdate Exception[" +e.getMessage()+"]"
							);						
				}					
			}
			
			
			try {			
			bd.createOrUpdate(dao, user);
		} catch(ApplicationException ae){
			log.error(
					"["+this.getClass().getName()+"] "+
					new java.util.Date()+" "+
					"Offhireeqp.createOrUpdate ApplicationException[" +ae.getMessage()+"]"
					);					
		}			
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}

		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	

	
	
	
	
	
}
