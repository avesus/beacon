package com.bureaueye.beacon.action.mandr.print;


import java.math.BigDecimal;
import java.util.Arrays;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.action.quotation.pdf.QuotationEndPage;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.bd.MandrdtlBD;
import com.bureaueye.beacon.model.mandr.bd.MandrhdrBD;
import com.bureaueye.beacon.model.mandr.dto.MandrdtlDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;

import com.bureaueye.beacon.util.Util;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



/**
 * Amendments
 * ----------
 *  												
 *
 */
public final class PrintMandrAction extends BaseAction {
	
	private static Document _Document;
	private static PdfPTable _Table1;
	private static int CELL_BORDER = 0;
	
	

	
	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	
	
	private static BaseColor lghtgry = new BaseColor(247, 247, 249);
	private static BaseColor lghtgry2 = new BaseColor(238, 238, 238);
	private static BaseColor blue = new BaseColor(0,78,152);
	private static BaseColor darkgry = new BaseColor(127,127,127);
	
	
	private Address customeraddr = new Address();
	private Location depotlocation = new Location();
	

	
	public PrintMandrAction() {
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					//Font.FontFamily.COURIER,
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
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
		User user = (User) session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY);
		
		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" isNew = " + session.isNew());
		
		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" formsToSkip = " + formsToSkip);
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
		
		
		try {
			
			// convert report to PDF format
			// step 1: init document				
			_Document = new Document();	
			// init pagesize default for user			
			_Document.setPageSize(PageSize.A4);			
			_Document.setPageCount(1);			
			if (user != null && user.getPagesize().equals("LEGAL")) _Document.setPageSize(PageSize.LEGAL);
			if (user != null && user.getPagesize().equals("LETTER")) _Document.setPageSize(PageSize.LETTER);
			
			// step 2: we set the ContentType and create an instance of the corresponding Writer				
			response.setContentType("application/pdf");
			PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());
			
			// step 3: set document                       
			_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f);
			_Document.open();				
			_PdfWriter.setPageEvent(new QuotationEndPage());
			
			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(0);
			
			// read  header
			Mandrhdr hdr = null;
			try { hdr = new MandrhdrBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId())); } catch (ApplicationException ae) {}
			if (hdr != null) outputHeaderToPDF(hdr);   
			
			// new page at end of footer
			_Document.newPage();
			
			
			// read details
			// set line items
			List dtls = null;
			try {
				dtls = new MandrdtlBD(
						this.getSessionFactoryClusterMap()
				)
				.findMandrdtlsById(
						hdr.getMandrhdrId().toString(), 
						0, 
						99, 
						"Itemno"
				);
			} catch (ApplicationException ae) {}					
			
			
			if (dtls != null && dtls.size() > 0) {  
				
				outputDetailHeaderToPDF();
				
				// process details list collection
				Iterator it = dtls.iterator();
				int row = 0;
				while (it.hasNext()) {
					// init 
					MandrdtlDTO lineItem = (MandrdtlDTO) it.next();
					
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
			
			if (hdr != null) outputFooterToPDF(hdr);
			
			
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
		
		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());
		
		return findSuccess(mapping);
	}
	
	
	public void outputDetailHeaderToPDF() 
	throws DocumentException, BadElementException
	{
		
		try {  				
						
			
			

			Font detailLabelFont = new Font(font.getFamily(), font.getSize()-3, fontBold.getStyle());
			detailLabelFont.setColor(darkgry);
			Font detailTextFont = new Font(font.getFamily(), font.getSize()-3, fontBold.getStyle());
			detailTextFont.setColor(blue);

			
			
			// working cell
			PdfPCell _PdfPCell;
			
			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",detailLabelFont));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);
			
			
			
			
			float[] widths1_3 = {0.05f, 0.10f, 0.08f, 0.08f, 0.08f, 0.07f, 0.07f, 0.06f, 0.06f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f}; 
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_3.addCell(new Phrase("Item",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Component",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Location",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Damage",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Repair",detailLabelFont));		
			_Table1_3.addCell(new Phrase("",detailLabelFont));		
			_Table1_3.addCell(new Phrase("",detailLabelFont));		
			_Table1_3.addCell(new Phrase("",detailLabelFont));
			_Table1_3.addCell(new Phrase("",detailLabelFont));
			_Table1_3.addCell(new Phrase("Labor",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Labor",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Labour",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Material",detailLabelFont));
			_Table1_3.addCell(new Phrase("Total",detailLabelFont));
			
			_Table1_3.addCell(new Phrase("No",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Code",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Code",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Code",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Code",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Length",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Width",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Qty",detailLabelFont));
			_Table1_3.addCell(new Phrase("Party",detailLabelFont));
			_Table1_3.addCell(new Phrase("Hours",detailLabelFont));
			_Table1_3.addCell(new Phrase("Rate",detailLabelFont));			
			_Table1_3.addCell(new Phrase("Amount",detailLabelFont));		
			_Table1_3.addCell(new Phrase("Amount",detailLabelFont));
			_Table1_3.addCell(new Phrase("Amount",detailLabelFont));
			
			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);
			
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(darkgry);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	
			
		}
		catch (Exception e) {}			
	}			
	
	
	public void outputDetailToPDF(MandrdtlDTO dtl, int row) 
	throws DocumentException, BadElementException
	{
		
		try {  				

			Font titleLabelFont = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			titleLabelFont.setColor(darkgry);
			Font headerLabelFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			headerLabelFont.setColor(darkgry);			
			Font headerTextFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			headerTextFont.setColor(blue);
			Font footerLabelFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			footerLabelFont.setColor(darkgry);			
			Font footerTextFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			footerTextFont.setColor(blue);	
			Font detailLabelFont = new Font(font.getFamily(), font.getSize()-3, fontBold.getStyle());
			detailLabelFont.setColor(darkgry);
			Font detailTextFont = new Font(font.getFamily(), font.getSize()-3, fontBold.getStyle());
			detailTextFont.setColor(blue);
			
			
			// working cell
			PdfPCell _PdfPCell;
			
			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",detailTextFont));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);
			
			float[] widths1_3 = {0.05f, 0.10f, 0.08f, 0.08f, 0.08f, 0.07f, 0.07f, 0.06f, 0.06f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f};  
			PdfPTable _Table1_3 = new PdfPTable(widths1_3);
			_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 
			
			try {
				_Table1_3.addCell(new Phrase(dtl.getItemno().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getComponentcode(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getLocationcode1(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getDamagecode(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getRepaircode(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getLength().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}			
			try {
				_Table1_3.addCell(new Phrase(dtl.getWidth().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}	
			try {
				_Table1_3.addCell(new Phrase(dtl.getQuantity().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getResponsibilitycode().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getLaborhours().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getLaborrate().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getLaboramt().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getMaterialamt().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			try {
				_Table1_3.addCell(new Phrase(dtl.getTotalamt().toString(),detailTextFont));
			} catch (Exception e) {
				_Table1_3.addCell(new Phrase("0.0",detailTextFont));
			}
			
			_PdfPCell = new PdfPCell(_Table1_3);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);				 	   	
			_Table1.addCell(_PdfPCell);
			
			
			float[] widths1_4 = {0.01f, 0.99f};  
			PdfPTable _Table1_4 = new PdfPTable(widths1_4);
			_Table1_4.getDefaultCell().setBorder(CELL_BORDER); 
			
			_Table1_4.addCell(new Phrase("",detailTextFont));
			try {
				_Table1_4.addCell(new Phrase(dtl.getTxt1()+" ",detailTextFont));
			} catch (Exception e) {
				_Table1_4.addCell(new Phrase(" ",detailTextFont));
			}
			_PdfPCell = new PdfPCell(_Table1_4);
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setBackgroundColor(lghtgry);
			if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);				 	   	
			_Table1.addCell(_PdfPCell);
			
			
		}
		catch (Exception e) {}			
	}		
	
	
	public void outputHeaderToPDF(Mandrhdr hdr) 
	throws DocumentException, BadElementException
	{
		
		try {  	
			
			
			Font titleLabelFont = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			titleLabelFont.setColor(darkgry);
			Font headerLabelFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			headerLabelFont.setColor(darkgry);			
			Font headerTextFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			headerTextFont.setColor(blue);

			
			
			// working cell
			PdfPCell _PdfPCell;
			
			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",titleLabelFont));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);
			
			// title label
			_PdfPCell = new PdfPCell(new Phrase("REPAIR ESTIMATE",titleLabelFont));
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			_Table1.addCell(_PdfPCell);
			
			try{this.setCustomeraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(hdr.getCustomeraddrkey()));}catch(Exception e){}
			try{this.setDepotlocation(new LocationBD(this.getSessionFactoryClusterMap()).read(hdr.getDepotlocationkey()));}catch(Exception e){}
			
			
			float[] widths1_7 = {0.17f, 0.15f, 0.10f, 0.25f}; 
			PdfPTable _Table1_7 = new PdfPTable(widths1_7);
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);  	   	  		
			// insert blank row
			_BlankCell.setColspan(4);
			_Table1_7.addCell(_BlankCell);
			_Table1_7.addCell(new Phrase("Unit Number:",headerLabelFont));
			_Table1_7.addCell(new Phrase(hdr.getUnitkey(),headerTextFont));
			_Table1_7.addCell(new Phrase("Depot:",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getDepotlocation().getLocationName(),headerTextFont));
			_Table1_7.addCell(new Phrase("Estimate Date:",headerLabelFont));
			_Table1_7.addCell(new Phrase(Util.dateTextFormat2(hdr.getEstimatedate()),headerTextFont));
			_Table1_7.addCell(new Phrase("",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getDepotlocation().getAddress1(),headerTextFont));
			_Table1_7.addCell(new Phrase("Estimate Ref:",headerLabelFont));
			_Table1_7.addCell(new Phrase(hdr.getEstimateref(),headerTextFont));
			_Table1_7.addCell(new Phrase("",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getDepotlocation().getAddress2(),headerTextFont));
			_Table1_7.addCell(new Phrase("Labor Rate:",headerLabelFont));
			_Table1_7.addCell(new Phrase(hdr.getLaborrate().toString(),headerTextFont));
			_Table1_7.addCell(new Phrase("Customer:",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getCustomeraddr().getName(),headerTextFont));
			_Table1_7.addCell(new Phrase("Original Estimate Date:",headerLabelFont));
			_Table1_7.addCell(new Phrase(Util.dateTextFormat2(hdr.getOriginalestimatedate()),headerTextFont));
			_Table1_7.addCell(new Phrase("",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getCustomeraddr().getAddr1(),headerTextFont));
			_Table1_7.addCell(new Phrase("Esimate Currency:",headerLabelFont));
			_Table1_7.addCell(new Phrase(hdr.getCcykey().toString(),headerTextFont));
			_Table1_7.addCell(new Phrase("",headerLabelFont));
			_Table1_7.addCell(new Phrase(this.getCustomeraddr().getAddr2(),headerTextFont));
			_Table1_7.addCell(new Phrase("Version Number:",headerLabelFont));
			_Table1_7.addCell(new Phrase(hdr.getVersionno().toString(),headerTextFont));
			_Table1_7.addCell(new Phrase("",headerLabelFont));
			_Table1_7.addCell(new Phrase("",headerTextFont));
			_PdfPCell = new PdfPCell(_Table1_7);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);
			
			
			
			
			// insert blank rows
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);			
			
			
		}
		catch (Exception e) {}		
	}	
	
	
	public void outputFooterToPDF(Mandrhdr hdr) 
	throws DocumentException, BadElementException
	{
		
		try {  	
		
			
			Font footerLabelFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			footerLabelFont.setColor(darkgry);			
			Font footerTextFont = new Font(font.getFamily(), font.getSize(), fontBold.getStyle());
			footerTextFont.setColor(blue);	

			
			// working cell
			PdfPCell _PdfPCell;
			
			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",footerLabelFont));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);
			
			
			// insert blank rows
			_BlankCell.setColspan(2);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);			
			
			
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(darkgry);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	
			
			
			float[] widths1_7 = {0.3f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.2f}; 
			PdfPTable _Table1_7 = new PdfPTable(widths1_7);
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);  	   	  		
			
			_Table1_7.addCell(new Phrase("Summary",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			_Table1_7.addCell(new Phrase("Labor",footerLabelFont));
			_Table1_7.addCell(new Phrase("Material",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			_Table1_7.addCell(new Phrase("Hours",footerLabelFont));
			_Table1_7.addCell(new Phrase("Cost",footerLabelFont));
			_Table1_7.addCell(new Phrase("Cost",footerLabelFont));
			_Table1_7.addCell(new Phrase("Tax",footerLabelFont));
			_Table1_7.addCell(new Phrase("Total",footerLabelFont));
			_Table1_7.addCell(new Phrase("",footerLabelFont));
			
			
			
			
			// list totals 
			MandrdtlBD dtlbd = new MandrdtlBD(this.getSessionFactoryClusterMap());
			List totals = null;
			try {
				totals=dtlbd.findMandrdtlsTotalsGroupbyResponsibilitycode(hdr.getMandrhdrId());
			}
			catch(Exception e){	
			}			
			// iterate results 
			for (Iterator it = totals.iterator(); it.hasNext();) {
				Object[] obj =(Object[])it.next();
				String responsibilitycode=(String)obj[0];
				BigDecimal materialamt=(BigDecimal)obj[1];
				BigDecimal laboramt=(BigDecimal)obj[2];
				BigDecimal totalamt=(BigDecimal)obj[3];
				BigDecimal laborhours=(BigDecimal)obj[4];
				try {
					if (responsibilitycode.equals("U"))	_Table1_7.addCell(new Phrase("User/Lessee",footerLabelFont));
					if (responsibilitycode.equals("O"))	_Table1_7.addCell(new Phrase("Owner/Lessor",footerLabelFont));
					_Table1_7.addCell(new Phrase(new CurrencyFormatter().format(laborhours),footerTextFont));
					_Table1_7.addCell(new Phrase(new CurrencyFormatter().format(laboramt),footerTextFont));
					_Table1_7.addCell(new Phrase(new CurrencyFormatter().format(materialamt),footerTextFont));
					_Table1_7.addCell(new Phrase("",footerTextFont));
					_Table1_7.addCell(new Phrase(new CurrencyFormatter().format(totalamt),footerTextFont));
					_Table1_7.addCell(new Phrase("",footerTextFont));					
					
				} catch (Exception e) {		
				}
			}

			_PdfPCell = new PdfPCell(_Table1_7);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);
			
			
			// insert blank row
			_Table1.addCell(_BlankCell);
			
			
			float[] widths1_9 = {0.3f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.2f}; 
			PdfPTable _Table1_9 = new PdfPTable(widths1_9);
			_Table1_9.getDefaultCell().setBorder(CELL_BORDER); 
			Object[] total=null;
			try {
				total=dtlbd.findMandrdtlsTotals(hdr.getMandrhdrId());
			}
			catch(Exception e){	
			}			
			// 
			BigDecimal materialamt=(BigDecimal)total[0];
			BigDecimal laboramt=(BigDecimal)total[1];
			BigDecimal totalamt=(BigDecimal)total[2];
			BigDecimal laborhours=(BigDecimal)total[3];
			try {
				_Table1_9.addCell(new Phrase("Total",footerLabelFont));
				_Table1_9.addCell(new Phrase(new CurrencyFormatter().format(laborhours),footerTextFont));
				_Table1_9.addCell(new Phrase(new CurrencyFormatter().format(laboramt),footerTextFont));
				_Table1_9.addCell(new Phrase(new CurrencyFormatter().format(materialamt),footerTextFont));
				_Table1_9.addCell(new Phrase("",footerTextFont));
				_Table1_9.addCell(new Phrase(new CurrencyFormatter().format(totalamt),footerTextFont));
				_Table1_9.addCell(new Phrase("",footerTextFont));					
				
			} catch (Exception e) {		
			}
			
			_PdfPCell = new PdfPCell(_Table1_9);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);
			
			
//			insert blank row
			_Table1.addCell(_BlankCell);			
			
			
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(darkgry);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	
			
			
			
			// insert blank row
			_Table1.addCell(_BlankCell);
			
			
			float[] widths1_8 = {0.15f, 0.85f}; 
			PdfPTable _Table1_8 = new PdfPTable(widths1_8);
			_Table1_8.getDefaultCell().setBorder(CELL_BORDER); 
			_Table1_8.addCell(new Phrase("Comments:",footerLabelFont));
			_Table1_8.addCell(new Phrase(hdr.getTxt1(),footerTextFont));			
			_PdfPCell = new PdfPCell(_Table1_8);
			_PdfPCell.setBorder(CELL_BORDER);			 	   	
			_Table1.addCell(_PdfPCell);			
			
			// insert blank row
			_Table1.addCell(_BlankCell);			
			
			
			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(darkgry);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);	
			
			
			
		}
		catch (Exception e) {}		
	}	
	
	
	private Address getCustomeraddr () {
		return customeraddr;
	}
	private void setCustomeraddr (Address customeraddr) {
		this.customeraddr = customeraddr;
	}
	
	
	private Location getDepotlocation () {
		return depotlocation;
	}
	private void setDepotlocation (Location depotlocation) {
		this.depotlocation = depotlocation;
	}
	
	
}