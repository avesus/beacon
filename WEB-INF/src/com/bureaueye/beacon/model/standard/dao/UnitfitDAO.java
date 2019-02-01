package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUnitfitDAO;


public class UnitfitDAO extends BaseUnitfitDAO implements com.bureaueye.beacon.model.standard.dao.iface.UnitfitDAO {

	public UnitfitDAO () {}
	
	public UnitfitDAO (Session session) {
		super(session);
	}


}