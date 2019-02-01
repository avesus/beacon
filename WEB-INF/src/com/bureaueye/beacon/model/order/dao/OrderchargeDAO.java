package com.bureaueye.beacon.model.order.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.order.base.BaseOrderchargeDAO;


public class OrderchargeDAO extends BaseOrderchargeDAO implements com.bureaueye.beacon.model.order.dao.iface.OrderchargeDAO {

	public OrderchargeDAO () {}
	
	public OrderchargeDAO (Session session) {
		super(session);
	}


}