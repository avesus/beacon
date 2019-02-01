package com.bureaueye.genesys.model.offhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.offhire.base.BaseOffhireeqpotcDAO;


public class OffhireeqpotcDAO extends BaseOffhireeqpotcDAO implements com.bureaueye.genesys.model.offhire.dao.iface.OffhireeqpotcDAO {

	public OffhireeqpotcDAO () {}
	
	public OffhireeqpotcDAO (Session session) {
		super(session);
	}


}