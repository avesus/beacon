package com.bureaueye.beacon.model.mandr.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mandr.base.BaseMandrhdrDAO;


public class MandrhdrDAO extends BaseMandrhdrDAO implements com.bureaueye.beacon.model.mandr.dao.iface.MandrhdrDAO {

	public MandrhdrDAO () {}
	
	public MandrhdrDAO (Session session) {
		super(session);
	}


}