package com.bureaueye.beacon.action.salesinvoice;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;



/**
 * 
 * Amendments
 * ----------
 * 
 * NT	2013-12-11		WSI-201311-0002		BEACON LAKER (WSI LINER) - Sales Invoice Template  
 * 
 */
public final class PrintSalesinvoiceAction extends BaseAction {


	SystemcodeBD systemcodebd;
	XdocumentBD xdocumentbd;


	public PrintSalesinvoiceAction() {
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
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form ");



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Action: "+listForm.getAction());





		try {


			//init BD
			systemcodebd = new SystemcodeBD(this.getSessionFactoryClusterMap());		
			xdocumentbd = new XdocumentBD(this.getSessionFactoryClusterMap());


			Systemcode systemcodedao = null;
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


			//GENERATE DOCUMENT														
			//check document key already generated
			String key = listForm.getId()+"|SALES_INVOICE";	

			//find document if already generated
			Xdocument xdocumentdao = null;
			try {
				xdocumentdao = xdocumentbd.findXdocumentByDockey(key);
			} catch (Exception e) {								
			}
			//if not found generate new document
			if (xdocumentdao==null) xdocumentdao = new Xdocument();


			user.setUserid(user.getUserid());

			//store file information
			xdocumentdao.setSourcefilename("");
			xdocumentdao.setFilename("");
			xdocumentdao.setFilesize(0);
			xdocumentdao.setContenttype("");

			xdocumentdao.setDoctype("SALES_INVOICE");
			xdocumentdao.setCreateaction(Constants.GENERATE);

			//init id
			xdocumentdao.setDocid(listForm.getId());
			xdocumentdao.setDockey(key);

			xdocumentdao.setErrors("");
			xdocumentdao.setWarnings("");
			xdocumentdao.setCompanykey(user.getCompanykey());
			xdocumentdao.setDepartmentkey(user.getDepartmentkeylist());
			xdocumentdao.setActivitykey(user.getActvid());

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
			xdocumentdao.setXmldocument("");	

			xdocumentbd.createOrUpdate(xdocumentdao, user);	

			//print Sales invoice===========================================>
			// build class and worker method
			Method printWorker = null;
			Class<?> printClass = null;
			try {
				printClass = Class.forName(user.getSalesinvoiceprintclass());
				Class[] argTypes = { 
						Integer.class,
						String.class, 
						com.bureaueye.beacon.model.standard.User.class,
						java.util.Map.class
				};    		

				String methodName = "executePrint";
				// initialise work method depending on process
				printWorker = printClass.getMethod(
						methodName,
						argTypes
				);	

				// initialise actual data to send
				Object[] theData = { 
						new Integer(listForm.getId()), 
						listForm.getAction(),
						user,
						this.getSessionFactoryClusterMap()
				};
				// invoke worker method
				printWorker.invoke(printClass.newInstance(), theData);
			} catch (Exception x) {	
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Print Sales Invoice Exception: " + x.getMessage());
			}
			//print Sales invoice===========================================<


			//generate print file
			String printFilename = "";															
			printFilename = workDirectory+"\\SALES_INVOICE"+new Integer(listForm.getId())+".pdf";								
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
				xdocumentdao.setLanguageid("en");
				xdocumentdao.setTestindicator("");

				//store desctiption and category
				xdocumentdao.setDescription("SALES INVOICE");
				xdocumentdao.setCategorycode("FINANCE");
				xdocumentdao.setSubcategorycode("SALES_INVOICE");

				//set receive details
				xdocumentdao.setReceivedate(xdocumentdao.getCreatedate());
				xdocumentdao.setReceivetime(xdocumentdao.getCreatetime());

				xdocumentdao.setXmlheader("");



				xdocumentbd.createOrUpdate(xdocumentdao, user);

				
				try {

					response.setContentLength( xdocumentdao.getFilesize() );
					response.setContentType( xdocumentdao.getContenttype() );

					ServletOutputStream outStream = response.getOutputStream();
					InputStream in = xdocumentdao.getFilebin().getBinaryStream();
					byte[] buffer = new byte[32768];
					int n = 0;
					while ( ( n = in.read(buffer)) != -1) {
						outStream.write(buffer, 0, n);
					}
					in.close();
					outStream.flush();

				} catch(Exception ae){
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" PRINT: Exception: "+ae.getMessage()
					);
					throw new Exception();									
				}
				
				
			} catch(Exception ae){
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" Store: Exception: "+ae.getMessage()
				);
				throw new Exception();									
			}



			//clear BD
			systemcodebd = null;		
			xdocumentbd = null;


			return null;
		}
		catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" Exception: "+e.getMessage());			
		}
		finally {
		}


		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ mapping.findForward("success").getPath());

		return findSuccess(mapping);
	}


}