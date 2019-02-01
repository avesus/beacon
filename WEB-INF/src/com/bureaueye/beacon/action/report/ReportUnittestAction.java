package com.bureaueye.beacon.action.report;



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

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.report.UnittestLineItem;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
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





public final class ReportUnittestAction extends BaseAction {


	private static Document _Document;
	private static PdfPTable _Table1;	

	private static int CELL_BORDER = 0;

	HSSFWorkbook wb;
	HSSFSheet sheet;


	Font font;
	Font fontBold;	
	Font fontLarge;
	Font fontLargeBold;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading;
	Font fontBoldUnderline;

	private static BaseColor headingColor = new BaseColor(180, 43, 22);


	public ReportUnittestAction() {
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
			fontLargeBold = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
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

		// default order parameters
		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals("")) 
			listForm.setOrderBy("unit.Unitkey");
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("Asc");

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

		// set line items
		List dtos = null;
		if (listForm.getSearchString9() != null && !listForm.getSearchString9().equals("")) {
			try {
				dtos = new UnittestBD(this.getSessionFactoryClusterMap()).findUnittestsByDuedate(listForm);
			} catch (ApplicationException ae) {}
		}


		if (
				listForm.getSearchString9() != null && 
				listForm.getSearchString9().equals("PDF") && 
				dtos.size() > 0
		) {
			try {

				// convert report to PDF format
				_Document = new Document(PageSize.A4.rotate(), 20, 20, 100, 100);//landscape
				_Document.setPageCount(1);			


				// step 2: we set the ContentType and create an instance of the corresponding Writer				
				response.setContentType("application/pdf");
				PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());


				_Document.open();	

				PdfPTable header = getHeader();
				_PdfWriter.setPageEvent(new EndPageEvent(header));

				// create main table and add it to the document
				_Table1 = new PdfPTable(1);
				_Table1.getDefaultCell().setBorder(0);
				_Table1.getDefaultCell().setNoWrap(false);            		
				_Table1.setWidthPercentage(100f);  
				_Table1.getDefaultCell().setPadding(0);




				if (dtos != null && dtos.size() > 0) {  

					// process list collection
					Iterator it = dtos.iterator();
					int row = 0;
					while (it.hasNext()) {
						// init 
						UnittestLineItem lineItem = (UnittestLineItem) it.next();

						// init select parameter					
						try {							
							// output to PDF
							outputDetailToPDF(lineItem);
						}
						catch (NullPointerException npe) {
						}	    	    		
						// increment pointer
						row++;	
					} // end list loop				
				}



				// add main table to PDF document
				_Document.add(_Table1);  

				// step 4: we close the document (the outputstream is also closed internally)
				_Document.close(); 

				return null; 

			}
			catch (BadElementException bee) {
			}		
			catch (DocumentException de) {
			}
			catch (Exception e) {
			}
			finally {
			}	

		} // end of PDF check



		if (listForm.getSearchString9() != null && listForm.getSearchString9().equals("EXCEL")) {
			try {	

				response.setContentType("application/vnd.ms-excel");

				wb = new HSSFWorkbook();
				sheet = wb.createSheet("Unit Test Due Report");

				// 
				outputHeaderToEXCEL();   			


				if (dtos != null && dtos.size() > 0) {  

					// process list collection
					Iterator it = dtos.iterator();
					int row = 1;
					while (it.hasNext()) {
						// init 
						UnittestLineItem lineItem = (UnittestLineItem) it.next();

						// init select parameter					
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
			}	

		} // end of EXCEL check




		// Calculate the total number of results before any buttons are
		// generated
		setTotalResults(listForm);


		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}


		// Set a transactional control token to prevent double posting
		// log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Setting transactional control token");
		// saveToken(request);

		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {

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
		if (listForm.getSearchString9() == null) {			
			listForm.setSearchString9("PDF");			
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
		row.createCell((short)0).setCellValue("unit");
		row.createCell((short)1).setCellValue("due date");
		row.createCell((short)2).setCellValue("test date");
		row.createCell((short)3).setCellValue("test by");
		row.createCell((short)4).setCellValue("test type");			

	}


	public void outputDetailToEXCEL(UnittestLineItem lineItem, int count) 
	throws DocumentException, BadElementException
	{

		// Create label column row 
		HSSFRow row = sheet.createRow((short)count);

		// we style the second cell as a date (and time).  It is important to
		// create a new cell style from the workbook otherwise you can end up
		// modifying the built in style and effecting not only this cell but other cells.
		HSSFCellStyle dateCellStyle = wb.createCellStyle();
		dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

		// Create a cell and put a value in it.
		row.createCell((short)0).setCellValue(lineItem.getUnitkey());

		HSSFCell dateCell = row.createCell((short)1);
		if (lineItem.getDuedate() != null) {
			dateCell.setCellValue( lineItem.getDuedate() );
			dateCell.setCellStyle(dateCellStyle);
		}
		else {
			row.createCell((short)1).setCellValue( "" );		        	
		}

		dateCell = row.createCell((short)2);
		if (lineItem.getCompdate() != null) { 
			dateCell.setCellValue( lineItem.getCompdate() );
			dateCell.setCellStyle(dateCellStyle);
		}
		else {
			row.createCell((short)2).setCellValue( "" );		        	
		}

		row.createCell((short)3).setCellValue(lineItem.getTestby());
		row.createCell((short)4).setCellValue(lineItem.getTesttypekey());			

	}


	public PdfPTable getHeader() throws DocumentException, BadElementException, SQLException, Exception
	{

		PdfPTable _Table1 = new PdfPTable(1);

		try {  	

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("UNIT TEST DUE REPORT",fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_3 =  {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		


			_Table1_3.addCell(new Phrase("Unit",fontBold));				
			_Table1_3.addCell(new Phrase("Due Date",fontBold));
			_Table1_3.addCell(new Phrase("Test Date",fontBold));	
			_Table1_3.addCell(new Phrase("Test by",fontBold));	
			_Table1_3.addCell(new Phrase("Test type",fontBold));	

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

		return _Table1;
	}


	public void outputHeaderToPDF() 
	throws DocumentException, BadElementException
	{

		try {  	

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_2 = {0.95f, 0.05f}; 
			PdfPTable _Table1_2 = new PdfPTable(widths1_2);
			_Table1_2.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_2.addCell(new Phrase("UNIT TEST DUE REPORT",fontHeading));
			_Table1_2.addCell(new Phrase("",font));
			_Table1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			_Table1_2.addCell(new Phrase("",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_3 =  {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			// insert blank row
			_BlankCell.setColspan(5);
			_Table1_3.addCell(_BlankCell);

			_Table1_3.addCell(new Phrase("Unit",fontBold));				
			_Table1_3.addCell(new Phrase("Due Date",fontBold));
			_Table1_3.addCell(new Phrase("Test Date",fontBold));	
			_Table1_3.addCell(new Phrase("Test by",fontBold));	
			_Table1_3.addCell(new Phrase("Test type",fontBold));	

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}		
	}	


	public void outputDetailToPDF(UnittestLineItem lineItem) 
	throws DocumentException, BadElementException
	{		
		try {  	

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_3 = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f}; 

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			try {_Table1_3.addCell(new Phrase(lineItem.getUnitkey(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getDuedate()),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getCompdate()),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}	

			try {_Table1_3.addCell(new Phrase(lineItem.getTestby(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}		
			try {_Table1_3.addCell(new Phrase(lineItem.getTesttypekey(),font));	}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}	

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

		}
		catch (Exception e) {
		}		
	}	


}
