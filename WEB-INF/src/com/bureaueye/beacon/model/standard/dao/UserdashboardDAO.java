package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseUserdashboardDAO;


public class UserdashboardDAO extends BaseUserdashboardDAO implements com.bureaueye.beacon.model.standard.dao.iface.UserdashboardDAO {

	public UserdashboardDAO () {}
	
	public UserdashboardDAO (Session session) {
		super(session);
	}


}