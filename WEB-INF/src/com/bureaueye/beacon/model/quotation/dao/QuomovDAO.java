package com.bureaueye.beacon.model.quotation.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.quotation.base.BaseQuomovDAO;


public class QuomovDAO extends BaseQuomovDAO implements com.bureaueye.beacon.model.quotation.dao.iface.QuomovDAO {

	public QuomovDAO () {}
	
	public QuomovDAO (Session session) {
		super(session);
	}


}