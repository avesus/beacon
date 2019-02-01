package com.bureaueye.beacon.action.order.report;



import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;

import com.bureaueye.beacon.action.report.pdf.EndPageEvent;
import com.bureaueye.beacon.bean.report.ReportRow;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;

import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;


import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





/**
 *
 * Amendments
 * ----------
 *
 */

public final class ReportJobActualEstimateAction extends BaseAction {


	private static Document pdfDocument;
	private static PdfPTable pdfTable1;

	private static int CELL_BORDER = 0;


	HSSFWorkbook wb;
	HSSFSheet sheet;


	Font font;
	Font fontBold;	
	Font fontLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading;
	Font fontBoldUnderline;

	private static BaseColor headingColor = new BaseColor(180, 43, 22);


	public ReportJobActualEstimateAction() {
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontLarge = new Font(font.getFamily(), font.getSize()+2, font.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontHeading = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			fontHeading.setColor(headingColor);
		} catch (Exception e) {
		}
	}


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" actionFormName = " + actionFormName + "\t Mapping = "
					+ mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		ListForm listForm = (ListForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");



		// set line items
		List<ReportRow> lineItems = null;
		JobcostBD jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());		


		//check if output selected and first time in 
		if (listForm.getSearchString3() != null && !listForm.getSearchString3().equals("")) {
			listForm.setLineItems(jobcostbd.reportJobActualEstimate(listForm));	
		}
		lineItems=listForm.getLineItems();


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  listForm.toString(): "+listForm.toString());


		if (
				listForm.getSearchString3() != null && 
				listForm.getSearchString3().equals("PDF") && 
				lineItems.size() > 0
		) {
			try {

				// convert report to PDF format
				// init document				
				pdfDocument =  new Document(PageSize.A4.rotate(), 20, 20, 100, 100);//landscape					
				pdfDocument.setPageCount(1);			

				// we set the ContentType and create an instance of the corresponding Writer				
				response.setContentType("application/pdf");
				PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, response.getOutputStream());


				pdfDocument.open();

				PdfPTable header = getHeader();
				pdfWriter.setPageEvent(new EndPageEvent(header));

				// create main table and add it to the document
				pdfTable1 = new PdfPTable(1);
				pdfTable1.getDefaultCell().setBorder(0);
				pdfTable1.getDefaultCell().setNoWrap(false);            		
				pdfTable1.setWidthPercentage(100f);  
				pdfTable1.getDefaultCell().setPadding(0);

				if (lineItems != null && lineItems.size() > 0) {  

					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  lineItems.size(): "+lineItems.size());

					// process list collection
					boolean vendorBreak=false;
					String vendorName="";
					Iterator it = lineItems.iterator();
					int row = 0;
					while (it.hasNext()) {
						ReportRow lineItem = (ReportRow) it.next();

						//check vendor break
						if (!vendorName.equals(lineItem.getCell1())) {
							vendorName=lineItem.getCell1();
							vendorBreak = true;
						}

						// output detail					
						try {							
							// output to PDF
							outputDetailToPDF(lineItem, vendorBreak);
						}
						catch (Exception e) {						
						}	

						//reset vendor break
						vendorBreak = false;
						// increment pointer
						row++;	
					} // end list loop				
				}

				// add main table to PDF document
				pdfDocument.add(pdfTable1);  

				// close the document (the outputstream is also closed internally)
				pdfDocument.close(); 

				return null; 

			}
			catch (BadElementException bee) {
			}		
			catch (DocumentException de) {
			}
			catch (Exception e) {
			}
			finally {
				//clear bd
				jobcostbd=null;
			}	

		} // end of PDF check



		if (listForm.getSearchString3() != null && listForm.getSearchString3().equals("EXCEL")) {
			try {	

				response.setContentType("application/vnd.ms-excel");

				wb = new HSSFWorkbook();
				sheet = wb.createSheet("Cost Actual Vs Estimate");

				// output header
				outputHeaderToEXCEL();   			


				if (lineItems != null && lineItems.size() > 0) {  

					// process list collection
					Iterator it = lineItems.iterator();
					int row = 1;
					while (it.hasNext()) {
						ReportRow lineItem = (ReportRow) it.next();

						// output detail					
						try {							
							// output to 
							outputDetailToEXCEL(lineItem, row);
						}
						catch (NullPointerException npe) {
						}	    	    		
						// increment pointer
						row++;	
					} // end list loop				
				}


				// Write the output to a file
				wb.write(response.getOutputStream());

				return null; 

			}
			catch (Exception e) {
			}		
			finally {
				//clear bd
				jobcostbd=null;
			}	

		} // end of EXCEL check


		// default select fields
		setTotalResults(listForm);

		// default select fields
		setTotalResults(listForm,session);


		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// set default field values
		//default order parameters
		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals("")) 
			listForm.setOrderBy("");
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("");



		//set default max results
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);


		// order no
		if (listForm.getSearchString1() == null) {
			listForm.setSearchString1("");
		}
		// job no
		if (listForm.getSearchString14() == null) {
			listForm.setSearchString14("");
		}
		// vendor
		if (listForm.getSearchString2() == null) {
			listForm.setSearchString2("");
		}
		// cost
		if (listForm.getSearchString4() == null) {
			listForm.setSearchString4("");
		}


		// expiry/active date check
		listForm.setSearchDate3(new Date());


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(
					new SystemcodeBD(
							this.getSessionFactoryClusterMap()
					).read(new SystemcodePK("DATERANGEDAYS","LISTDEFAULT")).getDescr()).intValue();
		}catch(Exception e){}		
		// date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus das range
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus days range 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}


		// default to PDF to output
		if (listForm.getSearchString3() == null) {			
			listForm.setSearchString3("PDF");			
		}

	}


	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {

		//default company
		User user = (User) session.getAttribute(Constants.USER_KEY);
		if (listForm.getSearchString19() == null || listForm.getSearchString19().equals("")) {
			listForm.setSearchString19(user.getCompanykey());
		}

	}


	public ActionMessages setLineItems(
			ListForm listForm
	) throws ApplicationException {

		return null;
	}


	public void outputHeaderToEXCEL() 
	throws DocumentException, BadElementException
	{
		// Create label column row 
		HSSFRow row = sheet.createRow((short)0);

		// Create a cell and put a value in it.
		row.createCell((short)0).setCellValue("Vendor");
		row.createCell((short)1).setCellValue("Job Number");
		row.createCell((short)2).setCellValue("Order Number");
		row.createCell((short)3).setCellValue("Order Date");
		row.createCell((short)4).setCellValue("Cost");
		row.createCell((short)5).setCellValue("Currency");
		row.createCell((short)6).setCellValue("Estimate Amount");
		row.createCell((short)7).setCellValue("Actual Amount");
		row.createCell((short)8).setCellValue("Difference"); 

	}


	public void outputDetailToEXCEL(ReportRow lineItem, int count) 
	{

		try {			


			// Create label column row 
			HSSFRow row = sheet.createRow((short)count);

			// we style the second cell as a date (and time).  It is important to
			// create a new cell style from the workbook otherwise you can end up
			// modifying the built in style and effecting not only this cell but other cells.
			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue(lineItem.getCell1());//vendor

			row.createCell((short)1).setCellValue(lineItem.getCell2());//job number

			row.createCell((short)2).setCellValue(lineItem.getCell3());//order number

			HSSFCell dateCell = row.createCell((short)3);
			if (lineItem.getCell31() != null) {
				dateCell.setCellValue( lineItem.getCell31() );//order date
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)3).setCellValue( "" );		        	
			}	

			row.createCell((short)4).setCellValue(lineItem.getCell4());//cost

			row.createCell((short)5).setCellValue(lineItem.getCell5());//currency


			try {
				row.createCell((short)6).setCellValue(new CurrencyFormatter().format(lineItem.getCell41()));					
			} catch (Exception e) {
				row.createCell((short)6).setCellValue("0.00");	
			}

			try {
				row.createCell((short)7).setCellValue(new CurrencyFormatter().format(lineItem.getCell42()));					
			} catch (Exception e) {
				row.createCell((short)7).setCellValue("0.00");	
			}

			try {
				row.createCell((short)8).setCellValue(new CurrencyFormatter().format(lineItem.getCell43()));					
			} catch (Exception e) {
				row.createCell((short)8).setCellValue("0.00");	
			}


		} catch (Exception e) {

		}

	}


	public PdfPTable getHeader() throws DocumentException, BadElementException, SQLException, Exception
	{

		PdfPTable pdfTable1 = new PdfPTable(1);


		try {  	

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable pdfTable1_2 = new PdfPTable(widths1_2);
			pdfTable1_2.getDefaultCell().setBorder(CELL_BORDER); 
			pdfTable1_2.addCell(new Phrase("JOB COST ACTUAL VS ESTIMATE",fontHeading));
			pdfTable1_2.addCell(new Phrase(" ",font));
			pdfTable1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			pdfTable1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(pdfTable1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			pdfTable1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			pdfTable1.addCell(_BlankCell);


			float[] widths = {0.34f, 0.08f, 0.08f, 0.08f, 0.06f, 0.06f, 0.1f, 0.1f, 0.1f};
			PdfPTable pdfTable1_3 = new PdfPTable(widths);
			pdfTable1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			pdfTable1_3.addCell(new Phrase("Vendor",fontSmallBold));
			pdfTable1_3.addCell(new Phrase("Job Number",fontSmallBold));
			pdfTable1_3.addCell(new Phrase("Order Number",fontSmallBold));
			pdfTable1_3.addCell(new Phrase("Order Date",fontSmallBold));	
			pdfTable1_3.addCell(new Phrase("Cost",fontSmallBold));
			pdfTable1_3.addCell(new Phrase("Currency",fontSmallBold));
			PdfPCell pdfpcell = new PdfPCell(new Phrase("Estimate Amount",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			pdfTable1_3.addCell(pdfpcell);				
			pdfpcell = new PdfPCell(new Phrase("Actual Amount",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			pdfTable1_3.addCell(pdfpcell);	
			pdfpcell = new PdfPCell(new Phrase("Difference",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			pdfTable1_3.addCell(pdfpcell);			


			_PdfPCell = new PdfPCell(pdfTable1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			pdfTable1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

		return pdfTable1;
	}


	public void outputDetailToPDF(ReportRow lineItem, boolean vendorBreak) 
	{		


		try {			

			// working cell
			PdfPCell pdfPCell;

			// define blank cell
			PdfPCell blankCell =  new PdfPCell(new Phrase("",font));
			blankCell.setColspan(2);
			blankCell.setFixedHeight(12f);
			blankCell.setBorder(0);






			float[] widths = {0.34f, 0.08f, 0.08f, 0.08f, 0.06f, 0.06f, 0.1f, 0.1f, 0.1f};
			PdfPTable pdfTable1_3 = new PdfPTable(widths);
			pdfTable1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		


			if (vendorBreak) {
				// insert blank row
				blankCell.setColspan(9);
				pdfTable1_3.addCell(blankCell);
			}


			if (vendorBreak) {
				pdfTable1_3.addCell(new Phrase(lineItem.getCell1(),fontSmall));//vendor
			} else {
				pdfTable1_3.addCell(new Phrase("",fontSmall));//vendor				
			}

			pdfTable1_3.addCell(new Phrase(lineItem.getCell2(),fontSmall));//jobno

			pdfTable1_3.addCell(new Phrase(lineItem.getCell3(),fontSmall));//orderno

			pdfTable1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getCell31()),fontSmall));//orderdate				

			pdfTable1_3.addCell(new Phrase(lineItem.getCell4(),fontSmall));//cost

			pdfTable1_3.addCell(new Phrase(lineItem.getCell5(),fontSmall));//ccy

			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getCell41()),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				pdfTable1_3.addCell(pdfpcell);	   	  		
			} catch (Exception e) {
				pdfTable1_3.addCell(new Phrase("-",fontSmall));				
			}

			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getCell42()),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				pdfTable1_3.addCell(pdfpcell);	   	  		
			} catch (Exception e) {
				pdfTable1_3.addCell(new Phrase("-",fontSmall));				
			}

			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(lineItem.getCell43()),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				pdfTable1_3.addCell(pdfpcell);	   	  		
			} catch (Exception e) {
				pdfTable1_3.addCell(new Phrase("-",fontSmall));				
			}





			pdfPCell = new PdfPCell(pdfTable1_3);
			pdfPCell.setColspan(1);			
			pdfPCell.setBorder(CELL_BORDER);			 	   	
			pdfTable1.addCell(pdfPCell);


		}
		catch (Exception e) {
		}	

	}	





}
