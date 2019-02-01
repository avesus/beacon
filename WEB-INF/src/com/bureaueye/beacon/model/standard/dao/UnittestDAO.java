package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUnittestDAO;


public class UnittestDAO extends BaseUnittestDAO implements com.bureaueye.beacon.model.standard.dao.iface.UnittestDAO {

	public UnittestDAO () {}
	
	public UnittestDAO (Session session) {
		super(session);
	}


}