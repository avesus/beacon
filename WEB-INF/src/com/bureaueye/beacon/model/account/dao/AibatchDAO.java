package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseAibatchDAO;


public class AibatchDAO extends BaseAibatchDAO implements com.bureaueye.beacon.model.account.dao.iface.AibatchDAO {

	public AibatchDAO () {}
	
	public AibatchDAO (Session session) {
		super(session);
	}


}