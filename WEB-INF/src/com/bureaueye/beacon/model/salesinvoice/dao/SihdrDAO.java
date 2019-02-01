package com.bureaueye.beacon.model.salesinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.salesinvoice.base.BaseSihdrDAO;


public class SihdrDAO extends BaseSihdrDAO implements com.bureaueye.beacon.model.salesinvoice.dao.iface.SihdrDAO {

	public SihdrDAO () {}
	
	public SihdrDAO (Session session) {
		super(session);
	}


}