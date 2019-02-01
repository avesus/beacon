package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseSectionDAO;


public class SectionDAO extends BaseSectionDAO implements com.bureaueye.beacon.model.standard.dao.iface.SectionDAO {

	public SectionDAO () {}
	
	public SectionDAO (Session session) {
		super(session);
	}


}