package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTpa00125DAO;


public class Tpa00125DAO extends BaseTpa00125DAO implements com.bureaueye.beacon.model.mas500.dao.iface.Tpa00125DAO {

	public Tpa00125DAO () {}
	
	public Tpa00125DAO (Session session) {
		super(session);
	}


}