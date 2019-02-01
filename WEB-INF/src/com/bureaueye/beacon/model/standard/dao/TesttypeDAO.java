package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseTesttypeDAO;


public class TesttypeDAO extends BaseTesttypeDAO implements com.bureaueye.beacon.model.standard.dao.iface.TesttypeDAO {

	public TesttypeDAO () {}
	
	public TesttypeDAO (Session session) {
		super(session);
	}


}