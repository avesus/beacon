package com.bureaueye.beacon.action.order.print;


import java.math.BigDecimal;
import java.util.Date;
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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.print.PrintdtlForm;
import com.bureaueye.beacon.form.print.PrinthdrForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdernoteBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;

import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;




/**
 */
public class EditDisbursementsummaryAction extends BaseAction {




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
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}


		Printhdr printhdrdto = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		SystemmappingcodeBD systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());
		CcyexBD ccyexbd = new CcyexBD(this.getSessionFactoryClusterMap());	
		java.util.Set printdtlForms = new java.util.HashSet();


		// initialise print header and details
		printhdrdto = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());

		if (editForm.getRefreshdata().equals("N")) {			
			if (printhdrdto != null) {		
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from printhdrdto " + printhdrdto);		
				BeanUtils.copyProperties(editForm, printhdrdto);

				// init report details	
				List printdtls = printdtlbd.findPrintdtlsByPrinthdrId(printhdrdto.getPrinthdrId());
				if (printdtls != null) {
					Iterator i = printdtls.iterator();	
					while (i.hasNext()) {
						Printdtl printdtldto = (Printdtl) i.next();
						PrintdtlForm printdtlForm = new PrintdtlForm();
						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from printdtldto " + printdtldto);		
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

			// exrate lookup
			ListForm ccyexListForm = new ListForm();
			ccyexListForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			ccyexListForm.setGotoPage(0);
			ccyexListForm.setSearchDate1(new Date());
			ccyexListForm.setOrderBy("Exdate");
			ccyexListForm.setOrderByDesc("Desc");			


			// retrieve section mapping for PKUP, LOAD, DSCH & DELV
			String pkupSection = "";
			String loadSection = "";
			String dschSection = "";
			String delvSection = "";
			String rtdpSection = "";
			String shipSection = "";
			try{pkupSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "PKUP").getCompanycode();}catch(Exception e){}
			try{loadSection  = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD").getCompanycode();}catch(Exception e){}
			try{dschSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DSCH").getCompanycode();}catch(Exception e){}
			try{delvSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DELV").getCompanycode();}catch(Exception e){}
			try{rtdpSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "RTDP").getCompanycode();}catch(Exception e){}
			try{shipSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "SHIP").getCompanycode();}catch(Exception e){}


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
			editForm.setReportType("DS");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setReportDate(new java.util.Date());

			editForm.setBookingNumber(orderhdrdto.getBookingnumber());			

			editForm.setPoldateest(orderhdrdto.getLdgfromdate());
			editForm.setPoddateest(orderhdrdto.getDchfromdate());		


			editForm.setMemo3("Disbursement Summary");		// subject
			editForm.setMemo7(user.getEmail());				// from





			//NOTES
			editForm.setMemo2("");							// Notes
			try{
				editForm.setMemo2(
						new OrdernoteBD(this.getSessionFactoryClusterMap()).findOrdernoteByKey1(
								orderhdrdto.getId().toString(),
								"DSNOTES"
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
				Address consignee = addressbd.read(orderhdrdto.getCustomeraddrkey());
				if (consignee != null) {
					editForm.setConsignee(consignee.getName());
					editForm.setConsigneeAddress1(consignee.getAddr1());
					editForm.setConsigneeAddress2(consignee.getAddr2());
					editForm.setConsigneeAddress3(consignee.getAddr3()+" "+consignee.getPostalcode());
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

			BigDecimal costTotal = new BigDecimal(0.0);
			BigDecimal chargeTotal = new BigDecimal(0.0);			
			try{chargeTotal = this.getChargeTotal(orderhdrdto.getId().toString());}catch(Exception e){}


			// init vessel details
			List jobhdrdtos = new OrderhdrBD(this.getSessionFactoryClusterMap()).getJobhdrs(orderhdrdto.getId());
			if (jobhdrdtos.size() > 0) {				

				int row = 1;
				Iterator i = jobhdrdtos.iterator();


				while (i.hasNext()) {
					Jobhdr jobhdrdto = (Jobhdr) i.next();


					// process if first record
					if (row==1) {						
						// standard sections
						Jobmov shipJobmov = null;												
						// retrieve sections					
						try{shipJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdrdto.getJobhdrId().toString(), shipSection);}catch(Exception e){}						
						//init vessel information
						editForm.setVessel("");
						editForm.setVoyage("");
						if (shipJobmov != null) {
							editForm.setVessel(shipJobmov.getVessel());	
							editForm.setVoyage(shipJobmov.getVoyage());
						}		
					}


					//need to total all job costs for order
					try {
						BigDecimal jobCostTotal = this.getCostTotal(jobhdrdto.getJobhdrId().toString());
						costTotal=costTotal.add(jobCostTotal);
					} catch (Exception e) {
					}


					//get costs for job
					List jobcosts = jobcostbd.findJobmovcostsByJobhdrIdForDisbursement(
							jobhdrdto.getJobhdrId().toString(),
							0,
							Constants.MAX_RESULTS_NOLIMIT,
							"address.Name"
					);		

					log.info(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  jobcosts size: "+jobcosts.size()
					);


					Iterator it2 = jobcosts.iterator();
					while (it2.hasNext()) {

						OrdersummaryJobcostDTO jobcost = (OrdersummaryJobcostDTO) it2.next();	

						PrintdtlForm printdtlForm = new PrintdtlForm();
						printdtlForm.setJobNumber(editForm.getJobNumber());
						printdtlForm.setReportType(editForm.getReportType());

						printdtlForm.setId(new Integer(row).toString()+editForm.getPrintId());
						printdtlForm.setIdType("TankId");
						printdtlForm.setTankNumber(jobhdrdto.getUnitkey());						


						try {
							printdtlForm.setMemoA(jobcost.getVendoraddrkey().getName());							
							printdtlForm.setMemoB(new CurrencyFormatter().format(jobcost.getCstamtbase()));
							printdtlForm.setAddInstructions(jobcost.getCostdescr());	
						} catch (Exception e) {
						}


						printdtlForms.add(printdtlForm);


					}//end of costs loop
					//

					row++;
				}//end of jobs loop			



				BigDecimal profitTotal = new BigDecimal(0.0);
				try {
					profitTotal = chargeTotal.subtract(costTotal);   	  		
				} catch (Exception e) {			
				}


			}				

		}

		log.info(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				"  printdtlForms size: "+printdtlForms.size()
		);

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
		jobcostbd = null;



		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}




	public BigDecimal getCostTotal(String id) 
	{	
		BigDecimal total = new BigDecimal(0.00);	

		// retrieve cost total					
		try{
			total = new JobcostBD(this.getSessionFactoryClusterMap()).jobcostsCstamtbaseTotal(id);
		} catch (Exception e) {
		}

		return total;
	}


	public BigDecimal getChargeTotal(String id) 
	{	
		BigDecimal total = new BigDecimal(0.00);	

		// retrieve cost total					
		try{
			total = new OrderchargeBD(this.getSessionFactoryClusterMap()).orderchargesChgamtbaseTotal(id);
		} catch (Exception e) {
		}

		return total;
	}



}
