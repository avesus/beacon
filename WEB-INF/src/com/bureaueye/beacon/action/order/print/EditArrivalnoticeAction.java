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
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdernoteBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;

import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;




/**
 */
public class EditArrivalnoticeAction extends BaseAction {
	
	
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
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating ArrivalNoticeForm from companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}
		
		
		Printhdr printhdrdto = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		SystemmappingcodeBD systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		java.util.Set printdtlForms = new java.util.HashSet();

		
		// initialise print header and details
		printhdrdto = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());
		
		if (editForm.getRefreshdata().equals("N")) {			
		if (printhdrdto != null) {		
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating ArrivalNoticeForm from printhdrdto " + printhdrdto);		
			BeanUtils.copyProperties(editForm, printhdrdto);
			
			// init report details	
			List printdtls = printdtlbd.findPrintdtlsByPrinthdrId(printhdrdto.getPrinthdrId());
			if (printdtls != null) {
				Iterator i = printdtls.iterator();	
				while (i.hasNext()) {
					Printdtl printdtldto = (Printdtl) i.next();
					PrintdtlForm printdtlForm = new PrintdtlForm();
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating ArrivalNoticeForm from printdtldto " + printdtldto);		
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

			// retrieve section mapping for PKUP, LOAD, DSCH & DELV
			String pkupSection = "";
			String loadSection = "";
			String dschSection = "";
			String delvSection = "";
			String rtdpSection = "";
			try{pkupSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "PKUP").getCompanycode();}catch(Exception e){}
			try{loadSection  = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD").getCompanycode();}catch(Exception e){}
			try{dschSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DSCH").getCompanycode();}catch(Exception e){}
			try{delvSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DELV").getCompanycode();}catch(Exception e){}
			try{rtdpSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "RTDP").getCompanycode();}catch(Exception e){}
			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findSystemmappingcode: " +
					" pkupSection="+pkupSection+
					" loadSection="+loadSection+
					" dschSection="+dschSection+
					" delvSection="+delvSection+
					" rtdpSection="+rtdpSection	
					);		
			
			
			Orderhdr orderhdrdto = null;
			//printhdrdto = new Printhdr();
			orderhdrdto = new OrderhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(editForm.getOrderhdrId()));
			editForm.setJobNumber(orderhdrdto.getOrderno());
			editForm.setReportType("AN");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());
			
			editForm.setBookingNumber(orderhdrdto.getBookingnumber());			
						
			editForm.setPoldateest(orderhdrdto.getLdgfromdate());
			editForm.setPoddateest(orderhdrdto.getDchfromdate());		
			
			
			editForm.setMemo3("Arrival Notice");			// subject
			editForm.setMemo7(user.getEmail());				// from
			editForm.setMemo11(orderhdrdto.getQuotno());	// quote
			
			
			editForm.setMemo2("");							// Notes
			try{
				editForm.setMemo2(
					new OrdernoteBD(this.getSessionFactoryClusterMap()).findOrdernoteByKey1(
							orderhdrdto.getId().toString(),
							"ANNOTES"
							).getNote1()
						);
			}catch(Exception e){}
				
			
			editForm.setShipper("");			
			editForm.setConsignee("");
			editForm.setCustomer("");
			editForm.setConsigneeAddress1("");
			editForm.setConsigneeAddress2("");
			editForm.setConsigneeAddress3("");
			try{editForm.setShipper(addressbd.read(orderhdrdto.getShipperaddrkey()).getName());}catch(Exception e){}
			try{
				Address consignee = addressbd.read(orderhdrdto.getConsigneeaddrkey());
				if (consignee != null) {
					editForm.setConsignee(consignee.getName());
					editForm.setConsigneeAddress1(consignee.getAddr1());
					editForm.setConsigneeAddress2(consignee.getAddr2());
					editForm.setConsigneeAddress3(consignee.getAddr3());
				}
			} catch(Exception e){}
			try{
				editForm.setCustomer(
						addressbd.read(orderhdrdto.getCustomeraddrkey()).getName()
						);
			}catch(Exception e){}
			
			editForm.setCustomerRef(orderhdrdto.getCustomerref());
			editForm.setShipperRef(orderhdrdto.getShipperref());
			editForm.setConsigneeRef(orderhdrdto.getConsigneeref());			
			editForm.setShipMethod(orderhdrdto.getShipmethod());
			

			
			// loading
			editForm.setPol("");
			try{editForm.setPol(locationbd.read(orderhdrdto.getLdglocationkey2()).getLocationName());}catch(Exception e){}
			// discharge
			editForm.setPod("");
			try{editForm.setPod(locationbd.read(orderhdrdto.getDchlocationkey2()).getLocationName());}catch(Exception e){}


			editForm.setMemo1(orderhdrdto.getCcykey());	
			editForm.setMemo4(orderhdrdto.getDmrgfreedays().toString());			
			editForm.setMemo5(
					"From 1 to "+orderhdrdto.getDmrgdays1().toString()+"days the rate is "+orderhdrdto.getDmrgdlyrate1().toString()+
					" from "+orderhdrdto.getDmrgdays1().toString()+" to "+orderhdrdto.getDmrgdays2().toString()+"days the rate is "+orderhdrdto.getDmrgdlyrate2().toString()+
					" after "+orderhdrdto.getDmrgdays2().toString()+"days the rate is "+orderhdrdto.getDmrgdlyrate2().toString()
					);			

			editForm.setShipLine("");
			editForm.setVessel("");
			editForm.setPickupPlant("");
			editForm.setFinalDelivery("");
			editForm.setMemo10("");
			
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
					
					// process if first record
					if (row==1) {
						
						// standard sections
						Jobmov pkupJobmov = null;
						Jobmov loadJobmov = null;
						//Jobmov dschJobmov = null;
						Jobmov delvJobmov = null;
						Jobmov rtdpJobmov = null;												
						// retrieve sections					
						try{pkupJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), pkupSection);}catch(Exception e){}
						try{loadJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), loadSection);}catch(Exception e){}
						//try{dschJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), dschSection);}catch(Exception e){}
						try{delvJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), delvSection);}catch(Exception e){}
						try{rtdpJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), rtdpSection);}catch(Exception e){}

						editForm.setPickupPlant("");
						if (pkupJobmov != null) {
							if (pkupJobmov.getFromlocationkey() != null)
								editForm.setPickupPlant(
									locationbd.read(pkupJobmov.getFromlocationkey()).getLocationName()
									);
						}

						editForm.setFinalDelivery("");
						if (delvJobmov != null) {
							if (delvJobmov.getEstfromdate() != null) editForm.setFinalDeliveryDateEst(delvJobmov.getEstfromdate());
							if (delvJobmov.getFromlocationkey() != null) 
								editForm.setFinalDelivery(
									locationbd.read(delvJobmov.getFromlocationkey()).getLocationName()
									);
						}
						
						editForm.setShipLine("");
						editForm.setVessel("");
						printdtlForm.setMovref("");
						if (loadJobmov != null) {
							if (loadJobmov.getVendoraddrkey() != null) 
								editForm.setShipLine(
									addressbd.read(loadJobmov.getVendoraddrkey()).getName()								
									);
							if (loadJobmov.getVessel() != null) editForm.setVessel(loadJobmov.getVessel());
							if (loadJobmov.getMovref() != null) printdtlForm.setMovref(loadJobmov.getMovref());
						}		

						editForm.setMemo10("");
						if (rtdpJobmov != null) {
							if (rtdpJobmov.getFromlocationkey() != null)
								editForm.setMemo10(
									locationbd.read(rtdpJobmov.getFromlocationkey()).getLocationName()									
									);
						}
						
						editForm.setWeightPerTankAprox(jobhdrdto.getWeightactual().toString());
						editForm.setWeightType(jobhdrdto.getWeightactualunit());
					}
					
					printdtlForm.setId(new Integer(row).toString()+editForm.getPrintId());
					printdtlForm.setIdType("TankId");
					printdtlForm.setTankNumber(jobhdrdto.getUnitkey());						
					
					
					printdtlForm.setProductId(
							productbd.read(jobhdrdto.getProductkey()).getLdesc()
							);					
					printdtlForm.setMemoA(jobhdrdto.getAddinstruction());					
					printdtlForm.setMemoB(
							"Seal Numbers: "+
							jobhdrdto.getSealnumber1()+" / "+
							jobhdrdto.getSealnumber2()+" / "+
							jobhdrdto.getSealnumber3()+" / "+
							jobhdrdto.getSealnumber4()+" / "+
							jobhdrdto.getSealnumber5()+" / "
							);		
					
					printdtlForm.setNumberOfTanks(new Integer(jobhdrdtos.size()).toString());

					printdtlForm.setActualWeight(jobhdrdto.getWeightactual().toString());
					printdtlForm.setWeightType(jobhdrdto.getWeightactualunit());
				
					printdtlForms.add(printdtlForm);					
				}			
				
			}				
					
		}
		
		// init details
		editForm.setPrintdtls(printdtlForms);

		
		printhdrdto = null;
		printhdrbd = null;
		printdtlbd= null;
		addressbd = null;
		productbd = null;
		locationbd= null;
		systemmappingcodebd = null;
		printdtlForms = null;
		
		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}
	
	
	
}
