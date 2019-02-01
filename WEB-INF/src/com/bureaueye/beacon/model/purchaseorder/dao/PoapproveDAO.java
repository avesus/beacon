package com.bureaueye.beacon.model.purchaseorder.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseorder.base.BasePoapproveDAO;


public class PoapproveDAO extends BasePoapproveDAO implements com.bureaueye.beacon.model.purchaseorder.dao.iface.PoapproveDAO {

	public PoapproveDAO () {}
	
	public PoapproveDAO (Session session) {
		super(session);
	}


}