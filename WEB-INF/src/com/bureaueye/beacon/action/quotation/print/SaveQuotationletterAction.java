package com.bureaueye.beacon.action.quotation.print;


import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.print.PrinthdrForm;
import com.bureaueye.beacon.model.print.Printhdr;
import com.bureaueye.beacon.model.print.bd.PrinthdrBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.util.Util;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
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
 * NT	2009-10-26		ITT-200910-0002		Quotation Letter
 * 
 * NT	2010-01-15		201000002			Problem printing € character in pdf format. Output Currency names instead.
 *												
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 */
public class SaveQuotationletterAction extends BaseAction {


	private Document _Document;
	private FileOutputStream _fileOutputStream;
	private PdfPTable _Table1;

	private int CELL_BORDER = 0;



	Font font;
	Font fontBold;	
	Font fontLargeBold;
	Font fontSmall;
	Font fontSmallBold;	
	Font fontHeading;
	Font fontBoldUnderline;

	private static BaseColor headingColor = new BaseColor(180, 43, 22);
	private static BaseColor black= new BaseColor(0, 0, 0);


	public SaveQuotationletterAction() {
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontLargeBold = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
			fontHeading = new Font(font.getFamily(), font.getSize()+4, fontBold.getStyle());
			fontHeading.setColor(headingColor);
			fontBoldUnderline = new Font(font.getFamily(), font.getSize(), Font.BOLD);
			fontBoldUnderline.setStyle(Font.UNDERLINE);
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
			// init FORM with DaO values
			BeanUtils.copyProperties(dao, saveForm);
		} catch (IllegalAccessException ite) {	
		} catch (InvocationTargetException ite) {
		} catch (Exception e) {
		}



		try {
			// update header
			bd.createOrUpdate(dao, user);
		} catch (ApplicationException ae) {
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
			_Document.setMargins(_Document.leftMargin(), _Document.rightMargin(), 50f, 50f); 
			_Document.open();				

			if (saveForm.getLanguage().equals("ENGLISH")) {
				doPrintEnglish(saveForm, user);
			}
			if (saveForm.getLanguage().equals("SPANISH")) {
				doPrintSpanish(saveForm, user);
			}

			_Document.add(_Table1);

			// step 3: close the document (the outputstream is also closed internally)
			_Document.close(); 

			// email
			if (saveForm.getBtnSubmit().equals("Email")) {    	    
				Util.servletLog(session.getServletContext(),this.getClass().getName(),"run","before toEmail");					
				doEmail(saveForm, user, session.getServletContext());
				Util.servletLog(session.getServletContext(),this.getClass().getName(),"run","after toEmail");					
			}

			return null;  
		}




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}


	/**
	 */
	public void doEmail(PrinthdrForm saveForm, User user, ServletContext context) throws ServletException, IOException
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
				_From = new InternetAddress(saveForm.getFromcontact());
				body.setFrom(_From);
			}	
			catch (AddressException ae) {}
			Util.servletLog(context,this.getClass().getName(),"toEmail","_From - "+_From);					

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
			Util.servletLog(context,this.getClass().getName(),"toEmail","TO _Recipients - "+saveForm.getMemo8());				

			_Recipient = null;

			/*			// process GROUP emails 
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
			Util.servletLog(context,this.getClass().getName(),"toEmail","CC _Recipients - "+saveForm.getMemo9());*/				



			body.setSubject("Quotation# "+saveForm.getMemo4());


			File _file = new File(user.getUserid()+"toEmail.pdf");
			Util.servletLog(context,this.getClass().getName(),"toEmail","_file - "+_file.getAbsolutePath());				

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
	public void doPrintEnglish(PrinthdrForm saveForm, User user) throws ServletException, IOException
	{


		// create main table and add it to the document
		_Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);

		// working cell
		PdfPCell _PdfPCell;

		// define blank cell
		PdfPCell _BlankCell =  new PdfPCell(new Phrase(" ",font));
		_BlankCell.setColspan(2);
		_BlankCell.setFixedHeight(12f);
		_BlankCell.setBorder(0);




		// create main table and add it to the document
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);




		Image jpeg;

		// header
		PdfPTable _Table1_1 = new PdfPTable(1);
		_Table1_1.getDefaultCell().setBorder(CELL_BORDER);    		

		if (saveForm.getCompanyheader() != null) {
			try {
				jpeg = Image.getInstance(saveForm.getCompanyheader().getLogo());			
				_PdfPCell = new PdfPCell(jpeg);
				_PdfPCell.setBorder(CELL_BORDER); 
				_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				_Table1_1.addCell(_PdfPCell);
			} catch (Exception e) {
			}

			// insert blank row
			_BlankCell.setColspan(1);
			_Table1_1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1_1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(1);
			_Table1_1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(new Phrase(saveForm.getCompanyheader().getAddress()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 			
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);     			
			_Table1_1.addCell(_PdfPCell);		
			_PdfPCell = new PdfPCell(new Phrase(saveForm.getCompanyheader().getCity()+" "+saveForm.getCompanyheader().getState()+" "+saveForm.getCompanyheader().getPostalCode()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 			
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);     			
			_Table1_1.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("Phone# "+saveForm.getCompanyheader().getPhone()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_1.addCell(_PdfPCell); 
		}


		_PdfPCell = new PdfPCell(_Table1_1);
		//_PdfPCell.setFixedHeight(100f);
		_PdfPCell.setBorder(CELL_BORDER);			
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell); 



		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);



		// details header
		float[] widths1_2 =  {0.15f, 0.85f};
		PdfPTable _Table1_2 = new PdfPTable(widths1_2); 

		_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
		_Table1_2.addCell(new Phrase("Date:",fontBold));
		_Table1_2.addCell(new Phrase(Util.dateTextFormat2(saveForm.getReportDate()),fontBold));
		_Table1_2.addCell(new Phrase("To:",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getCustomer(),fontBold));
		_Table1_2.addCell(new Phrase("Attention:",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getMemo8(),fontBold));
		_Table1_2.addCell(new Phrase("Total Pages:",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getMemo10(),fontBold));
		_Table1_2.addCell(new Phrase("From:",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getFromcontact(),fontBold));

		// insert blank row
		_BlankCell.setColspan(2);
		_Table1_2.addCell(_BlankCell);

		_Table1_2.addCell(new Phrase("Subject: ",fontLargeBold));
		_Table1_2.addCell(new Phrase("Quotation# "+saveForm.getMemo4(),fontLargeBold));

		_PdfPCell = new PdfPCell(_Table1_2);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		_PdfPCell = new PdfPCell();
		_PdfPCell.setBorder(CELL_BORDER);
		_PdfPCell.setBackgroundColor(black);
		_PdfPCell.setFixedHeight(1);
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);


		// paragraph1
		PdfPTable _Table1_3 = new PdfPTable(1); 

		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);
		_Table1_3.addCell(
				new Phrase("We refer to your recent enquiry and take pleasure in confirming our rate as follows:",fontBold)
		);

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// rate details
		float[] widths1_6 = {0.33f, 0.33f, 0.33f}; 			
		PdfPTable _Table1_6 = new PdfPTable(widths1_6);			
		_Table1_6.getDefaultCell().setBorder(0);			

		PdfPTable _Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("From Door:",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPickupPlant(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);	
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);					

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("To Door:",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getFinalDelivery(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);	
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("Rate:",fontBold));			
		try {
			_Table1_6_1_1.addCell(
					//new Phrase(saveForm.getRateccy()+""+saveForm.getRate(),font) //201000002
					new Phrase(saveForm.getRate()+" "+saveForm.getRateccy(),font) //201000002
			);
		} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);
		_Table1_6_1_1.addCell(new Phrase("Origin Port:",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPol(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);							

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("Destination Port:",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPod(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);				

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);			

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);

		_PdfPCell = new PdfPCell(_Table1_6);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);		
		/*		_Table1.addCell(_BlankCell);*/


		// product/equipment
		float[] widths1_4 = {0.15f, 0.85f};
		PdfPTable _Table1_4 = new PdfPTable(widths1_4); 		
		_Table1_4.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_4.addCell(new Phrase("Product:",fontBold));
		_Table1_4.addCell(new Phrase(saveForm.getMemo1(),font));
		_Table1_4.addCell(new Phrase("Equipment:",fontBold));
		_Table1_4.addCell(new Phrase(saveForm.getMemo2(),font));

		_PdfPCell = new PdfPCell(_Table1_4);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);



		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph2
		_Table1_3 = new PdfPTable(1); 

		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);
		Phrase p1 = new Phrase();
		Chunk c1 = new Chunk("Demurrage will be billed at ", font);
		Chunk c2 = new Chunk(saveForm.getMemo5(), fontBoldUnderline);//201000002
		//Chunk c3 = new Chunk(" "+saveForm.getRateccy(), fontBoldUnderline);//201000002//ITT-201001-0001
		Chunk c3 = new Chunk(" "+saveForm.getDmrgccykey(), fontBoldUnderline);//ITT-2010-0001
		Chunk c4 = new Chunk(" per tank per day after ", font);
		Chunk c5 = new Chunk(saveForm.getMemo3(), fontBoldUnderline);
		Chunk c6 = new Chunk(" days from vessel arrival at pier.", font);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(c4);
		p1.add(c5);
		p1.add(c6);
		_Table1_3.addCell(p1);
		_Table1_3.addCell(
				new Phrase("Demurrage will be for your account, or to another party nominated by yourselves prior to",font)
		);
		_Table1_3.addCell(
				new Phrase("commencement of business.",font)
		);

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph3
		_Table1_3 = new PdfPTable(1); 		
		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_3.addCell(new Phrase("Rate excludes:",fontBoldUnderline));
		_Table1_3.addCell(new Phrase("·	Heating of product during transit or prior to delivery",font));
		_Table1_3.addCell(new Phrase("·	Customs clearance at origin & destination, and product duties in country of destination",font));
		_Table1_3.addCell(new Phrase("·	Extra cleaning and any disposal costs for residue over 5 gallons remaining in tank container after discharge",font));
		_Table1_3.addCell(new Phrase("·	Pier storages or rail terminal charges in the event of postponed delivery",font));
		_Table1_3.addCell(new Phrase("·	Marine Insurance",font));
		_Table1_3.addCell(new Phrase("·	War risk/Port Congestion /Peak Season fees",font));
		_Table1_3.addCell(new Phrase("·	Any labels/preps or specialty equipment unless specifically requested",font));
		_Table1_3.addCell(new Phrase("·	Handrail fitted on tank",font));
		_Table1_3.addCell(new Phrase("",font));

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		



		// paragraph4
		_Table1_3 = new PdfPTable(1); 
		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_3.addCell(new Phrase("Rate includes:",fontBoldUnderline));
		_Table1_3.addCell(new Phrase("·	Current BAF/CAF/THC at origin",font));
		_Table1_3.addCell(new Phrase("·	Inland haulage from loading point to pier (if Door to Door or Door to Pier move)",font));
		_Table1_3.addCell(new Phrase("·	Inland haulage from pier to discharging point (if Door to Door or Pier to Door )",font));
		_Table1_3.addCell(new Phrase("",font));
		_Table1_3.addCell(new Phrase("Rate subject to the following unless otherwise specified in notes section:",font));
		_Table1_3.addCell(new Phrase("·	Accessorial Charges (FMC Tariff rate will apply for shipments to and from the U.S.)",font));
		_Table1_3.addCell(new Phrase("·	Prior day pick up, next day delivery charge, and trucking detention if applicable ",font)); 
		_Table1_3.addCell(new Phrase("·	Special preparation of tanks if required by loading plant",font));
		_Table1_3.addCell(new Phrase("·	Overweight charge if applicable",font));
		_Table1_3.addCell(new Phrase("·	DTHC and any other port charge at destination",font));

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// notes
		PdfPTable _Table1_5 = new PdfPTable(1); 		
		_Table1_5.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_5.addCell(new Phrase("Notes:",fontBoldUnderline));
		_Table1_5.addCell(new Phrase(saveForm.getMemo7(),font));

		_PdfPCell = new PdfPCell(_Table1_5);
		_PdfPCell.setBorder(CELL_BORDER);
		_PdfPCell.setFixedHeight(150f);
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph5
		PdfPTable _Table1_7 = new PdfPTable(1); 
		_Table1_7.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_7.addCell(new Phrase("Terms: "+saveForm.getShipMethod(),fontBoldUnderline));
		_Table1_7.addCell(new Phrase("·	Any damages to equipment under shipper’s, consignee’s, or any of their subcontractor's custody will be",font));
		_Table1_7.addCell(new Phrase("  for your account.",font));
		_Table1_7.addCell(new Phrase("·	Payment of any extra charges incurred in the destination country will be guaranteed by the shipper of record.",font));

		_PdfPCell = new PdfPCell(_Table1_7);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph5
		PdfPTable _Table1_8 = new PdfPTable(1); 
		_Table1_8.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_8.addCell(new Phrase("The quote is subject to tank availability at time of order placement.",font));
		Phrase p2 = new Phrase();
		Chunk c7 = new Chunk("Validity:", fontBoldUnderline);
		Chunk c8 = new Chunk(" Our quotation is based on current costs and rates of exchange. ", font);
		p2.add(c7);
		p2.add(c8);
		_Table1_8.addCell(p2);

		Phrase p3 = new Phrase();
		Chunk c9 = new Chunk("Rate is valid from ", font);
		Chunk c10 = new Chunk(saveForm.getMemo6(), fontBoldUnderline);
		Chunk c11 = new Chunk(" to ", fontBoldUnderline);
		Chunk c12 = new Chunk(saveForm.getMemo9(), fontBoldUnderline);
		Chunk c13 = new Chunk(".", font);
		p3.add(c9);
		p3.add(c10);
		p3.add(c11);
		p3.add(c12);
		p3.add(c13);
		_Table1_8.addCell(p3);

		_PdfPCell = new PdfPCell(_Table1_8);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);


		// paragraph6
		PdfPTable _Table1_9 = new PdfPTable(1); 
		_Table1_9.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_9.addCell(new Phrase("Rate (s) is (are) subject to change with 30 days prior notice to customer.",font));
		_Table1_9.addCell(new Phrase("All invoices are due settlement in full, 30 days from date of invoice.",font));
		_Table1_9.addCell(new Phrase("All business is undertaken subject to the "+saveForm.getCompanyheader().getCompanyName()+" Bill of Lading conditions.",font));
		_Table1_9.addCell(new Phrase(" ",font));
		_Table1_9.addCell(new Phrase("Commercial Invoices: "+saveForm.getCompanyheader().getCompanyName()+" is not party to and does not accept any liability",font));
		_Table1_9.addCell(new Phrase("due to disputes between Shipper & Consignee based on Commercial Invoice terms.",font));

		_PdfPCell = new PdfPCell(_Table1_9);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph7
		PdfPTable _Table1_10 = new PdfPTable(1); 
		_Table1_10.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_10.addCell(new Phrase("Kindest regards, ",font));
		_Table1_10.addCell(new Phrase(" ",font));		
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(saveForm.getCompanyheader().getCompanyName(),fontBold));	

		_PdfPCell = new PdfPCell(_Table1_10);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	



	}



	/**
	 */
	public void doPrintSpanish(PrinthdrForm saveForm, User user) throws ServletException, IOException
	{


		// create main table and add it to the document
		_Table1 = new PdfPTable(1);
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);

		// working cell
		PdfPCell _PdfPCell;

		// define blank cell
		PdfPCell _BlankCell =  new PdfPCell(new Phrase(" ",font));
		_BlankCell.setColspan(2);
		_BlankCell.setFixedHeight(12f);
		_BlankCell.setBorder(0);




		// create main table and add it to the document
		_Table1.getDefaultCell().setBorder(0);
		_Table1.getDefaultCell().setNoWrap(false);            		
		_Table1.setWidthPercentage(100f);  
		_Table1.getDefaultCell().setPadding(0);




		Image jpeg;

		// header
		PdfPTable _Table1_1 = new PdfPTable(1);
		_Table1_1.getDefaultCell().setBorder(CELL_BORDER);    		

		if (saveForm.getCompanyheader() != null) {
			try {
				jpeg = Image.getInstance(saveForm.getCompanyheader().getLogo());			
				_PdfPCell = new PdfPCell(jpeg);
				_PdfPCell.setBorder(CELL_BORDER); 
				_PdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				_Table1_1.addCell(_PdfPCell);
			} catch (Exception e) {
			}

			// insert blank row
			_BlankCell.setColspan(1);
			_Table1_1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell();
			_PdfPCell.setBorder(CELL_BORDER);
			_PdfPCell.setBackgroundColor(black);
			_PdfPCell.setFixedHeight(1);
			_Table1_1.addCell(_PdfPCell);

			// insert blank row
			_BlankCell.setColspan(1);
			_Table1_1.addCell(_BlankCell);

			_PdfPCell = new PdfPCell(new Phrase(saveForm.getCompanyheader().getAddress()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 			
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);     			
			_Table1_1.addCell(_PdfPCell);		
			_PdfPCell = new PdfPCell(new Phrase(saveForm.getCompanyheader().getCity()+" "+saveForm.getCompanyheader().getState()+" "+saveForm.getCompanyheader().getPostalCode()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 			
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);     			
			_Table1_1.addCell(_PdfPCell);
			_PdfPCell = new PdfPCell(new Phrase("Phone# "+saveForm.getCompanyheader().getPhone()+" ",fontSmallBold));
			_PdfPCell.setBorder(CELL_BORDER); 
			_PdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			_Table1_1.addCell(_PdfPCell); 
		}


		_PdfPCell = new PdfPCell(_Table1_1);
		//_PdfPCell.setFixedHeight(100f);
		_PdfPCell.setBorder(CELL_BORDER);			
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell); 



		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);



		// details header
		float[] widths1_2 =  {0.15f, 0.85f};
		PdfPTable _Table1_2 = new PdfPTable(widths1_2); 

		_Table1_2.getDefaultCell().setBorder(CELL_BORDER);
		_Table1_2.addCell(new Phrase("Fecha: ",fontBold));
		_Table1_2.addCell(new Phrase(Util.dateTextFormat2(saveForm.getReportDate()),fontBold));
		_Table1_2.addCell(new Phrase("A: ",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getCustomer(),fontBold));
		_Table1_2.addCell(new Phrase("Atención:   ",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getMemo8(),fontBold));
		_Table1_2.addCell(new Phrase("Total Páginas: ",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getMemo10(),fontBold));
		_Table1_2.addCell(new Phrase("De: ",fontBold));
		_Table1_2.addCell(new Phrase(saveForm.getFromcontact(),fontBold));

		// insert blank row
		_BlankCell.setColspan(2);
		_Table1_2.addCell(_BlankCell);

		_Table1_2.addCell(new Phrase("Asunto:  ",fontLargeBold));
		_Table1_2.addCell(new Phrase("Oferta# "+saveForm.getMemo4(),fontLargeBold));

		_PdfPCell = new PdfPCell(_Table1_2);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		_PdfPCell = new PdfPCell();
		_PdfPCell.setBorder(CELL_BORDER);
		_PdfPCell.setBackgroundColor(black);
		_PdfPCell.setFixedHeight(1);
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);


		// paragraph1
		PdfPTable _Table1_3 = new PdfPTable(1); 

		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);
		_Table1_3.addCell(
				new Phrase("En referencia a su reciente petición , nos complace confirmarles  los precios a continuación detallados: ",fontBold)
		);

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// rate details
		float[] widths1_6 = {0.33f, 0.33f, 0.33f}; 			
		PdfPTable _Table1_6 = new PdfPTable(widths1_6);			
		_Table1_6.getDefaultCell().setBorder(0);			

		PdfPTable _Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("Desde Door: ",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPickupPlant(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);	
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);					

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("A Door : ",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getFinalDelivery(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);	
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("Precio : ",fontBold));			
		try {
			_Table1_6_1_1.addCell(
					//new Phrase(saveForm.getRateccy()+""+saveForm.getRate(),font) //201000002
					new Phrase(saveForm.getRate()+" "+saveForm.getRateccy(),font)//201000002
			);
		} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);
		_Table1_6_1_1.addCell(new Phrase("Puerto de Origen: ",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPol(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);							

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase("Puerto de Destino: ",fontBold));			
		try {_Table1_6_1_1.addCell(new Phrase(saveForm.getPod(),font));} 
		catch (Exception e) {_Table1_6_1_1.addCell(new Phrase("",font));}						
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);				

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);		

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);			

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);

		_Table1_6_1_1 = new PdfPTable(1);			
		_Table1_6_1_1.getDefaultCell().setBorder(0);		
		_Table1_6_1_1.addCell(new Phrase(" ",fontBold));							
		_PdfPCell = new PdfPCell(_Table1_6_1_1);
		_PdfPCell.setBorder(1);
		_PdfPCell.setPadding(2f);
		_PdfPCell.setBackgroundColor(new BaseColor(Color.WHITE));
		_Table1_6.addCell(_PdfPCell);

		_PdfPCell = new PdfPCell(_Table1_6);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);		
		/*		_Table1.addCell(_BlankCell);*/


		// product/equipment
		float[] widths1_4 = {0.15f, 0.85f};
		PdfPTable _Table1_4 = new PdfPTable(widths1_4); 		
		_Table1_4.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_4.addCell(new Phrase("Producto:",fontBold));
		_Table1_4.addCell(new Phrase(saveForm.getMemo1(),font));
		_Table1_4.addCell(new Phrase("Equipo:",fontBold));
		_Table1_4.addCell(new Phrase(saveForm.getMemo2(),font));

		_PdfPCell = new PdfPCell(_Table1_4);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);



		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph2
		_Table1_3 = new PdfPTable(1); 
		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

		Phrase p1 = new Phrase();
		Chunk c1 = new Chunk("Las Demoras serán facturadas a ", font);
		Chunk c2 = new Chunk(saveForm.getMemo5(), fontBoldUnderline);//201000002
		//Chunk c3 = new Chunk(" "+saveForm.getRateccy(), fontBoldUnderline);//201000002 //ITT-2010-0001	 
		Chunk c3 = new Chunk(" "+saveForm.getDmrgccykey(), fontBoldUnderline);//ITT-2010-0001
		Chunk c4 = new Chunk(" por tanque por día después de ", font);
		Chunk c5 = new Chunk(saveForm.getMemo3(), fontBoldUnderline);
		Chunk c6 = new Chunk(" días desde la llegada del barco", font);//201000002
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(c4);
		p1.add(c5);
		p1.add(c6);
		_Table1_3.addCell(p1);
		_Table1_3.addCell(new Phrase("a muelle.",font));//201000002
		_Table1_3.addCell(
				new Phrase("Las demoras son por cuenta del cliente, o de una tercera parte nominada por el cliente al inicio de",font)
		);
		_Table1_3.addCell(
				new Phrase("los embarques.",font)
		);

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph3
		_Table1_3 = new PdfPTable(1); 		
		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_3.addCell(new Phrase("El precio excluye:",fontBoldUnderline));
		_Table1_3.addCell(new Phrase("·	Calentamiento del producto en tránsito o antes de la entrega",font));
		_Table1_3.addCell(new Phrase("·	Despacho de aduanas en orígen y destino ,y derechos arancelarios o impuestos en destino",font));
		_Table1_3.addCell(new Phrase("·	Costes por Lavado Adicional y destrucción de resíduos por cantidades mayors de 20 Litros que puedan permanecer",font));
		_Table1_3.addCell(new Phrase("  en el interior del tank",font));
		_Table1_3.addCell(new Phrase("·	Almacenajes en muelle o terminal ferroviaria por entrega aplazada.",font));
		_Table1_3.addCell(new Phrase("·	Seguro de Transporte de la mercancía",font));
		_Table1_3.addCell(new Phrase("·	Recargos por : Riesgo de Guerra/ Congestión portuaria/Peak Season",font));
		_Table1_3.addCell(new Phrase("·	Etiquetas/preparaciones especiales, equipo especial a menos que haya sido específicamente solicitado.",font));
		_Table1_3.addCell(new Phrase("·	Pasarela superior (Handrail) a menos que haya sido específicamente solicitado",font));
		_Table1_3.addCell(new Phrase("",font));

		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		



		// paragraph4
		_Table1_3 = new PdfPTable(1); 
		_Table1_3.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_3.addCell(new Phrase("El precio incluye:",fontBoldUnderline));
		_Table1_3.addCell(new Phrase("·	BAF/CAF/THC vigentes  en el Puerto de orígen",font));
		_Table1_3.addCell(new Phrase("·	Trasnporte terrestre desde el punto de carga a muelle (para cotizaciones Door to Door o Door to Pier)",font));
		_Table1_3.addCell(new Phrase("·	Transporte Terrestre desde Muelle a punto de entrega ( para cotizaciones Door to Door o Pier to Door",font));
		_Table1_3.addCell(new Phrase("",font));
		_Table1_3.addCell(new Phrase("Precio sujeto a los siguientes costes , excepto que se indique el apartado de notas: ",font));
		_Table1_3.addCell(new Phrase("·	Accessorial Charges (La Tarifa FMC se aplicará para embarques a/desde USA)",font));
		_Table1_3.addCell(new Phrase("·	Suplementos por Recogida el día anterior , o Entrega al día siguiente, y paralizaciones de camión y plataforma",font)); 
		_Table1_3.addCell(new Phrase("  cuando sean de aplicación  ",font)); 
		_Table1_3.addCell(new Phrase("·	Preparaciones especiales a solicitud de la planta de carga",font));
		_Table1_3.addCell(new Phrase("·	Recargo por extra-peso cuando sea de aplicación",font));
		_Table1_3.addCell(new Phrase("·	Manipulación portuaria en destino (DTHC) y cualquier otro gasto portuario en destino , a no ser que se haya ",font));
		_Table1_3.addCell(new Phrase("  solicitado incluirlo en el precio. ",font));
		_PdfPCell = new PdfPCell(_Table1_3);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);		


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// notes
		PdfPTable _Table1_5 = new PdfPTable(1); 		
		_Table1_5.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_5.addCell(new Phrase("Notas:",fontBoldUnderline));
		_Table1_5.addCell(new Phrase(saveForm.getMemo7(),font));

		_PdfPCell = new PdfPCell(_Table1_5);
		_PdfPCell.setBorder(CELL_BORDER);
		_PdfPCell.setFixedHeight(150f);
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph5
		PdfPTable _Table1_7 = new PdfPTable(1); 
		_Table1_7.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_7.addCell(new Phrase("Términos : "+saveForm.getShipMethod(),fontBoldUnderline));
		_Table1_7.addCell(new Phrase("·	Cualquier daño causado al equipo mientras esté bajo control del embarcador, receptor, o cualquiera de sus ",font));
		_Table1_7.addCell(new Phrase("  subcontratados, será por cuenta del cliente.",font));
		_Table1_7.addCell(new Phrase("·	El pago de cualquier coste adicional incurrido en destino imputable al receptor será garantizado por el embarcador o",font));
		_Table1_7.addCell(new Phrase("  contratante del servicio.",font));

		_PdfPCell = new PdfPCell(_Table1_7);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph5
		PdfPTable _Table1_8 = new PdfPTable(1); 
		_Table1_8.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_8.addCell(new Phrase("La oferta está sujeta a la disponibilidad de tanks en el momento de efectuar la reserva.",font));

		Phrase p2 = new Phrase();
		Chunk c7 = new Chunk("Validez:", fontBoldUnderline);
		Chunk c8 = new Chunk(" La oferta está basada en los costes y tipos de cambio vigentes en el momento de su emisión.", font);
		p2.add(c7);
		p2.add(c8);
		_Table1_8.addCell(p2);

		Phrase p3 = new Phrase();
		Chunk c9 = new Chunk("El precio es válido desde ", font);
		Chunk c10 = new Chunk(saveForm.getMemo6(), fontBoldUnderline);
		Chunk c11 = new Chunk(" to ", fontBoldUnderline);
		Chunk c12 = new Chunk(saveForm.getMemo9(), fontBoldUnderline);
		Chunk c13 = new Chunk(" desde la fecha de cotización y está sujeta a revisión partir", font);
		p3.add(c9);
		p3.add(c10);
		p3.add(c11);
		p3.add(c12);
		p3.add(c13);
		_Table1_8.addCell(p3);		
		_Table1_8.addCell(new Phrase("de dicha fecha.",font));

		_PdfPCell = new PdfPCell(_Table1_8);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);


		// paragraph6
		PdfPTable _Table1_9 = new PdfPTable(1); 
		_Table1_9.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_9.addCell(new Phrase("Los precios están sujetos a modificaciones durante la vigencia de la ofertacon con un pre-aviso de 30 días al cliente.",font));
		_Table1_9.addCell(new Phrase("Todas las facturas son pagaderas en su totalidad, a los 30 días de la fecha de emisión, salvo acuerdo distinto .",font));
		_Table1_9.addCell(new Phrase("Todos los embarques están sujetos  a ls cláusulas contenidas en los Bill Lading de",font));
		_Table1_9.addCell(new Phrase(saveForm.getCompanyheader().getCompanyName()+".",font));		
		_Table1_9.addCell(new Phrase(" ",font));
		_Table1_9.addCell(new Phrase("Facturas Comerciales : "+saveForm.getCompanyheader().getCompanyName()+" no son parte ni aceptan ninguna responsabilidad ",font));
		_Table1_9.addCell(new Phrase("en disputas entre Embarcador y Consignado por los términos de la factura comercial .",font));

		_PdfPCell = new PdfPCell(_Table1_9);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);


		// insert blank row
		_BlankCell.setColspan(1);
		_Table1.addCell(_BlankCell);
		_Table1.addCell(_BlankCell);


		// paragraph7
		PdfPTable _Table1_10 = new PdfPTable(1); 
		_Table1_10.getDefaultCell().setBorder(CELL_BORDER);

		_Table1_10.addCell(new Phrase("Saludos Cordiales, ",font));
		_Table1_10.addCell(new Phrase(" ",font));		
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(" ",font));
		_Table1_10.addCell(new Phrase(saveForm.getCompanyheader().getCompanyName(),fontBold));	

		_PdfPCell = new PdfPCell(_Table1_10);
		_PdfPCell.setBorder(CELL_BORDER); 	   	
		_Table1.addCell(_PdfPCell);	



	}




}
