package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoshipperDAO;


public class CustomertoshipperDAO extends BaseCustomertoshipperDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoshipperDAO {

	public CustomertoshipperDAO () {}
	
	public CustomertoshipperDAO (Session session) {
		super(session);
	}


}