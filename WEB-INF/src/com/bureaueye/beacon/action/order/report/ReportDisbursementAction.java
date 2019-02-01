package com.bureaueye.beacon.action.order.report;



import java.math.BigDecimal;
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
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;

import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrderhdrDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;


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
 * NT	2013-02-20		WSI-201302-0003			DISBURSEMENT REPORT
 */

public final class ReportDisbursementAction extends BaseAction {


	private static Document _Document;
	private static PdfPTable _Table1;

	private static int CELL_BORDER = 0;

	private static String shipSection;	

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


	public ReportDisbursementAction() {
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
		List<OrderhdrDTO> orderhdrs = null;

		//check if output selected and first time in 
		if (listForm.getSearchString3() != null && !listForm.getSearchString3().equals("")) {

			if (listForm.getSearchString1().equals("") && listForm.getSearchString14().equals("")) {
				listForm.setLineItems(		
						new OrderhdrBD(
								this.getSessionFactoryClusterMap()
						)
						.findOrderhdrsBySearchForSummaryReport(listForm)
				);		
			}
			else { 
				if (!listForm.getSearchString1().equals("")) {
					listForm.setLineItems(		
							new OrderhdrBD(
									this.getSessionFactoryClusterMap()
							)
							.findOrderhdrsBySearchByOrderno(listForm)
					);	
				} else {
					if (!listForm.getSearchString14().equals("")) {
						listForm.setLineItems(		
								new OrderhdrBD(
										this.getSessionFactoryClusterMap()
								)
								.findOrderhdrsBySearchByConsignmentno(listForm)
						);	
					}
				}
			}

		}

		orderhdrs = listForm.getLineItems();


		// retrieve section mapping for SHIP
		SystemmappingcodeBD systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());		
		try{shipSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "SHIP").getCompanycode();}catch(Exception e){}
		systemmappingcodebd = null;		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemmappingcode: " +
				" shipSection="+shipSection				
		);


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  listForm.toString(): "+listForm.toString());




		if (listForm.getSearchString3() != null && listForm.getSearchString3().equals("EXCEL")) {
			try {	

				response.setContentType("application/vnd.ms-excel");

				wb = new HSSFWorkbook();
				sheet = wb.createSheet("Disbursement Report");

				// 
				outputHeaderToEXCEL();   			


				if (orderhdrs != null && orderhdrs.size() > 0) {  

					// process list collection
					Iterator it = orderhdrs.iterator();
					int row = 1;
					while (it.hasNext()) {
						// init 
						OrderhdrDTO lineItem = (OrderhdrDTO) it.next();


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
			listForm.setOrderBy("Orderno");
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("Asc");



		//set default max results
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);


		// order no
		if (listForm.getSearchString1() == null) {
			listForm.setSearchString1("");
		}
		// consignmentno
		if (listForm.getSearchString14() == null) {
			listForm.setSearchString14("");
		}


		// customer
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("%");
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


		// default to EXCEL output
		if (listForm.getSearchString3() == null) {			
			listForm.setSearchString3("EXCEL");			
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
		row.createCell((short)0).setCellValue("Order Number");
		row.createCell((short)1).setCellValue("Create UserId");
		row.createCell((short)2).setCellValue("Order Date");
		row.createCell((short)3).setCellValue("Consignment Number");
		row.createCell((short)4).setCellValue("Booking Number");
		row.createCell((short)5).setCellValue("Invoice Status");
		row.createCell((short)6).setCellValue("Customer");
		row.createCell((short)7).setCellValue("Ship Method");
		row.createCell((short)8).setCellValue("Product");
		row.createCell((short)9).setCellValue("Pickup Location");
		row.createCell((short)10).setCellValue("POL");
		row.createCell((short)11).setCellValue("POD");
		row.createCell((short)12).setCellValue("Delivery Location");
		row.createCell((short)13).setCellValue("Ship line");
		row.createCell((short)14).setCellValue("Vessel");
		row.createCell((short)15).setCellValue("Charge Total"); 
		row.createCell((short)16).setCellValue("Cost total"); 
		row.createCell((short)17).setCellValue("Profit"); 
		row.createCell((short)18).setCellValue("GP%");
		row.createCell((short)19).setCellValue("Dept");  


	}


	public void outputDetailToEXCEL(OrderhdrDTO lineItem, int count) 
	throws DocumentException, BadElementException
	{

		List jobhdrdtos = null;
		try {			
			jobhdrdtos = new JobhdrBD(this.getSessionFactoryClusterMap())
			.findJobhdrsById(
					lineItem.getId().toString(), 
					0, 
					99, 
					"Jobno"
			);
			JobhdrDTO firstJobhdrdto=null;
			// 
			for (Iterator it = jobhdrdtos.iterator(); it.hasNext();) {
				firstJobhdrdto=(JobhdrDTO)it.next();
				break;
			}


			// Create label column row 
			HSSFRow row = sheet.createRow((short)count);

			// we style the second cell as a date (and time).  It is important to
			// create a new cell style from the workbook otherwise you can end up
			// modifying the built in style and effecting not only this cell but other cells.
			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue(lineItem.getOrderno());

			row.createCell((short)1).setCellValue(lineItem.getOrderbyuserid());


			HSSFCell dateCell = row.createCell((short)2);
			if (lineItem.getOrderdate() != null) {
				dateCell.setCellValue( lineItem.getOrderdate() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)2).setCellValue( "" );		        	
			}

			row.createCell((short)3).setCellValue(lineItem.getConsignmentno());

			row.createCell((short)4).setCellValue(lineItem.getBookingnumber());

			row.createCell((short)5).setCellValue(lineItem.getInvoicestatus());

			try {
				row.createCell((short)6).setCellValue(lineItem.getCustomeraddrkey().getName());	
			} catch (Exception e) {
				row.createCell((short)6).setCellValue("");			
			}

			row.createCell((short)7).setCellValue(lineItem.getShipmethod());

			// product
			try {
				row.createCell((short)8).setCellValue(lineItem.getProductkey().getTradname());
			} catch (Exception e) {	
				row.createCell((short)8).setCellValue("");
			}

			// init logistic details
			try {			
				row.createCell((short)9).setCellValue(lineItem.getLdglocationkey1().getLocationName());
			} catch (Exception e) {	
				row.createCell((short)9).setCellValue("");	
			}			
			try {
				row.createCell((short)10).setCellValue(lineItem.getLdglocationkey2().getLocationName());
			} catch (Exception e) {	
				row.createCell((short)10).setCellValue("");	
			}	
			try {
				row.createCell((short)11).setCellValue(lineItem.getDchlocationkey2().getLocationName());	
			} catch (Exception e) {	
				row.createCell((short)11).setCellValue("");	
			}
			try {
				row.createCell((short)12).setCellValue(lineItem.getDchlocationkey1().getLocationName());	
			} catch (Exception e) {	
				row.createCell((short)12).setCellValue("");			
			}

			row.createCell((short)13).setCellValue(this.getShipVendor(firstJobhdrdto.getJobhdrId().toString(),shipSection));	

			row.createCell((short)14).setCellValue(this.getShipVessel(firstJobhdrdto.getJobhdrId().toString(),shipSection));


			BigDecimal chargeTotal = this.getChargeTotal(lineItem.getId().toString());	
			try {
				row.createCell((short)15).setCellValue(new CurrencyFormatter().format(chargeTotal));					
			} catch (Exception e) {
				row.createCell((short)15).setCellValue("0.00");	
			}


			try {
				//need to total all job costs for order
				BigDecimal costTotal = new BigDecimal(0.0);

				for (Iterator it2 = jobhdrdtos.iterator(); it2.hasNext();) {
					JobhdrDTO jobhdrdto=(JobhdrDTO)it2.next();
					BigDecimal jobCostTotal = this.getCostTotal(jobhdrdto.getJobhdrId().toString());
					costTotal=costTotal.add(jobCostTotal);
				}

				try {				
					row.createCell((short)16).setCellValue(new CurrencyFormatter().format(costTotal));
				} catch (Exception e) {
					row.createCell((short)16).setCellValue("0.00");
				}


				BigDecimal profitTotal = new BigDecimal(0.0);
				try {
					profitTotal = chargeTotal.subtract(costTotal);
					row.createCell((short)17).setCellValue(new CurrencyFormatter().format(profitTotal));	   	  		
				} catch (Exception e) {
					row.createCell((short)17).setCellValue("0.00");				
				}


				String profitPercentage= new String();
				try {
					profitPercentage=new CurrencyFormatter().format(new BigDecimal((chargeTotal.doubleValue() - costTotal.doubleValue()) / chargeTotal.doubleValue() * 100))+"%";
					row.createCell((short)18).setCellValue(profitPercentage);				
				} catch (Exception e) {
					row.createCell((short)18).setCellValue("0.00%");				
				}	

			} catch (Exception e) {
			}

			row.createCell((short)19).setCellValue(lineItem.getDepartmentkey());



		} catch (Exception e) {

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
			_Table1_2.addCell(new Phrase("ORDER SUMMARY REPORT (PROFIT ANALYSIS)",fontHeading));
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

			_Table1_3.addCell(new Phrase("Order Number",fontSmallBold));
			_Table1_3.addCell(new Phrase("Create UserId",fontSmallBold));
			_Table1_3.addCell(new Phrase("Invoice Status",fontSmallBold));			
			_Table1_3.addCell(new Phrase("Ship Method",fontSmallBold));
			_Table1_3.addCell(new Phrase("Product",fontSmallBold));
			_Table1_3.addCell(new Phrase("Customer",fontSmallBold));

			PdfPCell pdfpcell = new PdfPCell(new Phrase("Charge Total",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);				
			pdfpcell = new PdfPCell(new Phrase("Cost Total",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);	
			pdfpcell = new PdfPCell(new Phrase("Profit",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);			
			_Table1_3.addCell(pdfpcell);			
			pdfpcell = new PdfPCell(new Phrase("GP%",fontSmallBold));
			pdfpcell.setHorizontalAlignment(2);
			pdfpcell.setBorder(0);		
			_Table1_3.addCell(pdfpcell);

			_Table1_3.addCell(new Phrase("Dept",fontSmallBold));
			_Table1_3.addCell(new Phrase("Order Date",fontSmallBold));
			_Table1_3.addCell(new Phrase("Consignment No.",fontSmallBold));
			_Table1_3.addCell(new Phrase("Booking No.",fontSmallBold));
			_Table1_3.addCell(new Phrase("Pickup Location",fontSmallBold));
			_Table1_3.addCell(new Phrase("POL",fontSmallBold));
			_Table1_3.addCell(new Phrase("POD",fontSmallBold));
			_Table1_3.addCell(new Phrase("Delivery Location",fontSmallBold));
			_Table1_3.addCell(new Phrase("Ship line",fontSmallBold));
			_Table1_3.addCell(new Phrase("Vessel",fontSmallBold));



			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

		return _Table1;
	}


	public void outputDetailToPDF(OrderhdrDTO lineItem) 
	throws DocumentException, BadElementException
	{		

		List jobhdrdtos = null;
		try {			
			jobhdrdtos = new JobhdrBD(this.getSessionFactoryClusterMap())
			.findJobhdrsById(
					lineItem.getId().toString(), 
					0, 
					99, 
					"Jobno"
			);
			JobhdrDTO firstJobhdrdto=null;
			// 
			for (Iterator it = jobhdrdtos.iterator(); it.hasNext();) {
				firstJobhdrdto=(JobhdrDTO)it.next();
				break;
			}



			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);



			PdfPTable _Table1_3 = new PdfPTable(10);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_3.addCell(new Phrase(lineItem.getOrderno(),fontSmall));

			try {
				_Table1_3.addCell(new Phrase(lineItem.getOrderbyuserid(),fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase(" ",fontSmall));
			}	


			_Table1_3.addCell(new Phrase(lineItem.getInvoicestatus(),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getShipmethod(),fontSmall));				

			// product
			try {
				String productTradname = lineItem.getProductkey().getTradname();
				try {productTradname=productTradname.substring(0,18);}catch(Exception e){}
				_Table1_3.addCell(new Phrase(productTradname,fontSmall));
			} catch (Exception e) {	
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}	

			String customerName = lineItem.getCustomeraddrkey().getName();
			try {customerName=customerName.substring(0,18);}catch (Exception e){}
			_Table1_3.addCell(new Phrase(customerName,fontSmall));

			BigDecimal chargeTotal = this.getChargeTotal(lineItem.getId().toString());	
			try {
				PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(chargeTotal),fontSmall));
				pdfpcell.setHorizontalAlignment(2);
				pdfpcell.setBorder(0);
				_Table1_3.addCell(pdfpcell);				
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("-",fontSmall));
			}


			try {

				//need to total all job costs for order
				BigDecimal costTotal = new BigDecimal(0.0);
				for (Iterator it2 = jobhdrdtos.iterator(); it2.hasNext();) {
					JobhdrDTO jobhdrdto=(JobhdrDTO)it2.next();		
					BigDecimal jobCostTotal = this.getCostTotal(jobhdrdto.getJobhdrId().toString());	
					costTotal=costTotal.add(jobCostTotal);
				}	
				try {				
					PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(costTotal),fontSmall));
					pdfpcell.setHorizontalAlignment(2);
					pdfpcell.setBorder(0);
					_Table1_3.addCell(pdfpcell);
				} catch (Exception e) {
					_Table1_3.addCell(new Phrase("-",fontSmall));
				}


				BigDecimal profitTotal = new BigDecimal(0.0);
				try {
					profitTotal = chargeTotal.subtract(costTotal);
					PdfPCell pdfpcell = new PdfPCell(new Phrase(new CurrencyFormatter().format(profitTotal),fontSmall));
					pdfpcell.setHorizontalAlignment(2);
					pdfpcell.setBorder(0);
					_Table1_3.addCell(pdfpcell);	   	  		
				} catch (Exception e) {
					_Table1_3.addCell(new Phrase("-",fontSmall));				
				}


				String profitPercentage= new String();
				try {
					profitPercentage=new CurrencyFormatter().format(new BigDecimal((chargeTotal.doubleValue() - costTotal.doubleValue()) / chargeTotal.doubleValue() * 100))+"%";
					PdfPCell pdfpcell = new PdfPCell(new Phrase(profitPercentage,fontSmall));				
					pdfpcell.setHorizontalAlignment(2);
					pdfpcell.setBorder(0);
					_Table1_3.addCell(pdfpcell);				
				} catch (Exception e) {
					_Table1_3.addCell(new Phrase("0.00%",fontSmall));				
				}

			} catch (Exception e) {			
			}


			_Table1_3.addCell(new Phrase(lineItem.getDepartmentkey(),fontSmall));

			_Table1_3.addCell(new Phrase(Util.dateTextFormat2(lineItem.getOrderdate()),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getConsignmentno(),fontSmall));
			_Table1_3.addCell(new Phrase(lineItem.getBookingnumber(),fontSmall));			

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

			_Table1_3.addCell(new Phrase(this.getShipVendor(firstJobhdrdto.getJobhdrId().toString(),shipSection),fontSmall));

			_Table1_3.addCell(new Phrase(this.getShipVessel(firstJobhdrdto.getJobhdrId().toString(),shipSection),fontSmall));





			// insert blank row
			_BlankCell.setColspan(10);
			_Table1_3.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {
		}	

	}	




	public String getShipVendor(String id, String section) 
	{	
		String vendorAddress = "";
		Jobmov mov = null;
		Address address = null;
		// retrieve ship section					
		try{
			mov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(id, section);
		} catch (Exception e) {
		}

		if (mov!=null) {
			// retrieve vendor address					
			try{
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(mov.getVendoraddrkey());
				vendorAddress=address.getName();
			} catch (Exception e) {
			}	
		}

		return vendorAddress;
	}


	public String getShipVessel(String id, String section) 
	{	
		String vendorVessel = "";
		Jobmov mov = null;
		// retrieve ship section					
		try{
			mov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(id, section);
			vendorVessel=mov.getVessel();
		} catch (Exception e) {
		}

		return vendorVessel;
	}


	public BigDecimal getCostTotal(String id) 
	{	
		BigDecimal total = new BigDecimal(0.00);	

		// retrieve cost total					
		try{
			total = new JobcostBD(this.getSessionFactoryClusterMap()).jobcostsCstamtbaseTotal(id);
		} catch (Exception e) {
		}

		return total;
	}


	public BigDecimal getChargeTotal(String id) 
	{	
		BigDecimal total = new BigDecimal(0.00);	

		// retrieve cost total					
		try{
			total = new OrderchargeBD(this.getSessionFactoryClusterMap()).orderchargesChgamtbaseTotal(id);
		} catch (Exception e) {
		}

		return total;
	}






}
