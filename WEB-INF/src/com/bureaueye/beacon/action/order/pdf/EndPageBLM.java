package com.bureaueye.beacon.action.order.pdf;


import java.awt.Color;
import java.sql.SQLException;



import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;



import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;


public class EndPageBLM extends PdfPageEventHelper {
	
	
	Companyheader _Companyheader;	
	Printhdr _Printhdr;	

	
	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontSmallBoldWhite;	
	
	int DEFAULT_CELL_BORDER = 0;
	int CELL_BORDER = 0;
	BaseColor BORDER_COLOR = new BaseColor(Color.LIGHT_GRAY);	

	

	
	
	public EndPageBLM(
			Companyheader Companyheader,
			Printhdr Printhdr
			) {
		_Companyheader = Companyheader;
		_Printhdr = Printhdr;	
		
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					//Font.FontFamily.COURIER,
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontSmallBoldWhite = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontSmallBoldWhite.setColor(new BaseColor(Color.WHITE));
		} catch (Exception e) {
		}
	}
	
	
	/**
	 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	 */
	public void onEndPage(PdfWriter writer, Document document) {
		try {
			Rectangle page = document.getPageSize();
			PdfPTable head = doHeader();
			head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
			head.writeSelectedRows(
					0, 
					-1, 
					document.leftMargin(), 
					page.getRight() - document.topMargin() + head.getTotalHeight(),						
					writer.getDirectContent()
			);
			PdfPTable foot = doFooter();
			foot.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
			foot.writeSelectedRows(
					0, 							// rowstart
					-1, 						// rowend
					document.leftMargin(), 		// xPos
					document.bottomMargin(),	// yPos
					writer.getDirectContent()
			);
		}
		catch (Exception e) {
			throw new ExceptionConverter(e);
		}
	}
	
	public PdfPTable doHeader() throws DocumentException, BadElementException, SQLException, Exception
	{
		
		// dtos
		Address address = null;
		Location location = null;
		
		// business delegates

		
		// define working table
		PdfPTable _Table1 = new PdfPTable(1);
		// 
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);
		
		try { 				
			// working cell
			PdfPCell _PdfPCell;
		
			
			// define main table		
			PdfPTable _Table1_1 = new PdfPTable(1);
			_Table1_1.getDefaultCell().setBorder(CELL_BORDER);    		

			
			// define title table		
			float[] widths = {0.5f, 0.5f};
			PdfPTable _Table1_2 = new PdfPTable(widths);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			
			// title   		 	
			_PdfPCell = new PdfPCell(new Phrase(" ",fontBoldLarge));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT); 			
			_PdfPCell.setBorder(CELL_BORDER);			
			_Table1_2.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("BILL OF LADING FOR MOTOR CARRIAGE",fontBoldLarge));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT); 			
			_PdfPCell.setBorder(CELL_BORDER);		
			_Table1_2.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase(_Companyheader.getCompanyName(),fontBoldLarge));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT); 			
			_PdfPCell.setBorder(CELL_BORDER);		
			_Table1_2.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("Non-Negotiable",fontBoldLarge));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT); 			
			_PdfPCell.setBorder(CELL_BORDER);		
			_Table1_2.addCell(_PdfPCell);	
			
			// add title table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell);  			


			// define text table		
			_Table1_2 = new PdfPTable(1);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			
			// text   		 	
			_PdfPCell = new PdfPCell(new Phrase("RECEIVED, subject to the terms and conditions on the reverse hereof, the property describe below, in apparent good order except as noted (contents and conditions, contents of packages unknown), marked, consigned, and destined as shown below. This Bill of Lading is not subject to any tariffs or classifications whether individually determined or filed with any federal or state regulatory agency, except as specifically agreed to in writing by the shipper and the carrier. ",fontSmall));
			_PdfPCell.setBorder(CELL_BORDER);			
			_Table1_2.addCell(_PdfPCell);	
			
			// add text table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			
			// define DATE, OUR REF NO...... table		
			float[] widths2 = {0.3f, 0.2f, 0.2f, 0.3f};
			_Table1_2 = new PdfPTable(widths2);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.getDefaultCell().setPadding(0);
			
	   		PdfPTable _Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		PdfPCell _Text = new PdfPCell(new Phrase("IF CHARGES ARE TO BE PREAID, WRITE OR STAMP HERE, CHARGES PREPAID",fontSmall));
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper);   

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1); 
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		PdfPCell _Label =  new PdfPCell(new Phrase("DATE",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
//	   		_Text = new PdfPCell(new Phrase(Util.dateTextFormat2(_Printhdr.getReportDate()),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("OUR REF NO",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getJobNumber(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("CUSTOMERS ORDER NO",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getConsigneeRef(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper);
	   		
			// add DATE, OUR REF NO...... table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			
			
			

			// define COMPANY NAME...... table		
			float[] widths4 = {0.4f, 0.6f};
			_Table1_2 = new PdfPTable(widths4);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.getDefaultCell().setPadding(0);
			
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		
	   		PdfPTable _Table1_3 = new PdfPTable(1);
	   		_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 	   		
	   		if (_Companyheader != null) {
	   			_PdfPCell = new PdfPCell(new Phrase(_Companyheader.getCompanyName(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);      			
	   			_Table1_3.addCell(_PdfPCell);
	   			_PdfPCell = new PdfPCell(new Phrase(_Companyheader.getAddress(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);     			
	   			_Table1_3.addCell(_PdfPCell);   			
	   			_PdfPCell = new PdfPCell(new Phrase(_Companyheader.getCity()+" "+_Companyheader.getState()+" "+_Companyheader.getCountry(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);    			
	   			_Table1_3.addCell(_PdfPCell);
	   		}
	   		else {
	   			_Table1_3.addCell(new Phrase("",font));
	   			_Table1_3.addCell(new Phrase("",font));
	   			_Table1_3.addCell(new Phrase("",font));  			
	   		}
			_Text = new PdfPCell(_Table1_3);
//			_Text.setFixedHeight(50f);
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper);  



			PdfPTable _Table1_5 = new PdfPTable(1);		
			_Table1_5.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_5.getDefaultCell().setPadding(0);  
	   		//
			// define IMPORT CARRIER........ table		
			PdfPTable _Table1_7 = new PdfPTable(2);		
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_7.getDefaultCell().setPadding(0);  
			
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("IMPORTING CARRIER",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
			//try{address = addressbd.read(_Printhdr.getShipLine());}catch(Exception e){}   
			if (address == null) 
				_Text = new PdfPCell(new Phrase("",font)); 
			else 
				_Text = new PdfPCell(new Phrase(address.getName(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 			
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("LOCATION",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label);
			//try{location = locationbd.read(_Printhdr.getPODPier());}catch(Exception e){}  			
			if (location == null) 
				_Text = new PdfPCell(new Phrase("",font)); 
			else 
				_Text = new PdfPCell(new Phrase(location.getLocationName(),font)); 	  
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 			
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper);

			// add IMPORT CARRIER........ table	
	   		_Table1_5.addCell(_Table1_7);
	   		 		

	   		//
			// define VESSEL........ table		
			_Table1_7 = new PdfPTable(3);		
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_7.getDefaultCell().setPadding(0);  
			
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("VESSEL",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 		
	   		if (_Printhdr.getVessel() != null) 
	   			_Text = new PdfPCell(new Phrase(_Printhdr.getVessel(),font)); 
	   		else
	   			_Text = new PdfPCell(new Phrase("",font));	
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("VOY-FLT",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label);			 
	   		if (_Printhdr.getVoyage() != null) 
	   			_Text = new PdfPCell(new Phrase(_Printhdr.getVoyage(),font));
	   		else
	   			_Text = new PdfPCell(new Phrase("",font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper);

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("ARRIVAL DATE",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label);
//	   		if (_Printhdr.getPODdateEst() != null) 
//	   			_Text = new PdfPCell(new Phrase(Util.dateTextFormat2(_Printhdr.getPODdateEst()),font));
//	   		else
	   			_Text = new PdfPCell(new Phrase("",font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper);
	   		
			// add VESSEL........ table	
	   		_Table1_5.addCell(_Table1_7);
	   		

	   		//
			// define B/L NO........ table		
			_Table1_7 = new PdfPTable(2);		
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_7.getDefaultCell().setPadding(0);  
			
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("B/L NO",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 		
	   		if (_Printhdr.getMbl() != null) 
	   			_Text = new PdfPCell(new Phrase(_Printhdr.getMbl(),font)); 
	   		else
	   			_Text = new PdfPCell(new Phrase(" ",font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("PORT OF ORIGIN / AIRPORT",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label);			 
			//try{location = locationbd.read(_Printhdr.getPod());}catch(Exception e){}  				
			if (location == null) 
				_Text = new PdfPCell(new Phrase(" ",font)); 
			else 
				_Text = new PdfPCell(new Phrase(location.getLocationName(),font)); 
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 			
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_7.addCell(_Wrapper);
	   		
			// add B/L NO........ table	
	   		_Table1_5.addCell(_Table1_7);
	   		
	   		_Table1_2.addCell(_Table1_5);	   		

	   		
			// add COMPANY NAME...... table		
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 			
		

			
			
			// define FREE TIME EXP........ table		
			float[] widths5 = {0.1f, 0.4f, 0.3f, 0.2f};
			_Table1_2 = new PdfPTable(widths5);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.getDefaultCell().setPadding(0);  

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1); 
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		_Label =  new PdfPCell(new Phrase("FREE TIME EXP",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getMemo1(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 
	   		
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1); 
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		_Label =  new PdfPCell(new Phrase("ORIGIN CARRIER / LOCAL DELIVERY OR TRANSFER BY",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getTruckerImport(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("HOUSE-SUB HOUSE",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getMemo2(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 

	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);	   		
	   		_Label =  new PdfPCell(new Phrase("ENTRY NO",fontSmall));
	   		_Label.setFixedHeight(9f);
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Wrapper.addCell(_Label); 
	   		_Text = new PdfPCell(new Phrase(_Printhdr.getMemo3(),font));
	   		_Text.setHorizontalAlignment(Element.ALIGN_CENTER);	 	   		
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper);
	   		
			// add FREE TIME EXP........ table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			
			
			// define DELIVER CONSIGNED........ table		
			_Table1_2 = new PdfPTable(2);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.getDefaultCell().setPadding(0);  

	   		_Label =  new PdfPCell(new Phrase("DELIVER CONSIGNED TO:",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);	   		

	   		_Label =  new PdfPCell(new Phrase("ROUTE",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);
	   		
			// add DELIVER CONSIGNED........ table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			

			// define DELIVER TO...... table		
			_Table1_2 = new PdfPTable(2);		
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.getDefaultCell().setPadding(0);
			
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		
	   		_Table1_3 = new PdfPTable(1);
	   		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);
			//try{address = addressbd.read(_Printhdr.getConsignee());}catch(Exception e){}   
			if (address != null) {
	   			_PdfPCell = new PdfPCell(new Phrase(address.getName(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);      			
	   			_Table1_3.addCell(_PdfPCell);
	   			_PdfPCell = new PdfPCell(new Phrase(address.getAddr1(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);     			
	   			_Table1_3.addCell(_PdfPCell); 
	   			_PdfPCell = new PdfPCell(new Phrase(address.getAddr2(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);     			
	   			_Table1_3.addCell(_PdfPCell); 	
	   			_PdfPCell = new PdfPCell(new Phrase(address.getAddr3(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);     			
	   			_Table1_3.addCell(_PdfPCell); 	   			
	   			_PdfPCell = new PdfPCell(new Phrase(address.getCity()+" "+address.getState()+" "+address.getCountry(),font));
	   			_PdfPCell.setBorder(CELL_BORDER);    			
	   			_Table1_3.addCell(_PdfPCell);
			}
			else {
	   			_Table1_3.addCell(new Phrase("",font));
	   			_Table1_3.addCell(new Phrase("",font));
	   			_Table1_3.addCell(new Phrase("",font));  
	   			_Table1_3.addCell(new Phrase("",font));
	   			_Table1_3.addCell(new Phrase("",font)); 	   			
			}
			_Text = new PdfPCell(_Table1_3);
//			_Text.setFixedHeight(50f);
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper);  
	   		
	   		_Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);  
	   		_Wrapper.getDefaultCell().setBorderColor(BORDER_COLOR);
	   		if (_Printhdr.getImportDeliveryInstructions() != null)
	   			_Text = new PdfPCell(new Phrase(_Printhdr.getImportDeliveryInstructions(),font));
	   		else
	   			_Text = new PdfPCell(new Phrase("",font));
			_Text.setFixedHeight(70f);
	   		_Wrapper.addCell(_Text);   	   		
	   		_Table1_2.addCell(_Wrapper); 

			// add DELIVER TO........ table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			
			// define PKGS........ table
			float[] widths6 = {0.1f, 0.05f, 0.45f, 0.2f, 0.2f};   		
	   		_Table1_2 = new PdfPTable(widths6);   		
	   		_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 		
			_Table1_2.getDefaultCell().setPadding(0);  

	   		_Label =  new PdfPCell(new Phrase("PKGS",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);	   		
	   		_Label =  new PdfPCell(new Phrase("HM",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase("DESCRIPTION OF ARTICLES, SPECIAL MARKS & EXCEPTIONS",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase("WEIGHT",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase(" ",fontSmallBoldWhite));
	   		_Label.setBackgroundColor(new BaseColor(Color.BLACK));
	   		_Table1_2.addCell(_Label);
	   		
	   		_Label = new PdfPCell(new Phrase(_Printhdr.getNumberOfTanks().toString(),font));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);	   		
	   		_Label =  new PdfPCell(new Phrase(" ",font));
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase(_Printhdr.getMemo10(),font));
	   		_Label.setFixedHeight(30f);	   		
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase(_Printhdr.getMemo12()+" "+_Printhdr.getWeightType(),font));
	   		_Label.setHorizontalAlignment(Element.ALIGN_CENTER); 	   		
	   		_Table1_2.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase(" ",font));
	   		_Table1_2.addCell(_Label);
	   		
			// add PKGS........ table
			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 
			
			
			// add main table to working table
			_PdfPCell = new PdfPCell(_Table1_1);
			_PdfPCell.setBorder(1);
			_Table1.addCell(_PdfPCell);			
			
		}
		catch (Exception e) {}
		
		return _Table1;
	}
	
	
	public PdfPTable doFooter() throws DocumentException, BadElementException, SQLException, Exception
	{
	
		// define working table
		PdfPTable _Table1 = new PdfPTable(1); 
		// 
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);
		
		try { 			
			// working cell
			PdfPCell _PdfPCell;

			
			// define MEMO4........ table
			float[] widths6 = {0.1f, 0.05f, 0.45f, 0.2f, 0.2f};   		
	   		PdfPTable _Table1_7 = new PdfPTable(widths6);   		
	   		_Table1_7.getDefaultCell().setBorder(CELL_BORDER); 		
	   		_Table1_7.getDefaultCell().setPadding(0);  

	   		PdfPCell _Label =  new PdfPCell(new Phrase(" ",font));
	   		_Label.setBorder(CELL_BORDER);
	   		_Table1_7.addCell(_Label);
	   		_Label =  new PdfPCell(new Phrase(" ",font));
	   		_Label.setBorder(CELL_BORDER);
	   		_Table1_7.addCell(_Label);		   		
	   		_Label =  new PdfPCell(new Phrase(_Printhdr.getMemo4(),font));
	   		_Label.setBorder(CELL_BORDER);	   		
	   		_Table1_7.addCell(_Label);	 
 	   		_Label =  new PdfPCell(new Phrase(" ",font));
 	   		_Label.setBorder(CELL_BORDER); 	   		
	   		_Table1_7.addCell(_Label);	 
	   		_Label =  new PdfPCell(new Phrase(" ",font));
	   		_Label.setBorder(CELL_BORDER);	   		
	   		_Table1_7.addCell(_Label);	 
	   		
			// add MEMO4........ table
			_PdfPCell = new PdfPCell(_Table1_7);
			_PdfPCell.setFixedHeight(100f);			
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell); 			

		   	
		   	
			
			// define main table
			float[] widths = {0.35f, 0.4f, 0.25f};
			PdfPTable _Table1_1 = new PdfPTable(widths);
			_Table1_1.getDefaultCell().setBorder(CELL_BORDER);    		


			// define left table
			PdfPTable _Table1_2 = new PdfPTable(1);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);    		

			// fill left table
			// text phrase
			_Table1_2.addCell(new Phrase("This is to certify that the above-named materials are properly calssified, described, and marked and labeled and are in proper condition for transportation according to xxxxxxxx regulations of the Department of Transportation. ",fontSmall));			

			// blank
			_Table1_2.addCell(new Phrase("",fontSmall));
			
			// shipper signature
			_Table1_2.addCell(new Phrase("_______________________________________ Shipper",fontSmall));			

			// blank
			_Table1_2.addCell(new Phrase("",fontSmall));			

			// define left sub table
			float[] widths2 = {0.9f, 0.1f};			
			PdfPTable _Table1_3 = new PdfPTable(widths2);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 
			// fill left sub table		
			_Table1_3.addCell(new Phrase("XXXXX RESPONSE INFORMATION OFFERED",fontSmall));		 		
			_Table1_3.addCell(new Phrase(_Printhdr.getChk1(),fontSmall));		 		
			_Table1_3.addCell(new Phrase("XXXXX IS PROPERLY XXXXX",fontSmall));		 		
			_Table1_3.addCell(new Phrase(_Printhdr.getChk2(),fontSmall));	
			_Table1_3.addCell(new Phrase("XXXXX HAS DOT EMERGENCY RESPONSE GUIDE 8",fontSmall));		 		
			_Table1_3.addCell(new Phrase(_Printhdr.getChk3(),fontSmall));						
			// add left sub table
			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_2.addCell(_PdfPCell);  
			
			// blank
			_Table1_2.addCell(new Phrase("",fontSmall));
			
			// shipper signature			
			_Table1_2.addCell(new Phrase("XXXXX DRIVER ____________________________",fontSmall));			
			
			// add left table
			_PdfPCell = new PdfPCell(_Table1_2);
//			_PdfPCell.setFixedHeight(40f);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell);  

			
			// define centre table
			_Table1_2 = new PdfPTable(1);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);    		

			// 
			_Table1_2.addCell(new Phrase("INTERMODAL CERTIFICATION",font));  
			_Table1_2.addCell(new Phrase("It is declared by the undersigned that container/vehicle number:",fontSmall));  
			_Table1_2.addCell(new Phrase(_Printhdr.getMemo5(),font));  
			_Table1_2.addCell(new Phrase("Was loaded with a total gross cargo weight (payload weight) at: ",fontSmall)); 
			_Table1_2.addCell(new Phrase(_Printhdr.getMemo6(),font));  
			
			_Table1_2.addCell(new Phrase("for cargo, consisting of the following: ",fontSmall)); 
			_PdfPCell = new PdfPCell(new Phrase(_Printhdr.getMemo7(),font));
			_PdfPCell.setFixedHeight(30f);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_2.addCell(_PdfPCell);
			
			_Table1_2.addCell(new Phrase("Name and Company/Organization of Signatory / Date",fontSmall)); 
			_Table1_2.addCell(new Phrase(_Printhdr.getMemo8(),font));  
			_Table1_2.addCell(new Phrase("Signature on behalf of packer: ",fontSmall)); 
			_Table1_2.addCell(new Phrase(" ",font));
			
			// add centre table
			_PdfPCell = new PdfPCell(_Table1_2);
//			_PdfPCell.setFixedHeight(40f);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell); 

			
			// define right table
			_Table1_2 = new PdfPTable(1);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);    		

			// blank
			_Table1_2.addCell(new Phrase("",fontSmall)); 
			
			// define right sub table		
			_Table1_3 = new PdfPTable(1);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);
			
			// fill right sub table	
			
			_PdfPCell = new PdfPCell(new Phrase("FOR CHEMICAL",fontSmallBoldWhite));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); 			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));			
			_Table1_3.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("EMERGENCY",fontSmallBoldWhite));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); 			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));			
			_Table1_3.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("SPILL, LEAK, FIRE,",fontSmallBoldWhite));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); 			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));			
			_Table1_3.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("EXPOSURE, OR ACCIDENT CALL:",fontSmallBoldWhite));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); 			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));			
			_Table1_3.addCell(_PdfPCell);	
			_PdfPCell = new PdfPCell(new Phrase(_Printhdr.getMemo11(),fontSmallBoldWhite));
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); 			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));				
			_Table1_3.addCell(_PdfPCell);
			
			// blank
			_Table1_3.addCell(new Phrase("",fontSmall));
			
			_PdfPCell = new PdfPCell(new Phrase(_Printhdr.getMemo9(),fontSmall));
			_PdfPCell.setFixedHeight(30f);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_3.addCell(_PdfPCell);
			
			// add right sub table
			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_2.addCell(_PdfPCell);  
			
			// blank
			_Table1_2.addCell(new Phrase("",fontSmall));
			
			// add right table
			_PdfPCell = new PdfPCell(_Table1_2);
//			_PdfPCell.setFixedHeight(40f);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1_1.addCell(_PdfPCell);		


 

			// add main table to working table
	   		PdfPTable _Wrapper = new PdfPTable(1);
	   		_Wrapper.getDefaultCell().setBorder(1);		   	

		   	_Wrapper.addCell(new PdfPCell(_Table1_1));
		   	_Table1.addCell(_Wrapper); 			
					
		}
		catch (Exception e) {
		}
		
		return _Table1;
	}
	
	
	
}
