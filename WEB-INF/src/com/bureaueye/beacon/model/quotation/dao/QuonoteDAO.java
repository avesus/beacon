package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuonoteDAO;


public class QuonoteDAO extends BaseQuonoteDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuonoteDAO {

	public QuonoteDAO () {}
	
	public QuonoteDAO (Session session) {
		super(session);
	}


}