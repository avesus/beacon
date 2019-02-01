package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUserDAO;


public class UserDAO extends BaseUserDAO implements com.bureaueye.beacon.model.standard.dao.iface.UserDAO {

	public UserDAO () {}
	
	public UserDAO (Session session) {
		super(session);
	}


}