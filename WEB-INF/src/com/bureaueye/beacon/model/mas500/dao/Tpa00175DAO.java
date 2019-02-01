package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTpa00175DAO;


public class Tpa00175DAO extends BaseTpa00175DAO implements com.bureaueye.beacon.model.mas500.dao.iface.Tpa00175DAO {

	public Tpa00175DAO () {}
	
	public Tpa00175DAO (Session session) {
		super(session);
	}


}