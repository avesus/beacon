package com.bureaueye.beacondms.bean.dms.pdf.base;

import java.awt.Color;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;

import com.bureaueye.beacon.util.Util;
import com.bureaueye.beacondms.exception.dms.BuildException;
import com.bureaueye.beacondms.model.dms.Documenttype;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * 
 * Amendments ----------
 * 
 * NT	2013-12-11	WSI-201311-0002	BEACON LAKER (WSI LINER) - Sales Invoice Template 
 * 
 */
public final class PrintSalesinvoice1 { 


	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);


	//maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;



	private static Document pdfDocument;
	private static PdfPTable pdfTable1;


	private static int CELL_BORDER = 0;




	private static Map<String, SessionFactory> _sessionFactoryClusterMap;
	public void setSessionFactoryClusterMap (Map<String, SessionFactory> sfcm) {_sessionFactoryClusterMap = sfcm;}	
	public Map<String, SessionFactory> getSessionFactoryClusterMap () { return _sessionFactoryClusterMap;	}	




	private static BaseColor lghtgry = new BaseColor(247, 247, 249);
	private static BaseColor bureaueyeColor = new BaseColor(180, 43, 22);
	private static BaseColor eggshell = new BaseColor(255, 255, 204);
	private static BaseColor grey = new BaseColor(192, 192, 192);



	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeaderGrey;
	Font fontInvoice;		
	Font fontBoldHugeLightgray;


	CompanyBD companybd;	
	CompanyheaderBD companyheaderbd;

	Sihdr sihdrdao;

	// constructors
	public PrintSalesinvoice1() throws ApplicationException {
	}



	public void executePrint(
			Integer id, 
			String printtype, 
			User user,
			Map<String, SessionFactory> sessionFactoryClusterMap
	)
	throws Exception {	


		setStartprocesstime();

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  executePrint: " +
				"  id ["+id+"]"+
				"  printtype ["+printtype+"]"				
		);


		this.setSessionFactoryClusterMap(sessionFactoryClusterMap);		


		//init BD		
		companybd = new CompanyBD(this.getSessionFactoryClusterMap());	
		companyheaderbd = new CompanyheaderBD(this.getSessionFactoryClusterMap());		
		SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());
		SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);	



		Systemcode systemcodedao = null;
		String workDirectory = "";
		try {
			systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
					"BEACONDMS", 
					"WORKDIRECTORY"
			);
			workDirectory = systemcodedao.getDescr();
		} catch (ApplicationException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
		}


		try {

			// read header
			sihdrdao = null;
			sihdrdao = sihdrbd.read(id); 


			try {
				// not a test print assign Printed fields
				if (printtype.equals("Print")) {
					this.setPrinted(user, this.getSessionFactoryClusterMap());					
				}
			} catch (Exception e) {
			}




			//set Document Type  
			//- pagesize
			//- font
			//- build class
			//- margins
			//- language
			Documenttype documenttypedao = new Documenttype();
			documenttypedao.setPagesizerectanglellx(new BigDecimal(0));//lower left x
			documenttypedao.setPagesizerectanglelly(new BigDecimal(0));//lower left y
			documenttypedao.setPagesizerectangleurx(new BigDecimal(595));//upper right x
			documenttypedao.setPagesizerectangleury(new BigDecimal(842)); //upper right y
			documenttypedao.setMarginleft(new BigDecimal(36));
			documenttypedao.setMarginright(new BigDecimal(36)); 
			documenttypedao.setMargintoppage1(new BigDecimal(30));
			documenttypedao.setMargintop(new BigDecimal(30));		
			documenttypedao.setMarginbottom(new BigDecimal(30));
			documenttypedao.setFontsize(new BigDecimal(10));
			documenttypedao.setFontstyle(0);		
			documenttypedao.setFontname("c:\\windows\\fonts\\calibri.ttf");	
			documenttypedao.setLanguageid("en");



			pdfDocument=new com.itextpdf.text.Document();


			// init pagesize for document type
			Rectangle pageSizeRectangle = new Rectangle(
					documenttypedao.getPagesizerectanglellx().floatValue(),//lower left x
					documenttypedao.getPagesizerectanglelly().floatValue(),//lower left y
					documenttypedao.getPagesizerectangleurx().floatValue(),//upper right x
					documenttypedao.getPagesizerectangleury().floatValue() //upper right y
			);
			pdfDocument.setPageSize(pageSizeRectangle);
			//pdfDocument.setPageSize(PageSize.A4);

			//init margins for document type
			pdfDocument.setMargins(
					documenttypedao.getMarginleft().floatValue(),
					documenttypedao.getMarginright().floatValue(), 
					documenttypedao.getMargintoppage1().floatValue(),
					documenttypedao.getMarginbottom().floatValue()
			); 

			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(documenttypedao.getFontname(), BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					//Font.FontFamily.COURIER,
					baseFont,
					documenttypedao.getFontsize().floatValue(),
					documenttypedao.getFontstyle()
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontBoldHugeLightgray=new Font(font.getFamily(), font.getSize()+24, fontBold.getStyle());
			fontBoldHugeLightgray.setColor(new BaseColor(Color.LIGHT_GRAY));
			fontInvoice = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontInvoice.setColor(bureaueyeColor);		
			fontHeaderGrey = new Font(font.getFamily(), font.getSize()+12, fontBold.getStyle());
			fontHeaderGrey.setColor(grey);


			//set page count
			pdfDocument.setPageCount(1);


			//generate print file
			String printFilename = "";															
			printFilename = workDirectory+"\\SALES_INVOICE"+sihdrdao.getSihdrId()+".pdf";
			FileOutputStream fileOutputStream = new FileOutputStream(printFilename);
			PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, fileOutputStream);



			//init end page event		
			Company companydao = null;
			try {
				companydao = companybd.read(sihdrdao.getCompanykey());
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" find company: ApplicationException: "+e.getMessage());				
			}
			Companyheader companyheaderdao =null;
			try {
				companyheaderdao = companyheaderbd.read(companydao.getCompanyheaderId());
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" find companyheader: ApplicationException: "+e.getMessage());				
			} 


			String title="INVOICE";

			pdfWriter.setPageEvent(
					new HeaderFooterPageEvent(
							companyheaderdao,
							documenttypedao,
							title
					)
			);


			pdfDocument.open();	


			// create main table and add it to the document
			pdfTable1 = new PdfPTable(1);
			pdfTable1.getDefaultCell().setBorder(0);
			pdfTable1.getDefaultCell().setNoWrap(false);            		
			pdfTable1.setWidthPercentage(100f);  
			pdfTable1.getDefaultCell().setPadding(2);


			if (sihdrdao != null) outputHeaderToPDF(sihdrdao,companyheaderdao);   

			// read details		
			int row = 0;
			List sidtldtos = new SihdrBD(this.getSessionFactoryClusterMap()).getSidtls(sihdrdao.getSihdrId());
			if (sidtldtos.size() > 0) {			
				outputDetailHeaderToPDF();   

				// process details list collection
				Iterator it = sidtldtos.iterator();
				while (it.hasNext()) {
					// init 
					Sidtl lineItem = (Sidtl) it.next();

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

			if (sihdrdao != null) outputFooterToPDF(companyheaderdao);


			// add main table to PDF document
			pdfDocument.add(pdfTable1);  


			// test print Watermark
			if (printtype.equals("Test")) {
				String waterMarkText=Constants.TEST_PRINT;
				//add watermark
				ColumnText.showTextAligned(
						pdfWriter.getDirectContentUnder(),
						Element.ALIGN_CENTER, 
						new Phrase(waterMarkText, fontBoldHugeLightgray),
						297.5f, 
						421, 
						pdfWriter.getPageNumber() % 2 == 1 ? 45 : -45
				);			
			}


		} catch (BuildException e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+" Build Document: BuildException: "+e.getCode());
			throw new BuildException(BuildException.GENERAL_FAILURE);	
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+" Build Document: Exception: "+e.getMessage());
			throw new BuildException(BuildException.GENERAL_FAILURE);	
		} finally {
			pdfDocument.close();	
		}



		// clean-up
		sihdrbd = null;
		companybd = null;
		companyheaderbd = null;	
		systemcodebd = null;


	}


	void println(String s) { System.out.println(s); }


	public void setStartprocesstime() {
		Calendar cal = Calendar.getInstance();	
		this._startprocesstime = cal;
	}
	public Calendar getStartprocesstime() {
		return this._startprocesstime;
	}
	public boolean isBlocked() {
		Calendar _currenttime = Calendar.getInstance();			
		Calendar _maxprocesstime = this._startprocesstime;
		_maxprocesstime.add(Calendar.MILLISECOND,MAX_PROCESS_TIME);

		log.debug(
				"["+this.getClass().getName()+"] "+new Date()+
				" isblocked: "+_currenttime.after(_maxprocesstime)+
				" currenttime: "+_currenttime.getTime()+
				" maxprocesstime: "+_maxprocesstime.getTime()
		);

		if (_currenttime.after(_maxprocesstime)) return true;
		return false;
	}



	public void outputDetailToPDF(Sidtl dtl, int row) 
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
			float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f}; 
			PdfPTable pdfTable1_2 = new PdfPTable(widths1_2);
			pdfTable1_2.getDefaultCell().setBorder(1);			

			pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			
			pdfPCell.setPaddingTop(4);


			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase(dtl.getTxt1(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			pdfTable1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getUnits().toString()+" "+dtl.getUname(),fontSmall));	
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			pdfTable1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getRate().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getChgamt().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getXrateinv().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			pdfTable1_2.addCell(tableCell);	*/

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(dtl.getCcykey(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			pdfTable1_2.addCell(tableCell);

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);	
			pdfPCell.setPhrase(new Phrase(dtl.getInvoiceamt().toString(),fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table8_1.addCell(pdfPCell);			
			tableCell = new PdfPCell(_Table8_1);		 	   	
			tableCell.setBackgroundColor(eggshell);
			pdfTable1_2.addCell(tableCell);	


			tableCell = new PdfPCell(pdfTable1_2);
			tableCell.setBorder(1);	
			pdfTable1.addCell(tableCell);


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
			float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f}; 
			PdfPTable pdfTable1_2 = new PdfPTable(widths1_2);
			pdfTable1_2.getDefaultCell().setBorder(1);			


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
			pdfTable1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));	
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			pdfTable1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			pdfTable1_2.addCell(tableCell);	*/

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table9_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table9_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("",fontSmall));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table8_1.addCell(pdfPCell);				
			tableCell = new PdfPCell(_Table8_1);
			tableCell.setBackgroundColor(eggshell);
			pdfTable1_2.addCell(tableCell);	


			tableCell = new PdfPCell(pdfTable1_2);
			tableCell.setBorder(1);	
			pdfTable1.addCell(tableCell);


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
			pdfTable1.addCell(_BlankCell);


			//float[] widths1_2 = {0.35f, 0.08f, 0.1f, 0.15f, 0.1f, 0.07f, 0.15f}; 
			float[] widths1_2 = {0.60f, 0.1f, 0.08f, 0.07f, 0.15f}; 
			PdfPTable pdfTable1_2 = new PdfPTable(widths1_2);
			pdfTable1_2.getDefaultCell().setBorder(1);			


			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(15f);			


			PdfPTable _Table3_1 = new PdfPTable(1);
			_Table3_1.getDefaultCell().setBorder(1);			
			pdfPCell.setPhrase(new Phrase("DESCRIPTION",fontSmallBold));	
			_Table3_1.addCell(pdfPCell);					
			tableCell = new PdfPCell(_Table3_1);		 	   	
			pdfTable1_2.addCell(tableCell);

			PdfPTable _Table4_1 = new PdfPTable(1);
			_Table4_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("UNITS",fontSmallBold));	
			_Table4_1.addCell(pdfPCell);	
			tableCell = new PdfPCell(_Table4_1);		 	   	
			pdfTable1_2.addCell(tableCell);			

			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("RATE",fontSmallBold));	
			_Table5_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table5_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			/*			PdfPTable _Table6_1 = new PdfPTable(1);
			_Table6_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("CHG AMOUNT",fontSmallBold));	
			_Table6_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table6_1);		 	   	
			pdfTable1_2.addCell(tableCell);	

			PdfPTable _Table7_1 = new PdfPTable(1);
			_Table7_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("EX RATE",fontSmallBold));	
			_Table7_1.addCell(pdfPCell);
			tableCell = new PdfPCell(_Table7_1);		 	   	
			pdfTable1_2.addCell(tableCell);	*/

			PdfPTable _Table9_1 = new PdfPTable(1);
			_Table9_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("CCY",fontSmallBold));	
			_Table9_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table9_1);		 	   	
			pdfTable1_2.addCell(tableCell);

			PdfPTable _Table8_1 = new PdfPTable(1);
			_Table8_1.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("AMOUNT",fontSmallBold));	
			_Table8_1.addCell(pdfPCell);		
			tableCell = new PdfPCell(_Table8_1);		 	   	
			pdfTable1_2.addCell(tableCell);	


			tableCell = new PdfPCell(pdfTable1_2);
			tableCell.setBorder(1);	
			pdfTable1.addCell(tableCell);


		}
		catch (Exception e) {}			
	}			


	public void outputHeaderToPDF(Sihdr hdr, Companyheader ch) 
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



			// title label
			float[] widths1_2 = {0.5f, 0.5f}; 
			PdfPTable pdfTable1_2 = new PdfPTable(widths1_2);
			pdfTable1_2.getDefaultCell().setBorder(0);

			Image logoImage = Image.getInstance(ch.getLogo());
			logoImage.scalePercent(70f);
			PdfPCell pdfPCell2 =  new PdfPCell(logoImage);

			pdfPCell2.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell2.setPaddingRight(10);
			pdfPCell2.setPaddingLeft(10);			
			pdfPCell2.setPaddingBottom(10);

			pdfTable1_2.addCell(pdfPCell2);

			PdfPCell pdfPCell3 = new PdfPCell();
			pdfPCell3.setBorderColor(new BaseColor(Color.WHITE));
			pdfPCell3.setPaddingRight(10);
			pdfPCell3.setPaddingLeft(10);			
			pdfPCell3.setPaddingBottom(10);			
			pdfPCell3.setPhrase(new Phrase("INVOICE",fontHeaderGrey));
			pdfPCell3.setHorizontalAlignment (Element.ALIGN_RIGHT);
			pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			pdfTable1_2.addCell(pdfPCell3);		

			tableCell = new PdfPCell(pdfTable1_2);

			pdfTable1.addCell(tableCell);


			// insert blank row
			_BlankCell.setColspan(2);
			pdfTable1.addCell(_BlankCell);




			float[] widths1_3 = {0.15f, 0.5f, 0.35f}; 

			PdfPTable pdfTable1_3 = new PdfPTable(widths1_3);
			pdfTable1_3.getDefaultCell().setBorder(1);  	   	  		


			PdfPTable pdfTable10_2 = new PdfPTable(1);
			pdfTable10_2.getDefaultCell().setBorder(1);

			pdfPCell.setPhrase(new Phrase("CUSTOMER",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setFixedHeight(100);
			pdfTable10_2.addCell(pdfPCell);	

			tableCell = new PdfPCell(pdfTable10_2);		 	   	
			pdfTable1_3.addCell(tableCell);		


			PdfPTable pdfTable11_1 = new PdfPTable(1);
			pdfTable11_1.getDefaultCell().setBorder(1);  	

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// init billing address
			Address _customer = _addressBD.read(hdr.getCustomeraddrkey());
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
			pdfTable11_1.addCell(pdfPCell);			
			pdfPCell.setPhrase(new Phrase(addr1,font));
			pdfTable11_1.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(addr2,font));
			pdfTable11_1.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(addr3,font));
			pdfTable11_1.addCell(pdfPCell);				
			pdfPCell.setPhrase(new Phrase(addr4,font));
			pdfTable11_1.addCell(pdfPCell);

			tableCell = new PdfPCell(pdfTable11_1);
			tableCell.setBackgroundColor(lghtgry);
			pdfTable1_3.addCell(tableCell);	


			pdfPCell.setBorder(1);

			float[] widths12_1 = {0.55f, 0.45f}; 
			PdfPTable pdfTable12_1 = new PdfPTable(widths12_1);

			pdfTable12_1.getDefaultCell().setBorder(1);

			PdfPTable pdfTable12_2 = new PdfPTable(1);
			pdfTable12_2.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("INVOICE No",fontBold));	
			pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);	
			pdfPCell.setFixedHeight(20);
			pdfTable12_2.addCell(pdfPCell);
			tableCell = new PdfPCell(pdfTable12_2);		
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));			
			pdfTable12_1.addCell(tableCell);

			pdfPCell.setFixedHeight(fixedHeightDefault);

			PdfPTable pdfTable12_5 = new PdfPTable(1);
			pdfTable12_5.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase(hdr.getInvoiceno(),fontInvoice));
			pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);	
			pdfTable12_5.addCell(pdfPCell);
			tableCell = new PdfPCell(pdfTable12_5);				
			tableCell.setBackgroundColor(lghtgry);			
			pdfTable12_1.addCell(tableCell);	



			PdfPTable pdfTable12_3 = new PdfPTable(1);
			pdfTable12_3.getDefaultCell().setBorder(1);
			pdfPCell.setPhrase(new Phrase("INVOICE DATE",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);			
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);				
			pdfTable12_3.addCell(pdfPCell);
			tableCell = new PdfPCell(pdfTable12_3);	
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));			
			pdfTable12_1.addCell(tableCell);	

			PdfPTable pdfTable12_4 = new PdfPTable(1);
			pdfTable12_4.getDefaultCell().setBorder(1);
			try {
				pdfPCell.setPhrase(new Phrase(Util.dateTextFormat2(hdr.getPrintdate()),font));
			} catch (Exception e) {
				pdfPCell.setPhrase(new Phrase("",font));		
			}
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);				
			pdfTable12_4.addCell(pdfPCell);
			tableCell = new PdfPCell(pdfTable12_4);				
			tableCell.setBackgroundColor(lghtgry);
			pdfTable12_1.addCell(tableCell);	


			tableCell = new PdfPCell(pdfTable12_1);
			pdfTable1_3.addCell(tableCell);



			tableCell = new PdfPCell(pdfTable1_3);

			pdfTable1.addCell(tableCell);


			pdfPCell = new PdfPCell();
			pdfPCell.setPaddingRight(10);
			pdfPCell.setPaddingLeft(10);		


			float[] widths1_5 = {0.3f, 0.7f};
			PdfPTable pdfTable1_5 = new PdfPTable(widths1_5);
			pdfTable1_5.getDefaultCell().setBorder(1);  	   	  		


			PdfPTable _Table5_1 = new PdfPTable(1);
			_Table5_1.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("INVOICE REFERENCE",fontBold));
			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);
			pdfPCell.setBorder(1);
			pdfPCell.setFixedHeight(fixedHeightDefault);
			_Table5_1.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase("",font));
			if (!hdr.getInvoiceref().equals(""))	
				pdfPCell.setPhrase(new Phrase(hdr.getInvoiceref(),font));
			else if (!hdr.getInvoicegroupref().equals(" ")) 
				pdfPCell.setPhrase(new Phrase(hdr.getInvoicegroupref(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);

			_Table5_1.addCell(pdfPCell);



			tableCell = new PdfPCell(_Table5_1);
			pdfTable1_5.addCell(tableCell);		

			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);

			pdfPCell.setPhrase(new Phrase("PAYMENT TERMS",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_CENTER);

			_Table5_2.addCell(pdfPCell);

			pdfPCell.setPhrase(new Phrase(" "+hdr.getPaymentterm(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);			

			_Table5_2.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_2);		 	   	
			pdfTable1_5.addCell(tableCell);	




			tableCell = new PdfPCell(pdfTable1_5);		 	   	
			pdfTable1.addCell(tableCell);


		}
		catch (Exception e) {	
		}	

	}	


	public void outputFooterToPDF(Companyheader companyheader) 
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
			PdfPTable pdfTable1_5 = new PdfPTable(widths1_5);
			pdfTable1_5.getDefaultCell().setBorder(1);  	   	  		



			PdfPTable _Table5_2 = new PdfPTable(1);
			_Table5_2.getDefaultCell().setBorder(CELL_BORDER);

			if (sihdrdao.getTaxamt().doubleValue() != 0) {
				pdfPCell.setPhrase(new Phrase("SUBTOTAL",fontBold));
				pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
				_Table5_2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("TAX",fontBold));
				pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
				_Table5_2.addCell(pdfPCell);
			}

			pdfPCell.setPhrase(new Phrase("TOTAL",fontBold));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_2.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_2);		 	   	
			pdfTable1_5.addCell(tableCell);	


			PdfPTable _Table5_4 = new PdfPTable(1);
			_Table5_4.getDefaultCell().setBorder(CELL_BORDER);

			if (sihdrdao.getTaxamt().doubleValue() != 0) {
				pdfPCell.setPhrase(new Phrase(sihdrdao.getInvoiceccykey(),font));
				pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);
				_Table5_4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(sihdrdao.getInvoiceccykey(),font));
				pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
				_Table5_4.addCell(pdfPCell);
			}

			pdfPCell.setPhrase(new Phrase(sihdrdao.getInvoiceccykey(),font));
			pdfPCell.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_4.addCell(pdfPCell);

			tableCell = new PdfPCell(_Table5_4);		 	   	
			pdfTable1_5.addCell(tableCell);	


			PdfPTable _Table5_3 = new PdfPTable(1);
			_Table5_3.getDefaultCell().setBorder(CELL_BORDER);
			PdfPCell pdfPCellYellow = new PdfPCell();
			pdfPCellYellow.setPaddingRight(2);
			pdfPCellYellow.setPaddingLeft(2);
			pdfPCellYellow.setBackgroundColor(eggshell);

			if (sihdrdao.getTaxamt().doubleValue() != 0) {			
				pdfPCellYellow.setPhrase(new Phrase(sihdrdao.getInvoiceamt().toString(),font));
				pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);			
				_Table5_3.addCell(pdfPCellYellow);	
				pdfPCellYellow.setPhrase(new Phrase(sihdrdao.getTaxamt().toString(),font));
				pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);				
				_Table5_3.addCell(pdfPCellYellow);
			}

			try {
				pdfPCellYellow.setPhrase(new Phrase(sihdrdao.getInvoiceamt().add(sihdrdao.getTaxamt()).toString(),font));
			} catch (Exception e) {
				pdfPCellYellow.setPhrase(new Phrase(sihdrdao.getInvoiceamt().toString(),font));				
			}
			pdfPCellYellow.setHorizontalAlignment (Element.ALIGN_RIGHT);			
			_Table5_3.addCell(pdfPCellYellow);	

			tableCell = new PdfPCell(_Table5_3);		 	   	
			pdfTable1_5.addCell(tableCell);	


			tableCell = new PdfPCell(pdfTable1_5);		 	   	
			pdfTable1.addCell(tableCell);




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
			pdfTable1.addCell(_BlankCell);


			float[] widths1_3 = {0.2f, 0.80f}; 

			PdfPTable pdfTable1_3 = new PdfPTable(widths1_3);
			pdfTable1_3.getDefaultCell().setBorder(1);  	   	  		



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
			pdfTable1_3.addCell(tableCell);


			PdfPTable _Table3_2 = new PdfPTable(1);
			_Table3_2.getDefaultCell().setBorder(1);			

			pdfPCell.setVerticalAlignment(Element.ALIGN_TOP);
			pdfPCell.setHorizontalAlignment (Element.ALIGN_LEFT);
			pdfPCell.setBorder(0);
			pdfPCell.setPaddingBottom(5);
			pdfPCell.setFixedHeight(fixedHeightDefault);			

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// init billing address
			Address _customer = _addressBD.read(sihdrdao.getCustomeraddrkey());
			String _paymenttoinstructions = _customer.getPaymenttoinstructions();
			if (!_paymenttoinstructions.equals("")) {
				pdfPCell.setPhrase(new Phrase(_paymenttoinstructions,font));
				_Table3_2.addCell(pdfPCell);				
			} else {
				pdfPCell.setPhrase(new Phrase(companyheader.getCompanyName(),font));
				_Table3_2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(companyheader.getAddress(),font));
				_Table3_2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(companyheader.getCity(),font));
				_Table3_2.addCell(pdfPCell);			
				pdfPCell.setPhrase(new Phrase(companyheader.getState(),font));
				_Table3_2.addCell(pdfPCell);			
				pdfPCell.setPhrase(new Phrase(companyheader.getCountry(),font));
				_Table3_2.addCell(pdfPCell);			
			}

			tableCell = new PdfPCell(_Table3_2);
			tableCell.setBackgroundColor(lghtgry);			 	   	
			pdfTable1_3.addCell(tableCell);

			tableCell = new PdfPCell(pdfTable1_3);
			tableCell.setBorder(1);
			tableCell.setBackgroundColor(new BaseColor(Color.WHITE));
			pdfTable1.addCell(tableCell);



			// insert blank row
			_BlankCell.setColspan(2);
			pdfTable1.addCell(_BlankCell);



			PdfPTable pdfTable1_9 = new PdfPTable(1);
			pdfTable1_9.getDefaultCell().setBorder(1);  	   	  		

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
			pdfTable1_9.addCell(tableCell);

			tableCell = new PdfPCell(pdfTable1_9);
			tableCell.setBorder(1);
			tableCell.setBackgroundColor(eggshell);
			pdfTable1.addCell(tableCell);



		}
		catch (Exception e) {}		
	}	





	//WE NEEDED TO INCLUDE THIS CLASS HERE AS THE PROGRAM 
	//AS WE NEED TO RESET THE MARGIN SETTINGS FOR PDF DOCUMENT 
	//TO HAVE A LARGER HEADER FOR PAGE 1
	public class HeaderFooterPageEvent extends PdfPageEventHelper {

		Companyheader companyHeader;
		PropertyResourceBundle resourceProps;
		String title;
		Documenttype documenttypedao;

		/** The template with the total number of pages. */
		PdfTemplate total;


		Font font;
		float fontSize;
		Font fontBold;	
		Font fontBoldLarge;
		Font fontSmall;
		Font fontSmallBold;	


		public HeaderFooterPageEvent(
				Companyheader header,
				Documenttype documenttypedao,
				String title
		) throws BuildException {

			try{
				this.companyHeader = header;
				this.title=title;
				this.documenttypedao=documenttypedao;

				//init document resource by languageid
				String resourceName="com.bureaueye.beacondms.DocumentResources_"+documenttypedao.getLanguageid();
				resourceProps = (PropertyResourceBundle) ResourceBundle.getBundle(resourceName);

				//init default fonts for document type
				BaseFont baseFont = BaseFont.createFont(documenttypedao.getFontname(), BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
				font=new Font(
						baseFont,
						documenttypedao.getFontsize().floatValue(),
						documenttypedao.getFontstyle()
				);
				fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
				fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
				fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
				fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);

			} catch (Exception e) {
				throw new BuildException(BuildException.GENERAL_FAILURE);	
			}
		}


		/**
		 * Creates the PdfTemplate that will hold the total number of pages.
		 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
		 *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
		 */
		public void onOpenDocument(PdfWriter writer, Document document) {
			total = writer.getDirectContent().createTemplate(30, 16);
		}


		/**
		 * Fills out the total number of pages before the document is closed.
		 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
		 *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
		 */
		public void onCloseDocument(PdfWriter writer, Document document) {
			ColumnText.showTextAligned(
					total, 
					Element.ALIGN_LEFT,
					new Phrase(String.valueOf(writer.getPageNumber() - 1),fontSmallBold),
					2,2,0
			);
		}




		public void onEndPage(PdfWriter writer, Document document) {
			try {

				com.itextpdf.text.Rectangle page = document.getPageSize();
				PdfPTable head = null;
				//process different header for page 1
				if (writer.getPageNumber()==1) {
					head = doHeader1(); 
					//set top margin for other pages (after page 1 printed)
					pdfDocument.setMargins(
							documenttypedao.getMarginleft().floatValue(),
							documenttypedao.getMarginright().floatValue(), 
							documenttypedao.getMargintop().floatValue(),
							documenttypedao.getMarginbottom().floatValue()
					);
				} else {
					head = doHeader2();
				}

				head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
				head.writeSelectedRows(
						0,							//rowstart
						-1,							//rowend
						document.leftMargin(), 
						page.getHeight() - document.topMargin() + head.getTotalHeight(),
						writer.getDirectContent()
				);


				PdfPTable foot = doFooter(writer);
				foot.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
				foot.writeSelectedRows(
						0, 							// rowstart
						-1, 						// rowend
						document.leftMargin(), 		// xPos
						document.bottomMargin(),	// yPos
						writer.getDirectContent()
				);

			}	
			catch(DocumentException de) {
				throw new ExceptionConverter(de);
			}
		}


		public PdfPTable doFooter(PdfWriter writer) throws DocumentException
		{	


			// create table  		
			PdfPTable _Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);			
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f); 
			_Table1.getDefaultCell().setPadding(0f);

			PdfPCell label =  new PdfPCell();
			label.setBorder(0);


			try {  	


			}
			catch (Exception e) {}

			return _Table1;
		}


		public PdfPTable doHeader1() throws DocumentException
		{

			// create table   		
			PdfPTable _Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);			
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f); 
			_Table1.getDefaultCell().setPadding(0f);



			PdfPCell label =  new PdfPCell();
			label.setBorder(0);


			try {  	


			}
			catch (Exception e) {}

			return _Table1;

		}


		public PdfPTable doHeader2() throws DocumentException
		{
			// create table   		
			PdfPTable _Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);			
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f); 
			_Table1.getDefaultCell().setPadding(0f);



			PdfPCell label =  new PdfPCell();
			label.setBorder(0);


			try {  	


			}
			catch (Exception e) {}

			return _Table1;	
		}


	}







	public void setPrinted(
			User user,
			Map<String, SessionFactory> sessionFactoryClusterMap
	)
	throws Exception {

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				"  setPrinted: " +
				"  id ["+sihdrdao.getSihdrId()+"]"+
				"  user ["+user+"]"				
		);
		this.setSessionFactoryClusterMap(sessionFactoryClusterMap);

		// read header
		SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());


		// do not update printed info if ALREADY PRINTED
		if (!sihdrdao.isPrintedflag()) {
			// update invoice no, print date
			Calendar c = Calendar.getInstance();
			sihdrdao.setPrintdate(c.getTime());
			sihdrdao.setPrinttime(com.bureaueye.beacon.util.Util.toTime(c));
			sihdrdao.setPrintedflag(true);
			String nextDocno = "";
			try {
				nextDocno = new SidocnoBD(this.getSessionFactoryClusterMap()).getNextDocno2(
						"INV",
						sihdrdao.getCompanykey(),//company
						"",//department
						"",//activity
						c.get(Calendar.YEAR),
						user
				);
			} catch (Exception e) {}
			sihdrdao.setInvoiceno(nextDocno);



			//generate posting record===============================================>
			AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
			Aiout aioutdao = new Aiout();
			//retrieve aiout record 
			if (sihdrdao.getAioutId()!=null) {
				try {
					aioutdao = aioutbd.read(sihdrdao.getAioutId()); 
				} catch (Exception e) {}
			}


			try {
				//check not already sent
				if (aioutdao.getSentdate()==null) {
					aioutdao.setDockey(sihdrdao.getInvoiceno());
					aioutdao.setAiid(sihdrdao.getInvoiceno());					
					aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
					aioutdao.setDoctype(com.bureaueye.beacon.bean.Constants.AR_ACTUAL);
					aioutdao.setCompanykey(sihdrdao.getCompanykey());
					aioutdao.setDepartmentkey(sihdrdao.getDepartmentkey());
					aioutdao.setActivitykey(sihdrdao.getActivitykey());
					aioutdao.setWarnings("");					
					aioutdao.setErrors("");
					aioutdao.setDocument("");
					aioutdao.setCompanyid("");						
					aioutdao.setActioncode("");	
					aioutdao.setProcessstatus("");	
					aioutdao.setFilename("");
					aioutdao.setControlid("");					

					// create/update aiout recod
					aioutbd.createOrUpdate(aioutdao, user);

					sihdrdao.setAioutId(aioutdao.getAioutId());
				}
			} catch (Exception e) {
			}
			aioutbd = null;
			//generate posting record===============================================<



			// update header
			sihdrbd.createOrUpdate(sihdrdao, user);



			// update order charges
			Hashtable<Integer,Ordercharge> orderhdrs = new Hashtable<Integer,Ordercharge>();
			OrderchargeBD _orderchargeBD = new OrderchargeBD(this.getSessionFactoryClusterMap());
			Iterator it = _orderchargeBD.findOrderchargesBySihdrId(sihdrdao.getSihdrId()).iterator();
			while (it.hasNext()) {
				// init 
				Ordercharge _orderchargeDAO = (Ordercharge) it.next();
				_orderchargeDAO.setInvoicestatus("PRINTED");
				_orderchargeDAO.setInvoiceno(sihdrdao.getInvoiceno());
				_orderchargeBD.createOrUpdate(_orderchargeDAO, user);

				// compile list to update Order headers information
				if (orderhdrs.get(_orderchargeDAO.getOrderhdrId()) == null) {
					orderhdrs.put(_orderchargeDAO.getOrderhdrId(),_orderchargeDAO);
				}

			} // end list loop	



			// process order headers
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					"  order headers to update: "+orderhdrs.keys().toString());

			for (Enumeration enum2 = orderhdrs.keys(); enum2.hasMoreElements(); ) {
				Integer orderhdrId = (Integer)enum2.nextElement();
				// update header information
				OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
				Orderhdr orderhdrdao = null;
				try{orderhdrdao = orderhdrbd.read(orderhdrId);}catch (Exception e){}
				if (orderhdrdao != null) {
					orderhdrdao.setInvoicestatus(orderhdrbd.getOrderhdrInvoicestatus(sihdrdao.getSihdrId().toString()));
					orderhdrbd.createOrUpdate(orderhdrdao, user);
				}
				orderhdrbd=null;
			}

		}//end of check

		//clear bd
		sihdrbd = null;

	}





}

