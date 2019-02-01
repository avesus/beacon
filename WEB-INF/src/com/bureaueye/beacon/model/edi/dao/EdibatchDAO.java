package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdibatchDAO;


public class EdibatchDAO extends BaseEdibatchDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdibatchDAO {

	public EdibatchDAO () {}
	
	public EdibatchDAO (Session session) {
		super(session);
	}


}