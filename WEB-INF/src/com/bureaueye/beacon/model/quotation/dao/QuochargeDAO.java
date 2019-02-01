package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuochargeDAO;


public class QuochargeDAO extends BaseQuochargeDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuochargeDAO {

	public QuochargeDAO () {}
	
	public QuochargeDAO (Session session) {
		super(session);
	}


}