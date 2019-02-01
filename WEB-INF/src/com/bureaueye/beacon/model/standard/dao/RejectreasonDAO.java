package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseRejectreasonDAO;


public class RejectreasonDAO extends BaseRejectreasonDAO implements com.bureaueye.beacon.model.standard.dao.iface.RejectreasonDAO {

	public RejectreasonDAO () {}
	
	public RejectreasonDAO (Session session) {
		super(session);
	}


}