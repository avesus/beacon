package com.bureaueye.genesys.model.onhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.onhire.base.BaseOnhireeqpotcDAO;


public class OnhireeqpotcDAO extends BaseOnhireeqpotcDAO implements com.bureaueye.genesys.model.onhire.dao.iface.OnhireeqpotcDAO {

	public OnhireeqpotcDAO () {}
	
	public OnhireeqpotcDAO (Session session) {
		super(session);
	}


}