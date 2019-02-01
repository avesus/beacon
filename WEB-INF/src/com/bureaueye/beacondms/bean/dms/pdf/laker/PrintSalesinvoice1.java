package com.bureaueye.beacondms.bean.dms.pdf.laker;

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
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacondms.exception.dms.BuildException;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
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
 * Amendments ----------
 * 
 * NT 2013-12-11 WSI-201311-0002 BEACON LAKER (WSI LINER) - Sales Invoice
 * Template
 * 
 * NT 2014-02-19 WSI-201311-0002B BEACON LAKER (WSI LINER) - Sales Invoice Mods to retrieve logistic info from Order
 *
 * NT 2014-06-11 WSI-201311-0002C BEACON LAKER (WSI LINER) - Add More Logistic fields to Manual Sales invoice 
 *  
 */
public final class PrintSalesinvoice1 {

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	/**
	 */
	// maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;

	String SYSTEM_USERID = "WSIL1";

	com.itextpdf.text.Document pdfDocument;
	private PdfPTable _Table1;

	Font font;
	Font fontBold;
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;
	Font fontBoldHugeLightgray;

	CompanyBD companybd;
	CompanyheaderBD companyheaderbd;
	PropertyResourceBundle resourceProps;

	BigDecimal freightRateTotal;

	Sihdr sihdrdao;

	private static Map<String, SessionFactory> _sessionFactoryClusterMap;

	public void setSessionFactoryClusterMap(Map<String, SessionFactory> sfcm) {
		_sessionFactoryClusterMap = sfcm;
	}

	public Map<String, SessionFactory> getSessionFactoryClusterMap() {
		return _sessionFactoryClusterMap;
	}

	@SuppressWarnings("rawtypes")
	public void executePrint(Integer id, String printtype, User user,
			Map<String, SessionFactory> sessionFactoryClusterMap)
					throws Exception {

		setStartprocesstime();

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
		+ "  executePrint: " + "  id [" + id + "]" + "  printtype ["
		+ printtype + "]");

		this.setSessionFactoryClusterMap(sessionFactoryClusterMap);

		// init BD
		companybd = new CompanyBD(this.getSessionFactoryClusterMap());
		companyheaderbd = new CompanyheaderBD(
				this.getSessionFactoryClusterMap());
		SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());
		SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);

		Systemcode systemcodedao = null;
		String workDirectory = "";
		try {
			systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
					"BEACONDMS", "WORKDIRECTORY");
			workDirectory = systemcodedao.getDescr();
		} catch (ApplicationException e) {
			log.error("["
					+ this.getClass().getName()
					+ "] "
					+ new java.util.Date()
					+ " findSystemcodesByTypekeyCodekey: ApplicationException: "
					+ e.getMessage());
		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
			+ " findSystemcodesByTypekeyCodekey: Exception: "
			+ e.getMessage());
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

			// set Document Type
			// - pagesize
			// - font
			// - build class
			// - margins
			// - language
			Documenttype documenttypedao = new Documenttype();
			documenttypedao.setPagesizerectanglellx(new BigDecimal(0));// lower
			// left
			// x
			documenttypedao.setPagesizerectanglelly(new BigDecimal(0));// lower
			// left
			// y
			documenttypedao.setPagesizerectangleurx(new BigDecimal(595));// upper
			// right
			// x
			documenttypedao.setPagesizerectangleury(new BigDecimal(842)); // upper
			// right
			// y
			documenttypedao.setMarginleft(new BigDecimal(36));
			documenttypedao.setMarginright(new BigDecimal(36));
			documenttypedao.setMargintoppage1(new BigDecimal(300));
			documenttypedao.setMargintop(new BigDecimal(300));
			documenttypedao.setMarginbottom(new BigDecimal(80));
			documenttypedao.setFontsize(new BigDecimal(11));
			documenttypedao.setFontstyle(0);
			documenttypedao.setFontname("c:\\windows\\fonts\\calibri.ttf");
			documenttypedao.setLanguageid("en");

			pdfDocument = new com.itextpdf.text.Document();

			// init pagesize for document type
			Rectangle pageSizeRectangle = new Rectangle(documenttypedao
					.getPagesizerectanglellx().floatValue(),// lower left x
					documenttypedao.getPagesizerectanglelly().floatValue(),// lower
					// left
					// y
					documenttypedao.getPagesizerectangleurx().floatValue(),// upper
					// right
					// x
					documenttypedao.getPagesizerectangleury().floatValue() // upper
					// right
					// y
					);
			pdfDocument.setPageSize(pageSizeRectangle);
			// pdfDocument.setPageSize(PageSize.A4);

			// init margins for document type
			pdfDocument.setMargins(
					documenttypedao.getMarginleft().floatValue(),
					documenttypedao.getMarginright().floatValue(),
					documenttypedao.getMargintoppage1().floatValue(),
					documenttypedao.getMarginbottom().floatValue());

			// init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(
					documenttypedao.getFontname(), BaseFont.CP1252,
					BaseFont.NOT_EMBEDDED);
			font = new Font(
					// Font.FontFamily.COURIER,
					baseFont, documenttypedao.getFontsize().floatValue(),
					documenttypedao.getFontstyle());
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontBoldLarge = new Font(font.getFamily(), font.getSize() + 2,
					fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize() - 3,
					font.getStyle());
			fontSmallBold = new Font(fontSmall.getFamily(),
					fontSmall.getSize(), Font.BOLD);
			fontBoldHugeLightgray = new Font(font.getFamily(),
					font.getSize() + 24, fontBold.getStyle());
			fontBoldHugeLightgray.setColor(new BaseColor(Color.LIGHT_GRAY));

			// set page count
			pdfDocument.setPageCount(1);

			// generate print file
			String printFilename = "";
			printFilename = workDirectory + "\\SALES_INVOICE"
					+ sihdrdao.getSihdrId() + ".pdf";
			FileOutputStream fileOutputStream = new FileOutputStream(
					printFilename);
			PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument,
					fileOutputStream);

			// init end page event
			Company companydao = null;
			try {
				companydao = companybd.read(sihdrdao.getCompanykey());
			} catch (ApplicationException e) {
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
				+ " find company: ApplicationException: "
				+ e.getMessage());
			}
			Companyheader companyheaderdao = null;
			try {
				companyheaderdao = companyheaderbd.read(companydao
						.getCompanyheaderId());
			} catch (ApplicationException e) {
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
				+ " find companyheader: ApplicationException: "
				+ e.getMessage());
			}

			String title = "INVOICE";

			pdfWriter
			.setPageEvent(new HeaderFooterPageEvent(companyheaderdao,
					documenttypedao, title, this
					.getSessionFactoryClusterMap()));

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

			// header
			doHeader();

			freightRateTotal = new BigDecimal(0.0);

			// read details
			int row = 0;
			List sidtldtos = new SihdrBD(this.getSessionFactoryClusterMap())
			.getSidtls(sihdrdao.getSihdrId());
			if (sidtldtos.size() > 0) {

				// process details list collection
				Iterator it = sidtldtos.iterator();
				while (it.hasNext()) {
					// init
					Sidtl lineItem = (Sidtl) it.next();

					// init select parameter
					try {
						// output to PDF
						doDetail(lineItem, row,
								this.getSessionFactoryClusterMap());
					} catch (NullPointerException npe) {
					}
					// increment pointer
					row++;
				} // end list loop
			}

			// body
			doDetailFooter(this.getSessionFactoryClusterMap());

			// footer
			doFooter();

			// add main table to PDF document
			pdfDocument.add(_Table1);

			// test print Watermark
			if (printtype.equals("Test")) {
				String waterMarkText = Constants.TEST_PRINT;
				// add watermark
				ColumnText.showTextAligned(pdfWriter.getDirectContentUnder(),
						Element.ALIGN_CENTER, new Phrase(waterMarkText,
								fontBoldHugeLightgray), 297.5f, 421, pdfWriter
								.getPageNumber() % 2 == 1 ? 45 : -45);
			}

		} catch (BuildException e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
			+ " Build Document: BuildException: " + e.getCode());
			throw new BuildException(BuildException.GENERAL_FAILURE);
		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
			+ " Build Document: Exception: " + e.getMessage());
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

	void println(String s) {
		System.out.println(s);
	}

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
		_maxprocesstime.add(Calendar.MILLISECOND, MAX_PROCESS_TIME);

		log.debug("[" + this.getClass().getName() + "] " + new Date()
		+ " isblocked: " + _currenttime.after(_maxprocesstime)
		+ " currenttime: " + _currenttime.getTime()
		+ " maxprocesstime: " + _maxprocesstime.getTime());

		if (_currenttime.after(_maxprocesstime))
			return true;
		return false;
	}

	public void doHeader() throws DocumentException, BadElementException,
	Exception {
		// header code in EndPageHeaderFooter PDF
	}

	public void doDetailFooter(
			Map<String, SessionFactory> sessionFactoryClusterMap)
					throws DocumentException, BadElementException, Exception {

		BaseColor colorLinen = new BaseColor(240, 240, 230);
		CurrencyFormatter cf = new CurrencyFormatter();

		PdfPCell label = new PdfPCell();
		label.setBorder(0);

		try {
			PdfPCell cellBlank = new PdfPCell();
			cellBlank.setBorder(0);
			cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBlank.setFixedHeight(10f);
			_Table1.addCell(cellBlank);
		} catch (Exception e) {
		}

		// print function for BEACON_SYS generated invoice
		if (sihdrdao.getCreateuserid().equals(SYSTEM_USERID)) {

			try {
				float[] widths = { 0.67f, 0.20f, 0.13f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase("Total:", fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(sihdrdao.getInvoiceccykey() + "   "
						+ cf.format(freightRateTotal), fontBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(sihdrdao.getInvoiceamt().toString(),
						fontBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				PdfPCell wrapperCell = new PdfPCell();
				wrapperCell = new PdfPCell(wrapper);
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

		} else {

			try {
				float[] widths = { 0.6f, 0.2f, 0.2f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase("Total:", fontBold));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase("   ", fontBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				label.setPhrase(new Phrase(sihdrdao.getInvoiceccykey() + "   "
						+ sihdrdao.getInvoiceamt().toString(), fontBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				wrapper.addCell(label);

				PdfPCell wrapperCell = new PdfPCell();
				wrapperCell = new PdfPCell(wrapper);
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

		}

	}

	public void doDetail(Sidtl dtl, int count,
			Map<String, SessionFactory> sessionFactoryClusterMap)
					throws DocumentException, BadElementException, Exception {

		PdfPCell label = new PdfPCell();
		label.setBorder(0);
		CurrencyFormatter cf = new CurrencyFormatter();

		// print function for BEACON_SYS generated invoice
		if (sihdrdao.getCreateuserid().equals(SYSTEM_USERID)) {

			try {

				// get shipper details------------------------->
				String shipperName = "";				
				String shipperCity = "";
				String shipperState = "";				
				AddressBD addressbd = new AddressBD(sessionFactoryClusterMap);
				try {
					Address shipperAddress = addressbd.findAddressByExtsysaddressid(dtl.getAdddata6());
					if (shipperAddress != null) {
						shipperName= shipperAddress.getName();							
						shipperCity = shipperAddress.getCity();
						shipperState = shipperAddress.getState();					
					}
				} catch (Exception e) {
				}
				addressbd = null;
				// get shipper details-------------------------<

				float[] widths = { 0.16f, 0.15f, 0.35f, 0.08f, 0.13f, 0.13f };
				PdfPTable _wrapper = new PdfPTable(widths);
				_wrapper.setSpacingAfter(0f);
				_wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(dtl.getAdddata8() + " / "
						+ dtl.getAdddata9(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase(dtl.getAdddata5(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				try {
					shipperName = shipperName.substring(0, 29);
				} catch (Exception e) {
				}
				label.setPhrase(new Phrase(shipperName, font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				BigDecimal commissionRate = new BigDecimal(dtl.getAdddata1());
				label.setPhrase(new Phrase(cf.format(commissionRate), font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				BigDecimal freightRate = new BigDecimal(0.0);
				try {
					freightRate = new BigDecimal(dtl.getAdddata10());
					freightRateTotal = freightRateTotal.add(freightRate);
				} catch (Exception e) {
				}				
				label.setPhrase(new Phrase(cf.format(freightRate), font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase(dtl.getInvoiceamt().toString(), font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase(shipperCity + ", " + shipperState,
						font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_wrapper.addCell(label);

				PdfPCell _wrapperCell7 = new PdfPCell();
				_wrapperCell7 = new PdfPCell(_wrapper);
				_wrapperCell7.setBorder(0);
				_Table1.addCell(_wrapperCell7);

			} catch (Exception e) {			
			}

		} else {

			try {

				float[] widths = { 0.6f, 0.2f, 0.2f };
				PdfPTable _wrapper = new PdfPTable(widths);
				_wrapper.setSpacingAfter(0f);
				_wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(dtl.getTxt1(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				label.setFixedHeight(30f);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase(dtl.getRate().toString(), font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				label.setVerticalAlignment(Element.ALIGN_TOP);
				_wrapper.addCell(label);

				label.setPhrase(new Phrase(dtl.getInvoiceamt().toString(), font));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				label.setVerticalAlignment(Element.ALIGN_TOP);
				_wrapper.addCell(label);

				PdfPCell _wrapperCell7 = new PdfPCell();
				_wrapperCell7 = new PdfPCell(_wrapper);
				_wrapperCell7.setBorder(0);
				_Table1.addCell(_wrapperCell7);

			} catch (Exception e) {
			}

		}

	}

	public void doFooter() throws DocumentException, BadElementException,
	Exception {
	}

	// WE NEEDED TO INCLUDE THIS CLASS HERE AS THE PROGRAM
	// AS WE NEED TO RESET THE MARGIN SETTINGS FOR PDF DOCUMENT
	// TO HAVE A LARGER HEADER FOR PAGE 1
	public class HeaderFooterPageEvent extends PdfPageEventHelper {

		Companyheader _companyheader;
		PropertyResourceBundle _resourceProps;
		String _title;
		Documenttype _documenttype;

		/** The template with the total number of pages. */
		PdfTemplate _total;

		Font font;
		float fontSize;
		Font fontBold;
		Font fontBoldLarge;
		Font fontSmall;
		Font fontSmallBold;

		private Map<String, SessionFactory> _sessionFactoryClusterMap;

		public HeaderFooterPageEvent(Companyheader companyheader,
				Documenttype documenttype, String title,
				Map<String, SessionFactory> sessionFactoryClusterMap)
						throws BuildException {

			try {
				this._companyheader = companyheader;
				this._title = title;
				this._documenttype = documenttype;
				this._sessionFactoryClusterMap = sessionFactoryClusterMap;

				// init document resource by languageid
				String resourceName = "com.bureaueye.beacondms.DocumentResources_"
						+ documenttype.getLanguageid();
				resourceProps = (PropertyResourceBundle) ResourceBundle
						.getBundle(resourceName);

				// init default fonts for document type
				BaseFont baseFont = BaseFont.createFont(
						documenttype.getFontname(), BaseFont.CP1252,
						BaseFont.NOT_EMBEDDED);
				font = new Font(baseFont, documenttype.getFontsize()
						.floatValue(), documenttype.getFontstyle());
				fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);
				fontBoldLarge = new Font(font.getFamily(), font.getSize() + 2,
						fontBold.getStyle());
				fontSmall = new Font(font.getFamily(), font.getSize() - 3,
						font.getStyle());
				fontSmallBold = new Font(fontSmall.getFamily(),
						fontSmall.getSize(), Font.BOLD);

			} catch (Exception e) {
				throw new BuildException(BuildException.GENERAL_FAILURE);
			}
		}

		/**
		 * Creates the PdfTemplate that will hold the total number of pages.
		 * 
		 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(com.itextpdf.text.pdf.PdfWriter,
		 *      com.itextpdf.text.Document)
		 */
		public void onOpenDocument(PdfWriter writer, Document document) {
			_total = writer.getDirectContent().createTemplate(30, 16);
		}

		/**
		 * Fills out the total number of pages before the document is closed.
		 * 
		 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(com.itextpdf.text.pdf.PdfWriter,
		 *      com.itextpdf.text.Document)
		 */
		public void onCloseDocument(PdfWriter writer, Document document) {
			ColumnText.showTextAligned(_total, Element.ALIGN_LEFT, new Phrase(
					String.valueOf(writer.getPageNumber() - 1), fontSmallBold),
					2, 2, 0);
		}

		public void onEndPage(PdfWriter writer, Document document) {
			try {

				com.itextpdf.text.Rectangle page = document.getPageSize();
				PdfPTable head = null;
				// process different header for page 1
				if (writer.getPageNumber() == 1) {
					head = doHeader1();
					// set top margin for other pages (after page 1 printed)
					pdfDocument.setMargins(_documenttype.getMarginleft()
							.floatValue(), _documenttype.getMarginright()
							.floatValue(), _documenttype.getMargintop()
							.floatValue(), _documenttype.getMarginbottom()
							.floatValue());
				} else {
					head = doHeader1();
				}

				head.setTotalWidth(page.getWidth() - document.leftMargin()
						- document.rightMargin());
				head.writeSelectedRows(
						0, // rowstart
						-1, // rowend
						document.leftMargin(),
						page.getHeight() - document.topMargin()
						+ head.getTotalHeight(),
						writer.getDirectContent());

				PdfPTable foot = doFooter(writer);
				foot.setTotalWidth(page.getWidth() - document.leftMargin()
						- document.rightMargin());
				foot.writeSelectedRows(0, // rowstart
						-1, // rowend
						document.leftMargin(), // xPos
						document.bottomMargin(), // yPos
						writer.getDirectContent());

			} catch (DocumentException de) {
				throw new ExceptionConverter(de);
			}
		}

		public PdfPTable doFooter(PdfWriter writer) throws DocumentException {

			// create table
			PdfPTable _Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f);
			_Table1.getDefaultCell().setPadding(0f);

			PdfPCell label = new PdfPCell();
			label.setBorder(0);

			try {
				float[] widths = { 0.35f, 0.65f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase("", font));
				wrapper.addCell(label);
				label.setPhrase(new Phrase("", font));
				wrapper.addCell(label);

				PdfPCell wrapperCell = new PdfPCell();
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

				float[] widths = { 0.5f, 0.5f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(String.format("Page %d of",
						writer.getPageNumber()), fontSmallBold));
				label.setHorizontalAlignment(Element.ALIGN_RIGHT);
				label.setVerticalAlignment(Element.ALIGN_BOTTOM);
				wrapper.addCell(label);

				PdfPCell labelImage = new PdfPCell(Image.getInstance(_total));
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
				label.setVerticalAlignment(Element.ALIGN_BOTTOM);
				wrapper.addCell(labelImage);

				_Table1.addCell(wrapper);

			} catch (Exception e) {
			}

			return _Table1;
		}

		public PdfPTable doHeader1() throws DocumentException {

			// create table
			PdfPTable _Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);
			_Table1.setSpacingAfter(0f);
			_Table1.setSpacingBefore(0f);
			_Table1.setExtendLastRow(true);
			_Table1.setWidthPercentage(100f);
			_Table1.getDefaultCell().setPadding(0f);

			PdfPCell label = new PdfPCell();
			label.setBorder(0);

			try {

				float[] widths = { 0.3f, 0.3f, 0.3f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				// logo
				Image logoImage = Image.getInstance(_companyheader.getLogo());
				logoImage.scalePercent(45f);
				PdfPCell labelImage = new PdfPCell(logoImage);
				labelImage.setBorder(0);
				labelImage.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(labelImage);

				// sub-table for address
				PdfPTable wrapper2 = new PdfPTable(1);
				wrapper2.setSpacingAfter(0f);
				wrapper2.setSpacingBefore(0f);

				label.setPhrase(new Phrase(_companyheader.getCompanyName(),
						font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getAddress(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getCityPostalcode(),
						font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);
				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper2.addCell(label);

				PdfPCell wrapperCell2 = new PdfPCell();
				wrapperCell2 = new PdfPCell(wrapper2);
				wrapperCell2.setBorder(0);
				wrapper.addCell(wrapperCell2);

				// sub-table for contact info
				PdfPTable wrapper3 = new PdfPTable(1);
				wrapper3.setSpacingAfter(0f);
				wrapper3.setSpacingBefore(0f);

				label.setPhrase(new Phrase(_companyheader.getOfficename(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getPhone(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getWebsite(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);
				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper3.addCell(label);

				PdfPCell wrapperCell3 = new PdfPCell();
				wrapperCell3 = new PdfPCell(wrapper3);
				wrapperCell3.setBorder(0);
				wrapper.addCell(wrapperCell3);

				PdfPCell wrapperCell = new PdfPCell();
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

			BaseColor colorLinen = new BaseColor(240, 240, 230);

			try {

				AddressBD _addressBD = new AddressBD(_sessionFactoryClusterMap);
				// init billing address
				Address _customer = _addressBD.read(sihdrdao
						.getCustomeraddrkey());
				String addr1 = _customer.getAddr1();
				String addr2 = _customer.getAddr2();
				String addr3 = _customer.getAddr3();
				String addr4 = _customer.getAddr4();
				String addr5 = _customer.getAddr5();
				if (!_customer.getRentaddrkey().equals("")) {
					Address billingaddress = null;
					try {
						billingaddress = _addressBD.read(_customer
								.getRentaddrkey());
					} catch (ApplicationException ae) {
					}
					if (billingaddress != null) {
						addr1 = billingaddress.getAddr1();
						addr2 = billingaddress.getAddr2();
						addr3 = billingaddress.getAddr3();
						addr4 = billingaddress.getAddr4();
						addr5 = billingaddress.getAddr5();
					}
				}

				// page size function for BEACON_SYS generated invoice
				if (sihdrdao.getCreateuserid().equals(SYSTEM_USERID)) {

					float[] widths = { 0.6f, 0.20f, 0.20f };
					PdfPTable wrapper = new PdfPTable(widths);
					wrapper.setSpacingAfter(0f);
					wrapper.setSpacingBefore(0f);

					label.setPhrase(new Phrase(_customer.getName(), font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Invoice No.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getInvoiceno(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr1, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Invoice Date:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(Util.dateTextFormat8(sihdrdao
							.getPrintdate()), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr2, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase("", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr3, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Vessel:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata1(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr4, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Voyage / Direction:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata2()+" / "+sihdrdao.getAdddata3(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr5, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Service:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata4(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase("", font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Voyage Date:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata5(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					PdfPCell wrapperCell = new PdfPCell();
					wrapperCell = new PdfPCell(wrapper);
					wrapperCell.setBorder(0);
					_Table1.addCell(wrapperCell);

				} else {

					String customerref = "";
					String vesselvoyage = "";
					String addinfo = "";

					//sWSI-201311-0002C
					// CHECK NOT A MANUAL INVOICE - GENERATED FROM ORDER
					if (!sihdrdao.isManualflag()) {
						try {
							//retrieve order and job information
							OrderhdrBD orderhdrbd = new OrderhdrBD(_sessionFactoryClusterMap);
							// init logistic info
							Orderhdr orderhdrdao = orderhdrbd.findOrderhdrByOrderno(sihdrdao.getOrderno());	
							if (orderhdrdao != null) {
								customerref = orderhdrdao.getCustomerref();
								vesselvoyage = orderhdrdao.getShipvoyage();
								addinfo = orderhdrdao.getNotes();
							}
							orderhdrbd=null;
						} catch (Exception e) {	
						}
					}
					// CHECK IS A MANUAL INVOICE 
					if (sihdrdao.isManualflag()) {
						customerref = sihdrdao.getCustomerref();
						vesselvoyage = sihdrdao.getAdddata1();
						addinfo = sihdrdao.getAdddata2();							
					}
					//wWSI-201311-0002C					

					float[] widths = { 0.6f, 0.15f, 0.25f };
					PdfPTable wrapper = new PdfPTable(widths);
					wrapper.setSpacingAfter(0f);
					wrapper.setSpacingBefore(0f);

					label.setPhrase(new Phrase(_customer.getName(), font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Invoice No.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getInvoiceno(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr1, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Invoice Date:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(Util.dateTextFormat8(sihdrdao
							.getPrintdate()), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					/***WSI-201311-0002B***					
					label.setPhrase(new Phrase(addr2, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("BL No.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getOrderno(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr3, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Customer Ref.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getCustomerref(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr4, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Vessel / Voy.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata1(), font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					 ***/
					//sWSI-201311-0002B
					label.setPhrase(new Phrase(addr2, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Customer Ref.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(customerref, font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr3, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("Vessel / Voy.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(vesselvoyage, font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);

					label.setPhrase(new Phrase(addr4, font));
					wrapper.addCell(label);
					label.setPhrase(new Phrase("", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase("", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					//eWSI-201311-0002B


					PdfPCell wrapperCell = new PdfPCell();
					wrapperCell = new PdfPCell(wrapper);
					wrapperCell.setBorder(0);
					_Table1.addCell(wrapperCell);

					//insert blank line
					PdfPCell cellBlank = new PdfPCell();
					cellBlank.setBorder(0);
					cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellBlank.setFixedHeight(2f);
					_Table1.addCell(cellBlank);


					float[] widths2 = { 0.15f, 0.85f };
					wrapper = new PdfPTable(widths2);
					wrapper.setSpacingAfter(0f);
					wrapper.setSpacingBefore(0f);

					/***WSI-201311-0002B***					
					label.setPhrase(new Phrase("Additional Info.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(sihdrdao.getAdddata2()+" ", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase("", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);					
					label.setPhrase(new Phrase(sihdrdao.getAdddata3()+" ", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					 ***/
					//sWSI-201311-0002B
					label.setPhrase(new Phrase("Additional Info.:", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					label.setPhrase(new Phrase(addinfo+" ", font));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					wrapper.addCell(label);
					//eWSI-201311-0002B					

					wrapperCell = new PdfPCell();
					wrapperCell = new PdfPCell(wrapper);
					wrapperCell.setBorder(0);
					_Table1.addCell(wrapperCell);

					//insert blank line
					_Table1.addCell(cellBlank);

				}

			} catch (Exception e) {
			}

			try {

				float[] widths = { 0.15f, 0.85f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase("Please Remit To:", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getCompanyName(),
						font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getAddress(), font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase("", font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);
				label.setPhrase(new Phrase(_companyheader.getCityPostalcode(),
						font));
				label.setHorizontalAlignment(Element.ALIGN_LEFT);
				wrapper.addCell(label);

				PdfPCell wrapperCell = new PdfPCell();
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setBorder(0);
				_Table1.addCell(wrapperCell);

				//insert blank line
				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0);
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(5f);
				_Table1.addCell(cellBlank);

			} catch (Exception e) {
			}

			try {
				float[] widths = { 1.00f };
				PdfPTable wrapper = new PdfPTable(widths);
				wrapper.setSpacingAfter(0f);
				wrapper.setSpacingBefore(0f);

				label.setPhrase(new Phrase(_title, fontBoldLarge));
				label.setHorizontalAlignment(Element.ALIGN_CENTER);
				label.setVerticalAlignment(Element.ALIGN_MIDDLE);
				wrapper.addCell(label);

				PdfPCell wrapperCell = new PdfPCell();
				wrapperCell = new PdfPCell(wrapper);
				wrapperCell.setFixedHeight(20f);
				wrapperCell.setBorder(0);
				_Table1.addCell(wrapperCell);

				//insert blank line
				PdfPCell cellBlank = new PdfPCell();
				cellBlank.setBorder(0);
				cellBlank.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellBlank.setFixedHeight(5f);
				_Table1.addCell(cellBlank);

			} catch (Exception e) {
			}

			// print function for BEACON_SYS generated invoice
			if (sihdrdao.getCreateuserid().equals(SYSTEM_USERID)) {

				try {

					float[] widths = { 0.16f, 0.15f, 0.35f, 0.08f, 0.13f, 0.13f };
					PdfPTable _wrapper = new PdfPTable(widths);
					_wrapper.setSpacingAfter(0f);
					_wrapper.setSpacingBefore(0f);

					label.setPhrase(new Phrase("Ports", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("B/L No.", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Shipper", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_LEFT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Rate", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_RIGHT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Freight", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_RIGHT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Amt. Due", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_RIGHT);
					_wrapper.addCell(label);

					PdfPCell _wrapperCell7 = new PdfPCell();
					_wrapperCell7 = new PdfPCell(_wrapper);
					_wrapperCell7.setBackgroundColor(colorLinen);
					_wrapperCell7.setBorder(0);
					_Table1.addCell(_wrapperCell7);

				} catch (Exception e) {
				}

			} else {

				try {

					float[] widths = { 0.6f, 0.2f, 0.2f };
					PdfPTable _wrapper = new PdfPTable(widths);
					_wrapper.setSpacingAfter(0f);
					_wrapper.setSpacingBefore(0f);

					label.setPhrase(new Phrase("Description", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_CENTER);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Rate", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_RIGHT);
					_wrapper.addCell(label);

					label.setPhrase(new Phrase("Amount", fontBold));
					label.setHorizontalAlignment(Element.ALIGN_RIGHT);
					_wrapper.addCell(label);

					PdfPCell _wrapperCell7 = new PdfPCell();
					_wrapperCell7 = new PdfPCell(_wrapper);
					_wrapperCell7.setBackgroundColor(colorLinen);
					_wrapperCell7.setBorder(0);
					_Table1.addCell(_wrapperCell7);

				} catch (Exception e) {
				}

			}

			return _Table1;
		}

		public PdfPTable doHeader2() throws DocumentException {
			return _Table1;
		}

	}

	@SuppressWarnings("rawtypes")
	public void setPrinted(User user,
			Map<String, SessionFactory> sessionFactoryClusterMap)
					throws Exception {

		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
		+ "  setPrinted: " + "  id [" + sihdrdao.getSihdrId() + "]"
		+ "  user [" + user + "]");
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
				nextDocno = new SidocnoBD(this.getSessionFactoryClusterMap())
				.getNextDocno2("INV", sihdrdao.getCompanykey(),// company
						"",// department
						"",// activity
						c.get(Calendar.YEAR), user);
			} catch (Exception e) {
			}
			sihdrdao.setInvoiceno(nextDocno);

			// generate posting
			// record===============================================>
			AioutBD aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
			Aiout aioutdao = new Aiout();
			// retrieve aiout record
			if (sihdrdao.getAioutId() != null) {
				try {
					aioutdao = aioutbd.read(sihdrdao.getAioutId());
				} catch (Exception e) {
				}
			}

			try {
				// check not already sent
				if (aioutdao.getSentdate() == null) {
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
			// generate posting
			// record===============================================<

			// update header
			sihdrbd.createOrUpdate(sihdrdao, user);

			// update order charges
			Hashtable<Integer, Ordercharge> orderhdrs = new Hashtable<Integer, Ordercharge>();
			OrderchargeBD _orderchargeBD = new OrderchargeBD(
					this.getSessionFactoryClusterMap());
			Iterator it = _orderchargeBD.findOrderchargesBySihdrId(
					sihdrdao.getSihdrId()).iterator();
			while (it.hasNext()) {
				// init
				Ordercharge _orderchargeDAO = (Ordercharge) it.next();
				_orderchargeDAO.setInvoicestatus("PRINTED");
				_orderchargeDAO.setInvoiceno(sihdrdao.getInvoiceno());
				_orderchargeBD.createOrUpdate(_orderchargeDAO, user);

				// compile list to update Order headers information
				if (orderhdrs.get(_orderchargeDAO.getOrderhdrId()) == null) {
					orderhdrs.put(_orderchargeDAO.getOrderhdrId(),
							_orderchargeDAO);
				}

			} // end list loop

			// process order headers
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + "  order headers to update: "
					+ orderhdrs.keys().toString());

			for (Enumeration enum2 = orderhdrs.keys(); enum2.hasMoreElements();) {
				Integer orderhdrId = (Integer) enum2.nextElement();
				// update header information
				OrderhdrBD orderhdrbd = new OrderhdrBD(
						this.getSessionFactoryClusterMap());
				Orderhdr orderhdrdao = null;
				try {
					orderhdrdao = orderhdrbd.read(orderhdrId);
				} catch (Exception e) {
				}
				if (orderhdrdao != null) {
					orderhdrdao.setInvoicestatus(orderhdrbd
							.getOrderhdrInvoicestatus(sihdrdao.getSihdrId()
									.toString()));
					orderhdrbd.createOrUpdate(orderhdrdao, user);
				}
				orderhdrbd = null;
			}

		}// end of check

		// clear bd
		sihdrbd = null;

	}

}
