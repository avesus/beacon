package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BasePaaplineDAO;


public class PaaplineDAO extends BasePaaplineDAO implements com.bureaueye.beacon.model.mas500.dao.iface.PaaplineDAO {

	public PaaplineDAO () {}
	
	public PaaplineDAO (Session session) {
		super(session);
	}


}