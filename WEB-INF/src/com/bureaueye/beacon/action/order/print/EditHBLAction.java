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
import com.bureaueye.beacon.model.order.Ordernote;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdernoteBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;

import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;




/**
 * Searches the database for records matching the
 * search argument
 */
public class EditHBLAction extends BaseAction {
	
	
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
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Processing " + action + " action");
		
		
		// initialise company header
		Companyheader companyheaderdto = null;
		companyheaderdto = new CompanyheaderBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getCompanyheaderId()));
		if (companyheaderdto != null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}
		
		
		Printhdr printhdrdto = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		OrdernoteBD ordernotebd = new OrdernoteBD(this.getSessionFactoryClusterMap());		
		SystemmappingcodeBD systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		java.util.Set printdtlForms = new java.util.HashSet();

		
		// initialise print header and details
		printhdrdto = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());
		
		if (editForm.getRefreshdata().equals("N")) {			
		if (printhdrdto != null) {		
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating from printhdrdto " + printhdrdto);		
			BeanUtils.copyProperties(editForm, printhdrdto);
			
			// init report details
			List printdtls = printdtlbd.findPrintdtlsByPrinthdrId(printhdrdto.getPrinthdrId());
			if (printdtls != null) {
				Iterator i = printdtls.iterator();	
				while (i.hasNext()) {
					Printdtl printdtldto = (Printdtl) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating from printdtldto " + printdtldto);		
					BeanUtils.copyProperties(printdtlForm, printdtldto);
					printdtlForms.add(printdtlForm);					
				}
			}				
		}
		}
		
		
		// delete header and details if refresh data
		if (editForm.getRefreshdata().equals("Y")) {
			if (printhdrdto != null) {
				//java.util.Set printdtls = printhdrdto.getPrintdtls();
				// delete header
				//printhdrbd.delete(printhdrdto,user);
				// delete details
				//for (Iterator it = printdtls.iterator(); it.hasNext();) {
				//	Printdtl printdtldto = printdtlbd.read(((Printdtl)it.next()).getPrintdtlId());
				//	if (printdtldto != null) printdtlbd.delete(printdtldto,user);
				//}
				printhdrbd.deleteAll(printhdrdto.getPrinthdrId(),user);
			}			
		} 
		
		
		
		// initialise from order header
		if (printhdrdto == null || editForm.getRefreshdata().equals("Y")) {					
			
			Orderhdr orderhdrdto = null;
			//printhdrdto = new Printhdr();
			orderhdrdto = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOrderhdrId()));
			editForm.setJobNumber(orderhdrdto.getOrderno());
			editForm.setReportType("HBL");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());
			editForm.setBookingNumber(orderhdrdto.getBookingnumber());			
						
			editForm.setPoldateest(orderhdrdto.getLdgfromdate());
			editForm.setPoddateest(orderhdrdto.getDchfromdate());		
			
			editForm.setMemo1("");	// origin/dest
			editForm.setMemo2("");	// ETA
			editForm.setMemo3(locationbd.read(orderhdrdto.getDchlocationkey1()).getLocationName());	// Dest plant		
			editForm.setMemo4("House Bill of Lading: "+orderhdrdto.getOrderno());	// ref
			editForm.setMemo5(user.getEmail());	// FROM					
			editForm.setMemo7("");	// Comments
			editForm.setMemo8("");	// TO					
			editForm.setMemo9("");	// CC				
			editForm.setMemo10("");	// pages
			editForm.setMemo11(orderhdrdto.getQuotno());	// quote
			
			//editForm.setMemo12("");	// hbltype					
			//editForm.setMbl("");	//mbl ?			

			//editForm.setMemo1(locationbd.read(orderhdrdto.getLdglocationkey2()).getLocationName());

			editForm.setShipper("");
			editForm.setShipperAddress1("");
			editForm.setShipperAddress2("");
			editForm.setShipperAddress3("");
			Address shipperdto = addressbd.read(orderhdrdto.getShipperaddrkey());
			if (shipperdto != null) {
				editForm.setShipper(shipperdto.getName());
				editForm.setShipperAddress1(shipperdto.getAddr1());
				editForm.setShipperAddress2(shipperdto.getAddr2());
				editForm.setShipperAddress3(shipperdto.getAddr3());
			}
			editForm.setConsignee("");
			editForm.setConsigneeAddress1("");
			editForm.setConsigneeAddress2("");
			editForm.setConsigneeAddress3("");			
			Address consigneedto = addressbd.read(orderhdrdto.getConsigneeaddrkey());
			if (consigneedto != null) {
				editForm.setConsignee(consigneedto.getName());
				editForm.setConsigneeAddress1(consigneedto.getAddr1());
				editForm.setConsigneeAddress2(consigneedto.getAddr2());
				editForm.setConsigneeAddress3(consigneedto.getAddr3());
			}
			editForm.setCustomer("");
			editForm.setCustomerAddress1("");
			editForm.setCustomerAddress2("");
			editForm.setCustomerAddress3("");			
			Address customerdao = addressbd.read(orderhdrdto.getCustomeraddrkey());
			//addressbd.read(orderhdrdto.getCustomeraddrkey());
			if (customerdao != null) {
				editForm.setCustomer(customerdao.getName());
				editForm.setCustomerAddress1(customerdao.getAddr1());
				editForm.setCustomerAddress2(customerdao.getAddr2());
				editForm.setCustomerAddress3(customerdao.getAddr3());
			}
			editForm.setFwdAgent("");
			editForm.setFwdAgentAddress1("");
			editForm.setFwdAgentAddress2("");
			editForm.setFwdAgentAddress3("");
			Address fwdagentdto = addressbd.read(orderhdrdto.getFwdagentaddrkey());
			if (fwdagentdto != null) {
				editForm.setFwdAgent(fwdagentdto.getName());
				editForm.setFwdAgentAddress1(fwdagentdto.getAddr1());
				editForm.setFwdAgentAddress2(fwdagentdto.getAddr2());
				editForm.setFwdAgentAddress3(fwdagentdto.getAddr3());
			}
			editForm.setNotifyContact("");
			editForm.setNotifyAddress1("");
			editForm.setNotifyAddress2("");
			editForm.setNotifyAddress3("");
			
			editForm.setCustomerRef(orderhdrdto.getCustomerref());
			editForm.setShipperRef(orderhdrdto.getShipperref());
			editForm.setConsigneeRef(orderhdrdto.getConsigneeref());
			editForm.setFwdAgentRef(orderhdrdto.getFwdagentref());
			
			editForm.setShipMethod(orderhdrdto.getShipmethod());

			editForm.setPreCarriageBy("");
			editForm.setPlaceOfReceipt("");
			editForm.setFinalDelivery("");
			editForm.setVesselVoyage("");
			editForm.setContainerized("");
			
			Ordernote exportinstructions = null;
			exportinstructions = ordernotebd.findOrdernoteByKey1(
														orderhdrdto.getId().toString(), 
														"EXPORTINSTRUCTIONS"
														);
			editForm.setExportInstructions("");
			if (exportinstructions != null) editForm.setExportInstructions(exportinstructions.getNote1());
			editForm.setExportTruckInstructions("");
			Ordernote truckexportinstructions = null;
			truckexportinstructions = ordernotebd.findOrdernoteByKey1(
														orderhdrdto.getId().toString(), 
														"TRUCKEXPORTINSTRUCTS"
														);
			if (truckexportinstructions != null) editForm.setExportTruckInstructions(truckexportinstructions.getNote1());
	
			Ordernote hblnotes = null;
			hblnotes = ordernotebd.findOrdernoteByKey1(
														orderhdrdto.getId().toString(), 
														"HBLNOTES"
														);
			if (hblnotes != null) editForm.setMemo1(hblnotes.getNote1());

			
			Location poddto = locationbd.read(orderhdrdto.getDchlocationkey2());
			if (poddto != null) editForm.setPod(poddto.getLocationName());

			Location poldto = locationbd.read(orderhdrdto.getLdglocationkey2());
			if (poldto != null) editForm.setPol(poldto.getLocationName());
			
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
					printdtlForm.setProductId(productbd.read(jobhdrdto.getProductkey()).getLdesc());	
					
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
