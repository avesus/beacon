package com.bureaueye.genesys.bean.finance.print;

import java.awt.Color;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;

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





public final class PrintFinancehdr extends BaseDTO {
	
	
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
	
	
	
	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeaderGrey;
	Font fontInvoice;
	
	
	// constructors
	public PrintFinancehdr() throws ApplicationException {
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

			fontHeaderGrey = new Font(font.getFamily(), font.getSize()+12, fontBold.getStyle());
			fontHeaderGrey.setColor(grey);
			fontInvoice = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontInvoice.setColor(bureaueyeColor);	
		} catch (Exception e) {
		}
	}
	public PrintFinancehdr(Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		_Document = null;
		_company = null;
		_companyheader = null;
	}
	
	
	
	
	
	public void setPrinted(
			Integer _id,
			User _user
	)
	throws Exception {
		
		// read header
		FinancehdrBD financehdrBD = new FinancehdrBD(this.getSessionFactoryClusterMap());
		Financehdr financehdrDAO = null;
		financehdrDAO = financehdrBD.read(_id); 
		
		
		// do not update printed info if a TEST PRINT
		if (!financehdrDAO.isPrintedflag()) {
			// update invoice no, print date
			Calendar c = Calendar.getInstance();
			financehdrDAO.setPrintdate(c.getTime());
			financehdrDAO.setPrinttime(com.bureaueye.beacon.util.Util.toTime(c));
			financehdrDAO.setPrintedflag(true);
			int nextdocno = 0;
			try {
				nextdocno = new SidocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
						"INV",
						financehdrDAO.getCompanykey(),
						c.get(Calendar.YEAR),
						_user
				);
			} catch (Exception e) {}
			financehdrDAO.setDockey(new Integer(nextdocno).toString());
			
			// update header
			financehdrBD.createOrUpdate(financehdrDAO, _user);
			
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
			FinancehdrBD financehdrBD = new FinancehdrBD(this.getSessionFactoryClusterMap());
			Financehdr financehdrDAO = null;
			financehdrDAO = financehdrBD.read(_id); 
			
			
			
			
			
			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(2);
			
			_company = new CompanyBD(this.getSessionFactoryClusterMap()).read(financehdrDAO.getCompanykey());
			_companyheader = new CompanyheaderBD(this.getSessionFactoryClusterMap()).read(_company.getCompanyheaderId());
			
			
			
			if (financehdrDAO != null) outputHeaderToPDF(financehdrDAO);   
			
			// new page at end of footer
			_Document.newPage();
			
			
			// read details		
			int row = 0;
			List sidtldtos = new FinancehdrBD(this.getSessionFactoryClusterMap()).getFinancedtls(financehdrDAO.getFinancehdrId());
			if (sidtldtos.size() > 0) {			
				outputDetailHeaderToPDF();   
				
				// process details list collection
				Iterator it = sidtldtos.iterator();
				while (it.hasNext()) {
					// init 
					Financedtl lineItem = (Financedtl) it.next();
					
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
			
			if (financehdrDAO != null) outputFooterToPDF(financehdrDAO);
			
			
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
	
	
	
	
	
	public void outputDetailToPDF(Financedtl dtl, int row) 
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
			
			
			//float[] widths1_2 = {0.35f, 0.08f, 0.1f, 0.15f, 0.1f, 0.07f, 0.15f}; 
			//float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f}; 
			float[] widths1_2 = {0.75f, 0.1f, 0.15f};
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(1);			
			
			pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			
			pdfPCell.setPaddingTop(4);
			
			
			String descr = dtl.getDoctypekey()+dtl.getSubtypekey();
			try{
				descr = new ChargeBD(this.getSessionFactoryClusterMap())
				.read(dtl.getSubtypekey()).getLdesc();
			} catch(Exception e){}
			
			// special text for Rental Per-diem
			if (dtl.getSubtypekey().equals("RNPD")) {
				descr=descr+" from "+dtl.getBillfromdate()+" to "+dtl.getBilltodate();
			}
			
			// add unit
			if (!dtl.getUnitkey().equals("")) descr = dtl.getUnitkey()+": "+descr;
			
			// use text if entered
			if (!dtl.getTxt1().equals("") && dtl.getTxt1() != null) descr = dtl.getTxt1();
			
			
			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase(descr,fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			_Table1_2.addCell(tableCell);
			
			/*			PdfPTable _Table4_1 = new PdfPTable(1);
			 _Table4_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase(dtl.getDays().toString(),fontSmall));	
			 pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			 pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
			 _Table4_1.addCell(pdfPCell);	
			 tableCell = new PdfPCell(_Table4_1);		 	   	
			 _Table1_2.addCell(tableCell);*/			
			
			/*			PdfPTable _Table5_1 = new PdfPTable(1);
			 _Table5_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase(dtl.getNetamount().toString(),fontSmall));
			 pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			 _Table5_1.addCell(pdfPCell);
			 tableCell = new PdfPCell(_Table5_1);		 	   	
			 _Table1_2.addCell(tableCell);*/	
			
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
			 _Table1_2.addCell(tableCell);	*/
			
			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getCcykey(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);
			
			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);	
			pdfPCell.setPhrase(new Phrase(dtl.getNetamount().toString(),fontSmall));
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
			//float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f}; 
			float[] widths1_2 = {0.75f, 0.1f, 0.15f};
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(1);			
			
			
			pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
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
			
			/*			PdfPTable _Table4_1 = new PdfPTable(1);
			 _Table4_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase("",fontSmall));	
			 pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			 _Table4_1.addCell(pdfPCell);	
			 tableCell = new PdfPCell(_Table4_1);		 	   	
			 _Table1_2.addCell(tableCell);	*/		
			
			/*			PdfPTable _Table5_1 = new PdfPTable(1);
			 _Table5_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase("",fontSmall));
			 pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			 _Table5_1.addCell(pdfPCell);
			 tableCell = new PdfPCell(_Table5_1);		 	   	
			 _Table1_2.addCell(tableCell);	*/
			
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
			 _Table1_2.addCell(tableCell);	*/
			
			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);	
			
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
			//float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f};
			float[] widths1_2 = {0.75f, 0.1f, 0.15f};
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
			
			/*			PdfPTable _Table4_1 = new PdfPTable(1);
			 _Table4_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase("UNITS",fontSmallBold));	
			 _Table4_1.addCell(pdfPCell);	
			 tableCell = new PdfPCell(_Table4_1);		 	   	
			 _Table1_2.addCell(tableCell);	*/		
			
			/*			PdfPTable _Table5_1 = new PdfPTable(1);
			 _Table5_1.getDefaultCell().setBorder(1);
			 pdfPCell.setPhrase(new Phrase("RATE",fontSmallBold));	
			 _Table5_1.addCell(pdfPCell);
			 tableCell = new PdfPCell(_Table5_1);		 	   	
			 _Table1_2.addCell(tableCell);*/	
			
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
			 _Table1_2.addCell(tableCell);	*/
			
			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("CCY",fontSmallBold));	
			_Table9_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_2.addCell(tableCell);
			
			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("AMOUNT",fontSmallBold));	
			_Table8_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table8_1);		 	   	
			_Table1_2.addCell(tableCell);	
			
			
			tableCell = new PdfPCell(_Table1_2);
			tableCell.setBorder(1);	
			_Table1.addCell(tableCell);
			
			
		}
		catch (Exception e) {}			
	}			
	
	
	
	
	public void outputHeaderToPDF(Financehdr hdr) 
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
			
			if (hdr.getDoctypekey().equals("INV")) pdfPCell3.setPhrase(new Phrase("INVOICE",fontHeaderGrey));
			if (hdr.getDoctypekey().equals("CRD")) pdfPCell3.setPhrase(new Phrase("CREDIT",fontHeaderGrey));
			
			pdfPCell3.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			_Table1_2.addCell(pdfPCell3);		
			
			tableCell = new PdfPCell(_Table1_2);
			
			_Table1.addCell(tableCell);
			
			
			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);
			
			
			
			float[] widths1_3 = {0.15f, 0.5f, 0.35f}; 
			
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(1);  	   	  		
			
			
			PdfPTable _Table10_2 = new PdfPTable(1);
			_Table10_2.getDefaultCell().setBorder(1);
			
			pdfPCell.setPhrase(new Phrase("CUSTOMER",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(100);
			_Table10_2.addCell(pdfPCell);	
			
			tableCell = new PdfPCell(_Table10_2);		 	   	
			_Table1_3.addCell(tableCell);		
			
			
			PdfPTable _Table11_1 = new PdfPTable(1);
			_Table11_1.getDefaultCell().setBorder(1);  	
			
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// init billing address
			Address _customer = _addressBD.read(hdr.getLesseeaddrkey());
			String addr1 = _customer.getAddr1();
			String addr2 = _customer.getAddr2();
			String addr3 =_customer.getAddr3();
			String addr4 = _customer.getAddr4();
			if (!_customer.getRentaddrkey().equals("")) {				
				Address billingaddress = null;
				try {
					billingaddress = _addressBD.read(_customer.getRentaddrkey());
				} catch (ApplicationException ae) {}
				if (billingaddress != null) {
					addr1 = billingaddress.getAddr1();
					addr2 = billingaddress.getAddr2();
					addr3 = billingaddress.getAddr3();
					addr4 = billingaddress.getAddr4();
				}
			}
			
			pdfPCell.setPhrase(new Phrase(_customer.getName(),font));
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
			
			float[] widths12_1 = {0.55f, 0.45f}; 
			PdfPTable _Table12_1 = new PdfPTable(widths12_1);
			
			_Table12_1.getDefaultCell().setBorder(1);
			
			PdfPTable _Table12_2 = new PdfPTable(1);
			_Table12_2.getDefaultCell().setBorder(1);
			
			if (hdr.getDoctypekey().equals("INV")) pdfPCell.setPhrase(new Phrase("INVOICE NO",fontBold));
			if (hdr.getDoctypekey().equals("CRD")) pdfPCell.setPhrase(new Phrase("CREDIT NO",fontBold));
			
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
			pdfPCell.setPhrase(new Phrase(hdr.getDockey(),fontInvoice));
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
			pdfPCell.setPhrase(new Phrase(Util.dateTextFormat2(hdr.getPrintdate()),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				
			_Table12_4.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table12_4);				
			tableCell.setBackgroundColor(lghtgry);
			_Table12_1.addCell(tableCell);	
			
			
			tableCell = new PdfPCell(_Table12_1);
			_Table1_3.addCell(tableCell);
			
			
			
			
			
			tableCell = new PdfPCell(_Table1_3);
			
			_Table1.addCell(tableCell);
			
			
			pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(10);
			pdfPCell.setPaddingLeft(10);		
			
			
			float[] widths1_5 = {0.3f, 0.542f, 0.158f}; 
			PdfPTable _Table1_5 = new PdfPTable(widths1_5);
			_Table1_5.getDefaultCell().setBorder(1);  	   	  		
			
			
			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(CELL_BORDER);
			
			pdfPCell.setPhrase(new Phrase("CONTRACT NO",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table5_1.addCell(pdfPCell);
			
			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setPhrase(new Phrase(hdr.getContractno(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			
			_Table5_1.addCell(pdfPCell);
			
			tableCell = new PdfPCell(_Table5_1);
			_Table1_5.addCell(tableCell);		
			
			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);
			
			pdfPCell.setPhrase(new Phrase("PAYMENT TERMS",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			
			_Table5_2.addCell(pdfPCell);
			
			pdfPCell.setPhrase(new Phrase(" "//+hdr.getPaymentterm()
					,font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			
			
			_Table5_2.addCell(pdfPCell);
			
			tableCell = new PdfPCell(_Table5_2);		 	   	
			_Table1_5.addCell(tableCell);	
			
			PdfPTable _Table5_3 = new PdfPTable(1);
			_Table5_3.getDefaultCell().setBorder(CELL_BORDER);
			
			pdfPCell.setPhrase(new Phrase("DUE DATE",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);			
			
			_Table5_3.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				
			
			_Table5_3.addCell(pdfPCell);
			
			tableCell = new PdfPCell(_Table5_3);		 	   	
			_Table1_5.addCell(tableCell);	
			
			
			tableCell = new PdfPCell(_Table1_5);		 	   	
			_Table1.addCell(tableCell);
			
			
		}
		catch (Exception e) {}		
	}	
	
	
	public void outputFooterToPDF(Financehdr hdr) 
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
			
			
			float[] widths1_5 = {0.75f, 0.1f, 0.15f};
			PdfPTable _Table1_5 = new PdfPTable(widths1_5);
			_Table1_5.getDefaultCell().setBorder(1);  	   	  		
			
			
			
			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);
			
			pdfPCell.setPhrase(new Phrase("SUBTOTAL",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table5_2.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase("TAX",fontBold));
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
			
			tableCell = new PdfPCell(_Table5_4);		 	   	
			_Table1_5.addCell(tableCell);	
			
			
			PdfPTable _Table5_3 = new PdfPTable(1);
			_Table5_3.getDefaultCell().setBorder(CELL_BORDER);
			PdfPCell pdfPCellYellow = new PdfPCell();
			pdfPCellYellow.setPaddingRight(2);
			pdfPCellYellow.setPaddingLeft(2);
			pdfPCellYellow.setBackgroundColor(eggshell);																	
			pdfPCellYellow.setPhrase(new Phrase(hdr.getNetamount().toString(),font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_3.addCell(pdfPCellYellow);	
			pdfPCellYellow.setPhrase(new Phrase("0.00",font));
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);				
			_Table5_3.addCell(pdfPCellYellow);
			pdfPCellYellow.setPhrase(new Phrase(hdr.getNetamount().toString(),font));
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
			
			pdfPCell.setPhrase(new Phrase("PAYMENT TO",fontBold));
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
			
			
			// only output payment to details for Invoice type
			if (hdr.getDoctypekey().equals("INV")) {
				
				PdfPTable _Table3_2 = new PdfPTable(1);
				_Table3_2.getDefaultCell().setBorder(1);			
				
				pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
				pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
				pdfPCell.setBorder(0);
				pdfPCell.setPaddingBottom(5);
				pdfPCell.setFixedHeight(fixedHeightDefault);			
				
				AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
				// init billing address
				Address _customer = _addressBD.read(hdr.getLesseeaddrkey());
				String _paymenttoinstructions = _customer.getPaymenttoinstructions();
				if (!_paymenttoinstructions.equals("")) {
					pdfPCell.setPhrase(new Phrase(_paymenttoinstructions,font));
					_Table3_2.addCell(pdfPCell);				
				} else {
					pdfPCell.setPhrase(new Phrase(_companyheader.getCompanyName(),font));
					_Table3_2.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(_companyheader.getAddress(),font));
					_Table3_2.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(_companyheader.getCity(),font));
					_Table3_2.addCell(pdfPCell);			
					pdfPCell.setPhrase(new Phrase(_companyheader.getState(),font));
					_Table3_2.addCell(pdfPCell);			
					pdfPCell.setPhrase(new Phrase(_companyheader.getCountry(),font));
					_Table3_2.addCell(pdfPCell);			
				}
				
				tableCell = new PdfPCell(_Table3_2);
				tableCell.setBackgroundColor(lghtgry);			 	   	
				_Table1_3.addCell(tableCell);
				
			}
			
			
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
			
			pdfPCell.setPhrase(new Phrase("OFFICE USE ONLY",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(fixedHeightDefault);			
			_Table9_1.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase("",font));
			pdfPCell.setFixedHeight(30);
			_Table9_1.addCell(pdfPCell);	
			
			tableCell = new PdfPCell(_Table9_1);		 	   	
			_Table1_9.addCell(tableCell);
			
			tableCell = new PdfPCell(_Table1_9);
			tableCell.setBorder(1);
			tableCell.setBackgroundColor(eggshell);
			_Table1.addCell(tableCell);
			
			
			
		}
		catch (Exception e) {}		
	}	
	
	
}