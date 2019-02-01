package com.bureaueye.beacon.bean.purchaseorder.print;

import java.awt.Color;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.purchaseorder.Podtl;
import com.bureaueye.beacon.model.purchaseorder.Pohdr;
import com.bureaueye.beacon.model.purchaseorder.bd.PohdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;
import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;




public final class PrintPurchaseorder extends BaseDTO {


	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);


	private static Document _Document;
	private static PdfPTable _Table1;
	private static int CELL_BORDER = 0;

	private static Company _company;
	private static Companyheader _companyheader;


	private static BaseColor lghtgry = new BaseColor(247, 247, 249);	
	private static BaseColor bureaueyeColor = new BaseColor(180, 43, 22);
	private static BaseColor grey = new BaseColor(192, 192, 192);
	private static BaseColor eggshell = new BaseColor(255, 255, 204);
	private static BaseColor black = new BaseColor(0, 0, 0);
	private static BaseColor headingColor = new BaseColor(180, 43, 22);


	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontBoldHugeLightgray;
	Font fontHeading;
	Font fontInvoice;


	public PrintPurchaseorder() {
		_Document = null;
		_company = null;
		_companyheader = null;

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
			fontBoldHugeLightgray=new Font(font.getFamily(), font.getSize()+14, fontBold.getStyle());
			fontBoldHugeLightgray.setColor(new BaseColor(Color.LIGHT_GRAY));
			fontHeading = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			fontHeading.setColor(headingColor);
			fontInvoice = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontInvoice.setColor(bureaueyeColor);	
		} catch (Exception e) {
		}
	}




	public Document executePrint(
			Integer _id, 
			String _printtype, 
			User _user,
			Document _document
	)
	throws Exception {

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  executePrint: id = "+_id);
		_Document = _document;

		try {

			// read header
			PohdrBD pohdrbd = new PohdrBD(this.getSessionFactoryClusterMap());
			Pohdr pohdrdto = null;
			pohdrdto = pohdrbd.read(_id); 





			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(2);

			_company = new CompanyBD(this.getSessionFactoryClusterMap()).read(pohdrdto.getCompanykey());
			_companyheader = new CompanyheaderBD(this.getSessionFactoryClusterMap()).read(_company.getCompanyheaderId());



			if (pohdrdto != null) outputHeaderToPDF(pohdrdto);   

			// new page at end of footer
			_Document.newPage();


			// read details		
			int row = 0;
			List podtldtos = new PohdrBD(this.getSessionFactoryClusterMap()).getPodtls(pohdrdto.getPohdrId());
			if (podtldtos.size() > 0) {			
				outputDetailHeaderToPDF();   

				// process details list collection
				Iterator it = podtldtos.iterator();
				while (it.hasNext()) {
					// init 
					Podtl lineItem = (Podtl) it.next();

					// init select parameter					
					try {							
						// output to PDF
						outputDetailToPDF(lineItem, row);
					}
					catch (NullPointerException npe) {
					}	    	    		
					// increment pointer
					row++;					
				} // end list loop				
			}
			if (row < 20) {
				while (row < 20) {
					// output blank to PDF
					outputDetailBlankToPDF(row);
					row++;
				}
			}

			if (pohdrdto != null) outputFooterToPDF(pohdrdto);


			// add main table to PDF document
			_Document.add(_Table1);  




		}
		catch (BadElementException bee) {
		}		
		catch (DocumentException de) {
		}
		catch (Exception e) {
		}
		finally {
		}	

		return _Document; 
	}





	public void outputDetailToPDF(Podtl dtl, int row) 
	throws DocumentException, BadElementException
	{

		try {  				

			// working cells
			PdfPCell tableCell = null;
			PdfPCell pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(2);
			pdfPCell.setPaddingLeft(2);



			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);


			float[] widths1_2 = {0.60f, 0.1f, 0.15f, 0.15f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(1);			

			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			


			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase(dtl.getTxt1(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			_Table1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getQty().toString(),fontSmall));	
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			_Table1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getRateamt().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			_Table1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getChgamt().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getXrateinv().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getCcykey(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);*/

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);	
			pdfPCell.setPhrase(new Phrase(dtl.getTotalamt().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);	
			_Table8_1.addCell(pdfPCell);			
			tableCell = new PdfPCell(_Table8_1);		 	   	
			tableCell.setBackgroundColor(eggshell);
			_Table1_2.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_2);
			tableCell.setBorder(1);	
			_Table1.addCell(tableCell);


		}
		catch (Exception e) {}			
	}			


	public void outputDetailBlankToPDF(int row) 
	throws DocumentException, BadElementException
	{

		try {  							

			// working cells
			PdfPCell tableCell = null;
			PdfPCell pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(0);
			pdfPCell.setPaddingLeft(0);



			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);


			//float[] widths1_2 = {0.35f, 0.08f, 0.1f, 0.15f, 0.1f, 0.07f, 0.15f};
			float[] widths1_2 = {0.60f, 0.1f, 0.15f, 0.15f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(1);			


			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			


			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			_Table1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));	
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			_Table1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			_Table1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);	*/

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table8_1.addCell(pdfPCell);				
			tableCell = new PdfPCell(_Table8_1);
			tableCell.setBackgroundColor(eggshell);
			_Table1_2.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_2);
			tableCell.setBorder(1);	
			_Table1.addCell(tableCell);


		}
		catch (Exception e) {}			
	}



	public void outputDetailHeaderToPDF() 
	throws DocumentException, BadElementException
	{

		try {  				

			// working cells
			PdfPCell tableCell = null;
			PdfPCell pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(0);
			pdfPCell.setPaddingLeft(0);


			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);


			//float[] widths1_2 = {0.35f, 0.08f, 0.1f, 0.15f, 0.1f, 0.07f, 0.15f};
			float[] widths1_2 = {0.60f, 0.1f, 0.15f, 0.15f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(1);			


			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			


			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase("DESCRIPTION",fontSmallBold));	
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			_Table1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("QTY",fontSmallBold));	
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			_Table1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("RATE",fontSmallBold));	
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			_Table1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("CHG AMOUNT",fontSmallBold));	
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("EX RATE",fontSmallBold));	
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			_Table1_2.addCell(tableCell);	

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("CCY",fontSmallBold));	
			_Table9_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);*/

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("TOTAL",fontSmallBold));	
			_Table8_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table8_1);		 	   	
			_Table1_2.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_2);
			tableCell.setBorder(1);	
			_Table1.addCell(tableCell);


		}
		catch (Exception e) {}			
	}			




	public void outputHeaderToPDF(Pohdr hdr) 
	throws DocumentException, BadElementException
	{

		try {  	

			// working cells
			PdfPCell tableCell = null;
			PdfPCell pdfPCell = new PdfPCell();
			float fixedHeightDefault = pdfPCell.getFixedHeight();
			pdfPCell.setPaddingRight(10);
			pdfPCell.setPaddingLeft(10);



			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" companyheader.getLogo(): "+_companyheader.getLogo());			
			Image jpeg;
			jpeg = Image.getInstance(_companyheader.getLogo());
			jpeg.scalePercent(70);

			// title label
			float[] widths1_2 = {0.5f, 0.5f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(0);
			PdfPCell pdfPCell2 = new PdfPCell(jpeg);
			pdfPCell2.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell2.setPaddingRight(10);
			pdfPCell2.setPaddingLeft(10);			
			pdfPCell2.setPaddingBottom(10);

			_Table1_2.addCell(pdfPCell2);

			PdfPCell pdfPCell3 = new PdfPCell();
			pdfPCell3.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell3.setPaddingRight(10);
			pdfPCell3.setPaddingLeft(10);			
			pdfPCell3.setPaddingBottom(10);			
			pdfPCell3.setPhrase(new Phrase("PURCHASE ORDER",fontHeading));
			pdfPCell3.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			_Table1_2.addCell(pdfPCell3);


			PdfPCell pdfPCell3a = new PdfPCell();
			pdfPCell3a.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell3a.setPaddingRight(10);
			pdfPCell3a.setPaddingLeft(10);			
			pdfPCell3a.setPaddingBottom(10);	
			pdfPCell3a.setPhrase(new Phrase("",fontBold));
			pdfPCell3a.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell3a.setVerticalAlignment(Element.ALIGN_MIDDLE);

			_Table1_2.addCell(pdfPCell3a);


			PdfPCell pdfPCell3b = new PdfPCell();
			pdfPCell3b.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell3b.setPaddingRight(10);
			pdfPCell3b.setPaddingLeft(10);			
			pdfPCell3b.setPaddingBottom(10);	
			pdfPCell3b.setPhrase(new Phrase("PO No:  "+hdr.getPono(),fontInvoice));
			pdfPCell3b.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell3b.setVerticalAlignment(Element.ALIGN_MIDDLE);

			_Table1_2.addCell(pdfPCell3b);	


			tableCell = new PdfPCell(_Table1_2);

			_Table1.addCell(tableCell);


			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);



			float[] widths1_3 = {0.15f, 0.35f, 0.15f, 0.35f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(1);  	   	  		


			PdfPTable _Table10_2 = new PdfPTable(1);
			_Table10_2.getDefaultCell().setBorder(1);

			pdfPCell.setPhrase(new Phrase("VENDOR",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(100);
			_Table10_2.addCell(pdfPCell);	

			tableCell = new PdfPCell(_Table10_2);		 	   	
			_Table1_3.addCell(tableCell);		


			PdfPTable _Table11_1 = new PdfPTable(1);
			_Table11_1.getDefaultCell().setBorder(1);  	

			// init vendor address
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// init billing address
			Address _address = _addressBD.read(hdr.getVendoraddrkey());
			String addr1 = _address.getAddr1();
			String addr2 = _address.getAddr2();
			String addr3 =_address.getAddr3();
			String addr4 = _address.getAddr4();			


			pdfPCell.setPhrase(new Phrase(_address.getName(),font));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table11_1.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(addr1,font));
			_Table11_1.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(addr2,font));
			_Table11_1.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(addr3,font));
			_Table11_1.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(addr4,font));
			_Table11_1.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table11_1);
			tableCell.setBackgroundColor(lghtgry);
			_Table1_3.addCell(tableCell);	

			pdfPCell.setBorder(1);


			//----------------------------------------------------------------------------
			PdfPTable _Table10_2b = new PdfPTable(1);
			_Table10_2b.getDefaultCell().setBorder(1);

			pdfPCell.setPhrase(new Phrase("SHIP TO",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(100);
			_Table10_2b.addCell(pdfPCell);	

			tableCell = new PdfPCell(_Table10_2b);		 	   	
			_Table1_3.addCell(tableCell);		


			PdfPTable _Table11_1b = new PdfPTable(1);
			_Table11_1b.getDefaultCell().setBorder(1);  	

			// init ship to address
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			Location _location = _locationBD.read(hdr.getShiptolocationkey());
			String shiptoaddr1 = _location.getAddress1();
			String shiptoaddr2 = _location.getAddress2();
			String shiptoaddr3 = _location.getAddress3();
			String shiptoaddr4 = _location.getCountry();

			pdfPCell.setPhrase(new Phrase(_location.getLocationName(),font));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table11_1b.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(shiptoaddr1,font));
			_Table11_1b.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(shiptoaddr2,font));
			_Table11_1b.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(shiptoaddr3,font));
			_Table11_1b.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(shiptoaddr4,font));
			_Table11_1b.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table11_1b);
			tableCell.setBackgroundColor(lghtgry);
			_Table1_3.addCell(tableCell);	
			//----------------------------------------------------------------------------


			pdfPCell.setBorder(1);

			/*			float[] widths12_1 = {0.573f, 0.427f}; 
			PdfPTable _Table12_1 = new PdfPTable(widths12_1);

			_Table12_1.getDefaultCell().setBorder(1);

			PdfPTable _Table12_2 = new PdfPTable(1);
			_Table12_2.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("PO No",fontBold));	
			pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);	
			pdfPCell.setFixedHeight(20);
			_Table12_2.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table12_2);		
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));			
			_Table12_1.addCell(tableCell);

			pdfPCell.setFixedHeight(fixedHeightDefault);

			PdfPTable _Table12_5 = new PdfPTable(1);
			_Table12_5.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(hdr.getPono(),invoiceFont));
			pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);	
			_Table12_5.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table12_5);				
			tableCell.setBackgroundColor(lghtgry);			
			_Table12_1.addCell(tableCell);	

			PdfPTable _Table12_3 = new PdfPTable(1);
			_Table12_3.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("DATE",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);			
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);				
			_Table12_3.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table12_3);	
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));			
			_Table12_1.addCell(tableCell);	

			PdfPTable _Table12_4 = new PdfPTable(1);
			_Table12_4.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(Util.dateTextFormat2(hdr.getCreatedate()),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				
			_Table12_4.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table12_4);				
			tableCell.setBackgroundColor(lghtgry);
			_Table12_1.addCell(tableCell);	


			tableCell = new PdfPCell(_Table12_1);
			_Table1_3.addCell(tableCell);*/





			tableCell = new PdfPCell(_Table1_3);

			_Table1.addCell(tableCell);


			pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(10);
			pdfPCell.setPaddingLeft(10);		


			float[] widths1_5a = {0.4f, 0.3f, 0.3f}; 
			PdfPTable _Table1_5a = new PdfPTable(widths1_5a);
			_Table1_5a.getDefaultCell().setBorder(1);  	   	  		


			PdfPTable _Table5_1a = new PdfPTable(1);
			_Table5_1a.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("SUBMITTED BY",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table5_1a.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setPhrase(new Phrase(" "+hdr.getCreateuserid(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);

			_Table5_1a.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_1a);
			_Table1_5a.addCell(tableCell);		

			PdfPTable _Table5_2a = new PdfPTable(1);
			_Table5_2a.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("DEPARTMENT",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);

			_Table5_2a.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase(" "+hdr.getDepartmentkey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			

			_Table5_2a.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_2a);		 	   	
			_Table1_5a.addCell(tableCell);	

			PdfPTable _Table5_3a = new PdfPTable(1);
			_Table5_3a.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("DATE",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);			

			_Table5_3a.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(" "+Util.dateTextFormat2(hdr.getCreatedate()),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				

			_Table5_3a.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_3a);		 	   	
			_Table1_5a.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_5a);		 	   	
			_Table1.addCell(tableCell);



			float[] widths1_5 = {0.3f, 0.5f, 0.2f}; 
			PdfPTable _Table1_5 = new PdfPTable(widths1_5);
			_Table1_5.getDefaultCell().setBorder(1);  	   	  		


			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("DELIVERY DATE",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table5_1.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setPhrase(new Phrase(" "+Util.dateTextFormat2(hdr.getDeliverydate()),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);

			_Table5_1.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_1);
			_Table1_5.addCell(tableCell);		

			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("PAYMENT TERMS",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);

			_Table5_2.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase(" "+hdr.getPaymentterm(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			

			_Table5_2.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_2);		 	   	
			_Table1_5.addCell(tableCell);	

			PdfPTable _Table5_3 = new PdfPTable(1);
			_Table5_3.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("SHIP VIA",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);			

			_Table5_3.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(" "+hdr.getShipvia(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				

			_Table5_3.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_3);		 	   	
			_Table1_5.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_5);		 	   	
			_Table1.addCell(tableCell);


		}
		catch (Exception e) {}		
	}	


	public void outputFooterToPDF(Pohdr hdr) 
	throws DocumentException, BadElementException
	{

		try {  	

			// working cells
			PdfPCell tableCell = null;
			PdfPCell pdfPCell = new PdfPCell();

			pdfPCell.setPaddingRight(2);
			pdfPCell.setPaddingLeft(2);



			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);


			float[] widths1_5 = {0.78f, 0.07f, 0.15f};
			PdfPTable _Table1_5 = new PdfPTable(widths1_5);
			_Table1_5.getDefaultCell().setBorder(1);  	   	  		


			// TODO: calculate Tax amount		
			BigDecimal taxrate = new BigDecimal(0.0);
			try{
				taxrate=new TaxcodeBD(this.getSessionFactoryClusterMap()).findTaxcodeByTaxcodekey(hdr.getTaxcode()).getRate();
			} catch (Exception e){}

			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("SUBTOTAL",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table5_2.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase("TAX "+taxrate.toString()+"%",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_2.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase("SHIPPING",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_2.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase("TOTAL",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_2.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_2);		 	   	
			_Table1_5.addCell(tableCell);	


			PdfPTable _Table5_4 = new PdfPTable(1);
			_Table5_4.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase(hdr.getCcykey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table5_4.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(hdr.getCcykey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_4.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(hdr.getCcykey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_4.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(hdr.getCcykey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_4.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_4);		 	   	
			_Table1_5.addCell(tableCell);	


			PdfPTable _Table5_3 = new PdfPTable(1);
			_Table5_3.getDefaultCell().setBorder(CELL_BORDER);
			PdfPCell pdfPCellYellow = new PdfPCell();
			pdfPCellYellow.setPaddingRight(2);
			pdfPCellYellow.setPaddingLeft(2);
			pdfPCellYellow.setBackgroundColor(eggshell);																	
			pdfPCellYellow.setPhrase(new Phrase(hdr.getSubtotalamt().toString(),font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_3.addCell(pdfPCellYellow);	
			pdfPCellYellow.setPhrase(new Phrase(hdr.getTaxamt().toString(),font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);				
			_Table5_3.addCell(pdfPCellYellow);
			pdfPCellYellow.setPhrase(new Phrase(hdr.getShippingamt().toString(),font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);				
			_Table5_3.addCell(pdfPCellYellow);			
			pdfPCellYellow.setPhrase(new Phrase(hdr.getTotalamt().toString(),font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_3.addCell(pdfPCellYellow);	

			tableCell = new PdfPCell(_Table5_3);		 	   	
			_Table1_5.addCell(tableCell);	


			tableCell = new PdfPCell(_Table1_5);		 	   	
			_Table1.addCell(tableCell);




			// working cells
			tableCell = null;
			pdfPCell = new PdfPCell();
			float fixedHeightDefault = pdfPCell.getFixedHeight();
			pdfPCell.setPaddingRight(10);
			pdfPCell.setPaddingLeft(10);



			// define blank cell
			_BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);



			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);


			float[] widths1_3 = {0.2f, 0.80f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(1);  	   	  		



			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);  	

			pdfPCell.setPhrase(new Phrase("SHIP TO",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(fixedHeightDefault);			
			_Table3_1.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setFixedHeight(70);
			_Table3_1.addCell(pdfPCell);	

			tableCell = new PdfPCell(_Table3_1);		 	   	
			_Table1_3.addCell(tableCell);


			/*			PdfPTable _Table3_2 = new PdfPTable(1);
			_Table3_2.getDefaultCell().setBorder(1);			

			// init shipto location			
			pdfPCell.setPhrase(new Phrase(hdr.getShiptolocationkey().getLocationName(),font));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setPaddingBottom(5);
			pdfPCell.setFixedHeight(fixedHeightDefault);			
			_Table3_2.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(hdr.getShiptolocationkey().getAddress1(),font));
			_Table3_2.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(hdr.getShiptolocationkey().getAddress2(),font));
			_Table3_2.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(hdr.getShiptolocationkey().getAddress3(),font));
			_Table3_2.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(hdr.getShiptolocationkey().getCountry(),font));
			_Table3_2.addCell(pdfPCell);			

			tableCell = new PdfPCell(_Table3_2);
			tableCell.setBackgroundColor(lghtgry);			 	   	
			_Table1_3.addCell(tableCell);*/

			tableCell = new PdfPCell(_Table1_3);
			tableCell.setBorder(1);
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));
			_Table1.addCell(tableCell);



			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);



			PdfPTable _Table1_9 = new PdfPTable(1);
			_Table1_9.getDefaultCell().setBorder(1);  	   	  		

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);  	

			pdfPCell.setPhrase(new Phrase("SPECIAL INSTRUCTIONS",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(fixedHeightDefault);			
			_Table9_1.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(hdr.getTxt1(),font));
			pdfPCell.setFixedHeight(80);
			pdfPCell.setNoWrap(false);
			_Table9_1.addCell(pdfPCell);	

			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_9.addCell(tableCell);

			tableCell = new PdfPCell(_Table1_9);
			tableCell.setBorder(1);
			tableCell.setBackgroundColor(lghtgry);
			_Table1.addCell(tableCell);



		}
		catch (Exception e) {}		
	}	


}