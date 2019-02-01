package com.bureaueye.beacon.action.report;



import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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






public final class ReportManifestAction extends BaseAction {


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
	Font fontTiny;
	Font fontTinyBold;	
	Font fontHeading;
	Font fontBoldUnderline;

	private static BaseColor headingColor = new BaseColor(180, 43, 22);


	public ReportManifestAction() {
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
			fontTiny= new Font(font.getFamily(), font.getSize()-5, font.getStyle());			
			fontTinyBold = new Font(fontTiny.getFamily(), fontTiny.getSize(), Font.BOLD);
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
			listForm.setOrderBy("jobhdr.Unitkey");		
		if (listForm.getOrderByDesc() == null || listForm.getOrderByDesc().equals("")) 
			listForm.setOrderByDesc("");
		if (listForm.getOrderBy2() == null || listForm.getOrderBy2().equals("")) 
			listForm.setOrderBy2("");		
		if (listForm.getOrderBy2Desc() == null || listForm.getOrderBy2Desc().equals("")) 
			listForm.setOrderBy2Desc("");


		// set line items
		List dtos = null;
		if (listForm.getSearchString9() != null && !listForm.getSearchString9().equals("")) {
			try {
				dtos = new ReportBD(this.getSessionFactoryClusterMap()).findUnitMovesByVesselVoyage(listForm);
			} catch (ApplicationException ae) {}
		}



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
				_Document =  new Document(PageSize.A4.rotate(), 50, 50, 100, 100);//landscape	
				_Document.setPageCount(1);			


				// step 2: we set the ContentType and create an instance of the corresponding Writer				
				response.setContentType("application/pdf");
				PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());


				_Document.open();				


				if (dtos != null && dtos.size() > 0) {  

					// process list collection
					Iterator it = dtos.iterator();
					UnitMoveDTO lineItem = (UnitMoveDTO) it.next();					
					PdfPTable header = outputHeaderToPDF(lineItem);
					_PdfWriter.setPageEvent(new EndPageEvent(header));

					// create main table and add it to the document
					_Table1 = new PdfPTable(1);
					_Table1.getDefaultCell().setBorder(0);
					_Table1.getDefaultCell().setNoWrap(false);            		
					_Table1.setWidthPercentage(100f);  
					_Table1.getDefaultCell().setPadding(0);

					// 
					//outputHeaderToPDF();   			

					// process list collection
					it = dtos.iterator();
					int row = 0;
					while (it.hasNext()) {
						// init 
						lineItem = (UnitMoveDTO) it.next();

						// init select parameter					
						try {							
							// output to PDF
							outputDetailToPDF(lineItem, row);
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
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {

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



	public PdfPTable outputHeaderToPDF(UnitMoveDTO lineItem) throws DocumentException, BadElementException, SQLException, Exception
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
			_Table1_2.addCell(new Phrase("MANIFEST",fontHeading));
			_Table1_2.addCell(new Phrase(" ",font));
			_Table1_2.addCell(new Phrase("Run at "+ Util.dateTimeFormat(new Date()),fontBold));
			_Table1_2.addCell(new Phrase(" ",font));

			_PdfPCell = new PdfPCell(_Table1_2);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);





			float[] widths1_4 =  {0.1f, 0.1f, 0.1f, 0.2f, 0.1f, 0.2f, 0.1f, 0.1f};			
			PdfPTable _Table1_4 = new PdfPTable(widths1_4);
			_Table1_4.getDefaultCell().setBorder(CELL_BORDER);  	   	  		

			_Table1_4.addCell(new Phrase("",fontBold));
			_Table1_4.addCell(new Phrase("",fontBold));	
			_Table1_4.addCell(new Phrase("Vessel",fontBold));
			_Table1_4.addCell(new Phrase(lineItem.getVessel(),font));
			_Table1_4.addCell(new Phrase("Voyage",fontBold));					
			_Table1_4.addCell(new Phrase(lineItem.getVoyage(),font));					
			_Table1_4.addCell(new Phrase("",fontBold));			
			_Table1_4.addCell(new Phrase("",fontBold));

			_Table1_4.addCell(new Phrase("",fontBold));
			_Table1_4.addCell(new Phrase("",fontBold));	
			_Table1_4.addCell(new Phrase("Vessel Contact",fontBold));
			_Table1_4.addCell(new Phrase(lineItem.getVsbkcontact(),font));
			_Table1_4.addCell(new Phrase("Vessel Ref",fontBold));					
			_Table1_4.addCell(new Phrase(lineItem.getVsbkref(),font));						
			_Table1_4.addCell(new Phrase("",fontBold));			
			_Table1_4.addCell(new Phrase("",fontBold));

			_Table1_4.addCell(new Phrase("",fontBold));
			_Table1_4.addCell(new Phrase("",fontBold));	
			_Table1_4.addCell(new Phrase("Carrier",fontBold));
			_Table1_4.addCell(new Phrase(lineItem.getVendoraddr().getName(),font));
			_Table1_4.addCell(new Phrase("Sailing",fontBold));					
			_Table1_4.addCell(new Phrase(Util.dateTextFormat2(lineItem.getEstfromdate()),font));						
			_Table1_4.addCell(new Phrase("",fontBold));			
			_Table1_4.addCell(new Phrase("",fontBold));

			_PdfPCell = new PdfPCell(_Table1_4);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);


			// insert blank row
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);

			// new BaseColor(Color.BLACK) line
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);


			float[] widths1_3 =  
			{0.1f, 0.05f, 0.05f, 0.15f, 0.15f, 0.1f, 0.1f, 0.1f, 0.05f, 0.05f, 0.05f, 0.05f, 0.05f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);  	   	  		


			_Table1_3.addCell(new Phrase("Booking",fontSmallBold));
			_Table1_3.addCell(new Phrase("POL",fontSmallBold));	
			_Table1_3.addCell(new Phrase("POD",fontSmallBold));
			_Table1_3.addCell(new Phrase("Product",fontSmallBold));
			_Table1_3.addCell(new Phrase("Type",fontSmallBold));					
			_Table1_3.addCell(new Phrase("Tank",fontSmallBold));
			_Table1_3.addCell(new Phrase("Seal Numbers",fontSmallBold));			
			_Table1_3.addCell(new Phrase("Weight",fontSmallBold));
			_Table1_3.addCell(new Phrase("Width",fontSmallBold));
			_Table1_3.addCell(new Phrase("Length",fontSmallBold));
			_Table1_3.addCell(new Phrase("Height",fontSmallBold));
			_Table1_3.addCell(new Phrase("UnNo",fontSmallBold));
			_Table1_3.addCell(new Phrase("IMO",fontSmallBold));			


			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);

			// new BaseColor(Color.BLACK) line			
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(new BaseColor(Color.BLACK));
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);


		}
		catch (Exception e) {}	

		return _Table1;
	}



	public void outputDetailToPDF(UnitMoveDTO _lineItem, int _row) 
	throws DocumentException, BadElementException
	{		
		try {  	

			BaseColor lghtgry = new BaseColor(247, 247, 249);
			BaseColor lghtgry2 = new BaseColor(238, 238, 238);

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			float[] widths1_3 =  
			{0.1f, 0.05f, 0.05f, 0.15f, 0.15f, 0.1f, 0.1f, 0.1f, 0.05f, 0.05f, 0.05f, 0.05f, 0.05f};

			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER);   	   	  		


			try {_Table1_3.addCell(new Phrase(_lineItem.getBookkey(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getFromlocation().getLocationcode(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getTolocation().getLocationcode(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getProduct().getChemname(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}			

			try {
				_Table1_3.addCell(
						new Phrase(
								_lineItem.getUnit().getEqpkeyp1()+" / "+
								_lineItem.getUnit().getEqpkeyp2() 
								,fontTiny)
				);
			}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}		

			try {_Table1_3.addCell(new Phrase(_lineItem.getUnitkey(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getSealnumbers(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getWeightactual()+" "+_lineItem.getWeightactualunit(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}

			try {_Table1_3.addCell(new Phrase(_lineItem.getUnit().getWidth().toString(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}	

			try {_Table1_3.addCell(new Phrase(_lineItem.getUnit().getLength().toString(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}	

			try {_Table1_3.addCell(new Phrase(_lineItem.getUnit().getHeight().toString(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}	

			try {_Table1_3.addCell(new Phrase(_lineItem.getProduct().getUnno(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}	

			try {_Table1_3.addCell(new Phrase(_lineItem.getUnit().getImokey(),fontTiny));}
			catch (NullPointerException e) {_Table1_3.addCell(new Phrase("",fontTiny));}	



			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setColspan(1);			
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((_row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);	


			_Table1.addCell(_PdfPCell);

		}
		catch (Exception e) {
		}		
	}	


}
