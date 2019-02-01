package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdipartnerDAO;


public class EdipartnerDAO extends BaseEdipartnerDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdipartnerDAO {

	public EdipartnerDAO () {}
	
	public EdipartnerDAO (Session session) {
		super(session);
	}


}