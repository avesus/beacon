package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseDocnoDAO;


public class DocnoDAO extends BaseDocnoDAO implements com.bureaueye.beacon.model.standard.dao.iface.DocnoDAO {

	public DocnoDAO () {}
	
	public DocnoDAO (Session session) {
		super(session);
	}


}