package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseLeasetypeDAO;


public class LeasetypeDAO extends BaseLeasetypeDAO implements com.bureaueye.beacon.model.standard.dao.iface.LeasetypeDAO {

	public LeasetypeDAO () {}
	
	public LeasetypeDAO (Session session) {
		super(session);
	}


}