package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.AddresscontactBD;

public final class ListAddresscontactAction extends ListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Name");			
		}
		
		listForm.setTotalResults(new AddresscontactBD(this.getSessionFactoryClusterMap())
				.findAddresscontactsTotalResults((listForm.getId())));
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {

		Address address = new AddressBD(this.getSessionFactoryClusterMap()).read(listForm.getId());

		if (address == null) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.record.deleted", listForm.getId()));
			return errors;
		}
		listForm.setHeaderInfo1(address.getName());
		listForm.setHeaderInfo2(address.getTypekey());
		listForm.setHeaderInfo3(address.getAddr1());
		listForm.setHeaderInfo4(address.getAddr2());
		listForm.setHeaderInfo5(address.getAddr3());

		listForm.setLineItems(new AddresscontactBD(this.getSessionFactoryClusterMap())
							.findAddresscontactsByAddrkey(
									listForm.getId(), 
									listForm.getGotoPage(),
									listForm.getMaxResults(),
									listForm.getOrderBy()		
									)
							);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
				);
		
		return null;
	}
}
