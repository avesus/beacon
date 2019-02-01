package com.bureaueye.beacondms.bean.dms.pdf.base;



import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;




import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacondms.bean.dms.base.XmlToPdf;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.exception.dms.BuildException;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
 * Amendments
 * ----------
 * 
 * 	
 */
public final class BuildBASFSoc
{



	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);


	/**
	 */
	//maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;




	public static String errorsPrefix="<errors>";
	public static String errorsSuffix="</errors>";
	public static String errorPrefix="<error>";
	public static String errorSuffix="</error>";


	public static String warningsPrefix="<warnings>";
	public static String warningsSuffix="</warnings>";
	public static String warningPrefix="<warning>";
	public static String warningSuffix="</warning>";
	public static String idPrefix="<id>";
	public static String idSuffix="</id>";
	public static String fieldPrefix="<field>";
	public static String fieldSuffix="</field>";
	public static String msgPrefix="<msg>";
	public static String msgSuffix="</msg>";


	public static String documentPrefix="<document>";
	public static String documentSuffix="</document>";
	public static String headerPrefix="<header>";
	public static String headerSuffix="</header>";	
	public static String detailPrefix="<detail>";
	public static String detailSuffix="</detail>";


	com.itextpdf.text.Document pdfDocument;
	org.w3c.dom.Document domDocument; 
	org.w3c.dom.Element elementDocument; 
	private PdfPTable _Table1;

	XmlToPdf xmlToPdf; 


	String waterMarkText;

	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;			
	Font fontBoldUnderline;	
	Font fontRed;





	CompanyBD companybd;	
	CompanyheaderBD companyheaderbd;
	PropertyResourceBundle resourceProps;
	int orderCount;




	public void build(
			Xdocument xdocumentdao,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) throws BuildException {	


		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("["+this.getClass().getName()+"] Run at: "+cal.getTime());	


		//init BD
		DocumenttypeBD documenttypebd = new DocumenttypeBD(sessionFactoryClusterMap);
		SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);		

		companybd = new CompanyBD(sessionFactoryClusterMap);	
		companyheaderbd = new CompanyheaderBD(sessionFactoryClusterMap);		


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



		//get Document Type  
		//- pagesize
		//- font
		//- build class
		//- margins
		//- language
		Documenttype documenttypedao = null;
		try {
			documenttypedao = documenttypebd.findDocumenttypeByDoctype(xdocumentdao.getDoctype());
		} catch (ApplicationException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttypeByDoctype: ApplicationException: "+e.getMessage());				
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttypeByDoctype: Exception: "+e.getMessage());							
		}




		//init document resource by languageid
		String resourceName="com.bureaueye.beacondms.DocumentResources_"+documenttypedao.getLanguageid();
		resourceProps = (PropertyResourceBundle) ResourceBundle.getBundle(resourceName);	





		log.info("["+this.getClass().getName()+"] "+new Date()+" Build Document: "+xdocumentdao.getDockey());








		try {


			//parse XML document
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			domDocument = dBuilder.parse(
					new org.xml.sax.InputSource(
							new java.io.StringReader(xdocumentdao.getXmldocument().toString())
					)
			);
			domDocument.getDocumentElement().normalize();

			elementDocument=(org.w3c.dom.Element) domDocument.getElementsByTagName("Document").item(0);


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
			fontBoldUnderline = new Font(font.getFamily(), font.getSize(), Font.UNDERLINE | Font.BOLD);
			fontRed= new Font(font.getFamily(), font.getSize(), font.getStyle());
			fontRed.setColor(new BaseColor(Color.RED));			



			//set page count
			pdfDocument.setPageCount(1);


			//generate print file
			String printFilename = "";															
			printFilename = workDirectory+"\\"+xdocumentdao.getXdocumentId()+".pdf";
			FileOutputStream fileOutputStream = new FileOutputStream(printFilename);
			PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, fileOutputStream);


			//init end page event
			org.w3c.dom.Element elementOrdhdr1 = null;
			org.w3c.dom.Element deptcode = null;			
			elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
			deptcode = (org.w3c.dom.Element)elementOrdhdr1.getElementsByTagName("deptcode").item(0);	

			String deptcode_compcode=getTagValue("compcode",deptcode);			
			Company companydao = null;
			try {
				companydao = companybd.read(deptcode_compcode);
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" find company: ApplicationException: "+e.getMessage());				
			}
			Companyheader companyheaderdao =null;
			try {
				companyheaderdao = companyheaderbd.read(companydao.getCompanyheaderId());
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" find companyheader: ApplicationException: "+e.getMessage());				
			} 



			//init title						
			String title="";


			//set page event
			pdfWriter.setPageEvent(
					new HeaderFooterPageEvent(
							companyheaderdao,
							documenttypedao,
							elementDocument,
							title
					)
			);


			//set template specification
			xmlToPdf = new XmlToPdf(
					companyheaderdao,
					documenttypedao,
					elementDocument					
			);





			pdfDocument.open();	


			// create main table and add it to the document   		  		
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);			
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f); 
			_Table1.getDefaultCell().setPadding(0f);



			//header
			doHeader();


			//body
			doBody1(companyheaderdao);


			//body
			doBody2();			


			//body
			doBody3();			


			//footer
			doFooter(companyheaderdao);


			// add main table to PDF document
			pdfDocument.add(_Table1);  	


		} catch (BuildException e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+" Build Document: BuildException: "+e.getCode());
			throw new BuildException(BuildException.GENERAL_FAILURE);	
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+" Build Document: Exception: "+e.getMessage());
			throw new BuildException(BuildException.GENERAL_FAILURE);	
		}


		pdfDocument.close();	


		// clean-up
		documenttypebd = null;
		systemcodebd = null;
		companybd = null;
		companyheaderbd = null;


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





	public void doHeader() throws DocumentException, BadElementException, Exception
	{
	}


	public void doBody1(
			Companyheader companyHeader
	) throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;

		org.w3c.dom.Element elementProdcode = null;
		org.w3c.dom.Element elementOrdprod10 = null;
		org.w3c.dom.Element elementOrdprod10Prodcode= null;


		org.w3c.dom.Element elementUnitkey=null;

		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);

		try{elementUnitkey=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("unitkey").item(0);}catch(Exception e){}


		try{elementProdcode=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("prodcode").item(0);}catch(Exception e){}
		try{elementOrdprod10=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordprod10").item(0);}catch(Exception e){}
		try{elementOrdprod10Prodcode=(org.w3c.dom.Element) elementOrdprod10.getElementsByTagName("prodcode").item(0);}catch(Exception e){}




		PdfPCell label =  new PdfPCell();
		label.setBorder(0);

		try {

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);	

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.2f, 0.8f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.shipmentfrom"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("BASF SE, D-67056 Ludwigshafen",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(" ",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("or.....................................",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.consigneecountry"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("BASF Corp.../...USA.........",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.shippingorderno"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("2......................................",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.deliveryno"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("308..................................",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.customerorderno"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("cusref",elementOrdhdr1),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(5f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.2f, 0.8f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.productname"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("tradname",elementProdcode),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(5f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.2f, 0.15f, 0.15f, 0.15f, 0.2f, 0.15f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.unnumber"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(xmlToPdf.unRule(elementOrdprod10Prodcode),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.class"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("Class",elementOrdprod10Prodcode),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.packaginggroup"),fontBold));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("packgrp",elementOrdprod10Prodcode),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.15f, 0.25f, 0.05f, 0.05f, 0.05f, 0.05f, 0.1f, 0.05f, 0.05f, 0.1f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("Transport Mode",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("(Main Leg or Direct Transport):",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("Road",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);			
			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("Rail",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);		
			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("River Barge",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("Sea",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			//label.setPhrase(new Phrase(String.valueOf((char)110), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));		
			label.setPhrase(new Phrase("X",fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(5f);
			_Table1.addCell(cellBlank);	

		} catch (Exception e) {
		}


		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("We hereby declare that the deployed Tank with ", font);
			Chunk c2 = new Chunk("Serial Number  ", fontBold);
			Chunk c3 = new Chunk(xmlToPdf.unitkeyRule1(elementUnitkey),fontRed);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);

			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

		} catch (Exception e) {
		}



		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("and ", font);
			Chunk c2 = new Chunk("Type Approval Certificate_______________________________ ", fontBold);
			Chunk c3 = new Chunk("compiles with the following Tank Codes:",font);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);			

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.2f, 0.05f, 0.75f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			//label.setPhrase(new Phrase(String.valueOf((char)110), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));
			label.setPhrase(new Phrase("X",fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("Portable Tank T11",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));	
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("ADR Tank",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			label.setPhrase(new Phrase("and/or is licensed as ",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));	
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("IMO Tank-Type",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.10f, 0.08f, 0.82f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("The Tank is ", font);
			Chunk c2 = new Chunk("marked ", fontBold);
			Chunk c3 = new Chunk("with the Tank Code listed above.",font);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);		
			
			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

		} catch (Exception e) {
		}




	}


	public void doBody2() throws DocumentException, BadElementException,  Exception
	{




		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		try {

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);	

		} catch (Exception e) {
		}


		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("Road, Rail and/or River Barge Transports",fontBoldUnderline));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("The Portable Tank respectively ADR tank complies with the requirements according to",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("ADR/RID Chapter 3.2 Table A ",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}

		try {
			float[] widths = {0.15f, 0.85f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("X",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			Chunk c1 = new Chunk("Tank Code ... ", fontBold);
			Chunk c2 = new Chunk("according to Column ", font);
			Chunk c3 = new Chunk("10 ",fontBold);
			Chunk c4 = new Chunk("and the ", font);
			Chunk c5 = new Chunk("Special Provisions ",fontBold);
			Chunk c6 = new Chunk("of Column ", font);
			Chunk c7 = new Chunk("11 ",fontBold);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			p1.add(c5);
			p1.add(c6);
			p1.add(c7);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("or",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("X",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("Tank Code ... ", fontBold);
			c2 = new Chunk("according to Column ", font);
			c3 = new Chunk("12 ",fontBold);
			c4 = new Chunk("with a ", font);
			c5 = new Chunk("Design Pressure ",fontBold);
			c6 = new Chunk("of 6 bar and the ", font);
			p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			p1.add(c5);
			p1.add(c6);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("Special Provisions ", fontBold);
			c2 = new Chunk("of Column ", font);
			c3 = new Chunk("13 ",fontBold);
			p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	
			
			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}



		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}



		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("Maritime Transports",fontBoldUnderline));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("The Portable Tank complies with the requirements of",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}

		try {
			float[] widths = {0.15f, 0.85f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("X",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			Chunk c1 = new Chunk("Tank Code T 11 ", fontBold);
			Chunk c2 = new Chunk("according to Column ", font);
			Chunk c3 = new Chunk("13 IMDG Code, Chapter 3.2",fontBold);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("and the ", font);
			c2 = new Chunk("Special Provisions ", fontBold);
			c3 = new Chunk("of Column ",font);
			Chunk c4 = new Chunk("14.",fontBold);
			p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}


		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}




		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("For ", font);
			Chunk c2 = new Chunk("IMO Tank Type",fontBoldUnderline);
			Chunk c3 = new Chunk(" the ",font);
			Chunk c4 = new Chunk("Transitional Measures for IMO Tanks according to 4.2.0.1 IMDG Code ",fontBold);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("apply. The IMO Tank complies with the requirements of ",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}


		try {
			float[] widths = {0.15f, 0.85f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));	
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			Chunk c1 = new Chunk("Portable Tanks T ", fontBold);
			Chunk c2 = new Chunk("according to Column ",font);
			Chunk c3 = new Chunk("13 IMDG Code, Chapter 3.2 ",fontBold);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("and the ", font);
			c2 = new Chunk("Special Provisions ",fontBold);
			c3 = new Chunk("of Column ",font);
			Chunk c4 = new Chunk("14.",fontBold);
			p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}



	}


	public void doBody3() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementUnitkey=null;
		org.w3c.dom.Element elementOrdhdr1 = null;

		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
		try{elementUnitkey=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("unitkey").item(0);}catch(Exception e){}
		

		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}
		

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("The Tank was ", font);
			Chunk c2 = new Chunk("manufactured ",fontBold);
			Chunk c3 = new Chunk("in ______________ (MM/YYYY)",font);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}
		
		
		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}
		

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("Next ", font);
			Chunk c2 = new Chunk("Tank Inspection ",fontBold);
			Chunk c3 = new Chunk("before:  ",font);
			Chunk c4 = new Chunk(xmlToPdf.formatDate(getTagValue("next_test_due",elementUnitkey)),fontRed);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			p1.add(c4);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}
		

		
		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}
		

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//compile phrase
			Chunk c1 = new Chunk("The ", font);
			Chunk c2 = new Chunk("Statutory Inspection Periods ",fontBold);
			Chunk c3 = new Chunk("have not expired.",font);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("The ", font);
			c2 = new Chunk("Gaskets ",fontBold);
			c3 = new Chunk("in place meet the requirements stipulated in the Shipping Order.",font);
			p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}
	
		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}

		try {
			float[] widths = {0.05f, 0.95f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(String.valueOf((char)113), new Font(Font.FontFamily.ZAPFDINGBATS, 10)));	
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			//compile phrase
			Chunk c1 = new Chunk("The ", font);
			Chunk c2 = new Chunk("Transitional Measures / Exemptions ",fontBold);
			Chunk c3 = new Chunk("according to Article 4.2.0.1. of ",font);
			Phrase p1 = new Phrase();
			p1.add(c1);
			p1.add(c2);
			p1.add(c3);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			label.setPhrase(new Phrase(" ",font));
			label.setHorizontalAlignment(Element.ALIGN_CENTER);
			wrapper.addCell(label);

			//compile phrase
			c1 = new Chunk("Dangerous Goods Provision  (e. g. ADR, IMDG Code, GGAV) apply.", font);
			p1 = new Phrase();
			p1.add(c1);
			
			label.setPhrase(p1);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);	

		} catch (Exception e) {
		}
		
		

	}


	public void doFooter(
			Companyheader companyHeader			
	) throws DocumentException, BadElementException, Exception
	{

		org.w3c.dom.Element elementParamdetails=null;
		elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);	


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		try {	
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}

		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("Authorized Signature/Company Stamp",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(5f);
			_Table1.addCell(cellBlank);	
			
		} catch (Exception e) {
		}


		try {
			float[] widths = {0.06f, 0.24f, 0.1f, 0.10f, 0.2f, 0.30f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.name"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("UserName",elementParamdetails),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.place"),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(companyHeader.getCity(),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.date"),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(Util.dateTextFormat(new Date()),fontRed));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);			

		} catch (Exception e) {
		}






		try {
			float[] widths = {0.3f, 0.3f, 0.3f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);


			//signature image 
			Image sigImage = Image.getInstance(companyHeader.getSignatureimage());
			sigImage.scalePercent(75f);
			PdfPCell labelImage =  new PdfPCell(sigImage);
			labelImage.setBorder(0);
			labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(labelImage);


			//logo image
			Image logoImage = Image.getInstance(companyHeader.getLogo());
			logoImage.scalePercent(45f);
			labelImage =  new PdfPCell(logoImage);
			labelImage.setBorder(0);
			labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(labelImage);


			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);



			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);

		} catch (Exception e) {
		}



	} 





	private static String getTagValue(String sTag, org.w3c.dom.Element eElement){
		String returnValue="";
		try {
			org.w3c.dom.NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
			org.w3c.dom.Node nValue = (org.w3c.dom.Node) nlList.item(0); 
			returnValue=nValue.getNodeValue(); 
		} catch (Exception e) {
		}		
		return returnValue;    
	}



	public static String setWarning(String id, String field, String msg) 
	{	
		String _warning ="";
		_warning = 
			warningPrefix+
			idPrefix+
			"<![CDATA["+id+"]]>"+
			idSuffix+
			fieldPrefix+
			"<![CDATA["+field+"]]>"+
			fieldSuffix+
			msgPrefix+
			"<![CDATA["+msg+"]]>"+
			msgSuffix+
			warningSuffix;

		return _warning; 	
	}



	public static String setError(String id, String field, String msg) 
	{	
		String _error ="";
		_error = 
			errorPrefix+
			idPrefix+
			"<![CDATA["+id+"]]>"+
			idSuffix+
			fieldPrefix+
			"<![CDATA["+field+"]]>"+
			fieldSuffix+
			msgPrefix+
			"<![CDATA["+msg+"]]>"+
			msgSuffix+
			errorSuffix;

		return _error; 	
	}










	//WE NEEDED TO INCLUDE THIS CLASS HERE AS THE PROGRAM 
	//AS WE NEED TO RESET THE MARGIN SETTINGS FOR PDF DOCUMENT 
	//TO HAVE A LARGER HEADER FOR PAGE 1
	public class HeaderFooterPageEvent extends PdfPageEventHelper {

		org.w3c.dom.Element elementDocument;
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
		Font fontBoldHugeLightgray;


		public HeaderFooterPageEvent(
				Companyheader header,
				Documenttype documenttypedao,
				org.w3c.dom.Element element,
				String title
		) throws BuildException {

			try{
				this.companyHeader = header;
				this.elementDocument = element;
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
				fontBoldLarge = new Font(font.getFamily(), font.getSize()+3, fontBold.getStyle());
				fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
				fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
				fontBoldHugeLightgray = new Font(font.getFamily(), font.getSize()+60, fontBold.getStyle());
				fontBoldHugeLightgray.setColor(new BaseColor(Color.LIGHT_GRAY));

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


				//add watermark
				ColumnText.showTextAligned(
						writer.getDirectContentUnder(),
						Element.ALIGN_CENTER, 
						new Phrase(waterMarkText, fontBoldHugeLightgray),
						297.5f, 
						421, 
						writer.getPageNumber() % 2 == 1 ? 45 : -45
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

				float[] widths = {0.5f, 0.5f};
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(String.format("Page %d of", writer.getPageNumber()),fontSmallBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				label.setVerticalAlignment(Element.ALIGN_BOTTOM);
				wrapper.addCell(label);

				PdfPCell labelImage =  new PdfPCell(Image.getInstance(total));  
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
				label.setVerticalAlignment(Element.ALIGN_BOTTOM);
				wrapper.addCell(labelImage);

				_Table1.addCell(wrapper);


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



			//TITLE
			try {	


				PdfPTable _text =  new PdfPTable(1);
				_text.getDefaultCell().setBorder(0);

				label.setPhrase(new Phrase(resourceProps.getString("title.basfstatement1"),fontBoldLarge));
				label.setHorizontalAlignment(Element.ALIGN_CENTER); 	
				_text.addCell(label);  

				label.setPhrase(new Phrase(resourceProps.getString("title.basfstatement2"),fontBoldLarge));
				label.setHorizontalAlignment(Element.ALIGN_CENTER); 	
				_text.addCell(label);  

				PdfPCell cell = new PdfPCell(_text);
				//cell.setBackgroundColor(colorLinen);
				cell.setBorderWidthLeft(0.1f);
				cell.setBorderWidthBottom(0.1f);
				cell.setBorderWidthRight(0.1f);
				cell.setBorderWidthTop(0.1f);
				cell.setBorderColorLeft(BaseColor.WHITE);
				cell.setBorderColorBottom(BaseColor.WHITE);
				cell.setBorderColorRight(BaseColor.WHITE);
				cell.setBorderColorTop(BaseColor.WHITE);

				_Table1.addCell(cell);		


			} catch (Exception e) {
			}


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


			//TITLE
			try {	


				PdfPTable _text =  new PdfPTable(1);
				_text.getDefaultCell().setBorder(0);

				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.basfstatement1")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_CENTER); 	
				_text.addCell(label);  

				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.basfstatement2")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_CENTER); 	
				_text.addCell(label);  

				PdfPCell cell = new PdfPCell(_text);
				//cell.setBackgroundColor(colorLinen);
				cell.setBorderWidthLeft(0.1f);
				cell.setBorderWidthBottom(0.1f);
				cell.setBorderWidthRight(0.1f);
				cell.setBorderWidthTop(0.1f);
				cell.setBorderColorLeft(BaseColor.WHITE);
				cell.setBorderColorBottom(BaseColor.WHITE);
				cell.setBorderColorRight(BaseColor.WHITE);
				cell.setBorderColorTop(BaseColor.WHITE);

				_Table1.addCell(cell);		


			} catch (Exception e) {
			}


			return _Table1;
		}



	}





}
