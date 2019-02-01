package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseSubcategoryDAO;


public class SubcategoryDAO extends BaseSubcategoryDAO implements com.bureaueye.beacon.model.standard.dao.iface.SubcategoryDAO {

	public SubcategoryDAO () {}
	
	public SubcategoryDAO (Session session) {
		super(session);
	}


}