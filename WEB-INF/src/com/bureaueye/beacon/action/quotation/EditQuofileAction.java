package com.bureaueye.beacon.action.quotation;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.quotation.QuofileForm;

import com.bureaueye.beacon.model.quotation.Quofile;
import com.bureaueye.beacon.model.quotation.bd.QuofileBD;


public final class EditQuofileAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		QuofileForm editForm = (QuofileForm) form;

		// Extract attributes we will need
		String action = editForm.getAction();

		// If action isn't supplied then invalidate the session
		if (editForm.getAction() == null) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" Form not supplied for EditAction");
			request.getSession().removeAttribute(Constants.USER_KEY);
		}

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Processing " + action	+ " action");

		if (!(action == null || action.equals("Create"))) {

			Quofile dto = new QuofileBD(this.getSessionFactoryClusterMap())
					.read(new Integer(editForm.getQuofileId()));

			if (dto == null) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" No Quofile found for quohdrId: "
						+ editForm.getQuohdrId() + ", "
						+ "quofileid: " + editForm.getQuofileId());
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.record.deleted", editForm.getQuohdrId()
								+ " - " + editForm.getQuofileId()));
				saveMessages(request, errors);
				return findFailure(mapping);
			}

			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Populating Form from " + dto);

			// init FORM with DTO values
			BeanUtils.copyProperties(editForm, dto);
			

			if (action.equals("View")) {
		        response.setContentLength( dto.getFilesize() );
		        response.setContentType( dto.getContenttype() );
		        response.setHeader("Content-disposition", "attachment; filename=" + dto.getFilename());
		        response.setHeader("Cache-Control", "max-age=600");

		        ServletOutputStream outStream = response.getOutputStream();
		        InputStream in = dto.getFilebin().getBinaryStream();
		        byte[] buffer = new byte[32768];
		        int n = 0;
		        while ( ( n = in.read(buffer)) != -1) {
		            outStream.write(buffer, 0, n);
		        }
		        in.close();
		        outStream.flush();

		        return (null);
			}
			

		}

		// Forward control to the edit page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}

}
