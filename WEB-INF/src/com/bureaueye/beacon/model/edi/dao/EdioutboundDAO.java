package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdioutboundDAO;


public class EdioutboundDAO extends BaseEdioutboundDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdioutboundDAO {

	public EdioutboundDAO () {}
	
	public EdioutboundDAO (Session session) {
		super(session);
	}


}