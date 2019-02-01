package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCcyDAO;


public class CcyDAO extends BaseCcyDAO implements com.bureaueye.beacon.model.standard.dao.iface.CcyDAO {

	public CcyDAO () {}
	
	public CcyDAO (Session session) {
		super(session);
	}


}