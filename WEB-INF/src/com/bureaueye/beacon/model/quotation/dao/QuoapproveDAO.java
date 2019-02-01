package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuoapproveDAO;


public class QuoapproveDAO extends BaseQuoapproveDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuoapproveDAO {

	public QuoapproveDAO () {}
	
	public QuoapproveDAO (Session session) {
		super(session);
	}


}