package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCountryDAO;


public class CountryDAO extends BaseCountryDAO implements com.bureaueye.beacon.model.standard.dao.iface.CountryDAO {

	public CountryDAO () {}
	
	public CountryDAO (Session session) {
		super(session);
	}


}