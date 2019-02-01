package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemmappingcodeDAO;


public class SystemmappingcodeDAO extends BaseSystemmappingcodeDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemmappingcodeDAO {

	public SystemmappingcodeDAO () {}
	
	public SystemmappingcodeDAO (Session session) {
		super(session);
	}


}