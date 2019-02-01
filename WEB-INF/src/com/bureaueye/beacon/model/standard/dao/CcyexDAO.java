package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCcyexDAO;


public class CcyexDAO extends BaseCcyexDAO implements com.bureaueye.beacon.model.standard.dao.iface.CcyexDAO {

	public CcyexDAO () {}
	
	public CcyexDAO (Session session) {
		super(session);
	}


}