package com.bureaueye.beacon.action.order.print;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;

import com.bureaueye.beacon.action.order.pdf.EndPageArrivalnotice;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.print.PrintdtlForm;
import com.bureaueye.beacon.form.print.PrinthdrForm;
import com.bureaueye.beacon.model.print.Printdtl;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.PrintdtlBD;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.util.Util;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





/**
 */
public class SaveArrivalnoticeAction extends BaseAction {


	private Document _Document;
	private FileOutputStream _fileOutputStream;
	private PdfPTable _Table1;


	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading; 


	private int CELL_BORDER = 0;


	BaseColor headingColor = new BaseColor(180, 43, 22);
	BaseColor lghtgry = new BaseColor(247, 247, 249);
	BaseColor lghtgry2 = new BaseColor(238, 238, 238);
	BaseColor black = new BaseColor(0, 0, 0);
	BaseColor white = new BaseColor(255, 255, 255);

	public SaveArrivalnoticeAction() {
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
			fontHeading = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			fontHeading.setColor(headingColor);
		} catch (Exception e) {
		}
	}



	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		PrinthdrForm saveForm = (PrinthdrForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();


		// If the session has timed-out then take the user back to the login page
		if (action == null || session == null || user == null) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Session has timed out");
			return mapping.findForward("welcome");
		}

		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action+ " action");

		// Generate Business Delegate
		PrinthdrBD bd = new PrinthdrBD(this.getSessionFactoryClusterMap());
		PrintdtlBD printdtlbd = new PrintdtlBD(this.getSessionFactoryClusterMap());

		// initialise print header and details
		Printhdr dao = null;
		dao = bd.findPrinthdrByPrintId(saveForm.getPrintId());	
		try{saveForm.setPrinthdrId(dao.getPrinthdrId().toString());}catch(Exception e){}
		// not found create empty object
		if (dao == null) {
			dao = new Printhdr();
		}


		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, messages);
			return (mapping.getInputForward());
		}		


		try {
			// populate data-transfer-object from form
			// init FORM with DTO values
			BeanUtils.copyProperties(dao, saveForm);
		} catch (IllegalAccessException ite) {	
		} catch (InvocationTargetException ite) {
		} catch (Exception e) {
		}


		if (action.equals("Delete")) {		

			// delete parent and children
			bd.deleteAll(new Integer(saveForm.getPrinthdrId()), user);

		} else {

			try {
				// update header
				bd.createOrUpdate(dao, user);
			} catch (ApplicationException ae) {
			}

			// update details
			for (Iterator it = saveForm.getPrintdtls().iterator(); it.hasNext();) {
				PrintdtlForm printdtlForm = (PrintdtlForm)it.next();
				Printdtl printdtldto = new Printdtl();

				try {
					// populate data-transfer-object from form
					// init FORM with DTO values
					BeanUtils.copyProperties(printdtldto, printdtlForm);
				} catch (IllegalAccessException ite) {	
				} catch (InvocationTargetException ite) {
				} catch (Exception e) {
				}			

				printdtldto.setPrinthdrId(dao.getPrinthdrId());				
				try {
					printdtlbd.createOrUpdate(printdtldto,user);
				} catch (ApplicationException ae) {
				}
			}

		}


		// print 
		if (saveForm.getBtnSubmit().equals("Print") || saveForm.getBtnSubmit().equals("Email")) {
			// 
			// step 1: convert report to PDF format		
			_Document = new Document();	
			// init pagesize default for user			
			_Document.setPageSize(PageSize.A4);			
			_Document.setPageCount(1);

			// step 2: set the ContentType and create an instance of the corresponding Writer				
			response.setContentType("application/pdf");
			PdfWriter _PdfWriter = PdfWriter.getInstance(_Document, response.getOutputStream());

			// email
			if (saveForm.getBtnSubmit().equals("Email")) {
				_fileOutputStream = new FileOutputStream(user.getUserid()+"toEmail.pdf");
				_PdfWriter = PdfWriter.getInstance(_Document, _fileOutputStream);  
			}
			_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 120f, 50f); 
			_Document.open();				
			_PdfWriter.setPageEvent(new EndPageArrivalnotice(saveForm.getCompanyheader()));

			toPrint(saveForm, user);

			_Document.add(_Table1);

			// step 3: close the document (the outputstream is also closed internally)
			_Document.close(); 

			// email
			if (saveForm.getBtnSubmit().equals("Email")) {    	    					
				toEmail(saveForm, user, session.getServletContext());
			}

			return null;  
		}




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}


	/**
	 */
	public void toEmail(PrinthdrForm saveForm, User user, ServletContext context) throws ServletException, IOException
	{

		try {

			// set email properties
			Properties props = new Properties();
			props.put("mail.host", user.getMailhost());			
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
			javax.mail.Message body = new MimeMessage(mailSession);

			javax.mail.Address _From = null;
			try {
				// FROM - default to user logon
				_From = new InternetAddress(saveForm.getMemo5());
				body.setFrom(_From);
			}	
			catch (AddressException ae) {}

			try {
				// BCC - default to user logon
				body.setRecipient(Message.RecipientType.BCC, _From);				
			}	
			catch (AddressException ae) {}


			javax.mail.Address _Recipient = null;
			// process GROUP emails
			String _emailTO = "";
			_emailTO = saveForm.getMemo8();	
			if ( _emailTO.indexOf(";") == 0 ) {
				try {
					_Recipient = new InternetAddress(saveForm.getMemo8());
					body.addRecipient(Message.RecipientType.TO, _Recipient);
				}
				catch (AddressException ae) {}
			}
			else {
				StringTokenizer _StringTokenizer = new StringTokenizer(_emailTO, ";");
				while (_StringTokenizer.hasMoreTokens()) {
					try {	
						_Recipient = new InternetAddress(_StringTokenizer.nextToken());
						body.addRecipient(Message.RecipientType.TO, _Recipient);
					}
					catch (AddressException ae) {}						
				}
			}

			_Recipient = null;

			// process GROUP emails 
			String _emailCC = "";
			_emailCC = saveForm.getMemo9();			   				
			if ( _emailCC.indexOf(";") == 0 ) {
				try {
					_Recipient = new InternetAddress(saveForm.getMemo9());
					body.addRecipient(Message.RecipientType.CC, _Recipient);
				}
				catch (AddressException ae) {}
			}
			else {
				StringTokenizer _StringTokenizer = null;
				_StringTokenizer = new StringTokenizer(_emailCC, ";");

				while (_StringTokenizer.hasMoreTokens()) {
					try {	
						_Recipient = new InternetAddress(_StringTokenizer.nextToken());
						body.addRecipient(Message.RecipientType.CC, _Recipient);
					}
					catch (AddressException ae) {}						
				}
			}



			body.setSubject(saveForm.getMemo3());


			File _file = new File(user.getUserid()+"toEmail.pdf");

			if (_file.exists())
			{
				Multipart multipart = new MimeMultipart();

				// Part one is the text
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setText("");
				multipart.addBodyPart(bodyPart);

				// Part two is the attachment
				bodyPart = new MimeBodyPart();
				DataSource sourceFile = new FileDataSource(user.getUserid()+"toEmail.pdf");
				bodyPart.setDataHandler(new DataHandler(sourceFile));
				bodyPart.setFileName(user.getUserid()+"toEmail.pdf");
				multipart.addBodyPart(bodyPart);

				body.setContent(multipart);
			}
			else {}


			Transport.send(body);

		}
		catch (javax.mail.SendFailedException sfe) {
			javax.mail.Address[] invalidAddresses = sfe.getInvalidAddresses();
			for (int i = 0; i < invalidAddresses.length; i++) {
			}
		}						
		catch (Exception e) {}		
		finally {
		}


	}  


	/**
	 */
	public void toPrint(PrinthdrForm saveForm, User user) throws ServletException, IOException
	{

		try {


			// create main table and add it to the document
			_Table1 = new PdfPTable(1);
			_Table1.getDefaultCell().setBorder(0);
			_Table1.getDefaultCell().setNoWrap(false);            		
			_Table1.setWidthPercentage(100f);  
			_Table1.getDefaultCell().setPadding(0);

			// working cell
			PdfPCell _PdfPCell;

			// define blank cell
			PdfPCell _BlankCell =  new PdfPCell(new Phrase("",font));
			_BlankCell.setColspan(2);
			_BlankCell.setFixedHeight(12f);
			_BlankCell.setBorder(0);

			// title label
			PdfPTable _Table1_1 = new PdfPTable(1);
			_Table1_1.getDefaultCell().setBorder(CELL_BORDER);    				     			
			_Table1_1.addCell(new Phrase("Arrival Notice",fontHeading));
			_Table1_1.addCell(new Phrase("Date: "+Util.dateTextFormat2(saveForm.getReportDate()),fontBold));
			_Table1_1.addCell(new Phrase(" ",font));

			_Table1.addCell(_Table1_1);

			// insert blank row
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);




			float[] widths1_6 = {0.3f, 0.7f};
			PdfPTable _Table1_6 = new PdfPTable(widths1_6);  		
			_Table1_6.getDefaultCell().setBorder(CELL_BORDER);

			try {

				_Table1_6.addCell(new Phrase(" ",fontBold));
				_Table1_6.addCell(new Phrase(" ",font));
				_Table1_6.addCell(new Phrase(" ",fontBold));
				_Table1_6.addCell(new Phrase(" ",font));

				_Table1_6.addCell(new Phrase("Our Reference:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getJobNumber(),font));

				_Table1_6.addCell(new Phrase(" ",fontBold));
				_Table1_6.addCell(new Phrase(" ",font));


				_Table1_6.addCell(new Phrase("Vessel:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getVessel(),font));
				_Table1_6.addCell(new Phrase("Shipping Line:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getShipLine(),font));

				_Table1_6.addCell(new Phrase(" ",fontBold));
				_Table1_6.addCell(new Phrase(" ",font));


				_Table1_6.addCell(new Phrase("Booking Number:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getBookingNumber(),font));

			} catch (Exception e) {

			}


			_Table1_6.addCell(new Phrase(" ",fontBold));
			_Table1_6.addCell(new Phrase(" ",font));


			try {

				_Table1_6.addCell(new Phrase("Port of Loading:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getPol(),font));
				_Table1_6.addCell(new Phrase("Estimate Loading Date:",fontBold));
				_Table1_6.addCell(new Phrase(Util.dateTextFormat2(saveForm.getPoldateest()),font));

				_Table1_6.addCell(new Phrase("Port of Discharge:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getPod(),font));
				_Table1_6.addCell(new Phrase("Estimate Discharge Date:",fontBold));
				_Table1_6.addCell(new Phrase(Util.dateTextFormat2(saveForm.getPoddateest()),font));

				_Table1_6.addCell(new Phrase("Final Delivery to:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getFinalDelivery(),font));
				_Table1_6.addCell(new Phrase("Estimate Delivery Date:",fontBold));
				_Table1_6.addCell(new Phrase(Util.dateTextFormat2(saveForm.getFinalDeliveryDateEst()),font));

				_Table1_6.addCell(new Phrase("Return Depot:",fontBold));
				_Table1_6.addCell(new Phrase(saveForm.getMemo10(),font));

			} catch (Exception e) {

			}

			_PdfPCell = new PdfPCell(_Table1_6);
			_PdfPCell.setBorder(CELL_BORDER); 	   	
			_Table1.addCell(_PdfPCell);


			// insert blank rows
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);


			// 
			float[] widths1_8 = {0.3f, 0.7f};
			PdfPTable _Table1_8 = new PdfPTable(widths1_8); 
			_Table1_8.getDefaultCell().setBorder(CELL_BORDER);	
			try {
				_Table1_8.addCell(new Phrase("Weight:",fontBold));
				_Table1_8.addCell(new Phrase(saveForm.getWeightPerTankAprox()+" "+saveForm.getWeightType(),font));
				_Table1_8.addCell(new Phrase("Demurrage Free Days:",fontBold));
				_Table1_8.addCell(new Phrase(saveForm.getMemo4(),font));
				_Table1_8.addCell(new Phrase("Demurrage Days and Rates ("+saveForm.getMemo1()+"):",fontBold));
				_Table1_8.addCell(new Phrase(saveForm.getMemo5(),font));	
			} catch (Exception e){}
			_Table1.addCell(_Table1_8);


			// insert blank rows
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);


			// references label
			float[] widths1_9 = {0.3f, 0.7f};
			PdfPTable _Table1_9 = new PdfPTable(widths1_9); 
			_Table1_9.getDefaultCell().setBorder(CELL_BORDER);	
			try {
				_Table1_9.addCell(new Phrase("Shipper:",fontBold));
				_Table1_9.addCell(new Phrase(saveForm.getShipper(),font));
				_Table1_9.addCell(new Phrase("Consignee:",fontBold));
				_Table1_9.addCell(new Phrase(saveForm.getConsignee(),font));		
				_Table1_9.addCell(new Phrase("Address:",fontBold));
				_Table1_9.addCell(new Phrase(saveForm.getConsigneeAddress1(),font));
				_Table1_9.addCell(new Phrase("",fontBold));
				_Table1_9.addCell(new Phrase(saveForm.getConsigneeAddress2(),font));
				_Table1_9.addCell(new Phrase("",fontBold));
				_Table1_9.addCell(new Phrase(saveForm.getConsigneeAddress3(),font));		
			} catch (Exception e){}
			_Table1.addCell(_Table1_9);


			// insert blank rows
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);



			// details header
			float[] widths1_2 = {0.2f, 0.2f, 0.1f, 0.5f};
			PdfPTable _Table1_2 = new PdfPTable(widths1_2); 

			_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
			_Table1_2.addCell(new Phrase("Tank Number",fontSmallBold));
			_Table1_2.addCell(new Phrase("Contents",fontSmallBold));
			_Table1_2.addCell(new Phrase("Actual Weight",fontSmallBold));
			_Table1_2.addCell(new Phrase("Additional Instructions",fontSmallBold));

			PdfPCell cell = new PdfPCell(_Table1_2);
			cell.setBorderWidthLeft(0.1f);
			cell.setBorderWidthBottom(0.1f);
			cell.setBorderWidthRight(0.1f);
			cell.setBorderWidthTop(0.1f);
			cell.setBorderColorLeft(BaseColor.WHITE);
			cell.setBorderColorBottom(BaseColor.BLACK);
			cell.setBorderColorRight(BaseColor.WHITE);
			cell.setBorderColorTop(BaseColor.BLACK);
			_Table1.addCell(cell);
			
			
			_Table1.addCell(_PdfPCell);




			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(white);
			_PdfPCell.setFixedHeight(1);
			_Table1.addCell(_PdfPCell);

			int row = 0;
			for (Iterator it = saveForm.getPrintdtls().iterator(); it.hasNext();) {
				PrintdtlForm printdtlForm = (PrintdtlForm)it.next();

				try {
					// details header
					float[] widths1_4 = {0.2f, 0.2f, 0.1f, 0.5f};
					PdfPTable _Table1_4 = new PdfPTable(widths1_4);
					_Table1_4.getDefaultCell().setBorder(CELL_BORDER); 

					_Table1_4.addCell(new Phrase(printdtlForm.getTankNumber(),fontSmall));
					_Table1_4.addCell(new Phrase(printdtlForm.getProductId(),fontSmall));
					_Table1_4.addCell(new Phrase(printdtlForm.getActualWeight()+" "+printdtlForm.getWeightType(),fontSmall));
					_Table1_4.addCell(new Phrase(printdtlForm.getMemoA(),fontSmall));			
					_Table1_4.addCell(new Phrase("",fontSmall));
					_Table1_4.addCell(new Phrase("",fontSmall));
					_Table1_4.addCell(new Phrase("",fontSmall));
					_Table1_4.addCell(new Phrase(printdtlForm.getMemoB(),fontSmall));

					_PdfPCell = new PdfPCell(_Table1_4);
					_PdfPCell.setBorder(CELL_BORDER); 
					_PdfPCell.setBackgroundColor(lghtgry);
					if ((row % 2) == 0) _PdfPCell.setBackgroundColor(lghtgry2);			
					_Table1.addCell(_PdfPCell);

					_PdfPCell = new PdfPCell();
					_PdfPCell.setBorder(CELL_BORDER);
					_PdfPCell.setBackgroundColor(white);
					_PdfPCell.setFixedHeight(1);
					_Table1.addCell(_PdfPCell);

				} catch (Exception e) {

				}

				row++;
			}


			// insert blank rows
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);


			// 
			PdfPTable _Table1_7 = new PdfPTable(1); 
			_Table1_7.getDefaultCell().setBorder(CELL_BORDER);	
			try {
				_Table1_7.addCell(new Phrase("PLEASE NOTE:",fontBold));
				_Table1_7.addCell(new Phrase(saveForm.getMemo2(),font));			
			} catch (Exception e){}
			_Table1.addCell(_Table1_7);


			// insert blank rows
			_BlankCell.setColspan(1);
			_Table1.addCell(_BlankCell);
			_Table1.addCell(_BlankCell);

		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+" toPrint: Exception: "+e.getMessage());
		}

	}



}
