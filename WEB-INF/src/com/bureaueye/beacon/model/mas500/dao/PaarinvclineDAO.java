package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BasePaarinvclineDAO;


public class PaarinvclineDAO extends BasePaarinvclineDAO implements com.bureaueye.beacon.model.mas500.dao.iface.PaarinvclineDAO {

	public PaarinvclineDAO () {}
	
	public PaarinvclineDAO (Session session) {
		super(session);
	}


}