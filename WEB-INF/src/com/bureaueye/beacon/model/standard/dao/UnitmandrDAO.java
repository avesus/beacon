package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUnitmandrDAO;


public class UnitmandrDAO extends BaseUnitmandrDAO implements com.bureaueye.beacon.model.standard.dao.iface.UnitmandrDAO {

	public UnitmandrDAO () {}
	
	public UnitmandrDAO (Session session) {
		super(session);
	}


}