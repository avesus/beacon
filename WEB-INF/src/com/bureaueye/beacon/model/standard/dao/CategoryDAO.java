package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCategoryDAO;


public class CategoryDAO extends BaseCategoryDAO implements com.bureaueye.beacon.model.standard.dao.iface.CategoryDAO {

	public CategoryDAO () {}
	
	public CategoryDAO (Session session) {
		super(session);
	}


}