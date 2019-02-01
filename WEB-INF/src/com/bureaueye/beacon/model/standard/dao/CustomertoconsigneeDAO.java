package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoconsigneeDAO;


public class CustomertoconsigneeDAO extends BaseCustomertoconsigneeDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertoconsigneeDAO {

	public CustomertoconsigneeDAO () {}
	
	public CustomertoconsigneeDAO (Session session) {
		super(session);
	}


}