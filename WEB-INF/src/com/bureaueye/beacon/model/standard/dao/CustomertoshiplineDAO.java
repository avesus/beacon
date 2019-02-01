package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoshiplineDAO;


public class CustomertoshiplineDAO extends BaseCustomertoshiplineDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoshiplineDAO {

	public CustomertoshiplineDAO () {}
	
	public CustomertoshiplineDAO (Session session) {
		super(session);
	}


}