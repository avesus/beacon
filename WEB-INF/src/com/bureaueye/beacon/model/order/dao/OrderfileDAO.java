package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrderfileDAO;


public class OrderfileDAO extends BaseOrderfileDAO implements com.bureaueye.beacon.model.order.dao.iface.OrderfileDAO {

	public OrderfileDAO () {}
	
	public OrderfileDAO (Session session) {
		super(session);
	}


}