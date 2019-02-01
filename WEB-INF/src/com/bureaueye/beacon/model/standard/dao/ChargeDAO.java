package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseChargeDAO;


public class ChargeDAO extends BaseChargeDAO implements com.bureaueye.beacon.model.standard.dao.iface.ChargeDAO {

	public ChargeDAO () {}
	
	public ChargeDAO (Session session) {
		super(session);
	}


}