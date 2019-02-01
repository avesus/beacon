package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseLocationcodeDAO;


public class LocationcodeDAO extends BaseLocationcodeDAO implements com.bureaueye.beacon.model.standard.dao.iface.LocationcodeDAO {

	public LocationcodeDAO () {}
	
	public LocationcodeDAO (Session session) {
		super(session);
	}


}