package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUseraccessDAO;


public class UseraccessDAO extends BaseUseraccessDAO implements com.bureaueye.beacon.model.standard.dao.iface.UseraccessDAO {

	public UseraccessDAO () {}
	
	public UseraccessDAO (Session session) {
		super(session);
	}


}