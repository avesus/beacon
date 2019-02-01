package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrdercostDAO;


public class OrdercostDAO extends BaseOrdercostDAO implements com.bureaueye.beacon.model.order.dao.iface.OrdercostDAO {

	public OrdercostDAO () {}
	
	public OrdercostDAO (Session session) {
		super(session);
	}


}