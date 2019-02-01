package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseLocationtypeDAO;


public class LocationtypeDAO extends BaseLocationtypeDAO implements com.bureaueye.beacon.model.standard.dao.iface.LocationtypeDAO {

	public LocationtypeDAO () {}
	
	public LocationtypeDAO (Session session) {
		super(session);
	}


}