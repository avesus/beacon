package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertariffhdrDAO;


public class CustomertariffhdrDAO extends BaseCustomertariffhdrDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertariffhdrDAO {

	public CustomertariffhdrDAO () {}
	
	public CustomertariffhdrDAO (Session session) {
		super(session);
	}


}