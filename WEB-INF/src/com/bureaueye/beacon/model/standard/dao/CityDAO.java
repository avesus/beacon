package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCityDAO;


public class CityDAO extends BaseCityDAO implements com.bureaueye.beacon.model.standard.dao.iface.CityDAO {

	public CityDAO () {}
	
	public CityDAO (Session session) {
		super(session);
	}


}