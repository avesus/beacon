package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdiinboundDAO;


public class EdiinboundDAO extends BaseEdiinboundDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdiinboundDAO {

	public EdiinboundDAO () {}
	
	public EdiinboundDAO (Session session) {
		super(session);
	}


}