package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseAioutDAO;


public class AioutDAO extends BaseAioutDAO implements com.bureaueye.beacon.model.account.dao.iface.AioutDAO {

	public AioutDAO () {}
	
	public AioutDAO (Session session) {
		super(session);
	}


}