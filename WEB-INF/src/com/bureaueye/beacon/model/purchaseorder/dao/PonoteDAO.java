package com.bureaueye.beacon.model.purchaseorder.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseorder.base.BasePonoteDAO;


public class PonoteDAO extends BasePonoteDAO implements com.bureaueye.beacon.model.purchaseorder.dao.iface.PonoteDAO {

	public PonoteDAO () {}
	
	public PonoteDAO (Session session) {
		super(session);
	}


}