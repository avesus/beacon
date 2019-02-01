package com.bureaueye.beacon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class RequestProcessor extends org.apache.struts.action.RequestProcessor {
	
	protected boolean processPreprocess(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		
		//If user is trying to access login page then don't check
		
		if (
			request.getServletPath().equals("/SubmitLogon.do") || 
			request.getServletPath().equals("/Welcome.do")
			)
			return true;
		
		//Check if userName attribute is there is session. If so, it means user
		// has allready logged in
		if (
			session != null && 
			session.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USER_KEY)	!= null
			)
			return true;
		else {
			try {
				//If no redirect user to login Page
				
				request.getRequestDispatcher("/Welcome.do").forward(
						request, response);
			} catch (Exception ex) {
			}
		}
		return false;
	}
	
}
