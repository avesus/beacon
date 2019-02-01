package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemXDAO;


public class SystemXDAO extends BaseSystemXDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemXDAO {

	public SystemXDAO () {}
	
	public SystemXDAO (Session session) {
		super(session);
	}


}