package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCostDAO;


public class CostDAO extends BaseCostDAO implements com.bureaueye.beacon.model.standard.dao.iface.CostDAO {

	public CostDAO () {}
	
	public CostDAO (Session session) {
		super(session);
	}


}