package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseTransportmodeDAO;


public class TransportmodeDAO extends BaseTransportmodeDAO implements com.bureaueye.beacon.model.standard.dao.iface.TransportmodeDAO {

	public TransportmodeDAO () {}
	
	public TransportmodeDAO (Session session) {
		super(session);
	}


}