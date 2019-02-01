package com.bureaueye.beacondms.action.dms;





import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Hibernate;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacondms.form.dms.TrackForm;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.Xdocumentversion;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;
import com.bureaueye.beacondms.model.dms.bd.XdocumentversionBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;




public final class SaveTrackAction extends BaseAction {



	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		TrackForm saveForm = (TrackForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();
		ActionMessages appInformationMessages = new ActionMessages();
		ActionMessages appErrorMessages = new ActionMessages();


		try {
			if (request.getParameter("checkoutButton") != null) action=Constants.CHECK_OUT;
			if (request.getParameter("undocheckoutButton") != null) action=Constants.UNDO_CHECK_OUT;
			if (request.getParameter("checkinButton") != null) action=Constants.CHECK_IN;
		} catch (Exception e) {
		}



		// validation


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



		// Generate Business Delegate
		XdocumentBD bd = new XdocumentBD(this.getSessionFactoryClusterMap());
		XdocumentversionBD xdocumentversionbd = new XdocumentversionBD(this.getSessionFactoryClusterMap());


		Integer pk = null;	
		try {
			pk = new Integer(saveForm.getXdocumentId());			
		} catch (Exception e) {}
		Xdocument dao = bd.read(pk);







		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			this.saveMessages(request, messages);
			return (mapping.getInputForward());
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}





		//check out process
		if (action.equals(Constants.CHECK_OUT)) {


			try {

				SystemcodeBD systemcodebd = new SystemcodeBD(this.getSessionFactoryClusterMap());
				Systemcode systemcodedao = null; 
				String checkoutDirectory = "";
				try {
					systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
							"BEACONDMS", 
							"CHECKOUTDIRECTORY"
					);
					checkoutDirectory = systemcodedao.getDescr();
				} catch (ApplicationException e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: ApplicationException: "+e.getMessage());				
				} catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" findSystemcodesByTypekeyCodekey: Exception: "+e.getMessage());							
				}


				// generate display document
				String outputFilename = "";															
				outputFilename  = checkoutDirectory+"\\"+user.getUserid()+"$"+dao.getFilename();
				FileOutputStream fileOutputStream = new FileOutputStream(outputFilename );
				InputStream in = dao.getFilebin().getBinaryStream();
				byte[] buffer = new byte[32768];
				int n = 0;
				while ( ( n = in.read(buffer)) != -1) {
					fileOutputStream.write(buffer, 0, n);
				}
				in.close();
				fileOutputStream.flush();
				fileOutputStream.close();


				// update check out details
				Calendar c = Calendar.getInstance();
				dao.setCheckoutflag(true);
				dao.setCheckoutdate(c.getTime());
				dao.setCheckouttime(com.bureaueye.beacon.util.Util.toTime(c));
				dao.setCheckoutuserid(user.getUserid());	

				bd.createOrUpdate(dao, user);

				saveForm.setCheckoutflag("true");
				saveForm.setCheckoutdate(c.getTime());
				saveForm.setCheckouttime(com.bureaueye.beacon.util.Util.toTime(c));
				
				// generate information message
				// Add information message 
				appInformationMessages.add(
						"messages.document",
						new ActionMessage(
								"information.document.checkedout",
								saveForm.getDescription(),
								outputFilename,
								user.getUserid()
						)
				);
				saveAppInformationMessages(request, appInformationMessages);
				

			} catch (Exception e) {
				// Add Error message 
				appErrorMessages.add(
						"messages.document",
						new ActionMessage(
								"error.document.checkout"
						)
				);
				saveAppErrorMessages(request, appErrorMessages);				
			}

			// return to screen
			return (mapping.getInputForward());

		}


		//check in process
		if (action.equals(Constants.CHECK_IN)) {

			try {

				if (saveForm.getInfile().getFileName().equals("")) {
					// Add Error message 
					appErrorMessages.add(
							"messages.document",
							new ActionMessage(
									"error.document.required"
							)
					);
					saveAppErrorMessages(request, appErrorMessages);

					// return to screen
					return (mapping.getInputForward());
				}
				if (saveForm.getVersiondescription().equals("")) {
					// Add Error message 
					appErrorMessages.add(
							"messages.document",
							new ActionMessage(
									"error.versiondescription.required"
							)
					);
					saveAppErrorMessages(request, appErrorMessages);

					// return to screen
					return (mapping.getInputForward());
				}
				


				//upload file information
				dao.setFilebin( Hibernate.createBlob (saveForm.getInfile().getInputStream()) );
				//store file information
				dao.setSourcefilename(saveForm.getInfile().getFileName());
				dao.setFilename(saveForm.getInfile().getFileName());
				dao.setFilesize(saveForm.getInfile().getFileSize());
				dao.setContenttype(saveForm.getInfile().getContentType());						


				// generate new version				 
				Xdocumentversion version = xdocumentversionbd.createXdocumentversion(dao, user, "create",saveForm.getVersiondescription());
				//init version information
				dao.setVersionno(version.getVersionno());
				dao.setVersiondescription(version.getVersiondescription());
				dao.setVersiondate(version.getVersiondate());
				dao.setVersiontime(version.getVersiontime());
				dao.setVersionuserid(version.getVersionuserid());


				// update check out details
				dao.setCheckoutflag(false);
				saveForm.setCheckoutdate(null);
				saveForm.setCheckouttime("");
				
				
				bd.createOrUpdate(dao, user);

				
				// refresh document versions
				saveForm.setXdocumentversions(
						xdocumentversionbd.findXdocumentversionsByDockey(saveForm.getDockey())
						);
				
				saveForm.setCheckoutflag("false");

				// Add information message 
				appInformationMessages.add(
						"messages.document",
						new ActionMessage(
								"information.document.checkedin",
								saveForm.getDescription()
						)
				);
				saveAppInformationMessages(request, appInformationMessages);
				
			} catch (Exception e) {
				// Add Error message 
				appErrorMessages.add(
						"messages.document",
						new ActionMessage(
								"error.document.checkin"
						)
				);
				saveAppErrorMessages(request, appErrorMessages);				
			}

			// return to screen
			return (mapping.getInputForward());

		}


		//undo check out process
		if (action.equals(Constants.UNDO_CHECK_OUT)) {

			try {

				// generate information message
				// Add information message 
				appInformationMessages.add(
						"messages.document",
						new ActionMessage(
								"information.document.checkoutundone",
								saveForm.getDescription()
						)
				);
				saveAppInformationMessages(request, appInformationMessages);

				// update check out details
				dao.setCheckoutflag(false);
				dao.setCheckoutdate(null);
				dao.setCheckouttime("");
				dao.setCheckoutuserid(user.getUserid());	

				bd.createOrUpdate(dao, user);

				saveForm.setCheckoutflag("false");
				saveForm.setCheckoutdate(null);
				saveForm.setCheckouttime("");

			} catch (Exception e) {
				// Add Error message 
				appErrorMessages.add(
						"messages.document",
						new ActionMessage(
								"error.document.undocheckout"
						)
				);
				saveAppErrorMessages(request, appErrorMessages);				
			}


			// return to screen
			return (mapping.getInputForward());

		}



		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}
}
