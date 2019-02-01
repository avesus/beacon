package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertobrokerDAO;


public class CustomertobrokerDAO extends BaseCustomertobrokerDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertobrokerDAO {

	public CustomertobrokerDAO () {}
	
	public CustomertobrokerDAO (Session session) {
		super(session);
	}


}