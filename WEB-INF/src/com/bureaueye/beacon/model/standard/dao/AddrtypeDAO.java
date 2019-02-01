package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseAddrtypeDAO;


public class AddrtypeDAO extends BaseAddrtypeDAO implements com.bureaueye.beacon.model.standard.dao.iface.AddrtypeDAO {

	public AddrtypeDAO () {}
	
	public AddrtypeDAO (Session session) {
		super(session);
	}


}