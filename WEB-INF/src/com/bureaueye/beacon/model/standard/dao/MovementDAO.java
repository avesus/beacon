package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseMovementDAO;


public class MovementDAO extends BaseMovementDAO implements com.bureaueye.beacon.model.standard.dao.iface.MovementDAO {

	public MovementDAO () {}
	
	public MovementDAO (Session session) {
		super(session);
	}


}