package com.bureaueye.beacon.action.system;



import java.io.File;


import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.alert.Alert;
import com.bureaueye.beacon.model.alert.bd.AlertBD;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.task.bd.TaskBD;









/**
 *
 * Amendments
 * ----------
 * 	
 */
public final class BatchAlertAgent implements Runnable 
{

	protected Map<String, SessionFactory> sessionFactoryClusterMap;	
	public BatchAlertAgent(Map<String, SessionFactory> sessionFactoryClusterMap) {
		this.sessionFactoryClusterMap=sessionFactoryClusterMap;
	}


	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	/**
	 */
	//maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;







	com.itextpdf.text.Document pdfDocument;	
	org.w3c.dom.Document domDocument; 
	org.w3c.dom.Element elementDocument; 


	SystemcodeBD systemcodebd;
	SystemXBD systemxbd;
	AlertBD alertbd;
	TaskBD taskbd;


	public void run() 
	{ 		

		//setName(this.getClass().getName());
		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("["+this.getClass().getName()+"] Run at: "+cal.getTime());	


		// set user
		User user = new User();





		//init BD
		systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);
		systemxbd = new SystemXBD(sessionFactoryClusterMap);
		alertbd = new AlertBD(sessionFactoryClusterMap);
		taskbd = new TaskBD(sessionFactoryClusterMap);

	


		try {

			//read alerts
			//process alerts which have not expired
			ListForm listForm = new ListForm();
			listForm.setSearchString1("JOBMOV");
			listForm.setSearchString2("DATE");
			listForm.setSearchString3("Y");
			listForm.setSearchDate1(new Date());
			List alerts = alertbd.findAlertsByModuleTypeAlertflagValidto(listForm);
			


				log.info(
						"["+this.getClass().getName()+"] "+new java.util.Date()+
						"  alerts size: "+alerts.size()
				);

				// process list collection
				Iterator it = alerts.iterator();
				while (it.hasNext()) {
					
					Alert alert = (Alert) it.next();
			
					
					//check alerts
						
					
					
					//output mails
										
					
					//generate tasks
					
					
				}

			
			
			





		} catch(Exception e){
			log.error("["+this.getClass().getName()+"] "+new Date()+
					" Exception: "+e.getMessage());	
		}									



		// clean-up
		systemcodebd = null;
		systemxbd = null;
		alertbd=null;
		taskbd=null;
		

	}


	void println(String s) { System.out.println(s); }






	public static String getDoctype(String s) {
		String doctype="";
		try {     
			String[] array = s.split("\\|",-1);
			doctype=array[1];
		} catch (Exception e) {
			return "";
		}
		return doctype;
	}


	public static String getEdiid(String s) {
		String ediid="";
		try {     
			String[] array = s.split("\\|",-1);
			ediid=array[2];
		} catch (Exception e) {
			return "";
		}
		return ediid;
	}



	public void setStartprocesstime() {
		Calendar cal = Calendar.getInstance();	
		this._startprocesstime = cal;
	}
	public Calendar getStartprocesstime() {
		return this._startprocesstime;
	}





	public boolean isBlocked() {
		Calendar _currenttime = Calendar.getInstance();			
		Calendar _maxprocesstime = this._startprocesstime;
		_maxprocesstime.add(Calendar.MILLISECOND,MAX_PROCESS_TIME);

		log.info(
				"["+this.getClass().getName()+"] "+new Date()+
				" isblocked: "+_currenttime.after(_maxprocesstime)+
				" currenttime: "+_currenttime.getTime()+
				" maxprocesstime: "+_maxprocesstime.getTime()
		);

		if (_currenttime.after(_maxprocesstime)) return true;
		return false;
	}











	public void toMail(
			String mailattachment1
	) throws Exception
	{



		//system defaults
		String typekey="BEACONDMS";

		//init mail parameters
		String mailhost="";
		String mailto="";
		String mailfrom="";
		String mailcc="";
		String mailbcc="";
		String mailsubject="";
		String mailtext="";

		Systemcode systemcodedao = null;

		//mail process----------------------------------------------->

		try {

			//init MAILHOST
			try {
				String codekey="MAILHOST";
				systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
				mailhost=systemcodedao.getDescr();
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						"MAILHOST: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						"MAILHOST: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());
			}


			//mailto not found default to system mail address
			if (mailto.equals("") || mailto==null) {
				try {
					String codekey="MAILTO";
					systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
					mailto=systemcodedao.getDescr();
				} catch (ApplicationException e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							"MAILTO: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());
				} catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							"MAILTO: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
				}
			}


			//mailcc not found default to system mail address
			if (mailcc.equals("") || mailcc==null) {
				try {
					String codekey="MAILCC";
					systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
					mailcc=systemcodedao.getDescr();
				} catch (ApplicationException e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" MAILCC: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
				} catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" MAILCC: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
				}
			}


			//mailbcc not found default to system mail address
			if (mailbcc.equals("") || mailbcc==null) {
				try {
					String codekey="MAILBCC";
					systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
					mailbcc=systemcodedao.getDescr();
				} catch (ApplicationException e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" MAILBCC: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
				} catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" MAILBCC: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
				}
			}


			//init MAILSUBJECT
			try {
				String codekey="MAILSUBJECT";
				systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
				mailsubject=systemcodedao.getDescr();
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILSUBJECT: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILSUBJECT: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
			}
			//init MAILFROM
			try {
				String codekey="MAILFROM";
				systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
				mailfrom=systemcodedao.getDescr();
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILFROM: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILFROM: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
			}
			//init MAILTEXT
			try {
				String codekey="MAILTEXT";
				systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(typekey,codekey);	
				mailtext=systemcodedao.getDescr();
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILTEXT: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" MAILTEXT: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
			}

			systemcodedao=null;

			log.info("["+this.getClass().getName()+"] "+new Date()+
					" mailhost["+mailhost+"]"+
					" mailto["+mailto+"]"+
					" mailfrom["+mailfrom+"]"+
					" mailcc["+mailcc+"]"+
					" mailbcc["+mailbcc+"]"+
					" mailsubject["+mailsubject+"]"+
					" mailtext["+mailtext+"]"+						
					" mailattachment1["+mailattachment1+"]"							
			);




			//mail connection
			// set email properties
			Properties props = new Properties();
			props.put("mail.host", mailhost);			
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
			javax.mail.Message message = new MimeMessage(mailSession);



			javax.mail.Address mailaddress = null;

			//mail from
			if (!mailfrom.equals("")) {
				try {
					mailaddress = new InternetAddress(mailfrom);
					message.setFrom(mailaddress);
				}	
				catch (AddressException ae) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" Email From: AddressException: "+ae.getMessage());	
					throw new Exception();
				}
			}
			mailaddress = null;							

			//mail to
			if (!mailto.equals("")) {
				if ( mailto.indexOf(";") == 0 ) {
					try {
						mailaddress = new InternetAddress(mailto);
						message.addRecipient(Message.RecipientType.TO, mailaddress);
					}
					catch (AddressException ae) {
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Email TO: AddressException: "+ae.getMessage());
						throw new Exception();
					}
				}
				else {
					StringTokenizer _StringTokenizer = new StringTokenizer(mailto, ";");
					while (_StringTokenizer.hasMoreTokens()) {
						try {	
							mailaddress = new InternetAddress(_StringTokenizer.nextToken());
							message.addRecipient(Message.RecipientType.TO, mailaddress);
						}
						catch (AddressException ae) {
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
									" Email TO: AddressException: "+ae.getMessage());	
							throw new Exception();
						}						
					}
				}	
			}
			mailaddress = null;

			//mail cc
			if (!mailcc.equals("")) {
				if ( mailcc.indexOf(";") == 0 ) {
					try {
						mailaddress = new InternetAddress(mailcc);
						message.addRecipient(Message.RecipientType.CC, mailaddress);
					}
					catch (AddressException ae) {
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Email CC: AddressException: "+ae.getMessage());
						throw new Exception();
					}
				}
				else {
					StringTokenizer _StringTokenizer = new StringTokenizer(mailcc, ";");
					while (_StringTokenizer.hasMoreTokens()) {
						try {	
							mailaddress = new InternetAddress(_StringTokenizer.nextToken());
							message.addRecipient(Message.RecipientType.CC, mailaddress);
						}
						catch (AddressException ae) {
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
									" Email CC: AddressException: "+ae.getMessage());
							throw new Exception();
						}						
					}
				}
			}
			mailaddress = null;

			//mail bcc
			if (!mailbcc.equals("")) {
				if ( mailbcc.indexOf(";") == 0 ) {
					try {
						mailaddress = new InternetAddress(mailbcc);
						message.addRecipient(Message.RecipientType.BCC, mailaddress);
					}
					catch (AddressException ae) {
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Email BCC: AddressException: "+ae.getMessage());
						throw new Exception();
					}
				}
				else {
					StringTokenizer _StringTokenizer = new StringTokenizer(mailbcc, ";");
					while (_StringTokenizer.hasMoreTokens()) {
						try {	
							mailaddress = new InternetAddress(_StringTokenizer.nextToken());
							message.addRecipient(Message.RecipientType.BCC, mailaddress);
						}
						catch (AddressException ae) {
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
									" Email BCC: AddressException: "+ae.getMessage());
							throw new Exception();
						}						
					}
				}	
			}
			mailaddress = null;


			message.setSubject(mailsubject);


			File file = new File(mailattachment1);

			if (file.exists()) {
				Multipart multipart = new MimeMultipart();

				// Part one is the text
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setText(mailtext);
				multipart.addBodyPart(bodyPart);

				// Part two is the attachment
				bodyPart = new MimeBodyPart();
				DataSource sourceFile = new FileDataSource(mailattachment1);
				bodyPart.setDataHandler(new DataHandler(sourceFile));
				bodyPart.setFileName(mailattachment1);
				multipart.addBodyPart(bodyPart);

				message.setContent(multipart);
			}
			else {}


			//send mail	
			Transport.send(message);


		}
		catch (javax.mail.SendFailedException sfe) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Mail Process: SendFailedException: "+sfe.getMessage());
			throw new Exception();
		}	
		catch (javax.mail.MessagingException mex) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Mail Process: MessagingException: "+mex.getMessage());
			throw new Exception();
		}
		catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Mail Process: Exception: "+e.getMessage());
			throw new Exception();
		}		


		//mail process-----------------------------------------------<


	}  





}
