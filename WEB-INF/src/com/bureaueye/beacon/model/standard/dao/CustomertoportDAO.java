package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoportDAO;


public class CustomertoportDAO extends BaseCustomertoportDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoportDAO {

	public CustomertoportDAO () {}
	
	public CustomertoportDAO (Session session) {
		super(session);
	}


}