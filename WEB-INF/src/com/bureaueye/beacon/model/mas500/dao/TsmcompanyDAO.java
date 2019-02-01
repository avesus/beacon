package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTsmcompanyDAO;


public class TsmcompanyDAO extends BaseTsmcompanyDAO implements com.bureaueye.beacon.model.mas500.dao.iface.TsmcompanyDAO {

	public TsmcompanyDAO () {}
	
	public TsmcompanyDAO (Session session) {
		super(session);
	}


}