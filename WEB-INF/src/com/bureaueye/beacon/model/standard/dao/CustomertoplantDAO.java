package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoplantDAO;


public class CustomertoplantDAO extends BaseCustomertoplantDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoplantDAO {

	public CustomertoplantDAO () {}
	
	public CustomertoplantDAO (Session session) {
		super(session);
	}


}