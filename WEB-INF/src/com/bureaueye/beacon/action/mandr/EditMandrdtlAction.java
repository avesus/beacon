package com.bureaueye.beacon.action.mandr;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.mandr.MandrdtlForm;
import com.bureaueye.beacon.model.mandr.Mandrdtl;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrdtlBD;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;







public final class EditMandrdtlAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		MandrdtlForm editForm = (MandrdtlForm) form;
		
		// Extract attributes we will need
		String action = editForm.getAction();
		
		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");
		
		Mandrdtl dao = null; 
		Mandrhdr mandrhdrdao = null;
		try{mandrhdrdao=new MandrhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getMandrhdrId()));}catch(Exception e){}
		String _itemno = "1";
		
		
		if (!(action == null || action.equals("Create"))) {
			
			dao = new MandrdtlBD(this.getSessionFactoryClusterMap())
			.read(new Integer(editForm.getMandrdtlId()));
			
			if (dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getMandrhdrId() + ", "
						+ "dtlid: " + editForm.getMandrdtlId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getMandrhdrId()
						+ " - " + editForm.getMandrdtlId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dao);
			
			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, dao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		
			
			_itemno = editForm.getItemno();
			
			
			Mandrdtl _lastdao = null;
			//find next lineno 
			try {
				_lastdao=new MandrdtlBD(this.getSessionFactoryClusterMap()).findLastMandrdtlByMandrhdrId(editForm.getMandrhdrId());
				editForm.setLastitemno(_lastdao.getItemno().toString());
			} catch (Exception e) {
			}
			
			
			
			// set lookup information
			if (mandrhdrdao != null) {
				editForm.setHdrccykey(mandrhdrdao.getCcykey());
				editForm.setHdrcancelflag(mandrhdrdao.isCancelflag());
			}
			
			
			
			// view only
			if (editForm.isHdrcancelflag()) {
				editForm.setAction("View");
				editForm.setReadonly("TRUE");
			}
			
			
			if (action.equals("Copy")) {
				try {
					int _nextno=_lastdao.getItemno().intValue()+1;
					if (_lastdao!= null) _itemno=_nextno+"";
				} catch (Exception e) {
				}
				
				editForm.setAction("Create");
				action="Create";								
			}
			
		}
		
		
		// set defaults for Create process
		if (action.equals("Create")) {
			editForm.setMandrdtlId(null);
			editForm.setItemno(_itemno);			
			
			if (mandrhdrdao != null) {
				editForm.setHdrccykey(mandrhdrdao.getCcykey());
				editForm.setCcykey(mandrhdrdao.getCcykey());
				editForm.setLaborrate(mandrhdrdao.getLaborrate().toString());
			}
			editForm.setXrate("1.0");			
		}				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		
		return findSuccess(mapping);
		
	}
	
	
}