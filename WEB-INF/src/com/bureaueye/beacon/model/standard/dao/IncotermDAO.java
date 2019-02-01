package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseIncotermDAO;


public class IncotermDAO extends BaseIncotermDAO implements com.bureaueye.beacon.model.standard.dao.iface.IncotermDAO {

	public IncotermDAO () {}
	
	public IncotermDAO (Session session) {
		super(session);
	}


}