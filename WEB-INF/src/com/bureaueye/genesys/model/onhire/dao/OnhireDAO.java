package com.bureaueye.genesys.model.onhire.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.onhire.base.BaseOnhireDAO;


public class OnhireDAO extends BaseOnhireDAO implements com.bureaueye.genesys.model.onhire.dao.iface.OnhireDAO {

	public OnhireDAO () {}
	
	public OnhireDAO (Session session) {
		super(session);
	}


}