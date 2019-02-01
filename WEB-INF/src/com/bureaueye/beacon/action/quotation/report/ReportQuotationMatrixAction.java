package com.bureaueye.beacon.action.quotation.report;



import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
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
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.quotation.Quonotecust;
import com.bureaueye.beacon.model.quotation.bd.QuochargeBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuohdrDTO;
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
 * NT	2011-03-01		ITT-201103-0002		Quotation Matrix Report 
 *
 */

public final class ReportQuotationMatrixAction extends BaseAction {


	private static Document _Document;
	private static PdfPTable _Table1;

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


	public ReportQuotationMatrixAction() {
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

		//default order parameters
		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals("")) 
			listForm.setOrderBy("Quotno");
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("Asc");


		//default max results if first time in 
		if (listForm.getSearchString1() == null) 
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_TOTAL_RESULTS);					


		// set line items
		List<QuohdrDTO> quohdrs = null;
		if (listForm.getSearchString3() != null && !listForm.getSearchString3().equals("")) {

			if (listForm.getSearchString1() == null || 
					listForm.getSearchString1().equals("")) {
				if (listForm.getSearchString15().equals("ACTIVE")) {			
					listForm.setLineItems(		
							new QuohdrBD(
									this.getSessionFactoryClusterMap()
							)
							.findQuohdrsBySearchActive(listForm)
					);		
				} 
				if (listForm.getSearchString15().equals("EXPIRED")) {			
					listForm.setLineItems(		
							new QuohdrBD(
									this.getSessionFactoryClusterMap()
							)
							.findQuohdrsBySearchExpired(listForm)
					);					
				}
				if (listForm.getSearchString15().equals("ALL")) {			
					listForm.setLineItems(		
							new QuohdrBD(
									this.getSessionFactoryClusterMap()
							)
							.findQuohdrsBySearch(listForm)
					);					
				}			
			}
			else { 
				listForm.setLineItems(		
						new QuohdrBD(
								this.getSessionFactoryClusterMap()
						)
						.findQuohdrsBySearchByQuotno(listForm)
				);		
			}

		}

		quohdrs = listForm.getLineItems();





		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  listForm.toString(): "+listForm.toString());

		if (
				listForm.getSearchString3() != null && 
				listForm.getSearchString3().equals("PDF") && 
				quohdrs.size() > 0
		) {
			try {

				// convert report to PDF format
				// init document				
				_Document =  new Document(PageSize.A4.rotate(), 20, 20, 100, 100);//landscape					
				_Document.setPageCount(1);			

				// we set the ContentType and create an instance of the corresponding Writer				
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

				//   			


				if (quohdrs != null && quohdrs.size() > 0) {  

					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  quohdrs.size(): "+quohdrs.size());

					// process list collection
					Iterator<QuohdrDTO> it = quohdrs.iterator();
					int row = 0;
					while (it.hasNext()) {
						// init 
						QuohdrDTO lineItem = (QuohdrDTO) it.next();


						// init select parameter					
						try {							
							// output to PDF
							outputDetailToPDF(lineItem);
						}
						catch (Exception e) {						
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



		if (listForm.getSearchString3() != null && listForm.getSearchString3().equals("EXCEL")) {
			try {	

				response.setContentType("application/vnd.ms-excel");

				wb = new HSSFWorkbook();
				sheet = wb.createSheet("Quotation Matrix Report");

				// 
				outputHeaderToEXCEL();   			


				if (quohdrs != null && quohdrs.size() > 0) {  

					// process list collection
					Iterator<QuohdrDTO> it = quohdrs.iterator();
					int row = 1;
					while (it.hasNext()) {
						// init 
						QuohdrDTO lineItem = (QuohdrDTO) it.next();


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
	
		// generated and default values from SESSION 
		setTotalResults(listForm, session);
		
		
		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}



		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// set default field values
		// customer
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
		}

		// status
		if (listForm.getSearchString9() == null || listForm.getSearchString9().equals("")) {
			listForm.setSearchString9("%");
		}

		// location
		if (listForm.getSearchString10() == null || listForm.getSearchString10().equals("")) {
			listForm.setSearchString10("%");
		}	
		// location
		if (listForm.getSearchString11() == null || listForm.getSearchString11().equals("")) {
			listForm.setSearchString11("%");
		}
		// location
		if (listForm.getSearchString12() == null || listForm.getSearchString12().equals("")) {
			listForm.setSearchString12("%");
		}
		// location
		if (listForm.getSearchString13() == null || listForm.getSearchString13().equals("")) {
			listForm.setSearchString13("%");
		}

		// active/expired 
		if (listForm.getSearchString15() == null || listForm.getSearchString15().equals("")) {
			listForm.setSearchString15("ACTIVE");
		}

		// expiry/active date check
		listForm.setSearchDate3(new Date());


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(
					new SystemcodeBD(
							this.getSessionFactoryClusterMap()
					).read(new SystemcodePK("DATERANGEDAYS","LISTQUOHDR")).getDescr()).intValue();
		}catch(Exception e){}
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// quote date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
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
		row.createCell((short)0).setCellValue("Quote Number");
		row.createCell((short)1).setCellValue("Customer");
		row.createCell((short)2).setCellValue("Effective Date");
		row.createCell((short)3).setCellValue("Expiry Date");
		row.createCell((short)4).setCellValue("Ship Method");
		row.createCell((short)5).setCellValue("Product");
		row.createCell((short)6).setCellValue("Pickup Location");
		row.createCell((short)7).setCellValue("POL");
		row.createCell((short)8).setCellValue("POD");
		row.createCell((short)9).setCellValue("Delivery Location");
		row.createCell((short)10).setCellValue("Quote Date");
		row.createCell((short)11).setCellValue("Quote Status");
		row.createCell((short)12).setCellValue("Quote Currency");
		row.createCell((short)13).setCellValue("Charge Total");
		row.createCell((short)14).setCellValue("Demurrage Currency"); 
		row.createCell((short)15).setCellValue("Demurrage Rate"); 
		row.createCell((short)16).setCellValue("Free Days"); 
		row.createCell((short)17).setCellValue("Notes");

	}


	public void outputDetailToEXCEL(QuohdrDTO lineItem, int count) 
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
		row.createCell((short)0).setCellValue(lineItem.getQuotno());

		try {
			row.createCell((short)1).setCellValue(lineItem.getCustomername());	
		} catch (Exception e) {
			row.createCell((short)1).setCellValue("");			
		}

		HSSFCell dateCell = row.createCell((short)2);
		if (lineItem.getEffectivedate() != null) {
			dateCell.setCellValue( lineItem.getEffectivedate() );
			dateCell.setCellStyle(dateCellStyle);
		}
		else {
			row.createCell((short)2).setCellValue( "" );		        	
		}

		dateCell = row.createCell((short)3);
		if (lineItem.getExpirydate() != null) {
			dateCell.setCellValue( lineItem.getExpirydate() );
			dateCell.setCellStyle(dateCellStyle);
		}
		else {
			row.createCell((short)3).setCellValue( "" );		        	
		}

		row.createCell((short)4).setCellValue(lineItem.getShipmethod());		


		// product
		try {
			row.createCell((short)5).setCellValue(lineItem.getProductkey().getTradname());
		} catch (Exception e) {	
			row.createCell((short)5).setCellValue("");
		}


		// logistic details
		try {			
			row.createCell((short)6).setCellValue(lineItem.getLdglocationkey1().getLocationName());
		} catch (Exception e) {	
			row.createCell((short)6).setCellValue("");	
		}			
		try {
			row.createCell((short)7).setCellValue(lineItem.getLdglocationkey2().getLocationName());
		} catch (Exception e) {	
			row.createCell((short)7).setCellValue("");	
		}	
		try {
			row.createCell((short)8).setCellValue(lineItem.getDchlocationkey2().getLocationName());	
		} catch (Exception e) {	
			row.createCell((short)8).setCellValue("");	
		}
		try {
			row.createCell((short)9).setCellValue(lineItem.getDchlocationkey1().getLocationName());	
		} catch (Exception e) {	
			row.createCell((short)9).setCellValue("");			
		}


		dateCell = row.createCell((short)10);
		if (lineItem.getQuotedate() != null) {
			dateCell.setCellValue( lineItem.getQuotedate() );
			dateCell.setCellStyle(dateCellStyle);
		}
		else {
			row.createCell((short)10).setCellValue( "" );		        	
		}

		row.createCell((short)11).setCellValue(lineItem.getQuotestatus());


		row.createCell((short)12).setCellValue(lineItem.getCcykey());

		BigDecimal chargeTotal = this.getChargeTotal(lineItem.getId().toString());	
		try {
			row.createCell((short)13).setCellValue(new CurrencyFormatter().format(chargeTotal));					
		} catch (Exception e) {
			row.createCell((short)13).setCellValue("0.00");	
		}


		row.createCell((short)14).setCellValue(lineItem.getDmrgccykey());

		BigDecimal dmrgdlyrat3 = lineItem.getDmrgdlyrate3();
		try {				
			row.createCell((short)15).setCellValue(new CurrencyFormatter().format(dmrgdlyrat3));
		} catch (Exception e) {
			row.createCell((short)15).setCellValue("0.00");
		}

		Integer freedays = lineItem.getDmrgfreedays();
		try {
			row.createCell((short)16).setCellValue(freedays+"");	   	  		
		} catch (Exception e) {
			row.createCell((short)16).setCellValue("0");				
		}



		//row detail #3--------------------------------------------------------------
		String notes = "";
		List<Quonotecust> quonotecusts = this.getQuonotecusts(lineItem.getId());		
		if (quonotecusts != null && quonotecusts.size() > 0) {  				
			// process list collection
			for (Iterator<Quonotecust> it = quonotecusts.iterator(); it.hasNext();) {					
				Quonotecust quonotecust= (Quonotecust) it.next();						

				try {
					notes=notes+" "+quonotecust.getNote1();
				} catch(Exception e){
				}

			}	
			try {
				row.createCell((short)17).setCellValue(notes);	   	  		
			} catch (Exception e) {
				row.createCell((short)17).setCellValue("-");				
			}
		}



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
			_Table1_2.addCell(new Phrase("QUOTATION MATRIX REPORT",fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);


			PdfPTable _Table1_3 = new PdfPTable(10);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			//row title #1
			_Table1_3.addCell(new Phrase("Quote Number",fontSmallBold));
			_Table1_3.addCell(new Phrase("Customer",fontSmallBold));
			_Table1_3.addCell(new Phrase("Effective Date",fontSmallBold));			
			_Table1_3.addCell(new Phrase("Expiry Date",fontSmallBold));
			_Table1_3.addCell(new Phrase("Ship Method",fontSmallBold));		
			_Table1_3.addCell(new Phrase("Product",fontSmallBold));
			_Table1_3.addCell(new Phrase("Pickup Location",fontSmallBold));
			_Table1_3.addCell(new Phrase("POL",fontSmallBold));
			_Table1_3.addCell(new Phrase("POD",fontSmallBold));
			_Table1_3.addCell(new Phrase("Delivery Location",fontSmallBold));


			//row title #2	
			_Table1_3.addCell(new Phrase("Quote Date",fontSmallBold));
			_Table1_3.addCell(new Phrase("Quote Status",fontSmallBold));	
			_Table1_3.addCell(new Phrase("Quote Currency",fontSmallBold));			
			PdfPCell pdfpcell = new PdfPCell(new Phrase("Charge Total",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);	
			_Table1_3.addCell(new Phrase("Demurrage Currency",fontSmallBold));			
			pdfpcell = new PdfPCell(new Phrase("Demurrage Rate",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);						
			pdfpcell = new PdfPCell(new Phrase("Free Days",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);

			_Table1_3.addCell(new Phrase("",fontSmallBold));
			_Table1_3.addCell(new Phrase("",fontSmallBold));
			_Table1_3.addCell(new Phrase("",fontSmallBold));



			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);



			float[] widths = {0.01f, 0.99f};
			_Table1_3 = new PdfPTable(widths);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			//row title #3
			_Table1_3.addCell(new Phrase("",fontSmallBold));
			_Table1_3.addCell(new Phrase("Notes",fontSmallBold));	


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);




		}
		catch (Exception e) {}	

		return _Table1;
	}


	public void outputDetailToPDF(QuohdrDTO lineItem) 
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



			PdfPTable _Table1_3 = new PdfPTable(10);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		


			//row detail #1-------------------------------------------------------------------------
			_Table1_3.addCell(new Phrase(lineItem.getQuotno(),fontSmall));

			String customerName = lineItem.getCustomername();
			try {customerName=customerName.substring(0,18);}catch (Exception e){}
			_Table1_3.addCell(new Phrase(customerName,fontSmall));

			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getEffectivedate()),fontSmall));
			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getExpirydate()),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getShipmethod(),fontSmall));	

			// product
			try {
				String productTradname = lineItem.getProductkey().getTradname();
				try {productTradname=productTradname.substring(0,18);}catch(Exception e){}
				_Table1_3.addCell(new Phrase(productTradname,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}


			// init logistic details
			String locationName = lineItem.getLdglocationkey1().getLocationName();
			try {locationName=locationName.substring(0,18);}catch (Exception e){}		
			try {
				_Table1_3.addCell(new Phrase(locationName,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}

			locationName = lineItem.getLdglocationkey2().getLocationName();
			try {locationName=locationName.substring(0,18);}catch (Exception e){}
			try {
				_Table1_3.addCell(new Phrase(locationName,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}	

			locationName = lineItem.getDchlocationkey2().getLocationName();
			try {locationName=locationName.substring(0,18);}catch (Exception e){}
			try {
				_Table1_3.addCell(new Phrase(locationName,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}

			locationName = lineItem.getDchlocationkey1().getLocationName();
			try {locationName=locationName.substring(0,18);}catch (Exception e){}			
			try {
				_Table1_3.addCell(new Phrase(locationName,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}







			//row detail #2-------------------------------------------------------------------------
			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getQuotedate()),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getQuotestatus(),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getCcykey(),fontSmall));		
			BigDecimal chargeTotal = this.getChargeTotal(lineItem.getId().toString());	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(chargeTotal),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);				
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}

			_Table1_3.addCell(new Phrase(lineItem.getDmrgccykey(),fontSmall));			
			BigDecimal dmrgdlyrate3 = lineItem.getDmrgdlyrate3();	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(dmrgdlyrate3),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);				
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}

			Integer freeDays = lineItem.getDmrgfreedays();	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(freeDays+"",fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);				
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}

			_Table1_3.addCell(new Phrase("",fontSmall));
			_Table1_3.addCell(new Phrase("",fontSmall));
			_Table1_3.addCell(new Phrase("",fontSmall));








			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);




			float[] widths = {0.01f, 0.99f};
			_Table1_3 = new PdfPTable(widths);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			//row detail #3--------------------------------------------------------------
			List<Quonotecust> quonotecusts = this.getQuonotecusts(lineItem.getId());		
			if (quonotecusts != null && quonotecusts.size() > 0) {  				
				// process list collection
				for (Iterator<Quonotecust> it = quonotecusts.iterator(); it.hasNext();) {					
					Quonotecust quonotecust= (Quonotecust) it.next();						
					_Table1_3.addCell(new Phrase(" ",fontSmall));

					String notes = "";
					try{
						notes=notes+"["+Util.dateTextFormat2(quonotecust.getCreatedate())+"]";
					}catch(Exception e){
					}
					try{
						notes=notes+"["+quonotecust.getCreateuserid()+"]";
					}catch(Exception e){
					}
					try{
						notes=notes+"["+quonotecust.getCategory()+"]";
					}catch(Exception e){
					}
					try{
						notes=notes+" "+quonotecust.getNote1()+"";
					}catch(Exception e){
					}
					_Table1_3.addCell(new Phrase(notes,fontSmall));

				}				
			}			


			// insert blank row
			_BlankCell.setColspan(2);
			_Table1_3.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);		


		}
		catch (Exception e) {
		}	

	}	


	public BigDecimal getChargeTotal(String id) 
	{	
		BigDecimal total = new BigDecimal(0.00);	

		// retrieve cost total					
		try{
			total = new QuochargeBD(this.getSessionFactoryClusterMap()).quochargesChgamtbaseTotal(id);
		} catch (Exception e) {
		}

		return total;
	}


	public List<Quonotecust> getQuonotecusts(Integer id) 
	{	
		List<Quonotecust> list = new LinkedList<Quonotecust>();

		try {
			list = new QuohdrBD(this.getSessionFactoryClusterMap()).getQuonotecusts(id);
		} catch (Exception e) {
		}

		return list;
	}



}
