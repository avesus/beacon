package com.bureaueye.beacondms.action.dms;

import java.io.InputStream;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;




public final class DisplayDocumentAction extends BaseAction {

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {


		String xdocumentId = request.getParameter("xdocumentId");


		Xdocument dao = new XdocumentBD(this.getSessionFactoryClusterMap()).read(new Integer(xdocumentId));


		response.setContentLength( dao.getFilesize() );
		response.setContentType( dao.getContenttype() );
		//response.setHeader("Content-Disposition", "inline");
		String fileName=dao.getDockey()+"_VERSION"+dao.getVersionno();
		response.setHeader("Content-disposition", "attachment; filename=" + fileName );
		response.setHeader("Cache-Control", "max-age=600");

		ServletOutputStream outStream = response.getOutputStream();
		InputStream in = dao.getFilebin().getBinaryStream();
		byte[] buffer = new byte[32768];
		int n = 0;
		while ( ( n = in.read(buffer)) != -1) {
			outStream.write(buffer, 0, n);
		}
		in.close();
		outStream.flush();

		return null;
	}



}
