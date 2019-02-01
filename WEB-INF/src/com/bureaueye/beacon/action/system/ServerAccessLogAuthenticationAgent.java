package com.bureaueye.beacon.action.system;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import java.util.StringTokenizer;
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
 * Access log processes all requests for this virtual host.  By
 * default, log files are created in the "logs" directory relative to
 * $CATALINA_HOME.
 *
 * The authentication process checks the access TCP/IP addresses
 * using the REPORT, TT systems.  Reporting any IP addresses which
 * are not on the key list.
 *
 * Amendments
 * ----------
 * 
 * NT	2008-10-01		200800009		Add Server access Log Authentification 
 * 	
 */
public final class ServerAccessLogAuthenticationAgent extends Thread 
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
		
		
		List systemcodeList = new LinkedList();
		Hashtable processedHosts = new Hashtable();
		Hashtable accessLogHosts = new Hashtable();
		Hashtable invalidHosts = new Hashtable();
		try {
			systemcodeList = new SystemcodeBD().findSystemcodesByTypekey("ACCESSLOGHOST");	
			for (Iterator e = systemcodeList.iterator(); e.hasNext();) {
				Systemcode systemcode = (Systemcode) e.next();
				accessLogHosts.put(systemcode.getId().getCodekey(),systemcode);
			}
		} catch (ApplicationException ae) {
		}
		
		List applicationList = new LinkedList();
		Hashtable applications = new Hashtable();
		try {
			applicationList = new SystemcodeBD().findSystemcodesByTypekey("APPLICATION");	
			for (Iterator e = applicationList.iterator(); e.hasNext();) {
				Systemcode systemcode = (Systemcode) e.next();
				applications.put(systemcode.getId().getCodekey(),systemcode);
			}
		} catch (ApplicationException ae) {
		}
		
/*		String emailAccount = "";
		try {
			emailAccount = new SystemcodeBD().read("ACCESSLOGADMIN","EMAILCONTACT").getDescr();
		} catch (ApplicationException ae) {
		}*/
		
		String logDirectory = "";
		try {
			logDirectory = new SystemcodeBD().findSystemcodesByTypekeyCodekey("ACCESSLOGVALUE","DIRECTORY").getDescr();
		} catch (ApplicationException ae) {
		}
		String logPrefix = "";
		try {
			logPrefix = new SystemcodeBD().findSystemcodesByTypekeyCodekey("ACCESSLOGVALUE","PREFIX").getDescr();
		} catch (ApplicationException ae) {
		}
		String logSuffix = "";
		try {
			logSuffix = new SystemcodeBD().findSystemcodesByTypekeyCodekey("ACCESSLOGVALUE","SUFFIX").getDescr();
		} catch (ApplicationException ae) {
		}
		
		
		String searchFilename = 
			logPrefix+
			Util.dateFormat(cal.getTime())+
			logSuffix;	
		
		
		try {
			// set directory
			String directory = logDirectory+"\\";
			File path = new File(directory);
			String[] listdir = null;
			
			//List Directory process
			try {
				
				log.debug("["+this.getClass().getName()+"] "+new Date()+" processing list directory: "+path.getAbsolutePath());
				
				
				// get files from directory
				listdir = path.list();
				log.debug("["+this.getClass().getName()+"] "+new Date()+
						" listDirectory.length: "+listdir.length);
				
				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new Date()+
						" listDirectory Exception: "+e.getMessage());	
			}
			
			
			
			
			//get files process
			for (int index = 0; index < listdir.length; index++){
				
				String filename = listdir[index];
				if (filename.equals(searchFilename)) {
					
					String filenameAbsolutePath=directory+filename;
					
					File file = new File(filenameAbsolutePath);
					BufferedReader input =  new BufferedReader(new FileReader(file));
					
					try {
						//use buffering, reading one line at a time
						try {
							String line = null; //not declared within while loop
							/*
							 */
							while (( line = input.readLine()) != null){
								
								String [] data=getData(line);
								
								if (!processedHosts.containsKey(data[0])) {
																		
									// check line contains one of the applications
									// - uat-itt
									// - report-itt
									// - raven
									// - itt
									if (findApplication(applicationList, data[2])) { 								
									
										// set process hosts
										processedHosts.put(data[0],data);
										
										// check host is valid
										if (!accessLogHosts.containsKey(data[0])) { 
											
											invalidHosts.put(data[0],data);
											
										} // check valid access log hosts
										
									} // check applications
									
								} // check processedHosts
								
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
		
		
			
			try {
				// output results to file
				String outFileName = 
					logDirectory+"\\"+
					"invalidhosts."+searchFilename;
				
				PrintStream printOut = 
					new PrintStream(
							new BufferedOutputStream(
									new FileOutputStream(outFileName)));
				
				for (Enumeration e = invalidHosts.elements(); e.hasMoreElements();) {
					String[] data = (String[])e.nextElement();
					printOut.println(
							"Host: "+data[0]+
							" Date/Time: "+data[1]+
							" URL: "+data[2]
					);
				}
				printOut.close();
				
			} catch (Exception e) {}
			
		
		
	}
	
	
	public void sendEmail(String emailAccount) 
	throws SQLException, Exception
	{
		
		try {
			
			String mailHost = "";
			try {
				mailHost = new SystemcodeBD().findSystemcodesByTypekeyCodekey("SYSTEM","MAILHOST").getDescr();
			} catch (ApplicationException ae) {
			}
			
			// set email properties
			Properties props = new Properties();
			props.put("mail.host", mailHost);
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);
			javax.mail.Message body = new MimeMessage(mailSession);
			
			javax.mail.Address _From = null;
			try {
				// FROM - default to user logon
				_From = new InternetAddress(emailAccount);
				body.setFrom(_From);
			}	
			catch (AddressException ae) {
			}
			
			javax.mail.Address _Recipient = null;
			try {
				_Recipient = new InternetAddress(emailAccount);
				body.addRecipient(Message.RecipientType.TO, _Recipient);
			}
			catch (AddressException ae) {
			}
			
			
			
			body.setSubject("Server Access Log Authentication - Invalid Hosts");
			
			
			
			File file = new File("invalidhosts.txt");
			if (file.exists())
			{
				Multipart multipart = new MimeMultipart();
				
				// Part one is the text
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setText("");
				multipart.addBodyPart(bodyPart);
				
				// Part two is the attachment
				bodyPart = new MimeBodyPart();
				DataSource sourceFile = new FileDataSource("invalidhosts.txt");
				bodyPart.setDataHandler(new DataHandler(sourceFile));
				bodyPart.setFileName("invalidhosts.txt");
				multipart.addBodyPart(bodyPart);
				
				body.setContent(multipart);
			}
			else {   			
			}
			
			
			Transport.send(body);
			
		}
		catch (javax.mail.SendFailedException sfe) {
		}						
		catch (Exception e) {					
		}		
		finally {
		}
		
	} // send
	
		
	public static String[] getData (String line) {
		
		StringTokenizer splitter = new StringTokenizer(line," \t");

		
		String[] data = new String[10];	
		
		data[0] = splitter.nextToken();
		splitter.nextToken();
		splitter.nextToken("[");
		data[1] = splitter.nextToken(" \t");
		splitter.nextToken("\"");		
		data[2] = splitter.nextToken();
		splitter.nextToken(" \t");		
		data[3] = splitter.nextToken(" \t");		
		data[4] = splitter.nextToken(" \t");
		
		return data;
		
	}
	
	
	public static boolean findApplication (List applicationList, String searchSource) {
		
		boolean found = false;
		
		for (Iterator e = applicationList.iterator(); e.hasNext();) {
			Systemcode systemcode = (Systemcode) e.next();
			String search = "POST /"+systemcode.getDescr();		
			if (searchSource.startsWith(search)) {
				found = true;
				break;				
			}
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
	
	
	
	public static String getFilename(String s) {
		// -rw-rw-r--   1 proftpd  web           559 Sep 30 16:26 IFTSTA20060930184741341.txt
		StringTokenizer tokenizer = new StringTokenizer(s," ");
		String readwrite = "";
		String filler = "";
		String owner1 = "";
		String owner2 = "";
		String size = "";
		String month = "";
		String day = "";
		String time = "";
		String filename = "";
		try {
			readwrite = tokenizer.nextToken();
			filler  = tokenizer.nextToken();
			owner1  = tokenizer.nextToken();
			owner2  = tokenizer.nextToken();
			size  = tokenizer.nextToken();
			month  = tokenizer.nextToken();
			day  = tokenizer.nextToken();
			time  = tokenizer.nextToken();
			filename  = tokenizer.nextToken();
			
			log.debug("[getFilename] "+new Date()+
					" readwrite = "+readwrite+
					" filler = "+filler+
					" owner1 = "+owner1+
					" owner2 = "+owner2+
					" size = "+size+
					" month = "+month+
					" day = "+day+
					" time = "+time+
					" FILENAME = "+filename
			);
			
		} catch (Exception e) {
			return "";
		}
		return filename;
	}
	
	
	public static String getDoctype(String s) {
		int beginIndex = s.indexOf("UNH");
		s=s.substring(beginIndex,beginIndex+50);
		log.debug("[getDoctype] "+new Date()+" s = "+s);		
		//		 UNH+00001+IFTMBF:D:96A:UN'
		StringTokenizer tokenizer = new StringTokenizer(s,"+");
		String segment = "";
		String filler = "";
		String doctype = "";
		try {
			segment = tokenizer.nextToken();
			filler  = tokenizer.nextToken();
			doctype  = tokenizer.nextToken();
			doctype = doctype.substring(0,6);
			log.debug("[getDoctype] "+new Date()+
					" segment = "+segment+
					" filler = "+filler+
					" DOCTYPE = "+doctype
			);
			
		} catch (Exception e) {
			return "";
		}
		return doctype;
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
