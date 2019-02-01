package com.bureaueye.beacondms.action.dms;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;


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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.LabelValue;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.bean.dms.base.DBToXml;
import com.bureaueye.beacondms.form.dms.GenerateXdocumentForm;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.Xdocumentversion;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentversionBD;


import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.bd.OrderfileBD;
import com.bureaueye.beacon.model.order.dto.OrderprodDTO;
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
public final class GenerateXdocument2Action extends BaseAction {




	com.itextpdf.text.Document pdfDocument;	
	org.w3c.dom.Document domDocument; 
	org.w3c.dom.Element elementDocument; 


	SystemcodeBD systemcodebd;
	SystemXBD systemxbd;
	XdocumentBD xdocumentbd;
	DocumenttypeBD documenttypebd;
	XdocumentversionBD xdocumentversionbd;


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {		


		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		GenerateXdocumentForm saveForm = (GenerateXdocumentForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();


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

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action + " action");

		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				" Form parameters: "+saveForm.toString()
		);	




		// error validation		

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




		if (saveForm.getBtnSubmit() != null) {


			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" button = " + saveForm.getBtnSubmit());


			//GET SELECTED SHIP MOVEMENT========================================================>
			// get selected rows
			Integer selectedShipMovement=new Integer(0);
			if (saveForm.getList1() != null) {			
				int[] selectedObjects1 = saveForm.getSelectedObjects1();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();
				if (selectedObjects1 != null) {
					for (int i = 0; i < selectedObjects1.length; i++) {
						tm.put(new Integer(selectedObjects1[i]),new Integer(selectedObjects1[i]));			
					}
				}
				LOOP1:
					for (Iterator it = saveForm.getList1().iterator(); it.hasNext();) {
						// get row
						JobmovDTO row = (JobmovDTO)it.next();
						// selected
						if (tm.get(row.getJobmovId()) != null) {
							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" selected List1 = " + row.getJobmovId());
							selectedShipMovement=row.getJobmovId();
							break LOOP1;
						}
					}			
			}
			//GET SELECTED SHIP MOVEMENT========================================================<			

			//GET SELECTED PRIMARY MOVEMENT========================================================>
			// get selected rows
			Integer selectedPrimaryMovement=new Integer(0);
			if (saveForm.getList2() != null) {
				int[] selectedObjects2 = saveForm.getSelectedObjects2();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();
				if (selectedObjects2 != null) {
					for (int i = 0; i < selectedObjects2.length; i++) {
						tm.put(new Integer(selectedObjects2[i]),new Integer(selectedObjects2[i]));			
					}
				}
				LOOP2:
					for (Iterator it2 = saveForm.getList2().iterator(); it2.hasNext();) {
						// get row
						JobmovDTO row = (JobmovDTO)it2.next();
						// selected
						if (tm.get(row.getJobmovId()) != null) {
							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" selected List2 = " + row.getJobmovId());
							selectedPrimaryMovement=row.getJobmovId();
							break LOOP2;
						}
					}
			}
			//GET SELECTED PIMARY MOVEMENT========================================================<

			//GET SELECTED PRODUCT========================================================>
			// get selected rows
			Integer selectedPrimaryProduct=new Integer(0);
			if (saveForm.getList3() != null) {
				int[] selectedObjects3 = saveForm.getSelectedObjects3();
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer> ();
				if (selectedObjects3 != null) {
					for (int i = 0; i < selectedObjects3.length; i++) {
						tm.put(new Integer(selectedObjects3[i]),new Integer(selectedObjects3[i]));	
					}
				}
				LOOP3:
					for (Iterator it3 = saveForm.getList3().iterator(); it3.hasNext();) {
						// get row
						OrderprodDTO row = (OrderprodDTO)it3.next();
						// selected
						if (tm.get(row.getOrderprodId()) != null) {
							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
									" selected List3 = " + row.getOrderprodId());
							selectedPrimaryProduct=row.getOrderprodId();
							break LOOP3;
						}
					}
			}
			//GET SELECTED PIMARY MOVEMENT========================================================<

			// check primary movement selected			
			if (selectedPrimaryMovement==0) {
				// Add an error message
				appErrorMessages.add(
						"errors.generatexdocument",
						new ActionMessage(
								"error.primarymovement.notselected"
						)
				);				
			}
			// check ship movement selected
			if (selectedShipMovement==0) {
				// Add an error message
				appErrorMessages.add(
						"errors.generatexdocument",
						new ActionMessage(
								"error.shipmovement.notselected"
						)
				);					
			}
			// check product selected
			if (selectedPrimaryProduct==0) {
				// Add an error message
				appErrorMessages.add(
						"errors.generatexdocument",
						new ActionMessage(
								"error.primaryproduct.notselected"
						)
				);					
			}




			if (!appErrorMessages.isEmpty()) {
				saveAppErrorMessages(request, appErrorMessages);
				return (mapping.getInputForward());				
			}

			saveForm.setSelectedPrimaryMovement(selectedPrimaryMovement+"");
			saveForm.setSelectedShipMovement(selectedShipMovement+"");
			saveForm.setSelectedPrimaryProduct(selectedPrimaryProduct+"");


			//get Document Type  
			//- pagesize
			//- build class
			//- margins
			documenttypebd = new DocumenttypeBD(this.getSessionFactoryClusterMap());			
			Documenttype documenttypedao = null;
			try {
				documenttypedao = documenttypebd.read(new Integer(saveForm.getDocumenttypeId()));
			} catch (ApplicationException e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttype: ApplicationException: "+e.getMessage());				
			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findDocumenttype: Exception: "+e.getMessage());							
			}

			//BUILD XML========================================================>
			StringBuffer xmlDocument=new StringBuffer();
			saveForm.setDocumentType(documenttypedao.getDoctype());
			saveForm.setDocumentLanguage(documenttypedao.getLanguageid());
			try {

				DBToXml toXml = new DBToXml();

				//prefix
				xmlDocument.append("<?xml version=\"1.0\" ?>");
				xmlDocument.append("<Document DocumentType=\""+documenttypedao.getDoctype()+"\">");


				//parameter details
				toXml.setParamDetails(saveForm,user,this.getSessionFactoryClusterMap());
				xmlDocument.append(toXml.getParamDetails());


				//loop job headers
				JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());				
				List jobhdrs = new LinkedList();
				int count=0;
				jobhdrs=jobhdrbd.findJobhdrsById(saveForm.getId(), 0, Constants.MAX_RESULTS_NOLIMIT, "Unitkey");				
				for (Iterator it = jobhdrs.iterator(); it.hasNext();) {
					JobhdrDTO jobhdrdto = (JobhdrDTO)it.next();
					count++;

					try {
						toXml.setOrdhdr(saveForm, jobhdrdto,count,this.getSessionFactoryClusterMap());					
						//init order hdr xml
						xmlDocument.append(toXml.getOrdhdr());
					} catch (Exception e) {
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" setOrdhdr: Exception: "+e.getMessage());						
					}

				}


				//suffix
				xmlDocument.append("</Document>");



			} catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" DBToXml: Exception: "+e.getMessage());
			}
			//BUILD XML========================================================<

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" xmlDocument = " + xmlDocument.toString());			



			//init BD
			systemcodebd = new SystemcodeBD(this.getSessionFactoryClusterMap());
			systemxbd = new SystemXBD(this.getSessionFactoryClusterMap());
			xdocumentbd = new XdocumentBD(this.getSessionFactoryClusterMap());
			xdocumentversionbd = new XdocumentversionBD(this.getSessionFactoryClusterMap());





			String workDirectory = "";
			Systemcode systemcodedao=null;
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




			try {



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
					xdocumentdao.setSourcefilename("");
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



					//===========================================>
					log.debug(
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

							log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
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

						log.debug(
								"["+this.getClass().getName()+"] "+new Date()+
								" Build Document BuildClass: "+documenttypedao.getBuildclass()
						);

						try {
							// initialise actual data to send
							Object[] theData = { xdocumentdao,  this.getSessionFactoryClusterMap() };
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


					log.debug("["+this.getClass().getName()+"] "+new Date()+
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




					// clean-up
					systemxbd = null;
					xdocumentbd=null;
					xdocumentversionbd=null;



					//email print file	
					if (saveForm.getBtnSubmit().equals("EMAIL")) {

						// Generate Business Delegate
						OrderfileBD orderfilebd = new OrderfileBD(this.getSessionFactoryClusterMap());

						List mailAttachmentsList = new LinkedList();
						int row=0;

						int maximumAttachments = 0;
						try {
							Systemcode systemcode = systemcodebd.findSystemcodesByTypekeyCodekey(
									"BEACONDMS", 
									"MAXIMUM_ATTACHMENTS"
							);
							maximumAttachments = new Integer(systemcode.getDescr()).intValue();
						} catch (ApplicationException e) {
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" MAXIMUM_ATTACHMENTS: findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
						} catch (Exception e) {
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" MAXIMUM_ATTACHMENTS: findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
						}

						// BUILD STORED DOCUMENT ATTACHMENTS=====================================>
						int[] selectedObjects = saveForm.getSelectedObjects4();
						// process selected
						if (selectedObjects != null) {
							LOOP2:
								for (int i = 0; i < selectedObjects.length; i++) {	

									//maximum number of attachments allowed
									if (row>maximumAttachments) {
										row=maximumAttachments;
										break LOOP2;
									}

									Integer id = new Integer(selectedObjects[i]);			
									// retrieve record
									Orderfile dao = orderfilebd.read(new Integer(id));

									//output attachment to work directory
									String outFilename = workDirectory+"\\"+dao.getFilename();
									//File outFile = new File(outFilename);
									FileOutputStream outStream = new FileOutputStream(outFilename);
									InputStream in = dao.getFilebin().getBinaryStream();
									byte[] buffer = new byte[32768];
									int n = 0;
									while ( ( n = in.read(buffer)) != -1) {
										outStream.write(buffer, 0, n);
									}
									in.close();
									outStream.flush();
									outStream.close();

									mailAttachmentsList.add(new LabelValue(dao.getFilename(),outFilename));

									row++;
								}//end for loop					

						}//check objects selected
						// BUILD STORED DOCUMENT ATTACHMENTS=====================================<

						try {

							toMail(
									printFilename,//filename
									saveForm,
									mailAttachmentsList
							);		

							// Add information message 
							appInformationMessages.add(
									"messages.generatexdocument",
									new ActionMessage(
											"information.mail.sent",
											documenttypedao.getDescription(),
											saveForm.getMailto()
									)
							);
							saveAppInformationMessages(request, appInformationMessages);	

						} catch(Exception ae){
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
									" EMAIL: Exception: "+ae.getMessage()
							);

							// Add error message 
							appErrorMessages.add(
									"errors.generatexdocument",
									new ActionMessage(
											"error.mail.notsent",
											documenttypedao.getDescription(),
											saveForm.getMailto()
									)
							);
							saveAppErrorMessages(request, appErrorMessages);						
							throw new Exception();									
						}

						orderfilebd = null;
					}


					//email print file	
					if (saveForm.getBtnSubmit().equals("PRINT")) {
						try {

							response.setContentLength( xdocumentdao.getFilesize() );
							response.setContentType( xdocumentdao.getContenttype() );
							//response.setHeader("Content-disposition", "attachment; filename=" + xdocumentdao.getFilename());
							//response.setHeader("Cache-Control", "max-age=600");

							ServletOutputStream outStream = response.getOutputStream();
							InputStream in = xdocumentdao.getFilebin().getBinaryStream();
							byte[] buffer = new byte[32768];
							int n = 0;
							while ( ( n = in.read(buffer)) != -1) {
								outStream.write(buffer, 0, n);
							}
							in.close();
							outStream.flush();

							return null;

						} catch(Exception ae){
							log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
									" PRINT: Exception: "+ae.getMessage()
							);
							throw new Exception();									
						}
					}





					/*					//delete print file 
					try {
						if (printFile.exists()) {
							printFile.delete();	
							log.debug("["+this.getClass().getName()+"] "+new Date()+					
									" printFilename["+printFilename+"]"+
									" deleted"							
							);	
						}
					} catch(Exception ae){
						log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
								" Delete: Exception: "+ae.getMessage()
						);
						throw new Exception();
					}*/


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


			} catch(Exception e){
				log.error("["+this.getClass().getName()+"] "+new Date()+
						" Exception: "+e.getMessage());	
			}									

		}//check submit button not null




		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);
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










	public void toMail(
			String mailattachment1,
			GenerateXdocumentForm form,
			List mailAttachmentsList
	) throws Exception
	{


		//system defaults
		String typekey="BEACONDMS";

		//init mail parameters
		String mailhost=form.getMailhost();
		String mailto=form.getMailto();
		String mailfrom=form.getMailfrom();
		String mailcc=form.getMailcc();
		String mailbcc=form.getMailbcc();
		String mailsubject=form.getMailsubject();
		String mailtext=form.getMailtext();

		Systemcode systemcodedao = null;

		//mail process----------------------------------------------->

		try {

			/**
			 * 			try {

				org.w3c.dom.Element elementParamdetails=(org.w3c.dom.Element) elementDocument.getElementsByTagName("ParamDetails").item(0);
				mailto=getTagValue("ToEmail",elementParamdetails);
				mailcc=getTagValue("CCToEmail",elementParamdetails);
				mailbcc=getTagValue("UserEmail",elementParamdetails);
			} catch (Exception e) {	
			}

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
			 **/

			log.debug("["+this.getClass().getName()+"] "+new Date()+
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
				bodyPart.setFileName(form.getHeaderInfo(9)+"_"+form.getHeaderInfo(1)+".pdf");
				multipart.addBodyPart(bodyPart);


				//loop other attachments
				Iterator it = mailAttachmentsList.iterator();
				while (it.hasNext()) {
					LabelValue labelValue = (LabelValue) it.next();
					String mailattachmentValue=labelValue.getValue();
					String mailattachmentLabel=labelValue.getLabel();
					file = new File(mailattachmentValue);
					if (file.exists()) {
						// Part two is the attachment
						bodyPart = new MimeBodyPart();
						sourceFile = new FileDataSource(mailattachmentValue);
						bodyPart.setDataHandler(new DataHandler(sourceFile));
						bodyPart.setFileName(mailattachmentLabel);
						multipart.addBodyPart(bodyPart);
					}
				}//end loop other attachments				


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
