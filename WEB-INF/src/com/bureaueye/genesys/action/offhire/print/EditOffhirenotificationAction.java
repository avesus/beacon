package com.bureaueye.genesys.action.offhire.print;


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
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.genesys.model.offhire.Offhire;
import com.bureaueye.genesys.model.offhire.Offhireeqp;
import com.bureaueye.genesys.model.offhire.bd.OffhireBD;



/**
 */
public class EditOffhirenotificationAction extends BaseAction {
	
	
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
			
			
			Offhire offhiredto = null;
			//printhdrdto = new Printhdr();
			offhiredto = new OffhireBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOffhireId()));
			editForm.setJobNumber(offhiredto.getOffhireno());
			editForm.setReportType("Offhirenotification");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());
			
			editForm.setCustomerRef(offhiredto.getOffhireno());			
			editForm.setPoldateest(offhiredto.getEstdeldate());
			
			
			
			editForm.setMemo4("Off Hire Notification");			// ref
			editForm.setMemo5(user.getEmail());					// FROM					
			
			
			editForm.setMemo11(offhiredto.getComments());
			
			editForm.setShipper("");			
			editForm.setConsignee("");
			editForm.setCustomer("");
			
			try{editForm.setCustomer(addressbd.read(offhiredto.getLesseeaddrkey()).getName());}catch(Exception e){}
			
			try{
				Location location = locationbd.read(offhiredto.getLocationkey());
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
			List offhireeqpdtos = new OffhireBD(this.getSessionFactoryClusterMap()).getOffhireeqps(offhiredto.getOffhireId());
			if (offhireeqpdtos.size() > 0) {
				int row = 0;
				Iterator i = offhireeqpdtos.iterator();
				
				
				while (i.hasNext()) {
					Offhireeqp offhireeqpdto = (Offhireeqp) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					printdtlForm.setJobNumber(editForm.getJobNumber());
					printdtlForm.setReportType(editForm.getReportType());
					
					row++;
					
					
					printdtlForm.setId(new Integer(row).toString()+editForm.getPrintId());
					printdtlForm.setIdType("TankId");
					printdtlForm.setTankNumber(offhireeqpdto.getUnitkey());						
					
					printdtlForm.setPuPlantApptDate(offhireeqpdto.getReservedate());
					
					printdtlForm.setMemoB("");
					Unit unitdao = new Unit();
					try {
						unitdao=unitbd.read(offhireeqpdto.getUnitId());
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
						
					
					} catch (Exception e) {}
					
					printdtlForm.setNumberOfTanks(new Integer(offhireeqpdtos.size()).toString());
					
					
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
		locationbd = null;
		printdtlForms = null;
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}
	
	
	
}
