package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuofileDAO;


public class QuofileDAO extends BaseQuofileDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuofileDAO {

	public QuofileDAO () {}
	
	public QuofileDAO (Session session) {
		super(session);
	}


}