package com.bureaueye.beacon.action.system;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.util.Util;


import java.util.*;

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



/**
 * application log manager checks for specific messages.
 *
 * The manager process checks the specific message problems
 * and outputs the results to a audit file.  Which will be emailed to
 * the system administrator.
 * 
 * Example exeption messages -
 * OutOfMemoryError
 * SQLException:
 *
 * Amendments
 * ----------
 * 
 * NT	2008-11-01		200800012		Application Log Manager
 * 	
 */
public final class ApplicationLogManagerAgent extends Thread 
{
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);
	
	/**
	 */
	//maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;
	
	
	@Override
	public void run() 
	{ 		
		
		setName(this.getClass().getName());
		setStartprocesstime();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("["+this.getClass().getName()+"] Run at: "+cal.getTime());			
		
		List messageList = new LinkedList();
		Hashtable appLogMessages = new Hashtable();
		List foundMessages = new LinkedList();
		try {
			messageList = new SystemcodeBD().findSystemcodesByTypekey("APPLOGMESSAGE");	
			for (Iterator e = messageList.iterator(); e.hasNext();) {
				Systemcode systemcode = (Systemcode) e.next();
				appLogMessages.put(systemcode.getId().getCodekey(),systemcode);
			}
		} catch (ApplicationException ae) {
		}
		
		
		
		String emailAccount = "";
		try {
			emailAccount = new SystemcodeBD().findSystemcodesByTypekeyCodekey("APPLOGADMIN","EMAILCONTACT").getDescr();
		} catch (ApplicationException ae) {
		}
		String systemEmailAccount = "";
		try {
			systemEmailAccount = new SystemcodeBD().findSystemcodesByTypekeyCodekey("SYSTEM","EMAILCONTACT").getDescr();
		} catch (ApplicationException ae) {
		}
		
		String logDirectory = "";
		try {
			logDirectory = new SystemcodeBD().findSystemcodesByTypekeyCodekey("APPLOGVALUE","DIRECTORY").getDescr();
		} catch (ApplicationException ae) {
		}
		String logPrefix = "";
		try {
			logPrefix = new SystemcodeBD().findSystemcodesByTypekeyCodekey("APPLOGVALUE","PREFIX").getDescr();
		} catch (ApplicationException ae) {
		}
		String logSuffix = "";
		try {
			logSuffix = new SystemcodeBD().findSystemcodesByTypekeyCodekey("APPLOGVALUE","SUFFIX").getDescr();
		} catch (ApplicationException ae) {
		}
		
		
		String searchFilename = 
			logPrefix+
			Util.dateFormat(new Date())+
			logSuffix;	
		log.info(
				"["+this.getClass().getName()+"] "+
				new Date()+
				" searchFilename["+searchFilename+"]"				
		);			
		
		try {
			// set directory
			String directory = logDirectory+"\\";
			File path = new File(directory);
			String[] listdir = null;
			
			//List Directory process
			try {
				
				log.debug(
						"["+this.getClass().getName()+"] "+
						new Date()+" processing list directory: "+
						path.getAbsolutePath()
				);
				
				
				// get files from directory
				listdir = path.list();
				log.debug(
						"["+this.getClass().getName()+"] "+
						new Date()+
						" listDirectory.length: "+
						listdir.length
				);
				
				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new Date()+
						" listDirectory: Exception: "+e.getMessage());	
			}
			
			
		
			
			//get files process
			for (int index = 0; index < listdir.length; index++){
				
				String filename = listdir[index];
				if (filename.equals(searchFilename)) {
					
					String filenameAbsolutePath=directory+filename;					
					File file = new File(filenameAbsolutePath);
					BufferedReader input =  new BufferedReader(new FileReader(file));
					
					try {
						
						log.debug(
								"["+this.getClass().getName()+"] "+
								new Date()+
								" filenameAbsolutePath["+filenameAbsolutePath+"]"				
						);
						
						//use buffering, reading one line at a time
						try {
							int lineCount = 1;
							String line = null; //not declared within while loop
							
							/*
							 */
							while (( line = input.readLine()) != null){
								
								String[] data = {"","",""};
								data[0] = line;
								// check line contains one of the messages
								if (
										findMessage(messageList, data[0])
								) { 							
									
									data[1] = filenameAbsolutePath;
									data[2] = new Integer(lineCount).toString();
									
									foundMessages.add(data);											
									
								} // check messages
								
								lineCount++;
								
							}
						}
						finally {
							input.close();
						}
					}
					catch (IOException ex){
						ex.printStackTrace();
					}
					
					
				} // check filename not blank
				
			} // get files loop
			
			
		} catch(Exception e){
			log.error("["+this.getClass().getName()+"] "+new Date()+
					" Exception: "+e.getMessage());	
		}
		
		
		String outFileName = 
			logDirectory+"\\"+
			"ApplicationLogManager.txt";
		
		try {
			// output results to file			
			PrintStream printOut = 
				new PrintStream(
						new BufferedOutputStream(
								new FileOutputStream(outFileName)));
			
			for (Iterator e = foundMessages.iterator(); e.hasNext();) {
				String[] data = (String[])e.next();
				printOut.println(
						//" Line: "+data[2]+
						" Message: "+data[0]+
						" Filename: "+data[1]
				);
			}
			printOut.close();
			
		} catch (Exception e) {}
		
		
		try {	
			log.debug(
					"["+this.getClass().getName()+"] "+
					new Date()+
					" sendEmail:"+
					" emailAccount["+emailAccount+"]"+
					" systemEmailAccount["+systemEmailAccount+"]"					
			);
			
			sendEmail(emailAccount, systemEmailAccount, outFileName);
		} 
		catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new Date()+
					" sendEmail: Exception: "+e.getMessage());			
		}
		
		
	}
	
	
	public void sendEmail(String emailAccount, String systemEmailAccount, String outFileName) 
	throws ApplicationException, AddressException, javax.mail.SendFailedException, Exception
	{
		
		try {
			
			String mailHost = "";
			try {
				mailHost = new SystemcodeBD().findSystemcodesByTypekeyCodekey("SYSTEM","MAILHOST").getDescr();
			} catch (ApplicationException ae) {
				throw new ApplicationException(ApplicationException.ROW_NOT_READ);
			} 
			
			// set email properties
			Properties props = new Properties();
			props.put("mail.host", mailHost);
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
			javax.mail.Message body = new MimeMessage(mailSession);
			
			javax.mail.Address _From = null;
			try {
				// FROM - default to user logon
				_From = new InternetAddress(systemEmailAccount);
				body.setFrom(_From);
			}	
			catch (AddressException ae) {
				throw new AddressException("setFrom: AddressException: "+ae.getMessage());
			}
			
			javax.mail.Address _Recipient = null;
			/*			try {
			 _Recipient = new InternetAddress(emailAccount);
			 body.addRecipient(Message.RecipientType.TO, _Recipient);
			 }
			 catch (AddressException ae) {
			 throw new AddressException("addRecipient: AddressException: "+ae.getMessage());
			 }*/
			StringTokenizer _StringTokenizer = new StringTokenizer(emailAccount, ";");
			while (_StringTokenizer.hasMoreTokens()) {
				try {	
					_Recipient = new InternetAddress(_StringTokenizer.nextToken());
					body.addRecipient(Message.RecipientType.TO, _Recipient);
				}
				catch (AddressException ae) {
					throw new AddressException("addRecipient: AddressException: "+ae.getMessage());
				}						
			}
			
			
			
			body.setSubject("ITT: Application Log Manager - Exception Messages");
			
			
			
			File file = new File(outFileName);
			if (file.exists())
			{
				Multipart multipart = new MimeMultipart();
				
				// Part one is the text
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setText("");
				multipart.addBodyPart(bodyPart);
				
				// Part two is the attachment
				bodyPart = new MimeBodyPart();
				DataSource sourceFile = new FileDataSource(outFileName);
				bodyPart.setDataHandler(new DataHandler(sourceFile));
				bodyPart.setFileName(outFileName);
				multipart.addBodyPart(bodyPart);
				
				body.setContent(multipart);
			}
			else {   			
			}
			
			
			Transport.send(body);
			
		}
		catch (javax.mail.SendFailedException sfe) {
			throw new javax.mail.SendFailedException(sfe.getMessage());
		}						
		catch (Exception e) {					
			throw new Exception(e.getMessage());
		}		
		finally {
		}
		
	} // send
	
	
	
	
	public static boolean findMessage (List list, String searchSource) {
		
		boolean found = false;
		if (searchSource == null) return false;
		
		try {
			for (Iterator e = list.iterator(); e.hasNext();) {
				Systemcode systemcode = (Systemcode) e.next();
				String searchFor = systemcode.getDescr();
				if (searchSource.indexOf(searchFor) != -1) {
					found = true;
					break;				
				}
			}
		} catch (Exception e) {
		}
		
		return found;
		
	}
	
	
	
	
	void println(String s) { System.out.println(s); }
	
	
	
	public static String readertoString(Reader is) throws IOException {
		StringBuffer sb = new StringBuffer();
		char[] b = new char[2086];
		int n;
		while ((n=is.read(b)) > 0) {
			sb.append(b, 0, n);
		}
		return sb.toString();
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
		
		log.debug(
				"["+this.getClass().getName()+"] "+new Date()+
				" isblocked: "+_currenttime.after(_maxprocesstime)+
				" currenttime: "+_currenttime.getTime()+
				" maxprocesstime: "+_maxprocesstime.getTime()
		);
		
		if (_currenttime.after(_maxprocesstime)) return true;
		return false;
	}
	
	
}
