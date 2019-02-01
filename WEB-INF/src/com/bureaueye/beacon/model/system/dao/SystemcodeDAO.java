package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemcodeDAO;


public class SystemcodeDAO extends BaseSystemcodeDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemcodeDAO {

	public SystemcodeDAO () {}
	
	public SystemcodeDAO (Session session) {
		super(session);
	}


}