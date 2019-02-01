package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrderhdrDAO;


public class OrderhdrDAO extends BaseOrderhdrDAO implements com.bureaueye.beacon.model.order.dao.iface.OrderhdrDAO {

	public OrderhdrDAO () {}
	
	public OrderhdrDAO (Session session) {
		super(session);
	}


}