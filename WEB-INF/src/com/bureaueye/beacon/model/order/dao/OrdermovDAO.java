package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrdermovDAO;


public class OrdermovDAO extends BaseOrdermovDAO implements com.bureaueye.beacon.model.order.dao.iface.OrdermovDAO {

	public OrdermovDAO () {}
	
	public OrdermovDAO (Session session) {
		super(session);
	}


}