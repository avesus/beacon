package com.bureaueye.beacon.ajax;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Customertobroker;
import com.bureaueye.beacon.model.standard.Customertoconsignee;
import com.bureaueye.beacon.model.standard.Customertoforwardagent;
import com.bureaueye.beacon.model.standard.Customertoshipline;
import com.bureaueye.beacon.model.standard.Customertoshipper;

import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CustomertobrokerBD;
import com.bureaueye.beacon.model.standard.bd.CustomertoconsigneeBD;
import com.bureaueye.beacon.model.standard.bd.CustomertoforwardagentBD;
import com.bureaueye.beacon.model.standard.bd.CustomertoshiplineBD;
import com.bureaueye.beacon.model.standard.bd.CustomertoshipperBD;


import javax.servlet.*;



public final class RefreshCustomerToObjectServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		
		String customeraddrkey = request.getParameter("customeraddrkey");
			
		StringBuffer results = new StringBuffer("");
		
		results.append("<channel>");
		
		List dtos = null;		
		try {
			dtos = new CustomertoconsigneeBD(this.getSessionFactoryClusterMap())
						.findCustomertoconsigneesByCustomer(customeraddrkey,0,99);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Customertoconsignee dto = (Customertoconsignee)it.next();
			Address address = null;
			try {
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getTokey());
			} catch (ApplicationException ae) {}
			if (address != null) {
				results.append("<consignee>");
				results.append("<key>");
				results.append(dto.getTokey());
				results.append("</key>");
				results.append("<name><![CDATA[");
				results.append(address.getName());
				results.append("]]></name>");						
				results.append("</consignee>");													
			}
		}
		
		
		dtos = null;	
		try {
			dtos = new CustomertobrokerBD(this.getSessionFactoryClusterMap())
						.findCustomertobrokersByCustomer(customeraddrkey,0,99);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Customertobroker dto = (Customertobroker)it.next();
			Address address = null;
			try {
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getTokey());
			} catch (ApplicationException ae) {}
			if (address != null) {
				results.append("<broker>");
				results.append("<key>");
				results.append(dto.getTokey());
				results.append("</key>");
				results.append("<name><![CDATA[");
				results.append(address.getName());
				results.append("]]></name>");						
				results.append("</broker>");													
			}
		}
		
		
		dtos = null;	
		try {
			dtos = new CustomertoshipperBD(this.getSessionFactoryClusterMap())
						.findCustomertoshippersByCustomer(customeraddrkey,0,99);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Customertoshipper dto = (Customertoshipper)it.next();
			Address address = null;
			try {
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getTokey());
			} catch (ApplicationException ae) {}
			if (address != null) {
				results.append("<shipper>");
				results.append("<key>");
				results.append(dto.getTokey());
				results.append("</key>");
				results.append("<name><![CDATA[");
				results.append(address.getName());
				results.append("]]></name>");						
				results.append("</shipper>");													
			}
		}
		
		
		dtos = null;	
		try {
			dtos = new CustomertoshiplineBD(this.getSessionFactoryClusterMap())
						.findCustomertoshiplinesByCustomer(customeraddrkey,0,99);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Customertoshipline dto = (Customertoshipline)it.next();
			Address address = null;
			try {
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getTokey());
			} catch (ApplicationException ae) {}
			if (address != null) {
				results.append("<shipline>");
				results.append("<key>");
				results.append(dto.getTokey());
				results.append("</key>");
				results.append("<name><![CDATA[");
				results.append(address.getName());
				results.append("]]></name>");						
				results.append("</shipline>");													
			}
		}
		

		dtos = null;	
		try {
			dtos = new CustomertoforwardagentBD(this.getSessionFactoryClusterMap())
						.findCustomertoforwardagentsByCustomer(customeraddrkey,0,99);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			Customertoforwardagent dto = (Customertoforwardagent)it.next();
			Address address = null;
			try {
				address = new AddressBD(this.getSessionFactoryClusterMap()).read(dto.getTokey());
			} catch (ApplicationException ae) {}
			if (address != null) {
				results.append("<forwardagent>");
				results.append("<key>");
				results.append(dto.getTokey());
				results.append("</key>");
				results.append("<name><![CDATA[");
				results.append(address.getName());
				results.append("]]></name>");						
				results.append("</forwardagent>");													
			}
		}
		
		
		results.append("</channel>");
		
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");		
		response.getWriter().write(results.toString());
		
	}
	

	
	
}
