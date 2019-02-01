package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseImdgDAO;


public class ImdgDAO extends BaseImdgDAO implements com.bureaueye.beacon.model.standard.dao.iface.ImdgDAO {

	public ImdgDAO () {}
	
	public ImdgDAO (Session session) {
		super(session);
	}


}