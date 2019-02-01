package com.bureaueye.genesys.model.offhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.offhire.base.BaseOffhireDAO;


public class OffhireDAO extends BaseOffhireDAO implements com.bureaueye.genesys.model.offhire.dao.iface.OffhireDAO {

	public OffhireDAO () {}
	
	public OffhireDAO (Session session) {
		super(session);
	}


}