package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuoprodDAO;


public class QuoprodDAO extends BaseQuoprodDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuoprodDAO {

	public QuoprodDAO () {}
	
	public QuoprodDAO (Session session) {
		super(session);
	}


}