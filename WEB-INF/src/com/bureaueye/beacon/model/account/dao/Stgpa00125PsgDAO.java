package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseStgpa00125PsgDAO;


public class Stgpa00125PsgDAO extends BaseStgpa00125PsgDAO implements com.bureaueye.beacon.model.account.dao.iface.Stgpa00125PsgDAO {

	public Stgpa00125PsgDAO () {}
	
	public Stgpa00125PsgDAO (Session session) {
		super(session);
	}


}