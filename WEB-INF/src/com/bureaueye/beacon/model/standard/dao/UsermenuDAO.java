package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUsermenuDAO;


public class UsermenuDAO extends BaseUsermenuDAO implements com.bureaueye.beacon.model.standard.dao.iface.UsermenuDAO {

	public UsermenuDAO () {}
	
	public UsermenuDAO (Session session) {
		super(session);
	}


}