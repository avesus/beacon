package com.bureaueye.beacon.action.standard;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.DashboardPool;
import com.bureaueye.beacon.form.standard.VendortariffhdrForm;

import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;



/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-16		ITT-200906-0004		Vendor Tariff Lump Sum Sub-totals
 * 												
 *
 */
public final class SaveVendortariffhdrAction extends BaseAction {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		VendortariffhdrForm vendortariffhdrform = (VendortariffhdrForm) form;
		String action = vendortariffhdrform.getAction();
		//String action2 = vendortariffhdrform.getAction2();//ITT-200906-0004
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		
		// If the session has timed-out then take the user back to the login
		// page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}
		
		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Processing " + action	+ " action");
		

		VendortariffhdrBD vendortariffhdrBD=new VendortariffhdrBD(this.getSessionFactoryClusterMap());	
		
/*		//sITT-200906-0004
		// process vendor tariff lump sum details
		boolean action2Success=false;
		VendortarifflumpsumBD vendortarifflumpsumBD=new VendortarifflumpsumBD(this.getSessionFactoryClusterMap());
	
		if (action2!=null && action2.equals("Add")) {
			// If the vendtarfdtlid is not specified then set it to null
			// (transient state)
			if (!vendortariffhdrform.getVendtarfhdrId2().equals("")) {
				// check tariff entered is valid
				Vendortariffhdr hdr2=vendortariffhdrBD.read(vendortariffhdrform.getVendtarfhdrId2());
				if (hdr2 != null) {
					Vendortarifflumpsum vendortarifflumpsum = new Vendortarifflumpsum();
					vendortarifflumpsum.setVendtarfhdrId(vendortariffhdrform.getVendtarfhdrId());
					vendortarifflumpsum.setVendtarfhdrId2(vendortariffhdrform.getVendtarfhdrId2());
					// persist data object
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Add Lumpsum: "+ vendortarifflumpsum.getVendtarfhdrId2());				
					vendortarifflumpsumBD.createOrUpdate(vendortarifflumpsum, user);
					//messages = new ActionMessages();
					messages.add("messages.vendortarifflumpsum",
							new ActionMessage(
							"information.add"));
				}
			}
			action2Success=true;
		}
		if (action2!=null && action2.equals("Remove")) {
			int[] selectedObjects = vendortariffhdrform.getSelectedObjects();
			if (selectedObjects != null) {			
				for (int i = 0; i < selectedObjects.length; i++) {
					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Remove Lumpsum: "+ selectedObjects[i]);
					vendortarifflumpsumBD.delete(new Vendortarifflumpsum(new Integer(selectedObjects[i])), user);
				}				
				//messages = new ActionMessages();
				messages.add("messages.vendortarifflumpsum",
						new ActionMessage(
						"information.remove"));
			}
			action2Success=true;
		}
		
		
		// check process has occurred
		if (action2Success) {
			// initialise lump sum breakdown details	
			List lumpsums = vendortarifflumpsumBD.findVendortarifflumpsumsById(vendortariffhdrform.getVendtarfhdrId(),"VendtarfhdrId2");	
			Vendortariffhdr hdr = vendortariffhdrBD.read(vendortariffhdrform.getVendtarfhdrId());
			if (hdr!=null) {
				BigDecimal lumpSum = null;
				try {
					lumpSum=vendortarifflumpsumBD.vendortarifflumpsumsLumpsumTotalById(vendortariffhdrform.getVendtarfhdrId());
					if (lumpSum==null) lumpSum = new BigDecimal(0.0);
				} catch (Exception e) {
				}
				try {
					hdr.setLumpsum(lumpSum);
					vendortariffhdrform.setLumpsum(hdr.getLumpsum().toString());
					vendortariffhdrBD.createOrUpdate(hdr, user);
				} catch (Exception e) {
				}
			}
			List<VendortarifflumpsumDTO> lumpsumDTOs = new ArrayList<VendortarifflumpsumDTO>();
			int row = 0;
			for (Iterator it = lumpsums.iterator(); it.hasNext();) {
				row++;
				VendortarifflumpsumDTO dto = new VendortarifflumpsumDTO();
				BeanUtils.copyProperties(dto, it.next());
				dto.setRow(new Integer(row).toString());				
				// retrieve vendor tariff link details
				Vendortariffhdr hdr2=new VendortariffhdrBD(this.getSessionFactoryClusterMap()).read(dto.getVendtarfhdrId2());
				dto.setCostkey(new CostBD(this.getSessionFactoryClusterMap()).read(hdr2.getCostkey()));
				dto.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr2.getVendoraddrkey()));
				dto.setLumpsum(new CurrencyFormatter().format(hdr2.getLumpsum()));
				lumpsumDTOs.add(dto);
			}			
			vendortariffhdrform.setList(lumpsumDTOs);
			// Reset the delete boxes
			vendortariffhdrform.setSelectedObjects(null);
			
			vendortarifflumpsumBD=null;
			vendortariffhdrBD=null;
			
			// Report any messages back to the original form
			if (!messages.isEmpty()) {
				this.saveMessages(request, messages);
			}
			// Report any errors back to the original form
			if (!errors.isEmpty()) {
				this.saveErrors(request, errors);
			}
			
			// back to the original form
			return (mapping.getInputForward());
		}
		vendortarifflumpsumBD=null;
		//eITT-200906-0004
*/		
		
		
		
		// find record
		Vendortariffhdr vendortariffhdr = vendortariffhdrBD.read(vendortariffhdrform.getVendtarfhdrId());
		// validation 
		if (vendortariffhdr != null && action.equals("Create")) {			
			errors.add("vendtarfhdrId", 
					new ActionMessage("error.record.unique"));			
		}
		
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}
		
		if (action.equals("Delete")) {
			
			//vendortariffhdrBD.delete(new Vendortariffhdr(vendortariffhdrform
			//		.getVendtarfhdrId()), user);			
			vendortariffhdrBD.deleteAll(vendortariffhdrform.getVendtarfhdrId(), user);	
			
		} else {
			
			if (vendortariffhdr == null) {
				vendortariffhdr = new Vendortariffhdr();
			}
			
			//convert to upper case
			vendortariffhdrform.setVendtarfhdrId(vendortariffhdrform.getVendtarfhdrId().toUpperCase());
			
			BeanUtils.copyProperties(vendortariffhdr, vendortariffhdrform);
			
			vendortariffhdrBD.createOrUpdate(vendortariffhdr, user);
			
			// Find the ListVendortariffhdrForm and reset to first page
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" createOrUpdate " + "List"
					+ mapping.getName());
		}
		
		vendortariffhdrBD=null;
		
		
		//UPDATE DASHBOARD POOL========================================================>		
		// check dashboard pool already exists
		DashboardPool pool = DashboardPool.getPool(session);
		if (pool!=null) {
		
			//VENDOR_TARIFFS_EXPIRING
			try {
				pool.setVENDOR_TARIFFS_EXPIRING();
			} catch (Exception e) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" "+
						"VENDOR_TARIFFS_EXPIRING - Exception: "+e.getMessage());					
			}				

			//store dashboard pool in user's session
			DashboardPool.setPool(session, pool);

		}//if (pool==null) {
		//UPDATE DASHBOARD POOL========================================================<
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
		
	}
	
}
