package com.bureaueye.beacondms.action.dms;




import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;




import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.form.dms.GenerateXdocumentForm;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderfileBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;
import com.bureaueye.beacon.util.Util;





/**
 *
 * Amendments
 * ----------
 * 	
 */
public class GenerateXdocument1Action extends BaseAction {





	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		HttpSession session = request.getSession(false);
		GenerateXdocumentForm editForm = (GenerateXdocumentForm) form;
		String action = editForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();




		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" EditForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				" Form parameters: "+editForm.toString()
		);	







		// validation		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			saveAppInformationMessages(request, messages);
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			saveAppErrorMessages(request, errors);
			return findFailure(mapping);
		}	


		//init bd
		JobhdrBD jobhdrbd=new JobhdrBD(this.getSessionFactoryClusterMap());
		OrderhdrBD orderhdrbd=new OrderhdrBD(this.getSessionFactoryClusterMap());				
		JobmovBD jobmovbd=new JobmovBD(this.getSessionFactoryClusterMap());
		DocumenttypeBD documenttypebd=new DocumenttypeBD(this.getSessionFactoryClusterMap());
		SystemmappingcodeBD systemmappingcodebd=new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		CompanyBD companybd = new CompanyBD(this.getSessionFactoryClusterMap());
		CompanyheaderBD companyheaderbd = new CompanyheaderBD(this.getSessionFactoryClusterMap());
		OrderprodBD orderprodbd = new OrderprodBD(this.getSessionFactoryClusterMap());


		// set header information
		Jobhdr jobhdr = null;
		Orderhdr orderhdr = null;
		try {
			orderhdr = orderhdrbd.read(new Integer(editForm.getId()));
			editForm.setHeaderInfo(orderhdr.getOrderno(),1);			
			editForm.setHeaderInfo(
					Util.dateTextFormat2(orderhdr.getOrderdate()),2
			);
			editForm.setHeaderInfo(
					orderhdr.getCustomerref(),3
			);
			editForm.setHeaderInfo(
					new AddressBD(this.getSessionFactoryClusterMap()).read(orderhdr.getCustomeraddrkey()).getName(),4
			);
			editForm.setHeaderInfo(orderhdr.getOrderbyuserid(),5);
			editForm.setHeaderInfo("",6);
			try {
				editForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(orderhdr.getLdglocationkey2()).getLocationName(),6);
			} catch (Exception e) {}
			editForm.setHeaderInfo("",7);
			try {
				editForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(orderhdr.getDchlocationkey2()).getLocationName(),7);
			} catch (Exception e) {}		
			editForm.setHeaderInfo(orderhdr.getCcykey(),8);

			jobhdr = jobhdrbd.findFirstJobhdrByOrdhdrId(orderhdr.getId().toString());
			editForm.setHeaderInfo(jobhdr.getJobhdrId()+"",9);
			editForm.setHeaderInfo(jobhdr.getJobno(),10);
		} catch (Exception e) {
		}		

		try {
			Documenttype documenttype =documenttypebd.read(new Integer(editForm.getDocumenttypeId()));
			editForm.setHeaderInfo(documenttype.getDescription(),9);		
		} catch (Exception e) {
		}

		// retrieve section mapping for PKUP, LOAD, DSCH & DELV
		String pkupSection = "";
		String loadSection = "";
		String dschSection = "";
		String delvSection = "";
		String rtdpSection = "";
		String shipSection = "";
		try {

			try{pkupSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "PKUP").getCompanycode();}catch(Exception e){}
			try{loadSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD").getCompanycode();}catch(Exception e){}
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
					" rtdpSection="+rtdpSection+
					" shipSection="+shipSection		
			);
		} catch (Exception e) {
		}


		// set list information
		try {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" jobhdr.getJobhdrId(): " +jobhdr.getJobhdrId()	
			);

			// populate SHIP list items	
			List jobmovs = jobmovbd.findJobmovsByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(),shipSection);		
			List jobmovDTOs = new ArrayList();
			for (Iterator it = jobmovs.iterator(); it.hasNext();) {
				jobmovDTOs.add(it.next());
			}
			editForm.setList1(jobmovDTOs);
			// Reset the update boxes
			editForm.setSelectedObjects1(null);	

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" populate SHIP list: exception: "+e.getMessage());
		}


		try {			
			List jobmovDTOs = null;
			// populate ALL MOVEMENT list items	
			if (editForm.getJobmovId().equals("")) {
				// populate movement list items	
				List jobmovs = jobmovbd.findJobmovsById(jobhdr.getJobhdrId().toString(), 0, Constants.MAX_RESULTS_NOLIMIT, "Totimeinmillis","Fromtimeinmillis");		
				jobmovDTOs = new ArrayList();
				for (Iterator it2 = jobmovs.iterator(); it2.hasNext();) {
					jobmovDTOs.add(it2.next());
				}
			} else {
				//populate single movement
				Jobmov jobmov = jobmovbd.read(new Integer(editForm.getJobmovId()));	
				JobmovDTO jobmovdto=new JobmovDTO(jobmov, this.getSessionFactoryClusterMap()); 
				jobmovDTOs = new ArrayList();
				jobmovDTOs.add(jobmovdto);				
			}			
			editForm.setList2(jobmovDTOs);
			// Reset the update boxes
			editForm.setSelectedObjects2(null);

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" populate MOVEMENT list items: exception: "+e.getMessage());			
		}


		try {			
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" orderhdr.getId(): " +orderhdr.getId()	
			);

			// populate PRODUCT list items	
			List orderprods = orderprodbd.findOrderprodsById(orderhdr.getId().toString(),0,Constants.MAX_RESULTS_NOLIMIT,"Productkey");		
			List ordprodDTOs = new ArrayList();
			for (Iterator it3 = orderprods.iterator(); it3.hasNext();) {
				ordprodDTOs.add(it3.next());
			}
			editForm.setList3(ordprodDTOs);
			// Reset the update boxes
			editForm.setSelectedObjects3(null);

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" orderhdr.getId(): " +orderhdr.getId()	+
					" orderprods size: " +orderprods.size()
			);			

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" populate PRODUCT list items: exception: "+e.getMessage());				
		}



		//set default screen fields
		editForm.setMailfrom(user.getEmail());
		editForm.setMailto("");
		editForm.setMailcc("");
		editForm.setMailbcc("");
		editForm.setMailsubject(editForm.getHeaderInfo(9));
		editForm.setMailtext("");
		editForm.setMailhost(user.getMailhost());


		//set default header fields
		editForm.setHeaderfrom("");
		editForm.setHeaderto("");
		editForm.setHeadercc("");
		editForm.setHeaderccattn("");
		editForm.setHeadertoattn("");
		editForm.setHeadercontact(user.getName());	
		editForm.setHeaderphone(user.getPhone());	
		editForm.setHeaderfax(user.getFax());	

		Company companydao = null;
		Companyheader companyheaderdao = null;

		try{companyheaderdao=companyheaderbd.read(new Integer(editForm.getCompanyheaderId()));}catch(ApplicationException e){}		
		if (companyheaderdao!=null) {
			editForm.setHeaderfrom(companyheaderdao.getCompanyName());		
		}



		try {
			//init document records from order
			//init bds
			OrderfileBD orderfilebd = new OrderfileBD(this.getSessionFactoryClusterMap());

			//init collections
			List<SidtlDTO> sidtldtos = new LinkedList<SidtlDTO>();	
			List<Orderfile> orderfiledaos = new LinkedList<Orderfile>();
			Hashtable<String, Orderfile> orderfiledaosHt = new Hashtable<String, Orderfile>();


			//retrieve all documents for order
			orderfiledaos = orderfilebd.findOrderfilesById(
					orderhdr.getId().toString(), 
					0, 
					Constants.MAX_RESULTS_NOLIMIT, 
					"OrderhdrId",
					"Createdate"
			);

			if (orderfiledaos!=null) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" order files size :" + orderfiledaos.size());

				// process order documents 
				Iterator<Orderfile> it3 = orderfiledaos.iterator();
				while (it3.hasNext()) {
					Orderfile orderfiledao = (Orderfile) it3.next();
					//find header
					Orderhdr orderhdrdao = orderhdrbd.read(orderfiledao.getOrderhdrId());
					String key = orderhdrdao.getOrderno()+"|"+orderfiledao.getDescription();
					//check already exists
					if (orderfiledaosHt.get(key)==null) {

						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" put key :" + key);

						orderfiledaosHt.put(key,orderfiledao);

					}
				}

				// init details
				editForm.setLineItemsHt(orderfiledaosHt);
				// Reset the update boxes				
				editForm.setSelectedObjects4(null);

				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" orderhdr.getId(): " +orderhdr.getId()	+
						" orderfiles size: " +orderfiledaos.size()
				);
			}

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" populate ORDER FILES list items: exception: "+e.getMessage());				
		}






		//clear bd
		jobhdrbd=null;
		orderhdrbd=null;			
		jobmovbd=null;
		documenttypebd=null;
		systemmappingcodebd=null;
		companybd=null;
		companyheaderbd=null;
		orderprodbd=null;


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}



}
