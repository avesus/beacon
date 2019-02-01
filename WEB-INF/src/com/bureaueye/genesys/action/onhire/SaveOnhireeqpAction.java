package com.bureaueye.genesys.action.onhire;



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
import com.bureaueye.genesys.form.onhire.OnhireeqpForm;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.Onhireeqp;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;
import com.bureaueye.genesys.model.onhire.bd.OnhireeqpBD;




public final class SaveOnhireeqpAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		OnhireeqpForm saveForm = (OnhireeqpForm) form;
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
		OnhireeqpBD bd = new OnhireeqpBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getOnhireeqpId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Onhireeqp dao = bd.read(pk);
		// not found create empty object
		if (dao == null) {
			dao = new Onhireeqp();
		}
		
		
		
		// error validation 
		
		// movement error validation
		// check onhire date entered when actualised  
		if (saveForm.getOnhiretimeinmillis() > 0 && saveForm.isActualflag()) {			
			UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
			Unit unitdao = unitbd.read(new Integer(saveForm.getUnitId()));
			// not found 
			if (unitdao != null) {
				if (unitdao.getMovetimeinmillis().longValue() >= saveForm.getOnhiretimeinmillis()) {
					errors.add("onhiredatedd",
							new ActionMessage(
									"error.onhiredate.afterlastmovedate", 
									Util.dateTextFormat2(unitdao.getMovedate()),
									unitdao.getMovetime()
							)
					); 	
					// reset actual flag
					saveForm.setActualflag(false);				
				}
			}
			if (!unitdao.getMovests().equals(com.bureaueye.beacon.bean.Constants.AVAILABLE_MOVSTS)) {
				errors.add("unitkey",
						new ActionMessage(
								"error.unit.notcorrectstatus",
								com.bureaueye.beacon.bean.Constants.ONHIRE_STATUS
								)
				); 
				// reset actual flag
				saveForm.setActualflag(false);					
			}	
			
			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+" "+
					"After Validation: "+
					"unit.Movetimeinmillis["+unitdao.getMovetimeinmillis().longValue()+"]: "+
					"onhireeqp.Onhiretimeinmillis["+saveForm.getOnhiretimeinmillis()+"]: "+	
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

			
			
			// check actual onhire date entered
			if (saveForm.getOnhiretimeinmillis() > 0 && saveForm.isActualflag()) {
				// get header information
				OnhireBD onhirebd = new OnhireBD(this.getSessionFactoryClusterMap());				
				Onhire onhiredao = onhirebd.read(dao.getOnhireId());		
				
				// TODO: create movement
				MovementBD movementbd = new MovementBD(this.getSessionFactoryClusterMap());				
				Movement movementdao = new Movement();
				try {			 
				movementdao.setUnitId(dao.getUnitId());
				movementdao.setMovedate(dao.getOnhiredate());
				movementdao.setMovetime(dao.getOnhiretime());
				movementdao.setMovetimeinmillis(dao.getOnhiretimeinmillis());
				movementdao.setMovelocationkey(onhiredao.getLocationkey());
				movementdao.setMovests(com.bureaueye.beacon.bean.Constants.ONHIRE_STATUS);
				movementdao.setInvsts(com.bureaueye.beacon.bean.Constants.ONHIRE_STATUS);
				movementdao.setMoveaddrkey(onhiredao.getLesseeaddrkey());			
				movementdao.setMoveref(onhiredao.getOnhireno());				
				movementdao.setMoveproductkey(dao.getProductkey());
				movementdao.setOnhireeqpId(dao.getOnhireeqpId());
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
				unitdao.setOnhireId(dao.getOnhireId());
				unitdao.setOffhireId(new Integer(0));				
				// update record
				unitbd.createOrUpdate(unitdao, user);
				} catch(Exception e){
					log.error(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"Unit.createOrUpdate Exception[" +e.getMessage()+"]"
							);						
				}				
				
				// set billstartdate
				try{
					//dao.setBillstartdate(Util.dateDaysAdd(dao.getBilluptodate(), dao.getFreedays().intValue()));
					dao.setBillstartdate(Util.dateDaysAdd(dao.getOnhiredate(), dao.getFreedays().intValue()));
				} catch(Exception e){}
			}
			
			
			
			try{			
			bd.createOrUpdate(dao, user);
			} catch(ApplicationException ae){
				log.error(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"Onhireeqp.createOrUpdate ApplicationException[" +ae.getMessage()+"]"
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
