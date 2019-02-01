package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTpa00002DAO;


public class Tpa00002DAO extends BaseTpa00002DAO implements com.bureaueye.beacon.model.mas500.dao.iface.Tpa00002DAO {

	public Tpa00002DAO () {}
	
	public Tpa00002DAO (Session session) {
		super(session);
	}


}