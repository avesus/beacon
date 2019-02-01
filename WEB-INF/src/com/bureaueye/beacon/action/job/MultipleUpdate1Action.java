package com.bureaueye.beacon.action.job;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.job.MultipleUpdateForm;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.job.dto.JobhdrmovDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;





/**
 *
 * Amendments
 * ----------
 * 	
 */
public class MultipleUpdate1Action extends BaseAction {





	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		MultipleUpdateForm editForm = (MultipleUpdateForm) form;	
		String action = editForm.getAction();
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();




		// If action isn't supplied then invalidate the session
		if (action == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" EditForm not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		log.info(
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


		// set header information
		Jobhdr jobhdr = null;
		Jobmov jobmov = null;		
		Orderhdr orderhdr = null;
		try {

			jobmov = jobmovbd.read(new Integer(editForm.getJobmovId()));
			//init movement search details
			if (editForm.getSearchString1()==null) editForm.setSearchString1(jobmov.getSectionkey());			
			if (editForm.getSearchString2()==null) editForm.setSearchString2(jobmov.getVendoraddrkey());			
			if (editForm.getSearchString3()==null) editForm.setSearchString3(jobmov.getFromlocationkey());
			if (editForm.getSearchString4()==null) editForm.setSearchString4(jobmov.getTolocationkey());
			if (editForm.getSearchString5()==null) editForm.setSearchString5("");
			if (editForm.getSearchString6()==null) editForm.setSearchString6("");
			if (editForm.getSearchString7()==null) editForm.setSearchString7(jobmov.getVessel());
			if (editForm.getSearchString8()==null) editForm.setSearchString8(jobmov.getVoyage());

			jobhdr = jobhdrbd.read(jobmov.getJobhdrId());
			editForm.setHeaderInfo(jobhdr.getJobhdrId()+"",9);
			editForm.setHeaderInfo(jobhdr.getJobno(),10);

			orderhdr = orderhdrbd.read(new Integer(jobhdr.getOrderhdrId()));
			editForm.setHeaderInfo(orderhdr.getOrderno(),1);			
			editForm.setHeaderInfo(Util.dateTextFormat2(orderhdr.getOrderdate()),2);
			editForm.setHeaderInfo(jobmov.getSectionkey(),3);
			editForm.setHeaderInfo(
					new AddressBD(this.getSessionFactoryClusterMap()).read(jobmov.getVendoraddrkey()).getName(),4
			);
			editForm.setHeaderInfo(orderhdr.getConsignmentno(),5);
			editForm.setHeaderInfo("",6);
			try {
				editForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(jobmov.getFromlocationkey()).getLocationName(),6);
			} catch (Exception e) {}
			editForm.setHeaderInfo("",7);
			try {
				editForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(jobmov.getTolocationkey()).getLocationName(),7);
			} catch (Exception e) {}		
			editForm.setHeaderInfo(orderhdr.getCcykey(),8);

			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" jobhdr.getJobhdrId(): " +jobhdr.getJobhdrId()	
			);

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" set header information: exception: "+e.getMessage()
			);			
		}		




		// set list information for Order Jobs
		try {
			// set multiple movement update collections
			if (jobhdr != null) {				
				// for multiple Movement Update process
				List<JobhdrmovDTO> jobmovs = null;
				jobmovs = jobmovbd.findJobmovsForMmuByOrderjobs( 
						jobhdr.getJobhdrId().toString(),
						editForm.getJobmovId(),
						jobhdr.getOrderhdrId().toString(),						
						editForm.getSearchString1(),
						editForm.getSearchString2(),
						editForm.getSearchString3(),
						editForm.getSearchString4(),
						editForm.getSearchString5(),
						editForm.getSearchString6(),	
						editForm.getSearchString7(),
						editForm.getSearchString8()						
				);
				//convert list to arraylist??? - to capture the checkbox selection
				List<JobhdrmovDTO> jobmovDTOs = new ArrayList<JobhdrmovDTO>();
				//int row = 0;
				for (Iterator<JobhdrmovDTO> it = jobmovs.iterator(); it.hasNext();) {
					jobmovDTOs.add((JobhdrmovDTO)it.next());
				}

				editForm.setList1(jobmovDTOs);
				// Reset the update boxes
				editForm.setSelectedObjects1(null);	
			}
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Order jobs movement update collection: exception: "+e.getMessage()
			);
		}



		// set list information for Order Consignments
		try {
			if (orderhdr != null) {	
				List<Orderhdr> orderhdrs = null;			
				orderhdrs=orderhdrbd.findOrderconsignments(orderhdr.getConsignmentno());
				for (Iterator<Orderhdr> it = orderhdrs.iterator(); it.hasNext();) {
					Orderhdr orderhdr2=(Orderhdr)it.next();

					//process if order consignment NOT the same as Job movement order
					if (!orderhdr2.getOrderno().equals(orderhdr.getOrderno())) {
						log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Order Consignments: orderhdr.getOrderno(): " +orderhdr2.getOrderno()	
						);

						List<JobhdrDTO> jobhdrs = null;			
						jobhdrs=jobhdrbd.findJobhdrsById(orderhdr2.getId().toString(), 0, com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT, "Unitkey");
						for (Iterator<JobhdrDTO> it2 = jobhdrs.iterator(); it2.hasNext();) {
							JobhdrDTO jobhdr2=(JobhdrDTO)it2.next();	

							log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
									" Order Consignments: jobhdr.getJobno(): " +jobhdr2.getJobno()+
									" jobhdr.getJobhdrId: " +jobhdr2.getJobhdrId()+	
									" jobhdr.getOrderhdrId: " +jobhdr2.getOrderhdrId()									
							);

							// set multiple movement update collections
							if (jobhdr2 != null) {				
								// for multiple Movement Update process
								List<JobhdrmovDTO> jobmovs = null;
								jobmovs = jobmovbd.findJobmovsForMmuByOrderjobs( 
										jobhdr2.getJobhdrId().toString(),
										editForm.getJobmovId(),
										jobhdr2.getOrderhdrId().toString(),						
										editForm.getSearchString1(),
										editForm.getSearchString2(),
										editForm.getSearchString3(),
										editForm.getSearchString4(),
										editForm.getSearchString5(),
										editForm.getSearchString6(),	
										editForm.getSearchString7(),
										editForm.getSearchString8()						
								);
								//convert list to arraylist??? - to capture the checkbox selection
								List<JobhdrmovDTO> jobmovDTOs = new ArrayList<JobhdrmovDTO>();
								//int row = 0;
								for (Iterator<JobhdrmovDTO> it3 = jobmovs.iterator(); it3.hasNext();) {
									jobmovDTOs.add((JobhdrmovDTO)it3.next());
								}//it3

								editForm.setList2(jobmovDTOs);
								// Reset the update boxes
								editForm.setSelectedObjects2(null);	
							}//jobhdr2 != null
						}//it2
					}
				}
			}
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Order consignments movement update collection: exception: "+e.getMessage()
			);
		}



		//clear bd
		jobhdrbd=null;
		orderhdrbd=null;			
		jobmovbd=null;


		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}



}
