package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoforwardagentDAO;


public class CustomertoforwardagentDAO extends BaseCustomertoforwardagentDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoforwardagentDAO {

	public CustomertoforwardagentDAO () {}
	
	public CustomertoforwardagentDAO (Session session) {
		super(session);
	}


}