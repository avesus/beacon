package com.bureaueye.beacon.action.edi.report;



import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;






import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.action.edi.pdf.ReportEdifactIftminEndPage;
import com.bureaueye.beacon.bean.LabelValue;
import com.bureaueye.beacon.bean.edi.EdifactIftminTransformer;
import com.bureaueye.beacon.bean.standard.Constants;

import com.bureaueye.beacon.form.edi.EDIInboundForm;
import com.bureaueye.beacon.model.edi.Ediinbound;
import com.bureaueye.beacon.model.edi.bd.EDIInboundBD;

import com.itextpdf.text.BaseColor;
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
 * NT	2007-09-10		ITT-200708-0003		New IFTMIN Summary Report (changes not marked)
 * 										
 * 										
 */
public final class ReportEdifactIftminAction extends BaseAction {

	private static final String[] 
	                            segmentsNoProcess =	{ "UNA","UNB","UNH","UNT","UNZ" };	

	private static com.itextpdf.text.Document _Document;
	private static PdfPTable _Table1;
	private static int CELL_BORDER = 0;



	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	


	private static BaseColor drkgry = new BaseColor(192, 192, 192);
	private static BaseColor lghtgry = new BaseColor(226, 226, 226);

	HSSFWorkbook wb;
	HSSFSheet sheet;
	private static boolean firstNAD = true;


	private static TreeMap _summaryDocument;
	private static int _row;


	public ReportEdifactIftminAction() {
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

		EDIInboundForm editForm = (EDIInboundForm) form;
		String action = editForm.getAction();


		HttpSession session = request.getSession(false);
		// If the session has timed-out then take the user back to the login
		// page
		if (
				(action == null) || 
				(session == null) || 
				(session.getAttribute(Constants.USER_KEY) == null)
		) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
			" Session has timed out");
			return mapping.findForward("ittmenu");
		}


		Ediinbound dto = null;

		dto = new EDIInboundBD().read(new Integer(editForm.getEdiinboundId()));
		if (dto == null) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.record.deleted", editForm.getEdiinboundId()));
			saveMessages(request, errors);
			return findFailure(mapping);
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  action: "+action);


		// summary report
		if (action.equals("Summary")) {

			if (dto.getDocument() != null && !dto.getDocument().equals("")) { 

				_summaryDocument = new TreeMap();
				_row = 1;


				try{
					Document doc = documentParseBuilder(dto.getXmldocument());
					NodeList segments = doc.getElementsByTagName("segment");

					// process segments
					for (int i=0;i<segments.getLength();i++){

						// get segment Id
						Node segmentNode = segments.item(i);
						String segmentId = segmentNode.getAttributes().getNamedItem("Id").getNodeValue().trim();

						boolean noProcess = false;
						for (int x=0; x<segmentsNoProcess.length; x++) { 
							if (segmentsNoProcess[x].equals(segmentId)) {
								noProcess = true;
								break;
							}
						}
						if (noProcess) continue;

						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segmentId["+segmentId+"]");

						LinkedList hm = new LinkedList();

						hm = getSegment(segments.item(i),segmentId);

						outputSummarySegment(hm, segmentId);		


					} // process segments

				}catch (NullPointerException ne){
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" NullPointerException error: " + ne.getMessage());				        	
				}catch (Exception e){
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Exception error: " + e.getMessage());			        	
				}


				try{   	
					// set excel output
					response.setContentType("application/vnd.ms-excel");		    			
					HSSFWorkbook wb = new HSSFWorkbook();
					HSSFSheet sheet = wb.createSheet("IFTMIN SUMMARY REPORT");

					// we style the second cell as a date (and time).  It is important to
					// create a new cell style from the workbook otherwise you can end up
					// modifying the built in style and effecting not only this cell but other cells.
					HSSFCellStyle dateCellStyle = wb.createCellStyle();
					dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

					HSSFCellStyle textCellStyle = wb.createCellStyle();
					textCellStyle.setWrapText(true);


					// Create label column row 
					HSSFRow row = sheet.createRow((short)0);

					// Create a cell and put a value in it.
					row.createCell((short)0).setCellValue("DOCUMENT NR");
					row.createCell((short)1).setCellValue("DOCUMENT DELIVERY INSTRUCTIONS");
					row.createCell((short)2).setCellValue("TOTAL NUMBER OF EQUIPMENT");
					row.createCell((short)3).setCellValue("TRANSPORT");
					row.createCell((short)4).setCellValue("ETS");			         
					row.createCell((short)5).setCellValue("SERVICE TYPE");
					row.createCell((short)6).setCellValue("PLACE OF DEPARTURE");
					row.createCell((short)7).setCellValue("PORT OF DISCHARGE");
					row.createCell((short)8).setCellValue("SHIPPER");
					row.createCell((short)9).setCellValue("CONSIGNEE");        
					row.createCell((short)10).setCellValue("NOTIFY PARTY NO 1");
					row.createCell((short)11).setCellValue("TELEFON");
					row.createCell((short)12).setCellValue("NOTIFY PARTY NO 2");				
					row.createCell((short)13).setCellValue("DOCUMENT RECIPIENT");			
					row.createCell((short)14).setCellValue("BILL OF LADING RECIPIENT");        
					row.createCell((short)15).setCellValue("MESSAGE RECIPIENT CONTACT 1");					
					row.createCell((short)16).setCellValue("MESSAGE RECIPIENT CONTACT 2");					
					row.createCell((short)17).setCellValue("GOODS ITEM NR");					
					row.createCell((short)18).setCellValue("GOODS INFORMATION");					
					row.createCell((short)19).setCellValue("WEIGHT KG");					
					row.createCell((short)20).setCellValue("DENSITY");					
					row.createCell((short)21).setCellValue("SCHMELZPUKNKT");
					row.createCell((short)22).setCellValue("SIEDEPUKNKT");
					row.createCell((short)23).setCellValue("LINE ITEM REFERENCE NUMBER");
					row.createCell((short)24).setCellValue("ORDER NUMBER");
					row.createCell((short)25).setCellValue("ORDERING CUST SECOND REFERENCE NR");
					row.createCell((short)26).setCellValue("ORIGINAL PO");
					row.createCell((short)27).setCellValue("MARKS AND NUMBERS OF A GOODS ITEM");
					row.createCell((short)28).setCellValue("DANGEROUS GOODS ADDITIONAL INFORMATION");
					row.createCell((short)29).setCellValue("LOADING INSTRUCTIONS");
					row.createCell((short)30).setCellValue("HANDLING INSTRUCTION");



					// output to excel spreadsheet
					int _excelrow=1;
					int _excelcol=0;		    		
					HSSFRow row2 = sheet.createRow((short)_excelrow);

					Iterator _keys = _summaryDocument.keySet().iterator();
					while (_keys.hasNext()) {
						String _key = (String)_keys.next();

						LabelValue labelValue = (LabelValue)_summaryDocument.get(_key);

						// get row
						int _nextrow=_excelrow;
						try {
							_nextrow=new Integer(_key.substring(0,_key.indexOf("_"))).intValue();
						} catch (Exception e) {}
						if (_nextrow!=_excelrow) {
							_excelrow=_nextrow;
							row2 = sheet.createRow((short)_excelrow);
						}
						// get col
						try {
							_excelcol=new Integer(_key.substring(_key.indexOf("_")+1,_key.length())).intValue();
						} catch (Exception e) {}

						HSSFCell _cell = row2.createCell((short)_excelcol);
						_cell.setCellValue( labelValue.getValue() );

						// special code to only output certain fields on row 1
						if (
								_excelrow>1 && 
								(	_excelcol==9 || 
										_excelcol==10 || 
										_excelcol==11 || 
										_excelcol==12 ||
										_excelcol==13 	)
						) _cell.setCellValue( "" );

						//_cell.setCellStyle( textCellStyle );
						//row2.createCell((short)_excelcol).setCellValue(labelValue.getValue());		    		

					}


					// Write the output to a file
					wb.write(response.getOutputStream());


				}catch (NullPointerException ne){
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" NullPointerException error: " + ne.getMessage());				        	
				}catch (Exception e){
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Exception error: " + e.getMessage());			        	
				}				



			}

			return null; 			

		}
		// detail report
		else {


			try {

				// convert report to PDF format
				// step 1: init document				
				_Document = new com.itextpdf.text.Document();	
				// init pagesize default for user			
				_Document.setPageSize(PageSize.A4);			
				_Document.setPageCount(1);			

				// step 2: we set the ContentType and create an instance of the corresponding Writer				
				response.setContentType("application/pdf");
				PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());

				// step 3: set document                       
				_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f);
				_Document.open();				
				_PdfWriter.setPageEvent(new ReportEdifactIftminEndPage());

				// create main table and add it to the document
				_Table1 = new PdfPTable(1);
				_Table1.getDefaultCell().setBorder(0);
				_Table1.getDefaultCell().setNoWrap(false);            		
				_Table1.setWidthPercentage(100f);  
				_Table1.getDefaultCell().setPadding(0);





				if (dto.getDocument() != null && !dto.getDocument().equals("")) {  


					try{
						Document doc = documentParseBuilder(dto.getXmldocument());
						NodeList segments = doc.getElementsByTagName("segment");

						// process segments
						for (int i=0;i<segments.getLength();i++){

							// get segment Id
							Node segmentNode = segments.item(i);
							String segmentId = segmentNode.getAttributes().getNamedItem("Id").getNodeValue().trim();

							boolean noProcess = false;
							for (int x=0; x<segmentsNoProcess.length; x++) { 
								if (segmentsNoProcess[x].equals(segmentId)) {
									noProcess = true;
									break;
								}
							}
							if (noProcess) continue;

							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" segmentId["+segmentId+"]");

							LinkedList hm = new LinkedList();

							hm = getSegment(segments.item(i),segmentId);

							outputSegment(hm, segmentId);

						} // process segments

					}catch (NullPointerException ne){
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" NullPointerException error: " + ne.getMessage());				        	
					}catch (Exception e){
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Exception error: " + e.getMessage());			        	
					}



				}






				// blank line
				PdfPCell blankLine=new PdfPCell(
						new Phrase("",fontBold)
				);
				blankLine.setBackgroundColor(new BaseColor(Color.WHITE));
				blankLine.setBorder(0);									
				blankLine.setFixedHeight(40);
				_Table1.addCell(blankLine);

				// end of report
				PdfPCell endofreportLine=new PdfPCell(
						new Phrase("***END OF INSTRUCTION MESSAGE REPORT***",fontBold)
				);
				endofreportLine.setBackgroundColor(drkgry);
				endofreportLine.setBorder(0);
				endofreportLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
				endofreportLine.setFixedHeight(20);
				_Table1.addCell(endofreportLine);
				endofreportLine=new PdfPCell(
						new Phrase("",fontBold)
				);
				endofreportLine.setBackgroundColor(new BaseColor(Color.WHITE));
				endofreportLine.setBorder(1);									
				endofreportLine.setFixedHeight(20);
				_Table1.addCell(endofreportLine);



				// add main table to PDF document
				_Document.add(_Table1);  

				// step 4: we close the document (the outputstream is also closed internally)
				_Document.close(); 

				return null; 


			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Exception error: " + e.getMessage());			
			}


		}		



		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}



	/**
	 * Parse list data.
	 * @param list data and segmentId.
	 * @return void.
	 */
	public void outputSegment(LinkedList hm, String segment){

		try {

			if (	
					hm != null 
			) {

				Font _subTitleFont = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
				_subTitleFont.setColor(drkgry);
				Font labelFont = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
				labelFont.setColor(lghtgry);		

				float[] widths1_3 = {0.40f, 0.60f}; 
				// working cell
				PdfPCell _PdfPCell;
				PdfPTable _Table1_3 = new PdfPTable(widths1_3);
				_Table1_3.getDefaultCell().setBorder(CELL_BORDER); 

				PdfPCell titleLine = null;

				if (segment.equals("BGM")) {
					titleLine=new PdfPCell(
							new Phrase("IFTMIN = INSTRUCTION MESSAGE",fontBold)
					);
					titleLine.setBackgroundColor(drkgry);
					titleLine.setBorder(1);
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					titleLine.setFixedHeight(20);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("CTA")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("COM")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(0);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("FTX")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("TSR")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}				
				if (segment.equals("CNT")) {
					titleLine=new PdfPCell(
							new Phrase("CONSIGNMENT INFORMATION",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);									
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("TCC")) {
					titleLine=new PdfPCell(
							new Phrase("TRANSPORT CHARGE/RATE CALCULATIONS",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);									
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("QTY")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}	
				if (segment.equals("DGS")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}				
				if (segment.equals("DTM")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}					
				if (segment.equals("MEA")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("LOC")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}				
				if (segment.equals("DOC")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("EQN")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}				
				if (segment.equals("PIA")) {
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("RFF")) {
					titleLine=new PdfPCell(
							new Phrase("REFERENCE",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);									
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);									
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("TDT")) {
					titleLine=new PdfPCell(
							new Phrase("TRANSPORTATION DETAILS",fontBold)
					);
					titleLine.setBackgroundColor(drkgry);
					titleLine.setBorder(1);		
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(20);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}	
				if (segment.equals("NAD") && firstNAD) {
					titleLine=new PdfPCell(
							new Phrase("ADDRESS AND DOCUMENT DETAILS",fontBold)
					);
					titleLine.setBackgroundColor(drkgry);
					titleLine.setBorder(1);		
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(20);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
					firstNAD = false;
				}					
				if (segment.equals("NAD")) {
					titleLine=new PdfPCell(
							new Phrase("NAME AND ADDRESS",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);		
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}	
				if (segment.equals("PCI")) {
					titleLine=new PdfPCell(
							new Phrase("MARKS AND NUMBERS OF A GOODS ITEM",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);		
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}				
				if (segment.equals("GID")) {
					titleLine=new PdfPCell(
							new Phrase("GOODS ITEMS DETAILS",fontBold)
					);
					titleLine.setBackgroundColor(drkgry);
					titleLine.setBorder(1);		
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(20);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("EQD")) {
					titleLine=new PdfPCell(
							new Phrase("EQUIPMENT DETAILS",fontBold)
					);
					titleLine.setBackgroundColor(drkgry);
					titleLine.setBorder(1);									
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(20);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}
				if (segment.equals("SGP")) {
					titleLine=new PdfPCell(
							new Phrase("SPLIT GOODS PLACEMENT",_subTitleFont)
					);
					titleLine.setBackgroundColor(lghtgry);
					titleLine.setBorder(1);									
					titleLine.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);										
					titleLine.setFixedHeight(15);
					_Table1.addCell(titleLine);
					titleLine=new PdfPCell();
					titleLine.setBorder(1);									
					_Table1.addCell(titleLine);
				}

				Iterator it = hm.iterator();
				int c = 0;
				while (it.hasNext()) {
					LabelValue labelValue = (LabelValue)it.next();
					// do not output segment descriptor
					c++;
					if (c==1) continue;

					// do not output label details if Free Text Segment
					// or Name and Address Segment
					//if (segment.equals("FTX") || segment.equals("NAD"))
					if (segment.equals("NAD") || segment.equals("RFF"))
						_Table1_3.addCell(new Phrase("",labelFont));
					else
						_Table1_3.addCell(new Phrase(labelValue.getLabel(),labelFont));

					_Table1_3.addCell(new Phrase(labelValue.getValue().toUpperCase(),font));										

				}

				// blank line
				_Table1_3.addCell(new Phrase("",font));				
				_Table1_3.addCell(new Phrase("",font));

				_PdfPCell = new PdfPCell(_Table1_3);
				_PdfPCell.setColspan(1);			
				_PdfPCell.setBorder(CELL_BORDER);			 	   	
				_Table1.addCell(_PdfPCell);


			}

		} catch (Exception e) {																					
		}

	}




	public static void outputSummarySegment(LinkedList hm, String segment){

		try {

			if (	
					hm != null 
			) {

				Iterator it = hm.iterator();
				int c = 0;
				while (it.hasNext()) {
					LabelValue labelValue = (LabelValue)it.next();
					// do not output segment descriptor
					c++;
					if (c==1) continue;



					//label=Document number 
					//value=2001603207 
					//segment=BGM
					if (
							segment.equals("BGM") && 
							labelValue.getLabel().equals("Document number")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						labelValue2.setValue("document nr");
						labelValue2.setValue(labelValue.getValue());
						String _key = new String(_row+"_00");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=Supplementary information 
					//value=DOCUMENTS DELIVERY INSTRUCTIONS 
					//segment=FTX
					if (
							segment.equals("FTX") && 
							labelValue.getValue().equals("DOCUMENTS DELIVERY INSTRUCTIONS")
					) {
						String _text = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}						
						LabelValue labelValue2 = new LabelValue("documents delivery instructions",_text);
						String _key = new String(_row+"_01");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=Control type 
					//value=TOTAL NUMBER OF EQUIPMENT 
					//segment=CNT					 
					if (
							segment.equals("CNT") && 
							labelValue.getValue().equals("TOTAL NUMBER OF EQUIPMENT")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("total number of equipment"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_02");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=Transport stage 
					//value=MAIN TRANSPORT 
					//segment=TDT					
					if (
							segment.equals("TDT") && 
							labelValue.getValue().equals("MAIN TRANSPORT")
					) {
						if( it.hasNext()) labelValue = (LabelValue)it.next();
						if( it.hasNext()) labelValue = (LabelValue)it.next();
						if( it.hasNext()) labelValue = (LabelValue)it.next();
						LabelValue labelValue2 = new LabelValue("","");
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("service type"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_03");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=Date/Time period type 
					//value=DEPARTURE DATE/TIME ESTIMATED 
					//segment=DTM
					if (
							segment.equals("DTM") && 
							labelValue.getValue().equals("DEPARTURE DATE/TIME ESTIMATED")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("ets"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_04");
						_summaryDocument.put(_key,labelValue2);
					}		

					if (
							segment.equals("TSR") 
					) {
						LabelValue labelValue2 = new LabelValue("service type",labelValue.getValue());
						String _key = new String(_row+"_05");
						_summaryDocument.put(_key,labelValue2);
					}

					if (
							segment.equals("LOC") && 
							labelValue.getValue().equals("PLACE OF DEPARTURE")
					) {
						if( it.hasNext()) labelValue = (LabelValue)it.next();
						LabelValue labelValue2 = new LabelValue("","");
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("place of departure"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_06");
						_summaryDocument.put(_key,labelValue2);
					}							
					if (
							segment.equals("LOC") && 
							labelValue.getValue().equals("PORT OF DISCHARGE")
					) {
						if( it.hasNext()) labelValue = (LabelValue)it.next();
						LabelValue labelValue2 = new LabelValue("","");
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("port of discharge"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_07");
						_summaryDocument.put(_key,labelValue2);
					}



					//label=PARTY FUNCTION 
					//value=ORIGINAL SHIPPER FOR BL 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("ORIGINAL SHIPPER FOR BL")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("shipper",_address);
						String _key = new String(_row+"_08");
						_summaryDocument.put(_key,labelValue2);
					}





					//label=PARTY FUNCTION 
					//value=BILL OF LADING RECIPIENT 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("BILL OF LADING RECIPIENT")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("document recipient",_address);
						String _key = new String(_row+"_14");
						_summaryDocument.put(_key,labelValue2);
					}



					//label=Communication reference 1 
					//value=indent.invoices@basf.com 
					//segment=COM
					if (
							segment.equals("COM") &&
							labelValue.getValue().equals("Communication reference 1")
					) {
						LabelValue labelValue2 = new LabelValue("message recipient contact",labelValue.getValue());
						String _key = new String(_row+"_15");						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							if (labelValue.getValue().equals("EM")) _key = new String(_row+"_16"); 
						}						
						_summaryDocument.put(_key,labelValue2);						
					}


					if (
							segment.equals("GID") 						
					) {
						//calculate new row value from goods item number
						try{_row=new Integer(labelValue.getValue()).intValue();} catch(Exception e){}

						LabelValue labelValue2 = new LabelValue("good item number",labelValue.getValue());
						String _key = new String(_row+"_17");
						_summaryDocument.put(_key,labelValue2);						
					}	


					//label=PARTY FUNCTION 
					//value=Consignee 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("Consignee")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("consignee",_address);
						String _key = new String(_row+"_09");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=PARTY FUNCTION 
					//value=Notify party no. 1 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("Notify party no. 1")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("notify party no 1",_address);
						String _key = new String(_row+"_10");
						_summaryDocument.put(_key,labelValue2);
					}


					//label=Location type 
					//value=LOCATION INFORMATION RELATED TO CURRENT PARTY 
					//segment=LOC
					if (
							segment.equals("LOC") && 
							labelValue.getValue().equals("LOCATION INFORMATION RELATED TO CURRENT PARTY")
					) {
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							if (
									labelValue.getValue().equals("TELEFON")
							) {	
								LabelValue labelValue2 = new LabelValue("","");
								if( it.hasNext()) {
									labelValue = (LabelValue)it.next();
									labelValue2.setLabel("telefon"); 
									labelValue2.setValue(labelValue.getValue());
								}
								String _key = new String(_row+"_11");
								_summaryDocument.put(_key,labelValue2);
							}
						}
					}


					//label=PARTY FUNCTION 
					//value=Notify party no. 2 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("Notify party no. 2")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("notify party no 2",_address);
						String _key = new String(_row+"_12");
						_summaryDocument.put(_key,labelValue2);
					}

					//label=PARTY FUNCTION 
					//value=Document recipient 
					//segment=NAD
					if (
							segment.equals("NAD") && 
							labelValue.getValue().equals("Document recipient")
					) {
						String _address = "";
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}						
						if( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_address = _address+", "+labelValue.getValue();
						}	
						LabelValue labelValue2 = new LabelValue("document recipient",_address);
						String _key = new String(_row+"_13");
						_summaryDocument.put(_key,labelValue2);
					}


					if (
							segment.equals("FTX") && 
							labelValue.getValue().equals("GOODS INFORMATION")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("goods information"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_18");
						_summaryDocument.put(_key,labelValue2);
					}


					//label=Measurement application 
					//value=WEIGHTS 
					//segment=MEA				
					if (
							segment.equals("MEA") &&
							labelValue.getValue().equals("WEIGHTS")
					) {
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							if (
									labelValue.getValue().equals("TOTAL NET WEIGHT")
							) {	

								if ( it.hasNext()) labelValue = (LabelValue)it.next();
								LabelValue labelValue2 = new LabelValue("","");
								if ( it.hasNext()) {
									labelValue = (LabelValue)it.next();
									labelValue2.setLabel("weight kg"); labelValue2.setValue(labelValue.getValue());
								}
								String _key = new String(_row+"_19");
								_summaryDocument.put(_key,labelValue2);
							}
						}
					}

					//label=Measurement application 
					//value=DENSITY 
					//segment=MEA					
					if (
							segment.equals("MEA") &&
							labelValue.getValue().equals("DENSITY")
					) {
						if (it.hasNext()) labelValue = (LabelValue)it.next();						
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							if (
									labelValue.getValue().equals("Stoffdichte (20 C)")
							) {	

								if( it.hasNext()) labelValue = (LabelValue)it.next();
								LabelValue labelValue2 = new LabelValue("","");
								if( it.hasNext()) {
									labelValue = (LabelValue)it.next();
									labelValue2.setLabel("density"); labelValue2.setValue(labelValue.getValue());
								}
								String _key = new String(_row+"_20");
								_summaryDocument.put(_key,labelValue2);
							}
						}
					}


					//label=Measurement application 
					//value=TEMPERATURE 
					//segment=MEA					
					if (
							segment.equals("MEA") &&
							labelValue.getValue().equals("TEMPERATURE")
					) {
						if (it.hasNext()) labelValue = (LabelValue)it.next();
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							if (
									labelValue.getValue().equals("Schmelzpunkt")
							) {	

								if( it.hasNext()) labelValue = (LabelValue)it.next();
								LabelValue labelValue2 = new LabelValue("","");
								if( it.hasNext()) {
									labelValue = (LabelValue)it.next();
									labelValue2.setLabel("schmelzpunkt"); labelValue2.setValue(labelValue.getValue());
								}
								String _key = new String(_row+"_21");
								_summaryDocument.put(_key,labelValue2);
							}
							if (
									labelValue.getValue().equals("Siedepunkt")
							) {	

								if( it.hasNext()) labelValue = (LabelValue)it.next();
								LabelValue labelValue2 = new LabelValue("","");
								if( it.hasNext()) {
									labelValue = (LabelValue)it.next();
									labelValue2.setLabel("siedepunkt"); labelValue2.setValue(labelValue.getValue());
								}
								String _key = new String(_row+"_22");
								_summaryDocument.put(_key,labelValue2);
							}							
						}
					}




					if (
							segment.equals("RFF") && 
							labelValue.getValue().equals("LINE ITEM REFERENCE NUMBER")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("line item reference number"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_23");
						_summaryDocument.put(_key,labelValue2);				
					}


					//label=Reference type 
					//value=ORDER NUMBER (VENDOR) 
					//segment=RFF
					if (
							segment.equals("RFF") && 
							labelValue.getValue().equals("ORDER NUMBER (VENDOR)")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("order number"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_24");
						_summaryDocument.put(_key,labelValue2);				
					}


					//label=Reference type 
					//value=ORDERING CUSTOMERS SECOND REFERENCE NUMBER 
					//segment=RFF
					if (
							segment.equals("RFF") && 
							labelValue.getValue().equals("ORDERING CUSTOMERS SECOND REFERENCE NUMBER")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("ordering cust second reference number"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_25");
						_summaryDocument.put(_key,labelValue2);				
					}


					//label=Reference type 
					//value=ORIGINAL PURCHASE ORDER 
					//segment=RFF
					if (
							segment.equals("RFF") && 
							labelValue.getValue().equals("ORIGINAL PURCHASE ORDER")
					) {
						LabelValue labelValue2 = new LabelValue("","");
						if (it.hasNext()) {
							labelValue = (LabelValue)it.next();
							labelValue2.setLabel("original po"); labelValue2.setValue(labelValue.getValue());
						}
						String _key = new String(_row+"_26");
						_summaryDocument.put(_key,labelValue2);				
					}


					//label=Shipping marks 1 
					//value=BASF 
					//segment=PCI
					if (
							segment.equals("PCI") && 
							labelValue.getLabel().equals("Shipping marks 1")
					) {
						String _text = "1: "+labelValue.getValue();
						int _count=2;
						while ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+"  "+_count+": "+labelValue.getValue();
							_count++;
						}
						LabelValue labelValue2 = new LabelValue("marks and numbers of a goods item",_text);
						String _key = new String(_row+"_27");
						_summaryDocument.put(_key,labelValue2);
					}



					//label=Supplementary information 
					//value=Dangerous goods additional information 
					//segment=FTX
					if (
							segment.equals("FTX") && 
							labelValue.getValue().equals("Dangerous goods additional information")
					) {
						String _text = "";
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}	
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}							
						LabelValue labelValue2 = new LabelValue("dangerous goods additional information",_text);
						String _key = new String(_row+"_28");
						_summaryDocument.put(_key,labelValue2);
					}	


					//label=Supplementary information 
					//value=LOADING INSTRUCTION 
					//segment=FTX
					if (
							segment.equals("FTX") && 
							labelValue.getValue().equals("LOADING INSTRUCTION")
					) {
						String _text = "";
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}	
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}							
						LabelValue labelValue2 = new LabelValue("loading instructions",_text);
						String _key = new String(_row+"_29");

						//check row and cell already has a value
						LabelValue labelValue3 = (LabelValue)_summaryDocument.get(_key);
						if (labelValue3 != null) _text = labelValue3.getValue()+" "+_text;
						labelValue2.setValue(_text);

						_summaryDocument.put(_key,labelValue2);
					}


					//label=Supplementary information 
					//value=HANDLING RESTRICTION 
					//segment=FTX
					if (
							segment.equals("FTX") && 
							labelValue.getValue().equals("HANDLING RESTRICTION")
					) {
						String _text = "";
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}	
						if ( it.hasNext()) {
							labelValue = (LabelValue)it.next();
							_text = _text+" "+labelValue.getValue();
						}							
						LabelValue labelValue2 = new LabelValue("handling restriction",_text);
						String _key = new String(_row+"_30");
						_summaryDocument.put(_key,labelValue2);
					}


				}

			}

		} catch (Exception e) {																					
		}

	}




	/**
	 * Parse soap response of Authentication.
	 * @param soapTokenResponse the soap response from Authentication service.
	 * @return String.
	 */
	public static String getToken(String soapTokenResponse){
		String strToken = null;
		try {
			Document doc = documentParseBuilder(soapTokenResponse);
			strToken = doc.getElementsByTagName("Result").item(0).getLastChild().getNodeValue().trim();
		}catch (NullPointerException ne) {
		}catch (Exception e) {
		}
		return strToken;
	}

	/**
	 * Create document to parse soap response.
	 * @param soapResponse the soap response from Autentication or AddressFinder service.
	 * @return Document.
	 */
	public static Document documentParseBuilder(String soapResponse){
		Document doc = null;
		try{
			DocumentBuilderFactory parseFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parseBuilder = parseFactory.newDocumentBuilder();

			doc = parseBuilder.parse(new InputSource(new StringReader(soapResponse)));

		}catch(ParserConfigurationException pce){
		}catch(IOException ioe){
		}catch(SAXException se){
		}catch(NullPointerException ne){
		}
		return doc;
	}



	/**
	 * Echo common attributes of a DOM2 Node and terminate output with an
	 * EOL character.
	 */
	private LinkedList getSegment(Node segmentNode, String segmentId) {

		LinkedList hm = new LinkedList();

		try {

			Class classEdifactIftminTransformer = Class.forName("com.bureaueye.beacon.bean.edi.EdifactIftminTransformer");
			Class[] argTypes = { org.w3c.dom.Node.class };    		
			try {
				String methodName = "get"+segmentId;
				// initialise work mthod depending on Segment to process
				Method worker = classEdifactIftminTransformer.getMethod(
						methodName,
						argTypes
				);
				// initialise actual data to send
				Object[] theData = { segmentNode };
				// invoke worker method
				hm = (LinkedList)worker.invoke(new EdifactIftminTransformer(), theData);											

			} catch (Exception e2) {				
				//log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
				//		" invoke error: " + e2.getMessage());																	
			}


		} catch (Exception e) {	
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" exception error: " + e.getMessage());				
		}

		return hm;
	}





}
