package com.bureaueye.beacon.action.quotation.print;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.action.quotation.pdf.QuosummaryEndPage;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.quotation.ListQuosummaryForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryChargeDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryCostDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-03-23		ITT-200904-0001		Add Effective Date, Pickup Location, Ship Method and Delivery Location
 * 											
 *
 */
public final class PrintQuosummaryAction extends BaseAction {

	private static Document _Document;
	private static PdfPTable _Table1;

	private static int CELL_BORDER = 0;

	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading;

	private static BaseColor headingColor = new BaseColor(180, 43, 22);
	private static BaseColor lghtgry = new BaseColor(247, 247, 249);
	private static BaseColor lghtgry2 = new BaseColor(238, 238, 238);
	private static BaseColor black= new BaseColor(0, 0, 0);


	public PrintQuosummaryAction() {
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontHeading = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			fontHeading.setColor(headingColor);
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
		User user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" PrintQuosummaryAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" PrintQuosummaryAction: formsToSkip = " + formsToSkip);
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

		ListQuosummaryForm listForm = (ListQuosummaryForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");


		// populate header info
		setHeaderInfo(listForm);

		// populate list items	
		setChargeLineItems(listForm);

		// populate list items	
		setCostLineItems(listForm);


		// Set a transactional control token to prevent double posting
		// log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Setting transactional control token");
		// saveToken(request);

		try {

			// convert report to PDF format
			// step 1: init document				
			_Document = new Document();	
			// init pagesize default for user			
			_Document.setPageSize(PageSize.A4);			
			_Document.setPageCount(1);			
			if (user != null && user.getPagesize().equals("LEGAL")) _Document.setPageSize(PageSize.LEGAL);
			if (user != null && user.getPagesize().equals("LETTER")) _Document.setPageSize(PageSize.LETTER);

			// step 2: we set the ContentType and create an instance of the corresponding Writer				
			response.setContentType("application/pdf");
			PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());

			//			// use a file to output if action is SEND email
			//			if (print.equals("Send")) {
			//				// step 2: we set the ContentType and create an instance of the corresponding Writer
			//				_FileOutputStream = new FileOutputStream("doToEmail.pdf");
			//				_PdfWriter = PdfWriter.getInstance(_Document, _FileOutputStream);  
			//			}   

			// step 3: set document                       
			_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f);
			_Document.open();				
			_PdfWriter.setPageEvent(new QuosummaryEndPage());

			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(0);

			outputHeaderToPDF(listForm);   

			outputChargeHeaderToPDF(); 

			double chargeTotal = 0.0;
			// process charges list collection
			if (listForm.getLineItems(0) != null) {
				Iterator it = listForm.getLineItems(0).iterator();
				int row = 0;
				while (it.hasNext()) {
					// init 
					QuosummaryChargeDTO lineItem = (QuosummaryChargeDTO) it.next();

					// init select parameter					
					try {							
						// output to PDF
						outputChargeToPDF(lineItem, row);
						chargeTotal = chargeTotal + lineItem.getChgamtbase().doubleValue();					
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;					
				} // end list loop
			}	// end 

			outputTotalToPDF(chargeTotal);

			outputQuohdrCostHeaderToPDF(); 

			double costTotal = 0.0;
			// process charges list collection
			if (listForm.getLineItems(1) != null) {
				Iterator it = listForm.getLineItems(1).iterator();
				int row = 0;
				while (it.hasNext()) {
					// init 
					QuosummaryCostDTO lineItem = (QuosummaryCostDTO) it.next();

					// init select parameter					
					try {							
						// output to PDF
						outputCostToPDF(lineItem, row);
						costTotal = costTotal + lineItem.getCstamtbase().doubleValue();					
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;					
				} // end list loop
			}	// end 

			outputTotalToPDF(costTotal);

			outputQuomovCostHeaderToPDF(); 

			double costTotal2 = 0.0;
			// process charges list collection
			if (listForm.getLineItems(2) != null) {
				Iterator it = listForm.getLineItems(2).iterator();
				int row = 0;
				while (it.hasNext()) {
					// init 
					QuosummaryCostDTO lineItem = (QuosummaryCostDTO) it.next();

					// init select parameter					
					try {							
						// output to PDF
						outputCostToPDF(lineItem, row);
						costTotal2 = costTotal2 + lineItem.getCstamtbase().doubleValue();					
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;					
				} // end list loop
			}	// end

			outputTotalToPDF(costTotal2);




			outputProfitToPDF(chargeTotal, costTotal, costTotal2);



			// add main table to PDF document
			_Document.add(_Table1);  

			// step 4: we close the document (the outputstream is also closed internally)
			_Document.close();                                

			return null; 

		}
		catch (BadElementException bee) {
		}		
		catch (DocumentException de) {
		}
		catch (Exception e) {
		}
		finally {
		}	

		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());

		return findSuccess(mapping);
	}



	public void outputHeaderToPDF(ListQuosummaryForm listForm) 
	throws DocumentException, BadElementException
	{

		try {  	


			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// title label
			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);    				    			
			_Table1_2.addCell(new Phrase("Quotation Profit/Analysis",fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));			
			_Table1_2.addCell(new Phrase("Date: "+Util.dateTextFormat2(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_7 = {0.2f, 0.8f}; 
			PdfPTable _Table1_7 = new PdfPTable(widths1_7);
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);  	   	  		
			// insert blank row
			//_BlankCell.setColspan(2);
			//_Table1_7.addCell(_BlankCell);
			_Table1_7.addCell(new Phrase("Quote No:",fontBold));
			_Table1_7.addCell(new Phrase(listForm.getHeaderInfo(1),font));
			_PdfPCell = new PdfPCell(_Table1_7);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_3 = {0.2f, 0.8f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			// insert blank row
			//_BlankCell.setColspan(4);
			//_Table1_3.addCell(_BlankCell);

			_Table1_3.addCell(new Phrase("Quote Date:",fontBold));
			_Table1_3.addCell(new Phrase(listForm.getHeaderInfo(2),font));
			_Table1_3.addCell(new Phrase("Effective Date:",fontBold));
			_Table1_3.addCell(new Phrase(listForm.getHeaderInfo(9),font));
			_Table1_3.addCell(new Phrase("Expiry Date:",fontBold));
			_Table1_3.addCell(new Phrase(listForm.getHeaderInfo(3),font));
			_Table1_3.addCell(new Phrase("Customer:",fontBold));			
			_Table1_3.addCell(new Phrase(listForm.getHeaderInfo(4),font));
			_Table1_3.addCell(new Phrase("Created by:",fontBold));		
			_Table1_3.addCell(new Phrase(listForm.getHeaderInfo(5),font));

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			float[] widths1_4 = {0.2f, 0.8f}; 

			PdfPTable _Table1_4 = new PdfPTable(widths1_4);
			_Table1_4.getDefaultCell().setBorder(CELL_BORDER);   

			_Table1_4.addCell(new Phrase("Ship Method:",fontBold));		
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(12),font));
			_Table1_4.addCell(new Phrase("Pickup Location:",fontBold));	
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(10),font));
			_Table1_4.addCell(new Phrase("Loading Port:",fontBold));				
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(6),font));	
			_Table1_4.addCell(new Phrase("Discharge Port:",fontBold));	
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(7),font));
			_Table1_4.addCell(new Phrase("Delivery Location:",fontBold));				
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(11),font));
			_Table1_4.addCell(new Phrase("Quote Currency:",fontBold));
			_Table1_4.addCell(new Phrase(listForm.getHeaderInfo(8),font));	



			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(_Table1_4);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// insert blank rows
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);
			//_Table1.addCell(_BlankCell);			


		}
		catch (Exception e) {}

	}


	public void outputChargeHeaderToPDF() 
	throws DocumentException, BadElementException
	{

		try {  	




			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.addCell(new Phrase("Quotation Charges",fontBold));				
			_Table1_2.addCell(new Phrase("",fontBold));
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);			

			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_3.addCell(new Phrase("Billing Account",fontBold));				
			_Table1_3.addCell(new Phrase("Charge",fontBold));			
			_Table1_3.addCell(new Phrase("Ccy",fontBold));
			_Table1_3.addCell(new Phrase("Tariff",fontBold));
			PdfPCell pdfpcell = new PdfPCell(new Phrase("Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Rate",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);									

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);			

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

		}
		catch (Exception e) {}

	}


	public void outputChargeToPDF(
			QuosummaryChargeDTO lineItem,
			int row
	) throws DocumentException, BadElementException
	{

		try {  	


			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  				

			try {
				_Table1_3.addCell(new Phrase(lineItem.getCustomeraddrkey().getName(),font));
			} catch (Exception e) {_Table1_3.addCell(new Phrase("",font));}	

			_Table1_3.addCell(new Phrase(lineItem.getChargekey().getLdesc(),font));			
			_Table1_3.addCell(new Phrase(lineItem.getCcykey(),font));
			try {
				_Table1_3.addCell(new Phrase(lineItem.getCusttarfhdrId().toString(),font));
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getChgamt()),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}		
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(lineItem.getXratebase().toString(),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}		
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getChgamtbase()),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}			


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);			

			_Table1.addCell(_PdfPCell);		


		}
		catch (Exception e) {
		}

	}


	public void outputQuohdrCostHeaderToPDF() 
	throws DocumentException, BadElementException
	{

		try {  	




			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("Quotation Costs",fontBold));				
			_Table1_2.addCell(new Phrase("",fontBold));
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_3.addCell(new Phrase("Vendor",fontBold));				
			_Table1_3.addCell(new Phrase("Cost",fontBold));			
			_Table1_3.addCell(new Phrase("Ccy",fontBold));
			_Table1_3.addCell(new Phrase("Tariff",fontBold));
			PdfPCell pdfpcell = new PdfPCell(new Phrase("Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Rate",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);									

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);			

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

		}
		catch (Exception e) {}

	}


	public void outputQuomovCostHeaderToPDF() 
	throws DocumentException, BadElementException
	{

		try {  	




			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("Movement Costs",fontBold));				
			_Table1_2.addCell(new Phrase("",fontBold));
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_3.addCell(new Phrase("Vendor",fontBold));				
			_Table1_3.addCell(new Phrase("Cost",fontBold));			
			_Table1_3.addCell(new Phrase("Ccy",fontBold));
			_Table1_3.addCell(new Phrase("Tariff",fontBold));
			PdfPCell pdfpcell = new PdfPCell(new Phrase("Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Rate",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);
			pdfpcell = new PdfPCell(new Phrase("Base Amount",fontBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);									

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);			

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

		}
		catch (Exception e) {}

	}


	public void outputCostToPDF(
			QuosummaryCostDTO lineItem,
			int row) 
	throws DocumentException, BadElementException
	{

		try {  	


			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  				

			_Table1_3.addCell(new Phrase(lineItem.getVendoraddrkey().getName(),font));				
			_Table1_3.addCell(new Phrase(lineItem.getCostkey().getDescr(),font));			
			_Table1_3.addCell(new Phrase(lineItem.getCcykey(),font));
			try {
				_Table1_3.addCell(new Phrase(lineItem.getVendtarfhdrId().toString(),font));
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getCstamt()),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}		
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(lineItem.getXratebase().toString(),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}		
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getCstamtbase()),font));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}			

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);		
			_Table1.addCell(_PdfPCell);		


		}
		catch (Exception e) {
		}

	}


	public void outputTotalToPDF(double value) 
	throws DocumentException, BadElementException
	{
		try {  	




			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_3 = {0.25f, 0.25f, 0.07f, 0.1f, 0.1f, 0.1f, 0.13f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  				

			_Table1_3.addCell(new Phrase("Total:",fontBold));				
			_Table1_3.addCell(new Phrase("",font));			
			_Table1_3.addCell(new Phrase("",font));
			try {
				_Table1_3.addCell(new Phrase("",font));
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}
			try {
				_Table1_3.addCell(new Phrase("",font));
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}		
			try {
				_Table1_3.addCell(new Phrase("",font));
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(new BigDecimal(value)),fontBold));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("",font));				
			}			

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_Table1.addCell(_PdfPCell);					
		}
		catch (Exception e) {
		}		
	}


	public void outputProfitToPDF(double chargeTotal, double costTotal, double costTotal2) 
	throws DocumentException, BadElementException
	{
		try {  	


			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			//			insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_3 = {0.25f, 0.60f, 0.15f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  				

			_Table1_3.addCell(new Phrase("Profit:",fontBold));						
			try {
				PdfPCell pdfpcell = new PdfPCell(
						new Phrase(new CurrencyFormatter().format(new BigDecimal((chargeTotal - costTotal - costTotal2) / chargeTotal * 100))+"%",fontBold));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("-",font));				
			}	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(new BigDecimal(chargeTotal - costTotal - costTotal2)),fontBold));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);				
				_Table1_3.addCell(pdfpcell);
			} catch (NullPointerException npe) {
				_Table1_3.addCell(new Phrase("-",font));				
			}			

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_Table1.addCell(_PdfPCell);					
		}
		catch (Exception e) {
		}		
	}


	public void setHeaderInfo(ListQuosummaryForm listForm) throws ApplicationException {

		// set header information
		Quohdr quohdr = new QuohdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));

		listForm.setHeaderInfo(quohdr.getQuotno(),1);
		try {		
			listForm.setHeaderInfo(
					Util.dateTextFormat2(quohdr.getQuotedate()),2
			);
		} catch (Exception e) {}
		try {			
			listForm.setHeaderInfo(
					Util.dateTextFormat2(quohdr.getExpirydate()),3
			);	
		} catch (Exception e) {}

		listForm.setHeaderInfo(
				quohdr.getCustomername(),4
		);

		try {		
			listForm.setHeaderInfo(
					Util.dateTextFormat2(quohdr.getEffectivedate()),9
			);
		} catch (Exception e) {}


		listForm.setHeaderInfo(quohdr.getQuotebyuserid(),5);
		listForm.setHeaderInfo("",6);
		try {
			listForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getLdglocationkey2()).getLocationName(),6);
		} catch (Exception e) {}
		listForm.setHeaderInfo("",7);
		try {
			listForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getDchlocationkey2()).getLocationName(),7);
		} catch (Exception e) {}	

		listForm.setHeaderInfo("",10);
		try {
			listForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getLdglocationkey1()).getLocationName(),10);
		} catch (Exception e) {}
		listForm.setHeaderInfo("",11);
		try {
			listForm.setHeaderInfo(new LocationBD(this.getSessionFactoryClusterMap()).read(quohdr.getDchlocationkey1()).getLocationName(),11);
		} catch (Exception e) {}


		listForm.setHeaderInfo(quohdr.getCcykey(),8);
		listForm.setHeaderInfo(quohdr.getShipmethod(),12);

	}


	public void setChargeLineItems(ListQuosummaryForm listForm) throws ApplicationException {

		listForm.setGotoPage(0);
		listForm.setMaxResults(99);
		listForm.setOrderBy("Chargekey");
		listForm.setOrderByDesc("");		

		// set line items
		listForm.setLineItems(
				new QuochargeBD(
						this.getSessionFactoryClusterMap()
				)
				.findQuochargesForSummary(listForm),0);

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

	}


	public void setCostLineItems(ListQuosummaryForm listForm) throws ApplicationException {

		listForm.setGotoPage(0);
		listForm.setMaxResults(99);


		// quohdr costs
		listForm.setOrderBy("quocost.Costkey");
		// set line items
		listForm.setLineItems(
				new QuocostBD(
						this.getSessionFactoryClusterMap()
				)
				.findQuohdrcostsForSummary(listForm),1);

		// quomov costs
		listForm.setOrderBy("quomov.Seqno, quocost.Costkey");
		// set line items
		listForm.setLineItems(
				new QuocostBD(
						this.getSessionFactoryClusterMap()
				)
				.findQuomovcostsForSummary(listForm),2);		
		/*		listForm.setOrderBy("Costkey");

		// set line items
		listForm.setLineItems(
				new QuocostBD(
						this.getSessionFactoryClusterMap()
				)
				.findQuocostsForSummary(listForm),1);*/

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);

	}

}
