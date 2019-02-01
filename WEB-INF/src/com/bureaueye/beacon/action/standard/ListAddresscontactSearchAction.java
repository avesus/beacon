package com.bureaueye.beacon.action.standard;



import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.PopupListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.bd.AddresscontactBD;




public final class ListAddresscontactSearchAction extends PopupListAction {

	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Name");
		}
		listForm.setOrderByDesc("");


		if (listForm.getSearchString1() == null) {
			listForm.setSearchString1("");
		}
		if (listForm.getSearchString2() == null) {
			listForm.setSearchString2("");
		}
		if (listForm.getSearchString3() == null) {
			listForm.setSearchString3("1");
		}

		/**
		AddresscontactPK pk = new AddresscontactPK(
				listForm.getHeaderInfo1(), 	// contactkey 
				listForm.getHeaderInfo2()	// addrkey
				);
		Addresscontact dto = new AddresscontactBD(this.getSessionFactoryClusterMap()).read(pk);
		listForm.setStartPage();
		if (dto == null) {

		} else {
			Address addressdto = new AddressBD(this.getSessionFactoryClusterMap()).read(pk.getAddrkey());
			String companyName = "";
			if (addressdto != null) companyName = addressdto.getName();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating listForm from " + dto.getClass().getName());
			listForm.setSearchString1(dto.getName());
			listForm.setSearchString2(companyName);
			listForm.setSearchString3(dto.getAddress1());
			listForm.setSearchString4(dto.getAddress2());
			listForm.setSearchString5(dto.getAddress3());
			listForm.setSearchString6("");
			listForm.setSearchString7(dto.getPostalCode());
			listForm.setSearchString8(dto.getCity());
			listForm.setSearchString9(dto.getState());
			listForm.setSearchString10(dto.getCountry());
			listForm.setSearchString11(dto.getPhone());
			listForm.setSearchString12(dto.getFax());
			listForm.setSearchString13(dto.getEmail());
			listForm.setSearchString14(null);
		}
		 **/

	}


	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		

	}


	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {


		/***THIS WORKS BUT NEED TO PURCHASE A LICENSE FOR com.moyosoft.connector.com.* SOFTWARE
		try
	      {
	         // Outlook application
	         Outlook outlookApplication = new Outlook();

	         // Get the default contacts folder
	         OutlookFolder folder = outlookApplication.getDefaultFolder(FolderType.CONTACTS);

	         // Get the folder's items collection
	         ItemsCollection items = folder.getItems();

	         // Display info for all contacts in the folder
	         for(ItemsIterator it = items.iterator(); it.hasNext();)
	         {
	           OutlookItem item = it.nextItem();

	           // Check the item is a contact
	           if(item != null && item.getType().isContact())
	           {
	              OutlookContact contact = (OutlookContact) item;

	              Addresscontact addresscontactdao = new Addresscontact();
	              addresscontactdao.setName(contact.getLastName()+", "+contact.getFirstName());
	              addresscontactdao.setEmail(contact.getEmail1Address());	              

	              addresscontactdaos.add(addresscontactdao);
	           }
	         }

	         // Dispose the library
	         outlookApplication.dispose();
	      }
	      catch(ComponentObjectModelException ex)
	      {
	         ex.printStackTrace();
	      }
	      catch(LibraryNotFoundException ex)
	      {
	         // If this error occurs, verify the file 'moyocore.dll' is present
	         // in java.library.path
	         ex.printStackTrace();
	      }
	      listForm.setLineItems(addresscontactdaos);


		 **/


		/*		try { 

		// To provide hostname and credentials information, use:
		Exchange exchange = new Exchange("ITT01", "Administrator", "track$boats");
		//Exchange exchange = ExchangeConnectionDialog.display();

		if(exchange != null)
		{

		// Get the default Contacts folder
		ExchangeFolder folder = exchange.getContactsFolder();

		// Display all the contacts in the folder:
		for(ExchangeItem item : folder.getItems())
		{
			if(item instanceof ExchangeContact)
			{
				ExchangeContact contact = (ExchangeContact) item;


			}
		}		

		}

		} catch (ExchangeServiceException ese) {
			} catch (Exception e) {
			}*/



		listForm.setLineItems(new AddresscontactBD(this.getSessionFactoryClusterMap())
			.findAddresscontactsSearch(
				listForm.getSearchString1(), 
				listForm.getSearchString2(),
				listForm.getSearchString3(), 
				listForm.getSearchString4(),
				listForm.getSearchString5(),
				listForm.getSearchString6(),
				listForm.getSearchString7(), 
				listForm.getSearchString8(),
				listForm.getSearchString9(), 
				listForm.getSearchString10(),
				listForm.getSearchString11(), 
				listForm.getSearchString12(),
				listForm.getSearchString13(), 
				listForm.getSearchString14(),
				listForm.getGotoPage(), 		
				listForm.getMaxResults(), 
				listForm.getOrderBy(), 
				listForm.getHeaderInfo1()));


/*		if (listForm.getSearchString3().equals("1")) {
			if (!listForm.getSearchString1().equals("")) {
				listForm.setLineItems(new AddressBD().findAddresssForContactSearch(listForm));
			}
		}*/


/*		if (listForm.getSearchString3().equals("2")) {
			listForm.setLineItems(new MisuserBD().findMisusersForContactSearch(listForm));
		}*/



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}
}