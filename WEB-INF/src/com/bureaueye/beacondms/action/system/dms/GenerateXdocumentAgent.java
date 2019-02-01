package com.bureaueye.beacondms.action.system.dms;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Calendar;
import java.util.Date;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.Xdocumentversion;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentversionBD;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;







/**
 *
 * Amendments
 * ----------
 * 	
 */
public final class GenerateXdocumentAgent implements Runnable 
{

	protected Map<String, SessionFactory> sessionFactoryClusterMap;	
	public GenerateXdocumentAgent(Map<String, SessionFactory> sessionFactoryClusterMap) {
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
	XdocumentBD xdocumentbd;
	DocumenttypeBD documenttypebd;
	XdocumentversionBD xdocumentversionbd;
	


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
		xdocumentbd = new XdocumentBD(sessionFactoryClusterMap);
		documenttypebd = new DocumenttypeBD(sessionFactoryClusterMap);
		xdocumentversionbd = new XdocumentversionBD(sessionFactoryClusterMap);
	



		//get xml directories
		Systemcode systemcodedao = null; 
		String fromDirectory = "";
		try {
			systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
					"MONITOR", 
					"XMLDIRECTORY"
			);
			fromDirectory = systemcodedao.getDescr();
		} catch (ApplicationException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
		}

		String workDirectory = "";
		try {
			systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
					"BEACONDMS", 
					"WORKDIRECTORY"
			);
			workDirectory = systemcodedao.getDescr();
		} catch (ApplicationException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
		}

		String toDirectory = "";
		try {
			systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
					"BEACONDMS", 
					"XMLARCHIVEDIRECTORY"
			);
			toDirectory = systemcodedao.getDescr();
		} catch (ApplicationException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
		}



		try {


			//output from directory log
			log.info("["+this.getClass().getName()+"] "+new Date()+" From XML Directory: "+fromDirectory);	



			// The list of files can also be retrieved as File objects
			File dir = new File(fromDirectory);
			File[] files = dir.listFiles();


			// This filter only returns directories
			FileFilter fileFilter = new FileFilter() {
				public boolean accept(File file) {
					return !file.isDirectory();
				}
			};
			files = dir.listFiles(fileFilter);




			//check files found
			if (files!=null) {

				//get files process
				for (int index = 0; index < files.length; index++){

					String filename = files[index].getName();
					// do not process invalid file names
					if (!filename.equals("") && !filename.startsWith(".") ) {

						String fromFilename = fromDirectory+"\\"+filename;


						//output to directory log
						log.info("["+this.getClass().getName()+"] "+new Date()+" To XML Directory: "+toDirectory);	


						String toFilename = toDirectory+"\\"+filename;

						//output from Filename to log
						log.info("["+this.getClass().getName()+"] "+new Date()+
								" processing AVAILABLE file: "+fromFilename);




						log.info("["+this.getClass().getName()+"] "+new Date()+
								" copy from file: "+fromFilename+" to directory: "+toDirectory);


						//copy file 
						String[] args = { "cmd", "/C", "copy", fromFilename, toDirectory };
						Runtime.getRuntime().exec(args);



						log.info("["+this.getClass().getName()+"] "+new Date()+
								" processing RECEIVED file: "+toFilename);



						//process file line by line
						String line;
						BufferedReader in = new BufferedReader(new FileReader(fromFilename));
						if (!in.ready()) throw new IOException();
						StringBuffer xmlDocument = new StringBuffer();
						while ((line = in.readLine()) != null) {
							xmlDocument.append(line);								
						}//loop lines in file
						in.close();



						if (!xmlDocument.toString().equals("")) {

							//GENERATE DOCUMENT														
							try {

								//parse XML document
								DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
								DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
								domDocument = dBuilder.parse(
										new org.xml.sax.InputSource(
												new java.io.StringReader(xmlDocument.toString())
										)
								);
								domDocument.getDocumentElement().normalize();

								elementDocument=(org.w3c.dom.Element) domDocument.getElementsByTagName("Document").item(0);
								String documentType=elementDocument.getAttribute("DocumentType");
								org.w3c.dom.Element elementOrdhdr1=(org.w3c.dom.Element) elementDocument.getElementsByTagName("Ordhdr1").item(0);
								org.w3c.dom.Element elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);
								org.w3c.dom.Element elementDeptcode=(org.w3c.dom.Element) elementDocument.getElementsByTagName("deptcode").item(0);								
								String ordno =getTagValue("ordno",elementOrdhdr1);
								String userid =getTagValue("UserId",elementParamdetails);
								String departmentkey =getTagValue("deptcode",elementDeptcode);
								String activitykey =getTagValue("actvcode",elementDeptcode);
								String companykey =getTagValue("compcode",elementDeptcode);

								
								//check document key already generated
								String key = ordno+"|"+documentType;	
								
								//find document if already generated
								Xdocument xdocumentdao = null;
								try {
									xdocumentdao = xdocumentbd.findXdocumentByDockey(key);
								} catch (Exception e) {								
								}
								//if not found generate new document
								if (xdocumentdao==null) xdocumentdao = new Xdocument();

								
								user.setUserid(userid);

								//store file information
								xdocumentdao.setSourcefilename(toFilename);
								xdocumentdao.setFilename("");
								xdocumentdao.setFilesize(0);
								xdocumentdao.setContenttype("");

								xdocumentdao.setDoctype(documentType);
								xdocumentdao.setCreateaction(Constants.GENERATE);
								
								//init id
								xdocumentdao.setDocid(ordno);
								xdocumentdao.setDockey(key);
								
								xdocumentdao.setErrors("");
								xdocumentdao.setWarnings("");
								xdocumentdao.setCompanykey(companykey);
								xdocumentdao.setDepartmentkey(departmentkey);
								xdocumentdao.setActivitykey(activitykey);

								xdocumentdao.setTxt1("");
								xdocumentdao.setTxt2("");
								xdocumentdao.setCategorycode("");
								xdocumentdao.setSubcategorycode("");
								xdocumentdao.setGroupid("");
								xdocumentdao.setTransactionid("");
								xdocumentdao.setModuleid("");
								xdocumentdao.setDocument("");								
								xdocumentdao.setControlid("");	
								
								//store document
								xdocumentdao.setXmldocument(xmlDocument.toString());	

								xdocumentbd.createOrUpdate(xdocumentdao, user);		


								//get Document Type  
								//- pagesize
								//- build class
								//- margins
								Documenttype documenttypedao = null;
								try {
									documenttypedao = documenttypebd.findDocumenttypeByDoctype(documentType);
								} catch (ApplicationException e) {
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttypeByDoctype: ApplicationException: "+e.getMessage());				
								} catch (Exception e) {
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttypeByDoctype: Exception: "+e.getMessage());							
								}






								//===========================================>
								log.info(
										"["+this.getClass().getName()+"] "+new Date()+
										" Build Document: "+xdocumentdao.getDockey()
										);

								try {

									// build class and worker method
									Method buildWorker = null;
									Class<?> buildClass = null;
									try {
										buildClass = Class.forName(documenttypedao.getBuildclass());
										Class[] argTypes = { com.bureaueye.beacondms.model.dms.Xdocument.class, java.util.Map.class };    		

										String methodName = "build";
										// initialise work method depending on process
										buildWorker = buildClass.getMethod(
												methodName,
												argTypes
										);	

										log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
												"  Build Worker Name: "+buildWorker.getName());

									} catch (ClassNotFoundException x) {
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" init buildclass: ClassNotFoundException: " + x.getMessage());
									} catch (NoSuchMethodException x) {
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" init buildclass: NoSuchMethodException: " + x.getMessage());					
									} catch (Exception e) {	
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" init buildclass exception: " + e.getMessage());				
									}

									log.info(
											"["+this.getClass().getName()+"] "+new Date()+
											" Build Document BuildClass: "+documenttypedao.getBuildclass()
									);

									try {
										// initialise actual data to send
										Object[] theData = { xdocumentdao,  this.sessionFactoryClusterMap };
										// invoke worker method
										buildWorker.invoke(buildClass.newInstance(), theData);
									} catch (IllegalAccessException x) {
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" invoke buildWorker: IllegalAccessException: " + x.getMessage());
									} catch (InvocationTargetException x) {
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" invoke buildWorker: InvocationTargetException: " + x.getMessage());							
									} catch (Exception x) {	
										log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
												" invoke buildWorker: Exception: " + x.getMessage());
									}

								} catch (Exception e) {
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
											" Build Document: Exception: " + e.getMessage());
								}





								//generate print file
								String printFilename = "";															
								printFilename = workDirectory+"\\"+xdocumentdao.getXdocumentId()+".pdf";								
								File printFile = new File(printFilename);							


								log.info("["+this.getClass().getName()+"] "+new Date()+
										" print file: "+printFilename);



								//store print file	
								try {

									FileInputStream fin = new FileInputStream(printFile);
									byte fileContent[] = new byte[(int)printFile.length()];
									fin.read(fileContent);
									fin.close();

									//upload file information
									xdocumentdao.setFilebin( Hibernate.createBlob (fileContent) );
									//store file information
									xdocumentdao.setFilename(printFile.getName());
									xdocumentdao.setFilesize((int)printFile.length());
									xdocumentdao.setContenttype("application/pdf");
									xdocumentdao.setLanguageid(documenttypedao.getLanguageid());
									xdocumentdao.setTestindicator(documenttypedao.getTestindicator());
									
									//store desctiption and category
									xdocumentdao.setDescription(documenttypedao.getDescription());
									xdocumentdao.setCategorycode(documenttypedao.getCategorycode());
									xdocumentdao.setSubcategorycode(documenttypedao.getSubcategorycode());
									
									//set receive details
									xdocumentdao.setReceivedate(xdocumentdao.getCreatedate());
									xdocumentdao.setReceivetime(xdocumentdao.getCreatetime());

									//TODO: SHOULD CALL GENERATE BASE_HEADER HERE---->
									xdocumentdao.setXmlheader(
											"<header>"+
											"<xdocument_id>"+xdocumentdao.getXdocumentId()+"</xdocument_id>"+
									"</header>");


									//TODO: NEED TO INITIALISE the XMLDOCUMENT FILED
									// 		HERE SO THAT IT HAS THE PARAMETER AND HEADER DETAILS
									// 		FROM THE MONIOTR XML FILE
									//xdocumentdao.setXmldocument("");

									

									try {					 
										Xdocumentversion version = 
											xdocumentversionbd.createXdocumentversion(
													xdocumentdao, 
													user, 
													"create",
													""//version description
											);
										//init version information
										xdocumentdao.setVersionno(version.getVersionno());
										xdocumentdao.setVersiondescription(version.getVersiondescription());
										xdocumentdao.setVersiondate(version.getVersiondate());
										xdocumentdao.setVersiontime(version.getVersiontime());
										xdocumentdao.setVersionuserid(version.getVersionuserid());
									} catch (HibernateException e) {	
									}
									
									
									xdocumentbd.createOrUpdate(xdocumentdao, user);

								} catch(Exception ae){
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
											" Store: Exception: "+ae.getMessage()
									);
									throw new Exception();									
								}


								//email print file	
								try {

									toMail(
											printFilename//filename
									);

								} catch(Exception ae){
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
											" Email: Exception: "+ae.getMessage()
									);
									throw new Exception();									
								}


								//delete monitor xml file 
								try {
									File file = new File(fromFilename);
									if (file.exists()) {
										file.delete();	
										log.info("["+this.getClass().getName()+"] "+new Date()+					
												" fromFilename["+fromFilename+"]"+
												" deleted"							
										);	
									}
								} catch(Exception ae){
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
											" Delete: Exception: "+ae.getMessage()
									);
									throw new Exception();
								}

								//delete print file 
								try {
									if (printFile.exists()) {
										printFile.delete();	
										log.info("["+this.getClass().getName()+"] "+new Date()+					
												" printFilename["+printFilename+"]"+
												" deleted"							
										);	
									}
								} catch(Exception ae){
									log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
											" Delete: Exception: "+ae.getMessage()
									);
									throw new Exception();
								}
								

							}
							catch(FileNotFoundException e)	{
								log.error(
										"["+this.getClass().getName()+"] "+new Date()+
										" FileNotFoundException: "+e.getMessage()
								);	
							}
							catch(IOException ioe)	{
								log.error(
										"["+this.getClass().getName()+"] "+new Date()+
										" IOException: "+ioe.getMessage()
								);	
							} catch (Exception e) {
								log.error(
										"["+this.getClass().getName()+"] "+new Date()+
										" Exception: "+e.getMessage()
								);	


							}



						} //check xml found 

					} //check filename not blank

				} //get files loop

			}

		} catch(Exception e){
			log.error("["+this.getClass().getName()+"] "+new Date()+
					" Exception: "+e.getMessage());	
		}									



		// clean-up
		systemcodebd = null;
		systemxbd = null;
		xdocumentbd=null;
		xdocumentversionbd=null;

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

			/*			try {
				org.w3c.dom.Element elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);
				mailto=getTagValue("ToEmail",elementParamdetails);
				mailcc=getTagValue("CCToEmail",elementParamdetails);
				//mailbcc=getTagValue("UserEmail",elementParamdetails);
			} catch (Exception e) {	
			}*/

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





	private static String getTagValue(String sTag, org.w3c.dom.Element eElement){
		String returnValue="";
		try {
			org.w3c.dom.NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
			org.w3c.dom.Node nValue = (org.w3c.dom.Node) nlList.item(0); 
			returnValue=nValue.getNodeValue(); 
		} catch (Exception e) {
		}		
		return returnValue;    
	}





	/*	public static TreeMap<String,StringBuffer> buildHeader(
			User user, Map<String, SessionFactory> sessionFactoryClusterMap
	) throws Exception {

		//validation
		//errors
		//warnings
		TreeMap<String,StringBuffer> returnParams = new TreeMap<String,StringBuffer>();
		StringBuffer document = new StringBuffer("");
		StringBuffer errors = new StringBuffer("");
		StringBuffer warnings = new StringBuffer("");


		int segmentCount=0;


		//xml message specification
		BaseHeader header = new BaseHeader();


		//PROCESS HEADER--------------------------------------------->
		document.append(headerPrefix);

		//companyheader
		try{
			header.setCompanyheader(new Integer(saveForm.getCompanyheaderid()), sessionFactoryClusterMap);
			document.append(header.getCompanyheader());
			segmentCount++;
		} catch (Exception e) {
		}

		//userid
		try{
			header.setUserid(user.getUserid());
			document.append(header.getUserid());
			segmentCount++;
		} catch (Exception e) {
		}

		//emailto
		try{
			header.setEmailto(saveForm.getEmailto());
			document.append(header.getEmailto());
			segmentCount++;
		} catch (Exception e) {
		}

		//emailcc
		try{
			header.setEmailcc(saveForm.getEmailcc());
			document.append(header.getEmailcc());
			segmentCount++;
		} catch (Exception e) {
		}

		//emailfrom
		try{
			header.setEmailfrom(saveForm.getEmailfrom());
			document.append(header.getEmailfrom());
			segmentCount++;
		} catch (Exception e) {
		}

		//subject
		try{
			header.setSubject(saveForm.getSubject());
			document.append(header.getSubject());
			segmentCount++;
		} catch (Exception e) {
		}

		//languageid
		try{
			header.setLangaugeid(saveForm.getLanguageid());
			document.append(header.getLanguageid());
			segmentCount++;
		} catch (Exception e) {
		}


		document.append(headerSuffix);





		if (!errors.toString().equals("")) {
			errors.insert(0,errorsPrefix);
			errors.append(errorsSuffix);
		}
		if (!warnings.toString().equals("")) {
			warnings.insert(0,warningsPrefix);
			warnings.append(warningsSuffix);
		}

		returnParams.put("1",document);
		returnParams.put("2",errors);
		returnParams.put("3",warnings);


		return returnParams;

	}
	 */








}
