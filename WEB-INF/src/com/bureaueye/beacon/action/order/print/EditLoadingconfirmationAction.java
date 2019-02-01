package com.bureaueye.beacon.action.order.print;


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
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;

import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;




/**
 * Searches the database for records matching the
 * search argument
 */
public class EditLoadingconfirmationAction extends BaseAction {
	
	
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
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating LoadingConfirmationForm from companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}
		
		
		Printhdr printhdrdto = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());		
		SystemmappingcodeBD systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		java.util.Set printdtlForms = new java.util.HashSet();

		
		// initialise print header and details
		printhdrdto = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());
		
		if (editForm.getRefreshdata().equals("N")) {			
		if (printhdrdto != null) {		
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating LoadingConfirmationForm from printhdrdto " + printhdrdto);		
			BeanUtils.copyProperties(editForm, printhdrdto);
			
			// init report details	
			List printdtls = printdtlbd.findPrintdtlsByPrinthdrId(printhdrdto.getPrinthdrId());
			if (printdtls != null) {
				Iterator i = printdtls.iterator();	
				while (i.hasNext()) {
					Printdtl printdtldto = (Printdtl) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating LoadingConfirmationForm from printdtldto " + printdtldto);		
					BeanUtils.copyProperties(printdtlForm, printdtldto);
					printdtlForms.add(printdtlForm);					
				}
			}				
		}
		}
		
		
		// delete header and details if refresh data
		if (editForm.getRefreshdata().equals("Y")) {
			if (printhdrdto != null) {
//				java.util.Set printdtls = printhdrdto.getPrintdtls();
//				// delete header
//				printhdrbd.delete(printhdrdto,user);
//				// delete details
//				for (Iterator it = printdtls.iterator(); it.hasNext();) {
//					Printdtl printdtldto = printdtlbd.read(((Printdtl)it.next()).getPrintdtlId());
//					if (printdtldto != null) printdtlbd.delete(printdtldto,user);
//				}
				printhdrbd.deleteAll(printhdrdto.getPrinthdrId(),user);
			}			
		} 
		
		
		
		// initialise from order header
		if (printhdrdto == null || editForm.getRefreshdata().equals("Y")) {					
			
			Orderhdr orderhdrdto = null;
			//printhdrdto = new Printhdr();
			orderhdrdto = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOrderhdrId()));
			editForm.setJobNumber(orderhdrdto.getOrderno());
			editForm.setReportType("LC");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());
			editForm.setBookingNumber(orderhdrdto.getBookingnumber());			
						
			editForm.setPoldateest(orderhdrdto.getLdgfromdate());
			editForm.setPoddateest(orderhdrdto.getDchfromdate());		
			
			editForm.setMemo1("");	// origin/dest
			editForm.setMemo2("");	// ETA
			editForm.setMemo3("");	// ETA
			try{editForm.setMemo3(locationbd.read(orderhdrdto.getDchlocationkey1()).getLocationName());}catch(Exception e){}	// Dest plant		
			editForm.setMemo4("Confirmation of Loading: "+orderhdrdto.getOrderno());	// ref
			editForm.setMemo5(user.getEmail());	// FROM					
			editForm.setMemo7("");	// Comments
			editForm.setMemo8("");	// TO					
			editForm.setMemo9("");	// CC				
			editForm.setMemo10("");	// pages
			editForm.setMemo11(orderhdrdto.getQuotno());	// quote
			
			//editForm.setMemo12("");	// hbltype					
			//editForm.setMbl("");	//mbl ?			

			editForm.setMemo1("");
			try{editForm.setMemo1(locationbd.read(orderhdrdto.getLdglocationkey2()).getLocationName());}catch(Exception e){}
	
			editForm.setShipper("");			
			editForm.setConsignee("");
			editForm.setCustomer("");
			try{editForm.setShipper(addressbd.read(orderhdrdto.getShipperaddrkey()).getName());}catch(Exception e){}
			try{editForm.setConsignee(addressbd.read(orderhdrdto.getConsigneeaddrkey()).getName());}catch(Exception e){}
			try{
				editForm.setCustomer(
						addressbd.read(orderhdrdto.getCustomeraddrkey()).getName()
						);
			} catch(Exception e){}
					//addressbd.read(orderhdrdto.getCustomeraddrkey()).getName());}catch(Exception e){}

			
			editForm.setCustomerRef(orderhdrdto.getCustomerref());
			editForm.setShipMethod(orderhdrdto.getShipmethod());
			
			// retrieve section mapping for PKUP, LOAD & DISCH
			String pkupSection = "";
			String loadSection = "";
			//String dischSection = "";
//			pkupSection = systemmappingcodebd
//							.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "PKUP")
//							.getCompanycode();
//			loadSection = systemmappingcodebd
//							.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD")
//							.getCompanycode(); 
			//dischSection = systemmappingcodebd
			//				.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD")
			//				.getCompanycode(); 
			
			
			// init report details	
			List jobhdrdtos = new OrderhdrBD(this.getSessionFactoryClusterMap()).getJobhdrs(orderhdrdto.getId());
			if (jobhdrdtos.size() > 0) {
				int row = 0;
				Iterator i = jobhdrdtos.iterator();			
				while (i.hasNext()) {
					Jobhdr jobhdrdto = (Jobhdr) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					printdtlForm.setJobNumber(editForm.getJobNumber());
					printdtlForm.setReportType(editForm.getReportType());
					row++;
					printdtlForm.setId(new Integer(row).toString()+editForm.getPrintId());
					printdtlForm.setIdType("TankId");
					printdtlForm.setTankNumber(jobhdrdto.getUnitkey());						
					printdtlForm.setProductId(
							productbd.read(jobhdrdto.getProductkey()).getLdesc()
							);	
					
					printdtlForm.setNumberOfTanks(new Integer(jobhdrdtos.size()).toString());

					// retrieve sections
//					Jobmov pkupJobmov = null;
//					Jobmov loadJobmov = null;
//					//Jobmov dischJobmov = null;
//					pkupJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), pkupSection);
//					loadJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), loadSection);
					//dischJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), dischSection);

					printdtlForm.setPuPlantLoadDate(null);
					printdtlForm.setPickupPlantRef("");
//					if (pkupJobmov != null) {
//						printdtlForm.setPuPlantLoadDate(pkupJobmov.getActtodate());
//						printdtlForm.setPickupPlantRef(pkupJobmov.getMovref());
//					}
					printdtlForm.setVendor("");
					printdtlForm.setVessel("");
					printdtlForm.setMovref("");
//					if (loadJobmov != null) {
//						printdtlForm.setVendor(loadJobmov.getVendoraddrkey().getName());
//						printdtlForm.setVessel(loadJobmov.getVessel());
//						printdtlForm.setMovref(loadJobmov.getMovref());
//					}
					
					
					printdtlForms.add(printdtlForm);					
				}			
			}				
		}
		// init details
		editForm.setPrintdtls(printdtlForms);
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}
	
	
	
}
