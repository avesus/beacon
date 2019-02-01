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
import com.bureaueye.beacon.model.report.bd.ReportBD;
import com.bureaueye.beacon.model.report.dto.UnitMoveDTO;
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





public final class ReportTimesheetAction extends BaseAction {


	private static Document _Document;
	private static PdfPTable _Table1;	

	private static int CELL_BORDER = 0;

	HSSFWorkbook wb;
	HSSFSheet sheet;
	Long totalMinutes;


	Font font;
	Font fontBold;	
	Font fontLarge;
	Font fontLargeBold;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading;
	Font fontBoldUnderline;

	HSSFCellStyle dateCellStyle;
	
	private static BaseColor headingColor = new BaseColor(180, 43, 22);


	public ReportTimesheetAction() {
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
			listForm.setOrderBy("jobmov.Actfromtimeinmillis");		
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("");
		if (listForm.getOrderBy2() == null || listForm.getOrderBy2().equals("")) 
			listForm.setOrderBy2("jobhdr.Unitkey");		
		if (listForm.getOrderBy2Desc() == null || listForm.getOrderBy2Desc().equals("")) 
			listForm.setOrderBy2Desc("");

		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			//c.add(Calendar.DATE,-7);			
			// default 'from' date to today minus 7

			c.set(Calendar.DAY_OF_MONTH,1);
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		//  date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.setTime(new Date());
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}		



		String[] selectedObjects2 = listForm.getSelectedObjects2();
		listForm.setSearchString4("");
		if (selectedObjects2 != null) {
			for (int i = 0; i < selectedObjects2.length; i++) {
				if (listForm.getSearchString4().equals("")) listForm.setSearchString4(selectedObjects2[i]); 
				else listForm.setSearchString4(listForm.getSearchString4()+"|"+selectedObjects2[i]);
			}				
		}


		// set line items
		List dtos = null;
		if (listForm.getSearchString9() != null && !listForm.getSearchString9().equals("")) {
			try {
				dtos = new ReportBD(this.getSessionFactoryClusterMap()).findUnitMoves(listForm);
			} catch (ApplicationException ae) {}
		}

		totalMinutes = new Long(0);

		if (
				listForm.getSearchString9() != null && 
				listForm.getSearchString9().equals("PDF")&& 
				dtos.size() > 0
		) {
			try {

				// convert report to PDF format
				// step 1: init document				
				_Document = new Document();	
				// init pagesize default for user			
				//_Document.setPageSize(PageSize.A4);	
				_Document =  new Document(PageSize.A4.rotate(), 50, 50, 100, 100);//landscape	
				_Document.setPageCount(1);			
				//if (user != null && user.getPagesize().equals("LEGAL")) _Document.setPageSize(PageSize.LEGAL);
				//if (user != null && user.getPagesize().equals("LETTER")) _Document.setPageSize(PageSize.LETTER);

				// step 2: we set the ContentType and create an instance of the corresponding Writer				
				response.setContentType("application/pdf");
				PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());

				// step 3: set document                       
				//_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f);
				_Document.open();				

				PdfPTable header = getHeader();
				_PdfWriter.setPageEvent(new EndPageEvent(header));

				// create main table and add it to the document
				_Table1 = new PdfPTable(1);
				_Table1.getDefaultCell().setBorder(0);
				_Table1.getDefaultCell().setNoWrap(false);            		
				_Table1.setWidthPercentage(100f);  
				_Table1.getDefaultCell().setPadding(0);

				// 
				//outputHeaderToPDF();   			


				if (dtos != null && dtos.size() > 0) {  

					// process list collection
					Iterator it = dtos.iterator();
					int row = 0;
					while (it.hasNext()) {
						// init 
						UnitMoveDTO lineItem = (UnitMoveDTO) it.next();

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

				outputTotalToPDF();				

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
				sheet = wb.createSheet("Timesheet Report");

				dateCellStyle = wb.createCellStyle();
				dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
				
				// 
				outputHeaderToEXCEL();   			


				if (dtos != null && dtos.size() > 0) {  

					// process list collection
					Iterator it = dtos.iterator();
					int row = 1;
					while (it.hasNext()) {
						// init 
						UnitMoveDTO lineItem = (UnitMoveDTO) it.next();

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
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			//c.add(Calendar.DATE-7);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
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
		row.createCell((short)0).setCellValue("Date");			
		row.createCell((short)1).setCellValue("Customer");
		row.createCell((short)2).setCellValue("Project");
		row.createCell((short)3).setCellValue("Catg");		
		row.createCell((short)4).setCellValue("Sub-catg");
		row.createCell((short)5).setCellValue("Task Ref");
		row.createCell((short)6).setCellValue("Task Description");					
		row.createCell((short)7).setCellValue("From");
		row.createCell((short)8).setCellValue("To");		
		row.createCell((short)9).setCellValue("Min.");

	}


	public void outputDetailToEXCEL(UnitMoveDTO lineItem, int count) 
	throws DocumentException, BadElementException
	{

		// Create label column row 
		HSSFRow row = sheet.createRow((short)count);

		// we style the second cell as a date (and time).  It is important to
		// create a new cell style from the workbook otherwise you can end up
		// modifying the built in style and effecting not only this cell but other cells.


		Calendar calFrom = Calendar.getInstance();
		try {
			calFrom.setTimeInMillis(lineItem.getActfromtimeinmillis());
		}
		catch (NullPointerException e) {}
		Calendar calTo = Calendar.getInstance(); 
		try {
			calTo.setTimeInMillis(lineItem.getActtotimeinmillis());
		}
		catch (NullPointerException e) {}

		// Create a cell and put a value in it.
		
		HSSFCell dateCell = row.createCell((short)0);
		dateCell.setCellValue( calFrom.getTime() );
		dateCell.setCellStyle(dateCellStyle);
		
		
		row.createCell((short)1).setCellValue(lineItem.getCustomeraddrkey());
		row.createCell((short)2).setCellValue(lineItem.getOrderno());

		row.createCell((short)3).setCellValue(lineItem.getProductkey());
		


		row.createCell((short)4).setCellValue(lineItem.getSectionkey());

		row.createCell((short)5).setCellValue(lineItem.getMovref());		

		row.createCell((short)6).setCellValue(lineItem.getTxt());	

		try {
			row.createCell((short)7).setCellValue(Util.toTimeHHMM(calFrom));}
		catch (NullPointerException e) {row.createCell((short)7).setCellValue("");}

		try {
			row.createCell((short)8).setCellValue(Util.toTimeHHMM(calTo));}
		catch (NullPointerException e) {row.createCell((short)8).setCellValue("");}					

		// calculate minutes
		Long[] difference = new Long[4];
		try {
			difference = Util.calendarDifference(calFrom,calTo);
			row.createCell((short)9).setCellValue(new Float(difference[2]).toString());
		}
		catch (NullPointerException e) {row.createCell((short)9).setCellValue("");}

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
			_Table1_2.addCell(new Phrase("TIMESHEET REPORT",fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_3 =  {0.08f, 0.13f, 0.08f, 0.09f, 0.10f, 0.37f, 0.05f, 0.05f, 0.05f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_3.addCell(new Phrase("Date",fontBold));			
			_Table1_3.addCell(new Phrase("Project",fontBold));
			_Table1_3.addCell(new Phrase("Catg",fontBold));			
			_Table1_3.addCell(new Phrase("Sub-catg",fontBold));
			_Table1_3.addCell(new Phrase("Task Ref",fontBold));
			_Table1_3.addCell(new Phrase("Task Description",fontBold));					
			_Table1_3.addCell(new Phrase("From",fontBold));
			_Table1_3.addCell(new Phrase("To",fontBold));			
			_Table1_3.addCell(new Phrase("Mins",fontBold));


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

		return _Table1;
	}


	public void outputTotalToPDF() throws DocumentException, BadElementException, SQLException, Exception
	{


		try {  	

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			float[] widths1_3 = {0.95f, 0.05f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		


			Long hours = totalMinutes / 60;
			Long minutes = totalMinutes - (hours * 60);

			String totalOutput = "";
			try {
				totalOutput="TOTAL - ";
				if (hours>0) {
					totalOutput=totalOutput+hours.intValue()+" Hours ";
				}
				if (minutes>0) {
					totalOutput=totalOutput+minutes.intValue()+" Minutes";
				}
			} catch (Exception e) {
			}
			_Table1_3.addCell(new Phrase(totalOutput,fontBold));
			_Table1_3.addCell(new Phrase("",fontBold));	

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

	}





	public void outputDetailToPDF(UnitMoveDTO lineItem) 
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

			float[] widths1_3 =  {0.08f, 0.13f, 0.08f, 0.09f, 0.10f, 0.37f, 0.05f, 0.05f, 0.05f};
			

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			Calendar calFrom = Calendar.getInstance();
			try {
				calFrom.setTimeInMillis(lineItem.getActfromtimeinmillis());
			}
			catch (NullPointerException e) {}
			Calendar calTo = Calendar.getInstance();
			try {
				calTo.setTimeInMillis(lineItem.getActtotimeinmillis());
			}
			catch (NullPointerException e) {}

			try {
				_Table1_3.addCell(new Phrase(Util.dateTextFormat2(calFrom.getTime()),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(lineItem.getOrderno(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(lineItem.getProductkey(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}
			


			try {_Table1_3.addCell(new Phrase(lineItem.getSectionkey(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(lineItem.getMovref(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {_Table1_3.addCell(new Phrase(lineItem.getTxt(),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}


			try {
				_Table1_3.addCell(new Phrase(Util.toTimeHHMM(calFrom),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}

			try {
				_Table1_3.addCell(new Phrase(Util.toTimeHHMM(calTo),font));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}	




			// calculate minutes
			Long[] difference = new Long[4];
			try {
				difference = Util.calendarDifference(calFrom,calTo);
				_Table1_3.addCell(
						new Phrase(
								new Float(difference[2]).toString(),
								font)
				);	
			}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",font));}	

			// calculate total minutes
			try {
				totalMinutes=totalMinutes+difference[2];
			}
			catch (NullPointerException e) {}


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

		}
		catch (Exception e) {
		}		
	}	


}
