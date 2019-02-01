package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdirouterDAO;


public class EdirouterDAO extends BaseEdirouterDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdirouterDAO {

	public EdirouterDAO () {}
	
	public EdirouterDAO (Session session) {
		super(session);
	}


}