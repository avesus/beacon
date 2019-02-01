package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemlogconfigDAO;


public class SystemlogconfigDAO extends BaseSystemlogconfigDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemlogconfigDAO {

	public SystemlogconfigDAO () {}
	
	public SystemlogconfigDAO (Session session) {
		super(session);
	}


}