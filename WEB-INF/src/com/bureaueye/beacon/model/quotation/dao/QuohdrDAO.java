package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuohdrDAO;


public class QuohdrDAO extends BaseQuohdrDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuohdrDAO {

	public QuohdrDAO () {}
	
	public QuohdrDAO (Session session) {
		super(session);
	}


}