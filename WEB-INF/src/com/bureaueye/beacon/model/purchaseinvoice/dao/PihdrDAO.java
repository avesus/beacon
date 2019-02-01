package com.bureaueye.beacon.model.purchaseinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseinvoice.base.BasePihdrDAO;


public class PihdrDAO extends BasePihdrDAO implements com.bureaueye.beacon.model.purchaseinvoice.dao.iface.PihdrDAO {

	public PihdrDAO () {}
	
	public PihdrDAO (Session session) {
		super(session);
	}


}