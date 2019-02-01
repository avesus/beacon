package com.bureaueye.beacondms.action.dms;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacondms.form.dms.DocumenttypeForm;

import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacon.model.standard.User;






public final class SaveDocumenttypeAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		DocumenttypeForm saveForm = (DocumenttypeForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);


		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Process: "+action+
				" Id: "+saveForm.getDocumenttypeId()
		);


		// Generate Business Delegate
		DocumenttypeBD bd = new DocumenttypeBD(this.getSessionFactoryClusterMap());


		if (action.equals("Delete")) {
			bd.delete(new Documenttype(new Integer(saveForm.getDocumenttypeId())), user);
		} else {

			Documenttype dao =null;
			try {
				dao = bd.read(new Integer(saveForm.getDocumenttypeId()));
			} catch (Exception e) {
			}

			if (dao == null) {
				dao = new Documenttype();
			}
			BeanUtils.copyProperties(dao, saveForm);




			bd.createOrUpdate(dao, user);

			// Find the form
			ListForm listform = (ListForm) session.getAttribute("List"
					+ mapping.getName());

			// Reset the parameters as if it was the first time in
			listform.setStartPage();

		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to success page");
		return findSuccess(mapping);

	}

}
