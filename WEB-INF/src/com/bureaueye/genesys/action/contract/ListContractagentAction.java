package com.bureaueye.genesys.action.contract;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.bd.ContractBD;
import com.bureaueye.genesys.model.contract.bd.ContractagentBD;



public final class ListContractagentAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		// Set the default ordering
			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("Agentaddrkey");
			}

		int total = new ContractagentBD(this.getSessionFactoryClusterMap()).findContractagentsTotalResults((listForm.getId()));
		listForm.setTotalResults(total);

	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {

		// set header information
		Contract hdr = new ContractBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(hdr.getContractno());
		listForm.setHeaderInfo2(
				Util.dateTextFormat2(hdr.getCreatedate())
				);
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(hdr.getContractdate())
				);
		listForm.setHeaderInfo4(hdr.getBillccykey());
		
		listForm.setHeaderInfo5("");
		try {
			listForm.setHeaderInfo5(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getLesseeaddrkey()).getName());
		} catch (Exception e) {}

		listForm.setHeaderInfo6(hdr.getLeasetypekey());		
		
		// set line items
		listForm.setLineItems(new ContractagentBD(this.getSessionFactoryClusterMap())
				.findContractagentsById(
						listForm.getId(), 
						listForm.getGotoPage(), 
						listForm.getMaxResults(), 
						listForm.getOrderBy())
						);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);	
		
		return null;
	}
}
