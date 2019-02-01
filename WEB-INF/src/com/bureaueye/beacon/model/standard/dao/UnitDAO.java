package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUnitDAO;


public class UnitDAO extends BaseUnitDAO implements com.bureaueye.beacon.model.standard.dao.iface.UnitDAO {

	public UnitDAO () {}
	
	public UnitDAO (Session session) {
		super(session);
	}


}