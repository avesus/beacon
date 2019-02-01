package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUserlistformDAO;


public class UserlistformDAO extends BaseUserlistformDAO implements com.bureaueye.beacon.model.standard.dao.iface.UserlistformDAO {

	public UserlistformDAO () {}
	
	public UserlistformDAO (Session session) {
		super(session);
	}


}