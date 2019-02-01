package com.bureaueye.beacon.action.quotation.print;


import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.print.PrintdtlForm;
import com.bureaueye.beacon.form.print.PrinthdrForm;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quonotecust;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuonotecustBD;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.util.Util;





/**
 * Amendments
 * ----------
 *
 * NT	2009-10-26		ITT-200910-0002		Quotation Letter
 *
 * NT	2010-01-15		201000002			Problem printing € character in pdf format. Output Currency names instead.
 *
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 * NT	2011-04-27		201100010			Add Quotation Customer Notes 
 *												
 */
public class EditQuotationletterAction extends BaseAction {
	
	
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
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating EditForm from companyheaderdto " + companyheaderdto);		
			editForm.setCompanyheader(companyheaderdto);
		}
		
		
		Printhdr dao = null;
		PrinthdrBD printhdrbd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuochargeBD quochargebd = new QuochargeBD(this.getSessionFactoryClusterMap());
		QuonotecustBD quonotecustbd = new QuonotecustBD(this.getSessionFactoryClusterMap());//201100010
		//CcyBD ccybd = new CcyBD(this.getSessionFactoryClusterMap());		
		java.util.Set<PrintdtlForm> printdtlForms = new java.util.HashSet<PrintdtlForm>();
		
		
		// initialise print header and details
		dao = printhdrbd.findPrinthdrByPrintId(editForm.getPrintId());
		
		if (editForm.getRefreshdata().equals("N")) {			
			if (dao != null) {		
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating EditForm from dao " + dao);		
				BeanUtils.copyProperties(editForm, dao);				
			}
		}
		
		
		// delete header and details if refresh data
		if (editForm.getRefreshdata().equals("Y")) {
			if (dao != null) {
				printhdrbd.deleteAll(dao.getPrinthdrId(),user);
			}			
		} 
		
		
		
		// initialise from order header
		if (dao == null || editForm.getRefreshdata().equals("Y")) {					
			
			Quohdr quohdrdao = null;
			quohdrdao = quohdrbd.read(new Integer(editForm.getOrderhdrId()));
			editForm.setReportType("QL");				
			editForm.setPrintId(editForm.getPrintId());				
			editForm.setQuohdrId(quohdrdao.getId().toString());	
			editForm.setReportDate(new java.util.Date());	
			
			editForm.setFinalDelivery("");
			try{editForm.setFinalDelivery(locationbd.read(quohdrdao.getDchlocationkey1()).getLocationName());}catch(Exception e){}
			editForm.setPickupPlant("");
			try{editForm.setPickupPlant(locationbd.read(quohdrdao.getLdglocationkey1()).getLocationName());}catch(Exception e){}
			editForm.setPol("");
			try{editForm.setPol(locationbd.read(quohdrdao.getLdglocationkey2()).getLocationName());}catch(Exception e){}
			editForm.setPod("");
			try{editForm.setPod(locationbd.read(quohdrdao.getDchlocationkey2()).getLocationName());}catch(Exception e){}		
			
			editForm.setMemo1("");
			try{editForm.setMemo1(productbd.read(quohdrdao.getProductkey()).getTradname());}catch(Exception e){}	
			
			editForm.setMemo2("Standard 24,000 Liter Tank Container (unless otherwise specified)");	//
			editForm.setMemo3(quohdrdao.getDmrgfreedays().toString());//demurrage free days	
			editForm.setMemo4(quohdrdao.getQuotno()+" "+quohdrdao.getShipmethod());//ref
			editForm.setMemo5(quohdrdao.getDmrgdlyrate3().toString());//demurrage rate	
			
			
			editForm.setMemo7("");	//Comments
			//s201100010
			String quonotecust="";
			//refresh notes from the quotation customer notes
			List quonotecusts = null;
			try {
				quonotecusts = quonotecustbd.findQuonotecustsById(
						quohdrdao.getId().toString(), 
						0, 
						99, 
						"Createdate",
						"Createtime"
				);
			} catch (ApplicationException ae) {
			}								
			if (quonotecusts != null) {
				// process list collection
				Iterator it = quonotecusts.iterator();
				while (it.hasNext()) {
					// init 
					Quonotecust lineItem = (Quonotecust) it.next();					
					// init select parameter					
					try {quonotecust=quonotecust+lineItem.getNote1()+"\n";}	catch (NullPointerException npe) {}				
				} // end list loop				
			}
			editForm.setMemo7(quonotecust);
			//e201100010
			
			
			
			
			editForm.setMemo8("");	//TO
			
			editForm.setMemo6(Util.dateTextFormat2(quohdrdao.getEffectivedate()));//valid from date
			editForm.setMemo9(Util.dateTextFormat2(quohdrdao.getExpirydate()));//expiry date
			
			editForm.setMemo10("");	//pages
			editForm.setMemo11(quohdrdao.getQuotno());//quote
			editForm.setFromcontact(user.getEmail());							
			
			editForm.setShipper("");			
			editForm.setConsignee("");
			editForm.setCustomer("");
			try{editForm.setShipper(addressbd.read(quohdrdao.getShipperaddrkey()).getName());}catch(Exception e){}
			try{editForm.setConsignee(addressbd.read(quohdrdao.getConsigneeaddrkey()).getName());}catch(Exception e){}
			try{editForm.setCustomer(addressbd.read(quohdrdao.getCustomeraddrkey()).getName());} catch(Exception e){}
			
			
			
			editForm.setCustomerRef(quohdrdao.getCustomerref());
			editForm.setShipMethod(quohdrdao.getShipmethod());
			
			
			editForm.setRate("0.00");
			editForm.setRateccy("");
			try {
				BigDecimal _rate=quochargebd.quochargesChgamtbaseTotal(quohdrdao.getId().toString());
				DecimalFormat decimalFormat = new DecimalFormat("#0.00");				
				editForm.setRate(decimalFormat.format(_rate));
			} catch(Exception e) {}
			try {
				editForm.setRateccy(
						//ccybd.read(quohdrdao.getCcykey()).getPrtchr()//201000002
						quohdrdao.getCcykey()//201000002
						);
			} catch(Exception e) {}
			editForm.setDmrgccykey(quohdrdao.getDmrgccykey());//ITT-201001-0001
			
		}
		// init details
		editForm.setPrintdtls(printdtlForms);
		
		
		// clear bd from memory
		printhdrbd = null;
		addressbd = null;
		locationbd = null;
		productbd = null;
		quohdrbd = null;
		quochargebd = null;
		//ccybd = null;

		
		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");
		return findSuccess(mapping);
	}
	
	
	
}
