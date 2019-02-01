package com.bureaueye.beacon.model.purchaseorder.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseorder.base.BasePohdrDAO;


public class PohdrDAO extends BasePohdrDAO implements com.bureaueye.beacon.model.purchaseorder.dao.iface.PohdrDAO {

	public PohdrDAO () {}
	
	public PohdrDAO (Session session) {
		super(session);
	}


}