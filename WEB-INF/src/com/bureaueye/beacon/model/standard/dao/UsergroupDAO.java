package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUsergroupDAO;


public class UsergroupDAO extends BaseUsergroupDAO implements com.bureaueye.beacon.model.standard.dao.iface.UsergroupDAO {

	public UsergroupDAO () {}
	
	public UsergroupDAO (Session session) {
		super(session);
	}


}