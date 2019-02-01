package com.bureaueye.beacon.action.standard;


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
import com.bureaueye.beacon.form.standard.CategoryForm;

import com.bureaueye.beacon.model.standard.Category;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.CategoryBD;





public final class SaveCategoryAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// If the session has timed-out then return to the login page
		HttpSession session = request.getSession(false);
		CategoryForm saveForm = (CategoryForm) form;
		String action = saveForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);


		// If the cancel button is selected then go back to the list
		if (isCancelled(request)) {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Cancel transaction");
			return findSuccess(mapping);
		}


		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Process: "+action+
				" Id: "+saveForm.getCategoryId()
		);


		// Generate Business Delegate
		CategoryBD bd = new CategoryBD(this.getSessionFactoryClusterMap());


		if (action.equals("Delete")) {
			bd.delete(new Category(new Integer(saveForm.getCategoryId())), user);
		} else {

			Category dao =null;
			try {
				dao = bd.read(new Integer(saveForm.getCategoryId()));
			} catch (Exception e) {
			}

			if (dao == null) {
				dao = new Category();
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
