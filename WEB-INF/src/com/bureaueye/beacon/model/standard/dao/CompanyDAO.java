package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCompanyDAO;


public class CompanyDAO extends BaseCompanyDAO implements com.bureaueye.beacon.model.standard.dao.iface.CompanyDAO {

	public CompanyDAO () {}
	
	public CompanyDAO (Session session) {
		super(session);
	}


}