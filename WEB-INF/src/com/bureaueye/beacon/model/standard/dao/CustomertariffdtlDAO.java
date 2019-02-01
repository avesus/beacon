package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseCustomertariffdtlDAO;


public class CustomertariffdtlDAO extends BaseCustomertariffdtlDAO implements com.bureaueye.beacon.model.standard.dao.iface.CustomertariffdtlDAO {

	public CustomertariffdtlDAO () {}
	
	public CustomertariffdtlDAO (Session session) {
		super(session);
	}


}