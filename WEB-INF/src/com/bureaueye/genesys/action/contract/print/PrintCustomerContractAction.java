package com.bureaueye.genesys.action.contract.print;


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
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.action.contract.pdf.ContractEndPage;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.bd.ContractBD;
import com.bureaueye.genesys.model.contract.bd.ContractagentBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqplocBD;
import com.bureaueye.genesys.model.contract.dto.ContractagentDTO;
import com.bureaueye.genesys.model.contract.dto.ContracteqplocDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public final class PrintCustomerContractAction extends BaseAction {


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


	public PrintCustomerContractAction() {
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
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" formsToSkip = " + formsToSkip);
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

			// step 3: set document                       
			_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f);
			_Document.open();				
			_PdfWriter.setPageEvent(new ContractEndPage());

			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(0);

			// read header
			Contract contract = null;
			try { contract = new ContractBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId())); } catch (ApplicationException ae) {}
			if (contract != null) outputContractToPDF(contract);   

			// new page at end of footer
			_Document.newPage();






			// read equipment
			// set line items
			List contracteqps = null;
			try {
				contracteqps = new ContracteqpBD(
						this.getSessionFactoryClusterMap()
				)
				.findContracteqpsById(
						contract.getContractId().toString(), 
						0, 
						99, 
						"Eqpkeyp1"
				);
			} catch (ApplicationException ae) {}					


			if (contracteqps != null && contracteqps.size() > 0) {  

				// process list collection			
				Iterator it = contracteqps.iterator();
				int row = 1;
				while (it.hasNext()) {
					// init 
					Contracteqp lineItem = (Contracteqp) it.next();

					// init select parameter					
					try {						
						// output to PDF
						outputContracteqpToPDF(lineItem, row);						
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;	


					// read equipment locations
					// set line items
					List contracteqplocs = null;
					try {
						contracteqplocs = new ContracteqplocBD(
								this.getSessionFactoryClusterMap()
						)
						.findContracteqplocsById(
								lineItem.getContracteqpId().toString(), 
								0, 
								99, 
								"Locationkey"
						);
					} catch (ApplicationException ae) {}	

					if (contracteqplocs != null && contracteqplocs.size() > 0) {
						outputContracteqplocHeaderToPDF();   

						// process list collection			
						Iterator it2 = contracteqplocs.iterator();
						int row2 = 0;
						while (it2.hasNext()) {
							// init 
							ContracteqplocDTO lineItem2 = (ContracteqplocDTO) it2.next();

							// init select parameter					
							try {						
								// output to PDF
								outputContracteqplocToPDF(lineItem2, row2);						
							}
							catch (NullPointerException npe) {
							}	    	    		
							// increment pointer
							row2++;	
						}

					}


				} // end list loop				
			}





			// read contract agents
			// set line items
			List contractagents = null;
			try {
				contractagents = new ContractagentBD(
						this.getSessionFactoryClusterMap()
				)
				.findContractagentsById(
						contract.getContractId().toString(), 
						0, 
						99, 
						"Agentaddrkey"
				);
			} catch (ApplicationException ae) {}					


			if (contractagents != null && contractagents.size() > 0) {
				outputContractagentHeaderToPDF();   

				// process charges list collection
				Iterator it = contractagents.iterator();
				int row = 0;
				while (it.hasNext()) {
					// init 
					ContractagentDTO lineItem = (ContractagentDTO) it.next();

					// init select parameter					
					try {							
						// output to PDF
						outputContractagentToPDF(lineItem, row);
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;					
				} // end list loop				
			}


			if (contract != null) outputContractCommentsToPDF(contract);			
			if (contract != null) outputContractNotesToPDF(contract);



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




	public void outputContracteqplocHeaderToPDF() 
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


			float[] widths1_2 = {0.05f, 0.95f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase(" ",fontBold));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(" ",font));

			/*			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);*/

			float[] widths1_3 = {0.4f, 0.2f, 0.2f, 0.2f}; 
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_3.addCell(new Phrase("Location",fontSmallBold));		
			_Table1_3.addCell(new Phrase("Onhire/Offhire",fontSmallBold));			
			_Table1_3.addCell(new Phrase("Min. Returns",fontSmallBold));		
			_Table1_3.addCell(new Phrase("Handling Charge",fontSmallBold));	


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1_2.addCell(_PdfPCell);


			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

		}
		catch (Exception e) {}			
	}			


	public void outputContracteqplocToPDF(ContracteqplocDTO contracteqploc, int row) 
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

			//_Table1.addCell(_BlankCell);



			float[] widths1_2 = {0.05f, 0.95f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase(" ",font));


			float[] widths1_3 = {0.4f, 0.2f, 0.2f, 0.2f}; 
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			_Table1_3.addCell(
					new Phrase(contracteqploc.getLocationkey().getLocationName(),font)
			);				
			_Table1_3.addCell(
					new Phrase(contracteqploc.getPudoflag(),font)
			);
			_Table1_3.addCell(
					new Phrase(contracteqploc.getMinreturns().toString(),font)
			);
			_Table1_3.addCell(
					new Phrase(contracteqploc.getHandchg().toString(),font)
			);


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);		
			_Table1_2.addCell(_PdfPCell);


			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER); 
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}			
	}		


	public void outputContractagentHeaderToPDF() 
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
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry2);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

			// insert blank row
			_Table1.addCell(_BlankCell);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("AGENTS",fontBold));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			float[] widths1_3 = {0.4f, 0.2f, 0.2f, 0.2f}; 
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_3.addCell(new Phrase("Agent",fontSmallBold));		
			_Table1_3.addCell(new Phrase("Scheme",fontSmallBold));			
			_Table1_3.addCell(new Phrase("Percentage",fontSmallBold));		
			_Table1_3.addCell(new Phrase("Lump Sum",fontSmallBold));	

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			/*			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	*/

		}
		catch (Exception e) {}			
	}			


	public void outputContractagentToPDF(ContractagentDTO contractagent, int row) 
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

			float[] widths1_3 = {0.4f, 0.2f, 0.2f, 0.2f}; 
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			_Table1_3.addCell(
					new Phrase(contractagent.getAgentaddrkey().getName(),font)
			);				
			_Table1_3.addCell(
					new Phrase(contractagent.getScheme(),font)
			);
			_Table1_3.addCell(
					new Phrase(contractagent.getPercentamt().toString(),font)
			);
			_Table1_3.addCell(
					new Phrase(contractagent.getLumpsumamt().toString(),font)
			);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);				 	   	
			_Table1.addCell(_PdfPCell);

		}
		catch (Exception e) {}			
	}		


	public void outputContractToPDF(Contract contract) 
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


			// get Lessee
			Address lessee = null;
			String lesseeName = "";
			try {
				lessee = new  AddressBD(this.getSessionFactoryClusterMap()).read(contract.getLesseeaddrkey());
				lesseeName = lessee.getName();
			} catch (Exception e) {}

			// title label
			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);    				    			
			_Table1_2.addCell(new Phrase("Contract for "+lesseeName,fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));			
			_Table1_2.addCell(new Phrase("Date: "+Util.dateTextFormat2(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_3 = {0.2f, 0.4f, 0.4f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			// insert blank row
			_BlankCell.setColspan(4);
			_Table1_3.addCell(_BlankCell);

			_Table1_3.addCell(new Phrase("Contract No:",fontBold));
			_Table1_3.addCell(new Phrase(contract.getContractno(),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));							

			_Table1_3.addCell(new Phrase("Contract Date:",fontBold));
			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(contract.getContractdate()),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));

			_Table1_3.addCell(new Phrase("Contract Signed:",fontBold));
			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(contract.getSigneddate()),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));

			_Table1_3.addCell(new Phrase("Notice Days:",fontBold));
			_Table1_3.addCell(new Phrase(contract.getNoticedays().toString(),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));


			_Table1_3.addCell(new Phrase("",fontBold));
			_Table1_3.addCell(new Phrase("",font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));


			_Table1_3.addCell(new Phrase("Lease Period:",fontBold));
			_Table1_3.addCell(
					new Phrase("Start Date: "+Util.dateTextFormat2(contract.getPeriodstartdate()),font)
			);				
			_Table1_3.addCell(new Phrase(
					"End Date: "+Util.dateTextFormat2(contract.getPeriodenddate()),font)
			);
			_Table1_3.addCell(new Phrase("",fontBold));				
			_Table1_3.addCell(new Phrase("End Date: "+Util.dateTextFormat2(contract.getPeriodenddate()),font));
			_Table1_3.addCell(new Phrase("",fontBold));

			_Table1_3.addCell(new Phrase("Lease Type:",fontBold));
			_Table1_3.addCell(new Phrase(contract.getLeasetypekey(),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));


			_Table1_3.addCell(new Phrase("",fontBold));
			_Table1_3.addCell(new Phrase("",font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));


			_Table1_3.addCell(new Phrase("Billing Type:",fontBold));
			_Table1_3.addCell(new Phrase(contract.getBilltype(),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));

			_Table1_3.addCell(new Phrase("Billing Currency:",fontBold));
			_Table1_3.addCell(new Phrase(contract.getBillccykey(),font));				
			_Table1_3.addCell(new Phrase(" ",fontBold));



			// insert blank row
			_BlankCell.setColspan(3);
			_Table1_3.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}		
	}	


	public void outputContracteqpToPDF(Contracteqp contracteqp, int row) 
	throws DocumentException, BadElementException
	{



		try {  				

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// insert blank row
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

			PdfPCell _PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry2);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

			// insert blank row
			_Table1.addCell(_BlankCell);


			float[] widths1_3 = {0.3f, 0.7f};
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 


			_Table1_3.addCell(
					new Phrase("EQUIPMENT TYPE "+row+":",fontBold)
			);			
			_Table1_3.addCell(
					new Phrase(contracteqp.getEqpkeyp1()+" / "+contracteqp.getEqpkeyp2(),
							font)
			);	

			_Table1_3.addCell(
					new Phrase("Free Days: ",fontSmallBold)
			);			
			_Table1_3.addCell(
					new Phrase(contracteqp.getFreedays().toString(),font)
			);

			_Table1_3.addCell(
					new Phrase("Minimum Days: ",fontSmallBold)
			);			
			_Table1_3.addCell(
					new Phrase(contracteqp.getMindays().toString(),font)
			);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			//_PdfPCell.setBackgroundColor(lghtgry);
			//if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);				 	   	
			_Table1.addCell(_PdfPCell);


			float[] widths1_4 = {0.3f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
			PdfPTable _Table1_4 = new PdfPTable(widths1_4);
			_Table1_4.getDefaultCell().setBorder(CELL_BORDER); 


			_Table1_4.addCell(
					new Phrase("Rate(s): ",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("Fixed: ",fontSmallBold)
			);				
			_Table1_4.addCell(
					new Phrase(contracteqp.getFixdlyrat().toString(),font)
			);			
			_Table1_4.addCell(new Phrase("",font));
			_Table1_4.addCell(new Phrase("",font));			
			_Table1_4.addCell(new Phrase("",font));
			_Table1_4.addCell(new Phrase("",font));
			_Table1_4.addCell(new Phrase("",font));


			_Table1_4.addCell(
					new Phrase("",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("Variable: ",fontSmallBold)
			);				
			_Table1_4.addCell(
					new Phrase("From Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getFromday1().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("To Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getToday1().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("Rate:",fontSmallBold)
			);	

			_Table1_4.addCell(
					new Phrase(contracteqp.getRate1().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("",font)
			);				
			_Table1_4.addCell(
					new Phrase("From Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getFromday2().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("To Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getToday2().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("Rate:",fontSmallBold)
			);		

			_Table1_4.addCell(
					new Phrase(contracteqp.getRate2().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("",font)
			);				
			_Table1_4.addCell(
					new Phrase("From Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getFromday3().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("To Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getToday3().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("Rate:",fontSmallBold)
			);		

			_Table1_4.addCell(
					new Phrase(contracteqp.getRate3().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("",font)
			);				
			_Table1_4.addCell(
					new Phrase("From Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getFromday4().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("To Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getToday4().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("Rate:",fontSmallBold)
			);		

			_Table1_4.addCell(
					new Phrase(contracteqp.getRate4().toString(),font)
			);			
			_Table1_4.addCell(
					new Phrase("",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase("",font)
			);				
			_Table1_4.addCell(
					new Phrase("From Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getFromday5().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("To Day:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getToday5().toString(),font)
			);
			_Table1_4.addCell(
					new Phrase("Rate:",fontSmallBold)
			);			
			_Table1_4.addCell(
					new Phrase(contracteqp.getRate5().toString(),font)
			);



			_PdfPCell = new PdfPCell(_Table1_4);
			_PdfPCell.setBorder(CELL_BORDER); 
			//_PdfPCell.setBackgroundColor(lghtgry);
			//if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);				 	   	
			_Table1.addCell(_PdfPCell);




		}
		catch (Exception e) {}			
	}		


	public void outputContractCommentsToPDF(Contract contract) 
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
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry2);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

			// insert blank row
			_Table1.addCell(_BlankCell);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("SPECIAL INSTRUCTIONS",fontBold));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(contract.getComments(),font));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}			
	}			


	public void outputContractNotesToPDF(Contract contract) 
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
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry2);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	

			// insert blank row
			_Table1.addCell(_BlankCell);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("NOTES",fontBold));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase(contract.getNotes(),font));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			// insert blank row
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry2);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	


		}
		catch (Exception e) {}			
	}			








}