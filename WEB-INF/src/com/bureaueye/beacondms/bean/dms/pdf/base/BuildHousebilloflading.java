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
public final class BuildHousebilloflading
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



			// set Watermark - if DRAFT
			if (documenttypedao.getDoctype().equals("HBLDRFT")) {
				waterMarkText=resourceProps.getString("title.draft");
			}



			pdfDocument.open();	


			// create main table and add it to the document   		
			float[] widths = {0.5f, 0.5f};    		
			_Table1 = new PdfPTable(widths);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);			
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f); 
			_Table1.getDefaultCell().setPadding(0f);


			orderCount = 1;
			DETAIL_LOOP1:
				while (true) {
					org.w3c.dom.Element elementOrdhdr = (org.w3c.dom.Element)elementDocument.getElementsByTagName("Ordhdr"+orderCount).item(0);
					if (elementOrdhdr==null) break DETAIL_LOOP1;
					orderCount++;
				} // report details loop
			orderCount--;//subtract the last increment


			//header
			doHeader();

			//body
			doBody1();

			//init space for all detail lines
			int detailHeight = 180;
			int count = 1;
			DETAIL_LOOP2:
				while (true) {
					org.w3c.dom.Element elementOrdhdr = (org.w3c.dom.Element)elementDocument.getElementsByTagName("Ordhdr"+count).item(0);
					if (elementOrdhdr==null) break DETAIL_LOOP2;
					doDetail(elementOrdhdr, count);
					count++;
					//subtract detail line height
					detailHeight=detailHeight-20;
				} // report details loop

			
			//output space left for detail lines
			doBody2(detailHeight);			
			
			
			//body
			doBody3();			

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
	}


	public void doBody1() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;

		org.w3c.dom.Element elementDespmovselected = null;
		org.w3c.dom.Element elementOrdlogis05= null;//shipper
		org.w3c.dom.Element elementOrdlogis06= null;//consignee
		org.w3c.dom.Element elementOrdlogis03= null;//fwd agent


		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);

		try{elementOrdlogis05=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordlogis05").item(0);}catch(Exception e){}
		try{elementOrdlogis06=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordlogis06").item(0);}catch(Exception e){}
		try{elementOrdlogis03=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordlogis03").item(0);}catch(Exception e){}


		try{elementDespmovselected=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("despmovSELECTED").item(0);}catch(Exception e){}




		PdfPCell _label =  new PdfPCell();
		_label.setBorder(0);


		PdfPCell cellBlank = new PdfPCell();
		cellBlank.setBorder(0); 
		cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellBlank.setFixedHeight(10f);
		cellBlank.setColspan(2);
		_Table1.addCell(cellBlank);	





		try {


			//SHIPPER			
			PdfPCell cell =  new PdfPCell();						
			cell = new PdfPCell(
					xmlToPdf.getAddress(resourceProps.getString("prompt.shipper"), elementOrdlogis05)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);



			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			//delivery terms...		
			PdfPTable _text =  new PdfPTable(2);
			_text.getDefaultCell().setBorder(0);

			_label.setPhrase(new Phrase(resourceProps.getString("prompt.deliveryterms"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);  

			_label.setPhrase(new Phrase(resourceProps.getString("prompt.blno"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);  

			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);

			_label.setPhrase(new Phrase(getTagValue("consignment_num",elementOrdhdr1)+" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);

			cell = new PdfPCell(_text);
			cell.setFixedHeight(40f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			wrapper.addCell(cell);		




			//export ref...		
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			_label.setPhrase(new Phrase(resourceProps.getString("prompt.exportref"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);  

			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);

			cell = new PdfPCell(_text);
			cell.setFixedHeight(20f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			wrapper.addCell(cell);		


			//origin of goods...		
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			_label.setPhrase(new Phrase(resourceProps.getString("prompt.originofgoods"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);  

			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(_label);

			cell = new PdfPCell(_text);
			cell.setFixedHeight(20f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			wrapper.addCell(cell);	



			_Table1.addCell(wrapper);

		} catch (Exception e) {
		}







		try {	

			//CONSIGNEE			
			PdfPCell cell =  new PdfPCell();						
			cell = new PdfPCell(
					xmlToPdf.getAddressWithVat(resourceProps.getString("prompt.consignee"), elementOrdlogis06)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);
			

			//forwarding agent...	
			cell =  new PdfPCell();						
			cell = new PdfPCell(
					xmlToPdf.getAddressWithVat(resourceProps.getString("prompt.forwardingagent"), elementOrdlogis03)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);

		} catch (Exception e) {
		}





		try {	

			//NOTIFY PARTY...		
			PdfPCell cell =  new PdfPCell();						
			cell = new PdfPCell(
					xmlToPdf.getAddressWithVat(resourceProps.getString("prompt.notifypartyaddress"), elementOrdlogis06)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);
			

			//2nd NOTIFY PARTY...
			cell =  new PdfPCell();						
			cell = new PdfPCell(
					xmlToPdf.getAddressWithVat(resourceProps.getString("prompt.2ndnotifyparty"), elementOrdlogis03)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);

		} catch (Exception e) {
		}





		//place of receipt....
		try {

			//titles
			PdfPTable _wrapper = new PdfPTable(2);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 
			_wrapper.getDefaultCell().setBorderColor(new BaseColor(Color.TRANSLUCENT));
			_wrapper.getDefaultCell().setBorderColorTop(new BaseColor(Color.BLACK));		

			//
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			PdfPCell _wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.placeofreceipt"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			PdfPCell _wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(1);
			_Table1.addCell(_wrapperCell1);  



			//dummy cells
			_wrapper = new PdfPTable(1);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);			
			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);



			//details
			_wrapper = new PdfPTable(2);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 		

			//
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(xmlToPdf.getToaddr(elementDespmovselected)+" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);



			//dummy cells
			_wrapper = new PdfPTable(1);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);			
			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);


		} catch (Exception e) {
		}










		//vessel/voyage....
		try {

			//titles
			PdfPTable _wrapper = new PdfPTable(2);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 
			_wrapper.getDefaultCell().setBorderColor(new BaseColor(Color.TRANSLUCENT));
			_wrapper.getDefaultCell().setBorderColorTop(new BaseColor(Color.BLACK));		

			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.oceanvessel"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			PdfPCell _wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.portofloading"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			PdfPCell _wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(1);
			_Table1.addCell(_wrapperCell1);  



			//dummy cells
			_wrapper = new PdfPTable(1);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);			
			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);




			//details
			_wrapper = new PdfPTable(2);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 		

			//
			_label.setPhrase(new Phrase(xmlToPdf.getVesselVoyage(elementDespmovselected)+" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);

			//
			_label.setPhrase(new Phrase(xmlToPdf.getFraddr(elementDespmovselected)+" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);

			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);



			//dummy cells
			_wrapper = new PdfPTable(1);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);			
			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);


		} catch (Exception e) {
		}





		//pod, place of delivery, freight payable at, number of....
		try {

			//titles
			PdfPTable _wrapper = new PdfPTable(4);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 
			_wrapper.getDefaultCell().setBorderColor(new BaseColor(Color.TRANSLUCENT));
			_wrapper.getDefaultCell().setBorderColorTop(new BaseColor(Color.BLACK));		

			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.portofdischarge"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			PdfPCell _wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.placeofdelivery"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.freightpayableat"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(resourceProps.getString("prompt.numberoforiginalbillsoflading"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			PdfPCell _wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setColspan(2);
			_wrapperCell1.setBorder(1);
			_Table1.addCell(_wrapperCell1);  



			//details
			_wrapper = new PdfPTable(4);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 		

			//
			_label.setPhrase(new Phrase(xmlToPdf.getFraddr(elementDespmovselected)+" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			//
			_label.setPhrase(new Phrase(" ",fontSmall));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				
			_wrapperCell = new PdfPCell(_label);	
			_wrapper.addCell(_wrapperCell);


			_wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setColspan(2);
			_wrapperCell1.setBorder(0);
			_Table1.addCell(_wrapperCell1);


		} catch (Exception e) {
		}










		//detail headers....
		try {
			PdfPTable _wrapper = new PdfPTable(3);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	 
			_wrapper.getDefaultCell().setBorderColor(new BaseColor(Color.TRANSLUCENT));
			_wrapper.getDefaultCell().setBorderColorTop(new BaseColor(Color.BLACK));		

			//tank container
			_label.setPhrase(new Phrase(resourceProps.getString("heading.marksandnos"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	 	   								               				

			PdfPCell _wrapperCell1 = new PdfPCell(_label);	
			_wrapperCell1.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell1);


			//product
			_label.setPhrase(new Phrase(resourceProps.getString("heading.quantityanddescriptionofgoods"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	

			PdfPCell _wrapperCell3 = new PdfPCell(_label);
			_wrapperCell3.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell3);


			//gross product weight
			_label.setPhrase(new Phrase(resourceProps.getString("heading.grossweightmeasurement"),fontSmallBold));
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	

			PdfPCell _wrapperCell4 = new PdfPCell(_label);
			_wrapperCell4.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell4);



			PdfPCell _wrapperCell6 = new PdfPCell(_wrapper);
			_wrapperCell6.setColspan(2);
			_wrapperCell6.setBorder(1);
			_Table1.addCell(_wrapperCell6);  

		} catch (Exception e) {		
		}


	}
	
	
	public void doBody2(int fixedHeight) throws DocumentException, BadElementException,  Exception
	{


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		PdfPCell cellBlank = new PdfPCell();
		cellBlank.setBorder(0); 
		cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellBlank.setFixedHeight(10f);
		cellBlank.setColspan(2);


		//particulars above....
		try {

			//
			PdfPTable _wrapper = new PdfPTable(1);	

			//
			label.setPhrase(new Phrase(resourceProps.getString("prompt.particularsabove"),fontSmallBold));
			label.setHorizontalAlignment(Element.ALIGN_CENTER); 	 	   								               				
			PdfPCell _wrapperCell = new PdfPCell(label);	
			_wrapper.addCell(_wrapperCell);			

			PdfPCell _wrapperCell1 = new PdfPCell(_wrapper);
			_wrapperCell1.setColspan(2);
			_wrapperCell1.setBorder(0);
			_wrapperCell1.setFixedHeight(fixedHeight);
			_wrapperCell1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			_Table1.addCell(_wrapperCell1);  


		} catch (Exception e) {
		}
		
		
	}
	

	public void doBody3() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;


		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);

		
		PdfPCell label =  new PdfPCell();
		label.setBorder(0);


		PdfPCell cellBlank = new PdfPCell();
		cellBlank.setBorder(0); 
		cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellBlank.setFixedHeight(10f);
		cellBlank.setColspan(2);




		try {


			//freight and charges			
			PdfPCell cell =  new PdfPCell();			
			cell = new PdfPCell(
					xmlToPdf.getFreightandcharges(resourceProps.getString("prompt.freightandcharges"), elementOrdhdr1)
			);
			cell.setFixedHeight(80f);	
			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);



			//received the goods in apparent...		
			PdfPTable _text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.receivedthegoodsinapparent"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase(" ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);

			cell = new PdfPCell(_text);
			cell.setBorderWidthLeft(0.1f);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderWidthRight(0.1f);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorLeft(BaseColor.BLACK);
			cell.setBorderColorBottom(BaseColor.WHITE);
			cell.setBorderColorRight(BaseColor.WHITE);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);		


		} catch (Exception e) {
		}


		try {

			PdfPTable _text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.shippersdeclaredvalueof"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase(" ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			label.setPhrase(new Phrase(resourceProps.getString("prompt.subjecttopayment"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			label.setPhrase(new Phrase(" ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			label.setPhrase(new Phrase(resourceProps.getString("prompt.note")+":",fontSmallBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			label.setPhrase(new Phrase(resourceProps.getString("prompt.themerchantsattention"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			PdfPCell cell = new PdfPCell(_text);
			cell.setBorderWidthLeft(0.1f);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderWidthRight(0.1f);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorLeft(BaseColor.WHITE);
			cell.setBorderColorBottom(BaseColor.BLACK);
			cell.setBorderColorRight(BaseColor.WHITE);
			cell.setBorderColorTop(BaseColor.BLACK);

			_Table1.addCell(cell); 			

		} catch (Exception e) {		
		}			

		try {			


			//Place and date of issue..
			PdfPTable _wrapper =  new PdfPTable(1);
			_wrapper.getDefaultCell().setBorder(0);



			//signed for...
			PdfPTable _text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.placeanddateofissue"),fontSmallBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase(" ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			PdfPCell cell = new PdfPCell(_text);
			cell.setBorderWidthLeft(0.1f);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderWidthRight(0.1f);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorLeft(BaseColor.BLACK);
			cell.setBorderColorBottom(BaseColor.WHITE);
			cell.setBorderColorRight(BaseColor.WHITE);
			cell.setBorderColorTop(BaseColor.BLACK);

			_wrapper.addCell(cell); 			



			//...
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setBorder(0);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.signedfor"),fontSmallBold));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase("_______________________________________________________ "+resourceProps.getString("prompt.ascarrier"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase(" ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label); 

			label.setPhrase(new Phrase(resourceProps.getString("prompt.by")+" ______________________________________________________________ ",fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_LEFT); 		
			_text.addCell(label);  

			label.setPhrase(new Phrase(resourceProps.getString("prompt.asagentsonlytothecarrier"),fontSmall));
			label.setHorizontalAlignment(Element.ALIGN_CENTER); 		
			_text.addCell(label);  

			cell = new PdfPCell(_text);
			cell.setBorderWidthLeft(0.1f);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderWidthRight(0.1f);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorLeft(BaseColor.BLACK);
			cell.setBorderColorBottom(BaseColor.WHITE);
			cell.setBorderColorRight(BaseColor.WHITE);
			cell.setBorderColorTop(BaseColor.BLACK);

			_wrapper.addCell(cell); 



			_Table1.addCell(_wrapper); 			



		} catch (Exception e) {
		}



	}


	public void doDetail(
			org.w3c.dom.Element elementOrdhdr,
			int count
	) throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementUnitkey=null;

		try{elementUnitkey=(org.w3c.dom.Element) elementOrdhdr.getElementsByTagName("unitkey").item(0);}catch(Exception e){}


		PdfPCell _label =  new PdfPCell();
		_label.setBorder(0);



		//details....
		try {
			PdfPTable _wrapper = new PdfPTable(3);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	


			//tank container, marks and nos
			PdfPTable _text =  new PdfPTable(1);
			_label.setPhrase(
					new Phrase(
							xmlToPdf.getTankno(elementUnitkey)+"   "+
							getTagValue("seal_number",elementOrdhdr)
							,
							fontSmall
					)
			);
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
			_text.addCell(_label);   	   								               				

			PdfPCell _wrapperCell1 = new PdfPCell(_text);
			_wrapperCell1.setFixedHeight(20f);
			_wrapperCell1.setBorder(0);
			_wrapper.addCell(_wrapperCell1);



			//product
			//TODO: THIS IS NOT WORKING AT THE MOMENT DUE TO THE XML ELEMENTS NOT
			// CORRECT IN THIS VERSION OF THE MONITOR XML!!!!!
			_text =  new PdfPTable(1);
			//only output product on first tank of consignment
			if (count==1) {
				_label.setPhrase(
						new Phrase(
								xmlToPdf.getProductDetail(elementOrdhdr)
								,
								fontSmall
						)
				);
			} else {
				_label.setPhrase(new Phrase(" ",	fontSmall));
			}
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
			_text.addCell(_label); 

			PdfPCell _wrapperCell3 = new PdfPCell(_text);
			_wrapperCell3.setFixedHeight(20f);
			_wrapperCell3.setBorder(0);
			_wrapper.addCell(_wrapperCell3);



			//gross product weight
			_text =  new PdfPTable(1);
			_label.setPhrase(
					new Phrase(
							xmlToPdf.getGrossProductWeight(elementOrdhdr)
							,
							fontSmall
					)
			);
			_label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
			_text.addCell(_label); 

			PdfPCell _wrapperCell4 = new PdfPCell(_text);
			_wrapperCell4.setFixedHeight(20f);
			_wrapperCell4.setBorder(0);
			_wrapper.addCell(_wrapperCell4);




			PdfPCell _wrapperCell = new PdfPCell(_wrapper);
			_wrapperCell.setColspan(2);
			_wrapperCell.setBorder(0);
			_Table1.addCell(_wrapperCell);  

		} catch (Exception e) {		
		}

	}   


	public void doFooter() throws DocumentException, BadElementException, Exception
	{

		try {


			//page break
			pdfDocument.newPage();


			//output standard hbl last page image
			Image lastPageImage = Image.getInstance(resourceProps.getString("hbldrft_last_page"));
			lastPageImage.scalePercent(70f);
			PdfPCell labelImage =  new PdfPCell(lastPageImage);
			labelImage.setBorder(0);
			labelImage.setHorizontalAlignment(Element.ALIGN_CENTER);
			labelImage.setVerticalAlignment(Element.ALIGN_MIDDLE);
			labelImage.setColspan(2);

			_Table1.addCell(labelImage); 		

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
				fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
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


			try {
				float[] widths = {0.5f, 0.5f};
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



				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);
				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.negotiable")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
				wrapper2.addCell(label);  

				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.housebilloflading")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
				wrapper2.addCell(label);  

				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);				


				PdfPCell wrapperCell =  new PdfPCell();			
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);
				
				_Table1.addCell(wrapperCell);


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
				float[] widths = {0.5f, 0.5f};
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



				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);
				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.negotiable")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
				wrapper2.addCell(label);  

				label.setPhrase(
						new Phrase(
								resourceProps.getString("title.housebilloflading")
								,fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT); 	
				wrapper2.addCell(label);  

				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);				


				PdfPCell wrapperCell =  new PdfPCell();			
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);

				_Table1.addCell(wrapperCell);


			} catch (Exception e) {
			}

			return _Table1;
		}



	}





}
