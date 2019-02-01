package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseProductDAO;


public class ProductDAO extends BaseProductDAO implements com.bureaueye.beacon.model.standard.dao.iface.ProductDAO {

	public ProductDAO () {}
	
	public ProductDAO (Session session) {
		super(session);
	}


}