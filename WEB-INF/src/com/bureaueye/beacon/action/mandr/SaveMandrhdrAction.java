package com.bureaueye.beacon.action.mandr;



import java.lang.reflect.InvocationTargetException;
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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.mandr.MandrhdrForm;
import com.bureaueye.beacon.model.mandr.Mandrdtl;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrdtlBD;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;

import com.bureaueye.beacon.model.standard.User;



public final class SaveMandrhdrAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		MandrhdrForm saveForm = (MandrhdrForm) form;
		String action = saveForm.getAction();
		
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
		MandrhdrBD mandrhdrbd = new MandrhdrBD(this.getSessionFactoryClusterMap());
		
		// set primary key
		Integer pk = null;		
		try {
			pk = new Integer(saveForm.getId());			
		} catch (Exception e) {}
		// find data-access-object using primary key
		Mandrhdr _dao = mandrhdrbd.read(pk);
		// not found create empty object
		if (_dao == null) {
			_dao = new Mandrhdr();
		}
		
		
		
		// error validation 
		
		
		
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
			
			// code to update previous version to be last version
			try {
				Mandrhdr _previousversiondao = mandrhdrbd.findLastMandrhdrByMandrno(saveForm.getMandrno());
				if (_previousversiondao != null) {
					_previousversiondao.setLastversionflag(true);
					mandrhdrbd.createOrUpdate(_previousversiondao, user);
				}
			} catch (Exception e) {					
			}
			
			mandrhdrbd.delete(_dao, user);		
			
		} else {
			
			
			// populate data-transfer-object from form
			// init FORM with DTO values
			try {
				BeanUtils.copyProperties(_dao, saveForm);
			} catch (IllegalAccessException ite) {
			} catch (InvocationTargetException ite) {
			} catch (Exception e) {
			}	
			
			mandrhdrbd.createOrUpdate(_dao, user);
			
			
			
			// code to update previous version to not last version
			if (!saveForm.getCopyVersionId().equals("")) {
				try {
					Mandrhdr _previousversiondao = mandrhdrbd.read(new Integer(saveForm.getCopyVersionId()));
					if (_previousversiondao != null) {
						_previousversiondao.setLastversionflag(false);
						mandrhdrbd.createOrUpdate(_previousversiondao, user);
					}
					
					// copy over all detail lines to new version
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" SaveAction:  Processing copy from copyVersionId: "+saveForm.getCopyVersionId());
					Integer _hdrId = null;
					try{_hdrId = new Integer(saveForm.getCopyVersionId());}catch(Exception e){}
					if (_hdrId != null) {
						copyMandrhdrToMandrhdr(_hdrId, _dao, user);
					}
				} catch (Exception e) {					
				}
				
			}
			
			
			
			// Find the list form and reset the parameters as if it
			// was the first time in
			((ListForm) session.getAttribute("List" + mapping.getName())).setStartPage();
			
		}
		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	public void copyMandrhdrToMandrhdr(
			Integer hdrId, 
			Mandrhdr dto,
			User user
	) throws Exception {
		
		MandrhdrBD mandrhdrbd = new MandrhdrBD(this.getSessionFactoryClusterMap());	
		MandrdtlBD mandrdtlbd = new MandrdtlBD(this.getSessionFactoryClusterMap());		
		
		// copy and store details 
		for (Iterator it = mandrhdrbd.getMandrdtls(hdrId).iterator(); it.hasNext();) {			
			Mandrdtl dtl = new Mandrdtl();
			BeanUtils.copyProperties(dtl, it.next());
			dtl.setMandrhdrId(dto.getMandrhdrId());
			dtl.setMandrdtlId(null);			
			mandrdtlbd.createOrUpdate(dtl, user);
		}
		
	}
	
	
	
}
