package com.bureaueye.beacondms.bean.dms.pdf.base;



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
public final class BuildDisbursementSummary
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


	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;			






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


			String title="DISBURSEMENT SUMMARY";

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
			doBody1(title);


			int count = 1;

			DETAIL_LOOP2:
				while (true) {
					org.w3c.dom.Element elementPidtlcost = 
						(org.w3c.dom.Element)elementOrdhdr1.getElementsByTagName("accountspayable"+count).item(0);
					if (elementPidtlcost==null) break DETAIL_LOOP2;
					doDetail(elementPidtlcost, count);
					count++;
				} // report details loop


			//body
			doBody2();			

			//footer
			doFooter();

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
		//header code in EndPageHeaderFooter PDF
	}


	public void doBody1(String title) throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;
		org.w3c.dom.Element elementDespmovshipping = null;
		org.w3c.dom.Element elementDespmovshippingFraddrkey = null;
		org.w3c.dom.Element elementCustomer= null;
		org.w3c.dom.Element elementDespmovshippingVessel= null;		

		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
		try{elementDespmovshipping=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("despmovshipping").item(0);}catch(Exception e){}
		try{elementDespmovshippingFraddrkey=(org.w3c.dom.Element) elementDespmovshipping.getElementsByTagName("fraddrkey").item(0);}catch(Exception e){}
		try{elementDespmovshippingVessel=(org.w3c.dom.Element) elementDespmovshipping.getElementsByTagName("vessel").item(0);}catch(Exception e){}

		try{elementCustomer=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("customer").item(0);}catch(Exception e){}



		BaseColor colorLinen = new BaseColor(240,240,230);


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		try {
			float[] widths = {0.65f, 0.1f, 0.25f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.date")+":",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(Util.dateTextFormat2(new Date()),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);				
		} catch (Exception e) {
		}


		try {
			float[] widths = {0.65f, 0.1f, 0.25f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);
			
			label.setPhrase(new Phrase("Owners and/or Charterers:",font));
			wrapper.addCell(label);
			label.setPhrase(new Phrase("Order:",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("ordno",elementOrdhdr1),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			
			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);				
		} catch (Exception e) {
		}


		try {
			float[] widths = {0.1f, 0.9f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							getTagValue("name",elementCustomer),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							getTagValue("addr1",elementCustomer),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							getTagValue("addr2",elementCustomer),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);			

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							getTagValue("addr3",elementCustomer),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							getTagValue("addr4",elementCustomer),
							font
					)
			);
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
			float[] widths = {0.35f, 0.3f, 0.35f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(getTagValue("vesselname",elementDespmovshippingVessel)+" VOY "+getTagValue("voyage",elementDespmovshipping),font)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);			
			label.setPhrase(new Phrase("",font));			
			wrapper.addCell(label);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("name",elementDespmovshippingFraddrkey)+", "+getTagValue("addr1",elementDespmovshippingFraddrkey),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);				

		} catch (Exception e) {
		}



		try {
			float[] widths = {0.35f, 0.1f, 0.2f, 0.35f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.from")+":",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							xmlToPdf.formatDate(getTagValue("frdate",elementDespmovshipping)),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);

			label.setPhrase(new Phrase("",font));
			wrapper.addCell(label);	
			label.setPhrase(new Phrase(resourceProps.getString("prompt.to")+":",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(
							xmlToPdf.formatDate(getTagValue("todate",elementDespmovshipping)),
							font
					)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
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



		try {
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("",fontBoldLarge));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_MIDDLE);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(title,fontBoldLarge));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_MIDDLE);
			wrapper.addCell(label);

			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setFixedHeight(20f);
			wrapperCell.setBorder(0);
			//wrapperCell.setBackgroundColor(colorLinen);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(5f);
			_Table1.addCell(cellBlank);					

		} catch (Exception e) {
		}



		try {
			float[] widths = {0.36f, 0.32f, 0.32f};
			PdfPTable _wrapper = new PdfPTable(widths);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	



			label.setPhrase(new Phrase("Vendor",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			_wrapper.addCell(label);




			label.setPhrase(new Phrase("Description",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			_wrapper.addCell(label);




			//label.setPhrase(new Phrase("Amount (USD)",fontBold));
			label.setPhrase(new Phrase("Amount ("+getTagValue("ordccykey",elementOrdhdr1)+")",fontBold));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_wrapper.addCell(label);



			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(_wrapper);
			wrapperCell.setBackgroundColor(colorLinen);
			wrapperCell.setBorder(0);
			_Table1.addCell(wrapperCell);




		} catch (Exception e) {
		}



	}


	public void doBody2() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;
		org.w3c.dom.Element elementCustomer = null;

		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
		try{elementCustomer=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("customer").item(0);}catch(Exception e){}


		BaseColor colorLinen = new BaseColor(240,240,230);

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
			float[] widths = {0.78f, 0.32f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase("Total:",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("accountspayabletotal",elementOrdhdr1),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("W.S.I. CASH ADVANCE:",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("accountsreceivabletotal",elementOrdhdr1),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);

			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("",font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);	

			if (getTagValue("balancedueto",elementOrdhdr1).equals("CUSTOMER")) {
				label.setPhrase(new Phrase(
						"Balance due "+getTagValue("name",elementCustomer)+" ("+
						getTagValue("ordccykey",elementOrdhdr1)+" Funds):",font)
				);				
				//label.setPhrase(new Phrase("Balance due "+getTagValue("name",elementCustomer)+" (U.S. Funds):",font));			
			}
			else {
				//label.setPhrase(new Phrase("Balance due World Shipping, Inc. (U.S. Funds):",font));				
				label.setPhrase(new Phrase("Balance due World Shipping, Inc. ("+
						getTagValue("ordccykey",elementOrdhdr1)+" Funds):",font));	
			}
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("actualsbalancetotal",elementOrdhdr1),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			wrapper.addCell(label);


			PdfPCell wrapperCell =  new PdfPCell();			
			wrapperCell = new PdfPCell(wrapper);
			wrapperCell.setBorder(0);
			wrapperCell.setBackgroundColor(colorLinen);
			_Table1.addCell(wrapperCell);

			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0); 
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(20f);
			_Table1.addCell(cellBlank);					

		} catch (Exception e) {
		}


	}


	public void doDetail(
			org.w3c.dom.Element element,
			int count
	) throws DocumentException, BadElementException,  Exception
	{


		org.w3c.dom.Element elementVendor = null;		
		try{elementVendor=(org.w3c.dom.Element) element.getElementsByTagName("vendor").item(0);}catch(Exception e){}


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);



		try {

			float[] widths = {0.36f, 0.32f, 0.32f};
			PdfPTable _wrapper = new PdfPTable(widths);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	



			label.setPhrase(new Phrase(getTagValue("name",elementVendor),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			_wrapper.addCell(label);


			label.setPhrase(new Phrase(getTagValue("txt",element),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			_wrapper.addCell(label);


			label.setPhrase(new Phrase(getTagValue("amount",element),font));
			label.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_wrapper.addCell(label);



			PdfPCell _wrapperCell7 =  new PdfPCell();			
			_wrapperCell7 = new PdfPCell(_wrapper);
			_wrapperCell7.setBorder(0);
			_Table1.addCell(_wrapperCell7);


		} catch (Exception e) {
		}	


	}   


	public void doFooter() throws DocumentException, BadElementException, Exception
	{
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


			org.w3c.dom.Element elementOrdhdr1 = null;
			org.w3c.dom.Element elementCustomer= null;

			elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
			try{elementCustomer=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("customer").item(0);}catch(Exception e){}



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
				float[] widths = {0.35f, 0.65f};
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				//only display payment instructions if balance due to company
				if (getTagValue("balancedueto",elementOrdhdr1).equals("COMPANY")) {
					label.setPhrase(new Phrase("For Wire Transfers: Please send to:",font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase(getTagValue("paymenttoinstructions",elementCustomer),font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);		
				} else {
					label.setPhrase(new Phrase("",font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("",font));
					wrapper.addCell(label);						
				}

				PdfPCell wrapperCell =  new PdfPCell();			
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);
				_Table1.addCell(wrapperCell);



				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0); 
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(20f);
				_Table1.addCell(cellBlank);	

			} catch (Exception e) {
			}


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


			try {

				float[] widths = {0.3f, 0.3f, 0.3f};
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				//logo
				Image logoImage = Image.getInstance(companyHeader.getLogo());
				logoImage.scalePercent(45f);
				PdfPCell labelImage =  new PdfPCell(logoImage);
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(labelImage);



				//sub-table for address
				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper2.setSpacingAfter(0f);
				wrapper2.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getCompanyName(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getAddress(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getCityPostalcode(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);			
				label.setPhrase(new Phrase("",font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);

				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);			


				//sub-table for contact info
				PdfPTable wrapper3 = new PdfPTable(1);
				wrapper3.setSpacingAfter(0f);
				wrapper3.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getOfficename(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getPhone(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getWebsite(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);			
				label.setPhrase(new Phrase("",font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);

				PdfPCell wrapperCell3 =  new PdfPCell();			
				wrapperCell3 = new PdfPCell(wrapper3);
				wrapperCell3.setBorder(0);
				wrapper.addCell(wrapperCell3);	


				PdfPCell wrapperCell =  new PdfPCell();			
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);
				_Table1.addCell(wrapperCell);

				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0); 
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(20f);
				_Table1.addCell(cellBlank);

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


			try {

				float[] widths = {0.3f, 0.3f, 0.3f};
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				//logo
				Image logoImage = Image.getInstance(companyHeader.getLogo());
				logoImage.scalePercent(45f);
				PdfPCell labelImage =  new PdfPCell(logoImage);
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(labelImage);



				//sub-table for address
				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper2.setSpacingAfter(0f);
				wrapper2.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getCompanyName(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getAddress(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getCityPostalcode(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);			
				label.setPhrase(new Phrase("",font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);

				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);			


				//sub-table for contact info
				PdfPTable wrapper3 = new PdfPTable(1);
				wrapper3.setSpacingAfter(0f);
				wrapper3.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getOfficename(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getPhone(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getWebsite(),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);			
				label.setPhrase(new Phrase("",font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);

				PdfPCell wrapperCell3 =  new PdfPCell();			
				wrapperCell3 = new PdfPCell(wrapper3);
				wrapperCell3.setBorder(0);
				wrapper.addCell(wrapperCell3);	


				PdfPCell wrapperCell =  new PdfPCell();			
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);
				_Table1.addCell(wrapperCell);

				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0); 
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(20f);
				_Table1.addCell(cellBlank);

			} catch (Exception e) {
			}

			return _Table1;
		}



	}





}
