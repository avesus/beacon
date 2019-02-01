package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrderprodDAO;


public class OrderprodDAO extends BaseOrderprodDAO implements com.bureaueye.beacon.model.order.dao.iface.OrderprodDAO {

	public OrderprodDAO () {}
	
	public OrderprodDAO (Session session) {
		super(session);
	}


}