package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuonotecustDAO;


public class QuonotecustDAO extends BaseQuonotecustDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuonotecustDAO {

	public QuonotecustDAO () {}
	
	public QuonotecustDAO (Session session) {
		super(session);
	}


}