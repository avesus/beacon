package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseStgpa00175PsgDAO;


public class Stgpa00175PsgDAO extends BaseStgpa00175PsgDAO implements com.bureaueye.beacon.model.account.dao.iface.Stgpa00175PsgDAO {

	public Stgpa00175PsgDAO () {}
	
	public Stgpa00175PsgDAO (Session session) {
		super(session);
	}


}