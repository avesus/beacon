package com.bureaueye.beacon.model.print.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.print.base.BaseCompanyheaderDAO;


public class CompanyheaderDAO extends BaseCompanyheaderDAO implements com.bureaueye.beacon.model.print.dao.iface.CompanyheaderDAO {

	public CompanyheaderDAO () {}
	
	public CompanyheaderDAO (Session session) {
		super(session);
	}


}