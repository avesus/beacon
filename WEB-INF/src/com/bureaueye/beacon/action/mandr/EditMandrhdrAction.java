package com.bureaueye.beacon.action.mandr;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

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
import com.bureaueye.beacon.form.mandr.MandrhdrForm;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unittest;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.DocnoBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.beacon.util.Util;








public final class EditMandrhdrAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);		
		User user = (User) session.getAttribute(Constants.USER_KEY);
		MandrhdrForm editForm = (MandrhdrForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		Mandrhdr _dao = null; 
		String _versionno = "1";
		String _mandrno = "";
		
		if (!(action == null || action.equals("Create"))) {

			_dao = new MandrhdrBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getId()));

			if (_dao == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Record found for hdrId: "
						+ editForm.getId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getId()));
				saveMessages(request, errors);				
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + _dao);

			try {
				// init FORM with DTO values
				BeanUtils.copyProperties(editForm, _dao);
			} catch (IllegalAccessException ite) {			
			} catch (InvocationTargetException ite) {				
			} catch (Exception e) {
			}		

			_versionno = editForm.getVersionno();
			_mandrno = editForm.getMandrno();

			Mandrhdr _lastdao = null;
			//find next versionno for mandrno
			try {
				_lastdao=new MandrhdrBD(this.getSessionFactoryClusterMap()).findLastMandrhdrByMandrno(editForm.getMandrno());
				editForm.setLastversionno(_lastdao.getVersionno().toString());
			} catch (Exception e) {
			}

			// set lookup information
			try {
				Unit _unitdao = new UnitBD(this.getSessionFactoryClusterMap()).read(_dao.getUnitId());
				if (_unitdao!=null) {
					editForm.setEqpkeyp1(_unitdao.getEqpkeyp1());
					editForm.setEqpkeyp2(_unitdao.getEqpkeyp2());
					editForm.setMovests(_unitdao.getMovests());
					Address _addressdao = new AddressBD(this.getSessionFactoryClusterMap()).read(_unitdao.getOwnerkey());
					if (_addressdao!=null) editForm.setUnitowner(_addressdao.getName());
				}
			} catch (Exception e) {
			}
			try {
				Unittest _unittestdao = new UnittestBD(this.getSessionFactoryClusterMap()).getNextUnittestDue(_dao.getUnitId());
				if (_unittestdao!=null) {
					editForm.setTestduedate(Util.dateTextFormat2(_unittestdao.getDuedate()));
					editForm.setTesttypekey(_unittestdao.getTesttypekey());				
				}
			} catch (Exception e) {
			}
			
			// view only
			if (
					editForm.isCancelflag() || 
					!editForm.getVersionno().equals(editForm.getLastversionno())//check if last version of mandrno 
				) {
				editForm.setAction("View");
				editForm.setReadonly("TRUE");
			}
			
			if (action.equals("Copy")) {
				_mandrno = "";
				editForm.setAction("Create");
				action="Create";
			}

			if (action.equals("CopyVersion")) {
				//find next versionno for mandrno
				try {
					int _nextversionno=_lastdao.getVersionno().intValue()+1;
					if (_lastdao!= null) _versionno=_nextversionno+"";
				} catch (Exception e) {					
				}
				editForm.setCopyVersionId(editForm.getId());
				editForm.setLastversionflag(true);
				editForm.setAction("Create");
				action="Create";
			}
			
		}



		// create only
		if (action.equals("Create")) {
			
			editForm.setId(null);
			editForm.setMandrno(_mandrno);
			editForm.setVersionno(_versionno);
			editForm.setMandrtypekey(com.bureaueye.beacon.bean.Constants.MANUAL);
			
			try {
				PropertyResourceBundle props = 
					(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
				if (props.getString("mandrno.auto.generate").equals("yes")) {
					// auto generate number
					int nextdocno = 0;
					nextdocno = new DocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
							"MANDR",
							"",
							0,
							user
					);
					DecimalFormat df = new DecimalFormat(props.getString ("quotno.format"));
					editForm.setMandrno(df.format(nextdocno));
					log.debug(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"nextdocno["+editForm.getMandrno()+"]: "+
							"userid["+user.getUserid()+"]"
							);					
				}
			} catch (Exception e) {
				log.error(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"Exception["+e.getMessage()+"]"
						);				
			}

			
			
			// default user information
			editForm.setCreateuserid(user.getUserid());	
			editForm.setActivitykey(user.getActivitykey());
			editForm.setCompanykey(user.getCompanykey());
			editForm.setDepartmentkey(user.getDepartmentkey());
			
			// default status information
			editForm.setMandrstatus("PENDING");
			
			// default dates to today
			Calendar c = Calendar.getInstance();		
			try {
				editForm.setEstimatedate(c.getTime());
				editForm.setOriginalestimatedate(c.getTime());
			} catch (Exception e) {}	
			
		}
				
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
