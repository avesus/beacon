package com.bureaueye.genesys.model.offhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.offhire.base.BaseOffhireeqpDAO;


public class OffhireeqpDAO extends BaseOffhireeqpDAO implements com.bureaueye.genesys.model.offhire.dao.iface.OffhireeqpDAO {

	public OffhireeqpDAO () {}
	
	public OffhireeqpDAO (Session session) {
		super(session);
	}


}