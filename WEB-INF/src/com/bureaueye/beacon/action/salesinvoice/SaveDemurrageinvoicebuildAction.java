package com.bureaueye.beacon.action.salesinvoice;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.TreeMap;

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
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobmovDemurrageDTO;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Taxcode;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;
import com.bureaueye.beacon.util.Util;





public final class SaveDemurrageinvoicebuildAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		ListForm saveForm = (ListForm) form;
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();
		
		BigDecimal zeroBD = new BigDecimal(0.0);
		
		// If the session has timed-out then take the user back to the login page
		if (session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Action: "+saveForm.getAction());		
		
		
		// validation		
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
		
		
		
		// get selected rows
		int[] selectedObjects = saveForm.getSelectedObjects();
		TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
		if (selectedObjects != null) {
			for (int i = 0; i < selectedObjects.length; i++) {				
				tm.put(new Integer(selectedObjects[i]),new Integer(selectedObjects[i]));			
			}
		} 
		// process SELECT ALL
		else { 
			if (saveForm.getSearchString15() != null) {
				for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {	
					JobmovDemurrageDTO dto = (JobmovDemurrageDTO)it.next();	
					tm.put(new Integer(dto.getJobmovId1()),new Integer(dto.getJobmovId1()));
				}	
			}
		}
		
		
		
		// if CLOSE button pressed 
		if (saveForm.getAction().equals("Close")) {
			JobmovBD _jobmovBD = new JobmovBD(this.getSessionFactoryClusterMap());
			
			int row = 0;
			for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {

				// get row
				JobmovDemurrageDTO dto = (JobmovDemurrageDTO)it.next();
				
				// selected
				if (tm.get(dto.getJobmovId1()) != null) {			
					// update job movement demurrage details
					Jobmov jobmov = null;
					try {jobmov = _jobmovBD.read(dto.getJobmovId1());}catch (ApplicationException ae) {}
					try {jobmov.setDmrgfinishflag(true);} catch (Exception e) {}
					_jobmovBD.createOrUpdate(jobmov, user);	
					row++;					
				}
			}
			
			_jobmovBD = null;
			
			if (row > 0) {
				// Add invformation message 
				appInformationMessages.add(
						"messages.demurrageinvoicebuild",
						new ActionMessage(
								"information.demurrageinvoicebuild.close",
								new Integer(row).toString()
						)
				);
			}
			
		} // CLOSE button pressed
		
		
		
		
		// if PROCESS button pressed 
		if (saveForm.getAction().equals("Process")) {
			
			// validation		
			// for Group Invoices
			if (!saveForm.getSearchString7().equals("")) {
				boolean processOnce = false;
				String groupCustomer = "";
				String groupCcy = "";			
				int row = 0;
				for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {
					row++;
					// get row
					JobmovDemurrageDTO dto = (JobmovDemurrageDTO)it.next();
					
					// selected
					if (tm.get(dto.getJobmovId1()) != null) {
						
						// store customer and invoice ccy if first row
						if (!processOnce) {						
							// store fields
							groupCustomer = dto.getDmrgbilltoaddrkey();
							groupCcy = dto.getCcykey();
							processOnce = true;
							continue;
						} 
						
						// check customers and ccy are same for each Group row
						if (!groupCustomer.equals(dto.getDmrgbilltoaddrkey())) {
							// Add an error message 
							appErrorMessages.add(
									"errors.salesinvoicebuild",
									new ActionMessage(
											"error.billingaccount.isnot", 
											new Integer(row).toString(),
											groupCustomer)
							);
						}
						if (!groupCcy.equals(dto.getCcykey())) {
							// Add an error message
							appErrorMessages.add(
									"errors.salesinvoicebuild",
									new ActionMessage(
											"error.invoiceccy.isnot", 
											new Integer(row).toString(),
											groupCcy
									)
							);
						}
						
					} // selected check
				} // lineitem iterator	
			} // group invoice		
			
			
			
			// update - if no error messages
			if (appErrorMessages.isEmpty()) {
				// init buisness delegates
				OrderchargeBD _orderchargeBD = new OrderchargeBD(this.getSessionFactoryClusterMap());
				OrderhdrBD _orderhdrBD = new OrderhdrBD(this.getSessionFactoryClusterMap());
				SihdrBD _sihdrBD = new SihdrBD(this.getSessionFactoryClusterMap());
				SidtlBD _sidtlBD = new SidtlBD(this.getSessionFactoryClusterMap());
				JobmovBD _jobmovBD = new JobmovBD(this.getSessionFactoryClusterMap());
				TaxcodeBD taxcodebd=new TaxcodeBD(this.getSessionFactoryClusterMap());
				
				double taxamt = 0.0;
				
				String demurrageChargekey = "";
				try{
					demurrageChargekey = 
						new SystemcodeBD(this.getSessionFactoryClusterMap()).read(
								new SystemcodePK("DEMURRAGE","CHARGEKEY")
						).getDescr();
				}catch(Exception e){}
				
				
				// for Group Invoices
				if (!saveForm.getSearchString7().equals("")) {
					boolean processOnce = false;		
					double invoiceamt = 0.0;
					
					
					// create dto for invoice header
					Sihdr sihdr = null;
					Sidtl sidtl = null;
					
					for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {
						// get row
						JobmovDemurrageDTO dto = (JobmovDemurrageDTO)it.next();
						
					
						// do not process ZERO invoice amounts
						if (dto.getDemAmountTotal().compareTo(zeroBD) <= 0) continue;
						
						
						// selected
						if (tm.get(dto.getJobmovId1()) != null) {
							
							// store customer and invoice ccy if first row
							if (!processOnce) {
								// store fields
								processOnce = true;
								
								// required data
								Orderhdr orderhdr = null;
								try {orderhdr = _orderhdrBD.read(new Integer(dto.getOrderhdrId()));}catch (ApplicationException ae) {}
								
								// init header fields
								sihdr = new Sihdr();
								sihdr.setInvoicegroupref(saveForm.getSearchString7());
								sihdr.setInvoiceref("");
								sihdr.setInvoiceno("");
								sihdr.setCompanykey(user.getCompanykey());
								sihdr.setDepartmentkey(user.getDepartmentkey());
								sihdr.setActivitykey(user.getActivitykey());
								sihdr.setInvoiceccykey(dto.getCcykey());
								sihdr.setCustomeraddrkey(dto.getDmrgbilltoaddrkey());
								sihdr.setTxt1("");
								sihdr.setTxt2("");
								
								sihdr.setCustomerref("");
								if (orderhdr != null) {
									sihdr.setCustomerref(orderhdr.getCustomerref());
								}
								sihdr.setOrderno(dto.getOrderno());							
								sihdr.setPaymentterm(dto.getDmrgbilltoaddr().getPaytermstext());	
								
								// update header
								_sihdrBD.createOrUpdate(sihdr, user);							
							} // process header once check
							
							// create dto for invoice detail
							sidtl = new Sidtl();					
							sidtl.setSihdrId(sihdr.getSihdrId());
							
							String txt = 
								"DEMURRAGE CHARGE FOR UNIT: " +
								dto.getUnit()+
								" FROM "+
								Util.dateTextFormat2(dto.getDemStartDate())+
								" TO "+
								Util.dateTextFormat2(dto.getDemEndDate());
							
							Ordercharge ordercharge = new Ordercharge();
							// init sales invoice detail fields
							ordercharge.setInvoicegroupref(saveForm.getSearchString7());
							ordercharge.setOrderhdrId(new Integer(dto.getOrderhdrId()));
							ordercharge.setJobmovId(dto.getJobmovId1());
							ordercharge.setDmrgflag(true);
							ordercharge.setCcykey(dto.getCcykey());
							ordercharge.setCustomeraddrkey(dto.getDmrgbilltoaddrkey());
							ordercharge.setChgamt(dto.getDemAmountTotal());
							ordercharge.setOrderno(dto.getOrderno());
							ordercharge.setChargekey(demurrageChargekey);
							ordercharge.setChargetype("LUMPSUM");
							ordercharge.setRate(dto.getDemAmountTotal());
							ordercharge.setTxt1(txt);
							ordercharge.setTxt2("");
							ordercharge.setUname("");
							ordercharge.setUnits(new BigDecimal(1.0));
							ordercharge.setXratebase(new BigDecimal(1.0));
							ordercharge.setXrateinv(new BigDecimal(1.0));
							ordercharge.setInvoiceccykey(dto.getCcykey());
							ordercharge.setSihdrId(sihdr.getSihdrId());
							ordercharge.setTaxcode("");
							// update charge 
							ordercharge.setInvoicestatus("CREATED");
							ordercharge.setSihdrId(sihdr.getSihdrId());
							_orderchargeBD.createOrUpdate(ordercharge, user);
							
							
							// init sales invoice detail fields
							sidtl.setInvoicegroupref(saveForm.getSearchString7());
							sidtl.setInvoiceref("");
							sidtl.setCcykey(ordercharge.getCcykey());
							sidtl.setChgamt(ordercharge.getChgamt());
							sidtl.setOrderno(ordercharge.getOrderno());
							sidtl.setChargekey(ordercharge.getChargekey());
							sidtl.setChargetype(ordercharge.getChargetype());						
							sidtl.setRate(ordercharge.getRate());
							sidtl.setTxt1(ordercharge.getTxt1());
							sidtl.setTxt2(ordercharge.getTxt2());
							sidtl.setUname(ordercharge.getUname());
							sidtl.setUnits(ordercharge.getUnits());
							sidtl.setXratebase(ordercharge.getXratebase());
							sidtl.setXrateinv(ordercharge.getXrateinv());
							sidtl.setInvoiceccykey(ordercharge.getInvoiceccykey());
							sidtl.setInvoiceamt(ordercharge.getChgamt());
							sidtl.setOrderhdrId(ordercharge.getOrderhdrId());
							sidtl.setOrderchargeId(ordercharge.getOrderchargeId());
							
							
							//------------------------------------------------------------------->
							sidtl.setTaxcode(ordercharge.getTaxcode());
							// get tax rate
							Taxcode taxcode = null;
							try {
								taxcode = taxcodebd.findTaxcodeByTaxcodekey(sidtl.getTaxcode());
							} catch (ApplicationException ae) {}
							sidtl.setTaxamt(new BigDecimal(0.0));
							if (taxcode !=null) {
								try {
									sidtl.setTaxamt(
											sidtl.getInvoiceamt()
											.multiply(taxcode.getRate())
											.divide(new BigDecimal(100))
									);
								} catch (Exception e) {
								}
							}
							taxamt = taxamt+sidtl.getTaxamt().doubleValue();
							//----------------------------------------------------------------->
							
							
							invoiceamt = invoiceamt+sidtl.getInvoiceamt().doubleValue();
							
							// update details
							_sidtlBD.createOrUpdate(sidtl, user);
							
							
							// update job movement demurrage details
							Jobmov jobmov = null;
							try {jobmov = _jobmovBD.read(dto.getJobmovId1());}catch (ApplicationException ae) {}
							try {
								jobmov.setLastdmrgdays(new Integer(dto.getDemurragePrintTotalDays().intValue()));
								jobmov.setLastdmrgfrdate(dto.getDemStartDate());
								jobmov.setLastdmrgtodate(dto.getDemEndDate());
							} catch (Exception e) {
							}
							_jobmovBD.createOrUpdate(jobmov, user);	
							
							
						} // selected check	
					} // lineitem iterator	
					
					if (sihdr != null) {			
						sihdr.setInvoiceamt(new BigDecimal(invoiceamt));
						sihdr.setTaxamt(new BigDecimal(taxamt));
						// update header
						_sihdrBD.createOrUpdate(sihdr, user);
						
						// Add information message 
						appInformationMessages.add(
								"messages.salesinvoicebuild",
								new ActionMessage(
										"information.salesinvoicebuild.groupcreate",
										saveForm.getSearchString7()
								)
						);
					}				
				} // group invoice check
				
				
				// for Single Invoices
				if (saveForm.getSearchString7().equals("")) {
					int row = 0;
					for (Iterator it = saveForm.getLineItems().iterator(); it.hasNext();) {
						// get row
						JobmovDemurrageDTO dto = (JobmovDemurrageDTO)it.next();
						

						// do not process ZERO invoice amounts
						if (dto.getDemAmountTotal().compareTo(zeroBD) <= 0) continue;
						
						
						// selected
						if (tm.get(dto.getJobmovId1()) != null) {
							row++;
							// create dto for invoice header
							Sihdr sihdr = new Sihdr();
							// create dto for invoice detail
							Sidtl sidtl = new Sidtl();
							
							
							// required data
							Orderhdr orderhdr = null;
							try {orderhdr = _orderhdrBD.read(new Integer(dto.getOrderhdrId()));}catch (ApplicationException ae) {}
							
							String txt = 
								"DEMURRAGE CHARGE FOR UNIT: " +
								dto.getUnit()+
								" FROM "+
								Util.dateTextFormat2(dto.getDemStartDate())+
								" TO "+
								Util.dateTextFormat2(dto.getDemEndDate());
							
							// init header fields
							sihdr.setInvoicegroupref("");
							sihdr.setInvoiceref(orderhdr.getOrderno());
							sihdr.setInvoiceno("");
							sihdr.setCompanykey(user.getCompanykey());
							sihdr.setDepartmentkey(user.getDepartmentkey());
							sihdr.setActivitykey(user.getActivitykey());
							sihdr.setInvoiceccykey(dto.getCcykey());
							sihdr.setCustomeraddrkey(dto.getDmrgbilltoaddrkey());
							sihdr.setTxt1(txt);
							sihdr.setTxt2("");
							
							sihdr.setCustomerref("");
							if (orderhdr != null) {
								sihdr.setCustomerref(orderhdr.getCustomerref());
							}
							sihdr.setOrderno(dto.getOrderno());
							sihdr.setPaymentterm(dto.getDmrgbilltoaddr().getPaytermstext());
							
							sihdr.setInvoiceamt(dto.getDemAmountTotal());
							
							// update header
							_sihdrBD.createOrUpdate(sihdr, user);
							
							
							
							Ordercharge ordercharge = new Ordercharge();						
							// init sales invoice detail fields
							ordercharge.setInvoicegroupref(saveForm.getSearchString7());
							ordercharge.setOrderhdrId(new Integer(dto.getOrderhdrId()));
							ordercharge.setJobmovId(dto.getJobmovId1());
							ordercharge.setDmrgflag(true);						
							ordercharge.setCcykey(dto.getCcykey());
							ordercharge.setChgamt(dto.getDemAmountTotal());
							ordercharge.setCustomeraddrkey(dto.getDmrgbilltoaddrkey());						
							ordercharge.setOrderno(dto.getOrderno());
							ordercharge.setChargekey(demurrageChargekey);
							ordercharge.setChargetype("LUMPSUM");
							ordercharge.setRate(dto.getDemAmountTotal());
							ordercharge.setTxt1(txt);
							ordercharge.setTxt2("");
							ordercharge.setUname("");
							ordercharge.setUnits(new BigDecimal(1.0));
							ordercharge.setXratebase(new BigDecimal(1.0));
							ordercharge.setXrateinv(new BigDecimal(1.0));
							ordercharge.setInvoiceccykey(dto.getCcykey());
							ordercharge.setSihdrId(sihdr.getSihdrId());
							ordercharge.setTaxcode("");
							// update charge 
							ordercharge.setInvoicestatus("CREATED");
							ordercharge.setSihdrId(sihdr.getSihdrId());
							_orderchargeBD.createOrUpdate(ordercharge, user);
							
							
							// init detail fields
							sidtl.setInvoicegroupref("");
							sidtl.setInvoiceref(orderhdr.getOrderno());
							sidtl.setCcykey(ordercharge.getCcykey());
							sidtl.setChgamt(ordercharge.getChgamt());
							sidtl.setOrderno(ordercharge.getOrderno());
							sidtl.setChargekey(ordercharge.getChargekey());
							sidtl.setChargetype(ordercharge.getChargetype());						
							sidtl.setRate(ordercharge.getRate());
							sidtl.setTxt1(ordercharge.getTxt1());
							sidtl.setTxt2(ordercharge.getTxt2());
							sidtl.setUname(ordercharge.getUname());
							sidtl.setUnits(ordercharge.getUnits());
							sidtl.setXratebase(ordercharge.getXratebase());
							sidtl.setXrateinv(ordercharge.getXrateinv());
							sidtl.setInvoiceccykey(ordercharge.getInvoiceccykey());
							sidtl.setInvoiceamt(ordercharge.getChgamt());
							sidtl.setOrderhdrId(ordercharge.getOrderhdrId());
							sidtl.setOrderchargeId(ordercharge.getOrderchargeId());
							
							
							//------------------------------------------------------------------->
							sidtl.setTaxcode(ordercharge.getTaxcode());
							// get tax rate
							Taxcode taxcode = null;
							try {
								taxcode = taxcodebd.findTaxcodeByTaxcodekey(sidtl.getTaxcode());
							} catch (ApplicationException ae) {}
							sidtl.setTaxamt(new BigDecimal(0.0));
							if (taxcode !=null) {
								try {
									sidtl.setTaxamt(
											sidtl.getInvoiceamt()
											.multiply(taxcode.getRate())
											.divide(new BigDecimal(100))
									);
								} catch (Exception e) {	
								}
							}
							taxamt = taxamt+sidtl.getTaxamt().doubleValue();
							//----------------------------------------------------------------->
							sihdr.setTaxamt(new BigDecimal(taxamt));
							
							
							// update header
							_sihdrBD.createOrUpdate(sihdr, user);
							
							// update details
							sidtl.setSihdrId(sihdr.getSihdrId());
							_sidtlBD.createOrUpdate(sidtl, user);
							
							
							// TODO: update job movement demurrage details
							Jobmov jobmov = null;
							try {jobmov = _jobmovBD.read(dto.getJobmovId1());}catch (ApplicationException ae) {}
							try {
								jobmov.setLastdmrgdays(new Integer(dto.getDemurragePrintTotalDays().intValue()));
								jobmov.setLastdmrgfrdate(dto.getDemStartDate());
								jobmov.setLastdmrgtodate(dto.getDemEndDate());
								jobmov.setDmrgfinishflag(dto.getDmrgfinishflag());
							} catch (Exception e) {
							}
							_jobmovBD.createOrUpdate(jobmov, user);						
							
							
						} // selected check
					} // lineitem iterator
					
					if (row > 0) {
						// Add invformation message 
						appInformationMessages.add(
								"messages.salesinvoicebuild",
								new ActionMessage(
										"information.salesinvoicebuild.create",
										new Integer(row).toString()
								)
						);
					}
					
				} // single invoice check
				
				
				// clear buisness delegates
				_orderchargeBD = null;
				_orderhdrBD = null;
				_sihdrBD = null;
				_sidtlBD = null;
				_jobmovBD = null;			
				taxcodebd = null;
				
				
			} // no errors check
			
		} // PROCESS button pressed
		
		
		// reset select objects
		saveForm.setSelectedObjects(null);
		saveForm.setSearchString15(null);	
		saveForm.setSearchString7(""); // reset Group ref
	
		
		
		// Report any errors back to the original form		
		if (!appErrorMessages.isEmpty()) {
			saveAppErrorMessages(request, appErrorMessages);
		} else {
			// Report any information back to the original form
			if (!appInformationMessages.isEmpty()) {
				saveAppInformationMessages(request, appInformationMessages);
			}					
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
	
	
}
