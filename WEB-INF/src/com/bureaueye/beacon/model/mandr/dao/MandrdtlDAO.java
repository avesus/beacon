package com.bureaueye.beacon.model.mandr.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mandr.base.BaseMandrdtlDAO;


public class MandrdtlDAO extends BaseMandrdtlDAO implements com.bureaueye.beacon.model.mandr.dao.iface.MandrdtlDAO {

	public MandrdtlDAO () {}
	
	public MandrdtlDAO (Session session) {
		super(session);
	}


}