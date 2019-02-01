package com.bureaueye.beacon.action.report.laker;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.struts.action.ActionMessages;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.report.Reportworktable;
import com.bureaueye.beacon.model.report.bd.ReportworktableBD;
import com.bureaueye.beacon.model.report.dto.ReportworktableDTO;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;

import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-01 WSI-201312-0001 BEACON LAKER (WSI LINER) - Sales Report
 * 
 */
public final class ReportSalesAction extends BaseAction {

	private static Document pdfDocument;

	private static int rowCounter = 0;
	private static int pageNumber = 0;
	private static int PAGE_ROW_MAXIMUM = 40;

	private static Font font;
	private static Font fontBold;
	private static Font fontHeading;
	private static int CELL_BORDER = 0;
	private static BaseColor headingColor = new BaseColor(180, 43, 22);

	public ReportSalesAction() {
		try {
			// init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(
					com.bureaueye.beacon.bean.Constants.FONT_NAME,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			float fontSize = com.bureaueye.beacon.bean.Constants.FONT_SIZE - 2;
			font = new Font(baseFont, fontSize,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontHeading = new Font(font.getFamily(), font.getSize() + 4,
					fontBold.getStyle());
			fontHeading.setColor(headingColor);
		} catch (Exception e) {
		}
	}

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		ListForm listForm = (ListForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		// default order parameters
		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals(""))
			listForm.setOrderBy("sihdr.Createdate");
		if (listForm.getOrderByDesc() == null
				|| listForm.getOrderByDesc().equals(""))
			listForm.setOrderByDesc("");

		if (listForm.getSearchString9() != null
				&& listForm.getSearchString9().equals("PDF")) {

			// init business delgate
			SidtlBD sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
			ReportworktableBD reportworktablebd = new ReportworktableBD(
					this.getSessionFactoryClusterMap());
			String reportkey = this.getClass().getName() + "|"
					+ new java.util.Date() + "|" + user.getUserid();

			// store MTD dates
			listForm.setSearchDate3(listForm.getSearchDate1());
			listForm.setSearchDate4(listForm.getSearchDate2());
			// set YTD date parameters
			Calendar c = Calendar.getInstance();
			c.setTime(listForm.getSearchDate3());
			c.set(Calendar.DAY_OF_YEAR, 1);
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {
			}

			// retrieve sales invoice details for YTD
			List dtos = null;
			try {
				dtos = sidtlbd.findSidtlsForWSILSalesreport(listForm);
			} catch (ApplicationException ae) {
			}

			log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
			+ "  ListForm parameters: "+listForm.toString());
			
			// BUILD REPORT WORK TABLE--------------------------------->
			if (dtos != null && dtos.size() > 0) {
				// process list collection
				Iterator it = dtos.iterator();
				while (it.hasNext()) {

					SidtlDTO lineItem = (SidtlDTO) it.next();

					try {
						// create work table record
						Reportworktable reportwork = new Reportworktable();
						reportwork.setReportkey(reportkey);
						reportwork.setField1(lineItem.getCompanykey());
						reportwork.setField2(lineItem.getSihdradddata3());// direction
						reportwork.setField3(lineItem.getAdddata2());// accrep
						reportwork.setField4(lineItem.getCustomeraddrkey2());// customer
						reportwork.setField5(lineItem.getSihdradddata4());// service
						reportwork.setField6(lineItem.getAdddata3());// commission
						// type
						reportwork.setField7(lineItem.getAdddata6());// shipper
						// code
						reportwork.setField41(new Integer(lineItem
								.getAdddata4()));// TEUS
						reportwork.setField31(lineItem.getInvoiceamt());
						reportwork.setField21(lineItem.getPrintdate());

						reportworktablebd.createOrUpdate(reportwork, user);

					} catch (Exception npe) {
					}

				} // end list loop

				// PROCESS YTD --------------------------------->
				List dtosYTD = null;
				listForm.setSearchString10(reportkey);
				try {
					dtosYTD = reportworktablebd.salesReportGroup(listForm);
				} catch (ApplicationException ae) {
				}

				if (dtosYTD != null && dtosYTD.size() > 0) {
					// process list collection
					Iterator it2 = dtosYTD.iterator();
					while (it2.hasNext()) {

						ReportworktableDTO lineItem = (ReportworktableDTO) it2
								.next();

						try {
							// create work table record
							Reportworktable reportwork = new Reportworktable();
							reportwork.setReportkey(reportkey + "|YTD");
							reportwork.setField1(lineItem.getField1());// company
							reportwork.setField2(lineItem.getField2());// direction
							reportwork.setField3(lineItem.getField3());// accrep
							reportwork.setField4(lineItem.getField4());// customer
							reportwork.setField5(lineItem.getField5());// service
							reportwork.setField6(lineItem.getField6());// commission
							// type
							reportwork.setField7(lineItem.getField7());// shipper
							// code
							reportwork.setField41(lineItem.getField41());// TEUS
							reportwork.setField31(lineItem.getField31());// INVOICEAMT

							reportworktablebd.createOrUpdate(reportwork, user);

						} catch (Exception npe) {
						}

					} // end list loop
				}
				// PROCESS YTD ---------------------------------<

				// reset MTD dates
				listForm.setSearchDate1(listForm.getSearchDate3());
				listForm.setSearchDate2(listForm.getSearchDate4());

				// PROCESS MTD --------------------------------->
				List dtosMTD = null;
				listForm.setSearchString10(reportkey);
				try {
					dtosMTD = reportworktablebd.salesReportGroup(listForm);
				} catch (ApplicationException ae) {
				}

				if (dtosMTD != null && dtosMTD.size() > 0) {
					// process list collection
					Iterator it3 = dtosMTD.iterator();
					while (it3.hasNext()) {

						ReportworktableDTO lineItem = (ReportworktableDTO) it3
								.next();

						try {
							// create work table record
							Reportworktable reportwork = new Reportworktable();
							reportwork.setReportkey(reportkey + "|MTD");
							reportwork.setField1(lineItem.getField1());// company
							reportwork.setField2(lineItem.getField2());// direction
							reportwork.setField3(lineItem.getField3());// accrep
							reportwork.setField4(lineItem.getField4());// customer
							reportwork.setField5(lineItem.getField5());// service
							reportwork.setField6(lineItem.getField6());// commission
							// type
							reportwork.setField7(lineItem.getField7());// shipper
							// code
							reportwork.setField41(lineItem.getField41());// TEUS
							reportwork.setField31(lineItem.getField31());// INVOICEAMT

							reportworktablebd.createOrUpdate(reportwork, user);

						} catch (Exception npe) {
						}

					} // end list loop
				}
				// PROCESS MTD ---------------------------------<

			}
			// BUILD REPORT WORK TABLE--------------------------------->

			// RETREIVE RECORDS IN ORDER --------------------------------->
			List dtosORDER = null;
			listForm.setSearchString10(reportkey + "|YTD");
			try {
				dtosORDER = reportworktablebd.salesReportOrder(listForm);
			} catch (ApplicationException ae) {
			}
			// RETREIVE RECORDS IN ORDER ---------------------------------<

			//
			if (dtosORDER != null && dtosORDER.size() > 0) {

				// work fields
				listForm.setSearchString10("");
				listForm.setSearchString11("");
				listForm.setSearchString12("");
				listForm.setSearchString13("");
				listForm.setSearchString14("");
				listForm.setSearchString15("");
				listForm.setSearchString16("");
				listForm.setSearchString17("");
				listForm.setSearchString18("");
				listForm.setSearchString19("");

				// group totals
				BigDecimal group1FreightYTD = new BigDecimal(0.0);
				BigDecimal group1FreightMTD = new BigDecimal(0.0);
				Integer group1TeuYTD = new Integer(0);
				Integer group1TeuMTD = new Integer(0);
				BigDecimal group2FreightYTD = new BigDecimal(0.0);
				BigDecimal group2FreightMTD = new BigDecimal(0.0);
				Integer group2TeuYTD = new Integer(0);
				Integer group2TeuMTD = new Integer(0);
				BigDecimal group3FreightYTD = new BigDecimal(0.0);
				BigDecimal group3FreightMTD = new BigDecimal(0.0);
				Integer group3TeuYTD = new Integer(0);
				Integer group3TeuMTD = new Integer(0);
				BigDecimal totalFreightYTD = new BigDecimal(0.0);
				BigDecimal totalFreightMTD = new BigDecimal(0.0);
				Integer totalTeuYTD = new Integer(0);
				Integer totalTeuMTD = new Integer(0);
				CurrencyFormatter cf = new CurrencyFormatter();

				try {

					// convert report to PDF format
					// init document
					pdfDocument = new Document();
					// init pagesize default for user
					pdfDocument = new Document(PageSize.A4.rotate(), 50f, 50f,
							50f, 50f);// landscape

					// we set the ContentType and create an instance of the
					// corresponding Writer
					response.setContentType("application/pdf");
					PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument,
							response.getOutputStream());

					// set document
					pdfDocument.open();

					//
					pageNumber = 0;
					Iterator it4 = dtosORDER.iterator();
					rowCounter = 0;
					while (it4.hasNext()) {

						// get data transfer object from list
						ReportworktableDTO lineItem = (ReportworktableDTO) it4
								.next();

						try {

							//
							String groupKey1 = lineItem.getField1() + "|"
									+ lineItem.getField2() + "|"
									+ lineItem.getField3() + "|"
									+ lineItem.getField4() + "|"
									+ lineItem.getField5() + "|"
									+ lineItem.getField6();
							String breakKey1 = listForm.getSearchString10()
									+ "|" + listForm.getSearchString11() + "|"
									+ listForm.getSearchString12() + "|"
									+ listForm.getSearchString13() + "|"
									+ listForm.getSearchString14() + "|"
									+ listForm.getSearchString15();
							//
							String groupKey2 = lineItem.getField1() + "|"
									+ lineItem.getField2() + "|"
									+ lineItem.getField3() + "|"
									+ lineItem.getField4() + "|"
									+ lineItem.getField5();
							String breakKey2 = listForm.getSearchString10()
									+ "|" + listForm.getSearchString11() + "|"
									+ listForm.getSearchString12() + "|"
									+ listForm.getSearchString13() + "|"
									+ listForm.getSearchString14();
							//
							String groupKey3 = lineItem.getField1() + "|"
									+ lineItem.getField2() + "|"
									+ lineItem.getField3() + "|"
									+ lineItem.getField4();
							String breakKey3 = listForm.getSearchString10()
									+ "|" + listForm.getSearchString11() + "|"
									+ listForm.getSearchString12() + "|"
									+ listForm.getSearchString13();

							/*
							 * System.out.println("pageNumber: "+pageNumber);
							 * System.out.println(": ");
							 * System.out.println("groupKey1: "+groupKey1);
							 * System.out.println("breakKey1: "+breakKey1);
							 * System.out.println(": ");
							 * System.out.println("groupKey2: "+groupKey2);
							 * System.out.println("breakKey2: "+breakKey2);
							 * System.out.println(": ");
							 * System.out.println("groupKey3: "+groupKey3);
							 * System.out.println("breakKey3: "+breakKey3);
							 * System.out.println(
							 * "---------------------------------------- ");
							 */

							// first page do not check footer
							if (pageNumber > 0) {

								// check commission group break
								if (!groupKey1.equals(breakKey1)) {
									// set total fields
									listForm.setSearchString16(cf
											.format(group1FreightMTD));
									listForm.setSearchString17(cf
											.format(group1FreightYTD));
									listForm.setSearchString18(group1TeuMTD
											.toString());
									listForm.setSearchString19(group1TeuYTD
											.toString());
									// output footer
									pdfDocument.add(groupFooter1(listForm));
									// reset group totals
									group1FreightYTD = new BigDecimal(0.0);
									group1FreightMTD = new BigDecimal(0.0);
									group1TeuYTD = new Integer(0);
									group1TeuMTD = new Integer(0);
								}

								// check service group break
								if (!groupKey2.equals(breakKey2)) {
									// set total fields
									listForm.setSearchString16(cf
											.format(group2FreightMTD));
									listForm.setSearchString17(cf
											.format(group2FreightYTD));
									listForm.setSearchString18(group2TeuMTD
											.toString());
									listForm.setSearchString19(group2TeuYTD
											.toString());
									// output footer
									pdfDocument.add(groupFooter2(listForm));
									// reset group totals
									group2FreightYTD = new BigDecimal(0.0);
									group2FreightMTD = new BigDecimal(0.0);
									group2TeuYTD = new Integer(0);
									group2TeuMTD = new Integer(0);
								}

								// check representative group break
								if (!groupKey3.equals(breakKey3)) {
									// set total fields
									listForm.setSearchString16(cf
											.format(group3FreightMTD));
									listForm.setSearchString17(cf
											.format(group3FreightYTD));
									listForm.setSearchString18(group3TeuMTD
											.toString());
									listForm.setSearchString19(group3TeuYTD
											.toString());
									// output footer
									pdfDocument.add(groupFooter3(listForm));
									// reset group totals
									group3FreightYTD = new BigDecimal(0.0);
									group3FreightMTD = new BigDecimal(0.0);
									group3TeuYTD = new Integer(0);
									group3TeuMTD = new Integer(0);
								}

							}// check not first page

							// check group key3 break
							if (!groupKey3.equals(breakKey3)) {
								listForm.setSearchString10(lineItem.getField1());// company
								listForm.setSearchString11(lineItem.getField2());// direction
								listForm.setSearchString12(lineItem.getField3());// accrep
								listForm.setSearchString13(lineItem.getField4());// customer

								// force new page
								rowCounter = PAGE_ROW_MAXIMUM;
								newPage(listForm, 0);
							}// page break check

							// service group header
							if (!groupKey2.equals(breakKey2)) {
								listForm.setSearchString14(lineItem.getField5());// service
								// output header
								pdfDocument.add(groupHeader2(listForm,
										this.getSessionFactoryClusterMap()));
							}

							// commission group header
							if (!groupKey1.equals(breakKey1)) {
								listForm.setSearchString15(lineItem.getField6());// commission
								// type
								// output header
								pdfDocument.add(groupHeader1(listForm,
										this.getSessionFactoryClusterMap()));
							}

							// find work table MTD------------------------->
							Integer teusMTD = new Integer(0);
							BigDecimal freightMTD = new BigDecimal(0.0);
							try {
								Reportworktable lineItemMTD = reportworktablebd
										.findSalesReportMTD(reportkey+"|MTD",
												lineItem.getField1(),
												lineItem.getField2(),
												lineItem.getField3(),
												lineItem.getField4(),
												lineItem.getField5(),
												lineItem.getField6(),
												lineItem.getField7());
								if (lineItemMTD != null) {
									teusMTD = lineItemMTD.getField41();
									freightMTD = lineItemMTD.getField31();
								}
							} catch (Exception e) {
							}
							// find work table MTD-------------------------<

							// output detail
							pdfDocument.add(detail(lineItem, listForm, teusMTD,
									freightMTD,
									this.getSessionFactoryClusterMap()));

							// increment group totals
							try {
								group1FreightYTD = group1FreightYTD
										.add(lineItem.getField31());
							} catch (Exception e) {
							}
							try {
								group1FreightMTD = group1FreightMTD
										.add(freightMTD);
							} catch (Exception e) {
							}
							try {
								group1TeuYTD = group1TeuYTD
										+ lineItem.getField41();
							} catch (Exception e) {
							}
							try {
								group1TeuMTD = group1TeuMTD + teusMTD;
							} catch (Exception e) {
							}
							try {
								group2FreightYTD = group2FreightYTD
										.add(lineItem.getField31());
							} catch (Exception e) {
							}
							try {
								group2FreightMTD = group2FreightMTD
										.add(freightMTD);
							} catch (Exception e) {
							}
							try {
								group2TeuYTD = group2TeuYTD
										+ lineItem.getField41();
							} catch (Exception e) {
							}
							try {
								group2TeuMTD = group2TeuMTD + teusMTD;
							} catch (Exception e) {
							}
							try {
								group3FreightYTD = group3FreightYTD
										.add(lineItem.getField31());
							} catch (Exception e) {
							}
							try {
								group3FreightMTD = group3FreightMTD
										.add(freightMTD);
							} catch (Exception e) {
							}
							try {
								group3TeuYTD = group3TeuYTD
										+ lineItem.getField41();
							} catch (Exception e) {
							}
							try {
								group3TeuMTD = group3TeuMTD + teusMTD;
							} catch (Exception e) {
							}
							try {
								totalFreightYTD = totalFreightYTD.add(lineItem
										.getField31());
							} catch (Exception e) {
							}
							try {
								totalFreightMTD = totalFreightMTD
										.add(freightMTD);
							} catch (Exception e) {
							}
							try {
								totalTeuYTD = totalTeuYTD
										+ lineItem.getField41();
							} catch (Exception e) {
							}
							try {
								totalTeuMTD = totalTeuMTD + teusMTD;
							} catch (Exception e) {
							}

							/*
							 * System.out.println("in loop rowCounter: "+rowCounter
							 * ); System.out.println(
							 * "---------------------------------------- ");
							 */

						} catch (Exception e) {
						}

					} // end list loop

					// last record output footers
					// commission group footer
					listForm.setSearchString16(cf.format(group1FreightMTD));
					listForm.setSearchString17(cf.format(group1FreightYTD));
					listForm.setSearchString18(group1TeuMTD.toString());
					listForm.setSearchString19(group1TeuYTD.toString());
					pdfDocument.add(groupFooter1(listForm));

					// service group footer
					listForm.setSearchString16(cf.format(group2FreightMTD));
					listForm.setSearchString17(cf.format(group2FreightYTD));
					listForm.setSearchString18(group2TeuMTD.toString());
					listForm.setSearchString19(group2TeuYTD.toString());
					pdfDocument.add(groupFooter2(listForm));

					// representative group footer
					listForm.setSearchString16(cf.format(group3FreightMTD));
					listForm.setSearchString17(cf.format(group3FreightYTD));
					listForm.setSearchString18(group3TeuMTD.toString());
					listForm.setSearchString19(group3TeuYTD.toString());
					pdfDocument.add(groupFooter3(listForm));

					/*
					 * System.out.println("end rowCounter: "+rowCounter);
					 * System.
					 * out.println("---------------------------------------- ");
					 */

					// totals=======================================================>
					// new page and increment page number
					// force new page
					rowCounter = PAGE_ROW_MAXIMUM;
					newPage(listForm, 0);
					// company footer
					listForm.setSearchString16(cf.format(totalFreightMTD));
					listForm.setSearchString17(cf.format(totalFreightYTD));
					listForm.setSearchString18(totalTeuMTD.toString());
					listForm.setSearchString19(totalTeuYTD.toString());
					pdfDocument.add(totalFooter(listForm));
					// totals=======================================================<

					// close the document (the output is also closed internally)
					pdfDocument.close();

				} catch (DocumentException de) {
				} catch (Exception e) {
				} finally {
				}

				//
			}// end dtosORDER check

			// CLEAR REPORT WORKTABLE----------------------------->
			try { 
				reportworktablebd.clearByReportkey(reportkey, user); 
			} catch (Exception e) { } 
			// CLEAR----------------------------------------------<

			// clear
			sidtlbd = null;
			reportworktablebd = null;

			return null;

		} // end of PDF check

		// Calculate the total number of results before any buttons are
		// generated
		setTotalResults(listForm);

		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}

	public void setTotalResults(ListForm listForm) throws ApplicationException {

		Calendar c = Calendar.getInstance();
		// date 'from'
		if (listForm.getSearchDate1() == null) {
			c.set(Calendar.DAY_OF_MONTH, 1);
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {
			}
		}
		// date 'to'
		if (listForm.getSearchDate2() == null) {
			// default 'to' date plus 7
			c.setTime(new Date());
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}
		}

		// default to PDF to output
		if (listForm.getSearchString9() != null
				&& listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("PDF");
		}

	}

	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {

		return null;

	}

	public void newPage(ListForm listForm, int rowIncrement)
			throws DocumentException, Exception {

		//System.out.println("rowCounter+rowIncrement: "+ (rowCounter + rowIncrement));

		// check row count plus next row increment is
		// not greater than maximum rows per page
		if ((rowCounter + rowIncrement) >= PAGE_ROW_MAXIMUM) {
			// new page and increment page number
			pdfDocument.newPage();
			pageNumber++;

			// output page headers
			pdfDocument.add(pageHeader1());

			pdfDocument.add(pageHeader2(listForm,
					this.getSessionFactoryClusterMap()));

			// reset row counter
			rowCounter = 0;
		}

	}

	public PdfPTable pageHeader1() throws DocumentException,
			BadElementException, Exception {

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell = new PdfPCell(new Phrase("", font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(5f);
			_BlankCell.setBorder(0);

			// report title
			float[] widths1_2 = { 0.99f, 0.01f };
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.addCell(new Phrase("SALES REPORT", fontHeading));
			_Table1_2.addCell(new Phrase("" + pageNumber, fontBold));
			_Table1_2.addCell(new Phrase("Run at "
					+ Util.dateTimeFormat(new Date()), fontBold));
			_Table1_2.addCell(new Phrase(" ", font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable pageHeader2(ListForm listForm,
			Map<String, SessionFactory> sessionFactoryClusterMap)
			throws DocumentException, BadElementException, SQLException,
			Exception {

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(5f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);

			// report parameters
			float[] widths1_1a = { 0.15f, 0.85f };
			PdfPTable _Table1_1a = new PdfPTable(widths1_1a);
			_Table1_1a.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_1a.addCell(new Phrase("DATE RANGE:", fontBold));
			_Table1_1a.addCell(new Phrase(Util.dateTextFormat2(listForm
					.getSearchDate1())
					+ " to "
					+ Util.dateTextFormat2(listForm.getSearchDate2()), font));

			_PdfPCell = new PdfPCell(_Table1_1a);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			float[] widths1_1 = { 0.15f, 0.05f, 0.80f };
			PdfPTable _Table1_1 = new PdfPTable(widths1_1);
			_Table1_1.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_1.addCell(new Phrase("COMPANY:", fontBold));
			_Table1_1.addCell(new Phrase(listForm.getSearchString10(), font));
			_Table1_1.addCell(new Phrase("", font));
			_Table1_1.addCell(new Phrase("DIRECTION:", fontBold));
			_Table1_1.addCell(new Phrase(listForm.getSearchString11(), font));
			_Table1_1.addCell(new Phrase("", font));
			_Table1_1.addCell(new Phrase("REPRESENTATIVE:", fontBold));
			_Table1_1.addCell(new Phrase(listForm.getSearchString12(), font));
			_Table1_1.addCell(new Phrase("", font));
			_Table1_1.addCell(new Phrase("LINE:", fontBold));
			_Table1_1.addCell(new Phrase(listForm.getSearchString13(), font));
			_Table1_1.addCell(new Phrase("", font));

			_PdfPCell = new PdfPCell(_Table1_1);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// column headers
			float[] widths1_3 = { 0.10f, 0.3f, 0.15f, 0.05f, 0.12f, 0.12f,
					0.08f, 0.08f };

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			PdfPCell cell = new PdfPCell();
			cell.setBorder(Rectangle.BOTTOM);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderColorBottom(BaseColor.BLACK);

			cell.setPhrase(new Phrase("SHPR", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("NAME", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("CITY", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("ST", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("FREIGHT MTD", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("FREIGHT YTD", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("TEUS MTD", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase("TEUS YTD", fontBold));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable groupHeader1(ListForm listForm,
			Map<String, SessionFactory> sessionFactoryClusterMap)
			throws DocumentException, BadElementException, SQLException,
			Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(2f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			// insert blank row
			_Table1.addCell(blankCell);

			// group1
			float[] widths1_5 = { 0.15f, 0.85f };
			PdfPTable _Table1_5 = new PdfPTable(widths1_5);
			_Table1_5.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_5.addCell(new Phrase("COMMISSION TYPE:", fontBold));
			_Table1_5.addCell(new Phrase(listForm.getSearchString15(), font));

			_PdfPCell = new PdfPCell(_Table1_5);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter by 2 rows
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable groupHeader2(ListForm listForm,
			Map<String, SessionFactory> sessionFactoryClusterMap)
			throws DocumentException, SQLException, Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(2f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			_Table1.addCell(blankCell);

			// group2
			float[] widths1_6 = { 0.15f, 0.05f, 0.80f };
			PdfPTable _Table1_6 = new PdfPTable(widths1_6);
			_Table1_6.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_6.addCell(new Phrase("SERVICE:", fontBold));
			_Table1_6.addCell(new Phrase(listForm.getSearchString14(), font));
			_Table1_6.addCell(new Phrase("", font));

			_PdfPCell = new PdfPCell(_Table1_6);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter by 2 rows
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable detail(ReportworktableDTO lineItem, ListForm listForm,
			Integer teusMTD, BigDecimal freightMTD,
			Map<String, SessionFactory> sessionFactoryClusterMap)
			throws DocumentException, BadElementException {

		// check new page required
		int rowIncrement = 1;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		// get shipper details------------------------->
		String shipperName = "";
		String shipperCity = "";
		String shipperState = "";
		AddressBD addressbd = new AddressBD(sessionFactoryClusterMap);
		try {
			Address shipperAddress = addressbd
					.findAddressByExtsysaddressid(lineItem.getField7());
			if (shipperAddress != null) {
				shipperName = shipperAddress.getName();
				shipperCity = shipperAddress.getCity();
				shipperState = shipperAddress.getState();
			}
		} catch (Exception e) {
		}
		addressbd = null;
		// get shipper details-------------------------<

		try {

			// working cell
			PdfPCell pdfPCell = new PdfPCell();
			;
			pdfPCell.setColspan(1);
			pdfPCell.setBorder(CELL_BORDER);

			// details
			float[] widths1_4 = { 0.1f, 0.3f, 0.15f, 0.05f, 0.12f, 0.12f,
					0.08f, 0.08f };

			PdfPTable _Table1_4 = new PdfPTable(widths1_4);
			_Table1_4.getDefaultCell().setBorder(CELL_BORDER);

			// record1
			try {
				pdfPCell.setPhrase(new Phrase(lineItem.getField7(), font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(shipperName, font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(shipperCity, font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(shipperState, font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(freightMTD.toString(), font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(lineItem.getField31().toString(),
						font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(teusMTD.toString(), font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			try {
				pdfPCell.setPhrase(new Phrase(lineItem.getField41().toString(),
						font));
				pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				_Table1_4.addCell(pdfPCell);
			} catch (NullPointerException e) {
				_Table1_4.addCell(new Phrase("", font));
			}

			pdfPCell = new PdfPCell(_Table1_4);
			pdfPCell.setColspan(1);
			pdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(pdfPCell);

			// increment row
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable groupFooter1(ListForm listForm) throws DocumentException,
			BadElementException, SQLException, Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(2f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			// insert blank row
			_Table1.addCell(blankCell);

			float[] widths1_3 = { 0.6f, 0.12f, 0.12f, 0.08f, 0.08f };
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			PdfPCell cell = new PdfPCell();
			cell.setBorder(0);

			cell.setPhrase(new Phrase("COMMISSION TYPE TOTAL:", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);

			cell.setPhrase(new Phrase(listForm.getSearchString16(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString17(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString18(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString19(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable groupFooter2(ListForm listForm) throws DocumentException,
			SQLException, Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(2f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			// insert blank row
			_Table1.addCell(blankCell);

			float[] widths1_3 = { 0.6f, 0.12f, 0.12f, 0.08f, 0.08f };
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			PdfPCell cell = new PdfPCell();
			cell.setBorder(0);

			cell.setPhrase(new Phrase("SERVICE TOTAL:", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);

			cell.setPhrase(new Phrase(listForm.getSearchString16(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString17(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString18(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString19(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable groupFooter3(ListForm listForm) throws DocumentException,
			SQLException, Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(2f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			// insert blank row
			_Table1.addCell(blankCell);

			float[] widths1_3 = { 0.6f, 0.12f, 0.12f, 0.08f, 0.08f };
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			PdfPCell cell = new PdfPCell();
			cell.setBorder(0);

			cell.setPhrase(new Phrase("REPRESENTATIVE TOTAL:", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);

			cell.setPhrase(new Phrase(listForm.getSearchString16(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString17(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString18(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString19(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

	public PdfPTable totalFooter(ListForm listForm) throws DocumentException,
			SQLException, Exception {

		// check new page required
		int rowIncrement = 2;
		try {
			newPage(listForm, rowIncrement);
		} catch (Exception e) {
		}

		PdfPTable _Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);
		_Table1.setWidthPercentage(100f);
		_Table1.getDefaultCell().setPadding(2);

		try {

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell blankCell = new PdfPCell(new Phrase("", font));
			blankCell.setFixedHeight(15f);
			blankCell.setColspan(1);
			blankCell.setBorder(0);
			// insert blank row
			_Table1.addCell(blankCell);

			float[] widths1_3 = { 0.6f, 0.12f, 0.12f, 0.08f, 0.08f };
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

			PdfPCell cell = new PdfPCell();
			cell.setBorder(0);

			cell.setPhrase(new Phrase("COMPANY TOTAL:", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			_Table1_3.addCell(cell);

			cell.setBorder(Rectangle.TOP);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorTop(BaseColor.BLACK);

			cell.setPhrase(new Phrase(listForm.getSearchString16(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString17(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString18(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			cell.setPhrase(new Phrase(listForm.getSearchString19(), font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_3.addCell(cell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);
			_PdfPCell.setBorder(CELL_BORDER);
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_Table1.addCell(blankCell);

			// increment row counter
			rowCounter = rowCounter + rowIncrement;

		} catch (Exception e) {
		}

		return _Table1;

	}

}
