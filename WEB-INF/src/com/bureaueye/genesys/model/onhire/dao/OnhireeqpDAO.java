package com.bureaueye.genesys.model.onhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.onhire.base.BaseOnhireeqpDAO;


public class OnhireeqpDAO extends BaseOnhireeqpDAO implements com.bureaueye.genesys.model.onhire.dao.iface.OnhireeqpDAO {

	public OnhireeqpDAO () {}
	
	public OnhireeqpDAO (Session session) {
		super(session);
	}


}