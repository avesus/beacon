package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUsergroupmenuDAO;


public class UsergroupmenuDAO extends BaseUsergroupmenuDAO implements com.bureaueye.beacon.model.standard.dao.iface.UsergroupmenuDAO {

	public UsergroupmenuDAO () {}
	
	public UsergroupmenuDAO (Session session) {
		super(session);
	}


}