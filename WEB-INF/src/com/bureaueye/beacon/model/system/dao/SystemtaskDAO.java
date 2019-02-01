package com.bureaueye.beacon.model.system.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.system.base.BaseSystemtaskDAO;


public class SystemtaskDAO extends BaseSystemtaskDAO implements com.bureaueye.beacon.model.system.dao.iface.SystemtaskDAO {

	public SystemtaskDAO () {}
	
	public SystemtaskDAO (Session session) {
		super(session);
	}


}