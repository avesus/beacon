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
public final class BuildShippingadvice
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
			fontSmall = new Font(font.getFamily(), font.getSize()-4, font.getStyle());			
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

			String title=
				resourceProps.getString("title.shippingadvice");
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
			doBody1();

			int count = 1;
			DETAIL_LOOP:
				while (true) {

					org.w3c.dom.Element elementOrdhdr = (org.w3c.dom.Element)elementDocument.getElementsByTagName("Ordhdr"+count).item(0);
					if (elementOrdhdr==null) break DETAIL_LOOP;         														

					doDetail(elementOrdhdr, count);

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


	public void doBody1() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;
		org.w3c.dom.Element elementDelterm = null;
		org.w3c.dom.Element elementLdgaddrkey = null;
		org.w3c.dom.Element elementDchaddrkey = null;
		org.w3c.dom.Element elementOrdlogis05= null;//shipper
		org.w3c.dom.Element elementOrdlogis06= null;//consignee
		org.w3c.dom.Element elementActvcode= null;

		org.w3c.dom.Element elementDespmovselected = null;
		org.w3c.dom.Element elementDespmovselectedFraddrkey = null;
		org.w3c.dom.Element elementDespmovselectedToaddrkey = null;


		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
		try{elementDelterm=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("delterm").item(0);}catch(Exception e){}

		try{elementLdgaddrkey=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ldgaddrkey").item(0);}catch(Exception e){}
		try{elementDchaddrkey=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("dchaddrkey").item(0);}catch(Exception e){}

		try{elementActvcode=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("actvcode").item(0);}catch(Exception e){}

		try{elementOrdlogis05=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordlogis05").item(0);}catch(Exception e){}
		try{elementOrdlogis06=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordlogis06").item(0);}catch(Exception e){}

		try{elementDespmovselected=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("despmovSELECTED").item(0);}catch(Exception e){}
		try{elementDespmovselectedFraddrkey=(org.w3c.dom.Element) elementDespmovselected.getElementsByTagName("fraddrkey").item(0);}catch(Exception e){}
		try{elementDespmovselectedToaddrkey=(org.w3c.dom.Element) elementDespmovselected.getElementsByTagName("toaddrkey").item(0);}catch(Exception e){}



		BaseColor colorLinen = new BaseColor(240,240,230);	


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);

		try {
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.ourconsignmentnumber"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("consignment_num",elementOrdhdr1),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.customer"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementOrdlogis05),font));
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
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.from"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("g4ldesc",elementDespmovselectedFraddrkey)+", "+xmlToPdf.countryRule(elementDespmovselectedFraddrkey),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.to"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("g4ldesc",elementDespmovselectedToaddrkey)+", "+xmlToPdf.countryRule(elementDespmovselectedToaddrkey),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	
			label.setPhrase(new Phrase(resourceProps.getString("prompt.loadingat"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementLdgaddrkey)+", "+getTagValue("addr1",elementLdgaddrkey),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.terms"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("descr",elementDelterm),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);	
			label.setPhrase(new Phrase(resourceProps.getString("prompt.activity"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementActvcode),font));
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
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.consignee"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementOrdlogis06),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.dischargeat"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementDchaddrkey)+", "+getTagValue("addr1",elementDchaddrkey),font));
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
			float[] widths = {0.04f, 0.24f, 0.22f, 0.1f, 0.15f, 0.25f};
			PdfPTable _wrapper = new PdfPTable(widths);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	


			//
			PdfPTable _text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);					
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(" ",font));		               			

			PdfPCell _wrapperCell8 = new PdfPCell(_text);
			_wrapperCell8.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell8);


			//
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);					
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(resourceProps.getString("heading.ourref"),font));		               			

			PdfPCell _wrapperCell1 = new PdfPCell(_text);
			_wrapperCell1.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell1);


			// 
			_text =  new PdfPTable(1);	
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(resourceProps.getString("heading.tankcontainer"),font));	

			PdfPCell _wrapperCell2 = new PdfPCell(_text);
			_wrapperCell2.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell2);


			//
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(resourceProps.getString("heading.customerref"),font));			

			PdfPCell _wrapperCell3 = new PdfPCell(_text);
			_wrapperCell3.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell3);


			//
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(resourceProps.getString("heading.productweight"),font));		

			PdfPCell _wrapperCell4 = new PdfPCell(_text);
			_wrapperCell4.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell4);


			//
			_text =  new PdfPTable(1);			
			_text.getDefaultCell().setBorder(0);						
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			_text.addCell(new Phrase(resourceProps.getString("heading.sealnos"),font));	

			PdfPCell _wrapperCell5 = new PdfPCell(_text);
			_wrapperCell5.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell5);





			//main
			_wrapper.getDefaultCell().setBorder(1);
			PdfPCell _wrapperCell7 = new PdfPCell(_wrapper);
			_wrapperCell7.setBackgroundColor(colorLinen);

			_Table1.addCell(_wrapperCell7);  

		} catch (Exception e) {
		}


	}


	public void doBody2() throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementOrdhdr1 = null;
		org.w3c.dom.Element elementDespmovshipping = null;
		org.w3c.dom.Element elementCarrier = null;
		org.w3c.dom.Element elementOrdhdr1Ordtxt2 = null;
		org.w3c.dom.Element elementProdcode = null;
		org.w3c.dom.Element elementOrdhdr1Dmrgccykey = null;
		org.w3c.dom.Element elementDespmovshippingVessel= null;
		
		elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
		try{elementDespmovshipping=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("despmovshipping").item(0);}catch(Exception e){}
		try{elementDespmovshippingVessel=(org.w3c.dom.Element) elementDespmovshipping.getElementsByTagName("vessel").item(0);}catch(Exception e){}
		
		try{elementCarrier=(org.w3c.dom.Element) elementDespmovshipping.getElementsByTagName("carrier").item(0);}catch(Exception e){}
		elementOrdhdr1Ordtxt2=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("ordtxt2").item(0);
		try{elementProdcode=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("prodcode").item(0);}catch(Exception e){}
		try{elementOrdhdr1Dmrgccykey=(org.w3c.dom.Element) elementOrdhdr1.getElementsByTagName("dmrgccykey").item(0);}catch(Exception e){}


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
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.shippingline"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("name",elementCarrier),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.vesselvoyage"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(
					new Phrase(": "+getTagValue("vesselname",elementDespmovshippingVessel)+" / "+getTagValue("voyage",elementDespmovshipping),font)
			);
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.eta"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+xmlToPdf.formatDate(getTagValue("todate",elementDespmovshipping)),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.hblno"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("ordlogis.blno",elementOrdhdr1),font));
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
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.producttradename"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("tradname",elementProdcode),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.chemicalname"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("chemname",elementProdcode),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.un"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("unno",elementProdcode),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.class"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("Class",elementProdcode),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(resourceProps.getString("prompt.packinggroup"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+getTagValue("packgrp",elementProdcode),font));
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
			float[] widths = {0.3f, 0.7f};
			PdfPTable wrapper = new PdfPTable(widths);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);


			//demurrage terms
			String demurrageterms = "";
			demurrageterms=
				getTagValue("dmrgfreday",elementOrdhdr1)+" day(s) Free / "+
				getTagValue("ccykey",elementOrdhdr1Dmrgccykey)+" "+
				getTagValue("dmrgdlyrat",elementOrdhdr1)
				;

			label.setPhrase(new Phrase(resourceProps.getString("prompt.demurrageterms"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_TOP);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+demurrageterms,font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_TOP);
			wrapper.addCell(label);

			wrapper.getDefaultCell().setBorder(1);
			PdfPCell wrapperCell =  new PdfPCell();	
			wrapperCell.setFixedHeight(20f);
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


			//derive notes
			String notes = "";
			//use discharge notes 			
			notes=getTagValue("txt",elementOrdhdr1Ordtxt2)+" "+getTagValue("txt2",elementOrdhdr1Ordtxt2);



			label.setPhrase(new Phrase(resourceProps.getString("prompt.specialnotes"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_TOP);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(": "+notes,font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			label.setVerticalAlignment(Element.ALIGN_TOP);
			wrapper.addCell(label);

			wrapper.getDefaultCell().setBorder(0);
			PdfPCell wrapperCell =  new PdfPCell();	
			wrapperCell.setFixedHeight(20f);
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


	public void doDetail(
			org.w3c.dom.Element elementOrdhdr,
			int count
	) throws DocumentException, BadElementException,  Exception
	{

		org.w3c.dom.Element elementUnitkey=null;

		try{elementUnitkey=(org.w3c.dom.Element) elementOrdhdr.getElementsByTagName("unitkey").item(0);}catch(Exception e){}



		PdfPCell label =  new PdfPCell();
		label.setBorder(0);



		try {
			float[] widths = {0.04f, 0.24f, 0.22f, 0.1f, 0.15f, 0.25f};
			PdfPTable _wrapper = new PdfPTable(widths);
			_wrapper.setSpacingAfter(0f);
			_wrapper.setSpacingBefore(0f);	


			// count
			PdfPTable _text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);					
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(count+". ",font));		               			

			PdfPCell _wrapperCell8 = new PdfPCell(_text);
			_wrapperCell8.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell8);


			// ordno
			_text =  new PdfPTable(1);	
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(getTagValue("ordno",elementOrdhdr),font));	

			PdfPCell _wrapperCell2 = new PdfPCell(_text);
			_wrapperCell2.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell2);


			// unitkey
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(getTagValue("unitkey",elementUnitkey),font));		

			PdfPCell _wrapperCell4 = new PdfPCell(_text);
			_wrapperCell4.setFixedHeight(15f);
			_wrapper.addCell(_wrapperCell4);


			// cusref
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);					
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(getTagValue("cusref",elementOrdhdr)+" ",font));		               			

			PdfPCell _wrapperCell1 = new PdfPCell(_text);
			_wrapperCell1.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell1);



			// product weight
			_text =  new PdfPTable(1);
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);				
			_text.getDefaultCell().setBorder(0);						

			_text.addCell(new Phrase(getTagValue("weightactual",elementOrdhdr)+getTagValue("weightactualunit",elementOrdhdr),font));							

			PdfPCell _wrapperCell3 = new PdfPCell(_text);
			_wrapperCell3.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell3);



			// seal nos
			_text =  new PdfPTable(1);			
			_text.getDefaultCell().setBorder(0);						
			_text.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			_text.addCell(new Phrase(getTagValue("seal_number",elementOrdhdr),font));

			PdfPCell _wrapperCell5 = new PdfPCell(_text);
			_wrapperCell5.setFixedHeight(15f);	
			_wrapper.addCell(_wrapperCell5);



			//main
			_wrapper.getDefaultCell().setBorder(1);
			PdfPCell _wrapperCell7 = new PdfPCell(_wrapper);

			_Table1.addCell(_wrapperCell7);  

		} catch (Exception e) {
		}	


	}   


	public void doFooter() throws DocumentException, BadElementException, Exception
	{


		org.w3c.dom.Element elementParamdetails=null;

		elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);		


		PdfPCell label =  new PdfPCell();
		label.setBorder(0);



		try {
			PdfPTable wrapper = new PdfPTable(1);
			wrapper.setSpacingAfter(0f);
			wrapper.setSpacingBefore(0f);

			label.setPhrase(new Phrase(resourceProps.getString("prompt.bestregards"),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("UserName",elementParamdetails),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase(getTagValue("UserJobTitle",elementParamdetails),font));
			label.setHorizontalAlignment(Element.ALIGN_LEFT);
			wrapper.addCell(label);
			label.setPhrase(new Phrase("User Office",font));
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


			BaseColor colorLinen = new BaseColor(240,240,230);

			org.w3c.dom.Element elementParamdetails=null;
			org.w3c.dom.Element elementToAddress=null;
			org.w3c.dom.Element elementCCToAddress=null;
			org.w3c.dom.Element elementUserLocation=null;
			org.w3c.dom.Element elementUserLocationContact1=null;

			elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);		
			try{elementToAddress=(org.w3c.dom.Element) elementParamdetails.getElementsByTagName("ToAddress").item(0);}catch(Exception e){}
			try{elementCCToAddress=(org.w3c.dom.Element) elementParamdetails.getElementsByTagName("CCToAddress").item(0);}catch(Exception e){}
			try{elementUserLocation=(org.w3c.dom.Element) elementParamdetails.getElementsByTagName("UserLocation").item(0);}catch(Exception e){}
			try{elementUserLocationContact1=(org.w3c.dom.Element) elementParamdetails.getElementsByTagName("UserLocationContact1").item(0);}catch(Exception e){}



			PdfPCell label =  new PdfPCell();
			label.setBorder(0);


			try {
				//float[] widths = {0.3f, 0.3f, 0.3f};
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

				/*			//barcode image			
				BarcodeQRCode qrcode = new BarcodeQRCode(getTagValue("consignment_num",elementOrdhdr1), 1, 1, null);
				Image barcodeImage = qrcode.getImage();
				barcodeImage.scalePercent(200f);
				labelImage =  new PdfPCell(barcodeImage);
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_CENTER);
				wrapper.addCell(labelImage);*/		        

				//sub-table for address
				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper2.setSpacingAfter(0f);
				wrapper2.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getCompanyName(),fontBoldLarge));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getAddress(),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(companyHeader.getCityPostalcode(),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(label);			
				label.setPhrase(new Phrase(companyHeader.getCountry(),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(label);

				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);			


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
				float[] widths = {0.1f, 0.4f, 0.1f, 0.4f};
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(resourceProps.getString("prompt.to"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("name",elementToAddress),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.from"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("name",elementUserLocation),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase(resourceProps.getString("prompt.toattn"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("ToAttn",elementParamdetails),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.contact"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("UserName",elementParamdetails),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase(resourceProps.getString("prompt.cc"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("name",elementCCToAddress),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.phone"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("telNo",elementUserLocationContact1),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase(resourceProps.getString("prompt.ccattn"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("CCToAttn",elementParamdetails),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.fax"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("faxNo",elementUserLocationContact1),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase(resourceProps.getString("prompt.date"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(Util.dateTextFormat(new Date()),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.email"),font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(getTagValue("UserEmail",elementParamdetails),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
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

				label.setPhrase(new Phrase(resourceProps.getString("prompt.concerning")+":",fontBoldLarge));
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
				wrapperCell.setBackgroundColor(colorLinen);
				_Table1.addCell(wrapperCell);

				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0); 
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(10f);
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


			BaseColor colorLinen = new BaseColor(240,240,230);

			org.w3c.dom.Element elementParamdetails=null;
			org.w3c.dom.Element elementOrdhdr1 = null;

			elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);				
			elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);


			PdfPCell label =  new PdfPCell();
			label.setBorder(0);


			try {
				//float[] widths = {0.3f, 0.3f, 0.3f};
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

				/*			//barcode image			
				BarcodeQRCode qrcode = new BarcodeQRCode(getTagValue("consignment_num",elementOrdhdr1), 1, 1, null);
				Image barcodeImage = qrcode.getImage();
				barcodeImage.scalePercent(200f);
				labelImage =  new PdfPCell(barcodeImage);
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_CENTER);
				wrapper.addCell(labelImage);*/		        

				//sub-table for address
				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper2.setSpacingAfter(0f);
				wrapper2.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(companyHeader.getCompanyName(),fontBoldLarge));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(label);


				//sub-table for contact details
				float[] widths3 = {0.7f, 0.3f};
				PdfPTable wrapper3 = new PdfPTable(widths3);
				wrapper3.setSpacingAfter(0f);
				wrapper3.setSpacingBefore(0f);	

				label.setPhrase(new Phrase(resourceProps.getString("prompt.from")+":",font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(getTagValue("UserName",elementParamdetails),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);			
				label.setPhrase(new Phrase(resourceProps.getString("prompt.consignmentno")+":",font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(getTagValue("consignment_num",elementOrdhdr1),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(resourceProps.getString("prompt.date")+":",font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(Util.dateTextFormat(new Date()),font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper3.addCell(label);				

				PdfPCell wrapperCell3 =  new PdfPCell();			
				wrapperCell3 = new PdfPCell(wrapper3);
				wrapperCell3.setBorder(0);
				wrapperCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper2.addCell(wrapperCell3);					


				PdfPCell wrapperCell2 =  new PdfPCell();			
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);			


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

				label.setPhrase(new Phrase(resourceProps.getString("prompt.concerning")+":",fontBoldLarge));
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
				wrapperCell.setBackgroundColor(colorLinen);
				_Table1.addCell(wrapperCell);

				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0); 
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(10f);
				_Table1.addCell(cellBlank);					

			} catch (Exception e) {
			}

			return _Table1;
		}

	}		




}
