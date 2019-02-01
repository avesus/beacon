package com.bureaueye.genesys.action.finance;

import java.awt.Color;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
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
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.genesys.action.finance.pdf.FinancehdrEndPage;
import com.bureaueye.genesys.bean.finance.print.PrintFinancehdr;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;




public final class ListFinancehdrAction extends BaseAction {


	Font font;
	Font fontBold;	
	Font fontBoldHugeLightgray;


	public ListFinancehdrAction() {
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldHugeLightgray=new Font(font.getFamily(), font.getSize()+24, fontBold.getStyle());
			fontBoldHugeLightgray.setColor(new BaseColor(Color.LIGHT_GRAY));
		} catch (Exception e) {
		}
	}


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();


		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" actionFormName = " + actionFormName + "\t Mapping = "
					+ mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		ListForm listForm = (ListForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");




		// Initialise button if button pressed
		listForm.setButton("");
		if (request.getParameter("printButton.x") != null) listForm.setButton("PRINT");
		if (request.getParameter("testprintButton.x") != null) listForm.setButton("TESTPRINT");


		// print process if action selected
		if (
				listForm.getButton() != null &&
				(listForm.getSelectedObjects() != null) &&
				(listForm.getButton().equals("PRINT") || listForm.getButton().equals("TESTPRINT"))
		) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Action = " + listForm.getButton());

			User _user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);


			// step 1: init document				
			Document _document = new Document();	

			// step 2: we set the ContentType and create an instance of the corresponding Writer				
			response.setContentType("application/pdf");
			PdfWriter _PdfWriter = PdfWriter.getInstance(_document, response.getOutputStream());
			_PdfWriter.setPageEvent(new FinancehdrEndPage());


			try {

				// init pagesize default for user			
				_document.setPageSize(PageSize.A4);			
				_document.setPageCount(1);	
				if (_user != null && _user.getPagesize().equals("LEGAL")) _document.setPageSize(PageSize.LEGAL);
				if (_user != null && _user.getPagesize().equals("LETTER")) _document.setPageSize(PageSize.LETTER);			                      
				_document.setMargins(_document.leftMargin(), _document.rightMargin(), 50f, 50f);



				_document.open();


				// get selected rows
				int[] selectedObjects = listForm.getSelectedObjects();
				if (selectedObjects != null) {
					for (int i = 0; i < selectedObjects.length; i++) {				
						Integer _id = new Integer(selectedObjects[i]);			

						PrintFinancehdr printFinancehdr = new PrintFinancehdr();

						// not a test print assign Printed fields
						if (!listForm.getButton().equals("TESTPRINT")) {
							printFinancehdr.setPrinted(_id, _user);					
						}

						_document = printFinancehdr.executePrint(_id, listForm.getButton(), _user, _document);

						// test print Watermark
						if (listForm.getButton().equals("TESTPRINT")) {
							String waterMarkText=Constants.TEST_PRINT;
							//add watermark
							ColumnText.showTextAligned(
									_PdfWriter.getDirectContentUnder(),
									Element.ALIGN_CENTER, 
									new Phrase(waterMarkText, fontBoldHugeLightgray),
									297.5f, 
									421, 
									_PdfWriter.getPageNumber() % 2 == 1 ? 45 : -45
							);			
						}

					}					
				} 


				// close the document (the outputstream is also closed internally)
				_document.close(); 

			}
			catch (BadElementException bee) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" executePrint: BadElementException: "+bee.getMessage());			
			}		
			catch (DocumentException de) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" executePrint: DocumentException: "+de.getMessage());			
			}
			catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" executePrint: Exception: "+e.getMessage());			
			}
			finally {
				// reset select objects
				listForm.setSearchString15(null);
				listForm.setSelectedObjects(null);
			}			

			return null;
		}



		// Calculate the total number of results before any buttons are 
		// generated and default values
		setTotalResults(listForm);

		// Calculate the total number of results before any buttons are
		// generated and default values from SESSION 
		setTotalResults(listForm, session);


		// Initialise previous page results if action selected
		if (request.getParameter("previousButton.x") != null)
			listForm.setPreviousPage();
		else
			// initialise next page results if action selected
			if (request.getParameter("nextButton.x") != null)
				listForm.setNextPage();
			else
				// initialise start page results
				if (request.getParameter("startButton.x") != null)
					listForm.setStartPage();
				else
					// initialise end page results
					if (request.getParameter("endButton.x") != null)
						listForm.setEndPage();

		if (request.getParameter("searchButton.x") != null)
			// reset page/result values if new Search
			listForm.setStartPage();

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()
		+ " GotoPage = "+listForm.getGotoPage()
		+ ", maxResults = "+listForm.getMaxResults() 
		+ ", totalResults = "+listForm.getTotalResults()
		+ ", searchButton.x = "+request.getParameter("searchButton.x")
		+ ", previousButton.x = "+request.getParameter("previousButton.x")
		+ ", nextButton.x = "+request.getParameter("nextButton.x")
		+ ", endButton.x = "+request.getParameter("endButton.x")
		+ ", startButton.x = "+request.getParameter("startButton.x")
		);

		if ((listForm.getGotoPage() * listForm.getMaxResults() == listForm
				.getTotalResults())
				&& listForm.getGotoPage() > 0) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Taking one off");
			listForm.setPreviousPage();
		}

		// populate list items
		ActionMessages messages = 
			setLineItems(listForm);

		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}

		// initialise Pagination
		if (listForm.getGotoPage() == 0) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Setting firstpage to true");
			listForm.setFirstPage(true);
		}
		if (listForm.getGotoPage() == ((listForm.getTotalResults() - 1) / listForm
				.getMaxResults())) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Setting lastpage to true");
			listForm.setLastPage(true);
		}

		// reset select objects
		listForm.setSelectedObjects(null);
		listForm.setSearchString15(null);		

		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}




	public void setTotalResults(ListForm listForm) throws ApplicationException {
	}

	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {		

		// Set the default ordering
		if (listForm.getOrderBy() == null) {

			if (listForm.getOrderBy() == null) {
				listForm.setOrderBy("FINANCEHDR_ID");
			}
		}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Createdate")) listForm.setOrderByDesc("desc");

		
		//set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}
		
		
		// set default field values
		if (listForm.getSearchString1() == null) listForm.setSearchString1("");
		if (listForm.getSearchString2() == null) listForm.setSearchString2("");	


		// customer
		if (listForm.getSearchString3() == null || listForm.getSearchString3().equals("")) {
			listForm.setSearchString3("%");
		}

		// manual flag
		if (listForm.getSearchString7() == null || listForm.getSearchString7().equals("")) {
			listForm.setSearchString7("Y");
		}


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap())
			.read(new SystemcodePK("DATERANGEDAYS","LISTFINANCEHDR")).getDescr()).intValue();
		}catch(Exception e){}			
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}

		int total = 0;
/*		boolean processedflag = false;
		if (!listForm.getSearchString1().equals("")) {
			total = new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsTotalResultsByDockey(listForm);
			processedflag = true;
		}
		if (!listForm.getSearchString2().equals("")) {
			total = new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsTotalResultsByFinancehdrId(listForm);
			processedflag = true;
		}
		if (!processedflag) {
			total = new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsTotalResultsManual(listForm);
		}*/
		listForm.setTotalResults(total);

	}


	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {


		boolean processedflag = false;
		listForm.setLineItems(null);
		if (!listForm.getSearchString1().equals("")) {
			listForm.setLineItems(new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsForSearchByDockey(listForm));
			processedflag = true;
		}
		if (!listForm.getSearchString2().equals("")) {
			listForm.setLineItems(new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsForSearchByFinancehdrId(listForm));
			processedflag = true;
		}
		if (!processedflag) {
			listForm.setLineItems(new FinancehdrBD(this.getSessionFactoryClusterMap()).findFinancehdrsForSearchManual(listForm));
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

		return null;
	}

}
