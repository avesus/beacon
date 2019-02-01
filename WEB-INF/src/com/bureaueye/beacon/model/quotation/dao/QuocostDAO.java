package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuocostDAO;


public class QuocostDAO extends BaseQuocostDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuocostDAO {

	public QuocostDAO () {}
	
	public QuocostDAO (Session session) {
		super(session);
	}


}