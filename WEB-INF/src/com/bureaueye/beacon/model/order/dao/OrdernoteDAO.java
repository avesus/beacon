package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrdernoteDAO;


public class OrdernoteDAO extends BaseOrdernoteDAO implements com.bureaueye.beacon.model.order.dao.iface.OrdernoteDAO {

	public OrdernoteDAO () {}
	
	public OrdernoteDAO (Session session) {
		super(session);
	}


}