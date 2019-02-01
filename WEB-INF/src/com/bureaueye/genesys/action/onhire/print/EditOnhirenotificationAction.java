package com.bureaueye.genesys.action.onhire.print;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.form.print.PrintdtlForm;
import com.bureaueye.beacon.form.print.PrinthdrForm;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;

import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;

import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unittest;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.Onhireeqp;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;



/**
 */
public class EditOnhirenotificationAction extends BaseAction {
	
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HttpSession session = request.getSession(false);
		PrinthdrForm editForm = (PrinthdrForm) form;
		String action = editForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		
		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" EditForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");
		
		
		// initialise company header
		Companyheader companyheaderdto = null;
		companyheaderdto = new CompanyheaderBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getCompanyheaderId()));
		if (companyheaderdto != null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating PrintForm from companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}
		
		
		Printhdr printhdrdto = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		UnitBD unitbd = new UnitBD(this.getSessionFactoryClusterMap());
		UnittestBD unittestbd = new UnittestBD(this.getSessionFactoryClusterMap());		
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		java.util.Set<PrintdtlForm> printdtlForms = new java.util.HashSet<PrintdtlForm>();
		
		
		// initialise print header and details
		printhdrdto = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());
		
		if (editForm.getRefreshdata().equals("N")) {			
			if (printhdrdto != null) {		
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating PrintForm from printhdrdto " + printhdrdto);		
				BeanUtils.copyProperties(editForm, printhdrdto);
				
				// init report details	
				List printdtls = printdtlbd.findPrintdtlsByPrinthdrId(printhdrdto.getPrinthdrId());
				if (printdtls != null) {
					Iterator i = printdtls.iterator();	
					while (i.hasNext()) {
						Printdtl printdtldto = (Printdtl) i.next();
						PrintdtlForm printdtlForm = new PrintdtlForm();
						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating PrintForm from printdtldto " + printdtldto);		
						BeanUtils.copyProperties(printdtlForm, printdtldto);
						printdtlForms.add(printdtlForm);					
					}
				}				
			}
		}
		
		
		// delete header and details if refresh data
		if (editForm.getRefreshdata().equals("Y")) {
			if (printhdrdto != null) {
				printhdrbd.deleteAll(printhdrdto.getPrinthdrId(),user);
			}			
		} 
		
		
		
		// initialise from order header
		if (printhdrdto == null || editForm.getRefreshdata().equals("Y")) {					
			
			
			Onhire onhiredto = null;
			//printhdrdto = new Printhdr();
			onhiredto = new OnhireBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOnhireId()));
			editForm.setJobNumber(onhiredto.getOnhireno());
			editForm.setReportType("Onhirenotification");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());
			
			editForm.setCustomerRef(onhiredto.getOnhireno());			
			editForm.setPoldateest(onhiredto.getEstreldate());
			
			
			
			editForm.setMemo4("On Hire Notification");			// ref
			editForm.setMemo5(user.getEmail());					// FROM					
			
			
			editForm.setMemo11(onhiredto.getComments());
			
			editForm.setShipper("");			
			editForm.setConsignee("");
			editForm.setCustomer("");
			
			try{editForm.setCustomer(addressbd.read(onhiredto.getLesseeaddrkey()).getName());}catch(Exception e){}
			
			try{
				Location location = locationbd.read(onhiredto.getLocationkey());
				editForm.setShipper(location.getLocationName());
				editForm.setShipperAddress1(location.getAddress1());
				editForm.setShipperAddress2(location.getAddress2());
				editForm.setShipperAddress3(location.getAddress3());
				editForm.setShipperFax("Tel:"+location.getPhone()+" Fax:"+location.getFax());
			}catch(Exception e){}
			
			
			
			editForm.setPol("");
			editForm.setPod("");
			
			editForm.setShipLine("");
			editForm.setVessel("");			
			editForm.setPickupPlant("");			
			editForm.setFinalDelivery("");		
			
			
			// init report details	
			List onhireeqpdtos = new OnhireBD(this.getSessionFactoryClusterMap()).getOnhireeqps(onhiredto.getOnhireId());
			if (onhireeqpdtos.size() > 0) {
				int row = 0;
				Iterator i = onhireeqpdtos.iterator();
				
				
				while (i.hasNext()) {
					Onhireeqp onhireeqpdto = (Onhireeqp) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					printdtlForm.setJobNumber(editForm.getJobNumber());
					printdtlForm.setReportType(editForm.getReportType());
					
					row++;
					
					
					printdtlForm.setId(new Integer(row).toString()+editForm.getPrintId());
					printdtlForm.setIdType("TankId");
					printdtlForm.setTankNumber(onhireeqpdto.getUnitkey());						
					
					printdtlForm.setPuPlantApptDate(onhireeqpdto.getReservedate());
					
					printdtlForm.setMemoB("");
					Unit unitdao = new Unit();
					try {
						unitdao=unitbd.read(onhireeqpdto.getUnitId());
						printdtlForm.setMemoB(unitdao.getEqpkeyp1()+" / "+unitdao.getEqpkeyp2());													
						
						
						// get last contents
						printdtlForm.setProductId("");
						printdtlForm.setMemoA("");
						Product productdao = new Product();
						try {
							productdao=productbd.read(unitdao.getMoveproductkey());
							printdtlForm.setProductId(productdao.getLdesc());					
							printdtlForm.setMemoA(
									"  IMO: "+productdao.getImo()+
									"  UN: "+productdao.getUnno()+
									"  IMDG: "+productdao.getImdg()+							
									"  CLG: "+productdao.getCleangrp()+
									"  PKG: "+productdao.getPackgrp()+
									"  SPGV: "+productdao.getSpecgrav()
							);					
						} catch (Exception e) {}
						
						
						// get next test due date
						Unittest unittestdao = new Unittest();					
						try {
							unittestdao=unittestbd.getNextUnittestDue(unitdao.getUnitId());
							printdtlForm.setPuPlantLoadDate(unittestdao.getDuedate());						
						} catch (Exception e) {}					
						
						
						
					} catch (Exception e) {}
					
					printdtlForm.setNumberOfTanks(new Integer(onhireeqpdtos.size()).toString());
					
					
					printdtlForms.add(printdtlForm);					
				}			
				
			}				
			
		}
		
		// init details
		editForm.setPrintdtls(printdtlForms);
		
		
		// null objects for garbage collection
		printhdrbd = null;
		printdtlbd = null;
		addressbd = null;
		productbd = null;
		unittestbd = null;
		locationbd = null;
		printdtlForms = null;
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}
	
	
	
}
