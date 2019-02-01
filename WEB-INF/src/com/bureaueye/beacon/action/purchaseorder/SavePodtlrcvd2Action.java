package com.bureaueye.beacon.action.purchaseorder;


import java.util.Calendar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.purchaseorder.Podtlrcvd2Form;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.purchaseorder.Podtl;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;
import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PodtlrcvdBD;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.UnitBD;




public final class SavePodtlrcvd2Action extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		Podtlrcvd2Form saveForm = (Podtlrcvd2Form) form;
		String action = saveForm.getActionX();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();
		
		
		
		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findFailure(mapping);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");
		
		// Generate Business Delegate
		PodtlrcvdBD bd = new PodtlrcvdBD(this.getSessionFactoryClusterMap());

		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getPodtlrcvdId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Podtlrcvd dto = bd.read(pk);


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
		
		
/*		// populate data-transfer-object from form
		// init FORM with DTO values
		BeanUtils.copyProperties(dto, saveForm);
					
		
		
		if (action.equals("Delete")) {		
			bd.delete(new Podtlrcvd(pk), user);		
		} else {
			
			bd.createOrUpdate(dto, user);

			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("ListPodtlrcvdForm"))
					.setStartPage();
		}*/

		// TODO: generated UNITS
		// init buisness delegates
		UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
		PohdrBD pohdrbd = new PohdrBD(this.getSessionFactoryClusterMap());
		PodtlBD podtlbd = new PodtlBD(this.getSessionFactoryClusterMap());
		JobmovBD jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());	
				
		// required data process once
		Podtl podtl = null;
		try {podtl  = podtlbd.read(dto.getPodtlId());}catch (ApplicationException ae) {}
		Pohdr pohdr = null;
		try {pohdr = pohdrbd.read(podtl.getPohdrId());}catch (ApplicationException ae) {}						
		Unit unittemplate = null;
		try {unittemplate = unitbd.read(new Integer(saveForm.getUnitId()));}catch (Exception ae) {}	
		
		
		// init qty
		int _qtytogenerate = 0;
		try{_qtytogenerate = new Integer(saveForm.getQtytogenerate()).intValue();}catch(Exception e){}
		int _qtygenerated = 0;
		try{_qtygenerated = new Integer(saveForm.getQtygenerated()).intValue();}catch(Exception e){}
		int _qtyrcvd = 0;
		try{_qtyrcvd = new Integer(saveForm.getQtyrcvd()).intValue();}catch(Exception e){}
		Integer _unitkeysuffix = new Integer(0);
		try{_unitkeysuffix = new Integer(saveForm.getUnitkeysuffix());}catch(Exception e){}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Generate process for parameters -"+saveForm.toString());

		
		// check qty entered and unit template exists
		if (_qtytogenerate > 0 && unittemplate != null) {
			int row = 0;
			for (int i = 0; i < _qtytogenerate; i++) {
					
					// init unit number
					String _unitkey = saveForm.getUnitkeyprefix()+_unitkeysuffix.toString();
					// increment suffix
					_unitkeysuffix=new Integer(_unitkeysuffix.intValue()+1);
					
					// TODO: check unit number already exists
					Unit unitduplicate = null;
					try {unitduplicate = unitbd.findUnitByUnitkey(_unitkey);}catch (Exception ae) {}	
					if (unitduplicate != null) {
						// Add an error message
						appErrorMessages.add(
								"errors.podtlrcvd2",
								new ActionMessage(
										"error.unit.duplicate", 
										_unitkey
								)
						);						
						continue;
					}

					
					// increment row
					row++;
					// create dto for unit
					Unit unit = new Unit();
									
					// populate data-transfer-object 
					// init new UNIT with UNIT TEMPLATE values
					//BeanUtils.copyProperties(unit, unittemplate);
					
					// init fields
					unit.setUnitkey(_unitkey);
					unit.setEqpkeyp1(podtl.getEqpkeyp1());
					unit.setEqpkeyp2(podtl.getEqpkeyp2());
					unit.setEqpkeyp3("");
					unit.setEqpkeyp4("");
					unit.setEqpkeyp5("");
					unit.setXinactive(false);
					unit.setFoodgrad(false);
					unit.setPodtlrcvdId(dto.getPodtlrcvdId());
					unit.setMfdate(dto.getRcvddate());
					unit.setManuflocationkey(pohdr.getShiptolocationkey());
					unit.setMovedate(unit.getMfdate());				
					unit.setMovetime("00:00");
					unit.setMovests(com.bureaueye.beacon.bean.Constants.AVAILABLE_MOVSTS);
					unit.setMovelocationkey(unit.getManuflocationkey());
					unit.setJobmovdate(unit.getMfdate());				
					unit.setJobmovtime("00:00");
					unit.setInvsts(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
					unit.setJobmovlocationkey(unit.getManuflocationkey());				
				
					// make sure Movetime in mills is up-to-date
					try {			
						Calendar cal = Calendar.getInstance();
						cal.setTime(unit.getMovedate());
						int hour = 00;
						int minute = 00;
						int second = 00;
						try{hour=new Integer(unit.getMovetime().substring(0,2)).intValue();}catch(Exception e){}
						try{minute=new Integer(unit.getMovetime().substring(3,2)).intValue();}catch(Exception e){}
						cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),hour,minute,second);
						unit.setMovetimeinmillis(new Long(cal.getTimeInMillis()));
						unit.setJobmovtimeinmillis(new Long(cal.getTimeInMillis()));				
					} catch (Exception e) {}	
													
					// update 
					unitbd.createOrUpdate(unit, user);
					
					// special code for Create
					// create dummy movement for new unit
					Jobmov jobmov = new Jobmov();
					jobmov.setJobhdrId(null);
					jobmov.setUnitId(unit.getUnitId());

					jobmov.setInvsts(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
					jobmov.setFromlocationkey(unit.getJobmovlocationkey());
					jobmov.setActfromdate(unit.getMovedate());
					jobmov.setActfromtime(unit.getMovetime());
					jobmov.setActfromtimeinmillis(unit.getMovetimeinmillis());
					jobmov.setFromdate(jobmov.getActfromdate());
					jobmov.setFromtime(jobmov.getActfromtime());
					jobmov.setFromtimeinmillis(jobmov.getActfromtimeinmillis());				
					jobmov.setTolocationkey(unit.getJobmovlocationkey());
					jobmov.setActtodate(unit.getMovedate());
					jobmov.setActtotime(unit.getMovetime());
					jobmov.setActtotimeinmillis(unit.getMovetimeinmillis());
					jobmov.setTodate(jobmov.getActtodate());
					jobmov.setTotime(jobmov.getActtotime());
					jobmov.setTotimeinmillis(jobmov.getActtotimeinmillis());
					jobmovbd.createOrUpdate(jobmov, user);				

			} // lineitem iterator
			
			if (row > 0) {
				// Add invformation message 
				appInformationMessages.add(
						"messages.podtlrcvd2",
							new ActionMessage(
									"information.units.generate",
									new Integer(row).toString()
							)
					);
			}
			
		} // generate UNITS	
		

		// Report any errors back to the original form		
		if (!appErrorMessages.isEmpty()) {
			saveAppErrorMessages(request, appErrorMessages);
		}
		// Report any information back to the original form
		if (!appInformationMessages.isEmpty()) {
			saveAppInformationMessages(request, appInformationMessages);
		}					

		

		// set extra information
		try {
			saveForm.setQtygenerated(
					new UnitBD(this.getSessionFactoryClusterMap()).countUnitsByPodtlrcvdId(dto.getPodtlrcvdId().toString())
					);
		} catch (Exception ae) {}

		// set lineitems
		try {
			saveForm.setLineItems(
					new UnitBD(this.getSessionFactoryClusterMap()).findUnitsByPodtlrcvdId(dto.getPodtlrcvdId())
					);
		} catch (Exception ae) {}
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  Forwarding to success page");
		return findSuccess(mapping);


	}
}
