package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoproductDAO;


public class CustomertoproductDAO extends BaseCustomertoproductDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoproductDAO {

	public CustomertoproductDAO () {}
	
	public CustomertoproductDAO (Session session) {
		super(session);
	}


}