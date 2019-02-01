package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrdernotecustDAO;


public class OrdernotecustDAO extends BaseOrdernotecustDAO implements com.bureaueye.beacon.model.order.dao.iface.OrdernotecustDAO {

	public OrdernotecustDAO () {}
	
	public OrdernotecustDAO (Session session) {
		super(session);
	}


}