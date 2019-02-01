package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTpa00005DAO;


public class Tpa00005DAO extends BaseTpa00005DAO implements com.bureaueye.beacon.model.mas500.dao.iface.Tpa00005DAO {

	public Tpa00005DAO () {}
	
	public Tpa00005DAO (Session session) {
		super(session);
	}


}