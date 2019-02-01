package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseLocationDAO;


public class LocationDAO extends BaseLocationDAO implements com.bureaueye.beacon.model.standard.dao.iface.LocationDAO {

	public LocationDAO () {}
	
	public LocationDAO (Session session) {
		super(session);
	}


}