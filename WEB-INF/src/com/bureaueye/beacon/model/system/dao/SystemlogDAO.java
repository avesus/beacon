package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemlogDAO;


public class SystemlogDAO extends BaseSystemlogDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemlogDAO {

	public SystemlogDAO () {}
	
	public SystemlogDAO (Session session) {
		super(session);
	}


}